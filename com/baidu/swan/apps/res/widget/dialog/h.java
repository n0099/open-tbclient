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
    private int KC;
    private String aIG;
    private boolean aIH;
    private int aIY;
    private Date aIx;
    private Date aIy;
    private BdTimePicker aPG;
    private boolean aPH;

    h(Context context) {
        super(context, a.i.NoTitleDialog);
        this.aPH = false;
    }

    public void setHour(int i) {
        this.aIY = i;
    }

    public int getHour() {
        return this.aPG.getHour();
    }

    public void setMinute(int i) {
        this.KC = i;
    }

    public int getMinute() {
        return this.aPG.getMinute();
    }

    private void Lu() {
        this.aPG = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.aPG.setLayoutParams(layoutParams);
        this.aPG.setScrollCycle(true);
        this.aPG.setStartDate(this.aIx);
        this.aPG.setmEndDate(this.aIy);
        this.aPG.setHour(this.aIY);
        this.aPG.setMinute(this.KC);
        this.aPG.JS();
        this.aPG.setDisabled(this.aIH);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.aPH) {
            getWindow().addFlags(4718592);
        }
        Lu();
        Lw().af(this.aPG);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        TextView Ls = Lw().Ls();
        if (Ls != null) {
            Ls.setBackgroundResource(a.e.aiapp_alertdialog_button_day_bg_all_selector);
        }
        if (this.aPG != null) {
            if (this.aIY != this.aPG.getHour()) {
                this.aPG.setHour(this.aIY);
            }
            if (this.KC != this.aPG.getMinute()) {
                this.aPG.setMinute(this.KC);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.aIG = str;
    }

    public void setDisabled(boolean z) {
        this.aIH = z;
    }

    public void setStartDate(Date date) {
        this.aIx = date;
    }

    public void setEndDate(Date date) {
        this.aIy = date;
    }

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public Date aPa;
        public Date aPb;
        public Date aPc;
        private String aPd;
        private boolean aPe;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new h(context);
        }

        public a j(Date date) {
            this.aPa = date;
            return this;
        }

        public a k(Date date) {
            this.aPb = date;
            return this;
        }

        public a l(Date date) {
            this.aPc = date;
            return this;
        }

        public a gF(String str) {
            this.aPd = str;
            return this;
        }

        public a ck(boolean z) {
            this.aPe = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g Bb() {
            h hVar = (h) super.Bb();
            hVar.setFields(this.aPd);
            hVar.setDisabled(this.aPe);
            if (this.aPc != null) {
                hVar.setHour(this.aPc.getHours());
                hVar.setMinute(this.aPc.getMinutes());
            }
            if (this.aPa != null) {
                hVar.setStartDate(this.aPa);
            }
            if (this.aPb != null) {
                hVar.setEndDate(this.aPb);
            }
            return hVar;
        }
    }
}
