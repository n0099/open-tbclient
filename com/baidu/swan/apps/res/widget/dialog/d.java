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
    private int KA;
    private int Ky;
    private int Kz;
    private String aIG;
    private boolean aIH;
    private Date aIx;
    private Date aIy;
    private BdDatePicker aOZ;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.Ky = i;
    }

    public int getYear() {
        return this.aOZ.getYear();
    }

    public void setMonth(int i) {
        this.Kz = i;
    }

    public int getMonth() {
        return this.aOZ.getMonth();
    }

    public void setDay(int i) {
        this.KA = i;
    }

    public int getDay() {
        return this.aOZ.getDay();
    }

    private boolean gw(String str) {
        return this.aOZ.gw(str);
    }

    public String Lt() {
        StringBuilder sb = new StringBuilder();
        if (gw("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (gw("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (gw(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Lu() {
        this.aOZ = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aOZ.setLayoutParams(layoutParams);
        this.aOZ.setScrollCycle(true);
        this.aOZ.setStartDate(this.aIx);
        this.aOZ.setEndDate(this.aIy);
        this.aOZ.setYear(this.Ky);
        this.aOZ.setMonth(this.Kz);
        this.aOZ.setDay(this.KA);
        this.aOZ.JS();
        this.aOZ.setFields(this.aIG);
        this.aOZ.setDisabled(this.aIH);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Lu();
        Lw().af(this.aOZ);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Ls = Lw().Ls();
        if (Ls != null) {
            Ls.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.aIG = str;
    }

    public void setDisabled(boolean z) {
        this.aIH = z;
    }

    public void setStartDate(Date date) {
        this.aIx = date;
    }

    public void setEndDate(Date date) {
        this.aIy = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date aPa;
        public Date aPb;
        public Date aPc;
        private String aPd;
        private boolean aPe;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new d(context);
        }

        public a g(Date date) {
            this.aPa = date;
            return this;
        }

        public a h(Date date) {
            this.aPb = date;
            return this;
        }

        public a i(Date date) {
            this.aPc = date;
            return this;
        }

        public a gD(String str) {
            this.aPd = str;
            return this;
        }

        public a bZ(boolean z) {
            this.aPe = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Bb() {
            d dVar = (d) super.Bb();
            dVar.setFields(this.aPd);
            dVar.setDisabled(this.aPe);
            if (this.aPc != null) {
                dVar.setYear(this.aPc.getYear() + 1900);
                dVar.setMonth(this.aPc.getMonth() + 1);
                dVar.setDay(this.aPc.getDate());
            }
            if (this.aPa != null) {
                dVar.setStartDate(this.aPa);
            }
            if (this.aPb != null) {
                dVar.setEndDate(this.aPb);
            }
            return dVar;
        }
    }
}
