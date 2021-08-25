package c.a.q0.i2.k.e;

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
import c.a.p0.s.f0.f;
import c.a.p0.s.q.b1;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import c.a.p0.s.q.y1;
import c.a.p0.s.s.a;
import c.a.p0.s.s.b;
import c.a.p0.s.s.i;
import c.a.q0.i.g;
import c.a.q0.i.j;
import c.a.q0.i2.i.a;
import c.a.q0.i2.k.e.y0.c;
import c.a.q0.i3.h0.a;
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
public class q0 {
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
    public c.a.q0.i2.k.e.g A;
    public boolean A0;
    public final FallingView A1;
    public c.a.p0.s.s.a B;
    public c.a.q0.i2.h.e B0;
    public final c.a.q0.i2.o.j.a B1;
    public c.a.p0.s.s.b C;
    public PostData C0;
    public RightFloatLayerView C1;
    public View D;
    public int D0;
    public boolean D1;
    public EditText E;
    public int E0;
    public String E1;
    public c.a.q0.i2.p.k F;
    public boolean F0;
    public CustomMessageListener F1;
    public PbListView G;
    public ViewStub G0;
    public CustomMessageListener G1;
    public c.a.q0.i2.p.g H;
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
    public PbFragment.z2 K1;
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
    public c.a.p0.s.s.a P;
    public int P0;
    public f.g P1;
    public Dialog Q;
    public boolean Q0;
    public final List<TbImageView> Q1;
    public Dialog R;
    public o0 R0;
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
    public c.a.q0.i2.k.e.s X0;
    public PopupDialog Y;
    public c.a.q0.i2.k.e.l0 Y0;
    public PopupDialog Z;
    public boolean Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f19511a;
    public c.a.p0.s.s.c a0;
    public int a1;

    /* renamed from: b  reason: collision with root package name */
    public int f19512b;
    public boolean b0;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f19513c;
    public boolean c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19514d;
    public String d0;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public View f19515e;
    public String e0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public int f19516f;
    public c.a.q0.i2.i.c f0;
    public PbTopTipView f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f19517g;
    public ScrollView g0;
    public PopupWindow g1;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.q0.i2.k.e.e1.c f19518h;
    public EditorTools h0;
    public TextView h1;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.i2.k.e.e1.b f19519i;
    public boolean i0;
    public List<String> i1;

    /* renamed from: j  reason: collision with root package name */
    public ViewStub f19520j;
    public View j0;
    public c.a.q0.i2.k.e.z0.c j1;
    public ViewStub k;
    public View k0;
    public c.a.q0.i2.k.d.a k1;
    public PbLandscapeListView l;
    public Button l0;
    public PbLandscapeListView.c l1;
    public NoNetworkView m;
    public View m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public c.a.q0.i2.k.e.e0 n1;
    public PbThreadPostView o;
    public LinearLayout o0;
    public NavigationBarCoverTip o1;
    public c.a.q0.i2.k.e.y0.i p;
    public HeadImageView p0;
    public c.a.q0.i.g p1;
    public c.a.q0.i2.k.e.y0.d q;
    public TextView q0;
    public c.a.q0.i.j q1;
    public c.a.q0.i2.k.e.y0.f r;
    public ImageView r0;
    public String r1;
    public c.a.q0.i2.k.e.y0.h s;
    public ImageView s0;
    public PermissionJudgePolicy s1;
    public c.a.q0.i2.k.e.y0.e t;
    public ImageView t0;
    public long t1;
    public c.a.q0.i2.k.e.y0.g u;
    public c.a.q0.i2.p.j u0;
    public boolean u1;
    public c.a.q0.i2.k.e.y0.c v;
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
    public c.a.q0.i2.p.i y1;
    public ObservedChangeRelativeLayout z;
    public c.a.p0.s.f0.a z0;
    public MaskView z1;

    /* loaded from: classes3.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19521a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f19522b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19523c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19524d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19526f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q0 f19527g;

        /* renamed from: c.a.q0.i2.k.e.q0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0925a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19528e;

            public RunnableC0925a(a aVar) {
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
                this.f19528e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19528e.f19527g.O0 == null || this.f19528e.f19527g.O0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f19528e.f19527g.O0.getLayoutParams();
                layoutParams.height = this.f19528e.f19527g.U0;
                this.f19528e.f19527g.O0.setLayoutParams(layoutParams);
            }
        }

        public a(q0 q0Var, int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Integer.valueOf(i2), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19527g = q0Var;
            this.f19521a = i2;
            this.f19522b = pbReplyTitleViewHolder;
            this.f19523c = z;
            this.f19524d = i3;
            this.f19525e = i4;
            this.f19526f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f19521a;
                if (i3 >= 0 && i3 <= this.f19527g.f19514d.getMeasuredHeight()) {
                    int T0 = this.f19527g.T0(this.f19522b);
                    int i4 = this.f19521a;
                    int i5 = T0 - i4;
                    if (this.f19523c && i5 != 0 && i4 <= (i2 = this.f19524d)) {
                        i5 = T0 - i2;
                    }
                    if (this.f19527g.O0 == null || (layoutParams = this.f19527g.O0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f19527g.f19514d.getMeasuredHeight() || T0 >= this.f19527g.f19514d.getMeasuredHeight()) {
                        layoutParams.height = this.f19527g.U0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f19527g.f19514d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f19527g.l.setSelectionFromTop(this.f19525e, this.f19526f);
                            }
                        }
                        layoutParams.height = this.f19527g.U0;
                    }
                    this.f19527g.O0.setLayoutParams(layoutParams);
                    c.a.e.e.m.e.a().post(new RunnableC0925a(this));
                }
                this.f19527g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f19529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f19530f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.i2.h.e f19531g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ q0 f19532h;

        public a0(q0 q0Var, Parcelable parcelable, ArrayList arrayList, c.a.q0.i2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, parcelable, arrayList, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19532h = q0Var;
            this.f19529e = parcelable;
            this.f19530f = arrayList;
            this.f19531g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19532h.l.onRestoreInstanceState(this.f19529e);
                if (ListUtils.getCount(this.f19530f) <= 1 || this.f19531g.y().b() <= 0) {
                    return;
                }
                this.f19532h.G.f();
                this.f19532h.G.A(this.f19532h.f19513c.getString(R.string.pb_load_more_without_point));
                this.f19532h.G.v();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19533e;

        public b(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19533e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19533e.q2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19534a;

        public b0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19534a = q0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f19534a.f19513c != null && this.f19534a.f19513c.isAdded()) {
                if (i2 < 0 && f2 > this.f19534a.e1) {
                    this.f19534a.d0();
                    this.f19534a.R1();
                }
                this.f19534a.k0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19535a;

        public c(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19535a = q0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19535a.W0.M(postData);
                this.f19535a.A.X();
                this.f19535a.X0.c();
                this.f19535a.h0.hideTools();
                this.f19535a.f3(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19536e;

        public c0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19536e = q0Var;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19536e.d0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19537a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(q0 q0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Integer.valueOf(i2)};
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
            this.f19537a = q0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f19537a.A == null) {
                return;
            }
            this.f19537a.A.X();
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19538e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d0 f19539e;

            public a(d0 d0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19539e = d0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19539e.f19538e.f19513c.HidenSoftKeyPad((InputMethodManager) this.f19539e.f19538e.f19513c.getBaseFragmentActivity().getSystemService("input_method"), this.f19539e.f19538e.f19514d);
                }
            }
        }

        public d0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19538e = q0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f19538e.V0 == null) {
                    this.f19538e.V0 = new a(this);
                }
                c.a.e.e.m.e.a().postDelayed(this.f19538e.V0, 150L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19540e;

        public e(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19540e = q0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19540e.w == null) {
                    this.f19540e.p1();
                }
                this.f19540e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19541e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19542f;

        public e0(q0 q0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19542f = q0Var;
            this.f19541e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19542f.C1.inPbLastCloseTime();
                if (!StringUtils.isNull(this.f19541e)) {
                    this.f19542f.K1(this.f19541e);
                }
                this.f19542f.C1.setAutoCompleteShown(false);
                this.f19542f.k1();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
                c.a.q0.i3.e0.a(this.f19542f.B1.c(this.f19542f.B0.j0()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(q0 q0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Integer.valueOf(i2)};
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
            this.f19543a = q0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f19543a.x0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19544e;

        public g(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19544e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19544e.q2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.a.p0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19545e;

        public h(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19545e = q0Var;
        }

        @Override // c.a.p0.x.b
        public void onAction(c.a.p0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f15088c;
                if (obj instanceof c.a.p0.t.c.v) {
                    if (((c.a.p0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((c.a.p0.t.c.v) aVar.f15088c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19545e.s1 == null) {
                            this.f19545e.s1 = new PermissionJudgePolicy();
                        }
                        this.f19545e.s1.clearRequestPermissionList();
                        this.f19545e.s1.appendRequestPermission(this.f19545e.f19513c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f19545e.s1.startRequestPermission(this.f19545e.f19513c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19545e.f19513c.getPbEditor().h((c.a.p0.t.c.v) aVar.f15088c);
                        this.f19545e.f19513c.getPbEditor().A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19547f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19548g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f19549h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ q0 f19550i;

        public h0(q0 q0Var, int i2, int i3, int i4, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19550i = q0Var;
            this.f19546e = i2;
            this.f19547f = i3;
            this.f19548g = i4;
            this.f19549h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f19546e;
                if (i2 == this.f19547f || i2 - this.f19548g >= 0) {
                    this.f19550i.g1.showAsDropDown(this.f19550i.n0, this.f19549h.getLeft(), -this.f19550i.n0.getHeight());
                } else {
                    this.f19550i.g1.showAsDropDown(this.f19549h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19551e;

        public i(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19551e = q0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f19551e.f19513c.mContentProcessController == null || this.f19551e.f19513c.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f19551e.f19513c.mContentProcessController.e().e()) {
                this.f19551e.f19513c.mContentProcessController.a(false);
            }
            this.f19551e.f19513c.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f19551e.h0 == null || this.f19551e.h0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f19551e.j1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f19551e.h0.getId());
                q0 q0Var = this.f19551e;
                q0Var.j1 = new c.a.q0.i2.k.e.z0.c(q0Var.f19513c.getPageContext(), this.f19551e.f19514d, layoutParams);
                if (!ListUtils.isEmpty(this.f19551e.i1)) {
                    this.f19551e.j1.m(this.f19551e.i1);
                }
                this.f19551e.j1.n(this.f19551e.h0);
            }
            this.f19551e.j1.l(substring);
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19552e;

        public i0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19552e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19552e.C1.inPbLastCloseTime();
                this.f19552e.k1();
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19554f;

        public j(q0 q0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19554f = q0Var;
            this.f19553e = z;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19554f.N.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f19554f.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f19554f.K1 != null) {
                            this.f19554f.K1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f19554f.f19513c.handleMuteClick(this.f19553e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19555a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(q0 q0Var, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, Integer.valueOf(i2)};
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
            this.f19555a = q0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f19555a.E1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19556e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19557f;

        public k0(q0 q0Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19557f = q0Var;
            this.f19556e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19557f.x1 || this.f19556e == null || this.f19557f.f19513c.getPbModel() == null || !this.f19557f.f19513c.getPbModel().p1()) {
                return;
            }
            this.f19557f.x1 = true;
            this.f19556e.checkEasterEgg(false);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q0 f19560g;

        public l(q0 q0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19560g = q0Var;
            this.f19558e = alertDialog;
            this.f19559f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19558e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f19560g.f19513c.getPbActivity(), R.string.neterror);
                } else {
                    this.f19560g.f19513c.deleteThread(this.f19559f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19561a;

        public l0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19561a = q0Var;
        }

        @Override // c.a.q0.i2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19561a.f19513c.hideKeyBroad();
            }
        }

        @Override // c.a.q0.i2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19561a.l == null) {
                return;
            }
            if (this.f19561a.p != null) {
                this.f19561a.p.t();
            }
            this.f19561a.l.setSelection(0);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19562e;

        public m(q0 q0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19562e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19562e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19563e;

        public m0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19563e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.p0.s.q.t0(this.f19563e.f19513c.getActivity(), "pb_huitie"))) {
                this.f19563e.f19513c.processProfessionPermission();
                if (this.f19563e.f19513c == null || this.f19563e.f19513c.getPbModel() == null || this.f19563e.f19513c.getPbModel().O0() == null || this.f19563e.f19513c.getPbModel().O0().O() == null || this.f19563e.f19513c.getPbModel().O0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19563e.f19513c.getPbModel().f1()).param("fid", this.f19563e.f19513c.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19563e.f19513c.getPbModel().f55030f).param("fid", this.f19563e.f19513c.getPbModel().O0().n()).param("obj_locate", 1).param("uid", this.f19563e.f19513c.getPbModel().O0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19565f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q0 f19566g;

        public n(q0 q0Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19566g = q0Var;
            this.f19564e = alertDialog;
            this.f19565f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19564e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f19566g.f19513c.getPbActivity(), R.string.neterror);
                } else {
                    this.f19566g.f19513c.deleteThread(this.f19565f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19567e;

        public n0(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19567e = q0Var;
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
                    this.f19567e.f19513c.checkMuteState(sparseArray);
                    return;
                }
                this.f19567e.d2(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f19567e.f19513c.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f19567e.Y1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19568e;

        public o(q0 q0Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19568e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19568e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class o0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19569a;

        /* renamed from: b  reason: collision with root package name */
        public int f19570b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f19571c;

