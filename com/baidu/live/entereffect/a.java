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
/* loaded from: classes2.dex */
public class a {
    private boolean acY;
    private com.baidu.live.entereffect.c.a acZ;
    private List<com.baidu.live.entereffect.a.a> ada;

    public static a qg() {
        return C0076a.adc;
    }

    public void qh() {
        if (!this.acY || this.ada == null || this.ada.isEmpty()) {
            release();
            this.acY = true;
            if (this.acZ == null) {
                this.acZ = new com.baidu.live.entereffect.c.a();
                this.acZ.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                    @Override // com.baidu.live.entereffect.c.b.a
                    public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                        if (z) {
                            c.ql().p(list);
                        }
                    }
                });
            }
            this.acZ.qh();
        }
    }

    public void n(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.ada == null) {
                this.ada = new ArrayList();
            }
            this.ada.clear();
            this.ada.addAll(list);
        } else if (this.ada != null) {
            this.ada.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.vt()) {
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

    public com.baidu.live.entereffect.a.a cR(String str) {
        return c.ql().cR(str);
    }

    public void cS(String str) {
        if (this.ada != null && !this.ada.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.ada) {
                if (aVar.id.equals(str)) {
                    c.ql().a(aVar);
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
            return com.baidu.live.entereffect.b.a.cT(jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private void release() {
        this.acY = false;
        c.ql().release();
        if (this.acZ != null) {
            this.acZ.release();
        }
        if (this.ada != null) {
            this.ada.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0076a {
        private static a adc = new a();
    }
}
