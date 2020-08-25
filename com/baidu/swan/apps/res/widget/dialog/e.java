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
    private JSONArray cKC;
    private JSONArray cKD;
    private BdMultiPicker cOY;
    private BdMultiPicker.a cOZ;
    private boolean cPa;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void azj() {
        this.cOY = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cOY.setLayoutParams(layoutParams);
        this.cOY.setMultiWheelData(this.cKC, this.cKD);
        if (!this.cPa) {
            this.cOY.setMultiSelectedListener(this.cOZ);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azj();
        azq().at(this.cOY);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cKC = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cKD = jSONArray;
    }

    public void fw(boolean z) {
        this.cPa = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cOZ = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cOY.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cOY.a(i, jSONArray, i2);
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public JSONArray cPb;
        public JSONArray cPc;
        public boolean cPd;
        public BdMultiPicker.a cPe;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.cPb = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.cPc = jSONArray;
            return this;
        }

        public a fx(boolean z) {
            this.cPd = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cPe = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            e eVar = (e) super.azi();
            eVar.setDataArray(this.cPb);
            eVar.setDataIndex(this.cPc);
            eVar.fw(this.cPd);
            eVar.setMultiSelectedListener(this.cPe);
            return eVar;
        }
    }
}
