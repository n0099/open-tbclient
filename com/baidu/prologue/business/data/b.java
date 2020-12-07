package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private final e cmr;

    public b(e eVar) {
        this.cmr = eVar;
    }

    public void aeN() {
        aeO();
        aeP();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        aeQ();
    }

    public void aeO() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ko(this.cmr.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ko(this.cmr.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.kr(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ko(this.cmr.ext);
        aVar.kq(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.clZ.get().aeu()) {
            aVar.kp("1");
        } else {
            aVar.kp("0");
        }
        aVar.kr(str);
        Als.a(aVar);
    }

    public void bf(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.ko(this.cmr.ext);
        aVar.kp("10");
        aVar.kq(str);
        aVar.kr(str2);
        Als.a(aVar);
    }

    public void aeP() {
        String[] strArr;
        for (String str : this.cmr.cmF) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.ks(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void aeQ() {
        String[] strArr;
        for (String str : this.cmr.cmG) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.ks(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void aeR() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.ko(string);
            Als.a(aVar);
        }
    }
}
