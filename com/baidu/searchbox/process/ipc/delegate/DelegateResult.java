package com.baidu.searchbox.process.ipc.delegate;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes3.dex */
public class DelegateResult implements DelegateDef.ResultCode {
    public final Class<? extends Delegation> mDelegation;
    public StringBuilder mDesc;
    public final Bundle mParams;
    public final Bundle mResult;
    public final int mResultCode;

    public DelegateResult(int i, Class<? extends ActivityDelegation> cls) {
        this(i, cls, null);
    }

    private String getDesc() {
        return this.mDesc.toString();
    }

    public static void putAll(@Nullable Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public DelegateResult addDesc(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.mDesc;
            sb.append("[desc]:: ");
            sb.append(str);
            sb.append("\n");
        }
        return this;
    }

    public boolean isOk() {
        return this.mResultCode == 0;
    }

    public DelegateResult putParams(Bundle bundle) {
        putAll(bundle, this.mParams);
        return this;
    }

    public DelegateResult putResult(Bundle bundle) {
        putAll(bundle, this.mResult);
        return this;
    }

    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle) {
        this(i, cls, bundle, null);
    }

    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        this.mDesc = new StringBuilder();
        this.mParams = new Bundle();
        this.mResult = new Bundle();
        this.mResultCode = i;
        this.mDelegation = cls;
        putParams(bundle);
        putResult(bundle2);
    }
}
