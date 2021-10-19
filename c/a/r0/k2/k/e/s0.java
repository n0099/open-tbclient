package c.a.r0.k2.k.e;

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
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.r0.j.g;
import c.a.r0.j.j;
import c.a.r0.k2.i.a;
import c.a.r0.k2.k.e.a1.c;
import c.a.r0.k3.h0.a;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
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
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class s0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int U1;
    public static int V1;
    public static int W1;
    public static int X1;
    public static int Y1;
    public static int Z1;
    public static int a2;
    public static final int b2;
    public static a.f c2;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.k2.k.e.h A;
    public boolean A0;
    public final FallingView A1;
    public c.a.q0.s.s.a B;
    public c.a.r0.k2.h.e B0;
    public final c.a.r0.k2.o.j.a B1;
    public c.a.q0.s.s.b C;
    public PostData C0;
    public RightFloatLayerView C1;
    public View D;
    public int D0;
    public boolean D1;
    public EditText E;
    public int E0;
    public String E1;
    public c.a.r0.k2.p.j F;
    public boolean F0;
    public CustomMessageListener F1;
    public PbListView G;
    public ViewStub G0;
    public CustomMessageListener G1;
    public c.a.r0.k2.p.f H;
    public PbInterviewStatusView H0;
    public Handler H1;
    public View I;
    public FrameLayout I0;
    public Runnable I1;
    public View J;
    public TextView J0;
    public CustomMessageListener J1;
    public View.OnClickListener K;
    public View K0;
    public PbFragment.b3 K1;
    public TbRichTextView.z L;
    public View L0;
    public boolean L1;
    public NoNetworkView.b M;
    public View M0;
    public View.OnClickListener M1;
    public PopupDialog N;
    public PbReplyTitleViewHolder N0;
    public boolean N1;
    public View.OnClickListener O;
    public View O0;
    public String O1;
    public c.a.q0.s.s.a P;
    public int P0;
    public f.g P1;
    public Dialog Q;
    public boolean Q0;
    public final List<TbImageView> Q1;
    public Dialog R;
    public p0 R0;
    public int R1;
    public View S;
    public PbEmotionBar S0;
    public boolean S1;
    public LinearLayout T;
    public int T0;
    public boolean T1;
    public CompoundButton.OnCheckedChangeListener U;
    public int U0;
    public TextView V;
    public Runnable V0;
    public TextView W;
    public PbFakeFloorModel W0;
    public String X;
    public c.a.r0.k2.k.e.t X0;
    public PopupDialog Y;
    public c.a.r0.k2.k.e.n0 Y0;
    public PopupDialog Z;
    public boolean Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f20410a;
    public c.a.q0.s.s.c a0;
    public int a1;

    /* renamed from: b  reason: collision with root package name */
    public int f20411b;
    public boolean b0;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f20412c;
    public boolean c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f20413d;
    public String d0;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public View f20414e;
    public String e0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public int f20415f;
    public c.a.r0.k2.i.c f0;
    public PbTopTipView f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f20416g;
    public ScrollView g0;
    public PopupWindow g1;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.k2.k.e.g1.c f20417h;
    public EditorTools h0;
    public TextView h1;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.k2.k.e.g1.b f20418i;
    public boolean i0;
    public List<String> i1;

    /* renamed from: j  reason: collision with root package name */
    public ViewStub f20419j;
    public View j0;
    public c.a.r0.k2.k.e.b1.c j1;
    public ViewStub k;
    public View k0;
    public c.a.r0.k2.k.d.a k1;
    public PbLandscapeListView l;
    public Button l0;
    public PbLandscapeListView.c l1;
    public NoNetworkView m;
    public View m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public c.a.r0.k2.k.e.f0 n1;
    public PbThreadPostView o;
    public LinearLayout o0;
    public NavigationBarCoverTip o1;
    public c.a.r0.k2.k.e.a1.i p;
    public HeadImageView p0;
    public c.a.r0.j.g p1;
    public c.a.r0.k2.k.e.a1.d q;
    public TextView q0;
    public c.a.r0.j.j q1;
    public c.a.r0.k2.k.e.a1.f r;
    public ImageView r0;
    public String r1;
    public c.a.r0.k2.k.e.a1.h s;
    public ImageView s0;
    public PermissionJudgePolicy s1;
    public c.a.r0.k2.k.e.a1.e t;
    public ImageView t0;
    public long t1;
    public c.a.r0.k2.k.e.a1.g u;
    public c.a.r0.k2.p.i u0;
    public boolean u1;
    public c.a.r0.k2.k.e.a1.c v;
    public TextView v0;
    public int v1;
    public LinearLayout w;
    public TextView w0;
    public int w1;
    public TextView x;
    public boolean x0;
    public boolean x1;
    public TextView y;
    public int y0;
    public c.a.r0.k2.p.h y1;
    public ObservedChangeRelativeLayout z;
    public c.a.q0.s.f0.a z0;
    public MaskView z1;

    /* loaded from: classes3.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20420a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f20421b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f20422c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20423d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f20426g;

        /* renamed from: c.a.r0.k2.k.e.s0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0970a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f20427e;

            public RunnableC0970a(a aVar) {
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
                this.f20427e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20427e.f20426g.O0 == null || this.f20427e.f20426g.O0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f20427e.f20426g.O0.getLayoutParams();
                layoutParams.height = this.f20427e.f20426g.U0;
                this.f20427e.f20426g.O0.setLayoutParams(layoutParams);
            }
        }

        public a(s0 s0Var, int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Integer.valueOf(i2), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20426g = s0Var;
            this.f20420a = i2;
            this.f20421b = pbReplyTitleViewHolder;
            this.f20422c = z;
            this.f20423d = i3;
            this.f20424e = i4;
            this.f20425f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f20420a;
                if (i3 >= 0 && i3 <= this.f20426g.f20413d.getMeasuredHeight()) {
                    int T0 = this.f20426g.T0(this.f20421b);
                    int i4 = this.f20420a;
                    int i5 = T0 - i4;
                    if (this.f20422c && i5 != 0 && i4 <= (i2 = this.f20423d)) {
                        i5 = T0 - i2;
                    }
                    if (this.f20426g.O0 == null || (layoutParams = this.f20426g.O0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f20426g.f20413d.getMeasuredHeight() || T0 >= this.f20426g.f20413d.getMeasuredHeight()) {
                        layoutParams.height = this.f20426g.U0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f20426g.f20413d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f20426g.l.setSelectionFromTop(this.f20424e, this.f20425f);
                            }
                        }
                        layoutParams.height = this.f20426g.U0;
                    }
                    this.f20426g.O0.setLayoutParams(layoutParams);
                    c.a.e.e.m.e.a().post(new RunnableC0970a(this));
                }
                this.f20426g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20429f;

        public a0(s0 s0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20429f = s0Var;
            this.f20428e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.e.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f20429f.f20412c.getPageContext(), new String[]{this.f20428e});
                    this.f20429f.f20412c.finish();
                    return;
                }
                this.f20429f.f20412c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20430e;

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
            this.f20430e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20430e.q2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f20431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f20432f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.k2.h.e f20433g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ s0 f20434h;

        public b0(s0 s0Var, Parcelable parcelable, ArrayList arrayList, c.a.r0.k2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, parcelable, arrayList, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20434h = s0Var;
            this.f20431e = parcelable;
            this.f20432f = arrayList;
            this.f20433g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20434h.l.onRestoreInstanceState(this.f20431e);
                if (ListUtils.getCount(this.f20432f) <= 1 || this.f20433g.y().b() <= 0) {
                    return;
                }
                this.f20434h.G.f();
                this.f20434h.G.A(this.f20434h.f20412c.getString(R.string.pb_load_more_without_point));
                this.f20434h.G.v();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20435a;

        public c(s0 s0Var) {
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
            this.f20435a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f20435a.W0.N(postData);
                this.f20435a.A.X();
                this.f20435a.X0.c();
                this.f20435a.h0.hideTools();
                this.f20435a.e3(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20436a;

        public c0(s0 s0Var) {
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
            this.f20436a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f20436a.f20412c != null && this.f20436a.f20412c.isAdded()) {
                if (i2 < 0 && f2 > this.f20436a.e1) {
                    this.f20436a.e0();
                    this.f20436a.R1();
                }
                this.f20436a.l0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements FallingView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20437a;

        public d(s0 s0Var) {
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
            this.f20437a = s0Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20437a.C1.getTag() == this.f20437a.A1) {
                this.f20437a.C1.setTag(null);
                this.f20437a.C1.setAutoCompleteShown(true);
                this.f20437a.C1.completeShow();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f20437a.C1.setAutoCompleteShown(false);
                if (this.f20437a.C1.getVisibility() == 0) {
                    this.f20437a.C1.setTag(this.f20437a.A1);
                    this.f20437a.C1.completeHide();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20438e;

        public d0(s0 s0Var) {
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
            this.f20438e = s0Var;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20438e.e0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20439a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(s0 s0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Integer.valueOf(i2)};
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
            this.f20439a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f20439a.A == null) {
                return;
            }
            this.f20439a.A.X();
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20441f;

        public e0(s0 s0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20441f = s0Var;
            this.f20440e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20441f.B1 == null || this.f20441f.B0 == null) {
                return;
            }
            this.f20441f.C1.inPbLastCloseTime();
            if (!UtilHelper.isMatchScheme(this.f20441f.f20412c.getContext(), this.f20441f.B1.c(this.f20441f.B0.j0()), this.f20441f.B1.b(this.f20441f.B0.j0())) && !StringUtils.isNull(this.f20440e)) {
                this.f20441f.K1(this.f20440e);
            }
            this.f20441f.C1.setAutoCompleteShown(false);
            this.f20441f.k1();
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            ThirdStatisticHelper.sendReq(this.f20441f.B1.e(this.f20441f.B0.j0()));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20442e;

        public f(s0 s0Var) {
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
            this.f20442e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20442e.w == null) {
                    this.f20442e.p1();
                }
                this.f20442e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20443e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f0 f20444e;

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
                this.f20444e = f0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f20444e.f20443e.f20412c.HidenSoftKeyPad((InputMethodManager) this.f20444e.f20443e.f20412c.getBaseFragmentActivity().getSystemService("input_method"), this.f20444e.f20443e.f20413d);
                }
            }
        }

        public f0(s0 s0Var) {
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
            this.f20443e = s0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f20443e.V0 == null) {
                    this.f20443e.V0 = new a(this);
                }
                c.a.e.e.m.e.a().postDelayed(this.f20443e.V0, 150L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(s0 s0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Integer.valueOf(i2)};
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
            this.f20445a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f20445a.x0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0(s0 s0Var) {
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
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20446e;

        public h(s0 s0Var) {
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
            this.f20446e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20446e.q2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h0(s0 s0Var) {
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
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20447e;

        public i(s0 s0Var) {
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
            this.f20447e = s0Var;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f15111c;
                if (obj instanceof c.a.q0.t.c.v) {
                    if (((c.a.q0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((c.a.q0.t.c.v) aVar.f15111c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f20447e.s1 == null) {
                            this.f20447e.s1 = new PermissionJudgePolicy();
                        }
                        this.f20447e.s1.clearRequestPermissionList();
                        this.f20447e.s1.appendRequestPermission(this.f20447e.f20412c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f20447e.s1.startRequestPermission(this.f20447e.f20412c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f20447e.f20412c.getPbEditor().h((c.a.q0.t.c.v) aVar.f15111c);
                        this.f20447e.f20412c.getPbEditor().B(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20449f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f20450g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f20451h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ s0 f20452i;

        public i0(s0 s0Var, int i2, int i3, int i4, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20452i = s0Var;
            this.f20448e = i2;
            this.f20449f = i3;
            this.f20450g = i4;
            this.f20451h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f20448e;
                if (i2 == this.f20449f || i2 - this.f20450g >= 0) {
                    this.f20452i.g1.showAsDropDown(this.f20452i.n0, this.f20451h.getLeft(), -this.f20452i.n0.getHeight());
                } else {
                    this.f20452i.g1.showAsDropDown(this.f20451h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20453e;

        public j(s0 s0Var) {
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
            this.f20453e = s0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f20453e.f20412c.mContentProcessController == null || this.f20453e.f20412c.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f20453e.f20412c.mContentProcessController.e().e()) {
                this.f20453e.f20412c.mContentProcessController.a(false);
            }
            this.f20453e.f20412c.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f20453e.h0 == null || this.f20453e.h0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f20453e.j1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f20453e.h0.getId());
                s0 s0Var = this.f20453e;
                s0Var.j1 = new c.a.r0.k2.k.e.b1.c(s0Var.f20412c.getPageContext(), this.f20453e.f20413d, layoutParams);
                if (!ListUtils.isEmpty(this.f20453e.i1)) {
                    this.f20453e.j1.m(this.f20453e.i1);
                }
                this.f20453e.j1.n(this.f20453e.h0);
            }
            this.f20453e.j1.l(substring);
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20454e;

        public j0(s0 s0Var) {
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
            this.f20454e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20454e.C1.inPbLastCloseTime();
                this.f20454e.k1();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20456f;

        public k(s0 s0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20456f = s0Var;
            this.f20455e = z;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20456f.N.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f20456f.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f20456f.K1 != null) {
                            this.f20456f.K1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20456f.f20412c.handleMuteClick(this.f20455e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20457a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(s0 s0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, Integer.valueOf(i2)};
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
            this.f20457a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f20457a.E1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(s0 s0Var) {
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
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20459f;

        public l0(s0 s0Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20459f = s0Var;
            this.f20458e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20459f.x1 || this.f20458e == null || this.f20459f.f20412c.getPbModel() == null || !this.f20459f.f20412c.getPbModel().r1()) {
                return;
            }
            this.f20459f.x1 = true;
            this.f20458e.checkEasterEgg(false);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f20462g;

        public m(s0 s0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20462g = s0Var;
            this.f20460e = alertDialog;
            this.f20461f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f20460e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20462g.f20412c.getPbActivity(), R.string.neterror);
                } else {
                    this.f20462g.f20412c.deleteThread(this.f20461f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20463a;

        public m0(s0 s0Var) {
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
            this.f20463a = s0Var;
        }

        @Override // c.a.r0.k2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20463a.f20412c.hideKeyBroad();
            }
        }

        @Override // c.a.r0.k2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f20463a.l == null) {
                return;
            }
            if (this.f20463a.p != null) {
                this.f20463a.p.t();
            }
            this.f20463a.l.setSelection(0);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20464e;

        public n(s0 s0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20464e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20464e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20465e;

        public n0(s0 s0Var) {
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
            this.f20465e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.q0.s.q.t0(this.f20465e.f20412c.getActivity(), "pb_huitie"))) {
                this.f20465e.f20412c.processProfessionPermission();
                if (this.f20465e.f20412c == null || this.f20465e.f20412c.getPbModel() == null || this.f20465e.f20412c.getPbModel().P0() == null || this.f20465e.f20412c.getPbModel().P0().O() == null || this.f20465e.f20412c.getPbModel().P0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f20465e.f20412c.getPbModel().g1()).param("fid", this.f20465e.f20412c.getPbModel().P0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f20465e.f20412c.getPbModel().f55227f).param("fid", this.f20465e.f20412c.getPbModel().P0().n()).param("obj_locate", 1).param("uid", this.f20465e.f20412c.getPbModel().P0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20467f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f20468g;

        public o(s0 s0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20468g = s0Var;
            this.f20466e = alertDialog;
            this.f20467f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f20466e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20468g.f20412c.getPbActivity(), R.string.neterror);
                } else {
                    this.f20468g.f20412c.deleteThread(this.f20467f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20469e;

        public o0(s0 s0Var) {
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
            this.f20469e = s0Var;
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
                    this.f20469e.f20412c.checkMuteState(sparseArray);
                    return;
                }
                this.f20469e.d2(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f20469e.f20412c.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f20469e.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20470e;

        public p(s0 s0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20470e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20470e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20471a;

        /* renamed from: b  reason: collision with root package name */
        public int f20472b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f20473c;

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

    /* loaded from: classes3.dex */
    public class q implements g.InterfaceC0932g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f20474a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f20475b;

        public q(s0 s0Var, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20475b = s0Var;
            this.f20474a = aVar;
        }

        @Override // c.a.r0.j.g.InterfaceC0932g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20475b.f20412c.deleteThread(this.f20474a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20476a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f20477b;

        public r(s0 s0Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20477b = s0Var;
            this.f20476a = sparseArray;
        }

        @Override // c.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20477b.f20412c.deleteThread(this.f20476a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20478e;

        public s(s0 s0Var) {
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
            this.f20478e = s0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f20478e.X = (String) compoundButton.getTag();
                if (this.f20478e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f20478e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f20478e.X != null && !str.equals(this.f20478e.X)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // c.a.r0.k3.h0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20479e;

        public u(s0 s0Var) {
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
            this.f20479e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f20479e.R instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f20479e.R, this.f20479e.f20412c.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f20480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20481f;

        public v(s0 s0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20481f = s0Var;
            this.f20480e = cVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20481f.Z.dismiss();
                this.f20480e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f20482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f20483f;

        public w(s0 s0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20483f = s0Var;
            this.f20482e = cVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20483f.Z.dismiss();
                this.f20482e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20484e;

        public x(s0 s0Var) {
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
            this.f20484e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f20484e.B0 == null || this.f20484e.B0.O() == null || this.f20484e.B0.O().J() == null || this.f20484e.B0.O().J().getAlaInfo() == null || this.f20484e.B0.O().J().getAlaInfo().live_status != 1) {
                    if (this.f20484e.b1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f20484e.b1 && this.f20484e.B0 != null && this.f20484e.B0.O() != null && this.f20484e.B0.O().J() != null && this.f20484e.B0.O().J().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f20484e.f20412c.getPbActivity() != null) {
                        this.f20484e.f20412c.getPbActivity().mEvent.f20137b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f20484e.B0.n());
                statisticItem2.param("fname", this.f20484e.B0.o());
                statisticItem2.param("obj_param1", this.f20484e.B0.O().J().getAlaInfo().user_info != null ? this.f20484e.B0.O().J().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f20484e.B0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f20484e.B0.O().J().getAlaInfo()));
                if (this.f20484e.B0.O().J().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f20484e.B0.O().J().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f20484e.B0.O().J().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f20484e.f20412c.getPageContext(), this.f20484e.B0.O().J().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f20485a;

        public y(s0 s0Var) {
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
            this.f20485a = s0Var;
        }

        @Override // c.a.r0.k2.k.e.a1.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f20485a.v.a(this.f20485a.l);
                } else {
                    this.f20485a.v.d(this.f20485a.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f20486e;

        public z(s0 s0Var) {
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
            this.f20486e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            s0 s0Var;
            c.a.r0.k2.k.e.g1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20486e.A == null || (cVar = (s0Var = this.f20486e).f20417h) == null || cVar.f20296i == null || s0Var.B0 == null || this.f20486e.B0.O() == null || this.f20486e.B0.O().E2() || this.f20486e.F1() || this.f20486e.B0.m() == null || c.a.e.e.p.k.isEmpty(this.f20486e.B0.m().getName())) {
                return;
            }
            if ((this.f20486e.A.H() == null || !this.f20486e.A.H().isShown()) && (linearLayout = this.f20486e.f20417h.f20296i) != null) {
                linearLayout.setVisibility(0);
                if (this.f20486e.f20412c == null || this.f20486e.f20412c.getPbModel() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f20486e.f20412c.getPbModel().f1());
                statisticItem.param("fid", this.f20486e.f20412c.getPbModel().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(214158483, "Lc/a/r0/k2/k/e/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(214158483, "Lc/a/r0/k2/k/e/s0;");
                return;
            }
        }
        U1 = UtilHelper.getLightStatusBarHeight();
        V1 = 3;
        W1 = 0;
        X1 = 3;
        Y1 = 4;
        Z1 = 5;
        a2 = 6;
        b2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        c2 = new t();
    }

    public s0(PbFragment pbFragment, View.OnClickListener onClickListener, c.a.r0.k2.i.c cVar) {
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
        this.f20412c = null;
        this.f20413d = null;
        this.f20414e = null;
        this.f20415f = 0;
        this.f20416g = new Handler();
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
        this.K = null;
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
        this.b0 = false;
        this.c0 = false;
        this.d0 = null;
        this.e0 = null;
        this.g0 = null;
        this.i0 = false;
        this.l0 = null;
        this.n0 = null;
        this.q0 = null;
        this.x0 = true;
        this.z0 = null;
        this.A0 = false;
        this.E0 = 3;
        this.F0 = false;
        this.G0 = null;
        this.P0 = 0;
        this.Q0 = true;
        this.R0 = new p0();
        this.T0 = 0;
        this.Z0 = false;
        this.a1 = 0;
        this.b1 = false;
        this.c1 = false;
        this.d1 = false;
        this.e1 = 0;
        this.m1 = false;
        this.t1 = 0L;
        this.w1 = 0;
        this.F1 = new k0(this, 2921306);
        this.G1 = new e(this, 2005016);
        this.H1 = new Handler();
        this.J1 = new g(this, 2004009);
        this.L1 = true;
        this.M1 = new x(this);
        this.N1 = false;
        this.O1 = null;
        this.Q1 = new ArrayList();
        this.S1 = false;
        this.t1 = System.currentTimeMillis();
        this.f20412c = pbFragment;
        this.K = onClickListener;
        this.f0 = cVar;
        this.e1 = c.a.e.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f20412c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f20413d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.j0 = this.f20413d.findViewById(R.id.bottom_shadow);
        this.o1 = (NavigationBarCoverTip) this.f20413d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f20414e = this.f20413d.findViewById(R.id.statebar_view);
        this.C1 = (RightFloatLayerView) this.f20413d.findViewById(R.id.right_layer_view);
        this.z = (ObservedChangeRelativeLayout) this.f20413d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f20413d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f20413d.findViewById(R.id.new_pb_list);
        this.I0 = (FrameLayout) this.f20413d.findViewById(R.id.root_float_header);
        this.J0 = new TextView(this.f20412c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f20412c.getActivity(), R.dimen.ds88));
        this.l.addHeaderView(this.J0, 0);
        this.l.setTextViewAdded(true);
        this.U0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.O0 = new View(this.f20412c.getPageContext().getPageActivity());
        if (c.a.q0.g1.b.c.d()) {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, this.U0));
        }
        this.O0.setVisibility(4);
        this.l.addFooterView(this.O0);
        this.l.setOnTouchListener(this.f20412c.mOnTouchListener);
        this.f20410a = new l0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f20410a);
        this.f20417h = new c.a.r0.k2.k.e.g1.c(pbFragment, this.f20413d);
        if (this.f20412c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f20413d.findViewById(R.id.manga_view_stub);
            this.f20419j = viewStub;
            viewStub.setVisibility(0);
            c.a.r0.k2.k.e.g1.b bVar = new c.a.r0.k2.k.e.g1.b(pbFragment);
            this.f20418i = bVar;
            bVar.c();
            this.f20417h.f20288a.setVisibility(8);
            layoutParams.height = c.a.e.e.p.l.g(this.f20412c.getActivity(), R.dimen.ds120);
        }
        this.J0.setLayoutParams(layoutParams);
        this.f20417h.p().setOnTouchListener(new c.a.r0.k2.i.a(new m0(this)));
        this.m0 = this.f20413d.findViewById(R.id.view_comment_top_line);
        this.n0 = this.f20413d.findViewById(R.id.pb_editor_tool_comment);
        c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.y0 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f20413d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.p0 = headImageView;
        headImageView.setVisibility(0);
        this.p0.setIsRound(true);
        this.p0.setBorderWidth(c.a.e.e.p.l.g(this.f20412c.getContext(), R.dimen.L_X01));
        this.p0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.p0.setPlaceHolder(0);
        L1();
        this.q0 = (TextView) this.f20413d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f20413d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.o0 = linearLayout;
        linearLayout.setOnClickListener(new n0(this));
        this.r0 = (ImageView) this.f20413d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.z1 = (MaskView) this.f20413d.findViewById(R.id.mask_view);
        this.r0.setOnClickListener(this.K);
        boolean booleanExtra = this.f20412c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f20413d.findViewById(R.id.pb_editor_tool_collection);
        this.s0 = imageView;
        imageView.setOnClickListener(this.K);
        if (booleanExtra) {
            this.s0.setVisibility(8);
        } else {
            this.s0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f20413d.findViewById(R.id.pb_editor_tool_share);
        this.t0 = imageView2;
        imageView2.setOnClickListener(this.K);
        this.u0 = new c.a.r0.k2.p.i(this.t0);
        if (!c.a.q0.b.d.S() && !c.a.q0.b.d.T()) {
            this.u0.e();
        }
        TextView textView = (TextView) this.f20413d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.v0 = textView;
        textView.setVisibility(0);
        this.G0 = (ViewStub) this.f20413d.findViewById(R.id.interview_status_stub);
        this.q = new c.a.r0.k2.k.e.a1.d(this.f20412c, cVar);
        this.s = new c.a.r0.k2.k.e.a1.h(this.f20412c, cVar, this.K);
        c.a.r0.k2.k.e.h hVar = new c.a.r0.k2.k.e.h(this.f20412c, this.l);
        this.A = hVar;
        hVar.q0(this.K);
        this.A.s0(this.f0);
        this.A.n0(this.L);
        this.A.p0(this.f20412c.onSwitchChangeListener);
        o0 o0Var = new o0(this);
        this.O = o0Var;
        this.A.m0(o0Var);
        t1();
        n1();
        c.a.r0.k2.k.e.a1.g gVar = new c.a.r0.k2.k.e.a1.g(this.f20412c);
        this.u = gVar;
        gVar.f20013f = 2;
        m1();
        this.v.a(this.l);
        this.r.a(this.l);
        this.s.h(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f20412c.getPageContext().getPageActivity());
        this.G = pbListView;
        View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
        this.I = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.K);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        this.G.x();
        this.G.n(R.drawable.pb_foot_more_trans_selector);
        this.G.o(R.drawable.pb_foot_more_trans_selector);
        this.J = this.f20413d.findViewById(R.id.viewstub_progress);
        this.f20412c.registerListener(this.J1);
        this.W0 = new PbFakeFloorModel(this.f20412c.getPageContext());
        PbModel pbModel = this.f20412c.getPbModel();
        this.W0.P(pbModel.F(), pbModel.B(), pbModel.C(), pbModel.A(), pbModel.G());
        c.a.r0.k2.k.e.t tVar = new c.a.r0.k2.k.e.t(this.f20412c.getPageContext(), this.W0, this.f20413d);
        this.X0 = tVar;
        tVar.k(new b(this));
        this.X0.m(this.f20412c.mOnFloorPostWriteNewCallback);
        this.W0.R(new c(this));
        if (this.f20412c.getPbModel() != null && !StringUtils.isNull(this.f20412c.getPbModel().S0())) {
            PbFragment pbFragment2 = this.f20412c;
            pbFragment2.showToast(pbFragment2.getPbModel().S0());
        }
        this.K0 = this.f20413d.findViewById(R.id.pb_expand_blank_view);
        this.L0 = this.f20413d.findViewById(R.id.bottom_rec_float_title);
        View findViewById2 = this.f20413d.findViewById(R.id.sticky_view);
        this.M0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f20412c.getPbModel() != null && this.f20412c.getPbModel().C0()) {
            this.K0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.M0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = U1;
            this.M0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f20412c.getPageContext(), this.f20413d.findViewById(R.id.pb_reply_expand_view));
        this.N0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
        this.N0.mDivideLineTop.setVisibility(8);
        this.N0.setPbCommonOnclickListener(this.K);
        this.N0.setOnSwitchChangeListener(this.f20412c.onSwitchChangeListener);
        this.f20412c.registerListener(this.G1);
        this.f20412c.registerListener(this.F1);
        PbFragment pbFragment3 = this.f20412c;
        this.y1 = new c.a.r0.k2.p.h(pbFragment3, pbFragment3.getUniqueId());
        FallingView fallingView = (FallingView) this.f20413d.findViewById(R.id.falling_view);
        this.A1 = fallingView;
        fallingView.setAnimationListener(new d(this));
        Z();
        p2(false);
        this.k0 = this.f20413d.findViewById(R.id.pb_comment_container);
        Y(c.a.q0.g1.b.c.d());
        this.B1 = new c.a.r0.k2.o.j.a();
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
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
            this.m1 = z2;
        }
    }

    public final void A3(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null || eVar.O() == null || eVar.O().E2()) {
            return;
        }
        boolean z2 = eVar.O().q0() == 1;
        boolean z3 = eVar.O().r0() == 1;
        c.a.r0.k2.k.e.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.j(eVar, z2, z3);
        }
        c.a.r0.k2.k.e.h hVar2 = this.A;
        if (hVar2 == null || hVar2.t() == null) {
            return;
        }
        this.A.t().showThreadTypeStampBottomPart(eVar, z2, z3);
    }

    public TextView B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s.l() : (TextView) invokeV.objValue;
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
        c.a.r0.k2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.r(z2);
    }

    @SuppressLint({"CutPasteId"})
    public void B3(c.a.r0.k2.h.e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, eVar, z2) == null) || eVar == null) {
            return;
        }
        K3(eVar, z2);
        h0();
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.r0.k2.p.i iVar = this.u0;
            if (iVar != null) {
                return iVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.O1) : invokeV.booleanValue;
    }

    public void C2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.A.f0(z2);
        }
    }

    public void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f20412c.showToast(str);
        }
    }

    public PbInterviewStatusView D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.H0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean D1(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, d2Var)) == null) {
            if (d2Var == null || d2Var.J() == null) {
                return false;
            }
            PostData x0 = x0(this.B0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (x0 == null || x0.t() == null) ? "" : x0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void D2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.A.k0(z2);
        }
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f20412c.showProgressBar();
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m1 : invokeV.booleanValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View view = this.O0;
            if (view == null || view.getParent() == null || this.G.l()) {
                return false;
            }
            int bottom = this.O0.getBottom();
            Rect rect = new Rect();
            this.O0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void E2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            this.P1 = gVar;
            c.a.r0.k2.p.j jVar = this.F;
            if (jVar != null) {
                jVar.a(gVar);
            }
        }
    }

    public void E3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (fallingView = this.A1) == null) {
            return;
        }
        fallingView.stopAllViews();
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.p != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return y0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.r0.k2.h.e eVar = this.B0;
            return eVar == null || eVar.m() == null || "0".equals(this.B0.m().getId()) || "me0407".equals(this.B0.m().getName());
        }
        return invokeV.booleanValue;
    }

    public void F2(String str) {
        c.a.r0.k2.k.e.g1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (bVar = this.f20418i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void F3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.Q1 == null) {
            return;
        }
        while (this.Q1.size() > 0) {
            TbImageView remove = this.Q1.remove(0);
            if (remove != null) {
                remove.stopLoading();
            }
        }
    }

    public BdTypeListView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.Z0 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.a1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            this.b0 = z2;
        }
    }

    public SparseArray<Object> H0(c.a.r0.k2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData x0;
        c.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (x0 = x0(eVar, z2)) == null) {
                return null;
            }
            String userId = x0.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, x0.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (x0.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, x0.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, x0.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, x0.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, x0.E());
                }
                sparseArray.put(R.id.tag_del_post_id, x0.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<z1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (z1 z1Var : q2) {
                        if (z1Var != null && !StringUtils.isNull(z1Var.getForumName()) && (e0Var = z1Var.f14399g) != null && e0Var.f14175a && !e0Var.f14177c && ((i3 = e0Var.f14176b) == 1 || i3 == 2)) {
                            sb.append(c.a.e.e.p.k.cutString(z1Var.getForumName(), 12));
                            sb.append(this.f20412c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f20412c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.D1 : invokeV.booleanValue;
    }

    public void H2(PbFragment.c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, c3Var) == null) {
        }
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) {
            this.f20417h.H(z2);
            if (z2 && this.F0) {
                this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.G);
                this.f20415f = 2;
            }
            L1();
        }
    }

    public c.a.r0.k2.k.d.a I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.k1 : (c.a.r0.k2.k.d.a) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            c.a.r0.k2.p.i iVar = this.u0;
            if (iVar == null) {
                return false;
            }
            return iVar.h();
        }
        return invokeV.booleanValue;
    }

    public void I2(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.L = zVar;
            this.A.n0(zVar);
            this.k1.q(this.L);
        }
    }

    public void I3(c.a.r0.k2.h.c cVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f20417h.I();
        if (!StringUtils.isNull(cVar.f19798b)) {
            this.f20417h.F(cVar.f19798b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int e2 = c.a.e.e.m.b.e(cVar.f19797a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f20412c.showNetRefreshView(this.f20413d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new a0(this, cVar.f19799c));
    }

    public final int J0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.H0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            EditorTools editorTools = this.h0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void J2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
            this.M = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void J3(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.O())) {
                c.a.r0.k2.p.i iVar = this.u0;
                if (iVar != null) {
                    iVar.k(false);
                    this.u0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.t0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.t0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.r0.k2.p.i iVar2 = this.u0;
            if (iVar2 == null || !iVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.t0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.t0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public final void K1(String str) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || (pbFragment = this.f20412c) == null || pbFragment.getPageContext() == null || this.f20412c.getPageContext().getPageActivity() == null) {
            return;
        }
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f20412c.getPageContext().getPageActivity(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public void K2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public boolean K3(c.a.r0.k2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048619, this, eVar, z2)) == null) {
            if (eVar == null) {
                return false;
            }
            if (this.r != null) {
                if (eVar.O() != null && eVar.O().n0() == 0 && !eVar.O().E2() && !this.D1) {
                    if (eVar.O() != null) {
                        d2 O = eVar.O();
                        O.Z2(true, h3(eVar));
                        O.n4(3);
                        O.i4("2");
                    }
                    if (eVar.O().M1()) {
                        this.s.t(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.h(this.l);
                        this.s.x(this.B0);
                        if (x1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(eVar);
                        }
                    } else {
                        this.s.x(this.B0);
                        if (x1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.g(eVar);
                        }
                    }
                } else if (eVar.O().n0() == 1) {
                    if (eVar.O() != null) {
                        this.r.d(this.l);
                        this.s.x(this.B0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.x(this.B0);
                }
            }
            A3(eVar);
            this.A0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public PbListView L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.p0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.p0.setImageResource(0);
                this.p0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.p0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public void L2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.f20412c.getIsMangaThread()) {
            if (this.f20412c.getMangaPrevChapterId() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
            if (this.f20412c.getMangaNextChapterId() == -1) {
                SkinManager.setViewTextColor(this.y, R.color.CAM_X0110, 1);
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
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || this.E0 == i2) {
            return;
        }
        this.E0 = i2;
        B3(this.B0, this.A0);
        k2(this.B0, this.A0, this.D0, i2);
        this.f20412c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f20412c.getBaseFragmentActivity().getLayoutMode().j(this.f20413d);
        SkinManager.setBackgroundColor(this.f20413d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
        c.a.r0.k2.k.e.a1.i iVar = this.p;
        if (iVar != null) {
            iVar.h(i2);
        }
        c.a.r0.k2.k.e.a1.e eVar = this.t;
        if (eVar != null) {
            eVar.c(i2);
        }
        c.a.r0.k2.k.e.a1.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
        c.a.r0.k2.k.e.a1.f fVar = this.r;
        if (fVar != null) {
            fVar.c(i2);
        }
        c.a.r0.k2.k.e.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.q(i2);
        }
        c.a.r0.k2.k.e.a1.g gVar = this.u;
        if (gVar != null) {
            gVar.d();
        }
        c.a.r0.k2.k.e.a1.c cVar = this.v;
        if (cVar != null) {
            cVar.c();
        }
        MaskView maskView = this.z1;
        if (maskView != null) {
            maskView.onChangeSkin();
        }
        PbListView pbListView = this.G;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.I != null) {
            this.f20412c.getBaseFragmentActivity().getLayoutMode().j(this.I);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        c.a.q0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f20412c.getPageContext());
        }
        G3(this.b0);
        this.A.X();
        c.a.r0.k2.p.j jVar = this.F;
        if (jVar != null) {
            jVar.D(i2);
        }
        EditorTools editorTools = this.h0;
        if (editorTools != null) {
            editorTools.onChangeSkinType(i2);
        }
        c.a.r0.k2.p.f fVar2 = this.H;
        if (fVar2 != null) {
            fVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.onChangeSkinMode();
            }
        }
        L3();
        UtilHelper.setStatusBarBackground(this.f20414e, i2);
        UtilHelper.setStatusBarBackground(this.M0, i2);
        if (this.w != null) {
            c.a.q0.w0.a.a(this.f20412c.getPageContext(), this.w);
        }
        c.a.r0.k2.k.e.t tVar = this.X0;
        if (tVar != null) {
            tVar.h(i2);
        }
        c.a.r0.k2.k.e.g1.c cVar2 = this.f20417h;
        if (cVar2 != null) {
            c.a.r0.k2.k.e.a1.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.i(i2);
            } else {
                cVar2.u(i2);
            }
        }
        HeadImageView headImageView = this.p0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.o0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f20412c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        c.a.r0.k2.h.e eVar2 = this.B0;
        if (eVar2 != null && eVar2.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        J3(this.B0);
        SkinManager.setBackgroundColor(this.n0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.h1, R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.q0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.w0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.v0, R.color.CAM_X0107);
        TextView textView = this.v0;
        int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        c.a.r0.k2.k.d.a aVar2 = this.k1;
        if (aVar2 != null) {
            aVar2.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.S0;
        if (pbEmotionBar != null) {
            pbEmotionBar.onChangeSkinType();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.onSkinChange(i2);
        }
        c.a.r0.k2.p.i iVar3 = this.u0;
        if (iVar3 != null) {
            iVar3.i();
        }
        c.a.r0.k2.p.h hVar2 = this.y1;
        if (hVar2 != null) {
            hVar2.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.L0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0.findViewById(R.id.tv_title), R.color.CAM_X0105);
    }

    public void M2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
            this.A.r0(onClickListener);
        }
    }

    public void M3(c.a.r0.k2.h.e eVar) {
        c.a.r0.k2.k.e.a1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, eVar) == null) || (dVar = this.q) == null) {
            return;
        }
        dVar.h(eVar, this.A0);
    }

    public View N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.K0 : (View) invokeV.objValue;
    }

    public void N1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, configuration) == null) || configuration == null) {
            return;
        }
        e0();
        if (configuration.orientation == 2) {
            d1();
            f1();
        } else {
            q2();
        }
        c.a.r0.k2.k.e.t tVar = this.X0;
        if (tVar != null) {
            tVar.c();
        }
        this.f20412c.hideKeyBroad();
        this.z.setVisibility(8);
        this.f20417h.B(false);
        this.f20412c.setNavigationBarShowFlag(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                Z0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.T1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.T1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.R1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.p.j(configuration);
            this.I0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void N2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.v1 = i2;
        }
    }

    public PbFakeFloorModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.W0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void O1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            RelativeLayout relativeLayout = this.f20413d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f20413d.getHandler().removeCallbacksAndMessages(null);
            }
            c.a.r0.k2.p.i iVar = this.u0;
            if (iVar != null) {
                iVar.j();
            }
            c.a.r0.k2.k.e.n0 n0Var = this.Y0;
            if (n0Var != null) {
                n0Var.a();
            }
            c.a.r0.k2.k.e.f0 f0Var = this.n1;
            if (f0Var != null) {
                f0Var.c();
            }
            PbTopTipView pbTopTipView = this.f1;
            if (pbTopTipView != null) {
                pbTopTipView.hide();
            }
            this.f20412c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.M) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            e0();
            k0();
            if (this.V0 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.V0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.H0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.clearStatus();
            }
            this.H1 = null;
            this.f20416g.removeCallbacksAndMessages(null);
            this.A.Y(3);
            View view = this.f20414e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            c.a.r0.k2.k.e.a1.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.a();
            }
            c.a.r0.k2.k.e.h hVar = this.A;
            if (hVar != null) {
                hVar.Z();
            }
            this.l.setOnLayoutListener(null);
            c.a.r0.k2.k.e.b1.c cVar = this.j1;
            if (cVar != null) {
                cVar.h();
            }
            PbEmotionBar pbEmotionBar = this.S0;
            if (pbEmotionBar != null) {
                pbEmotionBar.onDestroy();
            }
            c.a.r0.k2.k.e.a1.h hVar2 = this.s;
            if (hVar2 != null) {
                hVar2.r();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f20410a);
            }
        }
    }

    public void O2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onLongClickListener) == null) {
            this.s.u(onLongClickListener);
            this.A.o0(onLongClickListener);
            c.a.r0.k2.k.d.a aVar = this.k1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public c.a.r0.k2.k.e.t P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.X0 : (c.a.r0.k2.k.e.t) invokeV.objValue;
    }

    public void P1(TbRichText tbRichText) {
        c.a.r0.k2.h.e eVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, tbRichText) == null) || (eVar = this.B0) == null || eVar.F() == null || this.B0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.B0.F().size() && (postData = this.B0.F().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.B0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                c.a.r0.k2.k.d.a aVar = this.k1;
                if (aVar != null && aVar.l()) {
                    e3(false);
                }
                PbEmotionBar pbEmotionBar = this.S0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.autoShow(true);
                }
                postData.t().getName_show();
                return;
            }
        }
    }

    public final void P2(PostData postData, c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, postData, eVar) == null) {
            this.s.v(postData, eVar);
        }
    }

    public c.a.r0.k2.k.e.a1.i Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.p : (c.a.r0.k2.k.e.a1.i) invokeV.objValue;
    }

    public boolean Q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void Q2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048639, this, z2, postWriteCallBackData) == null) {
            this.f20412c.hideProgressBar();
            if (z2) {
                e0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                f0();
            } else {
                e0();
            }
        }
    }

    public final PostData R0(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null || eVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = eVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> A1 = eVar.O().A1();
            if (A1 != null && (metaData = A1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.k0(1);
            postData.n0(eVar.O().W());
            postData.z0(eVar.O().getTitle());
            postData.y0(eVar.O().P());
            postData.i0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void R1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.f20412c == null) {
            return;
        }
        if ((this.u1 || this.v1 == 17) && c.a.q0.b.d.h0()) {
            c.a.r0.k2.h.e eVar = this.B0;
            if (eVar == null || eVar.m() == null || c.a.e.e.p.k.isEmpty(this.B0.m().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f20412c.getContext()).createNormalCfg(this.B0.m().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.B0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.B0.m().getId()));
        } else if (!this.c1 || this.b1 || (postData = this.C0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f20412c.isSimpleForum() ? 2 : 1).param("obj_type", this.b1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20412c.getPageContext().getPageActivity(), this.C0.t().getUserId(), this.C0.t().getUserName(), this.f20412c.getPbModel().q0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.f20412c.hideProgressBar();
            k0();
            this.l.completePullRefreshPostDelayed(0L);
            h0();
        }
    }

    public final boolean S(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048643, this, absListView, i2)) == null) {
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

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (!c.a.e.e.p.k.isEmpty(this.r1)) {
                return this.r1;
            }
            if (this.f20412c != null) {
                this.r1 = TbadkCoreApplication.getInst().getResources().getString(q0.b());
            }
            return this.r1;
        }
        return (String) invokeV.objValue;
    }

    public void S1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            if (z2) {
                k3();
            } else {
                g1();
            }
            this.R0.f20473c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            f2(this.R0.f20473c, false);
        }
    }

    public void S2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (pbFragment = this.f20412c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        c.a.e.e.p.l.x(this.f20412c.getPageContext().getPageActivity(), this.f20412c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void T() {
        c.a.r0.k2.p.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (iVar = this.u0) == null) {
            return;
        }
        iVar.l(false);
    }

    public final int T0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, pbReplyTitleViewHolder)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            F3();
            this.A.Y(1);
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.G.x();
            this.G.O();
        }
    }

    public boolean U(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z2)) == null) {
            EditorTools editorTools = this.h0;
            if (editorTools == null || !editorTools.isToolVisible()) {
                return false;
            }
            this.h0.hideTools();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.A.Y(2);
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f20412c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f20412c.getFragmentActivity())) {
                    return;
                }
                b1().setSystemUiVisibility(4);
            }
        }
    }

    public void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            this.s.w(z2);
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbListView pbListView = this.G;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.G.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public final int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
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
        c.a.r0.k2.k.e.a1.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048657, this, absListView, i2, i3, i4) == null) {
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            c.a.r0.k2.k.e.g1.c cVar = this.f20417h;
            if (cVar != null && (hVar = this.s) != null) {
                cVar.w(hVar.m());
            }
            p0 p0Var = this.R0;
            p0Var.f20471a = i2;
            p0Var.f20472b = this.l.getHeaderViewsCount();
            this.R0.f20473c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            d3(S(absListView, i2));
            int i5 = 0;
            f2(this.R0.f20473c, false);
            d0();
            if (!this.G.m() || this.G.C) {
                return;
            }
            p0 p0Var2 = this.R0;
            if (p0Var2 != null && (pbReplyTitleViewHolder = p0Var2.f20473c) != null && pbReplyTitleViewHolder.getView() != null) {
                i5 = this.R0.f20473c.getView().getTop() < 0 ? this.R0.f20473c.getView().getHeight() : this.R0.f20473c.getView().getBottom();
            }
            this.G.e(i5);
            this.G.C = true;
        }
    }

    public void V2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.q0.performClick();
            if (StringUtils.isNull(str) || this.f20412c.getPbEditor() == null || this.f20412c.getPbEditor().w() == null || this.f20412c.getPbEditor().w().i() == null) {
                return;
            }
            EditText i2 = this.f20412c.getPbEditor().w().i();
            i2.setText(str);
            i2.setSelection(str.length());
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || this.B0 == null || !c.a.q0.b.d.S() || c.a.r0.k2.k.e.f1.b.k(this.B0.Q())) {
            return;
        }
        this.u0.e();
        c.a.r0.k2.k.e.f1.b.b(this.B0.Q());
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.E0 : invokeV.intValue;
    }

    public void W1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048661, this, absListView, i2) == null) {
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.T1 && i2 == 0) {
                this.R1 = V0();
                this.R0.f20473c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
                f2(this.R0.f20473c, true);
                d0();
                this.A.b0(true);
            }
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

    public void W2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            if (!this.f20412c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.e0));
            } else if (this.f20412c.checkPrivacyBeforeInput()) {
                c.a.q0.x.x.e pbEditor = this.f20412c.getPbEditor();
                if (pbEditor != null && (pbEditor.D() || pbEditor.F())) {
                    this.f20412c.getPbEditor().B(false, null);
                    return;
                }
                if (this.h0 != null) {
                    q1();
                }
                EditorTools editorTools = this.h0;
                if (editorTools != null) {
                    this.x0 = false;
                    if (editorTools.findToolById(2) != null) {
                        c.a.r0.k3.h0.a.c(this.f20412c.getPageContext(), (View) this.h0.findToolById(2).k, false, c2);
                    }
                }
                d1();
            }
        }
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.f20414e : (View) invokeV.objValue;
    }

    public void X1(ArrayList<c.a.q0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, arrayList) == null) {
            if (this.S == null) {
                this.S = LayoutInflater.from(this.f20412c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f20412c.getBaseFragmentActivity().getLayoutMode().j(this.S);
            if (this.R == null) {
                Dialog dialog = new Dialog(this.f20412c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.R = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.R.setCancelable(true);
                this.g0 = (ScrollView) this.S.findViewById(R.id.good_scroll);
                this.R.setContentView(this.S);
                WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.R.getWindow().setAttributes(attributes);
                this.U = new s(this);
                this.T = (LinearLayout) this.S.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.S.findViewById(R.id.dialog_button_cancel);
                this.W = textView;
                textView.setOnClickListener(new u(this));
                TextView textView2 = (TextView) this.S.findViewById(R.id.dialog_button_ok);
                this.V = textView2;
                textView2.setOnClickListener(this.K);
            }
            this.T.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton a02 = a0("0", this.f20412c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(a02);
            a02.setChecked(true);
            this.T.addView(a02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton a03 = a0(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(a03);
                        View view = new View(this.f20412c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.T.addView(view);
                        this.T.addView(a03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.g0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20412c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20412c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20412c.getPageContext().getPageActivity(), 186.0f);
                }
                this.g0.setLayoutParams(layoutParams2);
                this.g0.removeAllViews();
                LinearLayout linearLayout = this.T;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.g0.addView(this.T);
                }
            }
            c.a.e.e.m.g.j(this.R, this.f20412c.getPageContext());
        }
    }

    public void X2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, list) == null) {
            this.i1 = list;
            c.a.r0.k2.k.e.b1.c cVar = this.j1;
            if (cVar != null) {
                cVar.m(list);
            }
        }
    }

    public void Y(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view = this.k0;
            if (view != null) {
                view.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.I(z2 ? 8 : 0);
            }
            View view2 = this.I;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public PbThreadPostView Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void Y1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            Z1(i2, str, i3, z2, null);
        }
    }

    public final boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            PbFragment pbFragment = this.f20412c;
            return (pbFragment == null || pbFragment.getPbModel().P0().m().getDeletedReasonInfo() == null || 1 != this.f20412c.getPbModel().P0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            c.a.r0.k2.k.d.a aVar = new c.a.r0.k2.k.d.a(this.f20412c, this, (ViewStub) this.f20413d.findViewById(R.id.more_god_reply_popup));
            this.k1 = aVar;
            aVar.o(this.K);
            this.k1.p(this.O);
            this.k1.q(this.L);
            this.k1.o(this.K);
            this.k1.s(this.f0);
        }
    }

    public RelativeLayout Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.z : (RelativeLayout) invokeV.objValue;
    }

    public void Z1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            a2(i2, str, i3, z2, str2, false);
        }
    }

    public void Z2() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.I0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c.a.r0.k2.k.e.g1.c cVar = this.f20417h;
            if (cVar == null || (view = cVar.f20291d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public final CustomBlueCheckRadioButton a0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048676, this, str, str2)) == null) {
            Activity pageActivity = this.f20412c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.e.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.U);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? R.id.user_icon_box : invokeV.intValue;
    }

    public void a2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048678, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(W1, Integer.valueOf(X1));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            this.P = new c.a.q0.s.s.a(this.f20412c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.P.setMessageId(i4);
            } else {
                this.P.setOnlyMessageShowCenter(false);
                this.P.setMessage(str2);
            }
            this.P.setYesButtonTag(sparseArray);
            this.P.setPositiveButton(R.string.dialog_ok, this.f20412c);
            this.P.setNegativeButton(R.string.dialog_cancel, new l(this));
            this.P.setCancelable(true);
            this.P.create(this.f20412c.getPageContext());
            if (z3) {
                g3(sparseArray);
            } else if (z2) {
                g3(sparseArray);
            } else if (Y2()) {
                c.a.r0.j.i iVar = new c.a.r0.j.i(this.f20412c.getPbModel().P0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20412c.getPbModel().P0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20412c.getPbModel().P0().p().has_forum_rule.intValue());
                iVar.i(this.f20412c.getPbModel().P0().m().getId(), this.f20412c.getPbModel().P0().m().getName());
                iVar.h(this.f20412c.getPbModel().P0().m().getImage_url());
                iVar.j(this.f20412c.getPbModel().P0().m().getUser_level());
                n3(sparseArray, i2, iVar, this.f20412c.getPbModel().P0().U(), false);
            } else {
                v3(this.P, i2);
            }
        }
    }

    public void a3() {
        c.a.r0.k2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.u(this.l);
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || this.S1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.S1 = true;
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20412c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(W1, Integer.valueOf(Y1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f20412c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f20412c);
        aVar.setNegativeButton(R.string.look_again, new g0(this));
        aVar.create(this.f20412c.getPageContext()).show();
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.f20413d : (View) invokeV.objValue;
    }

    public void b2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(W1, Integer.valueOf(X1));
            if (z2) {
                b3(sparseArray);
            } else {
                c3(i2, sparseArray);
            }
        }
    }

    public final void b3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048683, this, sparseArray) == null) || this.f20412c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f20412c.getPbActivity());
        lVar.p(R.string.musk_my_thread_confirm);
        lVar.j(R.string.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new o(this, s2, sparseArray));
        aVar2.a(new p(this, s2));
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", org.apache.commons.lang3.StringUtils.LF);
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20412c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f20412c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(W1, Integer.valueOf(Z1));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(R.string.view, this.f20412c);
            aVar.setNegativeButton(R.string.cancel, new h0(this));
            aVar.create(this.f20412c.getPageContext()).show();
        }
    }

    public void c1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.I0.setVisibility(8);
            }
            c.a.r0.k2.k.e.g1.c cVar = this.f20417h;
            if (cVar == null || (view = cVar.f20291d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void c2(SparseArray<Object> sparseArray, boolean z2) {
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048686, this, sparseArray, z2) == null) {
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20412c.getContext());
            iVar.q(this.f20412c.getString(R.string.bar_manager));
            iVar.n(new k(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.q0.s.s.f(10, this.f20412c.getString(R.string.delete_post), iVar);
                } else {
                    fVar2 = new c.a.q0.s.s.f(10, this.f20412c.getString(R.string.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f14448d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !H1()) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = R.id.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(11, this.f20412c.getString(R.string.forbidden_person), iVar);
                fVar3.f14448d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = R.id.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    fVar = new c.a.q0.s.s.f(12, this.f20412c.getString(R.string.un_mute), iVar);
                } else {
                    fVar = new c.a.q0.s.s.f(12, this.f20412c.getString(R.string.mute), iVar);
                }
                fVar.f14448d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            c.a.r0.k2.k.e.f1.a.e(arrayList);
            if (c.a.q0.b.d.F()) {
                iVar.l(arrayList, false);
            } else {
                iVar.l(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f20412c.getPageContext(), iVar);
            this.N = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final void c3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048687, this, i2, sparseArray) == null) || (pbFragment = this.f20412c) == null || pbFragment.getPbModel() == null || this.f20412c.getPbModel().P0() == null || this.f20412c.getPbModel().P0().p() == null || this.f20412c.getPbModel().P0().m() == null || this.f20412c.getPbModel().P0().m().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.r0.j.i iVar = new c.a.r0.j.i(this.f20412c.getPbModel().P0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20412c.getPbModel().P0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20412c.getPbModel().P0().p().has_forum_rule.intValue());
        iVar.i(this.f20412c.getPbModel().P0().m().getId(), this.f20412c.getPbModel().P0().m().getName());
        iVar.h(this.f20412c.getPbModel().P0().m().getImage_url());
        iVar.j(this.f20412c.getPbModel().P0().m().getUser_level());
        n3(sparseArray, i2, iVar, this.f20412c.getPbModel().P0().U(), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.w1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d0() {
        c.a.r0.k2.p.h hVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (hVar = this.y1) == null) {
            return;
        }
        if (((hVar.a() == null || this.y1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.y1.a())) != -1) {
            if (this.y1.a().getTop() + b2 <= this.K0.getBottom()) {
                this.w1 = 1;
                z2 = true;
            } else {
                this.w1 = 0;
                z2 = false;
            }
        }
        this.N0.showRecomStyle(this.w1 == 1);
        this.y1.e(z2);
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048689, this) == null) || this.n0 == null) {
            return;
        }
        this.m0.setVisibility(8);
        this.n0.setVisibility(8);
        this.x0 = false;
        PbEmotionBar pbEmotionBar = this.S0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            p2(false);
        }
    }

    public void d2(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        c2(sparseArray, false);
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            this.j0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            this.f20417h.k();
            c.a.r0.k2.k.e.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PbFragment pbFragment = this.f20412c;
            if (pbFragment != null) {
                c.a.e.e.p.l.x(pbFragment.getContext(), this.E);
            }
            f1();
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            i0();
            c.a.q0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.q0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void e1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048693, this, z2) == null) || this.n0 == null || this.q0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        c.a.r0.k2.h.e eVar = this.B0;
        boolean z3 = eVar != null && eVar.j0();
        c.a.r0.k2.h.e eVar2 = this.B0;
        this.q0.setText(tbSingleton.getAdVertiComment(z3, eVar2 != null && eVar2.k0(), S0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.n0.startAnimation(alphaAnimation);
        }
        this.m0.setVisibility(0);
        this.n0.setVisibility(0);
        this.x0 = true;
        if (this.S0 == null || this.k1.l()) {
            return;
        }
        this.S0.setVisibility(0);
        p2(true);
    }

    public void e2(c.a.q0.u.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048694, this, aVar, i2) == null) || (fallingView = this.A1) == null) {
            return;
        }
        fallingView.startFalling(aVar, this.f20412c.getPageContext(), i2, false);
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) || this.n0 == null) {
            return;
        }
        x2(this.f20412c.getPbEditor().E());
        if (this.i0) {
            i3(z2);
        } else {
            e1(z2);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            this.f20417h.k();
            c.a.r0.k2.k.e.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            i0();
            c.a.q0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.q0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void f1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hide();
        c.a.r0.k2.k.e.b1.c cVar = this.j1;
        if (cVar != null) {
            cVar.i();
        }
    }

    public final void f2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048698, this, pbReplyTitleViewHolder, z2) == null) || this.b1 || this.K0 == null || this.f20417h.p() == null) {
            return;
        }
        View r2 = p0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.K0.getVisibility() == 0 && i3 - this.f20417h.p().getBottom() <= this.K0.getHeight()) {
                    this.L0.setVisibility(0);
                    if (i3 > this.f20417h.p().getBottom()) {
                        i2 = -(((this.K0.getHeight() + this.L0.getHeight()) + this.f20417h.p().getBottom()) - r2.getBottom());
                    } else {
                        i2 = -this.K0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K0.getLayoutParams();
                    if (layoutParams.topMargin != i2) {
                        layoutParams.topMargin = i2;
                        this.K0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.L0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.K0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.K0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int G = this.A.G();
        if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
            if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.K0.setVisibility(4);
                return;
            }
            this.K0.setVisibility(0);
            d3(false);
            this.f20417h.f20288a.hideBottomLine();
            if (this.K0.getParent() == null || ((ViewGroup) this.K0.getParent()).getHeight() > this.K0.getTop()) {
                return;
            }
            this.K0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.mDivideLineTop != null) {
            int top = pbReplyTitleViewHolder.getView().getTop();
            if (pbReplyTitleViewHolder.getView().getParent() != null) {
                if (this.Q0) {
                    this.P0 = top;
                    this.Q0 = false;
                }
                int i4 = this.P0;
                if (top < i4) {
                    i4 = top;
                }
                this.P0 = i4;
            }
            if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                if (this.z.getY() < 0.0f) {
                    measuredHeight = U1 - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                } else {
                    measuredHeight = this.f20417h.p().getMeasuredHeight() - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                    this.f20417h.f20288a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.P0) {
                    this.K0.setVisibility(0);
                    d3(false);
                } else if (top < measuredHeight) {
                    this.K0.setVisibility(0);
                    d3(false);
                } else {
                    this.K0.setVisibility(4);
                    this.f20417h.f20288a.hideBottomLine();
                }
                if (z2) {
                    this.Q0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.K0.setVisibility(4);
            this.f20417h.f20288a.hideBottomLine();
        }
    }

    public void f3(c.a.r0.k2.h.e eVar) {
        PostData postData;
        c.a.r0.k2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048699, this, eVar) == null) || eVar == null || (postData = this.C0) == null || postData.t() == null || (cVar = this.f20417h) == null) {
            return;
        }
        boolean z2 = !this.b1;
        this.c1 = z2;
        cVar.G(z2);
        if (this.f20412c.getPbNavigationAnimDispatcher() != null) {
            this.f20412c.getPbNavigationAnimDispatcher().s(this.c1);
        }
        g2();
        PbFragment pbFragment = this.f20412c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
            z1 z1Var = eVar.q().get(0);
            if (z1Var != null) {
                this.f20417h.K(eVar, z1Var.getForumName(), z1Var.getForumId(), z1Var.b(), z1Var.getIsLike());
            }
        } else if (eVar.m() != null) {
            this.f20417h.K(eVar, eVar.m().getName(), eVar.m().getId(), eVar.m().getImage_url(), eVar.m().isLike() == 1);
        }
        if (this.c1) {
            this.s.C(eVar, this.C0, this.c0);
            View view = this.M0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.l1 == null) {
                this.l1 = new c0(this);
            }
            this.l.setListViewDragListener(this.l1);
            return;
        }
        View view2 = this.M0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.s.C(eVar, this.C0, this.c0);
        this.l1 = null;
        this.l.setListViewDragListener(null);
    }

    public void g0() {
        c.a.r0.k2.p.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || (iVar = this.u0) == null) {
            return;
        }
        iVar.k(false);
    }

    public void g1() {
        c.a.r0.k2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (cVar = this.f20417h) == null) {
            return;
        }
        cVar.q();
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            this.s.s(this.B0, this.C0, this.c1, this.b1);
        }
    }

    public final void g3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, sparseArray) == null) || this.f20412c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f20412c.getPbActivity());
        lVar.p(R.string.del_my_thread_confirm);
        lVar.j(R.string.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new m(this, s2, sparseArray));
        aVar2.a(new n(this, s2));
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.q.b(this.A0) : invokeV.booleanValue;
    }

    public void h1() {
        c.a.q0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048705, this) == null) || (aVar = this.z0) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.a1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.R0.f20473c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.R0.f20473c;
        int T0 = T0(pbReplyTitleViewHolder);
        int measuredHeight = this.z.getMeasuredHeight() + ((int) this.z.getY());
        boolean z2 = this.K0.getVisibility() == 0;
        boolean z3 = this.z.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.A.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), U1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.f20417h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.b1 && this.p != null) {
            this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.D0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, T0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final boolean h3(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return false;
            }
            return eVar.O().j0() == 1 || eVar.O().o1() == 33 || !(eVar.O().w1() == null || eVar.O().w1().a() == 0) || eVar.O().r0() == 1 || eVar.O().q0() == 1 || eVar.O().I1() || eVar.O().c2() || eVar.O().H2() || eVar.O().F1() != null || !c.a.e.e.p.k.isEmpty(eVar.O().N()) || eVar.O().Z1() || eVar.O().q2();
        }
        return invokeL.booleanValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            c.a.q0.s.s.a aVar = this.P;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.Q;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f20412c.getPageContext());
            }
            Dialog dialog2 = this.R;
            if (dialog2 != null) {
                c.a.e.e.m.g.b(dialog2, this.f20412c.getPageContext());
            }
            PopupDialog popupDialog = this.N;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void i1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            if (this.w == null) {
                p1();
            }
            this.k.setVisibility(8);
            Handler handler = this.H1;
            if (handler == null || (runnable = this.I1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public final void i2(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        J3(eVar);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String o02 = o0(eVar.O().U0());
        TextView textView = this.v0;
        if (textView != null) {
            textView.setText(o02);
        }
        TextView textView2 = this.w0;
        if (textView2 != null) {
            textView2.setText(o02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.O()));
    }

    public void i3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) || this.n0 == null || (textView = this.q0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.n0.startAnimation(alphaAnimation);
        }
        this.m0.setVisibility(0);
        this.n0.setVisibility(0);
        this.x0 = true;
        if (this.S0 == null || this.k1.l()) {
            return;
        }
        this.S0.setVisibility(0);
        p2(true);
    }

    public void j0() {
        c.a.r0.k2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048712, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.b();
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            this.J.setVisibility(8);
        }
    }

    public void j2(int i2, c.a.r0.k2.h.e eVar, boolean z2, int i3) {
        PostData x0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (x0 = x0(eVar, z2)) == null || x0.t() == null) {
            return;
        }
        MetaData t2 = x0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void j3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048715, this, view) == null) || c.a.q0.s.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.n0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f20412c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f20412c.getContext());
        this.h1 = textView;
        textView.setText(R.string.connection_tips);
        this.h1.setGravity(17);
        this.h1.setPadding(c.a.e.e.p.l.g(this.f20412c.getContext(), R.dimen.ds24), 0, c.a.e.e.p.l.g(this.f20412c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = c.a.e.e.p.l.g(this.f20412c.getContext(), R.dimen.ds60);
        if (this.h1.getParent() == null) {
            frameLayout.addView(this.h1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f20412c.getContext());
        this.g1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.g1.setHeight(-2);
        this.g1.setWidth(-2);
        this.g1.setFocusable(true);
        this.g1.setOutsideTouchable(false);
        this.g1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new i0(this, i4, i2, i3, view), 100L);
        c.a.q0.s.d0.b.j().t("show_long_press_collection_tips", true);
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.v();
                this.G.f();
            }
            h1();
        }
    }

    public void k1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048717, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void k2(c.a.r0.k2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048718, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            q3(eVar, z2, i2, i3);
            this.s.q(i3);
        }
    }

    public void k3() {
        c.a.r0.k2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048719, this) == null) || (cVar = this.f20417h) == null || this.d1) {
            return;
        }
        cVar.C();
        this.d1 = true;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.l.completePullRefreshPostDelayed(0L);
            h0();
        }
    }

    public void l1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048721, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final void l2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048722, this) == null) && (pbInterviewStatusView = this.H0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.H0.setLayoutParams(layoutParams);
        }
    }

    public void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public void m0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048724, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f20412c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f20412c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f20412c.showToast(str);
            }
        }
    }

    public final void m1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048725, this) == null) && this.v == null && (pbFragment = this.f20412c) != null) {
            this.v = new c.a.r0.k2.k.e.a1.c(pbFragment.getContext());
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || this.f20415f == 2) {
            return;
        }
        this.l.setNextPage(this.G);
        this.f20415f = 2;
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            if (this.z0 == null) {
                this.z0 = new c.a.q0.s.f0.a(this.f20412c.getPageContext());
            }
            this.z0.h(true);
        }
    }

    public void n0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048729, this) == null) && this.r == null) {
            this.r = new c.a.r0.k2.k.e.a1.f(this.f20412c, this.f0);
        }
    }

    public void n2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.v.d(pbLandscapeListView);
        this.r.d(this.l);
        this.s.t(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public final void n3(SparseArray<Object> sparseArray, int i2, c.a.r0.j.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048731, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f20412c) == null) {
            return;
        }
        if (this.q1 == null && this.q != null) {
            this.q1 = new c.a.r0.j.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        this.q1.C(z2);
        AntiData antiData = this.f20412c.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.s.q.x0 x0Var = new c.a.q0.s.q.x0();
        x0Var.k(sparseArray2);
        this.q1.E(new String[]{this.f20412c.getString(R.string.delete_thread_reason_1), this.f20412c.getString(R.string.delete_thread_reason_2), this.f20412c.getString(R.string.delete_thread_reason_3), this.f20412c.getString(R.string.delete_thread_reason_4), this.f20412c.getString(R.string.delete_thread_reason_5)});
        this.q1.D(x0Var);
        this.q1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.q1.F(new r(this, sparseArray));
    }

    public final String o0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048732, this, i2)) == null) {
            if (i2 == 0) {
                return this.f20412c.getString(R.string.pb_comment_red_dot_no_reply);
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

    public final void o1(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048733, this, eVar) == null) && eVar != null && eVar.O() != null && eVar.O().c2() && this.H0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.G0.inflate();
            this.H0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.K);
            this.H0.setCallback(this.f20412c.getInterviewStatusCallback());
            this.H0.setData(this.f20412c, eVar);
        }
    }

    public final void o2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048734, this) == null) || (pbFragment = this.f20412c) == null || pbFragment.getPbEditor() == null || this.h0 == null) {
            return;
        }
        c.a.q0.x.x.a.a().c(0);
        c.a.q0.x.x.e pbEditor = this.f20412c.getPbEditor();
        pbEditor.V();
        pbEditor.T();
        if (pbEditor.A() != null) {
            pbEditor.A().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.n0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.q0.x.h findLauncherById = this.h0.findLauncherById(23);
        c.a.q0.x.h findLauncherById2 = this.h0.findLauncherById(2);
        c.a.q0.x.h findLauncherById3 = this.h0.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.h0.invalidate();
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.A.c0(this.B0, false);
            this.A.X();
        }
    }

    public c.a.r0.k2.k.e.h p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.A : (c.a.r0.k2.k.e.h) invokeV.objValue;
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && this.f20412c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f20413d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.w == null) {
                this.w = (LinearLayout) this.f20413d.findViewById(R.id.manga_controller_layout);
                c.a.q0.w0.a.a(this.f20412c.getPageContext(), this.w);
            }
            if (this.x == null) {
                this.x = (TextView) this.w.findViewById(R.id.manga_prev_btn);
            }
            if (this.y == null) {
                this.y = (TextView) this.w.findViewById(R.id.manga_next_btn);
            }
            this.x.setOnClickListener(this.K);
            this.y.setOnClickListener(this.K);
        }
    }

    public final void p2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z2) == null) {
        }
    }

    public void p3(c.a.r0.k2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048739, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || eVar == null || this.l == null) {
            return;
        }
        this.B0 = eVar;
        this.D0 = i2;
        if (eVar.O() != null) {
            this.T0 = eVar.O().O();
            if (eVar.O().F() != 0) {
                this.N1 = true;
            }
            this.c0 = D1(eVar.O());
        }
        if (eVar.U() != null) {
            this.O1 = eVar.U().getUserId();
        }
        o1(eVar);
        W();
        this.F0 = false;
        this.A0 = z2;
        R2();
        c.a.r0.k2.h.k kVar = eVar.f19810h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f20412c.getContext());
                this.o = pbThreadPostView;
                this.l.addHeaderView(pbThreadPostView, 1);
                this.o.setData(eVar);
                this.o.setChildOnClickLinstener(this.K);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        q3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        f3(eVar);
        if (this.n1 == null) {
            this.n1 = new c.a.r0.k2.k.e.f0(this.f20412c.getPageContext(), this.o1);
        }
        this.n1.a(eVar.w());
        if (this.f20412c.getIsMangaThread()) {
            if (this.F == null) {
                c.a.r0.k2.p.j jVar = new c.a.r0.k2.p.j(this.f20412c.getPageContext());
                this.F = jVar;
                jVar.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.r0.k2.p.j jVar2 = this.F;
            if (jVar2 != null) {
                jVar2.D(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.F == null) {
                c.a.r0.k2.p.j jVar3 = new c.a.r0.k2.p.j(this.f20412c.getPageContext());
                this.F = jVar3;
                jVar3.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.r0.k2.p.j jVar4 = this.F;
            if (jVar4 != null) {
                jVar4.D(TbadkCoreApplication.getInst().getSkinType());
            }
            h1();
        }
        h0();
        this.A.j0(this.A0);
        this.A.g0(false);
        this.A.h0(i2 == 5);
        this.A.i0(i2 == 6);
        this.A.e0(z3 && this.L1 && i2 != 2);
        this.A.c0(eVar, false);
        this.A.X();
        this.s.B(x0(eVar, z2), eVar.f0());
        if (eVar.O() != null && eVar.O().L0() != null && this.f20411b != -1) {
            eVar.O().L0().setIsLike(this.f20411b);
        }
        this.l.removeFooterView(this.O0);
        this.l.addFooterView(this.O0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.G);
            this.f20415f = 2;
            h1();
        } else {
            this.F0 = true;
            if (eVar.y().b() == 1) {
                if (this.H == null) {
                    PbFragment pbFragment = this.f20412c;
                    this.H = new c.a.r0.k2.p.f(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.H);
            } else {
                this.l.setNextPage(this.G);
            }
            this.f20415f = 3;
        }
        ArrayList<PostData> F = eVar.F();
        if (eVar.y().b() != 0 && F != null && F.size() >= eVar.y().e()) {
            if (z3) {
                if (this.L1) {
                    k0();
                    if (eVar.y().b() != 0) {
                        this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                    }
                } else {
                    this.G.x();
                    this.G.L();
                }
            } else {
                this.G.x();
                this.G.L();
            }
            this.G.j();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (eVar.y().b() == 0) {
                    this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.G.j();
            } else {
                p0 p0Var = this.R0;
                if (p0Var == null || (pbReplyTitleViewHolder = p0Var.f20473c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i5 = 0;
                } else {
                    i5 = this.R0.f20473c.getView().getTop() < 0 ? this.R0.f20473c.getView().getHeight() : this.R0.f20473c.getView().getBottom();
                }
                if (this.f20412c.isHostOnlyMode()) {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f20412c.getPbNavigationAnimDispatcher() != null && !this.f20412c.getPbNavigationAnimDispatcher().p()) {
                    this.f20412c.getPbNavigationAnimDispatcher().x();
                }
            }
            if (eVar.y().b() == 0 || F == null) {
                m2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && eVar.F() == null) ? 0 : (this.l.getData().size() - eVar.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.L1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        c.a.r0.k2.k.e.a1.i iVar = this.p;
                        if (iVar != null && iVar.c() != null) {
                            if (this.f20412c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - c.a.e.e.p.l.r(this.f20412c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d());
                            }
                        } else {
                            this.l.setSelection(this.A.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(eVar.R())) {
                        this.l.setSelection(i3 > 0 ? i3 + ((this.l.getData() == null && eVar.F() == null) ? 0 : (this.l.getData().size() - eVar.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(eVar.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.G.f();
                    this.G.A(this.f20412c.getString(R.string.pb_load_more_without_point));
                    this.G.v();
                }
            } else if (i4 == 1 && (e3 = c.a.r0.k2.k.e.k0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = c.a.r0.k2.k.e.k0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new b0(this, e2, F, eVar));
        }
        if (this.T0 == V1 && C1()) {
            b0();
        }
        if (this.Z0) {
            h2();
            this.Z0 = false;
            if (i4 == 0) {
                G2(true);
            }
        }
        if (eVar.f19806d == 1 || eVar.f19807e == 1) {
            if (this.f1 == null) {
                this.f1 = new PbTopTipView(this.f20412c.getContext());
            }
            if (eVar.f19807e == 1 && "game_guide".equals(this.f20412c.getStType())) {
                this.f1.setText(this.f20412c.getString(R.string.pb_read_strategy_add_experience));
                this.f1.show(this.f20413d, this.E0);
            } else if (eVar.f19806d == 1 && "game_news".equals(this.f20412c.getStType())) {
                this.f1.setText(this.f20412c.getString(R.string.pb_read_news_add_experience));
                this.f1.show(this.f20413d, this.E0);
            }
        }
        this.l.removeFooterView(this.y1.a());
        if (!ListUtils.isEmpty(eVar.I()) && eVar.y().b() == 0) {
            this.l.removeFooterView(this.O0);
            this.y1.d(Math.max(this.n0.getMeasuredHeight(), this.y0 / 2));
            this.l.addFooterView(this.y1.a());
            this.y1.f(eVar);
        }
        i2(eVar);
        if (eVar.d0() && this.f20412c.getPbRecThreadController() != null) {
            this.f20412c.getPbRecThreadController().d();
        }
        if (eVar.g() != 3) {
            s1(eVar);
        }
        this.q0.setText(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), S0()));
    }

    public LinearLayout q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.o0 : (LinearLayout) invokeV.objValue;
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || this.f20412c == null || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.display();
        if (this.f20412c.getPbEditor() != null) {
            this.f20412c.getPbEditor().R();
        }
        d1();
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            o2();
            f1();
            this.X0.c();
            e3(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void q3(c.a.r0.k2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048743, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        if (this.f20412c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.d0 = eVar.h().getForumName();
                this.e0 = eVar.h().getForumId();
            }
            if (this.d0 == null && this.f20412c.getPbModel() != null && this.f20412c.getPbModel().q0() != null) {
                this.d0 = this.f20412c.getPbModel().q0();
            }
        }
        PostData x0 = x0(eVar, z2);
        P2(x0, eVar);
        this.s.y(8);
        if (eVar.q0()) {
            this.b1 = true;
            this.f20417h.A(true);
            this.f20417h.f20288a.hideBottomLine();
            if (this.p == null) {
                this.p = new c.a.r0.k2.k.e.a1.i(this.f20412c);
            }
            this.p.v(eVar, x0, this.l, this.s, this.I0, this.f20417h, this.d0, this.t1);
            this.p.s(this.M1);
            r2();
        } else {
            this.b1 = false;
            this.f20417h.A(false);
            c.a.r0.k2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f20412c.getPbNavigationAnimDispatcher() != null) {
            this.f20412c.getPbNavigationAnimDispatcher().w(this.b1);
        }
        if (x0 == null) {
            return;
        }
        this.C0 = x0;
        this.s.y(0);
        SparseArray<Object> o2 = this.s.o();
        o2.put(R.id.tag_clip_board, x0);
        o2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.v.e(eVar, this.v1, new y(this));
        this.r.f(eVar);
        this.q.h(eVar, this.A0);
        this.q.g(eVar);
        this.s.z(this.E0, this.B0, x0, this.M1);
        if (this.N0 != null) {
            if (eVar.f0()) {
                this.N0.getView().setVisibility(8);
            } else {
                this.N0.getView().setVisibility(0);
                c.a.r0.k2.h.o oVar = new c.a.r0.k2.h.o(c.a.r0.k2.h.o.l);
                if (eVar.O() != null) {
                    eVar.O().U0();
                }
                oVar.f19844g = eVar.f19809g;
                eVar.c();
                oVar.f19845h = this.f20412c.isHostOnlyMode();
                oVar.k = eVar.f19808f;
                this.N0.bindDataToView(oVar);
            }
        }
        A3(eVar);
        c.a.e.e.m.e.a().post(new z(this));
        this.u.e(this.l);
        if (x0.S) {
            this.u.f(x0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        c.a.r0.k2.k.e.h hVar = this.A;
        if (hVar != null && hVar.z() != null) {
            this.A.z().u0(x0.S);
        }
        c.a.r0.k2.k.e.h hVar2 = this.A;
        if (hVar2 != null) {
            hVar2.l0(x0.S);
        }
        this.z1.setVisibility(x0.S ? 0 : 8);
    }

    public View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            View view = this.S;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || this.C1 == null) {
            return;
        }
        k1();
        if (this.C1.isPbNeedShow()) {
            String a3 = this.B1.a(this.B0.j0());
            if (StringUtils.isNull(a3)) {
                return;
            }
            this.C1.setData(a3);
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
            ThirdStatisticHelper.sendReq(this.B1.f(this.B0.j0()));
            this.C1.setLogoListener(new e0(this, this.B1.d(this.B0.j0())));
            this.C1.setFeedBackListener(new j0(this));
        }
    }

    public final void r2() {
        c.a.r0.k2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048746, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(this.l, this.J0, this.D0);
    }

    public void r3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048747, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Z = null;
            }
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20412c.getContext());
            ArrayList arrayList = new ArrayList();
            c.a.r0.k2.h.e eVar = this.B0;
            if (eVar != null && eVar.O() != null && !this.B0.O().Q1()) {
                arrayList.add(new c.a.q0.s.s.f(0, this.f20412c.getPageContext().getString(R.string.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.q0.s.s.f(1, this.f20412c.getPageContext().getString(R.string.save_to_local), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new w(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f20412c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public void s1(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, eVar) == null) {
            this.B1.i(eVar.k() == null ? null : eVar.k().pbpage);
            this.B1.h(TbSingleton.getInstance().getAdFloatViewData());
            if (this.B1.g(eVar.j0())) {
                r1();
            }
        }
    }

    public void s2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048750, this) == null) || (handler = this.H1) == null) {
            return;
        }
        Runnable runnable = this.I1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        f fVar = new f(this);
        this.I1 = fVar;
        this.H1.postDelayed(fVar, 2000L);
    }

    public void s3(b.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048751, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Y = null;
            }
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20412c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new c.a.q0.s.s.f(0, this.f20412c.getPageContext().getString(R.string.copy), iVar));
            }
            if (z3) {
                arrayList.add(new c.a.q0.s.s.f(1, this.f20412c.getPageContext().getString(R.string.report_text), iVar));
            } else if (!z2) {
                arrayList.add(new c.a.q0.s.s.f(1, this.f20412c.getPageContext().getString(R.string.mark), iVar));
            } else {
                arrayList.add(new c.a.q0.s.s.f(1, this.f20412c.getPageContext().getString(R.string.remove_mark), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new v(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f20412c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public int t0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
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

    public final void t1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && this.t == null) {
            this.t = new c.a.r0.k2.k.e.a1.e(this.f20412c, this.K);
        }
    }

    public void t2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, editorTools) == null) {
            this.h0 = editorTools;
            editorTools.setOnCancelClickListener(new h(this));
            this.h0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.h0.getParent() == null) {
                this.f20413d.addView(this.h0, layoutParams);
            }
            this.h0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.h0.setActionListener(24, new i(this));
            f1();
            this.f20412c.getPbEditor().i(new j(this));
        }
    }

    public void t3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, onItemClickListener) == null) {
            c.a.q0.s.s.c cVar = this.a0;
            if (cVar != null) {
                cVar.d();
                this.a0 = null;
            }
            if (this.B0 == null) {
                return;
            }
            ArrayList<c.a.q0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.q0.s.s.k(this.f20412c.getContext().getString(R.string.all_person), "", this.B0.L() == 1, Integer.toString(1)));
            arrayList.add(new c.a.q0.s.s.k(this.f20412c.getContext().getString(R.string.my_fans), "", this.B0.L() == 2, Integer.toString(5)));
            arrayList.add(new c.a.q0.s.s.k(this.f20412c.getContext().getString(R.string.my_attentions), "", this.B0.L() == 3, Integer.toString(6)));
            arrayList.add(new c.a.q0.s.s.k(this.f20412c.getContext().getString(R.string.myself_only), "", this.B0.L() == 4, Integer.toString(7)));
            c.a.q0.s.s.c cVar2 = new c.a.q0.s.s.c(this.f20412c.getPageContext());
            cVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.a0 = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.a0.n();
        }
    }

    public PostData u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int t0 = t0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (t0 < 0) {
                t0 = 0;
            }
            if (this.A.y(t0) != null && this.A.y(t0) != PostData.u0) {
                i2 = t0 + 1;
            }
            if (this.A.x(i2) instanceof PostData) {
                return (PostData) this.A.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void u1(c.a.r0.k2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, eVar) == null) {
            int i2 = 0;
            this.A.c0(eVar, false);
            this.A.X();
            h0();
            c.a.r0.k2.k.d.a aVar = this.k1;
            if (aVar != null) {
                aVar.n();
            }
            ArrayList<PostData> F = eVar.F();
            if (eVar.y().b() == 0 || F == null || F.size() < eVar.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (eVar.y().b() == 0) {
                        this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.G.j();
                } else {
                    p0 p0Var = this.R0;
                    if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f20473c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i2 = this.R0.f20473c.getView().getTop() < 0 ? this.R0.f20473c.getView().getHeight() : this.R0.f20473c.getView().getBottom();
                    }
                    if (this.f20412c.isHostOnlyMode()) {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            i2(eVar);
        }
    }

    public void u2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048758, this, str) == null) || (pbListView = this.G) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void u3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048759, this) == null) || !TbadkCoreApplication.isLogin() || this.B0 == null || !this.c1 || this.b1 || this.c0 || (postData = this.C0) == null || postData.t() == null || this.C0.t().getIsLike() || this.C0.t().hadConcerned() || this.Y0 != null) {
            return;
        }
        this.Y0 = new c.a.r0.k2.k.e.n0(this.f20412c);
    }

    public FallingView v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.A1 : (FallingView) invokeV.objValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.N1 : invokeV.booleanValue;
    }

    public void v2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048762, this, str) == null) || this.G == null) {
            return;
        }
        int i2 = 0;
        p0 p0Var = this.R0;
        if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f20473c) != null && pbReplyTitleViewHolder.getView() != null) {
            i2 = this.R0.f20473c.getView().getTop() < 0 ? this.R0.f20473c.getView().getHeight() : this.R0.f20473c.getView().getBottom();
        }
        this.G.D(str, i2);
    }

    public final void v3(c.a.q0.s.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048763, this, aVar, i2) == null) || (pbFragment = this.f20412c) == null || aVar == null) {
            return;
        }
        if (this.p1 == null && this.q != null) {
            this.p1 = new c.a.r0.j.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData antiData = this.f20412c.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.s.q.x0 x0Var = new c.a.q0.s.q.x0();
        x0Var.k(sparseArray);
        this.p1.y(new String[]{this.f20412c.getString(R.string.delete_thread_reason_1), this.f20412c.getString(R.string.delete_thread_reason_2), this.f20412c.getString(R.string.delete_thread_reason_3), this.f20412c.getString(R.string.delete_thread_reason_4), this.f20412c.getString(R.string.delete_thread_reason_5)});
        this.p1.x(x0Var);
        this.p1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.p1.z(new q(this, aVar));
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? y0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? this.x0 : invokeV.booleanValue;
    }

    public void w2(PbFragment.b3 b3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, b3Var) == null) {
            this.K1 = b3Var;
        }
    }

    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            this.J.setVisibility(0);
        }
    }

    public PostData x0(c.a.r0.k2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048768, this, eVar, z2)) == null) {
            PostData postData = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.W() != null) {
                return eVar.W();
            }
            if (!ListUtils.isEmpty(eVar.F())) {
                Iterator<PostData> it = eVar.F().iterator();
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
                postData = eVar.j();
            }
            if (!A1(postData)) {
                postData = R0(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean x1(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048769, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return false;
            }
            SpannableStringBuilder g1 = eVar.O().g1();
            if (g1 != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(g1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void x2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048770, this, z2) == null) {
            this.i0 = z2;
        }
    }

    public void x3() {
        c.a.r0.k2.p.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048771, this) == null) || (iVar = this.u0) == null) {
            return;
        }
        iVar.m(2);
    }

    public final int y0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048772, this, i2)) == null) {
            c.a.e.l.e.e adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0) {
                adapter2.getItem(i2);
            }
            int m2 = (adapter2.m() + adapter2.k()) - 1;
            if (i2 > m2) {
                i2 = m2;
            }
            int l2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof c.a.e.l.e.e)) ? 0 : this.l.getAdapter2().l();
            if (i2 > l2) {
                return i2 - l2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048774, this, z2) == null) {
            this.A.d0(z2);
        }
    }

    public void y3(b1 b1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048775, this, b1Var, eVar) == null) || b1Var == null) {
            return;
        }
        int a3 = b1Var.a();
        int h2 = b1Var.h();
        c.a.q0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.show();
        } else {
            this.B = new c.a.q0.s.s.a(this.f20412c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f20412c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.D = inflate;
            this.B.setContentView(inflate);
            this.B.setPositiveButton(R.string.dialog_ok, eVar);
            this.B.setNegativeButton(R.string.dialog_cancel, new d0(this));
            this.B.setOnCalcelListener(new f0(this));
            this.B.create(this.f20412c.getPageContext()).show();
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
        this.f20412c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.E, 150);
    }

    public Button z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.l0 : (Button) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            EditorTools editorTools = this.h0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z2) == null) {
            this.u1 = z2;
        }
    }

    public void z3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) || this.l == null || (textView = this.J0) == null || this.f20414e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f20414e.setVisibility(0);
            } else {
                this.f20414e.setVisibility(8);
                this.l.removeHeaderView(this.J0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.J0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = U1;
                this.J0.setLayoutParams(layoutParams);
            }
            r2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + J0(true);
            this.J0.setLayoutParams(layoutParams2);
        }
        r2();
        l2();
    }
}
