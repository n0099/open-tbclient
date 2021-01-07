package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes9.dex */
public class i extends h {
    private int VQ;
    private BdTimePicker dFm;
    private boolean dFn;
    private int dxH;
    private Date dxi;
    private Date dxj;
    private String dxr;
    private boolean dxs;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dFn = false;
    }

    public void setHour(int i) {
        this.dxH = i;
    }

    public int getHour() {
        return this.dFm.getHour();
    }

    public void setMinute(int i) {
        this.VQ = i;
    }

    public int getMinute() {
        return this.dFm.getMinute();
    }

    private void aLp() {
        this.dFm = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dFm.setLayoutParams(layoutParams);
        this.dFm.setScrollCycle(true);
        this.dFm.setStartDate(this.dxi);
        this.dFm.setmEndDate(this.dxj);
        this.dFm.setHour(this.dxH);
        this.dFm.setMinute(this.VQ);
        this.dFm.aKa();
        this.dFm.setDisabled(this.dxs);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dFn) {
            getWindow().addFlags(4718592);
        }
        aLp();
        aLC().aL(this.dFm);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dFm != null) {
            if (this.dxH != this.dFm.getHour()) {
                this.dFm.setHour(this.dxH);
            }
            if (this.VQ != this.dFm.getMinute()) {
                this.dFm.setMinute(this.VQ);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dxr = str;
    }

    public void setDisabled(boolean z) {
        this.dxs = z;
    }

    public void setStartDate(Date date) {
        this.dxi = date;
    }

    public void setEndDate(Date date) {
        this.dxj = date;
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public Date dEC;
        public Date dED;
        public Date dEE;
        private String dEF;
        private boolean dEG;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dk(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dEC = date;
            return this;
        }

        public a j(Date date) {
            this.dED = date;
            return this;
        }

        public a k(Date date) {
            this.dEE = date;
            return this;
        }

        public a sq(String str) {
            this.dEF = str;
            return this;
        }

        public a hc(boolean z) {
            this.dEG = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aLq() {
            i iVar = (i) super.aLq();
            iVar.setFields(this.dEF);
            iVar.setDisabled(this.dEG);
            if (this.dEE != null) {
                iVar.setHour(this.dEE.getHours());
                iVar.setMinute(this.dEE.getMinutes());
            }
            if (this.dEC != null) {
                iVar.setStartDate(this.dEC);
            }
            if (this.dED != null) {
                iVar.setEndDate(this.dED);
            }
            return iVar;
        }
    }
}
