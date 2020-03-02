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
    private Date bJY;
    private Date bJZ;
    private String bKh;
    private boolean bKi;
    private BdDatePicker bNO;
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
        return this.bNO.getYear();
    }

    public void setMonth(int i) {
        this.zE = i;
    }

    public int getMonth() {
        return this.bNO.getMonth();
    }

    public void setDay(int i) {
        this.zF = i;
    }

    public int getDay() {
        return this.bNO.getDay();
    }

    private boolean kC(String str) {
        return this.bNO.kC(str);
    }

    public String acg() {
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

    private void ach() {
        this.bNO = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bNO.setLayoutParams(layoutParams);
        this.bNO.setScrollCycle(true);
        this.bNO.setStartDate(this.bJY);
        this.bNO.setEndDate(this.bJZ);
        this.bNO.setYear(this.zD);
        this.bNO.setMonth(this.zE);
        this.bNO.setDay(this.zF);
        this.bNO.abD();
        this.bNO.setFields(this.bKh);
        this.bNO.setDisabled(this.bKi);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ach();
        acq().ao(this.bNO);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bKh = str;
    }

    public void setDisabled(boolean z) {
        this.bKi = z;
    }

    public void setStartDate(Date date) {
        this.bJY = date;
    }

    public void setEndDate(Date date) {
        this.bJZ = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bNP;
        public Date bNQ;
        public Date bNR;
        private String bNS;
        private boolean bNT;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cr(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bNP = date;
            return this;
        }

        public a e(Date date) {
            this.bNQ = date;
            return this;
        }

        public a f(Date date) {
            this.bNR = date;
            return this;
        }

        public a kI(String str) {
            this.bNS = str;
            return this;
        }

        public a dy(boolean z) {
            this.bNT = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aci() {
            d dVar = (d) super.aci();
            dVar.setFields(this.bNS);
            dVar.setDisabled(this.bNT);
            if (this.bNR != null) {
                dVar.setYear(this.bNR.getYear() + 1900);
                dVar.setMonth(this.bNR.getMonth() + 1);
                dVar.setDay(this.bNR.getDate());
            }
            if (this.bNP != null) {
                dVar.setStartDate(this.bNP);
            }
            if (this.bNQ != null) {
                dVar.setEndDate(this.bNQ);
            }
            return dVar;
        }
    }
}
