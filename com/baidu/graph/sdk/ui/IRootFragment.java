package com.baidu.graph.sdk.ui;

import android.support.v4.app.Fragment;
import com.baidu.graph.sdk.ui.IFragmentCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 0}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/graph/sdk/ui/IRootFragment;", "T", "Lcom/baidu/graph/sdk/ui/IFragmentCallback;", "", "getFragment", "Landroid/support/v4/app/Fragment;", "onFragmentBackPressed", "", "setFragmentCallback", "", "callback", "(Lcom/baidu/graph/sdk/ui/IFragmentCallback;)V", "framework_release"}, k = 1, mv = {1, 1, 1})
/* loaded from: classes3.dex */
public interface IRootFragment<T extends IFragmentCallback> {
    @NotNull
    Fragment getFragment();

    boolean onFragmentBackPressed();

    void setFragmentCallback(@NotNull T t);
}
