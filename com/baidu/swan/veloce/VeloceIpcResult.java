package com.baidu.swan.veloce;

import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class VeloceIpcResult {
    public Bundle mResult = new Bundle();
    public int mResultCode;

    /* loaded from: classes9.dex */
    public enum VeloceIpcResultCode {
        OK,
        ERR_UNKNOWN,
        ERR_CALLER
    }

    /* loaded from: classes9.dex */
    public interface a {
        void a(@NonNull VeloceIpcResult veloceIpcResult);
    }

    public static VeloceIpcResult g(int i, Bundle bundle) {
        VeloceIpcResult veloceIpcResult = new VeloceIpcResult();
        veloceIpcResult.mResultCode = i;
        veloceIpcResult.mResult = bundle;
        return veloceIpcResult;
    }
}
