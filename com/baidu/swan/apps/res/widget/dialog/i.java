package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes11.dex */
public class i extends h {
    private Date bJX;
    private Date bJY;
    private String bKg;
    private boolean bKh;
    private int bKv;
    private BdTimePicker bOp;
    private boolean bOq;
    private int zH;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bOq = false;
    }

    public void setHour(int i) {
        this.bKv = i;
    }

    public int getHour() {
        return this.bOp.getHour();
    }

    public void setMinute(int i) {
        this.zH = i;
    }

    public int getMinute() {
        return this.bOp.getMinute();
    }

    private void acf() {
        this.bOp = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bOp.setLayoutParams(layoutParams);
        this.bOp.setScrollCycle(true);
        this.bOp.setStartDate(this.bJX);
        this.bOp.setmEndDate(this.bJY);
        this.bOp.setHour(this.bKv);
        this.bOp.setMinute(this.zH);
        this.bOp.abB();
        this.bOp.setDisabled(this.bKh);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bOq) {
            getWindow().addFlags(4718592);
        }
        acf();
        aco().ao(this.bOp);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bOp != null) {
            if (this.bKv != this.bOp.getHour()) {
                this.bOp.setHour(this.bKv);
            }
            if (this.zH != this.bOp.getMinute()) {
                this.bOp.setMinute(this.zH);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bKg = str;
    }

    public void setDisabled(boolean z) {
        this.bKh = z;
    }

    public void setStartDate(Date date) {
        this.bJX = date;
    }

    public void setEndDate(Date date) {
        this.bJY = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNO;
        public Date bNP;
        public Date bNQ;
        private String bNR;
        private boolean bNS;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.bNO = date;
            return this;
        }

        public a h(Date date) {
            this.bNP = date;
            return this;
        }

        public a i(Date date) {
            this.bNQ = date;
            return this;
        }

        public a kK(String str) {
            this.bNR = str;
            return this;
        }

        public a dK(boolean z) {
            this.bNS = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acg() {
            i iVar = (i) super.acg();
            iVar.setFields(this.bNR);
            iVar.setDisabled(this.bNS);
            if (this.bNQ != null) {
                iVar.setHour(this.bNQ.getHours());
                iVar.setMinute(this.bNQ.getMinutes());
            }
            if (this.bNO != null) {
                iVar.setStartDate(this.bNO);
            }
            if (this.bNP != null) {
                iVar.setEndDate(this.bNP);
            }
            return iVar;
        }
    }
}
