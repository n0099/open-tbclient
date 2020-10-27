package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes10.dex */
public class i extends h {
    private int UV;
    private Date dgV;
    private Date dgW;
    private String dhe;
    private boolean dhf;
    private int dht;
    private BdTimePicker dmf;
    private boolean dmg;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dmg = false;
    }

    public void setHour(int i) {
        this.dht = i;
    }

    public int getHour() {
        return this.dmf.getHour();
    }

    public void setMinute(int i) {
        this.UV = i;
    }

    public int getMinute() {
        return this.dmf.getMinute();
    }

    private void aEt() {
        this.dmf = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dmf.setLayoutParams(layoutParams);
        this.dmf.setScrollCycle(true);
        this.dmf.setStartDate(this.dgV);
        this.dmf.setmEndDate(this.dgW);
        this.dmf.setHour(this.dht);
        this.dmf.setMinute(this.UV);
        this.dmf.aDE();
        this.dmf.setDisabled(this.dhf);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dmg) {
            getWindow().addFlags(4718592);
        }
        aEt();
        aEC().ax(this.dmf);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dmf != null) {
            if (this.dht != this.dmf.getHour()) {
                this.dmf.setHour(this.dht);
            }
            if (this.UV != this.dmf.getMinute()) {
                this.dmf.setMinute(this.UV);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dhe = str;
    }

    public void setDisabled(boolean z) {
        this.dhf = z;
    }

    public void setStartDate(Date date) {
        this.dgV = date;
    }

    public void setEndDate(Date date) {
        this.dgW = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date dlE;
        public Date dlF;
        public Date dlG;
        private String dlH;
        private boolean dlI;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dlE = date;
            return this;
        }

        public a j(Date date) {
            this.dlF = date;
            return this;
        }

        public a k(Date date) {
            this.dlG = date;
            return this;
        }

        public a rE(String str) {
            this.dlH = str;
            return this;
        }

        public a gp(boolean z) {
            this.dlI = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aEu() {
            i iVar = (i) super.aEu();
            iVar.setFields(this.dlH);
            iVar.setDisabled(this.dlI);
            if (this.dlG != null) {
                iVar.setHour(this.dlG.getHours());
                iVar.setMinute(this.dlG.getMinutes());
            }
            if (this.dlE != null) {
                iVar.setStartDate(this.dlE);
            }
            if (this.dlF != null) {
                iVar.setEndDate(this.dlF);
            }
            return iVar;
        }
    }
}
