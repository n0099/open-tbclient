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
    private JSONArray aFP;
    private JSONArray aFQ;
    private BdMultiPicker aMe;
    private BdMultiPicker.b aMf;
    private boolean aMg;

    public d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Io() {
        this.aMe = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMe.setLayoutParams(layoutParams);
        this.aMe.setMultiWheelData(this.aFP, this.aFQ);
        if (!this.aMg) {
            this.aMe.setMultiSelectedListener(this.aMf);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Io();
        Ip().ad(this.aMe);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aFP = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aFQ = jSONArray;
    }

    public void bN(boolean z) {
        this.aMg = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aMf = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aMe.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aMe.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public JSONArray aMh;
        public JSONArray aMi;
        public boolean aMj;
        public BdMultiPicker.b aMk;

        public a(Context context) {
            super(context);
        }

        public a j(JSONArray jSONArray) {
            this.aMh = jSONArray;
            return this;
        }

        public a k(JSONArray jSONArray) {
            this.aMi = jSONArray;
            return this;
        }

        public a bO(boolean z) {
            this.aMj = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aMk = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new d(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            d dVar = (d) super.zq();
            dVar.setDataArray(this.aMh);
            dVar.setDataIndex(this.aMi);
            dVar.bN(this.aMj);
            dVar.setMultiSelectedListener(this.aMk);
            return dVar;
        }
    }
}
