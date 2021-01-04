package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends h {
    private BdMultiPicker dEH;
    private BdMultiPicker.a dEI;
    private boolean dEJ;
    private JSONArray dxx;
    private JSONArray dxy;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aLq() {
        this.dEH = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dEH.setLayoutParams(layoutParams);
        this.dEH.setMultiWheelData(this.dxx, this.dxy);
        if (!this.dEJ) {
            this.dEH.setMultiSelectedListener(this.dEI);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aLq();
        aLB().aL(this.dEH);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dxx = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dxy = jSONArray;
    }

    public void gR(boolean z) {
        this.dEJ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dEI = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dEH.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dEH.a(i, jSONArray, i2);
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public JSONArray dEK;
        public JSONArray dEL;
        public boolean dEM;
        public BdMultiPicker.a dEN;

        public a(Context context) {
            super(context);
        }

        public a F(JSONArray jSONArray) {
            this.dEK = jSONArray;
            return this;
        }

        public a G(JSONArray jSONArray) {
            this.dEL = jSONArray;
            return this;
        }

        public a gS(boolean z) {
            this.dEM = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dEN = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dk(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aLp() {
            e eVar = (e) super.aLp();
            eVar.setDataArray(this.dEK);
            eVar.setDataIndex(this.dEL);
            eVar.gR(this.dEM);
            eVar.setMultiSelectedListener(this.dEN);
            return eVar;
        }
    }
}
