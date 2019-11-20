package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends g {
    private JSONArray bbK;
    private JSONArray bbL;
    private BdMultiPicker bhU;
    private BdMultiPicker.b bhV;
    private boolean bhW;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Qp() {
        this.bhU = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bhU.setLayoutParams(layoutParams);
        this.bhU.setMultiWheelData(this.bbK, this.bbL);
        if (!this.bhW) {
            this.bhU.setMultiSelectedListener(this.bhV);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Qp();
        Qq().al(this.bhU);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bbK = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bbL = jSONArray;
    }

    public void cr(boolean z) {
        this.bhW = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.bhV = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bhU.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bhU.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public JSONArray bhX;
        public JSONArray bhY;
        public boolean bhZ;
        public BdMultiPicker.b bia;

        public a(Context context) {
            super(context);
        }

        public a p(JSONArray jSONArray) {
            this.bhX = jSONArray;
            return this;
        }

        public a q(JSONArray jSONArray) {
            this.bhY = jSONArray;
            return this;
        }

        public a cs(boolean z) {
            this.bhZ = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.bia = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            e eVar = (e) super.FX();
            eVar.setDataArray(this.bhX);
            eVar.setDataIndex(this.bhY);
            eVar.cr(this.bhZ);
            eVar.setMultiSelectedListener(this.bia);
            return eVar;
        }
    }
}
