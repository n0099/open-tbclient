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
/* loaded from: classes10.dex */
public class d extends h {
    private int UQ;
    private int UR;
    private int US;
    private String cYD;
    private boolean cYE;
    private Date cYu;
    private Date cYv;
    private BdDatePicker ddc;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.UQ = i;
    }

    public int getYear() {
        return this.ddc.getYear();
    }

    public void setMonth(int i) {
        this.UR = i;
    }

    public int getMonth() {
        return this.ddc.getMonth();
    }

    public void setDay(int i) {
        this.US = i;
    }

    public int getDay() {
        return this.ddc.getDay();
    }

    private boolean rc(String str) {
        return this.ddc.rc(str);
    }

    public String aCy() {
        StringBuilder sb = new StringBuilder();
        if (rc("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rc("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rc("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aCz() {
        this.ddc = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.ddc.setLayoutParams(layoutParams);
        this.ddc.setScrollCycle(true);
        this.ddc.setStartDate(this.cYu);
        this.ddc.setEndDate(this.cYv);
        this.ddc.setYear(this.UQ);
        this.ddc.setMonth(this.UR);
        this.ddc.setDay(this.US);
        this.ddc.aBK();
        this.ddc.setFields(this.cYD);
        this.ddc.setDisabled(this.cYE);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aCz();
        aCI().aw(this.ddc);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.cYD = str;
    }

    public void setDisabled(boolean z) {
        this.cYE = z;
    }

    public void setStartDate(Date date) {
        this.cYu = date;
    }

    public void setEndDate(Date date) {
        this.cYv = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date ddd;
        public Date dde;
        public Date ddf;
        private String ddg;
        private boolean ddh;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.ddd = date;
            return this;
        }

        public a g(Date date) {
            this.dde = date;
            return this;
        }

        public a h(Date date) {
            this.ddf = date;
            return this;
        }

        public a rj(String str) {
            this.ddg = str;
            return this;
        }

        public a fQ(boolean z) {
            this.ddh = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aCA() {
            d dVar = (d) super.aCA();
            dVar.setFields(this.ddg);
            dVar.setDisabled(this.ddh);
            if (this.ddf != null) {
                dVar.setYear(this.ddf.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.ddf.getMonth() + 1);
                dVar.setDay(this.ddf.getDate());
            }
            if (this.ddd != null) {
                dVar.setStartDate(this.ddd);
            }
            if (this.dde != null) {
                dVar.setEndDate(this.dde);
            }
            return dVar;
        }
    }
}
