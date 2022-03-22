package c.a.p0.p3.c;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.l;
import c.a.o0.r.t.n;
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
/* loaded from: classes2.dex */
public class c extends c.a.d.a.d<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BrowseSettingActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f16951b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f16952c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f16953d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f16954e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f16955f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f16956g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f16957h;
    public c.a.o0.r.t.e i;
    public c.a.o0.r.t.e j;
    public c.a.o0.r.t.e k;
    public c.a.o0.r.t.e l;
    public ArrayList<n> m;
    public ArrayList<n> n;
    public ArrayList<n> o;
    public ArrayList<n> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                c.a.o0.r.j0.b.k().w("slide_local_switch_is_clicked", 1);
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

    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.i.h(i);
                if (i == 0) {
                    l.c().j(true);
                    l.c().k(0);
                } else if (i == 1) {
                    l.c().j(true);
                    l.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i == 2) {
                    l.c().j(true);
                    l.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i == 3) {
                    l.c().j(false);
                }
                this.a.i.d();
                this.a.E();
            }
        }
    }

    /* renamed from: c.a.p0.p3.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1272c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1272c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j.h(i);
                int i2 = 0;
                if (i == 0) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                    i2 = 1;
                } else if (i == 1) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                    i2 = 2;
                } else if (i == 2) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(this.a.a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                l.c().i(i2);
                this.a.F(i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.k.h(i);
                if (i == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.a.D();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.l.h(i);
                if (i == 0) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
                } else if (i == 1) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
                } else if (i == 2) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
                }
                this.a.G();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f16951b = null;
        this.f16952c = null;
        this.f16953d = null;
        this.f16954e = null;
        this.f16955f = null;
        this.f16956g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.r = new b(this);
        this.s = new C1272c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.a = browseSettingActivity;
        u();
        B();
        t();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            F(l.c().b());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            E();
            A();
            D();
            G();
            C();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f16955f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f062d));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f16955f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f062a));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f16955f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f062b));
            } else {
                this.f16955f.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f062c));
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!l.c().g()) {
                this.f16953d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f03e1));
            } else if (l.c().e() == 1) {
                this.f16953d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f14fd));
            } else if (l.c().e() == 2) {
                this.f16953d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1504));
            } else {
                this.f16953d.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f1500));
            }
        }
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i == 0) {
                this.f16954e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08b6));
            } else if (i == 1) {
                this.f16954e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08b7));
            } else if (i != 2) {
            } else {
                this.f16954e.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f08b5));
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
                this.f16956g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f14c6));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
                this.f16956g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f03e1));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
                this.f16956g.setTip(this.mContext.getString(R.string.obfuscated_res_0x7f0f14c5));
            }
        }
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16954e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16955f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f16953d : (TbSettingTextTipView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f16951b);
            this.f16952c.onChangeSkinType(getPageContext(), i);
            this.f16957h.c(this.a.getPageContext(), i);
            c.a.o0.r.t.e eVar = this.i;
            if (eVar != null) {
                eVar.g();
            }
            c.a.o0.r.t.e eVar2 = this.j;
            if (eVar2 != null) {
                eVar2.g();
            }
            c.a.o0.r.t.e eVar3 = this.k;
            if (eVar3 != null) {
                eVar3.g();
            }
            c.a.o0.r.t.e eVar4 = this.l;
            if (eVar4 != null) {
                eVar4.g();
            }
        }
    }

    public TbSettingTextTipView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f16956g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o = new ArrayList<>();
            int b2 = l.c().b();
            this.o.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08b7), (String) null, b2 == 1));
            this.o.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08b5), (String) null, b2 == 2));
            this.o.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08b6), (String) null, b2 == 0));
            c.a.o0.r.t.e eVar = new c.a.o0.r.t.e(this.a.getPageContext());
            eVar.l(R.string.obfuscated_res_0x7f0f00c8);
            this.j = eVar;
            eVar.k(this.o, this.s);
            eVar.c();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k = new c.a.o0.r.t.e(this.a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062d), (String) null, fontSize == 0));
            this.m.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062a), (String) null, fontSize == 1));
            this.m.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062b), (String) null, fontSize == 2));
            this.m.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f062c), (String) null, fontSize == 3));
            this.k.l(R.string.obfuscated_res_0x7f0f0629);
            this.k.k(this.m, this.t);
            this.k.c();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = new ArrayList<>();
            int e2 = l.c().e();
            boolean g2 = l.c().g();
            boolean z = false;
            this.n.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1500), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1501), g2 && e2 == 0));
            this.n.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f14fd), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1502), g2 && e2 == 1));
            ArrayList<n> arrayList = this.n;
            String string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1504);
            String string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1503);
            if (g2 && e2 == 2) {
                z = true;
            }
            arrayList.add(new n(string, string2, z));
            c.a.o0.r.t.e eVar = new c.a.o0.r.t.e(this.a.getPageContext());
            this.i = eVar;
            eVar.l(R.string.obfuscated_res_0x7f0f0335);
            c.a.o0.r.t.e eVar2 = this.i;
            eVar2.k(this.n, this.r);
            eVar2.c();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f16953d.setOnClickListener(this.a);
            this.f16954e.setOnClickListener(this.a);
            this.f16955f.setOnClickListener(this.a);
            this.f16956g.setOnClickListener(this.a);
            this.q.setOnClickListener(this.a);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0162);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.f16952c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16952c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0333));
            this.q = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09075e);
            this.f16953d = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090ea2);
            this.f16954e = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090112);
            this.f16955f = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090a06);
            this.f16956g = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092312);
            if (RichTextGifViewSwitch.isOn()) {
                this.f16956g.setText(R.string.obfuscated_res_0x7f0f14cf);
            } else {
                this.f16956g.setText(R.string.obfuscated_res_0x7f0f14c4);
            }
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f091d30);
            this.f16957h = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f117f);
            this.f16957h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.f16957h.setOnSwitchStateChangeListener(new a(this));
            this.f16951b = this.a.findViewById(R.id.obfuscated_res_0x7f091647);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l = new c.a.o0.r.t.e(this.a.getPageContext());
            this.p = new ArrayList<>();
            int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
            this.p.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c5), (String) null, homePageAutoPlay == 2));
            this.p.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c6), (String) null, homePageAutoPlay == 0));
            this.p.add(new n(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f03e1), (String) null, homePageAutoPlay == 1));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.obfuscated_res_0x7f0f14cf);
            } else {
                this.l.l(R.string.obfuscated_res_0x7f0f14c4);
            }
            this.l.k(this.p, this.u);
            this.l.c();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.j.n();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            r();
            this.k.n();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            s();
            this.i.n();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            v();
            this.l.n();
        }
    }
}
