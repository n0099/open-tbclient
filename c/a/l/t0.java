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
import com.baidu.tbadk.core.data.ThreadData;
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
public abstract class t0 extends c.a.l.a<c.a.o0.r.r.a> implements c.a.p0.c3.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f3482f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f3483g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.r.a f3484h;
    public RoundCornerFrameLayout i;
    public c.a.p0.c3.w.a j;
    public String k;
    public String l;
    public BdUniqueId m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final View.OnClickListener q;
    public final View.OnClickListener r;
    public a.b s;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t0 f3485b;

        public a(t0 t0Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3485b = t0Var;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.r.r.a aVar = this.f3485b.f3484h;
                if (aVar != null && aVar.getThreadData().getThreadVideoInfo().is_vertical.intValue() != 1) {
                    this.a.width = this.f3485b.f3482f.getWidth();
                    this.a.height = (this.f3485b.f3482f.getWidth() / 16) * 9;
                }
                this.f3485b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        public b(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.o0.r.r.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.a.f3484h) == null || aVar.getThreadData() == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.i);
            t0 t0Var = this.a;
            Context context = t0Var.f3392b;
            ThreadData threadData = t0Var.f3484h.getThreadData();
            t0 t0Var2 = this.a;
            String str = t0Var2.k;
            c.a.o0.c1.x.c(false, context, threadData, 0, computeViewArea, "from_nani_video", "personalize_page", "", str, str, t0Var2.f3484h.getThreadData().isJumpToFrsVideoTabPlay);
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        public c(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t0 t0Var;
            a.InterfaceC0194a interfaceC0194a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0194a = (t0Var = this.a).f3395e) == null) {
                return;
            }
            interfaceC0194a.a(t0Var.f3484h);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        public d(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.d() == null) {
                return;
            }
            this.a.d().a(view, this.a.f3484h);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // c.a.l.w0.a.b
        public boolean a(a.C0196a c0196a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0196a)) == null) {
                if (c0196a.b() == 1) {
                    t0 t0Var = this.a;
                    c.a.p0.h0.m.l(t0Var.f3483g, t0Var.f3484h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (c0196a.b() == 2) {
                    c.a.p0.c3.w.a aVar = this.a.j;
                    if (aVar != null) {
                        aVar.onScroll();
                        return false;
                    }
                    return false;
                } else if (c0196a.b() == 3) {
                    c.a.p0.c3.w.a aVar2 = this.a.j;
                    if (aVar2 != null) {
                        aVar2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (c0196a.b() == 6) {
                    c.a.p0.c3.w.a aVar3 = this.a.j;
                    if (aVar3 != null) {
                        return aVar3.onBackPress();
                    }
                    return false;
                } else if (c0196a.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.a.i;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.d(((Boolean) c0196a.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (c0196a.b() == 8 && this.a.j != null && (c0196a.c() instanceof Boolean)) {
                    return this.a.j.onBackground(((Boolean) c0196a.c()).booleanValue());
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
        t = (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
        u = k;
        int i = k - t;
        v = i;
        w = (i / 2) * 3;
        x = i / 3;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.o = false;
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f3482f == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().k != null && TbadkCoreApplication.getInst().getPersonalizeViewData().k.getParent() == null) {
                    this.f3482f = TbadkCoreApplication.getInst().getPersonalizeViewData().k;
                } else {
                    this.f3482f = LayoutInflater.from(this.f3392b).inflate(R.layout.obfuscated_res_0x7f0d01c7, (ViewGroup) null, true);
                }
                this.f3483g = (TextView) this.f3482f.findViewById(R.id.obfuscated_res_0x7f092375);
                this.i = (RoundCornerFrameLayout) this.f3482f.findViewById(R.id.obfuscated_res_0x7f090aaf);
                c.a.p0.c3.w.a p = p();
                this.j = p;
                p.setUniqueId(this.m);
                this.j.setFrom(this.k);
                this.j.setStageType(this.l);
            }
            return this.f3482f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.c3.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j.getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.p0.c3.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.o0.r.r.a aVar = this.f3484h;
            if (aVar == null || aVar.getThreadData() == null) {
                return null;
            }
            return this.f3484h.getThreadData().getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.c3.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i(1, this.s);
            i(2, this.s);
            i(3, this.s);
            i(6, this.s);
            i(7, this.s);
            i(8, this.s);
        }
    }

    @Override // c.a.p0.c3.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.p0.c3.w.a aVar = this.j;
            if (aVar == null) {
                return false;
            }
            return aVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    public c.a.p0.c3.w.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (c.a.p0.c3.w.a) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        c.a.o0.r.r.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i) == null) || (aVar = this.f3484h) == null || aVar.getThreadData() == null) {
            return;
        }
        c.a.p0.h0.m.l(this.f3483g, this.f3484h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.i.c(i);
        this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public abstract c.a.p0.c3.w.a p();

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
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, r10.j, r0, r1);
     */
    @Override // c.a.l.p
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c.a.o0.r.r.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
            if (k != this.n) {
                int k2 = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
                u = k2;
                int i = k2 - t;
                v = i;
                w = i / 2;
                x = i / 3;
                this.n = k;
            }
            this.f3484h = aVar;
            if (aVar == null || aVar.getThreadData() == null || this.f3484h.getThreadData().getThreadVideoInfo() == null) {
                return;
            }
            this.j.setData(aVar.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = layoutParams.height;
            boolean z2 = false;
            if (this.f3484h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                int i4 = (w / 9) * 16;
                int i5 = x;
                int intValue = this.f3484h.getThreadData().getThreadVideoInfo().video_width.intValue();
                int intValue2 = this.f3484h.getThreadData().getThreadVideoInfo().video_height.intValue();
                int i6 = w;
                layoutParams.width = i6;
                boolean z3 = i2 != i6;
                if (intValue != 0 && intValue2 != 0) {
                    int i7 = (int) (((intValue2 * 1.0f) / intValue) * w);
                    if (i7 < i5) {
                        i4 = i5;
                    } else if (i7 <= i4) {
                        i4 = i7;
                    }
                    layoutParams.height = i4;
                } else {
                    layoutParams.height = i4;
                }
            } else {
                int i8 = v;
                layoutParams.width = i8;
                int i9 = (i8 / 16) * 9;
                layoutParams.height = i9;
                z = (i3 == i9 && i2 == i8) ? false : true;
            }
            if (z) {
                if (this.f3484h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    this.i.setLayoutParams(layoutParams);
                } else {
                    this.i.post(new a(this, layoutParams));
                }
            }
            if (this.f3484h.getThreadData().isBJHVideoDynamicThreadType()) {
                this.f3483g.setMaxLines(5);
                ThreadCardUtils.setTitle(this.f3483g, this.f3484h.getThreadData(), v, this.o);
            } else {
                this.f3483g.setMaxLines(2);
                ThreadCardUtils.setTitle(this.f3483g, this.f3484h.getThreadData(), v, 2, this.o);
            }
            TextView textView = this.f3483g;
            ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.f3395e != null) {
                this.j.setJumpToPbClickListener(this.q);
            }
            if (d() != null) {
                this.j.setAfterClickListener(this.r);
            }
            TextView textView2 = this.f3483g;
            if (textView2 == null || this.f3482f == null) {
                return;
            }
            textView2.setOnClickListener(this.p);
            this.f3483g.setMovementMethod(LinkMovementMethod.getInstance());
            this.f3482f.setOnClickListener(this.p);
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

    @Override // c.a.p0.c3.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Context context = this.f3392b;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.j.startPlay();
            }
        }
    }

    @Override // c.a.p0.c3.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.j.stopPlay();
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.k = str;
            c.a.p0.c3.w.a aVar = this.j;
            if (aVar != null) {
                aVar.setFrom(str);
            }
        }
    }

    public void u(a.InterfaceC0194a interfaceC0194a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, interfaceC0194a) == null) {
            this.f3395e = interfaceC0194a;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.l = str;
            c.a.p0.c3.w.a aVar = this.j;
            if (aVar != null) {
                aVar.setStageType(str);
            }
        }
    }

    public void y(c.a.p0.c3.u uVar) {
        c.a.p0.c3.w.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, uVar) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.setStatistic(uVar);
    }
}
