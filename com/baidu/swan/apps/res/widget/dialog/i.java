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
    private int UW;
    private int dlH;
    private Date dlj;
    private Date dlk;
    private String dls;
    private boolean dlt;
    private BdTimePicker dqt;
    private boolean dqu;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dqu = false;
    }

    public void setHour(int i) {
        this.dlH = i;
    }

    public int getHour() {
        return this.dqt.getHour();
    }

    public void setMinute(int i) {
        this.UW = i;
    }

    public int getMinute() {
        return this.dqt.getMinute();
    }

    private void aGl() {
        this.dqt = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dqt.setLayoutParams(layoutParams);
        this.dqt.setScrollCycle(true);
        this.dqt.setStartDate(this.dlj);
        this.dqt.setmEndDate(this.dlk);
        this.dqt.setHour(this.dlH);
        this.dqt.setMinute(this.UW);
        this.dqt.aFw();
        this.dqt.setDisabled(this.dlt);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dqu) {
            getWindow().addFlags(4718592);
        }
        aGl();
        aGu().aB(this.dqt);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dqt != null) {
            if (this.dlH != this.dqt.getHour()) {
                this.dqt.setHour(this.dlH);
            }
            if (this.UW != this.dqt.getMinute()) {
                this.dqt.setMinute(this.UW);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dls = str;
    }

    public void setDisabled(boolean z) {
        this.dlt = z;
    }

    public void setStartDate(Date date) {
        this.dlj = date;
    }

    public void setEndDate(Date date) {
        this.dlk = date;
    }

    /* loaded from: classes7.dex */
    public static class a extends h.a {
        public Date dpS;
        public Date dpT;
        public Date dpU;
        private String dpV;
        private boolean dpW;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dpS = date;
            return this;
        }

        public a j(Date date) {
            this.dpT = date;
            return this;
        }

        public a k(Date date) {
            this.dpU = date;
            return this;
        }

        public a rM(String str) {
            this.dpV = str;
            return this;
        }

        public a gB(boolean z) {
            this.dpW = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aGm() {
            i iVar = (i) super.aGm();
            iVar.setFields(this.dpV);
            iVar.setDisabled(this.dpW);
            if (this.dpU != null) {
                iVar.setHour(this.dpU.getHours());
                iVar.setMinute(this.dpU.getMinutes());
            }
            if (this.dpS != null) {
                iVar.setStartDate(this.dpS);
            }
            if (this.dpT != null) {
                iVar.setEndDate(this.dpT);
            }
            return iVar;
        }
    }
}
