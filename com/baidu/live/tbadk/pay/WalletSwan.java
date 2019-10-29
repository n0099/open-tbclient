package com.baidu.live.tbadk.pay;
/* loaded from: classes6.dex */
public interface WalletSwan {

    /* loaded from: classes6.dex */
    public interface WalletPayCallback {
        void onResult(int i, String str);
    }

    void getWalletUA(WalletPayCallback walletPayCallback);
}
