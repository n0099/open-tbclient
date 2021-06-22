package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes2.dex */
public class Dev {
    public static final String INSTALLATION = "INSTALLATION";
    public String uniqueID = "";
    public String brand = "";
    public String sysVersion = "";
    public String packagename = "";
    public String sdkVersion = "2.1.0.0";
    public boolean firstRun = false;

    private String generateUniquePsuedoID(Context context) {
        String uuid;
        String str = EventType.GiftEventID.LOAD_ALL_GIFT_FAIL + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            uuid = Build.class.getField("SERIAL").get(null).toString();
        } catch (Exception unused) {
            uuid = UUID.randomUUID().toString();
        }
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if ("9774d56d682e549c".equals(string)) {
            string = UUID.randomUUID().toString();
        }
        return md5(uuid + string + str);
    }

    public static String md5(String str) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    private String readInstallationFile(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = 0;
        RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, r.f7715a);
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

    private void writeInstallationFile(Context context, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), INSTALLATION));
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (IOException e5) {
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
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            e = e8;
        } catch (IOException e9) {
            e = e9;
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public boolean getFirstRun() {
        return this.firstRun;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSysVersion() {
        return this.sysVersion;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public synchronized String getUniqueIdFromFile(Context context) {
        if (TextUtils.isEmpty(this.uniqueID)) {
            try {
                this.uniqueID = readInstallationFile(new File(context.getFilesDir(), INSTALLATION));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return this.uniqueID;
    }

    public void init(Context context) {
        if (context == null) {
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
        this.firstRun = z;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
