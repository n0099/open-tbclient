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
/* loaded from: classes6.dex */
public class a {
    private boolean VB;
    private com.baidu.live.entereffect.c.a VC;
    private List<com.baidu.live.entereffect.a.a> VD;

    public static a oF() {
        return C0061a.VF;
    }

    public void oG() {
        if (!this.VB || this.VD == null || this.VD.isEmpty()) {
            release();
            this.VB = true;
            if (this.VC == null) {
                this.VC = new com.baidu.live.entereffect.c.a();
                this.VC.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                    @Override // com.baidu.live.entereffect.c.b.a
                    public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                        if (z) {
                            c.oK().q(list);
                        }
                    }
                });
            }
            this.VC.oG();
        }
    }

    public void o(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.VD == null) {
                this.VD = new ArrayList();
            }
            this.VD.clear();
            this.VD.addAll(list);
        } else if (this.VD != null) {
            this.VD.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.th()) {
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

    public com.baidu.live.entereffect.a.a bY(String str) {
        return c.oK().bY(str);
    }

    public void bZ(String str) {
        if (this.VD != null && !this.VD.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.VD) {
                if (aVar.id.equals(str)) {
                    c.oK().a(aVar);
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
            com.baidu.live.entereffect.a.a s = com.baidu.live.entereffect.b.a.s(jSONArray.optJSONObject(i));
            if (s != null) {
                arrayList.add(s);
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
            return com.baidu.live.entereffect.b.a.ca(jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private void release() {
        this.VB = false;
        c.oK().release();
        if (this.VC != null) {
            this.VC.release();
        }
        if (this.VD != null) {
            this.VD.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0061a {
        private static a VF = new a();
    }
}
