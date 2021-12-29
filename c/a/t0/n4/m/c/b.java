package c.a.t0.n4.m.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class b extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f20518e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20519f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20518e = (int) TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        setBackgroundResource(R.drawable.ugc_capture_video_pointer);
    }

    public boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            Rect rect = new Rect();
            getHitRect(rect);
            int i4 = rect.left;
            int i5 = this.f20518e;
            rect.left = i4 - i5;
            rect.right += i5;
            rect.top -= i5;
            rect.bottom += i5;
            return rect.contains(i2, i3);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View
    public boolean isPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20519f : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f20519f = z;
        }
    }
}
