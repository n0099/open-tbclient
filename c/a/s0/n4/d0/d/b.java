package c.a.s0.n4.d0.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.f;
import c.a.s0.n4.d;
import c.a.s0.n4.e;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f20201g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20202c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20203d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20204e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20205f;

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
        f20201g = fVar.getResources().getDimensionPixelOffset(e.ds8);
    }

    @Override // c.a.s0.n4.d0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(h.pic_rorate_view, (ViewGroup) null);
            this.f20200b = inflate;
            this.f20202c = (TextView) inflate.findViewById(g.rotate_left);
            this.f20203d = (TextView) this.f20200b.findViewById(g.rotate_right);
            this.f20204e = (TextView) this.f20200b.findViewById(g.rotate_left_right);
            this.f20205f = (TextView) this.f20200b.findViewById(g.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20200b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f20202c, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f20203d, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f20204e, d.CAM_X0107);
            SkinManager.setViewTextColor(this.f20205f, d.CAM_X0107);
            this.f20202c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.s0.n4.f.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f20203d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.s0.n4.f.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f20205f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.s0.n4.f.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f20204e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(c.a.s0.n4.f.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f20202c.setCompoundDrawablePadding(f20201g);
            this.f20203d.setCompoundDrawablePadding(f20201g);
            this.f20205f.setCompoundDrawablePadding(f20201g);
            this.f20204e.setCompoundDrawablePadding(f20201g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20202c.setTag(0);
            this.f20203d.setTag(1);
            this.f20204e.setTag(2);
            this.f20205f.setTag(3);
            this.f20202c.setOnClickListener(onClickListener);
            this.f20203d.setOnClickListener(onClickListener);
            this.f20204e.setOnClickListener(onClickListener);
            this.f20205f.setOnClickListener(onClickListener);
        }
    }
}
