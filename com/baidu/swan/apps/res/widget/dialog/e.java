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
    private JSONArray cjj;
    private JSONArray cjk;
    private BdMultiPicker cmR;
    private BdMultiPicker.a cmS;
    private boolean cmT;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void akr() {
        this.cmR = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cmR.setLayoutParams(layoutParams);
        this.cmR.setMultiWheelData(this.cjj, this.cjk);
        if (!this.cmT) {
            this.cmR.setMultiSelectedListener(this.cmS);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        akr();
        aky().ap(this.cmR);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cjj = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cjk = jSONArray;
    }

    public void ew(boolean z) {
        this.cmT = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cmS = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cmR.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cmR.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray cmU;
        public JSONArray cmV;
        public boolean cmW;
        public BdMultiPicker.a cmX;

        public a(Context context) {
            super(context);
        }

        public a A(JSONArray jSONArray) {
            this.cmU = jSONArray;
            return this;
        }

        public a B(JSONArray jSONArray) {
            this.cmV = jSONArray;
            return this;
        }

        public a ex(boolean z) {
            this.cmW = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cmX = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akq() {
            e eVar = (e) super.akq();
            eVar.setDataArray(this.cmU);
            eVar.setDataIndex(this.cmV);
            eVar.ew(this.cmW);
            eVar.setMultiSelectedListener(this.cmX);
            return eVar;
        }
    }
}
