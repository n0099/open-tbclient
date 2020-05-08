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
    private JSONArray cjp;
    private JSONArray cjq;
    private BdMultiPicker cmX;
    private BdMultiPicker.a cmY;
    private boolean cmZ;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void akq() {
        this.cmX = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cmX.setLayoutParams(layoutParams);
        this.cmX.setMultiWheelData(this.cjp, this.cjq);
        if (!this.cmZ) {
            this.cmX.setMultiSelectedListener(this.cmY);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        akq();
        akx().ap(this.cmX);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cjp = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cjq = jSONArray;
    }

    public void ew(boolean z) {
        this.cmZ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.cmY = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.cmX.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.cmX.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray cna;
        public JSONArray cnb;
        public boolean cnc;
        public BdMultiPicker.a cnd;

        public a(Context context) {
            super(context);
        }

        public a A(JSONArray jSONArray) {
            this.cna = jSONArray;
            return this;
        }

        public a B(JSONArray jSONArray) {
            this.cnb = jSONArray;
            return this;
        }

        public a ex(boolean z) {
            this.cnc = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.cnd = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h bS(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akp() {
            e eVar = (e) super.akp();
            eVar.setDataArray(this.cna);
            eVar.setDataIndex(this.cnb);
            eVar.ew(this.cnc);
            eVar.setMultiSelectedListener(this.cnd);
            return eVar;
        }
    }
}
