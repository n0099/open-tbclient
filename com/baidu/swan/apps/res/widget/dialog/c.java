package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes2.dex */
public class c extends e {
    private int MC;
    private int MD;
    private int ME;
    private String aFG;
    private boolean aFH;
    private Date aFx;
    private Date aFy;
    private BdDatePicker aLX;

    c(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.MC = i;
    }

    public int getYear() {
        return this.aLX.getYear();
    }

    public void setMonth(int i) {
        this.MD = i;
    }

    public int getMonth() {
        return this.aLX.getMonth();
    }

    public void setDay(int i) {
        this.ME = i;
    }

    public int getDay() {
        return this.aLX.getDay();
    }

    private boolean fW(String str) {
        return this.aLX.fW(str);
    }

    public String Im() {
        StringBuilder sb = new StringBuilder();
        if (fW("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (fW("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (fW(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void In() {
        this.aLX = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aLX.setLayoutParams(layoutParams);
        this.aLX.setScrollCycle(true);
        this.aLX.setStartDate(this.aFx);
        this.aLX.setEndDate(this.aFy);
        this.aLX.setYear(this.MC);
        this.aLX.setMonth(this.MD);
        this.aLX.setDay(this.ME);
        this.aLX.GL();
        this.aLX.setFields(this.aFG);
        this.aLX.setDisabled(this.aFH);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        In();
        Ip().ad(this.aLX);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView Il = Ip().Il();
        if (Il != null) {
            Il.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFG = str;
    }

    public void setDisabled(boolean z) {
        this.aFH = z;
    }

    public void setStartDate(Date date) {
        this.aFx = date;
    }

    public void setEndDate(Date date) {
        this.aFy = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLY;
        public Date aLZ;
        public Date aMa;
        private String aMb;
        private boolean aMc;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new c(context);
        }

        public a g(Date date) {
            this.aLY = date;
            return this;
        }

        public a h(Date date) {
            this.aLZ = date;
            return this;
        }

        public a i(Date date) {
            this.aMa = date;
            return this;
        }

        public a gd(String str) {
            this.aMb = str;
            return this;
        }

        public a bM(boolean z) {
            this.aMc = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            c cVar = (c) super.zq();
            cVar.setFields(this.aMb);
            cVar.setDisabled(this.aMc);
            if (this.aMa != null) {
                cVar.setYear(this.aMa.getYear() + 1900);
                cVar.setMonth(this.aMa.getMonth() + 1);
                cVar.setDay(this.aMa.getDate());
            }
            if (this.aLY != null) {
                cVar.setStartDate(this.aLY);
            }
            if (this.aLZ != null) {
                cVar.setEndDate(this.aLZ);
            }
            return cVar;
        }
    }
}
