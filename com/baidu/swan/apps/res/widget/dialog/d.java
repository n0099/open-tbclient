package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes8.dex */
public class d extends h {
    private int VJ;
    private int VK;
    private int VL;
    private String dsE;
    private boolean dsF;
    private Date dsv;
    private Date dsw;
    private BdDatePicker dzP;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.VJ = i;
    }

    public int getYear() {
        return this.dzP.getYear();
    }

    public void setMonth(int i) {
        this.VK = i;
    }

    public int getMonth() {
        return this.dzP.getMonth();
    }

    public void setDay(int i) {
        this.VL = i;
    }

    public int getDay() {
        return this.dzP.getDay();
    }

    private boolean qS(String str) {
        return this.dzP.qS(str);
    }

    public String aHu() {
        StringBuilder sb = new StringBuilder();
        if (qS("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (qS("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (qS(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aHv() {
        this.dzP = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dzP.setLayoutParams(layoutParams);
        this.dzP.setScrollCycle(true);
        this.dzP.setStartDate(this.dsv);
        this.dzP.setEndDate(this.dsw);
        this.dzP.setYear(this.VJ);
        this.dzP.setMonth(this.VK);
        this.dzP.setDay(this.VL);
        this.dzP.aGg();
        this.dzP.setFields(this.dsE);
        this.dzP.setDisabled(this.dsF);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHv();
        aHI().aL(this.dzP);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
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
            return new d(context);
        }

        public a f(Date date) {
            this.dzQ = date;
            return this;
        }

        public a g(Date date) {
            this.dzR = date;
            return this;
        }

        public a h(Date date) {
            this.dzS = date;
            return this;
        }

        public a rd(String str) {
            this.dzT = str;
            return this;
        }

        public a gM(boolean z) {
            this.dzU = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHw() {
            d dVar = (d) super.aHw();
            dVar.setFields(this.dzT);
            dVar.setDisabled(this.dzU);
            if (this.dzS != null) {
                dVar.setYear(this.dzS.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dzS.getMonth() + 1);
                dVar.setDay(this.dzS.getDate());
            }
            if (this.dzQ != null) {
                dVar.setStartDate(this.dzQ);
            }
            if (this.dzR != null) {
                dVar.setEndDate(this.dzR);
            }
            return dVar;
        }
    }
}
