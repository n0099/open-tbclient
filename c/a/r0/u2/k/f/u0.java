package c.a.r0.u2.k.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.r.l0.f;
import c.a.q0.r.r.a2;
import c.a.q0.r.r.b1;
import c.a.q0.r.r.e2;
import c.a.q0.r.t.a;
import c.a.q0.r.t.c;
import c.a.q0.r.t.j;
import c.a.r0.l.g;
import c.a.r0.l.j;
import c.a.r0.u2.i.a;
import c.a.r0.u2.k.f.c1.c;
import c.a.r0.y3.j0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class u0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int V1;
    public static int W1;
    public static int X1;
    public static int Y1;
    public static int Z1;
    public static int a2;
    public static int b2;
    public static final int c2;
    public static a.f d2;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.u2.k.f.i A;
    public c.a.q0.r.l0.a A0;
    public MaskView A1;
    public c.a.q0.r.t.a B;
    public boolean B0;
    public final FallingView B1;
    public c.a.q0.r.t.c C;
    public c.a.r0.u2.h.f C0;
    public RightFloatLayerView C1;
    public View D;
    public PostData D0;
    public final FrameLayout D1;
    public EditText E;
    public int E0;
    public boolean E1;
    public c.a.r0.u2.p.k F;
    public int F0;
    public String F1;
    public PbListView G;
    public boolean G0;
    public CustomMessageListener G1;
    public c.a.r0.u2.p.g H;
    public ViewStub H0;
    public CustomMessageListener H1;
    public View I;
    public PbInterviewStatusView I0;
    public Handler I1;
    public View J;
    public FrameLayout J0;
    public Runnable J1;
    public View K;
    public TextView K0;
    public CustomMessageListener K1;
    public View.OnClickListener L;
    public View L0;
    public PbFragment.c3 L1;
    public TbRichTextView.y M;
    public View M0;
    public boolean M1;
    public NoNetworkView.b N;
    public View N0;
    public View.OnClickListener N1;
    public PopupDialog O;
    public PbReplyTitleViewHolder O0;
    public boolean O1;
    public View.OnClickListener P;
    public View P0;
    public String P1;
    public c.a.q0.r.t.a Q;
    public int Q0;
    public f.g Q1;
    public Dialog R;
    public boolean R0;
    public final List<TbImageView> R1;
    public Dialog S;
    public p0 S0;
    public int S1;
    public View T;
    public PbEmotionBar T0;
    public boolean T1;
    public LinearLayout U;
    public int U0;
    public boolean U1;
    public CompoundButton.OnCheckedChangeListener V;
    public int V0;
    public TextView W;
    public Runnable W0;
    public TextView X;
    public PbFakeFloorModel X0;
    public String Y;
    public c.a.r0.u2.k.f.u Y0;
    public PopupDialog Z;
    public c.a.r0.u2.k.f.p0 Z0;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public PopupDialog a0;
    public boolean a1;

    /* renamed from: b  reason: collision with root package name */
    public int f23718b;
    public c.a.q0.r.t.d b0;
    public int b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f23719c;
    public boolean c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f23720d;
    public boolean d0;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public View f23721e;
    public String e0;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public int f23722f;
    public String f0;
    public int f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f23723g;
    public c.a.r0.u2.i.c g0;
    public PbTopTipView g1;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.u2.k.f.i1.c f23724h;
    public ScrollView h0;
    public PopupWindow h1;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.u2.k.f.i1.b f23725i;
    public EditorTools i0;
    public TextView i1;

    /* renamed from: j  reason: collision with root package name */
    public ViewStub f23726j;
    public boolean j0;
    public List<String> j1;
    public ViewStub k;
    public View k0;
    public c.a.r0.u2.k.f.d1.c k1;
    public PbLandscapeListView l;
    public View l0;
    public c.a.r0.u2.k.e.a l1;
    public NoNetworkView m;
    public Button m0;
    public PbLandscapeListView.c m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public boolean n1;
    public PbThreadPostView o;
    public View o0;
    public c.a.r0.u2.k.f.h0 o1;
    public c.a.r0.u2.k.f.c1.i p;
    public LinearLayout p0;
    public NavigationBarCoverTip p1;
    public c.a.r0.u2.k.f.c1.d q;
    public HeadImageView q0;
    public c.a.r0.l.g q1;
    public c.a.r0.u2.k.f.c1.f r;
    public TextView r0;
    public c.a.r0.l.j r1;
    public c.a.r0.u2.k.f.c1.h s;
    public ImageView s0;
    public String s1;
    public c.a.r0.u2.k.f.c1.e t;
    public ImageView t0;
    public PermissionJudgePolicy t1;
    public c.a.r0.u2.k.f.c1.g u;
    public ImageView u0;
    public long u1;
    public c.a.r0.u2.k.f.c1.c v;
    public c.a.r0.u2.p.j v0;
    public boolean v1;
    public LinearLayout w;
    public TextView w0;
    public int w1;
    public TextView x;
    public TextView x0;
    public int x1;
    public TextView y;
    public boolean y0;
    public boolean y1;
    public ObservedChangeRelativeLayout z;
    public int z0;
    public c.a.r0.u2.p.i z1;

    /* loaded from: classes2.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f23727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23728c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f23729d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23731f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ u0 f23732g;

        /* renamed from: c.a.r0.u2.k.f.u0$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1463a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f23733e;

            public RunnableC1463a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23733e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23733e.f23732g.P0 == null || this.f23733e.f23732g.P0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f23733e.f23732g.P0.getLayoutParams();
                layoutParams.height = this.f23733e.f23732g.V0;
                this.f23733e.f23732g.P0.setLayoutParams(layoutParams);
            }
        }

        public a(u0 u0Var, int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Integer.valueOf(i2), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23732g = u0Var;
            this.a = i2;
            this.f23727b = pbReplyTitleViewHolder;
            this.f23728c = z;
            this.f23729d = i3;
            this.f23730e = i4;
            this.f23731f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.a;
                if (i3 >= 0 && i3 <= this.f23732g.f23720d.getMeasuredHeight()) {
                    int T0 = this.f23732g.T0(this.f23727b);
                    int i4 = this.a;
                    int i5 = T0 - i4;
                    if (this.f23728c && i5 != 0 && i4 <= (i2 = this.f23729d)) {
                        i5 = T0 - i2;
                    }
                    if (this.f23732g.P0 == null || (layoutParams = this.f23732g.P0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f23732g.f23720d.getMeasuredHeight() || T0 >= this.f23732g.f23720d.getMeasuredHeight()) {
                        layoutParams.height = this.f23732g.V0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f23732g.f23720d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f23732g.l.setSelectionFromTop(this.f23730e, this.f23731f);
                            }
                        }
                        layoutParams.height = this.f23732g.V0;
                    }
                    this.f23732g.P0.setLayoutParams(layoutParams);
                    c.a.d.f.m.e.a().post(new RunnableC1463a(this));
                }
                this.f23732g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f23734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23735f;

        public a0(u0 u0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23735f = u0Var;
            this.f23734e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.d.f.p.n.C()) {
                    UrlManager.getInstance().dealOneLink(this.f23735f.f23719c.getPageContext(), new String[]{this.f23734e});
                    this.f23735f.f23719c.finish();
                    return;
                }
                this.f23735f.f23719c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23736e;

        public b(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23736e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23736e.q2();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f23737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f23738f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.u2.h.f f23739g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ u0 f23740h;

        public b0(u0 u0Var, Parcelable parcelable, ArrayList arrayList, c.a.r0.u2.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, parcelable, arrayList, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23740h = u0Var;
            this.f23737e = parcelable;
            this.f23738f = arrayList;
            this.f23739g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23740h.l.onRestoreInstanceState(this.f23737e);
                if (ListUtils.getCount(this.f23738f) <= 1 || this.f23739g.y().b() <= 0) {
                    return;
                }
                this.f23740h.G.f();
                this.f23740h.G.D(this.f23740h.f23719c.getString(R.string.pb_load_more_without_point));
                this.f23740h.G.y();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public c(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.X0.N(postData);
                this.a.A.X();
                this.a.Y0.c();
                this.a.i0.hideTools();
                this.a.f3(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public c0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.a.f23719c != null && this.a.f23719c.isAdded()) {
                if (i2 < 0 && f2 > this.a.f1) {
                    this.a.d0();
                    this.a.R1();
                }
                this.a.k0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements FallingView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public d(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.B1.setTag(Boolean.FALSE);
                if (this.a.C1 == null) {
                    return;
                }
                this.a.C1.setAutoCompleteShown(false);
                if (this.a.C1.getVisibility() == 0) {
                    this.a.C1.setTag(this.a.B1);
                    this.a.C1.completeHide();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23741e;

        public d0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23741e = u0Var;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23741e.d0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(u0 u0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.A == null) {
                return;
            }
            this.a.A.X();
        }
    }

    /* loaded from: classes2.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.c.f f23742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23743f;

        public e0(u0 u0Var, c.a.q0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23743f = u0Var;
            this.f23742e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23742e == null || this.f23743f.C0 == null || this.f23743f.C1 == null) {
                return;
            }
            this.f23743f.C1.doLink(this.f23742e);
            this.f23743f.C1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23744e;

        public f(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23744e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f23744e.w == null) {
                    this.f23744e.p1();
                }
                this.f23744e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23745e;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f0 f23746e;

            public a(f0 f0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23746e = f0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f23746e.f23745e.f23719c.HidenSoftKeyPad((InputMethodManager) this.f23746e.f23745e.f23719c.getBaseFragmentActivity().getSystemService("input_method"), this.f23746e.f23745e.f23720d);
                }
            }
        }

        public f0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23745e = u0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f23745e.W0 == null) {
                    this.f23745e.W0 = new a(this);
                }
                c.a.d.f.m.e.a().postDelayed(this.f23745e.W0, 150L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(u0 u0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.y0 = false;
        }
    }

    /* loaded from: classes2.dex */
    public class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23747e;

        public h(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23747e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23747e.q2();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements c.a.q0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23748e;

        public i(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23748e = u0Var;
        }

        @Override // c.a.q0.w.b
        public void onAction(c.a.q0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f13989c;
                if (obj instanceof c.a.q0.s.c.u) {
                    if (((c.a.q0.s.c.u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((c.a.q0.s.c.u) aVar.f13989c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f23748e.t1 == null) {
                            this.f23748e.t1 = new PermissionJudgePolicy();
                        }
                        this.f23748e.t1.clearRequestPermissionList();
                        this.f23748e.t1.appendRequestPermission(this.f23748e.f23719c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f23748e.t1.startRequestPermission(this.f23748e.f23719c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f23748e.f23719c.getPbEditor().h((c.a.q0.s.c.u) aVar.f13989c);
                        this.f23748e.f23719c.getPbEditor().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f23751g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f23752h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u0 f23753i;

        public i0(u0 u0Var, int i2, int i3, int i4, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23753i = u0Var;
            this.f23749e = i2;
            this.f23750f = i3;
            this.f23751g = i4;
            this.f23752h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f23749e;
                if (i2 == this.f23750f || i2 - this.f23751g >= 0) {
                    this.f23753i.h1.showAsDropDown(this.f23753i.o0, this.f23752h.getLeft(), -this.f23753i.o0.getHeight());
                } else {
                    this.f23753i.h1.showAsDropDown(this.f23752h);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23754e;

        public j(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23754e = u0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f23754e.f23719c.mContentProcessController == null || this.f23754e.f23719c.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f23754e.f23719c.mContentProcessController.e().e()) {
                this.f23754e.f23719c.mContentProcessController.a(false);
            }
            this.f23754e.f23719c.mContentProcessController.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f23754e.i0 == null || this.f23754e.i0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f23754e.k1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f23754e.i0.getId());
                u0 u0Var = this.f23754e;
                u0Var.k1 = new c.a.r0.u2.k.f.d1.c(u0Var.f23719c.getPageContext(), this.f23754e.f23720d, layoutParams);
                if (!ListUtils.isEmpty(this.f23754e.j1)) {
                    this.f23754e.k1.m(this.f23754e.j1);
                }
                this.f23754e.k1.n(this.f23754e.i0);
            }
            this.f23754e.k1.l(substring);
        }
    }

    /* loaded from: classes2.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.c.f f23755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23756f;

        public j0(u0 u0Var, c.a.q0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23756f = u0Var;
            this.f23755e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.f23756f.C1.setHomePbFloatLastCloseTime();
                this.f23756f.k1();
                this.f23756f.C1.reportClickCloseAd(this.f23755e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f23757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23758f;

        public k(u0 u0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23758f = u0Var;
            this.f23757e = z;
        }

        @Override // c.a.q0.r.t.j.e
        public void onItemClick(c.a.q0.r.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f23758f.O.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f23758f.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f23758f.L1 != null) {
                            this.f23758f.L1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f23758f.f23719c.handleMuteClick(this.f23757e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(u0 u0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.F1 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23760f;

        public l0(u0 u0Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23760f = u0Var;
            this.f23759e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23760f.y1 || this.f23759e == null || this.f23760f.f23719c.getPbModel() == null || !this.f23760f.f23719c.getPbModel().w1()) {
                return;
            }
            this.f23760f.y1 = true;
            this.f23759e.checkEasterEgg(false);
        }
    }

    /* loaded from: classes2.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f23762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ u0 f23763g;

        public m(u0 u0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23763g = u0Var;
            this.f23761e = alertDialog;
            this.f23762f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f23761e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f23763g.f23719c.getPbActivity(), R.string.neterror);
                } else {
                    this.f23763g.f23719c.deleteThread(this.f23762f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public m0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        @Override // c.a.r0.u2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f23719c.hideKeyBroad();
            }
        }

        @Override // c.a.r0.u2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.l == null) {
                return;
            }
            if (this.a.p != null) {
                this.a.p.t();
            }
            this.a.l.setSelection(0);
        }
    }

    /* loaded from: classes2.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23764e;

        public n(u0 u0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23764e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f23764e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23765e;

        public n0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23765e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.q0.r.r.t0(this.f23765e.f23719c.getActivity(), "pb_huitie"))) {
                this.f23765e.f23719c.processProfessionPermission();
                if (this.f23765e.f23719c == null || this.f23765e.f23719c.getPbModel() == null || this.f23765e.f23719c.getPbModel().R0() == null || this.f23765e.f23719c.getPbModel().R0().O() == null || this.f23765e.f23719c.getPbModel().R0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f23765e.f23719c.getPbModel().i1()).param("fid", this.f23765e.f23719c.getPbModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f23765e.f23719c.getPbModel().f45173f).param("fid", this.f23765e.f23719c.getPbModel().R0().m()).param("obj_locate", 1).param("uid", this.f23765e.f23719c.getPbModel().R0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f23767f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ u0 f23768g;

        public o(u0 u0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23768g = u0Var;
            this.f23766e = alertDialog;
            this.f23767f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f23766e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f23768g.f23719c.getPbActivity(), R.string.neterror);
                } else {
                    this.f23768g.f23719c.deleteThread(this.f23767f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23769e;

        public o0(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23769e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 1);
                    this.f23769e.f23719c.checkMuteState(sparseArray);
                    return;
                }
                this.f23769e.d2(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f23769e.f23719c.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f23769e.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23770e;

        public p(u0 u0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23770e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f23770e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public static class p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f23771b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f23772c;

        public p0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements g.InterfaceC1174g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u0 f23773b;

        public q(u0 u0Var, c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23773b = u0Var;
            this.a = aVar;
        }

        @Override // c.a.r0.l.g.InterfaceC1174g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f23773b.f23719c.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u0 f23774b;

        public r(u0 u0Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23774b = u0Var;
            this.a = sparseArray;
        }

        @Override // c.a.r0.l.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f23774b.f23719c.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23775e;

        public s(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23775e = u0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f23775e.Y = (String) compoundButton.getTag();
                if (this.f23775e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f23775e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f23775e.Y != null && !str.equals(this.f23775e.Y)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class t implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.r0.y3.j0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23776e;

        public u(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23776e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f23776e.S instanceof Dialog)) {
                c.a.d.f.m.g.b(this.f23776e.S, this.f23776e.f23719c.getPageContext());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class v implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.InterfaceC0876c f23777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23778f;

        public v(u0 u0Var, c.InterfaceC0876c interfaceC0876c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, interfaceC0876c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23778f = u0Var;
            this.f23777e = interfaceC0876c;
        }

        @Override // c.a.q0.r.t.j.e
        public void onItemClick(c.a.q0.r.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f23778f.a0.dismiss();
                this.f23777e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class w implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.InterfaceC0876c f23779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ u0 f23780f;

        public w(u0 u0Var, c.InterfaceC0876c interfaceC0876c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var, interfaceC0876c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23780f = u0Var;
            this.f23779e = interfaceC0876c;
        }

        @Override // c.a.q0.r.t.j.e
        public void onItemClick(c.a.q0.r.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f23780f.a0.dismiss();
                this.f23779e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23781e;

        public x(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23781e = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f23781e.C0 == null || this.f23781e.C0.O() == null || this.f23781e.C0.O().J() == null || this.f23781e.C0.O().J().getAlaInfo() == null || this.f23781e.C0.O().J().getAlaInfo().live_status != 1) {
                    if (this.f23781e.c1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f23781e.c1 && this.f23781e.C0 != null && this.f23781e.C0.O() != null && this.f23781e.C0.O().J() != null && this.f23781e.C0.O().J().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f23781e.f23719c.getPbActivity() != null) {
                        this.f23781e.f23719c.getPbActivity().mEvent.f23480b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f23781e.C0.m());
                statisticItem2.param("fname", this.f23781e.C0.n());
                statisticItem2.param("obj_param1", this.f23781e.C0.O().J().getAlaInfo().user_info != null ? this.f23781e.C0.O().J().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f23781e.C0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f23781e.C0.O().J().getAlaInfo()));
                if (this.f23781e.C0.O().J().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f23781e.C0.O().J().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f23781e.C0.O().J().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f23781e.f23719c.getPageContext(), this.f23781e.C0.O().J().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class y implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u0 a;

        public y(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u0Var;
        }

        @Override // c.a.r0.u2.k.f.c1.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.v.a(this.a.l);
                } else {
                    this.a.v.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f23782e;

        public z(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23782e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            u0 u0Var;
            c.a.r0.u2.k.f.i1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23782e.A == null || (cVar = (u0Var = this.f23782e).f23724h) == null || cVar.f23634i == null || u0Var.C0 == null || this.f23782e.C0.O() == null || this.f23782e.C0.O().I2() || this.f23782e.F1() || this.f23782e.C0.l() == null || c.a.d.f.p.m.isEmpty(this.f23782e.C0.l().getName())) {
                return;
            }
            if ((this.f23782e.A.H() == null || !this.f23782e.A.H().isShown()) && (linearLayout = this.f23782e.f23724h.f23634i) != null) {
                linearLayout.setVisibility(0);
                if (this.f23782e.f23719c == null || this.f23782e.f23719c.getPbModel() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f23782e.f23719c.getPbModel().h1());
                statisticItem.param("fid", this.f23782e.f23719c.getPbModel().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1750051124, "Lc/a/r0/u2/k/f/u0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1750051124, "Lc/a/r0/u2/k/f/u0;");
                return;
            }
        }
        V1 = UtilHelper.getLightStatusBarHeight();
        W1 = 3;
        X1 = 0;
        Y1 = 3;
        Z1 = 4;
        a2 = 5;
        b2 = 6;
        c2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        d2 = new t();
    }

    public u0(PbFragment pbFragment, View.OnClickListener onClickListener, c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23719c = null;
        this.f23720d = null;
        this.f23721e = null;
        this.f23722f = 0;
        this.f23723g = new Handler();
        this.l = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = false;
        this.d0 = false;
        this.e0 = null;
        this.f0 = null;
        this.h0 = null;
        this.j0 = false;
        this.m0 = null;
        this.o0 = null;
        this.r0 = null;
        this.y0 = true;
        this.A0 = null;
        this.B0 = false;
        this.F0 = 3;
        this.G0 = false;
        this.H0 = null;
        this.Q0 = 0;
        this.R0 = true;
        this.S0 = new p0();
        this.U0 = 0;
        this.a1 = false;
        this.b1 = 0;
        this.c1 = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = 0;
        this.n1 = false;
        this.u1 = 0L;
        this.x1 = 0;
        this.G1 = new k0(this, 2921306);
        this.H1 = new e(this, 2005016);
        this.I1 = new Handler();
        this.K1 = new g(this, 2004009);
        this.M1 = true;
        this.N1 = new x(this);
        this.O1 = false;
        this.P1 = null;
        this.R1 = new ArrayList();
        this.T1 = false;
        this.u1 = System.currentTimeMillis();
        this.f23719c = pbFragment;
        this.L = onClickListener;
        this.g0 = cVar;
        this.f1 = c.a.d.f.p.n.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f23719c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f23720d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.k0 = this.f23720d.findViewById(R.id.bottom_shadow);
        this.p1 = (NavigationBarCoverTip) this.f23720d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f23721e = this.f23720d.findViewById(R.id.statebar_view);
        this.D1 = (FrameLayout) this.f23720d.findViewById(R.id.right_layer_view);
        this.z = (ObservedChangeRelativeLayout) this.f23720d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f23720d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f23720d.findViewById(R.id.new_pb_list);
        this.J0 = (FrameLayout) this.f23720d.findViewById(R.id.root_float_header);
        this.K0 = new TextView(this.f23719c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f23719c.getActivity(), R.dimen.ds88));
        this.l.addHeaderView(this.K0, 0);
        this.l.setTextViewAdded(true);
        this.V0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.P0 = new View(this.f23719c.getPageContext().getPageActivity());
        if (c.a.q0.f1.b.c.d()) {
            this.P0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.P0.setLayoutParams(new AbsListView.LayoutParams(-1, this.V0));
        }
        this.P0.setVisibility(4);
        this.l.addFooterView(this.P0);
        this.l.setOnTouchListener(this.f23719c.mOnTouchListener);
        this.a = new l0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.f23724h = new c.a.r0.u2.k.f.i1.c(pbFragment, this.f23720d);
        if (this.f23719c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f23720d.findViewById(R.id.manga_view_stub);
            this.f23726j = viewStub;
            viewStub.setVisibility(0);
            c.a.r0.u2.k.f.i1.b bVar = new c.a.r0.u2.k.f.i1.b(pbFragment);
            this.f23725i = bVar;
            bVar.c();
            this.f23724h.a.setVisibility(8);
            layoutParams.height = c.a.d.f.p.n.f(this.f23719c.getActivity(), R.dimen.ds120);
        }
        this.K0.setLayoutParams(layoutParams);
        this.f23724h.p().setOnTouchListener(new c.a.r0.u2.i.a(new m0(this)));
        this.n0 = this.f23720d.findViewById(R.id.view_comment_top_line);
        this.o0 = this.f23720d.findViewById(R.id.pb_editor_tool_comment);
        c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.z0 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f23720d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.q0 = headImageView;
        headImageView.setVisibility(0);
        this.q0.setIsRound(true);
        this.q0.setBorderWidth(c.a.d.f.p.n.f(this.f23719c.getContext(), R.dimen.L_X01));
        this.q0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.q0.setPlaceHolder(0);
        L1();
        this.r0 = (TextView) this.f23720d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f23720d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.p0 = linearLayout;
        linearLayout.setOnClickListener(new n0(this));
        this.s0 = (ImageView) this.f23720d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.A1 = (MaskView) this.f23720d.findViewById(R.id.mask_view);
        this.s0.setOnClickListener(this.L);
        boolean booleanExtra = this.f23719c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f23720d.findViewById(R.id.pb_editor_tool_collection);
        this.t0 = imageView;
        imageView.setOnClickListener(this.L);
        if (booleanExtra) {
            this.t0.setVisibility(8);
        } else {
            this.t0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f23720d.findViewById(R.id.pb_editor_tool_share);
        this.u0 = imageView2;
        imageView2.setOnClickListener(this.L);
        this.v0 = new c.a.r0.u2.p.j(this.u0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.v0.e();
        }
        TextView textView = (TextView) this.f23720d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.w0 = textView;
        textView.setVisibility(0);
        this.H0 = (ViewStub) this.f23720d.findViewById(R.id.interview_status_stub);
        this.q = new c.a.r0.u2.k.f.c1.d(this.f23719c, cVar);
        this.s = new c.a.r0.u2.k.f.c1.h(this.f23719c, cVar, this.L);
        c.a.r0.u2.k.f.i iVar = new c.a.r0.u2.k.f.i(this.f23719c, this.l);
        this.A = iVar;
        iVar.s0(this.L);
        this.A.u0(this.g0);
        this.A.p0(this.M);
        this.A.r0(this.f23719c.onSwitchChangeListener);
        o0 o0Var = new o0(this);
        this.P = o0Var;
        this.A.o0(o0Var);
        t1();
        n1();
        c.a.r0.u2.k.f.c1.g gVar = new c.a.r0.u2.k.f.c1.g(this.f23719c);
        this.u = gVar;
        gVar.f23389f = 2;
        m1();
        this.v.a(this.l);
        this.r.a(this.l);
        this.s.j(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f23719c.getPageContext().getPageActivity());
        this.G = pbListView;
        this.I = pbListView.b().findViewById(R.id.pb_more_view);
        this.J = this.G.b().findViewById(R.id.pb_check_more);
        if (!this.G.i().booleanValue()) {
            this.J.setVisibility(8);
        }
        View view = this.I;
        if (view != null) {
            view.setOnClickListener(this.L);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        View view2 = this.J;
        if (view2 != null) {
            view2.setOnClickListener(this.L);
        }
        this.G.A();
        this.G.o(R.drawable.pb_foot_more_trans_selector);
        this.G.p(R.drawable.pb_foot_more_trans_selector);
        this.K = this.f23720d.findViewById(R.id.viewstub_progress);
        this.f23719c.registerListener(this.K1);
        this.X0 = new PbFakeFloorModel(this.f23719c.getPageContext());
        PbModel pbModel = this.f23719c.getPbModel();
        this.X0.P(pbModel.F(), pbModel.B(), pbModel.C(), pbModel.A(), pbModel.G());
        c.a.r0.u2.k.f.u uVar = new c.a.r0.u2.k.f.u(this.f23719c.getPageContext(), this.X0, this.f23720d);
        this.Y0 = uVar;
        uVar.k(new b(this));
        this.Y0.n(this.f23719c.mOnFloorPostWriteNewCallback);
        this.X0.R(new c(this));
        if (this.f23719c.getPbModel() != null && !StringUtils.isNull(this.f23719c.getPbModel().U0())) {
            PbFragment pbFragment2 = this.f23719c;
            pbFragment2.showToast(pbFragment2.getPbModel().U0());
        }
        this.L0 = this.f23720d.findViewById(R.id.pb_expand_blank_view);
        this.M0 = this.f23720d.findViewById(R.id.bottom_rec_float_title);
        View findViewById = this.f23720d.findViewById(R.id.sticky_view);
        this.N0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.f23719c.getPbModel() != null && this.f23719c.getPbModel().E0()) {
            this.L0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.N0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = V1;
            this.N0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f23719c.getPageContext(), this.f23720d.findViewById(R.id.pb_reply_expand_view));
        this.O0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
        this.O0.mDivideLineTop.setVisibility(8);
        this.O0.setPbCommonOnclickListener(this.L);
        this.O0.setOnSwitchChangeListener(this.f23719c.onSwitchChangeListener);
        this.f23719c.registerListener(this.H1);
        this.f23719c.registerListener(this.G1);
        PbFragment pbFragment3 = this.f23719c;
        this.z1 = new c.a.r0.u2.p.i(pbFragment3, pbFragment3.getUniqueId());
        this.B1 = (FallingView) this.f23720d.findViewById(R.id.falling_view);
        w2();
        this.B1.setAnimationListener(new d(this));
        Y();
        p2(false);
        this.l0 = this.f23720d.findViewById(R.id.pb_comment_container);
        X(c.a.q0.f1.b.c.d());
    }

    public TextView A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.n() : (TextView) invokeV.objValue;
    }

    public final boolean A1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData)) == null) {
            if (postData == null || postData.t() == null) {
                return false;
            }
            MetaData t2 = postData.t();
            return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.v1 = z2;
        }
    }

    public void A3(b1 b1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, b1Var, eVar) == null) || b1Var == null) {
            return;
        }
        int a3 = b1Var.a();
        int h2 = b1Var.h();
        c.a.q0.r.t.a aVar = this.B;
        if (aVar != null) {
            aVar.show();
        } else {
            this.B = new c.a.q0.r.t.a(this.f23719c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f23719c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.D = inflate;
            this.B.setContentView(inflate);
            this.B.setPositiveButton(R.string.dialog_ok, eVar);
            this.B.setNegativeButton(R.string.dialog_cancel, new d0(this));
            this.B.setOnCalcelListener(new f0(this));
            this.B.create(this.f23719c.getPageContext()).show();
        }
        EditText editText = (EditText) this.D.findViewById(R.id.input_page_number);
        this.E = editText;
        editText.setText("");
        TextView textView = (TextView) this.D.findViewById(R.id.current_page_number);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.f23719c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.E, 150);
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.u2.p.j jVar = this.v0;
            if (jVar != null) {
                return jVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void B2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.n1 = z2;
        }
    }

    public void B3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) || this.l == null || (textView = this.K0) == null || this.f23721e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f23721e.setVisibility(0);
            } else {
                this.f23721e.setVisibility(8);
                this.l.removeHeaderView(this.K0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.K0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = V1;
                this.K0.setLayoutParams(layoutParams);
            }
            r2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + J0(true);
            this.K0.setLayoutParams(layoutParams2);
        }
        r2();
        l2();
    }

    public PbInterviewStatusView C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.I0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.P1) : invokeV.booleanValue;
    }

    public void C2(boolean z2) {
        c.a.r0.u2.k.f.c1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.r(z2);
    }

    public final void C3(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null || fVar.O() == null || fVar.O().I2()) {
            return;
        }
        boolean z2 = fVar.O().s0() == 1;
        boolean z3 = fVar.O().t0() == 1;
        c.a.r0.u2.k.f.c1.h hVar = this.s;
        if (hVar != null) {
            hVar.l(fVar, z2, z3);
        }
        c.a.r0.u2.k.f.i iVar = this.A;
        if (iVar == null || iVar.t() == null) {
            return;
        }
        this.A.t().showThreadTypeStampBottomPart(fVar, z2, z3);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n1 : invokeV.booleanValue;
    }

    public final boolean D1(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, e2Var)) == null) {
            if (e2Var == null || e2Var.J() == null) {
                return false;
            }
            PostData w0 = w0(this.C0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (w0 == null || w0.t() == null) ? "" : w0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void D2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.A.h0(z2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void D3(c.a.r0.u2.h.f fVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, fVar, z2) == null) || fVar == null) {
            return;
        }
        M3(fVar, z2);
        g0();
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.p != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return x0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View view = this.P0;
            if (view == null || view.getParent() == null || this.G.m()) {
                return false;
            }
            int bottom = this.P0.getBottom();
            Rect rect = new Rect();
            this.P0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.A.m0(z2);
        }
    }

    public void E3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f23719c.showToast(str);
        }
    }

    public BdTypeListView F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.r0.u2.h.f fVar = this.C0;
            return fVar == null || fVar.l() == null || "0".equals(this.C0.l().getId()) || "me0407".equals(this.C0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void F2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.Q1 = gVar;
            c.a.r0.u2.p.k kVar = this.F;
            if (kVar != null) {
                kVar.a(gVar);
            }
        }
    }

    public void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f23719c.showProgressBar();
        }
    }

    public SparseArray<Object> G0(c.a.r0.u2.h.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData w0;
        c.a.q0.r.r.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (w0 = w0(fVar, z2)) == null) {
                return null;
            }
            String userId = w0.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, w0.G());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (w0.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, w0.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, w0.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, w0.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, w0.G());
                }
                sparseArray.put(R.id.tag_del_post_id, w0.G());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<a2> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (a2 a2Var : p2) {
                        if (a2Var != null && !StringUtils.isNull(a2Var.getForumName()) && (e0Var = a2Var.f13164g) != null && e0Var.a && !e0Var.f13245c && ((i3 = e0Var.f13244b) == 1 || i3 == 2)) {
                            sb.append(c.a.d.f.p.m.cutString(a2Var.getForumName(), 12));
                            sb.append(this.f23719c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f23719c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G2(String str) {
        c.a.r0.u2.k.f.i1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || (bVar = this.f23725i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void G3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (fallingView = this.B1) == null) {
            return;
        }
        fallingView.stopAllViews();
    }

    public c.a.r0.u2.k.e.a H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.l1 : (c.a.r0.u2.k.e.a) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.E1 : invokeV.booleanValue;
    }

    public void H2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            this.a1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.b1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.R1 == null) {
            return;
        }
        while (this.R1.size() > 0) {
            TbImageView remove = this.R1.remove(0);
            if (remove != null) {
                remove.stopLoading();
            }
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.J : (View) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            c.a.r0.u2.p.j jVar = this.v0;
            if (jVar == null) {
                return false;
            }
            return jVar.h();
        }
        return invokeV.booleanValue;
    }

    public void I2(PbFragment.d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, d3Var) == null) {
        }
    }

    public void I3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.c0 = z2;
        }
    }

    public final int J0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.I0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            EditorTools editorTools = this.i0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void J2(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yVar) == null) {
            this.M = yVar;
            this.A.p0(yVar);
            this.l1.q(this.M);
        }
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.f23724h.H(z2);
            if (z2 && this.G0) {
                this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.G);
                this.f23722f = 2;
            }
            L1();
        }
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public /* synthetic */ void K1() {
        String S0;
        PbFragment pbFragment = this.f23719c;
        if (pbFragment != null && pbFragment.getPbModel() != null && this.f23719c.getPbModel().t1()) {
            S0 = this.f23719c.getString(R.string.pb_reply_hint_from_smart_frs);
        } else {
            S0 = S0();
        }
        if (!StringUtils.isNull(S0) && this.C0 != null) {
            S0 = TbSingleton.getInstance().getAdVertiComment(this.C0.k0(), this.C0.l0(), S0);
        }
        PbFragment pbFragment2 = this.f23719c;
        if (pbFragment2 != null && pbFragment2.getPbEditor() != null) {
            this.f23719c.getPbEditor().k0(S0);
        }
        TextView textView = this.r0;
        if (textView != null) {
            textView.setText(S0);
        }
        f3(false);
        y3();
    }

    public void K2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            this.N = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void K3(c.a.r0.u2.h.d dVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f23724h.I();
        if (!StringUtils.isNull(dVar.f23087b)) {
            this.f23724h.F(dVar.f23087b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int e2 = c.a.d.f.m.b.e(dVar.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f23719c.showNetRefreshView(this.f23720d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new a0(this, dVar.f23088c));
    }

    public PbListView L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.q0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.q0.setImageResource(0);
                this.q0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.q0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public void L2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void L3(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                c.a.r0.u2.p.j jVar = this.v0;
                if (jVar != null) {
                    jVar.k(false);
                    this.v0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.u0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.u0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.r0.u2.p.j jVar2 = this.v0;
            if (jVar2 == null || !jVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.u0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.u0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.u0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            try {
                return Integer.parseInt(this.E.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void M1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || this.F0 == i2) {
            return;
        }
        this.F0 = i2;
        D3(this.C0, this.B0);
        k2(this.C0, this.B0, this.E0, i2);
        this.f23719c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f23719c.getBaseFragmentActivity().getLayoutMode().j(this.f23720d);
        SkinManager.setBackgroundColor(this.f23720d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0203);
        c.a.r0.u2.k.f.c1.i iVar = this.p;
        if (iVar != null) {
            iVar.h(i2);
        }
        c.a.r0.u2.k.f.c1.e eVar = this.t;
        if (eVar != null) {
            eVar.c(i2);
        }
        c.a.r0.u2.k.f.c1.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
        c.a.r0.u2.k.f.c1.f fVar = this.r;
        if (fVar != null) {
            fVar.c(i2);
        }
        c.a.r0.u2.k.f.c1.h hVar = this.s;
        if (hVar != null) {
            hVar.t(i2);
        }
        c.a.r0.u2.k.f.c1.g gVar = this.u;
        if (gVar != null) {
            gVar.d();
        }
        c.a.r0.u2.k.f.c1.c cVar = this.v;
        if (cVar != null) {
            cVar.c();
        }
        MaskView maskView = this.A1;
        if (maskView != null) {
            maskView.onChangeSkin();
        }
        PbListView pbListView = this.G;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.I != null) {
            this.f23719c.getBaseFragmentActivity().getLayoutMode().j(this.I);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.J != null) {
            this.f23719c.getBaseFragmentActivity().getLayoutMode().j(this.J);
            SkinManager.setBackgroundResource(this.J, R.drawable.pb_foot_more_trans_selector);
        }
        c.a.q0.r.t.a aVar = this.B;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f23719c.getPageContext());
        }
        I3(this.c0);
        this.A.X();
        c.a.r0.u2.p.k kVar = this.F;
        if (kVar != null) {
            kVar.C(i2);
        }
        EditorTools editorTools = this.i0;
        if (editorTools != null) {
            editorTools.onChangeSkinType(i2);
        }
        c.a.r0.u2.p.g gVar2 = this.H;
        if (gVar2 != null) {
            gVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.onChangeSkinMode();
            }
        }
        N3();
        UtilHelper.setStatusBarBackground(this.f23721e, i2);
        UtilHelper.setStatusBarBackground(this.N0, i2);
        if (this.w != null) {
            c.a.q0.w0.a.a(this.f23719c.getPageContext(), this.w);
        }
        c.a.r0.u2.k.f.u uVar = this.Y0;
        if (uVar != null) {
            uVar.h(i2);
        }
        c.a.r0.u2.k.f.i1.c cVar2 = this.f23724h;
        if (cVar2 != null) {
            c.a.r0.u2.k.f.c1.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.i(i2);
            } else {
                cVar2.u(i2);
            }
        }
        HeadImageView headImageView = this.q0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.p0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(this.f23719c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        c.a.r0.u2.h.f fVar2 = this.C0;
        if (fVar2 != null && fVar2.r()) {
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        L3(this.C0);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.n0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.i1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.w0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.w0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        c.a.r0.u2.k.e.a aVar2 = this.l1;
        if (aVar2 != null) {
            aVar2.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.T0;
        if (pbEmotionBar != null) {
            pbEmotionBar.onChangeSkinType();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.onSkinChange(i2);
        }
        c.a.r0.u2.p.j jVar = this.v0;
        if (jVar != null) {
            jVar.i();
        }
        c.a.r0.u2.p.i iVar3 = this.z1;
        if (iVar3 != null) {
            iVar3.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.M0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.M0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
    }

    public void M2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public boolean M3(c.a.r0.u2.h.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, fVar, z2)) == null) {
            if (fVar == null) {
                return false;
            }
            if (this.r != null) {
                if (fVar.O() != null && fVar.O().p0() == 0 && !fVar.O().I2() && !this.E1) {
                    if (fVar.O() != null) {
                        e2 O = fVar.O();
                        O.e3(true, i3(fVar));
                        O.t4(3);
                        O.o4("2");
                    }
                    if (fVar.O().Q1()) {
                        this.s.w(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.j(this.l);
                        this.s.A(this.C0);
                        if (x1(fVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(fVar);
                        }
                    } else {
                        this.s.A(this.C0);
                        if (x1(fVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.g(fVar);
                        }
                    }
                } else if (fVar.O().p0() == 1) {
                    if (fVar.O() != null) {
                        this.r.d(this.l);
                        this.s.A(this.C0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.A(this.C0);
                }
            }
            C3(fVar);
            this.B0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public View N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.L0 : (View) invokeV.objValue;
    }

    public void N1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, configuration) == null) || configuration == null) {
            return;
        }
        d0();
        if (configuration.orientation == 2) {
            d1();
            f1();
        } else {
            q2();
        }
        c.a.r0.u2.k.f.u uVar = this.Y0;
        if (uVar != null) {
            uVar.c();
        }
        this.f23719c.hideKeyBroad();
        this.z.setVisibility(8);
        this.f23724h.B(false);
        this.f23719c.setNavigationBarShowFlag(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                Z0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.U1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.U1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.S1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.p.j(configuration);
            this.J0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void N2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.A.t0(onClickListener);
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && this.f23719c.getIsMangaThread()) {
            if (this.f23719c.getMangaPrevChapterId() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
            if (this.f23719c.getMangaNextChapterId() == -1) {
                SkinManager.setViewTextColor(this.y, R.color.CAM_X0110, 1);
            }
        }
    }

    public PbFakeFloorModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.X0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void O1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            RelativeLayout relativeLayout = this.f23720d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f23720d.getHandler().removeCallbacksAndMessages(null);
            }
            c.a.r0.u2.p.j jVar = this.v0;
            if (jVar != null) {
                jVar.j();
            }
            c.a.r0.u2.k.f.p0 p0Var = this.Z0;
            if (p0Var != null) {
                p0Var.a();
            }
            c.a.r0.u2.k.f.h0 h0Var = this.o1;
            if (h0Var != null) {
                h0Var.c();
            }
            PbTopTipView pbTopTipView = this.g1;
            if (pbTopTipView != null) {
                pbTopTipView.hide();
            }
            this.f23719c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.N) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            d0();
            j0();
            if (this.W0 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.W0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.I0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.clearStatus();
            }
            this.I1 = null;
            this.f23723g.removeCallbacksAndMessages(null);
            this.A.Y(3);
            View view = this.f23721e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.a();
            }
            c.a.r0.u2.k.f.i iVar2 = this.A;
            if (iVar2 != null) {
                iVar2.Z();
            }
            this.l.setOnLayoutListener(null);
            c.a.r0.u2.k.f.d1.c cVar = this.k1;
            if (cVar != null) {
                cVar.h();
            }
            PbEmotionBar pbEmotionBar = this.T0;
            if (pbEmotionBar != null) {
                pbEmotionBar.onDestroy();
            }
            c.a.r0.u2.k.f.c1.h hVar = this.s;
            if (hVar != null) {
                hVar.u();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void O2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.w1 = i2;
        }
    }

    public void O3(c.a.r0.u2.h.f fVar) {
        c.a.r0.u2.k.f.c1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, fVar) == null) || (dVar = this.q) == null) {
            return;
        }
        dVar.h(fVar, this.B0);
    }

    public c.a.r0.u2.k.f.u P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.Y0 : (c.a.r0.u2.k.f.u) invokeV.objValue;
    }

    public void P1(TbRichText tbRichText) {
        c.a.r0.u2.h.f fVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, tbRichText) == null) || (fVar = this.C0) == null || fVar.F() == null || this.C0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.C0.F().size() && (postData = this.C0.F().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.C0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                c.a.r0.u2.k.e.a aVar = this.l1;
                if (aVar != null && aVar.l()) {
                    f3(false);
                }
                PbEmotionBar pbEmotionBar = this.T0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.autoShow(true);
                }
                postData.t().getName_show();
                return;
            }
        }
    }

    public void P2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onLongClickListener) == null) {
            this.s.x(onLongClickListener);
            this.A.q0(onLongClickListener);
            c.a.r0.u2.k.e.a aVar = this.l1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public c.a.r0.u2.k.f.c1.i Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.p : (c.a.r0.u2.k.f.c1.i) invokeV.objValue;
    }

    public boolean Q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i2)) == null) {
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void Q2(PostData postData, c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, postData, fVar) == null) {
            this.s.y(postData, fVar);
        }
    }

    public final boolean R(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048642, this, absListView, i2)) == null) {
            if (absListView == null) {
                return false;
            }
            boolean z2 = i2 > 0;
            if (z2 || absListView.getChildCount() <= 0) {
                return z2;
            }
            return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public final PostData R0(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = fVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> D1 = fVar.O().D1();
            if (D1 != null && (metaData = D1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.n0(1);
            postData.r0(fVar.O().X());
            postData.D0(fVar.O().getTitle());
            postData.C0(fVar.O().P());
            postData.l0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void R1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.f23719c == null) {
            return;
        }
        if ((this.v1 || this.w1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            c.a.r0.u2.h.f fVar = this.C0;
            if (fVar == null || fVar.l() == null || c.a.d.f.p.m.isEmpty(this.C0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f23719c.getContext()).createNormalCfg(this.C0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.C0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.C0.l().getId()));
        } else if (!this.d1 || this.c1 || (postData = this.D0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f23719c.isSimpleForum() ? 2 : 1).param("obj_type", this.c1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f23719c.getPageContext().getPageActivity(), this.D0.t().getUserId(), this.D0.t().getUserName(), this.f23719c.getPbModel().r0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void R2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048645, this, z2, postWriteCallBackData) == null) {
            this.f23719c.hideProgressBar();
            if (z2) {
                d0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                e0();
            } else {
                d0();
            }
        }
    }

    public void S() {
        c.a.r0.u2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (jVar = this.v0) == null) {
            return;
        }
        jVar.l(false);
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (!c.a.d.f.p.m.isEmpty(this.s1)) {
                return this.s1;
            }
            if (this.f23719c != null) {
                this.s1 = TbadkCoreApplication.getInst().getResources().getString(s0.b());
            }
            return this.s1;
        }
        return (String) invokeV.objValue;
    }

    public void S1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z2) == null) {
            if (z2) {
                l3();
            } else {
                g1();
            }
            this.S0.f23772c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
            f2(this.S0.f23772c, false);
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.f23719c.hideProgressBar();
            c.a.r0.u2.h.f fVar = this.C0;
            if (fVar != null && this.G != null && fVar.y() != null && this.C0.y().b() == 0) {
                this.G.v(this.C0.t());
                if (this.C0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.C0.m());
                    statisticItem.param("fname", this.C0.n());
                    statisticItem.param("tid", this.C0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            j0();
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
    }

    public boolean T(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z2)) == null) {
            EditorTools editorTools = this.i0;
            if (editorTools == null || !editorTools.isToolVisible()) {
                return false;
            }
            this.i0.hideTools();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final int T0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                return pbReplyTitleViewHolder.getView().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            H3();
            this.A.Y(1);
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.l();
            }
            RightFloatLayerView rightFloatLayerView = this.C1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).onChangeStyleToUnFold(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void T2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (pbFragment = this.f23719c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        c.a.d.f.p.n.w(this.f23719c.getPageContext().getPageActivity(), this.f23719c.getBaseFragmentActivity().getCurrentFocus());
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            PbListView pbListView = this.G;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.G.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.A.Y(2);
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f23719c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f23719c.getFragmentActivity())) {
                    return;
                }
                b1().setSystemUiVisibility(4);
            }
        }
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.G.A();
            this.G.R();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || this.C0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || c.a.r0.u2.k.f.h1.b.k(this.C0.Q())) {
            return;
        }
        this.v0.e();
        c.a.r0.u2.k.f.h1.b.b(this.C0.Q());
    }

    public final int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void V1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        c.a.r0.u2.k.f.c1.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048660, this, absListView, i2, i3, i4) == null) {
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            c.a.r0.u2.k.f.i1.c cVar = this.f23724h;
            if (cVar != null && (hVar = this.s) != null) {
                cVar.w(hVar.o());
            }
            p0 p0Var = this.S0;
            p0Var.a = i2;
            p0Var.f23771b = this.l.getHeaderViewsCount();
            this.S0.f23772c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
            e3(R(absListView, i2));
            int i5 = 0;
            f2(this.S0.f23772c, false);
            c0();
            if (!this.G.n() || this.G.G) {
                return;
            }
            p0 p0Var2 = this.S0;
            if (p0Var2 != null && (pbReplyTitleViewHolder = p0Var2.f23772c) != null && pbReplyTitleViewHolder.getView() != null) {
                i5 = this.S0.f23772c.getView().getTop() < 0 ? this.S0.f23772c.getView().getHeight() : this.S0.f23772c.getView().getBottom();
            }
            this.G.e(i5);
            this.G.G = true;
        }
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
            this.s.z(z2);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (!this.f23719c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.f0));
            } else if (this.f23719c.checkPrivacyBeforeInput()) {
                c.a.q0.w.y.e pbEditor = this.f23719c.getPbEditor();
                if (pbEditor != null && (pbEditor.B() || pbEditor.D())) {
                    this.f23719c.getPbEditor().z(false, null);
                    return;
                }
                if (this.i0 != null) {
                    q1();
                }
                EditorTools editorTools = this.i0;
                if (editorTools != null) {
                    this.y0 = false;
                    if (editorTools.findToolById(2) != null) {
                        c.a.r0.y3.j0.a.c(this.f23719c.getPageContext(), (View) this.i0.findToolById(2).k, false, d2);
                    }
                }
                d1();
            }
        }
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.F0 : invokeV.intValue;
    }

    public void W1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048664, this, absListView, i2) == null) {
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.U1 && i2 == 0) {
                this.S1 = V0();
                this.S0.f23772c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
                f2(this.S0.f23772c, true);
                c0();
                this.A.d0(true);
            }
            this.A.c0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.C1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.onScrollIdle();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.C1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.onScrollDragging();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.C1) == null) {
            } else {
                rightFloatLayerView.onScrollSettling();
            }
        }
    }

    public void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            this.r0.performClick();
            if (StringUtils.isNull(str) || this.f23719c.getPbEditor() == null || this.f23719c.getPbEditor().v() == null || this.f23719c.getPbEditor().v().h() == null) {
                return;
            }
            EditText h2 = this.f23719c.getPbEditor().v().h();
            h2.setText(str);
            h2.setSelection(str.length());
        }
    }

    public void X(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view = this.l0;
            if (view != null) {
                view.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.L(z2 ? 8 : 0);
            }
            View view2 = this.I;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.f23721e : (View) invokeV.objValue;
    }

    public void X1(ArrayList<c.a.q0.r.r.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, arrayList) == null) {
            if (this.T == null) {
                this.T = LayoutInflater.from(this.f23719c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f23719c.getBaseFragmentActivity().getLayoutMode().j(this.T);
            if (this.S == null) {
                Dialog dialog = new Dialog(this.f23719c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.S = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.S.setCancelable(true);
                this.h0 = (ScrollView) this.T.findViewById(R.id.good_scroll);
                this.S.setContentView(this.T);
                WindowManager.LayoutParams attributes = this.S.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.S.getWindow().setAttributes(attributes);
                this.V = new s(this);
                this.U = (LinearLayout) this.T.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.T.findViewById(R.id.dialog_button_cancel);
                this.X = textView;
                textView.setOnClickListener(new u(this));
                TextView textView2 = (TextView) this.T.findViewById(R.id.dialog_button_ok);
                this.W = textView2;
                textView2.setOnClickListener(this.L);
            }
            this.U.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton Z = Z("0", this.f23719c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(Z);
            Z.setChecked(true);
            this.U.addView(Z);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.q0.r.r.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton Z2 = Z(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(Z2);
                        View view = new View(this.f23719c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.U.addView(view);
                        this.U.addView(Z2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.h0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f23719c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f23719c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f23719c.getPageContext().getPageActivity(), 186.0f);
                }
                this.h0.setLayoutParams(layoutParams2);
                this.h0.removeAllViews();
                LinearLayout linearLayout = this.U;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.h0.addView(this.U);
                }
            }
            c.a.d.f.m.g.j(this.S, this.f23719c.getPageContext());
        }
    }

    public void X2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            c.a.r0.u2.k.e.a aVar = new c.a.r0.u2.k.e.a(this.f23719c, this, (ViewStub) this.f23720d.findViewById(R.id.more_god_reply_popup));
            this.l1 = aVar;
            aVar.o(this.L);
            this.l1.p(this.P);
            this.l1.q(this.M);
            this.l1.o(this.L);
            this.l1.s(this.g0);
        }
    }

    public PbThreadPostView Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void Y1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048672, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            Z1(i2, str, i3, z2, null);
        }
    }

    public void Y2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, list) == null) {
            this.j1 = list;
            c.a.r0.u2.k.f.d1.c cVar = this.k1;
            if (cVar != null) {
                cVar.m(list);
            }
        }
    }

    public final CustomBlueCheckRadioButton Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048674, this, str, str2)) == null) {
            Activity pageActivity = this.f23719c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.n.f(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.V);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public RelativeLayout Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.z : (RelativeLayout) invokeV.objValue;
    }

    public void Z1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048676, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            a2(i2, str, i3, z2, str2, false);
        }
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            PbFragment pbFragment = this.f23719c;
            return (pbFragment == null || pbFragment.getPbModel().R0().l().getDeletedReasonInfo() == null || 1 != this.f23719c.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || this.T1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.T1 = true;
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f23719c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(X1, Integer.valueOf(Z1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f23719c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f23719c);
        aVar.setNegativeButton(R.string.look_again, new g0(this));
        aVar.create(this.f23719c.getPageContext()).show();
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? R.id.user_icon_box : invokeV.intValue;
    }

    public void a2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(X1, Integer.valueOf(Y1));
            int i4 = (i3 != 1002 || z2) ? R.string.del_all_post_confirm : R.string.report_post_confirm;
            int i5 = R.string.confirm_title;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.del_my_thread_confirm;
                    i4 = R.string.del_my_thread_confirm_subtitle;
                } else {
                    i4 = R.string.report_thread_confirm;
                }
            }
            this.Q = new c.a.q0.r.t.a(this.f23719c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Q.setMessageId(i4);
            } else {
                this.Q.setOnlyMessageShowCenter(false);
                this.Q.setMessage(str2);
            }
            this.Q.setYesButtonTag(sparseArray);
            this.Q.setPositiveButton(R.string.dialog_ok, this.f23719c);
            this.Q.setNegativeButton(R.string.dialog_cancel, new l(this));
            this.Q.setCancelable(true);
            this.Q.create(this.f23719c.getPageContext());
            if (z3) {
                h3(sparseArray, i5, i4);
            } else if (z2) {
                h3(sparseArray, i5, i4);
            } else if (Z2()) {
                c.a.r0.l.i iVar = new c.a.r0.l.i(this.f23719c.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f23719c.getPbModel().R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f23719c.getPbModel().R0().o().has_forum_rule.intValue());
                iVar.i(this.f23719c.getPbModel().R0().l().getId(), this.f23719c.getPbModel().R0().l().getName());
                iVar.h(this.f23719c.getPbModel().R0().l().getImage_url());
                iVar.j(this.f23719c.getPbModel().R0().l().getUser_level());
                o3(sparseArray, i2, iVar, this.f23719c.getPbModel().R0().U(), false);
            } else {
                w3(this.Q, i2);
            }
        }
    }

    public void a3() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.J0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c.a.r0.u2.k.f.i1.c cVar = this.f23724h;
            if (cVar == null || (view = cVar.f23629d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", org.apache.commons.lang3.StringUtils.LF);
            }
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f23719c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f23719c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(X1, Integer.valueOf(a2));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(R.string.view, this.f23719c);
            aVar.setNegativeButton(R.string.cancel, new h0(this));
            aVar.create(this.f23719c.getPageContext()).show();
        }
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.f23720d : (View) invokeV.objValue;
    }

    public void b2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(X1, Integer.valueOf(Y1));
            if (z2) {
                c3(sparseArray);
            } else {
                d3(i2, sparseArray);
            }
        }
    }

    public void b3() {
        c.a.r0.u2.k.f.c1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.u(this.l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.x1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0() {
        c.a.r0.u2.p.i iVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (iVar = this.z1) == null) {
            return;
        }
        if (((iVar.a() == null || this.z1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.z1.a())) != -1) {
            if (this.z1.a().getTop() + c2 <= this.L0.getBottom()) {
                this.x1 = 1;
                z2 = true;
            } else {
                this.x1 = 0;
                z2 = false;
            }
        }
        this.O0.showRecomStyle(this.x1 == 1);
        this.z1.e(z2);
    }

    public void c1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.J0.setVisibility(8);
            }
            c.a.r0.u2.k.f.i1.c cVar = this.f23724h;
            if (cVar == null || (view = cVar.f23629d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void c2(SparseArray<Object> sparseArray, boolean z2) {
        c.a.q0.r.t.g gVar;
        c.a.q0.r.t.g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048689, this, sparseArray, z2) == null) {
            c.a.q0.r.t.j jVar = new c.a.q0.r.t.j(this.f23719c.getContext());
            jVar.q(this.f23719c.getString(R.string.bar_manager));
            jVar.n(new k(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    gVar2 = new c.a.q0.r.t.g(10, this.f23719c.getString(R.string.delete_post), jVar);
                } else {
                    gVar2 = new c.a.q0.r.t.g(10, this.f23719c.getString(R.string.delete), jVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                gVar2.f13477d.setTag(sparseArray2);
                arrayList.add(gVar2);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !H1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                c.a.q0.r.t.g gVar3 = new c.a.q0.r.t.g(11, this.f23719c.getString(R.string.forbidden_person), jVar);
                gVar3.f13477d.setTag(sparseArray3);
                arrayList.add(gVar3);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
                if (z2) {
                    gVar = new c.a.q0.r.t.g(12, this.f23719c.getString(R.string.un_mute), jVar);
                } else {
                    gVar = new c.a.q0.r.t.g(12, this.f23719c.getString(R.string.mute), jVar);
                }
                gVar.f13477d.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            c.a.r0.u2.k.f.h1.a.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                jVar.k(arrayList, false);
            } else {
                jVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f23719c.getPageContext(), jVar);
            this.O = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final void c3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, sparseArray) == null) || this.f23719c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.r.t.m mVar = new c.a.q0.r.t.m(this.f23719c.getPbActivity());
        mVar.v(R.string.musk_my_thread_confirm);
        mVar.l(R.string.musk_my_thread_confirm_subtitle);
        mVar.n(true);
        mVar.r(aVar2, aVar);
        mVar.i(false);
        AlertDialog y2 = mVar.y();
        aVar.a(new o(this, y2, sparseArray));
        aVar2.a(new p(this, y2));
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.f23724h.k();
            c.a.r0.u2.k.f.c1.h hVar = this.s;
            if (hVar != null) {
                hVar.m();
            }
            PbFragment pbFragment = this.f23719c;
            if (pbFragment != null) {
                c.a.d.f.p.n.w(pbFragment.getContext(), this.E);
            }
            f1();
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.q0.r.t.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.q0.r.t.c cVar = this.C;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || this.o0 == null) {
            return;
        }
        this.n0.setVisibility(8);
        this.o0.setVisibility(8);
        this.y0 = false;
        PbEmotionBar pbEmotionBar = this.T0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            p2(false);
        }
    }

    public void d2(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        c2(sparseArray, false);
    }

    public final void d3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048694, this, i2, sparseArray) == null) || (pbFragment = this.f23719c) == null || pbFragment.getPbModel() == null || this.f23719c.getPbModel().R0() == null || this.f23719c.getPbModel().R0().o() == null || this.f23719c.getPbModel().R0().l() == null || this.f23719c.getPbModel().R0().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.r0.l.i iVar = new c.a.r0.l.i(this.f23719c.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f23719c.getPbModel().R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f23719c.getPbModel().R0().o().has_forum_rule.intValue());
        iVar.i(this.f23719c.getPbModel().R0().l().getId(), this.f23719c.getPbModel().R0().l().getName());
        iVar.h(this.f23719c.getPbModel().R0().l().getImage_url());
        iVar.j(this.f23719c.getPbModel().R0().l().getUser_level());
        o3(sparseArray, i2, iVar, this.f23719c.getPbModel().R0().U(), true);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.f23724h.k();
            c.a.r0.u2.k.f.c1.h hVar = this.s;
            if (hVar != null) {
                hVar.m();
            }
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.q0.r.t.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.q0.r.t.c cVar = this.C;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void e1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048696, this, z2) == null) || this.o0 == null || this.r0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        c.a.r0.u2.h.f fVar = this.C0;
        boolean z3 = fVar != null && fVar.k0();
        c.a.r0.u2.h.f fVar2 = this.C0;
        this.r0.setText(tbSingleton.getAdVertiComment(z3, fVar2 != null && fVar2.l0(), S0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.o0.startAnimation(alphaAnimation);
        }
        this.n0.setVisibility(0);
        this.o0.setVisibility(0);
        this.y0 = true;
        if (this.T0 == null || this.l1.l()) {
            return;
        }
        this.T0.setVisibility(0);
        p2(true);
    }

    public void e2(c.a.q0.t.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048697, this, aVar, i2) == null) || (fallingView = this.B1) == null) {
            return;
        }
        fallingView.startFalling(aVar, this.f23719c.getPageContext(), i2, false);
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z2) == null) {
            this.k0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void f0() {
        c.a.r0.u2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048699, this) == null) || (jVar = this.v0) == null) {
            return;
        }
        jVar.k(false);
    }

    public void f1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.hide();
        c.a.r0.u2.k.f.d1.c cVar = this.k1;
        if (cVar != null) {
            cVar.i();
        }
    }

    public final void f2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048701, this, pbReplyTitleViewHolder, z2) == null) || this.c1 || this.L0 == null || this.f23724h.p() == null) {
            return;
        }
        View r2 = o0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.L0.getVisibility() == 0 && i3 - this.f23724h.p().getBottom() <= this.L0.getHeight()) {
                    this.M0.setVisibility(0);
                    if (i3 > this.f23724h.p().getBottom()) {
                        i2 = -(((this.L0.getHeight() + this.M0.getHeight()) + this.f23724h.p().getBottom()) - r2.getBottom());
                    } else {
                        i2 = -this.L0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.L0.getLayoutParams();
                    if (layoutParams.topMargin != i2) {
                        layoutParams.topMargin = i2;
                        this.L0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.M0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.L0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.L0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int G = this.A.G();
        if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
            if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.L0.setVisibility(4);
                return;
            }
            this.L0.setVisibility(0);
            e3(false);
            this.f23724h.a.hideBottomLine();
            if (this.L0.getParent() == null || ((ViewGroup) this.L0.getParent()).getHeight() > this.L0.getTop()) {
                return;
            }
            this.L0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.mDivideLineTop != null) {
            int top = pbReplyTitleViewHolder.getView().getTop();
            if (pbReplyTitleViewHolder.getView().getParent() != null) {
                if (this.R0) {
                    this.Q0 = top;
                    this.R0 = false;
                }
                int i4 = this.Q0;
                if (top < i4) {
                    i4 = top;
                }
                this.Q0 = i4;
            }
            if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                if (this.z.getY() < 0.0f) {
                    measuredHeight = V1 - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                } else {
                    measuredHeight = this.f23724h.p().getMeasuredHeight() - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                    this.f23724h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.Q0) {
                    this.L0.setVisibility(0);
                    e3(false);
                } else if (top < measuredHeight) {
                    this.L0.setVisibility(0);
                    e3(false);
                } else {
                    this.L0.setVisibility(4);
                    this.f23724h.a.hideBottomLine();
                }
                if (z2) {
                    this.R0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.L0.setVisibility(4);
            this.f23724h.a.hideBottomLine();
        }
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) || this.o0 == null) {
            return;
        }
        y2(this.f23719c.getPbEditor().C());
        if (this.j0) {
            j3(z2);
        } else {
            e1(z2);
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.q.b(this.B0) : invokeV.booleanValue;
    }

    public void g1() {
        c.a.r0.u2.k.f.i1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (cVar = this.f23724h) == null) {
            return;
        }
        cVar.q();
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            this.s.v(this.C0, this.D0, this.d1, this.c1);
        }
    }

    public void g3(c.a.r0.u2.h.f fVar) {
        PostData postData;
        c.a.r0.u2.k.f.i1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048706, this, fVar) == null) || fVar == null || (postData = this.D0) == null || postData.t() == null || (cVar = this.f23724h) == null) {
            return;
        }
        boolean z2 = !this.c1;
        this.d1 = z2;
        cVar.G(z2);
        if (this.f23719c.getPbNavigationAnimDispatcher() != null) {
            this.f23719c.getPbNavigationAnimDispatcher().s(this.d1);
        }
        g2();
        PbFragment pbFragment = this.f23719c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
            a2 a2Var = fVar.p().get(0);
            if (a2Var != null) {
                this.f23724h.K(fVar, a2Var.getForumName(), a2Var.getForumId(), a2Var.b(), a2Var.getIsLike());
            }
        } else if (fVar.l() != null) {
            this.f23724h.K(fVar, fVar.l().getName(), fVar.l().getId(), fVar.l().getImage_url(), fVar.l().isLike() == 1);
        }
        if (this.d1) {
            this.s.F(fVar, this.D0, this.d0);
            View view = this.N0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.m1 == null) {
                this.m1 = new c0(this);
            }
            this.l.setListViewDragListener(this.m1);
            return;
        }
        View view2 = this.N0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.s.F(fVar, this.D0, this.d0);
        this.m1 = null;
        this.l.setListViewDragListener(null);
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            c.a.q0.r.t.a aVar = this.Q;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.R;
            if (dialog != null) {
                c.a.d.f.m.g.b(dialog, this.f23719c.getPageContext());
            }
            Dialog dialog2 = this.S;
            if (dialog2 != null) {
                c.a.d.f.m.g.b(dialog2, this.f23719c.getPageContext());
            }
            PopupDialog popupDialog = this.O;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void h1() {
        c.a.q0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || (aVar = this.A0) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048709, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.b1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.S0.f23772c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.S0.f23772c;
        int T0 = T0(pbReplyTitleViewHolder);
        int measuredHeight = this.z.getMeasuredHeight() + ((int) this.z.getY());
        boolean z2 = this.L0.getVisibility() == 0;
        boolean z3 = this.z.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.A.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), V1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.f23724h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.c1 && this.p != null) {
            this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.E0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, T0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void h3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048710, this, sparseArray, i2, i3) == null) || this.f23719c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.r.t.m mVar = new c.a.q0.r.t.m(this.f23719c.getPbActivity());
        mVar.v(i2);
        mVar.l(i3);
        mVar.n(true);
        mVar.r(aVar2, aVar);
        mVar.i(false);
        AlertDialog y2 = mVar.y();
        aVar.a(new m(this, y2, sparseArray));
        aVar2.a(new n(this, y2));
    }

    public void i0() {
        c.a.r0.u2.k.f.c1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048711, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.b();
    }

    public void i1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            if (this.w == null) {
                p1();
            }
            this.k.setVisibility(8);
            Handler handler = this.I1;
            if (handler == null || (runnable = this.J1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public final void i2(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        L3(fVar);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String n02 = n0(fVar.O().W0());
        TextView textView = this.w0;
        if (textView != null) {
            textView.setText(n02);
        }
        TextView textView2 = this.x0;
        if (textView2 != null) {
            textView2.setText(n02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public final boolean i3(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return fVar.O().l0() == 1 || fVar.O().s1() == 33 || !(fVar.O().A1() == null || fVar.O().A1().a() == 0) || fVar.O().t0() == 1 || fVar.O().s0() == 1 || fVar.O().M1() || fVar.O().g2() || fVar.O().M2() || fVar.O().J1() != null || !c.a.d.f.p.m.isEmpty(fVar.O().N()) || fVar.O().d2() || fVar.O().u2();
        }
        return invokeL.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.y();
                this.G.f();
            }
            h1();
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            this.K.setVisibility(8);
        }
    }

    public void j2(int i2, c.a.r0.u2.h.f fVar, boolean z2, int i3) {
        PostData w0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{Integer.valueOf(i2), fVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (w0 = w0(fVar, z2)) == null || w0.t() == null) {
            return;
        }
        MetaData t2 = w0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void j3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || this.o0 == null || (textView = this.r0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.o0.startAnimation(alphaAnimation);
        }
        this.n0.setVisibility(0);
        this.o0.setVisibility(0);
        this.y0 = true;
        if (this.T0 == null || this.l1.l()) {
            return;
        }
        this.T0.setVisibility(0);
        p2(true);
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
    }

    public void k1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void k2(c.a.r0.u2.h.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048721, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            r3(fVar, z2, i2, i3);
            this.s.t(i3);
        }
    }

    public void k3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048722, this, view) == null) || c.a.q0.r.j0.b.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.o0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f23719c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f23719c.getContext());
        this.i1 = textView;
        textView.setText(R.string.connection_tips);
        this.i1.setGravity(17);
        this.i1.setPadding(c.a.d.f.p.n.f(this.f23719c.getContext(), R.dimen.ds24), 0, c.a.d.f.p.n.f(this.f23719c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = c.a.d.f.p.n.f(this.f23719c.getContext(), R.dimen.ds60);
        if (this.i1.getParent() == null) {
            frameLayout.addView(this.i1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f23719c.getContext());
        this.h1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.h1.setHeight(-2);
        this.h1.setWidth(-2);
        this.h1.setFocusable(true);
        this.h1.setOutsideTouchable(false);
        this.h1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new i0(this, i4, i2, i3, view), 100L);
        c.a.q0.r.j0.b.k().u("show_long_press_collection_tips", true);
    }

    public void l0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f23719c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f23719c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (c.a.d.f.p.m.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f23719c.showToast(str);
            }
        }
    }

    public void l1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048724, this) == null) || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final void l2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048725, this) == null) && (pbInterviewStatusView = this.I0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.I0.setLayoutParams(layoutParams);
        }
    }

    public void l3() {
        c.a.r0.u2.k.f.i1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || (cVar = this.f23724h) == null || this.e1) {
            return;
        }
        cVar.C();
        this.e1 = true;
    }

    public void m0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void m1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048728, this) == null) && this.v == null && (pbFragment = this.f23719c) != null) {
            this.v = new c.a.r0.u2.k.f.c1.c(pbFragment.getContext());
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048729, this) == null) || this.f23722f == 2) {
            return;
        }
        this.l.setNextPage(this.G);
        this.f23722f = 2;
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public final String n0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048731, this, i2)) == null) {
            if (i2 == 0) {
                return this.f23719c.getString(R.string.pb_comment_red_dot_no_reply);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + "W";
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048732, this) == null) && this.r == null) {
            this.r = new c.a.r0.u2.k.f.c1.f(this.f23719c, this.g0);
        }
    }

    public void n2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.v.d(pbLandscapeListView);
        this.r.d(this.l);
        this.s.w(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            if (this.A0 == null) {
                this.A0 = new c.a.q0.r.l0.a(this.f23719c.getPageContext());
            }
            this.A0.h(true);
        }
    }

    public c.a.r0.u2.k.f.i o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.A : (c.a.r0.u2.k.f.i) invokeV.objValue;
    }

    public final void o1(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048736, this, fVar) == null) && fVar != null && fVar.O() != null && fVar.O().g2() && this.I0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.H0.inflate();
            this.I0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.L);
            this.I0.setCallback(this.f23719c.getInterviewStatusCallback());
            this.I0.setData(this.f23719c, fVar);
        }
    }

    public final void o2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || (pbFragment = this.f23719c) == null || pbFragment.getPbEditor() == null || this.i0 == null) {
            return;
        }
        c.a.q0.w.y.a.a().c(0);
        c.a.q0.w.y.e pbEditor = this.f23719c.getPbEditor();
        pbEditor.T();
        pbEditor.R();
        if (pbEditor.y() != null) {
            pbEditor.y().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.l0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.q0.w.h findLauncherById = this.i0.findLauncherById(23);
        c.a.q0.w.h findLauncherById2 = this.i0.findLauncherById(2);
        c.a.q0.w.h findLauncherById3 = this.i0.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.i0.invalidate();
    }

    public final void o3(SparseArray<Object> sparseArray, int i2, c.a.r0.l.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048738, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f23719c) == null) {
            return;
        }
        if (this.r1 == null && this.q != null) {
            this.r1 = new c.a.r0.l.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        this.r1.C(z2);
        AntiData antiData = this.f23719c.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.r.r.x0 x0Var = new c.a.q0.r.r.x0();
        x0Var.j(sparseArray2);
        this.r1.E(new String[]{this.f23719c.getString(R.string.delete_thread_reason_1), this.f23719c.getString(R.string.delete_thread_reason_2), this.f23719c.getString(R.string.delete_thread_reason_3), this.f23719c.getString(R.string.delete_thread_reason_4), this.f23719c.getString(R.string.delete_thread_reason_5)});
        this.r1.D(x0Var);
        this.r1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.r1.F(new r(this, sparseArray));
    }

    public LinearLayout p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.p0 : (LinearLayout) invokeV.objValue;
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && this.f23719c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f23720d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.w == null) {
                this.w = (LinearLayout) this.f23720d.findViewById(R.id.manga_controller_layout);
                c.a.q0.w0.a.a(this.f23719c.getPageContext(), this.w);
            }
            if (this.x == null) {
                this.x = (TextView) this.w.findViewById(R.id.manga_prev_btn);
            }
            if (this.y == null) {
                this.y = (TextView) this.w.findViewById(R.id.manga_next_btn);
            }
            this.x.setOnClickListener(this.L);
            this.y.setOnClickListener(this.L);
        }
    }

    public final void p2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.A.e0(this.C0, false);
            this.A.X();
        }
    }

    public View q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            View view = this.T;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || this.f23719c == null || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.display();
        if (this.f23719c.getPbEditor() != null) {
            this.f23719c.getPbEditor().P();
        }
        d1();
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            o2();
            f1();
            this.Y0.c();
            f3(false);
        }
    }

    public void q3(c.a.r0.u2.h.f fVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048746, this, new Object[]{fVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || fVar == null || this.l == null) {
            return;
        }
        this.C0 = fVar;
        this.E0 = i2;
        if (fVar.O() != null) {
            this.U0 = fVar.O().O();
            if (fVar.O().F() != 0) {
                this.O1 = true;
            }
            this.d0 = D1(fVar.O());
        }
        if (fVar.U() != null) {
            this.P1 = fVar.U().getUserId();
        }
        o1(fVar);
        V();
        this.G0 = false;
        this.B0 = z2;
        S2();
        c.a.r0.u2.h.m mVar = fVar.f23098h;
        if (mVar != null && mVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f23719c.getContext());
                this.o = pbThreadPostView;
                this.l.addHeaderView(pbThreadPostView, 1);
                this.o.setData(fVar);
                this.o.setChildOnClickLinstener(this.L);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        r3(fVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        g3(fVar);
        this.s.G(fVar, this.D0);
        if (this.o1 == null) {
            this.o1 = new c.a.r0.u2.k.f.h0(this.f23719c.getPageContext(), this.p1);
        }
        this.o1.a(fVar.w());
        if (this.f23719c.getIsMangaThread()) {
            if (this.F == null) {
                c.a.r0.u2.p.k kVar = new c.a.r0.u2.p.k(this.f23719c.getPageContext());
                this.F = kVar;
                kVar.i();
                this.F.a(this.Q1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.r0.u2.p.k kVar2 = this.F;
            if (kVar2 != null) {
                kVar2.C(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (fVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.F == null) {
                c.a.r0.u2.p.k kVar3 = new c.a.r0.u2.p.k(this.f23719c.getPageContext());
                this.F = kVar3;
                kVar3.i();
                this.F.a(this.Q1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.r0.u2.p.k kVar4 = this.F;
            if (kVar4 != null) {
                kVar4.C(TbadkCoreApplication.getInst().getSkinType());
            }
            h1();
        }
        g0();
        this.A.l0(this.B0);
        this.A.i0(false);
        this.A.j0(i2 == 5);
        this.A.k0(i2 == 6);
        this.A.g0(z3 && this.M1 && i2 != 2);
        this.A.e0(fVar, false);
        this.A.X();
        this.s.E(w0(fVar, z2), fVar.g0());
        if (fVar.O() != null && fVar.O().N0() != null && this.f23718b != -1) {
            fVar.O().N0().setIsLike(this.f23718b);
        }
        this.l.removeFooterView(this.P0);
        this.l.addFooterView(this.P0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.G);
            this.f23722f = 2;
            h1();
        } else {
            this.G0 = true;
            if (fVar.y().b() == 1) {
                if (this.H == null) {
                    PbFragment pbFragment = this.f23719c;
                    this.H = new c.a.r0.u2.p.g(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.H);
            } else {
                this.l.setNextPage(this.G);
            }
            this.f23722f = 3;
        }
        ArrayList<PostData> F = fVar.F();
        if (fVar.y().b() != 0 && F != null && F.size() >= fVar.y().e()) {
            if (z3) {
                if (this.M1) {
                    j0();
                    if (fVar.y().b() != 0) {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.G.A();
                    this.G.O();
                }
            } else {
                this.G.A();
                this.G.O();
            }
            this.G.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (fVar.y().b() == 0) {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.G.k();
            } else {
                p0 p0Var = this.S0;
                if (p0Var == null || (pbReplyTitleViewHolder = p0Var.f23772c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i5 = 0;
                } else {
                    i5 = this.S0.f23772c.getView().getTop() < 0 ? this.S0.f23772c.getView().getHeight() : this.S0.f23772c.getView().getBottom();
                }
                if (this.f23719c.isHostOnlyMode()) {
                    this.G.v(false);
                    this.G.G(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.G.G(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f23719c.getPbNavigationAnimDispatcher() != null && !this.f23719c.getPbNavigationAnimDispatcher().p()) {
                    this.f23719c.getPbNavigationAnimDispatcher().x();
                }
            }
            if (fVar.y().b() == 0 || F == null) {
                m2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && fVar.F() == null) ? 0 : (this.l.getData().size() - fVar.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.M1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        c.a.r0.u2.k.f.c1.i iVar = this.p;
                        if (iVar != null && iVar.c() != null) {
                            if (this.f23719c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - c.a.d.f.p.n.r(this.f23719c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d());
                            }
                        } else {
                            this.l.setSelection(this.A.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(fVar.R())) {
                        this.l.setSelection(i3 > 0 ? i3 + ((this.l.getData() == null && fVar.F() == null) ? 0 : (this.l.getData().size() - fVar.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(fVar.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.G.f();
                    this.G.D(this.f23719c.getString(R.string.pb_load_more_without_point));
                    this.G.y();
                }
            } else if (i4 == 1 && (e3 = c.a.r0.u2.k.f.m0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = c.a.r0.u2.k.f.m0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new b0(this, e2, F, fVar));
        }
        if (this.U0 == W1 && C1()) {
            a0();
        }
        if (this.a1) {
            h2();
            this.a1 = false;
            if (i4 == 0) {
                H2(true);
            }
        }
        if (fVar.f23094d == 1 || fVar.f23095e == 1) {
            if (this.g1 == null) {
                this.g1 = new PbTopTipView(this.f23719c.getContext());
            }
            if (fVar.f23095e == 1 && "game_guide".equals(this.f23719c.getStType())) {
                this.g1.setText(this.f23719c.getString(R.string.pb_read_strategy_add_experience));
                this.g1.show(this.f23720d, this.F0);
            } else if (fVar.f23094d == 1 && "game_news".equals(this.f23719c.getStType())) {
                this.g1.setText(this.f23719c.getString(R.string.pb_read_news_add_experience));
                this.g1.show(this.f23720d, this.F0);
            }
        }
        this.l.removeFooterView(this.z1.a());
        if (!ListUtils.isEmpty(fVar.I()) && fVar.y().b() == 0) {
            this.l.removeFooterView(this.P0);
            this.z1.d(Math.max(this.o0.getMeasuredHeight(), this.z0 / 2));
            this.l.addFooterView(this.z1.a());
            this.z1.f(fVar);
        }
        i2(fVar);
        if (fVar.e0() && this.f23719c.getPbRecThreadController() != null) {
            this.f23719c.getPbRecThreadController().d();
        }
        if (fVar.g() != 3) {
            s1(fVar);
        }
        this.r0.setText(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), S0()));
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public final void r1(c.a.r0.u2.h.f fVar, c.a.q0.s.c.f fVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048748, this, fVar, fVar2) == null) || this.D1 == null || fVar == null || fVar2 == null || this.f23719c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.isHomePbNeedShow()) {
            k1();
            return;
        }
        if (this.C1 == null) {
            this.C1 = RightFloatLayerLottieView.getRightFloatView(fVar2, this.f23719c.getContext());
            this.D1.removeAllViews();
            this.D1.addView(this.C1);
        }
        if ((this.B1.getTag() instanceof Boolean) && !((Boolean) this.B1.getTag()).booleanValue()) {
            this.C1.setAutoCompleteShown(false);
            this.C1.setTag(this.B1);
            this.C1.completeHide();
        }
        if (fVar2.a()) {
            return;
        }
        this.C1.setData(fVar2);
        this.C1.setLogoListener(new e0(this, fVar2));
        this.C1.setFeedBackListener(new j0(this, fVar2));
    }

    public final void r2() {
        c.a.r0.u2.k.f.c1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048749, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(this.l, this.K0, this.E0);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void r3(c.a.r0.u2.h.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048750, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        if (this.f23719c.isSimpleForum()) {
            if (fVar.h() != null) {
                this.e0 = fVar.h().getForumName();
                this.f0 = fVar.h().getForumId();
            }
            if (this.e0 == null && this.f23719c.getPbModel() != null && this.f23719c.getPbModel().r0() != null) {
                this.e0 = this.f23719c.getPbModel().r0();
            }
        }
        PostData w0 = w0(fVar, z2);
        Q2(w0, fVar);
        this.s.B(8);
        if (fVar.r0()) {
            this.c1 = true;
            this.f23724h.A(true);
            this.f23724h.a.hideBottomLine();
            if (this.p == null) {
                this.p = new c.a.r0.u2.k.f.c1.i(this.f23719c);
            }
            this.p.v(fVar, w0, this.l, this.s, this.J0, this.f23724h, this.e0, this.u1);
            this.p.s(this.N1);
            r2();
        } else {
            this.c1 = false;
            this.f23724h.A(false);
            c.a.r0.u2.k.f.c1.i iVar = this.p;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f23719c.getPbNavigationAnimDispatcher() != null) {
            this.f23719c.getPbNavigationAnimDispatcher().w(this.c1);
        }
        if (w0 == null) {
            return;
        }
        this.D0 = w0;
        this.s.B(0);
        SparseArray<Object> q2 = this.s.q();
        q2.put(R.id.tag_clip_board, w0);
        q2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(fVar, this.l);
        this.v.e(fVar, this.w1, new y(this));
        this.r.f(fVar);
        this.q.h(fVar, this.B0);
        this.q.g(fVar);
        this.s.C(this.F0, this.C0, w0, this.N1);
        if (this.O0 != null) {
            if (fVar.g0()) {
                this.O0.getView().setVisibility(8);
            } else {
                this.O0.getView().setVisibility(0);
                c.a.r0.u2.h.q qVar = new c.a.r0.u2.h.q(c.a.r0.u2.h.q.l);
                if (fVar.O() != null) {
                    fVar.O().W0();
                }
                qVar.f23130g = fVar.f23097g;
                fVar.c();
                qVar.f23131h = this.f23719c.isHostOnlyMode();
                qVar.k = fVar.f23096f;
                this.O0.bindDataToView(qVar);
            }
        }
        C3(fVar);
        c.a.d.f.m.e.a().post(new z(this));
        this.u.e(this.l);
        if (w0.U) {
            this.u.f(w0.G());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        c.a.r0.u2.k.f.i iVar2 = this.A;
        if (iVar2 != null && iVar2.z() != null) {
            this.A.z().m0(w0.U);
        }
        c.a.r0.u2.k.f.i iVar3 = this.A;
        if (iVar3 != null) {
            iVar3.n0(w0.U);
        }
        this.A1.setVisibility(w0.U ? 0 : 8);
    }

    public int s0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.l.getChildAt(i5)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i5] = rect.height();
                    }
                    i3 += iArr[i5];
                }
                int i6 = i3 / 2;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i7 >= i2) {
                        break;
                    }
                    i8 += iArr[i7];
                    if (i8 > i6) {
                        firstVisiblePosition += i7;
                        break;
                    }
                    i7++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public void s1(c.a.r0.u2.h.f fVar) {
        c.a.q0.s.c.f pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048752, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.k0()) {
            pbAdFloatViewItemData = fVar.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            r1(fVar, pbAdFloatViewItemData);
        } else {
            k1();
        }
    }

    public void s2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (handler = this.I1) == null) {
            return;
        }
        Runnable runnable = this.J1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        f fVar = new f(this);
        this.J1 = fVar;
        this.I1.postDelayed(fVar, 2000L);
    }

    public void s3(c.InterfaceC0876c interfaceC0876c, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048754, this, interfaceC0876c, z2) == null) {
            PopupDialog popupDialog = this.a0;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.a0 = null;
            }
            c.a.q0.r.t.j jVar = new c.a.q0.r.t.j(this.f23719c.getContext());
            ArrayList arrayList = new ArrayList();
            c.a.r0.u2.h.f fVar = this.C0;
            if (fVar != null && fVar.O() != null && !this.C0.O().U1()) {
                arrayList.add(new c.a.q0.r.t.g(0, this.f23719c.getPageContext().getString(R.string.save_to_emotion), jVar));
            }
            if (!z2) {
                arrayList.add(new c.a.q0.r.t.g(1, this.f23719c.getPageContext().getString(R.string.save_to_local), jVar));
            }
            jVar.j(arrayList);
            jVar.n(new w(this, interfaceC0876c));
            PopupDialog popupDialog2 = new PopupDialog(this.f23719c.getPageContext(), jVar);
            this.a0 = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public PostData t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int s0 = s0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (s0 < 0) {
                s0 = 0;
            }
            if (this.A.y(s0) != null && this.A.y(s0) != PostData.z0) {
                i2 = s0 + 1;
            }
            if (this.A.x(i2) instanceof PostData) {
                return (PostData) this.A.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048756, this) == null) && this.t == null) {
            this.t = new c.a.r0.u2.k.f.c1.e(this.f23719c, this.L);
        }
    }

    public void t2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, editorTools) == null) {
            this.i0 = editorTools;
            editorTools.setOnCancelClickListener(new h(this));
            this.i0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.i0.getParent() == null) {
                this.f23720d.addView(this.i0, layoutParams);
            }
            this.i0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.i0.setActionListener(24, new i(this));
            f1();
            this.f23719c.getPbEditor().i(new j(this));
        }
    }

    public void t3(c.InterfaceC0876c interfaceC0876c, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048758, this, new Object[]{interfaceC0876c, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Z = null;
            }
            c.a.q0.r.t.j jVar = new c.a.q0.r.t.j(this.f23719c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new c.a.q0.r.t.g(0, this.f23719c.getPageContext().getString(R.string.copy), jVar));
            }
            if (z3) {
                arrayList.add(new c.a.q0.r.t.g(1, this.f23719c.getPageContext().getString(R.string.report_text), jVar));
            } else if (!z2) {
                arrayList.add(new c.a.q0.r.t.g(1, this.f23719c.getPageContext().getString(R.string.mark), jVar));
            } else {
                arrayList.add(new c.a.q0.r.t.g(1, this.f23719c.getPageContext().getString(R.string.remove_mark), jVar));
            }
            jVar.j(arrayList);
            jVar.n(new v(this, interfaceC0876c));
            PopupDialog popupDialog2 = new PopupDialog(this.f23719c.getPageContext(), jVar);
            this.a0 = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public FallingView u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.B1 : (FallingView) invokeV.objValue;
    }

    public void u1(c.a.r0.u2.h.f fVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, fVar) == null) {
            int i2 = 0;
            this.A.e0(fVar, false);
            this.A.X();
            g0();
            c.a.r0.u2.k.e.a aVar = this.l1;
            if (aVar != null) {
                aVar.n();
            }
            ArrayList<PostData> F = fVar.F();
            if (fVar.y().b() == 0 || F == null || F.size() < fVar.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (fVar.y().b() == 0) {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.G.k();
                } else {
                    p0 p0Var = this.S0;
                    if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f23772c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i2 = this.S0.f23772c.getView().getTop() < 0 ? this.S0.f23772c.getView().getHeight() : this.S0.f23772c.getView().getBottom();
                    }
                    if (this.f23719c.isHostOnlyMode()) {
                        this.G.G(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.G.G(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            i2(fVar);
        }
    }

    public void u2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048761, this, str) == null) || (pbListView = this.G) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void u3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, onItemClickListener) == null) {
            c.a.q0.r.t.d dVar = this.b0;
            if (dVar != null) {
                dVar.d();
                this.b0 = null;
            }
            if (this.C0 == null) {
                return;
            }
            ArrayList<c.a.q0.r.t.l> arrayList = new ArrayList<>();
            arrayList.add(new c.a.q0.r.t.l(this.f23719c.getContext().getString(R.string.all_person), "", this.C0.L() == 1, Integer.toString(1)));
            arrayList.add(new c.a.q0.r.t.l(this.f23719c.getContext().getString(R.string.my_fans), "", this.C0.L() == 2, Integer.toString(5)));
            arrayList.add(new c.a.q0.r.t.l(this.f23719c.getContext().getString(R.string.my_attentions), "", this.C0.L() == 3, Integer.toString(6)));
            arrayList.add(new c.a.q0.r.t.l(this.f23719c.getContext().getString(R.string.myself_only), "", this.C0.L() == 4, Integer.toString(7)));
            c.a.q0.r.t.d dVar2 = new c.a.q0.r.t.d(this.f23719c.getPageContext());
            dVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.b0 = dVar2;
            dVar2.k(arrayList, onItemClickListener);
            dVar2.c();
            this.b0.n();
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? x0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.O1 : invokeV.booleanValue;
    }

    public void v2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048765, this, str) == null) || this.G == null) {
            return;
        }
        int i2 = 0;
        p0 p0Var = this.S0;
        if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f23772c) != null && pbReplyTitleViewHolder.getView() != null) {
            i2 = this.S0.f23772c.getView().getTop() < 0 ? this.S0.f23772c.getView().getHeight() : this.S0.f23772c.getView().getBottom();
        }
        this.G.G(str, i2);
    }

    public void v3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || !TbadkCoreApplication.isLogin() || this.C0 == null || !this.d1 || this.c1 || this.d0 || (postData = this.D0) == null || postData.t() == null || this.D0.t().getIsLike() || this.D0.t().hadConcerned() || this.Z0 != null) {
            return;
        }
        this.Z0 = new c.a.r0.u2.k.f.p0(this.f23719c);
    }

    public PostData w0(c.a.r0.u2.h.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048767, this, fVar, z2)) == null) {
            PostData postData = null;
            if (fVar == null) {
                return null;
            }
            if (fVar.W() != null) {
                return fVar.W();
            }
            if (!ListUtils.isEmpty(fVar.F())) {
                Iterator<PostData> it = fVar.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = fVar.j();
            }
            if (!A1(postData)) {
                postData = R0(fVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048769, this) == null) {
            this.B1.setFallingFeedbackListener(new FallingView.k() { // from class: c.a.r0.u2.k.f.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.k
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        u0.this.K1();
                    }
                }
            });
        }
    }

    public final void w3(c.a.q0.r.t.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048770, this, aVar, i2) == null) || (pbFragment = this.f23719c) == null || aVar == null) {
            return;
        }
        if (this.q1 == null && this.q != null) {
            this.q1 = new c.a.r0.l.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData antiData = this.f23719c.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.r.r.x0 x0Var = new c.a.q0.r.r.x0();
        x0Var.j(sparseArray);
        this.q1.y(new String[]{this.f23719c.getString(R.string.delete_thread_reason_1), this.f23719c.getString(R.string.delete_thread_reason_2), this.f23719c.getString(R.string.delete_thread_reason_3), this.f23719c.getString(R.string.delete_thread_reason_4), this.f23719c.getString(R.string.delete_thread_reason_5)});
        this.q1.x(x0Var);
        this.q1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.q1.z(new q(this, aVar));
    }

    public final int x0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048771, this, i2)) == null) {
            c.a.d.o.e.e adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof c.a.r0.u2.h.c)) {
                i2++;
            }
            int m2 = (adapter2.m() + adapter2.k()) - 1;
            if (i2 > m2) {
                i2 = m2;
            }
            int l2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof c.a.d.o.e.e)) ? 0 : this.l.getAdapter2().l();
            if (i2 > l2) {
                return i2 - l2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final boolean x1(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048772, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            SpannableStringBuilder j1 = fVar.O().j1();
            if (j1 != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(j1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void x2(PbFragment.c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, c3Var) == null) {
            this.L1 = c3Var;
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            this.K.setVisibility(0);
        }
    }

    public Button y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.m0 : (Button) invokeV.objValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.isDragListenerExecuted();
        }
        return invokeV.booleanValue;
    }

    public void y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z2) == null) {
            this.j0 = z2;
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            FallingView fallingView = this.B1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.C1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.B1) {
                this.C1.setTag(null);
                this.C1.setAutoCompleteShown(true);
                this.C1.completeShow();
            }
        }
    }

    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            EditorTools editorTools = this.i0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z2) == null) {
            this.A.f0(z2);
        }
    }

    public void z3() {
        c.a.r0.u2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048782, this) == null) || (jVar = this.v0) == null) {
            return;
        }
        jVar.m(2);
    }
}
