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
/* loaded from: classes7.dex */
public class d extends h {
    private int TA;
    private int TB;
    private int TC;
    private Date cBZ;
    private Date cCa;
    private String cCi;
    private boolean cCj;
    private BdDatePicker cFU;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.TA = i;
    }

    public int getYear() {
        return this.cFU.getYear();
    }

    public void setMonth(int i) {
        this.TB = i;
    }

    public int getMonth() {
        return this.cFU.getMonth();
    }

    public void setDay(int i) {
        this.TC = i;
    }

    public int getDay() {
        return this.cFU.getDay();
    }

    private boolean nY(String str) {
        return this.cFU.nY(str);
    }

    public String aqU() {
        StringBuilder sb = new StringBuilder();
        if (nY("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (nY("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (nY("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aqV() {
        this.cFU = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.cFU.setLayoutParams(layoutParams);
        this.cFU.setScrollCycle(true);
        this.cFU.setStartDate(this.cBZ);
        this.cFU.setEndDate(this.cCa);
        this.cFU.setYear(this.TA);
        this.cFU.setMonth(this.TB);
        this.cFU.setDay(this.TC);
        this.cFU.aqo();
        this.cFU.setFields(this.cCi);
        this.cFU.setDisabled(this.cCj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aqV();
        are().as(this.cFU);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cCi = str;
    }

    public void setDisabled(boolean z) {
        this.cCj = z;
    }

    public void setStartDate(Date date) {
        this.cBZ = date;
    }

    public void setEndDate(Date date) {
        this.cCa = date;
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public Date cFV;
        public Date cFW;
        public Date cFX;
        private String cFY;
        private boolean cFZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ch(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.cFV = date;
            return this;
        }

        public a g(Date date) {
            this.cFW = date;
            return this;
        }

        public a h(Date date) {
            this.cFX = date;
            return this;
        }

        public a oe(String str) {
            this.cFY = str;
            return this;
        }

        public a fc(boolean z) {
            this.cFZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aqW() {
            d dVar = (d) super.aqW();
            dVar.setFields(this.cFY);
            dVar.setDisabled(this.cFZ);
            if (this.cFX != null) {
                dVar.setYear(this.cFX.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.cFX.getMonth() + 1);
                dVar.setDay(this.cFX.getDate());
            }
            if (this.cFV != null) {
                dVar.setStartDate(this.cFV);
            }
            if (this.cFW != null) {
                dVar.setEndDate(this.cFW);
            }
            return dVar;
        }
    }
}
