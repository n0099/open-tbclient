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
    private boolean aVI;
    private com.baidu.live.entereffect.c.a aVJ;
    private List<com.baidu.live.entereffect.a.a> aVK;

    public static a CY() {
        return C0174a.aVM;
    }

    public void by(boolean z) {
        this.aVI = z;
        fM(null);
    }

    public boolean h(b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.Lf()) {
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

    public List<com.baidu.live.entereffect.a.a> CZ() {
        return c.Dc().CZ();
    }

    public com.baidu.live.entereffect.a.a fJ(String str) {
        return c.Dc().fJ(str);
    }

    public void s(String str, boolean z) {
        boolean z2;
        if (this.aVK != null && !this.aVK.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aVK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    next.aVQ = true;
                    c.Dc().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                fM(str);
            }
        }
    }

    public void fK(String str) {
        c.Dc().fO(str);
    }

    public void fL(String str) {
        c.Dc().fL(str);
    }

    public List<com.baidu.live.entereffect.a.a> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            com.baidu.live.entereffect.a.a I = com.baidu.live.entereffect.b.a.I(jSONArray.optJSONObject(i));
            if (I != null) {
                arrayList.add(I);
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
            if (bVar.Lc() == null) {
                str = "";
            } else {
                str = bVar.Lc().portrait;
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
        this.aVI = false;
        c.Dc().release();
        if (this.aVJ != null) {
            this.aVJ.release();
            this.aVJ = null;
        }
        if (this.aVK != null) {
            this.aVK.clear();
        }
    }

    private void fM(String str) {
        if (this.aVJ == null) {
            this.aVJ = new com.baidu.live.entereffect.c.a();
        }
        this.aVJ.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aVK == null || a.this.aVK.isEmpty()) {
                        c.Dc().C(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aVK) {
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
                                    next.aVQ = true;
                                    break;
                                }
                            }
                        }
                        c.Dc().D(list);
                    }
                    a.this.A(list);
                }
            }
        });
        this.aVJ.i(this.aVI, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aVK == null) {
                this.aVK = new ArrayList();
            }
            this.aVK.clear();
            this.aVK.addAll(list);
        } else if (this.aVK != null) {
            this.aVK.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0174a {
        private static a aVM = new a();
    }
}
