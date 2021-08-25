package c.a.q0.o3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f23351a;

    /* renamed from: b  reason: collision with root package name */
    public View f23352b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23353c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f23354d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23355e;

    public h(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23351a = tbPageContext;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23352b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f23351a.getPageActivity()).inflate(R.layout.background_preview_bottom, (ViewGroup) null);
            this.f23352b = inflate;
            this.f23353c = (TextView) inflate.findViewById(R.id.text_bg_name);
            this.f23354d = (TbImageView) this.f23352b.findViewById(R.id.bg_permission_icon);
            this.f23355e = (TextView) this.f23352b.findViewById(R.id.text_bg_description);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.u0.a.a(this.f23351a, this.f23352b);
        }
    }

    public void d(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.f23353c.setText(dressItemData.getTitle());
        this.f23354d.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
        this.f23355e.setText(dressItemData.getDescription());
    }
}
