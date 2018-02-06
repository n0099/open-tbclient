package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.util.AESUtils;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARConfiguration {
    public static final int LAUNCH_AR_TAB = 2;
    public static final int LAUNCH_AR_TAB_CASE = 3;
    public static final int LAUNCH_MODE_H5 = 1;
    public static final int LAUNCH_MODE_TAKE_PICTURE = 0;
    public static final int TYPE_GAME = 2;
    public static final int TYPE_LBS = 1;
    public static final int TYPE_NPC = 4;
    public static final int TYPE_SLAM = 5;
    public static final int TYPE_TRACK = 0;
    public static final int TYPE_UDT = 3;
    private static String d;
    private static String h;
    private static String i;
    private static String j;
    private static long k;
    private String a;
    private String b;
    private int c;
    private int e;
    private boolean f = false;
    private String g;
    private String l;

    private static void a(long j2) {
        k = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f5 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103 A[Catch: JSONException -> 0x00fd, NumberFormatException -> 0x010b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x010b, JSONException -> 0x00fd, blocks: (B:5:0x0004, B:7:0x0012, B:8:0x0019, B:10:0x0022, B:11:0x002a, B:13:0x0030, B:15:0x0036, B:17:0x003f, B:18:0x0046, B:20:0x004c, B:22:0x0054, B:23:0x005b, B:25:0x0061, B:27:0x0067, B:29:0x007e, B:30:0x0085, B:32:0x008b, B:33:0x008f, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00a9, B:41:0x00b2, B:42:0x00bc, B:44:0x00c5, B:56:0x0103, B:52:0x00f5, B:49:0x00e4, B:51:0x00ed, B:46:0x00d2, B:48:0x00db), top: B:66:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ARConfiguration createARConfiguration(String str) {
        String str2;
        String string;
        String string2;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string3 = jSONObject.has(Constants.AR_KEY) ? jSONObject.getString(Constants.AR_KEY) : jSONObject.has(Constants.OLD_AR_KEY) ? jSONObject.getString(Constants.OLD_AR_KEY) : null;
            String string4 = jSONObject.has("ar_id") ? jSONObject.getString("ar_id") : null;
            if (TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
                String string5 = jSONObject.has(Constants.AR_CODED_KEY) ? jSONObject.getString(Constants.AR_CODED_KEY) : null;
                if (!TextUtils.isEmpty(string5) && !TextUtils.isEmpty(d)) {
                    str2 = AESUtils.decrypt(d, string5);
                    if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(string4)) {
                        ARConfiguration aRConfiguration = new ARConfiguration();
                        aRConfiguration.setJsonString(str);
                        aRConfiguration.setARKey(str2);
                        aRConfiguration.setARId(string4);
                        string = !jSONObject.has("ar_type") ? jSONObject.getString("ar_type") : jSONObject.has(Constants.OLD_AR_TYPE) ? jSONObject.getString(Constants.OLD_AR_TYPE) : null;
                        if (TextUtils.isEmpty(string)) {
                            aRConfiguration.setARType(Integer.parseInt(string));
                        } else {
                            aRConfiguration.setARType(0);
                        }
                        string2 = !jSONObject.has(Constants.AR_LAUNCH_MODE) ? jSONObject.getString(Constants.AR_LAUNCH_MODE) : null;
                        if (TextUtils.isEmpty(string2)) {
                            aRConfiguration.setARLaunchMode(Integer.parseInt(string2));
                        } else {
                            aRConfiguration.setARLaunchMode(0);
                        }
                        if (jSONObject.has(Constants.EXTRA_INFO)) {
                            aRConfiguration.setARExtraInfo(jSONObject.getString(Constants.EXTRA_INFO));
                        }
                        if (jSONObject.has(Constants.AR_NEED_LAST_PREVIEW)) {
                            aRConfiguration.setIsNeedLastPreview(jSONObject.getBoolean(Constants.AR_NEED_LAST_PREVIEW));
                        }
                        return aRConfiguration;
                    }
                    return null;
                }
            }
            str2 = string3;
            if (TextUtils.isEmpty(str2)) {
            }
            ARConfiguration aRConfiguration2 = new ARConfiguration();
            aRConfiguration2.setJsonString(str);
            aRConfiguration2.setARKey(str2);
            aRConfiguration2.setARId(string4);
            if (!jSONObject.has("ar_type")) {
            }
            if (TextUtils.isEmpty(string)) {
            }
            if (!jSONObject.has(Constants.AR_LAUNCH_MODE)) {
            }
            if (TextUtils.isEmpty(string2)) {
            }
            if (jSONObject.has(Constants.EXTRA_INFO)) {
            }
            if (jSONObject.has(Constants.AR_NEED_LAST_PREVIEW)) {
            }
            return aRConfiguration2;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String createARSeed() {
        d = String.valueOf(System.currentTimeMillis());
        return d;
    }

    public static String getAccessKey() {
        return h;
    }

    public static String getPublishID() {
        return j;
    }

    public static String getSecretKey() {
        return i;
    }

    public static String getSignature() {
        long currentTimeMillis = System.currentTimeMillis();
        a(currentTimeMillis);
        return o.a(getPublishID() + getAccessKey() + "777078ec21930de508131ba36035de6b" + currentTimeMillis);
    }

    public static long getTimestamp() {
        return k;
    }

    public static void setAccessKey(String str) {
        h = str;
    }

    public static void setPublishId(String str) {
        j = str;
    }

    public static void setSecretKey(String str) {
        i = str;
    }

    public String getARExtraInfo() {
        return this.g;
    }

    public String getARId() {
        return this.a;
    }

    public String getARKey() {
        return this.b;
    }

    public int getARLaunchMode() {
        return this.e;
    }

    public int getARType() {
        return this.c;
    }

    public String getJsonString() {
        return this.l;
    }

    public boolean isNeedLastPreview() {
        return this.f;
    }

    public void setARExtraInfo(String str) {
        this.g = str;
    }

    public void setARId(String str) {
        this.a = str;
    }

    public void setARKey(String str) {
        this.b = str;
    }

    public void setARLaunchMode(int i2) {
        this.e = i2;
    }

    public void setARType(int i2) {
        this.c = i2;
    }

    public void setIsNeedLastPreview(boolean z) {
        this.f = z;
    }

    public void setJsonString(String str) {
        this.l = str;
    }
}
