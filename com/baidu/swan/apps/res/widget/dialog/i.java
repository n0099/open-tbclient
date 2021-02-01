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
    private int VL;
    private BdTimePicker dCF;
    private boolean dCG;
    private Date duG;
    private Date duH;
    private String duP;
    private boolean duQ;
    private int dvf;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dCG = false;
    }

    public void setHour(int i) {
        this.dvf = i;
    }

    public int getHour() {
        return this.dCF.getHour();
    }

    public void setMinute(int i) {
        this.VL = i;
    }

    public int getMinute() {
        return this.dCF.getMinute();
    }

    private void aHO() {
        this.dCF = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dCF.setLayoutParams(layoutParams);
        this.dCF.setScrollCycle(true);
        this.dCF.setStartDate(this.duG);
        this.dCF.setmEndDate(this.duH);
        this.dCF.setHour(this.dvf);
        this.dCF.setMinute(this.VL);
        this.dCF.aGB();
        this.dCF.setDisabled(this.duQ);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dCG) {
            getWindow().addFlags(4718592);
        }
        aHO();
        aIb().aH(this.dCF);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dCF != null) {
            if (this.dvf != this.dCF.getHour()) {
                this.dCF.setHour(this.dvf);
            }
            if (this.VL != this.dCF.getMinute()) {
                this.dCF.setMinute(this.VL);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.duP = str;
    }

    public void setDisabled(boolean z) {
        this.duQ = z;
    }

    public void setStartDate(Date date) {
        this.duG = date;
    }

    public void setEndDate(Date date) {
        this.duH = date;
    }

    /* loaded from: classes9.dex */
    public static class a extends h.a {
        public Date dBV;
        public Date dBW;
        public Date dBX;
        private String dBY;
        private boolean dBZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h di(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dBV = date;
            return this;
        }

        public a j(Date date) {
            this.dBW = date;
            return this;
        }

        public a k(Date date) {
            this.dBX = date;
            return this;
        }

        public a ry(String str) {
            this.dBY = str;
            return this;
        }

        public a ha(boolean z) {
            this.dBZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aHP() {
            i iVar = (i) super.aHP();
            iVar.setFields(this.dBY);
            iVar.setDisabled(this.dBZ);
            if (this.dBX != null) {
                iVar.setHour(this.dBX.getHours());
                iVar.setMinute(this.dBX.getMinutes());
            }
            if (this.dBV != null) {
                iVar.setStartDate(this.dBV);
            }
            if (this.dBW != null) {
                iVar.setEndDate(this.dBW);
            }
            return iVar;
        }
    }
}
