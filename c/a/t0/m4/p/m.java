package c.a.t0.m4.p;

import android.view.View;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class m implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ m f20078e = new m();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ m() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? VideoAttentionListPageFragment.k(view) : invokeL.booleanValue;
    }
}
