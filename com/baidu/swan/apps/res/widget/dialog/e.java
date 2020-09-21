package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends h {
    private JSONArray cMG;
    private JSONArray cMH;
    private BdMultiPicker cRc;
    private BdMultiPicker.a cRd;
    private boolean cRe;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void azS() {
        this.cRc = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cRc.setLayoutParams(layoutParams);
        this.cRc.setMultiWheelData(this.cMG, this.cMH);
        if (!this.cRe) {
            this.cRc.setMultiSelectedListener(this.cRd);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azS();
        azZ().av(this.cRc);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cMG = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cMH = jSONArray;
    }

    public void fv(boolean z) {
        this.cRe = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cRd = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cRc.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cRc.a(i, jSONArray, i2);
    }

    /* loaded from: classes3.dex */
    public static class a extends h.a {
        public JSONArray cRf;
        public JSONArray cRg;
        public boolean cRh;
        public BdMultiPicker.a cRi;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.cRf = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.cRg = jSONArray;
            return this;
        }

        public a fw(boolean z) {
            this.cRh = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cRi = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cm(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azR() {
            e eVar = (e) super.azR();
            eVar.setDataArray(this.cRf);
            eVar.setDataIndex(this.cRg);
            eVar.fv(this.cRh);
            eVar.setMultiSelectedListener(this.cRi);
            return eVar;
        }
    }
}
