package com.baidu.idl.license;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.idl.util.HttpRequest;
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
    public static final int LICENSE_AG_ID = -1;
    public static final String LICENSE_DATA_DIR_NAME = "license";
    public static final String LICENSE_DEFAULT_FILE_NAME = "idl_license";
    public static final String TAG = "License";
    public static final String URL = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    public static final String URL_V1 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    public static final String URL_V2 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense_new.py";
    public static License mInstance;
    public ArrayList<String> mALLicense;
    public int mAuthorityStatus = 256;
    public int mLicenseAgId = -1;
    public String mLicenseFileName = "";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    private ArrayList<String> ReadLicenseFromAsset(Context context) {
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        ArrayList<String> arrayList = null;
        arrayList = null;
        arrayList = null;
        arrayList = null;
        ?? r1 = 0;
        try {
        } catch (Throwable th) {
            th = th;
            r1 = assets;
        }
        try {
            try {
                inputStream = getAssetsLicenseFileInputStream(assets);
                if (inputStream != null) {
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
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
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

    private ArrayList<String> ReadLicenseFromData(Context context) {
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

    private boolean WriteLicense(Context context, ArrayList<String> arrayList) {
        FileOutputStream fileOutputStream;
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

    private ArrayList<String> analyseLicense(InputStream inputStream) throws IOException {
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
        if (context != null && (dir = context.getDir(LICENSE_DATA_DIR_NAME, 0)) != null && dir.exists() && dir.isDirectory()) {
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
        String str = TAG;
        Log.e(str, "Get Assets License File" + this.mLicenseFileName);
        try {
            return assetManager.open(this.mLicenseFileName);
        } catch (IOException unused) {
            Log.e(TAG, "Get Assets License File Exception");
            return null;
        }
    }

    public static native String getAuthorityVersion();

    private File getDataLicenseFile(Context context) {
        File dir = context.getDir(LICENSE_DATA_DIR_NAME, 0);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        String str = dir.getAbsolutePath() + File.separator + this.mLicenseFileName;
        Log.e(TAG, "Get Data License File" + str);
        return new File(str);
    }

    public static synchronized License getInstance() {
        License license;
        synchronized (License.class) {
            if (mInstance == null) {
                mInstance = new License();
            }
            license = mInstance;
        }
        return license;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLatestLicense(Context context, String str) {
        ArrayList<String> licenseByNetwork = getLicenseByNetwork(context, str);
        if (licenseByNetwork == null || licenseByNetwork.size() <= 0 || initLicense(context, str, (String[]) licenseByNetwork.toArray(new String[licenseByNetwork.size()])) >= 48) {
            return;
        }
        Log.e(TAG, "Network Latest License Success.");
        WriteLicense(context, licenseByNetwork);
    }

    private ArrayList<String> getLicenseByNetwork(Context context, String str) {
        JSONObject jSONObject;
        ArrayList<String> arrayList;
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
            int i = -1;
            int optInt = jSONObject.optInt("errno", -1);
            jSONObject.optString("msg");
            JSONArray optJSONArray = jSONObject.optJSONArray(LICENSE_DATA_DIR_NAME);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                arrayList = null;
            } else {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString != null) {
                        arrayList2.add(optString);
                    }
                }
                i = optInt;
                arrayList = arrayList2;
            }
            if (i != 0 || optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            Log.e(TAG, "Network License Resopnse Is Right.");
            return arrayList;
        }
        return null;
    }

    private ArrayList<String> getLocalLicense(Context context) {
        ArrayList<String> ReadLicenseFromData = ReadLicenseFromData(context);
        return (ReadLicenseFromData == null || ReadLicenseFromData.size() < 1) ? ReadLicenseFromAsset(context) : ReadLicenseFromData;
    }

    private native String getPostData(Context context, String str);

    private native int initLicense(Context context, String str, String[] strArr);

    private native int initLicenseWithToken(String str);

    private int initWithApikey(Context context, String str) {
        int i = this.mAuthorityStatus;
        if (272 == i) {
            return i;
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

    private int verifyByLocalData(final Context context, final String str) {
        ArrayList<String> localLicense = getLocalLicense(context);
        this.mALLicense = localLicense;
        if (localLicense != null && localLicense.size() > 0) {
            ArrayList<String> arrayList = this.mALLicense;
            int initLicense = initLicense(context, str, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (initLicense == 0) {
                Log.e(TAG, "Local License Success");
                return initLicense;
            } else if (initLicense == 16) {
                new Thread(new Runnable() { // from class: com.baidu.idl.license.License.1
                    @Override // java.lang.Runnable
                    public void run() {
                        License.this.getLatestLicense(context, str);
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

    private int verifyByNetworkData(Context context, String str) {
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

    public native int getLicenseRemnant(int i);

    public native int getLicenseState(int i);

    public int getLicenseStateWithAlgorithmId(int i) {
        return getLicenseState(i);
    }

    @Deprecated
    public int init(Context context, String str) {
        Log.e(TAG, "License Init With ApiKey");
        this.mLicenseAgId = -1;
        this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
        int i = this.mAuthorityStatus;
        if (272 == i) {
            return i;
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

    @Deprecated
    public int init(String str) {
        Log.e(TAG, "License Init With Token");
        int i = this.mAuthorityStatus;
        if (272 == i) {
            return i;
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

    @Deprecated
    public int init(Context context, String str, int i, String str2) {
        Log.e(TAG, "License Init With ApiKey and AgId");
        this.mLicenseAgId = i;
        if (TextUtils.isEmpty(str2)) {
            this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
        } else {
            this.mLicenseFileName = str2;
        }
        return initWithApikey(context, str);
    }

    public int init(Context context, String str, String str2) {
        Log.e(TAG, "License Init With ApiKey and License File Name");
        if (TextUtils.isEmpty(str2)) {
            this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
        } else {
            this.mLicenseFileName = str2;
        }
        return initWithApikey(context, str);
    }
}
