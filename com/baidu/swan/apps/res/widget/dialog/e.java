package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes25.dex */
public class e extends h {
    private JSONArray dsA;
    private JSONArray dsz;
    private BdMultiPicker dwY;
    private BdMultiPicker.a dwZ;
    private boolean dxa;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aJv() {
        this.dwY = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dwY.setLayoutParams(layoutParams);
        this.dwY.setMultiWheelData(this.dsz, this.dsA);
        if (!this.dxa) {
            this.dwY.setMultiSelectedListener(this.dwZ);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aJv();
        aJC().aD(this.dwY);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dsz = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dsA = jSONArray;
    }

    public void gF(boolean z) {
        this.dxa = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dwZ = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dwY.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dwY.a(i, jSONArray, i2);
    }

    /* loaded from: classes25.dex */
    public static class a extends h.a {
        public JSONArray dxb;
        public JSONArray dxc;
        public boolean dxd;
        public BdMultiPicker.a dxe;

        public a(Context context) {
            super(context);
        }

        public a F(JSONArray jSONArray) {
            this.dxb = jSONArray;
            return this;
        }

        public a G(JSONArray jSONArray) {
            this.dxc = jSONArray;
            return this;
        }

        public a gG(boolean z) {
            this.dxd = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dxe = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cY(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aJu() {
            e eVar = (e) super.aJu();
            eVar.setDataArray(this.dxb);
            eVar.setDataIndex(this.dxc);
            eVar.gF(this.dxd);
            eVar.setMultiSelectedListener(this.dxe);
            return eVar;
        }
    }
}
