package c.a.p0.c0.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends c.a.d.o.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f13215b;

    /* renamed from: c  reason: collision with root package name */
    public View f13216c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f13217d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13218e;

    /* renamed from: f  reason: collision with root package name */
    public View f13219f;

    /* renamed from: g  reason: collision with root package name */
    public View f13220g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f13221h;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13215b = context;
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f13215b).inflate(R.layout.obfuscated_res_0x7f0d00f9, (ViewGroup) null);
            this.f13216c = inflate;
            this.f13218e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0901dc);
            this.f13217d = (ImageView) this.f13216c.findViewById(R.id.obfuscated_res_0x7f0901db);
            this.f13219f = this.f13216c.findViewById(R.id.obfuscated_res_0x7f0901dd);
            this.f13220g = this.f13216c.findViewById(R.id.obfuscated_res_0x7f0901da);
            d(TbadkCoreApplication.getInst().getSkinType());
            return this.f13216c;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.b
    public void c() {
        View.OnClickListener onClickListener;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f13221h) == null || (view = this.f13216c) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            View view = this.f13216c;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
            TextView textView = this.f13218e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            ImageView imageView = this.f13217d;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_inf_arrowblue_n);
            }
            View view2 = this.f13219f;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0204);
            }
            View view3 = this.f13220g;
            if (view3 != null) {
                SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f13221h = onClickListener;
        }
    }
}
