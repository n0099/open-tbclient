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
    private boolean aRP;
    private com.baidu.live.entereffect.c.a aRQ;
    private List<com.baidu.live.entereffect.a.a> aRR;

    public static a EF() {
        return C0177a.aRT;
    }

    public void requestData(boolean z) {
        this.aRP = z;
        gt(null);
    }

    public boolean h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || aVar.LR()) {
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

    public List<com.baidu.live.entereffect.a.a> EG() {
        return c.EJ().EG();
    }

    public com.baidu.live.entereffect.a.a gp(String str) {
        return c.EJ().gp(str);
    }

    public void r(String str, boolean z) {
        boolean z2;
        if (this.aRR != null && !this.aRR.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aRR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                com.baidu.live.entereffect.a.a next = it.next();
                if (next.id.equals(str)) {
                    c.EJ().a(next);
                    z2 = true;
                    break;
                }
            }
            if (z && !z2) {
                gt(str);
            }
        }
    }

    public void gq(String str) {
        c.EJ().gv(str);
    }

    public void gr(String str) {
        c.EJ().gr(str);
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
            return com.baidu.live.entereffect.b.a.d(aVar.getMsgId(), jSONObject.optString("rmb_live_enter_effect"));
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public void cancelLoad() {
        c.EJ().stopDownload();
        if (this.aRQ != null) {
            this.aRQ.release();
            this.aRQ = null;
        }
    }

    public void release() {
        this.aRP = false;
        cancelLoad();
        c.EJ().release();
        if (this.aRR != null) {
            this.aRR.clear();
        }
    }

    private void gt(String str) {
        if (this.aRQ == null) {
            this.aRQ = new com.baidu.live.entereffect.c.a();
        }
        this.aRQ.a(new b.a() { // from class: com.baidu.live.entereffect.a.1
            @Override // com.baidu.live.entereffect.c.b.a
            public void a(boolean z, List<com.baidu.live.entereffect.a.a> list, String str2) {
                if (z) {
                    if (a.this.aRR == null || a.this.aRR.isEmpty()) {
                        c.EJ().B(list);
                    } else if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet();
                        for (com.baidu.live.entereffect.a.a aVar : a.this.aRR) {
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
                                    next.aRX = true;
                                    break;
                                }
                            }
                        }
                        c.EJ().C(list);
                    }
                    a.this.z(list);
                }
            }
        });
        this.aRQ.e(this.aRP, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aRR == null) {
                this.aRR = new ArrayList();
            }
            this.aRR.clear();
            this.aRR.addAll(list);
        } else if (this.aRR != null) {
            this.aRR.clear();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.entereffect.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0177a {
        private static a aRT = new a();
    }
}
