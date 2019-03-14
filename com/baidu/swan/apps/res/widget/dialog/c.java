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
    private String aFD;
    private boolean aFE;
    private Date aFu;
    private Date aFv;
    private BdDatePicker aLU;

    c(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.MC = i;
    }

    public int getYear() {
        return this.aLU.getYear();
    }

    public void setMonth(int i) {
        this.MD = i;
    }

    public int getMonth() {
        return this.aLU.getMonth();
    }

    public void setDay(int i) {
        this.ME = i;
    }

    public int getDay() {
        return this.aLU.getDay();
    }

    private boolean fV(String str) {
        return this.aLU.fV(str);
    }

    public String Io() {
        StringBuilder sb = new StringBuilder();
        if (fV("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (fV("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (fV(Config.TRACE_VISIT_RECENT_DAY)) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Ip() {
        this.aLU = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aLU.setLayoutParams(layoutParams);
        this.aLU.setScrollCycle(true);
        this.aLU.setStartDate(this.aFu);
        this.aLU.setEndDate(this.aFv);
        this.aLU.setYear(this.MC);
        this.aLU.setMonth(this.MD);
        this.aLU.setDay(this.ME);
        this.aLU.GN();
        this.aLU.setFields(this.aFD);
        this.aLU.setDisabled(this.aFE);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Ip();
        Ir().ad(this.aLU);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView In = Ir().In();
        if (In != null) {
            In.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFD = str;
    }

    public void setDisabled(boolean z) {
        this.aFE = z;
    }

    public void setStartDate(Date date) {
        this.aFu = date;
    }

    public void setEndDate(Date date) {
        this.aFv = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLV;
        public Date aLW;
        public Date aLX;
        private String aLY;
        private boolean aLZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new c(context);
        }

        public a g(Date date) {
            this.aLV = date;
            return this;
        }

        public a h(Date date) {
            this.aLW = date;
            return this;
        }

        public a i(Date date) {
            this.aLX = date;
            return this;
        }

        public a gc(String str) {
            this.aLY = str;
            return this;
        }

        public a bM(boolean z) {
            this.aLZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            c cVar = (c) super.zr();
            cVar.setFields(this.aLY);
            cVar.setDisabled(this.aLZ);
            if (this.aLX != null) {
                cVar.setYear(this.aLX.getYear() + 1900);
                cVar.setMonth(this.aLX.getMonth() + 1);
                cVar.setDay(this.aLX.getDate());
            }
            if (this.aLV != null) {
                cVar.setStartDate(this.aLV);
            }
            if (this.aLW != null) {
                cVar.setEndDate(this.aLW);
            }
            return cVar;
        }
    }
}
