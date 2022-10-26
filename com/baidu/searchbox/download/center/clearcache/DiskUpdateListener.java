package com.baidu.searchbox.download.center.clearcache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskUpdateListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "Landroid/content/Context;", "context", "", "module", "action", "Lcom/baidu/searchbox/net/update/CommandPostData;", "postData", "", "addPostData", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/CommandPostData;)V", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "value", "", "executeCommand", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/net/update/v2/ActionData;)Z", "getLocalVersion", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "Companion", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DiskUpdateListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALL = "all";
    public static final String BEGIN_TIME = "begin_time";
    public static final String CLEAN = "clean";
    public static final Companion Companion;
    public static final String DEFAULT_VERSION = "0";
    public static final String DISK_CLEAN_DATA_KEY = "disk_clean_data_key";
    public static final String DISK_VERSION_KEY = "disk_update_version";
    public static final String DISK_WARNING_DATA_KEY = "disk_warning_data_key";
    public static final String END_TIME = "end_time";
    public static final String PERCENT = "percent";
    public static final String WARNING = "warning";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-768495052, "Lcom/baidu/searchbox/download/center/clearcache/DiskUpdateListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-768495052, "Lcom/baidu/searchbox/download/center/clearcache/DiskUpdateListener;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/DiskUpdateListener$Companion;", "", "ALL", "Ljava/lang/String;", "BEGIN_TIME", "CLEAN", "DEFAULT_VERSION", "DISK_CLEAN_DATA_KEY", "DISK_VERSION_KEY", "DISK_WARNING_DATA_KEY", "END_TIME", "PERCENT", "WARNING", "<init>", "()V", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DiskUpdateListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) {
        JSONObject version;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) && commandPostData != null && (version = commandPostData.getVersion()) != null) {
            version.put(str2, getLocalVersion(context, str, str2));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.String, com.baidu.searchbox.net.update.v2.ActionData] */
    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (actionData != null && !TextUtils.isEmpty(actionData.version)) {
                new SharedPrefsWrapper("").putString(DISK_VERSION_KEY, actionData.version);
                if (AppConfig.isDebug()) {
                    Log.d("DiskUpdateListener", "executeCommand version : " + actionData.version);
                    Log.d("DiskUpdateListener", "executeCommand data : " + ((JSONObject) actionData.data));
                }
                if (actionData.data != null) {
                    try {
                        float nextFloat = new Random().nextFloat();
                        if (AppConfig.isDebug()) {
                            Log.d("DiskUpdateListener", "executeCommand random1 : " + nextFloat);
                        }
                        JSONObject optJSONObject = ((JSONObject) actionData.data).optJSONObject("all");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("percent");
                            Intrinsics.checkNotNullExpressionValue(optString, "all.optString(PERCENT)");
                            float parseFloat = Float.parseFloat(optString);
                            if (parseFloat > 0.01f) {
                                parseFloat = 0.01f;
                            }
                            if (parseFloat >= nextFloat) {
                                String optString2 = optJSONObject.optString(BEGIN_TIME);
                                Intrinsics.checkNotNullExpressionValue(optString2, "all.optString(BEGIN_TIME)");
                                long parseLong = Long.parseLong(optString2);
                                String optString3 = optJSONObject.optString("end_time");
                                Intrinsics.checkNotNullExpressionValue(optString3, "all.optString(END_TIME)");
                                long parseLong2 = Long.parseLong(optString3);
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                if (parseLong <= currentTimeMillis && parseLong2 >= currentTimeMillis) {
                                    ClearCacheUbcController.reportBaiduFile(ClearCacheUbcController.REPORT_FILE_TYPE_COLD_START);
                                }
                            }
                        }
                        float nextFloat2 = new Random().nextFloat();
                        if (AppConfig.isDebug()) {
                            Log.d("DiskUpdateListener", "executeCommand random2 : " + nextFloat2);
                        }
                        JSONObject optJSONObject2 = ((JSONObject) actionData.data).optJSONObject("clean");
                        if (optJSONObject2 != null) {
                            String optString4 = optJSONObject2.optString("percent");
                            Intrinsics.checkNotNullExpressionValue(optString4, "clean.optString(PERCENT)");
                            float parseFloat2 = Float.parseFloat(optString4);
                            if (parseFloat2 <= 0.0f) {
                                new SharedPrefsWrapper("").putString(DISK_CLEAN_DATA_KEY, "");
                            } else if (parseFloat2 >= nextFloat2) {
                                new SharedPrefsWrapper("").putString(DISK_CLEAN_DATA_KEY, optJSONObject2.toString());
                            }
                        }
                        float nextFloat3 = new Random().nextFloat();
                        if (AppConfig.isDebug()) {
                            Log.d("DiskUpdateListener", "executeCommand random3 : " + nextFloat3);
                        }
                        JSONObject optJSONObject3 = ((JSONObject) actionData.data).optJSONObject("warning");
                        if (optJSONObject3 != null) {
                            String optString5 = optJSONObject3.optString("percent");
                            Intrinsics.checkNotNullExpressionValue(optString5, "warning.optString(PERCENT)");
                            float parseFloat3 = Float.parseFloat(optString5);
                            if (parseFloat3 <= 0.0f) {
                                new SharedPrefsWrapper("").putString(DISK_WARNING_DATA_KEY, "");
                                return true;
                            } else if (parseFloat3 >= nextFloat3) {
                                new SharedPrefsWrapper("").putString(DISK_WARNING_DATA_KEY, optJSONObject3.toString());
                                return true;
                            } else {
                                return true;
                            }
                        }
                        return true;
                    } catch (Exception e) {
                        if (AppConfig.isDebug()) {
                            e.printStackTrace();
                            return true;
                        }
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
            String string = new SharedPrefsWrapper("").getString(DISK_VERSION_KEY, "0");
            Intrinsics.checkNotNull(string);
            return string;
        }
        return (String) invokeLLL.objValue;
    }
}
