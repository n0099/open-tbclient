package com.baidu.searchbox.net.update.v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.android.util.time.ServerDeltaChangeEvent;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.statistics.ICommandStatistics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GsonTool implements ICommandStatistics<ActionData> {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String ERROR_NO = "errno";
    public static final String ERROR_NO_OK = "0";
    public static final int FROM_CLOUD = 16;
    public static final int FROM_IM = 1;
    public static final int FROM_PRELOAD = 17;
    public static final int FROM_UPDATE = 0;
    public static final String TAG = "GsonTool";
    public static final String TIME_STAMP = "timestamp";
    public static final String VERSION_VERIFY = "1";
    public static final String VERSION_VERIFY_CMD = "version_asc";
    public int mCommandFrom;
    public CommandListenerRegistry mCommandListenerRegistry;
    public JSONArray mDispatcherTimeArray;
    public String mErrorCode;
    public String mReceiveTimeStamp;
    public int mSuccessCount;
    public String mTimeStamp;
    public int mTotalCount;
    public int mVersionFilterCount;
    public JSONArray mArrayInfo = new JSONArray();
    public JSONArray mRawDyeInfo = new JSONArray();

    /* renamed from: com.baidu.searchbox.net.update.v2.GsonTool$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.END_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void doStatistics() {
        UpdateRuntime.getUpdateContext().doStatistics(this.mCommandFrom, getReportInfo());
    }

    public JSONObject getDispatcherTimeReportInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("count", Integer.valueOf(this.mSuccessCount));
            jSONObject.putOpt("business", this.mDispatcherTimeArray);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray getRawDyeInfo() {
        return this.mRawDyeInfo;
    }

    public void prepareDispatcherTimeArray() {
        this.mDispatcherTimeArray = new JSONArray();
    }

    public GsonTool(CommandListenerRegistry commandListenerRegistry) {
        if (commandListenerRegistry == null) {
            this.mCommandListenerRegistry = new CommandListenerRegistry();
        } else {
            this.mCommandListenerRegistry = commandListenerRegistry;
        }
    }

    private boolean isNeedVersionVerify(JSONObject jSONObject) {
        if (jSONObject != null && TextUtils.equals(jSONObject.optString("version_asc"), "1")) {
            return true;
        }
        return false;
    }

    public static void setDeltaTimeAndPostEvent(String str) {
        long delta = DateTimeUtil.getDelta();
        DateTimeUtil.setDeltaTime(str);
        if (delta != DateTimeUtil.getDelta()) {
            BdEventBus.Companion.getDefault().post(new ServerDeltaChangeEvent());
        }
    }

    private void collectInfo(String str, ActionData actionData, boolean z, long j) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            collectInfo(str, actionData, z);
            collectRawDyeInfo(str, actionData);
            if (this.mDispatcherTimeArray == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("item", str);
                if (z) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                jSONObject.putOpt("state", str2);
                jSONObject.putOpt(UpdateConstants.UBC_SPEND_KEY, Long.valueOf(j));
                this.mDispatcherTimeArray.put(jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    private void collectRawDyeInfo(String str, ActionData actionData) {
        if (!TextUtils.isEmpty(str) && actionData != null) {
            try {
                if (!TextUtils.isEmpty(actionData.traceId)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("product", str);
                    jSONObject.put(UpdateConstants.TRACE_ID, actionData.traceId);
                    this.mRawDyeInfo.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private long convertStringToLong(String str, String str2) {
        long j = 0;
        if (TextUtils.isEmpty(str2)) {
            return 0L;
        }
        try {
            j = Long.parseLong(str2);
            if (DEBUG) {
                Log.d(TAG, "action = " + str + " support imsdk long connect,new data version is  " + str2);
            }
        } catch (NumberFormatException unused) {
            if (DEBUG) {
                Log.e(TAG, "action = " + str + " support imsdk long connect,version is not right--> " + str2);
            }
        }
        return j;
    }

    private boolean dispatchCheck(Context context, String str, String str2, AbstractCommandListener abstractCommandListener, ActionData actionData, JSONObject jSONObject) {
        if (!isNeedVersionVerify(jSONObject) || convertStringToLong(str2, actionData.version) > convertStringToLong(str2, abstractCommandListener.getLocalVersion(context, str, str2))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    private boolean readAction(JsonReader jsonReader, ActionData actionData, TypeAdapter typeAdapter) throws IOException {
        String path = jsonReader.getPath();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("data".equals(nextName)) {
                    actionData.data = typeAdapter.read(jsonReader);
                } else if ("version".equals(nextName)) {
                    actionData.version = jsonReader.nextString();
                } else if (UpdateConstants.TRACE_ID.equals(nextName)) {
                    actionData.traceId = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return true;
        } catch (Exception unused) {
            skipErrorAction(jsonReader, path);
            return false;
        }
    }

    private void readData(JsonReader jsonReader, JSONObject jSONObject) throws IOException {
        boolean z;
        long j;
        boolean z2;
        jsonReader.beginObject();
        Gson gson = new Gson();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName2 = jsonReader.nextName();
                this.mTotalCount++;
                if (DEBUG) {
                    Log.d(TAG, "read action " + nextName + " " + nextName2);
                }
                AbstractCommandListener commandListener = this.mCommandListenerRegistry.getCommandListener(nextName, nextName2);
                if (commandListener == null && (commandListener = DynamicCommandRegistry.getInstance().getDynamicCommandListener(nextName, nextName2)) == null) {
                    commandListener = new NoneCommandListener();
                    z = false;
                } else {
                    z = true;
                }
                TypeAdapter typeAdapter = commandListener.getTypeAdapter();
                if (typeAdapter == null) {
                    try {
                        typeAdapter = gson.getAdapter(TypeToken.get(commandListener.getDataType()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        collectInfo(nextName + "/" + nextName2, null, false, 0L);
                    }
                }
                ActionData createDataObject = commandListener.createDataObject();
                boolean readAction = readAction(jsonReader, createDataObject, typeAdapter);
                if (readAction) {
                    synchronized (GsonTool.class) {
                        if (!dispatchCheck(AppRuntime.getAppContext(), nextName, nextName2, commandListener, createDataObject, jSONObject)) {
                            if (DEBUG) {
                                Log.d(TAG, "data from imsdk is not newest");
                            }
                            collectInfo(nextName + "/" + nextName2, createDataObject, false, 0L);
                            this.mVersionFilterCount = this.mVersionFilterCount + 1;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            commandListener.executeCommand(AppRuntime.getAppContext(), nextName, nextName2, createDataObject);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                } else {
                    if (DEBUG) {
                        Log.d(TAG, "read action " + nextName + " " + nextName2 + " fail");
                    }
                    j = 0;
                }
                String str = nextName + "/" + nextName2;
                if (z && readAction) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                collectInfo(str, createDataObject, z2, j);
            }
            jsonReader.endObject();
        }
        jsonReader.endObject();
    }

    private void skipErrorAction(JsonReader jsonReader, String str) throws IOException {
        if (jsonReader.getPath().equals(str)) {
            jsonReader.skipValue();
            return;
        }
        do {
            int i = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.endArray();
                }
            } else {
                jsonReader.endObject();
            }
        } while (!jsonReader.getPath().equals(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void collectInfo(String str, ActionData actionData, boolean z) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("product", str);
                if (actionData == null) {
                    str2 = "-1";
                } else {
                    str2 = actionData.version;
                }
                jSONObject.put("version", str2);
                if (z) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                jSONObject.put("valid", str3);
                if (z) {
                    this.mSuccessCount++;
                }
                this.mArrayInfo.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void read(InputStream inputStream, int i, JSONObject jSONObject) throws IOException {
        read(new InputStreamReader(inputStream), i, jSONObject);
    }

    public void readData(JsonReader jsonReader, JSONObject jSONObject, int i) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i;
        readData(jsonReader, jSONObject);
        doStatistics();
    }

    public JSONObject getReportInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UpdateConstants.RECEIVE_TS_KEY, this.mReceiveTimeStamp);
            jSONObject.put("detail", this.mArrayInfo);
            jSONObject.put("totalCount", this.mTotalCount);
            jSONObject.put("successCount", this.mSuccessCount);
            jSONObject.put("versionFilterCount", this.mVersionFilterCount);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void read(Reader reader, int i, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i;
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("data")) {
                readData(jsonReader, jSONObject);
            } else if (nextName.equals("errno")) {
                String nextString = jsonReader.nextString();
                this.mErrorCode = nextString;
                if (!nextString.equals("0")) {
                    throw new IOException("error no is not 0");
                }
            } else if (nextName.equals("timestamp")) {
                String nextString2 = jsonReader.nextString();
                this.mTimeStamp = nextString2;
                if (i == 0) {
                    setDeltaTimeAndPostEvent(nextString2);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        doStatistics();
    }

    public void readData(Reader reader, int i, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i;
        readData(new JsonReader(reader), jSONObject);
        doStatistics();
    }
}
