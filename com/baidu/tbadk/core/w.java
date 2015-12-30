package com.baidu.tbadk.core;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.InterfaceC0004a {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0004a
    public void b(int i, String str, Address address) {
        if (i == 0 && address != null) {
            try {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                    this.this$0.setLocationLat(valueOf);
                    this.this$0.setLocationLng(valueOf2);
                    this.this$0.setLocationPos(address.getAddressLine(0));
                }
            } catch (IllegalStateException e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
