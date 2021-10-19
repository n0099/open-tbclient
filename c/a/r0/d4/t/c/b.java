package c.a.r0.d4.t.c;

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
    public static int f17081g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17082c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17083d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17084e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17085f;

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
        f17081g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // c.a.r0.d4.t.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f17079a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
            this.f17080b = inflate;
            this.f17082c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.f17083d = (TextView) this.f17080b.findViewById(R.id.rotate_right);
            this.f17084e = (TextView) this.f17080b.findViewById(R.id.rotate_left_right);
            this.f17085f = (TextView) this.f17080b.findViewById(R.id.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17080b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f17082c, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f17083d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f17084e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f17085f, R.color.CAM_X0107);
            this.f17082c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f17083d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f17085f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f17084e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f17082c.setCompoundDrawablePadding(f17081g);
            this.f17083d.setCompoundDrawablePadding(f17081g);
            this.f17085f.setCompoundDrawablePadding(f17081g);
            this.f17084e.setCompoundDrawablePadding(f17081g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f17082c.setTag(0);
            this.f17083d.setTag(1);
            this.f17084e.setTag(2);
            this.f17085f.setTag(3);
            this.f17082c.setOnClickListener(onClickListener);
            this.f17083d.setOnClickListener(onClickListener);
            this.f17084e.setOnClickListener(onClickListener);
            this.f17085f.setOnClickListener(onClickListener);
        }
    }
}
