package com.baidu.live.videochat.c;

import android.app.Activity;
import android.os.CountDownTimer;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.videochat.c.a;
/* loaded from: classes10.dex */
public class b {
    private com.baidu.live.videochat.c.a bLC;
    private a bLD;
    private BdAlertDialog bze;
    private long countdown = 10;

    /* loaded from: classes10.dex */
    public interface a {
        void OB();
    }

    public void a(a aVar) {
        this.bLD = aVar;
    }

    public void by(long j) {
        if (j > 0) {
            this.countdown = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0220a interfaceC0220a) {
        if (this.bLC == null) {
            this.bLC = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bLC != null && b.this.bLC.isShowing()) {
                    b.this.bLC.hO(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bLC != null && b.this.bLC.isShowing()) {
                    interfaceC0220a.Qc();
                    b.this.bLC.dismiss();
                }
            }
        };
        this.bLC.a(new a.InterfaceC0220a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
            public void Ul() {
                interfaceC0220a.Ul();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
            public void Um() {
                b.this.G(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0220a.Um();
                b.this.bLC.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
            public void Un() {
                b.this.G(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0220a.Un();
                b.this.bLC.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0220a
            public void Qc() {
            }
        });
        if (!this.bLC.isShowing()) {
            G(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bLC.show();
            if (str != null) {
                this.bLC.hM(str);
            }
        }
        this.bLC.fa(8);
        this.bLC.hN(str2);
        this.bLC.setTitle(activity.getString(a.h.linkmic_invite));
        this.bLC.ho(activity.getString(a.h.linkmic_start));
        this.bLC.hO(String.format(activity.getString(a.h.linkmic_close_refuse), this.countdown + ""));
        this.bLC.dX(0);
        this.bLC.eZ(0);
        this.bLC.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Qh() {
        if (this.bLC != null && this.bLC.isShowing()) {
            this.bLC.dismiss();
        }
        this.bLC = null;
    }

    public void a(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bze == null) {
            this.bze = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bze.setAutoNight(false);
        this.bze.setTitle((String) null);
        this.bze.setMessageId(i);
        this.bze.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.G(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bLD != null) {
                    b.this.bLD.OB();
                }
            }
        });
        this.bze.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.G(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bze.setCanceledOnTouchOutside(false);
        this.bze.setPositiveButtonTextColor(-55461);
        this.bze.setNagetiveButtonTextColor(-14737633);
        this.bze.create(bdPageContext).show();
        G(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void Qi() {
        if (this.bze != null && this.bze.isShowing()) {
            this.bze.dismiss();
        }
        this.bze = null;
    }

    public void onDestroy() {
        this.bLC = null;
        this.bze = null;
        this.bLD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, "author_liveroom", str3);
        ubcStatisticItem.setContentExt(null, UbcStatConstant.SubPage.POPUP, null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
