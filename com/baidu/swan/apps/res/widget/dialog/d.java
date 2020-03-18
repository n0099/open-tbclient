package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes11.dex */
public class d extends h {
    private Date bKk;
    private Date bKl;
    private String bKt;
    private boolean bKu;
    private BdDatePicker bOa;
    private int zD;
    private int zE;
    private int zF;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.zD = i;
    }

    public int getYear() {
        return this.bOa.getYear();
    }

    public void setMonth(int i) {
        this.zE = i;
    }

    public int getMonth() {
        return this.bOa.getMonth();
    }

    public void setDay(int i) {
        this.zF = i;
    }

    public int getDay() {
        return this.bOa.getDay();
    }

    private boolean kB(String str) {
        return this.bOa.kB(str);
    }

    public String acj() {
        StringBuilder sb = new StringBuilder();
        if (kB("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (kB("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (kB("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void ack() {
        this.bOa = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bOa.setLayoutParams(layoutParams);
        this.bOa.setScrollCycle(true);
        this.bOa.setStartDate(this.bKk);
        this.bOa.setEndDate(this.bKl);
        this.bOa.setYear(this.zD);
        this.bOa.setMonth(this.zE);
        this.bOa.setDay(this.zF);
        this.bOa.abG();
        this.bOa.setFields(this.bKt);
        this.bOa.setDisabled(this.bKu);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        ack();
        act().ao(this.bOa);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bKt = str;
    }

    public void setDisabled(boolean z) {
        this.bKu = z;
    }

    public void setStartDate(Date date) {
        this.bKk = date;
    }

    public void setEndDate(Date date) {
        this.bKl = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date bOb;
        public Date bOc;
        public Date bOd;
        private String bOe;
        private boolean bOf;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cq(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bOb = date;
            return this;
        }

        public a e(Date date) {
            this.bOc = date;
            return this;
        }

        public a f(Date date) {
            this.bOd = date;
            return this;
        }

        public a kH(String str) {
            this.bOe = str;
            return this;
        }

        public a dz(boolean z) {
            this.bOf = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acl() {
            d dVar = (d) super.acl();
            dVar.setFields(this.bOe);
            dVar.setDisabled(this.bOf);
            if (this.bOd != null) {
                dVar.setYear(this.bOd.getYear() + 1900);
                dVar.setMonth(this.bOd.getMonth() + 1);
                dVar.setDay(this.bOd.getDate());
            }
            if (this.bOb != null) {
                dVar.setStartDate(this.bOb);
            }
            if (this.bOc != null) {
                dVar.setEndDate(this.bOc);
            }
            return dVar;
        }
    }
}
