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
    private int SX;
    private Date cja;
    private Date cjb;
    private String cjj;
    private boolean cjk;
    private int cjy;
    private BdTimePicker cnu;
    private boolean cnv;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cnv = false;
    }

    public void setHour(int i) {
        this.cjy = i;
    }

    public int getHour() {
        return this.cnu.getHour();
    }

    public void setMinute(int i) {
        this.SX = i;
    }

    public int getMinute() {
        return this.cnu.getMinute();
    }

    private void ako() {
        this.cnu = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cnu.setLayoutParams(layoutParams);
        this.cnu.setScrollCycle(true);
        this.cnu.setStartDate(this.cja);
        this.cnu.setmEndDate(this.cjb);
        this.cnu.setHour(this.cjy);
        this.cnu.setMinute(this.SX);
        this.cnu.ajK();
        this.cnu.setDisabled(this.cjk);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cnv) {
            getWindow().addFlags(4718592);
        }
        ako();
        akx().ap(this.cnu);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cnu != null) {
            if (this.cjy != this.cnu.getHour()) {
                this.cnu.setHour(this.cjy);
            }
            if (this.SX != this.cnu.getMinute()) {
                this.cnu.setMinute(this.SX);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cjj = str;
    }

    public void setDisabled(boolean z) {
        this.cjk = z;
    }

    public void setStartDate(Date date) {
        this.cja = date;
    }

    public void setEndDate(Date date) {
        this.cjb = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cmS;
        public Date cmT;
        public Date cmU;
        private String cmV;
        private boolean cmW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h bS(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.cmS = date;
            return this;
        }

        public a h(Date date) {
            this.cmT = date;
            return this;
        }

        public a i(Date date) {
            this.cmU = date;
            return this;
        }

        public a lW(String str) {
            this.cmV = str;
            return this;
        }

        public a eH(boolean z) {
            this.cmW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akp() {
            i iVar = (i) super.akp();
            iVar.setFields(this.cmV);
            iVar.setDisabled(this.cmW);
            if (this.cmU != null) {
                iVar.setHour(this.cmU.getHours());
                iVar.setMinute(this.cmU.getMinutes());
            }
            if (this.cmS != null) {
                iVar.setStartDate(this.cmS);
            }
            if (this.cmT != null) {
                iVar.setEndDate(this.cmT);
            }
            return iVar;
        }
    }
}
