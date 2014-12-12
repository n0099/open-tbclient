package com.baidu.tbadk.core;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.d.d {
    final /* synthetic */ TbadkCoreApplication CR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbadkCoreApplication tbadkCoreApplication) {
        this.CR = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    this.CR.setLocationLat(valueOf);
                    this.CR.setLocationLng(valueOf2);
                    this.CR.setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
