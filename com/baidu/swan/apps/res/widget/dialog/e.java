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
    private JSONArray bKn;
    private JSONArray bKo;
    private BdMultiPicker bNU;
    private BdMultiPicker.a bNV;
    private boolean bNW;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void acj() {
        this.bNU = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNU.setLayoutParams(layoutParams);
        this.bNU.setMultiWheelData(this.bKn, this.bKo);
        if (!this.bNW) {
            this.bNU.setMultiSelectedListener(this.bNV);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        acj();
        acq().ao(this.bNU);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bKn = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bKo = jSONArray;
    }

    public void dz(boolean z) {
        this.bNW = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bNV = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bNU.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bNU.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray bNX;
        public JSONArray bNY;
        public boolean bNZ;
        public BdMultiPicker.a bOa;

        public a(Context context) {
            super(context);
        }

        public a z(JSONArray jSONArray) {
            this.bNX = jSONArray;
            return this;
        }

        public a A(JSONArray jSONArray) {
            this.bNY = jSONArray;
            return this;
        }

        public a dA(boolean z) {
            this.bNZ = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bOa = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            e eVar = (e) super.aci();
            eVar.setDataArray(this.bNX);
            eVar.setDataIndex(this.bNY);
            eVar.dz(this.bNZ);
            eVar.setMultiSelectedListener(this.bOa);
            return eVar;
        }
    }
}
