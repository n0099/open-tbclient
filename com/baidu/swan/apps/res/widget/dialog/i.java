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
    private Date bJZ;
    private Date bKa;
    private String bKi;
    private boolean bKj;
    private int bKx;
    private BdTimePicker bOr;
    private boolean bOs;
    private int zH;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bOs = false;
    }

    public void setHour(int i) {
        this.bKx = i;
    }

    public int getHour() {
        return this.bOr.getHour();
    }

    public void setMinute(int i) {
        this.zH = i;
    }

    public int getMinute() {
        return this.bOr.getMinute();
    }

    private void ach() {
        this.bOr = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bOr.setLayoutParams(layoutParams);
        this.bOr.setScrollCycle(true);
        this.bOr.setStartDate(this.bJZ);
        this.bOr.setmEndDate(this.bKa);
        this.bOr.setHour(this.bKx);
        this.bOr.setMinute(this.zH);
        this.bOr.abD();
        this.bOr.setDisabled(this.bKj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bOs) {
            getWindow().addFlags(4718592);
        }
        ach();
        acq().ao(this.bOr);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bOr != null) {
            if (this.bKx != this.bOr.getHour()) {
                this.bOr.setHour(this.bKx);
            }
            if (this.zH != this.bOr.getMinute()) {
                this.bOr.setMinute(this.zH);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bKi = str;
    }

    public void setDisabled(boolean z) {
        this.bKj = z;
    }

    public void setStartDate(Date date) {
        this.bJZ = date;
    }

    public void setEndDate(Date date) {
        this.bKa = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNQ;
        public Date bNR;
        public Date bNS;
        private String bNT;
        private boolean bNU;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.bNQ = date;
            return this;
        }

        public a h(Date date) {
            this.bNR = date;
            return this;
        }

        public a i(Date date) {
            this.bNS = date;
            return this;
        }

        public a kK(String str) {
            this.bNT = str;
            return this;
        }

        public a dK(boolean z) {
            this.bNU = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            i iVar = (i) super.aci();
            iVar.setFields(this.bNT);
            iVar.setDisabled(this.bNU);
            if (this.bNS != null) {
                iVar.setHour(this.bNS.getHours());
                iVar.setMinute(this.bNS.getMinutes());
            }
            if (this.bNQ != null) {
                iVar.setStartDate(this.bNQ);
            }
            if (this.bNR != null) {
                iVar.setEndDate(this.bNR);
            }
            return iVar;
        }
    }
}
