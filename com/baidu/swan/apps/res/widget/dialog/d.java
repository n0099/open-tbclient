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
    private int Xc;
    private int Xe;
    private int Xf;
    private BdDatePicker dDv;
    private Date dwh;
    private Date dwi;
    private String dwq;
    private boolean dwr;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Xc = i;
    }

    public int getYear() {
        return this.dDv.getYear();
    }

    public void setMonth(int i) {
        this.Xe = i;
    }

    public int getMonth() {
        return this.dDv.getMonth();
    }

    public void setDay(int i) {
        this.Xf = i;
    }

    public int getDay() {
        return this.dDv.getDay();
    }

    private boolean rs(String str) {
        return this.dDv.rs(str);
    }

    public String aHQ() {
        StringBuilder sb = new StringBuilder();
        if (rs("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rs("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rs(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aHR() {
        this.dDv = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dDv.setLayoutParams(layoutParams);
        this.dDv.setScrollCycle(true);
        this.dDv.setStartDate(this.dwh);
        this.dDv.setEndDate(this.dwi);
        this.dDv.setYear(this.Xc);
        this.dDv.setMonth(this.Xe);
        this.dDv.setDay(this.Xf);
        this.dDv.aGE();
        this.dDv.setFields(this.dwq);
        this.dDv.setDisabled(this.dwr);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aHR();
        aIe().aH(this.dDv);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dwq = str;
    }

    public void setDisabled(boolean z) {
        this.dwr = z;
    }

    public void setStartDate(Date date) {
        this.dwh = date;
    }

    public void setEndDate(Date date) {
        this.dwi = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        private boolean dDA;
        public Date dDw;
        public Date dDx;
        public Date dDy;
        private String dDz;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dh(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dDw = date;
            return this;
        }

        public a g(Date date) {
            this.dDx = date;
            return this;
        }

        public a h(Date date) {
            this.dDy = date;
            return this;
        }

        public a rD(String str) {
            this.dDz = str;
            return this;
        }

        public a gO(boolean z) {
            this.dDA = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHS() {
            d dVar = (d) super.aHS();
            dVar.setFields(this.dDz);
            dVar.setDisabled(this.dDA);
            if (this.dDy != null) {
                dVar.setYear(this.dDy.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dDy.getMonth() + 1);
                dVar.setDay(this.dDy.getDate());
            }
            if (this.dDw != null) {
                dVar.setStartDate(this.dDw);
            }
            if (this.dDx != null) {
                dVar.setEndDate(this.dDx);
            }
            return dVar;
        }
    }
}
