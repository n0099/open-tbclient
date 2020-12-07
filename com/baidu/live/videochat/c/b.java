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
/* loaded from: classes4.dex */
public class b {
    private com.baidu.live.videochat.c.a bLB;
    private a bLC;
    private long bzb = 10;
    private BdAlertDialog bzd;

    /* loaded from: classes4.dex */
    public interface a {
        void Rt();
    }

    public void a(a aVar) {
        this.bLC = aVar;
    }

    public void by(long j) {
        if (j > 0) {
            this.bzb = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0231a interfaceC0231a) {
        if (this.bLB == null) {
            this.bLB = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.bzb * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bLB != null && b.this.bLB.isShowing()) {
                    b.this.bLB.jj(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bLB != null && b.this.bLB.isShowing()) {
                    interfaceC0231a.SQ();
                    b.this.bLB.dismiss();
                }
            }
        };
        this.bLB.a(new a.InterfaceC0231a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
            public void WX() {
                interfaceC0231a.WX();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
            public void WY() {
                b.this.E(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0231a.WY();
                b.this.bLB.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
            public void WZ() {
                b.this.E(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0231a.WZ();
                b.this.bLB.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0231a
            public void SQ() {
            }
        });
        if (!this.bLB.isShowing()) {
            E(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bLB.show();
            if (str != null) {
                this.bLB.jh(str);
            }
        }
        this.bLB.gG(8);
        this.bLB.ji(str2);
        this.bLB.setTitle(activity.getString(a.h.linkmic_invite));
        this.bLB.iK(activity.getString(a.h.linkmic_start));
        this.bLB.jj(String.format(activity.getString(a.h.linkmic_close_refuse), this.bzb + ""));
        this.bLB.fC(0);
        this.bLB.gF(0);
        this.bLB.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void SX() {
        if (this.bLB != null && this.bLB.isShowing()) {
            this.bLB.dismiss();
        }
        this.bLB = null;
    }

    public void c(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bzd == null) {
            this.bzd = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bzd.setAutoNight(false);
        this.bzd.setTitle((String) null);
        this.bzd.setMessageId(i);
        this.bzd.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.E(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bLC != null) {
                    b.this.bLC.Rt();
                }
            }
        });
        this.bzd.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.E(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bzd.setCanceledOnTouchOutside(false);
        this.bzd.setPositiveButtonTextColor(-55461);
        this.bzd.setNagetiveButtonTextColor(-14737633);
        this.bzd.create(bdPageContext).show();
        E(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void SY() {
        if (this.bzd != null && this.bzd.isShowing()) {
            this.bzd.dismiss();
        }
        this.bzd = null;
    }

    public void onDestroy() {
        this.bLB = null;
        this.bzd = null;
        this.bLC = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, "author_liveroom", str3);
        ubcStatisticItem.setContentExt(null, "popup", null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
