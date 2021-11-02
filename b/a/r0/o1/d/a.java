package b.a.r0.o1.d;

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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f21986e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21987f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21988g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21989h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21990i;
    public ImageView j;
    public TextView k;
    public int l;
    public int m;
    public int n;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.label_recommend_header, (ViewGroup) null);
        this.f21986e = viewGroup;
        this.f21987f = (TextView) viewGroup.findViewById(R.id.choose_like_label);
        this.f21988g = (TextView) this.f21986e.findViewById(R.id.recommend_interest_thread);
        this.f21989h = (ImageView) this.f21986e.findViewById(R.id.male_icon);
        this.f21990i = (TextView) this.f21986e.findViewById(R.id.male_text);
        this.j = (ImageView) this.f21986e.findViewById(R.id.female_icon);
        this.k = (TextView) this.f21986e.findViewById(R.id.female_text);
        this.f21989h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        c();
    }

    public ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21986e : (ViewGroup) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f21987f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f21988g, R.color.CAM_X0109);
            SkinManager.setImageResource(this.f21989h, R.drawable.img_lable_boy_n);
            SkinManager.setViewTextColor(this.f21990i, R.color.CAM_X0109);
            SkinManager.setImageResource(this.j, R.drawable.img_lable_girl_n);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
        }
    }

    public void d(List<b.a.r0.o1.b.a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && ListUtils.getCount(list) == 2) {
            this.l = list.get(0).f21980a;
            this.m = list.get(1).f21980a;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            boolean z = false;
            if (view == this.f21989h) {
                z = true;
            } else {
                ImageView imageView = this.j;
            }
            this.n = z ? this.l : this.m;
            SkinManager.setImageResource(this.f21989h, z ? R.drawable.img_lable_boy_s : R.drawable.img_lable_boy_n);
            SkinManager.setViewTextColor(this.f21990i, z ? R.color.CAM_X0302 : R.color.CAM_X0109);
            SkinManager.setImageResource(this.j, z ? R.drawable.img_lable_girl_n : R.drawable.img_lable_girl_s);
            SkinManager.setViewTextColor(this.k, z ? R.color.CAM_X0109 : R.color.CAM_X0301);
        }
    }
}
