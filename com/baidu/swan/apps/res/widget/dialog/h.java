package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.util.Date;
/* loaded from: classes2.dex */
public class h extends g {
    private Date bbL;
    private Date bbM;
    private String bbU;
    private boolean bbV;
    private int bcm;
    private BdTimePicker biP;
    private boolean biQ;
    private int xl;

    h(Context context) {
        super(context, a.i.NoTitleDialog);
        this.biQ = false;
    }

    public void setHour(int i) {
        this.bcm = i;
    }

    public int getHour() {
        return this.biP.getHour();
    }

    public void setMinute(int i) {
        this.xl = i;
    }

    public int getMinute() {
        return this.biP.getMinute();
    }

    private void Qn() {
        this.biP = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.biP.setLayoutParams(layoutParams);
        this.biP.setScrollCycle(true);
        this.biP.setStartDate(this.bbL);
        this.biP.setmEndDate(this.bbM);
        this.biP.setHour(this.bcm);
        this.biP.setMinute(this.xl);
        this.biP.OM();
        this.biP.setDisabled(this.bbV);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.biQ) {
            getWindow().addFlags(4718592);
        }
        Qn();
        Qp().al(this.biP);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Ql = Qp().Ql();
        if (Ql != null) {
            Ql.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.biP != null) {
            if (this.bcm != this.biP.getHour()) {
                this.biP.setHour(this.bcm);
            }
            if (this.xl != this.biP.getMinute()) {
                this.biP.setMinute(this.xl);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bbU = str;
    }

    public void setDisabled(boolean z) {
        this.bbV = z;
    }

    public void setStartDate(Date date) {
        this.bbL = date;
    }

    public void setEndDate(Date date) {
        this.bbM = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date bij;
        public Date bik;
        public Date bil;
        private String bim;
        private boolean bin;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new h(context);
        }

        public a g(Date date) {
            this.bij = date;
            return this;
        }

        public a h(Date date) {
            this.bik = date;
            return this;
        }

        public a i(Date date) {
            this.bil = date;
            return this;
        }

        public a hj(String str) {
            this.bim = str;
            return this;
        }

        public a cB(boolean z) {
            this.bin = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FW() {
            h hVar = (h) super.FW();
            hVar.setFields(this.bim);
            hVar.setDisabled(this.bin);
            if (this.bil != null) {
                hVar.setHour(this.bil.getHours());
                hVar.setMinute(this.bil.getMinutes());
            }
            if (this.bij != null) {
                hVar.setStartDate(this.bij);
            }
            if (this.bik != null) {
                hVar.setEndDate(this.bik);
            }
            return hVar;
        }
    }
}
