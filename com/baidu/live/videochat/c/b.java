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
    private com.baidu.live.videochat.c.a bIe;
    private a bIf;
    private long bvC = 10;
    private BdAlertDialog bvE;

    /* loaded from: classes4.dex */
    public interface a {
        void PI();
    }

    public void a(a aVar) {
        this.bIf = aVar;
    }

    public void ba(long j) {
        if (j > 0) {
            this.bvC = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0224a interfaceC0224a) {
        if (this.bIe == null) {
            this.bIe = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.bvC * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bIe != null && b.this.bIe.isShowing()) {
                    b.this.bIe.iL(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bIe != null && b.this.bIe.isShowing()) {
                    interfaceC0224a.Rb();
                    b.this.bIe.dismiss();
                }
            }
        };
        this.bIe.a(new a.InterfaceC0224a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
            public void Ve() {
                interfaceC0224a.Ve();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
            public void Vf() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0224a.Vf();
                b.this.bIe.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
            public void Vg() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0224a.Vg();
                b.this.bIe.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0224a
            public void Rb() {
            }
        });
        if (!this.bIe.isShowing()) {
            B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bIe.show();
            if (str != null) {
                this.bIe.iJ(str);
            }
        }
        this.bIe.gl(8);
        this.bIe.iK(str2);
        this.bIe.setTitle(activity.getString(a.h.linkmic_invite));
        this.bIe.im(activity.getString(a.h.linkmic_start));
        this.bIe.iL(String.format(activity.getString(a.h.linkmic_close_refuse), this.bvC + ""));
        this.bIe.fi(0);
        this.bIe.gk(0);
        this.bIe.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Ri() {
        if (this.bIe != null && this.bIe.isShowing()) {
            this.bIe.dismiss();
        }
        this.bIe = null;
    }

    public void c(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.bvE == null) {
            this.bvE = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bvE.setAutoNight(false);
        this.bvE.setTitle((String) null);
        this.bvE.setMessageId(i);
        this.bvE.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bIf != null) {
                    b.this.bIf.PI();
                }
            }
        });
        this.bvE.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.bvE.setCanceledOnTouchOutside(false);
        this.bvE.setPositiveButtonTextColor(-55461);
        this.bvE.setNagetiveButtonTextColor(-14737633);
        this.bvE.create(bdPageContext).show();
        B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void Rj() {
        if (this.bvE != null && this.bvE.isShowing()) {
            this.bvE.dismiss();
        }
        this.bvE = null;
    }

    public void onDestroy() {
        this.bIe = null;
        this.bvE = null;
        this.bIf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str3);
        ubcStatisticItem.setContentExt(null, "popup", null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
