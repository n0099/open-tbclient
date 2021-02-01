package com.baidu.helios.trusts.zone.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.b.a.f;
import com.baidu.helios.common.b.a.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final byte[] aud = {77, 73, 78, 71};
    private String D;
    private Context E;
    private int F;
    private Set<String> aue;
    public String o;
    private long t;
    private boolean u;

    private void a(Bundle bundle, com.baidu.helios.common.a.b.a aVar) {
        try {
            if (aVar == null) {
                this.F |= 16;
                return;
            }
            String string = bundle.getString("helios_data");
            if (TextUtils.isEmpty(string)) {
                this.F |= 1;
                return;
            }
            String string2 = bundle.getString("helios_sf");
            if (TextUtils.isEmpty(string2)) {
                this.F |= 2;
                return;
            }
            byte[] decode = Base64.decode(string.getBytes("utf-8"), 1);
            for (int i = 0; i < decode.length; i++) {
                decode[i] = (byte) (decode[i] ^ aud[i % aud.length]);
            }
            JSONObject jSONObject = new JSONObject(new String(decode));
            if (a(jSONObject)) {
                this.aue = new HashSet();
                if (!a(this.D, this.E, jSONObject, this.aue)) {
                    this.F |= 4;
                } else if (!Arrays.equals(g.b(Base64.decode(string2, 0), aVar), f.y(decode))) {
                    this.F |= 8;
                } else {
                    this.t = jSONObject.getLong("priority");
                    this.u = true;
                }
            }
        } catch (Exception e) {
            this.F |= 256;
            this.o = Log.getStackTraceString(e);
        }
    }

    private static boolean a(String str, Context context, JSONObject jSONObject, Set<String> set) {
        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        String[] a2 = a(context.getPackageManager().getPackageInfo(str, 64).signatures);
        if (a2 != null && a2.length > 0) {
            Collections.addAll(set, a2);
        }
        return a(strArr, a2);
    }

    private boolean a(JSONObject jSONObject) {
        e eVar = new e();
        eVar.O(jSONObject.optLong("flags"));
        String optString = jSONObject.optString("package", "");
        long P = eVar.P(7L);
        if (optString.equals("") && P != 4) {
            this.F |= 64;
            return false;
        }
        if (P == 0) {
            if (!optString.equals(this.D)) {
                this.F |= 32;
                return false;
            }
        } else if (P == 1) {
            if (this.D == null || !this.D.startsWith(optString)) {
                this.F |= 32;
                return false;
            }
        } else if (P != 2) {
            if (P == 4) {
                return true;
            }
            this.F |= 64;
            return false;
        } else {
            try {
                if (!Pattern.compile(optString).matcher(this.D).matches()) {
                    this.F |= 32;
                    return false;
                }
            } catch (Exception e) {
                this.F |= 128;
                return false;
            }
        }
        return true;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
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

    private static String[] a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = f.z(signatureArr[i].toByteArray());
        }
        return strArr;
    }

    public void a(com.baidu.helios.common.a.b.a aVar, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        PackageManager packageManager = this.E.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(this.D, 2);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null || (activityInfoArr = packageInfo.receivers) == null || activityInfoArr.length <= 0) {
            return;
        }
        for (ActivityInfo activityInfo2 : activityInfoArr) {
            if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                try {
                    activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                } catch (PackageManager.NameNotFoundException e2) {
                    activityInfo = null;
                }
                if (activityInfo != null && activityInfo.metaData != null) {
                    Bundle bundle = activityInfo.metaData;
                    if (bundle.containsKey("helios") && z) {
                        a(bundle, aVar);
                    }
                }
            }
        }
    }

    public void a(String str, Context context) {
        this.D = str;
        this.E = context;
    }

    public boolean a() {
        return this.u;
    }

    public long b() {
        return this.t;
    }

    public Set<String> c() {
        return this.aue;
    }
}
