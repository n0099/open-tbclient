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
    private JSONArray aFO;
    private JSONArray aFP;
    private BdMultiPicker aMd;
    private BdMultiPicker.b aMe;
    private boolean aMf;

    public d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Io() {
        this.aMd = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMd.setLayoutParams(layoutParams);
        this.aMd.setMultiWheelData(this.aFO, this.aFP);
        if (!this.aMf) {
            this.aMd.setMultiSelectedListener(this.aMe);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Io();
        Ip().ad(this.aMd);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aFO = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aFP = jSONArray;
    }

    public void bN(boolean z) {
        this.aMf = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aMe = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aMd.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aMd.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public JSONArray aMg;
        public JSONArray aMh;
        public boolean aMi;
        public BdMultiPicker.b aMj;

        public a(Context context) {
            super(context);
        }

        public a j(JSONArray jSONArray) {
            this.aMg = jSONArray;
            return this;
        }

        public a k(JSONArray jSONArray) {
            this.aMh = jSONArray;
            return this;
        }

        public a bO(boolean z) {
            this.aMi = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aMj = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new d(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            d dVar = (d) super.zq();
            dVar.setDataArray(this.aMg);
            dVar.setDataIndex(this.aMh);
            dVar.bN(this.aMi);
            dVar.setMultiSelectedListener(this.aMj);
            return dVar;
        }
    }
}
