package com.baidu.swan.veloce;

import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class VeloceIpcResult {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f12626a;

    /* loaded from: classes3.dex */
    public enum VeloceIpcResultCode {
        OK,
        ERR_UNKNOWN,
        ERR_CALLER
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(@NonNull VeloceIpcResult veloceIpcResult);
    }

    public VeloceIpcResult() {
        new Bundle();
    }

    public static VeloceIpcResult a(int i2, Bundle bundle) {
        VeloceIpcResult veloceIpcResult = new VeloceIpcResult();
        veloceIpcResult.f12626a = bundle;
        return veloceIpcResult;
    }
}
