package com.baidu.live.entereffect;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.entereffect.b.c;
import com.baidu.live.entereffect.c.b;
import com.baidu.live.im.data.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private boolean aRd;
    private com.baidu.live.entereffect.c.a aRe;
    private List<com.baidu.live.entereffect.a.a> aRf;

    public static a BG() {
        return C0166a.aRh;
    }

    public void bt(boolean z) {
        this.aRd = z;
        fl(null);
    }

    public boolean h(b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.JE()) {
            return false;
        }
        try {
            if (bVar.getObjContent() == null) {
                bVar.setObjContent(new JSONObject(bVar.getContent()));
            }
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
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

    public List<com.baidu.live.entereffect.a.a> BH() {
        return c.BK().BH();
    }

    public com.baidu.live.entereffect.a.a fi(String str) {
        return c.BK().fi(str);
    }

    public void s(String str, boolean z) {
        boolean z2;
        if (this.aRf != null && !this.aRf.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aRf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    next.aRl = true;
                    c.BK().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                fl(str);
            }
        }
    }

    public void fj(String str) {
        c.BK().fn(str);
    }

    public void fk(String str) {
        c.BK().fk(str);
    }

    public List<com.baidu.live.entereffect.a.a> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.live.entereffect.a.a G = com.baidu.live.entereffect.b.a.G(jSONArray.optJSONObject(i));
            if (G != null) {
                arrayList.add(G);
            }
        }
        return arrayList;
    }

    public com.baidu.live.entereffect.a.c i(b bVar) {
        String str;
        JSONObject jSONObject;
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.JB() == null) {
                str = "";
            } else {
                str = bVar.JB().portrait;
            }
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return com.baidu.live.entereffect.b.a.d(bVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"), str);
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        this.aRd = false;
        c.BK().release();
        if (this.aRe != null) {
            this.aRe.release();
            this.aRe = null;
        }
        if (this.aRf != null) {
            this.aRf.clear();
        }
    }

    private void fl(String str) {
        if (this.aRe == null) {
            this.aRe = new com.baidu.live.entereffect.c.a();
        }
        this.aRe.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aRf == null || a.this.aRf.isEmpty()) {
                        c.BK().C(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aRf) {
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
                                    next.aRl = true;
                                    break;
                                }
                            }
                        }
                        c.BK().D(list);
                    }
                    a.this.A(list);
                }
            }
        });
        this.aRe.e(this.aRd, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aRf == null) {
                this.aRf = new ArrayList();
            }
            this.aRf.clear();
            this.aRf.addAll(list);
        } else if (this.aRf != null) {
            this.aRf.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0166a {
        private static a aRh = new a();
    }
}
