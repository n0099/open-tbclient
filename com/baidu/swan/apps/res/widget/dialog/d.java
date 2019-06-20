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
    private int Km;
    private int Kn;
    private int Ko;
    private String aHA;
    private boolean aHB;
    private Date aHr;
    private Date aHs;
    private BdDatePicker aNR;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Km = i;
    }

    public int getYear() {
        return this.aNR.getYear();
    }

    public void setMonth(int i) {
        this.Kn = i;
    }

    public int getMonth() {
        return this.aNR.getMonth();
    }

    public void setDay(int i) {
        this.Ko = i;
    }

    public int getDay() {
        return this.aNR.getDay();
    }

    private boolean gn(String str) {
        return this.aNR.gn(str);
    }

    public String KC() {
        StringBuilder sb = new StringBuilder();
        if (gn("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (gn("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (gn(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void KD() {
        this.aNR = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aNR.setLayoutParams(layoutParams);
        this.aNR.setScrollCycle(true);
        this.aNR.setStartDate(this.aHr);
        this.aNR.setEndDate(this.aHs);
        this.aNR.setYear(this.Km);
        this.aNR.setMonth(this.Kn);
        this.aNR.setDay(this.Ko);
        this.aNR.Jb();
        this.aNR.setFields(this.aHA);
        this.aNR.setDisabled(this.aHB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        KD();
        KF().ad(this.aNR);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView KB = KF().KB();
        if (KB != null) {
            KB.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.aHA = str;
    }

    public void setDisabled(boolean z) {
        this.aHB = z;
    }

    public void setStartDate(Date date) {
        this.aHr = date;
    }

    public void setEndDate(Date date) {
        this.aHs = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date aNS;
        public Date aNT;
        public Date aNU;
        private String aNV;
        private boolean aNW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new d(context);
        }

        public a g(Date date) {
            this.aNS = date;
            return this;
        }

        public a h(Date date) {
            this.aNT = date;
            return this;
        }

        public a i(Date date) {
            this.aNU = date;
            return this;
        }

        public a gv(String str) {
            this.aNV = str;
            return this;
        }

        public a bW(boolean z) {
            this.aNW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            d dVar = (d) super.Aq();
            dVar.setFields(this.aNV);
            dVar.setDisabled(this.aNW);
            if (this.aNU != null) {
                dVar.setYear(this.aNU.getYear() + 1900);
                dVar.setMonth(this.aNU.getMonth() + 1);
                dVar.setDay(this.aNU.getDate());
            }
            if (this.aNS != null) {
                dVar.setStartDate(this.aNS);
            }
            if (this.aNT != null) {
                dVar.setEndDate(this.aNT);
            }
            return dVar;
        }
    }
}
