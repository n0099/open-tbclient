package com.baidu.sapi2.base.utils;

import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.base.debug.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class EncodeUtils {
    private static final String TAG = "EncodeUtils";

    public static String getDigest(File file, String str) {
        try {
            return getDigest(new FileInputStream(file), str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "getDigest()", e);
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [64=4, 66=4, 67=4, 63=4] */
    static String getDigest(InputStream inputStream, String str) {
        String str2 = null;
        try {
            if (inputStream != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = MD5Util.toHexString(messageDigest.digest(), "", false);
                } catch (IOException e) {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return str2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String toMd5(byte[] bArr) {
        return MD5Util.toMd5(bArr, false);
    }

    public static String getSHA1(File file) {
        return getDigest(file, "SHA1");
    }
}
