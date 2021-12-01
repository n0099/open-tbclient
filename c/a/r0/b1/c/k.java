package c.a.r0.b1.c;

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
/* loaded from: classes5.dex */
public class k extends c.a.r0.d1.k<l, ManagerApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.t.i.b x;
    public View.OnClickListener y;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f14737e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14737e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag(k.z);
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.f14737e.y0(TbadkCoreApplication.getCurrentAccountInfo());
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f14737e.f2907e), new String[]{tag.toString()});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1319620913, "Lc/a/r0/b1/c/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1319620913, "Lc/a/r0/b1/c/k;");
                return;
            }
        }
        z = R.id.assist_apply_tip;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = new a(this);
    }

    @Override // c.a.r0.d1.k, c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x0(i2, view, viewGroup, (l) obj, (ManagerApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        c.a.q0.t.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.x) == null) {
            return;
        }
        bVar.s();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: w0 */
    public ManagerApplyViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ManagerApplyViewHolder(LayoutInflater.from(this.f2907e).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null)) : (ManagerApplyViewHolder) invokeL.objValue;
    }

    public View x0(int i2, View view, ViewGroup viewGroup, l lVar, ManagerApplyViewHolder managerApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, managerApplyViewHolder})) == null) {
            super.Z(i2, view, viewGroup, lVar, managerApplyViewHolder);
            if (lVar != null && !lVar.e() && managerApplyViewHolder != null) {
                if (lVar.e()) {
                    managerApplyViewHolder.mRootLayout.setVisibility(8);
                    return view;
                }
                if (managerApplyViewHolder.mSkinType != this.r) {
                    SkinManager.setViewTextColor(managerApplyViewHolder.mAssistRemainNum, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(managerApplyViewHolder.mTipAssistLeft, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(managerApplyViewHolder.mAssistApplyLayout, R.drawable.frs_member_manito_bg);
                }
                int d2 = lVar.d();
                if (d2 > 0) {
                    managerApplyViewHolder.mAssistRemainNum.setText(String.format(this.f2907e.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(d2)));
                    managerApplyViewHolder.mAssistApplyLayout.setTag(z, lVar.a());
                    managerApplyViewHolder.mAssistApplyLayout.setOnClickListener(this.y);
                    managerApplyViewHolder.mAssistApplyLayout.setEnabled(true);
                    managerApplyViewHolder.mAssistApplyLayout.setClickable(true);
                } else {
                    managerApplyViewHolder.mAssistRemainNum.setText(this.f2907e.getResources().getString(R.string.apply_no_left_tip));
                    managerApplyViewHolder.mAssistApplyLayout.setEnabled(false);
                    managerApplyViewHolder.mAssistApplyLayout.setClickable(false);
                }
                managerApplyViewHolder.mAssistRemainNum.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                managerApplyViewHolder.mSkinType = this.r;
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y0(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(this.f2907e);
            Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
            if (this.x == null) {
                this.x = new c.a.q0.t.i.b(pageActivity);
            }
            this.x.p();
            this.x.u(accountData);
            this.x.z(1);
        }
    }
}
