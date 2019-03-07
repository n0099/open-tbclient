package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends e {
    private JSONArray aFK;
    private JSONArray aFL;
    private BdMultiPicker aLZ;
    private BdMultiPicker.b aMa;
    private boolean aMb;

    public d(Context context) {
        super(context, b.i.NoTitleDialog);
    }

    private void Iq() {
        this.aLZ = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aLZ.setLayoutParams(layoutParams);
        this.aLZ.setMultiWheelData(this.aFK, this.aFL);
        if (!this.aMb) {
            this.aLZ.setMultiSelectedListener(this.aMa);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Iq();
        Ir().ad(this.aLZ);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aFK = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aFL = jSONArray;
    }

    public void bN(boolean z) {
        this.aMb = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aMa = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aLZ.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aLZ.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public JSONArray aMc;
        public JSONArray aMd;
        public boolean aMe;
        public BdMultiPicker.b aMf;

        public a(Context context) {
            super(context);
        }

        public a j(JSONArray jSONArray) {
            this.aMc = jSONArray;
            return this;
        }

        public a k(JSONArray jSONArray) {
            this.aMd = jSONArray;
            return this;
        }

        public a bO(boolean z) {
            this.aMe = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aMf = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new d(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            d dVar = (d) super.zr();
            dVar.setDataArray(this.aMc);
            dVar.setDataIndex(this.aMd);
            dVar.bN(this.aMe);
            dVar.setMultiSelectedListener(this.aMf);
            return dVar;
        }
    }
}
