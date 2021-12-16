package c.a.s0.l4.s.a;

import android.view.View;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ b f19243e = new b();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ b() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? VideoLoadingFragment.k(view) : invokeL.booleanValue;
    }
}
