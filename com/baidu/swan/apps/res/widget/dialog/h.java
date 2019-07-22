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
    private int KC;
    private Date aHZ;
    private int aIA;
    private Date aIa;
    private String aIi;
    private boolean aIj;
    private BdTimePicker aPi;
    private boolean aPj;

    h(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aPj = false;
    }

    public void setHour(int i) {
        this.aIA = i;
    }

    public int getHour() {
        return this.aPi.getHour();
    }

    public void setMinute(int i) {
        this.KC = i;
    }

    public int getMinute() {
        return this.aPi.getMinute();
    }

    private void Lq() {
        this.aPi = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aPi.setLayoutParams(layoutParams);
        this.aPi.setScrollCycle(true);
        this.aPi.setStartDate(this.aHZ);
        this.aPi.setmEndDate(this.aIa);
        this.aPi.setHour(this.aIA);
        this.aPi.setMinute(this.KC);
        this.aPi.JO();
        this.aPi.setDisabled(this.aIj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aPj) {
            getWindow().addFlags(4718592);
        }
        Lq();
        Ls().af(this.aPi);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Lo = Ls().Lo();
        if (Lo != null) {
            Lo.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aPi != null) {
            if (this.aIA != this.aPi.getHour()) {
                this.aPi.setHour(this.aIA);
            }
            if (this.KC != this.aPi.getMinute()) {
                this.aPi.setMinute(this.KC);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aIi = str;
    }

    public void setDisabled(boolean z) {
        this.aIj = z;
    }

    public void setStartDate(Date date) {
        this.aHZ = date;
    }

    public void setEndDate(Date date) {
        this.aIa = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date aOC;
        public Date aOD;
        public Date aOE;
        private String aOF;
        private boolean aOG;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new h(context);
        }

        public a j(Date date) {
            this.aOC = date;
            return this;
        }

        public a k(Date date) {
            this.aOD = date;
            return this;
        }

        public a l(Date date) {
            this.aOE = date;
            return this;
        }

        public a gD(String str) {
            this.aOF = str;
            return this;
        }

        public a ck(boolean z) {
            this.aOG = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            h hVar = (h) super.AX();
            hVar.setFields(this.aOF);
            hVar.setDisabled(this.aOG);
            if (this.aOE != null) {
                hVar.setHour(this.aOE.getHours());
                hVar.setMinute(this.aOE.getMinutes());
            }
            if (this.aOC != null) {
                hVar.setStartDate(this.aOC);
            }
            if (this.aOD != null) {
                hVar.setEndDate(this.aOD);
            }
            return hVar;
        }
    }
}
