package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends h {
    private JSONArray dhk;
    private JSONArray dhl;
    private BdMultiPicker dlJ;
    private BdMultiPicker.a dlK;
    private boolean dlL;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aEv() {
        this.dlJ = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dlJ.setLayoutParams(layoutParams);
        this.dlJ.setMultiWheelData(this.dhk, this.dhl);
        if (!this.dlL) {
            this.dlJ.setMultiSelectedListener(this.dlK);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aEv();
        aEC().ax(this.dlJ);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dhk = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dhl = jSONArray;
    }

    public void ge(boolean z) {
        this.dlL = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dlK = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dlJ.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dlJ.a(i, jSONArray, i2);
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public JSONArray dlM;
        public JSONArray dlN;
        public boolean dlO;
        public BdMultiPicker.a dlP;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.dlM = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.dlN = jSONArray;
            return this;
        }

        public a gf(boolean z) {
            this.dlO = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dlP = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aEu() {
            e eVar = (e) super.aEu();
            eVar.setDataArray(this.dlM);
            eVar.setDataIndex(this.dlN);
            eVar.ge(this.dlO);
            eVar.setMultiSelectedListener(this.dlP);
            return eVar;
        }
    }
}
