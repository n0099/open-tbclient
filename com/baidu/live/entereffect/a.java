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
    private boolean acJ;
    private com.baidu.live.entereffect.c.a acK;
    private List<com.baidu.live.entereffect.a.a> acL;

    public static a pZ() {
        return C0076a.acN;
    }

    public void qa() {
        if (!this.acJ || this.acL == null || this.acL.isEmpty()) {
            release();
            this.acJ = true;
            if (this.acK == null) {
                this.acK = new com.baidu.live.entereffect.c.a();
                this.acK.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                    @Override // com.baidu.live.entereffect.c.b.a
                    public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                        if (z) {
                            c.qe().p(list);
                        }
                    }
                });
            }
            this.acK.qa();
        }
    }

    public void n(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.acL == null) {
                this.acL = new ArrayList();
            }
            this.acL.clear();
            this.acL.addAll(list);
        } else if (this.acL != null) {
            this.acL.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.vc()) {
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

    public com.baidu.live.entereffect.a.a cP(String str) {
        return c.qe().cP(str);
    }

    public void cQ(String str) {
        if (this.acL != null && !this.acL.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.acL) {
                if (aVar.id.equals(str)) {
                    c.qe().a(aVar);
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
            com.baidu.live.entereffect.a.a p = com.baidu.live.entereffect.b.a.p(jSONArray.optJSONObject(i));
            if (p != null) {
                arrayList.add(p);
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
            return com.baidu.live.entereffect.b.a.cR(jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private void release() {
        this.acJ = false;
        c.qe().release();
        if (this.acK != null) {
            this.acK.release();
        }
        if (this.acL != null) {
            this.acL.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0076a {
        private static a acN = new a();
    }
}
