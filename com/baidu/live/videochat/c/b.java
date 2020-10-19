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
    private long bze = 10;
    private com.baidu.live.videochat.c.a bzf;
    private a bzg;
    private BdAlertDialog bzh;

    /* loaded from: classes4.dex */
    public interface a {
        void OK();
    }

    public void a(a aVar) {
        this.bzg = aVar;
    }

    public void aC(long j) {
        if (j > 0) {
            this.bze = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0206a interfaceC0206a) {
        if (this.bzf == null) {
            this.bzf = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.bze * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bzf != null && b.this.bzf.isShowing()) {
                    b.this.bzf.ij(String.format(activity.getString(a.i.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bzf != null && b.this.bzf.isShowing()) {
                    interfaceC0206a.Rz();
                    b.this.bzf.dismiss();
                }
            }
        };
        this.bzf.a(new a.InterfaceC0206a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
            public void Rw() {
                interfaceC0206a.Rw();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
            public void Rx() {
                b.this.t(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0206a.Rx();
                b.this.bzf.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
            public void Ry() {
                b.this.t(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0206a.Ry();
                b.this.bzf.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0206a
            public void Rz() {
            }
        });
        if (!this.bzf.isShowing()) {
            t(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bzf.show();
            if (str != null) {
                this.bzf.ig(str);
            }
        }
        this.bzf.fU(8);
        this.bzf.ih(str2);
        this.bzf.setTitle(activity.getString(a.i.linkmic_invite));
        this.bzf.ii(activity.getString(a.i.linkmic_start));
        this.bzf.ij(String.format(activity.getString(a.i.linkmic_close_refuse), this.bze + ""));
        this.bzf.fS(0);
        this.bzf.fT(0);
        this.bzf.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Sf() {
        if (this.bzf != null && this.bzf.isShowing()) {
            this.bzf.dismiss();
        }
        this.bzf = null;
    }

    public void c(BdPageContext bdPageContext, boolean z) {
        int i = a.i.linkmic_cancel_confirm;
        if (z) {
            i = a.i.linkmic_close_confirm;
        }
        if (this.bzh == null) {
            this.bzh = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.bzh.setAutoNight(false);
        this.bzh.setTitle((String) null);
        this.bzh.setMessageId(i);
        this.bzh.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.t(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_CLOSE_CFM);
                if (b.this.bzg != null) {
                    b.this.bzg.OK();
                }
            }
        });
        this.bzh.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.t(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_CLOSE_CAN);
            }
        });
        this.bzh.setCanceledOnTouchOutside(false);
        this.bzh.setPositiveButtonTextColor(-55461);
        this.bzh.setNagetiveButtonTextColor(-14737633);
        this.bzh.create(bdPageContext).show();
        t(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void Sg() {
        if (this.bzh != null && this.bzh.isShowing()) {
            this.bzh.dismiss();
        }
        this.bzh = null;
    }

    public void onDestroy() {
        this.bzf = null;
        this.bzh = null;
        this.bzg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str3);
        ubcStatisticItem.setContentExt(null, MapController.POPUP_LAYER_TAG, null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
