package com.baidu.idl.license;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.idl.util.HttpRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class License {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LICENSE_AG_ID = -1;
    public static final String LICENSE_DATA_DIR_NAME = "license";
    public static final String LICENSE_DEFAULT_FILE_NAME = "idl_license";
    public static final String TAG = "License";
    public static final String URL = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    public static final String URL_V1 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    public static final String URL_V2 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense_new.py";
    public static License mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> mALLicense;
    public int mAuthorityStatus;
    public int mLicenseAgId;
    public String mLicenseFileName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-312692236, "Lcom/baidu/idl/license/License;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-312692236, "Lcom/baidu/idl/license/License;");
        }
    }

    public License() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAuthorityStatus = 256;
        this.mLicenseAgId = -1;
        this.mLicenseFileName = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<String> ReadLicenseFromAsset(Context context) {
        InterceptResult invokeL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            ArrayList<String> arrayList = null;
            arrayList = null;
            arrayList = null;
            arrayList = null;
            InputStream inputStream2 = null;
            try {
                try {
                    inputStream = getAssetsLicenseFileInputStream(context.getAssets());
                    if (inputStream != null) {
                        try {
                            try {
                                arrayList = analyseLicense(inputStream);
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (arrayList != null) {
                                    WriteLicense(context, arrayList);
                                }
                                return arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (arrayList != null && arrayList.size() > 0) {
                WriteLicense(context, arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private ArrayList<String> ReadLicenseFromData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return analyseLicense(new FileInputStream(getDataLicenseFile(context)));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    private boolean WriteLicense(Context context, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, arrayList)) == null) {
            boolean z = false;
            if (arrayList == null || arrayList.size() == 0 || context == null) {
                return false;
            }
            File dataLicenseFile = getDataLicenseFile(context);
            if (dataLicenseFile != null) {
                dataLicenseFile.delete();
            }
            if (dataLicenseFile != null || !dataLicenseFile.exists()) {
                try {
                    dataLicenseFile.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        String str = TAG;
                        Log.e(str, "Write License File " + dataLicenseFile.getAbsolutePath());
                        fileOutputStream = new FileOutputStream(dataLicenseFile);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    fileOutputStream.write(it.next().getBytes());
                    fileOutputStream.write(10);
                }
                fileOutputStream.close();
                z = true;
            } catch (FileNotFoundException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z;
            } catch (IOException e7) {
                e = e7;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    private ArrayList<String> analyseLicense(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, inputStream)) != null) {
            return (ArrayList) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private void deleteErrorLicense(Context context) {
        File dir;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, context) == null) && context != null && (dir = context.getDir(LICENSE_DATA_DIR_NAME, 0)) != null && dir.exists() && dir.isDirectory()) {
            String str = dir.getAbsolutePath() + File.separator + this.mLicenseFileName;
            Log.e(TAG, "Delete Error License File " + str);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static native String getAlgorithmVersion();

    private InputStream getAssetsLicenseFileInputStream(AssetManager assetManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, assetManager)) == null) {
            String str = TAG;
            Log.e(str, "Get Assets License File" + this.mLicenseFileName);
            try {
                return assetManager.open(this.mLicenseFileName);
            } catch (IOException unused) {
                Log.e(TAG, "Get Assets License File Exception");
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public static native String getAuthorityVersion();

    private File getDataLicenseFile(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, context)) == null) {
            File dir = context.getDir(LICENSE_DATA_DIR_NAME, 0);
            if (!dir.exists() || !dir.isDirectory()) {
                dir.mkdirs();
            }
            String str = dir.getAbsolutePath() + File.separator + this.mLicenseFileName;
            Log.e(TAG, "Get Data License File" + str);
            return new File(str);
        }
        return (File) invokeL.objValue;
    }

    public static synchronized License getInstance() {
        InterceptResult invokeV;
        License license;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (License.class) {
                if (mInstance == null) {
                    mInstance = new License();
                }
                license = mInstance;
            }
            return license;
        }
        return (License) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLatestLicense(Context context, String str) {
        ArrayList<String> licenseByNetwork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, this, context, str) == null) || (licenseByNetwork = getLicenseByNetwork(context, str)) == null || licenseByNetwork.size() <= 0 || initLicense(context, str, (String[]) licenseByNetwork.toArray(new String[licenseByNetwork.size()])) >= 48) {
            return;
        }
        Log.e(TAG, "Network Latest License Success.");
        WriteLicense(context, licenseByNetwork);
    }

    private ArrayList<String> getLicenseByNetwork(Context context, String str) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, context, str)) == null) {
            String request = HttpRequest.request("http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py", getPostData(context, str));
            if (request == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(request);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                int i2 = -1;
                int optInt = jSONObject.optInt("errno", -1);
                jSONObject.optString("msg");
                JSONArray optJSONArray = jSONObject.optJSONArray(LICENSE_DATA_DIR_NAME);
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    arrayList = null;
                } else {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (optString != null) {
                            arrayList2.add(optString);
                        }
                    }
                    i2 = optInt;
                    arrayList = arrayList2;
                }
                if (i2 != 0 || optJSONArray == null || optJSONArray.length() <= 0) {
                    return null;
                }
                Log.e(TAG, "Network License Resopnse Is Right.");
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeLL.objValue;
    }

    private ArrayList<String> getLocalLicense(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, context)) == null) {
            ArrayList<String> ReadLicenseFromData = ReadLicenseFromData(context);
            return (ReadLicenseFromData == null || ReadLicenseFromData.size() < 1) ? ReadLicenseFromAsset(context) : ReadLicenseFromData;
        }
        return (ArrayList) invokeL.objValue;
    }

    private native String getPostData(Context context, String str);

    private native int initLicense(Context context, String str, String[] strArr);

    private native int initLicenseWithToken(String str);

    private int initWithApikey(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, this, context, str)) == null) {
            int i2 = this.mAuthorityStatus;
            if (272 == i2) {
                return i2;
            }
            this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
            this.mAuthorityStatus = verifyByLocalData(context, str);
            String str2 = TAG;
            Log.e(str2, "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
            if (this.mAuthorityStatus > 48) {
                this.mAuthorityStatus = verifyByNetworkData(context, str);
                String str3 = TAG;
                Log.e(str3, "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
            }
            return this.mAuthorityStatus;
        }
        return invokeLL.intValue;
    }

    private int verifyByLocalData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, context, str)) == null) {
            ArrayList<String> localLicense = getLocalLicense(context);
            this.mALLicense = localLicense;
            if (localLicense != null && localLicense.size() > 0) {
                ArrayList<String> arrayList = this.mALLicense;
                int initLicense = initLicense(context, str, (String[]) arrayList.toArray(new String[arrayList.size()]));
                if (initLicense == 0) {
                    Log.e(TAG, "Local License Success");
                    return initLicense;
                } else if (initLicense == 16) {
                    new Thread(new Runnable(this, context, str) { // from class: com.baidu.idl.license.License.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ License this$0;
                        public final /* synthetic */ String val$apiKey;
                        public final /* synthetic */ Context val$context;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$context = context;
                            this.val$apiKey = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.getLatestLicense(this.val$context, this.val$apiKey);
                            }
                        }
                    }).start();
                    return initLicense;
                } else {
                    deleteErrorLicense(context);
                    return initLicense;
                }
            }
            Log.e(TAG, "Local License Is Null");
            return 49;
        }
        return invokeLL.intValue;
    }

    private int verifyByNetworkData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, this, context, str)) == null) {
            ArrayList<String> licenseByNetwork = getLicenseByNetwork(context, str);
            this.mALLicense = licenseByNetwork;
            if (licenseByNetwork != null && licenseByNetwork.size() > 0) {
                ArrayList<String> arrayList = this.mALLicense;
                int initLicense = initLicense(context, str, (String[]) arrayList.toArray(new String[arrayList.size()]));
                if (initLicense < 48) {
                    Log.e(TAG, "Network License Success.");
                    WriteLicense(context, this.mALLicense);
                    return initLicense;
                }
                return initLicense;
            }
            deleteErrorLicense(context);
            return 49;
        }
        return invokeLL.intValue;
    }

    public native int getLicenseRemnant(int i2);

    public native int getLicenseState(int i2);

    public int getLicenseStateWithAlgorithmId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? getLicenseState(i2) : invokeI.intValue;
    }

    @Deprecated
    public int init(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            Log.e(TAG, "License Init With ApiKey");
            this.mLicenseAgId = -1;
            this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
            int i2 = this.mAuthorityStatus;
            if (272 == i2) {
                return i2;
            }
            this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
            this.mAuthorityStatus = verifyByLocalData(context, str);
            String str2 = TAG;
            Log.e(str2, "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
            if (this.mAuthorityStatus > 48) {
                this.mAuthorityStatus = verifyByNetworkData(context, str);
                String str3 = TAG;
                Log.e(str3, "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
            }
            if (this.mAuthorityStatus > 48) {
                String str4 = TAG;
                Log.e(str4, "Authority Exception :" + AuthorityState.getStateName(this.mAuthorityStatus));
            }
            return this.mAuthorityStatus;
        }
        return invokeLL.intValue;
    }

    @Deprecated
    public int init(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Log.e(TAG, "License Init With Token");
            int i2 = this.mAuthorityStatus;
            if (272 == i2) {
                return i2;
            }
            this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
            if (str != null && str.length() > 0) {
                int initLicenseWithToken = initLicenseWithToken(str);
                this.mAuthorityStatus = initLicenseWithToken;
                if (initLicenseWithToken != 0) {
                    this.mAuthorityStatus = 51;
                }
            } else {
                this.mAuthorityStatus = 51;
            }
            return this.mAuthorityStatus;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public int init(Context context, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048580, this, context, str, i2, str2)) == null) {
            Log.e(TAG, "License Init With ApiKey and AgId");
            this.mLicenseAgId = i2;
            if (TextUtils.isEmpty(str2)) {
                this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
            } else {
                this.mLicenseFileName = str2;
            }
            return initWithApikey(context, str);
        }
        return invokeLLIL.intValue;
    }

    public int init(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, str, str2)) == null) {
            Log.e(TAG, "License Init With ApiKey and License File Name");
            if (TextUtils.isEmpty(str2)) {
                this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
            } else {
                this.mLicenseFileName = str2;
            }
            return initWithApikey(context, str);
        }
        return invokeLLL.intValue;
    }
}
