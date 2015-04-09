package com.baidu.tbadk.core;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class ac extends PhoneStateListener {
    final /* synthetic */ TbadkCoreApplication Oz;

    private ac(TbadkCoreApplication tbadkCoreApplication) {
        this.Oz = tbadkCoreApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(TbadkCoreApplication tbadkCoreApplication, ac acVar) {
        this(tbadkCoreApplication);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                TbadkCoreApplication.access$1(this.Oz, false);
                break;
            case 1:
            case 2:
                TbadkCoreApplication.access$1(this.Oz, true);
                break;
        }
        super.onCallStateChanged(i, str);
    }
}
