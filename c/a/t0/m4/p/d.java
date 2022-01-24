package c.a.t0.m4.p;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class d implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ d f19658e = new d();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ d() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? VideoVerticalPageFragment.F(view, motionEvent) : invokeLL.booleanValue;
    }
}
