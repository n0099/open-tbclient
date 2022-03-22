package c.a.p0.w2.m.f;

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
import c.a.o0.r.l0.f;
import c.a.o0.r.r.x1;
import c.a.o0.r.t.a;
import c.a.o0.r.t.c;
import c.a.o0.r.t.l;
import c.a.p0.a4.j0.a;
import c.a.p0.l.g;
import c.a.p0.l.j;
import c.a.p0.w2.j.a;
import c.a.p0.w2.m.f.a0;
import c.a.p0.w2.m.f.i1.c;
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
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
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
/* loaded from: classes3.dex */
public class a1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int X1;
    public static int Y1;
    public static int Z1;
    public static int a2;
    public static int b2;
    public static int c2;
    public static int d2;
    public static final int e2;
    public static a.f f2;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public boolean A0;
    public boolean A1;
    public ObservedChangeRelativeLayout B;
    public int B0;
    public c.a.p0.w2.r.i B1;
    public c.a.p0.w2.m.f.l C;
    public c.a.o0.r.l0.a C0;
    public MaskView C1;
    public c.a.o0.r.t.a D;
    public boolean D0;
    public final FallingView D1;
    public c.a.o0.r.t.c E;
    public c.a.p0.w2.i.f E0;
    public RightFloatLayerView E1;
    public View F;
    public PostData F0;
    public final FrameLayout F1;
    public EditText G;
    public int G0;
    public boolean G1;
    public c.a.p0.w2.r.k H;
    public int H0;
    public String H1;
    public PbListView I;
    public boolean I0;
    public CustomMessageListener I1;
    public c.a.p0.w2.r.g J;
    public ViewStub J0;
    public CustomMessageListener J1;
    public View K;
    public PbInterviewStatusView K0;
    public Handler K1;
    public View L;
    public FrameLayout L0;
    public Runnable L1;
    public View M;
    public TextView M0;
    public CustomMessageListener M1;
    public View.OnClickListener N;
    public View N0;
    public PbFragment.c3 N1;
    public TbRichTextView.y O;
    public View O0;
    public boolean O1;
    public NoNetworkView.b P;
    public View P0;
    public View.OnClickListener P1;
    public c.a.o0.r.t.j Q;
    public PbReplyTitleViewHolder Q0;
    public boolean Q1;
    public View.OnClickListener R;
    public View R0;
    public String R1;
    public c.a.o0.r.t.a S;
    public int S0;
    public f.g S1;
    public Dialog T;
    public boolean T0;
    public final List<TbImageView> T1;
    public Dialog U;
    public p0 U0;
    public int U1;
    public View V;
    public PbEmotionBar V0;
    public boolean V1;
    public LinearLayout W;
    public int W0;
    public boolean W1;
    public CompoundButton.OnCheckedChangeListener X;
    public int X0;
    public TextView Y;
    public Runnable Y0;
    public TextView Z;
    public PbFakeFloorModel Z0;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public String a0;
    public c.a.p0.w2.m.f.x a1;

    /* renamed from: b  reason: collision with root package name */
    public int f19987b;
    public c.a.o0.r.t.j b0;
    public v0 b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f19988c;
    public c.a.o0.r.t.j c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19989d;
    public c.a.o0.r.t.e d0;
    public int d1;

    /* renamed from: e  reason: collision with root package name */
    public View f19990e;
    public boolean e0;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public int f19991f;
    public boolean f0;
    public boolean f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f19992g;
    public String g0;
    public boolean g1;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.w2.m.f.o1.c f19993h;
    public String h0;
    public int h1;
    public c.a.p0.w2.m.f.o1.b i;
    public c.a.p0.w2.j.c i0;
    public PbTopTipView i1;
    public ViewStub j;
    public ScrollView j0;
    public PopupWindow j1;
    public ViewStub k;
    public EditorTools k0;
    public TextView k1;
    public PbLandscapeListView l;
    public boolean l0;
    public List<String> l1;
    public NoNetworkView m;
    public View m0;
    public c.a.p0.w2.m.f.j1.c m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public c.a.p0.w2.m.e.a n1;
    public PbThreadPostView o;
    public Button o0;
    public PbLandscapeListView.c o1;
    public c.a.p0.w2.m.f.b0 p;
    public View p0;
    public boolean p1;
    public c.a.p0.w2.m.f.a0 q;
    public View q0;
    public c.a.p0.w2.m.f.n0 q1;
    public c.a.p0.w2.m.f.i1.i r;
    public LinearLayout r0;
    public NavigationBarCoverTip r1;
    public c.a.p0.w2.m.f.i1.d s;
    public HeadImageView s0;
    public c.a.p0.l.g s1;
    public c.a.p0.w2.m.f.i1.f t;
    public TextView t0;
    public c.a.p0.l.j t1;
    public c.a.p0.w2.m.f.i1.h u;
    public ImageView u0;
    public String u1;
    public c.a.p0.w2.m.f.i1.e v;
    public ImageView v0;
    public PermissionJudgePolicy v1;
    public c.a.p0.w2.m.f.i1.g w;
    public ImageView w0;
    public long w1;
    public c.a.p0.w2.m.f.i1.c x;
    public c.a.p0.w2.r.j x0;
    public boolean x1;
    public LinearLayout y;
    public TextView y0;
    public int y1;
    public TextView z;
    public TextView z0;
    public int z1;

    /* loaded from: classes3.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f19994b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19995c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19996d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a1 f19999g;

        /* renamed from: c.a.p0.w2.m.f.a1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1501a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC1501a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f19999g.R0 == null || this.a.f19999g.R0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.f19999g.R0.getLayoutParams();
                layoutParams.height = this.a.f19999g.X0;
                this.a.f19999g.R0.setLayoutParams(layoutParams);
            }
        }

        public a(a1 a1Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19999g = a1Var;
            this.a = i;
            this.f19994b = pbReplyTitleViewHolder;
            this.f19995c = z;
            this.f19996d = i2;
            this.f19997e = i3;
            this.f19998f = i4;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.a;
                if (i2 >= 0 && i2 <= this.f19999g.f19989d.getMeasuredHeight()) {
                    int T0 = this.f19999g.T0(this.f19994b);
                    int i3 = this.a;
                    int i4 = T0 - i3;
                    if (this.f19995c && i4 != 0 && i3 <= (i = this.f19996d)) {
                        i4 = T0 - i;
                    }
                    if (this.f19999g.R0 == null || (layoutParams = this.f19999g.R0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.f19999g.f19989d.getMeasuredHeight() || T0 >= this.f19999g.f19989d.getMeasuredHeight()) {
                        layoutParams.height = this.f19999g.X0;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.f19999g.f19989d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.f19999g.l.setSelectionFromTop(this.f19997e, this.f19998f);
                            }
                        }
                        layoutParams.height = this.f19999g.X0;
                    }
                    this.f19999g.R0.setLayoutParams(layoutParams);
                    c.a.d.f.m.e.a().post(new RunnableC1501a(this));
                }
                this.f19999g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20000b;

        public a0(a1 a1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20000b = a1Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.d.f.p.n.C()) {
                    UrlManager.getInstance().dealOneLink(this.f20000b.f19988c.getPageContext(), new String[]{this.a});
                    this.f20000b.f19988c.finish();
                    return;
                }
                this.f20000b.f19988c.showToast(R.string.obfuscated_res_0x7f0f0c15);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public b(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.s2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f20001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.w2.i.f f20002c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a1 f20003d;

        public b0(a1 a1Var, Parcelable parcelable, ArrayList arrayList, c.a.p0.w2.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, parcelable, arrayList, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20003d = a1Var;
            this.a = parcelable;
            this.f20001b = arrayList;
            this.f20002c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20003d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.f20001b) <= 1 || this.f20002c.y().b() <= 0) {
                    return;
                }
                this.f20003d.I.f();
                this.f20003d.I.D(this.f20003d.f19988c.getString(R.string.obfuscated_res_0x7f0f0da8));
                this.f20003d.I.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public c(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.Z0.P(postData);
                this.a.C.Y();
                this.a.a1.c();
                this.a.k0.q();
                this.a.h3(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public c0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.a.f19988c != null && this.a.f19988c.isAdded()) {
                if (i < 0 && f2 > this.a.h1) {
                    this.a.d0();
                    this.a.T1();
                }
                this.a.k0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements FallingView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public d(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A3();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.m
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.D1.setTag(Boolean.FALSE);
                if (this.a.E1 == null) {
                    return;
                }
                this.a.E1.setAutoCompleteShown(false);
                if (this.a.E1.getVisibility() == 0) {
                    this.a.E1.setTag(this.a.D1);
                    this.a.E1.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public d0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.d0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a1 a1Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.C == null) {
                return;
            }
            this.a.C.Y();
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.s.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20004b;

        public e0(a1 a1Var, c.a.o0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20004b = a1Var;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a == null || this.f20004b.E0 == null || this.f20004b.E1 == null) {
                return;
            }
            this.f20004b.E1.g(this.a);
            this.f20004b.E1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public f(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y == null) {
                    this.a.o1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f0 a;

            public a(f0 f0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = f0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f19988c.HidenSoftKeyPad((InputMethodManager) this.a.a.f19988c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.f19989d);
                }
            }
        }

        public f0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.Y0 == null) {
                    this.a.Y0 = new a(this);
                }
                c.a.d.f.m.e.a().postDelayed(this.a.Y0, 150L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a1 a1Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.A0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
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
        public final /* synthetic */ a1 a;

        public h(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.s2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public i(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f11499c;
                if (obj instanceof c.a.o0.s.c.u) {
                    if (((c.a.o0.s.c.u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((c.a.o0.s.c.u) aVar.f11499c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.v1 == null) {
                            this.a.v1 = new PermissionJudgePolicy();
                        }
                        this.a.v1.clearRequestPermissionList();
                        this.a.v1.appendRequestPermission(this.a.f19988c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.v1.startRequestPermission(this.a.f19988c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.a.f19988c.O4().h((c.a.o0.s.c.u) aVar.f11499c);
                        this.a.f19988c.O4().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20005b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20006c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f20007d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a1 f20008e;

        public i0(a1 a1Var, int i, int i2, int i3, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20008e = a1Var;
            this.a = i;
            this.f20005b = i2;
            this.f20006c = i3;
            this.f20007d = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == this.f20005b || i - this.f20006c >= 0) {
                    this.f20008e.j1.showAsDropDown(this.f20008e.q0, this.f20007d.getLeft(), -this.f20008e.q0.getHeight());
                } else {
                    this.f20008e.j1.showAsDropDown(this.f20007d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public j(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.f19988c.H0 == null || this.a.f19988c.H0.e() == null) {
                return;
            }
            if (!this.a.f19988c.H0.e().e()) {
                this.a.f19988c.H0.a(false);
            }
            this.a.f19988c.H0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.k0 == null || this.a.k0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.m1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.k0.getId());
                a1 a1Var = this.a;
                a1Var.m1 = new c.a.p0.w2.m.f.j1.c(a1Var.f19988c.getPageContext(), this.a.f19989d, layoutParams);
                if (!ListUtils.isEmpty(this.a.l1)) {
                    this.a.m1.q(this.a.l1);
                }
                this.a.m1.r(this.a.k0);
            }
            this.a.m1.p(substring);
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.s.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20009b;

        public j0(a1 a1Var, c.a.o0.s.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20009b = a1Var;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.f20009b.E1.setHomePbFloatLastCloseTime();
                this.f20009b.j1();
                this.f20009b.E1.u(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20010b;

        public k(a1 a1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20010b = a1Var;
            this.a = z;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f20010b.Q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.f20010b.a2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                        return;
                    case 11:
                        if (this.f20010b.N1 != null) {
                            this.f20010b.N1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e88), sparseArray.get(R.id.obfuscated_res_0x7f091e76), sparseArray.get(R.id.obfuscated_res_0x7f091e79), sparseArray.get(R.id.obfuscated_res_0x7f091e77), sparseArray.get(R.id.obfuscated_res_0x7f091e78)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20010b.f19988c.a5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba), sparseArray);
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
        public final /* synthetic */ a1 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(a1 a1Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.H1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
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
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20011b;

        public l0(a1 a1Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20011b = a1Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20011b.A1 || this.a == null || this.f20011b.f19988c.w() == null || !this.f20011b.f19988c.w().A1()) {
                return;
            }
            this.f20011b.A1 = true;
            this.a.c4(false);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20012b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a1 f20013c;

        public m(a1 a1Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20013c = a1Var;
            this.a = alertDialog;
            this.f20012b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f20013c.f19988c.x(), R.string.obfuscated_res_0x7f0f0c15);
                } else {
                    this.f20013c.f19988c.n4(this.f20012b, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public m0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // c.a.p0.w2.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f19988c.d5();
            }
        }

        @Override // c.a.p0.w2.j.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.l == null) {
                return;
            }
            if (this.a.r != null) {
                this.a.r.t();
            }
            this.a.l.setSelection(0);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public n(a1 a1Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public n0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.f19988c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.f19988c.K5();
                if (this.a.f19988c == null || this.a.f19988c.w() == null || this.a.f19988c.w().S0() == null || this.a.f19988c.w().S0().O() == null || this.a.f19988c.w().S0().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.f19988c.w().l1()).param("fid", this.a.f19988c.w().S0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.f19988c.w().f34970b).param("fid", this.a.f19988c.w().S0().m()).param("obj_locate", 1).param("uid", this.a.f19988c.w().S0().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a1 f20015c;

        public o(a1 a1Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20015c = a1Var;
            this.a = alertDialog;
            this.f20014b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f20015c.f19988c.x(), R.string.obfuscated_res_0x7f0f0c15);
                } else {
                    this.f20015c.f19988c.n4(this.f20014b, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public o0(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e7c, 1);
                    this.a.f19988c.f4(sparseArray);
                    return;
                }
                this.a.f2(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e7c, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e65, 1);
                this.a.f19988c.f4(sparseArray);
            } else if (booleanValue3) {
                this.a.a2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public p(a1 a1Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class p0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f20016b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f20017c;

        public p0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements g.InterfaceC1200g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20018b;

        public q(a1 a1Var, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20018b = a1Var;
            this.a = aVar;
        }

        @Override // c.a.p0.l.g.InterfaceC1200g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20018b.f19988c.o4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20019b;

        public r(a1 a1Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20019b = a1Var;
            this.a = sparseArray;
        }

        @Override // c.a.p0.l.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20019b.f19988c.n4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public s(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.a0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.a0 != null && !str.equals(this.a.a0)) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a4.j0.a.f
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
        public final /* synthetic */ a1 a;

        public u(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.a.U instanceof Dialog)) {
                c.a.d.f.m.g.b(this.a.U, this.a.f19988c.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.InterfaceC0843c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20020b;

        public v(a1 a1Var, c.InterfaceC0843c interfaceC0843c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, interfaceC0843c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20020b = a1Var;
            this.a = interfaceC0843c;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f20020b.c0.dismiss();
                this.a.a(null, i, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.InterfaceC0843c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f20021b;

        public w(a1 a1Var, c.InterfaceC0843c interfaceC0843c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, interfaceC0843c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20021b = a1Var;
            this.a = interfaceC0843c;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f20021b.c0.dismiss();
                this.a.a(null, i, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public x(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.a.E0 == null || this.a.E0.O() == null || this.a.E0.O().getAuthor() == null || this.a.E0.O().getAuthor().getAlaInfo() == null || this.a.E0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.e1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.e1 && this.a.E0 != null && this.a.E0.O() != null && this.a.E0.O().getAuthor() != null && this.a.E0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.f19988c.x() != null) {
                        this.a.f19988c.x().mEvent.f20180b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.E0.m());
                statisticItem2.param("fname", this.a.E0.n());
                statisticItem2.param("obj_param1", this.a.E0.O().getAuthor().getAlaInfo().user_info != null ? this.a.E0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.E0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.E0.O().getAuthor().getAlaInfo()));
                if (this.a.E0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.E0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.E0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.f19988c.getPageContext(), this.a.E0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public y(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // c.a.p0.w2.m.f.i1.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.x.a(this.a.l);
                } else {
                    this.a.x.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a1 a;

        public z(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a1 a1Var;
            c.a.p0.w2.m.f.o1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.C == null || (cVar = (a1Var = this.a).f19993h) == null || cVar.i == null || a1Var.E0 == null || this.a.E0.O() == null || this.a.E0.O().isVideoThreadType() || this.a.E1() || this.a.E0.l() == null || c.a.d.f.p.m.isEmpty(this.a.E0.l().getName())) {
                return;
            }
            if ((this.a.C.I() == null || !this.a.C.I().isShown()) && (linearLayout = this.a.f19993h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.f19988c == null || this.a.f19988c.w() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.f19988c.w().k1());
                statisticItem.param("fid", this.a.f19988c.w().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218716053, "Lc/a/p0/w2/m/f/a1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218716053, "Lc/a/p0/w2/m/f/a1;");
                return;
            }
        }
        X1 = UtilHelper.getLightStatusBarHeight();
        Y1 = 3;
        Z1 = 0;
        a2 = 3;
        b2 = 4;
        c2 = 5;
        d2 = 6;
        e2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        f2 = new t();
    }

    public a1(PbFragment pbFragment, View.OnClickListener onClickListener, c.a.p0.w2.j.c cVar) {
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
        this.f19988c = null;
        this.f19989d = null;
        this.f19990e = null;
        this.f19991f = 0;
        this.f19992g = new Handler();
        this.l = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
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
        this.c0 = null;
        this.d0 = null;
        this.e0 = false;
        this.f0 = false;
        this.g0 = null;
        this.h0 = null;
        this.j0 = null;
        this.l0 = false;
        this.o0 = null;
        this.q0 = null;
        this.t0 = null;
        this.A0 = true;
        this.C0 = null;
        this.D0 = false;
        this.H0 = 3;
        this.I0 = false;
        this.J0 = null;
        this.S0 = 0;
        this.T0 = true;
        this.U0 = new p0();
        this.W0 = 0;
        this.c1 = false;
        this.d1 = 0;
        this.e1 = false;
        this.f1 = false;
        this.g1 = false;
        this.h1 = 0;
        this.p1 = false;
        this.w1 = 0L;
        this.z1 = 0;
        this.I1 = new k0(this, 2921306);
        this.J1 = new e(this, 2005016);
        this.K1 = new Handler();
        this.M1 = new g(this, 2004009);
        this.O1 = true;
        this.P1 = new x(this);
        this.Q1 = false;
        this.R1 = null;
        this.T1 = new ArrayList();
        this.V1 = false;
        this.w1 = System.currentTimeMillis();
        this.f19988c = pbFragment;
        this.N = onClickListener;
        this.i0 = cVar;
        this.h1 = c.a.d.f.p.n.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19988c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05f9, (ViewGroup) null);
        this.f19989d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.m0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0903da);
        this.r1 = (NavigationBarCoverTip) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091700);
        this.f19990e = this.f19989d.findViewById(R.id.obfuscated_res_0x7f091da5);
        this.F1 = (FrameLayout) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091ab2);
        this.B = (ObservedChangeRelativeLayout) this.f19989d.findViewById(R.id.obfuscated_res_0x7f092061);
        this.m = (NoNetworkView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0923d1);
        this.l = (PbLandscapeListView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091551);
        this.L0 = (FrameLayout) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091ae1);
        this.M0 = new TextView(this.f19988c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.f19988c.getActivity(), R.dimen.obfuscated_res_0x7f0702ff));
        this.l.x(this.M0, 0);
        this.l.setTextViewAdded(true);
        this.X0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.R0 = new View(this.f19988c.getPageContext().getPageActivity());
        if (c.a.o0.f1.b.b.d()) {
            this.R0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.R0.setLayoutParams(new AbsListView.LayoutParams(-1, this.X0));
        }
        this.R0.setVisibility(4);
        this.l.addFooterView(this.R0);
        this.l.setOnTouchListener(this.f19988c.D2);
        this.a = new l0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.f19993h = new c.a.p0.w2.m.f.o1.c(pbFragment, this.f19989d);
        if (this.f19988c.G4()) {
            ViewStub viewStub = (ViewStub) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091394);
            this.j = viewStub;
            viewStub.setVisibility(0);
            c.a.p0.w2.m.f.o1.b bVar = new c.a.p0.w2.m.f.o1.b(pbFragment);
            this.i = bVar;
            bVar.c();
            this.f19993h.a.setVisibility(8);
            layoutParams.height = c.a.d.f.p.n.f(this.f19988c.getActivity(), R.dimen.obfuscated_res_0x7f070235);
        }
        this.M0.setLayoutParams(layoutParams);
        this.f19993h.p().setOnTouchListener(new c.a.p0.w2.j.a(new m0(this)));
        this.p0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0923b6);
        this.q0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a4);
        c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.B0 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07027b);
        HeadImageView headImageView = (HeadImageView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a8);
        this.s0 = headImageView;
        headImageView.setVisibility(0);
        this.s0.setIsRound(true);
        this.s0.setBorderWidth(c.a.d.f.p.n.f(this.f19988c.getContext(), R.dimen.L_X01));
        this.s0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.s0.setPlaceHolder(0);
        M1();
        this.t0 = (TextView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a7);
        LinearLayout linearLayout = (LinearLayout) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a1);
        this.r0 = linearLayout;
        linearLayout.setOnClickListener(new n0(this));
        this.u0 = (ImageView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a5);
        this.C1 = (MaskView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0913b5);
        this.u0.setOnClickListener(this.N);
        boolean booleanExtra = this.f19988c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a3);
        this.v0 = imageView;
        imageView.setOnClickListener(this.N);
        if (booleanExtra) {
            this.v0.setVisibility(8);
        } else {
            this.v0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a9);
        this.w0 = imageView2;
        imageView2.setOnClickListener(this.N);
        this.x0 = new c.a.p0.w2.r.j(this.w0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.x0.e();
        }
        TextView textView = (TextView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916a6);
        this.y0 = textView;
        textView.setVisibility(0);
        this.J0 = (ViewStub) this.f19989d.findViewById(R.id.obfuscated_res_0x7f090f46);
        this.s = new c.a.p0.w2.m.f.i1.d(this.f19988c, cVar);
        this.u = new c.a.p0.w2.m.f.i1.h(this.f19988c, cVar, this.N);
        c.a.p0.w2.m.f.l lVar = new c.a.p0.w2.m.f.l(this.f19988c, this.l);
        this.C = lVar;
        lVar.t0(this.N);
        this.C.v0(this.i0);
        this.C.q0(this.O);
        this.C.s0(this.f19988c.c2);
        o0 o0Var = new o0(this);
        this.R = o0Var;
        this.C.p0(o0Var);
        s1();
        m1();
        c.a.p0.w2.m.f.i1.g gVar = new c.a.p0.w2.m.f.i1.g(this.f19988c);
        this.w = gVar;
        gVar.f20109f = 2;
        l1();
        this.x.a(this.l);
        this.t.a(this.l);
        this.u.j(this.l);
        this.s.a(this.l);
        PbListView pbListView = new PbListView(this.f19988c.getPageContext().getPageActivity());
        this.I = pbListView;
        this.K = pbListView.b().findViewById(R.id.obfuscated_res_0x7f0916f0);
        this.L = this.I.b().findViewById(R.id.obfuscated_res_0x7f091692);
        if (!this.I.i().booleanValue()) {
            this.L.setVisibility(8);
        }
        View view = this.K;
        if (view != null) {
            view.setOnClickListener(this.N);
            SkinManager.setBackgroundResource(this.K, R.drawable.pb_foot_more_trans_selector);
        }
        View view2 = this.L;
        if (view2 != null) {
            view2.setOnClickListener(this.N);
        }
        this.I.A();
        this.I.o(R.drawable.pb_foot_more_trans_selector);
        this.I.p(R.drawable.pb_foot_more_trans_selector);
        this.M = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0923ee);
        this.f19988c.registerListener(this.M1);
        this.Z0 = new PbFakeFloorModel(this.f19988c.getPageContext());
        PbModel w2 = this.f19988c.w();
        this.Z0.R(w2.H(), w2.D(), w2.E(), w2.C(), w2.I());
        c.a.p0.w2.m.f.x xVar = new c.a.p0.w2.m.f.x(this.f19988c.getPageContext(), this.Z0, this.f19989d);
        this.a1 = xVar;
        xVar.k(new b(this));
        this.a1.n(this.f19988c.g2);
        this.Z0.T(new c(this));
        if (this.f19988c.w() != null && !StringUtils.isNull(this.f19988c.w().V0())) {
            PbFragment pbFragment2 = this.f19988c;
            pbFragment2.showToast(pbFragment2.w().V0());
        }
        this.N0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0916ab);
        this.O0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f0903d5);
        View findViewById = this.f19989d.findViewById(R.id.obfuscated_res_0x7f091db2);
        this.P0 = findViewById;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (this.f19988c.w() != null && this.f19988c.w().F0()) {
            this.N0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.P0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = X1;
            this.P0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f19988c.getPageContext(), this.f19989d.findViewById(R.id.obfuscated_res_0x7f09171e));
        this.Q0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.k0);
        this.Q0.f34999g.setVisibility(8);
        this.Q0.q(this.N);
        this.Q0.p(this.f19988c.c2);
        this.f19988c.registerListener(this.J1);
        this.f19988c.registerListener(this.I1);
        PbFragment pbFragment3 = this.f19988c;
        this.B1 = new c.a.p0.w2.r.i(pbFragment3, pbFragment3.getUniqueId());
        this.D1 = (FallingView) this.f19989d.findViewById(R.id.obfuscated_res_0x7f09096d);
        y2();
        this.D1.setAnimationListener(new d(this));
        Y();
        r2(false);
        this.n0 = this.f19989d.findViewById(R.id.obfuscated_res_0x7f091698);
        X(c.a.o0.f1.b.b.d());
        if (UbsABTestHelper.isPbForumGuideTestA() && w2.E1() && c.a.p0.w2.e.b().e()) {
            if (this.p == null) {
                this.p = new c.a.p0.w2.m.f.b0(this.f19988c.getActivity(), (ViewGroup) a1().findViewById(R.id.obfuscated_res_0x7f0916ca));
            }
            c.a.p0.w2.m.f.a0 a0Var = new c.a.p0.w2.m.f.a0(this.l);
            this.q = a0Var;
            a0Var.d(new a0.a() { // from class: c.a.p0.w2.m.f.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.p0.w2.m.f.a0.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a1.this.J1();
                    }
                }
            });
        }
    }

    public TextView A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u.n() : (TextView) invokeV.objValue;
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
            this.l0 = z2;
        }
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FallingView fallingView = this.D1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.E1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.D1) {
                this.E1.setTag(null);
                this.E1.setAutoCompleteShown(true);
                this.E1.d();
            }
        }
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.w2.r.j jVar = this.x0;
            if (jVar != null) {
                return jVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.R1) : invokeV.booleanValue;
    }

    public void B2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.C.g0(z2);
        }
    }

    public void B3() {
        c.a.p0.w2.r.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jVar = this.x0) == null) {
            return;
        }
        jVar.m(2);
    }

    public PbInterviewStatusView C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.K0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean C1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData w0 = w0(this.E0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (w0 == null || w0.s() == null) ? "" : w0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void C2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.x1 = z2;
        }
    }

    public void C3(c.a.o0.r.r.z0 z0Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, z0Var, eVar) == null) || z0Var == null) {
            return;
        }
        int a3 = z0Var.a();
        int h2 = z0Var.h();
        c.a.o0.r.t.a aVar = this.D;
        if (aVar != null) {
            aVar.show();
        } else {
            this.D = new c.a.o0.r.t.a(this.f19988c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19988c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0234, (ViewGroup) null);
            this.F = inflate;
            this.D.setContentView(inflate);
            this.D.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, eVar);
            this.D.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new d0(this));
            this.D.setOnCalcelListener(new f0(this));
            this.D.create(this.f19988c.getPageContext()).show();
        }
        EditText editText = (EditText) this.F.findViewById(R.id.obfuscated_res_0x7f090efe);
        this.G = editText;
        editText.setText("");
        TextView textView = (TextView) this.F.findViewById(R.id.obfuscated_res_0x7f090733);
        if (a3 <= 0) {
            a3 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0460), Integer.valueOf(a3), Integer.valueOf(h2)));
        this.f19988c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.G, 150);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p1 : invokeV.booleanValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View view = this.R0;
            if (view == null || view.getParent() == null || this.I.m()) {
                return false;
            }
            int bottom = this.R0.getBottom();
            Rect rect = new Rect();
            this.R0.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void D2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.p1 = z2;
        }
    }

    public void D3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || this.l == null || (textView = this.M0) == null || this.f19990e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f19990e.setVisibility(0);
            } else {
                this.f19990e.setVisibility(8);
                this.l.removeHeaderView(this.M0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.M0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = X1;
                this.M0.setLayoutParams(layoutParams);
            }
            t2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + J0(true);
            this.M0.setLayoutParams(layoutParams2);
        }
        t2();
        n2();
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.r != null) {
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
            c.a.p0.w2.i.f fVar = this.E0;
            return fVar == null || fVar.l() == null || "0".equals(this.E0.l().getId()) || "me0407".equals(this.E0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void E2(boolean z2) {
        c.a.p0.w2.m.f.i1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || (iVar = this.r) == null) {
            return;
        }
        iVar.r(z2);
    }

    public final void E3(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || fVar == null || fVar.O() == null || fVar.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = fVar.O().getIs_good() == 1;
        boolean z3 = fVar.O().getIs_top() == 1;
        c.a.p0.w2.m.f.i1.h hVar = this.u;
        if (hVar != null) {
            hVar.l(fVar, z2, z3);
        }
        c.a.p0.w2.m.f.l lVar = this.C;
        if (lVar == null || lVar.t() == null) {
            return;
        }
        this.C.t().e(fVar, z2, z3);
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
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void F2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.C.i0(z2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void F3(c.a.p0.w2.i.f fVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z2) == null) || fVar == null) {
            return;
        }
        O3(fVar, z2);
        g0();
    }

    public SparseArray<Object> G0(c.a.p0.w2.i.f fVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData w0;
        c.a.o0.r.r.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (fVar == null || (w0 = w0(fVar, z2)) == null) {
                return null;
            }
            String userId = w0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e6b, w0.G());
                sparseArray.put(R.id.obfuscated_res_0x7f091e6d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
            } else if (i2 == 1) {
                if (w0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e76, w0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e77, w0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e78, w0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e79, w0.G());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e6b, w0.G());
                sparseArray.put(R.id.obfuscated_res_0x7f091e6d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(fVar.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
            }
            if (!z3) {
                List<x1> p2 = fVar.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (x1 x1Var : p2) {
                        if (x1Var != null && !StringUtils.isNull(x1Var.a()) && (e0Var = x1Var.f10996g) != null && e0Var.a && !e0Var.f10845c && ((i3 = e0Var.f10844b) == 1 || i3 == 2)) {
                            sb.append(c.a.d.f.p.m.cutString(x1Var.a(), 12));
                            sb.append(this.f19988c.getString(R.string.obfuscated_res_0x7f0f063c));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e6a, String.format(this.f19988c.getString(R.string.obfuscated_res_0x7f0f0486), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.G1 : invokeV.booleanValue;
    }

    public void G2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.C.n0(z2);
        }
    }

    public void G3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f19988c.showToast(str);
        }
    }

    public c.a.p0.w2.m.e.a H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n1 : (c.a.p0.w2.m.e.a) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            c.a.p0.w2.r.j jVar = this.x0;
            if (jVar == null) {
                return false;
            }
            return jVar.h();
        }
        return invokeV.booleanValue;
    }

    public void H2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, gVar) == null) {
            this.S1 = gVar;
            c.a.p0.w2.r.k kVar = this.H;
            if (kVar != null) {
                kVar.f(gVar);
            }
        }
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f19988c.showProgressBar();
        }
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.L : (View) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void I2(String str) {
        c.a.p0.w2.m.f.o1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void I3() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (fallingView = this.D1) == null) {
            return;
        }
        fallingView.C();
    }

    public final int J0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.K0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void J1() {
        this.l.post(new Runnable() { // from class: c.a.p0.w2.m.f.d
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a1.this.K1();
                }
            }
        });
    }

    public void J2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            this.c1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.d1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.T1 == null) {
            return;
        }
        while (this.T1.size() > 0) {
            TbImageView remove = this.T1.remove(0);
            if (remove != null) {
                remove.N();
            }
        }
    }

    public View K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.K : (View) invokeV.objValue;
    }

    public /* synthetic */ void K1() {
        c.a.p0.w2.m.f.b0 b0Var = this.p;
        if (b0Var != null) {
            b0Var.p();
        }
    }

    public void K2(PbFragment.d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, d3Var) == null) {
        }
    }

    public void K3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.e0 = z2;
        }
    }

    public PbListView L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.I : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void L1() {
        String S0;
        PbFragment pbFragment = this.f19988c;
        if (pbFragment != null && pbFragment.w() != null && this.f19988c.w().x1()) {
            S0 = this.f19988c.getString(R.string.obfuscated_res_0x7f0f0dbd);
        } else {
            S0 = S0();
        }
        if (!StringUtils.isNull(S0) && this.E0 != null) {
            S0 = TbSingleton.getInstance().getAdVertiComment(this.E0.k0(), this.E0.l0(), S0);
        }
        PbFragment pbFragment2 = this.f19988c;
        if (pbFragment2 != null && pbFragment2.O4() != null) {
            this.f19988c.O4().k0(S0);
        }
        TextView textView = this.t0;
        if (textView != null) {
            textView.setText(S0);
        }
        h3(false);
        A3();
    }

    public void L2(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, yVar) == null) {
            this.O = yVar;
            this.C.q0(yVar);
            this.n1.q(this.O);
        }
    }

    public void L3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) {
            this.f19993h.H(z2);
            if (z2 && this.I0) {
                this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03d8));
                this.l.setNextPage(this.I);
                this.f19991f = 2;
            }
            M1();
        }
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            try {
                return Integer.parseInt(this.G.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.s0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.s0.setImageResource(0);
                this.s0.J(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.s0.setImageResource(R.drawable.obfuscated_res_0x7f081200);
        }
    }

    public void M2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bVar) == null) {
            this.P = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void M3(c.a.p0.w2.i.d dVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f19993h.I();
        if (!StringUtils.isNull(dVar.f19811b)) {
            this.f19993h.F(dVar.f19811b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1393);
        int e3 = c.a.d.f.m.b.e(dVar.a, 0);
        if (e3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10d6);
        } else if (e3 != 300) {
            string = e3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1310);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02e5);
        }
        this.f19988c.showNetRefreshView(this.f19989d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0292), true, new a0(this, dVar.f19812c));
    }

    public View N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.N0 : (View) invokeV.objValue;
    }

    public void N1() {
        c.a.p0.w2.m.f.a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (a0Var = this.q) == null) {
            return;
        }
        a0Var.b();
    }

    public void N2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void N3(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fVar) == null) {
            if (fVar != null && AntiHelper.o(fVar.O())) {
                c.a.p0.w2.r.j jVar = this.x0;
                if (jVar != null) {
                    jVar.k(false);
                    this.x0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.w0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.w0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080926, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.p0.w2.r.j jVar2 = this.x0;
            if (jVar2 == null || !jVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.w0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.w0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f080926, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public PbFakeFloorModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.Z0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void O1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || this.H0 == i2) {
            return;
        }
        this.H0 = i2;
        F3(this.E0, this.D0);
        m2(this.E0, this.D0, this.G0, i2);
        this.f19988c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f19988c.getBaseFragmentActivity().getLayoutMode().j(this.f19989d);
        SkinManager.setBackgroundColor(this.f19989d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0203);
        c.a.p0.w2.m.f.i1.i iVar = this.r;
        if (iVar != null) {
            iVar.h(i2);
        }
        c.a.p0.w2.m.f.i1.e eVar = this.v;
        if (eVar != null) {
            eVar.c(i2);
        }
        c.a.p0.w2.m.f.i1.d dVar = this.s;
        if (dVar != null) {
            dVar.e(i2);
        }
        c.a.p0.w2.m.f.i1.f fVar = this.t;
        if (fVar != null) {
            fVar.c(i2);
        }
        c.a.p0.w2.m.f.i1.h hVar = this.u;
        if (hVar != null) {
            hVar.t(i2);
        }
        c.a.p0.w2.m.f.i1.g gVar = this.w;
        if (gVar != null) {
            gVar.d();
        }
        c.a.p0.w2.m.f.i1.c cVar = this.x;
        if (cVar != null) {
            cVar.c();
        }
        MaskView maskView = this.C1;
        if (maskView != null) {
            maskView.f();
        }
        PbListView pbListView = this.I;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.K != null) {
            this.f19988c.getBaseFragmentActivity().getLayoutMode().j(this.K);
            SkinManager.setBackgroundResource(this.K, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.L != null) {
            this.f19988c.getBaseFragmentActivity().getLayoutMode().j(this.L);
            SkinManager.setBackgroundResource(this.L, R.drawable.pb_foot_more_trans_selector);
        }
        c.a.o0.r.t.a aVar = this.D;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f19988c.getPageContext());
        }
        K3(this.e0);
        this.C.Y();
        c.a.p0.w2.r.k kVar = this.H;
        if (kVar != null) {
            kVar.H(i2);
        }
        EditorTools editorTools = this.k0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        c.a.p0.w2.r.g gVar2 = this.J;
        if (gVar2 != null) {
            gVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        P3();
        UtilHelper.setStatusBarBackground(this.f19990e, i2);
        UtilHelper.setStatusBarBackground(this.P0, i2);
        if (this.y != null) {
            c.a.o0.w0.a.a(this.f19988c.getPageContext(), this.y);
        }
        c.a.p0.w2.m.f.x xVar = this.a1;
        if (xVar != null) {
            xVar.h(i2);
        }
        c.a.p0.w2.m.f.o1.c cVar2 = this.f19993h;
        if (cVar2 != null) {
            c.a.p0.w2.m.f.i1.i iVar2 = this.r;
            if (iVar2 != null) {
                iVar2.i(i2);
            } else {
                cVar2.u(i2);
            }
        }
        HeadImageView headImageView = this.s0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.r0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(this.f19988c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        c.a.p0.w2.i.f fVar2 = this.E0;
        if (fVar2 != null && fVar2.r()) {
            WebPManager.setPureDrawable(this.v0, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.v0, R.drawable.obfuscated_res_0x7f080921, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.u0, R.drawable.obfuscated_res_0x7f080924, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        N3(this.E0);
        SkinManager.setBackgroundColor(this.q0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.k1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.z0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.y0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.y0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        c.a.p0.w2.m.e.a aVar2 = this.n1;
        if (aVar2 != null) {
            aVar2.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.V0;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        c.a.p0.w2.r.j jVar = this.x0;
        if (jVar != null) {
            jVar.i();
        }
        c.a.p0.w2.r.i iVar3 = this.B1;
        if (iVar3 != null) {
            iVar3.c();
        }
        RightFloatLayerView rightFloatLayerView = this.E1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.O0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.O0.findViewById(R.id.obfuscated_res_0x7f09221e), (int) R.color.CAM_X0105);
    }

    public void O2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public boolean O3(c.a.p0.w2.i.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048635, this, fVar, z2)) == null) {
            if (fVar == null) {
                return false;
            }
            if (this.t != null) {
                if (fVar.O() != null && fVar.O().getIsNoTitle() == 0 && !fVar.O().isVideoThreadType() && !this.G1) {
                    if (fVar.O() != null) {
                        ThreadData O = fVar.O();
                        O.parserSpecTitleForFrsAndPb(true, k3(fVar));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (fVar.O().isBJHArticleThreadType()) {
                        this.u.w(this.l);
                        this.t.d(this.l);
                        this.t.a(this.l);
                        this.u.j(this.l);
                        this.u.A(this.E0);
                        if (w1(fVar)) {
                            this.t.d(this.l);
                        } else {
                            this.t.e(fVar);
                        }
                    } else {
                        this.u.A(this.E0);
                        if (w1(fVar)) {
                            this.t.d(this.l);
                        } else {
                            this.t.g(fVar);
                        }
                    }
                } else if (fVar.O().getIsNoTitle() == 1) {
                    if (fVar.O() != null) {
                        this.t.d(this.l);
                        this.u.A(this.E0);
                    }
                } else {
                    this.t.d(this.l);
                    this.u.A(this.E0);
                }
            }
            E3(fVar);
            this.D0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public c.a.p0.w2.m.f.x P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.a1 : (c.a.p0.w2.m.f.x) invokeV.objValue;
    }

    public void P1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, configuration) == null) || configuration == null) {
            return;
        }
        d0();
        if (configuration.orientation == 2) {
            c1();
            e1();
        } else {
            s2();
        }
        c.a.p0.w2.m.f.x xVar = this.a1;
        if (xVar != null) {
            xVar.c();
        }
        this.f19988c.d5();
        this.B.setVisibility(8);
        this.f19993h.B(false);
        this.f19988c.Y5(false);
        if (this.r != null) {
            if (configuration.orientation == 1) {
                Z0().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.W1 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.W1 = false;
                this.l.setIsLandscape(false);
                int i2 = this.U1;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
                }
            }
            this.r.j(configuration);
            this.L0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void P2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onClickListener) == null) {
            this.C.u0(onClickListener);
        }
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && this.f19988c.G4()) {
            if (this.f19988c.L4() == -1) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0110, 1);
            }
            if (this.f19988c.K4() == -1) {
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0110, 1);
            }
        }
    }

    public c.a.p0.w2.m.f.i1.i Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.r : (c.a.p0.w2.m.f.i1.i) invokeV.objValue;
    }

    public void Q1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            c.a.p0.w2.m.f.b0 b0Var = this.p;
            if (b0Var != null) {
                b0Var.l();
            }
            RelativeLayout relativeLayout = this.f19989d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f19989d.getHandler().removeCallbacksAndMessages(null);
            }
            c.a.p0.w2.r.j jVar = this.x0;
            if (jVar != null) {
                jVar.j();
            }
            v0 v0Var = this.b1;
            if (v0Var != null) {
                v0Var.a();
            }
            c.a.p0.w2.m.f.n0 n0Var = this.q1;
            if (n0Var != null) {
                n0Var.c();
            }
            PbTopTipView pbTopTipView = this.i1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f19988c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.P) != null) {
                noNetworkView.d(bVar);
            }
            d0();
            j0();
            if (this.Y0 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.Y0);
            }
            PbInterviewStatusView pbInterviewStatusView = this.K0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.K1 = null;
            this.f19992g.removeCallbacksAndMessages(null);
            this.C.Z(3);
            View view = this.f19990e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.a();
            }
            c.a.p0.w2.m.f.l lVar = this.C;
            if (lVar != null) {
                lVar.a0();
            }
            this.l.setOnLayoutListener(null);
            c.a.p0.w2.m.f.j1.c cVar = this.m1;
            if (cVar != null) {
                cVar.l();
            }
            PbEmotionBar pbEmotionBar = this.V0;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            c.a.p0.w2.m.f.i1.h hVar = this.u;
            if (hVar != null) {
                hVar.u();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void Q2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.y1 = i2;
        }
    }

    public void Q3(c.a.p0.w2.i.f fVar) {
        c.a.p0.w2.m.f.i1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) || (dVar = this.s) == null) {
            return;
        }
        dVar.h(fVar, this.D0);
    }

    public final boolean R(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048644, this, absListView, i2)) == null) {
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

    public final PostData R0(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null || fVar.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = fVar.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = fVar.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.n0(1);
            postData.r0(fVar.O().getFirstPostId());
            postData.D0(fVar.O().getTitle());
            postData.C0(fVar.O().getCreateTime());
            postData.l0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void R1(TbRichText tbRichText) {
        c.a.p0.w2.i.f fVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048646, this, tbRichText) == null) || (fVar = this.E0) == null || fVar.F() == null || this.E0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.E0.F().size() && (postData = this.E0.F().get(i2)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i2++) {
            if (this.E0.F().get(i2).s().getUserId().equals(tbRichText.getAuthorId())) {
                c.a.p0.w2.m.e.a aVar = this.n1;
                if (aVar != null && aVar.l()) {
                    h3(false);
                }
                PbEmotionBar pbEmotionBar = this.V0;
                if (pbEmotionBar != null) {
                    pbEmotionBar.q(true);
                }
                postData.s().getName_show();
                return;
            }
        }
    }

    public void R2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onLongClickListener) == null) {
            this.u.x(onLongClickListener);
            this.C.r0(onLongClickListener);
            c.a.p0.w2.m.e.a aVar = this.n1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
        }
    }

    public void S() {
        c.a.p0.w2.r.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (jVar = this.x0) == null) {
            return;
        }
        jVar.l(false);
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (!c.a.d.f.p.m.isEmpty(this.u1)) {
                return this.u1;
            }
            if (this.f19988c != null) {
                this.u1 = TbadkCoreApplication.getInst().getResources().getString(y0.b());
            }
            return this.u1;
        }
        return (String) invokeV.objValue;
    }

    public boolean S1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i2)) == null) {
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void S2(PostData postData, c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, postData, fVar) == null) {
            this.u.y(postData, fVar);
        }
    }

    public boolean T(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048652, this, z2)) == null) {
            EditorTools editorTools = this.k0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.k0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final int T0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.b().getTop() != 0 || pbReplyTitleViewHolder.b().isShown()) {
                return pbReplyTitleViewHolder.b().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void T1() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || this.f19988c == null) {
            return;
        }
        if ((this.x1 || this.y1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            c.a.p0.w2.i.f fVar = this.E0;
            if (fVar == null || fVar.l() == null || c.a.d.f.p.m.isEmpty(this.E0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19988c.getContext()).createNormalCfg(this.E0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.E0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.E0.l().getId()));
        } else if (!this.f1 || this.e1 || (postData = this.F0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f19988c.isSimpleForum() ? 2 : 1).param("obj_type", this.e1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19988c.getPageContext().getPageActivity(), this.F0.s().getUserId(), this.F0.s().getUserName(), this.f19988c.w().s0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void T2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048655, this, z2, postWriteCallBackData) == null) {
            this.f19988c.hideProgressBar();
            if (z2) {
                d0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                e0();
            } else {
                d0();
            }
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbListView pbListView = this.I;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.I.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
        }
        return invokeV.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? R.id.obfuscated_res_0x7f091a8a : invokeV.intValue;
    }

    public void U1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            if (z2) {
                n3();
            } else {
                f1();
            }
            this.U0.f20017c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.U0));
            h2(this.U0.f20017c, false);
        }
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.f19988c.hideProgressBar();
            c.a.p0.w2.i.f fVar = this.E0;
            if (fVar != null && this.I != null && fVar.y() != null && this.E0.y().b() == 0) {
                this.I.v(this.E0.t());
                if (this.E0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.E0.m());
                    statisticItem.param("fname", this.E0.n());
                    statisticItem.param("tid", this.E0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            j0();
            this.l.A(0L);
            g0();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || this.E0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || c.a.p0.w2.m.f.n1.b.k(this.E0.Q())) {
            return;
        }
        this.x0.e();
        c.a.p0.w2.m.f.n1.b.b(this.E0.Q());
    }

    public final int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            J3();
            this.C.Z(1);
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.l();
            }
            c.a.p0.w2.m.f.b0 b0Var = this.p;
            if (b0Var != null) {
                b0Var.k();
            }
            RightFloatLayerView rightFloatLayerView = this.E1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void V2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || (pbFragment = this.f19988c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        c.a.d.f.p.n.w(this.f19988c.getPageContext().getPageActivity(), this.f19988c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if (!this.f19988c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.h0));
            } else if (this.f19988c.g4()) {
                c.a.o0.w.y.e O4 = this.f19988c.O4();
                if (O4 != null && (O4.B() || O4.D())) {
                    this.f19988c.O4().z(false, null);
                    return;
                }
                if (this.k0 != null) {
                    p1();
                }
                EditorTools editorTools = this.k0;
                if (editorTools != null) {
                    this.A0 = false;
                    if (editorTools.n(2) != null) {
                        c.a.p0.a4.j0.a.c(this.f19988c.getPageContext(), (View) this.k0.n(2).k, false, f2);
                    }
                }
                c1();
            }
        }
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            this.C.Z(2);
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f19988c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19988c.getFragmentActivity())) {
                    return;
                }
                a1().setSystemUiVisibility(4);
            }
        }
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.I.A();
            this.I.R();
        }
    }

    public void X(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view = this.n0;
            if (view != null) {
                view.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.L(z2 ? 8 : 0);
            }
            View view2 = this.K;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.f19990e : (View) invokeV.objValue;
    }

    public void X1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        c.a.p0.w2.m.f.i1.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048670, this, absListView, i2, i3, i4) == null) {
            c.a.p0.w2.m.f.a0 a0Var = this.q;
            if (a0Var != null) {
                a0Var.c(i2, i3);
            }
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            c.a.p0.w2.m.f.o1.c cVar = this.f19993h;
            if (cVar != null && (hVar = this.u) != null) {
                cVar.w(hVar.o());
            }
            p0 p0Var = this.U0;
            p0Var.a = i2;
            p0Var.f20016b = this.l.getHeaderViewsCount();
            this.U0.f20017c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.U0));
            g3(R(absListView, i2));
            int i5 = 0;
            h2(this.U0.f20017c, false);
            c0();
            if (!this.I.n() || this.I.C) {
                return;
            }
            p0 p0Var2 = this.U0;
            if (p0Var2 != null && (pbReplyTitleViewHolder = p0Var2.f20017c) != null && pbReplyTitleViewHolder.b() != null) {
                i5 = this.U0.f20017c.b().getTop() < 0 ? this.U0.f20017c.b().getHeight() : this.U0.f20017c.b().getBottom();
            }
            this.I.e(i5);
            this.I.C = true;
        }
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z2) == null) {
            this.u.z(z2);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            c.a.p0.w2.m.e.a aVar = new c.a.p0.w2.m.e.a(this.f19988c, this, (ViewStub) this.f19989d.findViewById(R.id.obfuscated_res_0x7f091445));
            this.n1 = aVar;
            aVar.o(this.N);
            this.n1.p(this.R);
            this.n1.q(this.O);
            this.n1.o(this.N);
            this.n1.s(this.i0);
        }
    }

    public PbThreadPostView Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void Y1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048674, this, absListView, i2) == null) {
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.W1 && i2 == 0) {
                this.U1 = V0();
                this.U0.f20017c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.U0));
                h2(this.U0.f20017c, true);
                c0();
                this.C.e0(true);
            }
            this.C.d0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.E1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.E1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.E1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void Y2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            this.t0.performClick();
            if (StringUtils.isNull(str) || this.f19988c.O4() == null || this.f19988c.O4().v() == null || this.f19988c.O4().v().h() == null) {
                return;
            }
            EditText h2 = this.f19988c.O4().v().h();
            h2.setText(str);
            h2.setSelection(str.length());
        }
    }

    public final CustomBlueCheckRadioButton Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048676, this, str, str2)) == null) {
            Activity pageActivity = this.f19988c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.n.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.X);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.B : (RelativeLayout) invokeV.objValue;
    }

    public void Z1(ArrayList<c.a.o0.r.r.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, arrayList) == null) {
            if (this.V == null) {
                this.V = LayoutInflater.from(this.f19988c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f1, (ViewGroup) null);
            }
            this.f19988c.getBaseFragmentActivity().getLayoutMode().j(this.V);
            if (this.U == null) {
                Dialog dialog = new Dialog(this.f19988c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039e);
                this.U = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.U.setCancelable(true);
                this.j0 = (ScrollView) this.V.findViewById(R.id.obfuscated_res_0x7f090cd8);
                this.U.setContentView(this.V);
                WindowManager.LayoutParams attributes = this.U.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d4);
                this.U.getWindow().setAttributes(attributes);
                this.X = new s(this);
                this.W = (LinearLayout) this.V.findViewById(R.id.obfuscated_res_0x7f090cd7);
                TextView textView = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090798);
                this.Z = textView;
                textView.setOnClickListener(new u(this));
                TextView textView2 = (TextView) this.V.findViewById(R.id.obfuscated_res_0x7f090799);
                this.Y = textView2;
                textView2.setOnClickListener(this.N);
            }
            this.W.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton Z = Z("0", this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1398));
            this.n.add(Z);
            Z.setChecked(true);
            this.W.addView(Z);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.o0.r.r.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton Z2 = Z(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(Z2);
                        View view = new View(this.f19988c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.W.addView(view);
                        this.W.addView(Z2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.j0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f19988c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f19988c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.n.d(this.f19988c.getPageContext().getPageActivity(), 186.0f);
                }
                this.j0.setLayoutParams(layoutParams2);
                this.j0.removeAllViews();
                LinearLayout linearLayout = this.W;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.j0.addView(this.W);
                }
            }
            c.a.d.f.m.g.j(this.U, this.f19988c.getPageContext());
        }
    }

    public void Z2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048681, this) == null) || this.V1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.V1 = true;
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f19988c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(Z1, Integer.valueOf(b2));
        aVar.setTitle(R.string.obfuscated_res_0x7f0f07cb);
        View inflate = LayoutInflater.from(this.f19988c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0862, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c28)).setText(R.string.obfuscated_res_0x7f0f0773);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09205f)).setText(R.string.obfuscated_res_0x7f0f07cb);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f07ca, this.f19988c);
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0a5a, new g0(this));
        aVar.create(this.f19988c.getPageContext()).show();
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.f19989d : (View) invokeV.objValue;
    }

    public void a2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            b2(i2, str, i3, z2, null);
        }
    }

    public void a3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, list) == null) {
            this.l1 = list;
            c.a.p0.w2.m.f.j1.c cVar = this.m1;
            if (cVar != null) {
                cVar.q(list);
            }
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f19988c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19988c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0862, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09205f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c28)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(Z1, Integer.valueOf(c2));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f14fc, this.f19988c);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new h0(this));
            aVar.create(this.f19988c.getPageContext()).show();
        }
    }

    public void b1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.L0.setVisibility(8);
            }
            c.a.p0.w2.m.f.o1.c cVar = this.f19993h;
            if (cVar == null || (view = cVar.f20282d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void b2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            c2(i2, str, i3, z2, str2, false);
        }
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            PbFragment pbFragment = this.f19988c;
            return (pbFragment == null || pbFragment.w().S0().l().getDeletedReasonInfo() == null || 1 != this.f19988c.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.z1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0() {
        c.a.p0.w2.r.i iVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048689, this) == null) || (iVar = this.B1) == null) {
            return;
        }
        if (((iVar.a() == null || this.B1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.B1.a())) != -1) {
            if (this.B1.a().getTop() + e2 <= this.N0.getBottom()) {
                this.z1 = 1;
                z2 = true;
            } else {
                this.z1 = 0;
                z2 = false;
            }
        }
        this.Q0.t(this.z1 == 1);
        this.B1.e(z2);
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || this.q0 == null) {
            return;
        }
        this.p0.setVisibility(8);
        this.q0.setVisibility(8);
        this.A0 = false;
        PbEmotionBar pbEmotionBar = this.V0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            r2(false);
        }
    }

    public void c2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048691, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z2));
            sparseArray.put(Z1, Integer.valueOf(a2));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0483 : R.string.obfuscated_res_0x7f0f0f9f;
            int i5 = R.string.obfuscated_res_0x7f0f0422;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f0487;
                    i4 = R.string.obfuscated_res_0x7f0f0488;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fa3;
                }
            }
            this.S = new c.a.o0.r.t.a(this.f19988c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.S.setMessageId(i4);
            } else {
                this.S.setOnlyMessageShowCenter(false);
                this.S.setMessage(str2);
            }
            this.S.setYesButtonTag(sparseArray);
            this.S.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, this.f19988c);
            this.S.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new l(this));
            this.S.setCancelable(true);
            this.S.create(this.f19988c.getPageContext());
            if (z3) {
                j3(sparseArray, i5, i4);
            } else if (z2) {
                j3(sparseArray, i5, i4);
            } else if (b3()) {
                c.a.p0.l.i iVar = new c.a.p0.l.i(this.f19988c.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19988c.w().S0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19988c.w().S0().o().has_forum_rule.intValue());
                iVar.i(this.f19988c.w().S0().l().getId(), this.f19988c.w().S0().l().getName());
                iVar.h(this.f19988c.w().S0().l().getImage_url());
                iVar.j(this.f19988c.w().S0().l().getUser_level());
                q3(sparseArray, i2, iVar, this.f19988c.w().S0().U(), false);
            } else {
                y3(this.S, i2);
            }
        }
    }

    public void c3() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.L0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c.a.p0.w2.m.f.o1.c cVar = this.f19993h;
            if (cVar == null || (view = cVar.f20282d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.f19993h.k();
            c.a.p0.w2.m.f.i1.h hVar = this.u;
            if (hVar != null) {
                hVar.m();
            }
            PbFragment pbFragment = this.f19988c;
            if (pbFragment != null) {
                c.a.d.f.p.n.w(pbFragment.getContext(), this.G);
            }
            e1();
            c.a.o0.r.t.j jVar = this.b0;
            if (jVar != null) {
                jVar.dismiss();
            }
            h0();
            c.a.o0.r.t.a aVar = this.D;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.o0.r.t.c cVar = this.E;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) || this.q0 == null || this.t0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        c.a.p0.w2.i.f fVar = this.E0;
        boolean z3 = fVar != null && fVar.k0();
        c.a.p0.w2.i.f fVar2 = this.E0;
        this.t0.setText(tbSingleton.getAdVertiComment(z3, fVar2 != null && fVar2.l0(), S0()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.q0.startAnimation(alphaAnimation);
        }
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.A0 = true;
        if (this.V0 == null || this.n1.l()) {
            return;
        }
        this.V0.setVisibility(0);
        r2(true);
    }

    public void d2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z2));
            sparseArray.put(Z1, Integer.valueOf(a2));
            if (z2) {
                e3(sparseArray);
            } else {
                f3(i2, sparseArray);
            }
        }
    }

    public void d3() {
        c.a.p0.w2.m.f.i1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || (iVar = this.r) == null) {
            return;
        }
        iVar.u(this.l);
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            this.f19993h.k();
            c.a.p0.w2.m.f.i1.h hVar = this.u;
            if (hVar != null) {
                hVar.m();
            }
            c.a.o0.r.t.j jVar = this.b0;
            if (jVar != null) {
                jVar.dismiss();
            }
            h0();
            c.a.o0.r.t.a aVar = this.D;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.o0.r.t.c cVar = this.E;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void e1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.o();
        c.a.p0.w2.m.f.j1.c cVar = this.m1;
        if (cVar != null) {
            cVar.m();
        }
    }

    public void e2(SparseArray<Object> sparseArray, boolean z2) {
        c.a.o0.r.t.h hVar;
        c.a.o0.r.t.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048699, this, sparseArray, z2) == null) {
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.f19988c.getContext());
            lVar.q(this.f19988c.getString(R.string.obfuscated_res_0x7f0f02d3));
            lVar.n(new k(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e65)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e6b)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e6d) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue() : -1) == 0) {
                    hVar2 = new c.a.o0.r.t.h(10, this.f19988c.getString(R.string.obfuscated_res_0x7f0f0499), lVar);
                } else {
                    hVar2 = new c.a.o0.r.t.h(10, this.f19988c.getString(R.string.obfuscated_res_0x7f0f048e), lVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                hVar2.f11053d.setTag(sparseArray2);
                arrayList.add(hVar2);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e76)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e77))) && !G1()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e79, sparseArray.get(R.id.obfuscated_res_0x7f091e79));
                c.a.o0.r.t.h hVar3 = new c.a.o0.r.t.h(11, this.f19988c.getString(R.string.obfuscated_res_0x7f0f0636), lVar);
                hVar3.f11053d.setTag(sparseArray3);
                arrayList.add(hVar3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eb8, sparseArray.get(R.id.obfuscated_res_0x7f091eb8));
                if (z2) {
                    hVar = new c.a.o0.r.t.h(12, this.f19988c.getString(R.string.obfuscated_res_0x7f0f1460), lVar);
                } else {
                    hVar = new c.a.o0.r.t.h(12, this.f19988c.getString(R.string.obfuscated_res_0x7f0f0b13), lVar);
                }
                hVar.f11053d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            c.a.p0.w2.m.f.n1.a.e(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                lVar.k(arrayList, false);
            } else {
                lVar.k(arrayList, true);
            }
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.f19988c.getPageContext(), lVar);
            this.Q = jVar;
            jVar.m();
        }
    }

    public final void e3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, sparseArray) == null) || this.f19988c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e7f, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1152, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.f19988c.x());
        oVar.v(R.string.obfuscated_res_0x7f0f0b0f);
        oVar.l(R.string.obfuscated_res_0x7f0f0b10);
        oVar.n(true);
        oVar.r(aVar2, aVar);
        oVar.i(false);
        AlertDialog y2 = oVar.y();
        aVar.a(new o(this, y2, sparseArray));
        aVar2.a(new p(this, y2));
    }

    public void f0() {
        c.a.p0.w2.r.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (jVar = this.x0) == null) {
            return;
        }
        jVar.k(false);
    }

    public void f1() {
        c.a.p0.w2.m.f.o1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048702, this) == null) || (cVar = this.f19993h) == null) {
            return;
        }
        cVar.q();
    }

    public void f2(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        e2(sparseArray, false);
    }

    public final void f3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048704, this, i2, sparseArray) == null) || (pbFragment = this.f19988c) == null || pbFragment.w() == null || this.f19988c.w().S0() == null || this.f19988c.w().S0().o() == null || this.f19988c.w().S0().l() == null || this.f19988c.w().S0().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e7f, Boolean.TRUE);
        }
        c.a.p0.l.i iVar = new c.a.p0.l.i(this.f19988c.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19988c.w().S0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19988c.w().S0().o().has_forum_rule.intValue());
        iVar.i(this.f19988c.w().S0().l().getId(), this.f19988c.w().S0().l().getName());
        iVar.h(this.f19988c.w().S0().l().getImage_url());
        iVar.j(this.f19988c.w().S0().l().getUser_level());
        q3(sparseArray, i2, iVar, this.f19988c.w().S0().U(), true);
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.s.b(this.D0) : invokeV.booleanValue;
    }

    public void g1() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || (aVar = this.C0) == null) {
            return;
        }
        aVar.h(false);
    }

    public void g2(c.a.o0.t.a aVar, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048707, this, aVar, i2) == null) || (fallingView = this.D1) == null) {
            return;
        }
        fallingView.A(aVar, this.f19988c.getPageContext(), i2, false);
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048708, this, z2) == null) {
            this.m0.setVisibility(z2 ? 0 : 8);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            c.a.o0.r.t.a aVar = this.S;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.T;
            if (dialog != null) {
                c.a.d.f.m.g.b(dialog, this.f19988c.getPageContext());
            }
            Dialog dialog2 = this.U;
            if (dialog2 != null) {
                c.a.d.f.m.g.b(dialog2, this.f19988c.getPageContext());
            }
            c.a.o0.r.t.j jVar = this.Q;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public void h1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            if (this.y == null) {
                o1();
            }
            this.k.setVisibility(8);
            Handler handler = this.K1;
            if (handler == null || (runnable = this.L1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public final void h2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048711, this, pbReplyTitleViewHolder, z2) == null) || this.e1 || this.N0 == null || this.f19993h.p() == null) {
            return;
        }
        View r2 = o0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.N0.getVisibility() == 0 && i3 - this.f19993h.p().getBottom() <= this.N0.getHeight()) {
                    this.O0.setVisibility(0);
                    if (i3 > this.f19993h.p().getBottom()) {
                        i2 = -(((this.N0.getHeight() + this.O0.getHeight()) + this.f19993h.p().getBottom()) - r2.getBottom());
                    } else {
                        i2 = -this.N0.getHeight();
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
                    if (layoutParams.topMargin != i2) {
                        layoutParams.topMargin = i2;
                        this.N0.setLayoutParams(layoutParams);
                    }
                } else {
                    this.O0.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.N0.setLayoutParams(layoutParams2);
                    }
                }
            }
        }
        int G = this.C.G();
        if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.b().getParent() == null)) {
            if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                this.N0.setVisibility(4);
                return;
            }
            this.N0.setVisibility(0);
            g3(false);
            this.f19993h.a.hideBottomLine();
            if (this.N0.getParent() == null || ((ViewGroup) this.N0.getParent()).getHeight() > this.N0.getTop()) {
                return;
            }
            this.N0.getParent().requestLayout();
        } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.b() != null && pbReplyTitleViewHolder.f34999g != null) {
            int top = pbReplyTitleViewHolder.b().getTop();
            if (pbReplyTitleViewHolder.b().getParent() != null) {
                if (this.T0) {
                    this.S0 = top;
                    this.T0 = false;
                }
                int i4 = this.S0;
                if (top < i4) {
                    i4 = top;
                }
                this.S0 = i4;
            }
            if (top != 0 || pbReplyTitleViewHolder.b().isShown()) {
                if (this.B.getY() < 0.0f) {
                    measuredHeight = X1 - pbReplyTitleViewHolder.f34999g.getMeasuredHeight();
                } else {
                    measuredHeight = this.f19993h.p().getMeasuredHeight() - pbReplyTitleViewHolder.f34999g.getMeasuredHeight();
                    this.f19993h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.b().getParent() == null && top <= this.S0) {
                    this.N0.setVisibility(0);
                    g3(false);
                } else if (top < measuredHeight) {
                    this.N0.setVisibility(0);
                    g3(false);
                } else {
                    this.N0.setVisibility(4);
                    this.f19993h.a.hideBottomLine();
                }
                if (z2) {
                    this.T0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.N0.setVisibility(4);
            this.f19993h.a.hideBottomLine();
        }
    }

    public void h3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) || this.q0 == null) {
            return;
        }
        A2(this.f19988c.O4().C());
        if (this.l0) {
            l3(z2);
        } else {
            d1(z2);
        }
    }

    public void i0() {
        c.a.p0.w2.m.f.i1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || (iVar = this.r) == null) {
            return;
        }
        iVar.b();
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            this.M.setVisibility(8);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            this.u.v(this.E0, this.F0, this.f1, this.e1);
        }
    }

    public void i3(c.a.p0.w2.i.f fVar) {
        PostData postData;
        c.a.p0.w2.m.f.o1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048716, this, fVar) == null) || fVar == null || (postData = this.F0) == null || postData.s() == null || (cVar = this.f19993h) == null) {
            return;
        }
        boolean z2 = !this.e1;
        this.f1 = z2;
        cVar.G(z2);
        if (this.f19988c.P4() != null) {
            this.f19988c.P4().s(this.f1);
        }
        i2();
        PbFragment pbFragment = this.f19988c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
            x1 x1Var = fVar.p().get(0);
            if (x1Var != null) {
                this.f19993h.K(fVar, x1Var.a(), x1Var.c(), x1Var.b(), x1Var.getIsLike());
            }
        } else if (fVar.l() != null) {
            this.f19993h.K(fVar, fVar.l().getName(), fVar.l().getId(), fVar.l().getImage_url(), fVar.l().isLike() == 1);
        }
        if (this.f1) {
            this.u.F(fVar, this.F0, this.f0);
            View view = this.P0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.o1 == null) {
                this.o1 = new c0(this);
            }
            this.l.setListViewDragListener(this.o1);
            return;
        }
        View view2 = this.P0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.u.F(fVar, this.F0, this.f0);
        this.o1 = null;
        this.l.setListViewDragListener(null);
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            PbListView pbListView = this.I;
            if (pbListView != null) {
                pbListView.y();
                this.I.f();
            }
            g1();
        }
    }

    public void j1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || (rightFloatLayerView = this.E1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void j2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048719, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.d1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.U0.f20017c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.U0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.U0.f20017c;
        int T0 = T0(pbReplyTitleViewHolder);
        int measuredHeight = this.B.getMeasuredHeight() + ((int) this.B.getY());
        boolean z2 = this.N0.getVisibility() == 0;
        boolean z3 = this.B.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.C.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.f34999g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), X1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), this.f19993h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.e1 && this.r != null) {
            this.l.setSelectionFromTop(this.C.G() + this.l.getHeaderViewsCount(), this.r.d());
        } else if (this.G0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, T0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void j3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048720, this, sparseArray, i2, i3) == null) || this.f19988c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f048e, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.f19988c.x());
        oVar.v(i2);
        oVar.l(i3);
        oVar.n(true);
        oVar.r(aVar2, aVar);
        oVar.i(false);
        AlertDialog y2 = oVar.y();
        aVar.a(new m(this, y2, sparseArray));
        aVar2.a(new n(this, y2));
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.l.A(0L);
            g0();
        }
    }

    public void k1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048722, this) == null) || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.q();
    }

    public final void k2(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048723, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        N3(fVar);
        if (fVar.r()) {
            WebPManager.setPureDrawable(this.v0, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.v0, R.drawable.obfuscated_res_0x7f080921, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String n02 = n0(fVar.O().getReply_num());
        TextView textView = this.y0;
        if (textView != null) {
            textView.setText(n02);
        }
        TextView textView2 = this.z0;
        if (textView2 != null) {
            textView2.setText(n02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.O()));
    }

    public final boolean k3(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048724, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return fVar.O().getIsLive() == 1 || fVar.O().getThreadType() == 33 || !(fVar.O().getTopicData() == null || fVar.O().getTopicData().a() == 0) || fVar.O().getIs_top() == 1 || fVar.O().getIs_good() == 1 || fVar.O().isActInfo() || fVar.O().isInterviewLive() || fVar.O().isVoteThreadType() || fVar.O().getYulePostActivityData() != null || !c.a.d.f.p.m.isEmpty(fVar.O().getCategory()) || fVar.O().isGodThread() || fVar.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public void l0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f19988c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f19988c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f11f1));
            } else if (z3) {
                if (c.a.d.f.p.m.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
                }
                this.f19988c.showToast(str);
            }
        }
    }

    public final void l1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048726, this) == null) && this.x == null && (pbFragment = this.f19988c) != null) {
            this.x = new c.a.p0.w2.m.f.i1.c(pbFragment.getContext());
        }
    }

    public void l2(int i2, c.a.p0.w2.i.f fVar, boolean z2, int i3) {
        PostData w0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048727, this, new Object[]{Integer.valueOf(i2), fVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (w0 = w0(fVar, z2)) == null || w0.s() == null) {
            return;
        }
        MetaData s2 = w0.s();
        s2.setGiftNum(s2.getGiftNum() + i2);
    }

    public void l3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048728, this, z2) == null) || this.q0 == null || (textView = this.t0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0500);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.q0.startAnimation(alphaAnimation);
        }
        this.p0.setVisibility(0);
        this.q0.setVisibility(0);
        this.A0 = true;
        if (this.V0 == null || this.n1.l()) {
            return;
        }
        this.V0.setVisibility(0);
        r2(true);
    }

    public void m0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048729, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048730, this) == null) && this.t == null) {
            this.t = new c.a.p0.w2.m.f.i1.f(this.f19988c, this.i0);
        }
    }

    public void m2(c.a.p0.w2.i.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048731, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            t3(fVar, z2, i2, i3);
            this.u.t(i3);
        }
    }

    public void m3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048732, this, view) == null) || c.a.o0.r.j0.b.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.q0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f19988c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f19988c.getContext());
        this.k1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0426);
        this.k1.setGravity(17);
        this.k1.setPadding(c.a.d.f.p.n.f(this.f19988c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, c.a.d.f.p.n.f(this.f19988c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = c.a.d.f.p.n.f(this.f19988c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.k1.getParent() == null) {
            frameLayout.addView(this.k1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f19988c.getContext());
        this.j1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.j1.setHeight(-2);
        this.j1.setWidth(-2);
        this.j1.setFocusable(true);
        this.j1.setOutsideTouchable(false);
        this.j1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new i0(this, i4, i2, i3, view), 100L);
        c.a.o0.r.j0.b.k().u("show_long_press_collection_tips", true);
    }

    public final String n0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048733, this, i2)) == null) {
            if (i2 == 0) {
                return this.f19988c.getString(R.string.obfuscated_res_0x7f0f0d95);
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

    public final void n1(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048734, this, fVar) == null) && fVar != null && fVar.O() != null && fVar.O().isInterviewLive() && this.K0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.J0.inflate();
            this.K0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.N);
            this.K0.setCallback(this.f19988c.E4());
            this.K0.setData(this.f19988c, fVar);
        }
    }

    public final void n2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && (pbInterviewStatusView = this.K0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.K0.setLayoutParams(layoutParams);
        }
    }

    public void n3() {
        c.a.p0.w2.m.f.o1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (cVar = this.f19993h) == null || this.g1) {
            return;
        }
        cVar.C();
        this.g1 = true;
    }

    public c.a.p0.w2.m.f.l o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.C : (c.a.p0.w2.m.f.l) invokeV.objValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && this.f19988c.G4()) {
            ViewStub viewStub = (ViewStub) this.f19989d.findViewById(R.id.obfuscated_res_0x7f09138f);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.y == null) {
                this.y = (LinearLayout) this.f19989d.findViewById(R.id.obfuscated_res_0x7f09138e);
                c.a.o0.w0.a.a(this.f19988c.getPageContext(), this.y);
            }
            if (this.z == null) {
                this.z = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091393);
            }
            if (this.A == null) {
                this.A = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091392);
            }
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.N);
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048739, this) == null) || this.f19991f == 2) {
            return;
        }
        this.l.setNextPage(this.I);
        this.f19991f = 2;
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public LinearLayout p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.r0 : (LinearLayout) invokeV.objValue;
    }

    public void p1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048742, this) == null) || this.f19988c == null || (editorTools = this.k0) == null) {
            return;
        }
        editorTools.j();
        if (this.f19988c.O4() != null) {
            this.f19988c.O4().P();
        }
        c1();
    }

    public void p2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.x.d(pbLandscapeListView);
        this.t.d(this.l);
        this.u.w(this.l);
        this.v.d(this.l);
        this.s.f(this.l);
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            if (this.C0 == null) {
                this.C0 = new c.a.o0.r.l0.a(this.f19988c.getPageContext());
            }
            this.C0.h(true);
        }
    }

    public View q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            View view = this.V;
            if (view != null) {
                return view.findViewById(R.id.obfuscated_res_0x7f090799);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void q1(c.a.p0.w2.i.f fVar, c.a.o0.s.c.f fVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048746, this, fVar, fVar2) == null) || this.F1 == null || fVar == null || fVar2 == null || this.f19988c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            j1();
            return;
        }
        if (this.E1 == null) {
            this.E1 = RightFloatLayerLottieView.F(fVar2, this.f19988c.getContext());
            this.F1.removeAllViews();
            this.F1.addView(this.E1);
        }
        if ((this.D1.getTag() instanceof Boolean) && !((Boolean) this.D1.getTag()).booleanValue()) {
            this.E1.setAutoCompleteShown(false);
            this.E1.setTag(this.D1);
            this.E1.c();
        }
        if (fVar2.a()) {
            return;
        }
        this.E1.setData(fVar2);
        this.E1.setLogoListener(new e0(this, fVar2));
        this.E1.setFeedBackListener(new j0(this, fVar2));
    }

    public final void q2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || (pbFragment = this.f19988c) == null || pbFragment.O4() == null || this.k0 == null) {
            return;
        }
        c.a.o0.w.y.a.a().c(0);
        c.a.o0.w.y.e O4 = this.f19988c.O4();
        O4.T();
        O4.R();
        if (O4.y() != null) {
            O4.y().setMaxImagesAllowed(O4.v ? 1 : 9);
        }
        O4.l0(SendView.f30532g);
        O4.j(SendView.f30532g);
        c.a.o0.w.h m2 = this.k0.m(23);
        c.a.o0.w.h m3 = this.k0.m(2);
        c.a.o0.w.h m4 = this.k0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.k0.invalidate();
    }

    public final void q3(SparseArray<Object> sparseArray, int i2, c.a.p0.l.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048748, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f19988c) == null) {
            return;
        }
        if (this.t1 == null && this.s != null) {
            this.t1 = new c.a.p0.l.j(pbFragment.getPageContext(), this.s.c(), iVar, userData);
        }
        this.t1.C(z2);
        AntiData w4 = this.f19988c.w4();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (w4 != null && w4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = w4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.o0.r.r.v0 v0Var = new c.a.o0.r.r.v0();
        v0Var.j(sparseArray2);
        this.t1.E(new String[]{this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a2), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a3), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a4), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a5), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a6)});
        this.t1.D(v0Var);
        this.t1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.t1.F(new r(this, sparseArray));
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public void r1(c.a.p0.w2.i.f fVar) {
        c.a.o0.s.c.f pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, fVar) == null) || fVar == null) {
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

    public final void r2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z2) == null) {
        }
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.C.f0(this.E0, false);
            this.C.Y();
        }
    }

    public int s0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
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

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048754, this) == null) && this.v == null) {
            this.v = new c.a.p0.w2.m.f.i1.e(this.f19988c, this.N);
        }
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            q2();
            e1();
            this.a1.c();
            h3(false);
        }
    }

    public void s3(c.a.p0.w2.i.f fVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        c.a.p0.w2.i.f fVar2;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048756, this, new Object[]{fVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || fVar == null || this.l == null) {
            return;
        }
        this.E0 = fVar;
        this.G0 = i2;
        if (fVar.O() != null) {
            this.W0 = fVar.O().getCopyThreadRemindType();
            if (fVar.O().getAnchorLevel() != 0) {
                this.Q1 = true;
            }
            this.f0 = C1(fVar.O());
        }
        if (fVar.U() != null) {
            this.R1 = fVar.U().getUserId();
        }
        n1(fVar);
        V();
        this.I0 = false;
        this.D0 = z2;
        U2();
        c.a.p0.w2.i.n nVar = fVar.f19821h;
        if (nVar != null && nVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f19988c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(fVar);
                this.o.setChildOnClickLinstener(this.N);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        t3(fVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        i3(fVar);
        this.u.G(fVar, this.F0);
        if (this.q1 == null) {
            this.q1 = new c.a.p0.w2.m.f.n0(this.f19988c.getPageContext(), this.r1);
        }
        this.q1.a(fVar.w());
        if (this.f19988c.G4()) {
            if (this.H == null) {
                c.a.p0.w2.r.k kVar = new c.a.p0.w2.r.k(this.f19988c.getPageContext());
                this.H = kVar;
                kVar.n();
                this.H.f(this.S1);
            }
            this.l.setPullRefresh(this.H);
            t2();
            c.a.p0.w2.r.k kVar2 = this.H;
            if (kVar2 != null) {
                kVar2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (fVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.H == null) {
                c.a.p0.w2.r.k kVar3 = new c.a.p0.w2.r.k(this.f19988c.getPageContext());
                this.H = kVar3;
                kVar3.n();
                this.H.f(this.S1);
            }
            this.l.setPullRefresh(this.H);
            t2();
            c.a.p0.w2.r.k kVar4 = this.H;
            if (kVar4 != null) {
                kVar4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            g1();
        }
        g0();
        this.C.m0(this.D0);
        this.C.j0(false);
        this.C.k0(i2 == 5);
        this.C.l0(i2 == 6);
        this.C.h0(z3 && this.O1 && i2 != 2);
        this.C.f0(fVar, false);
        this.C.Y();
        this.u.E(w0(fVar, z2), fVar.g0());
        if (fVar.O() != null && fVar.O().getPraise() != null && this.f19987b != -1) {
            fVar.O().getPraise().setIsLike(this.f19987b);
        }
        this.l.removeFooterView(this.R0);
        this.l.addFooterView(this.R0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.I);
            this.f19991f = 2;
            g1();
        } else {
            this.I0 = true;
            if (fVar.y().b() == 1) {
                if (this.J == null) {
                    PbFragment pbFragment = this.f19988c;
                    this.J = new c.a.p0.w2.r.g(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.J);
            } else {
                this.l.setNextPage(this.I);
            }
            this.f19991f = 3;
        }
        ArrayList<PostData> F = fVar.F();
        if (fVar.y().b() != 0 && F != null && F.size() >= fVar.y().e()) {
            if (z3) {
                if (this.O1) {
                    j0();
                    if (fVar.y().b() != 0) {
                        this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0da7));
                    }
                } else {
                    this.I.A();
                    this.I.O();
                }
            } else {
                this.I.A();
                this.I.O();
            }
            this.I.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                if (fVar.y().b() == 0) {
                    this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                } else {
                    this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                }
                this.I.k();
            } else {
                p0 p0Var = this.U0;
                if (p0Var == null || (pbReplyTitleViewHolder = p0Var.f20017c) == null || pbReplyTitleViewHolder.b() == null) {
                    i5 = 0;
                } else {
                    i5 = this.U0.f20017c.b().getTop() < 0 ? this.U0.f20017c.b().getHeight() : this.U0.f20017c.b().getBottom();
                }
                if (this.f19988c.n5()) {
                    this.I.v(false);
                    if (ListUtils.isEmpty(fVar.R())) {
                        this.I.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dae), i5);
                    }
                } else if (ListUtils.isEmpty(fVar.R())) {
                    this.I.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daf), i5);
                }
                if (this.f19988c.P4() != null && !this.f19988c.P4().p()) {
                    this.f19988c.P4().x();
                }
            }
            if (fVar.y().b() == 0 || F == null) {
                o2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && fVar.F() == null) ? 0 : (this.l.getData().size() - fVar.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.O1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        c.a.p0.w2.m.f.i1.i iVar = this.r;
                        if (iVar != null && iVar.c() != null) {
                            if (this.f19988c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d() - c.a.d.f.p.n.r(this.f19988c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.C.B() + this.l.getHeaderViewsCount()) - 1, this.r.d());
                            }
                        } else {
                            this.l.setSelection(this.C.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(fVar.R())) {
                        this.l.setSelection(i3 > 0 ? i3 + ((this.l.getData() == null && fVar.F() == null) ? 0 : (this.l.getData().size() - fVar.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(fVar.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.I.f();
                    this.I.D(this.f19988c.getString(R.string.obfuscated_res_0x7f0f0da8));
                    this.I.y();
                }
            } else if (i4 == 1 && (e4 = s0.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e3 = s0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new b0(this, e3, F, fVar));
        }
        if (this.W0 == Y1 && B1()) {
            a0();
        }
        if (this.c1) {
            j2();
            this.c1 = false;
            if (i4 == 0) {
                J2(true);
            }
        }
        if (fVar.f19817d == 1 || fVar.f19818e == 1) {
            if (this.i1 == null) {
                this.i1 = new PbTopTipView(this.f19988c.getContext());
            }
            if (fVar.f19818e == 1 && "game_guide".equals(this.f19988c.U4())) {
                this.i1.setText(this.f19988c.getString(R.string.obfuscated_res_0x7f0f0dba));
                this.i1.l(this.f19989d, this.H0);
            } else if (fVar.f19817d == 1 && "game_news".equals(this.f19988c.U4())) {
                this.i1.setText(this.f19988c.getString(R.string.obfuscated_res_0x7f0f0db9));
                this.i1.l(this.f19989d, this.H0);
            }
        }
        this.l.removeFooterView(this.B1.a());
        if (!ListUtils.isEmpty(fVar.I()) && fVar.y().b() == 0) {
            this.l.removeFooterView(this.R0);
            this.B1.d(Math.max(this.q0.getMeasuredHeight(), this.B0 / 2));
            this.l.addFooterView(this.B1.a());
            this.B1.f(fVar);
        }
        k2(fVar);
        if (fVar.e0() && this.f19988c.w().E1() && this.f19988c.R4() != null) {
            this.f19988c.R4().d();
        }
        if (fVar.g() != 3) {
            r1(fVar);
        }
        this.t0.setText(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), S0()));
        if (this.p == null || (fVar2 = this.E0) == null || fVar2.l() == null) {
            return;
        }
        this.p.m(this.E0.l().getImage_url());
        this.p.n(this.E0.l().getName());
        PbFragment pbFragment2 = this.f19988c;
        if (pbFragment2 == null || pbFragment2.w() == null) {
            return;
        }
        this.p.o(this.f19988c.w().f34970b);
    }

    public PostData t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int s0 = s0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (s0 < 0) {
                s0 = 0;
            }
            if (this.C.y(s0) != null && this.C.y(s0) != PostData.v0) {
                i2 = s0 + 1;
            }
            if (this.C.x(i2) instanceof PostData) {
                return (PostData) this.C.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void t1(c.a.p0.w2.i.f fVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, fVar) == null) {
            int i2 = 0;
            this.C.f0(fVar, false);
            this.C.Y();
            g0();
            c.a.p0.w2.m.e.a aVar = this.n1;
            if (aVar != null) {
                aVar.n();
            }
            ArrayList<PostData> F = fVar.F();
            if (fVar.y().b() == 0 || F == null || F.size() < fVar.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).A() != 1)) {
                    if (fVar.y().b() == 0) {
                        this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
                    } else {
                        this.I.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a2b));
                    }
                    this.I.k();
                } else {
                    p0 p0Var = this.U0;
                    if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f20017c) != null && pbReplyTitleViewHolder.b() != null) {
                        i2 = this.U0.f20017c.b().getTop() < 0 ? this.U0.f20017c.b().getHeight() : this.U0.f20017c.b().getBottom();
                    }
                    if (this.f19988c.n5()) {
                        this.I.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dae), i2);
                    } else {
                        this.I.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0daf), i2);
                    }
                }
            }
            k2(fVar);
        }
    }

    public final void t2() {
        c.a.p0.w2.m.f.i1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048759, this) == null) || (iVar = this.r) == null) {
            return;
        }
        iVar.q(this.l, this.M0, this.G0);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void t3(c.a.p0.w2.i.f fVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048760, this, new Object[]{fVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        if (this.f19988c.isSimpleForum()) {
            if (fVar.h() != null) {
                this.g0 = fVar.h().a();
                this.h0 = fVar.h().c();
            }
            if (this.g0 == null && this.f19988c.w() != null && this.f19988c.w().s0() != null) {
                this.g0 = this.f19988c.w().s0();
            }
        }
        PostData w0 = w0(fVar, z2);
        S2(w0, fVar);
        this.u.B(8);
        if (fVar.r0()) {
            this.e1 = true;
            this.f19993h.A(true);
            this.f19993h.a.hideBottomLine();
            if (this.r == null) {
                this.r = new c.a.p0.w2.m.f.i1.i(this.f19988c);
            }
            this.r.v(fVar, w0, this.l, this.u, this.L0, this.f19993h, this.g0, this.w1);
            this.r.s(this.P1);
            t2();
        } else {
            this.e1 = false;
            this.f19993h.A(false);
            c.a.p0.w2.m.f.i1.i iVar = this.r;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f19988c.P4() != null) {
            this.f19988c.P4().w(this.e1);
        }
        if (w0 == null) {
            return;
        }
        this.F0 = w0;
        this.u.B(0);
        SparseArray<Object> q2 = this.u.q();
        q2.put(R.id.obfuscated_res_0x7f091e69, w0);
        q2.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
        this.v.e(fVar, this.l);
        this.x.e(fVar, this.y1, new y(this));
        this.t.f(fVar);
        this.s.h(fVar, this.D0);
        this.s.g(fVar);
        this.u.C(this.H0, this.E0, w0, this.P1);
        if (this.Q0 != null) {
            if (fVar.g0()) {
                this.Q0.b().setVisibility(8);
            } else {
                this.Q0.b().setVisibility(0);
                c.a.p0.w2.i.r rVar = new c.a.p0.w2.i.r(c.a.p0.w2.i.r.f19847h);
                if (fVar.O() != null) {
                    fVar.O().getReply_num();
                }
                rVar.f19849c = fVar.f19820g;
                fVar.c();
                rVar.f19850d = this.f19988c.n5();
                rVar.f19853g = fVar.f19819f;
                this.Q0.i(rVar);
            }
        }
        E3(fVar);
        c.a.d.f.m.e.a().post(new z(this));
        this.w.e(this.l);
        if (w0.Q) {
            this.w.f(w0.G());
            this.w.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        c.a.p0.w2.m.f.l lVar = this.C;
        if (lVar != null && lVar.z() != null) {
            this.C.z().m0(w0.Q);
        }
        c.a.p0.w2.m.f.l lVar2 = this.C;
        if (lVar2 != null) {
            lVar2.o0(w0.Q);
        }
        this.C1.setVisibility(w0.Q ? 0 : 8);
    }

    public FallingView u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.D1 : (FallingView) invokeV.objValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.Q1 : invokeV.booleanValue;
    }

    public void u2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (handler = this.K1) == null) {
            return;
        }
        Runnable runnable = this.L1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        f fVar = new f(this);
        this.L1 = fVar;
        this.K1.postDelayed(fVar, 2000L);
    }

    public void u3(c.InterfaceC0843c interfaceC0843c, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048764, this, interfaceC0843c, z2) == null) {
            c.a.o0.r.t.j jVar = this.c0;
            if (jVar != null) {
                jVar.dismiss();
                this.c0 = null;
            }
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.f19988c.getContext());
            ArrayList arrayList = new ArrayList();
            c.a.p0.w2.i.f fVar = this.E0;
            if (fVar != null && fVar.O() != null && !this.E0.O().isBjh()) {
                arrayList.add(new c.a.o0.r.t.h(0, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1067), lVar));
            }
            if (!z2) {
                arrayList.add(new c.a.o0.r.t.h(1, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1068), lVar));
            }
            lVar.j(arrayList);
            lVar.n(new w(this, interfaceC0843c));
            c.a.o0.r.t.j jVar2 = new c.a.o0.r.t.j(this.f19988c.getPageContext(), lVar);
            this.c0 = jVar2;
            jVar2.m();
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? x0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public void v2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, editorTools) == null) {
            this.k0 = editorTools;
            editorTools.setOnCancelClickListener(new h(this));
            this.k0.setId(R.id.obfuscated_res_0x7f0916a2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.k0.getParent() == null) {
                this.f19989d.addView(this.k0, layoutParams);
            }
            this.k0.w(TbadkCoreApplication.getInst().getSkinType());
            this.k0.setActionListener(24, new i(this));
            e1();
            this.f19988c.O4().i(new j(this));
        }
    }

    public void v3(c.InterfaceC0843c interfaceC0843c, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048768, this, new Object[]{interfaceC0843c, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            c.a.o0.r.t.j jVar = this.b0;
            if (jVar != null) {
                jVar.dismiss();
                this.b0 = null;
            }
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.f19988c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new c.a.o0.r.t.h(0, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0435), lVar));
            }
            if (z3) {
                arrayList.add(new c.a.o0.r.t.h(1, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fa2), lVar));
            } else if (!z2) {
                arrayList.add(new c.a.o0.r.t.h(1, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a7f), lVar));
            } else {
                arrayList.add(new c.a.o0.r.t.h(1, this.f19988c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f80), lVar));
            }
            lVar.j(arrayList);
            lVar.n(new v(this, interfaceC0843c));
            c.a.o0.r.t.j jVar2 = new c.a.o0.r.t.j(this.f19988c.getPageContext(), lVar);
            this.c0 = jVar2;
            jVar2.m();
        }
    }

    public PostData w0(c.a.p0.w2.i.f fVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048769, this, fVar, z2)) == null) {
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
                postData = R0(fVar);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean w1(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048770, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = fVar.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d96).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048771, this, str) == null) || (pbListView = this.I) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void w3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, onItemClickListener) == null) {
            c.a.o0.r.t.e eVar = this.d0;
            if (eVar != null) {
                eVar.d();
                this.d0 = null;
            }
            if (this.E0 == null) {
                return;
            }
            ArrayList<c.a.o0.r.t.n> arrayList = new ArrayList<>();
            arrayList.add(new c.a.o0.r.t.n(this.f19988c.getContext().getString(R.string.obfuscated_res_0x7f0f0266), "", this.E0.L() == 1, Integer.toString(1)));
            arrayList.add(new c.a.o0.r.t.n(this.f19988c.getContext().getString(R.string.obfuscated_res_0x7f0f0b24), "", this.E0.L() == 2, Integer.toString(5)));
            arrayList.add(new c.a.o0.r.t.n(this.f19988c.getContext().getString(R.string.obfuscated_res_0x7f0f0b20), "", this.E0.L() == 3, Integer.toString(6)));
            arrayList.add(new c.a.o0.r.t.n(this.f19988c.getContext().getString(R.string.obfuscated_res_0x7f0f0b3b), "", this.E0.L() == 4, Integer.toString(7)));
            c.a.o0.r.t.e eVar2 = new c.a.o0.r.t.e(this.f19988c.getPageContext());
            eVar2.l(R.string.obfuscated_res_0x7f0f0db6);
            this.d0 = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.d0.n();
        }
    }

    public final int x0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048773, this, i2)) == null) {
            c.a.d.o.e.e adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof c.a.p0.w2.i.c)) {
                i2++;
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o2) {
                i2 = o2;
            }
            int n2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof c.a.d.o.e.e)) ? 0 : this.l.getAdapter2().n();
            if (i2 > n2) {
                return i2 - n2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void x2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048775, this, str) == null) || this.I == null) {
            return;
        }
        int i2 = 0;
        p0 p0Var = this.U0;
        if (p0Var != null && (pbReplyTitleViewHolder = p0Var.f20017c) != null && pbReplyTitleViewHolder.b() != null) {
            i2 = this.U0.f20017c.b().getTop() < 0 ? this.U0.f20017c.b().getHeight() : this.U0.f20017c.b().getBottom();
        }
        this.I.G(str, i2);
    }

    public void x3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048776, this) == null) || !TbadkCoreApplication.isLogin() || this.E0 == null || !this.f1 || this.e1 || this.f0 || (postData = this.F0) == null || postData.s() == null || this.F0.s().getIsLike() || this.F0.s().hadConcerned() || this.b1 != null) {
            return;
        }
        this.b1 = new v0(this.f19988c);
    }

    public Button y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) ? this.o0 : (Button) invokeV.objValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            EditorTools editorTools = this.k0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            this.D1.setFallingFeedbackListener(new FallingView.k() { // from class: c.a.p0.w2.m.f.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.k
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a1.this.L1();
                    }
                }
            });
        }
    }

    public final void y3(c.a.o0.r.t.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048780, this, aVar, i2) == null) || (pbFragment = this.f19988c) == null || aVar == null) {
            return;
        }
        if (this.s1 == null && this.s != null) {
            this.s1 = new c.a.p0.l.g(pbFragment.getPageContext(), this.s.c());
        }
        AntiData w4 = this.f19988c.w4();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (w4 != null && w4.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = w4.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.o0.r.r.v0 v0Var = new c.a.o0.r.r.v0();
        v0Var.j(sparseArray);
        this.s1.y(new String[]{this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a2), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a3), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a4), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a5), this.f19988c.getString(R.string.obfuscated_res_0x7f0f04a6)});
        this.s1.x(v0Var);
        this.s1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.s1.z(new q(this, aVar));
    }

    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean z1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048782, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void z2(PbFragment.c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, c3Var) == null) {
            this.N1 = c3Var;
        }
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048784, this) == null) {
            this.M.setVisibility(0);
        }
    }
}
