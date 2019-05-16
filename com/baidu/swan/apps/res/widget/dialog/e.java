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
    private JSONArray aHI;
    private JSONArray aHJ;
    private BdMultiPicker aNX;
    private BdMultiPicker.b aNY;
    private boolean aNZ;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void KE() {
        this.aNX = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aNX.setLayoutParams(layoutParams);
        this.aNX.setMultiWheelData(this.aHI, this.aHJ);
        if (!this.aNZ) {
            this.aNX.setMultiSelectedListener(this.aNY);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        KE();
        KF().ad(this.aNX);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aHI = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aHJ = jSONArray;
    }

    public void bX(boolean z) {
        this.aNZ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aNY = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aNX.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aNX.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public JSONArray aOa;
        public JSONArray aOb;
        public boolean aOc;
        public BdMultiPicker.b aOd;

        public a(Context context) {
            super(context);
        }

        public a h(JSONArray jSONArray) {
            this.aOa = jSONArray;
            return this;
        }

        public a i(JSONArray jSONArray) {
            this.aOb = jSONArray;
            return this;
        }

        public a bY(boolean z) {
            this.aOc = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aOd = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            e eVar = (e) super.Aq();
            eVar.setDataArray(this.aOa);
            eVar.setDataIndex(this.aOb);
            eVar.bX(this.aOc);
            eVar.setMultiSelectedListener(this.aOd);
            return eVar;
        }
    }
}
