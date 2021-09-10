package c.a.r0.x1.c;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import c.a.r0.x1.c.k.k;
import c.a.r0.x1.c.k.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28392a;

    /* renamed from: b  reason: collision with root package name */
    public View f28393b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28394c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28395d;

    /* renamed from: e  reason: collision with root package name */
    public k f28396e;

    /* renamed from: f  reason: collision with root package name */
    public View f28397f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f28398g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28399e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28399e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (this.f28399e.f28396e == null || this.f28399e.f28396e.f28530f == null) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                l lVar = this.f28399e.f28396e.f28530f;
                String b2 = lVar.b();
                String c2 = lVar.c();
                if (lVar.h() == 0) {
                    str5 = this.f28399e.f28396e.f28531g;
                    str3 = "";
                    str4 = str3;
                    str = b2;
                    str2 = c2;
                } else {
                    String g2 = lVar.g();
                    str4 = lVar.d();
                    str5 = "";
                    str = b2;
                    str2 = c2;
                    str3 = g2;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberExchangeActivityConfig(this.f28399e.f28392a.getPageContext().getPageActivity(), str, str2, str3, str4, str5)));
        }
    }

    public f(View view, BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28398g = new a(this);
        this.f28392a = baseFragmentActivity;
        e(view);
    }

    public void c(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || kVar == null) {
            return;
        }
        this.f28396e = kVar;
        if (kVar.f28529e) {
            this.f28397f.setVisibility(0);
        } else {
            this.f28397f.setVisibility(8);
        }
        this.f28394c.setText(d());
        this.f28395d.setOnClickListener(this.f28398g);
    }

    public final SpannableString d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String string = this.f28392a.getPageContext().getString(R.string.exchange_super_member_desc);
            String string2 = this.f28392a.getPageContext().getString(R.string.vip_member);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)));
            return spannableString;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        this.f28393b = view;
        this.f28394c = (TextView) view.findViewById(R.id.txt_desc);
        this.f28397f = this.f28393b.findViewById(R.id.divider_line);
        this.f28395d = (TextView) this.f28393b.findViewById(R.id.exchange_view);
        SkinManager.setViewTextColor(this.f28394c, R.color.CAM_X0105);
        this.f28393b.setOnClickListener(this.f28398g);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.w0.a.a(this.f28392a.getPageContext(), this.f28393b);
            SkinManager.setViewTextColor(this.f28394c, R.color.CAM_X0105);
        }
    }
}
