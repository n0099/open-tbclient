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
    private com.baidu.live.talentshow.components.a.a bDP;
    private BdAlertDialog bDQ;
    private CountDownTimer bDR;
    private long countdown = 10;

    /* loaded from: classes11.dex */
    public interface a {
        void Sw();

        void Sx();
    }

    public void a(Activity activity, final a.InterfaceC0207a interfaceC0207a) {
        if (this.bDP == null) {
            this.bDP = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bDP.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.VD();
                    }
                });
            }
        }
        if (this.bDR == null) {
            this.bDR = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bDP != null && b.this.bDP.isShowing()) {
                        b.this.bDP.iA((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bDP != null && b.this.bDP.isShowing()) {
                        interfaceC0207a.TX();
                        b.this.Uc();
                    }
                }
            };
        }
        this.bDP.a(new a.InterfaceC0207a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0207a
            public boolean TW() {
                if (interfaceC0207a.TW()) {
                    b.this.Uc();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.VC();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0207a
            public void TX() {
            }
        });
        if (!this.bDP.isShowing()) {
            this.bDP.show();
        }
        this.bDP.iz(activity.getString(a.h.talent_start));
        this.bDP.fD(0);
        this.bDP.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void Uc() {
        if (this.bDP != null && this.bDP.isShowing()) {
            this.bDP.dismiss();
        }
        cancelTimer();
        this.bDP = null;
    }

    public void cancelTimer() {
        if (this.bDR != null) {
            this.bDR.cancel();
        }
    }

    public void startTimer() {
        if (this.bDR != null) {
            this.bDR.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bDQ == null) {
            this.bDQ = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bDQ.setAutoNight(false);
        this.bDQ.setTitle((String) null);
        this.bDQ.setMessage(str);
        this.bDQ.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Ud();
                if (aVar != null) {
                    aVar.Sw();
                }
            }
        });
        this.bDQ.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Ud();
                if (aVar != null) {
                    aVar.Sx();
                }
            }
        });
        this.bDQ.setCanceledOnTouchOutside(false);
        this.bDQ.setPositiveButtonTextColor(-55461);
        this.bDQ.setNagetiveButtonTextColor(-14737633);
        this.bDQ.create(bdPageContext).show();
    }

    public void Ud() {
        if (this.bDQ != null && this.bDQ.isShowing()) {
            this.bDQ.dismiss();
        }
        this.bDQ = null;
    }

    public void onDestroy() {
        if (this.bDP != null && this.bDP.isShowing()) {
            this.bDP.dismiss();
        }
        this.bDP = null;
        if (this.bDQ != null && this.bDQ.isShowing()) {
            this.bDQ.dismiss();
        }
        this.bDQ = null;
    }
}
