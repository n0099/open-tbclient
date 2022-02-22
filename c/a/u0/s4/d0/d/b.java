package c.a.u0.s4.d0.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.u0.s4.d;
import c.a.u0.s4.e;
import c.a.u0.s4.g;
import c.a.u0.s4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f22066g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22067c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22068d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22069e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22070f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f22066g = fVar.getResources().getDimensionPixelOffset(e.ds8);
    }

    @Override // c.a.u0.s4.d0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(h.pic_rorate_view, (ViewGroup) null);
            this.f22065b = inflate;
            this.f22067c = (TextView) inflate.findViewById(g.rotate_left);
            this.f22068d = (TextView) this.f22065b.findViewById(g.rotate_right);
            this.f22069e = (TextView) this.f22065b.findViewById(g.rotate_left_right);
            this.f22070f = (TextView) this.f22065b.findViewById(g.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22065b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f22067c, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f22068d, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f22069e, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f22070f, d.CAM_X0107);
            this.f22067c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.u0.s4.f.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f22068d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.u0.s4.f.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f22070f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.u0.s4.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f22069e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.u0.s4.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f22067c.setCompoundDrawablePadding(f22066g);
            this.f22068d.setCompoundDrawablePadding(f22066g);
            this.f22070f.setCompoundDrawablePadding(f22066g);
            this.f22069e.setCompoundDrawablePadding(f22066g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f22067c.setTag(0);
            this.f22068d.setTag(1);
            this.f22069e.setTag(2);
            this.f22070f.setTag(3);
            this.f22067c.setOnClickListener(onClickListener);
            this.f22068d.setOnClickListener(onClickListener);
            this.f22069e.setOnClickListener(onClickListener);
            this.f22070f.setOnClickListener(onClickListener);
        }
    }
}
