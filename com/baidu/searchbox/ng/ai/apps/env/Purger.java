package com.baidu.searchbox.ng.ai.apps.env;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.b.a.e.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ng.ai.apps.account.AiAppAccountStatusChangedListener;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageProvider;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageTable;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.AiAppsCookieManager;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.functions.b;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class Purger implements AiAppAccountStatusChangedListener {
    private static final String ACCOUNT_UID = "BoxAccount_uid";
    private static final String AIAPP_PREFIX = "aiapp_";
    private static final boolean DEBUG = false;
    private static final String PREFS_SEGMENT = "shared_prefs/";
    private static final String REQUEST_PARAM_ACCREDIT = "accredit";
    private static final String REQUEST_PARAM_AIAPP_ID = "ma_ids";
    private static final String REQUEST_PARAM_DATA = "data";
    private static final String RESPONSE_ACCREDIT = "accredit";
    private static final String RESPONSE_DATA = "data";
    private static final String RESPONSE_ERRNO = "errno";
    private static final int RESPONSE_ERRNO_SUCCESS = 0;
    private static final String SETTING_PREFIX = "aiapp_setting_";
    private static final String SETTING_SUBFIX = ".xml";
    public static final String TAG = "AiAppPurger";
    private CopyOnWriteArrayList<String> mDelIgnoreAppIds;
    private AtomicInteger mDeletingCount;
    private final Holder mHolder;
    private final String mProcess = ProcessUtils.getCurProcessName();

    /* loaded from: classes2.dex */
    public interface Holder extends ContextProvider {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Purger(Holder holder) {
        this.mHolder = holder;
        AiAppsRuntime.getAiAppAccountRuntime().addLoginStatusChangedListener(this);
        this.mDeletingCount = new AtomicInteger(0);
        this.mDelIgnoreAppIds = new CopyOnWriteArrayList<>();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.account.AiAppAccountStatusChangedListener
    public void onLoginStatusChanged(boolean z, boolean z2) {
        AiAppsRuntime.getAiAppAccountRuntime().getSession(this.mHolder.requireContext(), ACCOUNT_UID, null);
        if (z2) {
            settingsPurge();
        } else {
            fullPurge();
        }
    }

    public String toString() {
        return "Process<" + this.mProcess + "> " + super.toString();
    }

    public void deleteAiApp(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            deleteAiApp(arrayList);
        }
    }

    public void deleteAiApp(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            deleteAiApp(list, true);
        }
    }

    public void deleteAiApp(@Nullable final List<String> list, final boolean z) {
        if (list != null && !list.isEmpty()) {
            d.just("").observeOn(Schedulers.io()).subscribe(new b<String>() { // from class: com.baidu.searchbox.ng.ai.apps.env.Purger.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    Purger.this.mDeletingCount.incrementAndGet();
                    if (z) {
                        Purger.this.resetAccredit(list);
                    }
                    Purger.this.clearAiAppsData(list);
                    for (String str2 : list) {
                        if (!Purger.this.mDelIgnoreAppIds.contains(str2)) {
                            Purger.this.deleteApsItem(str2);
                            AiAppsBundleHelper.ReleaseBundleHelper.deleteAiAppFile(str2);
                            AiAppsDbControl.getInstance(AppRuntime.getAppContext()).deleteAiAppsItemByAppid(str2, false);
                            SubPackageInfoHelper.getInstance().clearAllVersionSubPackageInfo(str2);
                        }
                    }
                    if (Purger.this.mDeletingCount.decrementAndGet() <= 0) {
                        Purger.this.mDeletingCount.set(0);
                        Purger.this.mDelIgnoreAppIds.clear();
                    }
                }
            });
        }
    }

    public boolean isDeleting() {
        return this.mDeletingCount.get() > 0;
    }

    public void addDelIgnoreAppId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDelIgnoreAppIds.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAccredit(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(REQUEST_PARAM_AIAPP_ID, list);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(AiAppsRuntime.getAiAppAccountRuntime().processUrl(AiAppsRuntime.getConfigRuntime().getAiAppsResetUrl()))).addParam("data", jSONObject.toString()).cookieManager(new AiAppsCookieManager(true))).build().executeAsyncOnUIBack(buildResetCallback(list));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAiAppsData(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Set<String> resetByActiveAiApp = resetByActiveAiApp(list);
            HashSet hashSet = new HashSet(list);
            if (resetByActiveAiApp != null) {
                hashSet.removeAll(resetByActiveAiApp);
            }
            deleteSharedPrefFiles(SETTING_PREFIX, hashSet, false);
            deleteSharedPrefFiles(AIAPP_PREFIX, hashSet, false);
            for (String str : hashSet) {
                String aiappStoreDirectory = StorageUtil.getAiappStoreDirectory(str);
                if (!TextUtils.isEmpty(aiappStoreDirectory)) {
                    AiAppsFileUtils.deleteFile(aiappStoreDirectory);
                }
                String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(str);
                if (!TextUtils.isEmpty(aiappTmpDirectory)) {
                    AiAppsFileUtils.deleteFile(aiappTmpDirectory);
                }
            }
        }
    }

    private void settingsPurge() {
        settingsPurgeByDeleteFiles(settingsPurgeByActiveAiApp());
    }

    private Set<String> settingsPurgeByActiveAiApp() {
        return broadcastMsg(103);
    }

    @Nullable
    private Set<String> resetByActiveAiApp(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return broadcastMsg(106, list);
    }

    private void settingsPurgeByDeleteFiles(Set<String> set) {
        deleteSharedPrefFiles(SETTING_PREFIX, set, true);
    }

    private void fullPurge() {
        fullPurgeByDelFiles(fullPurgeByActiveAiApp());
    }

    private Set<String> fullPurgeByActiveAiApp() {
        return broadcastMsg(100);
    }

    private void fullPurgeByDelFiles(Set<String> set) {
        deleteSharedPrefFiles(AIAPP_PREFIX, set, true);
        String aiappStoreRoot = StorageUtil.getAiappStoreRoot();
        if (!TextUtils.isEmpty(aiappStoreRoot)) {
            AiAppsFileUtils.deleteFile(aiappStoreRoot);
        }
        String aiappTmpRoot = StorageUtil.getAiappTmpRoot();
        if (!TextUtils.isEmpty(aiappTmpRoot)) {
            AiAppsFileUtils.deleteFile(aiappTmpRoot);
        }
    }

    private Set<String> broadcastMsg(int i) {
        AiAppsMessengerService serviceObject = AiAppsMessengerService.getServiceObject();
        if (serviceObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collection<AiAppsMessengerService.AiAppsClientObject> values = serviceObject.getAllClientObjects().values();
        if (values.size() < 1) {
            return hashSet;
        }
        for (AiAppsMessengerService.AiAppsClientObject aiAppsClientObject : values) {
            String str = aiAppsClientObject.mAppId;
            if (!TextUtils.isEmpty(str)) {
                hashSet.add(str);
            }
        }
        serviceObject.sendMessageToAllClients(i);
        return hashSet;
    }

    @Nullable
    private Set<String> broadcastMsg(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        AiAppsMessengerService serviceObject = AiAppsMessengerService.getServiceObject();
        if (serviceObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collection<AiAppsMessengerService.AiAppsClientObject> values = serviceObject.getAllClientObjects().values();
        if (values.size() < 1) {
            return hashSet;
        }
        for (AiAppsMessengerService.AiAppsClientObject aiAppsClientObject : values) {
            String str = aiAppsClientObject.mAppId;
            if (!TextUtils.isEmpty(str) && list.contains(str)) {
                serviceObject.sendMessageToClient(aiAppsClientObject.mProcessId, i, null);
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    private void deleteSharedPrefFiles(@NonNull String str, Set<String> set, boolean z) {
        File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, PREFS_SEGMENT);
        if (file.exists() || file.isDirectory()) {
            File[] listFiles = file.listFiles();
            Set<String> set2 = set;
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!name.isEmpty() && file2.isFile() && name.startsWith(str) && name.endsWith(SETTING_SUBFIX)) {
                    int length = name.length();
                    int length2 = str.length();
                    int length3 = SETTING_SUBFIX.length();
                    if (length >= length2 + length3) {
                        String substring = name.substring(length2, length - length3);
                        if (set2 == null) {
                            set2 = Collections.emptySet();
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            if (z) {
                                if (set2.contains(substring)) {
                                }
                                file2.delete();
                            } else {
                                if (!set2.contains(substring)) {
                                }
                                file2.delete();
                            }
                        }
                    }
                }
            }
        }
    }

    @NonNull
    private ResponseCallback<JSONObject> buildResetCallback(@NonNull List<String> list) {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.ng.ai.apps.env.Purger.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(JSONObject jSONObject, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteApsItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.ae("21", str);
            deleteSubPackageApsItem(str);
        }
    }

    private void deleteSubPackageApsItem(String str) {
        List<String> subPackageApsPackageName;
        if (!TextUtils.isEmpty(str) && (subPackageApsPackageName = getSubPackageApsPackageName(str)) != null && subPackageApsPackageName.size() > 0) {
            for (String str2 : subPackageApsPackageName) {
                if (!TextUtils.isEmpty(str2)) {
                    a.ae("21", str2);
                }
            }
        }
    }

    private List<String> getSubPackageApsPackageName(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(SubPackageProvider.getUri(), new String[]{SubPackageTable.Table.aps_package_name.toString()}, SubPackageTable.Table.app_id + " =? ", new String[]{str}, null);
        } catch (Exception e) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursor != null) {
            try {
                int columnIndex = cursor.getColumnIndex(SubPackageTable.Table.aps_package_name.toString());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndex);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                AiAppsFileUtils.closeSafely(cursor);
            } catch (Exception e2) {
                AiAppsFileUtils.closeSafely(cursor);
                return arrayList;
            } catch (Throwable th2) {
                cursor2 = cursor;
                th = th2;
                AiAppsFileUtils.closeSafely(cursor2);
                throw th;
            }
            return arrayList;
        }
        AiAppsFileUtils.closeSafely(cursor);
        return arrayList;
    }
}
