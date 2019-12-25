package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes9.dex */
public class i extends h {
    private int bFF;
    private Date bFh;
    private Date bFi;
    private String bFq;
    private boolean bFr;
    private BdTimePicker bJA;
    private boolean bJB;
    private int zl;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bJB = false;
    }

    public void setHour(int i) {
        this.bFF = i;
    }

    public int getHour() {
        return this.bJA.getHour();
    }

    public void setMinute(int i) {
        this.zl = i;
    }

    public int getMinute() {
        return this.bJA.getMinute();
    }

    private void Zu() {
        this.bJA = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bJA.setLayoutParams(layoutParams);
        this.bJA.setScrollCycle(true);
        this.bJA.setStartDate(this.bFh);
        this.bJA.setmEndDate(this.bFi);
        this.bJA.setHour(this.bFF);
        this.bJA.setMinute(this.zl);
        this.bJA.YQ();
        this.bJA.setDisabled(this.bFr);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bJB) {
            getWindow().addFlags(4718592);
        }
        Zu();
        ZD().ak(this.bJA);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bJA != null) {
            if (this.bFF != this.bJA.getHour()) {
                this.bJA.setHour(this.bFF);
            }
            if (this.zl != this.bJA.getMinute()) {
                this.bJA.setMinute(this.zl);
            }
        }
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
            return new i(context);
        }

        public a g(Date date) {
            this.bIZ = date;
            return this;
        }

        public a h(Date date) {
            this.bJa = date;
            return this;
        }

        public a i(Date date) {
            this.bJb = date;
            return this;
        }

        public a ks(String str) {
            this.bJc = str;
            return this;
        }

        public a dy(boolean z) {
            this.bJd = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h Zv() {
            i iVar = (i) super.Zv();
            iVar.setFields(this.bJc);
            iVar.setDisabled(this.bJd);
            if (this.bJb != null) {
                iVar.setHour(this.bJb.getHours());
                iVar.setMinute(this.bJb.getMinutes());
            }
            if (this.bIZ != null) {
                iVar.setStartDate(this.bIZ);
            }
            if (this.bJa != null) {
                iVar.setEndDate(this.bJa);
            }
            return iVar;
        }
    }
}
