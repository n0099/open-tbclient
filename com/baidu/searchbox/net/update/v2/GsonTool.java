package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.statistics.ICommandStatistics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class GsonTool implements ICommandStatistics<ActionData> {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String ERROR_NO = "errno";
    private static final String ERROR_NO_OK = "0";
    public static final int FROM_CLOUD = 16;
    public static final int FROM_IM = 1;
    public static final int FROM_UPDATE = 0;
    private static final String TAG = "GsonTool";
    private static final String TIME_STAMP = "timestamp";
    private static final String VERSION_VERIFY = "1";
    private static final String VERSION_VERIFY_CMD = "version_asc";
    private JSONArray mArrayInfo = new JSONArray();
    private int mCommandFrom;
    private CommandListenerRegistry mCommandListenerRegistry;
    private String mErrorCode;
    private String mReceiveTimeStamp;
    private int mSuccessCount;
    private String mTimeStamp;
    private int mTotalCount;
    private int mVersionFilterCount;

    public GsonTool(CommandListenerRegistry commandListenerRegistry) {
        if (commandListenerRegistry == null) {
            this.mCommandListenerRegistry = new CommandListenerRegistry();
        } else {
            this.mCommandListenerRegistry = commandListenerRegistry;
        }
    }

    public void read(InputStream inputStream, int i, JSONObject jSONObject) throws IOException {
        read(new InputStreamReader(inputStream), i, jSONObject);
    }

    public void read(Reader reader, int i, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i;
        a aVar = new a(reader);
        aVar.dBq();
        while (aVar.hasNext()) {
            String dBu = aVar.dBu();
            if (dBu.equals("data")) {
                readData(aVar, jSONObject);
            } else if (dBu.equals("errno")) {
                this.mErrorCode = aVar.dBv();
                if (!this.mErrorCode.equals("0")) {
                    throw new IOException("error no is not 0");
                }
            } else if (dBu.equals("timestamp")) {
                this.mTimeStamp = aVar.dBv();
                if (i == 0) {
                    DateTimeUtil.setDeltaTime(this.mTimeStamp);
                }
            } else {
                aVar.dBx();
            }
        }
        aVar.endObject();
        doStatistics();
    }

    public void readData(Reader reader, int i, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i;
        readData(new a(reader), jSONObject);
        doStatistics();
    }

    private void readData(a aVar, JSONObject jSONObject) throws IOException {
        boolean z;
        aVar.dBq();
        Gson gson = new Gson();
        while (aVar.hasNext()) {
            String dBu = aVar.dBu();
            aVar.dBq();
            while (aVar.hasNext()) {
                String dBu2 = aVar.dBu();
                this.mTotalCount++;
                if (DEBUG) {
                    Log.d(TAG, "read action " + dBu + HanziToPinyin.Token.SEPARATOR + dBu2);
                }
                AbstractCommandListener commandListener = this.mCommandListenerRegistry.getCommandListener(dBu, dBu2);
                if (commandListener == null) {
                    commandListener = new NoneCommandListener();
                    z = false;
                } else {
                    z = true;
                }
                TypeAdapter typeAdapter = commandListener.getTypeAdapter();
                if (typeAdapter == null) {
                    try {
                        typeAdapter = gson.getAdapter(com.google.gson.b.a.get(commandListener.getDataType()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        collectInfo(dBu + "/" + dBu2, (ActionData) null, false);
                    }
                }
                ActionData createDataObject = commandListener.createDataObject();
                boolean readAction = readAction(aVar, createDataObject, typeAdapter);
                if (readAction) {
                    synchronized (GsonTool.class) {
                        if (!dispatchCheck(AppRuntime.getAppContext(), dBu, dBu2, commandListener, createDataObject, jSONObject)) {
                            if (DEBUG) {
                                Log.d(TAG, "data from imsdk is not newest");
                            }
                            collectInfo(dBu + "/" + dBu2, createDataObject, false);
                            this.mVersionFilterCount++;
                        } else {
                            commandListener.executeCommand(AppRuntime.getAppContext(), dBu, dBu2, createDataObject);
                        }
                    }
                } else if (DEBUG) {
                    Log.d(TAG, "read action " + dBu + HanziToPinyin.Token.SEPARATOR + dBu2 + " fail");
                }
                collectInfo(dBu + "/" + dBu2, createDataObject, z && readAction);
            }
            aVar.endObject();
        }
        aVar.endObject();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
    private boolean readAction(a aVar, ActionData actionData, TypeAdapter typeAdapter) throws IOException {
        String path = aVar.getPath();
        try {
            aVar.dBq();
            while (aVar.hasNext()) {
                String dBu = aVar.dBu();
                if (dBu.equals("data")) {
                    actionData.data = typeAdapter.read(aVar);
                } else if (dBu.equals("version")) {
                    actionData.version = aVar.dBv();
                } else {
                    aVar.dBx();
                }
            }
            aVar.endObject();
            return true;
        } catch (Exception e) {
            skipErrorAction(aVar, path);
            return false;
        }
    }

    private void skipErrorAction(a aVar, String str) throws IOException {
        if (aVar.getPath().equals(str)) {
            aVar.dBx();
            return;
        }
        aVar.dBx();
        do {
            switch (aVar.dBr()) {
                case END_OBJECT:
                    aVar.endObject();
                    break;
                case END_ARRAY:
                    aVar.endArray();
                    break;
                default:
                    aVar.dBx();
                    aVar.dBx();
                    break;
            }
        } while (!aVar.getPath().equals(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void collectInfo(String str, ActionData actionData, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("product", str);
                jSONObject.put("version", actionData == null ? "-1" : actionData.version);
                jSONObject.put(UpdateConstants.VALID_KEY, z ? "1" : "0");
                if (z) {
                    this.mSuccessCount++;
                }
                this.mArrayInfo.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void doStatistics() {
        UpdateRuntime.getUpdateContext().doStatistics(this.mCommandFrom, getReportInfo());
    }

    public JSONObject getReportInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UpdateConstants.RECEIVE_TS_KEY, this.mReceiveTimeStamp);
            jSONObject.put("detail", this.mArrayInfo);
            jSONObject.put(UpdateConstants.TOTAL_COUNT_KEY, this.mTotalCount);
            jSONObject.put(UpdateConstants.SUCCESS_COUNT_KEY, this.mSuccessCount);
            jSONObject.put(UpdateConstants.VERSION_FILTER_COUNT_KEY, this.mVersionFilterCount);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean dispatchCheck(Context context, String str, String str2, AbstractCommandListener abstractCommandListener, ActionData actionData, JSONObject jSONObject) {
        return !isNeedVersionVerify(jSONObject) || convertStringToLong(str2, actionData.version) > convertStringToLong(str2, abstractCommandListener.getLocalVersion(context, str, str2));
    }

    private boolean isNeedVersionVerify(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString(VERSION_VERIFY_CMD), "1");
    }

    private long convertStringToLong(String str, String str2) {
        long j = 0;
        if (!TextUtils.isEmpty(str2)) {
            try {
                j = Long.parseLong(str2);
                if (DEBUG) {
                    Log.d(TAG, "action = " + str + " support imsdk long connect,new data version is  " + str2);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    Log.e(TAG, "action = " + str + " support imsdk long connect,version is not right--> " + str2);
                }
            }
        }
        return j;
    }
}
