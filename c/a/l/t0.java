package c.a.l;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class t0 extends c.a.l.a<c.a.s0.s.q.a> implements c.a.t0.z2.e {
    public static /* synthetic */ Interceptable $ic;
    public static int A;
    public static int B;
    public static final int x;
    public static int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public View f4298j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f4299k;
    public c.a.s0.s.q.a l;
    public RoundCornerFrameLayout m;
    public c.a.t0.z2.v.a n;
    public String o;
    public String p;
    public BdUniqueId q;
    public int r;
    public boolean s;
    public View.OnClickListener t;
    public final View.OnClickListener u;
    public final View.OnClickListener v;
    public a.b w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f4300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f4301f;

        public a(t0 t0Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4301f = t0Var;
            this.f4300e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.s.q.a aVar = this.f4301f.l;
                if (aVar != null && aVar.getThreadData().t1().is_vertical.intValue() != 1) {
                    this.f4300e.width = this.f4301f.f4298j.getWidth();
                    this.f4300e.height = (this.f4301f.f4298j.getWidth() / 16) * 9;
                }
                this.f4301f.m.setLayoutParams(this.f4300e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f4302e;

        public b(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4302e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.s0.s.q.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f4302e.l) == null || aVar.getThreadData() == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f4302e.m);
            t0 t0Var = this.f4302e;
            c.a.s0.e1.y.c(false, t0Var.f4211f, t0Var.l.getThreadData(), 0, computeViewArea, "from_nani_video", "personalize_page", "", this.f4302e.o, this.f4302e.o, this.f4302e.l.getThreadData().n);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f4303e;

        public c(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4303e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var;
            a.InterfaceC0184a interfaceC0184a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0184a = (t0Var = this.f4303e).f4214i) == null) {
                return;
            }
            interfaceC0184a.a(t0Var.l);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f4304e;

        public d(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4304e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4304e.c() == null) {
                return;
            }
            this.f4304e.c().a(view, this.f4304e.l);
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        public e(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // c.a.l.w0.a.b
        public boolean a(a.C0186a c0186a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0186a)) == null) {
                if (c0186a.b() == 1) {
                    t0 t0Var = this.a;
                    c.a.t0.g0.m.l(t0Var.f4299k, t0Var.l.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (c0186a.b() == 2) {
                    c.a.t0.z2.v.a aVar = this.a.n;
                    if (aVar != null) {
                        aVar.onScroll();
                        return false;
                    }
                    return false;
                } else if (c0186a.b() == 3) {
                    c.a.t0.z2.v.a aVar2 = this.a.n;
                    if (aVar2 != null) {
                        aVar2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (c0186a.b() == 6) {
                    c.a.t0.z2.v.a aVar3 = this.a.n;
                    if (aVar3 != null) {
                        return aVar3.onBackPress();
                    }
                    return false;
                } else if (c0186a.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.a.m;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.onRootPressed(((Boolean) c0186a.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (c0186a.b() == 8 && this.a.n != null && (c0186a.c() instanceof Boolean)) {
                    return this.a.n.onBackground(((Boolean) c0186a.c()).booleanValue());
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343551926, "Lc/a/l/t0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343551926, "Lc/a/l/t0;");
                return;
            }
        }
        x = (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k2 = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
        y = k2;
        int i2 = k2 - x;
        z = i2;
        A = (i2 / 2) * 3;
        B = i2 / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = 0;
        this.s = false;
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
        this.w = new e(this);
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f4298j == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().l != null && TbadkCoreApplication.getInst().getPersonalizeViewData().l.getParent() == null) {
                    this.f4298j = TbadkCoreApplication.getInst().getPersonalizeViewData().l;
                } else {
                    this.f4298j = LayoutInflater.from(this.f4211f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                }
                this.f4299k = (TextView) this.f4298j.findViewById(R.id.video_seg_title);
                this.m = (RoundCornerFrameLayout) this.f4298j.findViewById(R.id.frame_video);
                c.a.t0.z2.v.a p = p();
                this.n = p;
                p.setUniqueId(this.q);
                this.n.setFrom(this.o);
                this.n.setStageType(this.p);
            }
            return this.f4298j;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(1, this.w);
            h(2, this.w);
            h(3, this.w);
            h(6, this.w);
            h(7, this.w);
            h(8, this.w);
        }
    }

    @Override // c.a.t0.z2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n.getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.t0.z2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.s.q.a aVar = this.l;
            if (aVar == null || aVar.getThreadData() == null) {
                return null;
            }
            return this.l.getThreadData().getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.t0.z2.v.a aVar = this.n;
            if (aVar == null) {
                return false;
            }
            return aVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n.isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.t0.z2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n.isPlaying() : invokeV.booleanValue;
    }

    public c.a.t0.z2.v.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (c.a.t0.z2.v.a) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        c.a.s0.s.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i2) == null) || (aVar = this.l) == null || aVar.getThreadData() == null) {
            return;
        }
        c.a.t0.g0.m.l(this.f4299k, this.l.getThreadData().g0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.onChangeSkinType(i2);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public abstract c.a.t0.z2.v.a p();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0 = c.a.s0.b.g.b.o(r11, r8, r10.n, r0, r1);
     */
    @Override // c.a.l.p
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(c.a.s0.s.q.a aVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            int k2 = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
            if (k2 != this.r) {
                int k3 = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
                y = k3;
                int i2 = k3 - x;
                z = i2;
                A = i2 / 2;
                B = i2 / 3;
                this.r = k2;
            }
            this.l = aVar;
            if (aVar == null || aVar.getThreadData() == null || this.l.getThreadData().t1() == null) {
                return;
            }
            this.n.setData(aVar.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = layoutParams.height;
            boolean z3 = false;
            if (this.l.getThreadData().t1().is_vertical.intValue() == 1) {
                int i5 = (A / 9) * 16;
                int i6 = B;
                int intValue = this.l.getThreadData().t1().video_width.intValue();
                int intValue2 = this.l.getThreadData().t1().video_height.intValue();
                int i7 = A;
                layoutParams.width = i7;
                boolean z4 = i3 != i7;
                if (intValue != 0 && intValue2 != 0) {
                    int i8 = (int) (((intValue2 * 1.0f) / intValue) * A);
                    if (i8 < i6) {
                        i5 = i6;
                    } else if (i8 <= i5) {
                        i5 = i8;
                    }
                    layoutParams.height = i5;
                } else {
                    layoutParams.height = i5;
                }
            } else {
                int i9 = z;
                layoutParams.width = i9;
                int i10 = (i9 / 16) * 9;
                layoutParams.height = i10;
                z2 = (i4 == i10 && i3 == i9) ? false : true;
            }
            if (z2) {
                if (this.l.getThreadData().t1().is_vertical.intValue() == 1) {
                    this.m.setLayoutParams(layoutParams);
                } else {
                    this.m.post(new a(this, layoutParams));
                }
            }
            if (this.l.getThreadData().R1()) {
                this.f4299k.setMaxLines(5);
                ThreadCardUtils.setTitle(this.f4299k, this.l.getThreadData(), z, this.s);
            } else {
                this.f4299k.setMaxLines(2);
                ThreadCardUtils.setTitle(this.f4299k, this.l.getThreadData(), z, 2, this.s);
            }
            TextView textView = this.f4299k;
            ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.f4214i != null) {
                this.n.setJumpToPbClickListener(this.u);
            }
            if (c() != null) {
                this.n.setAfterClickListener(this.v);
            }
            TextView textView2 = this.f4299k;
            if (textView2 == null || this.f4298j == null) {
                return;
            }
            textView2.setOnClickListener(this.t);
            this.f4299k.setMovementMethod(LinkMovementMethod.getInstance());
            this.f4298j.setOnClickListener(this.t);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.t0.z2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Context context = this.f4211f;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.n.startPlay();
            }
        }
    }

    @Override // c.a.t0.z2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n.stopPlay();
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.o = str;
            c.a.t0.z2.v.a aVar = this.n;
            if (aVar != null) {
                aVar.setFrom(str);
            }
        }
    }

    public void u(a.InterfaceC0184a interfaceC0184a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, interfaceC0184a) == null) {
            this.f4214i = interfaceC0184a;
        }
    }

    public void v(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            this.s = z2;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.q = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.p = str;
            c.a.t0.z2.v.a aVar = this.n;
            if (aVar != null) {
                aVar.setStageType(str);
            }
        }
    }

    public void y(c.a.t0.z2.t tVar) {
        c.a.t0.z2.v.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, tVar) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.setStatistic(tVar);
    }
}
