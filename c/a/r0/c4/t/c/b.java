package c.a.r0.c4.t.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f16907g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16908c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16909d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16910e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16911f;

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
        f16907g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // c.a.r0.c4.t.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f16905a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
            this.f16906b = inflate;
            this.f16908c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.f16909d = (TextView) this.f16906b.findViewById(R.id.rotate_right);
            this.f16910e = (TextView) this.f16906b.findViewById(R.id.rotate_left_right);
            this.f16911f = (TextView) this.f16906b.findViewById(R.id.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16906b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f16908c, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16909d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16910e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16911f, R.color.CAM_X0107);
            this.f16908c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f16909d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f16911f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f16910e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f16908c.setCompoundDrawablePadding(f16907g);
            this.f16909d.setCompoundDrawablePadding(f16907g);
            this.f16911f.setCompoundDrawablePadding(f16907g);
            this.f16910e.setCompoundDrawablePadding(f16907g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f16908c.setTag(0);
            this.f16909d.setTag(1);
            this.f16910e.setTag(2);
            this.f16911f.setTag(3);
            this.f16908c.setOnClickListener(onClickListener);
            this.f16909d.setOnClickListener(onClickListener);
            this.f16910e.setOnClickListener(onClickListener);
            this.f16911f.setOnClickListener(onClickListener);
        }
    }
}
