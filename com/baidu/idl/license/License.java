package com.baidu.idl.license;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
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
/* loaded from: classes3.dex */
public class License {
    private static final int LICENSE_AG_ID = -1;
    private static final String LICENSE_DATA_DIR_NAME = "license";
    private static final String LICENSE_DEFAULT_FILE_NAME = "idl_license";
    private static final String URL = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    private static final String URL_V1 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    private static final String URL_V2 = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense_new.py";
    private ArrayList<String> mALLicense;
    private int mAuthorityStatus = 256;
    private int mLicenseAgId = -1;
    private String mLicenseFileName = "";
    public static final String TAG = License.class.getSimpleName();
    private static License mInstance = null;

    public static native String getAlgorithmVersion();

    public static native String getAuthorityVersion();

    private native String getPostData(Context context, String str);

    private native int initLicense(Context context, String str, String[] strArr);

    private native int initLicenseWithToken(String str);

    public native int getLicenseRemnant(int i);

    public native int getLicenseState(int i);

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

    private License() {
    }

    @Deprecated
    public int init(Context context, String str) {
        Log.e(TAG, "License Init With ApiKey");
        this.mLicenseAgId = -1;
        this.mLicenseFileName = LICENSE_DEFAULT_FILE_NAME;
        if (272 == this.mAuthorityStatus) {
            return this.mAuthorityStatus;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        this.mAuthorityStatus = verifyByLocalData(context, str);
        Log.e(TAG, "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        if (this.mAuthorityStatus > 48) {
            this.mAuthorityStatus = verifyByNetworkData(context, str);
            Log.e(TAG, "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        }
        if (this.mAuthorityStatus > 48) {
            Log.e(TAG, "Authority Exception :" + AuthorityState.getStateName(this.mAuthorityStatus));
        }
        return this.mAuthorityStatus;
    }

    @Deprecated
    public int init(String str) {
        Log.e(TAG, "License Init With Token");
        if (272 == this.mAuthorityStatus) {
            return this.mAuthorityStatus;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        if (str != null && str.length() > 0) {
            this.mAuthorityStatus = initLicenseWithToken(str);
            if (this.mAuthorityStatus != 0) {
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

    private int verifyByLocalData(final Context context, final String str) {
        int i = 49;
        this.mALLicense = getLocalLicense(context);
        if (this.mALLicense != null && this.mALLicense.size() > 0) {
            i = initLicense(context, str, (String[]) this.mALLicense.toArray(new String[this.mALLicense.size()]));
            if (i == 0) {
                Log.e(TAG, "Local License Success");
            } else if (i == 16) {
                new Thread(new Runnable() { // from class: com.baidu.idl.license.License.1
                    @Override // java.lang.Runnable
                    public void run() {
                        License.this.getLatestLicense(context, str);
                    }
                }).start();
            } else {
                deleteErrorLicense(context);
            }
        } else {
            Log.e(TAG, "Local License Is Null");
        }
        return i;
    }

    private int verifyByNetworkData(Context context, String str) {
        this.mALLicense = getLicenseByNetwork(context, str);
        if (this.mALLicense != null && this.mALLicense.size() > 0) {
            int initLicense = initLicense(context, str, (String[]) this.mALLicense.toArray(new String[this.mALLicense.size()]));
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

    private ArrayList<String> getLocalLicense(Context context) {
        ArrayList<String> ReadLicenseFromData = ReadLicenseFromData(context);
        if (ReadLicenseFromData == null || ReadLicenseFromData.size() < 1) {
            return ReadLicenseFromAsset(context);
        }
        return ReadLicenseFromData;
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
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
            jSONObject.optString("msg");
            JSONArray optJSONArray = jSONObject.optJSONArray(LICENSE_DATA_DIR_NAME);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                optInt = -1;
                arrayList = null;
            } else {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null) {
                        arrayList2.add(optString);
                    }
                }
                arrayList = arrayList2;
            }
            if (optInt != 0 || optJSONArray == null || optJSONArray.length() <= 0) {
                arrayList = null;
            } else {
                Log.e(TAG, "Network License Resopnse Is Right.");
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLatestLicense(Context context, String str) {
        ArrayList<String> licenseByNetwork = getLicenseByNetwork(context, str);
        if (licenseByNetwork != null && licenseByNetwork.size() > 0 && initLicense(context, str, (String[]) licenseByNetwork.toArray(new String[licenseByNetwork.size()])) < 48) {
            Log.e(TAG, "Network Latest License Success.");
            WriteLicense(context, licenseByNetwork);
        }
    }

    private ArrayList<String> ReadLicenseFromData(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return analyseLicense(new FileInputStream(getDataLicenseFile(context)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [327=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x000f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList<java.lang.String>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.idl.license.License] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<String> ReadLicenseFromAsset(Context context) {
        InputStream inputStream;
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            try {
                inputStream = getAssetsLicenseFileInputStream(context.getAssets());
                if (inputStream != null) {
                    try {
                        r2 = analyseLicense(inputStream);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (r2 != 0) {
                            WriteLicense(context, r2);
                        }
                        return r2;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        if (r2 != 0 && r2.size() > 0) {
            WriteLicense(context, r2);
        }
        return r2;
    }

    private ArrayList<String> analyseLicense(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine);
            } else {
                return arrayList;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [390=5, 392=4, 393=4, 395=4, 396=7] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0045 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v18, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v19, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v20, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean WriteLicense(Context context, ArrayList<String> arrayList) {
        FileOutputStream fileOutputStream;
        boolean z;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream4 = null;
        Iterator<String> it = null;
        FileOutputStream fileOutputStream5 = null;
        FileOutputStream fileOutputStream6 = null;
        try {
            try {
                Log.e(TAG, "Write License File " + dataLicenseFile.getAbsolutePath());
                fileOutputStream3 = new FileOutputStream(dataLicenseFile);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            it = arrayList.iterator();
            while (it.hasNext()) {
                fileOutputStream3.write(it.next().getBytes());
                fileOutputStream3.write(10);
            }
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                    z = true;
                    fileOutputStream4 = it;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    z = false;
                    fileOutputStream4 = it;
                }
            } else {
                z = true;
                fileOutputStream4 = it;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileOutputStream = fileOutputStream3;
            fileOutputStream5 = it;
            try {
                e.printStackTrace();
                fileOutputStream2 = fileOutputStream5;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        return false;
                    }
                }
                z = false;
                fileOutputStream4 = fileOutputStream2;
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream4 = fileOutputStream;
                if (fileOutputStream4 != null) {
                    try {
                        fileOutputStream4.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream6 = fileOutputStream3;
            e.printStackTrace();
            fileOutputStream2 = fileOutputStream6;
            if (fileOutputStream6 != null) {
                try {
                    fileOutputStream6.close();
                    z = false;
                    fileOutputStream4 = fileOutputStream6;
                } catch (IOException e9) {
                    e9.printStackTrace();
                    z = false;
                    fileOutputStream4 = fileOutputStream6;
                }
                return z;
            }
            z = false;
            fileOutputStream4 = fileOutputStream2;
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream4 = fileOutputStream3;
            if (fileOutputStream4 != null) {
            }
            throw th;
        }
        return z;
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

    private int initWithApikey(Context context, String str) {
        if (272 == this.mAuthorityStatus) {
            return this.mAuthorityStatus;
        }
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        this.mAuthorityStatus = verifyByLocalData(context, str);
        Log.e(TAG, "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        if (this.mAuthorityStatus > 48) {
            this.mAuthorityStatus = verifyByNetworkData(context, str);
            Log.e(TAG, "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        }
        if (this.mAuthorityStatus > 48) {
        }
        return this.mAuthorityStatus;
    }

    public int getLicenseStateWithAlgorithmId(int i) {
        return getLicenseState(i);
    }

    private File getDataLicenseFile(Context context) {
        File dir = context.getDir(LICENSE_DATA_DIR_NAME, 0);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        String str = dir.getAbsolutePath() + File.separator + this.mLicenseFileName;
        Log.e(TAG, "Get Data License File" + str);
        return new File(str);
    }

    private InputStream getAssetsLicenseFileInputStream(AssetManager assetManager) {
        Log.e(TAG, "Get Assets License File" + this.mLicenseFileName);
        try {
            return assetManager.open(this.mLicenseFileName);
        } catch (IOException e) {
            Log.e(TAG, "Get Assets License File Exception");
            return null;
        }
    }
}
