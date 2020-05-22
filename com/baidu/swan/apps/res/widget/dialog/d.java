package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes11.dex */
public class d extends h {
    private int Te;
    private int Tf;
    private int Tg;
    private Date cuE;
    private Date cuF;
    private String cuN;
    private boolean cuO;
    private BdDatePicker cyx;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Te = i;
    }

    public int getYear() {
        return this.cyx.getYear();
    }

    public void setMonth(int i) {
        this.Tf = i;
    }

    public int getMonth() {
        return this.cyx.getMonth();
    }

    public void setDay(int i) {
        this.Tg = i;
    }

    public int getDay() {
        return this.cyx.getDay();
    }

    private boolean nj(String str) {
        return this.cyx.nj(str);
    }

    public String aoe() {
        StringBuilder sb = new StringBuilder();
        if (nj("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (nj("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (nj("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aof() {
        this.cyx = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cyx.setLayoutParams(layoutParams);
        this.cyx.setScrollCycle(true);
        this.cyx.setStartDate(this.cuE);
        this.cyx.setEndDate(this.cuF);
        this.cyx.setYear(this.Te);
        this.cyx.setMonth(this.Tf);
        this.cyx.setDay(this.Tg);
        this.cyx.any();
        this.cyx.setFields(this.cuN);
        this.cyx.setDisabled(this.cuO);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aof();
        aoo().ap(this.cyx);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cuN = str;
    }

    public void setDisabled(boolean z) {
        this.cuO = z;
    }

    public void setStartDate(Date date) {
        this.cuE = date;
    }

    public void setEndDate(Date date) {
        this.cuF = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cyA;
        private String cyB;
        private boolean cyC;
        public Date cyy;
        public Date cyz;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cd(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.cyy = date;
            return this;
        }

        public a e(Date date) {
            this.cyz = date;
            return this;
        }

        public a f(Date date) {
            this.cyA = date;
            return this;
        }

        public a np(String str) {
            this.cyB = str;
            return this;
        }

        public a eO(boolean z) {
            this.cyC = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aog() {
            d dVar = (d) super.aog();
            dVar.setFields(this.cyB);
            dVar.setDisabled(this.cyC);
            if (this.cyA != null) {
                dVar.setYear(this.cyA.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cyA.getMonth() + 1);
                dVar.setDay(this.cyA.getDate());
            }
            if (this.cyy != null) {
                dVar.setStartDate(this.cyy);
            }
            if (this.cyz != null) {
                dVar.setEndDate(this.cyz);
            }
            return dVar;
        }
    }
}
