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
    private JSONArray cuT;
    private JSONArray cuU;
    private BdMultiPicker cyD;
    private BdMultiPicker.a cyE;
    private boolean cyF;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aoh() {
        this.cyD = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cyD.setLayoutParams(layoutParams);
        this.cyD.setMultiWheelData(this.cuT, this.cuU);
        if (!this.cyF) {
            this.cyD.setMultiSelectedListener(this.cyE);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aoh();
        aoo().ap(this.cyD);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cuT = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cuU = jSONArray;
    }

    public void eP(boolean z) {
        this.cyF = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cyE = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cyD.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cyD.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray cyG;
        public JSONArray cyH;
        public boolean cyI;
        public BdMultiPicker.a cyJ;

        public a(Context context) {
            super(context);
        }

        public a B(JSONArray jSONArray) {
            this.cyG = jSONArray;
            return this;
        }

        public a C(JSONArray jSONArray) {
            this.cyH = jSONArray;
            return this;
        }

        public a eQ(boolean z) {
            this.cyI = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cyJ = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cd(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aog() {
            e eVar = (e) super.aog();
            eVar.setDataArray(this.cyG);
            eVar.setDataIndex(this.cyH);
            eVar.eP(this.cyI);
            eVar.setMultiSelectedListener(this.cyJ);
            return eVar;
        }
    }
}
