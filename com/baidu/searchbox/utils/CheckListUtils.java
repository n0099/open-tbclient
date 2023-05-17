package com.baidu.searchbox.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.language.bm.ResourceConstants;
/* loaded from: classes4.dex */
public class CheckListUtils {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "CheckListUtils";

    public static String addSchemeIfNeed(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("rtsp://")) {
            return "http://" + str;
        }
        return str;
    }

    public static boolean checkInHostList(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2) && (str2.equals(host) || host.endsWith(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean compare(String[] strArr, String[] strArr2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.addAll(Arrays.asList(strArr));
        hashSet2.addAll(Arrays.asList(strArr2));
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        int size = hashSet.size();
        hashSet.addAll(Arrays.asList(strArr2));
        if (size != hashSet.size()) {
            return false;
        }
        return true;
    }

    public static boolean checkInList(String str, List<String> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf >= str.length()) {
            indexOf = 0;
        }
        if (indexOf2 >= str.length()) {
            indexOf2 = 0;
        }
        if (indexOf2 > 0 && indexOf2 < indexOf) {
            indexOf = 0;
        }
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (indexOf2 > 0) {
                String substring2 = str.substring(indexOf + 1, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                str3 = substring2;
                str2 = substring3;
            } else {
                str3 = str.substring(indexOf + 1);
                str2 = null;
            }
            str = substring;
        } else if (indexOf2 > 0) {
            String substring4 = str.substring(0, indexOf2);
            String substring5 = str.substring(indexOf2 + 1);
            str3 = null;
            str2 = substring5;
            str = substring4;
        } else {
            str2 = null;
            str3 = null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                int indexOf3 = next.indexOf("?");
                int indexOf4 = next.indexOf("#");
                if (indexOf3 >= next.length()) {
                    indexOf3 = 0;
                }
                if (indexOf4 >= next.length()) {
                    indexOf4 = 0;
                }
                if (indexOf4 > 0 && indexOf4 < indexOf3) {
                    indexOf3 = 0;
                }
                if (indexOf3 > 0) {
                    String substring6 = next.substring(0, indexOf3);
                    if (indexOf4 > 0) {
                        String substring7 = next.substring(indexOf3 + 1, indexOf4);
                        String substring8 = next.substring(indexOf4 + 1);
                        str5 = substring7;
                        str4 = substring8;
                        next = substring6;
                    } else {
                        str5 = next.substring(indexOf3 + 1);
                        next = substring6;
                        str4 = null;
                    }
                } else if (indexOf4 > 0) {
                    String substring9 = next.substring(0, indexOf4);
                    String substring10 = next.substring(indexOf4 + 1);
                    str5 = null;
                    str4 = substring10;
                    next = substring9;
                } else {
                    str4 = null;
                    str5 = null;
                }
                if (!str.startsWith(next)) {
                    continue;
                } else if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4)) {
                    return true;
                } else {
                    if (TextUtils.isEmpty(str5) || (!TextUtils.isEmpty(str3) && compare(str3.split("&"), str5.split("&")))) {
                        if (TextUtils.equals(str2, str4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String decrypt(String str, String str2, String str3) {
        try {
            byte[] decode = Base64.decode(str, 2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(str3.getBytes()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static String fixUrl(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(58);
        boolean z = true;
        for (int i = 0; i < indexOf; i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetter(charAt)) {
                break;
            }
            z &= Character.isLowerCase(charAt);
            if (i == indexOf - 1 && !z) {
                str = str.substring(0, indexOf).toLowerCase(Locale.getDefault()) + str.substring(indexOf);
            }
        }
        if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("rtsp://")) {
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS) || str.startsWith("rtsp:")) {
                if (!str.startsWith("http:/") && !str.startsWith("https:/") && !str.startsWith("rtsp:/")) {
                    return str.replaceFirst(":", "://");
                }
                return str.replaceFirst("/", ResourceConstants.CMT);
            }
            return str;
        }
        return str;
    }

    public static List<String> readCache(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    fileInputStream = AppRuntime.getAppContext().openFileInput(str);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (!TextUtils.isEmpty(readLine)) {
                            arrayList.add(readLine);
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            Closeables.closeSafely(fileInputStream);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                Log.d(TAG, "Read WhiteScheme Cache: " + (currentTimeMillis2 - currentTimeMillis));
            }
            return arrayList;
        } catch (Throwable th) {
            Closeables.closeSafely(fileInputStream);
            throw th;
        }
    }

    public static boolean writeCache(List<String> list, String str) {
        try {
            try {
                try {
                    FileOutputStream openFileOutput = AppRuntime.getAppContext().openFileOutput(str, 0);
                    if (list.size() == 0) {
                        openFileOutput.write(new byte[0]);
                        Closeables.closeSafely(openFileOutput);
                        return true;
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput));
                    for (String str2 : list) {
                        bufferedWriter.write(str2);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    Closeables.closeSafely(openFileOutput);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        } finally {
            Closeables.closeSafely((Closeable) null);
        }
    }
}
