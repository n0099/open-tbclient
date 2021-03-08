package com.baidu.live.talentshow.components.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CountDownTimer;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.components.a.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.live.talentshow.components.a.a bEj;
    private BdAlertDialog bEk;
    private CountDownTimer bEl;
    private long countdown = 10;

    /* loaded from: classes10.dex */
    public interface a {
        void Qd();

        void Qe();
    }

    public void a(Activity activity, final a.InterfaceC0206a interfaceC0206a) {
        if (this.bEj == null) {
            this.bEj = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bEj.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.Tu();
                    }
                });
            }
        }
        if (this.bEl == null) {
            this.bEl = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bEj != null && b.this.bEj.isShowing()) {
                        b.this.bEj.hR((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bEj != null && b.this.bEj.isShowing()) {
                        interfaceC0206a.RP();
                        b.this.RU();
                    }
                }
            };
        }
        this.bEj.a(new a.InterfaceC0206a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0206a
            public boolean RO() {
                if (interfaceC0206a.RO()) {
                    b.this.RU();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.Tt();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0206a
            public void RP() {
            }
        });
        if (!this.bEj.isShowing()) {
            this.bEj.show();
        }
        this.bEj.hQ(activity.getString(a.h.talent_start));
        this.bEj.ec(0);
        this.bEj.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void RU() {
        if (this.bEj != null && this.bEj.isShowing()) {
            this.bEj.dismiss();
        }
        cancelTimer();
        this.bEj = null;
    }

    public void cancelTimer() {
        if (this.bEl != null) {
            this.bEl.cancel();
        }
    }

    public void startTimer() {
        if (this.bEl != null) {
            this.bEl.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bEk == null) {
            this.bEk = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bEk.setAutoNight(false);
        this.bEk.setTitle((String) null);
        this.bEk.setMessage(str);
        this.bEk.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.RV();
                if (aVar != null) {
                    aVar.Qd();
                }
            }
        });
        this.bEk.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.RV();
                if (aVar != null) {
                    aVar.Qe();
                }
            }
        });
        this.bEk.setCanceledOnTouchOutside(false);
        this.bEk.setPositiveButtonTextColor(-55461);
        this.bEk.setNagetiveButtonTextColor(-14737633);
        this.bEk.create(bdPageContext).show();
    }

    public void RV() {
        if (this.bEk != null && this.bEk.isShowing()) {
            this.bEk.dismiss();
        }
        this.bEk = null;
    }

    public void onDestroy() {
        if (this.bEj != null && this.bEj.isShowing()) {
            this.bEj.dismiss();
        }
        this.bEj = null;
        if (this.bEk != null && this.bEk.isShowing()) {
            this.bEk.dismiss();
        }
        this.bEk = null;
    }
}
