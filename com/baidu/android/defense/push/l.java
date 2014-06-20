package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class l {
    private static l b = null;
    private Context a;

    private l(Context context) {
        this.a = null;
        this.a = context.getApplicationContext();
    }

    public static l a(Context context) {
        if (b == null) {
            b = new l(context);
        }
        return b;
    }

    public n a(String str) {
        String str2;
        try {
            str2 = new JSONObject(str).getString(com.baidu.tbadk.core.frameworkData.a.CMD);
        } catch (JSONException e) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if ("appinstall".equals(str2)) {
            return new f(str, this.a);
        }
        if ("appuninstall".equals(str2)) {
            return new m(str, this.a);
        }
        if ("appfreeze".equals(str2)) {
            return new i(str, this.a);
        }
        if ("appunfreeze".equals(str2)) {
            return new e(str, this.a);
        }
        if ("filepush".equals(str2)) {
            return new c(str, this.a);
        }
        if (TbConfig.SETTINGFILE.equals(str2)) {
            return new p(str, this.a);
        }
        if ("notifationurl".equals(str2)) {
            return new d(str, this.a);
        }
        if ("notifationuninstall".equals(str2)) {
            return new k(str, this.a);
        }
        if ("ports".equals(str2)) {
            return new o(str, this.a);
        }
        return null;
    }
}
