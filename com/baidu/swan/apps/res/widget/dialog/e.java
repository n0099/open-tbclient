package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class e extends h {
    private BdMultiPicker cDn;
    private BdMultiPicker.a cDo;
    private boolean cDp;
    private JSONArray czE;
    private JSONArray czF;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void apo() {
        this.cDn = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cDn.setLayoutParams(layoutParams);
        this.cDn.setMultiWheelData(this.czE, this.czF);
        if (!this.cDp) {
            this.cDn.setMultiSelectedListener(this.cDo);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        apo();
        apv().ap(this.cDn);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.czE = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.czF = jSONArray;
    }

    public void eU(boolean z) {
        this.cDp = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cDo = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cDn.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cDn.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray cDq;
        public JSONArray cDr;
        public boolean cDs;
        public BdMultiPicker.a cDt;

        public a(Context context) {
            super(context);
        }

        public a B(JSONArray jSONArray) {
            this.cDq = jSONArray;
            return this;
        }

        public a C(JSONArray jSONArray) {
            this.cDr = jSONArray;
            return this;
        }

        public a eV(boolean z) {
            this.cDs = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cDt = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h apn() {
            e eVar = (e) super.apn();
            eVar.setDataArray(this.cDq);
            eVar.setDataIndex(this.cDr);
            eVar.eU(this.cDs);
            eVar.setMultiSelectedListener(this.cDt);
            return eVar;
        }
    }
}
