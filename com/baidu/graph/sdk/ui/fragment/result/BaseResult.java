package com.baidu.graph.sdk.ui.fragment.result;

import com.baidu.graph.sdk.ui.FragmentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/graph/sdk/ui/fragment/result/BaseResult;", "", "fragmentType", "Lcom/baidu/graph/sdk/ui/FragmentType;", "(Lcom/baidu/graph/sdk/ui/FragmentType;)V", "getFragmentType", "()Lcom/baidu/graph/sdk/ui/FragmentType;", "framework_release"}, k = 1, mv = {1, 1, 1})
/* loaded from: classes3.dex */
public class BaseResult {
    @NotNull
    private final FragmentType fragmentType;

    public BaseResult(@NotNull FragmentType fragmentType) {
        Intrinsics.checkParameterIsNotNull(fragmentType, "fragmentType");
        this.fragmentType = fragmentType;
    }

    @NotNull
    public final FragmentType getFragmentType() {
        return this.fragmentType;
    }
}
