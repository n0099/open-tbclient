package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class e extends h {
    private BdMultiPicker dDB;
    private BdMultiPicker.a dDC;
    private boolean dDD;
    private JSONArray dww;
    private JSONArray dwx;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void aHT() {
        this.dDB = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dDB.setLayoutParams(layoutParams);
        this.dDB.setMultiWheelData(this.dww, this.dwx);
        if (!this.dDD) {
            this.dDB.setMultiSelectedListener(this.dDC);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHT();
        aIe().aH(this.dDB);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.dww = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.dwx = jSONArray;
    }

    public void gP(boolean z) {
        this.dDD = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.dDC = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.dDB.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.dDB.a(i, jSONArray, i2);
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public JSONArray dDE;
        public JSONArray dDF;
        public boolean dDG;
        public BdMultiPicker.a dDH;

        public a(Context context) {
            super(context);
        }

        public a E(JSONArray jSONArray) {
            this.dDE = jSONArray;
            return this;
        }

        public a F(JSONArray jSONArray) {
            this.dDF = jSONArray;
            return this;
        }

        public a gQ(boolean z) {
            this.dDG = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.dDH = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dh(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHS() {
            e eVar = (e) super.aHS();
            eVar.setDataArray(this.dDE);
            eVar.setDataIndex(this.dDF);
            eVar.gP(this.dDG);
            eVar.setMultiSelectedListener(this.dDH);
            return eVar;
        }
    }
}
