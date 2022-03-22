package com.baidu.searchbox.net.update.v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.android.util.time.ServerDeltaChangeEvent;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.net.update.ioc.UpdateRuntime;
import com.baidu.searchbox.net.update.statistics.ICommandStatistics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class GsonTool implements ICommandStatistics<ActionData> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
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
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray mArrayInfo;
    public int mCommandFrom;
    public CommandListenerRegistry mCommandListenerRegistry;
    public String mErrorCode;
    public String mReceiveTimeStamp;
    public int mSuccessCount;
    public String mTimeStamp;
    public int mTotalCount;
    public int mVersionFilterCount;

    /* renamed from: com.baidu.searchbox.net.update.v2.GsonTool$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(435261586, "Lcom/baidu/searchbox/net/update/v2/GsonTool$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(435261586, "Lcom/baidu/searchbox/net/update/v2/GsonTool$1;");
                    return;
                }
            }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(505480319, "Lcom/baidu/searchbox/net/update/v2/GsonTool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(505480319, "Lcom/baidu/searchbox/net/update/v2/GsonTool;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public GsonTool(CommandListenerRegistry commandListenerRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {commandListenerRegistry};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mArrayInfo = new JSONArray();
        if (commandListenerRegistry == null) {
            this.mCommandListenerRegistry = new CommandListenerRegistry();
        } else {
            this.mCommandListenerRegistry = commandListenerRegistry;
        }
    }

    private long convertStringToLong(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
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
        return invokeLL.longValue;
    }

    private boolean dispatchCheck(Context context, String str, String str2, AbstractCommandListener abstractCommandListener, ActionData actionData, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, str, str2, abstractCommandListener, actionData, jSONObject})) == null) ? !isNeedVersionVerify(jSONObject) || convertStringToLong(str2, actionData.version) > convertStringToLong(str2, abstractCommandListener.getLocalVersion(context, str, str2)) : invokeCommon.booleanValue;
    }

    private boolean isNeedVersionVerify(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("version_asc"), "1") : invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
    private boolean readAction(JsonReader jsonReader, ActionData actionData, TypeAdapter typeAdapter) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, jsonReader, actionData, typeAdapter)) == null) {
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
        return invokeLLL.booleanValue;
    }

    public static void setDeltaTimeAndPostEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            long delta = DateTimeUtil.getDelta();
            DateTimeUtil.setDeltaTime(str);
            if (delta != DateTimeUtil.getDelta()) {
                BdEventBus.Companion.getDefault().post(new ServerDeltaChangeEvent());
            }
        }
    }

    private void skipErrorAction(JsonReader jsonReader, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, jsonReader, str) == null) {
            if (jsonReader.getPath().equals(str)) {
                jsonReader.skipValue();
                return;
            }
            do {
                int i = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()];
                if (i == 1) {
                    jsonReader.endObject();
                } else if (i != 2) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.endArray();
                }
            } while (!jsonReader.getPath().equals(str));
        }
    }

    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void doStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            UpdateRuntime.getUpdateContext().doStatistics(this.mCommandFrom, getReportInfo());
        }
    }

    public JSONObject getReportInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }

    public void read(InputStream inputStream, int i, JSONObject jSONObject) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, inputStream, i, jSONObject) == null) {
            read(new InputStreamReader(inputStream), i, jSONObject);
        }
    }

    public void readData(JsonReader jsonReader, JSONObject jSONObject, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, jsonReader, jSONObject, i) == null) {
            this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
            this.mCommandFrom = i;
            readData(jsonReader, jSONObject);
            doStatistics();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.net.update.statistics.ICommandStatistics
    public void collectInfo(String str, ActionData actionData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, actionData, z) == null) || TextUtils.isEmpty(str)) {
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

    @SuppressLint({"BDThrowableCheck"})
    public void read(Reader reader, int i, JSONObject jSONObject) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, reader, i, jSONObject) == null) {
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
    }

    public void readData(Reader reader, int i, JSONObject jSONObject) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, reader, i, jSONObject) == null) {
            this.mReceiveTimeStamp = String.valueOf(System.currentTimeMillis());
            this.mCommandFrom = i;
            readData(new JsonReader(reader), jSONObject);
            doStatistics();
        }
    }

    private void readData(JsonReader jsonReader, JSONObject jSONObject) throws IOException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, jsonReader, jSONObject) == null) {
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
}
