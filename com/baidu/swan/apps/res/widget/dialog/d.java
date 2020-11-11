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
    private int UR;
    private int US;
    private int UT;
    private Date dmQ;
    private Date dmR;
    private String dmZ;
    private boolean dna;
    private BdDatePicker drz;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.UR = i;
    }

    public int getYear() {
        return this.drz.getYear();
    }

    public void setMonth(int i) {
        this.US = i;
    }

    public int getMonth() {
        return this.drz.getMonth();
    }

    public void setDay(int i) {
        this.UT = i;
    }

    public int getDay() {
        return this.drz.getDay();
    }

    private boolean rJ(String str) {
        return this.drz.rJ(str);
    }

    public String aGS() {
        StringBuilder sb = new StringBuilder();
        if (rJ("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rJ("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rJ("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aGT() {
        this.drz = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.drz.setLayoutParams(layoutParams);
        this.drz.setScrollCycle(true);
        this.drz.setStartDate(this.dmQ);
        this.drz.setEndDate(this.dmR);
        this.drz.setYear(this.UR);
        this.drz.setMonth(this.US);
        this.drz.setDay(this.UT);
        this.drz.aGe();
        this.drz.setFields(this.dmZ);
        this.drz.setDisabled(this.dna);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aGT();
        aHc().aB(this.drz);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dmZ = str;
    }

    public void setDisabled(boolean z) {
        this.dna = z;
    }

    public void setStartDate(Date date) {
        this.dmQ = date;
    }

    public void setEndDate(Date date) {
        this.dmR = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date drA;
        public Date drB;
        public Date drC;
        private String drD;
        private boolean drE;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.drA = date;
            return this;
        }

        public a g(Date date) {
            this.drB = date;
            return this;
        }

        public a h(Date date) {
            this.drC = date;
            return this;
        }

        public a rQ(String str) {
            this.drD = str;
            return this;
        }

        public a gm(boolean z) {
            this.drE = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGU() {
            d dVar = (d) super.aGU();
            dVar.setFields(this.drD);
            dVar.setDisabled(this.drE);
            if (this.drC != null) {
                dVar.setYear(this.drC.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.drC.getMonth() + 1);
                dVar.setDay(this.drC.getDate());
            }
            if (this.drA != null) {
                dVar.setStartDate(this.drA);
            }
            if (this.drB != null) {
                dVar.setEndDate(this.drB);
            }
            return dVar;
        }
    }
}
