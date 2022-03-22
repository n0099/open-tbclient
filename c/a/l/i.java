package c.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends c.a.l.a<c.a.o0.r.r.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f3425f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f3426g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.r.a f3427h;
    public RoundCornerFrameLayout i;
    public FakeVideoContainer j;
    public int k;
    public boolean l;
    public a.b m;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f3428b;

        public a(i iVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3428b = iVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.width = this.f3428b.f3425f.getWidth();
                this.a.height = (this.f3428b.f3425f.getWidth() / 16) * 9;
                this.f3428b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.l.w0.a.b
        public boolean a(a.C0196a c0196a) {
            InterceptResult invokeL;
            RoundCornerFrameLayout roundCornerFrameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0196a)) == null) {
                if (c0196a.b() != 7 || (roundCornerFrameLayout = this.a.i) == null) {
                    return false;
                }
                roundCornerFrameLayout.d(((Boolean) c0196a.c()).booleanValue());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896322597, "Lc/a/l/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896322597, "Lc/a/l/i;");
                return;
            }
        }
        n = (c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
        o = k;
        int i = k - n;
        p = i;
        q = i / 2;
        r = i / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context) {
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
        this.k = 0;
        this.l = false;
        this.m = new b(this);
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f3425f == null) {
                View inflate = LayoutInflater.from(this.f3392b).inflate(R.layout.obfuscated_res_0x7f0d01c7, (ViewGroup) null, true);
                this.f3425f = inflate;
                this.f3426g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092375);
                this.i = (RoundCornerFrameLayout) this.f3425f.findViewById(R.id.obfuscated_res_0x7f090aaf);
                FakeVideoContainer fakeVideoContainer = new FakeVideoContainer(this.f3392b);
                this.j = fakeVideoContainer;
                fakeVideoContainer.setBackgroundResource(R.color.transparent);
                this.i.addView(this.j);
            }
            return this.f3425f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i(7, this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
        if (r1 != r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (r1 != r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, null, r0, r1);
     */
    @Override // c.a.l.p
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c.a.o0.r.r.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            int k = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
            if (k != this.k) {
                int k2 = c.a.d.f.p.n.k(TbadkCoreApplication.getInst());
                o = k2;
                int i = k2 - n;
                p = i;
                q = i / 2;
                r = i / 3;
                this.k = k;
            }
            this.f3427h = aVar;
            if (aVar == null || aVar.getThreadData() == null || this.f3427h.getThreadData().getThreadVideoInfo() == null) {
                return;
            }
            this.j.setData(aVar.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = layoutParams.height;
            boolean z2 = false;
            if (this.f3427h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                int i4 = (q / 9) * 16;
                int i5 = r;
                int intValue = this.f3427h.getThreadData().getThreadVideoInfo().video_width.intValue();
                int intValue2 = this.f3427h.getThreadData().getThreadVideoInfo().video_height.intValue();
                int i6 = q;
                layoutParams.width = i6;
                boolean z3 = i2 != i6;
                if (intValue != 0 && intValue2 != 0) {
                    int i7 = (int) (((intValue2 * 1.0f) / intValue) * q);
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
                int i8 = p;
                layoutParams.width = i8;
                int i9 = (i8 / 16) * 9;
                layoutParams.height = i9;
                z = (i3 == i9 && i2 == i8) ? false : true;
            }
            if (z) {
                if (this.f3427h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    this.i.setLayoutParams(layoutParams);
                } else {
                    this.i.post(new a(this, layoutParams));
                }
            }
            if (!this.f3427h.getThreadData().isBJHVideoDynamicThreadType() && this.f3427h.getThreadData().getType() != ThreadData.TYPE_FAKE_VIDEO) {
                this.f3426g.setMaxLines(2);
                ThreadCardUtils.setTitle(this.f3426g, this.f3427h.getThreadData(), 0, this.l);
            } else {
                this.f3426g.setMaxLines(5);
                ThreadCardUtils.setTitle(this.f3426g, this.f3427h.getThreadData(), p, this.l);
            }
            TextView textView = this.f3426g;
            ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        c.a.o0.r.r.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) || (aVar = this.f3427h) == null || aVar.getThreadData() == null) {
            return;
        }
        c.a.p0.h0.m.l(this.f3426g, this.f3427h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.i.c(i);
        this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.l = z;
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
        }
    }
}
