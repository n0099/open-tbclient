package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.h;
import java.util.Date;
/* loaded from: classes11.dex */
public class i extends h {
    private int SU;
    private Date ciU;
    private Date ciV;
    private String cjd;
    private boolean cje;
    private int cjs;
    private BdTimePicker cnn;
    private boolean cno;

    i(Context context) {
        super(context, a.i.NoTitleDialog);
        this.cno = false;
    }

    public void setHour(int i) {
        this.cjs = i;
    }

    public int getHour() {
        return this.cnn.getHour();
    }

    public void setMinute(int i) {
        this.SU = i;
    }

    public int getMinute() {
        return this.cnn.getMinute();
    }

    private void akp() {
        this.cnn = new BdTimePicker(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.cnn.setLayoutParams(layoutParams);
        this.cnn.setScrollCycle(true);
        this.cnn.setStartDate(this.ciU);
        this.cnn.setmEndDate(this.ciV);
        this.cnn.setHour(this.cjs);
        this.cnn.setMinute(this.SU);
        this.cnn.ajL();
        this.cnn.setDisabled(this.cje);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        if (this.cno) {
            getWindow().addFlags(4718592);
        }
        akp();
        aky().ap(this.cnn);
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.c, android.app.Dialog
    public void show() {
        if (this.cnn != null) {
            if (this.cjs != this.cnn.getHour()) {
                this.cnn.setHour(this.cjs);
            }
            if (this.SU != this.cnn.getMinute()) {
                this.cnn.setMinute(this.SU);
            }
        }
        super.show();
    }

    public void setFields(String str) {
        this.cjd = str;
    }

    public void setDisabled(boolean z) {
        this.cje = z;
    }

    public void setStartDate(Date date) {
        this.ciU = date;
    }

    public void setEndDate(Date date) {
        this.ciV = date;
    }

    /* loaded from: classes11.dex */
    public static class a extends h.a {
        public Date cmM;
        public Date cmN;
        public Date cmO;
        private String cmP;
        private boolean cmQ;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        protected h ce(Context context) {
            return new i(context);
        }

        public a g(Date date) {
            this.cmM = date;
            return this;
        }

        public a h(Date date) {
            this.cmN = date;
            return this;
        }

        public a i(Date date) {
            this.cmO = date;
            return this;
        }

        public a lW(String str) {
            this.cmP = str;
            return this;
        }

        public a eH(boolean z) {
            this.cmQ = z;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.h.a
        public h akq() {
            i iVar = (i) super.akq();
            iVar.setFields(this.cmP);
            iVar.setDisabled(this.cmQ);
            if (this.cmO != null) {
                iVar.setHour(this.cmO.getHours());
                iVar.setMinute(this.cmO.getMinutes());
            }
            if (this.cmM != null) {
                iVar.setStartDate(this.cmM);
            }
            if (this.cmN != null) {
                iVar.setEndDate(this.cmN);
            }
            return iVar;
        }
    }
}
