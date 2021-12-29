package c.a.s0.g1.q.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import c.a.s0.g1.q.a.d.e;
import c.a.s0.g1.q.a.d.f;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public String B;
    public String C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public WheelView.DividerType U;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public e f13009b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.g1.q.a.d.a f13010c;

    /* renamed from: d  reason: collision with root package name */
    public boolean[] f13011d;

    /* renamed from: e  reason: collision with root package name */
    public Calendar f13012e;

    /* renamed from: f  reason: collision with root package name */
    public Calendar f13013f;

    /* renamed from: g  reason: collision with root package name */
    public Calendar f13014g;

    /* renamed from: h  reason: collision with root package name */
    public int f13015h;

    /* renamed from: i  reason: collision with root package name */
    public int f13016i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13017j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13018k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public ViewGroup y;
    public int z;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13011d = new boolean[]{true, true, true, false, false, false};
        this.f13017j = false;
        this.f13018k = false;
        this.z = 17;
        this.E = -16417281;
        this.F = -16417281;
        this.G = -16777216;
        this.H = -1;
        this.I = BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT;
        this.J = 17;
        this.K = 18;
        this.L = 18;
        this.M = -5723992;
        this.N = -14013910;
        this.O = -2763307;
        this.P = -1;
        this.Q = 1.6f;
        this.S = true;
        this.T = false;
        Typeface typeface = Typeface.MONOSPACE;
        this.U = WheelView.DividerType.FILL;
        if (i2 == 1) {
            this.x = R.layout.pickerview_options;
        } else {
            this.x = R.layout.pickerview_time;
        }
    }
}
