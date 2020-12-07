package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes25.dex */
public class i extends h {
    private int VN;
    private int dsI;
    private Date dsj;
    private Date dsk;
    private String dss;
    private boolean dsu;
    private BdTimePicker dxu;
    private boolean dxv;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.dxv = false;
    }

    public void setHour(int i) {
        this.dsI = i;
    }

    public int getHour() {
        return this.dxu.getHour();
    }

    public void setMinute(int i) {
        this.VN = i;
    }

    public int getMinute() {
        return this.dxu.getMinute();
    }

    private void aJt() {
        this.dxu = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.dxu.setLayoutParams(layoutParams);
        this.dxu.setScrollCycle(true);
        this.dxu.setStartDate(this.dsj);
        this.dxu.setmEndDate(this.dsk);
        this.dxu.setHour(this.dsI);
        this.dxu.setMinute(this.VN);
        this.dxu.aIE();
        this.dxu.setDisabled(this.dsu);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.dxv) {
            getWindow().addFlags(4718592);
        }
        aJt();
        aJC().aD(this.dxu);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.dxu != null) {
            if (this.dsI != this.dxu.getHour()) {
                this.dxu.setHour(this.dsI);
            }
            if (this.VN != this.dxu.getMinute()) {
                this.dxu.setMinute(this.VN);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.dss = str;
    }

    public void setDisabled(boolean z) {
        this.dsu = z;
    }

    public void setStartDate(Date date) {
        this.dsj = date;
    }

    public void setEndDate(Date date) {
        this.dsk = date;
    }

    /* loaded from: classes25.dex */
    public static class a extends h.a {
        public Date dwT;
        public Date dwU;
        public Date dwV;
        private String dwW;
        private boolean dwX;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cY(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.dwT = date;
            return this;
        }

        public a j(Date date) {
            this.dwU = date;
            return this;
        }

        public a k(Date date) {
            this.dwV = date;
            return this;
        }

        public a su(String str) {
            this.dwW = str;
            return this;
        }

        public a gQ(boolean z) {
            this.dwX = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aJu() {
            i iVar = (i) super.aJu();
            iVar.setFields(this.dwW);
            iVar.setDisabled(this.dwX);
            if (this.dwV != null) {
                iVar.setHour(this.dwV.getHours());
                iVar.setMinute(this.dwV.getMinutes());
            }
            if (this.dwT != null) {
                iVar.setStartDate(this.dwT);
            }
            if (this.dwU != null) {
                iVar.setEndDate(this.dwU);
            }
            return iVar;
        }
    }
}
