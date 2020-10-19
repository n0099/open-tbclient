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
    private JSONArray cYJ;
    private JSONArray cYK;
    private BdMultiPicker ddi;
    private BdMultiPicker.a ddj;
    private boolean ddk;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aCB() {
        this.ddi = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.ddi.setLayoutParams(layoutParams);
        this.ddi.setMultiWheelData(this.cYJ, this.cYK);
        if (!this.ddk) {
            this.ddi.setMultiSelectedListener(this.ddj);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aCB();
        aCI().aw(this.ddi);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.cYJ = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.cYK = jSONArray;
    }

    public void fR(boolean z) {
        this.ddk = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.ddj = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.ddi.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.ddi.a(i, jSONArray, i2);
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public JSONArray ddl;
        public JSONArray ddm;
        public boolean ddn;
        public BdMultiPicker.a ddo;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.ddl = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.ddm = jSONArray;
            return this;
        }

        public a fS(boolean z) {
            this.ddn = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.ddo = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aCA() {
            e eVar = (e) super.aCA();
            eVar.setDataArray(this.ddl);
            eVar.setDataIndex(this.ddm);
            eVar.fR(this.ddn);
            eVar.setMultiSelectedListener(this.ddo);
            return eVar;
        }
    }
}
