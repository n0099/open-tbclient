package c.a.q0.v.j.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.s.a;
import c.a.q0.v.j.d.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class j extends c.a.e.l.e.a<m, CardViewHolder<c.a.q0.v.j.h.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public c.a.q0.q3.d n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public TextView s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f25641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f25642f;

        public a(j jVar, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25642f = jVar;
            this.f25641e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25642f.n0(this.f25641e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f25643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f25644b;

        public c(j jVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25644b = jVar;
            this.f25643a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f25644b.o ? this.f25644b.p : "0";
                String str2 = this.f25644b.o ? this.f25644b.q : null;
                String str3 = this.f25644b.o ? this.f25644b.r : null;
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                c.a.e.e.i.a.l().h(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f25643a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.f25679f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = false;
        this.m = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.q = str;
        }
    }

    public final void m0(m mVar, c.a.q0.v.j.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, mVar, aVar) == null) || mVar.g() == null) {
            return;
        }
        this.s = aVar.p();
        v0();
        aVar.v(8);
        aVar.w(this.f2966e.getResources().getString(R.string.ala_person_center_publish_live));
        aVar.l(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void n0(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) || mVar == null || mVar.g() == null) {
            return;
        }
        c.a.p0.s.d0.b.j().t(c.a.p0.s.d0.b.n("live_publish_live_has_showed"), true);
        w0(this.s, null, false);
        r0();
        TiebaStatic.log("c13618");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: o0 */
    public CardViewHolder<c.a.q0.v.j.h.a> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new CardViewHolder<>(new c.a.q0.v.j.h.a(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: p0 */
    public View a0(int i2, View view, ViewGroup viewGroup, m mVar, CardViewHolder<c.a.q0.v.j.h.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            m0(mVar, cardViewHolder.getCardView());
            cardViewHolder.getCardView().j().setOnClickListener(new a(this, mVar));
            return cardViewHolder.getCardView().j();
        }
        return (View) invokeCommon.objValue;
    }

    public final void q0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void r0() {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.m.getPageActivity());
                aVar.setAutoNight(false);
                aVar.setTitle(R.string.prompt);
                aVar.setMessage(this.m.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.know, new b(this));
                aVar.create(this.m).show();
            } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
                if (this.n == null) {
                    this.n = new c.a.q0.q3.d(this.m);
                }
                if (this.o) {
                    if (this.n.c()) {
                        return;
                    }
                } else if (this.n.d()) {
                    return;
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    c.a.e.e.p.l.L(this.m.getPageActivity(), R.string.plugin_config_not_found);
                } else {
                    q0(this.m);
                }
            }
        }
    }

    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.p = str;
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.r = str;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.t) {
            return;
        }
        this.t = true;
        if (!c.a.p0.s.d0.b.j().g(c.a.p0.s.d0.b.n("live_publish_live_has_showed"), false)) {
            c.a.p0.s.d0.b.j().t(c.a.p0.s.d0.b.n("live_publish_live_has_showed"), true);
            w0(this.s, null, true);
            return;
        }
        w0(this.s, null, false);
    }

    public final void w0(TextView textView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048589, this, textView, str, z) == null) || textView == null || this.m == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.m.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
