package com.baidu.searchbox.ng.ai.apps.network.update;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsBaseNode;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.SettingDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsUpdateManager {
    private static final long CACHE_DATA_VALID_TIME_MILLISECONDS = 18000000;
    public static final int CODE_SUCCESS = 0;
    private static final boolean DEBUG = false;
    private static final String REQUEST_PARAM_DATA = "data";
    private static final String REQUEST_PARAM_MA_ID = "ma_id";
    private static final String REQUEST_PARAM_VERSION = "version";
    private static final String REQUEST_PARAM_VERSION_DEFAULT = "";
    private static final String TAG = "AiAppsUpdateManager";
    private static final String UPDATE_NODES_VERSION_JSON_DEFAULT = "";
    private static volatile AiAppsUpdateManager sInstance;
    private long mLastRequestTimeMilliseconds;
    private List<AiAppsBaseNode> mNodes;
    private AtomicInteger mRequestCount;
    private CopyOnWriteArrayList<IOnUpdateFinish> mTempFinishCallbacks;

    public static AiAppsUpdateManager getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsUpdateManager.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsUpdateManager();
                }
            }
        }
        return sInstance;
    }

    private AiAppsUpdateManager() {
        init();
    }

    private void init() {
        initNodes();
        this.mLastRequestTimeMilliseconds = 0L;
        this.mRequestCount = new AtomicInteger(0);
        this.mTempFinishCallbacks = new CopyOnWriteArrayList<>();
    }

    private void initNodes() {
        this.mNodes = new ArrayList();
        this.mNodes.add(new AiAppsAccreditNode());
    }

    public void tryUpdate() {
        tryUpdate(null);
    }

    public void tryUpdate(@Nullable IOnUpdateFinish iOnUpdateFinish) {
        if (isCacheDataInvalid()) {
            update(iOnUpdateFinish);
        } else if (iOnUpdateFinish != null) {
            iOnUpdateFinish.onUpdateFinish();
        }
    }

    public void update() {
        update(null);
    }

    public void update(@Nullable IOnUpdateFinish iOnUpdateFinish) {
        if (iOnUpdateFinish != null) {
            this.mTempFinishCallbacks.add(iOnUpdateFinish);
        }
        doUpdate(this.mNodes);
    }

    public void resetNodeVersion(AiAppsBaseNode aiAppsBaseNode) {
        if (aiAppsBaseNode != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aiAppsBaseNode);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(aiAppsBaseNode.getNodeName(), "");
            updateNodeVersions(arrayList, arrayMap);
        }
    }

    public void release() {
        if (sInstance != null) {
            this.mTempFinishCallbacks.clear();
            sInstance = null;
        }
    }

    private void doUpdate(@NonNull List<AiAppsBaseNode> list) {
        if (list.size() == 0) {
            onUpdateFinish();
        } else if (this.mRequestCount.incrementAndGet() <= 1) {
            ArrayMap<String, String> nodesVersion = getNodesVersion(this.mNodes);
            JSONObject buildRequestParams = buildRequestParams(list, nodesVersion);
            if (buildRequestParams == null) {
                onUpdateFinish();
                return;
            }
            OAuthUtils.getHttpClient().newCall(new Request.Builder().url(AiAppsRuntime.getAiAppAccountRuntime().processUrl(AiAppsRuntime.getConfigRuntime().getAiAppsUpdateUrl())).post(new FormBody.Builder().add("data", buildRequestParams.toString()).build()).build()).enqueue(buildResponseCallback(list, nodesVersion));
        }
    }

    @Nullable
    private JSONObject buildRequestParams(@NonNull List<AiAppsBaseNode> list, @NonNull ArrayMap<String, String> arrayMap) {
        if (list.size() == 0) {
            return null;
        }
        String aiAppId = AiApp.getAiAppId();
        if (TextUtils.isEmpty(aiAppId)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(REQUEST_PARAM_MA_ID, aiAppId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (AiAppsBaseNode aiAppsBaseNode : list) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String str = "";
                if (arrayMap.containsKey(aiAppsBaseNode.getNodeName())) {
                    str = arrayMap.get(aiAppsBaseNode.getNodeName());
                }
                jSONObject2.put("version", str);
                jSONObject.put(aiAppsBaseNode.getNodeName(), jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @NonNull
    private Callback buildResponseCallback(@NonNull final List<AiAppsBaseNode> list, @NonNull final ArrayMap<String, String> arrayMap) {
        return new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.AiAppsUpdateManager.1
            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                AiAppsUpdateManager.this.doRequestFail(list);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                if (!response.isSuccessful()) {
                    AiAppsUpdateManager.this.doRequestFail(list);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    AiAppsUpdateManager.this.doRequestFail(list);
                    return;
                }
                String str = null;
                try {
                    str = body.string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str)) {
                    AiAppsUpdateManager.this.doRequestFail(list);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") != 0) {
                        AiAppsUpdateManager.this.doRequestFail(list);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        AiAppsUpdateManager.this.doRequestFail(list);
                    } else {
                        AiAppsUpdateManager.this.doRequestSuccess(optJSONObject, list, arrayMap);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    AiAppsUpdateManager.this.doRequestFail(list);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestSuccess(@NonNull JSONObject jSONObject, @NonNull List<AiAppsBaseNode> list, @NonNull ArrayMap<String, String> arrayMap) {
        boolean z;
        this.mLastRequestTimeMilliseconds = SystemClock.elapsedRealtime();
        boolean z2 = false;
        for (AiAppsBaseNode aiAppsBaseNode : list) {
            JSONObject optJSONObject = jSONObject.optJSONObject(aiAppsBaseNode.getNodeName());
            if (optJSONObject == null) {
                aiAppsBaseNode.onFail();
            } else if (optJSONObject.optInt("errno") != 0) {
                aiAppsBaseNode.onFail();
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    aiAppsBaseNode.onFiltered();
                } else {
                    aiAppsBaseNode.onUpdate(optJSONObject2);
                    String optString = optJSONObject.optString("version", "");
                    if (TextUtils.isEmpty(optString)) {
                        z = z2;
                    } else {
                        arrayMap.put(aiAppsBaseNode.getNodeName(), optString);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            updateNodeVersions(list, arrayMap);
        }
        onRequestFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestFail(@NonNull List<AiAppsBaseNode> list) {
        notifyNodesFail(list);
        onRequestFinish();
    }

    private void onRequestFinish() {
        if (this.mRequestCount.decrementAndGet() > 0) {
            this.mRequestCount.set(0);
            update();
            return;
        }
        onUpdateFinish();
    }

    private void onUpdateFinish() {
        this.mRequestCount.set(0);
        Iterator<IOnUpdateFinish> it = this.mTempFinishCallbacks.iterator();
        while (it.hasNext()) {
            final IOnUpdateFinish next = it.next();
            OAuthUtils.postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.AiAppsUpdateManager.2
                @Override // java.lang.Runnable
                public void run() {
                    next.onUpdateFinish();
                }
            });
        }
        this.mTempFinishCallbacks.clear();
    }

    private void notifyNodesFail(@NonNull List<AiAppsBaseNode> list) {
        for (AiAppsBaseNode aiAppsBaseNode : list) {
            aiAppsBaseNode.onFail();
        }
    }

    @NonNull
    private ArrayMap<String, String> getNodesVersion(@NonNull List<AiAppsBaseNode> list) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        if (list.size() == 0) {
            return arrayMap;
        }
        for (AiAppsBaseNode aiAppsBaseNode : list) {
            arrayMap.put(aiAppsBaseNode.getNodeName(), "");
        }
        AiApp aiApp = AiApp.get();
        if (aiApp == null) {
            return arrayMap;
        }
        String string = aiApp.getSetting().getString(SettingDef.UPDATE_NODES_VERSION, "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (AiAppsBaseNode aiAppsBaseNode2 : list) {
                arrayMap.put(aiAppsBaseNode2.getNodeName(), jSONObject.optString(aiAppsBaseNode2.getNodeName(), ""));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateNodeVersions(@NonNull List<AiAppsBaseNode> list, @NonNull ArrayMap<String, String> arrayMap) {
        AiApp aiApp;
        JSONObject jSONObject;
        if (list.size() != 0 && (aiApp = AiApp.get()) != null) {
            String string = aiApp.getSetting().getString(SettingDef.UPDATE_NODES_VERSION, "");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (AiAppsBaseNode aiAppsBaseNode : list) {
                    String str = arrayMap.get(aiAppsBaseNode.getNodeName());
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    try {
                        jSONObject.put(aiAppsBaseNode.getNodeName(), str);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                aiApp.getSetting().putString(SettingDef.UPDATE_NODES_VERSION, jSONObject.toString());
            }
            jSONObject = jSONObject2;
            while (r4.hasNext()) {
            }
            aiApp.getSetting().putString(SettingDef.UPDATE_NODES_VERSION, jSONObject.toString());
        }
    }

    private boolean isCacheDataInvalid() {
        return SystemClock.elapsedRealtime() - this.mLastRequestTimeMilliseconds > CACHE_DATA_VALID_TIME_MILLISECONDS;
    }
}
