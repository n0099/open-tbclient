package com.baidu.android.nebula.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class d {
    private static volatile d c = null;
    boolean a = false;
    private Context b;
    private ExecutorService d;

    private d(Context context) {
        this.b = null;
        this.d = null;
        this.b = context.getApplicationContext();
        this.d = Executors.newSingleThreadExecutor();
    }

    public static d a(Context context) {
        if (c == null) {
            c = new d(context);
        }
        return c;
    }

    private String b(Context context) {
        String str;
        long j = -1;
        String str2 = null;
        for (ResolveInfo resolveInfo : com.baidu.android.moplus.util.b.g(context)) {
            try {
                String str3 = resolveInfo.activityInfo.packageName;
                long j2 = context.createPackageContext(str3, 0).getSharedPreferences(str3 + ".share_list", 1).getLong("up_stamp", -1L);
                if (j2 > j) {
                    str = str3;
                } else {
                    j2 = j;
                    str = str2;
                }
                str2 = str;
                j = j2;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return str2;
    }

    public final j a() {
        j jVar = new j();
        String b = b(this.b);
        if (!TextUtils.isEmpty(b)) {
            try {
                String string = this.b.createPackageContext(b, 0).getSharedPreferences(this.b.getPackageName() + ".share_list", 1).getString("up_list", null);
                byte[] decrypt = TextUtils.isEmpty(string) ? null : AESUtil.decrypt("0925458709122426", "0925458709122426", Base64.decode(string.getBytes()));
                if (decrypt != null) {
                    JSONArray jSONArray = new JSONArray(new String(decrypt));
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        jVar.a(new u(jSONArray.getJSONObject(i)));
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
            } catch (Exception e2) {
            }
        }
        return jVar;
    }

    public final void a(List list) {
        this.d.submit(new o(this, list));
    }

    public final void b() {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(".share_list", 1).edit();
        edit.putString("up_list", "");
        edit.putLong("up_stamp", -1L);
        edit.commit();
    }
}
