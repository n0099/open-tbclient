package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes2.dex */
public class c extends e {
    private int MB;
    private int MC;
    private int MD;
    private String aFC;
    private boolean aFD;
    private Date aFt;
    private Date aFu;
    private BdDatePicker aLT;

    c(Context context) {
        super(context, b.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.MB = i;
    }

    public int getYear() {
        return this.aLT.getYear();
    }

    public void setMonth(int i) {
        this.MC = i;
    }

    public int getMonth() {
        return this.aLT.getMonth();
    }

    public void setDay(int i) {
        this.MD = i;
    }

    public int getDay() {
        return this.aLT.getDay();
    }

    private boolean fV(String str) {
        return this.aLT.fV(str);
    }

    public String Io() {
        StringBuilder sb = new StringBuilder();
        if (fV("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (fV("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (fV("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Ip() {
        this.aLT = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aLT.setLayoutParams(layoutParams);
        this.aLT.setScrollCycle(true);
        this.aLT.setStartDate(this.aFt);
        this.aLT.setEndDate(this.aFu);
        this.aLT.setYear(this.MB);
        this.aLT.setMonth(this.MC);
        this.aLT.setDay(this.MD);
        this.aLT.GN();
        this.aLT.setFields(this.aFC);
        this.aLT.setDisabled(this.aFD);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Ip();
        Ir().ad(this.aLT);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView In = Ir().In();
        if (In != null) {
            In.setBackgroundResource(b.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFC = str;
    }

    public void setDisabled(boolean z) {
        this.aFD = z;
    }

    public void setStartDate(Date date) {
        this.aFt = date;
    }

    public void setEndDate(Date date) {
        this.aFu = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLU;
        public Date aLV;
        public Date aLW;
        private String aLX;
        private boolean aLY;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new c(context);
        }

        public a g(Date date) {
            this.aLU = date;
            return this;
        }

        public a h(Date date) {
            this.aLV = date;
            return this;
        }

        public a i(Date date) {
            this.aLW = date;
            return this;
        }

        public a gc(String str) {
            this.aLX = str;
            return this;
        }

        public a bM(boolean z) {
            this.aLY = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            c cVar = (c) super.zr();
            cVar.setFields(this.aLX);
            cVar.setDisabled(this.aLY);
            if (this.aLW != null) {
                cVar.setYear(this.aLW.getYear() + 1900);
                cVar.setMonth(this.aLW.getMonth() + 1);
                cVar.setDay(this.aLW.getDate());
            }
            if (this.aLU != null) {
                cVar.setStartDate(this.aLU);
            }
            if (this.aLV != null) {
                cVar.setEndDate(this.aLV);
            }
            return cVar;
        }
    }
}
