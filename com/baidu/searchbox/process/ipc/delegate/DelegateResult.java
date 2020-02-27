package com.baidu.searchbox.process.ipc.delegate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes11.dex */
public class DelegateResult implements DelegateDef.ResultCode {
    public final Class<? extends Delegation> mDelegation;
    private StringBuilder mDesc;
    public final Bundle mParams;
    public final Bundle mResult;
    public final int mResultCode;

    DelegateResult(int i, Class<? extends ActivityDelegation> cls) {
        this(i, cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle) {
        this(i, cls, bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        this.mDesc = new StringBuilder();
        this.mParams = new Bundle();
        this.mResult = new Bundle();
        this.mResultCode = i;
        this.mDelegation = cls;
        putParams(bundle);
        putResult(bundle2);
    }

    DelegateResult putParams(Bundle bundle) {
        putAll(bundle, this.mParams);
        return this;
    }

    DelegateResult putResult(Bundle bundle) {
        putAll(bundle, this.mResult);
        return this;
    }

    public boolean isOk() {
        return this.mResultCode == 0;
    }

    private static void putAll(@Nullable Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public DelegateResult addDesc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDesc.append("[desc]:: ").append(str).append("\n");
        }
        return this;
    }

    private String getDesc() {
        return this.mDesc.toString();
    }
}
