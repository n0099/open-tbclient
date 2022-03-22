package c.a.p0.c1.c;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ManagerApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k extends c.a.p0.f1.k<l, ManagerApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: v */
    public static final int obfuscated = 2131296941;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.s.i.b t;
    public View.OnClickListener u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag(k.obfuscated);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.q0(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.a.a), new String[]{tag.toString()});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1694815692, "Lc/a/p0/c1/c/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1694815692, "Lc/a/p0/c1/c/k;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this);
    }

    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        p0(i, view, viewGroup, (l) obj, (ManagerApplyViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: o0 */
    public ManagerApplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new ManagerApplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d033d, (ViewGroup) null)) : (ManagerApplyViewHolder) invokeL.objValue;
    }

    public void onDestroy() {
        c.a.o0.s.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.t) == null) {
            return;
        }
        bVar.s();
    }

    public View p0(int i, View view, ViewGroup viewGroup, l lVar, ManagerApplyViewHolder managerApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, lVar, managerApplyViewHolder})) == null) {
            super.S(i, view, viewGroup, lVar, managerApplyViewHolder);
            if (lVar != null && !lVar.e() && managerApplyViewHolder != null) {
                if (lVar.e()) {
                    managerApplyViewHolder.f32219d.setVisibility(8);
                    return view;
                }
                if (managerApplyViewHolder.f32220e != this.n) {
                    SkinManager.setViewTextColor(managerApplyViewHolder.f32217b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(managerApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(managerApplyViewHolder.f32218c, R.drawable.frs_member_manito_bg);
                }
                int b2 = lVar.b();
                if (b2 > 0) {
                    managerApplyViewHolder.f32217b.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0293), StringHelper.numberUniformFormat(b2)));
                    managerApplyViewHolder.f32218c.setTag(obfuscated, lVar.a());
                    managerApplyViewHolder.f32218c.setOnClickListener(this.u);
                    managerApplyViewHolder.f32218c.setEnabled(true);
                    managerApplyViewHolder.f32218c.setClickable(true);
                } else {
                    managerApplyViewHolder.f32217b.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0295));
                    managerApplyViewHolder.f32218c.setEnabled(false);
                    managerApplyViewHolder.f32218c.setClickable(false);
                }
                managerApplyViewHolder.f32217b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.f32220e = this.n;
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void q0(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(this.a);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.t == null) {
                this.t = new c.a.o0.s.i.b(pageActivity);
            }
            this.t.p();
            this.t.u(accountData);
            this.t.z(1);
        }
    }
}
