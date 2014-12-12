package com.baidu.tbadk.core;

import android.telephony.PhoneStateListener;
/* loaded from: classes.dex */
class x extends PhoneStateListener {
    final /* synthetic */ TbadkCoreApplication CR;

    private x(TbadkCoreApplication tbadkCoreApplication) {
        this.CR = tbadkCoreApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(TbadkCoreApplication tbadkCoreApplication, x xVar) {
        this(tbadkCoreApplication);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        switch (i) {
            case 0:
                TbadkCoreApplication.access$1(this.CR, false);
                break;
            case 1:
            case 2:
                TbadkCoreApplication.access$1(this.CR, true);
                break;
        }
        super.onCallStateChanged(i, str);
    }
}
