package com.baidu.graph.sdk.ui;

import com.baidu.graph.sdk.ui.fragment.result.BaseResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 0}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/baidu/graph/sdk/ui/IFragmentCallback;", "", "finish", "", "result", "Lcom/baidu/graph/sdk/ui/fragment/result/BaseResult;", "startFragment", "fragmentType", "Lcom/baidu/graph/sdk/ui/FragmentType;", "framework_release"}, k = 1, mv = {1, 1, 1})
/* loaded from: classes3.dex */
public interface IFragmentCallback {
    void finish(@NotNull BaseResult baseResult);

    void startFragment(@NotNull FragmentType fragmentType);
}
