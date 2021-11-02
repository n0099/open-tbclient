package b.a.r0.y1.c;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import b.a.r0.y1.c.k.k;
import b.a.r0.y1.c.k.l;
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
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27317a;

    /* renamed from: b  reason: collision with root package name */
    public View f27318b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27319c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27320d;

    /* renamed from: e  reason: collision with root package name */
    public k f27321e;

    /* renamed from: f  reason: collision with root package name */
    public View f27322f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f27323g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27324e;

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
            this.f27324e = fVar;
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
            if (this.f27324e.f27321e == null || this.f27324e.f27321e.f27450f == null) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                l lVar = this.f27324e.f27321e.f27450f;
                String a2 = lVar.a();
                String d2 = lVar.d();
                if (lVar.h() == 0) {
                    str5 = this.f27324e.f27321e.f27451g;
                    str3 = "";
                    str4 = str3;
                    str = a2;
                    str2 = d2;
                } else {
                    String g2 = lVar.g();
                    str4 = lVar.e();
                    str5 = "";
                    str = a2;
                    str2 = d2;
                    str3 = g2;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberExchangeActivityConfig(this.f27324e.f27317a.getPageContext().getPageActivity(), str, str2, str3, str4, str5)));
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
        this.f27323g = new a(this);
        this.f27317a = baseFragmentActivity;
        e(view);
    }

    public void c(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || kVar == null) {
            return;
        }
        this.f27321e = kVar;
        if (kVar.f27449e) {
            this.f27322f.setVisibility(0);
        } else {
            this.f27322f.setVisibility(8);
        }
        this.f27319c.setText(d());
        this.f27320d.setOnClickListener(this.f27323g);
    }

    public final SpannableString d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String string = this.f27317a.getPageContext().getString(R.string.exchange_super_member_desc);
            String string2 = this.f27317a.getPageContext().getString(R.string.vip_member);
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
        this.f27318b = view;
        this.f27319c = (TextView) view.findViewById(R.id.txt_desc);
        this.f27322f = this.f27318b.findViewById(R.id.divider_line);
        this.f27320d = (TextView) this.f27318b.findViewById(R.id.exchange_view);
        SkinManager.setViewTextColor(this.f27319c, R.color.CAM_X0105);
        this.f27318b.setOnClickListener(this.f27323g);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.w0.a.a(this.f27317a.getPageContext(), this.f27318b);
            SkinManager.setViewTextColor(this.f27319c, R.color.CAM_X0105);
        }
    }
}
