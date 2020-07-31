package com.baidu.swan.veloce;

import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class VeloceIpcResult {
    public Bundle mResult = new Bundle();
    public int mResultCode;

    /* loaded from: classes8.dex */
    public enum VeloceIpcResultCode {
        OK,
        ERR_UNKNOWN,
        ERR_CALLER
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull VeloceIpcResult veloceIpcResult);
    }

    public static VeloceIpcResult f(int i, Bundle bundle) {
        VeloceIpcResult veloceIpcResult = new VeloceIpcResult();
        veloceIpcResult.mResultCode = i;
        veloceIpcResult.mResult = bundle;
        return veloceIpcResult;
    }
}
