package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private final e bKz;

    public b(e eVar) {
        this.bKz = eVar;
    }

    public void Vp() {
        Vq();
        Vr();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        Vs();
    }

    public void Vq() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.il(this.bKz.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.il(this.bKz.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.io(str);
        }
        Als.a(aVar);
    }

    public void g(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.il(this.bKz.ext);
        aVar.in(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bKi.get().UW()) {
            aVar.im("1");
        } else {
            aVar.im("0");
        }
        aVar.io(str);
        Als.a(aVar);
    }

    public void aN(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.il(this.bKz.ext);
        aVar.im("10");
        aVar.in(str);
        aVar.io(str2);
        Als.a(aVar);
    }

    public void Vr() {
        String[] strArr;
        for (String str : this.bKz.bKN) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.ip(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void Vs() {
        String[] strArr;
        for (String str : this.bKz.bKO) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.ip(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void Vt() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.il(string);
            Als.a(aVar);
        }
    }
}
