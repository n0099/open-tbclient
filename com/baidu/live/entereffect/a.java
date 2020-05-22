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
    private com.baidu.live.entereffect.c.a aCZ;
    private List<com.baidu.live.entereffect.a.a> aDa;

    public static a wD() {
        return C0159a.aDc;
    }

    public void aZ(boolean z) {
        release();
        if (this.aDa == null || this.aDa.isEmpty()) {
            this.aCZ = new com.baidu.live.entereffect.c.a();
            this.aCZ.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void a(boolean z2, List<com.baidu.live.entereffect.a.a> list) {
                    if (z2) {
                        c.wG().s(list);
                    }
                }
            });
            this.aCZ.aZ(z);
            return;
        }
        c.wG().t(this.aDa);
    }

    public void q(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aDa == null) {
                this.aDa = new ArrayList();
            }
            this.aDa.clear();
            this.aDa.addAll(list);
        } else if (this.aDa != null) {
            this.aDa.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.DE()) {
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

    public com.baidu.live.entereffect.a.a ew(String str) {
        return c.wG().ew(str);
    }

    public void ex(String str) {
        if (this.aDa != null && !this.aDa.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.aDa) {
                if (aVar.id.equals(str)) {
                    c.wG().a(aVar);
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
            com.baidu.live.entereffect.a.a y = com.baidu.live.entereffect.b.a.y(jSONArray.optJSONObject(i));
            if (y != null) {
                arrayList.add(y);
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
        c.wG().release();
        if (this.aCZ != null) {
            this.aCZ.release();
            this.aCZ = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0159a {
        private static a aDc = new a();
    }
}
