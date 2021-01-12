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
    private int VN;
    private BdTimePicker dAA;
    private boolean dAB;
    private String dsE;
    private boolean dsF;
    private int dsU;
    private Date dsv;
    private Date dsw;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dAB = false;
    }

    public void setHour(int i) {
        this.dsU = i;
    }

    public int getHour() {
        return this.dAA.getHour();
    }

    public void setMinute(int i) {
        this.VN = i;
    }

    public int getMinute() {
        return this.dAA.getMinute();
    }

    private void aHv() {
        this.dAA = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dAA.setLayoutParams(layoutParams);
        this.dAA.setScrollCycle(true);
        this.dAA.setStartDate(this.dsv);
        this.dAA.setmEndDate(this.dsw);
        this.dAA.setHour(this.dsU);
        this.dAA.setMinute(this.VN);
        this.dAA.aGg();
        this.dAA.setDisabled(this.dsF);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dAB) {
            getWindow().addFlags(4718592);
        }
        aHv();
        aHI().aL(this.dAA);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dAA != null) {
            if (this.dsU != this.dAA.getHour()) {
                this.dAA.setHour(this.dsU);
            }
            if (this.VN != this.dAA.getMinute()) {
                this.dAA.setMinute(this.VN);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dsE = str;
    }

    public void setDisabled(boolean z) {
        this.dsF = z;
    }

    public void setStartDate(Date date) {
        this.dsv = date;
    }

    public void setEndDate(Date date) {
        this.dsw = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public Date dzQ;
        public Date dzR;
        public Date dzS;
        private String dzT;
        private boolean dzU;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dj(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dzQ = date;
            return this;
        }

        public a j(Date date) {
            this.dzR = date;
            return this;
        }

        public a k(Date date) {
            this.dzS = date;
            return this;
        }

        public a rf(String str) {
            this.dzT = str;
            return this;
        }

        public a gY(boolean z) {
            this.dzU = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHw() {
            i iVar = (i) super.aHw();
            iVar.setFields(this.dzT);
            iVar.setDisabled(this.dzU);
            if (this.dzS != null) {
                iVar.setHour(this.dzS.getHours());
                iVar.setMinute(this.dzS.getMinutes());
            }
            if (this.dzQ != null) {
                iVar.setStartDate(this.dzQ);
            }
            if (this.dzR != null) {
                iVar.setEndDate(this.dzR);
            }
            return iVar;
        }
    }
}
