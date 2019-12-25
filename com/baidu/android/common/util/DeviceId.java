package com.baidu.android.common.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.security.SHA1Util;
import com.baidu.fsg.face.base.b.c;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final boolean CONFIG_WRITE_V1_STORAGE = false;
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_FLAG = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final int S_IRGRP = 32;
    private static final int S_IROTH = 4;
    private static final int S_IRUSR = 256;
    private static final int S_IRWXG = 56;
    private static final int S_IRWXO = 7;
    private static final int S_IRWXU = 448;
    private static final int S_IWGRP = 16;
    private static final int S_IWOTH = 2;
    private static final int S_IWUSR = 128;
    private static final int S_IXGRP = 8;
    private static final int S_IXOTH = 1;
    private static final int S_IXUSR = 64;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo = null;
    private static final String sDEncoded = "ZGV2aWNlaWQ=";
    private static boolean sDataCuidInfoShable = true;
    private static final String sIEncoded = "aW1laQ==";
    private static final String sVEncoded = "dmVy";
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    private DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str.toLowerCase();
    }

    public static void setCuidDataShable(Context context, boolean z) {
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        Context applicationContext = context.getApplicationContext();
        if (file.exists()) {
            if (sCachedCuidInfo == null) {
                tryToModifyChmodForSelfFile(applicationContext, z);
            } else if (sDataCuidInfoShable != z) {
                tryToModifyChmodForSelfFile(applicationContext, z);
            }
        }
        sDataCuidInfoShable = z;
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = byte2hex(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [234=4] */
    private void initPublicKey() {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(CuidCertStore.getCertBytes());
        } catch (Exception e) {
            byteArrayInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.mPublicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e2) {
                    handleThrowable(e2);
                }
            }
        } catch (Exception e3) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e4) {
                    handleThrowable(e4);
                }
            }
        } catch (Throwable th2) {
            byteArrayInputStream2 = byteArrayInputStream;
            th = th2;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception e5) {
                    handleThrowable(e5);
                }
            }
            throw th;
        }
    }

    private List<CUIDBuddyInfo> collectBuddyInfos(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString(META_KEY_GLAXY_DATA);
                            if (!TextUtils.isEmpty(string)) {
                                byte[] decode = Base64.decode(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(decode));
                                CUIDBuddyInfo cUIDBuddyInfo = new CUIDBuddyInfo();
                                cUIDBuddyInfo.priority = jSONObject.getInt("priority");
                                cUIDBuddyInfo.appInfo = resolveInfo.activityInfo.applicationInfo;
                                if (this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cUIDBuddyInfo.isSelf = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString(META_KEY_GALAXY_SF);
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (isSigsEqual(strArr, formatAndroidSigArray(packageInfo.signatures))) {
                                            byte[] decryptByPublicKey = decryptByPublicKey(Base64.decode(string2.getBytes()), this.mPublicKey);
                                            if (decryptByPublicKey != null && Arrays.equals(decryptByPublicKey, SHA1Util.sha1(decode))) {
                                                cUIDBuddyInfo.sigMatched = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cUIDBuddyInfo);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<CUIDBuddyInfo>() { // from class: com.baidu.android.common.util.DeviceId.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(CUIDBuddyInfo cUIDBuddyInfo2, CUIDBuddyInfo cUIDBuddyInfo3) {
                int i2 = cUIDBuddyInfo3.priority - cUIDBuddyInfo2.priority;
                if (i2 == 0) {
                    if (cUIDBuddyInfo2.isSelf && cUIDBuddyInfo3.isSelf) {
                        return 0;
                    }
                    if (cUIDBuddyInfo2.isSelf) {
                        return -1;
                    }
                    if (cUIDBuddyInfo3.isSelf) {
                        return 1;
                    }
                    return i2;
                }
                return i2;
            }
        });
        return arrayList;
    }

    private boolean isSigsEqual(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [429=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean writeToCuidFile(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream openFileOutput;
        FileOutputStream fileOutputStream2 = null;
        int i = sDataCuidInfoShable ? Build.VERSION.SDK_INT >= 24 ? 0 : 1 : 0;
        try {
            try {
                openFileOutput = this.mContext.openFileOutput(SELF_CUID_FILE, i);
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        handleThrowable(e);
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        }
        try {
            openFileOutput.write(str.getBytes());
            openFileOutput.flush();
            if (openFileOutput != null) {
                try {
                    openFileOutput.close();
                } catch (Exception e3) {
                    handleThrowable(e3);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (i == 0 && sDataCuidInfoShable) {
                    return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 436);
                }
                if (sDataCuidInfoShable) {
                    return true;
                }
                return TargetApiSupport.doChmodSafely(new File(this.mContext.getFilesDir(), SELF_CUID_FILE).getAbsolutePath(), 432);
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = openFileOutput;
            try {
                handleThrowable(e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        handleThrowable(e5);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean tryToModifyChmodForSelfFile(Context context, boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        File file = new File(context.getApplicationContext().getFilesDir(), SELF_CUID_FILE);
        if (file.exists()) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (z) {
                        z3 = file.setReadable(true, false);
                    } else {
                        boolean readable = file.setReadable(false, false);
                        boolean readable2 = file.setReadable(true, true);
                        if (!readable || !readable2) {
                            z2 = false;
                        }
                        z3 = z2;
                    }
                    return z3;
                } catch (Exception e) {
                    handleThrowable(e);
                    return z3;
                }
            }
            return TargetApiSupport.doChmodSafely(file.getAbsolutePath(), z ? 436 : 432);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TargetApiSupport {
        TargetApiSupport() {
        }

        static boolean doChmodSafely(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                DeviceId.handleThrowable(e);
                return false;
            } catch (Exception e2) {
                DeviceId.handleThrowable(e2);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSystemSettingValue(String str) {
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), str);
        } catch (Exception e) {
            handleThrowable(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return Settings.System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Exception e) {
            handleThrowable(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleThrowable(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CUIDInfo {
        public static final String I_EMPTY = "0";
        public static final String I_FIXED = "O";
        public static final int PROTOCAL_MAX_LENGTH = 14;
        private static final int VERSION_DEF = 2;
        public String deviceId;
        public String flag;
        public int oldValueLength;
        public int version;

        private CUIDInfo() {
            this.version = 2;
            this.oldValueLength = 0;
        }

        public boolean isIENull() {
            return isIENull(this.flag);
        }

        public boolean isIENormal() {
            return isIENormal(this.oldValueLength);
        }

        public static boolean isIENull(String str) {
            return TextUtils.isEmpty(str);
        }

        public static boolean isIENormal(int i) {
            return i >= 14;
        }

        public static CUIDInfo createFromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!DeviceId.getBase64DecodeStr(DeviceId.sDEncoded).equals(next) && !DeviceId.getBase64DecodeStr(DeviceId.sVEncoded).equals(next)) {
                        str2 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded));
                int i = jSONObject.getInt(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded));
                int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
                if (!TextUtils.isEmpty(string)) {
                    CUIDInfo cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = string;
                    cUIDInfo.version = i;
                    cUIDInfo.oldValueLength = length;
                    if (cUIDInfo.oldValueLength < 14) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "0";
                        }
                        cUIDInfo.flag = str2;
                        return cUIDInfo;
                    }
                    return cUIDInfo;
                }
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CUIDInfo createCuidInfoFromV1Cache(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                CUIDInfo cUIDInfo = new CUIDInfo();
                cUIDInfo.deviceId = str;
                cUIDInfo.oldValueLength = TextUtils.isEmpty(str2) ? 0 : str2.length();
                if (cUIDInfo.oldValueLength < 14) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    cUIDInfo.flag = str2;
                }
                return cUIDInfo;
            }
            return null;
        }

        public String toPersitString() {
            try {
                return new JSONObject().put(DeviceId.getBase64DecodeStr(DeviceId.sDEncoded), this.deviceId).put(DeviceId.getBase64DecodeStr(DeviceId.sIEncoded), this.flag).put(DeviceId.getBase64DecodeStr(DeviceId.sVEncoded), this.version).toString();
            } catch (JSONException e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }

        public String getFinalCUID() {
            String str = this.flag;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.deviceId + "|" + str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [778=5, 780=4, 781=4, 782=4] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void writeToFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            handleThrowable(e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            handleThrowable(e3);
                        }
                    }
                } catch (SecurityException e4) {
                    e = e4;
                    handleThrowable(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            handleThrowable(e5);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        handleThrowable(e6);
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            fileOutputStream = null;
        } catch (SecurityException e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [814=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileContent(File file) {
        Throwable th;
        FileReader fileReader;
        String str = 0;
        str = 0;
        str = 0;
        try {
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
                    str = charArrayWriter2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            str = charArrayWriter2;
                        } catch (Exception e) {
                            handleThrowable(e);
                            str = charArrayWriter2;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    handleThrowable(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                            handleThrowable(e3);
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (Exception e4) {
                        handleThrowable(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CUIDInfo.class) {
                if (sCachedCuidInfo == null) {
                    SystemClock.uptimeMillis();
                    sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return sCachedCuidInfo;
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    private static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    private CUIDInfo getCUIDInfo() {
        boolean z;
        CUIDInfo cUIDInfo;
        CUIDInfo cUIDInfo2;
        String str;
        CUIDInfo cUIDInfo3;
        String str2;
        String str3;
        boolean z2 = false;
        List<CUIDBuddyInfo> collectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        if (collectBuddyInfos == null || collectBuddyInfos.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w(TAG, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            CUIDBuddyInfo cUIDBuddyInfo = collectBuddyInfos.get(0);
            boolean z3 = cUIDBuddyInfo.sigMatched;
            if (!cUIDBuddyInfo.sigMatched) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w(TAG, "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z3;
        }
        File file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        CUIDInfo createFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
        if (createFromJson == null) {
            this.mSaveMask |= 16;
            List<CUIDBuddyInfo> collectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
            if (collectBuddyInfos2 != null) {
                File filesDir = this.mContext.getFilesDir();
                if (c.g.equals(filesDir.getName())) {
                    str3 = c.g;
                } else {
                    Log.e(TAG, "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str3 = filesDir.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo2 : collectBuddyInfos2) {
                    if (!cUIDBuddyInfo2.isSelf) {
                        File file2 = new File(new File(cUIDBuddyInfo2.appInfo.dataDir, str3), SELF_CUID_FILE);
                        if (file2.exists()) {
                            cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)));
                            if (cUIDInfo != null) {
                                break;
                            }
                        } else {
                            cUIDInfo = createFromJson;
                        }
                        createFromJson = cUIDInfo;
                    }
                }
            }
        }
        cUIDInfo = createFromJson;
        if (cUIDInfo == null) {
            cUIDInfo = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        boolean checkSelfPermission = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        if (cUIDInfo == null && checkSelfPermission) {
            this.mSaveMask |= 2;
            cUIDInfo2 = getCuidInfoFromExternalV2();
        } else {
            cUIDInfo2 = cUIDInfo;
        }
        if (cUIDInfo2 == null) {
            this.mSaveMask |= 8;
            cUIDInfo2 = getCUidInfoFromSystemSettingV1();
        }
        if (cUIDInfo2 == null && checkSelfPermission) {
            this.mSaveMask |= 1;
            str = getDefaultFlag("");
            cUIDInfo2 = getExternalV1DeviceId(str);
            z2 = true;
        } else {
            str = null;
        }
        if (cUIDInfo2 == null) {
            this.mSaveMask |= 4;
            if (!z2) {
                str = getDefaultFlag("");
            }
            CUIDInfo cUIDInfo4 = new CUIDInfo();
            String androidId = getAndroidId(this.mContext);
            if (Build.VERSION.SDK_INT < 23) {
                str2 = str + androidId + UUID.randomUUID().toString();
            } else {
                str2 = "com.baidu" + androidId;
            }
            cUIDInfo4.deviceId = MD5Util.toMd5(str2.getBytes(), true);
            cUIDInfo4.flag = str;
            cUIDInfo3 = cUIDInfo4;
        } else {
            cUIDInfo3 = cUIDInfo2;
        }
        fixCUIDInfoByIE(cUIDInfo3);
        writeJobThread(cUIDInfo3);
        return cUIDInfo3;
    }

    private synchronized void writeJobThread(CUIDInfo cUIDInfo) {
        new Thread(getWriteRunnable(cUIDInfo)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fixCUIDInfoByIE(CUIDInfo cUIDInfo) {
        if (cUIDInfo.isIENormal()) {
            cUIDInfo.flag = CUIDInfo.I_FIXED;
            return true;
        } else if (cUIDInfo.isIENull()) {
            cUIDInfo.flag = "0";
            return true;
        } else {
            return false;
        }
    }

    private Runnable getWriteRunnable(final CUIDInfo cUIDInfo) {
        return new Runnable() { // from class: com.baidu.android.common.util.DeviceId.2
            @Override // java.lang.Runnable
            public void run() {
                CUIDInfo cUIDInfo2 = new CUIDInfo();
                cUIDInfo2.flag = cUIDInfo.flag;
                cUIDInfo2.deviceId = cUIDInfo.deviceId;
                File file = new File(DeviceId.this.mContext.getFilesDir(), DeviceId.SELF_CUID_FILE);
                String encryptCUIDInfo = DeviceId.encryptCUIDInfo(cUIDInfo2.toPersitString());
                if (!file.exists()) {
                    DeviceId.this.writeToCuidFile(encryptCUIDInfo);
                } else {
                    CUIDInfo createFromJson = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(DeviceId.getFileContent(file)));
                    if (createFromJson != null) {
                        if (DeviceId.this.fixCUIDInfoByIE(createFromJson)) {
                            DeviceId.this.writeToCuidFile(DeviceId.encryptCUIDInfo(createFromJson.toPersitString()));
                        }
                    } else if (createFromJson == null) {
                        DeviceId.this.writeToCuidFile(encryptCUIDInfo);
                    }
                }
                boolean hasWriteSettingsPermission = DeviceId.this.hasWriteSettingsPermission();
                if (hasWriteSettingsPermission) {
                    String systemSettingValue = DeviceId.this.getSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2);
                    if (TextUtils.isEmpty(systemSettingValue)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, encryptCUIDInfo);
                    } else {
                        CUIDInfo createFromJson2 = CUIDInfo.createFromJson(DeviceId.decryptCUIDInfo(systemSettingValue));
                        if (createFromJson2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(createFromJson2)) {
                                DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, DeviceId.encryptCUIDInfo(createFromJson2.toPersitString()));
                            }
                        } else if (createFromJson2 == null) {
                            DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_DEVICE_ID_V2, encryptCUIDInfo);
                        }
                    }
                }
                boolean checkSelfPermission = DeviceId.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                if (checkSelfPermission) {
                    if (!new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        DeviceId.setExternalV2DeviceId(encryptCUIDInfo);
                    } else {
                        CUIDInfo cuidInfoFromExternalV2 = DeviceId.this.getCuidInfoFromExternalV2();
                        if (cuidInfoFromExternalV2 != null) {
                            if (DeviceId.this.fixCUIDInfoByIE(cuidInfoFromExternalV2)) {
                                DeviceId.setExternalV2DeviceId(DeviceId.encryptCUIDInfo(cuidInfoFromExternalV2.toPersitString()));
                            }
                        } else if (cuidInfoFromExternalV2 == null) {
                            DeviceId.setExternalV2DeviceId(encryptCUIDInfo);
                        }
                    }
                }
                if (hasWriteSettingsPermission) {
                    String systemSettingValue2 = DeviceId.this.getSystemSettingValue(DeviceId.KEY_FLAG);
                    if (CUIDInfo.isIENormal(TextUtils.isEmpty(systemSettingValue2) ? 0 : systemSettingValue2.length())) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, CUIDInfo.I_FIXED);
                    } else if (CUIDInfo.isIENull(systemSettingValue2)) {
                        DeviceId.this.tryPutSystemSettingValue(DeviceId.KEY_FLAG, "0");
                    }
                }
                if (checkSelfPermission && new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists()) {
                    CUIDInfo externalV1DeviceId = DeviceId.this.getExternalV1DeviceId(DeviceId.this.getDefaultFlag(""));
                    if (externalV1DeviceId != null) {
                        if (DeviceId.this.fixCUIDInfoByIE(externalV1DeviceId)) {
                            DeviceId.setExternalDeviceId(externalV1DeviceId.flag, externalV1DeviceId.deviceId);
                            return;
                        }
                        return;
                    }
                    if (externalV1DeviceId == null) {
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        return CUIDInfo.createCuidInfoFromV1Cache(getSystemSettingValue(KEY_DEVICE_ID), getSystemSettingValue(KEY_FLAG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getCuidInfoFromExternalV2() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String fileContent = getFileContent(file);
            if (!TextUtils.isEmpty(fileContent)) {
                try {
                    return CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(fileContent.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CUIDInfo getExternalV1DeviceId(String str) {
        String str2 = "";
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(sb.toString().getBytes()))).split(ETAG.EQUAL);
            if (split != null && split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
        return CUIDInfo.createCuidInfoFromV1Cache(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            handleThrowable(e);
            return "";
        } catch (Exception e2) {
            handleThrowable(e2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            handleThrowable(e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalV2DeviceId(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
        File file3 = new File(file2, EXT_FILE_V2);
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setExternalDeviceId(String str, String str2) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(Environment.getExternalStorageDirectory(), EXT_DIR);
            File file3 = new File(file2, EXT_FILE);
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        file = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                fileWriter.write(Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, (str + ETAG.EQUAL + str2).getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDefaultFlag(String str) {
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBase64DecodeStr(String str) {
        return new String(Base64.decode(str.getBytes()));
    }
}
