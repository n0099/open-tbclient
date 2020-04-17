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
    private com.baidu.live.entereffect.c.a axD;
    private List<com.baidu.live.entereffect.a.a> axE;

    public static a vo() {
        return C0107a.axG;
    }

    public void vp() {
        release();
        if (this.axE == null || this.axE.isEmpty()) {
            this.axD = new com.baidu.live.entereffect.c.a();
            this.axD.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                    if (z) {
                        c.vt().s(list);
                    }
                }
            });
            this.axD.vp();
            return;
        }
        c.vt().t(this.axE);
    }

    public void q(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.axE == null) {
                this.axE = new ArrayList();
            }
            this.axE.clear();
            this.axE.addAll(list);
        } else if (this.axE != null) {
            this.axE.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.Ci()) {
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

    public com.baidu.live.entereffect.a.a dR(String str) {
        return c.vt().dR(str);
    }

    public void dS(String str) {
        if (this.axE != null && !this.axE.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.axE) {
                if (aVar.id.equals(str)) {
                    c.vt().a(aVar);
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
            com.baidu.live.entereffect.a.a u = com.baidu.live.entereffect.b.a.u(jSONArray.optJSONObject(i));
            if (u != null) {
                arrayList.add(u);
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
            return com.baidu.live.entereffect.b.a.b(aVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        c.vt().release();
        if (this.axD != null) {
            this.axD.release();
            this.axD = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0107a {
        private static a axG = new a();
    }
}
