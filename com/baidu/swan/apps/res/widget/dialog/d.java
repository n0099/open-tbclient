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
/* loaded from: classes25.dex */
public class d extends h {
    private int VJ;
    private int VK;
    private int VL;
    private Date dsj;
    private Date dsk;
    private String dss;
    private boolean dsu;
    private BdDatePicker dwS;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.VJ = i;
    }

    public int getYear() {
        return this.dwS.getYear();
    }

    public void setMonth(int i) {
        this.VK = i;
    }

    public int getMonth() {
        return this.dwS.getMonth();
    }

    public void setDay(int i) {
        this.VL = i;
    }

    public int getDay() {
        return this.dwS.getDay();
    }

    private boolean sk(String str) {
        return this.dwS.sk(str);
    }

    public String aJs() {
        StringBuilder sb = new StringBuilder();
        if (sk("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (sk("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (sk("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aJt() {
        this.dwS = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dwS.setLayoutParams(layoutParams);
        this.dwS.setScrollCycle(true);
        this.dwS.setStartDate(this.dsj);
        this.dwS.setEndDate(this.dsk);
        this.dwS.setYear(this.VJ);
        this.dwS.setMonth(this.VK);
        this.dwS.setDay(this.VL);
        this.dwS.aIE();
        this.dwS.setFields(this.dss);
        this.dwS.setDisabled(this.dsu);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aJt();
        aJC().aD(this.dwS);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dss = str;
    }

    public void setDisabled(boolean z) {
        this.dsu = z;
    }

    public void setStartDate(Date date) {
        this.dsj = date;
    }

    public void setEndDate(Date date) {
        this.dsk = date;
    }

    /* loaded from: classes25.dex */
    public static class a extends h.a {
        public Date dwT;
        public Date dwU;
        public Date dwV;
        private String dwW;
        private boolean dwX;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cY(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dwT = date;
            return this;
        }

        public a g(Date date) {
            this.dwU = date;
            return this;
        }

        public a h(Date date) {
            this.dwV = date;
            return this;
        }

        public a ss(String str) {
            this.dwW = str;
            return this;
        }

        public a gE(boolean z) {
            this.dwX = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aJu() {
            d dVar = (d) super.aJu();
            dVar.setFields(this.dwW);
            dVar.setDisabled(this.dwX);
            if (this.dwV != null) {
                dVar.setYear(this.dwV.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dwV.getMonth() + 1);
                dVar.setDay(this.dwV.getDate());
            }
            if (this.dwT != null) {
                dVar.setStartDate(this.dwT);
            }
            if (this.dwU != null) {
                dVar.setEndDate(this.dwU);
            }
            return dVar;
        }
    }
}
