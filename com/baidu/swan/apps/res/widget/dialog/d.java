package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes2.dex */
public class d extends g {
    private String bbC;
    private boolean bbD;
    private Date bbt;
    private Date bbu;
    private BdDatePicker bhO;
    private int wH;
    private int wI;
    private int wJ;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.wH = i;
    }

    public int getYear() {
        return this.bhO.getYear();
    }

    public void setMonth(int i) {
        this.wI = i;
    }

    public int getMonth() {
        return this.bhO.getMonth();
    }

    public void setDay(int i) {
        this.wJ = i;
    }

    public int getDay() {
        return this.bhO.getDay();
    }

    private boolean ha(String str) {
        return this.bhO.ha(str);
    }

    public String Qn() {
        StringBuilder sb = new StringBuilder();
        if (ha("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (ha("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (ha(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Qo() {
        this.bhO = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bhO.setLayoutParams(layoutParams);
        this.bhO.setScrollCycle(true);
        this.bhO.setStartDate(this.bbt);
        this.bhO.setEndDate(this.bbu);
        this.bhO.setYear(this.wH);
        this.bhO.setMonth(this.wI);
        this.bhO.setDay(this.wJ);
        this.bhO.ON();
        this.bhO.setFields(this.bbC);
        this.bhO.setDisabled(this.bbD);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Qo();
        Qq().al(this.bhO);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Qm = Qq().Qm();
        if (Qm != null) {
            Qm.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.bbC = str;
    }

    public void setDisabled(boolean z) {
        this.bbD = z;
    }

    public void setStartDate(Date date) {
        this.bbt = date;
    }

    public void setEndDate(Date date) {
        this.bbu = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date bhP;
        public Date bhQ;
        public Date bhR;
        private String bhS;
        private boolean bhT;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bhP = date;
            return this;
        }

        public a e(Date date) {
            this.bhQ = date;
            return this;
        }

        public a f(Date date) {
            this.bhR = date;
            return this;
        }

        public a hh(String str) {
            this.bhS = str;
            return this;
        }

        public a cq(boolean z) {
            this.bhT = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            d dVar = (d) super.FX();
            dVar.setFields(this.bhS);
            dVar.setDisabled(this.bhT);
            if (this.bhR != null) {
                dVar.setYear(this.bhR.getYear() + 1900);
                dVar.setMonth(this.bhR.getMonth() + 1);
                dVar.setDay(this.bhR.getDate());
            }
            if (this.bhP != null) {
                dVar.setStartDate(this.bhP);
            }
            if (this.bhQ != null) {
                dVar.setEndDate(this.bhQ);
            }
            return dVar;
        }
    }
}
