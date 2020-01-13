package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes10.dex */
public class d extends h {
    private Date bFS;
    private Date bFT;
    private String bGb;
    private boolean bGc;
    private BdDatePicker bJI;
    private int zl;
    private int zm;
    private int zn;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.zl = i;
    }

    public int getYear() {
        return this.bJI.getYear();
    }

    public void setMonth(int i) {
        this.zm = i;
    }

    public int getMonth() {
        return this.bJI.getMonth();
    }

    public void setDay(int i) {
        this.zn = i;
    }

    public int getDay() {
        return this.bJI.getDay();
    }

    private boolean kn(String str) {
        return this.bJI.kn(str);
    }

    public String ZQ() {
        StringBuilder sb = new StringBuilder();
        if (kn("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (kn("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (kn("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void ZR() {
        this.bJI = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bJI.setLayoutParams(layoutParams);
        this.bJI.setScrollCycle(true);
        this.bJI.setStartDate(this.bFS);
        this.bJI.setEndDate(this.bFT);
        this.bJI.setYear(this.zl);
        this.bJI.setMonth(this.zm);
        this.bJI.setDay(this.zn);
        this.bJI.Zn();
        this.bJI.setFields(this.bGb);
        this.bJI.setDisabled(this.bGc);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ZR();
        aaa().ao(this.bJI);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bGb = str;
    }

    public void setDisabled(boolean z) {
        this.bGc = z;
    }

    public void setStartDate(Date date) {
        this.bFS = date;
    }

    public void setEndDate(Date date) {
        this.bFT = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date bJJ;
        public Date bJK;
        public Date bJL;
        private String bJM;
        private boolean bJN;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bJJ = date;
            return this;
        }

        public a e(Date date) {
            this.bJK = date;
            return this;
        }

        public a f(Date date) {
            this.bJL = date;
            return this;
        }

        public a kt(String str) {
            this.bJM = str;
            return this;
        }

        public a dr(boolean z) {
            this.bJN = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h ZS() {
            d dVar = (d) super.ZS();
            dVar.setFields(this.bJM);
            dVar.setDisabled(this.bJN);
            if (this.bJL != null) {
                dVar.setYear(this.bJL.getYear() + 1900);
                dVar.setMonth(this.bJL.getMonth() + 1);
                dVar.setDay(this.bJL.getDate());
            }
            if (this.bJJ != null) {
                dVar.setStartDate(this.bJJ);
            }
            if (this.bJK != null) {
                dVar.setEndDate(this.bJK);
            }
            return dVar;
        }
    }
}
