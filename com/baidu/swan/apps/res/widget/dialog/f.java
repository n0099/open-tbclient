package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import java.util.Date;
/* loaded from: classes2.dex */
public class f extends e {
    private int MG;
    private String aFH;
    private boolean aFI;
    private int aFZ;
    private Date aFy;
    private Date aFz;
    private BdTimePicker aMB;
    private boolean aMC;

    f(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aMC = false;
    }

    public void setHour(int i) {
        this.aFZ = i;
    }

    public int getHour() {
        return this.aMB.getHour();
    }

    public void setMinute(int i) {
        this.MG = i;
    }

    public int getMinute() {
        return this.aMB.getMinute();
    }

    private void In() {
        this.aMB = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMB.setLayoutParams(layoutParams);
        this.aMB.setScrollCycle(true);
        this.aMB.setStartDate(this.aFy);
        this.aMB.setmEndDate(this.aFz);
        this.aMB.setHour(this.aFZ);
        this.aMB.setMinute(this.MG);
        this.aMB.GL();
        this.aMB.setDisabled(this.aFI);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aMC) {
            getWindow().addFlags(4718592);
        }
        In();
        Ip().ad(this.aMB);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView Il = Ip().Il();
        if (Il != null) {
            Il.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aMB != null) {
            if (this.aFZ != this.aMB.getHour()) {
                this.aMB.setHour(this.aFZ);
            }
            if (this.MG != this.aMB.getMinute()) {
                this.aMB.setMinute(this.MG);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFH = str;
    }

    public void setDisabled(boolean z) {
        this.aFI = z;
    }

    public void setStartDate(Date date) {
        this.aFy = date;
    }

    public void setEndDate(Date date) {
        this.aFz = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLZ;
        public Date aMa;
        public Date aMb;
        private String aMc;
        private boolean aMd;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new f(context);
        }

        public a j(Date date) {
            this.aLZ = date;
            return this;
        }

        public a k(Date date) {
            this.aMa = date;
            return this;
        }

        public a l(Date date) {
            this.aMb = date;
            return this;
        }

        public a gf(String str) {
            this.aMc = str;
            return this;
        }

        public a bW(boolean z) {
            this.aMd = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            f fVar = (f) super.zq();
            fVar.setFields(this.aMc);
            fVar.setDisabled(this.aMd);
            if (this.aMb != null) {
                fVar.setHour(this.aMb.getHours());
                fVar.setMinute(this.aMb.getMinutes());
            }
            if (this.aLZ != null) {
                fVar.setStartDate(this.aLZ);
            }
            if (this.aMa != null) {
                fVar.setEndDate(this.aMa);
            }
            return fVar;
        }
    }
}
