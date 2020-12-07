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
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.live.entereffect.a.a> aUA;
    private boolean aUy;
    private com.baidu.live.entereffect.c.a aUz;

    public static a Gi() {
        return C0181a.aUC;
    }

    public void bA(boolean z) {
        this.aUy = z;
        gN(null);
    }

    public boolean h(b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.NX()) {
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

    public List<com.baidu.live.entereffect.a.a> Gj() {
        return c.Gm().Gj();
    }

    public com.baidu.live.entereffect.a.a gK(String str) {
        return c.Gm().gK(str);
    }

    public void s(String str, boolean z) {
        boolean z2;
        if (this.aUA != null && !this.aUA.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aUA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    c.Gm().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                gN(str);
            }
        }
    }

    public void gL(String str) {
        c.Gm().gP(str);
    }

    public void gM(String str) {
        c.Gm().gM(str);
    }

    public List<com.baidu.live.entereffect.a.a> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.live.entereffect.a.a z = com.baidu.live.entereffect.b.a.z(jSONArray.optJSONObject(i));
            if (z != null) {
                arrayList.add(z);
            }
        }
        return arrayList;
    }

    public com.baidu.live.entereffect.a.c i(b bVar) {
        JSONObject jSONObject;
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return com.baidu.live.entereffect.b.a.g(bVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void release() {
        this.aUy = false;
        c.Gm().release();
        if (this.aUz != null) {
            this.aUz.release();
            this.aUz = null;
        }
        if (this.aUA != null) {
            this.aUA.clear();
        }
    }

    private void gN(String str) {
        if (this.aUz == null) {
            this.aUz = new com.baidu.live.entereffect.c.a();
        }
        this.aUz.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aUA == null || a.this.aUA.isEmpty()) {
                        c.Gm().C(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aUA) {
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
                                    next.aUG = true;
                                    break;
                                }
                            }
                        }
                        c.Gm().D(list);
                    }
                    a.this.A(list);
                }
            }
        });
        this.aUz.e(this.aUy, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aUA == null) {
                this.aUA = new ArrayList();
            }
            this.aUA.clear();
            this.aUA.addAll(list);
        } else if (this.aUA != null) {
            this.aUA.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0181a {
        private static a aUC = new a();
    }
}
