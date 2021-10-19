package c.a.r0.c3.c;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.k;
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
/* loaded from: classes3.dex */
public class c extends c.a.e.a.d<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BrowseSettingActivity f16206a;

    /* renamed from: b  reason: collision with root package name */
    public View f16207b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16208c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f16209d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f16210e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f16211f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f16212g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f16213h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.s.s.c f16214i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.c f16215j;
    public c.a.q0.s.s.c k;
    public c.a.q0.s.s.c l;
    public ArrayList<k> m;
    public ArrayList<k> n;
    public ArrayList<k> o;
    public ArrayList<k> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes3.dex */
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
                c.a.q0.s.d0.b.j().v("slide_local_switch_is_clicked", 1);
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

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16216e;

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
            this.f16216e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f16216e.f16214i.h(i2);
                if (i2 == 0) {
                    c.a.q0.s.k.c().j(true);
                    c.a.q0.s.k.c().k(0);
                } else if (i2 == 1) {
                    c.a.q0.s.k.c().j(true);
                    c.a.q0.s.k.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i2 == 2) {
                    c.a.q0.s.k.c().j(true);
                    c.a.q0.s.k.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i2 == 3) {
                    c.a.q0.s.k.c().j(false);
                }
                this.f16216e.f16214i.d();
                this.f16216e.B();
            }
        }
    }

    /* renamed from: c.a.r0.c3.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0772c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16217e;

        public C0772c(c cVar) {
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
            this.f16217e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f16217e.f16215j.h(i2);
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
                setImageWatermarkTypeReqMsg.setTag(this.f16217e.f16206a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                c.a.q0.s.k.c().i(i3);
                this.f16217e.D(i3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16218e;

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
            this.f16218e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f16218e.k.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i2 == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.f16218e.A();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16219e;

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
            this.f16219e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f16219e.l.h(i2);
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
                this.f16219e.J();
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16206a = null;
        this.f16207b = null;
        this.f16208c = null;
        this.f16209d = null;
        this.f16210e = null;
        this.f16211f = null;
        this.f16212g = null;
        this.f16214i = null;
        this.f16215j = null;
        this.k = null;
        this.l = null;
        this.r = new b(this);
        this.s = new C0772c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.f16206a = browseSettingActivity;
        initUI();
        y();
        r();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f16211f.setTip(this.mContext.getString(R.string.font_size_xlarge));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f16211f.setTip(this.mContext.getString(R.string.font_size_big));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f16211f.setTip(this.mContext.getString(R.string.font_size_mid));
            } else {
                this.f16211f.setTip(this.mContext.getString(R.string.font_size_small));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!c.a.q0.s.k.c().g()) {
                this.f16209d.setTip(this.mContext.getString(R.string.close));
            } else if (c.a.q0.s.k.c().e() == 1) {
                this.f16209d.setTip(this.mContext.getString(R.string.view_high));
            } else if (c.a.q0.s.k.c().e() == 2) {
                this.f16209d.setTip(this.mContext.getString(R.string.view_low));
            } else {
                this.f16209d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
            }
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                this.f16210e.setTip(this.mContext.getString(R.string.image_water_show_none));
            } else if (i2 == 1) {
                this.f16210e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
            } else if (i2 != 2) {
            } else {
                this.f16210e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
                this.f16212g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
                this.f16212g.setTip(this.mContext.getString(R.string.close));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
                this.f16212g.setTip(this.mContext.getString(R.string.video_auto_play_always));
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f16206a.setContentView(R.layout.browse_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f16206a.findViewById(R.id.view_navigation_bar);
            this.f16208c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16208c.setTitleText(this.f16206a.getPageContext().getString(R.string.browse_setting));
            this.q = (TbSettingTextTipView) this.f16206a.findViewById(R.id.debug_tool_entrance);
            this.f16209d = (TbSettingTextTipView) this.f16206a.findViewById(R.id.img_browser);
            this.f16210e = (TbSettingTextTipView) this.f16206a.findViewById(R.id.add_img_water);
            this.f16211f = (TbSettingTextTipView) this.f16206a.findViewById(R.id.font_size);
            this.f16212g = (TbSettingTextTipView) this.f16206a.findViewById(R.id.video_auto_play);
            if (RichTextGifViewSwitch.isOn()) {
                this.f16212g.setText(R.string.video_gif_auto_play);
            } else {
                this.f16212g.setText(R.string.video_auto_play);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f16206a.findViewById(R.id.slide_anim_switch);
            this.f16213h = msgSettingItemView;
            msgSettingItemView.setText(R.string.slide_anim_switch);
            this.f16213h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.f16213h.setOnSwitchStateChangeListener(new a(this));
            this.f16207b = this.f16206a.findViewById(R.id.parent);
        }
    }

    public TbSettingTextTipView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16210e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16211f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16209d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16212g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = new ArrayList<>();
            int b2 = c.a.q0.s.k.c().b();
            this.o.add(new k(this.f16206a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
            this.o.add(new k(this.f16206a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
            this.o.add(new k(this.f16206a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
            c.a.q0.s.s.c cVar = new c.a.q0.s.s.c(this.f16206a.getPageContext());
            cVar.l(R.string.add_image_water);
            this.f16215j = cVar;
            cVar.k(this.o, this.s);
            cVar.c();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f16206a.getLayoutMode().k(i2 == 1);
            this.f16206a.getLayoutMode().j(this.f16207b);
            this.f16208c.onChangeSkinType(getPageContext(), i2);
            this.f16213h.onChangeSkinType(this.f16206a.getPageContext(), i2);
            c.a.q0.s.s.c cVar = this.f16214i;
            if (cVar != null) {
                cVar.g();
            }
            c.a.q0.s.s.c cVar2 = this.f16215j;
            if (cVar2 != null) {
                cVar2.g();
            }
            c.a.q0.s.s.c cVar3 = this.k;
            if (cVar3 != null) {
                cVar3.g();
            }
            c.a.q0.s.s.c cVar4 = this.l;
            if (cVar4 != null) {
                cVar4.g();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = new c.a.q0.s.s.c(this.f16206a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new k(this.f16206a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
            this.m.add(new k(this.f16206a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
            this.m.add(new k(this.f16206a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
            this.m.add(new k(this.f16206a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
            this.k.l(R.string.font_size);
            this.k.k(this.m, this.t);
            this.k.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.n = new ArrayList<>();
            int e2 = c.a.q0.s.k.c().e();
            boolean g2 = c.a.q0.s.k.c().g();
            boolean z = false;
            this.n.add(new k(this.f16206a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.f16206a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
            this.n.add(new k(this.f16206a.getPageContext().getString(R.string.view_high), this.f16206a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
            ArrayList<k> arrayList = this.n;
            String string = this.f16206a.getPageContext().getString(R.string.view_low);
            String string2 = this.f16206a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
            if (g2 && e2 == 2) {
                z = true;
            }
            arrayList.add(new k(string, string2, z));
            c.a.q0.s.s.c cVar = new c.a.q0.s.s.c(this.f16206a.getPageContext());
            this.f16214i = cVar;
            cVar.l(R.string.browser_image_quality);
            c.a.q0.s.s.c cVar2 = this.f16214i;
            cVar2.k(this.n, this.r);
            cVar2.c();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16209d.setOnClickListener(this.f16206a);
            this.f16210e.setOnClickListener(this.f16206a);
            this.f16211f.setOnClickListener(this.f16206a);
            this.f16212g.setOnClickListener(this.f16206a);
            this.q.setOnClickListener(this.f16206a);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.l = new c.a.q0.s.s.c(this.f16206a.getPageContext());
            this.p = new ArrayList<>();
            int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
            this.p.add(new k(this.f16206a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
            this.p.add(new k(this.f16206a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
            this.p.add(new k(this.f16206a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
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
            this.f16215j.n();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            p();
            this.k.n();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            q();
            this.f16214i.n();
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
            D(c.a.q0.s.k.c().b());
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            B();
            x();
            A();
            J();
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
