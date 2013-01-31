package com.baidu.browser.bbm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.baidu.browser.core.BdPath;
import com.baidu.browser.core.util.BdLog;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.zeus.PlumCore;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BdBBM {
    private static BdBBM mInstance;
    private Context mContext;
    private String mImeiCryptoString;
    private String mImeiString;
    private String mTNNumber;

    public static synchronized BdBBM initBdBBM(Context context) {
        BdBBM bdBBM;
        synchronized (BdBBM.class) {
            if (mInstance == null) {
                mInstance = new BdBBM();
                mInstance.mContext = context;
            }
            bdBBM = mInstance;
        }
        return bdBBM;
    }

    public static String getIMEINumber() {
        if (mInstance.mImeiString == null) {
            mInstance.mImeiString = ((TelephonyManager) mInstance.mContext.getSystemService("phone")).getDeviceId();
        }
        if (mInstance.mImeiString == null) {
            WifiInfo connectionInfo = ((WifiManager) mInstance.mContext.getSystemService("wifi")).getConnectionInfo();
            mInstance.mImeiString = connectionInfo.getMacAddress();
            mInstance.mImeiString = mInstance.mImeiString.replaceAll(":", "").replaceAll("-", "");
        }
        if (mInstance.mImeiString == null) {
            mInstance.mImeiString = mInstance.readImeiFromSDCard();
            if (mInstance.mImeiString != null) {
                if (mInstance.readImeiFromBBMFile() == null) {
                    mInstance.saveImei2BBMFile(mInstance.mImeiString);
                }
                return mInstance.mImeiString;
            }
            mInstance.mImeiString = mInstance.readImeiFromBBMFile();
            if (mInstance.mImeiString != null) {
                mInstance.saveImei2SDCard(mInstance.mImeiString);
                return mInstance.mImeiString;
            }
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                stringBuffer.append(random.nextInt(10));
            }
            mInstance.mImeiString = stringBuffer.toString();
            if (mInstance.mImeiString != null) {
                mInstance.saveImei2SDCard(mInstance.mImeiString);
                mInstance.saveImei2BBMFile(mInstance.mImeiString);
            }
        }
        return mInstance.mImeiString;
    }

    public static String getIMEICryptoString() {
        return mInstance.mImeiCryptoString;
    }

    public static String appendIMEIBBMInfo() {
        String reverseString = BdUtil.reverseString(getIMEINumber());
        getIMEICryptoString();
        return reverseString;
    }

    private static String readTNFromApk() {
        String str;
        try {
            InputStream openRawResource = mInstance.mContext.getResources().openRawResource(mInstance.mContext.getResources().getIdentifier("browser_tnconfig", "raw", mInstance.mContext.getPackageName()));
            if (openRawResource != null) {
                byte[] bArr = new byte[openRawResource.available()];
                if (openRawResource.read(bArr) > 0) {
                    str = Pattern.compile("\\s*|\t|\r|\n").matcher(new String(bArr)).replaceAll("");
                    openRawResource.close();
                } else {
                    openRawResource.close();
                    str = "1200a";
                }
            } else {
                str = "1200a";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "1200a";
        }
    }

    private void clearFrameUpdateMark2SP() {
        SharedPreferences preferences;
        if ((this.mContext instanceof Activity) && (preferences = ((Activity) this.mContext).getPreferences(0)) != null) {
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("updateBySelf", false);
            edit.commit();
        }
    }

    private boolean isFrameUpdateMark2SP() {
        boolean z;
        if (this.mContext instanceof Activity) {
            SharedPreferences preferences = ((Activity) this.mContext).getPreferences(0);
            if (preferences == null) {
                return false;
            }
            z = preferences.getBoolean("updateBySelf", false);
            clearFrameUpdateMark2SP();
        } else {
            z = false;
        }
        return z;
    }

    private boolean isUpdateApkFileExist() {
        String str;
        File[] listFiles;
        String path = Environment.getExternalStorageDirectory().getPath();
        if (path != null && !path.equals("")) {
            if (path.endsWith("/")) {
                str = String.valueOf(path) + "baidu/flyflow/";
            } else {
                str = String.valueOf(path) + "/baidu/flyflow/";
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().toLowerCase().startsWith("baidumb")) {
                        BdLog.w("zd file detected");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void setTN4Rulers() {
    }

    public static String getTNNumber() {
        SharedPreferences defaultSharedPreferences;
        String string;
        if (mInstance.mTNNumber == null) {
            mInstance.mTNNumber = mInstance.readTNFromSDCard();
            if (mInstance.mTNNumber != null) {
                if (mInstance.readTNFromBBMFile() == null) {
                    mInstance.saveTN2BBMFile(mInstance.mTNNumber);
                }
            } else {
                mInstance.mTNNumber = mInstance.readTNFromBBMFile();
                if (mInstance.mTNNumber != null) {
                    mInstance.saveTN2SDCard(mInstance.mTNNumber);
                }
            }
            if (mInstance.mTNNumber == null && (string = (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mInstance.mContext)).getString("tn", null)) != null && !string.equals("")) {
                mInstance.mTNNumber = string;
                String readTNFromApk = readTNFromApk();
                if (readTNFromApk != null && readTNFromApk.equals("1200a")) {
                    if (mInstance.isUpdateApkFileExist()) {
                        mInstance.mTNNumber = string;
                    } else {
                        mInstance.mTNNumber = readTNFromApk;
                    }
                } else {
                    mInstance.mTNNumber = readTNFromApk;
                }
                mInstance.saveTN2BBMFile(mInstance.mTNNumber);
                mInstance.saveTN2SDCard(mInstance.mTNNumber);
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putString("tn", "");
                edit.commit();
                return mInstance.mTNNumber;
            }
            mInstance.setTN4Rulers();
        }
        if (mInstance.mTNNumber == null) {
            mInstance.mTNNumber = readTNFromApk();
            mInstance.saveTN2BBMFile(mInstance.mTNNumber);
            mInstance.saveTN2SDCard(mInstance.mTNNumber);
        }
        return mInstance.mTNNumber;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0043 */
    public static String getTNEncoder() {
        String tNNumber = getTNNumber();
        if (tNNumber == null || tNNumber.length() == 0) {
            return "";
        }
        char[] charArray = tNNumber.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            int i = c;
            i = c;
            if (c > '@' && c < '[') {
                int i2 = c + '\f';
                i = i2;
                if (i2 >= 91) {
                    i = (i2 - 91) + 65;
                }
            }
            if (i > 47 && i < 58 && (i = i + 5) >= 58) {
                i = (i - 58) + 48;
            }
            sb.insert(0, (char) i);
        }
        return sb.toString();
    }

    private byte[] PlIdeaEncoderWraper(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        byteArrayOutputStream.write(length & 255);
        byteArrayOutputStream.write((length >> 8) & 255);
        byteArrayOutputStream.write((length >> 16) & 255);
        byteArrayOutputStream.write((length >> 24) & 255);
        for (int i = 1; i <= 16; i++) {
            try {
                byteArrayOutputStream.write(3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.write(bArr);
        for (int i2 = 0; i2 < 7; i2++) {
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    boolean isSDCardMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private String makesureSDCardDirExist() {
        String path;
        String str;
        if (!isSDCardMounted()) {
            return null;
        }
        if (Environment.getExternalStorageDirectory().getPath().endsWith("/")) {
            str = String.valueOf(path) + BdBBMConfig.DIR_NAME_OF_BBM_EXTERNAL;
        } else {
            str = String.valueOf(path) + "/" + BdBBMConfig.DIR_NAME_OF_BBM_EXTERNAL;
        }
        File file = new File(str);
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
            return str;
        }
        return str;
    }

    private String readImeiFromSDCard() {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflyflowR");
            if (file.isDirectory()) {
                file.delete();
                return null;
            }
            return BdBBMUtils.readLineFromFile(file);
        }
        return null;
    }

    private String readImeiFromBBMFile() {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflyflowR");
        if (file.isDirectory()) {
            file.delete();
            return null;
        }
        return BdBBMUtils.readLineFromFile(file);
    }

    private boolean saveImei2SDCard(String str) {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflyflowR");
            if (file.isDirectory()) {
                file.delete();
            }
            return BdBBMUtils.saveString2File(file, str);
        }
        return false;
    }

    private boolean saveImei2BBMFile(String str) {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflyflowR");
        if (file.isDirectory()) {
            file.delete();
        }
        return BdBBMUtils.saveString2File(file, str);
    }

    private String readImeiCryptoFromSDCard() {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflyflow");
            if (file.isDirectory()) {
                file.delete();
                return null;
            }
            return BdBBMUtils.readLineFromFile(file);
        }
        return null;
    }

    private String readImeiCryptoFromBBMFile() {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflyflow");
        if (file.isDirectory()) {
            file.delete();
            return null;
        }
        return BdBBMUtils.readLineFromFile(file);
    }

    private boolean saveImeiCrypto2SDCard(String str) {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflyflow");
            if (file.isDirectory()) {
                file.delete();
            }
            return BdBBMUtils.saveString2File(file, str);
        }
        return false;
    }

    private boolean saveImeiCrypto2BBMFile(String str) {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflyflow");
        if (file.isDirectory()) {
            file.delete();
        }
        return BdBBMUtils.saveString2File(file, str);
    }

    private String generateIMEICrypto(String str) {
        byte[] PlIdeaEncoderWraper = PlIdeaEncoderWraper(str.getBytes());
        try {
            PlumCore.PlSetBuff(PlIdeaEncoderWraper, mInstance.mContext.getPackageManager().getPackageInfo("com.baidu.browser.apps", 64));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String str2 = new String(Base64.encode(PlIdeaEncoderWraper, 0), "iso-8859-1");
            Base64.decode(str2, 0);
            return URLEncoder.encode(str2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String readTNFromSDCard() {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflowfly");
            if (file.isDirectory()) {
                file.delete();
                return null;
            }
            return BdBBMUtils.readLineFromFile(file);
        }
        return null;
    }

    private String readTNFromBBMFile() {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflowfly");
        if (file.isDirectory()) {
            file.delete();
            return null;
        }
        return BdBBMUtils.readLineFromFile(file);
    }

    private boolean saveTN2BBMFile(String str) {
        File file = new File(String.valueOf(String.valueOf(BdPath.getInstance(this.mContext).getDirBBM()) + "/") + ".tmpflowfly");
        if (file.isDirectory()) {
            file.delete();
        }
        return BdBBMUtils.saveString2File(file, str);
    }

    private boolean saveTN2SDCard(String str) {
        String makesureSDCardDirExist;
        if (isSDCardMounted() && (makesureSDCardDirExist = mInstance.makesureSDCardDirExist()) != null) {
            File file = new File(String.valueOf(makesureSDCardDirExist) + ".tmpflowfly");
            if (file.isDirectory()) {
                file.delete();
            }
            return BdBBMUtils.saveString2File(file, str);
        }
        return false;
    }
}
