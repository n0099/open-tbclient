package com.baidu.prologue.business.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.prologue.a.c.k;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    private final e bTm;

    public b(e eVar) {
        this.bTm = eVar;
    }

    public void XV() {
        XW();
        XX();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        XY();
    }

    public void XW() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jh(this.bTm.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jh(this.bTm.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.jk(str);
        }
        Als.a(aVar);
    }

    public void g(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jh(this.bTm.ext);
        aVar.jj(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.bSV.get().XC()) {
            aVar.ji("1");
        } else {
            aVar.ji("0");
        }
        aVar.jk(str);
        Als.a(aVar);
    }

    public void aS(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jh(this.bTm.ext);
        aVar.ji("10");
        aVar.jj(str);
        aVar.jk(str2);
        Als.a(aVar);
    }

    public void XX() {
        String[] strArr;
        for (String str : this.bTm.bTA) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jl(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void XY() {
        String[] strArr;
        for (String str : this.bTm.bTB) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jl(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void XZ() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.jh(string);
            Als.a(aVar);
        }
    }
}
