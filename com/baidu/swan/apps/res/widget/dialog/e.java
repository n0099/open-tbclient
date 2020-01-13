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
    private JSONArray bGh;
    private JSONArray bGi;
    private BdMultiPicker bJO;
    private BdMultiPicker.a bJP;
    private boolean bJQ;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void ZT() {
        this.bJO = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bJO.setLayoutParams(layoutParams);
        this.bJO.setMultiWheelData(this.bGh, this.bGi);
        if (!this.bJQ) {
            this.bJO.setMultiSelectedListener(this.bJP);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ZT();
        aaa().ao(this.bJO);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bGh = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bGi = jSONArray;
    }

    public void ds(boolean z) {
        this.bJQ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bJP = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bJO.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bJO.a(i, jSONArray, i2);
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public JSONArray bJR;
        public JSONArray bJS;
        public boolean bJT;
        public BdMultiPicker.a bJU;

        public a(Context context) {
            super(context);
        }

        public a z(JSONArray jSONArray) {
            this.bJR = jSONArray;
            return this;
        }

        public a A(JSONArray jSONArray) {
            this.bJS = jSONArray;
            return this;
        }

        public a dt(boolean z) {
            this.bJT = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bJU = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h ZS() {
            e eVar = (e) super.ZS();
            eVar.setDataArray(this.bJR);
            eVar.setDataIndex(this.bJS);
            eVar.ds(this.bJT);
            eVar.setMultiSelectedListener(this.bJU);
            return eVar;
        }
    }
}
