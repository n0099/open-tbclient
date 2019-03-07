package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.e;
import java.util.Date;
/* loaded from: classes2.dex */
public class f extends e {
    private int MF;
    private String aFC;
    private boolean aFD;
    private int aFU;
    private Date aFt;
    private Date aFu;
    private BdTimePicker aMw;
    private boolean aMx;

    f(Context context) {
        super(context, b.i.NoTitleDialog);
        this.aMx = false;
    }

    public void setHour(int i) {
        this.aFU = i;
    }

    public int getHour() {
        return this.aMw.getHour();
    }

    public void setMinute(int i) {
        this.MF = i;
    }

    public int getMinute() {
        return this.aMw.getMinute();
    }

    private void Ip() {
        this.aMw = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMw.setLayoutParams(layoutParams);
        this.aMw.setScrollCycle(true);
        this.aMw.setStartDate(this.aFt);
        this.aMw.setmEndDate(this.aFu);
        this.aMw.setHour(this.aFU);
        this.aMw.setMinute(this.MF);
        this.aMw.GN();
        this.aMw.setDisabled(this.aFD);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aMx) {
            getWindow().addFlags(4718592);
        }
        Ip();
        Ir().ad(this.aMw);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView In = Ir().In();
        if (In != null) {
            In.setBackgroundResource(b.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aMw != null) {
            if (this.aFU != this.aMw.getHour()) {
                this.aMw.setHour(this.aFU);
            }
            if (this.MF != this.aMw.getMinute()) {
                this.aMw.setMinute(this.MF);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFC = str;
    }

    public void setDisabled(boolean z) {
        this.aFD = z;
    }

    public void setStartDate(Date date) {
        this.aFt = date;
    }

    public void setEndDate(Date date) {
        this.aFu = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLU;
        public Date aLV;
        public Date aLW;
        private String aLX;
        private boolean aLY;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new f(context);
        }

        public a j(Date date) {
            this.aLU = date;
            return this;
        }

        public a k(Date date) {
            this.aLV = date;
            return this;
        }

        public a l(Date date) {
            this.aLW = date;
            return this;
        }

        public a ge(String str) {
            this.aLX = str;
            return this;
        }

        public a bW(boolean z) {
            this.aLY = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            f fVar = (f) super.zr();
            fVar.setFields(this.aLX);
            fVar.setDisabled(this.aLY);
            if (this.aLW != null) {
                fVar.setHour(this.aLW.getHours());
                fVar.setMinute(this.aLW.getMinutes());
            }
            if (this.aLU != null) {
                fVar.setStartDate(this.aLU);
            }
            if (this.aLV != null) {
                fVar.setEndDate(this.aLV);
            }
            return fVar;
        }
    }
}
