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
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class m extends c.a.p0.f1.k<n, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: v */
    public static final int obfuscated = 2131302651;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.s.i.b t;
    public View.OnClickListener u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    Object tag = view.getTag(m.obfuscated);
                    if (tag == null || tag.toString().equals("")) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.a.a), new String[]{tag.toString()});
                    return;
                }
                this.a.q0(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1694815630, "Lc/a/p0/c1/c/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1694815630, "Lc/a/p0/c1/c/m;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        p0(i, view, viewGroup, (n) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: o0 */
    public PrivateMgrApplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PrivateMgrApplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d070a, (ViewGroup) null)) : (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public void onDestroy() {
        c.a.o0.s.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.t) == null) {
            return;
        }
        bVar.s();
    }

    public View p0(int i, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, nVar, privateMgrApplyViewHolder})) == null) {
            super.S(i, view, viewGroup, nVar, privateMgrApplyViewHolder);
            if (nVar != null && !nVar.f() && privateMgrApplyViewHolder != null) {
                if (nVar.f()) {
                    privateMgrApplyViewHolder.f32224e.setVisibility(8);
                    return view;
                }
                boolean z = true;
                if (privateMgrApplyViewHolder.f32225f != this.n) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.f32223d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.f32221b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.f32222c, R.drawable.frs_member_manito_bg);
                }
                int a2 = nVar.a();
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1372);
                if (a2 == -1) {
                    int e2 = nVar.e();
                    String numberUniformFormat = StringHelper.numberUniformFormat(e2);
                    if (e2 > 0) {
                        string = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136c), numberUniformFormat);
                        privateMgrApplyViewHolder.f32222c.setOnClickListener(this.u);
                        privateMgrApplyViewHolder.f32221b.setText(string);
                        privateMgrApplyViewHolder.f32222c.setTag(obfuscated, nVar.b());
                        privateMgrApplyViewHolder.f32222c.setEnabled(z);
                        privateMgrApplyViewHolder.f32222c.setClickable(z);
                        privateMgrApplyViewHolder.f32221b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f32225f = this.n;
                    }
                    z = false;
                    privateMgrApplyViewHolder.f32222c.setOnClickListener(this.u);
                    privateMgrApplyViewHolder.f32221b.setText(string);
                    privateMgrApplyViewHolder.f32222c.setTag(obfuscated, nVar.b());
                    privateMgrApplyViewHolder.f32222c.setEnabled(z);
                    privateMgrApplyViewHolder.f32222c.setClickable(z);
                    privateMgrApplyViewHolder.f32221b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f32225f = this.n;
                } else {
                    if (a2 == 0) {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1370);
                    } else if (a2 == 1) {
                        string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136e);
                    } else {
                        if (a2 == 2) {
                            string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f136d);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.f32222c.setOnClickListener(this.u);
                    privateMgrApplyViewHolder.f32221b.setText(string);
                    privateMgrApplyViewHolder.f32222c.setTag(obfuscated, nVar.b());
                    privateMgrApplyViewHolder.f32222c.setEnabled(z);
                    privateMgrApplyViewHolder.f32222c.setClickable(z);
                    privateMgrApplyViewHolder.f32221b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f32225f = this.n;
                }
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
