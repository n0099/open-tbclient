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
/* loaded from: classes7.dex */
public class a {
    private com.baidu.live.entereffect.c.a aLW;
    private List<com.baidu.live.entereffect.a.a> aLX;

    public static a Dg() {
        return C0168a.aLZ;
    }

    public void bh(boolean z) {
        release();
        if (this.aLX == null || this.aLX.isEmpty()) {
            this.aLW = new com.baidu.live.entereffect.c.a();
            this.aLW.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                @Override // com.baidu.live.entereffect.c.b.a
                public void b(boolean z2, List<com.baidu.live.entereffect.a.a> list) {
                    if (z2) {
                        c.Dj().z(list);
                    }
                }
            });
            this.aLW.bh(z);
            return;
        }
        c.Dj().A(this.aLX);
    }

    public void x(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aLX == null) {
                this.aLX = new ArrayList();
            }
            this.aLX.clear();
            this.aLX.addAll(list);
        } else if (this.aLX != null) {
            this.aLX.clear();
        }
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.JN()) {
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

    public com.baidu.live.entereffect.a.a fU(String str) {
        return c.Dj().fU(str);
    }

    public void fV(String str) {
        if (this.aLX != null && !this.aLX.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.aLX) {
                if (aVar.id.equals(str)) {
                    c.Dj().a(aVar);
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
        c.Dj().release();
        if (this.aLW != null) {
            this.aLW.release();
            this.aLW = null;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0168a {
        private static a aLZ = new a();
    }
}
