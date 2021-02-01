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
    private BdAlertDialog bCK;
    private com.baidu.live.videochat.c.a bPm;
    private a bPn;
    private long countdown = 10;

    /* loaded from: classes11.dex */
    public interface a {
        void Qa();
    }

    public void a(a aVar) {
        this.bPn = aVar;
    }

    public void bC(long j) {
        if (j > 0) {
            this.countdown = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0222a interfaceC0222a) {
        if (this.bPm == null) {
            this.bPm = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.countdown * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bPm != null && b.this.bPm.isShowing()) {
                    b.this.bPm.ij(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bPm != null && b.this.bPm.isShowing()) {
                    interfaceC0222a.RM();
                    b.this.bPm.dismiss();
                }
            }
        };
        this.bPm.a(new a.InterfaceC0222a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void VU() {
                interfaceC0222a.VU();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void VV() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0222a.VV();
                b.this.bPm.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void VW() {
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0222a.VW();
                b.this.bPm.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void RM() {
            }
        });
        if (!this.bPm.isShowing()) {
            H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bPm.show();
            if (str != null) {
                this.bPm.ih(str);
            }
        }
        this.bPm.fe(8);
        this.bPm.ii(str2);
        this.bPm.setTitle(activity.getString(a.h.linkmic_invite));
        this.bPm.hK(activity.getString(a.h.linkmic_start));
        this.bPm.ij(String.format(activity.getString(a.h.linkmic_close_refuse), this.countdown + ""));
        this.bPm.eb(0);
        this.bPm.fd(0);
        this.bPm.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void RR() {
        if (this.bPm != null && this.bPm.isShowing()) {
            this.bPm.dismiss();
        }
        this.bPm = null;
    }

    public void a(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bCK == null) {
            this.bCK = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bCK.setAutoNight(false);
        this.bCK.setTitle((String) null);
        this.bCK.setMessageId(i);
        this.bCK.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bPn != null) {
                    b.this.bPn.Qa();
                }
            }
        });
        this.bCK.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.H(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bCK.setCanceledOnTouchOutside(false);
        this.bCK.setPositiveButtonTextColor(-55461);
        this.bCK.setNagetiveButtonTextColor(-14737633);
        this.bCK.create(bdPageContext).show();
        H(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void RS() {
        if (this.bCK != null && this.bCK.isShowing()) {
            this.bCK.dismiss();
        }
        this.bCK = null;
    }

    public void onDestroy() {
        this.bPm = null;
        this.bCK = null;
        this.bPn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, "author_liveroom", str3);
        ubcStatisticItem.setContentExt(null, UbcStatConstant.SubPage.POPUP, null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
