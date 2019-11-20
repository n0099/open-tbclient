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
    private String bbC;
    private boolean bbD;
    private int bbU;
    private Date bbt;
    private Date bbu;
    private BdTimePicker bix;
    private boolean biy;
    private int wL;

    h(Context context) {
        super(context, a.i.NoTitleDialog);
        this.biy = false;
    }

    public void setHour(int i) {
        this.bbU = i;
    }

    public int getHour() {
        return this.bix.getHour();
    }

    public void setMinute(int i) {
        this.wL = i;
    }

    public int getMinute() {
        return this.bix.getMinute();
    }

    private void Qo() {
        this.bix = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bix.setLayoutParams(layoutParams);
        this.bix.setScrollCycle(true);
        this.bix.setStartDate(this.bbt);
        this.bix.setmEndDate(this.bbu);
        this.bix.setHour(this.bbU);
        this.bix.setMinute(this.wL);
        this.bix.ON();
        this.bix.setDisabled(this.bbD);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.biy) {
            getWindow().addFlags(4718592);
        }
        Qo();
        Qq().al(this.bix);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Qm = Qq().Qm();
        if (Qm != null) {
            Qm.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.bix != null) {
            if (this.bbU != this.bix.getHour()) {
                this.bix.setHour(this.bbU);
            }
            if (this.wL != this.bix.getMinute()) {
                this.bix.setMinute(this.wL);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.bbC = str;
    }

    public void setDisabled(boolean z) {
        this.bbD = z;
    }

    public void setStartDate(Date date) {
        this.bbt = date;
    }

    public void setEndDate(Date date) {
        this.bbu = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date bhP;
        public Date bhQ;
        public Date bhR;
        private String bhS;
        private boolean bhT;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new h(context);
        }

        public a g(Date date) {
            this.bhP = date;
            return this;
        }

        public a h(Date date) {
            this.bhQ = date;
            return this;
        }

        public a i(Date date) {
            this.bhR = date;
            return this;
        }

        public a hj(String str) {
            this.bhS = str;
            return this;
        }

        public a cB(boolean z) {
            this.bhT = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            h hVar = (h) super.FX();
            hVar.setFields(this.bhS);
            hVar.setDisabled(this.bhT);
            if (this.bhR != null) {
                hVar.setHour(this.bhR.getHours());
                hVar.setMinute(this.bhR.getMinutes());
            }
            if (this.bhP != null) {
                hVar.setStartDate(this.bhP);
            }
            if (this.bhQ != null) {
                hVar.setEndDate(this.bhQ);
            }
            return hVar;
        }
    }
}
