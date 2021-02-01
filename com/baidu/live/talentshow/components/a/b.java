package com.baidu.live.talentshow.components.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CountDownTimer;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.components.a.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.live.talentshow.components.a.a bCJ;
    private BdAlertDialog bCK;
    private CountDownTimer bCL;
    private long countdown = 10;

    /* loaded from: classes11.dex */
    public interface a {
        void Qa();

        void Qb();
    }

    public void a(Activity activity, final a.InterfaceC0200a interfaceC0200a) {
        if (this.bCJ == null) {
            this.bCJ = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bCJ.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.Tr();
                    }
                });
            }
        }
        if (this.bCL == null) {
            this.bCL = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bCJ != null && b.this.bCJ.isShowing()) {
                        b.this.bCJ.hL((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bCJ != null && b.this.bCJ.isShowing()) {
                        interfaceC0200a.RM();
                        b.this.RR();
                    }
                }
            };
        }
        this.bCJ.a(new a.InterfaceC0200a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0200a
            public boolean RL() {
                if (interfaceC0200a.RL()) {
                    b.this.RR();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.Tq();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0200a
            public void RM() {
            }
        });
        if (!this.bCJ.isShowing()) {
            this.bCJ.show();
        }
        this.bCJ.hK(activity.getString(a.h.talent_start));
        this.bCJ.eb(0);
        this.bCJ.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void RR() {
        if (this.bCJ != null && this.bCJ.isShowing()) {
            this.bCJ.dismiss();
        }
        cancelTimer();
        this.bCJ = null;
    }

    public void cancelTimer() {
        if (this.bCL != null) {
            this.bCL.cancel();
        }
    }

    public void startTimer() {
        if (this.bCL != null) {
            this.bCL.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bCK == null) {
            this.bCK = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bCK.setAutoNight(false);
        this.bCK.setTitle((String) null);
        this.bCK.setMessage(str);
        this.bCK.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.RS();
                if (aVar != null) {
                    aVar.Qa();
                }
            }
        });
        this.bCK.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.RS();
                if (aVar != null) {
                    aVar.Qb();
                }
            }
        });
        this.bCK.setCanceledOnTouchOutside(false);
        this.bCK.setPositiveButtonTextColor(-55461);
        this.bCK.setNagetiveButtonTextColor(-14737633);
        this.bCK.create(bdPageContext).show();
    }

    public void RS() {
        if (this.bCK != null && this.bCK.isShowing()) {
            this.bCK.dismiss();
        }
        this.bCK = null;
    }

    public void onDestroy() {
        if (this.bCJ != null && this.bCJ.isShowing()) {
            this.bCJ.dismiss();
        }
        this.bCJ = null;
        if (this.bCK != null && this.bCK.isShowing()) {
            this.bCK.dismiss();
        }
        this.bCK = null;
    }
}
