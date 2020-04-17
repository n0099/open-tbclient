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
    private h bCz;
    private e.a cBU;
    private BdMultiPicker.a cBV;
    private InterfaceC0347a cBW;
    private JSONArray cjj = new JSONArray();
    private JSONArray cjk = new JSONArray();
    private List<d> cBs = new ArrayList();
    private List<d> cBS = new ArrayList();
    private List<d> cBT = new ArrayList();
    private Map<d, List<d>> cBt = new HashMap();
    private Map<d, List<d>> cBu = new HashMap();

    /* renamed from: com.baidu.swan.bdprivate.address.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0347a {
        void al(List<d> list);
    }

    public a(Context context) {
        initData(context);
    }

    private void initData(Context context) {
        this.cBs = c.aqv().aqx();
        this.cBt = c.aqv().aqy();
        this.cBu = c.aqv().aqz();
        aqG();
        aqH();
        this.cBU = new e.a(context);
        this.cBV = new BdMultiPicker.a() { // from class: com.baidu.swan.bdprivate.address.view.a.1
            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("column");
                    int optInt2 = jSONObject.optInt("current");
                    if (optInt != a.this.cjj.length() - 1) {
                        a.this.al(optInt, optInt2);
                    }
                }
            }
        };
    }

    private void aqG() {
        this.cjk.put(0);
        this.cjk.put(0);
        this.cjk.put(0);
    }

    private void aqH() {
        if (this.cBs.size() > 0) {
            this.cjj.put(ap(this.cBs));
        }
        ak(0, this.cjk.optInt(0));
        ak(1, this.cjk.optInt(1));
    }

    private void aj(int i, int i2) {
        JSONArray optJSONArray;
        if (this.bCz != null && (optJSONArray = this.cjj.optJSONArray(i)) != null) {
            ((e) this.bCz).a(i, optJSONArray, i2);
        }
    }

    private void ak(int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i == 0) {
            this.cBS = this.cBt.get(this.cBs.get(i2));
            if (this.cBS.size() <= 0) {
                jSONArray = null;
            } else {
                jSONArray = ap(this.cBS);
            }
            jSONArray2 = jSONArray;
        } else if (i == 1) {
            this.cBT = this.cBu.get(this.cBS.get(i2));
            if (this.cBT.size() > 0) {
                jSONArray2 = ap(this.cBT);
            }
        }
        if (jSONArray2 != null) {
            try {
                this.cjj.put(i + 1, jSONArray2);
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

    public void aqI() {
        if (this.bCz == null) {
            this.bCz = this.cBU.A(this.cjj).B(this.cjk).a(this.cBV).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                    List<d> E = a.this.E(((e) dialogInterface).getCurrentIndex());
                    if (a.this.cBW != null) {
                        a.this.cBW.al(E);
                    }
                }
            }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.view.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    a.this.a(dialogInterface);
                }
            }).akz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> E(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.cBs.get(jSONArray.optInt(0)));
        arrayList.add(this.cBS.get(jSONArray.optInt(1)));
        arrayList.add(this.cBT.get(jSONArray.optInt(2)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.bCz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        int i3 = i;
        while (i3 < this.cjj.length() - 1) {
            ak(i3, i3 == i ? i2 : 0);
            aj(i3 + 1, 0);
            i3++;
        }
    }

    public void a(InterfaceC0347a interfaceC0347a) {
        this.cBW = interfaceC0347a;
    }
}
