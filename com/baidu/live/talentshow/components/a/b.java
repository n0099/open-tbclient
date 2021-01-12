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
    private com.baidu.live.talentshow.components.a.a bzd;
    private BdAlertDialog bze;
    private CountDownTimer bzf;
    private long countdown = 10;

    /* loaded from: classes10.dex */
    public interface a {
        void OB();

        void OC();
    }

    public void a(Activity activity, final a.InterfaceC0198a interfaceC0198a) {
        if (this.bzd == null) {
            this.bzd = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bzd.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.RK();
                    }
                });
            }
        }
        if (this.bzf == null) {
            this.bzf = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bzd != null && b.this.bzd.isShowing()) {
                        b.this.bzd.hp((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bzd != null && b.this.bzd.isShowing()) {
                        interfaceC0198a.Qc();
                        b.this.Qh();
                    }
                }
            };
        }
        this.bzd.a(new a.InterfaceC0198a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0198a
            public boolean Qb() {
                if (interfaceC0198a.Qb()) {
                    b.this.Qh();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.RJ();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0198a
            public void Qc() {
            }
        });
        if (!this.bzd.isShowing()) {
            this.bzd.show();
        }
        this.bzd.ho(activity.getString(a.h.talent_start));
        this.bzd.dX(0);
        this.bzd.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void Qh() {
        if (this.bzd != null && this.bzd.isShowing()) {
            this.bzd.dismiss();
        }
        cancelTimer();
        this.bzd = null;
    }

    public void cancelTimer() {
        if (this.bzf != null) {
            this.bzf.cancel();
        }
    }

    public void startTimer() {
        if (this.bzf != null) {
            this.bzf.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bze == null) {
            this.bze = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bze.setAutoNight(false);
        this.bze.setTitle((String) null);
        this.bze.setMessage(str);
        this.bze.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Qi();
                if (aVar != null) {
                    aVar.OB();
                }
            }
        });
        this.bze.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.Qi();
                if (aVar != null) {
                    aVar.OC();
                }
            }
        });
        this.bze.setCanceledOnTouchOutside(false);
        this.bze.setPositiveButtonTextColor(-55461);
        this.bze.setNagetiveButtonTextColor(-14737633);
        this.bze.create(bdPageContext).show();
    }

    public void Qi() {
        if (this.bze != null && this.bze.isShowing()) {
            this.bze.dismiss();
        }
        this.bze = null;
    }

    public void onDestroy() {
        if (this.bzd != null && this.bzd.isShowing()) {
            this.bzd.dismiss();
        }
        this.bzd = null;
        if (this.bze != null && this.bze.isShowing()) {
            this.bze.dismiss();
        }
        this.bze = null;
    }
}
