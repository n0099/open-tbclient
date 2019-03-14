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
    private String aFD;
    private boolean aFE;
    private int aFV;
    private Date aFu;
    private Date aFv;
    private BdTimePicker aMx;
    private boolean aMy;

    f(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aMy = false;
    }

    public void setHour(int i) {
        this.aFV = i;
    }

    public int getHour() {
        return this.aMx.getHour();
    }

    public void setMinute(int i) {
        this.MG = i;
    }

    public int getMinute() {
        return this.aMx.getMinute();
    }

    private void Ip() {
        this.aMx = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aMx.setLayoutParams(layoutParams);
        this.aMx.setScrollCycle(true);
        this.aMx.setStartDate(this.aFu);
        this.aMx.setmEndDate(this.aFv);
        this.aMx.setHour(this.aFV);
        this.aMx.setMinute(this.MG);
        this.aMx.GN();
        this.aMx.setDisabled(this.aFE);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aMy) {
            getWindow().addFlags(4718592);
        }
        Ip();
        Ir().ad(this.aMx);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b, android.app.Dialog
    public void show() {
        TextView In = Ir().In();
        if (In != null) {
            In.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aMx != null) {
            if (this.aFV != this.aMx.getHour()) {
                this.aMx.setHour(this.aFV);
            }
            if (this.MG != this.aMx.getMinute()) {
                this.aMx.setMinute(this.MG);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aFD = str;
    }

    public void setDisabled(boolean z) {
        this.aFE = z;
    }

    public void setStartDate(Date date) {
        this.aFu = date;
    }

    public void setEndDate(Date date) {
        this.aFv = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends e.a {
        public Date aLV;
        public Date aLW;
        public Date aLX;
        private String aLY;
        private boolean aLZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        protected e bB(Context context) {
            return new f(context);
        }

        public a j(Date date) {
            this.aLV = date;
            return this;
        }

        public a k(Date date) {
            this.aLW = date;
            return this;
        }

        public a l(Date date) {
            this.aLX = date;
            return this;
        }

        public a ge(String str) {
            this.aLY = str;
            return this;
        }

        public a bW(boolean z) {
            this.aLZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        public e zr() {
            f fVar = (f) super.zr();
            fVar.setFields(this.aLY);
            fVar.setDisabled(this.aLZ);
            if (this.aLX != null) {
                fVar.setHour(this.aLX.getHours());
                fVar.setMinute(this.aLX.getMinutes());
            }
            if (this.aLV != null) {
                fVar.setStartDate(this.aLV);
            }
            if (this.aLW != null) {
                fVar.setEndDate(this.aLW);
            }
            return fVar;
        }
    }
}
