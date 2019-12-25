package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class e extends h {
    private JSONArray bFw;
    private JSONArray bFx;
    private BdMultiPicker bJe;
    private BdMultiPicker.a bJf;
    private boolean bJg;

    public e(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    private void Zw() {
        this.bJe = new BdMultiPicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bJe.setLayoutParams(layoutParams);
        this.bJe.setMultiWheelData(this.bFw, this.bFx);
        if (!this.bJg) {
            this.bJe.setMultiSelectedListener(this.bJf);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Zw();
        ZD().ak(this.bJe);
    }

    public void setDataArray(JSONArray jSONArray) {
        this.bFw = jSONArray;
    }

    public void setDataIndex(JSONArray jSONArray) {
        this.bFx = jSONArray;
    }

    public void dn(boolean z) {
        this.bJg = z;
    }

    public void setMultiSelectedListener(BdMultiPicker.a aVar) {
        this.bJf = aVar;
    }

    public JSONArray getCurrentIndex() {
        return this.bJe.getCurrentIndex();
    }

    public void a(int i, JSONArray jSONArray, int i2) {
        this.bJe.a(i, jSONArray, i2);
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public JSONArray bJh;
        public JSONArray bJi;
        public boolean bJj;
        public BdMultiPicker.a bJk;

        public a(Context context) {
            super(context);
        }

        public a y(JSONArray jSONArray) {
            this.bJh = jSONArray;
            return this;
        }

        public a z(JSONArray jSONArray) {
            this.bJi = jSONArray;
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m19do(boolean z) {
            this.bJj = z;
            return this;
        }

        public a a(BdMultiPicker.a aVar) {
            this.bJk = aVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new e(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h Zv() {
            e eVar = (e) super.Zv();
            eVar.setDataArray(this.bJh);
            eVar.setDataIndex(this.bJi);
            eVar.dn(this.bJj);
            eVar.setMultiSelectedListener(this.bJk);
            return eVar;
        }
    }
}
