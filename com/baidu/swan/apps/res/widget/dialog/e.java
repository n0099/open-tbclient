package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e extends g {
    private JSONArray aIq;
    private JSONArray aIr;
    private BdMultiPicker aOH;
    private BdMultiPicker.b aOI;
    private boolean aOJ;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Lr() {
        this.aOH = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aOH.setLayoutParams(layoutParams);
        this.aOH.setMultiWheelData(this.aIq, this.aIr);
        if (!this.aOJ) {
            this.aOH.setMultiSelectedListener(this.aOI);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Lr();
        Ls().af(this.aOH);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aIq = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aIr = jSONArray;
    }

    public void ca(boolean z) {
        this.aOJ = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aOI = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aOH.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aOH.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public JSONArray aOK;
        public JSONArray aOL;
        public boolean aOM;
        public BdMultiPicker.b aON;

        public a(Context context) {
            super(context);
        }

        public a h(JSONArray jSONArray) {
            this.aOK = jSONArray;
            return this;
        }

        public a i(JSONArray jSONArray) {
            this.aOL = jSONArray;
            return this;
        }

        public a cb(boolean z) {
            this.aOM = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aON = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            e eVar = (e) super.AX();
            eVar.setDataArray(this.aOK);
            eVar.setDataIndex(this.aOL);
            eVar.ca(this.aOM);
            eVar.setMultiSelectedListener(this.aON);
            return eVar;
        }
    }
}
