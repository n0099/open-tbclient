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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private h aZM;
    private e.a bYC;
    private BdMultiPicker.a bYD;
    private InterfaceC0307a bYE;
    private JSONArray bGh = new JSONArray();
    private JSONArray bGi = new JSONArray();
    private List<d> bYa = new ArrayList();
    private List<d> bYA = new ArrayList();
    private List<d> bYB = new ArrayList();
    private Map<d, List<d>> bYb = new HashMap();
    private Map<d, List<d>> bYc = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0307a {
        void ad(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bYa = c.afU().afW();
        this.bYb = c.afU().afX();
        this.bYc = c.afU().afY();
        agf();
        agg();
        this.bYC = new e.a(context);
        this.bYD = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bGh.length() - 1) {
                        a.this.ai(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void agf() {
        this.bGi.put(0);
        this.bGi.put(0);
        this.bGi.put(0);
    }

    private void agg() {
        if (this.bYa.size() > 0) {
            this.bGh.put(ah(this.bYa));
        }
        ah(0, this.bGi.optInt(0));
        ah(1, this.bGi.optInt(1));
    }

    private void ag(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aZM != null && (optJSONArray = this.bGh.optJSONArray(i)) != null) {
            ((e) this.aZM).a(i, optJSONArray, i2);
        }
    }

    private void ah(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.bYA = this.bYb.get(this.bYa.get(i2));
            if (this.bYA.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ah(this.bYA);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bYB = this.bYc.get(this.bYA.get(i2));
            if (this.bYB.size() > 0) {
                jSONArray2 = ah(this.bYB);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bGh.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray ah(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void agh() {
        if (this.aZM == null) {
            this.aZM = this.bYC.z(this.bGh).A(this.bGi).a(this.bYD).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> D = a.this.D(((e) dialogInterface).getCurrentIndex());
                    if (a.this.bYE != null) {
                        a.this.bYE.ad(D);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).aab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> D(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.bYa.get(jSONArray.optInt(0)));
        arrayList.add(this.bYA.get(jSONArray.optInt(1)));
        arrayList.add(this.bYB.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aZM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, int i2) {
        int i3 = i;
        while (i3 < this.bGh.length() - 1) {
            ah(i3, i3 == i ? i2 : 0);
            ag(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0307a interfaceC0307a) {
        this.bYE = interfaceC0307a;
    }
}
