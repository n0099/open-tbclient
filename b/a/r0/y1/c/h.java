package b.a.r0.y1.c;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import b.a.r0.y1.c.k.p;
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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28838a;

    /* renamed from: b  reason: collision with root package name */
    public View f28839b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f28840c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28841d;

    /* renamed from: e  reason: collision with root package name */
    public p f28842e;

    /* renamed from: f  reason: collision with root package name */
    public View f28843f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f28844g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28845e;

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
            this.f28845e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            String d2 = this.f28845e.f28842e.a().d();
            if (StringUtils.isNull(d2)) {
                return;
            }
            TiebaStatic.log("c10452");
            MemberCenterStatic.a(this.f28845e.f28838a.getPageContext(), new String[]{d2});
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
        this.f28844g = new a(this);
        this.f28838a = baseFragmentActivity;
        e(view);
    }

    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null) {
            return;
        }
        this.f28842e = pVar;
        if (pVar.f28976e) {
            this.f28843f.setVisibility(0);
        } else {
            this.f28843f.setVisibility(8);
        }
        String d2 = pVar.d();
        if (!TextUtils.isEmpty(d2)) {
            this.f28840c.setIsRound(true);
            this.f28840c.setDefaultBgResource(0);
            this.f28840c.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f28840c.startLoad(d2, 25, false);
        }
        if (TbadkCoreApplication.getCurrentMemberType() <= 1) {
            this.f28841d.setText(R.string.index_rank_default_value);
        } else {
            this.f28841d.setText(d(pVar));
        }
    }

    public final SpannableString d(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar)) == null) {
            String str = this.f28838a.getPageContext().getString(R.string.index_rank_value) + pVar.e();
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, pVar.e(), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || view == null) {
            return;
        }
        this.f28839b = view;
        this.f28840c = (HeadImageView) view.findViewById(R.id.user_portrait);
        this.f28841d = (TextView) this.f28839b.findViewById(R.id.txt_rank_num);
        this.f28843f = this.f28839b.findViewById(R.id.divider_sp_line);
        this.f28839b.setOnClickListener(this.f28844g);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.q0.v0.a.a(this.f28838a.getPageContext(), this.f28839b);
        }
    }
}
