package com.baidu.swan.bdprivate.address.view;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.baidu.swan.bdprivate.address.b.c;
import com.baidu.swan.bdprivate.address.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private h bCE;
    private e.a cCa;
    private BdMultiPicker.a cCb;
    private InterfaceC0368a cCc;
    private JSONArray cjp = new JSONArray();
    private JSONArray cjq = new JSONArray();
    private List<d> cBy = new ArrayList();
    private List<d> cBY = new ArrayList();
    private List<d> cBZ = new ArrayList();
    private Map<d, List<d>> cBz = new HashMap();
    private Map<d, List<d>> cBA = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0368a {
        void al(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cBy = c.aqu().aqw();
        this.cBz = c.aqu().aqx();
        this.cBA = c.aqu().aqy();
        aqF();
        aqG();
        this.cCa = new e.a(context);
        this.cCb = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.cjp.length() - 1) {
                        a.this.al(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aqF() {
        this.cjq.put(0);
        this.cjq.put(0);
        this.cjq.put(0);
    }

    private void aqG() {
        if (this.cBy.size() > 0) {
            this.cjp.put(ap(this.cBy));
        }
        ak(0, this.cjq.optInt(0));
        ak(1, this.cjq.optInt(1));
    }

    private void aj(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bCE != null && (optJSONArray = this.cjp.optJSONArray(i)) != null) {
            ((e) this.bCE).a(i, optJSONArray, i2);
        }
    }

    private void ak(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.cBY = this.cBz.get(this.cBy.get(i2));
            if (this.cBY.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ap(this.cBY);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.cBZ = this.cBA.get(this.cBY.get(i2));
            if (this.cBZ.size() > 0) {
                jSONArray2 = ap(this.cBZ);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.cjp.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray ap(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void aqH() {
        if (this.bCE == null) {
            this.bCE = this.cCa.A(this.cjp).B(this.cjq).a(this.cCb).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> E = a.this.E(((e) dialogInterface).getCurrentIndex());
                    if (a.this.cCc != null) {
                        a.this.cCc.al(E);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).aky();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> E(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.cBy.get(jSONArray.optInt(0)));
        arrayList.add(this.cBY.get(jSONArray.optInt(1)));
        arrayList.add(this.cBZ.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bCE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        int i3 = i;
        while (i3 < this.cjp.length() - 1) {
            ak(i3, i3 == i ? i2 : 0);
            aj(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0368a interfaceC0368a) {
        this.cCc = interfaceC0368a;
    }
}
