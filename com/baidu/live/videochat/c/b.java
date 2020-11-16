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
    private com.baidu.live.videochat.c.a bGt;
    private a bGu;
    private long btQ = 10;
    private BdAlertDialog btS;

    /* loaded from: classes4.dex */
    public interface a {
        void OZ();
    }

    public void a(a aVar) {
        this.bGu = aVar;
    }

    public void ba(long j) {
        if (j > 0) {
            this.btQ = j;
        }
    }

    public void a(final Activity activity, String str, String str2, final a.InterfaceC0222a interfaceC0222a) {
        if (this.bGt == null) {
            this.bGt = new com.baidu.live.videochat.c.a(activity);
        }
        final CountDownTimer countDownTimer = new CountDownTimer(this.btQ * 1000, 1000L) { // from class: com.baidu.live.videochat.c.b.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (b.this.bGt != null && b.this.bGt.isShowing()) {
                    b.this.bGt.iF(String.format(activity.getString(a.h.linkmic_close_refuse), (((int) (j / 1000)) + 1) + ""));
                } else {
                    cancel();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (b.this.bGt != null && b.this.bGt.isShowing()) {
                    interfaceC0222a.Qs();
                    b.this.bGt.dismiss();
                }
            }
        };
        this.bGt.a(new a.InterfaceC0222a() { // from class: com.baidu.live.videochat.c.b.2
            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void Uv() {
                interfaceC0222a.Uv();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void Uw() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_ACC);
                interfaceC0222a.Uw();
                b.this.bGt.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void Ux() {
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_RFS);
                interfaceC0222a.Ux();
                b.this.bGt.dismiss();
                countDownTimer.cancel();
            }

            @Override // com.baidu.live.videochat.c.a.InterfaceC0222a
            public void Qs() {
            }
        });
        if (!this.bGt.isShowing()) {
            B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_INVITE_SHOW);
            this.bGt.show();
            if (str != null) {
                this.bGt.iD(str);
            }
        }
        this.bGt.gh(8);
        this.bGt.iE(str2);
        this.bGt.setTitle(activity.getString(a.h.linkmic_invite));
        this.bGt.ig(activity.getString(a.h.linkmic_start));
        this.bGt.iF(String.format(activity.getString(a.h.linkmic_close_refuse), this.btQ + ""));
        this.bGt.fe(0);
        this.bGt.gg(0);
        this.bGt.setCanceledOnTouchOutside(false);
        countDownTimer.start();
    }

    public void Qz() {
        if (this.bGt != null && this.bGt.isShowing()) {
            this.bGt.dismiss();
        }
        this.bGt = null;
    }

    public void c(BdPageContext bdPageContext, boolean z) {
        int i = a.h.linkmic_cancel_confirm;
        if (z) {
            i = a.h.linkmic_close_confirm;
        }
        if (this.btS == null) {
            this.btS = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.btS.setAutoNight(false);
        this.btS.setTitle((String) null);
        this.btS.setMessageId(i);
        this.btS.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_cfm");
                if (b.this.bGu != null) {
                    b.this.bGu.OZ();
                }
            }
        });
        this.btS.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.videochat.c.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
                b.this.B(UbcStatisticLiveKey.KEY_ID_1396, "click", "linkclose_can");
            }
        });
        this.btS.setCanceledOnTouchOutside(false);
        this.btS.setPositiveButtonTextColor(-55461);
        this.btS.setNagetiveButtonTextColor(-14737633);
        this.btS.create(bdPageContext).show();
        B(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Value.VALUE_CHAT_LINK_CLS_TAB_SHOW);
    }

    public void QA() {
        if (this.btS != null && this.btS.isShowing()) {
            this.btS.dismiss();
        }
        this.btS = null;
    }

    public void onDestroy() {
        this.bGt = null;
        this.btS = null;
        this.bGu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, String str2, String str3) {
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str3);
        ubcStatisticItem.setContentExt(null, "popup", null);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }
}
