package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes2.dex */
public class d extends g {
    private int KA;
    private int Ky;
    private int Kz;
    private Date aHZ;
    private Date aIa;
    private String aIi;
    private boolean aIj;
    private BdDatePicker aOB;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Ky = i;
    }

    public int getYear() {
        return this.aOB.getYear();
    }

    public void setMonth(int i) {
        this.Kz = i;
    }

    public int getMonth() {
        return this.aOB.getMonth();
    }

    public void setDay(int i) {
        this.KA = i;
    }

    public int getDay() {
        return this.aOB.getDay();
    }

    private boolean gu(String str) {
        return this.aOB.gu(str);
    }

    public String Lp() {
        StringBuilder sb = new StringBuilder();
        if (gu("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (gu("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (gu(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Lq() {
        this.aOB = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aOB.setLayoutParams(layoutParams);
        this.aOB.setScrollCycle(true);
        this.aOB.setStartDate(this.aHZ);
        this.aOB.setEndDate(this.aIa);
        this.aOB.setYear(this.Ky);
        this.aOB.setMonth(this.Kz);
        this.aOB.setDay(this.KA);
        this.aOB.JO();
        this.aOB.setFields(this.aIi);
        this.aOB.setDisabled(this.aIj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Lq();
        Ls().af(this.aOB);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Lo = Ls().Lo();
        if (Lo != null) {
            Lo.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
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
            return new d(context);
        }

        public a g(Date date) {
            this.aOC = date;
            return this;
        }

        public a h(Date date) {
            this.aOD = date;
            return this;
        }

        public a i(Date date) {
            this.aOE = date;
            return this;
        }

        public a gB(String str) {
            this.aOF = str;
            return this;
        }

        public a bZ(boolean z) {
            this.aOG = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            d dVar = (d) super.AX();
            dVar.setFields(this.aOF);
            dVar.setDisabled(this.aOG);
            if (this.aOE != null) {
                dVar.setYear(this.aOE.getYear() + 1900);
                dVar.setMonth(this.aOE.getMonth() + 1);
                dVar.setDay(this.aOE.getDate());
            }
            if (this.aOC != null) {
                dVar.setStartDate(this.aOC);
            }
            if (this.aOD != null) {
                dVar.setEndDate(this.aOD);
            }
            return dVar;
        }
    }
}
