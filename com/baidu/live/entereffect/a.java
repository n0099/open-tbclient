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
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.entereffect.c.a aRb;
    private List<com.baidu.live.entereffect.a.a> aRc;

    public static a Et() {
        return C0176a.aRe;
    }

    public void bm(boolean z) {
        release();
        if (this.aRc == null || this.aRc.isEmpty()) {
            this.aRb = new com.baidu.live.entereffect.c.a();
            this.aRb.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void b(boolean z2, List<com.baidu.live.entereffect.a.a> list) {
                    if (z2) {
                        c.Ew().B(list);
                    }
                }
            });
            this.aRb.bm(z);
            return;
        }
        c.Ew().C(this.aRc);
    }

    public void z(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aRc == null) {
                this.aRc = new ArrayList();
            }
            this.aRc.clear();
            this.aRc.addAll(list);
        } else if (this.aRc != null) {
            this.aRc.clear();
        }
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.Lw()) {
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

    public com.baidu.live.entereffect.a.a go(String str) {
        return c.Ew().go(str);
    }

    public void gp(String str) {
        if (this.aRc != null && !this.aRc.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.aRc) {
                if (aVar.id.equals(str)) {
                    c.Ew().a(aVar);
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
            com.baidu.live.entereffect.a.a C = com.baidu.live.entereffect.b.a.C(jSONArray.optJSONObject(i));
            if (C != null) {
                arrayList.add(C);
            }
        }
        return arrayList;
    }

    public com.baidu.live.entereffect.a.b i(com.baidu.live.im.data.a aVar) {
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
            return com.baidu.live.entereffect.b.a.d(aVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        c.Ew().release();
        if (this.aRb != null) {
            this.aRb.release();
            this.aRb = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0176a {
        private static a aRe = new a();
    }
}
