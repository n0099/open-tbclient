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
    private int US;
    private int UT;
    private int UU;
    private Date dlj;
    private Date dlk;
    private String dls;
    private boolean dlt;
    private BdDatePicker dpR;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.US = i;
    }

    public int getYear() {
        return this.dpR.getYear();
    }

    public void setMonth(int i) {
        this.UT = i;
    }

    public int getMonth() {
        return this.dpR.getMonth();
    }

    public void setDay(int i) {
        this.UU = i;
    }

    public int getDay() {
        return this.dpR.getDay();
    }

    private boolean rD(String str) {
        return this.dpR.rD(str);
    }

    public String aGk() {
        StringBuilder sb = new StringBuilder();
        if (rD("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (rD("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (rD("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void aGl() {
        this.dpR = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.dpR.setLayoutParams(layoutParams);
        this.dpR.setScrollCycle(true);
        this.dpR.setStartDate(this.dlj);
        this.dpR.setEndDate(this.dlk);
        this.dpR.setYear(this.US);
        this.dpR.setMonth(this.UT);
        this.dpR.setDay(this.UU);
        this.dpR.aFw();
        this.dpR.setFields(this.dls);
        this.dpR.setDisabled(this.dlt);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        aGl();
        aGu().aB(this.dpR);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.dls = str;
    }

    public void setDisabled(boolean z) {
        this.dlt = z;
    }

    public void setStartDate(Date date) {
        this.dlj = date;
    }

    public void setEndDate(Date date) {
        this.dlk = date;
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public Date dpS;
        public Date dpT;
        public Date dpU;
        private String dpV;
        private boolean dpW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new d(context);
        }

        public a f(Date date) {
            this.dpS = date;
            return this;
        }

        public a g(Date date) {
            this.dpT = date;
            return this;
        }

        public a h(Date date) {
            this.dpU = date;
            return this;
        }

        public a rK(String str) {
            this.dpV = str;
            return this;
        }

        public a gp(boolean z) {
            this.dpW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGm() {
            d dVar = (d) super.aGm();
            dVar.setFields(this.dpV);
            dVar.setDisabled(this.dpW);
            if (this.dpU != null) {
                dVar.setYear(this.dpU.getYear() + FeatureCodes.SKY_SEG);
                dVar.setMonth(this.dpU.getMonth() + 1);
                dVar.setDay(this.dpU.getDate());
            }
            if (this.dpS != null) {
                dVar.setStartDate(this.dpS);
            }
            if (this.dpT != null) {
                dVar.setEndDate(this.dpT);
            }
            return dVar;
        }
    }
}
