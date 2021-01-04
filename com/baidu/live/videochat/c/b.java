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
/* loaded from: classes11.dex */
public class b {
    private BdAlertDialog bDQ;
    private com.baidu.live.videochat.c.a bQo;
    private a bQp;
    private long countdown = 10;

    /* loaded from: classes11.dex */
    public interface a {
        void Sw();
    }

    public void a(a aVar) {
        this.bQp = aVar;
    }

    public void by(long j) {
        if (j > 0) {
            this.countdown = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0229a interfaceC0229a) {
        if (this.bQo == null) {
            this.bQo = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bQo != null && b.this.bQo.isShowing()) {
                    b.this.bQo.iZ(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bQo != null && b.this.bQo.isShowing()) {
                    interfaceC0229a.TX();
                    b.this.bQo.dismiss();
                }
            }
        };
        this.bQo.a(new a.InterfaceC0229a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
            public void Yd() {
                interfaceC0229a.Yd();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
            public void Ye() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0229a.Ye();
                b.this.bQo.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
            public void Yf() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0229a.Yf();
                b.this.bQo.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0229a
            public void TX() {
            }
        });
        if (!this.bQo.isShowing()) {
            H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bQo.show();
            if (str != null) {
                this.bQo.iX(str);
            }
        }
        this.bQo.gH(8);
        this.bQo.iY(str2);
        this.bQo.setTitle(activity.getString(a.h.linkmic_invite));
        this.bQo.iz(activity.getString(a.h.linkmic_start));
        this.bQo.iZ(String.format(activity.getString(a.h.linkmic_close_refuse), this.countdown + ""));
        this.bQo.fD(0);
        this.bQo.gG(0);
        this.bQo.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Uc() {
        if (this.bQo != null && this.bQo.isShowing()) {
            this.bQo.dismiss();
        }
        this.bQo = null;
    }

    public void a(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bDQ == null) {
            this.bDQ = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bDQ.setAutoNight(false);
        this.bDQ.setTitle((String) null);
        this.bDQ.setMessageId(i);
        this.bDQ.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bQp != null) {
                    b.this.bQp.Sw();
                }
            }
        });
        this.bDQ.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bDQ.setCanceledOnTouchOutside(false);
        this.bDQ.setPositiveButtonTextColor(-55461);
        this.bDQ.setNagetiveButtonTextColor(-14737633);
        this.bDQ.create(bdPageContext).show();
        H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void Ud() {
        if (this.bDQ != null && this.bDQ.isShowing()) {
            this.bDQ.dismiss();
        }
        this.bDQ = null;
    }

    public void onDestroy() {
        this.bQo = null;
        this.bDQ = null;
        this.bQp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, "author_liveroom", str3);
        ubcStatisticItem.setContentExt(null, "popup", null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
