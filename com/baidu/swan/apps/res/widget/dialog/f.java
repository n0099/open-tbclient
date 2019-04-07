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
    private String aFG;
    private boolean aFH;
    private int aFY;
    private Date aFx;
    private Date aFy;
    private BdTimePicker aMA;
    private boolean aMB;

    f(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aMB = false;
    }

    public void setHour(int i) {
        this.aFY = i;
    }

    public int getHour() {
        return this.aMA.getHour();
    }

    public void setMinute(int i) {
        this.MG = i;
    }

    public int getMinute() {
        return this.aMA.getMinute();
    }

    private void In() {
        this.aMA = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMA.setLayoutParams(layoutParams);
        this.aMA.setScrollCycle(true);
        this.aMA.setStartDate(this.aFx);
        this.aMA.setmEndDate(this.aFy);
        this.aMA.setHour(this.aFY);
        this.aMA.setMinute(this.MG);
        this.aMA.GL();
        this.aMA.setDisabled(this.aFH);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aMB) {
            getWindow().addFlags(4718592);
        }
        In();
        Ip().ad(this.aMA);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView Il = Ip().Il();
        if (Il != null) {
            Il.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aMA != null) {
            if (this.aFY != this.aMA.getHour()) {
                this.aMA.setHour(this.aFY);
            }
            if (this.MG != this.aMA.getMinute()) {
                this.aMA.setMinute(this.MG);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFG = str;
    }

    public void setDisabled(boolean z) {
        this.aFH = z;
    }

    public void setStartDate(Date date) {
        this.aFx = date;
    }

    public void setEndDate(Date date) {
        this.aFy = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLY;
        public Date aLZ;
        public Date aMa;
        private String aMb;
        private boolean aMc;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new f(context);
        }

        public a j(Date date) {
            this.aLY = date;
            return this;
        }

        public a k(Date date) {
            this.aLZ = date;
            return this;
        }

        public a l(Date date) {
            this.aMa = date;
            return this;
        }

        public a gf(String str) {
            this.aMb = str;
            return this;
        }

        public a bW(boolean z) {
            this.aMc = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zq() {
            f fVar = (f) super.zq();
            fVar.setFields(this.aMb);
            fVar.setDisabled(this.aMc);
            if (this.aMa != null) {
                fVar.setHour(this.aMa.getHours());
                fVar.setMinute(this.aMa.getMinutes());
            }
            if (this.aLY != null) {
                fVar.setStartDate(this.aLY);
            }
            if (this.aLZ != null) {
                fVar.setEndDate(this.aLZ);
            }
            return fVar;
        }
    }
}
