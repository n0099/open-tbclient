package c.a.p0.s4.t.d;

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
/* loaded from: classes2.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f18460g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18461c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18462d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18463e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18464f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f18460g = fVar.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0702fb);
    }

    @Override // c.a.p0.s4.t.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06e3, (ViewGroup) null);
            this.f18459b = inflate;
            this.f18461c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091af3);
            this.f18462d = (TextView) this.f18459b.findViewById(R.id.obfuscated_res_0x7f091af5);
            this.f18463e = (TextView) this.f18459b.findViewById(R.id.obfuscated_res_0x7f091af4);
            this.f18464f = (TextView) this.f18459b.findViewById(R.id.obfuscated_res_0x7f091af6);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18459b : (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f18461c, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f18462d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f18463e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f18464f, (int) R.color.CAM_X0107);
            this.f18461c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f18462d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f18464f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f18463e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f18461c.setCompoundDrawablePadding(f18460g);
            this.f18462d.setCompoundDrawablePadding(f18460g);
            this.f18464f.setCompoundDrawablePadding(f18460g);
            this.f18463e.setCompoundDrawablePadding(f18460g);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f18461c.setTag(0);
            this.f18462d.setTag(1);
            this.f18463e.setTag(2);
            this.f18464f.setTag(3);
            this.f18461c.setOnClickListener(onClickListener);
            this.f18462d.setOnClickListener(onClickListener);
            this.f18463e.setOnClickListener(onClickListener);
            this.f18464f.setOnClickListener(onClickListener);
        }
    }
}
