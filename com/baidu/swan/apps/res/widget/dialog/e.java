package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends h {
    private JSONArray cKG;
    private JSONArray cKH;
    private BdMultiPicker cPc;
    private BdMultiPicker.a cPd;
    private boolean cPe;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void azj() {
        this.cPc = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cPc.setLayoutParams(layoutParams);
        this.cPc.setMultiWheelData(this.cKG, this.cKH);
        if (!this.cPe) {
            this.cPc.setMultiSelectedListener(this.cPd);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azj();
        azq().at(this.cPc);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cKG = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cKH = jSONArray;
    }

    public void fx(boolean z) {
        this.cPe = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cPd = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cPc.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cPc.a(i, jSONArray, i2);
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public JSONArray cPf;
        public JSONArray cPg;
        public boolean cPh;
        public BdMultiPicker.a cPi;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.cPf = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.cPg = jSONArray;
            return this;
        }

        public a fy(boolean z) {
            this.cPh = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cPi = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            e eVar = (e) super.azi();
            eVar.setDataArray(this.cPf);
            eVar.setDataIndex(this.cPg);
            eVar.fx(this.cPh);
            eVar.setMultiSelectedListener(this.cPi);
            return eVar;
        }
    }
}
