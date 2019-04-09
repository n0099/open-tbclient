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
    private String aFH;
    private boolean aFI;
    private Date aFy;
    private Date aFz;
    private BdDatePicker aLY;

    c(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.MC = i;
    }

    public int getYear() {
        return this.aLY.getYear();
    }

    public void setMonth(int i) {
        this.MD = i;
    }

    public int getMonth() {
        return this.aLY.getMonth();
    }

    public void setDay(int i) {
        this.ME = i;
    }

    public int getDay() {
        return this.aLY.getDay();
    }

    private boolean fW(String str) {
        return this.aLY.fW(str);
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
        this.aLY = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aLY.setLayoutParams(layoutParams);
        this.aLY.setScrollCycle(true);
        this.aLY.setStartDate(this.aFy);
        this.aLY.setEndDate(this.aFz);
        this.aLY.setYear(this.MC);
        this.aLY.setMonth(this.MD);
        this.aLY.setDay(this.ME);
        this.aLY.GL();
        this.aLY.setFields(this.aFH);
        this.aLY.setDisabled(this.aFI);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        In();
        Ip().ad(this.aLY);
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
        this.aFH = str;
    }

    public void setDisabled(boolean z) {
        this.aFI = z;
    }

    public void setStartDate(Date date) {
        this.aFy = date;
    }

    public void setEndDate(Date date) {
        this.aFz = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLZ;
        public Date aMa;
        public Date aMb;
        private String aMc;
        private boolean aMd;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new c(context);
        }

        public a g(Date date) {
            this.aLZ = date;
            return this;
        }

        public a h(Date date) {
            this.aMa = date;
            return this;
        }

        public a i(Date date) {
            this.aMb = date;
            return this;
        }

        public a gd(String str) {
            this.aMc = str;
            return this;
        }

        public a bM(boolean z) {
            this.aMd = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            c cVar = (c) super.zq();
            cVar.setFields(this.aMc);
            cVar.setDisabled(this.aMd);
            if (this.aMb != null) {
                cVar.setYear(this.aMb.getYear() + 1900);
                cVar.setMonth(this.aMb.getMonth() + 1);
                cVar.setDay(this.aMb.getDate());
            }
            if (this.aLZ != null) {
                cVar.setStartDate(this.aLZ);
            }
            if (this.aMa != null) {
                cVar.setEndDate(this.aMa);
            }
            return cVar;
        }
    }
}
