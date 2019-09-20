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
    private JSONArray aIO;
    private JSONArray aIP;
    private BdMultiPicker aPf;
    private BdMultiPicker.b aPg;
    private boolean aPh;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Lv() {
        this.aPf = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aPf.setLayoutParams(layoutParams);
        this.aPf.setMultiWheelData(this.aIO, this.aIP);
        if (!this.aPh) {
            this.aPf.setMultiSelectedListener(this.aPg);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Lv();
        Lw().af(this.aPf);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.aIO = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.aIP = jSONArray;
    }

    public void ca(boolean z) {
        this.aPh = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.aPg = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.aPf.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.aPf.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public JSONArray aPi;
        public JSONArray aPj;
        public boolean aPk;
        public BdMultiPicker.b aPl;

        public a(Context context) {
            super(context);
        }

        public a h(JSONArray jSONArray) {
            this.aPi = jSONArray;
            return this;
        }

        public a i(JSONArray jSONArray) {
            this.aPj = jSONArray;
            return this;
        }

        public a cb(boolean z) {
            this.aPk = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.aPl = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Bb() {
            e eVar = (e) super.Bb();
            eVar.setDataArray(this.aPi);
            eVar.setDataIndex(this.aPj);
            eVar.ca(this.aPk);
            eVar.setMultiSelectedListener(this.aPl);
            return eVar;
        }
    }
}
