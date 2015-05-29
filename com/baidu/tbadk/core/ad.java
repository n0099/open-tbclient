package com.baidu.tbadk.core;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class ad extends PhoneStateListener {
    final /* synthetic */ TbadkCoreApplication OW;

    private ad(TbadkCoreApplication tbadkCoreApplication) {
        this.OW = tbadkCoreApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(TbadkCoreApplication tbadkCoreApplication, ad adVar) {
        this(tbadkCoreApplication);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                TbadkCoreApplication.access$1(this.OW, false);
                break;
            case 1:
            case 2:
                TbadkCoreApplication.access$1(this.OW, true);
                break;
        }
        super.onCallStateChanged(i, str);
    }
}
