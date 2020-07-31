package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class e extends h {
    private JSONArray cCo;
    private JSONArray cCp;
    private BdMultiPicker cGa;
    private BdMultiPicker.a cGb;
    private boolean cGc;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aqX() {
        this.cGa = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cGa.setLayoutParams(layoutParams);
        this.cGa.setMultiWheelData(this.cCo, this.cCp);
        if (!this.cGc) {
            this.cGa.setMultiSelectedListener(this.cGb);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aqX();
        are().as(this.cGa);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cCo = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cCp = jSONArray;
    }

    public void fd(boolean z) {
        this.cGc = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cGb = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cGa.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cGa.a(i, jSONArray, i2);
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public JSONArray cGd;
        public JSONArray cGe;
        public boolean cGf;
        public BdMultiPicker.a cGg;

        public a(Context context) {
            super(context);
        }

        public a C(JSONArray jSONArray) {
            this.cGd = jSONArray;
            return this;
        }

        public a D(JSONArray jSONArray) {
            this.cGe = jSONArray;
            return this;
        }

        public a fe(boolean z) {
            this.cGf = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cGg = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ch(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aqW() {
            e eVar = (e) super.aqW();
            eVar.setDataArray(this.cGd);
            eVar.setDataIndex(this.cGe);
            eVar.fd(this.cGf);
            eVar.setMultiSelectedListener(this.cGg);
            return eVar;
        }
    }
}
