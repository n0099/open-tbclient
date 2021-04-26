package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.time.DateTimeUtil;
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
    public static final int FROM_UPDATE = 0;
    public static final String TAG = "GsonTool";
    public static final String TIME_STAMP = "timestamp";
    public static final String VERSION_VERIFY = "1";
    public static final String VERSION_VERIFY_CMD = "version_asc";
    public JSONArray mArrayInfo = new JSONArray();
    public int mCommandFrom;
    public CommandListenerRegistry mCommandListenerRegistry;
    public String mErrorCode;
    public String mReceiveTimeStamp;
    public int mSuccessCount;
    public String mTimeStamp;
    public int mTotalCount;
    public int mVersionFilterCount;

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

    public GsonTool(CommandListenerRegistry commandListenerRegistry) {
        if (commandListenerRegistry == null) {
            this.mCommandListenerRegistry = new CommandListenerRegistry();
        } else {
            this.mCommandListenerRegistry = commandListenerRegistry;
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
        return !isNeedVersionVerify(jSONObject) || convertStringToLong(str2, actionData.version) > convertStringToLong(str2, abstractCommandListener.getLocalVersion(context, str, str2));
    }

    private boolean isNeedVersionVerify(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("version_asc"), "1");
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    private boolean readAction(JsonReader jsonReader, ActionData actionData, TypeAdapter typeAdapter) throws IOException {
        String path = jsonReader.getPath();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("data")) {
                    actionData.data = typeAdapter.read(jsonReader);
                } else if (nextName.equals("version")) {
                    actionData.version = jsonReader.nextString();
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

    private void skipErrorAction(JsonReader jsonReader, String str) throws IOException {
        if (jsonReader.getPath().equals(str)) {
            jsonReader.skipValue();
            return;
        }
        do {
            int i2 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
            if (i2 == 1) {
                jsonReader.endObject();
            } else if (i2 != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.endArray();
            }
        } while (!jsonReader.getPath().equals(str));
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
            jSONObject.put("totalCount", this.mTotalCount);
            jSONObject.put("successCount", this.mSuccessCount);
            jSONObject.put("versionFilterCount", this.mVersionFilterCount);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void read(InputStream inputStream, int i2, JSONObject jSONObject) throws IOException {
        read(new InputStreamReader(inputStream), i2, jSONObject);
    }

    public void readData(JsonReader jsonReader, JSONObject jSONObject, int i2) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i2;
        readData(jsonReader, jSONObject);
        doStatistics();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void collectInfo(String str, ActionData actionData, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("product", str);
            jSONObject.put("version", actionData == null ? "-1" : actionData.version);
            jSONObject.put("valid", z ? "1" : "0");
            if (z) {
                this.mSuccessCount++;
            }
            this.mArrayInfo.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void read(Reader reader, int i2, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i2;
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
                if (i2 == 0) {
                    DateTimeUtil.setDeltaTime(nextString2);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        doStatistics();
    }

    public void readData(Reader reader, int i2, JSONObject jSONObject) throws IOException {
        this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
        this.mCommandFrom = i2;
        readData(new JsonReader(reader), jSONObject);
        doStatistics();
    }

    private void readData(JsonReader jsonReader, JSONObject jSONObject) throws IOException {
        boolean z;
        jsonReader.beginObject();
        Gson gson = new Gson();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName2 = jsonReader.nextName();
                boolean z2 = true;
                this.mTotalCount++;
                if (DEBUG) {
                    Log.d(TAG, "read action " + nextName + " " + nextName2);
                }
                AbstractCommandListener commandListener = this.mCommandListenerRegistry.getCommandListener(nextName, nextName2);
                if (commandListener == null) {
                    commandListener = new NoneCommandListener();
                    z = false;
                } else {
                    z = true;
                }
                TypeAdapter typeAdapter = commandListener.getTypeAdapter();
                if (typeAdapter == null) {
                    try {
                        typeAdapter = gson.getAdapter(TypeToken.get(commandListener.getDataType()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        collectInfo(nextName + "/" + nextName2, (ActionData) null, false);
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
                            collectInfo(nextName + "/" + nextName2, createDataObject, false);
                            this.mVersionFilterCount = this.mVersionFilterCount + 1;
                        } else {
                            commandListener.executeCommand(AppRuntime.getAppContext(), nextName, nextName2, createDataObject);
                        }
                    }
                } else if (DEBUG) {
                    Log.d(TAG, "read action " + nextName + " " + nextName2 + " fail");
                }
                String str = nextName + "/" + nextName2;
                if (!z || !readAction) {
                    z2 = false;
                }
                collectInfo(str, createDataObject, z2);
            }
            jsonReader.endObject();
        }
        jsonReader.endObject();
    }
}
