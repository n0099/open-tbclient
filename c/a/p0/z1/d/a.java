package c.a.p0.z1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20894b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20895c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f20896d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20897e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20898f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20899g;

    /* renamed from: h  reason: collision with root package name */
    public int f20900h;
    public int i;
    public int j;

    public a(Context context) {
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
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d048b, (ViewGroup) null);
        this.a = viewGroup;
        this.f20894b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090613);
        this.f20895c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091a10);
        this.f20896d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091385);
        this.f20897e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091386);
        this.f20898f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090990);
        this.f20899g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090991);
        this.f20896d.setOnClickListener(this);
        this.f20898f.setOnClickListener(this);
        c();
    }

    public ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f20894b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f20895c, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.f20896d, R.drawable.img_lable_boy_n);
            SkinManager.setViewTextColor(this.f20897e, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.f20898f, R.drawable.img_lable_girl_n);
            SkinManager.setViewTextColor(this.f20899g, (int) R.color.CAM_X0109);
        }
    }

    public void d(List<c.a.p0.z1.b.a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && ListUtils.getCount(list) == 2) {
            this.f20900h = list.get(0).a;
            this.i = list.get(1).a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            boolean z = false;
            if (view == this.f20896d) {
                z = true;
            } else {
                ImageView imageView = this.f20898f;
            }
            this.j = z ? this.f20900h : this.i;
            SkinManager.setImageResource(this.f20896d, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
            TextView textView = this.f20897e;
            int i = R.color.CAM_X0109;
            SkinManager.setViewTextColor(textView, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
            SkinManager.setImageResource(this.f20898f, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
            TextView textView2 = this.f20899g;
            if (!z) {
                i = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(textView2, i);
        }
    }
}
