package c.a.q0.w1.c;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import c.a.q0.w1.c.k.p;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27724a;

    /* renamed from: b  reason: collision with root package name */
    public View f27725b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f27726c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27727d;

    /* renamed from: e  reason: collision with root package name */
    public p f27728e;

    /* renamed from: f  reason: collision with root package name */
    public View f27729f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f27730g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f27731e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27731e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            String d2 = this.f27731e.f27728e.b().d();
            if (StringUtils.isNull(d2)) {
                return;
            }
            TiebaStatic.log("c10452");
            MemberCenterStatic.a(this.f27731e.f27724a.getPageContext(), new String[]{d2});
        }
    }

    public h(View view, BaseFragmentActivity baseFragmentActivity) {
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
        this.f27730g = new a(this);
        this.f27724a = baseFragmentActivity;
        e(view);
    }

    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null) {
            return;
        }
        this.f27728e = pVar;
        if (pVar.f27867e) {
            this.f27729f.setVisibility(0);
        } else {
            this.f27729f.setVisibility(8);
        }
        String c2 = pVar.c();
        if (!TextUtils.isEmpty(c2)) {
            this.f27726c.setIsRound(true);
            this.f27726c.setDefaultBgResource(0);
            this.f27726c.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f27726c.startLoad(c2, 25, false);
        }
        if (TbadkCoreApplication.getCurrentMemberType() <= 1) {
            this.f27727d.setText(R.string.index_rank_default_value);
        } else {
            this.f27727d.setText(d(pVar));
        }
    }

    public final SpannableString d(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
            String str = this.f27724a.getPageContext().getString(R.string.index_rank_value) + pVar.d();
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, pVar.d(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        this.f27725b = view;
        this.f27726c = (HeadImageView) view.findViewById(R.id.user_portrait);
        this.f27727d = (TextView) this.f27725b.findViewById(R.id.txt_rank_num);
        this.f27729f = this.f27725b.findViewById(R.id.divider_sp_line);
        this.f27725b.setOnClickListener(this.f27730g);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.u0.a.a(this.f27724a.getPageContext(), this.f27725b);
        }
    }
}
