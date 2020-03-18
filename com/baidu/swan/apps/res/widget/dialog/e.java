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
    private JSONArray bKA;
    private JSONArray bKz;
    private BdMultiPicker bOg;
    private BdMultiPicker.a bOh;
    private boolean bOi;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void acm() {
        this.bOg = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bOg.setLayoutParams(layoutParams);
        this.bOg.setMultiWheelData(this.bKz, this.bKA);
        if (!this.bOi) {
            this.bOg.setMultiSelectedListener(this.bOh);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        acm();
        act().ao(this.bOg);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bKz = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bKA = jSONArray;
    }

    public void dA(boolean z) {
        this.bOi = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bOh = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bOg.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bOg.a(i, jSONArray, i2);
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public JSONArray bOj;
        public JSONArray bOk;
        public boolean bOl;
        public BdMultiPicker.a bOm;

        public a(Context context) {
            super(context);
        }

        public a z(JSONArray jSONArray) {
            this.bOj = jSONArray;
            return this;
        }

        public a A(JSONArray jSONArray) {
            this.bOk = jSONArray;
            return this;
        }

        public a dB(boolean z) {
            this.bOl = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bOm = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cq(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acl() {
            e eVar = (e) super.acl();
            eVar.setDataArray(this.bOj);
            eVar.setDataIndex(this.bOk);
            eVar.dA(this.bOl);
            eVar.setMultiSelectedListener(this.bOm);
            return eVar;
        }
    }
}
