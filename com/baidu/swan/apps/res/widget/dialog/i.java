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
    private int bKI;
    private Date bKk;
    private Date bKl;
    private String bKt;
    private boolean bKu;
    private BdTimePicker bOC;
    private boolean bOD;
    private int zH;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.bOD = false;
    }

    public void setHour(int i) {
        this.bKI = i;
    }

    public int getHour() {
        return this.bOC.getHour();
    }

    public void setMinute(int i) {
        this.zH = i;
    }

    public int getMinute() {
        return this.bOC.getMinute();
    }

    private void ack() {
        this.bOC = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.bOC.setLayoutParams(layoutParams);
        this.bOC.setScrollCycle(true);
        this.bOC.setStartDate(this.bKk);
        this.bOC.setmEndDate(this.bKl);
        this.bOC.setHour(this.bKI);
        this.bOC.setMinute(this.zH);
        this.bOC.abG();
        this.bOC.setDisabled(this.bKu);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.bOD) {
            getWindow().addFlags(4718592);
        }
        ack();
        act().ao(this.bOC);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.bOC != null) {
            if (this.bKI != this.bOC.getHour()) {
                this.bOC.setHour(this.bKI);
            }
            if (this.zH != this.bOC.getMinute()) {
                this.bOC.setMinute(this.zH);
            }
        }
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
            return new i(context);
        }

        public a g(Date date) {
            this.bOb = date;
            return this;
        }

        public a h(Date date) {
            this.bOc = date;
            return this;
        }

        public a i(Date date) {
            this.bOd = date;
            return this;
        }

        public a kJ(String str) {
            this.bOe = str;
            return this;
        }

        public a dL(boolean z) {
            this.bOf = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h acl() {
            i iVar = (i) super.acl();
            iVar.setFields(this.bOe);
            iVar.setDisabled(this.bOf);
            if (this.bOd != null) {
                iVar.setHour(this.bOd.getHours());
                iVar.setMinute(this.bOd.getMinutes());
            }
            if (this.bOb != null) {
                iVar.setStartDate(this.bOb);
            }
            if (this.bOc != null) {
                iVar.setEndDate(this.bOc);
            }
            return iVar;
        }
    }
}
