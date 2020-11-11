package com.baidu.live.talentshow.components.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CountDownTimer;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.components.a.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes4.dex */
public class b {
    private long bvC = 10;
    private com.baidu.live.talentshow.components.a.a bvD;
    private BdAlertDialog bvE;
    private CountDownTimer bvF;

    /* loaded from: classes4.dex */
    public interface a {
        void PI();

        void PJ();
    }

    public void a(Activity activity, final a.InterfaceC0201a interfaceC0201a) {
        if (this.bvD == null) {
            this.bvD = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bvD.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.SJ();
                    }
                });
            }
        }
        if (this.bvF == null) {
            this.bvF = new CountDownTimer(this.bvC * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bvD != null && b.this.bvD.isShowing()) {
                        b.this.bvD.in((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bvD != null && b.this.bvD.isShowing()) {
                        interfaceC0201a.Rb();
                        b.this.Ri();
                    }
                }
            };
        }
        this.bvD.a(new a.InterfaceC0201a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0201a
            public boolean Ra() {
                if (interfaceC0201a.Ra()) {
                    b.this.Ri();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.SI();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0201a
            public void Rb() {
            }
        });
        if (!this.bvD.isShowing()) {
            this.bvD.show();
        }
        this.bvD.im(activity.getString(a.h.talent_start));
        this.bvD.fi(0);
        this.bvD.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void Ri() {
        if (this.bvD != null && this.bvD.isShowing()) {
            this.bvD.dismiss();
        }
        cancelTimer();
        this.bvD = null;
    }

    public void cancelTimer() {
        if (this.bvF != null) {
            this.bvF.cancel();
        }
    }

    public void startTimer() {
        if (this.bvF != null) {
            this.bvF.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bvE == null) {
            this.bvE = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bvE.setAutoNight(false);
        this.bvE.setTitle((String) null);
        this.bvE.setMessage(str);
        this.bvE.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Rj();
                if (aVar != null) {
                    aVar.PI();
                }
            }
        });
        this.bvE.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Rj();
                if (aVar != null) {
                    aVar.PJ();
                }
            }
        });
        this.bvE.setCanceledOnTouchOutside(false);
        this.bvE.setPositiveButtonTextColor(-55461);
        this.bvE.setNagetiveButtonTextColor(-14737633);
        this.bvE.create(bdPageContext).show();
    }

    public void Rj() {
        if (this.bvE != null && this.bvE.isShowing()) {
            this.bvE.dismiss();
        }
        this.bvE = null;
    }

    public void onDestroy() {
        if (this.bvD != null && this.bvD.isShowing()) {
            this.bvD.dismiss();
        }
        this.bvD = null;
        if (this.bvE != null && this.bvE.isShowing()) {
            this.bvE.dismiss();
        }
        this.bvE = null;
    }
}
