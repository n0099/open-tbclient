package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes11.dex */
public class d extends h {
    private Date bJX;
    private Date bJY;
    private String bKg;
    private boolean bKh;
    private BdDatePicker bNN;
    private int zD;
    private int zE;
    private int zF;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.zD = i;
    }

    public int getYear() {
        return this.bNN.getYear();
    }

    public void setMonth(int i) {
        this.zE = i;
    }

    public int getMonth() {
        return this.bNN.getMonth();
    }

    public void setDay(int i) {
        this.zF = i;
    }

    public int getDay() {
        return this.bNN.getDay();
    }

    private boolean kC(String str) {
        return this.bNN.kC(str);
    }

    public String ace() {
        StringBuilder sb = new StringBuilder();
        if (kC("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (kC("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (kC("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void acf() {
        this.bNN = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNN.setLayoutParams(layoutParams);
        this.bNN.setScrollCycle(true);
        this.bNN.setStartDate(this.bJX);
        this.bNN.setEndDate(this.bJY);
        this.bNN.setYear(this.zD);
        this.bNN.setMonth(this.zE);
        this.bNN.setDay(this.zF);
        this.bNN.abB();
        this.bNN.setFields(this.bKg);
        this.bNN.setDisabled(this.bKh);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        acf();
        aco().ao(this.bNN);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bKg = str;
    }

    public void setDisabled(boolean z) {
        this.bKh = z;
    }

    public void setStartDate(Date date) {
        this.bJX = date;
    }

    public void setEndDate(Date date) {
        this.bJY = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNO;
        public Date bNP;
        public Date bNQ;
        private String bNR;
        private boolean bNS;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bNO = date;
            return this;
        }

        public a e(Date date) {
            this.bNP = date;
            return this;
        }

        public a f(Date date) {
            this.bNQ = date;
            return this;
        }

        public a kI(String str) {
            this.bNR = str;
            return this;
        }

        public a dy(boolean z) {
            this.bNS = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acg() {
            d dVar = (d) super.acg();
            dVar.setFields(this.bNR);
            dVar.setDisabled(this.bNS);
            if (this.bNQ != null) {
                dVar.setYear(this.bNQ.getYear() + 1900);
                dVar.setMonth(this.bNQ.getMonth() + 1);
                dVar.setDay(this.bNQ.getDate());
            }
            if (this.bNO != null) {
                dVar.setStartDate(this.bNO);
            }
            if (this.bNP != null) {
                dVar.setEndDate(this.bNP);
            }
            return dVar;
        }
    }
}
