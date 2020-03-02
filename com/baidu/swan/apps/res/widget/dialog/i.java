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
    private Date bJY;
    private Date bJZ;
    private String bKh;
    private boolean bKi;
    private int bKw;
    private BdTimePicker bOq;
    private boolean bOr;
    private int zH;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bOr = false;
    }

    public void setHour(int i) {
        this.bKw = i;
    }

    public int getHour() {
        return this.bOq.getHour();
    }

    public void setMinute(int i) {
        this.zH = i;
    }

    public int getMinute() {
        return this.bOq.getMinute();
    }

    private void ach() {
        this.bOq = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bOq.setLayoutParams(layoutParams);
        this.bOq.setScrollCycle(true);
        this.bOq.setStartDate(this.bJY);
        this.bOq.setmEndDate(this.bJZ);
        this.bOq.setHour(this.bKw);
        this.bOq.setMinute(this.zH);
        this.bOq.abD();
        this.bOq.setDisabled(this.bKi);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bOr) {
            getWindow().addFlags(4718592);
        }
        ach();
        acq().ao(this.bOq);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bOq != null) {
            if (this.bKw != this.bOq.getHour()) {
                this.bOq.setHour(this.bKw);
            }
            if (this.zH != this.bOq.getMinute()) {
                this.bOq.setMinute(this.zH);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bKh = str;
    }

    public void setDisabled(boolean z) {
        this.bKi = z;
    }

    public void setStartDate(Date date) {
        this.bJY = date;
    }

    public void setEndDate(Date date) {
        this.bJZ = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNP;
        public Date bNQ;
        public Date bNR;
        private String bNS;
        private boolean bNT;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.bNP = date;
            return this;
        }

        public a h(Date date) {
            this.bNQ = date;
            return this;
        }

        public a i(Date date) {
            this.bNR = date;
            return this;
        }

        public a kK(String str) {
            this.bNS = str;
            return this;
        }

        public a dK(boolean z) {
            this.bNT = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            i iVar = (i) super.aci();
            iVar.setFields(this.bNS);
            iVar.setDisabled(this.bNT);
            if (this.bNR != null) {
                iVar.setHour(this.bNR.getHours());
                iVar.setMinute(this.bNR.getMinutes());
            }
            if (this.bNP != null) {
                iVar.setStartDate(this.bNP);
            }
            if (this.bNQ != null) {
                iVar.setEndDate(this.bNQ);
            }
            return iVar;
        }
    }
}
