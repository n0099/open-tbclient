package c.a.s0.m3.c;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.l;
import c.a.r0.s.t.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.setting.more.BrowseSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c extends c.a.d.a.d<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BrowseSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f19490b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f19491c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f19492d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f19493e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f19494f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f19495g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f19496h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.s.t.c f19497i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.s.t.c f19498j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.s.t.c f19499k;
    public c.a.r0.s.t.c l;
    public ArrayList<k> m;
    public ArrayList<k> n;
    public ArrayList<k> o;
    public ArrayList<k> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes7.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                c.a.r0.s.g0.b.j().v("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19500e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19500e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f19500e.f19497i.h(i2);
                if (i2 == 0) {
                    l.c().j(true);
                    l.c().k(0);
                } else if (i2 == 1) {
                    l.c().j(true);
                    l.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i2 == 2) {
                    l.c().j(true);
                    l.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i2 == 3) {
                    l.c().j(false);
                }
                this.f19500e.f19497i.d();
                this.f19500e.B();
            }
        }
    }

    /* renamed from: c.a.s0.m3.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1175c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19501e;

        public C1175c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19501e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f19501e.f19498j.h(i2);
                int i3 = 0;
                if (i2 == 0) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                    i3 = 1;
                } else if (i2 == 1) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                    i3 = 2;
                } else if (i2 == 2) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i3);
                setImageWatermarkTypeReqMsg.setTag(this.f19501e.a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                l.c().i(i3);
                this.f19501e.C(i3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19502e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19502e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f19502e.f19499k.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i2 == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.f19502e.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19503e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19503e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f19503e.l.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
                }
                this.f19503e.D();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {browseSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f19490b = null;
        this.f19491c = null;
        this.f19492d = null;
        this.f19493e = null;
        this.f19494f = null;
        this.f19495g = null;
        this.f19497i = null;
        this.f19498j = null;
        this.f19499k = null;
        this.l = null;
        this.r = new b(this);
        this.s = new C1175c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.a = browseSettingActivity;
        initUI();
        y();
        r();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f19494f.setTip(this.mContext.getString(R.string.font_size_xlarge));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f19494f.setTip(this.mContext.getString(R.string.font_size_big));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f19494f.setTip(this.mContext.getString(R.string.font_size_mid));
            } else {
                this.f19494f.setTip(this.mContext.getString(R.string.font_size_small));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!l.c().g()) {
                this.f19492d.setTip(this.mContext.getString(R.string.close));
            } else if (l.c().e() == 1) {
                this.f19492d.setTip(this.mContext.getString(R.string.view_high));
            } else if (l.c().e() == 2) {
                this.f19492d.setTip(this.mContext.getString(R.string.view_low));
            } else {
                this.f19492d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
            }
        }
    }

    public final void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                this.f19493e.setTip(this.mContext.getString(R.string.image_water_show_none));
            } else if (i2 == 1) {
                this.f19493e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
            } else if (i2 != 2) {
            } else {
                this.f19493e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
                this.f19495g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
                this.f19495g.setTip(this.mContext.getString(R.string.close));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
                this.f19495g.setTip(this.mContext.getString(R.string.video_auto_play_always));
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.browse_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.f19491c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f19491c.setTitleText(this.a.getPageContext().getString(R.string.browse_setting));
            this.q = (TbSettingTextTipView) this.a.findViewById(R.id.debug_tool_entrance);
            this.f19492d = (TbSettingTextTipView) this.a.findViewById(R.id.img_browser);
            this.f19493e = (TbSettingTextTipView) this.a.findViewById(R.id.add_img_water);
            this.f19494f = (TbSettingTextTipView) this.a.findViewById(R.id.font_size);
            this.f19495g = (TbSettingTextTipView) this.a.findViewById(R.id.video_auto_play);
            if (RichTextGifViewSwitch.isOn()) {
                this.f19495g.setText(R.string.video_gif_auto_play);
            } else {
                this.f19495g.setText(R.string.video_auto_play);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.slide_anim_switch);
            this.f19496h = msgSettingItemView;
            msgSettingItemView.setText(R.string.slide_anim_switch);
            this.f19496h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.f19496h.setOnSwitchStateChangeListener(new a(this));
            this.f19490b = this.a.findViewById(R.id.parent);
        }
    }

    public TbSettingTextTipView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19493e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19494f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19492d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19495g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = new ArrayList<>();
            int b2 = l.c().b();
            this.o.add(new k(this.a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
            this.o.add(new k(this.a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
            this.o.add(new k(this.a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
            c.a.r0.s.t.c cVar = new c.a.r0.s.t.c(this.a.getPageContext());
            cVar.l(R.string.add_image_water);
            this.f19498j = cVar;
            cVar.k(this.o, this.s);
            cVar.c();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f19490b);
            this.f19491c.onChangeSkinType(getPageContext(), i2);
            this.f19496h.onChangeSkinType(this.a.getPageContext(), i2);
            c.a.r0.s.t.c cVar = this.f19497i;
            if (cVar != null) {
                cVar.g();
            }
            c.a.r0.s.t.c cVar2 = this.f19498j;
            if (cVar2 != null) {
                cVar2.g();
            }
            c.a.r0.s.t.c cVar3 = this.f19499k;
            if (cVar3 != null) {
                cVar3.g();
            }
            c.a.r0.s.t.c cVar4 = this.l;
            if (cVar4 != null) {
                cVar4.g();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f19499k = new c.a.r0.s.t.c(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new k(this.a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
            this.m.add(new k(this.a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
            this.m.add(new k(this.a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
            this.m.add(new k(this.a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
            this.f19499k.l(R.string.font_size);
            this.f19499k.k(this.m, this.t);
            this.f19499k.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.n = new ArrayList<>();
            int e2 = l.c().e();
            boolean g2 = l.c().g();
            boolean z = false;
            this.n.add(new k(this.a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
            this.n.add(new k(this.a.getPageContext().getString(R.string.view_high), this.a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
            ArrayList<k> arrayList = this.n;
            String string = this.a.getPageContext().getString(R.string.view_low);
            String string2 = this.a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
            if (g2 && e2 == 2) {
                z = true;
            }
            arrayList.add(new k(string, string2, z));
            c.a.r0.s.t.c cVar = new c.a.r0.s.t.c(this.a.getPageContext());
            this.f19497i = cVar;
            cVar.l(R.string.browser_image_quality);
            c.a.r0.s.t.c cVar2 = this.f19497i;
            cVar2.k(this.n, this.r);
            cVar2.c();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f19492d.setOnClickListener(this.a);
            this.f19493e.setOnClickListener(this.a);
            this.f19494f.setOnClickListener(this.a);
            this.f19495g.setOnClickListener(this.a);
            this.q.setOnClickListener(this.a);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.l = new c.a.r0.s.t.c(this.a.getPageContext());
            this.p = new ArrayList<>();
            int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
            this.p.add(new k(this.a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
            this.p.add(new k(this.a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
            this.p.add(new k(this.a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.video_gif_auto_play);
            } else {
                this.l.l(R.string.video_auto_play);
            }
            this.l.k(this.p, this.u);
            this.l.c();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            o();
            this.f19498j.n();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p();
            this.f19499k.n();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            q();
            this.f19497i.n();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            s();
            this.l.n();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            C(l.c().b());
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            B();
            x();
            A();
            D();
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
        }
    }
}
