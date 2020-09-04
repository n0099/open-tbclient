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
    private String cKA;
    private boolean cKB;
    private int cKP;
    private Date cKr;
    private Date cKs;
    private BdTimePicker cPy;
    private boolean cPz;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cPz = false;
    }

    public void setHour(int i) {
        this.cKP = i;
    }

    public int getHour() {
        return this.cPy.getHour();
    }

    public void setMinute(int i) {
        this.Ui = i;
    }

    public int getMinute() {
        return this.cPy.getMinute();
    }

    private void azh() {
        this.cPy = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cPy.setLayoutParams(layoutParams);
        this.cPy.setScrollCycle(true);
        this.cPy.setStartDate(this.cKr);
        this.cPy.setmEndDate(this.cKs);
        this.cPy.setHour(this.cKP);
        this.cPy.setMinute(this.Ui);
        this.cPy.ays();
        this.cPy.setDisabled(this.cKB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cPz) {
            getWindow().addFlags(4718592);
        }
        azh();
        azq().at(this.cPy);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cPy != null) {
            if (this.cKP != this.cPy.getHour()) {
                this.cPy.setHour(this.cKP);
            }
            if (this.Ui != this.cPy.getMinute()) {
                this.cPy.setMinute(this.Ui);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cKA = str;
    }

    public void setDisabled(boolean z) {
        this.cKB = z;
    }

    public void setStartDate(Date date) {
        this.cKr = date;
    }

    public void setEndDate(Date date) {
        this.cKs = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public Date cOX;
        public Date cOY;
        public Date cOZ;
        private String cPa;
        private boolean cPb;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.cOX = date;
            return this;
        }

        public a j(Date date) {
            this.cOY = date;
            return this;
        }

        public a k(Date date) {
            this.cOZ = date;
            return this;
        }

        public a qg(String str) {
            this.cPa = str;
            return this;
        }

        public a fI(boolean z) {
            this.cPb = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azi() {
            i iVar = (i) super.azi();
            iVar.setFields(this.cPa);
            iVar.setDisabled(this.cPb);
            if (this.cOZ != null) {
                iVar.setHour(this.cOZ.getHours());
                iVar.setMinute(this.cOZ.getMinutes());
            }
            if (this.cOX != null) {
                iVar.setStartDate(this.cOX);
            }
            if (this.cOY != null) {
                iVar.setEndDate(this.cOY);
            }
            return iVar;
        }
    }
}
