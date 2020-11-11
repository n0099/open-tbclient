package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class e extends h {
    private JSONArray dnf;
    private JSONArray dng;
    private BdMultiPicker drF;
    private BdMultiPicker.a drG;
    private boolean drH;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aGV() {
        this.drF = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.drF.setLayoutParams(layoutParams);
        this.drF.setMultiWheelData(this.dnf, this.dng);
        if (!this.drH) {
            this.drF.setMultiSelectedListener(this.drG);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aGV();
        aHc().aB(this.drF);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dnf = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dng = jSONArray;
    }

    public void gn(boolean z) {
        this.drH = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.drG = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.drF.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.drF.a(i, jSONArray, i2);
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public JSONArray drI;
        public JSONArray drJ;
        public boolean drK;
        public BdMultiPicker.a drL;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.drI = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.drJ = jSONArray;
            return this;
        }

        public a go(boolean z) {
            this.drK = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.drL = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGU() {
            e eVar = (e) super.aGU();
            eVar.setDataArray(this.drI);
            eVar.setDataIndex(this.drJ);
            eVar.gn(this.drK);
            eVar.setMultiSelectedListener(this.drL);
            return eVar;
        }
    }
}
