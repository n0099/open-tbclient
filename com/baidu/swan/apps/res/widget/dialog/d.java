package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends e {
    private JSONArray aFL;
    private JSONArray aFM;
    private BdMultiPicker aMa;
    private BdMultiPicker.b aMb;
    private boolean aMc;

    public d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Iq() {
        this.aMa = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMa.setLayoutParams(layoutParams);
        this.aMa.setMultiWheelData(this.aFL, this.aFM);
        if (!this.aMc) {
            this.aMa.setMultiSelectedListener(this.aMb);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Iq();
        Ir().ad(this.aMa);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aFL = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aFM = jSONArray;
    }

    public void bN(boolean z) {
        this.aMc = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aMb = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aMa.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aMa.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public JSONArray aMd;
        public JSONArray aMe;
        public boolean aMf;
        public BdMultiPicker.b aMg;

        public a(Context context) {
            super(context);
        }

        public a j(JSONArray jSONArray) {
            this.aMd = jSONArray;
            return this;
        }

        public a k(JSONArray jSONArray) {
            this.aMe = jSONArray;
            return this;
        }

        public a bO(boolean z) {
            this.aMf = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aMg = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new d(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            d dVar = (d) super.zr();
            dVar.setDataArray(this.aMd);
            dVar.setDataIndex(this.aMe);
            dVar.bN(this.aMf);
            dVar.setMultiSelectedListener(this.aMg);
            return dVar;
        }
    }
}
