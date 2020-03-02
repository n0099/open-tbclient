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
    private h bdX;
    private e.a ccI;
    private BdMultiPicker.a ccJ;
    private InterfaceC0317a ccK;
    private JSONArray bKn = new JSONArray();
    private JSONArray bKo = new JSONArray();
    private List<d> ccf = new ArrayList();
    private List<d> ccG = new ArrayList();
    private List<d> ccH = new ArrayList();
    private Map<d, List<d>> ccg = new HashMap();
    private Map<d, List<d>> cch = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0317a {
        void ad(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.ccf = c.aik().aim();
        this.ccg = c.aik().ain();
        this.cch = c.aik().aio();
        aiv();
        aiw();
        this.ccI = new e.a(context);
        this.ccJ = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bKn.length() - 1) {
                        a.this.ai(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aiv() {
        this.bKo.put(0);
        this.bKo.put(0);
        this.bKo.put(0);
    }

    private void aiw() {
        if (this.ccf.size() > 0) {
            this.bKn.put(ah(this.ccf));
        }
        ah(0, this.bKo.optInt(0));
        ah(1, this.bKo.optInt(1));
    }

    private void ag(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bdX != null && (optJSONArray = this.bKn.optJSONArray(i)) != null) {
            ((e) this.bdX).a(i, optJSONArray, i2);
        }
    }

    private void ah(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.ccG = this.ccg.get(this.ccf.get(i2));
            if (this.ccG.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ah(this.ccG);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.ccH = this.cch.get(this.ccG.get(i2));
            if (this.ccH.size() > 0) {
                jSONArray2 = ah(this.ccH);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bKn.put(i + 1, jSONArray2);
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

    public void aix() {
        if (this.bdX == null) {
            this.bdX = this.ccI.z(this.bKn).A(this.bKo).a(this.ccJ).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> D = a.this.D(((e) dialogInterface).getCurrentIndex());
                    if (a.this.ccK != null) {
                        a.this.ccK.ad(D);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).acr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> D(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.ccf.get(jSONArray.optInt(0)));
        arrayList.add(this.ccG.get(jSONArray.optInt(1)));
        arrayList.add(this.ccH.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bdX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, int i2) {
        int i3 = i;
        while (i3 < this.bKn.length() - 1) {
            ah(i3, i3 == i ? i2 : 0);
            ag(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0317a interfaceC0317a) {
        this.ccK = interfaceC0317a;
    }
}
