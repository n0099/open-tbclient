package c.a.p0.i2.k.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import c.a.o0.s.f0.f;
import c.a.o0.s.q.b1;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.y1;
import c.a.o0.s.s.a;
import c.a.o0.s.s.b;
import c.a.o0.s.s.i;
import c.a.p0.i.g;
import c.a.p0.i.j;
import c.a.p0.i2.i.a;
import c.a.p0.i2.k.e.a1.c;
import c.a.p0.i2.p.c;
import c.a.p0.i3.g0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class s0 {
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
    public c.a.p0.i2.k.e.i A;
    public boolean A0;
    public final FallingView A1;
    public c.a.o0.s.s.a B;
    public c.a.p0.i2.h.e B0;
    public final TbImageView B1;
    public c.a.o0.s.s.b C;
    public PostData C0;
    public final c.a.p0.i2.o.j.a C1;
    public View D;
    public int D0;
    public RightFloatLayerView D1;
    public EditText E;
    public int E0;
    public final CustomMessageListener E1;
    public c.a.p0.i2.p.i F;
    public boolean F0;
    public boolean F1;
    public PbListView G;
    public ViewStub G0;
    public String G1;
    public c.a.p0.i2.p.e H;
    public PbInterviewStatusView H0;
    public CustomMessageListener H1;
    public View I;
    public FrameLayout I0;
    public Runnable I1;
    public View J;
    public TextView J0;
    public CustomMessageListener J1;
    public View.OnClickListener K;
    public View K0;
    public Handler K1;
    public TbRichTextView.z L;
    public View L0;
    public Runnable L1;
    public NoNetworkView.b M;
    public View M0;
    public CustomMessageListener M1;
    public PopupDialog N;
    public PbReplyTitleViewHolder N0;
    public PbFragment.z2 N1;
    public View.OnClickListener O;
    public View O0;
    public boolean O1;
    public c.a.o0.s.s.a P;
    public int P0;
    public View.OnClickListener P1;
    public Dialog Q;
    public boolean Q0;
    public boolean Q1;
    public Dialog R;
    public r0 R0;
    public String R1;
    public View S;
    public PbEmotionBar S0;
    public f.g S1;
    public LinearLayout T;
    public int T0;
    public final List<TbImageView> T1;
    public CompoundButton.OnCheckedChangeListener U;
    public int U0;
    public int U1;
    public TextView V;
    public Runnable V0;
    public boolean V1;
    public TextView W;
    public PbFakeFloorModel W0;
    public boolean W1;
    public String X;
    public c.a.p0.i2.k.e.u X0;
    public PopupDialog Y;
    public c.a.p0.i2.k.e.n0 Y0;
    public PopupDialog Z;
    public boolean Z0;

    /* renamed from: a  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f19324a;
    public c.a.o0.s.s.c a0;
    public int a1;

    /* renamed from: b  reason: collision with root package name */
    public int f19325b;
    public boolean b0;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f19326c;
    public boolean c0;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f19327d;
    public String d0;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public View f19328e;
    public String e0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public int f19329f;
    public c.a.p0.i2.i.c f0;
    public PbTopTipView f1;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f19330g;
    public ScrollView g0;
    public PopupWindow g1;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.i2.k.e.g1.c f19331h;
    public EditorTools h0;
    public TextView h1;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.i2.k.e.g1.b f19332i;
    public boolean i0;
    public List<String> i1;

    /* renamed from: j  reason: collision with root package name */
    public ViewStub f19333j;
    public View j0;
    public c.a.p0.i2.k.e.b1.c j1;
    public ViewStub k;
    public View k0;
    public c.a.p0.i2.k.d.a k1;
    public PbLandscapeListView l;
    public Button l0;
    public PbLandscapeListView.c l1;
    public NoNetworkView m;
    public View m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public View n0;
    public c.a.p0.i2.k.e.g0 n1;
    public PbThreadPostView o;
    public LinearLayout o0;
    public NavigationBarCoverTip o1;
    public c.a.p0.i2.k.e.a1.i p;
    public HeadImageView p0;
    public c.a.p0.i.g p1;
    public c.a.p0.i2.k.e.a1.d q;
    public TextView q0;
    public c.a.p0.i.j q1;
    public c.a.p0.i2.k.e.a1.f r;
    public ImageView r0;
    public String r1;
    public c.a.p0.i2.k.e.a1.h s;
    public ImageView s0;
    public PermissionJudgePolicy s1;
    public c.a.p0.i2.k.e.a1.e t;
    public ImageView t0;
    public long t1;
    public c.a.p0.i2.k.e.a1.g u;
    public c.a.p0.i2.p.h u0;
    public boolean u1;
    public c.a.p0.i2.k.e.a1.c v;
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
    public c.a.p0.i2.p.g y1;
    public ObservedChangeRelativeLayout z;
    public c.a.o0.s.f0.a z0;
    public MaskView z1;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19334e;

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
            this.f19334e = s0Var;
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
                    this.f19334e.f19326c.checkMuteState(sparseArray);
                    return;
                }
                this.f19334e.e2(view);
            } else if (booleanValue2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.f19334e.f19326c.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f19334e.Z1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19335a;

        public a0(s0 s0Var) {
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
            this.f19335a = s0Var;
        }

        @Override // c.a.p0.i2.k.e.a1.c.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f19335a.v.a(this.f19335a.l);
                } else {
                    this.f19335a.v.d(this.f19335a.l);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19336e;

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
            this.f19336e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19336e.r2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19337e;

        public b0(s0 s0Var) {
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
            this.f19337e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            s0 s0Var;
            c.a.p0.i2.k.e.g1.c cVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19337e.A == null || (cVar = (s0Var = this.f19337e).f19331h) == null || cVar.f19217i == null || s0Var.B0 == null || this.f19337e.B0.O() == null || this.f19337e.B0.O().A2() || this.f19337e.E1() || this.f19337e.B0.m() == null || c.a.e.e.p.k.isEmpty(this.f19337e.B0.m().getName())) {
                return;
            }
            if ((this.f19337e.A.H() == null || !this.f19337e.A.H().isShown()) && (linearLayout = this.f19337e.f19331h.f19217i) != null) {
                linearLayout.setVisibility(0);
                if (this.f19337e.f19326c == null || this.f19337e.f19326c.getPbModel() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.f19337e.f19326c.getPbModel().e1());
                statisticItem.param("fid", this.f19337e.f19326c.getPbModel().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19338a;

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
            this.f19338a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f19338a.W0.M(postData);
                this.f19338a.A.X();
                this.f19338a.X0.c();
                this.f19338a.h0.hideTools();
                this.f19338a.g3(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19340f;

        public c0(s0 s0Var, String str) {
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
            this.f19340f = s0Var;
            this.f19339e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.e.e.p.l.D()) {
                    UrlManager.getInstance().dealOneLink(this.f19340f.f19326c.getPageContext(), new String[]{this.f19339e});
                    this.f19340f.f19326c.finish();
                    return;
                }
                this.f19340f.f19326c.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.u.a f19341a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f19342b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ s0 f19343c;

        public d(s0 s0Var, c.a.o0.u.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19343c = s0Var;
            this.f19341a = aVar;
            this.f19342b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.f19343c.F3(this.f19341a, bitmap, this.f19342b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Parcelable f19344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f19345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.i2.h.e f19346g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ s0 f19347h;

        public d0(s0 s0Var, Parcelable parcelable, ArrayList arrayList, c.a.p0.i2.h.e eVar) {
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
            this.f19347h = s0Var;
            this.f19344e = parcelable;
            this.f19345f = arrayList;
            this.f19346g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19347h.l.onRestoreInstanceState(this.f19344e);
                if (ListUtils.getCount(this.f19345f) <= 1 || this.f19346g.y().b() <= 0) {
                    return;
                }
                this.f19347h.G.f();
                this.f19347h.G.A(this.f19347h.f19326c.getString(R.string.pb_load_more_without_point));
                this.f19347h.G.v();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19348e;

        public e(s0 s0Var) {
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
            this.f19348e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19348e.B1 == null) {
                return;
            }
            c.a.p0.i2.p.d.b(this.f19348e.B1);
        }
    }

    /* loaded from: classes3.dex */
    public static class e0 implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e0() {
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

        @Override // c.a.p0.i3.g0.a.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19349a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(s0 s0Var, int i2) {
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
            this.f19349a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f19349a.A == null) {
                return;
            }
            this.f19349a.A.X();
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19350a;

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
            this.f19350a = s0Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i2, int i3, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) && this.f19350a.f19326c != null && this.f19350a.f19326c.isAdded()) {
                if (i2 < 0 && f2 > this.f19350a.e1) {
                    this.f19350a.d0();
                    this.f19350a.S1();
                }
                this.f19350a.k0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19351e;

        public g(s0 s0Var) {
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
            this.f19351e = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19351e.w == null) {
                    this.f19351e.o1();
                }
                this.f19351e.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19352e;

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
                    return;
                }
            }
            this.f19352e = s0Var;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19352e.d0();
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19353a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(s0 s0Var, int i2) {
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
            this.f19353a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f19353a.x0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19354e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h0 f19355e;

            public a(h0 h0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19355e = h0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19355e.f19354e.f19326c.HidenSoftKeyPad((InputMethodManager) this.f19355e.f19354e.f19326c.getBaseFragmentActivity().getSystemService("input_method"), this.f19355e.f19354e.f19327d);
                }
            }
        }

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
                    return;
                }
            }
            this.f19354e = s0Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f19354e.V0 == null) {
                    this.f19354e.V0 = new a(this);
                }
                c.a.e.e.m.e.a().postDelayed(this.f19354e.V0, 150L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19356a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(s0 s0Var, int i2) {
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
            this.f19356a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921552) {
                this.f19356a.j1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i0(s0 s0Var) {
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

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19357a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbReplyTitleViewHolder f19358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19359c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f19360d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19363g;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f19364e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19364e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19364e.f19363g.O0 == null || this.f19364e.f19363g.O0.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f19364e.f19363g.O0.getLayoutParams();
                layoutParams.height = this.f19364e.f19363g.U0;
                this.f19364e.f19363g.O0.setLayoutParams(layoutParams);
            }
        }

        public j(s0 s0Var, int i2, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i3, int i4, int i5) {
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
            this.f19363g = s0Var;
            this.f19357a = i2;
            this.f19358b = pbReplyTitleViewHolder;
            this.f19359c = z;
            this.f19360d = i3;
            this.f19361e = i4;
            this.f19362f = i5;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = this.f19357a;
                if (i3 >= 0 && i3 <= this.f19363g.f19327d.getMeasuredHeight()) {
                    int S0 = this.f19363g.S0(this.f19358b);
                    int i4 = this.f19357a;
                    int i5 = S0 - i4;
                    if (this.f19359c && i5 != 0 && i4 <= (i2 = this.f19360d)) {
                        i5 = S0 - i2;
                    }
                    if (this.f19363g.O0 == null || (layoutParams = this.f19363g.O0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i5 == 0 || i5 > this.f19363g.f19327d.getMeasuredHeight() || S0 >= this.f19363g.f19327d.getMeasuredHeight()) {
                        layoutParams.height = this.f19363g.U0;
                    } else {
                        if (layoutParams != null) {
                            int i6 = layoutParams.height;
                            if (i6 + i5 > 0 && i6 + i5 <= this.f19363g.f19327d.getMeasuredHeight()) {
                                layoutParams.height += i5;
                                this.f19363g.l.setSelectionFromTop(this.f19361e, this.f19362f);
                            }
                        }
                        layoutParams.height = this.f19363g.U0;
                    }
                    this.f19363g.O0.setLayoutParams(layoutParams);
                    c.a.e.e.m.e.a().post(new a(this));
                }
                this.f19363g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19365e;

        public k(s0 s0Var) {
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
            this.f19365e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19365e.r2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19368g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View f19369h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ s0 f19370i;

        public k0(s0 s0Var, int i2, int i3, int i4, View view) {
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
            this.f19370i = s0Var;
            this.f19366e = i2;
            this.f19367f = i3;
            this.f19368g = i4;
            this.f19369h = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f19366e;
                if (i2 == this.f19367f || i2 - this.f19368g >= 0) {
                    this.f19370i.g1.showAsDropDown(this.f19370i.n0, this.f19369h.getLeft(), -this.f19370i.n0.getHeight());
                } else {
                    this.f19370i.g1.showAsDropDown(this.f19369h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements c.a.o0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19371e;

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
                    return;
                }
            }
            this.f19371e = s0Var;
        }

        @Override // c.a.o0.x.b
        public void onAction(c.a.o0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14777c;
                if (obj instanceof c.a.o0.t.c.v) {
                    if (((c.a.o0.t.c.v) obj).f() == EmotionGroupType.BIG_EMOTION || ((c.a.o0.t.c.v) aVar.f14777c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f19371e.s1 == null) {
                            this.f19371e.s1 = new PermissionJudgePolicy();
                        }
                        this.f19371e.s1.clearRequestPermissionList();
                        this.f19371e.s1.appendRequestPermission(this.f19371e.f19326c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f19371e.s1.startRequestPermission(this.f19371e.f19326c.getBaseFragmentActivity())) {
                            return;
                        }
                        this.f19371e.f19326c.getPbEditor().h((c.a.o0.t.c.v) aVar.f14777c);
                        this.f19371e.f19326c.getPbEditor().A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19373f;

        public l0(s0 s0Var, String str) {
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
            this.f19373f = s0Var;
            this.f19372e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19373f.D1.inPbLastCloseTime();
                if (!StringUtils.isNull(this.f19372e)) {
                    this.f19373f.J1(this.f19372e);
                }
                this.f19373f.j1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19374e;

        public m(s0 s0Var) {
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
            this.f19374e = s0Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f19374e.f19326c.mContentProcessController == null || this.f19374e.f19326c.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f19374e.f19326c.mContentProcessController.e().e()) {
                this.f19374e.f19326c.mContentProcessController.a(false);
            }
            this.f19374e.f19326c.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f19374e.h0 == null || this.f19374e.h0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f19374e.j1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f19374e.h0.getId());
                s0 s0Var = this.f19374e;
                s0Var.j1 = new c.a.p0.i2.k.e.b1.c(s0Var.f19326c.getPageContext(), this.f19374e.f19327d, layoutParams);
                if (!ListUtils.isEmpty(this.f19374e.i1)) {
                    this.f19374e.j1.m(this.f19374e.i1);
                }
                this.f19374e.j1.n(this.f19374e.h0);
            }
            this.f19374e.j1.l(substring);
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19375e;

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
            this.f19375e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19375e.D1.inPbLastCloseTime();
                this.f19375e.j1();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
                TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19377f;

        public n(s0 s0Var, boolean z) {
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
            this.f19377f = s0Var;
            this.f19376e = z;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19377f.N.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f19377f.Z1(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f19377f.N1 != null) {
                            this.f19377f.N1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f19377f.f19326c.handleMuteClick(this.f19376e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19378a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(s0 s0Var, int i2) {
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
            this.f19378a = s0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.f19378a.G1 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(s0 s0Var) {
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

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19380f;

        public o0(s0 s0Var, PbFragment pbFragment) {
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
            this.f19380f = s0Var;
            this.f19379e = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19380f.x1 || this.f19379e == null || this.f19380f.f19326c.getPbModel() == null || !this.f19380f.f19326c.getPbModel().o1()) {
                return;
            }
            this.f19380f.x1 = true;
            this.f19379e.checkEasterEgg(false);
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19382f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19383g;

        public p(s0 s0Var, AlertDialog alertDialog, SparseArray sparseArray) {
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
            this.f19383g = s0Var;
            this.f19381e = alertDialog;
            this.f19382f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19381e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f19383g.f19326c.getPbActivity(), R.string.neterror);
                } else {
                    this.f19383g.f19326c.deleteThread(this.f19382f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f19384a;

        public p0(s0 s0Var) {
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
            this.f19384a = s0Var;
        }

        @Override // c.a.p0.i2.i.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19384a.f19326c.hideKeyBroad();
            }
        }

        @Override // c.a.p0.i2.i.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19384a.l == null) {
                return;
            }
            if (this.f19384a.p != null) {
                this.f19384a.p.t();
            }
            this.f19384a.l.setSelection(0);
        }
    }

    /* loaded from: classes3.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19385e;

        public q(s0 s0Var, AlertDialog alertDialog) {
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
            this.f19385e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19385e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19386e;

        public q0(s0 s0Var) {
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
            this.f19386e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new c.a.o0.s.q.t0(this.f19386e.f19326c.getActivity(), "pb_huitie"))) {
                this.f19386e.f19326c.processProfessionPermission();
                if (this.f19386e.f19326c == null || this.f19386e.f19326c.getPbModel() == null || this.f19386e.f19326c.getPbModel().O0() == null || this.f19386e.f19326c.getPbModel().O0().O() == null || this.f19386e.f19326c.getPbModel().O0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f19386e.f19326c.getPbModel().f1()).param("fid", this.f19386e.f19326c.getPbModel().O0().n()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19386e.f19326c.getPbModel().f54865f).param("fid", this.f19386e.f19326c.getPbModel().O0().n()).param("obj_locate", 1).param("uid", this.f19386e.f19326c.getPbModel().O0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19388f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f19389g;

        public r(s0 s0Var, AlertDialog alertDialog, SparseArray sparseArray) {
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
            this.f19389g = s0Var;
            this.f19387e = alertDialog;
            this.f19388f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f19387e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f19389g.f19326c.getPbActivity(), R.string.neterror);
                } else {
                    this.f19389g.f19326c.deleteThread(this.f19388f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19390a;

        /* renamed from: b  reason: collision with root package name */
        public int f19391b;

        /* renamed from: c  reason: collision with root package name */
        public PbReplyTitleViewHolder f19392c;

        public r0() {
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
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f19393e;

        public s(s0 s0Var, AlertDialog alertDialog) {
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
            this.f19393e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f19393e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class t implements g.InterfaceC0893g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.s.s.a f19394a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f19395b;

        public t(s0 s0Var, c.a.o0.s.s.a aVar) {
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
            this.f19395b = s0Var;
            this.f19394a = aVar;
        }

        @Override // c.a.p0.i.g.InterfaceC0893g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19395b.f19326c.deleteThread(this.f19394a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19396a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s0 f19397b;

        public u(s0 s0Var, SparseArray sparseArray) {
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
            this.f19397b = s0Var;
            this.f19396a = sparseArray;
        }

        @Override // c.a.p0.i.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f19397b.f19326c.deleteThread(this.f19396a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19398e;

        public v(s0 s0Var) {
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
            this.f19398e = s0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f19398e.X = (String) compoundButton.getTag();
                if (this.f19398e.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f19398e.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f19398e.X != null && !str.equals(this.f19398e.X)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19399e;

        public w(s0 s0Var) {
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
            this.f19399e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19399e.R instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f19399e.R, this.f19399e.f19326c.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19400e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19401f;

        public x(s0 s0Var, b.c cVar) {
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
            this.f19401f = s0Var;
            this.f19400e = cVar;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19401f.Z.dismiss();
                this.f19400e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f19402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f19403f;

        public y(s0 s0Var, b.c cVar) {
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
            this.f19403f = s0Var;
            this.f19402e = cVar;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f19403f.Z.dismiss();
                this.f19402e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s0 f19404e;

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
            this.f19404e = s0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!(view instanceof HeadImageView) || this.f19404e.B0 == null || this.f19404e.B0.O() == null || this.f19404e.B0.O().J() == null || this.f19404e.B0.O().J().getAlaInfo() == null || this.f19404e.B0.O().J().getAlaInfo().live_status != 1) {
                    if (this.f19404e.b1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.f19404e.b1 && this.f19404e.B0 != null && this.f19404e.B0.O() != null && this.f19404e.B0.O().J() != null && this.f19404e.B0.O().J().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.f19404e.f19326c.getPbActivity() != null) {
                        this.f19404e.f19326c.getPbActivity().mEvent.f19051b.onClick(view);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.f19404e.B0.n());
                statisticItem2.param("fname", this.f19404e.B0.o());
                statisticItem2.param("obj_param1", this.f19404e.B0.O().J().getAlaInfo().user_info != null ? this.f19404e.B0.O().J().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.f19404e.B0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.f19404e.B0.O().J().getAlaInfo()));
                if (this.f19404e.B0.O().J().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.f19404e.B0.O().J().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.f19404e.B0.O().J().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.f19404e.f19326c.getPageContext(), this.f19404e.B0.O().J().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1193991507, "Lc/a/p0/i2/k/e/s0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1193991507, "Lc/a/p0/i2/k/e/s0;");
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
        e2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        f2 = new e0();
    }

    public s0(PbFragment pbFragment, View.OnClickListener onClickListener, c.a.p0.i2.i.c cVar) {
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
        this.f19326c = null;
        this.f19327d = null;
        this.f19328e = null;
        this.f19329f = 0;
        this.f19330g = new Handler();
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
        this.R0 = new r0();
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
        this.E1 = new i(this, 2921552);
        this.H1 = new n0(this, 2921306);
        this.I1 = new e(this);
        this.J1 = new f(this, 2005016);
        this.K1 = new Handler();
        this.M1 = new h(this, 2004009);
        this.O1 = true;
        this.P1 = new z(this);
        this.Q1 = false;
        this.R1 = null;
        this.T1 = new ArrayList();
        this.V1 = false;
        this.t1 = System.currentTimeMillis();
        this.f19326c = pbFragment;
        this.K = onClickListener;
        this.f0 = cVar;
        this.e1 = c.a.e.e.p.l.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19326c.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.f19327d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.j0 = this.f19327d.findViewById(R.id.bottom_shadow);
        this.o1 = (NavigationBarCoverTip) this.f19327d.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.f19328e = this.f19327d.findViewById(R.id.statebar_view);
        this.D1 = (RightFloatLayerView) this.f19327d.findViewById(R.id.right_layer_view);
        this.f19326c.registerListener(this.E1);
        this.z = (ObservedChangeRelativeLayout) this.f19327d.findViewById(R.id.title_wrapper);
        this.m = (NoNetworkView) this.f19327d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.f19327d.findViewById(R.id.new_pb_list);
        this.I0 = (FrameLayout) this.f19327d.findViewById(R.id.root_float_header);
        this.J0 = new TextView(this.f19326c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.e.e.p.l.g(this.f19326c.getActivity(), R.dimen.ds88));
        this.l.addHeaderView(this.J0, 0);
        this.l.setTextViewAdded(true);
        this.U0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.O0 = new View(this.f19326c.getPageContext().getPageActivity());
        if (c.a.o0.e1.b.e.d()) {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.O0.setLayoutParams(new AbsListView.LayoutParams(-1, this.U0));
        }
        this.O0.setVisibility(4);
        this.l.addFooterView(this.O0);
        this.l.setOnTouchListener(this.f19326c.mOnTouchListener);
        this.f19324a = new o0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f19324a);
        this.f19331h = new c.a.p0.i2.k.e.g1.c(pbFragment, this.f19327d);
        if (this.f19326c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19327d.findViewById(R.id.manga_view_stub);
            this.f19333j = viewStub;
            viewStub.setVisibility(0);
            c.a.p0.i2.k.e.g1.b bVar = new c.a.p0.i2.k.e.g1.b(pbFragment);
            this.f19332i = bVar;
            bVar.c();
            this.f19331h.f19209a.setVisibility(8);
            layoutParams.height = c.a.e.e.p.l.g(this.f19326c.getActivity(), R.dimen.ds120);
        }
        this.J0.setLayoutParams(layoutParams);
        this.f19331h.p().setOnTouchListener(new c.a.p0.i2.i.a(new p0(this)));
        this.m0 = this.f19327d.findViewById(R.id.view_comment_top_line);
        this.n0 = this.f19327d.findViewById(R.id.pb_editor_tool_comment);
        c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.y0 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f19327d.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.p0 = headImageView;
        headImageView.setVisibility(0);
        this.p0.setIsRound(true);
        this.p0.setBorderWidth(c.a.e.e.p.l.g(this.f19326c.getContext(), R.dimen.L_X01));
        this.p0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.p0.setPlaceHolder(0);
        M1();
        this.q0 = (TextView) this.f19327d.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f19327d.findViewById(R.id.pb_editer_tool_comment_layout);
        this.o0 = linearLayout;
        linearLayout.setOnClickListener(new q0(this));
        this.r0 = (ImageView) this.f19327d.findViewById(R.id.pb_editor_tool_comment_icon);
        this.z1 = (MaskView) this.f19327d.findViewById(R.id.mask_view);
        this.r0.setOnClickListener(this.K);
        boolean booleanExtra = this.f19326c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.f19327d.findViewById(R.id.pb_editor_tool_collection);
        this.s0 = imageView;
        imageView.setOnClickListener(this.K);
        if (booleanExtra) {
            this.s0.setVisibility(8);
        } else {
            this.s0.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) this.f19327d.findViewById(R.id.pb_editor_tool_share);
        this.t0 = imageView2;
        imageView2.setOnClickListener(this.K);
        this.u0 = new c.a.p0.i2.p.h(this.t0);
        TextView textView = (TextView) this.f19327d.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.v0 = textView;
        textView.setVisibility(0);
        this.G0 = (ViewStub) this.f19327d.findViewById(R.id.interview_status_stub);
        this.q = new c.a.p0.i2.k.e.a1.d(this.f19326c, cVar);
        this.s = new c.a.p0.i2.k.e.a1.h(this.f19326c, cVar, this.K);
        c.a.p0.i2.k.e.i iVar = new c.a.p0.i2.k.e.i(this.f19326c, this.l);
        this.A = iVar;
        iVar.q0(this.K);
        this.A.s0(this.f0);
        this.A.n0(this.L);
        this.A.p0(this.f19326c.onSwitchChangeListener);
        a aVar = new a(this);
        this.O = aVar;
        this.A.m0(aVar);
        s1();
        m1();
        c.a.p0.i2.k.e.a1.g gVar = new c.a.p0.i2.k.e.a1.g(this.f19326c);
        this.u = gVar;
        gVar.f18947f = 2;
        l1();
        this.v.a(this.l);
        this.r.a(this.l);
        this.s.h(this.l);
        this.q.a(this.l);
        PbListView pbListView = new PbListView(this.f19326c.getPageContext().getPageActivity());
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
        this.J = this.f19327d.findViewById(R.id.viewstub_progress);
        this.f19326c.registerListener(this.M1);
        this.W0 = new PbFakeFloorModel(this.f19326c.getPageContext());
        PbModel pbModel = this.f19326c.getPbModel();
        this.W0.O(pbModel.E(), pbModel.A(), pbModel.B(), pbModel.z(), pbModel.F());
        c.a.p0.i2.k.e.u uVar = new c.a.p0.i2.k.e.u(this.f19326c.getPageContext(), this.W0, this.f19327d);
        this.X0 = uVar;
        uVar.k(new b(this));
        this.X0.m(this.f19326c.mOnFloorPostWriteNewCallback);
        this.W0.Q(new c(this));
        if (this.f19326c.getPbModel() != null && !StringUtils.isNull(this.f19326c.getPbModel().R0())) {
            PbFragment pbFragment2 = this.f19326c;
            pbFragment2.showToast(pbFragment2.getPbModel().R0());
        }
        this.K0 = this.f19327d.findViewById(R.id.pb_expand_blank_view);
        this.L0 = this.f19327d.findViewById(R.id.bottom_rec_float_title);
        View findViewById2 = this.f19327d.findViewById(R.id.sticky_view);
        this.M0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f19326c.getPbModel() != null && this.f19326c.getPbModel().B0()) {
            this.K0.setVisibility(0);
            u2(true);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.M0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = X1;
            this.M0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f19326c.getPageContext(), this.f19327d.findViewById(R.id.pb_reply_expand_view));
        this.N0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.setSortButtonId(pbFragment.sortSwitchId);
        this.N0.mDivideLineTop.setVisibility(8);
        this.N0.setPbCommonOnclickListener(this.K);
        this.N0.setOnSwitchChangeListener(this.f19326c.onSwitchChangeListener);
        this.f19326c.registerListener(this.J1);
        this.f19326c.registerListener(this.H1);
        PbFragment pbFragment3 = this.f19326c;
        this.y1 = new c.a.p0.i2.p.g(pbFragment3, pbFragment3.getUniqueId());
        this.A1 = (FallingView) this.f19327d.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f19327d.findViewById(R.id.falling_ad_view);
        this.B1 = tbImageView;
        tbImageView.setPlaceHolder(2);
        Y();
        q2(false);
        this.k0 = this.f19327d.findViewById(R.id.pb_comment_container);
        X(c.a.o0.e1.b.e.d());
        this.C1 = new c.a.p0.i2.o.j.a();
    }

    public static /* synthetic */ float K1(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public TextView A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.l() : (TextView) invokeV.objValue;
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
            this.A.d0(z2);
        }
    }

    public void A3(b1 b1Var, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, b1Var, eVar) == null) || b1Var == null) {
            return;
        }
        int a3 = b1Var.a();
        int h2 = b1Var.h();
        c.a.o0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.show();
        } else {
            this.B = new c.a.o0.s.s.a(this.f19326c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19326c.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
            this.D = inflate;
            this.B.setContentView(inflate);
            this.B.setPositiveButton(R.string.dialog_ok, eVar);
            this.B.setNegativeButton(R.string.dialog_cancel, new g0(this));
            this.B.setOnCalcelListener(new h0(this));
            this.B.create(this.f19326c.getPageContext()).show();
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
        this.f19326c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.E, 150);
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.i2.p.h hVar = this.u0;
            if (hVar != null) {
                return hVar.f();
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
            this.u1 = z2;
        }
    }

    public void B3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) || this.l == null || (textView = this.J0) == null || this.f19328e == null) {
            return;
        }
        if (z2) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f19328e.setVisibility(0);
            } else {
                this.f19328e.setVisibility(8);
                this.l.removeHeaderView(this.J0);
                this.l.setTextViewAdded(false);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.J0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = X1;
                this.J0.setLayoutParams(layoutParams);
            }
            s2();
            return;
        }
        AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) textView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + I0(true);
            this.J0.setLayoutParams(layoutParams2);
        }
        s2();
        m2();
    }

    public PbInterviewStatusView C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.H0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean C1(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c2Var)) == null) {
            if (c2Var == null || c2Var.J() == null) {
                return false;
            }
            PostData w0 = w0(this.B0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (w0 == null || w0.t() == null) ? "" : w0.t().getUserId());
        }
        return invokeL.booleanValue;
    }

    public void C2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.m1 = z2;
        }
    }

    public final void C3(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) || eVar == null || eVar.O() == null || eVar.O().A2()) {
            return;
        }
        boolean z2 = eVar.O().o0() == 1;
        boolean z3 = eVar.O().p0() == 1;
        c.a.p0.i2.k.e.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.j(eVar, z2, z3);
        }
        c.a.p0.i2.k.e.i iVar = this.A;
        if (iVar == null || iVar.t() == null) {
            return;
        }
        this.A.t().showThreadTypeStampBottomPart(eVar, z2, z3);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m1 : invokeV.booleanValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public void D2(boolean z2) {
        c.a.p0.i2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.r(z2);
    }

    @SuppressLint({"CutPasteId"})
    public void D3(c.a.p0.i2.h.e eVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, eVar, z2) == null) || eVar == null) {
            return;
        }
        N3(eVar, z2);
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
            c.a.p0.i2.h.e eVar = this.B0;
            return eVar == null || eVar.m() == null || "0".equals(this.B0.m().getId()) || "me0407".equals(this.B0.m().getName());
        }
        return invokeV.booleanValue;
    }

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.A.f0(z2);
        }
    }

    public void E3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f19326c.showToast(str);
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
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            return iVar != null && iVar.f();
        }
        return invokeV.booleanValue;
    }

    public void F2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.A.k0(z2);
        }
    }

    public void F3(final c.a.o0.u.a aVar, Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new c.InterfaceC0939c() { // from class: c.a.p0.i2.k.e.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.p0.i2.p.c.InterfaceC0939c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? s0.K1(random) : invokeV.floatValue;
                }
            });
            bVar.q(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            c.a.p0.i2.p.c l2 = bVar.l();
            this.A1.start();
            this.A1.addFallObject(l2, 19);
            c.a.e.e.m.e.a().postDelayed(this.I1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.B1;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.i2.k.e.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            s0.this.L1(aVar, i2, view);
                        }
                    }
                });
            }
        }
    }

    public SparseArray<Object> G0(c.a.p0.i2.h.e eVar, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData w0;
        c.a.o0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (eVar == null || (w0 = w0(eVar, z2)) == null) {
                return null;
            }
            String userId = w0.t().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, w0.E());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (w0.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, w0.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, w0.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, w0.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, w0.E());
                }
                sparseArray.put(R.id.tag_del_post_id, w0.E());
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
                        if (y1Var != null && !StringUtils.isNull(y1Var.getForumName()) && (e0Var = y1Var.f14098g) != null && e0Var.f13895a && !e0Var.f13897c && ((i3 = e0Var.f13896b) == 1 || i3 == 2)) {
                            sb.append(c.a.e.e.p.k.cutString(y1Var.getForumName(), 12));
                            sb.append(this.f19326c.getString(R.string.forum));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f19326c.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.F1 : invokeV.booleanValue;
    }

    public void G2(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, gVar) == null) {
            this.S1 = gVar;
            c.a.p0.i2.p.i iVar = this.F;
            if (iVar != null) {
                iVar.a(gVar);
            }
        }
    }

    public void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f19326c.showProgressBar();
        }
    }

    public c.a.p0.i2.k.d.a H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.k1 : (c.a.p0.i2.k.d.a) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            c.a.p0.i2.p.h hVar = this.u0;
            if (hVar == null) {
                return false;
            }
            return hVar.h();
        }
        return invokeV.booleanValue;
    }

    public void H2(String str) {
        c.a.p0.i2.k.e.g1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (bVar = this.f19332i) == null) {
            return;
        }
        bVar.b(str);
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            FallingView fallingView = this.A1;
            if (fallingView != null) {
                fallingView.stop();
            }
            if (this.B1 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.I1);
                this.B1.setVisibility(8);
            }
        }
    }

    public final int I0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.H0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            EditorTools editorTools = this.h0;
            return editorTools != null && editorTools.isToolVisible();
        }
        return invokeV.booleanValue;
    }

    public void I2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z2) == null) {
            this.Z0 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.a1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void I3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.T1 == null) {
            return;
        }
        while (this.T1.size() > 0) {
            TbImageView remove = this.T1.remove(0);
            if (remove != null) {
                remove.stopLoading();
            }
        }
    }

    public View J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public final void J1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f19326c.getPageContext().getPageActivity(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void J2(PbFragment.a3 a3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, a3Var) == null) {
        }
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.b0 = z2;
        }
    }

    public PbListView K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public void K2(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, zVar) == null) {
            this.L = zVar;
            this.A.n0(zVar);
            this.k1.q(this.L);
        }
    }

    public void K3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            this.f19331h.I(z2);
            if (z2 && this.F0) {
                this.G.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                this.l.setNextPage(this.G);
                this.f19329f = 2;
            }
            M1();
        }
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            try {
                return Integer.parseInt(this.E.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public /* synthetic */ void L1(c.a.o0.u.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = this.f19326c.getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.e.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void L2(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bVar) == null) {
            this.M = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void L3(c.a.p0.i2.h.c cVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f19331h.J();
        if (!StringUtils.isNull(cVar.f18724b)) {
            this.f19331h.G(cVar.f18724b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
        int d3 = c.a.e.e.m.b.d(cVar.f18723a, 0);
        if (d3 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
        } else if (d3 != 300) {
            string = d3 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.system);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
        }
        this.f19326c.showNetRefreshView(this.f19327d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new c0(this, cVar.f18725c));
    }

    public View M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.K0 : (View) invokeV.objValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.p0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.p0.setImageResource(0);
                this.p0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
                return;
            }
            this.p0.setImageResource(R.drawable.transparent_bg);
        }
    }

    public void M2(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void M3(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, eVar) == null) {
            if (eVar != null && AntiHelper.o(eVar.O())) {
                c.a.p0.i2.p.h hVar = this.u0;
                if (hVar != null) {
                    hVar.k(false);
                    this.u0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.t0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.t0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            c.a.p0.i2.p.h hVar2 = this.u0;
            if (hVar2 == null || !hVar2.g()) {
                ViewGroup.LayoutParams layoutParams2 = this.t0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.t0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.t0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public PbFakeFloorModel N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.W0 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void N1(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || this.E0 == i2) {
            return;
        }
        this.E0 = i2;
        D3(this.B0, this.A0);
        l2(this.B0, this.A0, this.D0, i2);
        this.f19326c.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f19326c.getBaseFragmentActivity().getLayoutMode().j(this.f19327d);
        SkinManager.setBackgroundColor(this.f19327d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
        c.a.p0.i2.k.e.a1.i iVar = this.p;
        if (iVar != null) {
            iVar.h(i2);
        }
        c.a.p0.i2.k.e.a1.e eVar = this.t;
        if (eVar != null) {
            eVar.c(i2);
        }
        c.a.p0.i2.k.e.a1.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
        c.a.p0.i2.k.e.a1.f fVar = this.r;
        if (fVar != null) {
            fVar.c(i2);
        }
        c.a.p0.i2.k.e.a1.h hVar = this.s;
        if (hVar != null) {
            hVar.q(i2);
        }
        c.a.p0.i2.k.e.a1.g gVar = this.u;
        if (gVar != null) {
            gVar.d();
        }
        c.a.p0.i2.k.e.a1.c cVar = this.v;
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
            this.f19326c.getBaseFragmentActivity().getLayoutMode().j(this.I);
            SkinManager.setBackgroundResource(this.I, R.drawable.pb_foot_more_trans_selector);
        }
        c.a.o0.s.s.a aVar = this.B;
        if (aVar != null) {
            aVar.autoChangeSkinType(this.f19326c.getPageContext());
        }
        J3(this.b0);
        this.A.X();
        c.a.p0.i2.p.i iVar2 = this.F;
        if (iVar2 != null) {
            iVar2.D(i2);
        }
        EditorTools editorTools = this.h0;
        if (editorTools != null) {
            editorTools.onChangeSkinType(i2);
        }
        c.a.p0.i2.p.e eVar2 = this.H;
        if (eVar2 != null) {
            eVar2.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.onChangeSkinMode();
            }
        }
        O3();
        UtilHelper.setStatusBarBackground(this.f19328e, i2);
        UtilHelper.setStatusBarBackground(this.M0, i2);
        if (this.w != null) {
            c.a.o0.u0.a.a(this.f19326c.getPageContext(), this.w);
        }
        c.a.p0.i2.k.e.u uVar = this.X0;
        if (uVar != null) {
            uVar.h(i2);
        }
        c.a.p0.i2.k.e.g1.c cVar2 = this.f19331h;
        if (cVar2 != null) {
            c.a.p0.i2.k.e.a1.i iVar3 = this.p;
            if (iVar3 != null) {
                iVar3.i(i2);
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
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f19326c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        c.a.p0.i2.h.e eVar3 = this.B0;
        if (eVar3 != null && eVar3.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.r0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        M3(this.B0);
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
        c.a.p0.i2.k.d.a aVar2 = this.k1;
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
        c.a.p0.i2.p.h hVar2 = this.u0;
        if (hVar2 != null) {
            hVar2.i();
        }
        c.a.p0.i2.p.g gVar2 = this.y1;
        if (gVar2 != null) {
            gVar2.c();
        }
        RightFloatLayerView rightFloatLayerView = this.D1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.onChangeSkinType();
        }
        SkinManager.setBackgroundColor(this.L0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0.findViewById(R.id.tv_title), R.color.CAM_X0105);
    }

    public void N2(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public boolean N3(c.a.p0.i2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048630, this, eVar, z2)) == null) {
            if (eVar == null) {
                return false;
            }
            if (this.r != null) {
                if (eVar.O() != null && eVar.O().m0() == 0 && !eVar.O().A2() && !this.F1) {
                    if (eVar.O() != null) {
                        c2 O = eVar.O();
                        O.T2(true, j3(eVar));
                        O.e4(3);
                        O.Z3("2");
                    }
                    if (eVar.O().J1()) {
                        this.s.t(this.l);
                        this.r.d(this.l);
                        this.r.a(this.l);
                        this.s.h(this.l);
                        this.s.x(this.B0);
                        if (w1(eVar)) {
                            this.r.d(this.l);
                        } else {
                            this.r.e(eVar);
                        }
                    } else {
                        this.s.x(this.B0);
                        if (w1(eVar)) {
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
            C3(eVar);
            this.A0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public c.a.p0.i2.k.e.u O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.X0 : (c.a.p0.i2.k.e.u) invokeV.objValue;
    }

    public void O1(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, configuration) == null) || configuration == null) {
            return;
        }
        d0();
        if (configuration.orientation == 2) {
            c1();
            e1();
        } else {
            r2();
        }
        c.a.p0.i2.k.e.u uVar = this.X0;
        if (uVar != null) {
            uVar.c();
        }
        this.f19326c.hideKeyBroad();
        this.z.setVisibility(8);
        this.f19331h.C(false);
        this.f19326c.setNavigationBarShowFlag(false);
        if (this.p != null) {
            if (configuration.orientation == 1) {
                Y0().setVisibility(0);
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
            this.p.j(configuration);
            this.I0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void O2(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.A.r0(onClickListener);
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.f19326c.getIsMangaThread()) {
            if (this.f19326c.getMangaPrevChapterId() == -1) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0110, 1);
            }
            if (this.f19326c.getMangaNextChapterId() == -1) {
                SkinManager.setViewTextColor(this.y, R.color.CAM_X0110, 1);
            }
        }
    }

    public c.a.p0.i2.k.e.a1.i P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.p : (c.a.p0.i2.k.e.a1.i) invokeV.objValue;
    }

    public void P1() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            RelativeLayout relativeLayout = this.f19327d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.f19327d.getHandler().removeCallbacksAndMessages(null);
            }
            c.a.p0.i2.p.h hVar = this.u0;
            if (hVar != null) {
                hVar.j();
            }
            c.a.p0.i2.k.e.n0 n0Var = this.Y0;
            if (n0Var != null) {
                n0Var.a();
            }
            c.a.p0.i2.k.e.g0 g0Var = this.n1;
            if (g0Var != null) {
                g0Var.c();
            }
            PbTopTipView pbTopTipView = this.f1;
            if (pbTopTipView != null) {
                pbTopTipView.hide();
            }
            this.f19326c.hideProgressBar();
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
            this.K1 = null;
            this.f19330g.removeCallbacksAndMessages(null);
            this.A.Y(3);
            View view = this.f19328e;
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.a();
            }
            c.a.p0.i2.k.e.i iVar2 = this.A;
            if (iVar2 != null) {
                iVar2.Z();
            }
            this.l.setOnLayoutListener(null);
            c.a.p0.i2.k.e.b1.c cVar = this.j1;
            if (cVar != null) {
                cVar.h();
            }
            PbEmotionBar pbEmotionBar = this.S0;
            if (pbEmotionBar != null) {
                pbEmotionBar.onDestroy();
            }
            c.a.p0.i2.k.e.a1.h hVar2 = this.s;
            if (hVar2 != null) {
                hVar2.r();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.f19324a);
            }
        }
    }

    public void P2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.v1 = i2;
        }
    }

    public void P3(c.a.p0.i2.h.e eVar) {
        c.a.p0.i2.k.e.a1.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, eVar) == null) || (dVar = this.q) == null) {
            return;
        }
        dVar.h(eVar, this.A0);
    }

    public final PostData Q0(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, eVar)) == null) {
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

    public void Q1(TbRichText tbRichText) {
        c.a.p0.i2.h.e eVar;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, tbRichText) == null) || (eVar = this.B0) == null || eVar.F() == null || this.B0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i2 = 0; i2 < this.B0.F().size() && (postData = this.B0.F().get(i2)) != null && postData.t() != null && !StringUtils.isNull(postData.t().getUserId()); i2++) {
            if (this.B0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                c.a.p0.i2.k.d.a aVar = this.k1;
                if (aVar != null && aVar.l()) {
                    g3(false);
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

    public void Q2(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.s.u(onLongClickListener);
            this.A.o0(onLongClickListener);
            c.a.p0.i2.k.d.a aVar = this.k1;
            if (aVar != null) {
                aVar.r(onLongClickListener);
            }
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

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (!c.a.e.e.p.k.isEmpty(this.r1)) {
                return this.r1;
            }
            if (this.f19326c != null) {
                this.r1 = TbadkCoreApplication.getInst().getResources().getString(c.a.p0.i2.k.e.q0.c());
            }
            return this.r1;
        }
        return (String) invokeV.objValue;
    }

    public boolean R1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i2)) == null) {
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                return iVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void R2(PostData postData, c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, postData, eVar) == null) {
            this.s.v(postData, eVar);
        }
    }

    public void S() {
        c.a.p0.i2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (hVar = this.u0) == null) {
            return;
        }
        hVar.l(false);
    }

    public final int S0(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, pbReplyTitleViewHolder)) == null) {
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
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || this.f19326c == null) {
            return;
        }
        if ((this.u1 || this.v1 == 17) && c.a.o0.b.d.o0()) {
            c.a.p0.i2.h.e eVar = this.B0;
            if (eVar == null || eVar.m() == null || c.a.e.e.p.k.isEmpty(this.B0.m().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19326c.getContext()).createNormalCfg(this.B0.m().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.B0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.B0.m().getId()));
        } else if (!this.c1 || this.b1 || (postData = this.C0) == null || postData.t() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.f19326c.isSimpleForum() ? 2 : 1).param("obj_type", this.b1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19326c.getPageContext().getPageActivity(), this.C0.t().getUserId(), this.C0.t().getUserName(), this.f19326c.getPbModel().p0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void S2(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048649, this, z2, postWriteCallBackData) == null) {
            this.f19326c.hideProgressBar();
            if (z2) {
                d0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                e0();
            } else {
                d0();
            }
        }
    }

    public boolean T(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z2)) == null) {
            EditorTools editorTools = this.h0;
            if (editorTools == null || !editorTools.isToolVisible()) {
                return false;
            }
            this.h0.hideTools();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? R.id.richText : invokeV.intValue;
    }

    public void T1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z2) == null) {
            if (z2) {
                m3();
            } else {
                f1();
            }
            this.R0.f19392c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            g2(this.R0.f19392c, false);
        }
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.f19326c.hideProgressBar();
            j0();
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
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

    public final int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            I3();
            this.A.Y(1);
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.l();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void U2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (pbFragment = this.f19326c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        c.a.e.e.p.l.x(this.f19326c.getPageContext().getPageActivity(), this.f19326c.getBaseFragmentActivity().getCurrentFocus());
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || this.B0 == null || !c.a.o0.b.d.X() || c.a.p0.i2.k.e.f1.b.k(this.B0.Q())) {
            return;
        }
        this.u0.e();
        c.a.p0.i2.k.e.f1.b.b(this.B0.Q());
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.E0 : invokeV.intValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            this.A.Y(2);
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.m();
                if (TbSingleton.getInstance().isNotchScreen(this.f19326c.getFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19326c.getFragmentActivity())) {
                    return;
                }
                a1().setSystemUiVisibility(4);
            }
        }
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            this.G.x();
            this.G.O();
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (!this.f19326c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.e0));
            } else if (this.f19326c.checkPrivacyBeforeInput()) {
                c.a.o0.x.w.e pbEditor = this.f19326c.getPbEditor();
                if (pbEditor != null && (pbEditor.C() || pbEditor.E())) {
                    this.f19326c.getPbEditor().A(false, null);
                    return;
                }
                if (this.h0 != null) {
                    p1();
                }
                EditorTools editorTools = this.h0;
                if (editorTools != null) {
                    this.x0 = false;
                    if (editorTools.findToolById(2) != null) {
                        c.a.p0.i3.g0.a.c(this.f19326c.getPageContext(), (View) this.h0.findToolById(2).k, false, f2);
                    }
                }
                c1();
            }
        }
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.f19328e : (View) invokeV.objValue;
    }

    public void W1(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        c.a.p0.i2.k.e.a1.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048664, this, absListView, i2, i3, i4) == null) {
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.n(absListView, i2, i3, i4);
            }
            c.a.p0.i2.k.e.g1.c cVar = this.f19331h;
            if (cVar != null && (hVar = this.s) != null) {
                cVar.x(hVar.m());
            }
            r0 r0Var = this.R0;
            r0Var.f19390a = i2;
            r0Var.f19391b = this.l.getHeaderViewsCount();
            this.R0.f19392c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
            f3(R(absListView, i2));
            int i5 = 0;
            g2(this.R0.f19392c, false);
            c0();
            if (!this.G.m() || this.G.C) {
                return;
            }
            r0 r0Var2 = this.R0;
            if (r0Var2 != null && (pbReplyTitleViewHolder = r0Var2.f19392c) != null && pbReplyTitleViewHolder.getView() != null) {
                i5 = this.R0.f19392c.getView().getTop() < 0 ? this.R0.f19392c.getView().getHeight() : this.R0.f19392c.getView().getBottom();
            }
            this.G.e(i5);
            this.G.C = true;
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) {
            this.s.w(z2);
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

    public PbThreadPostView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void X1(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048668, this, absListView, i2) == null) {
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.o(absListView, i2);
            }
            if (!this.W1 && i2 == 0) {
                this.U1 = U0();
                this.R0.f19392c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
                g2(this.R0.f19392c, true);
                c0();
                this.A.b0(true);
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.D1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.onScrollIdle();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.D1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.onScrollDragging();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.D1) == null) {
            } else {
                rightFloatLayerView.onScrollSettling();
            }
        }
    }

    public void X2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.q0.performClick();
            if (StringUtils.isNull(str) || this.f19326c.getPbEditor() == null || this.f19326c.getPbEditor().w() == null || this.f19326c.getPbEditor().w().i() == null) {
                return;
            }
            EditText i2 = this.f19326c.getPbEditor().w().i();
            i2.setText(str);
            i2.setSelection(str.length());
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            c.a.p0.i2.k.d.a aVar = new c.a.p0.i2.k.d.a(this.f19326c, this, (ViewStub) this.f19327d.findViewById(R.id.more_god_reply_popup));
            this.k1 = aVar;
            aVar.o(this.K);
            this.k1.p(this.O);
            this.k1.q(this.L);
            this.k1.o(this.K);
            this.k1.s(this.f0);
        }
    }

    public RelativeLayout Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.z : (RelativeLayout) invokeV.objValue;
    }

    public void Y1(ArrayList<c.a.o0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, arrayList) == null) {
            if (this.S == null) {
                this.S = LayoutInflater.from(this.f19326c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f19326c.getBaseFragmentActivity().getLayoutMode().j(this.S);
            if (this.R == null) {
                Dialog dialog = new Dialog(this.f19326c.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.R = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.R.setCancelable(true);
                this.g0 = (ScrollView) this.S.findViewById(R.id.good_scroll);
                this.R.setContentView(this.S);
                WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.R.getWindow().setAttributes(attributes);
                this.U = new v(this);
                this.T = (LinearLayout) this.S.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.S.findViewById(R.id.dialog_button_cancel);
                this.W = textView;
                textView.setOnClickListener(new w(this));
                TextView textView2 = (TextView) this.S.findViewById(R.id.dialog_button_ok);
                this.V = textView2;
                textView2.setOnClickListener(this.K);
            }
            this.T.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton Z = Z("0", this.f19326c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(Z);
            Z.setChecked(true);
            this.T.addView(Z);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.o0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton Z2 = Z(String.valueOf(m0Var.a()), m0Var.b());
                        this.n.add(Z2);
                        View view = new View(this.f19326c.getPageContext().getPageActivity());
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
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19326c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19326c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19326c.getPageContext().getPageActivity(), 186.0f);
                }
                this.g0.setLayoutParams(layoutParams2);
                this.g0.removeAllViews();
                LinearLayout linearLayout = this.T;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.g0.addView(this.T);
                }
            }
            c.a.e.e.m.g.j(this.R, this.f19326c.getPageContext());
        }
    }

    public void Y2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public final CustomBlueCheckRadioButton Z(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048674, this, str, str2)) == null) {
            Activity pageActivity = this.f19326c.getPageContext().getPageActivity();
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

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? R.id.user_icon_box : invokeV.intValue;
    }

    public void Z1(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048676, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            a2(i2, str, i3, z2, null);
        }
    }

    public void Z2(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, list) == null) {
            this.i1 = list;
            c.a.p0.i2.k.e.b1.c cVar = this.j1;
            if (cVar != null) {
                cVar.m(list);
            }
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || this.V1) {
            return;
        }
        TiebaStatic.log("c10490");
        this.V1 = true;
        c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f19326c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(Z1, Integer.valueOf(b2));
        aVar.setTitle(R.string.grade_thread_tips);
        View inflate = LayoutInflater.from(this.f19326c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
        ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
        aVar.setContentView(inflate);
        aVar.setYesButtonTag(sparseArray);
        aVar.setPositiveButton(R.string.grade_button_tips, this.f19326c);
        aVar.setNegativeButton(R.string.look_again, new i0(this));
        aVar.create(this.f19326c.getPageContext()).show();
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.f19327d : (View) invokeV.objValue;
    }

    public void a2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            b2(i2, str, i3, z2, str2, false);
        }
    }

    public final boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbFragment pbFragment = this.f19326c;
            return (pbFragment == null || pbFragment.getPbModel().O0().m().getDeletedReasonInfo() == null || 1 != this.f19326c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", org.apache.commons.lang3.StringUtils.LF);
            }
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(this.f19326c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f19326c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            aVar.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(Z1, Integer.valueOf(c2));
            aVar.setYesButtonTag(sparseArray);
            aVar.setPositiveButton(R.string.view, this.f19326c);
            aVar.setNegativeButton(R.string.cancel, new j0(this));
            aVar.create(this.f19326c.getPageContext()).show();
        }
    }

    public void b1() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.I0.setVisibility(8);
            }
            c.a.p0.i2.k.e.g1.c cVar = this.f19331h;
            if (cVar == null || (view = cVar.f19212d) == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public void b2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Z1, Integer.valueOf(a2));
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
            this.P = new c.a.o0.s.s.a(this.f19326c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.P.setMessageId(i4);
            } else {
                this.P.setOnlyMessageShowCenter(false);
                this.P.setMessage(str2);
            }
            this.P.setYesButtonTag(sparseArray);
            this.P.setPositiveButton(R.string.dialog_ok, this.f19326c);
            this.P.setNegativeButton(R.string.dialog_cancel, new o(this));
            this.P.setCancelable(true);
            this.P.create(this.f19326c.getPageContext());
            if (z3) {
                i3(sparseArray);
            } else if (z2) {
                i3(sparseArray);
            } else if (a3()) {
                c.a.p0.i.i iVar = new c.a.p0.i.i(this.f19326c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19326c.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19326c.getPbModel().O0().p().has_forum_rule.intValue());
                iVar.i(this.f19326c.getPbModel().O0().m().getId(), this.f19326c.getPbModel().O0().m().getName());
                iVar.h(this.f19326c.getPbModel().O0().m().getImage_url());
                iVar.j(this.f19326c.getPbModel().O0().m().getUser_level());
                p3(sparseArray, i2, iVar, this.f19326c.getPbModel().O0().U(), false);
            } else {
                x3(this.P, i2);
            }
        }
    }

    public void b3() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.I0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            c.a.p0.i2.k.e.g1.c cVar = this.f19331h;
            if (cVar == null || (view = cVar.f19212d) == null) {
                return;
            }
            view.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.w1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0() {
        c.a.p0.i2.p.g gVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (gVar = this.y1) == null) {
            return;
        }
        if (((gVar.a() == null || this.y1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.y1.a())) != -1) {
            if (this.y1.a().getTop() + e2 <= this.K0.getBottom()) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || this.n0 == null) {
            return;
        }
        this.m0.setVisibility(8);
        this.n0.setVisibility(8);
        this.x0 = false;
        PbEmotionBar pbEmotionBar = this.S0;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            q2(false);
        }
    }

    public void c2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048689, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Z1, Integer.valueOf(a2));
            if (z2) {
                d3(sparseArray);
            } else {
                e3(i2, sparseArray);
            }
        }
    }

    public void c3() {
        c.a.p0.i2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.u(this.l);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.f19331h.k();
            c.a.p0.i2.k.e.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PbFragment pbFragment = this.f19326c;
            if (pbFragment != null) {
                c.a.e.e.p.l.x(pbFragment.getContext(), this.E);
            }
            e1();
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.o0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.o0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) || this.n0 == null || this.q0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        c.a.p0.i2.h.e eVar = this.B0;
        boolean z3 = eVar != null && eVar.j0();
        c.a.p0.i2.h.e eVar2 = this.B0;
        this.q0.setText(tbSingleton.getAdVertiComment(z3, eVar2 != null && eVar2.k0(), R0()));
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
        q2(true);
    }

    public void d2(SparseArray<Object> sparseArray, boolean z2) {
        c.a.o0.s.s.f fVar;
        c.a.o0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048693, this, sparseArray, z2) == null) {
            c.a.o0.s.s.i iVar = new c.a.o0.s.s.i(this.f19326c.getContext());
            iVar.q(this.f19326c.getString(R.string.bar_manager));
            iVar.n(new n(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.o0.s.s.f(10, this.f19326c.getString(R.string.delete_post), iVar);
                } else {
                    fVar2 = new c.a.o0.s.s.f(10, this.f19326c.getString(R.string.delete), iVar);
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
                fVar2.f14157d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !G1()) {
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
                c.a.o0.s.s.f fVar3 = new c.a.o0.s.s.f(11, this.f19326c.getString(R.string.forbidden_person), iVar);
                fVar3.f14157d.setTag(sparseArray3);
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
                    fVar = new c.a.o0.s.s.f(12, this.f19326c.getString(R.string.un_mute), iVar);
                } else {
                    fVar = new c.a.o0.s.s.f(12, this.f19326c.getString(R.string.mute), iVar);
                }
                fVar.f14157d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            c.a.p0.i2.k.e.f1.a.e(arrayList);
            if (c.a.o0.b.d.L()) {
                iVar.l(arrayList, false);
            } else {
                iVar.l(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f19326c.getPageContext(), iVar);
            this.N = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final void d3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, sparseArray) == null) || this.f19326c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.s.s.l lVar = new c.a.o0.s.s.l(this.f19326c.getPbActivity());
        lVar.p(R.string.musk_my_thread_confirm);
        lVar.j(R.string.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new r(this, s2, sparseArray));
        aVar2.a(new s(this, s2));
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.f19331h.k();
            c.a.p0.i2.k.e.a1.h hVar = this.s;
            if (hVar != null) {
                hVar.k();
            }
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            h0();
            c.a.o0.s.s.a aVar = this.B;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.o0.s.s.b bVar = this.C;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    public void e1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hide();
        c.a.p0.i2.k.e.b1.c cVar = this.j1;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void e2(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048697, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        d2(sparseArray, false);
    }

    public final void e3(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048698, this, i2, sparseArray) == null) || this.f19326c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.p0.i.i iVar = new c.a.p0.i.i(this.f19326c.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f19326c.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f19326c.getPbModel().O0().p().has_forum_rule.intValue());
        iVar.i(this.f19326c.getPbModel().O0().m().getId(), this.f19326c.getPbModel().O0().m().getName());
        iVar.h(this.f19326c.getPbModel().O0().m().getImage_url());
        iVar.j(this.f19326c.getPbModel().O0().m().getUser_level());
        p3(sparseArray, i2, iVar, this.f19326c.getPbModel().O0().U(), true);
    }

    public void f0() {
        c.a.p0.i2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048699, this) == null) || (hVar = this.u0) == null) {
            return;
        }
        hVar.k(false);
    }

    public void f1() {
        c.a.p0.i2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048700, this) == null) || (cVar = this.f19331h) == null) {
            return;
        }
        cVar.q();
    }

    public void f2(c.a.o0.u.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048701, this, aVar, i2) == null) && c.a.p0.i2.k.e.q0.a(aVar, i2)) {
            this.B1.startLoad(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), this.f19326c.getContext()).subscribe(new d(this, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) {
            this.j0.setVisibility(z2 ? 0 : 8);
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.q.b(this.A0) : invokeV.booleanValue;
    }

    public void g1() {
        c.a.o0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (aVar = this.z0) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void g2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048705, this, pbReplyTitleViewHolder, z2) == null) || this.b1 || this.K0 == null || this.f19331h.p() == null) {
            return;
        }
        View r2 = o0().r();
        if (r2 != null) {
            int[] iArr = new int[2];
            r2.getLocationInWindow(iArr);
            int i3 = iArr[1];
            if (i3 != 0) {
                if (this.K0.getVisibility() == 0 && i3 - this.f19331h.p().getBottom() <= this.K0.getHeight()) {
                    this.L0.setVisibility(0);
                    if (i3 > this.f19331h.p().getBottom()) {
                        i2 = -(((this.K0.getHeight() + this.L0.getHeight()) + this.f19331h.p().getBottom()) - r2.getBottom());
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
                u2(false);
                return;
            }
            this.K0.setVisibility(0);
            u2(true);
            f3(false);
            this.f19331h.f19209a.hideBottomLine();
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
                    measuredHeight = X1 - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                } else {
                    measuredHeight = this.f19331h.p().getMeasuredHeight() - pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight();
                    this.f19331h.f19209a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.P0) {
                    this.K0.setVisibility(0);
                    u2(true);
                    f3(false);
                } else if (top < measuredHeight) {
                    this.K0.setVisibility(0);
                    u2(true);
                    f3(false);
                } else {
                    this.K0.setVisibility(4);
                    u2(false);
                    this.f19331h.f19209a.hideBottomLine();
                }
                if (z2) {
                    this.Q0 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.K0.setVisibility(4);
            u2(false);
            this.f19331h.f19209a.hideBottomLine();
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) || this.n0 == null) {
            return;
        }
        z2(this.f19326c.getPbEditor().D());
        if (this.i0) {
            k3(z2);
        } else {
            d1(z2);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            c.a.o0.s.s.a aVar = this.P;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.Q;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f19326c.getPageContext());
            }
            Dialog dialog2 = this.R;
            if (dialog2 != null) {
                c.a.e.e.m.g.b(dialog2, this.f19326c.getPageContext());
            }
            PopupDialog popupDialog = this.N;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void h1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            if (this.w == null) {
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

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            this.s.s(this.B0, this.C0, this.c1, this.b1);
        }
    }

    public void h3(c.a.p0.i2.h.e eVar) {
        PostData postData;
        c.a.p0.i2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, eVar) == null) || eVar == null || (postData = this.C0) == null || postData.t() == null || (cVar = this.f19331h) == null) {
            return;
        }
        boolean z2 = !this.b1;
        this.c1 = z2;
        cVar.H(z2);
        if (this.f19326c.getPbNavigationAnimDispatcher() != null) {
            this.f19326c.getPbNavigationAnimDispatcher().s(this.c1);
        }
        h2();
        PbFragment pbFragment = this.f19326c;
        if (pbFragment != null && !pbFragment.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
            y1 y1Var = eVar.q().get(0);
            if (y1Var != null) {
                this.f19331h.L(eVar, y1Var.getForumName(), y1Var.getForumId(), y1Var.b(), y1Var.getIsLike());
            }
        } else if (eVar.m() != null) {
            this.f19331h.L(eVar, eVar.m().getName(), eVar.m().getId(), eVar.m().getImage_url(), eVar.m().isLike() == 1);
        }
        if (this.c1) {
            this.s.C(eVar, this.C0, this.c0);
            View view = this.M0;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.l1 == null) {
                this.l1 = new f0(this);
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

    public void i0() {
        c.a.p0.i2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048711, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.b();
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            this.J.setVisibility(8);
        }
    }

    public void i2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.a1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.R0.f19392c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.R0));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.R0.f19392c;
        int S0 = S0(pbReplyTitleViewHolder);
        int measuredHeight = this.z.getMeasuredHeight() + ((int) this.z.getY());
        boolean z2 = this.K0.getVisibility() == 0;
        boolean z3 = this.z.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.A.G() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.mDivideLineTop.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), X1 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.f19331h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.b1 && this.p != null) {
            this.l.setSelectionFromTop(this.A.G() + this.l.getHeaderViewsCount(), this.p.d());
        } else if (this.D0 != 6) {
        } else {
            this.l.setOnLayoutListener(new j(this, S0, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void i3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048714, this, sparseArray) == null) || this.f19326c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.s.s.l lVar = new c.a.o0.s.s.l(this.f19326c.getPbActivity());
        lVar.p(R.string.del_my_thread_confirm);
        lVar.j(R.string.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        AlertDialog s2 = lVar.s();
        aVar.a(new p(this, s2, sparseArray));
        aVar2.a(new q(this, s2));
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.v();
                this.G.f();
            }
            g1();
        }
    }

    public void j1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048716, this) == null) || (rightFloatLayerView = this.D1) == null) {
            return;
        }
        rightFloatLayerView.completeHide();
    }

    public final void j2(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048717, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        M3(eVar);
        if (eVar.s()) {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.s0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String n02 = n0(eVar.O().S0());
        TextView textView = this.v0;
        if (textView != null) {
            textView.setText(n02);
        }
        TextView textView2 = this.w0;
        if (textView2 != null) {
            textView2.setText(n02);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.O()));
    }

    public final boolean j3(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048718, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return false;
            }
            return eVar.O().j0() == 1 || eVar.O().m1() == 33 || !(eVar.O().u1() == null || eVar.O().u1().a() == 0) || eVar.O().p0() == 1 || eVar.O().o0() == 1 || eVar.O().G1() || eVar.O().Z1() || eVar.O().D2() || eVar.O().D1() != null || !c.a.e.e.p.k.isEmpty(eVar.O().N()) || eVar.O().W1() || eVar.O().m2();
        }
        return invokeL.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.l.completePullRefreshPostDelayed(0L);
            g0();
        }
    }

    public void k1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.hideTools();
    }

    public void k2(int i2, c.a.p0.i2.h.e eVar, boolean z2, int i3) {
        PostData w0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048721, this, new Object[]{Integer.valueOf(i2), eVar, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) || i2 <= 0 || (w0 = w0(eVar, z2)) == null || w0.t() == null) {
            return;
        }
        MetaData t2 = w0.t();
        t2.setGiftNum(t2.getGiftNum() + i2);
    }

    public void k3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048722, this, z2) == null) || this.n0 == null || (textView = this.q0) == null) {
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
        q2(true);
    }

    public void l0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f19326c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f19326c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.success));
            } else if (z3) {
                if (c.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                }
                this.f19326c.showToast(str);
            }
        }
    }

    public final void l1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048724, this) == null) && this.v == null && (pbFragment = this.f19326c) != null) {
            this.v = new c.a.p0.i2.k.e.a1.c(pbFragment.getContext());
        }
    }

    public void l2(c.a.p0.i2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048725, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            s3(eVar, z2, i2, i3);
            this.s.q(i3);
        }
    }

    public void l3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048726, this, view) == null) || c.a.o0.s.d0.b.j().g("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.n0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f19326c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f19326c.getContext());
        this.h1 = textView;
        textView.setText(R.string.connection_tips);
        this.h1.setGravity(17);
        this.h1.setPadding(c.a.e.e.p.l.g(this.f19326c.getContext(), R.dimen.ds24), 0, c.a.e.e.p.l.g(this.f19326c.getContext(), R.dimen.ds24), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = c.a.e.e.p.l.g(this.f19326c.getContext(), R.dimen.ds60);
        if (this.h1.getParent() == null) {
            frameLayout.addView(this.h1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f19326c.getContext());
        this.g1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.g1.setHeight(-2);
        this.g1.setWidth(-2);
        this.g1.setFocusable(true);
        this.g1.setOutsideTouchable(false);
        this.g1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new k0(this, i4, i2, i3, view), 100L);
        c.a.o0.s.d0.b.j().t("show_long_press_collection_tips", true);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048728, this) == null) && this.r == null) {
            this.r = new c.a.p0.i2.k.e.a1.f(this.f19326c, this.f0);
        }
    }

    public final void m2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048729, this) == null) && (pbInterviewStatusView = this.H0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.H0.setLayoutParams(layoutParams);
        }
    }

    public void m3() {
        c.a.p0.i2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048730, this) == null) || (cVar = this.f19331h) == null || this.d1) {
            return;
        }
        cVar.D();
        this.d1 = true;
    }

    public final String n0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048731, this, i2)) == null) {
            if (i2 == 0) {
                return this.f19326c.getString(R.string.pb_comment_red_dot_no_reply);
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

    public final void n1(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048732, this, eVar) == null) && eVar != null && eVar.O() != null && eVar.O().Z1() && this.H0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.G0.inflate();
            this.H0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.K);
            this.H0.setCallback(this.f19326c.getInterviewStatusCallback());
            this.H0.setData(this.f19326c, eVar);
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || this.f19329f == 2) {
            return;
        }
        this.l.setNextPage(this.G);
        this.f19329f = 2;
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public c.a.p0.i2.k.e.i o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.A : (c.a.p0.i2.k.e.i) invokeV.objValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && this.f19326c.getIsMangaThread()) {
            ViewStub viewStub = (ViewStub) this.f19327d.findViewById(R.id.manga_mention_controller_view_stub);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.w == null) {
                this.w = (LinearLayout) this.f19327d.findViewById(R.id.manga_controller_layout);
                c.a.o0.u0.a.a(this.f19326c.getPageContext(), this.w);
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

    public void o2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.v.d(pbLandscapeListView);
        this.r.d(this.l);
        this.s.t(this.l);
        this.t.d(this.l);
        this.q.f(this.l);
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if (this.z0 == null) {
                this.z0 = new c.a.o0.s.f0.a(this.f19326c.getPageContext());
            }
            this.z0.h(true);
        }
    }

    public LinearLayout p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.o0 : (LinearLayout) invokeV.objValue;
    }

    public void p1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || this.f19326c == null || (editorTools = this.h0) == null) {
            return;
        }
        editorTools.display();
        if (this.f19326c.getPbEditor() != null) {
            this.f19326c.getPbEditor().Q();
        }
        c1();
    }

    public final void p2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || (pbFragment = this.f19326c) == null || pbFragment.getPbEditor() == null || this.h0 == null) {
            return;
        }
        c.a.o0.x.w.a.a().c(0);
        c.a.o0.x.w.e pbEditor = this.f19326c.getPbEditor();
        pbEditor.U();
        pbEditor.S();
        if (pbEditor.z() != null) {
            pbEditor.z().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.m0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.o0.x.h findLauncherById = this.h0.findLauncherById(23);
        c.a.o0.x.h findLauncherById2 = this.h0.findLauncherById(2);
        c.a.o0.x.h findLauncherById3 = this.h0.findLauncherById(5);
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

    public final void p3(SparseArray<Object> sparseArray, int i2, c.a.p0.i.i iVar, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048742, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.f19326c) == null) {
            return;
        }
        if (this.q1 == null && this.q != null) {
            this.q1 = new c.a.p0.i.j(pbFragment.getPageContext(), this.q.c(), iVar, userData);
        }
        this.q1.C(z2);
        AntiData antiData = this.f19326c.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.o0.s.q.x0 x0Var = new c.a.o0.s.q.x0();
        x0Var.k(sparseArray2);
        this.q1.E(new String[]{this.f19326c.getString(R.string.delete_thread_reason_1), this.f19326c.getString(R.string.delete_thread_reason_2), this.f19326c.getString(R.string.delete_thread_reason_3), this.f19326c.getString(R.string.delete_thread_reason_4), this.f19326c.getString(R.string.delete_thread_reason_5)});
        this.q1.D(x0Var);
        this.q1.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.q1.F(new u(this, sparseArray));
    }

    public View q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            View view = this.S;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || this.D1 == null) {
            return;
        }
        j1();
        if (this.D1.isPbNeedShow()) {
            String a3 = this.C1.a(this.B0.j0());
            if (StringUtils.isNull(a3)) {
                return;
            }
            this.D1.setData(a3);
            TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
            this.D1.setLogoListener(new l0(this, this.C1.b(this.B0.j0())));
            this.D1.setFeedBackListener(new m0(this));
        }
    }

    public final void q2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) {
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.A.c0(this.B0, false);
            this.A.X();
        }
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public void r1(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, eVar) == null) {
            this.C1.e(eVar.k() == null ? null : eVar.k().pbpage);
            this.C1.d(TbSingleton.getInstance().getAdFloatViewData());
            if (this.C1.c(eVar.j0())) {
                q1();
            }
        }
    }

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            p2();
            e1();
            this.X0.c();
            g3(false);
        }
    }

    public void r3(c.a.p0.i2.h.e eVar, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Parcelable e3;
        Parcelable e4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048750, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) || eVar == null || this.l == null) {
            return;
        }
        this.B0 = eVar;
        this.D0 = i2;
        if (eVar.O() != null) {
            this.T0 = eVar.O().O();
            if (eVar.O().F() != 0) {
                this.Q1 = true;
            }
            this.c0 = C1(eVar.O());
        }
        if (eVar.U() != null) {
            this.R1 = eVar.U().getUserId();
        }
        n1(eVar);
        V();
        this.F0 = false;
        this.A0 = z2;
        T2();
        c.a.p0.i2.h.k kVar = eVar.f18736h;
        if (kVar != null && kVar.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f19326c.getContext());
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
        s3(eVar, z2, i2, TbadkCoreApplication.getInst().getSkinType());
        h3(eVar);
        if (this.n1 == null) {
            this.n1 = new c.a.p0.i2.k.e.g0(this.f19326c.getPageContext(), this.o1);
        }
        this.n1.a(eVar.w());
        if (this.f19326c.getIsMangaThread()) {
            if (this.F == null) {
                c.a.p0.i2.p.i iVar = new c.a.p0.i2.p.i(this.f19326c.getPageContext());
                this.F = iVar;
                iVar.i();
                this.F.a(this.S1);
            }
            this.l.setPullRefresh(this.F);
            s2();
            c.a.p0.i2.p.i iVar2 = this.F;
            if (iVar2 != null) {
                iVar2.D(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (eVar.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.F == null) {
                c.a.p0.i2.p.i iVar3 = new c.a.p0.i2.p.i(this.f19326c.getPageContext());
                this.F = iVar3;
                iVar3.i();
                this.F.a(this.S1);
            }
            this.l.setPullRefresh(this.F);
            s2();
            c.a.p0.i2.p.i iVar4 = this.F;
            if (iVar4 != null) {
                iVar4.D(TbadkCoreApplication.getInst().getSkinType());
            }
            g1();
        }
        g0();
        this.A.j0(this.A0);
        this.A.g0(false);
        this.A.h0(i2 == 5);
        this.A.i0(i2 == 6);
        this.A.e0(z3 && this.O1 && i2 != 2);
        this.A.c0(eVar, false);
        this.A.X();
        this.s.B(w0(eVar, z2), eVar.f0());
        if (eVar.O() != null && eVar.O().J0() != null && this.f19325b != -1) {
            eVar.O().J0().setIsLike(this.f19325b);
        }
        this.l.removeFooterView(this.O0);
        this.l.addFooterView(this.O0);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.G);
            this.f19329f = 2;
            g1();
        } else {
            this.F0 = true;
            if (eVar.y().b() == 1) {
                if (this.H == null) {
                    PbFragment pbFragment = this.f19326c;
                    this.H = new c.a.p0.i2.p.e(pbFragment, pbFragment);
                }
                this.l.setNextPage(this.H);
            } else {
                this.l.setNextPage(this.G);
            }
            this.f19329f = 3;
        }
        ArrayList<PostData> F = eVar.F();
        if (eVar.y().b() != 0 && F != null && F.size() >= eVar.y().e()) {
            if (z3) {
                if (this.O1) {
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
                r0 r0Var = this.R0;
                if (r0Var == null || (pbReplyTitleViewHolder = r0Var.f19392c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i5 = 0;
                } else {
                    i5 = this.R0.f19392c.getView().getTop() < 0 ? this.R0.f19392c.getView().getHeight() : this.R0.f19392c.getView().getBottom();
                }
                if (this.f19326c.isHostOnlyMode()) {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i5);
                } else {
                    this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i5);
                }
                if (this.f19326c.getPbNavigationAnimDispatcher() != null && !this.f19326c.getPbNavigationAnimDispatcher().p()) {
                    this.f19326c.getPbNavigationAnimDispatcher().x();
                }
            }
            if (eVar.y().b() == 0 || F == null) {
                n2();
            }
        }
        if (i2 == 2) {
            this.l.setSelection(i3 > 1 ? (i3 + ((this.l.getData() == null && eVar.F() == null) ? 0 : (this.l.getData().size() - eVar.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.O1 = false;
            } else if (i2 == 5) {
                this.l.setSelection(0);
            } else if (i2 != 6) {
                if (i2 == 8) {
                    if (i3 == 0) {
                        c.a.p0.i2.k.e.a1.i iVar5 = this.p;
                        if (iVar5 != null && iVar5.c() != null) {
                            if (this.f19326c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.A.B() + this.l.getHeaderViewsCount()) - 1, this.p.d() - c.a.e.e.p.l.r(this.f19326c.getPageContext().getPageActivity()));
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
                    this.G.A(this.f19326c.getString(R.string.pb_load_more_without_point));
                    this.G.v();
                }
            } else if (i4 == 1 && (e4 = c.a.p0.i2.k.e.l0.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e4);
            } else {
                this.l.setSelection(0);
            }
        } else if (i4 == 1 && (e3 = c.a.p0.i2.k.e.l0.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
            this.l.post(new d0(this, e3, F, eVar));
        }
        if (this.T0 == Y1 && B1()) {
            a0();
        }
        if (this.Z0) {
            i2();
            this.Z0 = false;
            if (i4 == 0) {
                I2(true);
            }
        }
        if (eVar.f18732d == 1 || eVar.f18733e == 1) {
            if (this.f1 == null) {
                this.f1 = new PbTopTipView(this.f19326c.getContext());
            }
            if (eVar.f18733e == 1 && "game_guide".equals(this.f19326c.getStType())) {
                this.f1.setText(this.f19326c.getString(R.string.pb_read_strategy_add_experience));
                this.f1.show(this.f19327d, this.E0);
            } else if (eVar.f18732d == 1 && "game_news".equals(this.f19326c.getStType())) {
                this.f1.setText(this.f19326c.getString(R.string.pb_read_news_add_experience));
                this.f1.show(this.f19327d, this.E0);
            }
        }
        this.l.removeFooterView(this.y1.a());
        if (!ListUtils.isEmpty(eVar.I()) && eVar.y().b() == 0) {
            this.l.removeFooterView(this.O0);
            this.y1.d(Math.max(this.n0.getMeasuredHeight(), this.y0 / 2));
            this.l.addFooterView(this.y1.a());
            this.y1.f(eVar);
        }
        j2(eVar);
        if (eVar.d0() && this.f19326c.getPbRecThreadController() != null) {
            this.f19326c.getPbRecThreadController().d();
        }
        if (eVar.g() != 3) {
            r1(eVar);
        }
        this.q0.setText(TbSingleton.getInstance().getAdVertiComment(eVar.j0(), eVar.k0(), R0()));
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

    public final void s1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048752, this) == null) && this.t == null) {
            this.t = new c.a.p0.i2.k.e.a1.e(this.f19326c, this.K);
        }
    }

    public final void s2() {
        c.a.p0.i2.k.e.a1.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (iVar = this.p) == null) {
            return;
        }
        iVar.q(this.l, this.J0, this.D0);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void s3(c.a.p0.i2.h.e eVar, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048754, this, new Object[]{eVar, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        if (this.f19326c.isSimpleForum()) {
            if (eVar.h() != null) {
                this.d0 = eVar.h().getForumName();
                this.e0 = eVar.h().getForumId();
            }
            if (this.d0 == null && this.f19326c.getPbModel() != null && this.f19326c.getPbModel().p0() != null) {
                this.d0 = this.f19326c.getPbModel().p0();
            }
        }
        PostData w0 = w0(eVar, z2);
        R2(w0, eVar);
        this.s.y(8);
        if (eVar.p0()) {
            this.b1 = true;
            this.f19331h.B(true);
            this.f19331h.f19209a.hideBottomLine();
            if (this.p == null) {
                this.p = new c.a.p0.i2.k.e.a1.i(this.f19326c);
            }
            this.p.v(eVar, w0, this.l, this.s, this.I0, this.f19331h, this.d0, this.t1);
            this.p.s(this.P1);
            s2();
        } else {
            this.b1 = false;
            this.f19331h.B(false);
            c.a.p0.i2.k.e.a1.i iVar = this.p;
            if (iVar != null) {
                iVar.p(this.l);
            }
        }
        if (this.f19326c.getPbNavigationAnimDispatcher() != null) {
            this.f19326c.getPbNavigationAnimDispatcher().w(this.b1);
        }
        if (w0 == null) {
            return;
        }
        this.C0 = w0;
        this.s.y(0);
        SparseArray<Object> o2 = this.s.o();
        o2.put(R.id.tag_clip_board, w0);
        o2.put(R.id.tag_is_subpb, Boolean.FALSE);
        this.t.e(eVar, this.l);
        this.v.e(eVar, this.v1, new a0(this));
        this.r.f(eVar);
        this.q.h(eVar, this.A0);
        this.q.g(eVar);
        this.s.z(this.E0, this.B0, w0, this.P1);
        if (this.N0 != null) {
            if (eVar.f0()) {
                this.N0.getView().setVisibility(8);
            } else {
                this.N0.getView().setVisibility(0);
                c.a.p0.i2.h.o oVar = new c.a.p0.i2.h.o(c.a.p0.i2.h.o.l);
                if (eVar.O() != null) {
                    eVar.O().S0();
                }
                oVar.f18770g = eVar.f18735g;
                eVar.c();
                oVar.f18771h = this.f19326c.isHostOnlyMode();
                oVar.k = eVar.f18734f;
                this.N0.bindDataToView(oVar);
            }
        }
        C3(eVar);
        c.a.e.e.m.e.a().post(new b0(this));
        this.u.e(this.l);
        if (w0.S) {
            this.u.f(w0.E());
            this.u.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        c.a.p0.i2.k.e.i iVar2 = this.A;
        if (iVar2 != null && iVar2.z() != null) {
            this.A.z().s0(w0.S);
        }
        c.a.p0.i2.k.e.i iVar3 = this.A;
        if (iVar3 != null) {
            iVar3.l0(w0.S);
        }
        this.z1.setVisibility(w0.S ? 0 : 8);
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
            if (this.A.y(s0) != null && this.A.y(s0) != PostData.u0) {
                i2 = s0 + 1;
            }
            if (this.A.x(i2) instanceof PostData) {
                return (PostData) this.A.x(i2);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void t1(c.a.p0.i2.h.e eVar) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, eVar) == null) {
            int i2 = 0;
            this.A.c0(eVar, false);
            this.A.X();
            g0();
            c.a.p0.i2.k.d.a aVar = this.k1;
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
                    r0 r0Var = this.R0;
                    if (r0Var != null && (pbReplyTitleViewHolder = r0Var.f19392c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i2 = this.R0.f19392c.getView().getTop() < 0 ? this.R0.f19392c.getView().getHeight() : this.R0.f19392c.getView().getBottom();
                    }
                    if (this.f19326c.isHostOnlyMode()) {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i2);
                    } else {
                        this.G.D(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i2);
                    }
                }
            }
            j2(eVar);
        }
    }

    public void t2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048757, this) == null) || (handler = this.K1) == null) {
            return;
        }
        Runnable runnable = this.L1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        g gVar = new g(this);
        this.L1 = gVar;
        this.K1.postDelayed(gVar, 2000L);
    }

    public void t3(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048758, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.Z;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Z = null;
            }
            c.a.o0.s.s.i iVar = new c.a.o0.s.s.i(this.f19326c.getContext());
            ArrayList arrayList = new ArrayList();
            c.a.p0.i2.h.e eVar = this.B0;
            if (eVar != null && eVar.O() != null && !this.B0.O().N1()) {
                arrayList.add(new c.a.o0.s.s.f(0, this.f19326c.getPageContext().getString(R.string.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.o0.s.s.f(1, this.f19326c.getPageContext().getString(R.string.save_to_local), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new y(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19326c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public FallingView u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.A1 : (FallingView) invokeV.objValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.Q1 : invokeV.booleanValue;
    }

    public final void u2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048761, this, z2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921599, Boolean.valueOf(z2)));
        }
    }

    public void u3(b.c cVar, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048762, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            PopupDialog popupDialog = this.Y;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.Y = null;
            }
            c.a.o0.s.s.i iVar = new c.a.o0.s.s.i(this.f19326c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4) {
                arrayList.add(new c.a.o0.s.s.f(0, this.f19326c.getPageContext().getString(R.string.copy), iVar));
            }
            if (z3) {
                arrayList.add(new c.a.o0.s.s.f(1, this.f19326c.getPageContext().getString(R.string.report_text), iVar));
            } else if (!z2) {
                arrayList.add(new c.a.o0.s.s.f(1, this.f19326c.getPageContext().getString(R.string.mark), iVar));
            } else {
                arrayList.add(new c.a.o0.s.s.f(1, this.f19326c.getPageContext().getString(R.string.remove_mark), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new x(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f19326c.getPageContext(), iVar);
            this.Z = popupDialog2;
            popupDialog2.showDialog();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.x0 : invokeV.booleanValue;
    }

    public void v2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, editorTools) == null) {
            this.h0 = editorTools;
            editorTools.setOnCancelClickListener(new k(this));
            this.h0.setId(R.id.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.h0.getParent() == null) {
                this.f19327d.addView(this.h0, layoutParams);
            }
            this.h0.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.h0.setActionListener(24, new l(this));
            e1();
            this.f19326c.getPbEditor().i(new m(this));
        }
    }

    public void v3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, onItemClickListener) == null) {
            c.a.o0.s.s.c cVar = this.a0;
            if (cVar != null) {
                cVar.d();
                this.a0 = null;
            }
            if (this.B0 == null) {
                return;
            }
            ArrayList<c.a.o0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.o0.s.s.k(this.f19326c.getContext().getString(R.string.all_person), "", this.B0.L() == 1, Integer.toString(1)));
            arrayList.add(new c.a.o0.s.s.k(this.f19326c.getContext().getString(R.string.my_fans), "", this.B0.L() == 2, Integer.toString(5)));
            arrayList.add(new c.a.o0.s.s.k(this.f19326c.getContext().getString(R.string.my_attentions), "", this.B0.L() == 3, Integer.toString(6)));
            arrayList.add(new c.a.o0.s.s.k(this.f19326c.getContext().getString(R.string.myself_only), "", this.B0.L() == 4, Integer.toString(7)));
            c.a.o0.s.s.c cVar2 = new c.a.o0.s.s.c(this.f19326c.getPageContext());
            cVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.a0 = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.a0.n();
        }
    }

    public PostData w0(c.a.p0.i2.h.e eVar, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048767, this, eVar, z2)) == null) {
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
            if (!z1(postData)) {
                postData = Q0(eVar);
            }
            if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
                postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean w1(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048768, this, eVar)) == null) {
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

    public void w2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048769, this, str) == null) || (pbListView = this.G) == null) {
            return;
        }
        pbListView.A(str);
    }

    public void w3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048770, this) == null) || !TbadkCoreApplication.isLogin() || this.B0 == null || !this.c1 || this.b1 || this.c0 || (postData = this.C0) == null || postData.t() == null || this.C0.t().getIsLike() || this.C0.t().hadConcerned() || this.Y0 != null) {
            return;
        }
        this.Y0 = new c.a.p0.i2.k.e.n0(this.f19326c);
    }

    public final int x0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048771, this, i2)) == null) {
            c.a.e.k.e.e adapter2 = this.l.getAdapter2();
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
            int l2 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof c.a.e.k.e.e)) ? 0 : this.l.getAdapter2().l();
            if (i2 > l2) {
                return i2 - l2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.isDragListenerExecuted();
        }
        return invokeV.booleanValue;
    }

    public void x2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048773, this, str) == null) || this.G == null) {
            return;
        }
        int i2 = 0;
        r0 r0Var = this.R0;
        if (r0Var != null && (pbReplyTitleViewHolder = r0Var.f19392c) != null && pbReplyTitleViewHolder.getView() != null) {
            i2 = this.R0.f19392c.getView().getTop() < 0 ? this.R0.f19392c.getView().getHeight() : this.R0.f19392c.getView().getBottom();
        }
        this.G.D(str, i2);
    }

    public final void x3(c.a.o0.s.s.a aVar, int i2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048774, this, aVar, i2) == null) || (pbFragment = this.f19326c) == null || aVar == null) {
            return;
        }
        if (this.p1 == null && this.q != null) {
            this.p1 = new c.a.p0.i.g(pbFragment.getPageContext(), this.q.c());
        }
        AntiData antiData = this.f19326c.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.o0.s.q.x0 x0Var = new c.a.o0.s.q.x0();
        x0Var.k(sparseArray);
        this.p1.y(new String[]{this.f19326c.getString(R.string.delete_thread_reason_1), this.f19326c.getString(R.string.delete_thread_reason_2), this.f19326c.getString(R.string.delete_thread_reason_3), this.f19326c.getString(R.string.delete_thread_reason_4), this.f19326c.getString(R.string.delete_thread_reason_5)});
        this.p1.x(x0Var);
        this.p1.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.p1.z(new t(this, aVar));
    }

    public Button y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.l0 : (Button) invokeV.objValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            EditorTools editorTools = this.h0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void y2(PbFragment.z2 z2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, z2Var) == null) {
            this.N1 = z2Var;
        }
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            this.J.setVisibility(0);
        }
    }

    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean z1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048780, this, postData)) == null) {
            if (postData == null || postData.t() == null) {
                return false;
            }
            MetaData t2 = postData.t();
            return (TextUtils.isEmpty(t2.getUserId()) && TextUtils.isEmpty(t2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z2) == null) {
            this.i0 = z2;
        }
    }

    public void z3() {
        c.a.p0.i2.p.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048782, this) == null) || (hVar = this.u0) == null) {
            return;
        }
        hVar.m(2);
    }
}
