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
    private boolean aVQ;
    private com.baidu.live.entereffect.c.a aVR;
    private List<com.baidu.live.entereffect.a.a> aVS;

    public static a FB() {
        return C0175a.aVU;
    }

    public void bx(boolean z) {
        this.aVQ = z;
        gx(null);
    }

    public boolean h(b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.Nz()) {
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

    public List<com.baidu.live.entereffect.a.a> FC() {
        return c.FF().FC();
    }

    public com.baidu.live.entereffect.a.a gu(String str) {
        return c.FF().gu(str);
    }

    public void s(String str, boolean z) {
        boolean z2;
        if (this.aVS != null && !this.aVS.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aVS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    next.aVY = true;
                    c.FF().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                gx(str);
            }
        }
    }

    public void gv(String str) {
        c.FF().gz(str);
    }

    public void gw(String str) {
        c.FF().gw(str);
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
            if (bVar.Nw() == null) {
                str = "";
            } else {
                str = bVar.Nw().portrait;
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
        this.aVQ = false;
        c.FF().release();
        if (this.aVR != null) {
            this.aVR.release();
            this.aVR = null;
        }
        if (this.aVS != null) {
            this.aVS.clear();
        }
    }

    private void gx(String str) {
        if (this.aVR == null) {
            this.aVR = new com.baidu.live.entereffect.c.a();
        }
        this.aVR.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aVS == null || a.this.aVS.isEmpty()) {
                        c.FF().C(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aVS) {
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
                                    next.aVY = true;
                                    break;
                                }
                            }
                        }
                        c.FF().D(list);
                    }
                    a.this.A(list);
                }
            }
        });
        this.aVR.e(this.aVQ, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aVS == null) {
                this.aVS = new ArrayList();
            }
            this.aVS.clear();
            this.aVS.addAll(list);
        } else if (this.aVS != null) {
            this.aVS.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0175a {
        private static a aVU = new a();
    }
}
