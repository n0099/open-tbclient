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
    private Date bbL;
    private Date bbM;
    private String bbU;
    private boolean bbV;
    private BdDatePicker bii;
    private int xh;
    private int xi;
    private int xj;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.xh = i;
    }

    public int getYear() {
        return this.bii.getYear();
    }

    public void setMonth(int i) {
        this.xi = i;
    }

    public int getMonth() {
        return this.bii.getMonth();
    }

    public void setDay(int i) {
        this.xj = i;
    }

    public int getDay() {
        return this.bii.getDay();
    }

    private boolean ha(String str) {
        return this.bii.ha(str);
    }

    public String Qm() {
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

    private void Qn() {
        this.bii = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bii.setLayoutParams(layoutParams);
        this.bii.setScrollCycle(true);
        this.bii.setStartDate(this.bbL);
        this.bii.setEndDate(this.bbM);
        this.bii.setYear(this.xh);
        this.bii.setMonth(this.xi);
        this.bii.setDay(this.xj);
        this.bii.OM();
        this.bii.setFields(this.bbU);
        this.bii.setDisabled(this.bbV);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Qn();
        Qp().al(this.bii);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Ql = Qp().Ql();
        if (Ql != null) {
            Ql.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.bbU = str;
    }

    public void setDisabled(boolean z) {
        this.bbV = z;
    }

    public void setStartDate(Date date) {
        this.bbL = date;
    }

    public void setEndDate(Date date) {
        this.bbM = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date bij;
        public Date bik;
        public Date bil;
        private String bim;
        private boolean bin;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bij = date;
            return this;
        }

        public a e(Date date) {
            this.bik = date;
            return this;
        }

        public a f(Date date) {
            this.bil = date;
            return this;
        }

        public a hh(String str) {
            this.bim = str;
            return this;
        }

        public a cq(boolean z) {
            this.bin = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g FW() {
            d dVar = (d) super.FW();
            dVar.setFields(this.bim);
            dVar.setDisabled(this.bin);
            if (this.bil != null) {
                dVar.setYear(this.bil.getYear() + 1900);
                dVar.setMonth(this.bil.getMonth() + 1);
                dVar.setDay(this.bil.getDate());
            }
            if (this.bij != null) {
                dVar.setStartDate(this.bij);
            }
            if (this.bik != null) {
                dVar.setEndDate(this.bik);
            }
            return dVar;
        }
    }
}
