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
    private Date bFS;
    private Date bFT;
    private String bGb;
    private boolean bGc;
    private int bGq;
    private BdTimePicker bKk;
    private boolean bKl;
    private int zp;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bKl = false;
    }

    public void setHour(int i) {
        this.bGq = i;
    }

    public int getHour() {
        return this.bKk.getHour();
    }

    public void setMinute(int i) {
        this.zp = i;
    }

    public int getMinute() {
        return this.bKk.getMinute();
    }

    private void ZR() {
        this.bKk = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bKk.setLayoutParams(layoutParams);
        this.bKk.setScrollCycle(true);
        this.bKk.setStartDate(this.bFS);
        this.bKk.setmEndDate(this.bFT);
        this.bKk.setHour(this.bGq);
        this.bKk.setMinute(this.zp);
        this.bKk.Zn();
        this.bKk.setDisabled(this.bGc);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bKl) {
            getWindow().addFlags(4718592);
        }
        ZR();
        aaa().ao(this.bKk);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bKk != null) {
            if (this.bGq != this.bKk.getHour()) {
                this.bKk.setHour(this.bGq);
            }
            if (this.zp != this.bKk.getMinute()) {
                this.bKk.setMinute(this.zp);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bGb = str;
    }

    public void setDisabled(boolean z) {
        this.bGc = z;
    }

    public void setStartDate(Date date) {
        this.bFS = date;
    }

    public void setEndDate(Date date) {
        this.bFT = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date bJJ;
        public Date bJK;
        public Date bJL;
        private String bJM;
        private boolean bJN;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.bJJ = date;
            return this;
        }

        public a h(Date date) {
            this.bJK = date;
            return this;
        }

        public a i(Date date) {
            this.bJL = date;
            return this;
        }

        public a kv(String str) {
            this.bJM = str;
            return this;
        }

        public a dD(boolean z) {
            this.bJN = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h ZS() {
            i iVar = (i) super.ZS();
            iVar.setFields(this.bJM);
            iVar.setDisabled(this.bJN);
            if (this.bJL != null) {
                iVar.setHour(this.bJL.getHours());
                iVar.setMinute(this.bJL.getMinutes());
            }
            if (this.bJJ != null) {
                iVar.setStartDate(this.bJJ);
            }
            if (this.bJK != null) {
                iVar.setEndDate(this.bJK);
            }
            return iVar;
        }
    }
}
