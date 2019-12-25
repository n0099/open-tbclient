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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private h aYU;
    private e.a bYq;
    private BdMultiPicker.a bYr;
    private InterfaceC0305a bYs;
    private JSONArray bFw = new JSONArray();
    private JSONArray bFx = new JSONArray();
    private List<d> bXO = new ArrayList();
    private List<d> bYo = new ArrayList();
    private List<d> bYp = new ArrayList();
    private Map<d, List<d>> bXP = new HashMap();
    private Map<d, List<d>> bXQ = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0305a {
        void ae(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.bXO = c.afB().afD();
        this.bXP = c.afB().afE();
        this.bXQ = c.afB().afF();
        afM();
        afN();
        this.bYq = new e.a(context);
        this.bYr = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bFw.length() - 1) {
                        a.this.ae(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void afM() {
        this.bFx.put(0);
        this.bFx.put(0);
        this.bFx.put(0);
    }

    private void afN() {
        if (this.bXO.size() > 0) {
            this.bFw.put(ai(this.bXO));
        }
        ad(0, this.bFx.optInt(0));
        ad(1, this.bFx.optInt(1));
    }

    private void ac(int i, int i2) {
        JSONArray optJSONArray;
        if (this.aYU != null && (optJSONArray = this.bFw.optJSONArray(i)) != null) {
            ((e) this.aYU).a(i, optJSONArray, i2);
        }
    }

    private void ad(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.bYo = this.bXP.get(this.bXO.get(i2));
            if (this.bYo.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ai(this.bYo);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.bYp = this.bXQ.get(this.bYo.get(i2));
            if (this.bYp.size() > 0) {
                jSONArray2 = ai(this.bYp);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bFw.put(i + 1, jSONArray2);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private JSONArray ai(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            jSONArray.put(dVar.name);
        }
        return jSONArray;
    }

    public void afO() {
        if (this.aYU == null) {
            this.aYU = this.bYq.y(this.bFw).z(this.bFx).a(this.bYr).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> C = a.this.C(((e) dialogInterface).getCurrentIndex());
                    if (a.this.bYs != null) {
                        a.this.bYs.ae(C);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).ZE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> C(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.bXO.get(jSONArray.optInt(0)));
        arrayList.add(this.bYo.get(jSONArray.optInt(1)));
        arrayList.add(this.bYp.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.aYU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, int i2) {
        int i3 = i;
        while (i3 < this.bFw.length() - 1) {
            ad(i3, i3 == i ? i2 : 0);
            ac(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0305a interfaceC0305a) {
        this.bYs = interfaceC0305a;
    }
}
