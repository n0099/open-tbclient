package com.baidu.graph.sdk.ui.fragment.result;

import com.baidu.graph.sdk.ui.FragmentType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/graph/sdk/ui/fragment/result/StringResult;", "Lcom/baidu/graph/sdk/ui/fragment/result/BaseResult;", "result", "", "fragmentType", "Lcom/baidu/graph/sdk/ui/FragmentType;", "(Ljava/lang/String;Lcom/baidu/graph/sdk/ui/FragmentType;)V", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "framework_release"}, k = 1, mv = {1, 1, 1})
/* loaded from: classes3.dex */
public class StringResult extends BaseResult {
    @NotNull
    private String result;

    @NotNull
    public String getResult() {
        return this.result;
    }

    public void setResult(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.result = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringResult(@NotNull String str, @NotNull FragmentType fragmentType) {
        super(fragmentType);
        Intrinsics.checkParameterIsNotNull(str, "result");
        Intrinsics.checkParameterIsNotNull(fragmentType, "fragmentType");
        this.result = str;
    }
}
