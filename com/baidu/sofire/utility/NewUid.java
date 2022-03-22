package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
/* loaded from: classes4.dex */
public class NewUid {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXT_FILE = ".icosc";
    public static final String NEW_UID_SETTING_KEY = "com.q.zi.i";
    public static final String STORAGE_DIR = ".zp";
    public static final String STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String STORAGE_WIRTE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static String sNewUid = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1772666631, "Lcom/baidu/sofire/utility/NewUid;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1772666631, "Lcom/baidu/sofire/utility/NewUid;");
        }
    }

    public NewUid() {
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

    private boolean checkSelfPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private String getFileContent(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, file)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                String charArrayWriter2 = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                return charArrayWriter2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    CommonMethods.handleNuLException(th);
                    return null;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            CommonMethods.handleNuLException(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static String getNewUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (TextUtils.isEmpty(sNewUid)) {
                sNewUid = new NewUid().getOrCreateNewUid(context);
            }
            return sNewUid;
        }
        return (String) invokeL.objValue;
    }

    private String getOrCreateNewUid(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            String newUidByPreferences = getNewUidByPreferences(context);
            boolean z2 = true;
            boolean z3 = false;
            if (TextUtils.isEmpty(newUidByPreferences)) {
                newUidByPreferences = getNewUidBySetting(context);
                if (TextUtils.isEmpty(newUidByPreferences)) {
                    newUidByPreferences = getNewUidBySdCard(context);
                    if (TextUtils.isEmpty(newUidByPreferences)) {
                        newUidByPreferences = createNewUid(context);
                        z = true;
                    } else {
                        z = false;
                    }
                    z3 = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (z2 || TextUtils.isEmpty(getNewUidByPreferences(context))) {
                SharedPreferenceManager.getInstance(context).setNewUidNew(newUidByPreferences);
            }
            if (z3 || TextUtils.isEmpty(getNewUidBySetting(context))) {
                tryPutSystemSettingValue(context, NEW_UID_SETTING_KEY, newUidByPreferences);
            }
            if (checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (z || TextUtils.isEmpty(getNewUidBySdCard(context)))) {
                tryPutExternalStorageValue(context, newUidByPreferences);
            }
            return newUidByPreferences;
        }
        return (String) invokeL.objValue;
    }

    private String getSystemSettingValue(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, context, str)) == null) {
            try {
                return PrivacyOperationUtil.allowReadSettings(context) ? Settings.System.getString(context.getContentResolver(), str) : "";
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    private void tryPutExternalStorageValue(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, this, context, str) != null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            if (Build.VERSION.SDK_INT < 29 && PrivacyOperationUtil.allowWriteSdCard(context)) {
                File file = new File(Environment.getExternalStorageDirectory(), STORAGE_DIR);
                File file2 = new File(file, EXT_FILE);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        file.delete();
                        file.mkdirs();
                    }
                } else {
                    file.mkdirs();
                }
                FileWriter fileWriter2 = new FileWriter(file2, false);
                try {
                    fileWriter2.write(str);
                    fileWriter2.flush();
                    try {
                        fileWriter2.close();
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                    }
                } catch (Throwable th2) {
                    fileWriter = fileWriter2;
                    th = th2;
                    try {
                        CommonMethods.handleNuLException(th);
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable th3) {
                                CommonMethods.handleNuLException(th3);
                            }
                        }
                    } catch (Throwable th4) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable th5) {
                                CommonMethods.handleNuLException(th5);
                            }
                        }
                        throw th4;
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private boolean tryPutSystemSettingValue(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, context, str, str2)) == null) {
            try {
                if (PrivacyOperationUtil.allowWriteSettings(context)) {
                    return Settings.System.putString(context.getContentResolver(), str, str2);
                }
                return false;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public String createNewUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return "1|" + MD5Util.getMD5(UUID.randomUUID().toString());
        }
        return (String) invokeL.objValue;
    }

    public String getNewUidByPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                String newUidNew = sharedPreferenceManager.getNewUidNew();
                if (TextUtils.isEmpty(newUidNew)) {
                    String newUid = sharedPreferenceManager.getNewUid();
                    if (TextUtils.isEmpty(newUid)) {
                        return "";
                    }
                    sharedPreferenceManager.setNewUidNew(newUid);
                    return newUid;
                }
                return newUidNew;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String getNewUidBySdCard(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (PrivacyOperationUtil.allowReadSdCard(context) && checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
                if (file.exists()) {
                    return getFileContent(file);
                }
                return "";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String getNewUidBySetting(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                return getSystemSettingValue(context, NEW_UID_SETTING_KEY);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
