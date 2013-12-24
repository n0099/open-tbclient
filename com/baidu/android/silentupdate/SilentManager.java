package com.baidu.android.silentupdate;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.zeus.NotificationProxy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SilentManager {
    private static final String b = "push_lib";
    private static final String c = "push_dex";
    private static final String d = "push_update";
    private static final String a = SilentManager.class.getSimpleName();
    private static String e = null;
    private static boolean f = false;
    private static boolean g = true;

    private static String a(File file) {
        if (!file.isFile() || !file.exists()) {
            return null;
        }
        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
                if (read == -1) {
                    fileInputStream.close();
                    return a(messageDigest.digest()).toLowerCase();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return (str.lastIndexOf("/") <= lastIndexOf && lastIndexOf > 0 && lastIndexOf < str.length()) ? str.substring(0, lastIndexOf) : str;
    }

    private static String a(String str, String str2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(a.a(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePublic);
            byte[] doFinal = cipher.doFinal(a.a(str2.getBytes()));
            String str3 = new String(doFinal, "UTF8");
            if (f) {
                Log.d(a, "RSA decrypt:" + str3);
            }
            return new String(doFinal, "UTF8");
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | Exception e2) {
            if (f) {
                Log.d(a, "RSA decrypt fail");
            }
            return null;
        }
    }

    private static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            str = hexString.length() == 1 ? str + SocialConstants.FALSE + hexString : str + hexString;
        }
        return str;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] bArr = new byte[ImageManager.DEFAULT_MAX_CACHEABLE_SIZE];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            } finally {
                a(inputStream);
                a(outputStream);
            }
        }
    }

    private static boolean a(Context context, File file, File file2, String str, String str2, String str3) {
        if (g) {
            String str4 = "";
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str4 = str4 + readLine + "\r\n";
                    }
                } catch (Exception e2) {
                    return false;
                }
            } catch (FileNotFoundException e3) {
            } catch (IOException e4) {
            }
            JSONObject jSONObject = new JSONObject(a(str, str4));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(context.getAssets().open(str2 + "/" + a(str3) + ".key")));
            String str5 = "";
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    break;
                }
                str5 = str5 + readLine2 + "\r\n";
            }
            JSONObject jSONObject2 = new JSONObject(a(str, str5));
            if (!jSONObject2.getString("flag").equals(jSONObject.getString("flag"))) {
                if (f) {
                    Log.d(a, "Flag not equal!");
                }
                return false;
            } else if (jSONObject2.getLong("timestamp") > jSONObject.getLong("timestamp")) {
                if (f) {
                    Log.d(a, "APK newer than dex!");
                }
                return false;
            } else {
                String a2 = a(file2);
                if (f) {
                    Log.d(a, "Lib MD5 : " + a2);
                }
                if (!jSONObject.getString("md5").equals(a2)) {
                    if (f) {
                        Log.d(a, "RSA check fail");
                    }
                    return false;
                } else if (f) {
                    Log.d(a, "RSA check ok");
                    return true;
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    private static boolean a(Context context, String str, String str2, String str3, String str4) {
        if (e == null) {
            throw new RuntimeException("public key must init first!");
        }
        if (str2 == null) {
            throw new RuntimeException("Lib Name Must Not Null!");
        }
        Date date = new Date();
        String str5 = str == null ? "" : str;
        File file = new File(context.getDir(b, 0).getAbsolutePath() + "/" + str2);
        String str6 = a(str2) + ".key";
        File file2 = new File(context.getDir(b, 0).getAbsolutePath() + "/" + str6);
        if (str4 != null) {
            File file3 = new File(str4 + "/" + str2);
            File file4 = new File(str4 + "/" + str6);
            if (file3.exists() && file4.exists()) {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName.endsWith(context.getPackageName())) {
                        if (f) {
                            Log.d(a, "Found update");
                        }
                        file3.renameTo(file);
                        file4.renameTo(file2);
                    }
                }
            }
        }
        if (!file.exists() || !file2.exists() || !a(context, file2, file, e, str5, str2)) {
            if (f) {
                Log.d(a, "Need copy lib from assert");
            }
            try {
                a(context.getAssets().open(str5 + "/" + str2), new FileOutputStream(file));
                a(context.getAssets().open(str5 + "/" + str6), new FileOutputStream(file2));
            } catch (IOException e2) {
                if (f) {
                    Log.e(a, "Copy from assert fail!");
                }
                return false;
            }
        } else if (f) {
            Log.d(a, "Lib file check ok");
        }
        ClassLoader a2 = b.a(file.getAbsolutePath(), context.getDir(c, 0).getAbsolutePath(), str3, context);
        if (a2 == null) {
            if (f) {
                Log.e(a, "Create classloader fail");
            }
            return false;
        }
        boolean a3 = b.a(a2, context.getClassLoader());
        if (a3) {
            if (f) {
                Log.d(a, "Load lib ok, cost " + (new Date().getTime() - date.getTime()) + "ms");
                return a3;
            }
            return a3;
        } else if (f) {
            Log.e(a, "Insert classloader fail");
            return a3;
        } else {
            return a3;
        }
    }

    public static void enableDebugMode(boolean z) {
        f = z;
    }

    public static void enableRSA(boolean z) {
        g = z;
    }

    public static String getKey() {
        return e;
    }

    public static boolean loadLib(Context context, String str, String str2) {
        return loadLib(context, str, str2, "/data/data/" + context.getPackageName() + "/lib");
    }

    public static boolean loadLib(Context context, String str, String str2, String str3) {
        return a(context, str, str2, str3, context.getDir(d, 0).getAbsolutePath());
    }

    public static void setKey(String str) {
        e = str;
    }
}
