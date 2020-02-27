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
    private JSONArray bKm;
    private JSONArray bKn;
    private BdMultiPicker bNT;
    private BdMultiPicker.a bNU;
    private boolean bNV;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void ach() {
        this.bNT = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNT.setLayoutParams(layoutParams);
        this.bNT.setMultiWheelData(this.bKm, this.bKn);
        if (!this.bNV) {
            this.bNT.setMultiSelectedListener(this.bNU);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ach();
        aco().ao(this.bNT);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bKm = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bKn = jSONArray;
    }

    public void dz(boolean z) {
        this.bNV = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bNU = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bNT.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bNT.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray bNW;
        public JSONArray bNX;
        public boolean bNY;
        public BdMultiPicker.a bNZ;

        public a(Context context) {
            super(context);
        }

        public a z(JSONArray jSONArray) {
            this.bNW = jSONArray;
            return this;
        }

        public a A(JSONArray jSONArray) {
            this.bNX = jSONArray;
            return this;
        }

        public a dA(boolean z) {
            this.bNY = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bNZ = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acg() {
            e eVar = (e) super.acg();
            eVar.setDataArray(this.bNW);
            eVar.setDataIndex(this.bNX);
            eVar.dz(this.bNY);
            eVar.setMultiSelectedListener(this.bNZ);
            return eVar;
        }
    }
}
