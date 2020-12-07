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
    private long bzb = 10;
    private com.baidu.live.talentshow.components.a.a bzc;
    private BdAlertDialog bzd;
    private CountDownTimer bze;

    /* loaded from: classes4.dex */
    public interface a {
        void Rt();

        void Ru();
    }

    public void a(Activity activity, final a.InterfaceC0209a interfaceC0209a) {
        if (this.bzc == null) {
            this.bzc = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.bzc.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.Uy();
                    }
                });
            }
        }
        if (this.bze == null) {
            this.bze = new CountDownTimer(this.bzb * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.bzc != null && b.this.bzc.isShowing()) {
                        b.this.bzc.iL((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.bzc != null && b.this.bzc.isShowing()) {
                        interfaceC0209a.SQ();
                        b.this.SX();
                    }
                }
            };
        }
        this.bzc.a(new a.InterfaceC0209a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0209a
            public boolean SP() {
                if (interfaceC0209a.SP()) {
                    b.this.SX();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.Ux();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0209a
            public void SQ() {
            }
        });
        if (!this.bzc.isShowing()) {
            this.bzc.show();
        }
        this.bzc.iK(activity.getString(a.h.talent_start));
        this.bzc.fC(0);
        this.bzc.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void SX() {
        if (this.bzc != null && this.bzc.isShowing()) {
            this.bzc.dismiss();
        }
        cancelTimer();
        this.bzc = null;
    }

    public void cancelTimer() {
        if (this.bze != null) {
            this.bze.cancel();
        }
    }

    public void startTimer() {
        if (this.bze != null) {
            this.bze.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.bzd == null) {
            this.bzd = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bzd.setAutoNight(false);
        this.bzd.setTitle((String) null);
        this.bzd.setMessage(str);
        this.bzd.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.SY();
                if (aVar != null) {
                    aVar.Rt();
                }
            }
        });
        this.bzd.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.SY();
                if (aVar != null) {
                    aVar.Ru();
                }
            }
        });
        this.bzd.setCanceledOnTouchOutside(false);
        this.bzd.setPositiveButtonTextColor(-55461);
        this.bzd.setNagetiveButtonTextColor(-14737633);
        this.bzd.create(bdPageContext).show();
    }

    public void SY() {
        if (this.bzd != null && this.bzd.isShowing()) {
            this.bzd.dismiss();
        }
        this.bzd = null;
    }

    public void onDestroy() {
        if (this.bzc != null && this.bzc.isShowing()) {
            this.bzc.dismiss();
        }
        this.bzc = null;
        if (this.bzd != null && this.bzd.isShowing()) {
            this.bzd.dismiss();
        }
        this.bzd = null;
    }
}
