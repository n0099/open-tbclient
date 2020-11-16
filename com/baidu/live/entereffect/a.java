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
    private boolean aRw;
    private com.baidu.live.entereffect.c.a aRx;
    private List<com.baidu.live.entereffect.a.a> aRy;

    public static a Ex() {
        return C0177a.aRA;
    }

    public void requestData(boolean z) {
        this.aRw = z;
        gr(null);
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.LI()) {
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

    public List<com.baidu.live.entereffect.a.a> Ey() {
        return c.EB().Ey();
    }

    public com.baidu.live.entereffect.a.a go(String str) {
        return c.EB().go(str);
    }

    public void r(String str, boolean z) {
        boolean z2;
        if (this.aRy != null && !this.aRy.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aRy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    c.EB().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                gr(str);
            }
        }
    }

    public void gp(String str) {
        c.EB().gu(str);
    }

    public void gq(String str) {
        c.EB().gq(str);
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
        this.aRw = false;
        c.EB().release();
        if (this.aRx != null) {
            this.aRx.release();
            this.aRx = null;
        }
        if (this.aRy != null) {
            this.aRy.clear();
        }
    }

    private void gr(String str) {
        if (this.aRx == null) {
            this.aRx = new com.baidu.live.entereffect.c.a();
        }
        this.aRx.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aRy == null || a.this.aRy.isEmpty()) {
                        c.EB().B(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aRy) {
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
                                    next.aRE = true;
                                    break;
                                }
                            }
                        }
                        c.EB().C(list);
                    }
                    a.this.z(list);
                }
            }
        });
        this.aRx.e(this.aRw, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aRy == null) {
                this.aRy = new ArrayList();
            }
            this.aRy.clear();
            this.aRy.addAll(list);
        } else if (this.aRy != null) {
            this.aRy.clear();
        }
    }

    private a() {
    }

    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0177a {
        private static a aRA = new a();
    }
}
