package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends h {
    private JSONArray dsK;
    private JSONArray dsL;
    private BdMultiPicker dzV;
    private BdMultiPicker.a dzW;
    private boolean dzX;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aHx() {
        this.dzV = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dzV.setLayoutParams(layoutParams);
        this.dzV.setMultiWheelData(this.dsK, this.dsL);
        if (!this.dzX) {
            this.dzV.setMultiSelectedListener(this.dzW);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHx();
        aHI().aL(this.dzV);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dsK = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dsL = jSONArray;
    }

    public void gN(boolean z) {
        this.dzX = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dzW = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dzV.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dzV.a(i, jSONArray, i2);
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public boolean dAa;
        public BdMultiPicker.a dAb;
        public JSONArray dzY;
        public JSONArray dzZ;

        public a(Context context) {
            super(context);
        }

        public a F(JSONArray jSONArray) {
            this.dzY = jSONArray;
            return this;
        }

        public a G(JSONArray jSONArray) {
            this.dzZ = jSONArray;
            return this;
        }

        public a gO(boolean z) {
            this.dAa = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dAb = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dj(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHw() {
            e eVar = (e) super.aHw();
            eVar.setDataArray(this.dzY);
            eVar.setDataIndex(this.dzZ);
            eVar.gN(this.dAa);
            eVar.setMultiSelectedListener(this.dAb);
            return eVar;
        }
    }
}
