package com.android.msasdk;
/* loaded from: classes6.dex */
public interface FreemeIdsSupplier {
    void connect(IConnect iConnect);

    String getAAID(String str);

    String getOAID();

    String getUDID(String str);

    String getVAID(String str);

    boolean isSupported();

    void shutDown();
}
