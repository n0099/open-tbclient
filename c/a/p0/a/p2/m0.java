package c.a.p0.a.p2;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f6972e;

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                View view2 = this.f6972e;
                if (view2 == null) {
                    view.setAlpha(c.a.p0.a.s0.a.M().a() ? 0.5f : 0.2f);
                    return false;
                }
                view2.setAlpha(c.a.p0.a.s0.a.M().a() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                View view3 = this.f6972e;
                if (view3 == null) {
                    view.setAlpha(1.0f);
                    return false;
                }
                view3.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
