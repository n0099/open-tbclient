package c.a.q0.w1.c;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import c.a.q0.w1.c.k.k;
import c.a.q0.w1.c.k.l;
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
    public BaseFragmentActivity f27705a;

    /* renamed from: b  reason: collision with root package name */
    public View f27706b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27707c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27708d;

    /* renamed from: e  reason: collision with root package name */
    public k f27709e;

    /* renamed from: f  reason: collision with root package name */
    public View f27710f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f27711g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27712e;

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
            this.f27712e = fVar;
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
            if (this.f27712e.f27709e == null || this.f27712e.f27709e.f27843f == null) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                l lVar = this.f27712e.f27709e.f27843f;
                String b2 = lVar.b();
                String c2 = lVar.c();
                if (lVar.h() == 0) {
                    str5 = this.f27712e.f27709e.f27844g;
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberExchangeActivityConfig(this.f27712e.f27705a.getPageContext().getPageActivity(), str, str2, str3, str4, str5)));
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
        this.f27711g = new a(this);
        this.f27705a = baseFragmentActivity;
        e(view);
    }

    public void c(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || kVar == null) {
            return;
        }
        this.f27709e = kVar;
        if (kVar.f27842e) {
            this.f27710f.setVisibility(0);
        } else {
            this.f27710f.setVisibility(8);
        }
        this.f27707c.setText(d());
        this.f27708d.setOnClickListener(this.f27711g);
    }

    public final SpannableString d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String string = this.f27705a.getPageContext().getString(R.string.exchange_super_member_desc);
            String string2 = this.f27705a.getPageContext().getString(R.string.vip_member);
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
        this.f27706b = view;
        this.f27707c = (TextView) view.findViewById(R.id.txt_desc);
        this.f27710f = this.f27706b.findViewById(R.id.divider_line);
        this.f27708d = (TextView) this.f27706b.findViewById(R.id.exchange_view);
        SkinManager.setViewTextColor(this.f27707c, R.color.CAM_X0105);
        this.f27706b.setOnClickListener(this.f27711g);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.u0.a.a(this.f27705a.getPageContext(), this.f27706b);
            SkinManager.setViewTextColor(this.f27707c, R.color.CAM_X0105);
        }
    }
}
