package c.a.r0.l4.t.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f19659g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19660c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19661d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19662e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19663f;

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
        f19659g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // c.a.r0.l4.t.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
            this.f19658b = inflate;
            this.f19660c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.f19661d = (TextView) this.f19658b.findViewById(R.id.rotate_right);
            this.f19662e = (TextView) this.f19658b.findViewById(R.id.rotate_left_right);
            this.f19663f = (TextView) this.f19658b.findViewById(R.id.rotate_up_down);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19658b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19660c, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f19661d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f19662e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f19663f, R.color.CAM_X0107);
            this.f19660c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f19661d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f19663f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f19662e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f19660c.setCompoundDrawablePadding(f19659g);
            this.f19661d.setCompoundDrawablePadding(f19659g);
            this.f19663f.setCompoundDrawablePadding(f19659g);
            this.f19662e.setCompoundDrawablePadding(f19659g);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f19660c.setTag(0);
            this.f19661d.setTag(1);
            this.f19662e.setTag(2);
            this.f19663f.setTag(3);
            this.f19660c.setOnClickListener(onClickListener);
            this.f19661d.setOnClickListener(onClickListener);
            this.f19662e.setOnClickListener(onClickListener);
            this.f19663f.setOnClickListener(onClickListener);
        }
    }
}
