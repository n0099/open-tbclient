package c.a.o0.s.q;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.AnchorInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.PushStatusData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.bumptech.glide.load.engine.GlideException;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.ApkDetail;
import tbclient.DislikeInfo;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes3.dex */
public class c2 extends a implements PreLoadImageProvider, c.a.e.k.e.n, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A3;
    public static final BdUniqueId B3;
    public static final BdUniqueId C3;
    public static final BdUniqueId D3;
    public static final BdUniqueId E3;
    public static final BdUniqueId F3;
    public static final BdUniqueId G3;
    public static final BdUniqueId H3;
    public static AtomicBoolean I3;
    public static AtomicBoolean J3;
    public static AtomicBoolean K3;
    public static final BdUniqueId L3;
    public static final BdUniqueId M3;
    public static HashMap<Point, Integer> N3;
    public static HashMap<Integer, Integer> O3;
    public static final BdUniqueId P3;
    public static final BdUniqueId Q3;
    public static HashMap<Point, Integer> R3;
    public static SparseArray<m.a> S3;
    public static final BdUniqueId V2;
    public static final BdUniqueId W2;
    public static final BdUniqueId X2;
    public static final BdUniqueId Y2;
    public static final BdUniqueId Z2;
    public static final BdUniqueId a3;
    public static final BdUniqueId b3;
    public static final BdUniqueId c3;
    public static final BdUniqueId d3;
    public static final BdUniqueId e3;
    public static final BdUniqueId f3;
    public static final BdUniqueId g3;
    public static final BdUniqueId h3;
    public static final BdUniqueId i3;
    public static final BdUniqueId j3;
    public static final BdUniqueId k3;
    public static final BdUniqueId l3;
    public static final BdUniqueId m3;
    public static final BdUniqueId n3;
    public static final BdUniqueId o3;
    public static final BdUniqueId p3;
    public static final BdUniqueId q3;
    public static final BdUniqueId r3;
    public static final BdUniqueId s3;
    public static final BdUniqueId t3;
    public static final BdUniqueId u3;
    public static final BdUniqueId v3;
    public static final BdUniqueId w3;
    public static final BdUniqueId x3;
    public static final BdUniqueId y3;
    public static final BdUniqueId z3;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String A0;
    public TopicModule A1;
    public int A2;
    public String B;
    public int B0;
    public String B1;
    public String B2;
    public long C;
    public boolean C0;
    public String C1;
    public String C2;
    public y1 D;
    public ArrayList<b> D0;
    public VideoInfo D1;
    public String D2;
    public String E;
    public p2 E0;
    public boolean E1;
    public boolean E2;
    public String F;
    public i F0;
    public boolean F1;
    public boolean F2;
    public String G;
    public u G0;
    public OriginalForumInfo G1;
    public int G2;
    public int H;
    public String H0;
    public boolean H1;
    public c.a.p0.i3.h0.o H2;
    public int I;
    public int I0;
    public boolean I1;
    public int I2;
    public long J;
    public a2 J0;
    public SmartApp J1;
    public WorksInfoData J2;
    public int K;
    public ArrayList<c.a.o0.u.c> K0;
    public boolean K1;
    public int K2;
    public int L;
    public PushStatusData L0;
    public String L1;
    public List<ThreadRecommendInfoData> L2;
    public int M;
    public String M0;
    public String M1;
    public String M2;
    public int N;
    public String N0;
    public String N1;
    public int N2;
    public g2 O;
    public SkinInfo O0;
    public String O1;
    public boolean O2;
    public String P;
    public boolean P0;
    public String P1;
    public String P2;
    public MetaData Q;
    public String Q0;
    public int Q1;
    public String Q2;
    public String R;
    public int R0;
    public String R1;
    public String R2;
    public int S;
    public r S0;
    public String S1;
    public boolean S2;
    public String T;
    public boolean T0;
    public boolean T1;
    public long T2;
    public ArrayList<MediaData> U;
    public String U0;
    public boolean U1;
    public boolean U2;
    public ArrayList<VoiceData$VoiceModel> V;
    public String V0;
    public boolean V1;
    public int W;
    public String W0;
    public boolean W1;
    public int X;
    public String X0;
    public boolean X1;
    public String Y;
    public String Y0;
    public boolean Y1;
    public int Z;
    public String Z0;
    public boolean Z1;
    public int a0;
    public long a1;
    public boolean a2;
    public PraiseData b0;
    public boolean b1;
    public boolean b2;
    public AnchorInfoData c0;
    public boolean c1;
    public boolean c2;
    public int d1;
    public boolean d2;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13868e;
    public boolean e1;
    public boolean e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13869f;
    public boolean f1;
    public String f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13870g;
    public int g1;
    public boolean g2;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13871h;
    public SparseArray<String> h1;
    public String h2;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13872i;
    public String i0;
    public SparseArray<String> i1;
    public boolean i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13873j;
    public HashMap<String, MetaData> j0;
    public String j1;
    public String j2;
    public boolean k;
    public String k0;
    public boolean k1;
    public String k2;
    public boolean l;
    public String l0;
    public AgreeData l1;
    public int l2;
    public boolean m;
    public String m0;
    public PostData m1;
    public BaijiahaoData m2;
    public int n;
    public int n0;
    public long n1;
    public boolean n2;
    public String o;
    public int o0;
    public r0 o1;
    public String o2;
    public int p;
    public ArrayList<c.a.o0.t.i.c> p0;
    public boolean p1;
    public int p2;
    public int q;
    public VideoInfo q0;
    public boolean q1;
    public String q2;
    public String r;
    public VideoDesc r0;
    public h r1;
    public ThreadInfo r2;
    public String s;
    public j2 s0;
    public MediaData s1;
    public List<PbLinkData> s2;
    public List<PbContent> t;
    public AlaInfoData t0;
    public int t1;
    public List<PbGoodsData> t2;
    public List<PbContent> u;
    public int u0;
    public int u1;
    public boolean u2;
    public List<PbContent> v;
    public int v0;
    public OriginalThreadInfo v1;
    public Item v2;
    public SpannableStringBuilder w;
    public long w0;
    public boolean w1;
    public ItemData w2;
    public SpannableStringBuilder x;
    public long x0;
    public String x1;
    public List<HeadItem> x2;
    public SpannableString y;
    public String y0;
    public String y1;
    public ItemStarData y2;
    @Nullable
    public List<c.a.o0.d1.o.a> z;
    public int z0;
    public int z1;
    public PollData z2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-180952022, "Lc/a/o0/s/q/c2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-180952022, "Lc/a/o0/s/q/c2;");
                return;
            }
        }
        V2 = BdUniqueId.gen();
        W2 = BdUniqueId.gen();
        X2 = BdUniqueId.gen();
        Y2 = BdUniqueId.gen();
        Z2 = BdUniqueId.gen();
        a3 = BdUniqueId.gen();
        b3 = BdUniqueId.gen();
        c3 = BdUniqueId.gen();
        d3 = BdUniqueId.gen();
        e3 = BdUniqueId.gen();
        f3 = BdUniqueId.gen();
        g3 = BdUniqueId.gen();
        h3 = BdUniqueId.gen();
        i3 = BdUniqueId.gen();
        j3 = BdUniqueId.gen();
        k3 = BdUniqueId.gen();
        l3 = BdUniqueId.gen();
        m3 = BdUniqueId.gen();
        n3 = BdUniqueId.gen();
        o3 = BdUniqueId.gen();
        p3 = BdUniqueId.gen();
        q3 = BdUniqueId.gen();
        r3 = BdUniqueId.gen();
        s3 = BdUniqueId.gen();
        t3 = BdUniqueId.gen();
        u3 = BdUniqueId.gen();
        v3 = BdUniqueId.gen();
        w3 = BdUniqueId.gen();
        x3 = BdUniqueId.gen();
        y3 = BdUniqueId.gen();
        z3 = BdUniqueId.gen();
        A3 = BdUniqueId.gen();
        B3 = BdUniqueId.gen();
        C3 = BdUniqueId.gen();
        D3 = BdUniqueId.gen();
        E3 = BdUniqueId.gen();
        F3 = BdUniqueId.gen();
        G3 = BdUniqueId.gen();
        H3 = BdUniqueId.gen();
        I3 = new AtomicBoolean(false);
        J3 = new AtomicBoolean(false);
        K3 = new AtomicBoolean(false);
        L3 = BdUniqueId.gen();
        M3 = BdUniqueId.gen();
        N3 = new HashMap<>();
        O3 = new HashMap<>();
        P3 = BdUniqueId.gen();
        Q3 = BdUniqueId.gen();
        R3 = new HashMap<>();
        S3 = new SparseArray<>(3);
        N3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        N3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        N3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        N3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        N3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        N3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        N3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        N3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        R3.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        R3.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        R3.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        R3.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        R3.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        R3.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        R3.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        R3.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        O3.put(1, Integer.valueOf(R.drawable.label_interview_no));
        O3.put(2, Integer.valueOf(R.drawable.label_interview_live));
        O3.put(3, Integer.valueOf(R.drawable.label_interview_off));
        S3.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        S3.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        S3.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public c2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i4 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13868e = false;
        this.f13869f = false;
        this.f13870g = false;
        this.f13871h = false;
        this.f13872i = false;
        this.f13873j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 0;
        this.o = "1";
        this.p = 1;
        this.W = 0;
        this.Y = null;
        this.o0 = 0;
        this.z0 = 0;
        this.A0 = "";
        this.C0 = false;
        this.H0 = "";
        this.b1 = true;
        this.f1 = false;
        this.g1 = -1;
        this.h1 = null;
        this.i1 = null;
        this.q1 = false;
        this.t1 = 0;
        this.z1 = 0;
        this.E1 = false;
        this.K1 = false;
        this.T1 = false;
        this.U1 = false;
        this.i2 = false;
        this.n2 = false;
        this.E2 = false;
        this.F2 = false;
        this.M2 = "";
        this.A = null;
        this.B = null;
        this.C = 0L;
        this.r = null;
        this.v0 = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0L;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = new g2();
        this.Q = new MetaData();
        this.R = null;
        this.U = new ArrayList<>();
        this.V = new ArrayList<>();
        this.S = 0;
        this.T = null;
        this.s = null;
        this.X = 0;
        this.b0 = new PraiseData();
        this.c0 = new AnchorInfoData();
        this.n0 = 0;
        this.D0 = new ArrayList<>();
        this.E0 = null;
        this.F0 = null;
        this.p0 = new ArrayList<>();
        this.B0 = 0;
        this.B0 = 0;
        this.I0 = 0;
        this.o0 = 0;
        this.u0 = 0;
        this.R0 = 0;
        this.S0 = new r();
        this.v = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.G = null;
        this.J0 = new a2();
        this.K0 = new ArrayList<>();
        this.L0 = new PushStatusData();
        this.W = 0;
        this.c1 = false;
        this.d1 = -1;
        this.m1 = new PostData();
        this.l1 = new AgreeData();
        this.t1 = 0;
        this.u1 = 0;
        this.y0 = "";
        this.y1 = "";
        this.x1 = "";
        this.M0 = "";
        this.N0 = "";
        this.s2 = new ArrayList();
        this.t2 = new ArrayList();
        this.L2 = new ArrayList();
        this.A2 = -1;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.I : invokeV.intValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.a0;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void A3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.P0 = z;
        }
    }

    public final c.a.e.k.b A4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(R.layout.thread_category, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(R.id.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0106_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                return new c.a.e.k.b(bitmapDrawable, 1);
            }
            return null;
        }
        return (c.a.e.k.b) invokeL.objValue;
    }

    public AgreeData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l1 : (AgreeData) invokeV.objValue;
    }

    public String B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public ArrayList<VoiceData$VoiceModel> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V : (ArrayList) invokeV.objValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? A2() && E2() : invokeV.booleanValue;
    }

    public void B3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.R = str;
        }
    }

    public void B4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.q = i2;
        }
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l1.agreeNum : invokeV.longValue;
    }

    public ArrayList<MediaData> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.U : (ArrayList) invokeV.objValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (O0() == 1) {
                return 2;
            }
            if (O0() == 2) {
                return 3;
            }
            return O0() == 3 ? 1 : 4;
        }
        return invokeV.intValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a0 == 11 || this.Z == 1 : invokeV.booleanValue;
    }

    public void C3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.Y1 = z;
        }
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.z0 == 0) {
            this.z0 = 1;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l1.agreeType : invokeV.intValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.S1 : (String) invokeV.objValue;
    }

    public p2 D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.E0 : (p2) invokeV.objValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a0 == 36 : invokeV.booleanValue;
    }

    public void D3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.W1 = z;
        }
    }

    public AnchorInfoData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.c0 : (AnchorInfoData) invokeV.objValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o0 : invokeV.intValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || ListUtils.getCount(this.x2) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.x;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) TbRichTextHelper.e(this.x2));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
        spannableStringBuilder2.insert(0, (CharSequence) TbRichTextHelper.e(this.x2));
        this.y = new SpannableString(spannableStringBuilder2);
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            WorksInfoData worksInfoData = this.J2;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void E3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.j1 = str;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.u0 : invokeV.intValue;
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void F1(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, spannableString) == null) || J() == null || showNoName() || showWeakenName()) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.x;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
        spannableStringBuilder2.insert(0, (CharSequence) spannableString);
        this.y = new SpannableString(spannableStringBuilder2);
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.v0 != 0 : invokeV.booleanValue;
    }

    public void F3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.l1.hasAgree = i2 == 1;
        }
    }

    public i G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.F0 : (i) invokeV.objValue;
    }

    public PollData G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.z2 : (PollData) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.n0 == 1 : invokeV.booleanValue;
    }

    public SpannableString G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SpannableStringBuilder J2 = J2();
            c.a.p0.a0.m.b(this, J2, false);
            return new SpannableString(J2);
        }
        return (SpannableString) invokeV.objValue;
    }

    public void G3(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, videoInfo) == null) {
            this.D1 = videoInfo;
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.k2 : (String) invokeV.objValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.N2 : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (J() == null || J().getAlaUserData() == null || J().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public SpannableString H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (ListUtils.isEmpty(this.v)) {
                return null;
            }
            return new SpannableString(TbRichTextHelper.A(this, this.v, this.s));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void H3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.A = str;
        }
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.x0 : invokeV.longValue;
    }

    public int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.B0 : invokeV.intValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            MetaData metaData = this.Q;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public void I2(WriteData writeData) {
        String j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, writeData) == null) || writeData == null) {
            return;
        }
        try {
            this.A = "0";
            this.B = "";
            this.C = c.a.e.e.m.b.f(writeData.getForumId(), 0L);
            this.r = writeData.getTitle();
            this.w0 = System.currentTimeMillis() / 1000;
            String str = (System.currentTimeMillis() / 1000) + "";
            this.J = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.Q = metaData;
            metaData.parseFromCurrentUser();
            this.P = TbadkCoreApplication.getCurrentAccount();
            this.R = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (c.a.e.e.p.k.isEmpty(c.a.p0.i3.q0.g.g().j())) {
                j2 = writeData.getVideoInfo().getThumbPath();
            } else {
                j2 = c.a.p0.i3.q0.g.g().j();
            }
            builder.thumbnail_url = j2;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.q0 = builder.build(true);
            this.a0 = 40;
            System.currentTimeMillis();
            this.q = writeData.isNoTitle() ? 1 : 0;
            this.s = writeData.getContent();
            y1 y1Var = new y1();
            this.D = y1Var;
            y1Var.f14092a = writeData.getForumId();
            this.D.f14093b = writeData.getForumName();
            this.p2 = writeData.getTabId();
            this.q2 = writeData.getTabName();
            Y2();
            if (StringUtils.isNull(writeData.getItem_id()) || writeData.getItemInfo() == null) {
                return;
            }
            Item.Builder builder2 = new Item.Builder();
            builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
            builder2.icon_url = writeData.getItemInfo().getIconUrl();
            builder2.item_name = writeData.getItemInfo().getTitle();
            builder2.tags = writeData.getItemInfo().getTags();
            builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
            builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
            this.v2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.w2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void I3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.d1 = i2 + 1;
        }
    }

    public MetaData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.Q : (MetaData) invokeV.objValue;
    }

    public PraiseData J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.b0 : (PraiseData) invokeV.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            BaijiahaoData baijiahaoData = this.m2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.z == null) {
                this.z = new ArrayList();
            }
            return TbRichTextHelper.B(this, this.u, this.s, this.z);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void J3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
        }
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.l2 : invokeV.intValue;
    }

    public ArrayList<c.a.o0.d1.m.b> K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            ArrayList<c.a.o0.d1.m.b> arrayList = new ArrayList<>();
            if (this.n2) {
                arrayList.add(new c.a.o0.d1.m.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            BaijiahaoData baijiahaoData = this.m2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? TbRichTextHelper.A(this, this.t, this.r) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void K3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.c1 = z;
        }
    }

    public BaijiahaoData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.m2 : (BaijiahaoData) invokeV.objValue;
    }

    public final ArrayList<m.a> L0(boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> arrayList = new ArrayList<>();
            boolean F2 = F2();
            if (z2) {
                if (z) {
                    if (F2 && !A2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if (j0() == 1 || m1() == 33 || (u1() != null && u1().a() != 0)) {
                        if (h1() == null || !Z1()) {
                            if (!F2) {
                                arrayList.add(new m.a(R.string.photo_live_tips));
                            }
                        } else if (i1() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    }
                    if (Z1()) {
                        arrayList.add(S3.get(i1()));
                    }
                    if (G1()) {
                        Integer num = R3.get(new Point(w(), t()));
                        if (num != null) {
                            arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (D1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.e.e.p.k.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                } else {
                    if (F2 && p0() != 1 && !A2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if ((j0() == 1 || m1() == 33) && !Z1() && !F2) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                    if (o0() == 1) {
                        arrayList.add(new m.a(R.string.good));
                    }
                    if (p0() == 1) {
                        arrayList.add(new m.a(R.string.top));
                    }
                    if (Z1() && h1() != null && i1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                    if (G1()) {
                        Integer num2 = R3.get(new Point(w(), t()));
                        if (num2 != null) {
                            arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (this.R0 == 1) {
                        arrayList.add(new m.a(R.string.card_tbread_text));
                    }
                    if (G() != null) {
                        arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (D1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.e.e.p.k.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                    if (z4 && e2()) {
                        arrayList.add(new m.a(R.string.ala_live));
                    }
                    if (z4 && d2()) {
                        arrayList.add(new m.a(R.string.live_record));
                    } else if (n2()) {
                        arrayList.add(new m.a(R.string.video_title_str));
                    }
                    if (z5) {
                        arrayList.add(new m.a(R.string.video_review_state));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            BaijiahaoData baijiahaoData = this.m2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    public void L2(ArrayList<v> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, arrayList) == null) || this.q == 1 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<v> it = arrayList.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next != null && next.a() != null && !StringUtils.isNull(this.r)) {
                Iterator<String> it2 = next.a().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!StringUtils.isNull(next2) && this.r.contains(next2)) {
                            next.b();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void L3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.X = i2;
        }
    }

    public u M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.G0 : (u) invokeV.objValue;
    }

    public PushStatusData M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L0 : (PushStatusData) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            BaijiahaoData baijiahaoData = this.m2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (StringUtils.isNull(this.r) || this.q == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(K2());
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void M3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.V1 = z;
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public ThreadInfo N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.r2 : (ThreadInfo) invokeV.objValue;
    }

    @Deprecated
    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? z2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder N2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? O2(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.z1 = 1;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.I0 : invokeV.intValue;
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (m2()) {
                return 4;
            }
            if (e2() || d2()) {
                return 3;
            }
            if (J1()) {
                return 5;
            }
            if (M1()) {
                return 6;
            }
            if (K1()) {
                return 7;
            }
            if (L1()) {
                return 8;
            }
            if (!this.w1 || this.v1 == null) {
                return n2() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? K1() || L1() : invokeV.booleanValue;
    }

    public SpannableStringBuilder O2(boolean z, boolean z2, boolean z4) {
        InterceptResult invokeCommon;
        SpannableStringBuilder K2;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048652, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)})) == null) {
            if (this.q == 1) {
                K2 = J2();
                spannableStringBuilder = K2.toString();
            } else {
                K2 = K2();
                spannableStringBuilder = K2.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = K2;
            String str = spannableStringBuilder;
            if (z) {
                spannableStringBuilder2 = g(str, spannableStringBuilder3, z, true, z2, z4);
            } else {
                spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
            }
            this.w = spannableStringBuilder2;
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void O3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.M = i2;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.w0 : invokeV.longValue;
    }

    public String P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.U2 : invokeV.booleanValue;
    }

    public SpannableStringBuilder P2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder J2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.r) && this.q != 1) {
                J2 = K2();
            } else {
                J2 = J2();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(J2);
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void P3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            this.K = i2;
        }
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.l1.disAgreeNum : invokeV.longValue;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.O1 : (String) invokeV.objValue;
    }

    public final boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q2(boolean z, boolean z2) {
        c.a.e.k.b bVar;
        SpannableStringBuilder K2;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (m1() == 42 && Q1()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_convene));
                }
                if (p0() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_top));
                } else if (p0() == 2) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_notice));
                }
                if (j0() == 1 || this.O.a() != 0) {
                    if (h1() != null && m1() == 41) {
                        if (i1() == 2) {
                            arrayList.add(Integer.valueOf(R.drawable.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                    }
                }
                if (z && Z1() && (num = O3.get(Integer.valueOf(i1()))) != null) {
                    arrayList.add(num);
                }
                if (o0() == 1 && !w2() && t3 != getType() && C3 != getType()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.c0;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
                }
                if (a1() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
                }
                Integer num2 = N3.get(new Point(w(), t()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (D1() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.tag_act));
                }
                if (G() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
                }
                if (!c.a.e.e.p.k.isEmpty(this.G)) {
                    bVar = A4(this.G);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (bVar != null) {
                            spannableString = new SpannableString(sb2 + this.G + " ");
                        } else {
                            spannableString = new SpannableString(sb2);
                        }
                        int i4 = 0;
                        for (int i5 = 0; i5 < arrayList.size(); i5++) {
                            Bitmap bitmap = SkinManager.getBitmap(((Integer) arrayList.get(i5)).intValue());
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                            if (bitmap != null) {
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            }
                            c.a.o0.s.f0.j jVar = new c.a.o0.s.f0.j(bitmapDrawable);
                            jVar.b(c.a.e.e.p.l.e(TbadkCoreApplication.getInst().getApplicationContext(), this.p));
                            spannableString.setSpan(jVar, i4, i4 + 1, 33);
                            i4 += 2;
                        }
                        if (bVar != null) {
                            spannableString.setSpan(bVar, i4, this.G.length() + i4, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    K2 = K2();
                    if (K2 != null) {
                        spannableStringBuilder.append((CharSequence) K2);
                    }
                    this.w = spannableStringBuilder;
                }
            }
            bVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            K2 = K2();
            if (K2 != null) {
            }
            this.w = spannableStringBuilder2;
        }
    }

    public void Q3(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, item) == null) {
            this.v2 = item;
        }
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.T2 : invokeV.longValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.P1 : (String) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? E2() : invokeV.booleanValue;
    }

    @Deprecated
    public void R2(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.A = jSONObject.optString("id");
            this.C = jSONObject.optLong("fid", 0L);
            this.B = jSONObject.optString("tid");
            this.r = jSONObject.optString("title");
            this.v0 = jSONObject.optInt("is_god");
            this.w0 = jSONObject.optLong("create_time", 0L) * 1000;
            this.x0 = jSONObject.optLong("audit_time", 0L) * 1000;
            this.H = jSONObject.optInt("reply_num", 0);
            jSONObject.optInt("repost_num", 0);
            this.I = jSONObject.optInt("view_num", 0);
            jSONObject.optString("last_time");
            this.J = jSONObject.optLong("last_time_int", 0L);
            this.K = jSONObject.optInt("is_top", 0);
            this.L = jSONObject.optInt("is_membertop", 0);
            this.M = jSONObject.optInt("is_good", 0);
            this.N = jSONObject.optInt("is_livepost", 0);
            this.O.c(jSONObject.optJSONObject("topic"));
            this.P = jSONObject.optString("author_id");
            this.Q.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            this.R = jSONObject.optString("fname");
            jSONObject.optInt("has_commented", 0);
            this.S = jSONObject.optInt("show_commented", 0);
            this.T = jSONObject.optString("click_url");
            jSONObject.optString("from");
            this.X = jSONObject.optInt("collect_status");
            this.Y = jSONObject.optString("collect_mark_pid");
            this.Z = jSONObject.optInt("is_voice_thread");
            this.a0 = jSONObject.optInt("thread_type");
            jSONObject.optInt("thread_type");
            this.n1 = jSONObject.optLong("share_num");
            this.i0 = jSONObject.optString("first_post_id", "0");
            this.A0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.q = jSONObject.optInt("is_ntitle");
            this.G = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.y0 = jSONObject.optString("tieba_game_information_source", "");
            this.l1.parseJson(jSONObject.optJSONObject("agree"));
            this.l1.threadId = this.B;
            JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
            ArrayList<DislikeInfo> arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    DislikeInfo build = new DislikeInfo.Builder().build(true);
                    build.parseJson(optJSONArray.getJSONObject(i2));
                    arrayList.add(build);
                }
            }
            if (ListUtils.getCount(arrayList) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : arrayList) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.h1 = sparseArray;
                this.i1 = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.J0.k(optJSONObject2);
            }
            if ((this.Q == null || this.Q.getUserId() == null) && this.j0 != null) {
                this.Q = this.j0.get(this.P);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.m0 = optJSONObject.optString("location");
            }
            jSONObject.optString("label_url");
            this.M2 = jSONObject.optString("mode_url");
            jSONObject.optString("location");
            AlaInfoData alaInfoData = new AlaInfoData();
            this.t0 = alaInfoData;
            alaInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray2.getJSONObject(i4).optString("text"));
                    }
                }
            }
            this.s = sb.toString();
            JSONArray optJSONArray3 = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray3 != null) {
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray3.getJSONObject(i5));
                    this.U.add(mediaData);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray4 != null) {
                int length = optJSONArray4.length();
                for (int i6 = 0; i6 < length; i6++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    JSONObject jSONObject3 = optJSONArray4.getJSONObject(i6);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = jSONObject3.optString("voice_md5");
                    voiceData$VoiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                    this.V.add(voiceData$VoiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray(com.alipay.sdk.sys.a.o);
            if (optJSONArray5 != null) {
                for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                    b bVar = new b();
                    bVar.h(optJSONArray5.getJSONObject(i7));
                    this.D0.add(bVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                p2 p2Var = new p2();
                this.E0 = p2Var;
                p2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                i iVar = new i();
                this.F0 = iVar;
                iVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                u uVar = new u();
                this.G0 = uVar;
                uVar.c(optJSONObject6);
            }
            this.b0.setUserMap(this.j0);
            this.b0.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.c0.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!c.a.e.e.p.k.isEmpty(this.r)) {
                this.b0.setTitle(this.r);
            } else {
                this.b0.setTitle(this.s);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.J0.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                    c.a.o0.u.c cVar = new c.a.o0.u.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.K0.add(cVar);
                }
            }
            this.R0 = jSONObject.optInt("is_book_chapter", 0);
            this.S0.a(jSONObject.optJSONObject("book_chapter"));
            this.U0 = jSONObject.optString("recom_source");
            this.Y0 = jSONObject.optString("recom_reason");
            this.Z0 = jSONObject.optString("recom_tag_icon");
            this.V0 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.X0 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.a1 = jSONObject.optLong("last_read_pid");
            this.b1 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                j2 j2Var = new j2();
                this.s0 = j2Var;
                j2Var.a(optJSONObject8);
            }
            this.k1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.p1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.p1 && optJSONObject9 != null) {
                r0 r0Var = new r0();
                this.o1 = r0Var;
                r0Var.g(optJSONObject9);
            }
            this.q1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                h hVar = new h();
                this.r1 = hVar;
                hVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.s1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.t1 = jSONObject.optInt("middle_page_num", 0);
            this.u1 = jSONObject.optInt("middle_page_pass_flag", 0);
            JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
            if (optJSONObject12 != null) {
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                builder.video_md5 = optJSONObject12.optString(VideoFinishResult.KEY_VIDEO_MD5);
                builder.video_url = optJSONObject12.optString("video_url");
                builder.video_duration = new Integer(optJSONObject12.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                builder.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                builder.is_vertical = new Integer(optJSONObject12.optInt(TiebaStatic.Params.IS_VERTICAL, 0));
                builder.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                this.q0 = builder.build(true);
            }
            boolean z = jSONObject.optInt("is_share_thread", 0) == 1;
            this.w1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.v1 = originalThreadInfo;
                    originalThreadInfo.o(optJSONObject13);
                } else {
                    this.v1 = null;
                }
            } else {
                this.v1 = null;
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
            if (optJSONObject14 != null) {
                SmartApp.Builder builder2 = new SmartApp.Builder();
                builder2.avatar = optJSONObject14.optString("avatar");
                builder2.name = optJSONObject14.optString("name");
                builder2._abstract = optJSONObject14.optString("abstract");
                builder2.pic = optJSONObject14.optString("pic");
                builder2.h5_url = optJSONObject14.optString("h5_url");
                builder2.id = optJSONObject14.optString("id");
                builder2.link = optJSONObject14.optString("link");
                this.J1 = builder2.build(false);
            }
            this.R1 = jSONObject.optString("t_share_img");
            this.S1 = jSONObject.optString("nid");
            this.T1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.l2 = jSONObject.optInt("bjh_content_tag");
            this.k2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.m2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.l1.baijiahaoData = this.m2;
            }
            this.n2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.o2 = jSONObject.optString("scard_packet_id");
            this.p2 = jSONObject.optInt("tab_id");
            this.q2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.i2 = jSONObject.optInt("if_comment", 0) == 1;
            this.j2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.z2 == null) {
                    this.z2 = new PollData();
                }
                this.z2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.u2) {
                        this.u2 = true;
                    }
                    this.s2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.t2.add(pbGoodsData);
                }
                if (this.t2.size() > 0 && !this.u2) {
                    this.u2 = true;
                }
            }
            this.A2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.J2 == null) {
                    this.J2 = new WorksInfoData();
                }
                this.J2.parseJson(optJSONObject17);
            }
            this.K2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.L2.add(threadRecommendInfoData);
                }
            }
            y1 y1Var = new y1();
            this.D = y1Var;
            y1Var.e(jSONObject.optJSONObject("forum_info"));
            this.I2 = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.H0 = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.u = c1.a(optJSONArray10);
            }
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.t = c1.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.v = c1.a(optJSONArray12);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("star_rank_icon");
            if (optJSONObject18 != null) {
                this.x1 = optJSONObject18.optString("icon_pic_url");
                this.y1 = optJSONObject18.optString("icon_link");
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("location");
            if (optJSONObject19 != null) {
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LAT))) {
                    this.k0 = optJSONObject19.optString(SuggestAddrField.KEY_LAT);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LNG))) {
                    this.k0 = optJSONObject19.optString(SuggestAddrField.KEY_LNG);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("name"))) {
                    this.k0 = optJSONObject19.optString("name");
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ori_forum_info");
            if (optJSONObject20 != null) {
                OriginalForumInfo originalForumInfo = new OriginalForumInfo();
                originalForumInfo.id = optJSONObject20.optLong("ori_fid") + "";
                originalForumInfo.ori_fname = optJSONObject20.optString("ori_fname");
                originalForumInfo.ori_avatar = optJSONObject20.optString("ori_avatar");
                originalForumInfo.ori_member_num = optJSONObject20.optLong("ori_member_num");
                this.G1 = originalForumInfo;
            }
            JSONArray optJSONArray13 = jSONObject.optJSONArray("item_star");
            if (optJSONArray13 != null) {
                for (int i12 = 0; i12 < optJSONArray13.length(); i12++) {
                    JSONObject optJSONObject21 = optJSONArray13.optJSONObject(i12);
                    if (optJSONObject21 != null) {
                        HeadItem.Builder builder3 = new HeadItem.Builder();
                        builder3.content = optJSONObject21.optString("content");
                        builder3.name = optJSONObject21.optString("name");
                        builder3.type = Integer.valueOf(optJSONObject21.optInt("type"));
                        if (this.x2 == null) {
                            this.x2 = new ArrayList();
                        }
                        this.x2.add(builder3.build(true));
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("item");
            if (optJSONObject22 != null && 0 != optJSONObject22.optLong("item_id")) {
                Item.Builder builder4 = new Item.Builder();
                builder4.item_id = Long.valueOf(optJSONObject22.optLong("item_id"));
                builder4.item_name = optJSONObject22.optString("item_name");
                builder4.icon_size = Double.valueOf(optJSONObject22.optDouble("icon_size"));
                builder4.score = Double.valueOf(optJSONObject22.optDouble("score"));
                builder4.icon_url = optJSONObject22.optString("icon_url");
                builder4.star = Integer.valueOf(optJSONObject22.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
                builder4.forum_name = optJSONObject22.optString("forum_name");
                builder4.apk_name = optJSONObject22.optString("apk_name");
                builder4.button_link = optJSONObject22.optString("button_link");
                builder4.button_link_type = Integer.valueOf(optJSONObject22.optInt("button_link_type"));
                builder4.button_name = optJSONObject22.optString("button_name");
                JSONObject optJSONObject23 = optJSONObject22.optJSONObject("apk_detail");
                if (optJSONObject23 != null) {
                    ApkDetail.Builder builder5 = new ApkDetail.Builder();
                    builder5.authority_url = optJSONObject23.optString("authority_url");
                    builder5.developer = optJSONObject23.optString("developer");
                    builder5.publisher = optJSONObject23.optString("publisher");
                    builder5.privacy_url = optJSONObject23.optString("privacy_url");
                    builder5.size = optJSONObject23.optString("size");
                    builder5.update_time = optJSONObject23.optString("update_time");
                    builder5.version = optJSONObject23.optString("version");
                    builder5.version_code = Integer.valueOf(optJSONObject23.optInt("version_code"));
                    builder5.need_inner_buy = Integer.valueOf(optJSONObject23.optInt("need_inner_buy"));
                    builder5.need_network = Integer.valueOf(optJSONObject23.optInt("need_network"));
                    builder4.apk_detail = builder5.build(true);
                }
                JSONArray optJSONArray14 = optJSONObject22.optJSONArray(CommandMessage.TYPE_TAGS);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray14 != null) {
                    for (int i13 = 0; i13 < optJSONArray14.length(); i13++) {
                        arrayList2.add(optJSONArray14.optString(i13));
                    }
                    builder4.tags = arrayList2;
                }
                Item build2 = builder4.build(true);
                if (build2 != null) {
                    this.v2 = build2;
                    ItemData itemData = new ItemData();
                    this.w2 = itemData;
                    itemData.parseProto(build2);
                }
            }
            this.O2 = StringHelper.equals(jSONObject.optString("is_tiebaplus_ad"), "1");
            this.P2 = jSONObject.optString("tiebaplus_order_id");
            this.Q2 = jSONObject.optString("tiebaplus_token");
            this.R2 = jSONObject.optString("tiebaplus_extra_param");
            this.S2 = jSONObject.optInt("tiebaplus_cant_delete") == 1;
            Y2();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void R3(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, itemData) == null) {
            this.w2 = itemData;
        }
    }

    public SparseArray<String> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.h1 : (SparseArray) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.H : invokeV.intValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            MetaData metaData = this.Q;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public void S2(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.k0 = threadInfo.location.lat;
                this.l0 = threadInfo.location.lng;
                this.m0 = threadInfo.location.name;
            }
            this.W = threadInfo.is_tbread_dispatch.intValue();
            this.A = threadInfo.id + "";
            this.B = threadInfo.tid + "";
            this.C = threadInfo.fid.longValue();
            this.r = threadInfo.title;
            this.v0 = threadInfo.is_god.intValue();
            this.w0 = threadInfo.create_time.intValue() * 1000;
            this.x0 = threadInfo.audit_time.longValue() * 1000;
            this.H = threadInfo.reply_num.intValue();
            threadInfo.repost_num.intValue();
            this.I = threadInfo.view_num.intValue();
            String str = threadInfo.last_time;
            this.J = threadInfo.last_time_int.intValue();
            this.K = threadInfo.is_top.intValue();
            this.L = threadInfo.is_membertop.intValue();
            this.M = threadInfo.is_good.intValue();
            this.N = threadInfo.is_livepost.intValue();
            this.O.d(threadInfo.topic);
            this.Q.parserProtobuf(threadInfo.author);
            this.P = threadInfo.author_id.toString();
            this.R = threadInfo.fname;
            threadInfo.has_commented.intValue();
            this.S = threadInfo.show_commented.intValue();
            this.T = threadInfo.click_url;
            this.q0 = threadInfo.video_info;
            this.r0 = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.t0 = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            String str2 = threadInfo.from;
            this.X = threadInfo.collect_status.intValue();
            this.Y = threadInfo.collect_mark_pid;
            this.Z = threadInfo.is_voice_thread.intValue();
            this.a0 = threadInfo.thread_type.intValue();
            threadInfo.thread_type.intValue();
            this.i0 = threadInfo.first_post_id + "";
            this.A0 = threadInfo.post_id + "";
            threadInfo.time.intValue();
            this.q = threadInfo.is_ntitle.intValue();
            this.n0 = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.l1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.l1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.y0 = threadInfo.tieba_game_information_source;
            } else {
                this.y0 = "";
            }
            this.n1 = threadInfo.share_num.longValue();
            this.G = threadInfo.category_name;
            this.o0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.T0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.t = threadInfo.rich_title;
            this.v = threadInfo.first_post_content;
            this.u = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.Q == null || this.Q.getUserId() == null || this.Q.getUserId().equals("0") || this.F2) && this.P != null && !this.P.equals("0") && this.j0 != null && (metaData = this.j0.get(this.P)) != null) {
                this.Q = metaData;
            }
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) != null && list.get(i2).type.intValue() == 0) {
                        sb.append(list.get(i2).text);
                    }
                }
            }
            this.s = sb.toString();
            List<Media> list2 = threadInfo.media;
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(list2.get(i4));
                    this.U.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.q0 = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                j2 j2Var = new j2();
                this.s0 = j2Var;
                j2Var.b(threadInfo.video_channel_info);
            }
            List<Voice> list3 = threadInfo.voice_info;
            if (list3 != null) {
                int size = list3.size();
                for (int i5 = 0; i5 < size; i5++) {
                    VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                    Voice voice = list3.get(i5);
                    voiceData$VoiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceData$VoiceModel.voiceId = voice.voice_md5;
                    voiceData$VoiceModel.duration = voice.during_time.intValue() / 1000;
                    this.V.add(voiceData$VoiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    b bVar = new b();
                    bVar.i(list4.get(i6));
                    this.D0.add(bVar);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                p2 p2Var = new p2();
                this.E0 = p2Var;
                p2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                i iVar = new i();
                this.F0 = iVar;
                iVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                u uVar = new u();
                this.G0 = uVar;
                uVar.d(threadInfo.cartoon_info);
            }
            this.b0.setUserMap(this.j0);
            this.b0.parserProtobuf(threadInfo.zan);
            this.c0.parserProtobuf(threadInfo.anchor_info);
            if (!c.a.e.e.p.k.isEmpty(this.r)) {
                this.b0.setTitle(this.r);
            } else {
                this.b0.setTitle(this.s);
            }
            this.H0 = threadInfo.livecover_src;
            threadInfo.storecount.intValue();
            this.B0 = threadInfo.post_num.intValue();
            threadInfo.post_num.intValue();
            threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        if (zhiBoInfoTW.labelInfo.get(i7) != null) {
                            c.a.o0.t.i.c cVar = new c.a.o0.t.i.c();
                            cVar.a(zhiBoInfoTW.labelInfo.get(i7).labelHot.intValue());
                            cVar.b(zhiBoInfoTW.labelInfo.get(i7).labelId);
                            cVar.c(zhiBoInfoTW.labelInfo.get(i7).labelContent);
                            this.p0.add(cVar);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    String str3 = noticeInfo.notice;
                }
                this.I0 = zhiBoInfoTW.copythread_remind.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                if (StringUtils.isNull(this.H0)) {
                    this.H0 = zhiBoInfoTW.livecover_src;
                }
                if (zhiBoInfoTW.user != null) {
                    TwZhiBoUser twZhiBoUser = zhiBoInfoTW.user.tw_anchor_info;
                    List<TwAnchorProfitItem> list5 = zhiBoInfoTW.user.profit_list;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                threadInfo.twzhibo_info.is_headline.intValue();
                LiveCoverStatus liveCoverStatus = threadInfo.twzhibo_info.livecover_status;
                threadInfo.twzhibo_info.freq_num.intValue();
                if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                    this.u0 = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            threadInfo.is_copythread.intValue();
            if (threadInfo.task_info != null) {
                this.J0.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i8 = 0; i8 != threadInfo.ext_tails.size(); i8++) {
                    c.a.o0.u.c cVar2 = new c.a.o0.u.c();
                    cVar2.b(threadInfo.ext_tails.get(i8));
                    this.K0.add(cVar2);
                }
            }
            this.L0.parserProtobuf(threadInfo.push_status);
            this.Q0 = threadInfo.lego_card;
            this.O0 = threadInfo.skin_info;
            this.R0 = threadInfo.is_book_chapter.intValue();
            this.S0.b(threadInfo.book_chapter);
            this.U0 = threadInfo.recom_source;
            this.Y0 = threadInfo.recom_reason;
            this.Z0 = threadInfo.recom_tag_icon;
            this.V0 = threadInfo.recom_weight;
            this.W0 = threadInfo.ab_tag;
            this.X0 = threadInfo.recom_extra;
            this.a1 = threadInfo.last_read_pid.longValue();
            this.b1 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.m1.c0(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
            }
            List<DislikeInfo> list7 = threadInfo.dislike_info;
            if (ListUtils.getCount(list7) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list7) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.h1 = sparseArray;
                this.i1 = sparseArray2;
            }
            this.k1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.p1 = z;
            if (z && threadInfo.link_info != null) {
                r0 r0Var = new r0();
                this.o1 = r0Var;
                r0Var.h(threadInfo.link_info);
            }
            this.q1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                h hVar = new h();
                this.r1 = hVar;
                hVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.s1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.t1 = threadInfo.middle_page_num.intValue();
            this.u1 = threadInfo.middle_page_pass_flag.intValue();
            this.w1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.x1 = threadInfo.star_rank_icon.icon_pic_url;
                this.y1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.v1 = originalThreadInfo;
                originalThreadInfo.m(threadInfo.origin_thread_info, this);
            } else {
                this.v1 = null;
                this.w1 = false;
            }
            this.z1 = threadInfo.is_topic.intValue();
            this.B1 = threadInfo.topic_user_name;
            this.C1 = threadInfo.topic_h5_url;
            this.A1 = threadInfo.topic_module;
            String str4 = threadInfo.presentation_style;
            this.G1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str5 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                y1 y1Var = new y1();
                this.D = y1Var;
                y1Var.f(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.J1 = threadInfo.swan_info;
            }
            this.R1 = threadInfo.t_share_img;
            this.S1 = threadInfo.nid;
            this.T1 = threadInfo.is_headlinepost.intValue() == 1;
            String str6 = threadInfo.thread_share_link;
            this.k2 = threadInfo.article_cover;
            this.l2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.m2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.l1.baijiahaoData = this.m2;
            }
            this.n2 = threadInfo.is_s_card.intValue() == 1;
            this.o2 = threadInfo.scard_packet_id;
            this.p2 = threadInfo.tab_id.intValue();
            this.q2 = threadInfo.tab_name;
            String str7 = threadInfo.wonderful_post_info;
            this.i2 = threadInfo.if_comment.intValue() == 1;
            this.j2 = threadInfo.if_comment_info;
            this.r2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.u2) {
                        this.u2 = true;
                    }
                    this.s2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.t2.add(pbGoodsData);
                }
                if (this.t2.size() > 0 && !this.u2) {
                    this.u2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.v2 = threadInfo.item;
            }
            if (this.v2 != null) {
                ItemData itemData = new ItemData();
                this.w2 = itemData;
                itemData.parseProto(this.v2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.x2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.y2 = itemStarData;
                itemStarData.parseProto(this.x2);
            }
            if (threadInfo.poll_info != null) {
                if (this.z2 == null) {
                    this.z2 = new PollData();
                }
                this.z2.parserProtobuf(threadInfo.poll_info);
            }
            this.A2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.I2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.J2 == null) {
                    this.J2 = new WorksInfoData();
                }
                this.J2.parseProto(threadInfo.works_info);
            }
            this.K2 = threadInfo.collect_num.intValue();
            if (!ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseProto(threadRecommendInfo);
                    this.L2.add(threadRecommendInfoData);
                }
            }
            this.U2 = threadInfo.is_frs_mask.intValue() == 1;
            this.O2 = StringHelper.equals(threadInfo.is_tiebaplus_ad, "1");
            this.P2 = threadInfo.tiebaplus_order_id;
            this.Q2 = threadInfo.tiebaplus_token;
            this.R2 = threadInfo.tiebaplus_extra_param;
            this.S2 = threadInfo.tiebaplus_cant_delete.intValue() == 1;
            Y2();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void S3(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, list) == null) {
            this.x2 = list;
        }
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.C : invokeV.longValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.n : invokeV.intValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.P0 : invokeV.booleanValue;
    }

    public void T2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            U2(z, z2, true);
        }
    }

    public void T3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048678, this, j2) == null) {
            this.J = j2;
        }
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public List<PbContent> U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.Y1 : invokeV.booleanValue;
    }

    public void U2(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)}) == null) {
            if (ListUtils.getCount(L0(z, z2, z4, false)) > 0) {
                N2(z, z4);
                return;
            }
            SpannableStringBuilder K2 = K2();
            if (z) {
                spannableStringBuilder = g(K2.toString(), K2, z, z2, z4, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(K2);
            }
            this.w = spannableStringBuilder;
        }
    }

    public void U3(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, list) == null) {
            this.s2 = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.s2) {
                if (pbLinkData.urlType == 2 && !this.u2) {
                    this.u2 = true;
                }
            }
        }
    }

    public List<PbContent> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.N0 : (String) invokeV.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            c.a.p0.i3.h0.o oVar = this.H2;
            if (oVar != null) {
                return oVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            Q2(false, true);
        }
    }

    public void V3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.Y = str;
        }
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.A0 : (String) invokeV.objValue;
    }

    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            MetaData metaData = this.Q;
            return (metaData == null || metaData.getGodUserData() == null || this.Q.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            Q2(false, false);
        }
    }

    public void W3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048693, this, z) == null) {
            this.E1 = z;
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.R1 : (String) invokeV.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.u2 : invokeV.booleanValue;
    }

    public int X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            if (!c.a.o0.s.k.c().g() || ListUtils.getCount(C0()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < C0().size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(C0(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void X3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z) == null) {
            this.F1 = z;
        }
    }

    public y1 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.D : (y1) invokeV.objValue;
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.N1 : (String) invokeV.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.c1 : invokeV.booleanValue;
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            j3();
            b3();
            h3();
            i3();
            Z2();
            f3();
            g3();
        }
    }

    public void Y3(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, arrayList) == null) {
            this.U = arrayList;
        }
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public long Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.n1 : invokeV.longValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.a0 == 41 : invokeV.booleanValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.y = G2();
        }
    }

    public void Z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.o = str;
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.j1 : (String) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.S : invokeV.intValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? h1() != null && m1() == 41 && j0() == 1 && i1() == 2 : invokeV.booleanValue;
    }

    public final void a3() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048712, this) == null) || (alaInfoData = this.t0) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j2 = this.w0;
            if (j2 > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j2);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.M1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.t0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.M1) || i2 <= 0) {
                if (i2 > 0) {
                    this.M1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.M1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void a4(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, pollData) == null) {
            this.z2 = pollData;
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.y0 : (String) invokeV.objValue;
    }

    public SkinInfo b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.O0 : (SkinInfo) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.p1 : invokeV.booleanValue;
    }

    public final void b3() {
        MetaData metaData;
        MetaData metaData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            if ((this instanceof y0) && "0".equals(f0())) {
                this.M1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
                return;
            }
            if (!z2() && (!U1() || getType() == u3)) {
                if (getType() != u3 && getType() != x3) {
                    long t0 = t0() * 1000;
                    if (t0 != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(t0);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(t0);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(t0);
                        }
                        this.M1 = string + formatTimeForJustNow;
                    } else {
                        long j2 = this.w0;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j2);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j2);
                        }
                        this.M1 = formatTimeForJustNow2;
                    }
                    if (j2()) {
                        d3();
                    } else if (q2()) {
                        c3();
                    } else if (!this.X1 && (metaData2 = this.Q) != null && metaData2.showBazhuGrade()) {
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.Q.getBazhuGradeData().getDesc(), this.W1 ? 24 : 16, "...");
                        if (!TextUtils.isEmpty(this.M1)) {
                            this.M1 += "   " + cutChineseAndEnglishWithSuffix;
                        } else {
                            this.M1 = cutChineseAndEnglishWithSuffix;
                        }
                    }
                    if (TextUtils.isEmpty(this.M1) || TextUtils.isEmpty(A())) {
                        return;
                    }
                    this.M1 += " • " + A();
                    return;
                }
                a3();
                return;
            }
            long j4 = this.w0;
            if (j4 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j4);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j4);
                }
                this.M1 = formatTimeForJustNow3;
            }
            MetaData metaData3 = this.Q;
            String str = (metaData3 == null || metaData3.getBaijiahaoInfo() == null || TextUtils.isEmpty(this.Q.getBaijiahaoInfo().auth_desc)) ? "" : this.Q.getBaijiahaoInfo().auth_desc;
            if (j2()) {
                d3();
            } else if (!this.X1 && (metaData = this.Q) != null && metaData.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = StringHelper.cutChineseAndEnglishWithSuffix(this.Q.getBazhuGradeData().getDesc(), 24, "...");
                if (!TextUtils.isEmpty(this.M1)) {
                    this.M1 += "   " + cutChineseAndEnglishWithSuffix2;
                    return;
                }
                this.M1 = cutChineseAndEnglishWithSuffix2;
            } else if (!TextUtils.isEmpty(this.M1) && !TextUtils.isEmpty(str)) {
                this.M1 += "   " + str;
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.M1 = str;
            }
        }
    }

    public void b4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i2) == null) {
            this.N2 = i2;
        }
    }

    public List<PbGoodsData> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.t2 : (List) invokeV.objValue;
    }

    public SmartApp c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.J1 : (SmartApp) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.a0 == 41 : invokeV.booleanValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048722, this) == null) || StringUtils.isNull(this.R)) {
            return;
        }
        this.M1 = (StringHelper.cutChineseAndEnglishWithSuffix(this.R, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(R.string.forum)) + GlideException.IndentedAppendable.INDENT + this.M1;
    }

    public void c4(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, praiseData) == null) {
            this.b0 = praiseData;
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.l1.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.g1 : invokeV.intValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? m1() == 50 : invokeV.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && j2() && !TextUtils.isEmpty(this.Q.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.M1)) {
                this.M1 += "   " + this.Q.getNewGodData().getFieldName() + c.a.o0.b1.q0.d(this.Q.getNewGodData().isVideoGod());
                return;
            }
            this.M1 = this.Q.getNewGodData().getFieldName() + c.a.o0.b1.q0.d(this.Q.getNewGodData().isVideoGod());
        }
    }

    public void d4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048728, this, i2) == null) {
            this.H = i2;
        }
    }

    public VideoInfo e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.D1 : (VideoInfo) invokeV.objValue;
    }

    public SpannableStringBuilder e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.w : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? m1() == 49 || m1() == 69 : invokeV.booleanValue;
    }

    public void e3() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || z2() || U1()) {
            return;
        }
        long t0 = t0() * 1000;
        if (t0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(t0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(t0);
            }
            this.M1 = formatTimeForJustNow;
        }
        if (j2()) {
            d3();
        } else if (!this.X1 && (metaData = this.Q) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.Q.getBazhuGradeData().getDesc(), 24, "...");
            if (!TextUtils.isEmpty(this.M1)) {
                this.M1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.M1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.M1) || TextUtils.isEmpty(A())) {
            return;
        }
        this.M1 += " • " + A();
    }

    public void e4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048733, this, i2) == null) {
            this.n = i2;
        }
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.p2 : invokeV.intValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.E1 : invokeV.booleanValue;
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            this.O1 = StringHelper.getFormatTimeShort(t0() * 1000);
        }
    }

    public void f4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, list) == null) {
            this.u = list;
        }
    }

    public final SpannableStringBuilder g(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048739, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> L0 = L0(z, z2, z4, z5);
            if (L0 == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h2 = c.a.p0.a0.m.h(TbadkCoreApplication.getInst(), str, L0, false);
            if (L0.size() > 0) {
                if (h2 == null) {
                    h2 = new SpannableStringBuilder();
                }
                if (this.q == 1) {
                    this.w = h2;
                    return h2;
                }
            } else if (this.q == 1) {
                this.w = new SpannableStringBuilder();
                return h2;
            }
            if (spannableStringBuilder != null) {
                h2.append((CharSequence) spannableStringBuilder);
            } else if (L0.size() > 0 || h2.length() == 0) {
                h2.append((CharSequence) str);
            }
            return h2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public int[] g0() {
        InterceptResult invokeV;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            int[] iArr = new int[2];
            int size = View.MeasureSpec.getSize(c.a.e.e.p.l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> C0 = C0();
            if (c.a.o0.s.k.c().g() && ListUtils.getCount(C0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i13 = 0; i13 < C0.size(); i13++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(C0, i13);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(C0, 0);
            if (mediaData2 == null || (i4 = mediaData2.picWidth) <= 0 || (i2 = mediaData2.picHeight) <= 0) {
                i12 = (i12 * 2) + dimensionPixelSize;
                i2 = i12;
            } else {
                if (i4 * 2 <= i2) {
                    i10 = ((int) (i12 * 1.5f)) + dimensionPixelSize;
                    i11 = i12 * 2;
                } else if (i2 * 2 <= i4) {
                    i10 = (i12 * 2) + dimensionPixelSize;
                    i11 = (int) (i12 * 1.5f);
                } else if (i4 >= i12) {
                    if (i4 < i12 || i4 >= (i9 = i12 * 2)) {
                        int i14 = mediaData2.picHeight;
                        if (i14 >= i12) {
                            if (i14 >= i12 && i14 < (i8 = i12 * 2)) {
                                i12 = i8 + dimensionPixelSize;
                                i5 = (i14 * i12) / mediaData2.picWidth;
                            } else {
                                int i15 = mediaData2.picWidth;
                                int i16 = mediaData2.picHeight;
                                if (i15 < i16) {
                                    i6 = (i12 * 2) + dimensionPixelSize;
                                    i7 = (i15 * i6) / i16;
                                } else {
                                    i12 = (i12 * 2) + dimensionPixelSize;
                                    i5 = (i16 * i12) / i15;
                                }
                            }
                            i2 = i5;
                        }
                        i12 = 0;
                        i2 = 0;
                    } else if (i2 < i12) {
                        i4 = (i4 * i12) / i2;
                        i2 = i12;
                        i12 = i4;
                    } else {
                        if (i2 < i12 || i2 >= i9) {
                            i6 = i9 + dimensionPixelSize;
                            i7 = (mediaData2.picWidth * i6) / mediaData2.picHeight;
                        }
                        i12 = i4;
                    }
                    i2 = i6;
                    i12 = i7;
                } else if (i2 >= i12) {
                    if (i2 >= i12 && i2 < i12 * 2) {
                        i2 = (i2 * i12) / i4;
                    }
                    i12 = 0;
                    i2 = 0;
                } else if (i4 < i2) {
                    i2 = (i2 * i12) / i4;
                } else {
                    i4 = (i4 * i12) / i2;
                    i2 = i12;
                    i12 = i4;
                }
                i2 = i11 + dimensionPixelSize;
                i12 = i10;
            }
            iArr[0] = i12;
            iArr[1] = i2;
            c.a.o0.b.g.b.k(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.q2 : (String) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.F1 : invokeV.booleanValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            this.P1 = StringHelper.getFormatTimeShort(t0());
        }
    }

    public void g4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, list) == null) {
            this.t = list;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            ArrayList<MediaData> C0 = C0();
            if (C0 == null || w2()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < C0.size() && i2 < 3; i2++) {
                if (C0.get(i2) != null && C0.get(i2).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(C0.get(i2).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = C0.get(i2).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = C0.get(i2).getPicUrl();
                    }
                    preLoadImageInfo.procType = 13;
                    arrayList.add(preLoadImageInfo);
                }
            }
            int size = arrayList.size();
            Iterator<PreLoadImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PreLoadImageInfo next = it.next();
                if (size == 1) {
                    next.preloadType = 1;
                } else {
                    next.preloadType = 2;
                }
            }
            VideoInfo videoInfo = this.q0;
            if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.imgUrl = this.q0.thumbnail_url;
                preLoadImageInfo2.procType = 10;
                preLoadImageInfo2.preloadType = 1;
                arrayList.add(preLoadImageInfo2);
            }
            if (this.Q != null) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.Q.getPortrait();
                preLoadImageInfo3.procType = 28;
                preLoadImageInfo3.preloadType = 3;
                arrayList.add(preLoadImageInfo3);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            SparseArray<String> sparseArray = this.h1;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            getThreadData();
            x0Var.p(q1());
            getThreadData();
            x0Var.l(T());
            getThreadData();
            x0Var.o(D0());
            x0Var.k(this.h1);
            x0Var.f14081g = this.i1;
            x0Var.p = this.W0;
            x0Var.k = this.V0;
            x0Var.m = this.X0;
            x0Var.l = this.U0;
            x0Var.q = this.Q1;
            x0Var.o = O0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.Y0 : (String) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this : (c2) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            c.a.p0.i3.h0.o oVar = this.H2;
            if (oVar != null) {
                return oVar.f() ? this.H2.g() ? AdvertAppInfo.x4 : AdvertAppInfo.y4 : this.H2.g() ? AdvertAppInfo.x4 : AdvertAppInfo.w4;
            } else if (i0()) {
                if (o1() != null) {
                    return t3;
                }
                return W2;
            } else {
                int p0 = p0();
                if (this.z1 == 1) {
                    if (this.A1 != null) {
                        return k3;
                    }
                    return this.D1 != null ? E3 : D3;
                } else if (this.t0 != null && this.a0 == 60) {
                    return w3;
                } else {
                    if (this.t0 != null && ((i2 = this.a0) == 49 || i2 == 69)) {
                        return u3;
                    }
                    if (this.t0 != null && this.a0 == 67) {
                        return x3;
                    }
                    int i4 = this.a0;
                    if (i4 == 51) {
                        return v3;
                    }
                    if (i4 == 63) {
                        return F3;
                    }
                    if (i4 == 64) {
                        return G3;
                    }
                    if (p0 != 2 && p0 != 1) {
                        if (this.q0 != null && Y1() && !c2()) {
                            return L3;
                        }
                        if (this.q0 != null && !c2()) {
                            if (W1()) {
                                return C3;
                            }
                            if (this instanceof y0) {
                                return M3;
                            }
                            return t3;
                        } else if (this.w1 && (originalThreadInfo = this.v1) != null) {
                            if (originalThreadInfo.w) {
                                if (originalThreadInfo.r != null) {
                                    return B3;
                                }
                                if (originalThreadInfo.f()) {
                                    return A3;
                                }
                                return z3;
                            }
                            return y3;
                        } else if (J1()) {
                            return l3;
                        } else {
                            if (a2()) {
                                return I3.get() ? P3 : W2;
                            } else if (G1() && w() == 1) {
                                return I3.get() ? Q3 : W2;
                            } else if (b2()) {
                                return r3;
                            } else {
                                if (W1()) {
                                    return s3;
                                }
                                if (this.f13868e) {
                                    return c3;
                                }
                                if (this.f13869f) {
                                    return d3;
                                }
                                if (this.f13870g) {
                                    return e3;
                                }
                                if (this.f13871h) {
                                    return f3;
                                }
                                if (this.f13872i) {
                                    return g3;
                                }
                                if (this.k) {
                                    return i3;
                                }
                                if (this.l) {
                                    return j3;
                                }
                                if (this.f13873j) {
                                    return h3;
                                }
                                if (this.m) {
                                    return n3;
                                }
                                if (this.C0) {
                                    int X22 = X2();
                                    if (X22 == 1) {
                                        return Y2;
                                    }
                                    if (X22 == 2) {
                                        return Z2;
                                    }
                                    if (X22 > 2) {
                                        return a3;
                                    }
                                    return W2;
                                }
                                return W2;
                            }
                        }
                    }
                    return V2;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            VideoInfo videoInfo = this.q0;
            if (videoInfo != null) {
                return videoInfo.video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.d1 : invokeV.intValue;
    }

    public a2 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? this.J0 : (a2) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.k1 : invokeV.booleanValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            if (j1() != null && j1().share_info != null && j1().share_info.share_user_count > 0 && p2() && (this.t1 <= 0 || this.u1 != 0)) {
                int i2 = j1().share_info.share_user_count;
                if (i2 == 1) {
                    this.N1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.N1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                    return;
                }
            }
            this.N1 = null;
        }
    }

    public void h4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.F = str;
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this.I1 : invokeV.booleanValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            a2 a2Var = this.J0;
            if (a2Var != null) {
                long e2 = a2Var.e();
                long a2 = this.J0.a();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < e2) {
                    return 1;
                }
                return currentTimeMillis > a2 ? 3 : 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            SpannableStringBuilder M2 = M2();
            this.x = M2;
            c.a.p0.a0.m.b(this, M2, true);
        }
    }

    public void i4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048762, this, j2) == null) {
            this.n1 = j2;
        }
    }

    @Override // c.a.o0.s.q.a
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.W1 : invokeV.booleanValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.N : invokeV.intValue;
    }

    public AlaInfoData j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? this.t0 : (AlaInfoData) invokeV.objValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            MetaData metaData = this.Q;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048767, this) == null) || StringUtils.isNull(this.Q.getName_show())) {
            return;
        }
        this.L1 = StringHelper.cutChineseAndEnglishWithSuffix(this.Q.getName_show(), 12, "...");
    }

    public void j4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
            this.K1 = z;
        }
    }

    public SpannableString k(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048769, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            c.a.o0.s.f0.k kVar = new c.a.o0.s.f0.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String p = c.a.o0.s.d0.b.j().p("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
            if (StringUtils.isNull(p)) {
                p = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
            }
            StringBuilder sb = new StringBuilder(p);
            if (J() != null) {
                if (J().getGender() == 1) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
                } else if (J().getGender() == 2) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
                } else {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
                }
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
            sb.insert(0, "[icon]");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(kVar, 0, 6, 17);
            spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.X : invokeV.intValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? this.M1 : (String) invokeV.objValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.a0 == 0 : invokeV.booleanValue;
    }

    public void k3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.s = str;
        }
    }

    public void k4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048774, this, i2) == null) {
            this.g1 = i2;
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.L : invokeV.intValue;
    }

    public List<ThreadRecommendInfoData> l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.L2 : (List) invokeV.objValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) ? this.a0 == 31 : invokeV.booleanValue;
    }

    public void l3(ArrayList<b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, arrayList) == null) {
            this.D0 = arrayList;
        }
    }

    public void l4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048779, this, i2) == null) {
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.q : invokeV.intValue;
    }

    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) ? this.v0 == 1 : invokeV.booleanValue;
    }

    public void m3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048783, this, i2) == null) {
            this.l1.agreeNum = i2;
        }
    }

    public void m4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048784, this, str, str2) == null) {
            this.M0 = str;
            this.N0 = str2;
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) ? this.T0 : invokeV.booleanValue;
    }

    public j2 n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) ? this.s0 : (j2) invokeV.objValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) ? m1() == 40 : invokeV.booleanValue;
    }

    public void n3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048788, this, j2) == null) {
            this.l1.agreeNum = j2;
        }
    }

    public void n4(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, alaInfoData) == null) {
            this.t0 = alaInfoData;
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.M : invokeV.intValue;
    }

    public VideoInfo o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.q0 : (VideoInfo) invokeV.objValue;
    }

    public boolean o2() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? (q0() == null && ((originalThreadInfo = this.v1) == null || originalThreadInfo.B == null)) ? false : true : invokeV.booleanValue;
    }

    public void o3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048794, this, i2) == null) {
            this.l1.agreeType = i2;
        }
    }

    public void o4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, str) == null) {
            this.M1 = str;
        }
    }

    public SpannableString p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) ? this.y : (SpannableString) invokeV.objValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.K : invokeV.intValue;
    }

    public VideoDesc p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) ? this.r0 : (VideoDesc) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) ? m1() == 60 : invokeV.booleanValue;
    }

    public void p3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048800, this, i2) == null) {
            this.u0 = i2;
        }
    }

    public void p4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048801, this, i2) == null) {
            this.a0 = i2;
        }
    }

    public ArrayList<b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? this.D0 : (ArrayList) invokeV.objValue;
    }

    public Item q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? this.v2 : (Item) invokeV.objValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            if (!StringUtils.isNull(this.B) && !"0".equals(this.B)) {
                return this.B;
            }
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048805, this)) == null) ? E2() && !StringUtils.isNull(this.R) && this.X1 : invokeV.booleanValue;
    }

    public void q3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            this.k2 = str;
        }
    }

    public void q4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, str) == null) {
            this.B = str;
        }
    }

    public List<HeadItem> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? this.x2 : (List) invokeV.objValue;
    }

    @Nullable
    public List<c.a.o0.d1.o.a> r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) ? this.K1 : invokeV.booleanValue;
    }

    public void r3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, metaData) == null) {
            this.Q = metaData;
        }
    }

    public void r4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, str) == null) {
            this.r = str;
        }
    }

    public long s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? this.a1 : invokeV.longValue;
    }

    public SpannableStringBuilder s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) ? this.x : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) {
            int i2 = this.a0;
            return i2 == 63 || i2 == 64;
        }
        return invokeV.booleanValue;
    }

    public void s3(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048816, this, baijiahaoData) == null) {
            this.m2 = baijiahaoData;
        }
    }

    public void s4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, str) == null) {
            this.C1 = str;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048818, this)) == null) {
            if (!G1() || this.D0.size() < 1) {
                return -1;
            }
            b bVar = this.D0.get(0);
            int e2 = bVar.e();
            if (e2 == 3) {
                return e2;
            }
            int b2 = bVar.b();
            int c2 = bVar.c();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < b2) {
                return 4;
            }
            return currentTimeMillis > c2 ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public long t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048819, this)) == null) ? this.J : invokeV.longValue;
    }

    public PostData t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) ? this.m1 : (PostData) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) ? this.V1 : invokeV.booleanValue;
    }

    public void t3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048822, this, i2) == null) {
            this.I0 = i2;
        }
    }

    public void t4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.B1 = str;
        }
    }

    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048824, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public g2 u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) ? this.O : (g2) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? this.W == 1 : invokeV.booleanValue;
    }

    public void u3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048827, this, j2) == null) {
            this.l1.diffAgreeNum = j2;
        }
    }

    public void u4(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048828, this, hashMap) == null) {
            this.j0 = hashMap;
        }
    }

    public String v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048829, this)) == null) ? this.M0 : (String) invokeV.objValue;
    }

    public TopicModule v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? this.A1 : (TopicModule) invokeV.objValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) ? this.O2 || this.S2 : invokeV.booleanValue;
    }

    public void v3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048832, this, j2) == null) {
            this.T2 = j2;
        }
    }

    public void v4(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048833, this, videoInfo) == null) {
            this.q0 = videoInfo;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) {
            if (!G1() || this.D0.size() < 1 || this.D0.get(0) == null) {
                return -1;
            }
            return this.D0.get(0).a();
        }
        return invokeV.intValue;
    }

    public String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) ? this.Q0 : (String) invokeV.objValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) ? this.C1 : (String) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) ? p0() != 0 : invokeV.booleanValue;
    }

    public void w3(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, str) == null) {
            v3(c.a.e.e.m.b.f(str, 0L));
        }
    }

    public void w4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048839, this, i2) == null) {
            this.I = i2;
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) ? (!G1() || this.D0.size() < 1 || this.D0.get(0) == null) ? "" : this.D0.get(0).g() : (String) invokeV.objValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) ? this.L1 : (String) invokeV.objValue;
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) ? this.B1 : (String) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048843, this)) == null) ? this.z1 == 1 : invokeV.booleanValue;
    }

    public void x3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048844, this, j2) == null) {
            this.C = j2;
        }
    }

    public void x4(ArrayList<VoiceData$VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, arrayList) == null) {
            this.V = arrayList;
        }
    }

    public ActivityItemData y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) {
            List<PbContent> list = this.t;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.t.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && A2() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = c.a.o0.r0.b.d(pbContent.text);
                    String str2 = pbContent.text;
                    activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                    return activityItemData;
                }
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    public List<PbLinkData> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) ? this.s2 : (List) invokeV.objValue;
    }

    public HashMap<String, MetaData> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048848, this)) == null) ? this.j0 : (HashMap) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048849, this)) == null) ? this.G1 != null : invokeV.booleanValue;
    }

    public void y3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, str) == null) {
            this.E = str;
        }
    }

    public void y4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048851, this, j2) == null) {
            this.w0 = j2;
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    public r0 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) ? this.o1 : (r0) invokeV.objValue;
    }

    public int z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048854, this)) == null) {
            if (L1() || K1()) {
                return 2;
            }
            return (J1() || M1()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048855, this)) == null) {
            BaijiahaoData baijiahaoData = this.m2;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public void z3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, list) == null) {
            this.v = list;
        }
    }

    public void z4(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, list) == null) {
            this.t2 = list;
            if (ListUtils.isEmpty(list) || this.u2) {
                return;
            }
            this.u2 = true;
        }
    }
}
