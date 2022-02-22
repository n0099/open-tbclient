package c.a.u0.a0.f.c.h;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.t.a;
import c.a.u0.a0.f.c.e.h;
import c.a.u0.a0.f.c.e.i;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends c.a.u0.g0.b<i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public ImageView D;
    public ImageView E;
    public ImageView F;
    public RotateAnimation G;
    public ObjectAnimator H;
    public int I;
    public List<h.a> J;
    public String K;
    public c.a.u0.h4.d L;
    public View m;
    public LinearLayout n;
    public HeadImageView o;
    public ImageView p;
    public TextView q;
    public LinearLayout r;
    public ImageView s;
    public TextView t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public LinearLayout x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14952e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14952e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.f14952e.q();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.t0.e.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaPersonCenterActivityConfig a;

        public b(d dVar, AlaPersonCenterActivityConfig alaPersonCenterActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, alaPersonCenterActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaPersonCenterActivityConfig;
        }

        @Override // c.a.t0.e.f
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                onSwitchGet(false);
            }
        }

        @Override // c.a.t0.e.f
        public void onSwitchGet(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* renamed from: c.a.u0.a0.f.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0946d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public C0946d(d dVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                c.a.d.f.i.a.n().j(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = -1;
        this.J = new ArrayList();
        s();
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_live_super_enreances_item_view : invokeV.intValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0202);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0107);
            SkinManager.setImageResource(this.s, R.drawable.super_entrance_ranklist_bg_selector);
            SkinManager.setImageResource(this.v, R.drawable.super_entrance_discuss_bg_selector);
            SkinManager.setImageResource(this.y, R.drawable.super_entrance_person_bg_selector);
            SkinManager.setImageResource(this.B, R.drawable.super_entrance_start_recorder_bg_selector);
            SkinManager.setImageResource(this.F, R.drawable.pic_live_tab_quan);
            if (8 == this.E.getVisibility()) {
                this.p.setVisibility(0);
                this.F.setVisibility(8);
                SkinManager.setBackgroundResource(this.p, R.drawable.super_entrance_follow_bg_selector);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.n) {
                if (ViewHelper.checkUpIsLogin(this.f17876g)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(i().getPageActivity())));
                }
                StatisticItem statisticItem = new StatisticItem("c13552");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (view == this.r) {
                if (StringUtils.isNull(this.K)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f17875f, new String[]{this.K});
                StatisticItem statisticItem2 = new StatisticItem("c13553");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            } else if (view == this.u) {
                String str = "http://tieba.baidu.com/f?kw=百度直播";
                String q = c.a.t0.s.j0.b.k().q("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
                if (!StringUtils.isNull(q) && q.startsWith("http")) {
                    str = q;
                }
                if (!str.contains("?")) {
                    str = str + "?default_tab_id=1&call_from=15";
                } else if (!str.contains("&default_tab_id=")) {
                    str = str + "&default_tab_id=1&call_from=15";
                }
                UrlManager.getInstance().dealOneLink(this.f17875f, new String[]{str}, true);
                StatisticItem statisticItem3 = new StatisticItem("c13554");
                TiebaStaticHelper.addYYParam(statisticItem3);
                TiebaStatic.log(statisticItem3);
            } else if (view == this.x) {
                if (ViewHelper.checkUpIsLogin(this.f17876g)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, new AlaPersonCenterActivityConfig(this.f17875f.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true))));
                }
                StatisticItem statisticItem4 = new StatisticItem("c13555");
                TiebaStaticHelper.addYYParam(statisticItem4);
                TiebaStatic.log(statisticItem4);
            } else if (view == this.A) {
                w();
                TiebaStatic.log("c13617");
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.o == null || ListUtils.isEmpty(this.J)) {
            return;
        }
        this.I++;
        int size = this.J.size();
        int i2 = this.I;
        if (size > i2) {
            this.o.startLoad(this.J.get(i2).a, 12, false);
        } else if (this.J.size() > 0) {
            this.I = 0;
            this.o.startLoad(this.J.get(0).a, 12, false);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View j2 = j();
            this.m = j2;
            this.n = (LinearLayout) j2.findViewById(R.id.entrance_follow);
            this.r = (LinearLayout) this.m.findViewById(R.id.entrance_ranklist);
            this.u = (LinearLayout) this.m.findViewById(R.id.entrance_discuss);
            this.x = (LinearLayout) this.m.findViewById(R.id.entrance_person_center);
            this.E = (ImageView) this.m.findViewById(R.id.entrance_follow_img_diandian);
            this.A = (LinearLayout) this.m.findViewById(R.id.entrance_start_recorder);
            HeadImageView headImageView = (HeadImageView) this.m.findViewById(R.id.entrance_follow_img);
            this.o = headImageView;
            headImageView.setIsRound(true);
            this.o.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.o.setDefaultResource(17170445);
            this.o.setDefaultBgResource(17170445);
            this.F = (ImageView) this.m.findViewById(R.id.entrance_follow_circle);
            this.p = (ImageView) this.m.findViewById(R.id.entrance_follow_default_img);
            this.s = (ImageView) this.m.findViewById(R.id.entrance_ranklist_img);
            this.v = (ImageView) this.m.findViewById(R.id.entrance_discuss_img);
            this.y = (ImageView) this.m.findViewById(R.id.entrance_person_center_img);
            this.B = (ImageView) this.m.findViewById(R.id.entrance_start_recorder_img);
            this.q = (TextView) this.m.findViewById(R.id.entrance_follow_desc);
            this.t = (TextView) this.m.findViewById(R.id.entrance_ranklist_desc);
            this.w = (TextView) this.m.findViewById(R.id.entrance_discuss_desc);
            this.z = (TextView) this.m.findViewById(R.id.entrance_person_center_desc);
            this.C = (TextView) this.m.findViewById(R.id.entrance_start_recorder_desc);
            this.D = (ImageView) this.m.findViewById(R.id.entrance_publish_live_red);
            this.n.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.A.setOnClickListener(this);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.G = rotateAnimation;
            rotateAnimation.setDuration(6000L);
            this.G.setRepeatMode(1);
            this.G.setRepeatCount(-1);
            this.G.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.o, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
            this.H = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            this.H.setTarget(this.o);
            this.H.setRepeatCount(-1);
            this.H.setRepeatMode(1);
            this.H.setDuration(2000L);
            this.H.addListener(new a(this));
            l(this.f17875f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void t(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.D) == null) {
            return;
        }
        if (z) {
            if (!c.a.t0.s.j0.b.k().h(c.a.t0.s.j0.b.o("square_live_publish_live_has_showed"), false)) {
                c.a.t0.s.j0.b.k().u(c.a.t0.s.j0.b.o("square_live_publish_live_has_showed"), true);
                this.D.setVisibility(0);
                return;
            }
            this.D.setVisibility(8);
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: u */
    public void k(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
            this.x.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.A.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.A.setVisibility(TbSingleton.getInstance().isAuditPackageSwitchOn() ? 0 : 8);
            if (iVar != null && iVar.f14851e != null) {
                if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                    StatisticItem statisticItem = new StatisticItem("c13550");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13549");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem("c13547");
                TiebaStaticHelper.addYYParam(statisticItem3);
                TiebaStatic.log(statisticItem3);
                StatisticItem statisticItem4 = new StatisticItem("c13546");
                TiebaStaticHelper.addYYParam(statisticItem4);
                TiebaStatic.log(statisticItem4);
                h hVar = iVar.f14851e;
                this.K = hVar.f14849c;
                if (hVar.a && !ListUtils.isEmpty(hVar.f14848b)) {
                    ArrayList<h.a> arrayList = iVar.f14851e.f14848b;
                    this.J = arrayList;
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    x();
                    q();
                    return;
                }
                y();
                return;
            }
            y();
        }
    }

    public final void v(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new C0946d(this, tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void w() {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(i().getPageActivity());
                aVar.setAutoNight(false);
                aVar.setTitle(R.string.prompt);
                aVar.setMessage(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setPositiveButton(R.string.know, new c(this));
                aVar.create(i()).show();
            } else if (ViewHelper.checkUpIsLogin(i().getPageActivity())) {
                if (this.L == null) {
                    this.L = new c.a.u0.h4.d(i());
                }
                if (this.L.d()) {
                    return;
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    n.M(i().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                c.a.t0.s.j0.b.k().u(c.a.t0.s.j0.b.o("square_live_publish_live_has_showed"), true);
                this.D.setVisibility(8);
                v(i());
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p.setVisibility(8);
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.o.setVisibility(0);
            this.E.clearAnimation();
            RotateAnimation rotateAnimation = this.G;
            if (rotateAnimation != null) {
                this.E.startAnimation(rotateAnimation);
            }
            ObjectAnimator objectAnimator = this.H;
            if (objectAnimator != null) {
                if (objectAnimator.isRunning()) {
                    this.H.cancel();
                }
                this.H.start();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.o.setVisibility(8);
            this.E.clearAnimation();
            ObjectAnimator objectAnimator = this.H;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }
}
