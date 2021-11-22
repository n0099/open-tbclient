package b.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.l.w0.a;
import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class i extends b.a.l.a<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public TextView k;
    public b.a.q0.s.q.a l;
    public RoundCornerFrameLayout m;
    public FakeVideoContainer n;
    public int o;
    public boolean p;
    public a.b q;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f3324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f3325f;

        public a(i iVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3325f = iVar;
            this.f3324e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3324e.width = this.f3325f.j.getWidth();
                this.f3324e.height = (this.f3325f.j.getWidth() / 16) * 9;
                this.f3325f.m.setLayoutParams(this.f3324e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f3326a;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3326a = iVar;
        }

        @Override // b.a.l.w0.a.b
        public boolean a(a.C0092a c0092a) {
            InterceptResult invokeL;
            RoundCornerFrameLayout roundCornerFrameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c0092a)) == null) {
                if (c0092a.b() != 7 || (roundCornerFrameLayout = this.f3326a.m) == null) {
                    return false;
                }
                roundCornerFrameLayout.onRootPressed(((Boolean) c0092a.c()).booleanValue());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(655834364, "Lb/a/l/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(655834364, "Lb/a/l/i;");
                return;
            }
        }
        r = (b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = b.a.e.f.p.l.k(TbadkCoreApplication.getInst());
        s = k;
        int i2 = k - r;
        t = i2;
        u = i2 / 2;
        v = i2 / 3;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = false;
        this.q = new b(this);
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                View inflate = LayoutInflater.from(this.f3307f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                this.j = inflate;
                this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
                this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
                FakeVideoContainer fakeVideoContainer = new FakeVideoContainer(this.f3307f);
                this.n = fakeVideoContainer;
                fakeVideoContainer.setBackgroundResource(R.color.transparent);
                this.m.addView(this.n);
            }
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h(7, this.q);
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
        r0 = b.a.q0.b.g.b.o(r11, r8, null, r0, r1);
     */
    @Override // b.a.l.p
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            int k = b.a.e.f.p.l.k(TbadkCoreApplication.getInst());
            if (k != this.o) {
                int k2 = b.a.e.f.p.l.k(TbadkCoreApplication.getInst());
                s = k2;
                int i2 = k2 - r;
                t = i2;
                u = i2 / 2;
                v = i2 / 3;
                this.o = k;
            }
            this.l = aVar;
            if (aVar == null || aVar.getThreadData() == null || this.l.getThreadData().r1() == null) {
                return;
            }
            this.n.setData(aVar.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = layoutParams.height;
            boolean z2 = false;
            if (this.l.getThreadData().r1().is_vertical.intValue() == 1) {
                int i5 = (u / 9) * 16;
                int i6 = v;
                int intValue = this.l.getThreadData().r1().video_width.intValue();
                int intValue2 = this.l.getThreadData().r1().video_height.intValue();
                int i7 = u;
                layoutParams.width = i7;
                boolean z3 = i3 != i7;
                if (intValue != 0 && intValue2 != 0) {
                    int i8 = (int) (((intValue2 * 1.0f) / intValue) * u);
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
                int i9 = t;
                layoutParams.width = i9;
                int i10 = (i9 / 16) * 9;
                layoutParams.height = i10;
                z = (i4 == i10 && i3 == i9) ? false : true;
            }
            if (z) {
                if (this.l.getThreadData().r1().is_vertical.intValue() == 1) {
                    this.m.setLayoutParams(layoutParams);
                } else {
                    this.m.post(new a(this, layoutParams));
                }
            }
            if (!this.l.getThreadData().Q1() && this.l.getThreadData().getType() != d2.R3) {
                this.k.setMaxLines(2);
                ThreadCardUtils.setTitle(this.k, this.l.getThreadData(), 0, this.p);
            } else {
                this.k.setMaxLines(5);
                ThreadCardUtils.setTitle(this.k, this.l.getThreadData(), t, this.p);
            }
            TextView textView = this.k;
            ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.p = z;
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        b.a.q0.s.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) || (aVar = this.l) == null || aVar.getThreadData() == null) {
            return;
        }
        b.a.r0.b0.m.l(this.k, this.l.getThreadData().f0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.onChangeSkinType(i2);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
        }
    }
}
