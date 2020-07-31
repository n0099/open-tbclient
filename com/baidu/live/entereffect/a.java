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
    private com.baidu.live.entereffect.c.a aGM;
    private List<com.baidu.live.entereffect.a.a> aGN;

    public static a xD() {
        return C0160a.aGP;
    }

    public void bc(boolean z) {
        release();
        if (this.aGN == null || this.aGN.isEmpty()) {
            this.aGM = new com.baidu.live.entereffect.c.a();
            this.aGM.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void b(boolean z2, List<com.baidu.live.entereffect.a.a> list) {
                    if (z2) {
                        c.xG().y(list);
                    }
                }
            });
            this.aGM.bc(z);
            return;
        }
        c.xG().z(this.aGN);
    }

    public void w(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aGN == null) {
                this.aGN = new ArrayList();
            }
            this.aGN.clear();
            this.aGN.addAll(list);
        } else if (this.aGN != null) {
            this.aGN.clear();
        }
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.Ek()) {
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

    public com.baidu.live.entereffect.a.a eA(String str) {
        return c.xG().eA(str);
    }

    public void eB(String str) {
        if (this.aGN != null && !this.aGN.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.aGN) {
                if (aVar.id.equals(str)) {
                    c.xG().a(aVar);
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
            com.baidu.live.entereffect.a.a A = com.baidu.live.entereffect.b.a.A(jSONArray.optJSONObject(i));
            if (A != null) {
                arrayList.add(A);
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
        c.xG().release();
        if (this.aGM != null) {
            this.aGM.release();
            this.aGM = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0160a {
        private static a aGP = new a();
    }
}
