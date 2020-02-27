package com.baidu.live.entereffect;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.entereffect.b.c;
import com.baidu.live.entereffect.c.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean afb;
    private com.baidu.live.entereffect.c.a afc;
    private List<com.baidu.live.entereffect.a.a> afd;

    public static a qR() {
        return C0083a.aff;
    }

    public void qS() {
        if (!this.afb || this.afd == null || this.afd.isEmpty()) {
            release();
            this.afb = true;
            if (this.afc == null) {
                this.afc = new com.baidu.live.entereffect.c.a();
                this.afc.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                    @Override // com.baidu.live.entereffect.c.b.a
                    public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                        if (z) {
                            c.qW().p(list);
                        }
                    }
                });
            }
            this.afc.qS();
        }
    }

    public void n(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.afd == null) {
                this.afd = new ArrayList();
            }
            this.afd.clear();
            this.afd.addAll(list);
        } else if (this.afd != null) {
            this.afd.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.xr()) {
            return false;
        }
        try {
            if (aVar.getObjContent() == null) {
                aVar.setObjContent(new JSONObject(aVar.getContent()));
            }
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                return !TextUtils.isEmpty(jSONObject.optString("rmb_live_enter_effect"));
            } catch (JSONException e) {
                BdLog.e(e);
                return false;
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public com.baidu.live.entereffect.a.a da(String str) {
        return c.qW().da(str);
    }

    public void db(String str) {
        if (this.afd != null && !this.afd.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.afd) {
                if (aVar.id.equals(str)) {
                    c.qW().a(aVar);
                    return;
                }
            }
        }
    }

    public List<com.baidu.live.entereffect.a.a> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.live.entereffect.a.a o = com.baidu.live.entereffect.b.a.o(jSONArray.optJSONObject(i));
            if (o != null) {
                arrayList.add(o);
            }
        }
        return arrayList;
    }

    public com.baidu.live.entereffect.a.b b(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null) {
            return null;
        }
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            return com.baidu.live.entereffect.b.a.dc(jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        this.afb = false;
        c.qW().release();
        if (this.afc != null) {
            this.afc.release();
        }
        if (this.afd != null) {
            this.afd.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0083a {
        private static a aff = new a();
    }
}
