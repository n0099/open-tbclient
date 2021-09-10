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
    public static int f16897g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16898c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16899d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16900e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16901f;

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
        f16897g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // c.a.r0.c4.t.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f16895a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
            this.f16896b = inflate;
            this.f16898c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.f16899d = (TextView) this.f16896b.findViewById(R.id.rotate_right);
            this.f16900e = (TextView) this.f16896b.findViewById(R.id.rotate_left_right);
            this.f16901f = (TextView) this.f16896b.findViewById(R.id.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16896b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f16898c, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16899d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16900e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16901f, R.color.CAM_X0107);
            this.f16898c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f16899d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f16901f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f16900e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f16898c.setCompoundDrawablePadding(f16897g);
            this.f16899d.setCompoundDrawablePadding(f16897g);
            this.f16901f.setCompoundDrawablePadding(f16897g);
            this.f16900e.setCompoundDrawablePadding(f16897g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f16898c.setTag(0);
            this.f16899d.setTag(1);
            this.f16900e.setTag(2);
            this.f16901f.setTag(3);
            this.f16898c.setOnClickListener(onClickListener);
            this.f16899d.setOnClickListener(onClickListener);
            this.f16900e.setOnClickListener(onClickListener);
            this.f16901f.setOnClickListener(onClickListener);
        }
    }
}
