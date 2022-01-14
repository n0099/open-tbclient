package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.a;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes10.dex */
public class Dev {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INSTALLATION = "INSTALLATION";
    public transient /* synthetic */ FieldHolder $fh;
    public String brand;
    public boolean firstRun;
    public String packagename;
    public String sdkVersion;
    public String sysVersion;
    public String uniqueID;

    public Dev() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uniqueID = "";
        this.brand = "";
        this.sysVersion = "";
        this.packagename = "";
        this.sdkVersion = a.k;
        this.firstRun = false;
    }

    private String generateUniquePsuedoID(Context context) {
        InterceptResult invokeL;
        String uuid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
            try {
                uuid = Build.class.getField("SERIAL").get(null).toString();
            } catch (Exception unused) {
                uuid = UUID.randomUUID().toString();
            }
            String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            if ("9774d56d682e549c".equals(string)) {
                string = UUID.randomUUID().toString();
            }
            return md5(uuid + string + str);
        }
        return (String) invokeL.objValue;
    }

    public static String md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
                while (bigInteger.length() < 32) {
                    bigInteger = "0" + bigInteger;
                }
                return bigInteger;
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0025 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    private String readInstallationFile(File file) throws IOException {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
            RandomAccessFile randomAccessFile2 = 0;
            RandomAccessFile randomAccessFile3 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[(int) randomAccessFile.length()];
                randomAccessFile.readFully(bArr);
                String str = new String(bArr);
                randomAccessFile.close();
                return str;
            } catch (Exception e3) {
                e = e3;
                randomAccessFile3 = randomAccessFile;
                e.printStackTrace();
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
                randomAccessFile2 = "";
                return "";
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != 0) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    private void writeInstallationFile(Context context, String str) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), INSTALLATION));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
            try {
                fileOutputStream.write(str.getBytes());
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public String getBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.brand : (String) invokeV.objValue;
    }

    public boolean getFirstRun() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.firstRun : invokeV.booleanValue;
    }

    public String getPackagename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.packagename : (String) invokeV.objValue;
    }

    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sdkVersion : (String) invokeV.objValue;
    }

    public String getSysVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.sysVersion : (String) invokeV.objValue;
    }

    public String getUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.uniqueID : (String) invokeV.objValue;
    }

    public synchronized String getUniqueIdFromFile(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.uniqueID)) {
                    try {
                        this.uniqueID = readInstallationFile(new File(context.getFilesDir(), INSTALLATION));
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                str = this.uniqueID;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, context) == null) || context == null) {
            return;
        }
        this.brand = Build.MODEL.replace(" ", "");
        this.sysVersion = Build.VERSION.RELEASE;
        this.packagename = context.getPackageName();
        String uniqueIdFromFile = getUniqueIdFromFile(context);
        this.uniqueID = uniqueIdFromFile;
        if (TextUtils.isEmpty(uniqueIdFromFile)) {
            this.firstRun = true;
            String generateUniquePsuedoID = generateUniquePsuedoID(context);
            this.uniqueID = generateUniquePsuedoID;
            writeInstallationFile(context, generateUniquePsuedoID);
        }
    }

    public void setFirstRun(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.firstRun = z;
        }
    }

    public void setSdkVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.sdkVersion = str;
        }
    }
}
