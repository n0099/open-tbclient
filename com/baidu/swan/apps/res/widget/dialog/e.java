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
    private JSONArray bcc;
    private JSONArray bcd;
    private BdMultiPicker bio;
    private BdMultiPicker.b bip;
    private boolean biq;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Qo() {
        this.bio = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bio.setLayoutParams(layoutParams);
        this.bio.setMultiWheelData(this.bcc, this.bcd);
        if (!this.biq) {
            this.bio.setMultiSelectedListener(this.bip);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Qo();
        Qp().al(this.bio);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bcc = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bcd = jSONArray;
    }

    public void cr(boolean z) {
        this.biq = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.b bVar) {
        this.bip = bVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bio.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bio.a(i, jSONArray, i2);
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public JSONArray bir;
        public JSONArray bis;
        public boolean bit;
        public BdMultiPicker.b biu;

        public a(Context context) {
            super(context);
        }

        public a p(JSONArray jSONArray) {
            this.bir = jSONArray;
            return this;
        }

        public a q(JSONArray jSONArray) {
            this.bis = jSONArray;
            return this;
        }

        public a cs(boolean z) {
            this.bit = z;
            return this;
        }

        public a a(BdMultiPicker.b bVar) {
            this.biu = bVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FW() {
            e eVar = (e) super.FW();
            eVar.setDataArray(this.bir);
            eVar.setDataIndex(this.bis);
            eVar.cr(this.bit);
            eVar.setMultiSelectedListener(this.biu);
            return eVar;
        }
    }
}
