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
/* loaded from: classes3.dex */
public class d extends h {
    private int Uw;
    private int Ux;
    private int Uy;
    private String cMA;
    private boolean cMB;
    private Date cMr;
    private Date cMs;
    private BdDatePicker cQW;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Uw = i;
    }

    public int getYear() {
        return this.cQW.getYear();
    }

    public void setMonth(int i) {
        this.Ux = i;
    }

    public int getMonth() {
        return this.cQW.getMonth();
    }

    public void setDay(int i) {
        this.Uy = i;
    }

    public int getDay() {
        return this.cQW.getDay();
    }

    private boolean qq(String str) {
        return this.cQW.qq(str);
    }

    public String azP() {
        StringBuilder sb = new StringBuilder();
        if (qq("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (qq("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (qq("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void azQ() {
        this.cQW = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cQW.setLayoutParams(layoutParams);
        this.cQW.setScrollCycle(true);
        this.cQW.setStartDate(this.cMr);
        this.cQW.setEndDate(this.cMs);
        this.cQW.setYear(this.Uw);
        this.cQW.setMonth(this.Ux);
        this.cQW.setDay(this.Uy);
        this.cQW.azb();
        this.cQW.setFields(this.cMA);
        this.cQW.setDisabled(this.cMB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        azQ();
        azZ().av(this.cQW);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cMA = str;
    }

    public void setDisabled(boolean z) {
        this.cMB = z;
    }

    public void setStartDate(Date date) {
        this.cMr = date;
    }

    public void setEndDate(Date date) {
        this.cMs = date;
    }

    /* loaded from: classes3.dex */
    public static class a extends h.a {
        public Date cQX;
        public Date cQY;
        public Date cQZ;
        private String cRa;
        private boolean cRb;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cm(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.cQX = date;
            return this;
        }

        public a g(Date date) {
            this.cQY = date;
            return this;
        }

        public a h(Date date) {
            this.cQZ = date;
            return this;
        }

        public a qx(String str) {
            this.cRa = str;
            return this;
        }

        public a fu(boolean z) {
            this.cRb = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azR() {
            d dVar = (d) super.azR();
            dVar.setFields(this.cRa);
            dVar.setDisabled(this.cRb);
            if (this.cQZ != null) {
                dVar.setYear(this.cQZ.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cQZ.getMonth() + 1);
                dVar.setDay(this.cQZ.getDate());
            }
            if (this.cQX != null) {
                dVar.setStartDate(this.cQX);
            }
            if (this.cQY != null) {
                dVar.setEndDate(this.cQY);
            }
            return dVar;
        }
    }
}
