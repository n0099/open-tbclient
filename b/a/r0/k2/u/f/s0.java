package b.a.r0.k2.u.f;

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
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.z1;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.q0.s.s.i;
import b.a.r0.j.g;
import b.a.r0.j.j;
import b.a.r0.k2.s.a;
import b.a.r0.k2.u.f.a1.c;
import b.a.r0.l3.i0.a;
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
import com.baidu.tbadk.core.data.AntiData;
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
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
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
/* loaded from: classes5.dex */
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
    public b.a.r0.k2.u.f.h A;
    public b.a.q0.s.g0.a A0;
    public MaskView A1;
    public b.a.q0.s.s.a B;
    public boolean B0;
    public final FallingView B1;
    public b.a.q0.s.s.b C;
    public b.a.r0.k2.r.f C0;
    public RightFloatLayerView C1;
    public View D;
    public PostData D0;
    public boolean D1;
    public EditText E;
    public int E0;
    public String E1;
    public b.a.r0.k2.z.j F;
    public int F0;
    public CustomMessageListener F1;
    public PbListView G;
    public boolean G0;
    public CustomMessageListener G1;
    public b.a.r0.k2.z.f H;
    public ViewStub H0;
    public Handler H1;
    public View I;
    public PbInterviewStatusView I0;
    public Runnable I1;
    public View J;
    public FrameLayout J0;
    public CustomMessageListener J1;
    public View K;
    public TextView K0;
    public PbFragment.b3 K1;
    public View.OnClickListener L;
    public View L0;
    public boolean L1;
    public TbRichTextView.z M;
    public View M0;
    public View.OnClickListener M1;
    public NoNetworkView.b N;
    public View N0;
    public boolean N1;
    public PopupDialog O;
    public PbReplyTitleViewHolder O0;
    public String O1;
    public View.OnClickListener P;
    public View P0;
    public f.g P1;
    public b.a.q0.s.s.a Q;
    public int Q0;
    public final List<TbImageView> Q1;
    public Dialog R;
    public boolean R0;
    public int R1;
    public Dialog S;
    public p0 S0;
    public boolean S1;
    public View T;
    public PbEmotionBar T0;
    public boolean T1;
    public LinearLayout U;
    public int U0;
    public CompoundButton.OnCheckedChangeListener V;
    public int V0;
    public TextView W;
    public Runnable W0;
    public TextView X;
    public PbFakeFloorModel X0;
    public String Y;
    public b.a.r0.k2.u.f.t Y0;
    public PopupDialog Z;
    public b.a.r0.k2.u.f.n0 Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f19399a;
    public PopupDialog a0;
    public boolean a1;

    /* renamed from: b  reason: collision with root package name */
    public int f19400b;
    public b.a.q0.s.s.c b0;
    public int b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f19401c;
    public boolean c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19402d;
    public boolean d0;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public View f19403e;
    public String e0;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public int f19404f;
    public String f0;
    public int f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f19405g;
    public b.a.r0.k2.s.c g0;
    public PbTopTipView g1;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.r0.k2.u.f.g1.c f19406h;
    public ScrollView h0;
    public PopupWindow h1;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.k2.u.f.g1.b f19407i;
    public EditorTools i0;
    public TextView i1;
    public ViewStub j;
    public boolean j0;
    public List<String> j1;
    public ViewStub k;
    public View k0;
    public b.a.r0.k2.u.f.b1.c k1;
    public PbLandscapeListView l;
    public View l0;
    public b.a.r0.k2.u.e.a l1;
    public NoNetworkView m;
    public Button m0;
    public PbLandscapeListView.c m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public boolean n1;
    public PbThreadPostView o;
    public View o0;
    public b.a.r0.k2.u.f.f0 o1;
    public b.a.r0.k2.u.f.a1.i p;
    public LinearLayout p0;
    public NavigationBarCoverTip p1;
    public b.a.r0.k2.u.f.a1.d q;
    public HeadImageView q0;
    public b.a.r0.j.g q1;
    public b.a.r0.k2.u.f.a1.f r;
    public TextView r0;
    public b.a.r0.j.j r1;
    public b.a.r0.k2.u.f.a1.h s;
    public ImageView s0;
    public String s1;
    public b.a.r0.k2.u.f.a1.e t;
    public ImageView t0;
    public PermissionJudgePolicy t1;
    public b.a.r0.k2.u.f.a1.g u;
    public ImageView u0;
    public long u1;
    public b.a.r0.k2.u.f.a1.c v;
    public b.a.r0.k2.z.i v0;
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
    public b.a.r0.k2.z.h z1;

    /* loaded from: classes5.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19408a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f19409b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19410c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19411d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19414g;

        /* renamed from: b.a.r0.k2.u.f.s0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0969a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19415e;

            public RunnableC0969a(a aVar) {
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
                this.f19415e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19415e.f19414g.P0 == null || this.f19415e.f19414g.P0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f19415e.f19414g.P0.getLayoutParams();
                layoutParams.height = this.f19415e.f19414g.V0;
                this.f19415e.f19414g.P0.setLayoutParams(layoutParams);
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
            this.f19414g = s0Var;
            this.f19408a = i2;
            this.f19409b = pbReplyTitleViewHolder;
            this.f19410c = z;
            this.f19411d = i3;
            this.f19412e = i4;
            this.f19413f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f19408a;
                if (i3 >= 0 && i3 <= this.f19414g.f19402d.getMeasuredHeight()) {
                    int S0 = this.f19414g.S0(this.f19409b);
                    int i4 = this.f19408a;
                    int i5 = S0 - i4;
                    if (this.f19410c && i5 != 0 && i4 <= (i2 = this.f19411d)) {
                        i5 = S0 - i2;
                    }
                    if (this.f19414g.P0 == null || (layoutParams = this.f19414g.P0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f19414g.f19402d.getMeasuredHeight() || S0 >= this.f19414g.f19402d.getMeasuredHeight()) {
                        layoutParams.height = this.f19414g.V0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f19414g.f19402d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f19414g.l.setSelectionFromTop(this.f19412e, this.f19413f);
                            }
                        }
                        layoutParams.height = this.f19414g.V0;
                    }
                    this.f19414g.P0.setLayoutParams(layoutParams);
                    b.a.e.e.m.e.a().post(new RunnableC0969a(this));
                }
                this.f19414g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19417f;

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
            this.f19417f = s0Var;
            this.f19416e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (b.a.e.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f19417f.f19401c.getPageContext(), new String[]{this.f19416e});
                    this.f19417f.f19401c.finish();
                    return;
                }
                this.f19417f.f19401c.showToast(b.a.r0.k2.l.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19418e;

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
            this.f19418e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19418e.o2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f19419e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f19420f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.k2.r.f f19421g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ s0 f19422h;

        public b0(s0 s0Var, Parcelable parcelable, ArrayList arrayList, b.a.r0.k2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, parcelable, arrayList, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19422h = s0Var;
            this.f19419e = parcelable;
            this.f19420f = arrayList;
            this.f19421g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19422h.l.onRestoreInstanceState(this.f19419e);
                if (ListUtils.getCount(this.f19420f) <= 1 || this.f19421g.y().b() <= 0) {
                    return;
                }
                this.f19422h.G.f();
                this.f19422h.G.C(this.f19422h.f19401c.getString(b.a.r0.k2.l.pb_load_more_without_point));
                this.f19422h.G.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19423a;

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
            this.f19423a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19423a.X0.N(postData);
                this.f19423a.A.X();
                this.f19423a.Y0.c();
                this.f19423a.i0.hideTools();
                this.f19423a.c3(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19424a;

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
            this.f19424a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f19424a.f19401c != null && this.f19424a.f19401c.isAdded()) {
                if (i2 < 0 && f2 > this.f19424a.f1) {
                    this.f19424a.c0();
                    this.f19424a.P1();
                }
                this.f19424a.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements FallingView.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19425a;

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
            this.f19425a = s0Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19425a.C1.getTag() == this.f19425a.B1) {
                this.f19425a.C1.setTag(null);
                this.f19425a.C1.setAutoCompleteShown(true);
                this.f19425a.C1.completeShow();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.l
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f19425a.C1.setAutoCompleteShown(false);
                if (this.f19425a.C1.getVisibility() == 0) {
                    this.f19425a.C1.setTag(this.f19425a.B1);
                    this.f19425a.C1.completeHide();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19426e;

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
            this.f19426e = s0Var;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19426e.c0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19427a;

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
            this.f19427a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f19427a.A == null) {
                return;
            }
            this.f19427a.A.X();
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f19428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19429f;

        public e0(s0 s0Var, b.a.q0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19429f = s0Var;
            this.f19428e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19428e == null || this.f19429f.C0 == null || this.f19429f.C1 == null) {
                return;
            }
            this.f19429f.C1.doLink(this.f19428e);
            this.f19429f.C1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19430e;

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
            this.f19430e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19430e.w == null) {
                    this.f19430e.o1();
                }
                this.f19430e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19431e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f0 f19432e;

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
                this.f19432e = f0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19432e.f19431e.f19401c.HidenSoftKeyPad((InputMethodManager) this.f19432e.f19431e.f19401c.getBaseFragmentActivity().getSystemService("input_method"), this.f19432e.f19431e.f19402d);
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
            this.f19431e = s0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f19431e.W0 == null) {
                    this.f19431e.W0 = new a(this);
                }
                b.a.e.e.m.e.a().postDelayed(this.f19431e.W0, 150L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19433a;

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
            this.f19433a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f19433a.y0 = false;
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19434e;

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
            this.f19434e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19434e.o2();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19435e;

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
            this.f19435e = s0Var;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14197c;
                if (obj instanceof b.a.q0.t.c.w) {
                    if (((b.a.q0.t.c.w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((b.a.q0.t.c.w) aVar.f14197c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19435e.t1 == null) {
                            this.f19435e.t1 = new PermissionJudgePolicy();
                        }
                        this.f19435e.t1.clearRequestPermissionList();
                        this.f19435e.t1.appendRequestPermission(this.f19435e.f19401c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f19435e.t1.startRequestPermission(this.f19435e.f19401c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19435e.f19401c.getPbEditor().h((b.a.q0.t.c.w) aVar.f14197c);
                        this.f19435e.f19401c.getPbEditor().A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f19439h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ s0 f19440i;

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
            this.f19440i = s0Var;
            this.f19436e = i2;
            this.f19437f = i3;
            this.f19438g = i4;
            this.f19439h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f19436e;
                if (i2 == this.f19437f || i2 - this.f19438g >= 0) {
                    this.f19440i.h1.showAsDropDown(this.f19440i.o0, this.f19439h.getLeft(), -this.f19440i.o0.getHeight());
                } else {
                    this.f19440i.h1.showAsDropDown(this.f19439h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19441e;

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
            this.f19441e = s0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f19441e.f19401c.mContentProcessController == null || this.f19441e.f19401c.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f19441e.f19401c.mContentProcessController.e().e()) {
                this.f19441e.f19401c.mContentProcessController.a(false);
            }
            this.f19441e.f19401c.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f19441e.i0 == null || this.f19441e.i0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f19441e.k1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f19441e.i0.getId());
                s0 s0Var = this.f19441e;
                s0Var.k1 = new b.a.r0.k2.u.f.b1.c(s0Var.f19401c.getPageContext(), this.f19441e.f19402d, layoutParams);
                if (!ListUtils.isEmpty(this.f19441e.j1)) {
                    this.f19441e.k1.m(this.f19441e.j1);
                }
                this.f19441e.k1.n(this.f19441e.i0);
            }
            this.f19441e.k1.l(substring);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.t.c.g f19442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19443f;

        public j0(s0 s0Var, b.a.q0.t.c.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19443f = s0Var;
            this.f19442e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19443f.C1.inPbLastCloseTime();
                this.f19443f.j1();
                this.f19443f.C1.reportClickCloseAd(this.f19442e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19445f;

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
            this.f19445f = s0Var;
            this.f19444e = z;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19445f.O.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f19445f.W1(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f19445f.K1 != null) {
                            this.f19445f.K1.a(new Object[]{sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f19445f.f19401c.handleMuteClick(this.f19444e, (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19446a;

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
            this.f19446a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f19446a.E1 = null;
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19448f;

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
            this.f19448f = s0Var;
            this.f19447e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19448f.y1 || this.f19447e == null || this.f19448f.f19401c.getPbModel() == null || !this.f19448f.f19401c.getPbModel().s1()) {
                return;
            }
            this.f19448f.y1 = true;
            this.f19447e.checkEasterEgg(false);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19451g;

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
            this.f19451g = s0Var;
            this.f19449e = alertDialog;
            this.f19450f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19449e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f19451g.f19401c.getPbActivity(), b.a.r0.k2.l.neterror);
                } else {
                    this.f19451g.f19401c.deleteThread(this.f19450f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19452a;

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
            this.f19452a = s0Var;
        }

        @Override // b.a.r0.k2.s.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19452a.f19401c.hideKeyBroad();
            }
        }

        @Override // b.a.r0.k2.s.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19452a.l == null) {
                return;
            }
            if (this.f19452a.p != null) {
                this.f19452a.p.t();
            }
            this.f19452a.l.setSelection(0);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19453e;

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
            this.f19453e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19453e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19454e;

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
            this.f19454e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new b.a.q0.s.q.t0(this.f19454e.f19401c.getActivity(), "pb_huitie"))) {
                this.f19454e.f19401c.processProfessionPermission();
                if (this.f19454e.f19401c == null || this.f19454e.f19401c.getPbModel() == null || this.f19454e.f19401c.getPbModel().P0() == null || this.f19454e.f19401c.getPbModel().P0().O() == null || this.f19454e.f19401c.getPbModel().P0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19454e.f19401c.getPbModel().g1()).param("fid", this.f19454e.f19401c.getPbModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19454e.f19401c.getPbModel().f52415f).param("fid", this.f19454e.f19401c.getPbModel().P0().m()).param("obj_locate", 1).param("uid", this.f19454e.f19401c.getPbModel().P0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19457g;

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
            this.f19457g = s0Var;
            this.f19455e = alertDialog;
            this.f19456f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19455e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f19457g.f19401c.getPbActivity(), b.a.r0.k2.l.neterror);
                } else {
                    this.f19457g.f19401c.deleteThread(this.f19456f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19458e;

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
            this.f19458e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(b.a.r0.k2.i.tag_from, 1);
                    this.f19458e.f19401c.checkMuteState(sparseArray);
                    return;
                }
                this.f19458e.b2(view);
            } else if (booleanValue2) {
                sparseArray.put(b.a.r0.k2.i.tag_from, 0);
                sparseArray.put(b.a.r0.k2.i.tag_check_mute_from, 1);
                this.f19458e.f19401c.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f19458e.W1(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19459e;

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
            this.f19459e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19459e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19460a;

        /* renamed from: b  reason: collision with root package name */
        public int f19461b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f19462c;

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

    /* loaded from: classes5.dex */
    public class q implements g.InterfaceC0930g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f19463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f19464b;

        public q(s0 s0Var, b.a.q0.s.s.a aVar) {
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
            this.f19464b = s0Var;
            this.f19463a = aVar;
        }

        @Override // b.a.r0.j.g.InterfaceC0930g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19464b.f19401c.deleteThread(this.f19463a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19465a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f19466b;

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
            this.f19466b = s0Var;
            this.f19465a = sparseArray;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19466b.f19401c.deleteThread(this.f19465a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19467e;

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
            this.f19467e = s0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f19467e.Y = (String) compoundButton.getTag();
                if (this.f19467e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f19467e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f19467e.Y != null && !str.equals(this.f19467e.Y)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.r0.l3.i0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19468e;

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
            this.f19468e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19468e.S instanceof Dialog)) {
                b.a.e.e.m.g.b(this.f19468e.S, this.f19468e.f19401c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19470f;

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
            this.f19470f = s0Var;
            this.f19469e = cVar;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19470f.a0.dismiss();
                this.f19469e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19472f;

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
            this.f19472f = s0Var;
            this.f19471e = cVar;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19472f.a0.dismiss();
                this.f19471e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19473e;

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
            this.f19473e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f19473e.C0 == null || this.f19473e.C0.O() == null || this.f19473e.C0.O().J() == null || this.f19473e.C0.O().J().getAlaInfo() == null || this.f19473e.C0.O().J().getAlaInfo().live_status != 1) {
                    if (this.f19473e.c1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f19473e.c1 && this.f19473e.C0 != null && this.f19473e.C0.O() != null && this.f19473e.C0.O().J() != null && this.f19473e.C0.O().J().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f19473e.f19401c.getPbActivity() != null) {
                        this.f19473e.f19401c.getPbActivity().mEvent.f19142b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f19473e.C0.m());
                statisticItem2.param("fname", this.f19473e.C0.n());
                statisticItem2.param("obj_param1", this.f19473e.C0.O().J().getAlaInfo().user_info != null ? this.f19473e.C0.O().J().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f19473e.C0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f19473e.C0.O().J().getAlaInfo()));
                if (this.f19473e.C0.O().J().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f19473e.C0.O().J().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f19473e.C0.O().J().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f19473e.f19401c.getPageContext(), this.f19473e.C0.O().J().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19474a;

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
            this.f19474a = s0Var;
        }

        @Override // b.a.r0.k2.u.f.a1.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f19474a.v.a(this.f19474a.l);
                } else {
                    this.f19474a.v.d(this.f19474a.l);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19475e;

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
            this.f19475e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            s0 s0Var;
            b.a.r0.k2.u.f.g1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19475e.A == null || (cVar = (s0Var = this.f19475e).f19406h) == null || cVar.f19290i == null || s0Var.C0 == null || this.f19475e.C0.O() == null || this.f19475e.C0.O().E2() || this.f19475e.E1() || this.f19475e.C0.l() == null || b.a.e.e.p.k.isEmpty(this.f19475e.C0.l().getName())) {
                return;
            }
            if ((this.f19475e.A.H() == null || !this.f19475e.A.H().isShown()) && (linearLayout = this.f19475e.f19406h.f19290i) != null) {
                linearLayout.setVisibility(0);
                if (this.f19475e.f19401c == null || this.f19475e.f19401c.getPbModel() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f19475e.f19401c.getPbModel().f1());
                statisticItem.param("fid", this.f19475e.f19401c.getPbModel().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-853125475, "Lb/a/r0/k2/u/f/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-853125475, "Lb/a/r0/k2/u/f/s0;");
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
        b2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds80);
        c2 = new t();
    }

    public s0(PbFragment pbFragment, View.OnClickListener onClickListener, b.a.r0.k2.s.c cVar) {
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
        this.f19401c = null;
        this.f19402d = null;
        this.f19403e = null;
        this.f19404f = 0;
        this.f19405g = new Handler();
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
        this.u1 = System.currentTimeMillis();
        this.f19401c = pbFragment;
        this.L = onClickListener;
        this.g0 = cVar;
        this.f1 = b.a.e.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19401c.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_pb_activity, (ViewGroup) null);
        this.f19402d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.k0 = this.f19402d.findViewById(b.a.r0.k2.i.bottom_shadow);
        this.p1 = (NavigationBarCoverTip) this.f19402d.findViewById(b.a.r0.k2.i.pb_multi_forum_del_tip_view);
        this.f19403e = this.f19402d.findViewById(b.a.r0.k2.i.statebar_view);
        this.C1 = (RightFloatLayerView) this.f19402d.findViewById(b.a.r0.k2.i.right_layer_view);
        this.z = (ObservedChangeRelativeLayout) this.f19402d.findViewById(b.a.r0.k2.i.title_wrapper);
        this.m = (NoNetworkView) this.f19402d.findViewById(b.a.r0.k2.i.view_no_network);
        this.l = (PbLandscapeListView) this.f19402d.findViewById(b.a.r0.k2.i.new_pb_list);
        this.J0 = (FrameLayout) this.f19402d.findViewById(b.a.r0.k2.i.root_float_header);
        this.K0 = new TextView(this.f19401c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + b.a.e.e.p.l.g(this.f19401c.getActivity(), b.a.r0.k2.g.ds88));
        this.l.addHeaderView(this.K0, 0);
        this.l.setTextViewAdded(true);
        this.V0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(b.a.r0.k2.g.tbds134);
        this.P0 = new View(this.f19401c.getPageContext().getPageActivity());
        if (b.a.q0.g1.b.c.d()) {
            this.P0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.P0.setLayoutParams(new AbsListView.LayoutParams(-1, this.V0));
        }
        this.P0.setVisibility(4);
        this.l.addFooterView(this.P0);
        this.l.setOnTouchListener(this.f19401c.mOnTouchListener);
        this.f19399a = new l0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f19399a);
        this.f19406h = new b.a.r0.k2.u.f.g1.c(pbFragment, this.f19402d);
        if (this.f19401c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19402d.findViewById(b.a.r0.k2.i.manga_view_stub);
            this.j = viewStub;
            viewStub.setVisibility(0);
            b.a.r0.k2.u.f.g1.b bVar = new b.a.r0.k2.u.f.g1.b(pbFragment);
            this.f19407i = bVar;
            bVar.c();
            this.f19406h.f19282a.setVisibility(8);
            layoutParams.height = b.a.e.e.p.l.g(this.f19401c.getActivity(), b.a.r0.k2.g.ds120);
        }
        this.K0.setLayoutParams(layoutParams);
        this.f19406h.p().setOnTouchListener(new b.a.r0.k2.s.a(new m0(this)));
        this.n0 = this.f19402d.findViewById(b.a.r0.k2.i.view_comment_top_line);
        this.o0 = this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_comment);
        b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds120);
        this.z0 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds242);
        HeadImageView headImageView = (HeadImageView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_user_image);
        this.q0 = headImageView;
        headImageView.setVisibility(0);
        this.q0.setIsRound(true);
        this.q0.setBorderWidth(b.a.e.e.p.l.g(this.f19401c.getContext(), b.a.r0.k2.g.L_X01));
        this.q0.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
        this.q0.setPlaceHolder(0);
        J1();
        this.r0 = (TextView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f19402d.findViewById(b.a.r0.k2.i.pb_editer_tool_comment_layout);
        this.p0 = linearLayout;
        linearLayout.setOnClickListener(new n0(this));
        this.s0 = (ImageView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_icon);
        this.A1 = (MaskView) this.f19402d.findViewById(b.a.r0.k2.i.mask_view);
        this.s0.setOnClickListener(this.L);
        boolean booleanExtra = this.f19401c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_collection);
        this.t0 = imageView;
        imageView.setOnClickListener(this.L);
        if (booleanExtra) {
            this.t0.setVisibility(8);
        } else {
            this.t0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_share);
        this.u0 = imageView2;
        imageView2.setOnClickListener(this.L);
        this.v0 = new b.a.r0.k2.z.i(this.u0);
        if (!b.a.q0.b.d.S() && !b.a.q0.b.d.T()) {
            this.v0.e();
        }
        TextView textView = (TextView) this.f19402d.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_red_dot);
        this.w0 = textView;
        textView.setVisibility(0);
        this.H0 = (ViewStub) this.f19402d.findViewById(b.a.r0.k2.i.interview_status_stub);
        this.q = new b.a.r0.k2.u.f.a1.d(this.f19401c, cVar);
        this.s = new b.a.r0.k2.u.f.a1.h(this.f19401c, cVar, this.L);
        b.a.r0.k2.u.f.h hVar = new b.a.r0.k2.u.f.h(this.f19401c, this.l);
        this.A = hVar;
        hVar.q0(this.L);
        this.A.s0(this.g0);
        this.A.n0(this.M);
        this.A.p0(this.f19401c.onSwitchChangeListener);
        o0 o0Var = new o0(this);
        this.P = o0Var;
        this.A.m0(o0Var);
        s1();
        m1();
        b.a.r0.k2.u.f.a1.g gVar = new b.a.r0.k2.u.f.a1.g(this.f19401c);
        this.u = gVar;
        gVar.f19023f = 2;
        l1();
        this.v.a(this.l);
        this.r.a(this.l);
        this.s.h(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f19401c.getPageContext().getPageActivity());
        this.G = pbListView;
        this.I = pbListView.b().findViewById(b.a.r0.k2.i.pb_more_view);
        this.J = this.G.b().findViewById(b.a.r0.k2.i.pb_check_more);
        if (!this.G.i().booleanValue()) {
            this.J.setVisibility(8);
        }
        View view = this.I;
        if (view != null) {
            view.setOnClickListener(this.L);
            SkinManager.setBackgroundResource(this.I, b.a.r0.k2.h.pb_foot_more_trans_selector);
        }
        View view2 = this.J;
        if (view2 != null) {
            view2.setOnClickListener(this.L);
        }
        this.G.z();
        this.G.o(b.a.r0.k2.h.pb_foot_more_trans_selector);
        this.G.p(b.a.r0.k2.h.pb_foot_more_trans_selector);
        this.K = this.f19402d.findViewById(b.a.r0.k2.i.viewstub_progress);
        this.f19401c.registerListener(this.J1);
        this.X0 = new PbFakeFloorModel(this.f19401c.getPageContext());
        PbModel pbModel = this.f19401c.getPbModel();
        this.X0.P(pbModel.F(), pbModel.B(), pbModel.C(), pbModel.A(), pbModel.G());
        b.a.r0.k2.u.f.t tVar = new b.a.r0.k2.u.f.t(this.f19401c.getPageContext(), this.X0, this.f19402d);
        this.Y0 = tVar;
        tVar.k(new b(this));
        this.Y0.m(this.f19401c.mOnFloorPostWriteNewCallback);
        this.X0.R(new c(this));
        if (this.f19401c.getPbModel() != null && !StringUtils.isNull(this.f19401c.getPbModel().S0())) {
            PbFragment pbFragment2 = this.f19401c;
            pbFragment2.showToast(pbFragment2.getPbModel().S0());
        }
        this.L0 = this.f19402d.findViewById(b.a.r0.k2.i.pb_expand_blank_view);
        this.M0 = this.f19402d.findViewById(b.a.r0.k2.i.bottom_rec_float_title);
        View findViewById = this.f19402d.findViewById(b.a.r0.k2.i.sticky_view);
        this.N0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.f19401c.getPbModel() != null && this.f19401c.getPbModel().C0()) {
            this.L0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.N0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = U1;
            this.N0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f19401c.getPageContext(), this.f19402d.findViewById(b.a.r0.k2.i.pb_reply_expand_view));
        this.O0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
        this.O0.mDivideLineTop.setVisibility(8);
        this.O0.setPbCommonOnclickListener(this.L);
        this.O0.setOnSwitchChangeListener(this.f19401c.onSwitchChangeListener);
        this.f19401c.registerListener(this.G1);
        this.f19401c.registerListener(this.F1);
        PbFragment pbFragment3 = this.f19401c;
        this.z1 = new b.a.r0.k2.z.h(pbFragment3, pbFragment3.getUniqueId());
        FallingView fallingView = (FallingView) this.f19402d.findViewById(b.a.r0.k2.i.falling_view);
        this.B1 = fallingView;
        fallingView.setAnimationListener(new d(this));
        X();
        n2(false);
        this.l0 = this.f19402d.findViewById(b.a.r0.k2.i.pb_comment_container);
        W(b.a.q0.g1.b.c.d());
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.k2.z.i iVar = this.v0;
            if (iVar != null) {
                return iVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void A2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.A.f0(z2);
        }
    }

    public void A3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f19401c.showToast(str);
        }
    }

    public PbInterviewStatusView B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.I0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.O1) : invokeV.booleanValue;
    }

    public void B2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.A.k0(z2);
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f19401c.showProgressBar();
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n1 : invokeV.booleanValue;
    }

    public final boolean C1(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, d2Var)) == null) {
            if (d2Var == null || d2Var.J() == null) {
                return false;
            }
            PostData v0 = v0(this.C0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (v0 == null || v0.t() == null) ? "" : v0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void C2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.P1 = gVar;
            b.a.r0.k2.z.j jVar = this.F;
            if (jVar != null) {
                jVar.a(gVar);
            }
        }
    }

    public void C3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (fallingView = this.B1) == null) {
            return;
        }
        fallingView.stopAllViews();
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.p != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return w0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public void D2(String str) {
        b.a.r0.k2.u.f.g1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (bVar = this.f19407i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.Q1 == null) {
            return;
        }
        while (this.Q1.size() > 0) {
            TbImageView remove = this.Q1.remove(0);
            if (remove != null) {
                remove.stopLoading();
            }
        }
    }

    public BdTypeListView E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            b.a.r0.k2.r.f fVar = this.C0;
            return fVar == null || fVar.l() == null || "0".equals(this.C0.l().getId()) || "me0407".equals(this.C0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.a1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.b1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void E3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            this.c0 = z2;
        }
    }

    public SparseArray<Object> F0(b.a.r0.k2.r.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData v0;
        b.a.q0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (v0 = v0(fVar, z2)) == null) {
                return null;
            }
            String userId = v0.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(b.a.r0.k2.i.tag_del_post_id, v0.G());
                sparseArray.put(b.a.r0.k2.i.tag_del_post_type, 0);
                sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (v0.t() != null) {
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name, v0.t().getUserName());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name_show, v0.t().getName_show());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_portrait, v0.t().getPortrait());
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, v0.G());
                }
                sparseArray.put(b.a.r0.k2.i.tag_del_post_id, v0.G());
                sparseArray.put(b.a.r0.k2.i.tag_del_post_type, 0);
                sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(fVar.V()));
                sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<z1> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (z1 z1Var : p2) {
                        if (z1Var != null && !StringUtils.isNull(z1Var.getForumName()) && (e0Var = z1Var.f13511g) != null && e0Var.f13285a && !e0Var.f13287c && ((i3 = e0Var.f13286b) == 1 || i3 == 2)) {
                            sb.append(b.a.e.e.p.k.cutString(z1Var.getForumName(), 12));
                            sb.append(this.f19401c.getString(b.a.r0.k2.l.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(b.a.r0.k2.i.tag_del_multi_forum, String.format(this.f19401c.getString(b.a.r0.k2.l.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void F2(PbFragment.c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, c3Var) == null) {
        }
    }

    public void F3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.f19406h.H(z2);
            if (z2 && this.G0) {
                this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.click_load_more));
                this.l.setNextPage(this.G);
                this.f19404f = 2;
            }
            J1();
        }
    }

    public b.a.r0.k2.u.e.a G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l1 : (b.a.r0.k2.u.e.a) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.D1 : invokeV.booleanValue;
    }

    public void G2(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, zVar) == null) {
            this.M = zVar;
            this.A.n0(zVar);
            this.l1.q(this.M);
        }
    }

    public void G3(b.a.r0.k2.r.d dVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f19406h.I();
        if (!StringUtils.isNull(dVar.f18752b)) {
            this.f19406h.F(dVar.f18752b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.thread_delete_by);
        int e2 = b.a.e.e.m.b.e(dVar.f18751a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.self);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.bawu);
        }
        this.f19401c.showNetRefreshView(this.f19402d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.appeal_restore), true, new a0(this, dVar.f18753c));
    }

    public View H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.J : (View) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b.a.r0.k2.z.i iVar = this.v0;
            if (iVar == null) {
                return false;
            }
            return iVar.h();
        }
        return invokeV.booleanValue;
    }

    public void H2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bVar) == null) {
            this.N = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void H3(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                b.a.r0.k2.z.i iVar = this.v0;
                if (iVar != null) {
                    iVar.k(false);
                    this.v0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.u0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.u0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.u0, b.a.r0.k2.h.icon_pure_pb_bottom_share26, b.a.r0.k2.f.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            b.a.r0.k2.z.i iVar2 = this.v0;
            if (iVar2 == null || !iVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.u0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.u0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.u0, b.a.r0.k2.h.icon_pure_pb_bottom_share26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final int I0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.I0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            EditorTools editorTools = this.i0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void I2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public boolean I3(b.a.r0.k2.r.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048611, this, fVar, z2)) == null) {
            if (fVar == null) {
                return false;
            }
            if (this.r != null) {
                if (fVar.O() != null && fVar.O().n0() == 0 && !fVar.O().E2() && !this.D1) {
                    if (fVar.O() != null) {
                        d2 O = fVar.O();
                        O.Z2(true, f3(fVar));
                        O.o4(3);
                        O.j4("2");
                    }
                    if (fVar.O().M1()) {
                        this.s.t(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.h(this.l);
                        this.s.x(this.C0);
                        if (w1(fVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(fVar);
                        }
                    } else {
                        this.s.x(this.C0);
                        if (w1(fVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.g(fVar);
                        }
                    }
                } else if (fVar.O().n0() == 1) {
                    if (fVar.O() != null) {
                        this.r.d(this.l);
                        this.s.x(this.C0);
                    }
                } else {
                    this.r.d(this.l);
                    this.s.x(this.C0);
                }
            }
            y3(fVar);
            this.B0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public View J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.q0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.q0.setImageResource(0);
                this.q0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.q0.setImageResource(b.a.r0.k2.h.transparent_bg);
        }
    }

    public void J2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public final void J3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.f19401c.getIsMangaThread()) {
            if (this.f19401c.getMangaPrevChapterId() == -1) {
                SkinManager.setViewTextColor(this.x, b.a.r0.k2.f.CAM_X0110, 1);
            }
            if (this.f19401c.getMangaNextChapterId() == -1) {
                SkinManager.setViewTextColor(this.y, b.a.r0.k2.f.CAM_X0110, 1);
            }
        }
    }

    public PbListView K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public void K1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || this.F0 == i2) {
            return;
        }
        this.F0 = i2;
        z3(this.C0, this.B0);
        i2(this.C0, this.B0, this.E0, i2);
        this.f19401c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f19401c.getBaseFragmentActivity().getLayoutMode().j(this.f19402d);
        SkinManager.setBackgroundColor(this.f19402d, b.a.r0.k2.f.CAM_X0201);
        SkinManager.setBackgroundColor(this.k0, b.a.r0.k2.f.CAM_X0203);
        b.a.r0.k2.u.f.a1.i iVar = this.p;
        if (iVar != null) {
            iVar.h(i2);
        }
        b.a.r0.k2.u.f.a1.e eVar = this.t;
        if (eVar != null) {
            eVar.c(i2);
        }
        b.a.r0.k2.u.f.a1.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
        b.a.r0.k2.u.f.a1.f fVar = this.r;
        if (fVar != null) {
            fVar.c(i2);
        }
        b.a.r0.k2.u.f.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.q(i2);
        }
        b.a.r0.k2.u.f.a1.g gVar = this.u;
        if (gVar != null) {
            gVar.d();
        }
        b.a.r0.k2.u.f.a1.c cVar = this.v;
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
            this.f19401c.getBaseFragmentActivity().getLayoutMode().j(this.I);
            SkinManager.setBackgroundResource(this.I, b.a.r0.k2.h.pb_foot_more_trans_selector);
        }
        if (this.J != null) {
            this.f19401c.getBaseFragmentActivity().getLayoutMode().j(this.J);
            SkinManager.setBackgroundResource(this.J, b.a.r0.k2.h.pb_foot_more_trans_selector);
        }
        b.a.q0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f19401c.getPageContext());
        }
        E3(this.c0);
        this.A.X();
        b.a.r0.k2.z.j jVar = this.F;
        if (jVar != null) {
            jVar.C(i2);
        }
        EditorTools editorTools = this.i0;
        if (editorTools != null) {
            editorTools.onChangeSkinType(i2);
        }
        b.a.r0.k2.z.f fVar2 = this.H;
        if (fVar2 != null) {
            fVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.onChangeSkinMode();
            }
        }
        J3();
        UtilHelper.setStatusBarBackground(this.f19403e, i2);
        UtilHelper.setStatusBarBackground(this.N0, i2);
        if (this.w != null) {
            b.a.q0.w0.a.a(this.f19401c.getPageContext(), this.w);
        }
        b.a.r0.k2.u.f.t tVar = this.Y0;
        if (tVar != null) {
            tVar.h(i2);
        }
        b.a.r0.k2.u.f.g1.c cVar2 = this.f19406h;
        if (cVar2 != null) {
            b.a.r0.k2.u.f.a1.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.i(i2);
            } else {
                cVar2.u(i2);
            }
        }
        HeadImageView headImageView = this.q0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
        }
        LinearLayout linearLayout = this.p0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f19401c.getContext(), b.a.r0.k2.g.tbds47), SkinManager.getColor(b.a.r0.k2.f.CAM_X0209)));
        }
        b.a.r0.k2.r.f fVar3 = this.C0;
        if (fVar3 != null && fVar3.r()) {
            WebPManager.setPureDrawable(this.t0, b.a.r0.k2.h.icon_pure_pb_bottom_collected26_selection, b.a.r0.k2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.t0, b.a.r0.k2.h.icon_pure_pb_bottom_collect26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.s0, b.a.r0.k2.h.icon_pure_pb_bottom_comment26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        H3(this.C0);
        SkinManager.setBackgroundColor(this.o0, b.a.r0.k2.f.CAM_X0207);
        SkinManager.setBackgroundColor(this.n0, b.a.r0.k2.f.CAM_X0203);
        SkinManager.setViewTextColor(this.i1, b.a.r0.k2.f.cp_cont_n);
        SkinManager.setViewTextColor(this.r0, b.a.r0.k2.f.CAM_X0109);
        SkinManager.setViewTextColor(this.x0, b.a.r0.k2.f.CAM_X0105);
        SkinManager.setViewTextColor(this.w0, b.a.r0.k2.f.CAM_X0107);
        TextView textView = this.w0;
        int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds18);
        int i3 = b.a.r0.k2.f.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        b.a.r0.k2.u.e.a aVar2 = this.l1;
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
        b.a.r0.k2.z.i iVar3 = this.v0;
        if (iVar3 != null) {
            iVar3.i();
        }
        b.a.r0.k2.z.h hVar2 = this.z1;
        if (hVar2 != null) {
            hVar2.c();
        }
        RightFloatLayerView rightFloatLayerView = this.C1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.M0, b.a.r0.k2.f.CAM_X0207);
        SkinManager.setViewTextColor(this.M0.findViewById(b.a.r0.k2.i.tv_title), b.a.r0.k2.f.CAM_X0105);
    }

    public void K2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onClickListener) == null) {
            this.A.r0(onClickListener);
        }
    }

    public void K3(b.a.r0.k2.r.f fVar) {
        b.a.r0.k2.u.f.a1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, fVar) == null) || (dVar = this.q) == null) {
            return;
        }
        dVar.h(fVar, this.B0);
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            try {
                return Integer.parseInt(this.E.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void L1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, configuration) == null) || configuration == null) {
            return;
        }
        c0();
        if (configuration.orientation == 2) {
            c1();
            e1();
        } else {
            o2();
        }
        b.a.r0.k2.u.f.t tVar = this.Y0;
        if (tVar != null) {
            tVar.c();
        }
        this.f19401c.hideKeyBroad();
        this.z.setVisibility(8);
        this.f19406h.B(false);
        this.f19401c.setNavigationBarShowFlag(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                Y0().setVisibility(0);
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
            this.J0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void L2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.w1 = i2;
        }
    }

    public View M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.L0 : (View) invokeV.objValue;
    }

    public void M1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            RelativeLayout relativeLayout = this.f19402d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f19402d.getHandler().removeCallbacksAndMessages(null);
            }
            b.a.r0.k2.z.i iVar = this.v0;
            if (iVar != null) {
                iVar.j();
            }
            b.a.r0.k2.u.f.n0 n0Var = this.Z0;
            if (n0Var != null) {
                n0Var.a();
            }
            b.a.r0.k2.u.f.f0 f0Var = this.o1;
            if (f0Var != null) {
                f0Var.c();
            }
            PbTopTipView pbTopTipView = this.g1;
            if (pbTopTipView != null) {
                pbTopTipView.hide();
            }
            this.f19401c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.N) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            c0();
            i0();
            if (this.W0 != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.W0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.I0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.clearStatus();
            }
            this.H1 = null;
            this.f19405g.removeCallbacksAndMessages(null);
            this.A.Y(3);
            View view = this.f19403e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            b.a.r0.k2.u.f.a1.i iVar2 = this.p;
            if (iVar2 != null) {
                iVar2.a();
            }
            b.a.r0.k2.u.f.h hVar = this.A;
            if (hVar != null) {
                hVar.Z();
            }
            this.l.setOnLayoutListener(null);
            b.a.r0.k2.u.f.b1.c cVar = this.k1;
            if (cVar != null) {
                cVar.h();
            }
            PbEmotionBar pbEmotionBar = this.T0;
            if (pbEmotionBar != null) {
                pbEmotionBar.onDestroy();
            }
            b.a.r0.k2.u.f.a1.h hVar2 = this.s;
            if (hVar2 != null) {
                hVar2.r();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f19399a);
            }
        }
    }

    public void M2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onLongClickListener) == null) {
            this.s.u(onLongClickListener);
            this.A.o0(onLongClickListener);
            b.a.r0.k2.u.e.a aVar = this.l1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public PbFakeFloorModel N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.X0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void N1(TbRichText tbRichText) {
        b.a.r0.k2.r.f fVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, tbRichText) == null) || (fVar = this.C0) == null || fVar.F() == null || this.C0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.C0.F().size() && (postData = this.C0.F().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.C0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                b.a.r0.k2.u.e.a aVar = this.l1;
                if (aVar != null && aVar.l()) {
                    c3(false);
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

    public final void N2(PostData postData, b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, postData, fVar) == null) {
            this.s.v(postData, fVar);
        }
    }

    public b.a.r0.k2.u.f.t O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.Y0 : (b.a.r0.k2.u.f.t) invokeV.objValue;
    }

    public boolean O1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void O2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048631, this, z2, postWriteCallBackData) == null) {
            this.f19401c.hideProgressBar();
            if (z2) {
                c0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                d0();
            } else {
                c0();
            }
        }
    }

    public b.a.r0.k2.u.f.a1.i P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.p : (b.a.r0.k2.u.f.a1.i) invokeV.objValue;
    }

    public void P1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || this.f19401c == null) {
            return;
        }
        if ((this.v1 || this.w1 == 17) && b.a.q0.b.d.i0()) {
            b.a.r0.k2.r.f fVar = this.C0;
            if (fVar == null || fVar.l() == null || b.a.e.e.p.k.isEmpty(this.C0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19401c.getContext()).createNormalCfg(this.C0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.C0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.C0.l().getId()));
        } else if (!this.d1 || this.c1 || (postData = this.D0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f19401c.isSimpleForum() ? 2 : 1).param("obj_type", this.c1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19401c.getPageContext().getPageActivity(), this.D0.t().getUserId(), this.D0.t().getUserName(), this.f19401c.getPbModel().q0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f19401c.hideProgressBar();
            b.a.r0.k2.r.f fVar = this.C0;
            if (fVar != null && this.G != null && fVar.y() != null && this.C0.y().b() == 0) {
                this.G.u(this.C0.t());
                if (this.C0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.C0.m());
                    statisticItem.param("fname", this.C0.n());
                    statisticItem.param("tid", this.C0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            i0();
            this.l.completePullRefreshPostDelayed(0L);
            f0();
        }
    }

    public final boolean Q(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048635, this, absListView, i2)) == null) {
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

    public final PostData Q0(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().J() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData J = fVar.O().J();
            String userId = J.getUserId();
            HashMap<String, MetaData> A1 = fVar.O().A1();
            if (A1 != null && (metaData = A1.get(userId)) != null && metaData.getUserId() != null) {
                J = metaData;
            }
            postData.m0(1);
            postData.q0(fVar.O().W());
            postData.C0(fVar.O().getTitle());
            postData.B0(fVar.O().P());
            postData.k0(J);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void Q1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) {
            if (z2) {
                i3();
            } else {
                f1();
            }
            this.S0.f19462c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
            d2(this.S0.f19462c, false);
        }
    }

    public void Q2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (pbFragment = this.f19401c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        b.a.e.e.p.l.x(this.f19401c.getPageContext().getPageActivity(), this.f19401c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void R() {
        b.a.r0.k2.z.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (iVar = this.v0) == null) {
            return;
        }
        iVar.l(false);
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (!b.a.e.e.p.k.isEmpty(this.s1)) {
                return this.s1;
            }
            if (this.f19401c != null) {
                this.s1 = TbadkCoreApplication.getInst().getResources().getString(q0.b());
            }
            return this.s1;
        }
        return (String) invokeV.objValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            D3();
            this.A.Y(1);
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.G.z();
            this.G.Q();
        }
    }

    public boolean S(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z2)) == null) {
            EditorTools editorTools = this.i0;
            if (editorTools == null || !editorTools.isToolVisible()) {
                return false;
            }
            this.i0.hideTools();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final int S0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, pbReplyTitleViewHolder)) == null) {
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

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.A.Y(2);
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f19401c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19401c.getFragmentActivity())) {
                    return;
                }
                a1().setSystemUiVisibility(4);
            }
        }
    }

    public void S2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            this.s.w(z2);
        }
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            PbListView pbListView = this.G;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.G.h().equals(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? b.a.r0.k2.i.richText : invokeV.intValue;
    }

    public void T1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        b.a.r0.k2.u.f.a1.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048649, this, absListView, i2, i3, i4) == null) {
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            b.a.r0.k2.u.f.g1.c cVar = this.f19406h;
            if (cVar != null && (hVar = this.s) != null) {
                cVar.w(hVar.m());
            }
            p0 p0Var = this.S0;
            p0Var.f19460a = i2;
            p0Var.f19461b = this.l.getHeaderViewsCount();
            this.S0.f19462c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
            b3(Q(absListView, i2));
            int i5 = 0;
            d2(this.S0.f19462c, false);
            b0();
            if (!this.G.n() || this.G.F) {
                return;
            }
            p0 p0Var2 = this.S0;
            if (p0Var2 != null && (pbReplyTitleViewHolder = p0Var2.f19462c) != null && pbReplyTitleViewHolder.getView() != null) {
                i5 = this.S0.f19462c.getView().getTop() < 0 ? this.S0.f19462c.getView().getHeight() : this.S0.f19462c.getView().getBottom();
            }
            this.G.e(i5);
            this.G.F = true;
        }
    }

    public void T2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.r0.performClick();
            if (StringUtils.isNull(str) || this.f19401c.getPbEditor() == null || this.f19401c.getPbEditor().v() == null || this.f19401c.getPbEditor().v().h() == null) {
                return;
            }
            EditText h2 = this.f19401c.getPbEditor().v().h();
            h2.setText(str);
            h2.setSelection(str.length());
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || this.C0 == null || !b.a.q0.b.d.S() || b.a.r0.k2.u.f.f1.b.k(this.C0.Q())) {
            return;
        }
        this.v0.e();
        b.a.r0.k2.u.f.f1.b.b(this.C0.Q());
    }

    public final int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void U1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048653, this, absListView, i2) == null) {
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.T1 && i2 == 0) {
                this.R1 = U0();
                this.S0.f19462c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
                d2(this.S0.f19462c, true);
                b0();
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

    public void U2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            if (!this.f19401c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.f0));
            } else if (this.f19401c.checkPrivacyBeforeInput()) {
                b.a.q0.x.x.e pbEditor = this.f19401c.getPbEditor();
                if (pbEditor != null && (pbEditor.C() || pbEditor.E())) {
                    this.f19401c.getPbEditor().A(false, null);
                    return;
                }
                if (this.i0 != null) {
                    p1();
                }
                EditorTools editorTools = this.i0;
                if (editorTools != null) {
                    this.y0 = false;
                    if (editorTools.findToolById(2) != null) {
                        b.a.r0.l3.i0.a.c(this.f19401c.getPageContext(), (View) this.i0.findToolById(2).k, false, c2);
                    }
                }
                c1();
            }
        }
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.F0 : invokeV.intValue;
    }

    public void V1(ArrayList<b.a.q0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, arrayList) == null) {
            if (this.T == null) {
                this.T = LayoutInflater.from(this.f19401c.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.commit_good, (ViewGroup) null);
            }
            this.f19401c.getBaseFragmentActivity().getLayoutMode().j(this.T);
            if (this.S == null) {
                Dialog dialog = new Dialog(this.f19401c.getPageContext().getPageActivity(), b.a.r0.k2.m.common_alert_dialog);
                this.S = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.S.setCancelable(true);
                this.h0 = (ScrollView) this.T.findViewById(b.a.r0.k2.i.good_scroll);
                this.S.setContentView(this.T);
                WindowManager.LayoutParams attributes = this.S.getWindow().getAttributes();
                attributes.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds540);
                this.S.getWindow().setAttributes(attributes);
                this.V = new s(this);
                this.U = (LinearLayout) this.T.findViewById(b.a.r0.k2.i.good_class_group);
                TextView textView = (TextView) this.T.findViewById(b.a.r0.k2.i.dialog_button_cancel);
                this.X = textView;
                textView.setOnClickListener(new u(this));
                TextView textView2 = (TextView) this.T.findViewById(b.a.r0.k2.i.dialog_button_ok);
                this.W = textView2;
                textView2.setOnClickListener(this.L);
            }
            this.U.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton Y = Y("0", this.f19401c.getPageContext().getString(b.a.r0.k2.l.thread_good_class));
            this.n.add(Y);
            Y.setChecked(true);
            this.U.addView(Y);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    b.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton Y2 = Y(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(Y2);
                        View view = new View(this.f19401c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds1));
                        SkinManager.setBackgroundColor(view, b.a.r0.k2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.U.addView(view);
                        this.U.addView(Y2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.h0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19401c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19401c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19401c.getPageContext().getPageActivity(), 186.0f);
                }
                this.h0.setLayoutParams(layoutParams2);
                this.h0.removeAllViews();
                LinearLayout linearLayout = this.U;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.h0.addView(this.U);
                }
            }
            b.a.e.e.m.g.j(this.S, this.f19401c.getPageContext());
        }
    }

    public void V2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, list) == null) {
            this.j1 = list;
            b.a.r0.k2.u.f.b1.c cVar = this.k1;
            if (cVar != null) {
                cVar.m(list);
            }
        }
    }

    public void W(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, b.a.r0.k2.f.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view = this.l0;
            if (view != null) {
                view.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.K(z2 ? 8 : 0);
            }
            View view2 = this.I;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f19403e : (View) invokeV.objValue;
    }

    public void W1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            X1(i2, str, i3, z2, null);
        }
    }

    public final boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            PbFragment pbFragment = this.f19401c;
            return (pbFragment == null || pbFragment.getPbModel().P0().l().getDeletedReasonInfo() == null || 1 != this.f19401c.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            b.a.r0.k2.u.e.a aVar = new b.a.r0.k2.u.e.a(this.f19401c, this, (ViewStub) this.f19402d.findViewById(b.a.r0.k2.i.more_god_reply_popup));
            this.l1 = aVar;
            aVar.o(this.L);
            this.l1.p(this.P);
            this.l1.q(this.M);
            this.l1.o(this.L);
            this.l1.s(this.g0);
        }
    }

    public PbThreadPostView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void X1(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            Y1(i2, str, i3, z2, str2, false);
        }
    }

    public void X2() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.J0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            b.a.r0.k2.u.f.g1.c cVar = this.f19406h;
            if (cVar == null || (view = cVar.f19285d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public final CustomBlueCheckRadioButton Y(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048667, this, str, str2)) == null) {
            Activity pageActivity = this.f19401c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, b.a.e.e.p.l.g(pageActivity, b.a.r0.k2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.V);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public RelativeLayout Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.z : (RelativeLayout) invokeV.objValue;
    }

    public void Y1(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(W1, Integer.valueOf(X1));
            int i4 = b.a.r0.k2.l.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = b.a.r0.k2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = b.a.r0.k2.l.report_thread_confirm;
                } else {
                    i4 = b.a.r0.k2.l.del_thread_confirm;
                }
            }
            this.Q = new b.a.q0.s.s.a(this.f19401c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Q.setMessageId(i4);
            } else {
                this.Q.setOnlyMessageShowCenter(false);
                this.Q.setMessage(str2);
            }
            this.Q.setYesButtonTag(sparseArray);
            this.Q.setPositiveButton(b.a.r0.k2.l.dialog_ok, this.f19401c);
            this.Q.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new l(this));
            this.Q.setCancelable(true);
            this.Q.create(this.f19401c.getPageContext());
            if (z3) {
                e3(sparseArray);
            } else if (z2) {
                e3(sparseArray);
            } else if (W2()) {
                b.a.r0.j.i iVar = new b.a.r0.j.i(this.f19401c.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19401c.getPbModel().P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19401c.getPbModel().P0().o().has_forum_rule.intValue());
                iVar.i(this.f19401c.getPbModel().P0().l().getId(), this.f19401c.getPbModel().P0().l().getName());
                iVar.h(this.f19401c.getPbModel().P0().l().getImage_url());
                iVar.j(this.f19401c.getPbModel().P0().l().getUser_level());
                l3(sparseArray, i2, iVar, this.f19401c.getPbModel().P0().U(), false);
            } else {
                t3(this.Q, i2);
            }
        }
    }

    public void Y2() {
        b.a.r0.k2.u.f.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.u(this.l);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || this.S1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.S1 = true;
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19401c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(W1, Integer.valueOf(Y1));
        aVar.setTitle(b.a.r0.k2.l.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f19401c.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(b.a.r0.k2.i.function_description_view)).setText(b.a.r0.k2.l.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(b.a.r0.k2.i.title_view)).setText(b.a.r0.k2.l.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(b.a.r0.k2.l.grade_button_tips, this.f19401c);
        aVar.setNegativeButton(b.a.r0.k2.l.look_again, new g0(this));
        aVar.create(this.f19401c.getPageContext()).show();
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? b.a.r0.k2.i.user_icon_box : invokeV.intValue;
    }

    public void Z1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(W1, Integer.valueOf(X1));
            if (z2) {
                Z2(sparseArray);
            } else {
                a3(i2, sparseArray);
            }
        }
    }

    public final void Z2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048674, this, sparseArray) == null) || this.f19401c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(b.a.r0.k2.i.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f19401c.getPbActivity());
        lVar.q(b.a.r0.k2.l.musk_my_thread_confirm);
        lVar.j(b.a.r0.k2.l.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        AlertDialog t2 = lVar.t();
        aVar.a(new o(this, t2, sparseArray));
        aVar2.a(new p(this, t2));
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", org.apache.commons.lang3.StringUtils.LF);
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19401c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19401c.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(b.a.r0.k2.i.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(b.a.r0.k2.i.function_description_view)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(W1, Integer.valueOf(Z1));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(b.a.r0.k2.l.view, this.f19401c);
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new h0(this));
            aVar.create(this.f19401c.getPageContext()).show();
        }
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.f19402d : (View) invokeV.objValue;
    }

    public void a2(SparseArray<Object> sparseArray, boolean z2) {
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048678, this, sparseArray, z2) == null) {
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f19401c.getContext());
            iVar.p(this.f19401c.getString(b.a.r0.k2.l.bar_manager));
            iVar.m(new k(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new b.a.q0.s.s.f(10, this.f19401c.getString(b.a.r0.k2.l.delete_post), iVar);
                } else {
                    fVar2 = new b.a.q0.s.s.f(10, this.f19401c.getString(b.a.r0.k2.l.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = b.a.r0.k2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = b.a.r0.k2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = b.a.r0.k2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f13556d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if ((!"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show))) && !G1()) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = b.a.r0.k2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = b.a.r0.k2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = b.a.r0.k2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = b.a.r0.k2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(11, this.f19401c.getString(b.a.r0.k2.l.forbidden_person), iVar);
                fVar3.f13556d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = b.a.r0.k2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = b.a.r0.k2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = b.a.r0.k2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = b.a.r0.k2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = b.a.r0.k2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    fVar = new b.a.q0.s.s.f(12, this.f19401c.getString(b.a.r0.k2.l.un_mute), iVar);
                } else {
                    fVar = new b.a.q0.s.s.f(12, this.f19401c.getString(b.a.r0.k2.l.mute), iVar);
                }
                fVar.f13556d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            b.a.r0.k2.u.f.f1.a.e(arrayList);
            if (b.a.q0.b.d.F()) {
                iVar.k(arrayList, false);
            } else {
                iVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f19401c.getPageContext(), iVar);
            this.O = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final void a3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048679, this, i2, sparseArray) == null) || (pbFragment = this.f19401c) == null || pbFragment.getPbModel() == null || this.f19401c.getPbModel().P0() == null || this.f19401c.getPbModel().P0().o() == null || this.f19401c.getPbModel().P0().l() == null || this.f19401c.getPbModel().P0().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(b.a.r0.k2.i.tag_is_block_thread, Boolean.TRUE);
        }
        b.a.r0.j.i iVar = new b.a.r0.j.i(this.f19401c.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19401c.getPbModel().P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19401c.getPbModel().P0().o().has_forum_rule.intValue());
        iVar.i(this.f19401c.getPbModel().P0().l().getId(), this.f19401c.getPbModel().P0().l().getName());
        iVar.h(this.f19401c.getPbModel().P0().l().getImage_url());
        iVar.j(this.f19401c.getPbModel().P0().l().getUser_level());
        l3(sparseArray, i2, iVar, this.f19401c.getPbModel().P0().U(), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.x1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b0() {
        b.a.r0.k2.z.h hVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || (hVar = this.z1) == null) {
            return;
        }
        if (((hVar.a() == null || this.z1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.z1.a())) != -1) {
            if (this.z1.a().getTop() + b2 <= this.L0.getBottom()) {
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

    public void b1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.J0.setVisibility(8);
            }
            b.a.r0.k2.u.f.g1.c cVar = this.f19406h;
            if (cVar == null || (view = cVar.f19285d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void b2(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048682, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        a2(sparseArray, false);
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) {
            this.k0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.f19406h.k();
            b.a.r0.k2.u.f.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PbFragment pbFragment = this.f19401c;
            if (pbFragment != null) {
                b.a.e.e.p.l.x(pbFragment.getContext(), this.E);
            }
            e1();
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            g0();
            b.a.q0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            b.a.q0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || this.o0 == null) {
            return;
        }
        this.n0.setVisibility(8);
        this.o0.setVisibility(8);
        this.y0 = false;
        PbEmotionBar pbEmotionBar = this.T0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            n2(false);
        }
    }

    public void c2(b.a.q0.u.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048686, this, aVar, i2) == null) || (fallingView = this.B1) == null) {
            return;
        }
        fallingView.startFalling(aVar, this.f19401c.getPageContext(), i2, false);
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) || this.o0 == null) {
            return;
        }
        v2(this.f19401c.getPbEditor().D());
        if (this.j0) {
            g3(z2);
        } else {
            d1(z2);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            this.f19406h.k();
            b.a.r0.k2.u.f.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            g0();
            b.a.q0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            b.a.q0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) || this.o0 == null || this.r0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        b.a.r0.k2.r.f fVar = this.C0;
        boolean z3 = fVar != null && fVar.k0();
        b.a.r0.k2.r.f fVar2 = this.C0;
        this.r0.setText(tbSingleton.getAdVertiComment(z3, fVar2 != null && fVar2.l0(), R0()));
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
        n2(true);
    }

    public final void d2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048690, this, pbReplyTitleViewHolder, z2) == null) || this.c1 || this.L0 == null || this.f19406h.p() == null) {
            return;
        }
        View r2 = n0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.L0.getVisibility() == 0 && i3 - this.f19406h.p().getBottom() <= this.L0.getHeight()) {
                    this.M0.setVisibility(0);
                    if (i3 > this.f19406h.p().getBottom()) {
                        i2 = -(((this.L0.getHeight() + this.M0.getHeight()) + this.f19406h.p().getBottom()) - r2.getBottom());
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
            b3(false);
            this.f19406h.f19282a.hideBottomLine();
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
                    measuredHeight = U1 - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                } else {
                    measuredHeight = this.f19406h.p().getMeasuredHeight() - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                    this.f19406h.f19282a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.Q0) {
                    this.L0.setVisibility(0);
                    b3(false);
                } else if (top < measuredHeight) {
                    this.L0.setVisibility(0);
                    b3(false);
                } else {
                    this.L0.setVisibility(4);
                    this.f19406h.f19282a.hideBottomLine();
                }
                if (z2) {
                    this.R0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.L0.setVisibility(4);
            this.f19406h.f19282a.hideBottomLine();
        }
    }

    public void d3(b.a.r0.k2.r.f fVar) {
        PostData postData;
        b.a.r0.k2.u.f.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, fVar) == null) || fVar == null || (postData = this.D0) == null || postData.t() == null || (cVar = this.f19406h) == null) {
            return;
        }
        boolean z2 = !this.c1;
        this.d1 = z2;
        cVar.G(z2);
        if (this.f19401c.getPbNavigationAnimDispatcher() != null) {
            this.f19401c.getPbNavigationAnimDispatcher().s(this.d1);
        }
        e2();
        PbFragment pbFragment = this.f19401c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
            z1 z1Var = fVar.p().get(0);
            if (z1Var != null) {
                this.f19406h.K(fVar, z1Var.getForumName(), z1Var.getForumId(), z1Var.b(), z1Var.getIsLike());
            }
        } else if (fVar.l() != null) {
            this.f19406h.K(fVar, fVar.l().getName(), fVar.l().getId(), fVar.l().getImage_url(), fVar.l().isLike() == 1);
        }
        if (this.d1) {
            this.s.C(fVar, this.D0, this.d0);
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
        this.s.C(fVar, this.D0, this.d0);
        this.m1 = null;
        this.l.setListViewDragListener(null);
    }

    public void e0() {
        b.a.r0.k2.z.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || (iVar = this.v0) == null) {
            return;
        }
        iVar.k(false);
    }

    public void e1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.hide();
        b.a.r0.k2.u.f.b1.c cVar = this.k1;
        if (cVar != null) {
            cVar.i();
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.s.s(this.C0, this.D0, this.d1, this.c1);
        }
    }

    public final void e3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048695, this, sparseArray) == null) || this.f19401c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f19401c.getPbActivity());
        lVar.q(b.a.r0.k2.l.del_my_thread_confirm);
        lVar.j(b.a.r0.k2.l.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        AlertDialog t2 = lVar.t();
        aVar.a(new m(this, t2, sparseArray));
        aVar2.a(new n(this, t2));
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.q.b(this.B0) : invokeV.booleanValue;
    }

    public void f1() {
        b.a.r0.k2.u.f.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (cVar = this.f19406h) == null) {
            return;
        }
        cVar.q();
    }

    public void f2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.b1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.S0.f19462c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.S0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.S0.f19462c;
        int S0 = S0(pbReplyTitleViewHolder);
        int measuredHeight = this.z.getMeasuredHeight() + ((int) this.z.getY());
        boolean z2 = this.L0.getVisibility() == 0;
        boolean z3 = this.z.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.A.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), U1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.f19406h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.c1 && this.p != null) {
            this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.E0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, S0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final boolean f3(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return fVar.O().j0() == 1 || fVar.O().o1() == 33 || !(fVar.O().w1() == null || fVar.O().w1().a() == 0) || fVar.O().r0() == 1 || fVar.O().q0() == 1 || fVar.O().I1() || fVar.O().c2() || fVar.O().H2() || fVar.O().F1() != null || !b.a.e.e.p.k.isEmpty(fVar.O().N()) || fVar.O().Z1() || fVar.O().q2();
        }
        return invokeL.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            b.a.q0.s.s.a aVar = this.Q;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.R;
            if (dialog != null) {
                b.a.e.e.m.g.b(dialog, this.f19401c.getPageContext());
            }
            Dialog dialog2 = this.S;
            if (dialog2 != null) {
                b.a.e.e.m.g.b(dialog2, this.f19401c.getPageContext());
            }
            PopupDialog popupDialog = this.O;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void g1() {
        b.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (aVar = this.A0) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void g2(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        H3(fVar);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.t0, b.a.r0.k2.h.icon_pure_pb_bottom_collected26_selection, b.a.r0.k2.f.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.t0, b.a.r0.k2.h.icon_pure_pb_bottom_collect26, b.a.r0.k2.f.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String m02 = m0(fVar.O().U0());
        TextView textView = this.w0;
        if (textView != null) {
            textView.setText(m02);
        }
        TextView textView2 = this.x0;
        if (textView2 != null) {
            textView2.setText(m02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public void g3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) || this.o0 == null || (textView = this.r0) == null) {
            return;
        }
        textView.setText(b.a.r0.k2.l.draft_to_send);
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
        n2(true);
    }

    public void h0() {
        b.a.r0.k2.u.f.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.b();
    }

    public void h1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            if (this.w == null) {
                o1();
            }
            this.k.setVisibility(8);
            Handler handler = this.H1;
            if (handler == null || (runnable = this.I1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void h2(int i2, b.a.r0.k2.r.f fVar, boolean z2, int i3) {
        PostData v0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048706, this, new Object[]{Integer.valueOf(i2), fVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (v0 = v0(fVar, z2)) == null || v0.t() == null) {
            return;
        }
        MetaData t2 = v0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void h3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048707, this, view) == null) || b.a.q0.s.e0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.o0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f19401c.getContext());
        frameLayout.setBackgroundResource(b.a.r0.k2.h.pic_sign_tip);
        TextView textView = new TextView(this.f19401c.getContext());
        this.i1 = textView;
        textView.setText(b.a.r0.k2.l.connection_tips);
        this.i1.setGravity(17);
        this.i1.setPadding(b.a.e.e.p.l.g(this.f19401c.getContext(), b.a.r0.k2.g.ds24), 0, b.a.e.e.p.l.g(this.f19401c.getContext(), b.a.r0.k2.g.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = b.a.e.e.p.l.g(this.f19401c.getContext(), b.a.r0.k2.g.ds60);
        if (this.i1.getParent() == null) {
            frameLayout.addView(this.i1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f19401c.getContext());
        this.h1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.h1.setHeight(-2);
        this.h1.setWidth(-2);
        this.h1.setFocusable(true);
        this.h1.setOutsideTouchable(false);
        this.h1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(b.a.r0.k2.f.transparent)));
        this.l.postDelayed(new i0(this, i4, i2, i3, view), 100L);
        b.a.q0.s.e0.b.j().t("show_long_press_collection_tips", true);
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.x();
                this.G.f();
            }
            g1();
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            this.K.setVisibility(8);
        }
    }

    public void i2(b.a.r0.k2.r.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048710, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            o3(fVar, z2, i2, i3);
            this.s.q(i3);
        }
    }

    public void i3() {
        b.a.r0.k2.u.f.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048711, this) == null) || (cVar = this.f19406h) == null || this.e1) {
            return;
        }
        cVar.C();
        this.e1 = true;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            this.l.completePullRefreshPostDelayed(0L);
            f0();
        }
    }

    public void j1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || (rightFloatLayerView = this.C1) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public final void j2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048714, this) == null) && (pbInterviewStatusView = this.I0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.I0.setLayoutParams(layoutParams);
        }
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public void k0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f19401c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f19401c;
                pbFragment.showToast(pbFragment.getPageContext().getString(b.a.r0.k2.l.success));
            } else if (z3) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.neterror);
                }
                this.f19401c.showToast(str);
            }
        }
    }

    public void k1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048717, this) == null) || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || this.f19404f == 2) {
            return;
        }
        this.l.setNextPage(this.G);
        this.f19404f = 2;
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            if (this.A0 == null) {
                this.A0 = new b.a.q0.s.g0.a(this.f19401c.getPageContext());
            }
            this.A0.h(true);
        }
    }

    public void l0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void l1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048721, this) == null) && this.v == null && (pbFragment = this.f19401c) != null) {
            this.v = new b.a.r0.k2.u.f.a1.c(pbFragment.getContext());
        }
    }

    public void l2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048722, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.v.d(pbLandscapeListView);
        this.r.d(this.l);
        this.s.t(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public final void l3(SparseArray<Object> sparseArray, int i2, b.a.r0.j.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f19401c) == null) {
            return;
        }
        if (this.r1 == null && this.q != null) {
            this.r1 = new b.a.r0.j.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        this.r1.C(z2);
        AntiData antiData = this.f19401c.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        b.a.q0.s.q.x0 x0Var = new b.a.q0.s.q.x0();
        x0Var.j(sparseArray2);
        this.r1.E(new String[]{this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.r1.D(x0Var);
        this.r1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.r1.F(new r(this, sparseArray));
    }

    public final String m0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048724, this, i2)) == null) {
            if (i2 == 0) {
                return this.f19401c.getString(b.a.r0.k2.l.pb_comment_red_dot_no_reply);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048725, this) == null) && this.r == null) {
            this.r = new b.a.r0.k2.u.f.a1.f(this.f19401c, this.g0);
        }
    }

    public final void m2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || (pbFragment = this.f19401c) == null || pbFragment.getPbEditor() == null || this.i0 == null) {
            return;
        }
        b.a.q0.x.x.a.a().c(0);
        b.a.q0.x.x.e pbEditor = this.f19401c.getPbEditor();
        pbEditor.U();
        pbEditor.S();
        if (pbEditor.z() != null) {
            pbEditor.z().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.m0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        b.a.q0.x.h findLauncherById = this.i0.findLauncherById(23);
        b.a.q0.x.h findLauncherById2 = this.i0.findLauncherById(2);
        b.a.q0.x.h findLauncherById3 = this.i0.findLauncherById(5);
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

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.A.c0(this.C0, false);
            this.A.X();
        }
    }

    public b.a.r0.k2.u.f.h n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.A : (b.a.r0.k2.u.f.h) invokeV.objValue;
    }

    public final void n1(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048729, this, fVar) == null) && fVar != null && fVar.O() != null && fVar.O().c2() && this.I0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.H0.inflate();
            this.I0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.L);
            this.I0.setCallback(this.f19401c.getInterviewStatusCallback());
            this.I0.setData(this.f19401c, fVar);
        }
    }

    public final void n2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) {
        }
    }

    public void n3(b.a.r0.k2.r.f fVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048731, this, new Object[]{fVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || fVar == null || this.l == null) {
            return;
        }
        this.C0 = fVar;
        this.E0 = i2;
        if (fVar.O() != null) {
            this.U0 = fVar.O().O();
            if (fVar.O().F() != 0) {
                this.N1 = true;
            }
            this.d0 = C1(fVar.O());
        }
        if (fVar.U() != null) {
            this.O1 = fVar.U().getUserId();
        }
        n1(fVar);
        U();
        this.G0 = false;
        this.B0 = z2;
        P2();
        b.a.r0.k2.r.l lVar = fVar.f18764h;
        if (lVar != null && lVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f19401c.getContext());
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
        o3(fVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        d3(fVar);
        if (this.o1 == null) {
            this.o1 = new b.a.r0.k2.u.f.f0(this.f19401c.getPageContext(), this.p1);
        }
        this.o1.a(fVar.w());
        if (this.f19401c.getIsMangaThread()) {
            if (this.F == null) {
                b.a.r0.k2.z.j jVar = new b.a.r0.k2.z.j(this.f19401c.getPageContext());
                this.F = jVar;
                jVar.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            p2();
            b.a.r0.k2.z.j jVar2 = this.F;
            if (jVar2 != null) {
                jVar2.C(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (fVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.F == null) {
                b.a.r0.k2.z.j jVar3 = new b.a.r0.k2.z.j(this.f19401c.getPageContext());
                this.F = jVar3;
                jVar3.i();
                this.F.a(this.P1);
            }
            this.l.setPullRefresh(this.F);
            p2();
            b.a.r0.k2.z.j jVar4 = this.F;
            if (jVar4 != null) {
                jVar4.C(TbadkCoreApplication.getInst().getSkinType());
            }
            g1();
        }
        f0();
        this.A.j0(this.B0);
        this.A.g0(false);
        this.A.h0(i2 == 5);
        this.A.i0(i2 == 6);
        this.A.e0(z3 && this.L1 && i2 != 2);
        this.A.c0(fVar, false);
        this.A.X();
        this.s.B(v0(fVar, z2), fVar.g0());
        if (fVar.O() != null && fVar.O().L0() != null && this.f19400b != -1) {
            fVar.O().L0().setIsLike(this.f19400b);
        }
        this.l.removeFooterView(this.P0);
        this.l.addFooterView(this.P0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.G);
            this.f19404f = 2;
            g1();
        } else {
            this.G0 = true;
            if (fVar.y().b() == 1) {
                if (this.H == null) {
                    PbFragment pbFragment = this.f19401c;
                    this.H = new b.a.r0.k2.z.f(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.H);
            } else {
                this.l.setNextPage(this.G);
            }
            this.f19404f = 3;
        }
        ArrayList<PostData> F = fVar.F();
        if (fVar.y().b() != 0 && F != null && F.size() >= fVar.y().e()) {
            if (z3) {
                if (this.L1) {
                    i0();
                    if (fVar.y().b() != 0) {
                        this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_load_more));
                    }
                } else {
                    this.G.z();
                    this.G.N();
                }
            } else {
                this.G.z();
                this.G.N();
            }
            this.G.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (fVar.y().b() == 0) {
                    this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.list_has_no_more));
                } else {
                    this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.load_more));
                }
                this.G.k();
            } else {
                p0 p0Var = this.S0;
                if (p0Var == null || (pbReplyTitleViewHolder = p0Var.f19462c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i5 = 0;
                } else {
                    i5 = this.S0.f19462c.getView().getTop() < 0 ? this.S0.f19462c.getView().getHeight() : this.S0.f19462c.getView().getBottom();
                }
                if (this.f19401c.isHostOnlyMode()) {
                    this.G.u(false);
                    this.G.F(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_no_host_reply), i5);
                } else {
                    this.G.F(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_no_replay), i5);
                }
                if (this.f19401c.getPbNavigationAnimDispatcher() != null && !this.f19401c.getPbNavigationAnimDispatcher().p()) {
                    this.f19401c.getPbNavigationAnimDispatcher().x();
                }
            }
            if (fVar.y().b() == 0 || F == null) {
                k2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && fVar.F() == null) ? 0 : (this.l.getData().size() - fVar.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.L1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        b.a.r0.k2.u.f.a1.i iVar = this.p;
                        if (iVar != null && iVar.c() != null) {
                            if (this.f19401c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - b.a.e.e.p.l.r(this.f19401c.getPageContext().getPageActivity()));
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
                    this.G.C(this.f19401c.getString(b.a.r0.k2.l.pb_load_more_without_point));
                    this.G.x();
                }
            } else if (i4 == 1 && (e3 = b.a.r0.k2.u.f.k0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e2 = b.a.r0.k2.u.f.k0.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new b0(this, e2, F, fVar));
        }
        if (this.U0 == V1 && B1()) {
            Z();
        }
        if (this.a1) {
            f2();
            this.a1 = false;
            if (i4 == 0) {
                E2(true);
            }
        }
        if (fVar.f18760d == 1 || fVar.f18761e == 1) {
            if (this.g1 == null) {
                this.g1 = new PbTopTipView(this.f19401c.getContext());
            }
            if (fVar.f18761e == 1 && "game_guide".equals(this.f19401c.getStType())) {
                this.g1.setText(this.f19401c.getString(b.a.r0.k2.l.pb_read_strategy_add_experience));
                this.g1.show(this.f19402d, this.F0);
            } else if (fVar.f18760d == 1 && "game_news".equals(this.f19401c.getStType())) {
                this.g1.setText(this.f19401c.getString(b.a.r0.k2.l.pb_read_news_add_experience));
                this.g1.show(this.f19402d, this.F0);
            }
        }
        this.l.removeFooterView(this.z1.a());
        if (!ListUtils.isEmpty(fVar.I()) && fVar.y().b() == 0) {
            this.l.removeFooterView(this.P0);
            this.z1.d(Math.max(this.o0.getMeasuredHeight(), this.z0 / 2));
            this.l.addFooterView(this.z1.a());
            this.z1.f(fVar);
        }
        g2(fVar);
        if (fVar.e0() && this.f19401c.getPbRecThreadController() != null) {
            this.f19401c.getPbRecThreadController().d();
        }
        if (fVar.g() != 3) {
            r1(fVar);
        }
        this.r0.setText(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), R0()));
    }

    public LinearLayout o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.p0 : (LinearLayout) invokeV.objValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && this.f19401c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19402d.findViewById(b.a.r0.k2.i.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.w == null) {
                this.w = (LinearLayout) this.f19402d.findViewById(b.a.r0.k2.i.manga_controller_layout);
                b.a.q0.w0.a.a(this.f19401c.getPageContext(), this.w);
            }
            if (this.x == null) {
                this.x = (TextView) this.w.findViewById(b.a.r0.k2.i.manga_prev_btn);
            }
            if (this.y == null) {
                this.y = (TextView) this.w.findViewById(b.a.r0.k2.i.manga_next_btn);
            }
            this.x.setOnClickListener(this.L);
            this.y.setOnClickListener(this.L);
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            m2();
            e1();
            this.Y0.c();
            c3(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o3(b.a.r0.k2.r.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048735, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        if (this.f19401c.isSimpleForum()) {
            if (fVar.h() != null) {
                this.e0 = fVar.h().getForumName();
                this.f0 = fVar.h().getForumId();
            }
            if (this.e0 == null && this.f19401c.getPbModel() != null && this.f19401c.getPbModel().q0() != null) {
                this.e0 = this.f19401c.getPbModel().q0();
            }
        }
        PostData v0 = v0(fVar, z2);
        N2(v0, fVar);
        this.s.y(8);
        if (fVar.r0()) {
            this.c1 = true;
            this.f19406h.A(true);
            this.f19406h.f19282a.hideBottomLine();
            if (this.p == null) {
                this.p = new b.a.r0.k2.u.f.a1.i(this.f19401c);
            }
            this.p.v(fVar, v0, this.l, this.s, this.J0, this.f19406h, this.e0, this.u1);
            this.p.s(this.M1);
            p2();
        } else {
            this.c1 = false;
            this.f19406h.A(false);
            b.a.r0.k2.u.f.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f19401c.getPbNavigationAnimDispatcher() != null) {
            this.f19401c.getPbNavigationAnimDispatcher().w(this.c1);
        }
        if (v0 == null) {
            return;
        }
        this.D0 = v0;
        this.s.y(0);
        SparseArray<Object> o2 = this.s.o();
        o2.put(b.a.r0.k2.i.tag_clip_board, v0);
        o2.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
        this.t.e(fVar, this.l);
        this.v.e(fVar, this.w1, new y(this));
        this.r.f(fVar);
        this.q.h(fVar, this.B0);
        this.q.g(fVar);
        this.s.z(this.F0, this.C0, v0, this.M1);
        if (this.O0 != null) {
            if (fVar.g0()) {
                this.O0.getView().setVisibility(8);
            } else {
                this.O0.getView().setVisibility(0);
                b.a.r0.k2.r.p pVar = new b.a.r0.k2.r.p(b.a.r0.k2.r.p.l);
                if (fVar.O() != null) {
                    fVar.O().U0();
                }
                pVar.f18796g = fVar.f18763g;
                fVar.c();
                pVar.f18797h = this.f19401c.isHostOnlyMode();
                pVar.k = fVar.f18762f;
                this.O0.bindDataToView(pVar);
            }
        }
        y3(fVar);
        b.a.e.e.m.e.a().post(new z(this));
        this.u.e(this.l);
        if (v0.U) {
            this.u.f(v0.G());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        b.a.r0.k2.u.f.h hVar = this.A;
        if (hVar != null && hVar.z() != null) {
            this.A.z().t0(v0.U);
        }
        b.a.r0.k2.u.f.h hVar2 = this.A;
        if (hVar2 != null) {
            hVar2.l0(v0.U);
        }
        this.A1.setVisibility(v0.U ? 0 : 8);
    }

    public View p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            View view = this.T;
            if (view != null) {
                return view.findViewById(b.a.r0.k2.i.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void p1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || this.f19401c == null || (editorTools = this.i0) == null) {
            return;
        }
        editorTools.display();
        if (this.f19401c.getPbEditor() != null) {
            this.f19401c.getPbEditor().Q();
        }
        c1();
    }

    public final void p2() {
        b.a.r0.k2.u.f.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(this.l, this.K0, this.E0);
    }

    public void p3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048739, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.a0;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.a0 = null;
            }
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f19401c.getContext());
            ArrayList arrayList = new ArrayList();
            b.a.r0.k2.r.f fVar = this.C0;
            if (fVar != null && fVar.O() != null && !this.C0.O().Q1()) {
                arrayList.add(new b.a.q0.s.s.f(0, this.f19401c.getPageContext().getString(b.a.r0.k2.l.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new b.a.q0.s.s.f(1, this.f19401c.getPageContext().getString(b.a.r0.k2.l.save_to_local), iVar));
            }
            iVar.j(arrayList);
            iVar.m(new w(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19401c.getPageContext(), iVar);
            this.a0 = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public final void q1(b.a.r0.k2.r.f fVar, b.a.q0.t.c.g gVar) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048741, this, fVar, gVar) == null) || (rightFloatLayerView = this.C1) == null || fVar == null || gVar == null) {
            return;
        }
        if (!rightFloatLayerView.isPbNeedShow()) {
            j1();
        } else if (StringUtils.isNull(gVar.f13782f)) {
        } else {
            this.C1.setData(gVar);
            this.C1.setLogoListener(new e0(this, gVar));
            this.C1.setFeedBackListener(new j0(this, gVar));
        }
    }

    public void q2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048742, this) == null) || (handler = this.H1) == null) {
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

    public void q3(b.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048743, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Z = null;
            }
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f19401c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new b.a.q0.s.s.f(0, this.f19401c.getPageContext().getString(b.a.r0.k2.l.copy), iVar));
            }
            if (z3) {
                arrayList.add(new b.a.q0.s.s.f(1, this.f19401c.getPageContext().getString(b.a.r0.k2.l.report_text), iVar));
            } else if (!z2) {
                arrayList.add(new b.a.q0.s.s.f(1, this.f19401c.getPageContext().getString(b.a.r0.k2.l.mark), iVar));
            } else {
                arrayList.add(new b.a.q0.s.s.f(1, this.f19401c.getPageContext().getString(b.a.r0.k2.l.remove_mark), iVar));
            }
            iVar.j(arrayList);
            iVar.m(new v(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19401c.getPageContext(), iVar);
            this.a0 = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public int r0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
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

    public void r1(b.a.r0.k2.r.f fVar) {
        b.a.q0.t.c.g pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048745, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.k0()) {
            pbAdFloatViewItemData = fVar.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            q1(fVar, pbAdFloatViewItemData);
        } else {
            j1();
        }
    }

    public void r2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, editorTools) == null) {
            this.i0 = editorTools;
            editorTools.setOnCancelClickListener(new h(this));
            this.i0.setId(b.a.r0.k2.i.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.i0.getParent() == null) {
                this.f19402d.addView(this.i0, layoutParams);
            }
            this.i0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.i0.setActionListener(24, new i(this));
            e1();
            this.f19401c.getPbEditor().i(new j(this));
        }
    }

    public void r3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, onItemClickListener) == null) {
            b.a.q0.s.s.c cVar = this.b0;
            if (cVar != null) {
                cVar.d();
                this.b0 = null;
            }
            if (this.C0 == null) {
                return;
            }
            ArrayList<b.a.q0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new b.a.q0.s.s.k(this.f19401c.getContext().getString(b.a.r0.k2.l.all_person), "", this.C0.L() == 1, Integer.toString(1)));
            arrayList.add(new b.a.q0.s.s.k(this.f19401c.getContext().getString(b.a.r0.k2.l.my_fans), "", this.C0.L() == 2, Integer.toString(5)));
            arrayList.add(new b.a.q0.s.s.k(this.f19401c.getContext().getString(b.a.r0.k2.l.my_attentions), "", this.C0.L() == 3, Integer.toString(6)));
            arrayList.add(new b.a.q0.s.s.k(this.f19401c.getContext().getString(b.a.r0.k2.l.myself_only), "", this.C0.L() == 4, Integer.toString(7)));
            b.a.q0.s.s.c cVar2 = new b.a.q0.s.s.c(this.f19401c.getPageContext());
            cVar2.l(b.a.r0.k2.l.pb_privacy_setting_thread_reply_decs);
            this.b0 = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.b0.n();
        }
    }

    public PostData s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int r0 = r0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (r0 < 0) {
                r0 = 0;
            }
            if (this.A.y(r0) != null && this.A.y(r0) != PostData.x0) {
                i2 = r0 + 1;
            }
            if (this.A.x(i2) instanceof PostData) {
                return (PostData) this.A.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048749, this) == null) && this.t == null) {
            this.t = new b.a.r0.k2.u.f.a1.e(this.f19401c, this.L);
        }
    }

    public void s2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, str) == null) || (pbListView = this.G) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void s3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || !TbadkCoreApplication.isLogin() || this.C0 == null || !this.d1 || this.c1 || this.d0 || (postData = this.D0) == null || postData.t() == null || this.D0.t().getIsLike() || this.D0.t().hadConcerned() || this.Z0 != null) {
            return;
        }
        this.Z0 = new b.a.r0.k2.u.f.n0(this.f19401c);
    }

    public FallingView t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.B1 : (FallingView) invokeV.objValue;
    }

    public void t1(b.a.r0.k2.r.f fVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, fVar) == null) {
            int i2 = 0;
            this.A.c0(fVar, false);
            this.A.X();
            f0();
            b.a.r0.k2.u.e.a aVar = this.l1;
            if (aVar != null) {
                aVar.n();
            }
            ArrayList<PostData> F = fVar.F();
            if (fVar.y().b() == 0 || F == null || F.size() < fVar.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (fVar.y().b() == 0) {
                        this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.list_has_no_more));
                    } else {
                        this.G.C(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.load_more));
                    }
                    this.G.k();
                } else {
                    p0 p0Var = this.S0;
                    if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f19462c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i2 = this.S0.f19462c.getView().getTop() < 0 ? this.S0.f19462c.getView().getHeight() : this.S0.f19462c.getView().getBottom();
                    }
                    if (this.f19401c.isHostOnlyMode()) {
                        this.G.F(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_no_host_reply), i2);
                    } else {
                        this.G.F(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_no_replay), i2);
                    }
                }
            }
            g2(fVar);
        }
    }

    public void t2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048754, this, str) == null) || this.G == null) {
            return;
        }
        int i2 = 0;
        p0 p0Var = this.S0;
        if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f19462c) != null && pbReplyTitleViewHolder.getView() != null) {
            i2 = this.S0.f19462c.getView().getTop() < 0 ? this.S0.f19462c.getView().getHeight() : this.S0.f19462c.getView().getBottom();
        }
        this.G.F(str, i2);
    }

    public final void t3(b.a.q0.s.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048755, this, aVar, i2) == null) || (pbFragment = this.f19401c) == null || aVar == null) {
            return;
        }
        if (this.q1 == null && this.q != null) {
            this.q1 = new b.a.r0.j.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData antiData = this.f19401c.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        b.a.q0.s.q.x0 x0Var = new b.a.q0.s.q.x0();
        x0Var.j(sparseArray);
        this.q1.y(new String[]{this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f19401c.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.q1.x(x0Var);
        this.q1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.q1.z(new q(this, aVar));
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? w0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? this.N1 : invokeV.booleanValue;
    }

    public void u2(PbFragment.b3 b3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, b3Var) == null) {
            this.K1 = b3Var;
        }
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.K.setVisibility(0);
        }
    }

    public PostData v0(b.a.r0.k2.r.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048760, this, fVar, z2)) == null) {
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
            if (!z1(postData)) {
                postData = Q0(fVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    public void v2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048762, this, z2) == null) {
            this.j0 = z2;
        }
    }

    public void v3() {
        b.a.r0.k2.z.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (iVar = this.v0) == null) {
            return;
        }
        iVar.m(2);
    }

    public final int w0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048764, this, i2)) == null) {
            b.a.e.l.e.e adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof b.a.r0.k2.r.c)) {
                i2++;
            }
            int m2 = (adapter2.m() + adapter2.k()) - 1;
            if (i2 > m2) {
                i2 = m2;
            }
            int l2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof b.a.e.l.e.e)) ? 0 : this.l.getAdapter2().l();
            if (i2 > l2) {
                return i2 - l2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final boolean w1(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048765, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            SpannableStringBuilder g1 = fVar.O().g1();
            if (g1 != null) {
                return TbadkApplication.getInst().getResources().getString(b.a.r0.k2.l.pb_default_share_tie_title).equals(g1.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z2) == null) {
            this.A.d0(z2);
        }
    }

    public void w3(b1 b1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048767, this, b1Var, eVar) == null) || b1Var == null) {
            return;
        }
        int a3 = b1Var.a();
        int h2 = b1Var.h();
        b.a.q0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.show();
        } else {
            this.B = new b.a.q0.s.s.a(this.f19401c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19401c.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.dialog_direct_pager, (ViewGroup) null);
            this.D = inflate;
            this.B.setContentView(inflate);
            this.B.setPositiveButton(b.a.r0.k2.l.dialog_ok, eVar);
            this.B.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new d0(this));
            this.B.setOnCalcelListener(new f0(this));
            this.B.create(this.f19401c.getPageContext()).show();
        }
        EditText editText = (EditText) this.D.findViewById(b.a.r0.k2.i.input_page_number);
        this.E = editText;
        editText.setText("");
        TextView textView = (TextView) this.D.findViewById(b.a.r0.k2.i.current_page_number);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.current_page), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.f19401c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.E, 150);
    }

    public Button x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) ? this.m0 : (Button) invokeV.objValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.isDragListenerExecuted();
        }
        return invokeV.booleanValue;
    }

    public void x2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048770, this, z2) == null) {
            this.v1 = z2;
        }
    }

    public void x3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048771, this, z2) == null) || this.l == null || (textView = this.K0) == null || this.f19403e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f19403e.setVisibility(0);
            } else {
                this.f19403e.setVisibility(8);
                this.l.removeHeaderView(this.K0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.K0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = U1;
                this.K0.setLayoutParams(layoutParams);
            }
            p2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + I0(true);
            this.K0.setLayoutParams(layoutParams2);
        }
        p2();
        j2();
    }

    public int y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            EditorTools editorTools = this.i0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z2) == null) {
            this.n1 = z2;
        }
    }

    public final void y3(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048775, this, fVar) == null) || fVar == null || fVar.O() == null || fVar.O().E2()) {
            return;
        }
        boolean z2 = fVar.O().q0() == 1;
        boolean z3 = fVar.O().r0() == 1;
        b.a.r0.k2.u.f.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.j(fVar, z2, z3);
        }
        b.a.r0.k2.u.f.h hVar2 = this.A;
        if (hVar2 == null || hVar2.t() == null) {
            return;
        }
        this.A.t().showThreadTypeStampBottomPart(fVar, z2, z3);
    }

    public TextView z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.s.l() : (TextView) invokeV.objValue;
    }

    public final boolean z1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048777, this, postData)) == null) {
            if (postData == null || postData.t() == null) {
                return false;
            }
            MetaData t2 = postData.t();
            return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void z2(boolean z2) {
        b.a.r0.k2.u.f.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048778, this, z2) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.r(z2);
    }

    @SuppressLint({"CutPasteId"})
    public void z3(b.a.r0.k2.r.f fVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048779, this, fVar, z2) == null) || fVar == null) {
            return;
        }
        I3(fVar, z2);
        f0();
    }
}
