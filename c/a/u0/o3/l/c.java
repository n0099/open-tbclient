package c.a.u0.o3.l;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.t.l;
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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.setting.more.BrowseSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends c.a.d.a.d<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BrowseSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f20132b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f20133c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f20134d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f20135e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f20136f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f20137g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f20138h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.s.t.d f20139i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.s.t.d f20140j;
    public c.a.t0.s.t.d k;
    public c.a.t0.s.t.d l;
    public ArrayList<l> m;
    public ArrayList<l> n;
    public ArrayList<l> o;
    public ArrayList<l> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes8.dex */
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
                c.a.t0.s.j0.b.k().w("slide_local_switch_is_clicked", 1);
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

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20141e;

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
            this.f20141e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f20141e.f20139i.h(i2);
                if (i2 == 0) {
                    c.a.t0.s.l.c().j(true);
                    c.a.t0.s.l.c().k(0);
                } else if (i2 == 1) {
                    c.a.t0.s.l.c().j(true);
                    c.a.t0.s.l.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i2 == 2) {
                    c.a.t0.s.l.c().j(true);
                    c.a.t0.s.l.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i2 == 3) {
                    c.a.t0.s.l.c().j(false);
                }
                this.f20141e.f20139i.d();
                this.f20141e.B();
            }
        }
    }

    /* renamed from: c.a.u0.o3.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1240c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20142e;

        public C1240c(c cVar) {
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
            this.f20142e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f20142e.f20140j.h(i2);
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
                setImageWatermarkTypeReqMsg.setTag(this.f20142e.a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                c.a.t0.s.l.c().i(i3);
                this.f20142e.C(i3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20143e;

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
            this.f20143e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f20143e.k.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i2 == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.f20143e.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20144e;

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
            this.f20144e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f20144e.l.h(i2);
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
                this.f20144e.D();
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
        this.f20132b = null;
        this.f20133c = null;
        this.f20134d = null;
        this.f20135e = null;
        this.f20136f = null;
        this.f20137g = null;
        this.f20139i = null;
        this.f20140j = null;
        this.k = null;
        this.l = null;
        this.r = new b(this);
        this.s = new C1240c(this);
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
                this.f20136f.setTip(this.mContext.getString(c.a.u0.o3.g.font_size_xlarge));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f20136f.setTip(this.mContext.getString(c.a.u0.o3.g.font_size_big));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f20136f.setTip(this.mContext.getString(c.a.u0.o3.g.font_size_mid));
            } else {
                this.f20136f.setTip(this.mContext.getString(c.a.u0.o3.g.font_size_small));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!c.a.t0.s.l.c().g()) {
                this.f20134d.setTip(this.mContext.getString(c.a.u0.o3.g.close));
            } else if (c.a.t0.s.l.c().e() == 1) {
                this.f20134d.setTip(this.mContext.getString(c.a.u0.o3.g.view_high));
            } else if (c.a.t0.s.l.c().e() == 2) {
                this.f20134d.setTip(this.mContext.getString(c.a.u0.o3.g.view_low));
            } else {
                this.f20134d.setTip(this.mContext.getString(c.a.u0.o3.g.view_image_quality_auto_menu));
            }
        }
    }

    public final void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                this.f20135e.setTip(this.mContext.getString(c.a.u0.o3.g.image_water_show_none));
            } else if (i2 == 1) {
                this.f20135e.setTip(this.mContext.getString(c.a.u0.o3.g.image_water_show_user_name));
            } else if (i2 != 2) {
            } else {
                this.f20135e.setTip(this.mContext.getString(c.a.u0.o3.g.image_water_show_forum_name));
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
                this.f20137g.setTip(this.mContext.getString(c.a.u0.o3.g.video_auto_play_in_wifi));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
                this.f20137g.setTip(this.mContext.getString(c.a.u0.o3.g.close));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
                this.f20137g.setTip(this.mContext.getString(c.a.u0.o3.g.video_auto_play_always));
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(c.a.u0.o3.f.browse_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(c.a.u0.o3.e.view_navigation_bar);
            this.f20133c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20133c.setTitleText(this.a.getPageContext().getString(c.a.u0.o3.g.browse_setting));
            this.q = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.debug_tool_entrance);
            this.f20134d = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.img_browser);
            this.f20135e = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.add_img_water);
            this.f20136f = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.font_size);
            this.f20137g = (TbSettingTextTipView) this.a.findViewById(c.a.u0.o3.e.video_auto_play);
            if (RichTextGifViewSwitch.isOn()) {
                this.f20137g.setText(c.a.u0.o3.g.video_gif_auto_play);
            } else {
                this.f20137g.setText(c.a.u0.o3.g.video_auto_play);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(c.a.u0.o3.e.slide_anim_switch);
            this.f20138h = msgSettingItemView;
            msgSettingItemView.setText(c.a.u0.o3.g.slide_anim_switch);
            this.f20138h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.f20138h.setOnSwitchStateChangeListener(new a(this));
            this.f20132b = this.a.findViewById(c.a.u0.o3.e.parent);
        }
    }

    public TbSettingTextTipView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20135e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20136f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20134d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f20137g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o = new ArrayList<>();
            int b2 = c.a.t0.s.l.c().b();
            this.o.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.image_water_show_user_name), (String) null, b2 == 1));
            this.o.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.image_water_show_forum_name), (String) null, b2 == 2));
            this.o.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.image_water_show_none), (String) null, b2 == 0));
            c.a.t0.s.t.d dVar = new c.a.t0.s.t.d(this.a.getPageContext());
            dVar.l(c.a.u0.o3.g.add_image_water);
            this.f20140j = dVar;
            dVar.k(this.o, this.s);
            dVar.c();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f20132b);
            this.f20133c.onChangeSkinType(getPageContext(), i2);
            this.f20138h.onChangeSkinType(this.a.getPageContext(), i2);
            c.a.t0.s.t.d dVar = this.f20139i;
            if (dVar != null) {
                dVar.g();
            }
            c.a.t0.s.t.d dVar2 = this.f20140j;
            if (dVar2 != null) {
                dVar2.g();
            }
            c.a.t0.s.t.d dVar3 = this.k;
            if (dVar3 != null) {
                dVar3.g();
            }
            c.a.t0.s.t.d dVar4 = this.l;
            if (dVar4 != null) {
                dVar4.g();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = new c.a.t0.s.t.d(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.font_size_xlarge), (String) null, fontSize == 0));
            this.m.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.font_size_big), (String) null, fontSize == 1));
            this.m.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.font_size_mid), (String) null, fontSize == 2));
            this.m.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.font_size_small), (String) null, fontSize == 3));
            this.k.l(c.a.u0.o3.g.font_size);
            this.k.k(this.m, this.t);
            this.k.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.n = new ArrayList<>();
            int e2 = c.a.t0.s.l.c().e();
            boolean g2 = c.a.t0.s.l.c().g();
            boolean z = false;
            this.n.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.view_image_quality_auto_menu), this.a.getPageContext().getString(c.a.u0.o3.g.view_image_quality_auto_menu_desc), g2 && e2 == 0));
            this.n.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.view_high), this.a.getPageContext().getString(c.a.u0.o3.g.view_image_quality_high_menu_desc), g2 && e2 == 1));
            ArrayList<l> arrayList = this.n;
            String string = this.a.getPageContext().getString(c.a.u0.o3.g.view_low);
            String string2 = this.a.getPageContext().getString(c.a.u0.o3.g.view_image_quality_low_menu_desc);
            if (g2 && e2 == 2) {
                z = true;
            }
            arrayList.add(new l(string, string2, z));
            c.a.t0.s.t.d dVar = new c.a.t0.s.t.d(this.a.getPageContext());
            this.f20139i = dVar;
            dVar.l(c.a.u0.o3.g.browser_image_quality);
            c.a.t0.s.t.d dVar2 = this.f20139i;
            dVar2.k(this.n, this.r);
            dVar2.c();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f20134d.setOnClickListener(this.a);
            this.f20135e.setOnClickListener(this.a);
            this.f20136f.setOnClickListener(this.a);
            this.f20137g.setOnClickListener(this.a);
            this.q.setOnClickListener(this.a);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.l = new c.a.t0.s.t.d(this.a.getPageContext());
            this.p = new ArrayList<>();
            int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
            this.p.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.video_auto_play_always), (String) null, homePageAutoPlay == 2));
            this.p.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
            this.p.add(new l(this.a.getPageContext().getString(c.a.u0.o3.g.close), (String) null, homePageAutoPlay == 1));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(c.a.u0.o3.g.video_gif_auto_play);
            } else {
                this.l.l(c.a.u0.o3.g.video_auto_play);
            }
            this.l.k(this.p, this.u);
            this.l.c();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            o();
            this.f20140j.n();
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
            this.f20139i.n();
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
            C(c.a.t0.s.l.c().b());
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
