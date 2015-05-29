package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.c;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public class h {
    private static final int a = 1;
    private static final String b = Character.toString(1);
    private static final String c = "android";
    private static final String d = "OaLhzOKTTQGLw8hP";

    static String a() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "";
    }

    static String b() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
    }

    static List<String> c() {
        List<SapiAccount> shareAccounts = SapiAccountManager.getInstance().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    static List<String> a(String str) {
        Context context = SapiAccountManager.getInstance().getSapiConfiguration().context;
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getPackageName());
        arrayList.add(SapiUtils.getVersionName(context));
        arrayList.add(SapiAccountManager.VERSION_NAME);
        arrayList.add(b());
        arrayList.add(a());
        arrayList.add(c);
        arrayList.add(SapiUtils.getClientId(context));
        arrayList.add(SapiAccountManager.getInstance().getSapiConfiguration().tpl);
        arrayList.add(String.valueOf(SapiAccountManager.getInstance().getShareAccounts().size()));
        arrayList.add(TextUtils.join(",", c()));
        if (str == null) {
            str = "";
        }
        arrayList.add(str);
        arrayList.add(String.valueOf(com.baidu.sapi2.d.a(context).A()));
        return arrayList;
    }

    static String d() {
        return String.format("%02d", Integer.valueOf(new Random().nextInt(100))) + (System.currentTimeMillis() / 1000) + String.format("%03d", 1) + GameInfoData.NOT_FROM_DETAIL;
    }

    public static String b(String str) {
        try {
            String join = TextUtils.join(b, a(str));
            String d2 = d();
            return TextUtils.join("_", new String[]{d2, c.a.b(new i().a(join, d2, d))});
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }
}
