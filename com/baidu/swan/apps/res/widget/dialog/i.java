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
    private int TK;
    private BdTimePicker cDJ;
    private boolean cDK;
    private int czN;
    private Date czp;
    private Date czq;
    private String czy;
    private boolean czz;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cDK = false;
    }

    public void setHour(int i) {
        this.czN = i;
    }

    public int getHour() {
        return this.cDJ.getHour();
    }

    public void setMinute(int i) {
        this.TK = i;
    }

    public int getMinute() {
        return this.cDJ.getMinute();
    }

    private void apm() {
        this.cDJ = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cDJ.setLayoutParams(layoutParams);
        this.cDJ.setScrollCycle(true);
        this.cDJ.setStartDate(this.czp);
        this.cDJ.setmEndDate(this.czq);
        this.cDJ.setHour(this.czN);
        this.cDJ.setMinute(this.TK);
        this.cDJ.aoE();
        this.cDJ.setDisabled(this.czz);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cDK) {
            getWindow().addFlags(4718592);
        }
        apm();
        apv().ap(this.cDJ);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cDJ != null) {
            if (this.czN != this.cDJ.getHour()) {
                this.cDJ.setHour(this.czN);
            }
            if (this.TK != this.cDJ.getMinute()) {
                this.cDJ.setMinute(this.TK);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.czy = str;
    }

    public void setDisabled(boolean z) {
        this.czz = z;
    }

    public void setStartDate(Date date) {
        this.czp = date;
    }

    public void setEndDate(Date date) {
        this.czq = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cDi;
        public Date cDj;
        public Date cDk;
        private String cDl;
        private boolean cDm;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.cDi = date;
            return this;
        }

        public a h(Date date) {
            this.cDj = date;
            return this;
        }

        public a i(Date date) {
            this.cDk = date;
            return this;
        }

        public a nz(String str) {
            this.cDl = str;
            return this;
        }

        public a ff(boolean z) {
            this.cDm = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h apn() {
            i iVar = (i) super.apn();
            iVar.setFields(this.cDl);
            iVar.setDisabled(this.cDm);
            if (this.cDk != null) {
                iVar.setHour(this.cDk.getHours());
                iVar.setMinute(this.cDk.getMinutes());
            }
            if (this.cDi != null) {
                iVar.setStartDate(this.cDi);
            }
            if (this.cDj != null) {
                iVar.setEndDate(this.cDj);
            }
            return iVar;
        }
    }
}
