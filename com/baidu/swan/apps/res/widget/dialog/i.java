package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes8.dex */
public class i extends h {
    private int Ui;
    private int cKL;
    private Date cKn;
    private Date cKo;
    private String cKw;
    private boolean cKx;
    private BdTimePicker cPu;
    private boolean cPv;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cPv = false;
    }

    public void setHour(int i) {
        this.cKL = i;
    }

    public int getHour() {
        return this.cPu.getHour();
    }

    public void setMinute(int i) {
        this.Ui = i;
    }

    public int getMinute() {
        return this.cPu.getMinute();
    }

    private void azh() {
        this.cPu = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cPu.setLayoutParams(layoutParams);
        this.cPu.setScrollCycle(true);
        this.cPu.setStartDate(this.cKn);
        this.cPu.setmEndDate(this.cKo);
        this.cPu.setHour(this.cKL);
        this.cPu.setMinute(this.Ui);
        this.cPu.ays();
        this.cPu.setDisabled(this.cKx);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cPv) {
            getWindow().addFlags(4718592);
        }
        azh();
        azq().at(this.cPu);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cPu != null) {
            if (this.cKL != this.cPu.getHour()) {
                this.cPu.setHour(this.cKL);
            }
            if (this.Ui != this.cPu.getMinute()) {
                this.cPu.setMinute(this.Ui);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cKw = str;
    }

    public void setDisabled(boolean z) {
        this.cKx = z;
    }

    public void setStartDate(Date date) {
        this.cKn = date;
    }

    public void setEndDate(Date date) {
        this.cKo = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public Date cOT;
        public Date cOU;
        public Date cOV;
        private String cOW;
        private boolean cOX;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.cOT = date;
            return this;
        }

        public a j(Date date) {
            this.cOU = date;
            return this;
        }

        public a k(Date date) {
            this.cOV = date;
            return this;
        }

        public a qf(String str) {
            this.cOW = str;
            return this;
        }

        public a fH(boolean z) {
            this.cOX = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            i iVar = (i) super.azi();
            iVar.setFields(this.cOW);
            iVar.setDisabled(this.cOX);
            if (this.cOV != null) {
                iVar.setHour(this.cOV.getHours());
                iVar.setMinute(this.cOV.getMinutes());
            }
            if (this.cOT != null) {
                iVar.setStartDate(this.cOT);
            }
            if (this.cOU != null) {
                iVar.setEndDate(this.cOU);
            }
            return iVar;
        }
    }
}
