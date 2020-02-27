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
    private h bdW;
    private e.a ccH;
    private BdMultiPicker.a ccI;
    private InterfaceC0317a ccJ;
    private JSONArray bKm = new JSONArray();
    private JSONArray bKn = new JSONArray();
    private List<d> cce = new ArrayList();
    private List<d> ccF = new ArrayList();
    private List<d> ccG = new ArrayList();
    private Map<d, List<d>> ccf = new HashMap();
    private Map<d, List<d>> ccg = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0317a {
        void ad(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cce = c.aii().aik();
        this.ccf = c.aii().ail();
        this.ccg = c.aii().aim();
        ait();
        aiu();
        this.ccH = new e.a(context);
        this.ccI = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bKm.length() - 1) {
                        a.this.ai(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void ait() {
        this.bKn.put(0);
        this.bKn.put(0);
        this.bKn.put(0);
    }

    private void aiu() {
        if (this.cce.size() > 0) {
            this.bKm.put(ah(this.cce));
        }
        ah(0, this.bKn.optInt(0));
        ah(1, this.bKn.optInt(1));
    }

    private void ag(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bdW != null && (optJSONArray = this.bKm.optJSONArray(i)) != null) {
            ((e) this.bdW).a(i, optJSONArray, i2);
        }
    }

    private void ah(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.ccF = this.ccf.get(this.cce.get(i2));
            if (this.ccF.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ah(this.ccF);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.ccG = this.ccg.get(this.ccF.get(i2));
            if (this.ccG.size() > 0) {
                jSONArray2 = ah(this.ccG);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bKm.put(i + 1, jSONArray2);
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

    public void aiv() {
        if (this.bdW == null) {
            this.bdW = this.ccH.z(this.bKm).A(this.bKn).a(this.ccI).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> D = a.this.D(((e) dialogInterface).getCurrentIndex());
                    if (a.this.ccJ != null) {
                        a.this.ccJ.ad(D);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).acp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> D(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.cce.get(jSONArray.optInt(0)));
        arrayList.add(this.ccF.get(jSONArray.optInt(1)));
        arrayList.add(this.ccG.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bdW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, int i2) {
        int i3 = i;
        while (i3 < this.bKm.length() - 1) {
            ah(i3, i3 == i ? i2 : 0);
            ag(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0317a interfaceC0317a) {
        this.ccJ = interfaceC0317a;
    }
}
