package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class s0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static int w;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public int m;
    public int n;
    public Context o;
    public c.a.o0.s.q.a p;
    public VideoImageNoPlayerLayout q;
    public int r;
    public String s;
    public int t;
    public c.a.l.w0.a u;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f3624e;

        public a(s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3624e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0 s0Var;
            a.InterfaceC0086a interfaceC0086a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0086a = (s0Var = this.f3624e).f3550i) == null) {
                return;
            }
            interfaceC0086a.a(s0Var.p);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.l.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f3625a;

        public b(s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3625a = s0Var;
        }

        @Override // c.a.l.w0.a
        public void a(c.a.o0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f3625a.u == null) {
                return;
            }
            this.f3625a.u.a(this.f3625a.p);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343550965, "Lc/a/l/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343550965, "Lc/a/l/s0;");
                return;
            }
        }
        v = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
        w = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(Context context) {
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
        int i4 = w;
        this.l = i4;
        this.m = i4 / 2;
        this.n = i4 / 3;
        this.r = 0;
        this.t = 3;
        this.o = context;
        this.q = new VideoImageNoPlayerLayout(context);
        m(Boolean.TRUE);
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void k(c.a.p0.a0.b0<c.a.o0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b0Var) == null) {
            super.k(b0Var);
            this.q.setOnCardSubClickListener(b0Var);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            if (this.t != i2) {
                this.q.onChangeSkinType(tbPageContext, i2);
            }
            this.t = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dc, code lost:
        if (r3 != r11.height) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e5, code lost:
        if (r3 != r11.height) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e9, code lost:
        r1 = c.a.o0.b.g.b.n(r11, r0, r2, r3, r5);
     */
    @Override // c.a.l.p
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(c.a.o0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            int k = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
            if (k != this.r) {
                w = c.a.e.e.p.l.k(TbadkCoreApplication.getInst());
                if (!"pb".equals(this.s)) {
                    this.l = w - v;
                } else {
                    this.l = w;
                }
                int i2 = this.l;
                this.m = i2 / 2;
                this.n = i2 / 3;
                this.r = k;
            }
            this.p = aVar;
            if (aVar != null && aVar.getThreadData() != null && this.p.getThreadData().v1 != null && !this.p.getThreadData().v1.m) {
                this.q.setVisibility(0);
                this.q.onBindDataToView(aVar);
                ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.q.mContainerView.getLayoutParams();
                int i3 = layoutParams.width;
                int i4 = layoutParams.height;
                boolean z = true;
                if (this.p.getThreadData().v1.r.is_vertical.intValue() == 1) {
                    VideoInfo videoInfo = this.p.getThreadData().v1.r;
                    if (videoInfo == null) {
                        return;
                    }
                    int i5 = (this.m / 9) * 16;
                    int i6 = this.n;
                    int intValue = videoInfo.video_width.intValue();
                    int intValue2 = videoInfo.video_height.intValue();
                    layoutParams.width = this.l;
                    layoutParams2.width = this.m;
                    r1 = i3 != layoutParams.width;
                    if (intValue != 0 && intValue2 != 0) {
                        int i7 = (int) (((intValue2 * 1.0f) / intValue) * this.m);
                        if (i7 < i6) {
                            i5 = i6;
                        } else if (i7 <= i5) {
                            i5 = i7;
                        }
                        layoutParams.height = i5;
                        layoutParams2.height = i5;
                    } else {
                        layoutParams.height = i5;
                        layoutParams2.height = i5;
                    }
                } else {
                    int i8 = this.l;
                    layoutParams.width = i8;
                    layoutParams2.width = i8;
                    layoutParams.height = ((i8 / 16) * 9) - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    layoutParams2.height = ((this.l / 16) * 9) - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    if (i4 != layoutParams.height || i3 != layoutParams.width) {
                        r1 = true;
                    }
                }
                if (r1) {
                    this.q.setLayoutParams(layoutParams);
                    this.q.mContainerView.setLayoutParams(layoutParams2);
                }
                this.q.setJumpToPbListener(new a(this));
                this.q.setData(this.p);
                c();
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.s = str;
        }
    }

    public void v(a.InterfaceC0086a interfaceC0086a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0086a) == null) {
            this.f3550i = interfaceC0086a;
        }
    }

    public void w(c.a.l.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.u = aVar;
            if (aVar != null) {
                x();
            }
        }
    }

    public final void x() {
        VideoImageNoPlayerLayout videoImageNoPlayerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (videoImageNoPlayerLayout = this.q) == null) {
            return;
        }
        videoImageNoPlayerLayout.setVideoAreaClickListener(new b(this));
    }
}
