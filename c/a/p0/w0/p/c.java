package c.a.p0.w0.p;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19623b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f19624c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19625d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19626e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19627f;

    public c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d061e, (ViewGroup) null);
        this.f19623b = inflate;
        this.f19624c = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090f71);
        this.f19625d = (ImageView) this.f19623b.findViewById(R.id.obfuscated_res_0x7f090e69);
        this.f19626e = (TextView) this.f19623b.findViewById(R.id.obfuscated_res_0x7f090d56);
        this.f19627f = (TextView) this.f19623b.findViewById(R.id.obfuscated_res_0x7f090d57);
        this.f19626e.setText(R.string.obfuscated_res_0x7f0f0c41);
        this.f19627f.setText(R.string.obfuscated_res_0x7f0f0c42);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setImageResource(this.f19625d, R.drawable.cp_mask_attention_a);
            SkinManager.setViewTextColor(this.f19626e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19627f, (int) R.color.CAM_X0109);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0206).tlRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).trRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).blRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).brRadius(n.f(this.a.getPageActivity(), R.dimen.tbds21)).into(this.f19624c);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19623b : (View) invokeV.objValue;
    }
}
