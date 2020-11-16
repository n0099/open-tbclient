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
    private JSONArray dly;
    private JSONArray dlz;
    private BdMultiPicker dpX;
    private BdMultiPicker.a dpY;
    private boolean dpZ;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aGn() {
        this.dpX = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dpX.setLayoutParams(layoutParams);
        this.dpX.setMultiWheelData(this.dly, this.dlz);
        if (!this.dpZ) {
            this.dpX.setMultiSelectedListener(this.dpY);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aGn();
        aGu().aB(this.dpX);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dly = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dlz = jSONArray;
    }

    public void gq(boolean z) {
        this.dpZ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dpY = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dpX.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dpX.a(i, jSONArray, i2);
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public JSONArray dqa;
        public JSONArray dqb;
        public boolean dqc;
        public BdMultiPicker.a dqd;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.dqa = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.dqb = jSONArray;
            return this;
        }

        public a gr(boolean z) {
            this.dqc = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dqd = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGm() {
            e eVar = (e) super.aGm();
            eVar.setDataArray(this.dqa);
            eVar.setDataIndex(this.dqb);
            eVar.gq(this.dqc);
            eVar.setMultiSelectedListener(this.dqd);
            return eVar;
        }
    }
}
