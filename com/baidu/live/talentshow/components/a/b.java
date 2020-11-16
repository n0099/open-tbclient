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
    private long btQ = 10;
    private com.baidu.live.talentshow.components.a.a btR;
    private BdAlertDialog btS;
    private CountDownTimer btT;

    /* loaded from: classes4.dex */
    public interface a {
        void OZ();

        void Pa();
    }

    public void a(Activity activity, final a.InterfaceC0199a interfaceC0199a) {
        if (this.btR == null) {
            this.btR = new com.baidu.live.talentshow.components.a.a(activity);
            if (Build.VERSION.SDK_INT >= 8) {
                this.btR.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.talentshow.components.a.b.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        com.baidu.live.talentshow.e.a.Sa();
                    }
                });
            }
        }
        if (this.btT == null) {
            this.btT = new CountDownTimer(this.btQ * 1000, 1000L) { // from class: com.baidu.live.talentshow.components.a.b.2
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    if (b.this.btR != null && b.this.btR.isShowing()) {
                        b.this.btR.ih((((int) (j / 1000)) + 1) + "s");
                        return;
                    }
                    cancel();
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (b.this.btR != null && b.this.btR.isShowing()) {
                        interfaceC0199a.Qs();
                        b.this.Qz();
                    }
                }
            };
        }
        this.btR.a(new a.InterfaceC0199a() { // from class: com.baidu.live.talentshow.components.a.b.3
            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0199a
            public boolean Qr() {
                if (interfaceC0199a.Qr()) {
                    b.this.Qz();
                    b.this.cancelTimer();
                    com.baidu.live.talentshow.e.a.RZ();
                    return true;
                }
                return true;
            }

            @Override // com.baidu.live.talentshow.components.a.a.InterfaceC0199a
            public void Qs() {
            }
        });
        if (!this.btR.isShowing()) {
            this.btR.show();
        }
        this.btR.ig(activity.getString(a.h.talent_start));
        this.btR.fe(0);
        this.btR.setCanceledOnTouchOutside(false);
        startTimer();
    }

    public void Qz() {
        if (this.btR != null && this.btR.isShowing()) {
            this.btR.dismiss();
        }
        cancelTimer();
        this.btR = null;
    }

    public void cancelTimer() {
        if (this.btT != null) {
            this.btT.cancel();
        }
    }

    public void startTimer() {
        if (this.btT != null) {
            this.btT.start();
        }
    }

    public void a(BdPageContext bdPageContext, String str, final a aVar) {
        if (this.btS == null) {
            this.btS = new BdAlertDialog(bdPageContext.getPageActivity());
        }
        this.btS.setAutoNight(false);
        this.btS.setTitle((String) null);
        this.btS.setMessage(str);
        this.btS.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.QA();
                if (aVar != null) {
                    aVar.OZ();
                }
            }
        });
        this.btS.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.talentshow.components.a.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                b.this.QA();
                if (aVar != null) {
                    aVar.Pa();
                }
            }
        });
        this.btS.setCanceledOnTouchOutside(false);
        this.btS.setPositiveButtonTextColor(-55461);
        this.btS.setNagetiveButtonTextColor(-14737633);
        this.btS.create(bdPageContext).show();
    }

    public void QA() {
        if (this.btS != null && this.btS.isShowing()) {
            this.btS.dismiss();
        }
        this.btS = null;
    }

    public void onDestroy() {
        if (this.btR != null && this.btR.isShowing()) {
            this.btR.dismiss();
        }
        this.btR = null;
        if (this.btS != null && this.btS.isShowing()) {
            this.btS.dismiss();
        }
        this.btS = null;
    }
}
