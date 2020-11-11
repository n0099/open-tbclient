package com.baidu.live.entereffect;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.entereffect.b.c;
import com.baidu.live.entereffect.c.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean aTh;
    private com.baidu.live.entereffect.c.a aTi;
    private List<com.baidu.live.entereffect.a.a> aTj;

    public static a Fg() {
        return C0179a.aTl;
    }

    public void requestData(boolean z) {
        this.aTh = z;
        gy(null);
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.Mr()) {
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

    public List<com.baidu.live.entereffect.a.a> Fh() {
        return c.Fk().Fh();
    }

    public com.baidu.live.entereffect.a.a gv(String str) {
        return c.Fk().gv(str);
    }

    public void r(String str, boolean z) {
        boolean z2;
        if (this.aTj != null && !this.aTj.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aTj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    c.Fk().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                gy(str);
            }
        }
    }

    public void gw(String str) {
        c.Fk().gA(str);
    }

    public void gx(String str) {
        c.Fk().gx(str);
    }

    public List<com.baidu.live.entereffect.a.a> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.live.entereffect.a.a F = com.baidu.live.entereffect.b.a.F(jSONArray.optJSONObject(i));
            if (F != null) {
                arrayList.add(F);
            }
        }
        return arrayList;
    }

    public com.baidu.live.entereffect.a.c i(com.baidu.live.im.data.a aVar) {
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
            return com.baidu.live.entereffect.b.a.e(aVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        this.aTh = false;
        c.Fk().release();
        if (this.aTi != null) {
            this.aTi.release();
            this.aTi = null;
        }
        if (this.aTj != null) {
            this.aTj.clear();
        }
    }

    private void gy(String str) {
        if (this.aTi == null) {
            this.aTi = new com.baidu.live.entereffect.c.a();
        }
        this.aTi.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aTj == null || a.this.aTj.isEmpty()) {
                        c.Fk().B(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aTj) {
                            if (aVar != null) {
                                hashSet.add(aVar.id);
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            Iterator<com.baidu.live.entereffect.a.a> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.live.entereffect.a.a next = it.next();
                                if (!str2.equals(next.id)) {
                                    next.aTp = true;
                                    break;
                                }
                            }
                        }
                        c.Fk().C(list);
                    }
                    a.this.z(list);
                }
            }
        });
        this.aTi.e(this.aTh, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aTj == null) {
                this.aTj = new ArrayList();
            }
            this.aTj.clear();
            this.aTj.addAll(list);
        } else if (this.aTj != null) {
            this.aTj.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0179a {
        private static a aTl = new a();
    }
}
