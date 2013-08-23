package com.baidu.android.nebula.a;

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
public final class l {
    private static volatile l c = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f549a = false;
    private Context b;
    private ExecutorService d;

    private l(Context context) {
        this.b = null;
        this.d = null;
        this.b = context.getApplicationContext();
        this.d = Executors.newSingleThreadExecutor();
    }

    public static l a(Context context) {
        if (c == null) {
            c = new l(context);
        }
        return c;
    }

    private String b(Context context) {
        long j;
        String str;
        long j2 = -1;
        String str2 = null;
        for (ResolveInfo resolveInfo : com.baidu.android.moplus.util.b.g(context)) {
            try {
                String str3 = resolveInfo.activityInfo.packageName;
                j = context.createPackageContext(str3, 0).getSharedPreferences(str3 + ".share_list", 1).getLong("up_stamp", -1L);
                if (j > j2) {
                    str = str3;
                } else {
                    j = j2;
                    str = str2;
                }
            } catch (PackageManager.NameNotFoundException e) {
                j = j2;
                str = str2;
            }
            str2 = str;
            j2 = j;
        }
        return str2;
    }

    public s a() {
        s sVar = new s();
        String b = b(this.b);
        if (!TextUtils.isEmpty(b)) {
            try {
                String string = this.b.createPackageContext(b, 0).getSharedPreferences(this.b.getPackageName() + ".share_list", 1).getString("up_list", null);
                byte[] decrypt = TextUtils.isEmpty(string) ? null : AESUtil.decrypt("0925458709122426", "0925458709122426", Base64.decode(string.getBytes()));
                if (decrypt != null) {
                    JSONArray jSONArray = new JSONArray(new String(decrypt));
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        sVar.a(new a(jSONArray.getJSONObject(i)));
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
            } catch (Exception e2) {
            }
        }
        return sVar;
    }

    public void a(List list) {
        this.d.submit(new m(this, list));
    }

    public void b() {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(".share_list", 1).edit();
        edit.putString("up_list", "");
        edit.putLong("up_stamp", -1L);
        edit.commit();
    }
}
