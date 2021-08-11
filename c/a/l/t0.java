package c.a.l;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.v0.a;
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
public abstract class t0 extends c.a.l.a<c.a.o0.s.q.a> implements c.a.p0.o2.e {
    public static /* synthetic */ Interceptable $ic;
    public static int A;
    public static int B;
    public static final int x;
    public static int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public View f3627j;
    public TextView k;
    public c.a.o0.s.q.a l;
    public RoundCornerFrameLayout m;
    public c.a.p0.o2.q.a n;
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
        public final /* synthetic */ ViewGroup.LayoutParams f3628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t0 f3629f;

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
            this.f3629f = t0Var;
            this.f3628e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.s.q.a aVar = this.f3629f.l;
                if (aVar != null && aVar.getThreadData().o1().is_vertical.intValue() != 1) {
                    this.f3628e.width = this.f3629f.f3627j.getWidth();
                    this.f3628e.height = (this.f3629f.f3627j.getWidth() / 16) * 9;
                }
                this.f3629f.m.setLayoutParams(this.f3628e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f3630e;

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
            this.f3630e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var;
            c.a.o0.s.q.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.o0.b.d.f0() && (aVar = (t0Var = this.f3630e).l) != null) {
                    c.a.o0.b1.t.a(false, t0Var.f3547f, aVar.getThreadData(), this.f3630e.o);
                } else if (c.a.o0.b.d.h0()) {
                    c.a.o0.s.q.a aVar2 = this.f3630e.l;
                    if (aVar2 == null || aVar2.getThreadData() == null) {
                        return;
                    }
                    t0 t0Var2 = this.f3630e;
                    c.a.o0.b1.t.f(false, t0Var2.f3547f, t0Var2.l.getThreadData(), 0, null, "from_nani_video", "personalize_page", "", this.f3630e.o, this.f3630e.o);
                } else {
                    t0 t0Var3 = this.f3630e;
                    a.InterfaceC0086a interfaceC0086a = t0Var3.f3550i;
                    if (interfaceC0086a != null) {
                        interfaceC0086a.a(t0Var3.l);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f3631e;

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
            this.f3631e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var;
            a.InterfaceC0086a interfaceC0086a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0086a = (t0Var = this.f3631e).f3550i) == null) {
                return;
            }
            interfaceC0086a.a(t0Var.l);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t0 f3632e;

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
            this.f3632e = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3632e.c() == null) {
                return;
            }
            this.f3632e.c().a(view, this.f3632e.l);
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f3633a;

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
            this.f3633a = t0Var;
        }

        @Override // c.a.l.v0.a.b
        public boolean a(a.C0088a c0088a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0088a)) == null) {
                if (c0088a.b() == 1) {
                    t0 t0Var = this.f3633a;
                    c.a.p0.a0.m.l(t0Var.k, t0Var.l.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (c0088a.b() == 2) {
                    c.a.p0.o2.q.a aVar = this.f3633a.n;
                    if (aVar != null) {
                        aVar.H();
                        return false;
                    }
                    return false;
                } else if (c0088a.b() == 3) {
                    c.a.p0.o2.q.a aVar2 = this.f3633a.n;
                    if (aVar2 != null) {
                        aVar2.F();
                        return false;
                    }
                    return false;
                } else if (c0088a.b() == 6) {
                    c.a.p0.o2.q.a aVar3 = this.f3633a.n;
                    if (aVar3 != null) {
                        return aVar3.C();
                    }
                    return false;
                } else if (c0088a.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.f3633a.m;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.onRootPressed(((Boolean) c0088a.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (c0088a.b() == 8 && this.f3633a.n != null && (c0088a.c() instanceof Boolean)) {
                    return this.f3633a.n.I(((Boolean) c0088a.c()).booleanValue());
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
        x = (c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
        y = k;
        int i2 = k - x;
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
            if (this.f3627j == null) {
                View inflate = LayoutInflater.from(this.f3547f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                this.f3627j = inflate;
                this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
                this.m = (RoundCornerFrameLayout) this.f3627j.findViewById(R.id.frame_video);
                c.a.p0.o2.q.a p = p();
                this.n = p;
                p.setUniqueId(this.q);
                this.n.setFrom(this.o);
                this.n.setStageType(this.p);
            }
            return this.f3627j;
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

    @Override // c.a.p0.o2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n.getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.p0.o2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.s.q.a aVar = this.l;
            if (aVar == null || aVar.getThreadData() == null) {
                return null;
            }
            return this.l.getThreadData().getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.o2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.o2.q.a aVar = this.n;
            if (aVar == null) {
                return false;
            }
            return aVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n.isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.p0.o2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n.isPlaying() : invokeV.booleanValue;
    }

    public c.a.p0.o2.q.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (c.a.p0.o2.q.a) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        c.a.o0.s.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i2) == null) || (aVar = this.l) == null || aVar.getThreadData() == null) {
            return;
        }
        c.a.p0.a0.m.l(this.k, this.l.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.onChangeSkinType(i2);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public abstract c.a.p0.o2.q.a p();

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
        r0 = c.a.o0.b.g.b.o(r11, r8, r10.n, r0, r1);
     */
    @Override // c.a.l.p
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(c.a.o0.s.q.a aVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            int k = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
            if (k != this.r) {
                int k2 = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
                y = k2;
                int i2 = k2 - x;
                z = i2;
                A = i2 / 2;
                B = i2 / 3;
                this.r = k;
            }
            this.l = aVar;
            if (aVar == null || aVar.getThreadData() == null || this.l.getThreadData().o1() == null) {
                return;
            }
            this.n.setData(aVar.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = layoutParams.height;
            boolean z3 = false;
            if (this.l.getThreadData().o1().is_vertical.intValue() == 1) {
                int i5 = (A / 9) * 16;
                int i6 = B;
                int intValue = this.l.getThreadData().o1().video_width.intValue();
                int intValue2 = this.l.getThreadData().o1().video_height.intValue();
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
                if (this.l.getThreadData().o1().is_vertical.intValue() == 1) {
                    this.m.setLayoutParams(layoutParams);
                } else {
                    this.m.post(new a(this, layoutParams));
                }
            }
            if (this.l.getThreadData().L1()) {
                this.k.setMaxLines(5);
                ThreadCardUtils.setTitle(this.k, this.l.getThreadData(), z, this.s);
            } else {
                this.k.setMaxLines(2);
                ThreadCardUtils.setTitle(this.k, this.l.getThreadData(), z, 2, this.s);
            }
            TextView textView = this.k;
            ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.f3550i != null) {
                this.n.M(this.u);
            }
            if (c() != null) {
                this.n.setAfterClickListener(this.v);
            }
            TextView textView2 = this.k;
            if (textView2 == null || this.f3627j == null) {
                return;
            }
            textView2.setOnClickListener(this.t);
            this.k.setMovementMethod(LinkMovementMethod.getInstance());
            this.f3627j.setOnClickListener(this.t);
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

    @Override // c.a.p0.o2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Context context = this.f3547f;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.n.startPlay();
            }
        }
    }

    @Override // c.a.p0.o2.e
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
            c.a.p0.o2.q.a aVar = this.n;
            if (aVar != null) {
                aVar.setFrom(str);
            }
        }
    }

    public void u(a.InterfaceC0086a interfaceC0086a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, interfaceC0086a) == null) {
            this.f3550i = interfaceC0086a;
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
            c.a.p0.o2.q.a aVar = this.n;
            if (aVar != null) {
                aVar.setStageType(str);
            }
        }
    }

    public void y(c.a.p0.o2.o oVar) {
        c.a.p0.o2.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, oVar) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.G(oVar);
    }
}
