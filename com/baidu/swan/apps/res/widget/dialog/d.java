package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes9.dex */
public class d extends h {
    private Date bFh;
    private Date bFi;
    private String bFq;
    private boolean bFr;
    private BdDatePicker bIY;
    private int zh;
    private int zi;
    private int zj;

    d(Context context) {
        super(context, a.i.NoTitleDialog);
    }

    public void setYear(int i) {
        this.zh = i;
    }

    public int getYear() {
        return this.bIY.getYear();
    }

    public void setMonth(int i) {
        this.zi = i;
    }

    public int getMonth() {
        return this.bIY.getMonth();
    }

    public void setDay(int i) {
        this.zj = i;
    }

    public int getDay() {
        return this.bIY.getDay();
    }

    private boolean kk(String str) {
        return this.bIY.kk(str);
    }

    public String Zt() {
        StringBuilder sb = new StringBuilder();
        if (kk("year")) {
            sb.append(String.format("%d-", Integer.valueOf(getYear())));
        }
        if (kk("month")) {
            sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
        }
        if (kk("day")) {
            sb.append(String.format("%02d", Integer.valueOf(getDay())));
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb2;
    }

    private void Zu() {
        this.bIY = new BdDatePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.bIY.setLayoutParams(layoutParams);
        this.bIY.setScrollCycle(true);
        this.bIY.setStartDate(this.bFh);
        this.bIY.setEndDate(this.bFi);
        this.bIY.setYear(this.zh);
        this.bIY.setMonth(this.zi);
        this.bIY.setDay(this.zj);
        this.bIY.YQ();
        this.bIY.setFields(this.bFq);
        this.bIY.setDisabled(this.bFr);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        Zu();
        ZD().ak(this.bIY);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        super.show();
    }

    public void setFields(String str) {
        this.bFq = str;
    }

    public void setDisabled(boolean z) {
        this.bFr = z;
    }

    public void setStartDate(Date date) {
        this.bFh = date;
    }

    public void setEndDate(Date date) {
        this.bFi = date;
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public Date bIZ;
        public Date bJa;
        public Date bJb;
        private String bJc;
        private boolean bJd;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cn(Context context) {
            return new d(context);
        }

        public a d(Date date) {
            this.bIZ = date;
            return this;
        }

        public a e(Date date) {
            this.bJa = date;
            return this;
        }

        public a f(Date date) {
            this.bJb = date;
            return this;
        }

        public a kq(String str) {
            this.bJc = str;
            return this;
        }

        public a dm(boolean z) {
            this.bJd = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h Zv() {
            d dVar = (d) super.Zv();
            dVar.setFields(this.bJc);
            dVar.setDisabled(this.bJd);
            if (this.bJb != null) {
                dVar.setYear(this.bJb.getYear() + 1900);
                dVar.setMonth(this.bJb.getMonth() + 1);
                dVar.setDay(this.bJb.getDate());
            }
            if (this.bIZ != null) {
                dVar.setStartDate(this.bIZ);
            }
            if (this.bJa != null) {
                dVar.setEndDate(this.bJa);
            }
            return dVar;
        }
    }
}
