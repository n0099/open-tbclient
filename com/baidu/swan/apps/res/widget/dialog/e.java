package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends h {
    private BdMultiPicker dCa;
    private BdMultiPicker.a dCb;
    private boolean dCc;
    private JSONArray duV;
    private JSONArray duW;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aHQ() {
        this.dCa = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dCa.setLayoutParams(layoutParams);
        this.dCa.setMultiWheelData(this.duV, this.duW);
        if (!this.dCc) {
            this.dCa.setMultiSelectedListener(this.dCb);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHQ();
        aIb().aH(this.dCa);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.duV = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.duW = jSONArray;
    }

    public void gP(boolean z) {
        this.dCc = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dCb = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dCa.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dCa.a(i, jSONArray, i2);
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public JSONArray dCd;
        public JSONArray dCe;
        public boolean dCf;
        public BdMultiPicker.a dCg;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.dCd = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.dCe = jSONArray;
            return this;
        }

        public a gQ(boolean z) {
            this.dCf = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dCg = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h di(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHP() {
            e eVar = (e) super.aHP();
            eVar.setDataArray(this.dCd);
            eVar.setDataIndex(this.dCe);
            eVar.gP(this.dCf);
            eVar.setMultiSelectedListener(this.dCg);
            return eVar;
        }
    }
}
