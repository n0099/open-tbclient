package com.baidu.tbadk.core;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.InterfaceC0003a {
    final /* synthetic */ TbadkCoreApplication TP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbadkCoreApplication tbadkCoreApplication) {
        this.TP = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    this.TP.setLocationLat(valueOf);
                    this.TP.setLocationLng(valueOf2);
                    this.TP.setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
