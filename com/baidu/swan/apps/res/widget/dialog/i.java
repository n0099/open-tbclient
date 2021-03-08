package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes8.dex */
public class i extends h {
    private int Xh;
    private BdTimePicker dEg;
    private boolean dEh;
    private int dwG;
    private Date dwh;
    private Date dwi;
    private String dwq;
    private boolean dwr;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dEh = false;
    }

    public void setHour(int i) {
        this.dwG = i;
    }

    public int getHour() {
        return this.dEg.getHour();
    }

    public void setMinute(int i) {
        this.Xh = i;
    }

    public int getMinute() {
        return this.dEg.getMinute();
    }

    private void aHR() {
        this.dEg = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dEg.setLayoutParams(layoutParams);
        this.dEg.setScrollCycle(true);
        this.dEg.setStartDate(this.dwh);
        this.dEg.setmEndDate(this.dwi);
        this.dEg.setHour(this.dwG);
        this.dEg.setMinute(this.Xh);
        this.dEg.aGE();
        this.dEg.setDisabled(this.dwr);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dEh) {
            getWindow().addFlags(4718592);
        }
        aHR();
        aIe().aH(this.dEg);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dEg != null) {
            if (this.dwG != this.dEg.getHour()) {
                this.dEg.setHour(this.dwG);
            }
            if (this.Xh != this.dEg.getMinute()) {
                this.dEg.setMinute(this.Xh);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dwq = str;
    }

    public void setDisabled(boolean z) {
        this.dwr = z;
    }

    public void setStartDate(Date date) {
        this.dwh = date;
    }

    public void setEndDate(Date date) {
        this.dwi = date;
    }

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        private boolean dDA;
        public Date dDw;
        public Date dDx;
        public Date dDy;
        private String dDz;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h dh(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dDw = date;
            return this;
        }

        public a j(Date date) {
            this.dDx = date;
            return this;
        }

        public a k(Date date) {
            this.dDy = date;
            return this;
        }

        public a rF(String str) {
            this.dDz = str;
            return this;
        }

        public a ha(boolean z) {
            this.dDA = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHS() {
            i iVar = (i) super.aHS();
            iVar.setFields(this.dDz);
            iVar.setDisabled(this.dDA);
            if (this.dDy != null) {
                iVar.setHour(this.dDy.getHours());
                iVar.setMinute(this.dDy.getMinutes());
            }
            if (this.dDw != null) {
                iVar.setStartDate(this.dDw);
            }
            if (this.dDx != null) {
                iVar.setEndDate(this.dDx);
            }
            return iVar;
        }
    }
}
