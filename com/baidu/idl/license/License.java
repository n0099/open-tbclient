package com.baidu.idl.license;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.idl.authority.IDLAuthorityException;
import com.baidu.idl.util.HttpClient;
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
    private static final int LICENSE_AG_ID = -1;
    private static final String LICENSE_ASSETS_FILE = "idl_license";
    private static final String LICENSE_ASSETS_MULTIPLE_FILE = "license/idl_license_%s";
    private static final String LICENSE_FILE = "license";
    private static final String LICENSE_LICENSE_FILE_NAME = "idl_license_%s";
    public static final String TAG = "IDL-License";
    private static final String URL = "http://sdkss.shitu.baidu.com/cgi-bin/queryLicense.py";
    private static License mInstance = null;
    private ArrayList<String> mALLicense;
    private int mAuthorityStatus = 256;
    private int mAlgorithmId = -1;
    private String mAlgorithmIdLicenseName = "";

    public static native String getAlgorithmVersion();

    public static native String getAuthorityVersion();

    public native long getLicenseRemnant(int i);

    public native int getLicenseState(int i);

    public native String getPostData(Context context, String str);

    public native int initLicense(Context context, String str, String[] strArr);

    public native int initLicenseWithToken(String str);

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
        this.mAlgorithmId = -1;
        this.mAlgorithmIdLicenseName = "";
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
            Log.e(TAG, "IDLAuthorityException :" + AuthorityState.getStateName(this.mAuthorityStatus));
        }
        return this.mAuthorityStatus;
    }

    public int init(String str) {
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

    private int verifyByLocalData(final Context context, final String str) {
        Log.e(TAG, "verifyByLocalData");
        int i = 49;
        this.mALLicense = getLocalLicense(context);
        if (this.mALLicense != null && this.mALLicense.size() > 0) {
            i = initLicense(context, str, (String[]) this.mALLicense.toArray(new String[this.mALLicense.size()]));
            if (i == 0) {
                Log.e(TAG, "license success.");
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
            Log.e(TAG, "my license is null");
        }
        return i;
    }

    private int verifyByNetworkData(Context context, String str) {
        Log.e(TAG, "verifyByNetworkData");
        this.mALLicense = getLicenseByNetwork(context, str);
        Log.e(TAG, "Net License:" + this.mALLicense);
        if (this.mALLicense != null && this.mALLicense.size() > 0) {
            int initLicense = initLicense(context, str, (String[]) this.mALLicense.toArray(new String[this.mALLicense.size()]));
            if (initLicense < 48) {
                WriteLicense(context, this.mALLicense);
                return initLicense;
            }
            return initLicense;
        }
        deleteErrorLicense(context);
        return 49;
    }

    private ArrayList<String> getLocalLicense(Context context) {
        Log.e(TAG, "getLocalLicense");
        ArrayList<String> ReadLicenseFromData = ReadLicenseFromData(context);
        if (ReadLicenseFromData == null || ReadLicenseFromData.size() < 1) {
            return ReadLicenseFromAsset(context);
        }
        return ReadLicenseFromData;
    }

    private ArrayList<String> getLicenseByNetwork(Context context, String str) {
        JSONObject jSONObject;
        ArrayList<String> arrayList;
        Log.e(TAG, "getLicenseByNetwork");
        String postData = getPostData(context, str);
        Log.e(TAG, "Network Request " + postData);
        String post = HttpClient.post(URL, postData);
        if (post != null && post.length() > 0) {
            Log.e(TAG, "Network Response " + post);
        }
        if (post == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(post);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("errno", -1);
            jSONObject.optString("msg");
            JSONArray optJSONArray = jSONObject.optJSONArray(LICENSE_FILE);
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
                Log.e(TAG, "resonpse is right.");
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLatestLicense(Context context, String str) {
        Log.e(TAG, "getLatestLicense");
        ArrayList<String> licenseByNetwork = getLicenseByNetwork(context, str);
        if (licenseByNetwork != null && licenseByNetwork.size() > 0 && initLicense(context, str, (String[]) licenseByNetwork.toArray(new String[licenseByNetwork.size()])) < 48) {
            WriteLicense(context, licenseByNetwork);
            Log.e(TAG, "LatestLicense " + licenseByNetwork);
        }
    }

    public ArrayList<String> ReadLicenseFromData(Context context) {
        if (context == null) {
            return null;
        }
        Log.e(TAG, "ReadLicenseFromData");
        File dataLicenseFile = getDataLicenseFile(context);
        if (dataLicenseFile != null) {
            Log.e(TAG, "ReadLicenseFromData file type " + dataLicenseFile.isDirectory() + dataLicenseFile.getAbsolutePath());
        }
        try {
            return analyseLicense(new FileInputStream(dataLicenseFile));
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [285=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x004b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<String> ReadLicenseFromAsset(Context context) {
        InputStream inputStream;
        ArrayList<String> arrayList = null;
        ?? r1 = "ReadLicenseFromAsset";
        Log.e(TAG, "ReadLicenseFromAsset");
        try {
            try {
                inputStream = getAssetsLicenseFileInputStream(context.getAssets());
                if (inputStream != null) {
                    try {
                        arrayList = analyseLicense(inputStream);
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
                        if (arrayList != null) {
                            WriteLicense(context, arrayList);
                        }
                        return arrayList;
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
                if (r1 != 0) {
                    try {
                        r1.close();
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
            r1 = 0;
            if (r1 != 0) {
            }
            throw th;
        }
        if (arrayList != null && arrayList.size() > 0) {
            WriteLicense(context, arrayList);
        }
        return arrayList;
    }

    private ArrayList<String> analyseLicense(InputStream inputStream) throws IOException {
        Log.e(TAG, "analyseLicense");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [352=5, 354=4, 355=4, 357=4, 358=7] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0091 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x004f */
    /* JADX DEBUG: Multi-variable search result rejected for r4v18, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v19, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v20, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean WriteLicense(Context context, ArrayList<String> arrayList) {
        FileOutputStream fileOutputStream;
        boolean z;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        if (arrayList == null || arrayList.size() == 0 || context == null) {
            return false;
        }
        Log.e(TAG, "WriteLicense");
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
                Log.e(TAG, "WriteLicense path " + dataLicenseFile.getAbsolutePath());
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

    public void deleteErrorLicense(Context context) {
        if (context != null) {
            Log.e(TAG, "deleteErrorLicense");
            File dir = context.getDir(LICENSE_FILE, 0);
            if (dir.exists()) {
                dir.delete();
            }
        }
    }

    public int init(Context context, String str, int i, String str2) {
        this.mAlgorithmId = i;
        this.mAlgorithmIdLicenseName = str2;
        return initWithAlgorithmId(context, str);
    }

    private int initWithAlgorithmId(Context context, String str) {
        if (272 == this.mAuthorityStatus) {
            return this.mAuthorityStatus;
        }
        Log.e(TAG, "initWithAlgorithmId");
        this.mAuthorityStatus = AuthorityState.STATE_INIT_ING;
        this.mAuthorityStatus = verifyByLocalData(context, str);
        Log.e(TAG, "Local License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        if (this.mAuthorityStatus > 48) {
            this.mAuthorityStatus = verifyByNetworkData(context, str);
            Log.e(TAG, "Net License Authority State Is :" + AuthorityState.getStateName(this.mAuthorityStatus));
        }
        if (this.mAuthorityStatus > 48) {
            throw new IDLAuthorityException(AuthorityState.getStateName(this.mAuthorityStatus));
        }
        return this.mAuthorityStatus;
    }

    public int getLicenseStateWithAlgorithmId(int i) {
        return getLicenseState(i);
    }

    private File getDataLicenseFile(Context context) {
        Log.e(TAG, "getDataLicenseFile");
        if (TextUtils.isEmpty(this.mAlgorithmIdLicenseName)) {
            return context.getDir(LICENSE_FILE, 0);
        }
        File dir = context.getDir(LICENSE_FILE, 0);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        return new File(dir.getAbsolutePath() + File.separator + String.format(LICENSE_LICENSE_FILE_NAME, this.mAlgorithmIdLicenseName));
    }

    private InputStream getAssetsLicenseFileInputStream(AssetManager assetManager) {
        Log.e(TAG, "getAssetsLicenseFileInputStream");
        InputStream inputStream = null;
        try {
            if (TextUtils.isEmpty(this.mAlgorithmIdLicenseName)) {
                inputStream = assetManager.open(LICENSE_ASSETS_FILE);
            } else {
                inputStream = assetManager.open(String.format(LICENSE_ASSETS_MULTIPLE_FILE, this.mAlgorithmIdLicenseName));
            }
        } catch (IOException e) {
            Log.e(TAG, "getLicenseFileInputStream error");
        }
        return inputStream;
    }
}
