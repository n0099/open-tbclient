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
    private JSONArray bKo;
    private JSONArray bKp;
    private BdMultiPicker bNV;
    private BdMultiPicker.a bNW;
    private boolean bNX;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void acj() {
        this.bNV = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNV.setLayoutParams(layoutParams);
        this.bNV.setMultiWheelData(this.bKo, this.bKp);
        if (!this.bNX) {
            this.bNV.setMultiSelectedListener(this.bNW);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        acj();
        acq().ao(this.bNV);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bKo = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bKp = jSONArray;
    }

    public void dz(boolean z) {
        this.bNX = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bNW = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bNV.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bNV.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray bNY;
        public JSONArray bNZ;
        public boolean bOa;
        public BdMultiPicker.a bOb;

        public a(Context context) {
            super(context);
        }

        public a z(JSONArray jSONArray) {
            this.bNY = jSONArray;
            return this;
        }

        public a A(JSONArray jSONArray) {
            this.bNZ = jSONArray;
            return this;
        }

        public a dA(boolean z) {
            this.bOa = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bOb = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            e eVar = (e) super.aci();
            eVar.setDataArray(this.bNY);
            eVar.setDataIndex(this.bNZ);
            eVar.dz(this.bOa);
            eVar.setMultiSelectedListener(this.bOb);
            return eVar;
        }
    }
}
