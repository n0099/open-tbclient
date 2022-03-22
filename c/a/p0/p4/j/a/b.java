package c.a.p0.p4.j.a;

import android.view.View;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ b a = new b();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ b() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? VideoLoadingFragment.H0(view) : invokeL.booleanValue;
    }
}
