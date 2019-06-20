package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.util.Date;
/* loaded from: classes2.dex */
public class h extends g {
    private int Kq;
    private String aHA;
    private boolean aHB;
    private int aHS;
    private Date aHr;
    private Date aHs;
    private BdTimePicker aOy;
    private boolean aOz;

    h(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aOz = false;
    }

    public void setHour(int i) {
        this.aHS = i;
    }

    public int getHour() {
        return this.aOy.getHour();
    }

    public void setMinute(int i) {
        this.Kq = i;
    }

    public int getMinute() {
        return this.aOy.getMinute();
    }

    private void KD() {
        this.aOy = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aOy.setLayoutParams(layoutParams);
        this.aOy.setScrollCycle(true);
        this.aOy.setStartDate(this.aHr);
        this.aOy.setmEndDate(this.aHs);
        this.aOy.setHour(this.aHS);
        this.aOy.setMinute(this.Kq);
        this.aOy.Jb();
        this.aOy.setDisabled(this.aHB);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aOz) {
            getWindow().addFlags(4718592);
        }
        KD();
        KF().ad(this.aOy);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView KB = KF().KB();
        if (KB != null) {
            KB.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aOy != null) {
            if (this.aHS != this.aOy.getHour()) {
                this.aOy.setHour(this.aHS);
            }
            if (this.Kq != this.aOy.getMinute()) {
                this.aOy.setMinute(this.Kq);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aHA = str;
    }

    public void setDisabled(boolean z) {
        this.aHB = z;
    }

    public void setStartDate(Date date) {
        this.aHr = date;
    }

    public void setEndDate(Date date) {
        this.aHs = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date aNS;
        public Date aNT;
        public Date aNU;
        private String aNV;
        private boolean aNW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new h(context);
        }

        public a j(Date date) {
            this.aNS = date;
            return this;
        }

        public a k(Date date) {
            this.aNT = date;
            return this;
        }

        public a l(Date date) {
            this.aNU = date;
            return this;
        }

        public a gx(String str) {
            this.aNV = str;
            return this;
        }

        public a ch(boolean z) {
            this.aNW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            h hVar = (h) super.Aq();
            hVar.setFields(this.aNV);
            hVar.setDisabled(this.aNW);
            if (this.aNU != null) {
                hVar.setHour(this.aNU.getHours());
                hVar.setMinute(this.aNU.getMinutes());
            }
            if (this.aNS != null) {
                hVar.setStartDate(this.aNS);
            }
            if (this.aNT != null) {
                hVar.setEndDate(this.aNT);
            }
            return hVar;
        }
    }
}
