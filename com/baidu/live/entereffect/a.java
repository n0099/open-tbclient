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
    private boolean afl;
    private com.baidu.live.entereffect.c.a afm;
    private List<com.baidu.live.entereffect.a.a> afn;

    public static a qW() {
        return C0083a.afp;
    }

    public void qX() {
        if (!this.afl || this.afn == null || this.afn.isEmpty()) {
            release();
            this.afl = true;
            if (this.afm == null) {
                this.afm = new com.baidu.live.entereffect.c.a();
                this.afm.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
                    @Override // com.baidu.live.entereffect.c.b.a
                    public void a(boolean z, List<com.baidu.live.entereffect.a.a> list) {
                        if (z) {
                            c.rb().p(list);
                        }
                    }
                });
            }
            this.afm.qX();
        }
    }

    public void n(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.afn == null) {
                this.afn = new ArrayList();
            }
            this.afn.clear();
            this.afn.addAll(list);
        } else if (this.afn != null) {
            this.afn.clear();
        }
    }

    public boolean a(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.xw()) {
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

    public com.baidu.live.entereffect.a.a cZ(String str) {
        return c.rb().cZ(str);
    }

    public void da(String str) {
        if (this.afn != null && !this.afn.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.baidu.live.entereffect.a.a aVar : this.afn) {
                if (aVar.id.equals(str)) {
                    c.rb().a(aVar);
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
            return com.baidu.live.entereffect.b.a.db(jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        this.afl = false;
        c.rb().release();
        if (this.afm != null) {
            this.afm.release();
        }
        if (this.afn != null) {
            this.afn.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0083a {
        private static a afp = new a();
    }
}
