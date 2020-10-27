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
import com.baidu.platform.comapi.map.MapController;
/* loaded from: classes4.dex */
public class b {
    private long bCa = 10;
    private com.baidu.live.videochat.c.a bCb;
    private a bCc;
    private BdAlertDialog bCd;

    /* loaded from: classes4.dex */
    public interface a {
        void Pi();
    }

    public void a(a aVar) {
        this.bCc = aVar;
    }

    public void aE(long j) {
        if (j > 0) {
            this.bCa = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0212a interfaceC0212a) {
        if (this.bCb == null) {
            this.bCb = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.bCa * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bCb != null && b.this.bCb.isShowing()) {
                    b.this.bCb.iu(String.format(activity.getString(a.i.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bCb != null && b.this.bCb.isShowing()) {
                    interfaceC0212a.Sz();
                    b.this.bCb.dismiss();
                }
            }
        };
        this.bCb.a(new a.InterfaceC0212a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
            public void Sw() {
                interfaceC0212a.Sw();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
            public void Sx() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0212a.Sx();
                b.this.bCb.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
            public void Sy() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0212a.Sy();
                b.this.bCb.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0212a
            public void Sz() {
            }
        });
        if (!this.bCb.isShowing()) {
            B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bCb.show();
            if (str != null) {
                this.bCb.ir(str);
            }
        }
        this.bCb.fZ(8);
        this.bCb.is(str2);
        this.bCb.setTitle(activity.getString(a.i.linkmic_invite));
        this.bCb.it(activity.getString(a.i.linkmic_start));
        this.bCb.iu(String.format(activity.getString(a.i.linkmic_close_refuse), this.bCa + ""));
        this.bCb.fX(0);
        this.bCb.fY(0);
        this.bCb.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Tf() {
        if (this.bCb != null && this.bCb.isShowing()) {
            this.bCb.dismiss();
        }
        this.bCb = null;
    }

    public void c(BdPageContext bdPageContext, boolean z) {
        int i = a.i.linkmic_cancel_confirm;
        if (z) {
            i = a.i.linkmic_close_confirm;
        }
        if (this.bCd == null) {
            this.bCd = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bCd.setAutoNight(false);
        this.bCd.setTitle((String) null);
        this.bCd.setMessageId(i);
        this.bCd.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_CLOSE_CFM);
                if (b.this.bCc != null) {
                    b.this.bCc.Pi();
                }
            }
        });
        this.bCd.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_CLOSE_CAN);
            }
        });
        this.bCd.setCanceledOnTouchOutside(false);
        this.bCd.setPositiveButtonTextColor(-55461);
        this.bCd.setNagetiveButtonTextColor(-14737633);
        this.bCd.create(bdPageContext).show();
        B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void Tg() {
        if (this.bCd != null && this.bCd.isShowing()) {
            this.bCd.dismiss();
        }
        this.bCd = null;
    }

    public void onDestroy() {
        this.bCb = null;
        this.bCd = null;
        this.bCc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str3);
        ubcStatisticItem.setContentExt(null, MapController.POPUP_LAYER_TAG, null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
