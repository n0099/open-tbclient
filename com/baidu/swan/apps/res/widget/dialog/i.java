package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes11.dex */
public class i extends h {
    private int Ti;
    private Date cuE;
    private Date cuF;
    private String cuN;
    private boolean cuO;
    private int cvc;
    private BdTimePicker cyZ;
    private boolean cza;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cza = false;
    }

    public void setHour(int i) {
        this.cvc = i;
    }

    public int getHour() {
        return this.cyZ.getHour();
    }

    public void setMinute(int i) {
        this.Ti = i;
    }

    public int getMinute() {
        return this.cyZ.getMinute();
    }

    private void aof() {
        this.cyZ = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cyZ.setLayoutParams(layoutParams);
        this.cyZ.setScrollCycle(true);
        this.cyZ.setStartDate(this.cuE);
        this.cyZ.setmEndDate(this.cuF);
        this.cyZ.setHour(this.cvc);
        this.cyZ.setMinute(this.Ti);
        this.cyZ.any();
        this.cyZ.setDisabled(this.cuO);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cza) {
            getWindow().addFlags(4718592);
        }
        aof();
        aoo().ap(this.cyZ);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cyZ != null) {
            if (this.cvc != this.cyZ.getHour()) {
                this.cyZ.setHour(this.cvc);
            }
            if (this.Ti != this.cyZ.getMinute()) {
                this.cyZ.setMinute(this.Ti);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cuN = str;
    }

    public void setDisabled(boolean z) {
        this.cuO = z;
    }

    public void setStartDate(Date date) {
        this.cuE = date;
    }

    public void setEndDate(Date date) {
        this.cuF = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cyA;
        private String cyB;
        private boolean cyC;
        public Date cyy;
        public Date cyz;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cd(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.cyy = date;
            return this;
        }

        public a h(Date date) {
            this.cyz = date;
            return this;
        }

        public a i(Date date) {
            this.cyA = date;
            return this;
        }

        public a nr(String str) {
            this.cyB = str;
            return this;
        }

        public a fa(boolean z) {
            this.cyC = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aog() {
            i iVar = (i) super.aog();
            iVar.setFields(this.cyB);
            iVar.setDisabled(this.cyC);
            if (this.cyA != null) {
                iVar.setHour(this.cyA.getHours());
                iVar.setMinute(this.cyA.getMinutes());
            }
            if (this.cyy != null) {
                iVar.setStartDate(this.cyy);
            }
            if (this.cyz != null) {
                iVar.setEndDate(this.cyz);
            }
            return iVar;
        }
    }
}
