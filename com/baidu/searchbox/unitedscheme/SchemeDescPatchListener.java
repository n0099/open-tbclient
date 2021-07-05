package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.VersionUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = SchemeDescPatchListener.DESC_PATCH_ACTION, module = "scheme")
/* loaded from: classes3.dex */
public class SchemeDescPatchListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String DESC_PATCH_ACTION = "desc_patch";
    public static final String DESC_PATCH_VERSION = "desc_patch_v";
    public static final String END_VERSION = "endVersion";
    public static final String KEY_DESC_PATCH_DATA = "desc_patch_data";
    public static final String PATCH = "patch";
    public static final String START_VERSION = "startVersion";
    public static final String TAG;
    public static String amendDes;
    public static String endVersion;
    public static String startVersion;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-967133406, "Lcom/baidu/searchbox/unitedscheme/SchemeDescPatchListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-967133406, "Lcom/baidu/searchbox/unitedscheme/SchemeDescPatchListener;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        TAG = SchemeDescPatchListener.class.getSimpleName();
        amendDes = "";
    }

    public SchemeDescPatchListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean SavePatchToFile(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                file = new File(SchemeConfig.getAppContext().getFilesDir(), KEY_DESC_PATCH_DATA);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (!file.exists()) {
                if (FileUtils.createNewFileSafely(file)) {
                    return FileUtils.saveToFileWithReturn(str, file, false);
                }
                return false;
            }
            return FileUtils.saveToFileWithReturn(str, file, false);
        }
        return invokeL.booleanValue;
    }

    public static boolean checkVersionIsValid(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String versionName = VersionUtils.getVersionName();
            return compareVersion(versionName, str) >= 0 && compareVersion(versionName, str2) <= 0;
        }
        return invokeLL.booleanValue;
    }

    public static int compareVersion(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null || str2 != null) {
                if (str != null || str2 == null) {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    int i2 = 0;
                    while (i2 < split.length && i2 < split2.length) {
                        try {
                            int parseInt = Integer.parseInt(split[i2]);
                            int parseInt2 = Integer.parseInt(split2[i2]);
                            if (parseInt < parseInt2) {
                                return -1;
                            }
                            if (parseInt > parseInt2) {
                                return 1;
                            }
                            i2++;
                        } catch (NumberFormatException unused) {
                            return str.compareTo(str2);
                        }
                    }
                    if (split.length > i2) {
                        return 1;
                    }
                    return split2.length > i2 ? -1 : 0;
                }
                return -1;
            }
            return 1;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(DESC_PATCH_ACTION, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (actionData == null || !TextUtils.equals(str2, DESC_PATCH_ACTION) || TextUtils.isEmpty(actionData.version)) {
                return false;
            }
            if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
                if (DEBUG) {
                    String str3 = TAG;
                    Log.d(str3, "value.data " + actionData.data);
                }
                if (SavePatchToFile(actionData.data.toString())) {
                    PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(DESC_PATCH_VERSION, actionData.version).apply();
                    JSONArray optJSONArray = actionData.data.optJSONArray(PATCH);
                    if (optJSONArray != null) {
                        startVersion = actionData.data.optString(START_VERSION);
                        endVersion = actionData.data.optString(END_VERSION);
                        amendDes = optJSONArray.toString();
                        SchemeCollecter.finalDesPatch = SchemeCollecter.getAmendDes();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(DESC_PATCH_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
