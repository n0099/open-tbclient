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
    private BdAlertDialog bEk;
    private com.baidu.live.videochat.c.a bQM;
    private a bQN;
    private long countdown = 10;

    /* loaded from: classes10.dex */
    public interface a {
        void Qd();
    }

    public void a(a aVar) {
        this.bQN = aVar;
    }

    public void bC(long j) {
        if (j > 0) {
            this.countdown = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0228a interfaceC0228a) {
        if (this.bQM == null) {
            this.bQM = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bQM != null && b.this.bQM.isShowing()) {
                    b.this.bQM.ip(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bQM != null && b.this.bQM.isShowing()) {
                    interfaceC0228a.RP();
                    b.this.bQM.dismiss();
                }
            }
        };
        this.bQM.a(new a.InterfaceC0228a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
            public void VX() {
                interfaceC0228a.VX();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
            public void VY() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0228a.VY();
                b.this.bQM.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
            public void VZ() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0228a.VZ();
                b.this.bQM.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0228a
            public void RP() {
            }
        });
        if (!this.bQM.isShowing()) {
            H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bQM.show();
            if (str != null) {
                this.bQM.in(str);
            }
        }
        this.bQM.ff(8);
        this.bQM.io(str2);
        this.bQM.setTitle(activity.getString(a.h.linkmic_invite));
        this.bQM.hQ(activity.getString(a.h.linkmic_start));
        this.bQM.ip(String.format(activity.getString(a.h.linkmic_close_refuse), this.countdown + ""));
        this.bQM.ec(0);
        this.bQM.fe(0);
        this.bQM.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void RU() {
        if (this.bQM != null && this.bQM.isShowing()) {
            this.bQM.dismiss();
        }
        this.bQM = null;
    }

    public void a(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bEk == null) {
            this.bEk = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bEk.setAutoNight(false);
        this.bEk.setTitle((String) null);
        this.bEk.setMessageId(i);
        this.bEk.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bQN != null) {
                    b.this.bQN.Qd();
                }
            }
        });
        this.bEk.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bEk.setCanceledOnTouchOutside(false);
        this.bEk.setPositiveButtonTextColor(-55461);
        this.bEk.setNagetiveButtonTextColor(-14737633);
        this.bEk.create(bdPageContext).show();
        H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void RV() {
        if (this.bEk != null && this.bEk.isShowing()) {
            this.bEk.dismiss();
        }
        this.bEk = null;
    }

    public void onDestroy() {
        this.bQM = null;
        this.bEk = null;
        this.bQN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, "author_liveroom", str3);
        ubcStatisticItem.setContentExt(null, UbcStatConstant.SubPage.POPUP, null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
