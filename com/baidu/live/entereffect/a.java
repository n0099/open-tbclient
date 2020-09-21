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
    private com.baidu.live.entereffect.c.a aNQ;
    private List<com.baidu.live.entereffect.a.a> aNR;

    public static a Dw() {
        return C0170a.aNT;
    }

    public void bi(boolean z) {
        release();
        if (this.aNR == null || this.aNR.isEmpty()) {
            this.aNQ = new com.baidu.live.entereffect.c.a();
            this.aNQ.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void b(boolean z2, List<com.baidu.live.entereffect.a.a> list) {
                    if (z2) {
                        c.Dz().z(list);
                    }
                }
            });
            this.aNQ.bi(z);
            return;
        }
        c.Dz().A(this.aNR);
    }

    public void x(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aNR == null) {
                this.aNR = new ArrayList();
            }
            this.aNR.clear();
            this.aNR.addAll(list);
        } else if (this.aNR != null) {
            this.aNR.clear();
        }
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.Kr()) {
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

    public com.baidu.live.entereffect.a.a ga(String str) {
        return c.Dz().ga(str);
    }

    public void gb(String str) {
        if (this.aNR != null && !this.aNR.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.aNR) {
                if (aVar.id.equals(str)) {
                    c.Dz().a(aVar);
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
            return com.baidu.live.entereffect.b.a.c(aVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        c.Dz().release();
        if (this.aNQ != null) {
            this.aNQ.release();
            this.aNQ = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0170a {
        private static a aNT = new a();
    }
}
