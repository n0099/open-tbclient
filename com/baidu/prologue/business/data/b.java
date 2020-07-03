package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.j;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private final e bEC;

    public b(e eVar) {
        this.bEC = eVar;
    }

    public void Pe() {
        Pf();
        Pg();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        Ph();
    }

    public void Pf() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gT(this.bEC.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gT(this.bEC.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.gW(str);
        }
        Als.a(aVar);
    }

    public void h(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gT(this.bEC.ext);
        aVar.gV(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bEl.get().OL()) {
            aVar.gU("1");
        } else {
            aVar.gU("0");
        }
        aVar.gW(str);
        Als.a(aVar);
    }

    public void aJ(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.gT(this.bEC.ext);
        aVar.gU("10");
        aVar.gV(str);
        aVar.gW(str2);
        Als.a(aVar);
    }

    public void Pg() {
        String[] strArr;
        for (String str : this.bEC.bEQ) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gX(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void Ph() {
        String[] strArr;
        for (String str : this.bEC.bER) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.gX(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void Pi() {
        String string = j.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.gT(string);
            Als.a(aVar);
        }
    }
}
