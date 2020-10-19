package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes10.dex */
public class i extends h {
    private int UU;
    private String cYD;
    private boolean cYE;
    private int cYS;
    private Date cYu;
    private Date cYv;
    private BdTimePicker ddF;
    private boolean ddG;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.ddG = false;
    }

    public void setHour(int i) {
        this.cYS = i;
    }

    public int getHour() {
        return this.ddF.getHour();
    }

    public void setMinute(int i) {
        this.UU = i;
    }

    public int getMinute() {
        return this.ddF.getMinute();
    }

    private void aCz() {
        this.ddF = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ddF.setLayoutParams(layoutParams);
        this.ddF.setScrollCycle(true);
        this.ddF.setStartDate(this.cYu);
        this.ddF.setmEndDate(this.cYv);
        this.ddF.setHour(this.cYS);
        this.ddF.setMinute(this.UU);
        this.ddF.aBK();
        this.ddF.setDisabled(this.cYE);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.ddG) {
            getWindow().addFlags(4718592);
        }
        aCz();
        aCI().aw(this.ddF);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.ddF != null) {
            if (this.cYS != this.ddF.getHour()) {
                this.ddF.setHour(this.cYS);
            }
            if (this.UU != this.ddF.getMinute()) {
                this.ddF.setMinute(this.UU);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cYD = str;
    }

    public void setDisabled(boolean z) {
        this.cYE = z;
    }

    public void setStartDate(Date date) {
        this.cYu = date;
    }

    public void setEndDate(Date date) {
        this.cYv = date;
    }

    /* loaded from: classes10.dex */
    public static class a extends h.a {
        public Date ddd;
        public Date dde;
        public Date ddf;
        private String ddg;
        private boolean ddh;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h cs(Context context) {
            return new i(context);
        }

        public a i(Date date) {
            this.ddd = date;
            return this;
        }

        public a j(Date date) {
            this.dde = date;
            return this;
        }

        public a k(Date date) {
            this.ddf = date;
            return this;
        }

        public a rl(String str) {
            this.ddg = str;
            return this;
        }

        public a gc(boolean z) {
            this.ddh = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h aCA() {
            i iVar = (i) super.aCA();
            iVar.setFields(this.ddg);
            iVar.setDisabled(this.ddh);
            if (this.ddf != null) {
                iVar.setHour(this.ddf.getHours());
                iVar.setMinute(this.ddf.getMinutes());
            }
            if (this.ddd != null) {
                iVar.setStartDate(this.ddd);
            }
            if (this.dde != null) {
                iVar.setEndDate(this.dde);
            }
            return iVar;
        }
    }
}
