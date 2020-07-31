package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes7.dex */
public class i extends h {
    private int TF;
    private Date cBZ;
    private Date cCa;
    private String cCi;
    private boolean cCj;
    private int cCx;
    private BdTimePicker cGw;
    private boolean cGx;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cGx = false;
    }

    public void setHour(int i) {
        this.cCx = i;
    }

    public int getHour() {
        return this.cGw.getHour();
    }

    public void setMinute(int i) {
        this.TF = i;
    }

    public int getMinute() {
        return this.cGw.getMinute();
    }

    private void aqV() {
        this.cGw = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cGw.setLayoutParams(layoutParams);
        this.cGw.setScrollCycle(true);
        this.cGw.setStartDate(this.cBZ);
        this.cGw.setmEndDate(this.cCa);
        this.cGw.setHour(this.cCx);
        this.cGw.setMinute(this.TF);
        this.cGw.aqo();
        this.cGw.setDisabled(this.cCj);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cGx) {
            getWindow().addFlags(4718592);
        }
        aqV();
        are().as(this.cGw);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cGw != null) {
            if (this.cCx != this.cGw.getHour()) {
                this.cGw.setHour(this.cCx);
            }
            if (this.TF != this.cGw.getMinute()) {
                this.cGw.setMinute(this.TF);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cCi = str;
    }

    public void setDisabled(boolean z) {
        this.cCj = z;
    }

    public void setStartDate(Date date) {
        this.cBZ = date;
    }

    public void setEndDate(Date date) {
        this.cCa = date;
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public Date cFV;
        public Date cFW;
        public Date cFX;
        private String cFY;
        private boolean cFZ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ch(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.cFV = date;
            return this;
        }

        public a j(Date date) {
            this.cFW = date;
            return this;
        }

        public a k(Date date) {
            this.cFX = date;
            return this;
        }

        public a oh(String str) {
            this.cFY = str;
            return this;
        }

        public a fo(boolean z) {
            this.cFZ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aqW() {
            i iVar = (i) super.aqW();
            iVar.setFields(this.cFY);
            iVar.setDisabled(this.cFZ);
            if (this.cFX != null) {
                iVar.setHour(this.cFX.getHours());
                iVar.setMinute(this.cFX.getMinutes());
            }
            if (this.cFV != null) {
                iVar.setStartDate(this.cFV);
            }
            if (this.cFW != null) {
                iVar.setEndDate(this.cFW);
            }
            return iVar;
        }
    }
}
