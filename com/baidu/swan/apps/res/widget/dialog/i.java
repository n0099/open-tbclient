package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes10.dex */
public class i extends h {
    private int UV;
    private Date dmQ;
    private Date dmR;
    private String dmZ;
    private boolean dna;
    private int dno;
    private BdTimePicker dsb;
    private boolean dsc;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dsc = false;
    }

    public void setHour(int i) {
        this.dno = i;
    }

    public int getHour() {
        return this.dsb.getHour();
    }

    public void setMinute(int i) {
        this.UV = i;
    }

    public int getMinute() {
        return this.dsb.getMinute();
    }

    private void aGT() {
        this.dsb = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dsb.setLayoutParams(layoutParams);
        this.dsb.setScrollCycle(true);
        this.dsb.setStartDate(this.dmQ);
        this.dsb.setmEndDate(this.dmR);
        this.dsb.setHour(this.dno);
        this.dsb.setMinute(this.UV);
        this.dsb.aGe();
        this.dsb.setDisabled(this.dna);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dsc) {
            getWindow().addFlags(4718592);
        }
        aGT();
        aHc().aB(this.dsb);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dsb != null) {
            if (this.dno != this.dsb.getHour()) {
                this.dsb.setHour(this.dno);
            }
            if (this.UV != this.dsb.getMinute()) {
                this.dsb.setMinute(this.UV);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dmZ = str;
    }

    public void setDisabled(boolean z) {
        this.dna = z;
    }

    public void setStartDate(Date date) {
        this.dmQ = date;
    }

    public void setEndDate(Date date) {
        this.dmR = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date drA;
        public Date drB;
        public Date drC;
        private String drD;
        private boolean drE;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.drA = date;
            return this;
        }

        public a j(Date date) {
            this.drB = date;
            return this;
        }

        public a k(Date date) {
            this.drC = date;
            return this;
        }

        public a rS(String str) {
            this.drD = str;
            return this;
        }

        public a gy(boolean z) {
            this.drE = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGU() {
            i iVar = (i) super.aGU();
            iVar.setFields(this.drD);
            iVar.setDisabled(this.drE);
            if (this.drC != null) {
                iVar.setHour(this.drC.getHours());
                iVar.setMinute(this.drC.getMinutes());
            }
            if (this.drA != null) {
                iVar.setStartDate(this.drA);
            }
            if (this.drB != null) {
                iVar.setEndDate(this.drB);
            }
            return iVar;
        }
    }
}
