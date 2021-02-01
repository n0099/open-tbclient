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
/* loaded from: classes11.dex */
public class a {
    private boolean aUi;
    private com.baidu.live.entereffect.c.a aUj;
    private List<com.baidu.live.entereffect.a.a> aUk;

    public static a CV() {
        return C0168a.aUm;
    }

    public void by(boolean z) {
        this.aUi = z;
        fG(null);
    }

    public boolean h(b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.Lc()) {
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

    public List<com.baidu.live.entereffect.a.a> CW() {
        return c.CZ().CW();
    }

    public com.baidu.live.entereffect.a.a fD(String str) {
        return c.CZ().fD(str);
    }

    public void s(String str, boolean z) {
        boolean z2;
        if (this.aUk != null && !this.aUk.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aUk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    next.aUq = true;
                    c.CZ().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                fG(str);
            }
        }
    }

    public void fE(String str) {
        c.CZ().fI(str);
    }

    public void fF(String str) {
        c.CZ().fF(str);
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
            if (bVar.KZ() == null) {
                str = "";
            } else {
                str = bVar.KZ().portrait;
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
        this.aUi = false;
        c.CZ().release();
        if (this.aUj != null) {
            this.aUj.release();
            this.aUj = null;
        }
        if (this.aUk != null) {
            this.aUk.clear();
        }
    }

    private void fG(String str) {
        if (this.aUj == null) {
            this.aUj = new com.baidu.live.entereffect.c.a();
        }
        this.aUj.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aUk == null || a.this.aUk.isEmpty()) {
                        c.CZ().C(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aUk) {
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
                                    next.aUq = true;
                                    break;
                                }
                            }
                        }
                        c.CZ().D(list);
                    }
                    a.this.A(list);
                }
            }
        });
        this.aUj.i(this.aUi, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aUk == null) {
                this.aUk = new ArrayList();
            }
            this.aUk.clear();
            this.aUk.addAll(list);
        } else if (this.aUk != null) {
            this.aUk.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0168a {
        private static a aUm = new a();
    }
}