        public o0() {
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
    public class p implements g.InterfaceC0904g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f19572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q0 f19573b;

        public p(q0 q0Var, c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19573b = q0Var;
            this.f19572a = aVar;
        }

        @Override // c.a.q0.i.g.InterfaceC0904g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19573b.f19513c.deleteThread(this.f19572a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q0 f19575b;

        public q(q0 q0Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19575b = q0Var;
            this.f19574a = sparseArray;
        }

        @Override // c.a.q0.i.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19575b.f19513c.deleteThread(this.f19574a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19576e;

        public r(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19576e = q0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f19576e.X = (String) compoundButton.getTag();
                if (this.f19576e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f19576e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f19576e.X != null && !str.equals(this.f19576e.X)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19577e;

        public s(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19577e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19577e.R instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f19577e.R, this.f19577e.f19513c.getPageContext());
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

        @Override // c.a.q0.i3.h0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19579f;

        public u(q0 q0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19579f = q0Var;
            this.f19578e = cVar;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19579f.Z.dismiss();
                this.f19578e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19581f;

        public v(q0 q0Var, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19581f = q0Var;
            this.f19580e = cVar;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19581f.Z.dismiss();
                this.f19580e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19582e;

        public w(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19582e = q0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f19582e.B0 == null || this.f19582e.B0.O() == null || this.f19582e.B0.O().J() == null || this.f19582e.B0.O().J().getAlaInfo() == null || this.f19582e.B0.O().J().getAlaInfo().live_status != 1) {
                    if (this.f19582e.b1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f19582e.b1 && this.f19582e.B0 != null && this.f19582e.B0.O() != null && this.f19582e.B0.O().J() != null && this.f19582e.B0.O().J().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f19582e.f19513c.getPbActivity() != null) {
                        this.f19582e.f19513c.getPbActivity().mEvent.f19238b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f19582e.B0.n());
                statisticItem2.param("fname", this.f19582e.B0.o());
                statisticItem2.param("obj_param1", this.f19582e.B0.O().J().getAlaInfo().user_info != null ? this.f19582e.B0.O().J().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f19582e.B0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f19582e.B0.O().J().getAlaInfo()));
                if (this.f19582e.B0.O().J().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f19582e.B0.O().J().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f19582e.B0.O().J().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f19582e.f19513c.getPageContext(), this.f19582e.B0.O().J().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f19583a;

        public x(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19583a = q0Var;
        }

        @Override // c.a.q0.i2.k.e.y0.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f19583a.v.a(this.f19583a.l);
                } else {
                    this.f19583a.v.d(this.f19583a.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f19584e;

        public y(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19584e = q0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            q0 q0Var;
            c.a.q0.i2.k.e.e1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19584e.A == null || (cVar = (q0Var = this.f19584e).f19518h) == null || cVar.f19404i == null || q0Var.B0 == null || this.f19584e.B0.O() == null || this.f19584e.B0.O().A2() || this.f19584e.F1() || this.f19584e.B0.m() == null || c.a.e.e.p.k.isEmpty(this.f19584e.B0.m().getName())) {
                return;
            }
            if ((this.f19584e.A.H() == null || !this.f19584e.A.H().isShown()) && (linearLayout = this.f19584e.f19518h.f19404i) != null) {
                linearLayout.setVisibility(0);
                if (this.f19584e.f19513c == null || this.f19584e.f19513c.getPbModel() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f19584e.f19513c.getPbModel().e1());
                statisticItem.param("fid", this.f19584e.f19513c.getPbModel().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q0 f19586f;

        public z(q0 q0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19586f = q0Var;
            this.f19585e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.e.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f19586f.f19513c.getPageContext(), new String[]{this.f19585e});
                    this.f19586f.f19513c.finish();
                    return;
                }
                this.f19586f.f19513c.showToast(R.string.neterror);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(900586578, "Lc/a/q0/i2/k/e/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(900586578, "Lc/a/q0/i2/k/e/q0;");
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

    public q0(PbFragment pbFragment, View.OnClickListener onClickListener, c.a.q0.i2.i.c cVar) {
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
        this.f19513c = null;
        this.f19514d = null;
        this.f19515e = null;
        this.f19516f = 0;
        this.f19517g = new Handler();
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
        this.R0 = new o0();
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
        this.F1 = new j0(this, 2921306);
        this.G1 = new d(this, 2005016);
        this.H1 = new Handler();
        this.J1 = new f(this, 2004009);
        this.L1 = true;
        this.M1 = new w(this);
        this.N1 = false;
        this.O1 = null;
        this.Q1 = new ArrayList();
        this.S1 = false;
        this.t1 = System.currentTimeMillis();
        this.f19513c = pbFragment;
        this.K = onClickListener;
        this.f0 = cVar;
        this.e1 = c.a.e.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19513c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f19514d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.j0 = this.f19514d.findViewById(R.id.bottom_shadow);
        this.o1 = (NavigationBarCoverTip) this.f19514d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f19515e = this.f19514d.findViewById(R.id.statebar_view);
        this.C1 = (RightFloatLayerView) this.f19514d.findViewById(R.id.right_layer_view);
        this.z = (ObservedChangeRelativeLayout) this.f19514d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f19514d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f19514d.findViewById(R.id.new_pb_list);
        this.I0 = (FrameLayout) this.f19514d.findViewById(R.id.root_float_header);
        this.J0 = new TextView(this.f19513c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f19513c.getActivity(), R.dimen.ds88));
        this.l.addHeaderView(this.J0, 0);
        this.l.setTextViewAdded(true);
        this.U0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.O0 = new View(this.f19513c.getPageContext().getPageActivity());
        if (c.a.p0.e1.b.e.d()) {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, this.U0));
        }
        this.O0.setVisibility(4);
        this.l.addFooterView(this.O0);
        this.l.setOnTouchListener(this.f19513c.mOnTouchListener);
        this.f19511a = new k0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f19511a);
        this.f19518h = new c.a.q0.i2.k.e.e1.c(pbFragment, this.f19514d);
        if (this.f19513c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19514d.findViewById(R.id.manga_view_stub);
            this.f19520j = viewStub;
            viewStub.setVisibility(0);
            c.a.q0.i2.k.e.e1.b bVar = new c.a.q0.i2.k.e.e1.b(pbFragment);
            this.f19519i = bVar;
            bVar.c();
            this.f19518h.f19396a.setVisibility(8);
            layoutParams.height = c.a.e.e.p.l.g(this.f19513c.getActivity(), R.dimen.ds120);
        }
        this.J0.setLayoutParams(layoutParams);
        this.f19518h.p().setOnTouchListener(new c.a.q0.i2.i.a(new l0(this)));
        this.m0 = this.f19514d.findViewById(R.id.view_comment_top_line);
        this.n0 = this.f19514d.findViewById(R.id.pb_editor_tool_comment);
        c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.y0 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f19514d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.p0 = headImageView;
        headImageView.setVisibility(0);
        this.p0.setIsRound(true);
        this.p0.setBorderWidth(c.a.e.e.p.l.g(this.f19513c.getContext(), R.dimen.L_X01));
        this.p0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.p0.setPlaceHolder(0);
        L1();
        this.q0 = (TextView) this.f19514d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f19514d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.o0 = linearLayout;
        linearLayout.setOnClickListener(new m0(this));
        this.r0 = (ImageView) this.f19514d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.z1 = (MaskView) this.f19514d.findViewById(R.id.mask_view);
        this.r0.setOnClickListener(this.K);
        boolean booleanExtra = this.f19513c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f19514d.findViewById(R.id.pb_editor_tool_collection);
        this.s0 = imageView;
        imageView.setOnClickListener(this.K);
        if (booleanExtra) {
            this.s0.setVisibility(8);
        } else {
            this.s0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f19514d.findViewById(R.id.pb_editor_tool_share);
        this.t0 = imageView2;
        imageView2.setOnClickListener(this.K);
        this.u0 = new c.a.q0.i2.p.j(this.t0);
        TextView textView = (TextView) this.f19514d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.v0 = textView;
        textView.setVisibility(0);
        this.G0 = (ViewStub) this.f19514d.findViewById(R.id.interview_status_stub);
        this.q = new c.a.q0.i2.k.e.y0.d(this.f19513c, cVar);
        this.s = new c.a.q0.i2.k.e.y0.h(this.f19513c, cVar, this.K);
        c.a.q0.i2.k.e.g gVar = new c.a.q0.i2.k.e.g(this.f19513c, this.l);
        this.A = gVar;
        gVar.q0(this.K);
        this.A.s0(this.f0);
        this.A.n0(this.L);
        this.A.p0(this.f19513c.onSwitchChangeListener);
        n0 n0Var = new n0(this);
        this.O = n0Var;
        this.A.m0(n0Var);
        t1();
        n1();
        c.a.q0.i2.k.e.y0.g gVar2 = new c.a.q0.i2.k.e.y0.g(this.f19513c);
        this.u = gVar2;
        gVar2.f19725f = 2;
        m1();
        this.v.a(this.l);
        this.r.a(this.l);
        this.s.h(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f19513c.getPageContext().getPageActivity());
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
        this.J = this.f19514d.findViewById(R.id.viewstub_progress);
        this.f19513c.registerListener(this.J1);
        this.W0 = new PbFakeFloorModel(this.f19513c.getPageContext());
        PbModel pbModel = this.f19513c.getPbModel();
        this.W0.O(pbModel.E(), pbModel.A(), pbModel.B(), pbModel.z(), pbModel.F());
        c.a.q0.i2.k.e.s sVar = new c.a.q0.i2.k.e.s(this.f19513c.getPageContext(), this.W0, this.f19514d);
        this.X0 = sVar;
        sVar.k(new b(this));
        this.X0.m(this.f19513c.mOnFloorPostWriteNewCallback);
        this.W0.Q(new c(this));
        if (this.f19513c.getPbModel() != null && !StringUtils.isNull(this.f19513c.getPbModel().R0())) {
            PbFragment pbFragment2 = this.f19513c;
            pbFragment2.showToast(pbFragment2.getPbModel().R0());
        }
        this.K0 = this.f19514d.findViewById(R.id.pb_expand_blank_view);
        this.L0 = this.f19514d.findViewById(R.id.bottom_rec_float_title);
        View findViewById2 = this.f19514d.findViewById(R.id.sticky_view);
        this.M0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f19513c.getPbModel() != null && this.f19513c.getPbModel().B0()) {
            this.K0.setVisibility(0);
            t2(true);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.M0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = U1;
            this.M0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f19513c.getPageContext(), this.f19514d.findViewById(R.id.pb_reply_expand_view));
        this.N0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
        this.N0.mDivideLineTop.setVisibility(8);
        this.N0.setPbCommonOnclickListener(this.K);
        this.N0.setOnSwitchChangeListener(this.f19513c.onSwitchChangeListener);
        this.f19513c.registerListener(this.G1);
        this.f19513c.registerListener(this.F1);
        PbFragment pbFragment3 = this.f19513c;
        this.y1 = new c.a.q0.i2.p.i(pbFragment3, pbFragment3.getUniqueId());
        this.A1 = (FallingView) this.f19514d.findViewById(R.id.falling_view);
        Y();
        p2(false);
        this.k0 = this.f19514d.findViewById(R.id.pb_comment_container);
        X(c.a.p0.e1.b.e.d());
        this.B1 = new c.a.q0.i2.o.j.a();
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
            this.u1 = z2;
        }
    }

    public void A3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || this.l == null || (textView = this.J0) == null || this.f19515e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f19515e.setVisibility(0);
            } else {
                this.f19515e.setVisibility(8);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.m1 = z2;
        }
    }

    public final void B3(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || eVar == null || eVar.O() == null || eVar.O().A2()) {
            return;
        }
        boolean z2 = eVar.O().o0() == 1;
        boolean z3 = eVar.O().p0() == 1;
        c.a.q0.i2.k.e.y0.h hVar = this.s;
        if (hVar != null) {
            hVar.j(eVar, z2, z3);
        }
        c.a.q0.i2.k.e.g gVar = this.A;
        if (gVar == null || gVar.t() == null) {
            return;
        }
        this.A.t().showThreadTypeStampBottomPart(eVar, z2, z3);
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.q0.i2.p.j jVar = this.u0;
            if (jVar != null) {
                return jVar.f();
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
        c.a.q0.i2.k.e.y0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.r(z2);
    }

    @SuppressLint({"CutPasteId"})
    public void C3(c.a.q0.i2.h.e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, eVar, z2) == null) || eVar == null) {
            return;
        }
        L3(eVar, z2);
        g0();
    }

    public PbInterviewStatusView D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.H0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean D1(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, c2Var)) == null) {
            if (c2Var == null || c2Var.J() == null) {
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
            this.A.f0(z2);
        }
    }

    public void D3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f19513c.showToast(str);
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

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.A.k0(z2);
        }
    }

    public void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f19513c.showProgressBar();
        }
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
            c.a.q0.i2.h.e eVar = this.B0;
            return eVar == null || eVar.m() == null || "0".equals(this.B0.m().getId()) || "me0407".equals(this.B0.m().getName());
        }
        return invokeV.booleanValue;
    }

    public void F2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.P1 = gVar;
            c.a.q0.i2.p.k kVar = this.F;
            if (kVar != null) {
                kVar.a(gVar);
            }
        }
    }

    public void F3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (fallingView = this.A1) == null) {
            return;
        }
        fallingView.stopAllViews();
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
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void G2(String str) {
        c.a.q0.i2.k.e.e1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || (bVar = this.f19519i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.Q1 == null) {
            return;
        }
        while (this.Q1.size() > 0) {
            TbImageView remove = this.Q1.remove(0);
            if (remove != null) {
                remove.stopLoading();
            }
        }
    }

    public SparseArray<Object> H0(c.a.q0.i2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData x0;
        c.a.p0.s.q.e0 e0Var;
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
                List<y1> q2 = eVar.q();
                if (ListUtils.getCount(q2) > 0) {
                    sb = new StringBuilder();
                    for (y1 y1Var : q2) {
                        if (y1Var != null && !StringUtils.isNull(y1Var.getForumName()) && (e0Var = y1Var.f14404g) != null && e0Var.f14201a && !e0Var.f14203c && ((i3 = e0Var.f14202b) == 1 || i3 == 2)) {
                            sb.append(c.a.e.e.p.k.cutString(y1Var.getForumName(), 12));
                            sb.append(this.f19513c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f19513c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
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

    public void H2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            this.Z0 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.a1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) {
            this.b0 = z2;
        }
    }

    public c.a.q0.i2.k.d.a I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.k1 : (c.a.q0.i2.k.d.a) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            c.a.q0.i2.p.j jVar = this.u0;
            if (jVar == null) {
                return false;
            }
            return jVar.h();
        }
        return invokeV.booleanValue;
    }

    public void I2(PbFragment.a3 a3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, a3Var) == null) {
        }
    }

    public void I3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.f19518h.I(z2);
            if (z2 && this.F0) {
                this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.G);
                this.f19516f = 2;
            }
            L1();
        }
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

    public void J2(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, zVar) == null) {
            this.L = zVar;
            this.A.n0(zVar);
            this.k1.q(this.L);
        }
    }

    public void J3(c.a.q0.i2.h.c cVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f19518h.J();
        if (!StringUtils.isNull(cVar.f19057b)) {
            this.f19518h.G(cVar.f19057b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d2 = c.a.e.e.m.b.d(cVar.f19056a, 0);
        if (d2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d2 != 300) {
            string = d2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f19513c.showNetRefreshView(this.f19514d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new z(this, cVar.f19058c));
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public final void K1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f19513c.getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void K2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bVar) == null) {
            this.M = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void K3(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.O())) {
                c.a.q0.i2.p.j jVar = this.u0;
                if (jVar != null) {
                    jVar.k(false);
                    this.u0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.t0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.t0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.q0.i2.p.j jVar2 = this.u0;
            if (jVar2 == null || !jVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.t0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.t0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
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

    public void L2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public boolean L3(c.a.q0.i2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048623, this, eVar, z2)) == null) {
            if (eVar == null) {
                return false;
            }
            if (this.r != null) {
                if (eVar.O() != null && eVar.O().m0() == 0 && !eVar.O().A2() && !this.D1) {
                    if (eVar.O() != null) {
                        c2 O = eVar.O();
                        O.T2(true, i3(eVar));
                        O.e4(3);
                        O.Z3("2");
                    }
                    if (eVar.O().J1()) {
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
                } else if (eVar.O().m0() == 1) {
                    if (eVar.O() != null) {
                        this.r.d(this.l);
                        this.s.x(this.B0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.x(this.B0);
                }
            }
            B3(eVar);
            this.A0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
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
        C3(this.B0, this.A0);
        k2(this.B0, this.A0, this.D0, i2);
        this.f19513c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f19513c.getBaseFragmentActivity().getLayoutMode().j(this.f19514d);
        SkinManager.setBackgroundColor(this.f19514d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
        c.a.q0.i2.k.e.y0.i iVar = this.p;
        if (iVar != null) {
            iVar.h(i2);
        }
        c.a.q0.i2.k.e.y0.e eVar = this.t;
        if (eVar != null) {
            eVar.c(i2);
        }
        c.a.q0.i2.k.e.y0.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
        c.a.q0.i2.k.e.y0.f fVar = this.r;
        if (fVar != null) {
            fVar.c(i2);
        }
        c.a.q0.i2.k.e.y0.h hVar = this.s;
        if (hVar != null) {
            hVar.q(i2);
        }
        c.a.q0.i2.k.e.y0.g gVar = this.u;
        if (gVar != null) {
            gVar.d();
        }
        c.a.q0.i2.k.e.y0.c cVar = this.v;
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
            this.f19513c.getBaseFragmentActivity().getLayoutMode().j(this.I);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        c.a.p0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f19513c.getPageContext());
        }
        H3(this.b0);
        this.A.X();
        c.a.q0.i2.p.k kVar = this.F;
        if (kVar != null) {
            kVar.D(i2);
        }
        EditorTools editorTools = this.h0;
        if (editorTools != null) {
            editorTools.onChangeSkinType(i2);
        }
        c.a.q0.i2.p.g gVar2 = this.H;
        if (gVar2 != null) {
            gVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.onChangeSkinMode();
            }
        }
        M3();
        UtilHelper.setStatusBarBackground(this.f19515e, i2);
        UtilHelper.setStatusBarBackground(this.M0, i2);
        if (this.w != null) {
            c.a.p0.u0.a.a(this.f19513c.getPageContext(), this.w);
        }
        c.a.q0.i2.k.e.s sVar = this.X0;
        if (sVar != null) {
            sVar.h(i2);
        }
        c.a.q0.i2.k.e.e1.c cVar2 = this.f19518h;
        if (cVar2 != null) {
            c.a.q0.i2.k.e.y0.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.i(i2);
            } else {
                cVar2.v(i2);
            }
        }
        HeadImageView headImageView = this.p0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.o0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f19513c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        c.a.q0.i2.h.e eVar2 = this.B0;
        if (eVar2 != null && eVar2.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        K3(this.B0);
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
        c.a.q0.i2.k.d.a aVar2 = this.k1;
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
        c.a.q0.i2.p.j jVar = this.u0;
        if (jVar != null) {
            jVar.i();
        }
        c.a.q0.i2.p.i iVar3 = this.y1;
        if (iVar3 != null) {
            iVar3.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.L0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0.findViewById(R.id.tv_title), R.color.CAM_X0105);
    }

    public void M2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && this.f19513c.getIsMangaThread()) {
            if (this.f19513c.getMangaPrevChapterId() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
            if (this.f19513c.getMangaNextChapterId() == -1) {
                SkinManager.setViewTextColor(this.y, R.color.CAM_X0110, 1);
            }
        }
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
        d0();
        if (configuration.orientation == 2) {
            d1();
            f1();
        } else {
            q2();
        }
        c.a.q0.i2.k.e.s sVar = this.X0;
        if (sVar != null) {
            sVar.c();
        }
        this.f19513c.hideKeyBroad();
        this.z.setVisibility(8);
        this.f19518h.C(false);
        this.f19513c.setNavigationBarShowFlag(false);
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

    public void N2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.A.r0(onClickListener);
        }
    }

    public void N3(c.a.q0.i2.h.e eVar) {
        c.a.q0.i2.k.e.y0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, eVar) == null) || (dVar = this.q) == null) {
            return;
        }
        dVar.h(eVar, this.A0);
    }

    public PbFakeFloorModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.W0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void O1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            RelativeLayout relativeLayout = this.f19514d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f19514d.getHandler().removeCallbacksAndMessages(null);
            }
            c.a.q0.i2.p.j jVar = this.u0;
            if (jVar != null) {
                jVar.j();
            }
            c.a.q0.i2.k.e.l0 l0Var = this.Y0;
            if (l0Var != null) {
                l0Var.a();
            }
            c.a.q0.i2.k.e.e0 e0Var = this.n1;
            if (e0Var != null) {
                e0Var.c();
            }
            PbTopTipView pbTopTipView = this.f1;
            if (pbTopTipView != null) {
                pbTopTipView.hide();
            }
            this.f19513c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.M) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            d0();
            j0();
            if (this.V0 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.V0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.H0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.clearStatus();
            }
            this.H1 = null;
            this.f19517g.removeCallbacksAndMessages(null);
            this.A.Y(3);
            View view = this.f19515e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.a();
            }
            c.a.q0.i2.k.e.g gVar = this.A;
            if (gVar != null) {
                gVar.Z();
            }
            this.l.setOnLayoutListener(null);
            c.a.q0.i2.k.e.z0.c cVar = this.j1;
            if (cVar != null) {
                cVar.h();
            }
            PbEmotionBar pbEmotionBar = this.S0;
            if (pbEmotionBar != null) {
                pbEmotionBar.onDestroy();
            }
            c.a.q0.i2.k.e.y0.h hVar = this.s;
            if (hVar != null) {
                hVar.r();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f19511a);
            }
        }
    }

    public void O2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.v1 = i2;
        }
    }

    public c.a.q0.i2.k.e.s P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.X0 : (c.a.q0.i2.k.e.s) invokeV.objValue;
    }

    public void P1(TbRichText tbRichText) {
        c.a.q0.i2.h.e eVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, tbRichText) == null) || (eVar = this.B0) == null || eVar.F() == null || this.B0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.B0.F().size() && (postData = this.B0.F().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.B0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                c.a.q0.i2.k.d.a aVar = this.k1;
                if (aVar != null && aVar.l()) {
                    f3(false);
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

    public void P2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onLongClickListener) == null) {
            this.s.u(onLongClickListener);
            this.A.o0(onLongClickListener);
            c.a.q0.i2.k.d.a aVar = this.k1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public c.a.q0.i2.k.e.y0.i Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.p : (c.a.q0.i2.k.e.y0.i) invokeV.objValue;
    }

    public boolean Q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void Q2(PostData postData, c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, postData, eVar) == null) {
            this.s.v(postData, eVar);
        }
    }

    public final boolean R(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048641, this, absListView, i2)) == null) {
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

    public final PostData R0(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null || eVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = eVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> y1 = eVar.O().y1();
            if (y1 != null && (metaData = y1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.i0(1);
            postData.l0(eVar.O().W());
            postData.x0(eVar.O().getTitle());
            postData.w0(eVar.O().P());
            postData.g0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void R1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || this.f19513c == null) {
            return;
        }
        if ((this.u1 || this.v1 == 17) && c.a.p0.b.d.t0()) {
            c.a.q0.i2.h.e eVar = this.B0;
            if (eVar == null || eVar.m() == null || c.a.e.e.p.k.isEmpty(this.B0.m().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19513c.getContext()).createNormalCfg(this.B0.m().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.B0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.B0.m().getId()));
        } else if (!this.c1 || this.b1 || (postData = this.C0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f19513c.isSimpleForum() ? 2 : 1).param("obj_type", this.b1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19513c.getPageContext().getPageActivity(), this.C0.t().getUserId(), this.C0.t().getUserName(), this.f19513c.getPbModel().p0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void R2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048644, this, z2, postWriteCallBackData) == null) {
            this.f19513c.hideProgressBar();
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
        c.a.q0.i2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (jVar = this.u0) == null) {
            return;
        }
        jVar.l(false);
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (!c.a.e.e.p.k.isEmpty(this.r1)) {
                return this.r1;
            }
            if (this.f19513c != null) {
                this.r1 = TbadkCoreApplication.getInst().getResources().getString(c.a.q0.i2.k.e.o0.b());
            }
            return this.r1;
        }
        return (String) invokeV.objValue;
    }

    public void S1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z2) == null) {
            if (z2) {
                l3();
            } else {
                g1();
            }
            this.R0.f19571c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            f2(this.R0.f19571c, false);
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.f19513c.hideProgressBar();
            j0();
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
    }

    public boolean T(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z2)) == null) {
            EditorTools editorTools = this.h0;
            if (editorTools == null || !editorTools.isToolVisible()) {
                return false;
            }
            this.h0.hideTools();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final int T0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, pbReplyTitleViewHolder)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            G3();
            this.A.Y(1);
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void T2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048652, this) == null) || (pbFragment = this.f19513c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        c.a.e.e.p.l.x(this.f19513c.getPageContext().getPageActivity(), this.f19513c.getBaseFragmentActivity().getCurrentFocus());
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.A.Y(2);
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f19513c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19513c.getFragmentActivity())) {
                    return;
                }
                b1().setSystemUiVisibility(4);
            }
        }
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.G.x();
            this.G.O();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.B0 == null || !c.a.p0.b.d.a0() || c.a.q0.i2.k.e.d1.b.k(this.B0.Q())) {
            return;
        }
        this.u0.e();
        c.a.q0.i2.k.e.d1.b.b(this.B0.Q());
    }

    public final int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
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
        c.a.q0.i2.k.e.y0.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048659, this, absListView, i2, i3, i4) == null) {
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            c.a.q0.i2.k.e.e1.c cVar = this.f19518h;
            if (cVar != null && (hVar = this.s) != null) {
                cVar.x(hVar.m());
            }
            o0 o0Var = this.R0;
            o0Var.f19569a = i2;
            o0Var.f19570b = this.l.getHeaderViewsCount();
            this.R0.f19571c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            e3(R(absListView, i2));
            int i5 = 0;
            f2(this.R0.f19571c, false);
            c0();
            if (!this.G.m() || this.G.C) {
                return;
            }
            o0 o0Var2 = this.R0;
            if (o0Var2 != null && (pbReplyTitleViewHolder = o0Var2.f19571c) != null && pbReplyTitleViewHolder.getView() != null) {
                i5 = this.R0.f19571c.getView().getTop() < 0 ? this.R0.f19571c.getView().getHeight() : this.R0.f19571c.getView().getBottom();
            }
            this.G.e(i5);
            this.G.C = true;
        }
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            this.s.w(z2);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            if (!this.f19513c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.e0));
            } else if (this.f19513c.checkPrivacyBeforeInput()) {
                c.a.p0.x.w.e pbEditor = this.f19513c.getPbEditor();
                if (pbEditor != null && (pbEditor.C() || pbEditor.E())) {
                    this.f19513c.getPbEditor().A(false, null);
                    return;
                }
                if (this.h0 != null) {
                    q1();
                }
                EditorTools editorTools = this.h0;
                if (editorTools != null) {
                    this.x0 = false;
                    if (editorTools.findToolById(2) != null) {
                        c.a.q0.i3.h0.a.c(this.f19513c.getPageContext(), (View) this.h0.findToolById(2).k, false, c2);
                    }
                }
                d1();
            }
        }
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.E0 : invokeV.intValue;
    }

    public void W1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048663, this, absListView, i2) == null) {
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.T1 && i2 == 0) {
                this.R1 = V0();
                this.R0.f19571c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
                f2(this.R0.f19571c, true);
                c0();
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

    public void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.q0.performClick();
            if (StringUtils.isNull(str) || this.f19513c.getPbEditor() == null || this.f19513c.getPbEditor().w() == null || this.f19513c.getPbEditor().w().i() == null) {
                return;
            }
            EditText i2 = this.f19513c.getPbEditor().w().i();
            i2.setText(str);
            i2.setSelection(str.length());
        }
    }

    public void X(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) {
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

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.f19515e : (View) invokeV.objValue;
    }

    public void X1(ArrayList<c.a.p0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, arrayList) == null) {
            if (this.S == null) {
                this.S = LayoutInflater.from(this.f19513c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f19513c.getBaseFragmentActivity().getLayoutMode().j(this.S);
            if (this.R == null) {
                Dialog dialog = new Dialog(this.f19513c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.R = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.R.setCancelable(true);
                this.g0 = (ScrollView) this.S.findViewById(R.id.good_scroll);
                this.R.setContentView(this.S);
                WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.R.getWindow().setAttributes(attributes);
                this.U = new r(this);
                this.T = (LinearLayout) this.S.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.S.findViewById(R.id.dialog_button_cancel);
                this.W = textView;
                textView.setOnClickListener(new s(this));
                TextView textView2 = (TextView) this.S.findViewById(R.id.dialog_button_ok);
                this.V = textView2;
                textView2.setOnClickListener(this.K);
            }
            this.T.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton Z = Z("0", this.f19513c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(Z);
            Z.setChecked(true);
            this.T.addView(Z);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.p0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton Z2 = Z(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(Z2);
                        View view = new View(this.f19513c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.T.addView(view);
                        this.T.addView(Z2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.g0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19513c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19513c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19513c.getPageContext().getPageActivity(), 186.0f);
                }
                this.g0.setLayoutParams(layoutParams2);
                this.g0.removeAllViews();
                LinearLayout linearLayout = this.T;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.g0.addView(this.T);
                }
            }
            c.a.e.e.m.g.j(this.R, this.f19513c.getPageContext());
        }
    }

    public void X2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            c.a.q0.i2.k.d.a aVar = new c.a.q0.i2.k.d.a(this.f19513c, this, (ViewStub) this.f19514d.findViewById(R.id.more_god_reply_popup));
            this.k1 = aVar;
            aVar.o(this.K);
            this.k1.p(this.O);
            this.k1.q(this.L);
            this.k1.o(this.K);
            this.k1.s(this.f0);
        }
    }

    public PbThreadPostView Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void Y1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            Z1(i2, str, i3, z2, null);
        }
    }

    public void Y2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, list) == null) {
            this.i1 = list;
            c.a.q0.i2.k.e.z0.c cVar = this.j1;
            if (cVar != null) {
                cVar.m(list);
            }
        }
    }

    public final CustomBlueCheckRadioButton Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048673, this, str, str2)) == null) {
            Activity pageActivity = this.f19513c.getPageContext().getPageActivity();
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

    public RelativeLayout Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.z : (RelativeLayout) invokeV.objValue;
    }

    public void Z1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048675, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            a2(i2, str, i3, z2, str2, false);
        }
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            PbFragment pbFragment = this.f19513c;
            return (pbFragment == null || pbFragment.getPbModel().O0().m().getDeletedReasonInfo() == null || 1 != this.f19513c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || this.S1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.S1 = true;
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f19513c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(W1, Integer.valueOf(Y1));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f19513c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f19513c);
        aVar.setNegativeButton(R.string.look_again, new f0(this));
        aVar.create(this.f19513c.getPageContext()).show();
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? R.id.user_icon_box : invokeV.intValue;
    }

    public void a2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048680, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.P = new c.a.p0.s.s.a(this.f19513c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.P.setMessageId(i4);
            } else {
                this.P.setOnlyMessageShowCenter(false);
                this.P.setMessage(str2);
            }
            this.P.setYesButtonTag(sparseArray);
            this.P.setPositiveButton(R.string.dialog_ok, this.f19513c);
            this.P.setNegativeButton(R.string.dialog_cancel, new k(this));
            this.P.setCancelable(true);
            this.P.create(this.f19513c.getPageContext());
            if (z3) {
                h3(sparseArray);
            } else if (z2) {
                h3(sparseArray);
            } else if (Z2()) {
                c.a.q0.i.i iVar = new c.a.q0.i.i(this.f19513c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19513c.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19513c.getPbModel().O0().p().has_forum_rule.intValue());
                iVar.i(this.f19513c.getPbModel().O0().m().getId(), this.f19513c.getPbModel().O0().m().getName());
                iVar.h(this.f19513c.getPbModel().O0().m().getImage_url());
                iVar.j(this.f19513c.getPbModel().O0().m().getUser_level());
                o3(sparseArray, i2, iVar, this.f19513c.getPbModel().O0().U(), false);
            } else {
                w3(this.P, i2);
            }
        }
    }

    public void a3() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.I0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c.a.q0.i2.k.e.e1.c cVar = this.f19518h;
            if (cVar == null || (view = cVar.f19399d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", org.apache.commons.lang3.StringUtils.LF);
            }
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f19513c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19513c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
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
            aVar.setPositiveButton(R.string.view, this.f19513c);
            aVar.setNegativeButton(R.string.cancel, new g0(this));
            aVar.create(this.f19513c.getPageContext()).show();
        }
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.f19514d : (View) invokeV.objValue;
    }

    public void b2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(W1, Integer.valueOf(X1));
            if (z2) {
                c3(sparseArray);
            } else {
                d3(i2, sparseArray);
            }
        }
    }

    public void b3() {
        c.a.q0.i2.k.e.y0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.u(this.l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.w1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0() {
        c.a.q0.i2.p.i iVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (iVar = this.y1) == null) {
            return;
        }
        if (((iVar.a() == null || this.y1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.y1.a())) != -1) {
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

    public void c1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.I0.setVisibility(8);
            }
            c.a.q0.i2.k.e.e1.c cVar = this.f19518h;
            if (cVar == null || (view = cVar.f19399d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void c2(SparseArray<Object> sparseArray, boolean z2) {
        c.a.p0.s.s.f fVar;
        c.a.p0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048688, this, sparseArray, z2) == null) {
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f19513c.getContext());
            iVar.q(this.f19513c.getString(R.string.bar_manager));
            iVar.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.p0.s.s.f(10, this.f19513c.getString(R.string.delete_post), iVar);
                } else {
                    fVar2 = new c.a.p0.s.s.f(10, this.f19513c.getString(R.string.delete), iVar);
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
                fVar2.f14463d.setTag(sparseArray2);
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
                c.a.p0.s.s.f fVar3 = new c.a.p0.s.s.f(11, this.f19513c.getString(R.string.forbidden_person), iVar);
                fVar3.f14463d.setTag(sparseArray3);
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
                    fVar = new c.a.p0.s.s.f(12, this.f19513c.getString(R.string.un_mute), iVar);
                } else {
                    fVar = new c.a.p0.s.s.f(12, this.f19513c.getString(R.string.mute), iVar);
                }
                fVar.f14463d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            c.a.q0.i2.k.e.d1.a.e(arrayList);
            if (c.a.p0.b.d.O()) {
                iVar.l(arrayList, false);
            } else {
                iVar.l(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f19513c.getPageContext(), iVar);
            this.N = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final void c3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048689, this, sparseArray) == null) || this.f19513c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.p0.s.s.l lVar = new c.a.p0.s.s.l(this.f19513c.getPbActivity());
        lVar.p(R.string.musk_my_thread_confirm);
        lVar.j(R.string.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new n(this, s2, sparseArray));
        aVar2.a(new o(this, s2));
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.f19518h.k();
            c.a.q0.i2.k.e.y0.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PbFragment pbFragment = this.f19513c;
            if (pbFragment != null) {
                c.a.e.e.p.l.x(pbFragment.getContext(), this.E);
            }
            f1();
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.p0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.p0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || this.n0 == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048692, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        c2(sparseArray, false);
    }

    public final void d3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048693, this, i2, sparseArray) == null) || (pbFragment = this.f19513c) == null || pbFragment.getPbModel() == null || this.f19513c.getPbModel().O0() == null || this.f19513c.getPbModel().O0().p() == null || this.f19513c.getPbModel().O0().m() == null || this.f19513c.getPbModel().O0().m().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.q0.i.i iVar = new c.a.q0.i.i(this.f19513c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19513c.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19513c.getPbModel().O0().p().has_forum_rule.intValue());
        iVar.i(this.f19513c.getPbModel().O0().m().getId(), this.f19513c.getPbModel().O0().m().getName());
        iVar.h(this.f19513c.getPbModel().O0().m().getImage_url());
        iVar.j(this.f19513c.getPbModel().O0().m().getUser_level());
        o3(sparseArray, i2, iVar, this.f19513c.getPbModel().O0().U(), true);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.f19518h.k();
            c.a.q0.i2.k.e.y0.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.p0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.p0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void e1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) || this.n0 == null || this.q0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        c.a.q0.i2.h.e eVar = this.B0;
        boolean z3 = eVar != null && eVar.j0();
        c.a.q0.i2.h.e eVar2 = this.B0;
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

    public void e2(c.a.p0.u.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048696, this, aVar, i2) == null) || (fallingView = this.A1) == null) {
            return;
        }
        fallingView.start(aVar, this.f19513c.getPageContext(), i2);
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.j0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void f0() {
        c.a.q0.i2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || (jVar = this.u0) == null) {
            return;
        }
        jVar.k(false);
    }

    public void f1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048699, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hide();
        c.a.q0.i2.k.e.z0.c cVar = this.j1;
        if (cVar != null) {
            cVar.i();
        }
    }

    public final void f2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048700, this, pbReplyTitleViewHolder, z2) == null) || this.b1 || this.K0 == null || this.f19518h.p() == null) {
            return;
        }
        View r2 = p0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.K0.getVisibility() == 0 && i3 - this.f19518h.p().getBottom() <= this.K0.getHeight()) {
                    this.L0.setVisibility(0);
                    if (i3 > this.f19518h.p().getBottom()) {
                        i2 = -(((this.K0.getHeight() + this.L0.getHeight()) + this.f19518h.p().getBottom()) - r2.getBottom());
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
                t2(false);
                return;
            }
            this.K0.setVisibility(0);
            t2(true);
            e3(false);
            this.f19518h.f19396a.hideBottomLine();
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
                    measuredHeight = this.f19518h.p().getMeasuredHeight() - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                    this.f19518h.f19396a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.P0) {
                    this.K0.setVisibility(0);
                    t2(true);
                    e3(false);
                } else if (top < measuredHeight) {
                    this.K0.setVisibility(0);
                    t2(true);
                    e3(false);
                } else {
                    this.K0.setVisibility(4);
                    t2(false);
                    this.f19518h.f19396a.hideBottomLine();
                }
                if (z2) {
                    this.Q0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.K0.setVisibility(4);
            t2(false);
            this.f19518h.f19396a.hideBottomLine();
        }
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) || this.n0 == null) {
            return;
        }
        y2(this.f19513c.getPbEditor().D());
        if (this.i0) {
            j3(z2);
        } else {
            e1(z2);
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.q.b(this.A0) : invokeV.booleanValue;
    }

    public void g1() {
        c.a.q0.i2.k.e.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048703, this) == null) || (cVar = this.f19518h) == null) {
            return;
        }
        cVar.q();
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.s.s(this.B0, this.C0, this.c1, this.b1);
        }
    }

    public void g3(c.a.q0.i2.h.e eVar) {
        PostData postData;
        c.a.q0.i2.k.e.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048705, this, eVar) == null) || eVar == null || (postData = this.C0) == null || postData.t() == null || (cVar = this.f19518h) == null) {
            return;
        }
        boolean z2 = !this.b1;
        this.c1 = z2;
        cVar.H(z2);
        if (this.f19513c.getPbNavigationAnimDispatcher() != null) {
            this.f19513c.getPbNavigationAnimDispatcher().s(this.c1);
        }
        g2();
        PbFragment pbFragment = this.f19513c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
            y1 y1Var = eVar.q().get(0);
            if (y1Var != null) {
                this.f19518h.L(eVar, y1Var.getForumName(), y1Var.getForumId(), y1Var.b(), y1Var.getIsLike());
            }
        } else if (eVar.m() != null) {
            this.f19518h.L(eVar, eVar.m().getName(), eVar.m().getId(), eVar.m().getImage_url(), eVar.m().isLike() == 1);
        }
        if (this.c1) {
            this.s.C(eVar, this.C0, this.c0);
            View view = this.M0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.l1 == null) {
                this.l1 = new b0(this);
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

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            c.a.p0.s.s.a aVar = this.P;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.Q;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f19513c.getPageContext());
            }
            Dialog dialog2 = this.R;
            if (dialog2 != null) {
                c.a.e.e.m.g.b(dialog2, this.f19513c.getPageContext());
            }
            PopupDialog popupDialog = this.N;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void h1() {
        c.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048707, this) == null) || (aVar = this.z0) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.a1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.R0.f19571c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.R0.f19571c;
        int T0 = T0(pbReplyTitleViewHolder);
        int measuredHeight = this.z.getMeasuredHeight() + ((int) this.z.getY());
        boolean z2 = this.K0.getVisibility() == 0;
        boolean z3 = this.z.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.A.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), U1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.f19518h.p().getMeasuredHeight() - measuredHeight2);
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

    public final void h3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048709, this, sparseArray) == null) || this.f19513c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.p0.s.s.l lVar = new c.a.p0.s.s.l(this.f19513c.getPbActivity());
        lVar.p(R.string.del_my_thread_confirm);
        lVar.j(R.string.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new l(this, s2, sparseArray));
        aVar2.a(new m(this, s2));
    }

    public void i0() {
        c.a.q0.i2.k.e.y0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048710, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.b();
    }

    public void i1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
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

    public final void i2(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048712, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        K3(eVar);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String o02 = o0(eVar.O().S0());
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

    public final boolean i3(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return false;
            }
            return eVar.O().j0() == 1 || eVar.O().m1() == 33 || !(eVar.O().u1() == null || eVar.O().u1().a() == 0) || eVar.O().p0() == 1 || eVar.O().o0() == 1 || eVar.O().G1() || eVar.O().Z1() || eVar.O().D2() || eVar.O().D1() != null || !c.a.e.e.p.k.isEmpty(eVar.O().N()) || eVar.O().W1() || eVar.O().m2();
        }
        return invokeL.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.v();
                this.G.f();
            }
            h1();
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            this.J.setVisibility(8);
        }
    }

    public void j2(int i2, c.a.q0.i2.h.e eVar, boolean z2, int i3) {
        PostData x0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (x0 = x0(eVar, z2)) == null || x0.t() == null) {
            return;
        }
        MetaData t2 = x0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void j3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048717, this, z2) == null) || this.n0 == null || (textView = this.q0) == null) {
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

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
    }

    public void k1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048719, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public void k2(c.a.q0.i2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048720, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            r3(eVar, z2, i2, i3);
            this.s.q(i3);
        }
    }

    public void k3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048721, this, view) == null) || c.a.p0.s.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.n0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f19513c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f19513c.getContext());
        this.h1 = textView;
        textView.setText(R.string.connection_tips);
        this.h1.setGravity(17);
        this.h1.setPadding(c.a.e.e.p.l.g(this.f19513c.getContext(), R.dimen.ds24), 0, c.a.e.e.p.l.g(this.f19513c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = c.a.e.e.p.l.g(this.f19513c.getContext(), R.dimen.ds60);
        if (this.h1.getParent() == null) {
            frameLayout.addView(this.h1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f19513c.getContext());
        this.g1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.g1.setHeight(-2);
        this.g1.setWidth(-2);
        this.g1.setFocusable(true);
        this.g1.setOutsideTouchable(false);
        this.g1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new h0(this, i4, i2, i3, view), 100L);
        c.a.p0.s.d0.b.j().t("show_long_press_collection_tips", true);
    }

    public boolean l0(c.a.p0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048722, this, aVar, i2)) == null) {
            FallingView fallingView = this.A1;
            if (fallingView != null) {
                return fallingView.showByLimit(aVar, i2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void l1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048723, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public final void l2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048724, this) == null) && (pbInterviewStatusView = this.H0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.H0.setLayoutParams(layoutParams);
        }
    }

    public void l3() {
        c.a.q0.i2.k.e.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || (cVar = this.f19518h) == null || this.d1) {
            return;
        }
        cVar.D();
        this.d1 = true;
    }

    public void m0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048726, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f19513c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f19513c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f19513c.showToast(str);
            }
        }
    }

    public final void m1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && this.v == null && (pbFragment = this.f19513c) != null) {
            this.v = new c.a.q0.i2.k.e.y0.c(pbFragment.getContext());
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || this.f19516f == 2) {
            return;
        }
        this.l.setNextPage(this.G);
        this.f19516f = 2;
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public void n0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && this.r == null) {
            this.r = new c.a.q0.i2.k.e.y0.f(this.f19513c, this.f0);
        }
    }

    public void n2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.v.d(pbLandscapeListView);
        this.r.d(this.l);
        this.s.t(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            if (this.z0 == null) {
                this.z0 = new c.a.p0.s.f0.a(this.f19513c.getPageContext());
            }
            this.z0.h(true);
        }
    }

    public final String o0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048734, this, i2)) == null) {
            if (i2 == 0) {
                return this.f19513c.getString(R.string.pb_comment_red_dot_no_reply);
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

    public final void o1(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048735, this, eVar) == null) && eVar != null && eVar.O() != null && eVar.O().Z1() && this.H0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.G0.inflate();
            this.H0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.K);
            this.H0.setCallback(this.f19513c.getInterviewStatusCallback());
            this.H0.setData(this.f19513c, eVar);
        }
    }

    public final void o2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (pbFragment = this.f19513c) == null || pbFragment.getPbEditor() == null || this.h0 == null) {
            return;
        }
        c.a.p0.x.w.a.a().c(0);
        c.a.p0.x.w.e pbEditor = this.f19513c.getPbEditor();
        pbEditor.U();
        pbEditor.S();
        if (pbEditor.z() != null) {
            pbEditor.z().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.m0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.p0.x.h findLauncherById = this.h0.findLauncherById(23);
        c.a.p0.x.h findLauncherById2 = this.h0.findLauncherById(2);
        c.a.p0.x.h findLauncherById3 = this.h0.findLauncherById(5);
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

    public final void o3(SparseArray<Object> sparseArray, int i2, c.a.q0.i.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048737, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f19513c) == null) {
            return;
        }
        if (this.q1 == null && this.q != null) {
            this.q1 = new c.a.q0.i.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        this.q1.C(z2);
        AntiData antiData = this.f19513c.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.k(sparseArray2);
        this.q1.E(new String[]{this.f19513c.getString(R.string.delete_thread_reason_1), this.f19513c.getString(R.string.delete_thread_reason_2), this.f19513c.getString(R.string.delete_thread_reason_3), this.f19513c.getString(R.string.delete_thread_reason_4), this.f19513c.getString(R.string.delete_thread_reason_5)});
        this.q1.D(x0Var);
        this.q1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.q1.F(new q(this, sparseArray));
    }

    public c.a.q0.i2.k.e.g p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.A : (c.a.q0.i2.k.e.g) invokeV.objValue;
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && this.f19513c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19514d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.w == null) {
                this.w = (LinearLayout) this.f19514d.findViewById(R.id.manga_controller_layout);
                c.a.p0.u0.a.a(this.f19513c.getPageContext(), this.w);
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
        if (interceptable == null || interceptable.invokeZ(1048740, this, z2) == null) {
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.A.c0(this.B0, false);
            this.A.X();
        }
    }

    public LinearLayout q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.o0 : (LinearLayout) invokeV.objValue;
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || this.f19513c == null || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.display();
        if (this.f19513c.getPbEditor() != null) {
            this.f19513c.getPbEditor().Q();
        }
        d1();
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            o2();
            f1();
            this.X0.c();
            f3(false);
        }
    }

    public void q3(c.a.q0.i2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048745, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || eVar == null || this.l == null) {
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
        V();
        this.F0 = false;
        this.A0 = z2;
        S2();
        c.a.q0.i2.h.k kVar = eVar.f19069h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f19513c.getContext());
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
        r3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        g3(eVar);
        if (this.n1 == null) {
            this.n1 = new c.a.q0.i2.k.e.e0(this.f19513c.getPageContext(), this.o1);
        }
        this.n1.a(eVar.w());
        if (this.f19513c.getIsMangaThread()) {
            if (this.F == null) {
                c.a.q0.i2.p.k kVar2 = new c.a.q0.i2.p.k(this.f19513c.getPageContext());
                this.F = kVar2;
                kVar2.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.q0.i2.p.k kVar3 = this.F;
            if (kVar3 != null) {
                kVar3.D(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.F == null) {
                c.a.q0.i2.p.k kVar4 = new c.a.q0.i2.p.k(this.f19513c.getPageContext());
                this.F = kVar4;
                kVar4.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            r2();
            c.a.q0.i2.p.k kVar5 = this.F;
            if (kVar5 != null) {
                kVar5.D(TbadkCoreApplication.getInst().getSkinType());
            }
            h1();
        }
        g0();
        this.A.j0(this.A0);
        this.A.g0(false);
        this.A.h0(i2 == 5);
        this.A.i0(i2 == 6);
        this.A.e0(z3 && this.L1 && i2 != 2);
        this.A.c0(eVar, false);
        this.A.X();
        this.s.B(x0(eVar, z2), eVar.f0());
        if (eVar.O() != null && eVar.O().J0() != null && this.f19512b != -1) {
            eVar.O().J0().setIsLike(this.f19512b);
        }
        this.l.removeFooterView(this.O0);
        this.l.addFooterView(this.O0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.G);
            this.f19516f = 2;
            h1();
        } else {
            this.F0 = true;
            if (eVar.y().b() == 1) {
                if (this.H == null) {
                    PbFragment pbFragment = this.f19513c;
                    this.H = new c.a.q0.i2.p.g(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.H);
            } else {
                this.l.setNextPage(this.G);
            }
            this.f19516f = 3;
        }
        ArrayList<PostData> F = eVar.F();
        if (eVar.y().b() != 0 && F != null && F.size() >= eVar.y().e()) {
            if (z3) {
                if (this.L1) {
                    j0();
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
                o0 o0Var = this.R0;
                if (o0Var == null || (pbReplyTitleViewHolder = o0Var.f19571c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i5 = 0;
                } else {
                    i5 = this.R0.f19571c.getView().getTop() < 0 ? this.R0.f19571c.getView().getHeight() : this.R0.f19571c.getView().getBottom();
                }
                if (this.f19513c.isHostOnlyMode()) {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f19513c.getPbNavigationAnimDispatcher() != null && !this.f19513c.getPbNavigationAnimDispatcher().p()) {
                    this.f19513c.getPbNavigationAnimDispatcher().x();
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
                        c.a.q0.i2.k.e.y0.i iVar = this.p;
                        if (iVar != null && iVar.c() != null) {
                            if (this.f19513c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - c.a.e.e.p.l.r(this.f19513c.getPageContext().getPageActivity()));
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
                    this.G.A(this.f19513c.getString(R.string.pb_load_more_without_point));
                    this.G.v();
                }
            } else if (i4 == 1 && (e3 = c.a.q0.i2.k.e.j0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = c.a.q0.i2.k.e.j0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new a0(this, e2, F, eVar));
        }
        if (this.T0 == V1 && C1()) {
            a0();
        }
        if (this.Z0) {
            h2();
            this.Z0 = false;
            if (i4 == 0) {
                H2(true);
            }
        }
        if (eVar.f19065d == 1 || eVar.f19066e == 1) {
            if (this.f1 == null) {
                this.f1 = new PbTopTipView(this.f19513c.getContext());
            }
            if (eVar.f19066e == 1 && "game_guide".equals(this.f19513c.getStType())) {
                this.f1.setText(this.f19513c.getString(R.string.pb_read_strategy_add_experience));
                this.f1.show(this.f19514d, this.E0);
            } else if (eVar.f19065d == 1 && "game_news".equals(this.f19513c.getStType())) {
                this.f1.setText(this.f19513c.getString(R.string.pb_read_news_add_experience));
                this.f1.show(this.f19514d, this.E0);
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
        if (eVar.d0() && this.f19513c.getPbRecThreadController() != null) {
            this.f19513c.getPbRecThreadController().d();
        }
        if (eVar.g() != 3) {
            s1(eVar);
        }
        this.q0.setText(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), S0()));
    }

    public View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || this.C1 == null) {
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
            c.a.q0.i3.e0.a(this.B1.d(this.B0.j0()));
            this.C1.setLogoListener(new e0(this, this.B1.b(this.B0.j0())));
            this.C1.setFeedBackListener(new i0(this));
        }
    }

    public final void r2() {
        c.a.q0.i2.k.e.y0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(this.l, this.J0, this.D0);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void r3(c.a.q0.i2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048749, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        if (this.f19513c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.d0 = eVar.h().getForumName();
                this.e0 = eVar.h().getForumId();
            }
            if (this.d0 == null && this.f19513c.getPbModel() != null && this.f19513c.getPbModel().p0() != null) {
                this.d0 = this.f19513c.getPbModel().p0();
            }
        }
        PostData x0 = x0(eVar, z2);
        Q2(x0, eVar);
        this.s.y(8);
        if (eVar.p0()) {
            this.b1 = true;
            this.f19518h.B(true);
            this.f19518h.f19396a.hideBottomLine();
            if (this.p == null) {
                this.p = new c.a.q0.i2.k.e.y0.i(this.f19513c);
            }
            this.p.v(eVar, x0, this.l, this.s, this.I0, this.f19518h, this.d0, this.t1);
            this.p.s(this.M1);
            r2();
        } else {
            this.b1 = false;
            this.f19518h.B(false);
            c.a.q0.i2.k.e.y0.i iVar = this.p;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f19513c.getPbNavigationAnimDispatcher() != null) {
            this.f19513c.getPbNavigationAnimDispatcher().w(this.b1);
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
        this.v.e(eVar, this.v1, new x(this));
        this.r.f(eVar);
        this.q.h(eVar, this.A0);
        this.q.g(eVar);
        this.s.z(this.E0, this.B0, x0, this.M1);
        if (this.N0 != null) {
            if (eVar.f0()) {
                this.N0.getView().setVisibility(8);
            } else {
                this.N0.getView().setVisibility(0);
                c.a.q0.i2.h.o oVar = new c.a.q0.i2.h.o(c.a.q0.i2.h.o.l);
                if (eVar.O() != null) {
                    eVar.O().S0();
                }
                oVar.f19103g = eVar.f19068g;
                eVar.c();
                oVar.f19104h = this.f19513c.isHostOnlyMode();
                oVar.k = eVar.f19067f;
                this.N0.bindDataToView(oVar);
            }
        }
        B3(eVar);
        c.a.e.e.m.e.a().post(new y(this));
        this.u.e(this.l);
        if (x0.S) {
            this.u.f(x0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        c.a.q0.i2.k.e.g gVar = this.A;
        if (gVar != null && gVar.z() != null) {
            this.A.z().s0(x0.S);
        }
        c.a.q0.i2.k.e.g gVar2 = this.A;
        if (gVar2 != null) {
            gVar2.l0(x0.S);
        }
        this.z1.setVisibility(x0.S ? 0 : 8);
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public void s1(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, eVar) == null) {
            this.B1.g(eVar.k() == null ? null : eVar.k().pbpage);
            this.B1.f(TbSingleton.getInstance().getAdFloatViewData());
            if (this.B1.e(eVar.j0())) {
                r1();
            }
        }
    }

    public void s2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || (handler = this.H1) == null) {
            return;
        }
        Runnable runnable = this.I1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        e eVar = new e(this);
        this.I1 = eVar;
        this.H1.postDelayed(eVar, 2000L);
    }

    public void s3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048753, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Z = null;
            }
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f19513c.getContext());
            ArrayList arrayList = new ArrayList();
            c.a.q0.i2.h.e eVar = this.B0;
            if (eVar != null && eVar.O() != null && !this.B0.O().N1()) {
                arrayList.add(new c.a.p0.s.s.f(0, this.f19513c.getPageContext().getString(R.string.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.p0.s.s.f(1, this.f19513c.getPageContext().getString(R.string.save_to_local), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new v(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19513c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public int t0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && this.t == null) {
            this.t = new c.a.q0.i2.k.e.y0.e(this.f19513c, this.K);
        }
    }

    public final void t2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921599, Boolean.valueOf(z2)));
        }
    }

    public void t3(b.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Y = null;
            }
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f19513c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new c.a.p0.s.s.f(0, this.f19513c.getPageContext().getString(R.string.copy), iVar));
            }
            if (z3) {
                arrayList.add(new c.a.p0.s.s.f(1, this.f19513c.getPageContext().getString(R.string.report_text), iVar));
            } else if (!z2) {
                arrayList.add(new c.a.p0.s.s.f(1, this.f19513c.getPageContext().getString(R.string.mark), iVar));
            } else {
                arrayList.add(new c.a.p0.s.s.f(1, this.f19513c.getPageContext().getString(R.string.remove_mark), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new u(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19513c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public PostData u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
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

    public void u1(c.a.q0.i2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, eVar) == null) {
            int i2 = 0;
            this.A.c0(eVar, false);
            this.A.X();
            g0();
            c.a.q0.i2.k.d.a aVar = this.k1;
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
                    o0 o0Var = this.R0;
                    if (o0Var != null && (pbReplyTitleViewHolder = o0Var.f19571c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i2 = this.R0.f19571c.getView().getTop() < 0 ? this.R0.f19571c.getView().getHeight() : this.R0.f19571c.getView().getBottom();
                    }
                    if (this.f19513c.isHostOnlyMode()) {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            i2(eVar);
        }
    }

    public void u2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, editorTools) == null) {
            this.h0 = editorTools;
            editorTools.setOnCancelClickListener(new g(this));
            this.h0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.h0.getParent() == null) {
                this.f19514d.addView(this.h0, layoutParams);
            }
            this.h0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.h0.setActionListener(24, new h(this));
            f1();
            this.f19513c.getPbEditor().i(new i(this));
        }
    }

    public void u3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, onItemClickListener) == null) {
            c.a.p0.s.s.c cVar = this.a0;
            if (cVar != null) {
                cVar.d();
                this.a0 = null;
            }
            if (this.B0 == null) {
                return;
            }
            ArrayList<c.a.p0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.p0.s.s.k(this.f19513c.getContext().getString(R.string.all_person), "", this.B0.L() == 1, Integer.toString(1)));
            arrayList.add(new c.a.p0.s.s.k(this.f19513c.getContext().getString(R.string.my_fans), "", this.B0.L() == 2, Integer.toString(5)));
            arrayList.add(new c.a.p0.s.s.k(this.f19513c.getContext().getString(R.string.my_attentions), "", this.B0.L() == 3, Integer.toString(6)));
            arrayList.add(new c.a.p0.s.s.k(this.f19513c.getContext().getString(R.string.myself_only), "", this.B0.L() == 4, Integer.toString(7)));
            c.a.p0.s.s.c cVar2 = new c.a.p0.s.s.c(this.f19513c.getPageContext());
            cVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.a0 = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.a0.n();
        }
    }

    public FallingView v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.A1 : (FallingView) invokeV.objValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.N1 : invokeV.booleanValue;
    }

    public void v2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048764, this, str) == null) || (pbListView = this.G) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void v3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || !TbadkCoreApplication.isLogin() || this.B0 == null || !this.c1 || this.b1 || this.c0 || (postData = this.C0) == null || postData.t() == null || this.C0.t().getIsLike() || this.C0.t().hadConcerned() || this.Y0 != null) {
            return;
        }
        this.Y0 = new c.a.q0.i2.k.e.l0(this.f19513c);
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) ? y0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? this.x0 : invokeV.booleanValue;
    }

    public void w2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048768, this, str) == null) || this.G == null) {
            return;
        }
        int i2 = 0;
        o0 o0Var = this.R0;
        if (o0Var != null && (pbReplyTitleViewHolder = o0Var.f19571c) != null && pbReplyTitleViewHolder.getView() != null) {
            i2 = this.R0.f19571c.getView().getTop() < 0 ? this.R0.f19571c.getView().getHeight() : this.R0.f19571c.getView().getBottom();
        }
        this.G.D(str, i2);
    }

    public final void w3(c.a.p0.s.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048769, this, aVar, i2) == null) || (pbFragment = this.f19513c) == null || aVar == null) {
            return;
        }
        if (this.p1 == null && this.q != null) {
            this.p1 = new c.a.q0.i.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData antiData = this.f19513c.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.k(sparseArray);
        this.p1.y(new String[]{this.f19513c.getString(R.string.delete_thread_reason_1), this.f19513c.getString(R.string.delete_thread_reason_2), this.f19513c.getString(R.string.delete_thread_reason_3), this.f19513c.getString(R.string.delete_thread_reason_4), this.f19513c.getString(R.string.delete_thread_reason_5)});
        this.p1.x(x0Var);
        this.p1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.p1.z(new p(this, aVar));
    }

    public PostData x0(c.a.q0.i2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048770, this, eVar, z2)) == null) {
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

    public final boolean x1(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048771, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return false;
            }
            SpannableStringBuilder e1 = eVar.O().e1();
            if (e1 != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(e1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void x2(PbFragment.z2 z2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, z2Var) == null) {
            this.K1 = z2Var;
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            this.J.setVisibility(0);
        }
    }

    public final int y0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048774, this, i2)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048776, this, z2) == null) {
            this.i0 = z2;
        }
    }

    public void y3() {
        c.a.q0.i2.p.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048777, this) == null) || (jVar = this.u0) == null) {
            return;
        }
        jVar.m(2);
    }

    public Button z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) ? this.l0 : (Button) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) {
            EditorTools editorTools = this.h0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z2) == null) {
            this.A.d0(z2);
        }
    }

    public void z3(b1 b1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048781, this, b1Var, eVar) == null) || b1Var == null) {
            return;
        }
        int a3 = b1Var.a();
        int h2 = b1Var.h();
        c.a.p0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.show();
        } else {
            this.B = new c.a.p0.s.s.a(this.f19513c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19513c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.D = inflate;
            this.B.setContentView(inflate);
            this.B.setPositiveButton(R.string.dialog_ok, eVar);
            this.B.setNegativeButton(R.string.dialog_cancel, new c0(this));
            this.B.setOnCalcelListener(new d0(this));
            this.B.create(this.f19513c.getPageContext()).show();
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
        this.f19513c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.E, 150);
    }
}
