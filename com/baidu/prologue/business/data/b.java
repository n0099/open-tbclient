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
    private final e chv;

    public b(e eVar) {
        this.chv = eVar;
    }

    public void aco() {
        acp();
        acq();
    }

    public void a(@NonNull Als.Area area, String str) {
        b(area, str);
        acr();
    }

    public void acp() {
        Als.a aVar = new Als.a(Als.Type.SHOW);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jN(this.chv.ext);
        Als.a(aVar);
    }

    public void b(@NonNull Als.Area area, String str) {
        Als.a aVar = new Als.a(Als.Type.CLICK);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jN(this.chv.ext);
        aVar.b(area);
        if (!TextUtils.isEmpty(str)) {
            aVar.jQ(str);
        }
        Als.a(aVar);
    }

    public void i(String str, long j) {
        Als.a aVar = new Als.a(Als.Type.CLOSE);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jN(this.chv.ext);
        aVar.jP(String.valueOf(j));
        if (com.baidu.prologue.a.b.a.che.get().abV()) {
            aVar.jO("1");
        } else {
            aVar.jO("0");
        }
        aVar.jQ(str);
        Als.a(aVar);
    }

    public void aZ(String str, String str2) {
        Als.a aVar = new Als.a(Als.Type.DISCARD);
        aVar.a(Als.Page.NA_SPLASH);
        aVar.jN(this.chv.ext);
        aVar.jO("10");
        aVar.jP(str);
        aVar.jQ(str2);
        Als.a(aVar);
    }

    public void acq() {
        String[] strArr;
        for (String str : this.chv.chJ) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jR(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public void acr() {
        String[] strArr;
        for (String str : this.chv.chK) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i.jR(new JSONObject(str).optString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    public static void acs() {
        String string = k.getString("empty_ext_info", "");
        if (!TextUtils.isEmpty(string)) {
            Als.a aVar = new Als.a(Als.Type.SHOW);
            aVar.a(Als.Page.NA_SPLASH);
            aVar.jN(string);
            Als.a(aVar);
        }
    }
}
