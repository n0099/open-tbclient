package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes3.dex */
public class i extends h {
    private int UB;
    private String cMA;
    private boolean cMB;
    private int cMP;
    private Date cMr;
    private Date cMs;
    private BdTimePicker cRy;
    private boolean cRz;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cRz = false;
    }

    public void setHour(int i) {
        this.cMP = i;
    }

    public int getHour() {
        return this.cRy.getHour();
    }

    public void setMinute(int i) {
        this.UB = i;
    }

    public int getMinute() {
        return this.cRy.getMinute();
    }

    private void azQ() {
        this.cRy = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cRy.setLayoutParams(layoutParams);
        this.cRy.setScrollCycle(true);
        this.cRy.setStartDate(this.cMr);
        this.cRy.setmEndDate(this.cMs);
        this.cRy.setHour(this.cMP);
        this.cRy.setMinute(this.UB);
        this.cRy.azb();
        this.cRy.setDisabled(this.cMB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cRz) {
            getWindow().addFlags(4718592);
        }
        azQ();
        azZ().av(this.cRy);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cRy != null) {
            if (this.cMP != this.cRy.getHour()) {
                this.cRy.setHour(this.cMP);
            }
            if (this.UB != this.cRy.getMinute()) {
                this.cRy.setMinute(this.UB);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cMA = str;
    }

    public void setDisabled(boolean z) {
        this.cMB = z;
    }

    public void setStartDate(Date date) {
        this.cMr = date;
    }

    public void setEndDate(Date date) {
        this.cMs = date;
    }

    /* loaded from: classes3.dex */
    public static class a extends h.a {
        public Date cQX;
        public Date cQY;
        public Date cQZ;
        private String cRa;
        private boolean cRb;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cm(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.cQX = date;
            return this;
        }

        public a j(Date date) {
            this.cQY = date;
            return this;
        }

        public a k(Date date) {
            this.cQZ = date;
            return this;
        }

        public a qz(String str) {
            this.cRa = str;
            return this;
        }

        public a fG(boolean z) {
            this.cRb = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h azR() {
            i iVar = (i) super.azR();
            iVar.setFields(this.cRa);
            iVar.setDisabled(this.cRb);
            if (this.cQZ != null) {
                iVar.setHour(this.cQZ.getHours());
                iVar.setMinute(this.cQZ.getMinutes());
            }
            if (this.cQX != null) {
                iVar.setStartDate(this.cQX);
            }
            if (this.cQY != null) {
                iVar.setEndDate(this.cQY);
            }
            return iVar;
        }
    }
}
