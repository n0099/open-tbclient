package c.a.o0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes2.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f11583b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f11584c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f11585d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f11586e;

    public b(Context context) {
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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d029d, (ViewGroup) null);
        this.a = inflate;
        this.f11583b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909d9);
        this.f11585d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909db);
        this.f11584c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d7);
        this.f11586e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909da);
        this.f11585d.setText(R.string.obfuscated_res_0x7f0f06c4);
        b();
    }

    @Override // c.a.o0.x.c
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f11585d, (int) R.color.CAM_X0101);
        this.f11584c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(w0.A).tlRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f11586e);
        this.f11583b.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0807ff, WebPManager.ResourceStateType.NORMAL));
    }

    @Override // c.a.o0.x.c
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.a;
            return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d029b, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.o0.x.c
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
