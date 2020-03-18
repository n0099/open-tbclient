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
    private h bem;
    private e.a ccU;
    private BdMultiPicker.a ccV;
    private InterfaceC0317a ccW;
    private JSONArray bKz = new JSONArray();
    private JSONArray bKA = new JSONArray();
    private List<d> ccr = new ArrayList();
    private List<d> ccS = new ArrayList();
    private List<d> ccT = new ArrayList();
    private Map<d, List<d>> cct = new HashMap();
    private Map<d, List<d>> ccu = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0317a {
        void ad(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.ccr = c.ain().aip();
        this.cct = c.ain().aiq();
        this.ccu = c.ain().air();
        aiy();
        aiz();
        this.ccU = new e.a(context);
        this.ccV = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.bKz.length() - 1) {
                        a.this.ai(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aiy() {
        this.bKA.put(0);
        this.bKA.put(0);
        this.bKA.put(0);
    }

    private void aiz() {
        if (this.ccr.size() > 0) {
            this.bKz.put(ah(this.ccr));
        }
        ah(0, this.bKA.optInt(0));
        ah(1, this.bKA.optInt(1));
    }

    private void ag(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bem != null && (optJSONArray = this.bKz.optJSONArray(i)) != null) {
            ((e) this.bem).a(i, optJSONArray, i2);
        }
    }

    private void ah(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.ccS = this.cct.get(this.ccr.get(i2));
            if (this.ccS.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ah(this.ccS);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.ccT = this.ccu.get(this.ccS.get(i2));
            if (this.ccT.size() > 0) {
                jSONArray2 = ah(this.ccT);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.bKz.put(i + 1, jSONArray2);
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

    public void aiA() {
        if (this.bem == null) {
            this.bem = this.ccU.z(this.bKz).A(this.bKA).a(this.ccV).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> D = a.this.D(((e) dialogInterface).getCurrentIndex());
                    if (a.this.ccW != null) {
                        a.this.ccW.ad(D);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).acu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> D(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.ccr.get(jSONArray.optInt(0)));
        arrayList.add(this.ccS.get(jSONArray.optInt(1)));
        arrayList.add(this.ccT.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bem = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(int i, int i2) {
        int i3 = i;
        while (i3 < this.bKz.length() - 1) {
            ah(i3, i3 == i ? i2 : 0);
            ag(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0317a interfaceC0317a) {
        this.ccW = interfaceC0317a;
    }
}
