package c.a.t0.s.r;

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
import c.a.u0.g0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.AnchorInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumRecTip;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import tbclient.TiebaPlusAd;
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.UserPostPerm;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.VoiceRoom;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes6.dex */
public class e2 extends a implements PreLoadImageProvider, c.a.d.o.e.n, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A3;
    public static final BdUniqueId B3;
    public static final BdUniqueId C3;
    public static final BdUniqueId D3;
    public static final BdUniqueId E3;
    public static final BdUniqueId F3;
    public static final BdUniqueId G3;
    public static final BdUniqueId H3;
    public static final BdUniqueId I3;
    public static final BdUniqueId J3;
    public static final BdUniqueId K3;
    public static final BdUniqueId L3;
    public static final BdUniqueId M3;
    public static final BdUniqueId N3;
    public static final BdUniqueId O3;
    public static final BdUniqueId P3;
    public static final BdUniqueId Q3;
    public static final BdUniqueId R3;
    public static final BdUniqueId S3;
    public static final BdUniqueId T3;
    public static final BdUniqueId U3;
    public static final BdUniqueId V3;
    public static AtomicBoolean W3;
    public static AtomicBoolean X3;
    public static final BdUniqueId Y3;
    public static final BdUniqueId Z3;
    public static HashMap<Point, Integer> a4;
    public static HashMap<Integer, Integer> b4;
    public static final BdUniqueId c4;
    public static final BdUniqueId d4;
    public static HashMap<Point, Integer> e4;
    public static SparseArray<m.a> f4;
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
    @Nullable
    public List<c.a.t0.f1.p.b> A;
    public int A0;
    public boolean A1;
    public Item A2;
    public String B;
    public long B0;
    public String B1;
    public ItemData B2;
    public int C;
    public long C0;
    public String C1;
    public List<HeadItem> C2;
    public int D;
    public String D0;
    public int D1;
    public ItemStarData D2;
    public String E;
    public int E0;
    public TopicModule E1;
    public PollData E2;
    public long F;
    public String F0;
    public String F1;
    public int F2;
    public a2 G;
    public int G0;
    public VideoInfo G1;
    public String G2;
    public String H;
    public boolean H0;
    public boolean H1;
    public String H2;
    public String I;
    public ArrayList<b> I0;
    public boolean I1;
    public String I2;
    public String J;
    public q2 J0;
    public OriginalForumInfo J1;
    public boolean J2;
    public int K;
    public i K0;
    public boolean K1;
    public boolean K2;
    public int L;
    public u L0;
    public boolean L1;
    public int L2;
    public long M;
    public String M0;
    public SmartApp M1;
    public c.a.u0.z3.k0.o M2;
    public int N;
    public int N0;
    public boolean N1;
    public int N2;
    public int O;
    public c2 O0;
    public String O1;
    public WorksInfoData O2;
    public int P;
    public ArrayList<c.a.t0.u.c> P0;
    public String P1;
    public int P2;
    public int Q;
    public PushStatusData Q0;
    public String Q1;
    public List<ThreadRecommendInfoData> Q2;
    public h2 R;
    public String R0;
    public String R1;
    public String R2;
    public String S;
    public String S0;
    public String S1;
    public String S2;
    public MetaData T;
    public SkinInfo T0;
    public int T1;
    public int T2;
    public String U;
    public boolean U0;
    public String U1;
    public boolean U2;
    public int V;
    public String V0;
    public String V1;
    public String V2;
    public String W;
    public int W0;
    public boolean W1;
    public String W2;
    public ArrayList<MediaData> X;
    public r X0;
    public boolean X1;
    public String X2;
    public ArrayList<VoiceData$VoiceModel> Y;
    public boolean Y0;
    public boolean Y1;
    public boolean Y2;
    public int Z;
    public String Z0;
    public boolean Z1;
    public String Z2;
    public int a0;
    public String a1;
    public boolean a2;
    public String a3;
    public String b0;
    public String b1;
    public boolean b2;
    public int b3;
    public int c0;
    public String c1;
    public boolean c2;
    public UserPostPerm c3;
    public int d0;
    public String d1;
    public boolean d2;
    public long d3;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13835e;
    public PraiseData e0;
    public long e1;
    public boolean e2;
    public VoiceRoom e3;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13836f;
    public AnchorInfoData f0;
    public boolean f1;
    public boolean f2;
    public int f3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13837g;
    public String g0;
    public boolean g1;
    public boolean g2;
    public ForumRecTip g3;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13838h;
    public HashMap<String, MetaData> h0;
    public int h1;
    public boolean h2;
    public boolean h3;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13839i;
    public String i0;
    public boolean i1;
    public boolean i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13840j;
    public boolean j1;
    public String j2;
    public boolean k;
    public String k0;
    public int k1;
    public String k2;
    public boolean l;
    public SparseArray<String> l1;
    public boolean l2;
    public boolean m;
    public SparseArray<String> m1;
    public String m2;
    public boolean n;
    public String n1;
    public boolean n2;
    public int o;
    public boolean o1;
    public String o2;
    public String p;
    public AgreeData p1;
    public String p2;
    public int q;
    public String q0;
    public PostData q1;
    public int q2;
    public int r;
    public String r0;
    public long r1;
    public BaijiahaoData r2;
    public String s;
    public int s0;
    public r0 s1;
    public boolean s2;
    public String t;
    public int t0;
    public boolean t1;
    public String t2;
    public List<PbContent> u;
    public ArrayList<c.a.t0.t.i.c> u0;
    public boolean u1;
    public int u2;
    public List<PbContent> v;
    public VideoInfo v0;
    public h v1;
    public String v2;
    public List<PbContent> w;
    public VideoDesc w0;
    public MediaData w1;
    public ThreadInfo w2;
    public SpannableStringBuilder x;
    public k2 x0;
    public int x1;
    public List<PbLinkData> x2;
    public SpannableStringBuilder y;
    public AlaInfoData y0;
    public int y1;
    public List<PbGoodsData> y2;
    public SpannableString z;
    public int z0;
    public OriginalThreadInfo z1;
    public boolean z2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1162594104, "Lc/a/t0/s/r/e2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1162594104, "Lc/a/t0/s/r/e2;");
                return;
            }
        }
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
        I3 = BdUniqueId.gen();
        J3 = BdUniqueId.gen();
        K3 = BdUniqueId.gen();
        L3 = BdUniqueId.gen();
        M3 = BdUniqueId.gen();
        N3 = BdUniqueId.gen();
        O3 = BdUniqueId.gen();
        P3 = BdUniqueId.gen();
        Q3 = BdUniqueId.gen();
        R3 = BdUniqueId.gen();
        S3 = BdUniqueId.gen();
        T3 = BdUniqueId.gen();
        U3 = BdUniqueId.gen();
        V3 = BdUniqueId.gen();
        W3 = new AtomicBoolean(false);
        X3 = new AtomicBoolean(true);
        new AtomicBoolean(true);
        Y3 = BdUniqueId.gen();
        Z3 = BdUniqueId.gen();
        a4 = new HashMap<>();
        b4 = new HashMap<>();
        c4 = BdUniqueId.gen();
        d4 = BdUniqueId.gen();
        e4 = new HashMap<>();
        f4 = new SparseArray<>(3);
        a4.put(new Point(1, 1), Integer.valueOf(c.a.u0.a4.f.label_frs_lottery_ing));
        a4.put(new Point(1, 2), Integer.valueOf(c.a.u0.a4.f.label_frs_lottery_over));
        a4.put(new Point(1, 3), Integer.valueOf(c.a.u0.a4.f.label_frs_lottery_off));
        a4.put(new Point(1, 4), Integer.valueOf(c.a.u0.a4.f.label_frs_lottery_d));
        a4.put(new Point(2, 1), Integer.valueOf(c.a.u0.a4.f.label_frs_activity_shaiing));
        a4.put(new Point(2, 2), Integer.valueOf(c.a.u0.a4.f.label_frs_activity_shai_over));
        a4.put(new Point(2, 3), Integer.valueOf(c.a.u0.a4.f.label_frs_activity_shai_off));
        a4.put(new Point(2, 4), Integer.valueOf(c.a.u0.a4.f.label_frs_activity_shai_d));
        e4.put(new Point(1, 1), Integer.valueOf(c.a.u0.a4.j.lottery_status_ing));
        e4.put(new Point(1, 2), Integer.valueOf(c.a.u0.a4.j.lottery_status_over));
        e4.put(new Point(1, 3), Integer.valueOf(c.a.u0.a4.j.lottery_status_off));
        e4.put(new Point(1, 4), Integer.valueOf(c.a.u0.a4.j.lottery_status_not_start));
        e4.put(new Point(2, 1), Integer.valueOf(c.a.u0.a4.j.share_picture_status_ing));
        e4.put(new Point(2, 2), Integer.valueOf(c.a.u0.a4.j.share_picture_status_over));
        e4.put(new Point(2, 3), Integer.valueOf(c.a.u0.a4.j.share_picture_status_off));
        e4.put(new Point(2, 4), Integer.valueOf(c.a.u0.a4.j.share_picture_status_not_start));
        b4.put(1, Integer.valueOf(c.a.u0.a4.f.label_interview_no));
        b4.put(2, Integer.valueOf(c.a.u0.a4.f.label_interview_live));
        b4.put(3, Integer.valueOf(c.a.u0.a4.f.label_interview_off));
        f4.put(1, new m.a(c.a.u0.a4.j.interview_live_status_not_start, c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
        f4.put(2, new m.a(c.a.u0.a4.j.interview_live_status_ing, c.a.u0.a4.d.CAM_X0309, c.a.u0.a4.f.pic_dot_title_green));
        f4.put(3, new m.a(c.a.u0.a4.j.interview_live_status_over, c.a.u0.a4.d.CAM_X0303, c.a.u0.a4.f.pic_dot_title_blue));
    }

    public e2() {
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
        this.f13835e = false;
        this.f13836f = false;
        this.f13837g = false;
        this.f13838h = false;
        this.f13839i = false;
        this.f13840j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = "1";
        this.q = 1;
        this.Z = 0;
        this.b0 = null;
        this.t0 = 0;
        this.E0 = 0;
        this.F0 = "";
        this.H0 = false;
        this.M0 = "";
        this.f1 = true;
        this.j1 = false;
        this.k1 = -1;
        this.l1 = null;
        this.m1 = null;
        this.u1 = false;
        this.x1 = 0;
        this.D1 = 0;
        this.H1 = false;
        this.N1 = false;
        this.W1 = false;
        this.X1 = false;
        this.n2 = false;
        this.s2 = false;
        this.J2 = false;
        this.K2 = false;
        this.R2 = "";
        this.S2 = "";
        this.B = null;
        this.E = null;
        this.F = 0L;
        this.s = null;
        this.A0 = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0L;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = new h2();
        this.T = new MetaData();
        this.U = null;
        this.X = new ArrayList<>();
        this.Y = new ArrayList<>();
        this.V = 0;
        this.W = null;
        this.t = null;
        this.a0 = 0;
        this.e0 = new PraiseData();
        this.f0 = new AnchorInfoData();
        this.s0 = 0;
        this.I0 = new ArrayList<>();
        this.J0 = null;
        this.K0 = null;
        this.u0 = new ArrayList<>();
        this.G0 = 0;
        this.G0 = 0;
        this.N0 = 0;
        this.t0 = 0;
        this.z0 = 0;
        this.W0 = 0;
        this.X0 = new r();
        this.w = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.J = null;
        this.O0 = new c2();
        this.P0 = new ArrayList<>();
        this.Q0 = new PushStatusData();
        this.Z = 0;
        this.g1 = false;
        this.h1 = -1;
        this.q1 = new PostData();
        this.p1 = new AgreeData();
        this.x1 = 0;
        this.y1 = 0;
        this.D0 = "";
        this.C1 = "";
        this.B1 = "";
        this.R0 = "";
        this.S0 = "";
        this.x2 = new ArrayList();
        this.y2 = new ArrayList();
        this.Q2 = new ArrayList();
        this.F2 = -1;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q0 : (String) invokeV.objValue;
    }

    public String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public h2 A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R : (h2) invokeV.objValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.d0;
            return i2 == 63 || i2 == 64;
        }
        return invokeV.booleanValue;
    }

    public void A3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.z0 = i2;
        }
    }

    public void A4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    public AgreeData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p1 : (AgreeData) invokeV.objValue;
    }

    public String B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.O1 : (String) invokeV.objValue;
    }

    public TopicModule B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.E1 : (TopicModule) invokeV.objValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Y1 : invokeV.booleanValue;
    }

    public void B3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.p2 = str;
        }
    }

    public void B4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.R0 = str;
            this.S0 = str2;
        }
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p1.agreeNum : invokeV.longValue;
    }

    public List<PbLinkData> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.x2 : (List) invokeV.objValue;
    }

    public String C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.F1 : (String) invokeV.objValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.Z == 1 : invokeV.booleanValue;
    }

    public void C3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, metaData) == null) {
            this.T = metaData;
        }
    }

    public void C4(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, alaInfoData) == null) {
            this.y0 = alaInfoData;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.p1.agreeType : invokeV.intValue;
    }

    public r0 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.s1 : (r0) invokeV.objValue;
    }

    public HashMap<String, MetaData> D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.h0 : (HashMap) invokeV.objValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.U2 || this.Y2 : invokeV.booleanValue;
    }

    public void D3(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, baijiahaoData) == null) {
            this.r2 = baijiahaoData;
        }
    }

    public void D4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.P1 = str;
        }
    }

    public AnchorInfoData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f0 : (AnchorInfoData) invokeV.objValue;
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (S1() || R1()) {
                return 2;
            }
            return (Q1() || T1()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? t0() != 0 : invokeV.booleanValue;
    }

    public void E3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.N0 = i2;
        }
    }

    public void E4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.d0 = i2;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.z0 : invokeV.intValue;
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.b0 : (String) invokeV.objValue;
    }

    public int F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.L : invokeV.intValue;
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.D1 == 1 : invokeV.booleanValue;
    }

    public void F3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j2) == null) {
            this.p1.diffAgreeNum = j2;
        }
    }

    public void F4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.E = str;
        }
    }

    public i G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.K0 : (i) invokeV.objValue;
    }

    public ArrayList<MediaData> G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.X : (ArrayList) invokeV.objValue;
    }

    public ArrayList<VoiceData$VoiceModel> G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.Y : (ArrayList) invokeV.objValue;
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.J1 != null : invokeV.booleanValue;
    }

    public void G3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j2) == null) {
            this.d3 = j2;
        }
    }

    public void G4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.s = str;
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.p2 : (String) invokeV.objValue;
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.V1 : (String) invokeV.objValue;
    }

    public VoiceRoom H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.e3 : (VoiceRoom) invokeV.objValue;
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            BaijiahaoData baijiahaoData = this.r2;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public void H3(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            G3(c.a.d.f.m.b.g(str, 0L));
        }
    }

    public void H4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
        }
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.C0 : invokeV.longValue;
    }

    public int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (S0() == 1) {
                return 2;
            }
            if (S0() == 2) {
                return 3;
            }
            return S0() == 3 ? 1 : 4;
        }
        return invokeV.intValue;
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            int i2 = this.d0;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void I3(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, sparseArray) == null) {
            this.l1 = sparseArray;
        }
    }

    public void I4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.F1 = str;
        }
    }

    public MetaData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.T : (MetaData) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public q2 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.J0 : (q2) invokeV.objValue;
    }

    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? I2() && N2() : invokeV.booleanValue;
    }

    public void J3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            this.F = j2;
        }
    }

    public void J4(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, hashMap) == null) {
            this.h0 = hashMap;
        }
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.q2 : invokeV.intValue;
    }

    public PollData K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.E2 : (PollData) invokeV.objValue;
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || ListUtils.getCount(this.C2) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.y;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) c.a.t0.f1.n.e.e(this.C2));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.z);
        spannableStringBuilder2.insert(0, (CharSequence) c.a.t0.f1.n.e.e(this.C2));
        this.z = new SpannableString(spannableStringBuilder2);
    }

    public boolean K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            VoiceRoom voiceRoom = this.e3;
            return voiceRoom != null && voiceRoom.room_id.longValue() > 0;
        }
        return invokeV.booleanValue;
    }

    public void K3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.H = str;
        }
    }

    public void K4(UserPostPerm userPostPerm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, userPostPerm) == null) {
            this.c3 = userPostPerm;
        }
    }

    public BaijiahaoData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.r2 : (BaijiahaoData) invokeV.objValue;
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.T2 : invokeV.intValue;
    }

    public void L1(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, spannableString) == null) || J() == null || showNoName() || showWeakenName()) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.y;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.z);
        spannableStringBuilder2.insert(0, (CharSequence) spannableString);
        this.z = new SpannableString(spannableStringBuilder2);
    }

    public boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.d0 == 11 || this.c0 == 1 : invokeV.booleanValue;
    }

    public void L3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, list) == null) {
            this.w = list;
        }
    }

    public void L4(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, videoInfo) == null) {
            this.v0 = videoInfo;
        }
    }

    public u M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.L0 : (u) invokeV.objValue;
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.G0 : invokeV.intValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.s0 == 1 : invokeV.booleanValue;
    }

    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.d0 == 36 : invokeV.booleanValue;
    }

    public void M3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.U0 = z;
        }
    }

    public void M4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.L = i2;
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public PraiseData N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.e0 : (PraiseData) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? s0() == 1 : invokeV.booleanValue;
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            WorksInfoData worksInfoData = this.O2;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void N3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.U = str;
        }
    }

    public void N4(ArrayList<VoiceData$VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, arrayList) == null) {
            this.Y = arrayList;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.N0 : invokeV.intValue;
    }

    public ArrayList<c.a.t0.f1.n.b> O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            ArrayList<c.a.t0.f1.n.b> arrayList = new ArrayList<>();
            if (this.s2) {
                arrayList.add(new c.a.t0.f1.n.b(TbadkCoreApplication.getInst().getResources().getString(c.a.u0.a4.j.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? (J() == null || J().getAlaUserData() == null || J().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.A0 != 0 : invokeV.booleanValue;
    }

    public void O3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.b2 = z;
        }
    }

    public void O4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048665, this, j2) == null) {
            this.B0 = j2;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.B0 : invokeV.longValue;
    }

    public final ArrayList<m.a> P0(boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048667, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> arrayList = new ArrayList<>();
            boolean O2 = O2();
            if (z2) {
                if (z) {
                    if (O2 && !I2()) {
                        arrayList.add(new m.a(c.a.u0.a4.j.god_title));
                    }
                    if (l0() == 1 || s1() == 33 || (A1() != null && A1().a() != 0)) {
                        if (n1() == null || !g2()) {
                            if (!O2) {
                                arrayList.add(new m.a(c.a.u0.a4.j.photo_live_tips));
                            }
                        } else if (o1() == 2) {
                            arrayList.add(new m.a(c.a.u0.a4.j.interview_live));
                        }
                    }
                    if (g2()) {
                        arrayList.add(f4.get(o1()));
                    }
                    if (M1()) {
                        Integer num = e4.get(new Point(w(), t()));
                        if (num != null) {
                            arrayList.add(new m.a(num.intValue(), c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(c.a.u0.a4.j.card_promotion_text));
                        }
                    }
                    if (J1() != null) {
                        arrayList.add(new m.a(c.a.u0.a4.j.card_promotion_text, c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
                    }
                    if (!c.a.d.f.p.m.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                } else {
                    if (O2 && t0() != 1 && !I2()) {
                        arrayList.add(new m.a(c.a.u0.a4.j.god_title));
                    }
                    if ((l0() == 1 || s1() == 33) && !g2() && !O2) {
                        arrayList.add(new m.a(c.a.u0.a4.j.photo_live_tips));
                    }
                    if (s0() == 1) {
                        arrayList.add(new m.a(c.a.u0.a4.j.good));
                    }
                    if (t0() == 1) {
                        arrayList.add(new m.a(c.a.u0.a4.j.top));
                    }
                    if (g2() && n1() != null && o1() == 2) {
                        arrayList.add(new m.a(c.a.u0.a4.j.interview_live));
                    }
                    if (M1()) {
                        Integer num2 = e4.get(new Point(w(), t()));
                        if (num2 != null) {
                            arrayList.add(new m.a(num2.intValue(), c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(c.a.u0.a4.j.card_promotion_text));
                        }
                    }
                    if (this.W0 == 1) {
                        arrayList.add(new m.a(c.a.u0.a4.j.card_tbread_text));
                    }
                    if (G() != null) {
                        arrayList.add(new m.a(c.a.u0.a4.j.send_app_code_gift, c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
                    }
                    if (J1() != null) {
                        arrayList.add(new m.a(c.a.u0.a4.j.card_promotion_text, c.a.u0.a4.d.CAM_X0308, c.a.u0.a4.f.pic_dot_title_red));
                    }
                    if (!c.a.d.f.p.m.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                    if (z4 && l2()) {
                        arrayList.add(new m.a(c.a.u0.a4.j.ala_live));
                    }
                    if (z4 && k2()) {
                        arrayList.add(new m.a(c.a.u0.a4.j.live_record));
                    } else if (v2()) {
                        arrayList.add(new m.a(c.a.u0.a4.j.video_title_str));
                    }
                    if (z5) {
                        arrayList.add(new m.a(c.a.u0.a4.j.video_review_state));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            MetaData metaData = this.T;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            UserPostPerm userPostPerm = this.c3;
            return userPostPerm != null && userPostPerm.not_show_hide_thread.intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public void P3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
            this.Z1 = z;
        }
    }

    public void P4(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, list) == null) {
            this.y2 = list;
            if (ListUtils.isEmpty(list) || this.z2) {
                return;
            }
            this.z2 = true;
        }
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.p1.disAgreeNum : invokeV.longValue;
    }

    public PushStatusData Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.Q0 : (PushStatusData) invokeV.objValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            BaijiahaoData baijiahaoData = this.r2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableString Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            SpannableStringBuilder U2 = U2();
            c.a.u0.g0.m.b(this, U2, false);
            return new SpannableString(U2);
        }
        return (SpannableString) invokeV.objValue;
    }

    public void Q3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.n1 = str;
        }
    }

    public boolean Q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.z1;
            return originalThreadInfo != null && originalThreadInfo.H && this.F == originalThreadInfo.f40388e;
        }
        return invokeV.booleanValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.d3 : invokeV.longValue;
    }

    public ThreadInfo R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.w2 : (ThreadInfo) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            BaijiahaoData baijiahaoData = this.r2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public SpannableString R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if (ListUtils.isEmpty(this.w)) {
                return null;
            }
            return new SpannableString(c.a.t0.f1.n.e.C(this, this.w, this.t));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void R3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            this.p1.hasAgree = i2 == 1;
        }
    }

    public final c.a.d.o.b R4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(c.a.u0.a4.h.thread_category, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(c.a.u0.a4.d.CAM_X0106_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                return new c.a.d.o.b(bitmapDrawable, 1);
            }
            return null;
        }
        return (c.a.d.o.b) invokeL.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.r0 : (String) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (u2()) {
                return 4;
            }
            if (l2() || k2()) {
                return 3;
            }
            if (Q1()) {
                return 5;
            }
            if (T1()) {
                return 6;
            }
            if (R1()) {
                return 7;
            }
            if (S1()) {
                return 8;
            }
            if (!this.A1 || this.z1 == null) {
                return v2() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            BaijiahaoData baijiahaoData = this.r2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    public final void S2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, str) == null) {
            Matcher matcher = Pattern.compile("#([ ]*[^#(\\n ]+[ ]*)++#(?!\\\\(\\\\w+\\\\))").matcher(str);
            String[] split = str.split("#([ ]*[^#(\\n ]+[ ]*)++#(?!\\\\(\\\\w+\\\\))");
            PbContent.Builder builder = new PbContent.Builder();
            PbContent.Builder builder2 = new PbContent.Builder();
            int i2 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                if ((!matcher.find() || i4 > matcher.groupCount()) && i4 > split.length) {
                    return;
                }
                if (i4 < split.length && !TextUtils.isEmpty(split[i4])) {
                    builder2.text = split[i4];
                    this.u.add(builder2.build(true));
                    i2 += split[i4].length();
                }
                if (matcher.find(i2)) {
                    builder.type = 1282;
                    builder.text = matcher.group(0);
                    builder.link = " =" + matcher.group(0);
                    this.u.add(builder.build(true));
                    i2 += matcher.group(0).length();
                }
            }
        }
    }

    public void S3(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, videoInfo) == null) {
            this.G1 = videoInfo;
        }
    }

    public void S4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i2) == null) {
            this.r = i2;
        }
    }

    public SparseArray<String> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.l1 : (SparseArray) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.Z0 : (String) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            BaijiahaoData baijiahaoData = this.r2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public void T2(WriteData writeData) {
        String n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, writeData) == null) || writeData == null) {
            return;
        }
        try {
            this.B = "0";
            this.E = "";
            this.F = c.a.d.f.m.b.g(writeData.getForumId(), 0L);
            this.s = writeData.getTitle();
            this.B0 = System.currentTimeMillis() / 1000;
            String str = (System.currentTimeMillis() / 1000) + "";
            this.M = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.T = metaData;
            metaData.parseFromCurrentUser();
            this.S = TbadkCoreApplication.getCurrentAccount();
            this.U = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (c.a.d.f.p.m.isEmpty(c.a.u0.z3.t0.b.k().n())) {
                n = writeData.getVideoInfo().getThumbPath();
            } else {
                n = c.a.u0.z3.t0.b.k().n();
            }
            builder.thumbnail_url = n;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.v0 = builder.build(true);
            this.d0 = 40;
            System.currentTimeMillis();
            this.r = writeData.isNoTitle() ? 1 : 0;
            this.t = writeData.getContent();
            a2 a2Var = new a2();
            this.G = a2Var;
            a2Var.a = writeData.getForumId();
            this.G.f13743b = writeData.getForumName();
            this.u2 = writeData.getTabId();
            this.v2 = writeData.getTabName();
            S2(writeData.getTitle());
            j3();
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
            this.A2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.B2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void T3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.B = str;
        }
    }

    public void T4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && this.E0 == 0) {
            this.E0 = 1;
        }
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.F : invokeV.longValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.R1 : (String) invokeV.objValue;
    }

    @Deprecated
    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? H2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (this.A == null) {
                this.A = new ArrayList();
            }
            return c.a.t0.f1.n.e.D(this, this.v, this.t, this.A);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void U3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i2) == null) {
            this.h1 = i2 + 1;
        }
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.S1 : (String) invokeV.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? R1() || S1() : invokeV.booleanValue;
    }

    public SpannableStringBuilder V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? c.a.t0.f1.n.e.C(this, this.u, this.s) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void V3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i2) == null) {
        }
    }

    public List<PbContent> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.w : (List) invokeV.objValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.K : invokeV.intValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.h3 : invokeV.booleanValue;
    }

    public void W2(ArrayList<v> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048709, this, arrayList) == null) || this.r == 1 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<v> it = arrayList.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next != null && next.a() != null && !StringUtils.isNull(this.s)) {
                Iterator<String> it2 = next.a().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!StringUtils.isNull(next2) && this.s.contains(next2)) {
                            next.b();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void W3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
            this.g1 = z;
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.F0 : (String) invokeV.objValue;
    }

    public int X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.o : invokeV.intValue;
    }

    public final boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public SpannableStringBuilder X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            if (StringUtils.isNull(this.s) || this.r == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(V2());
            this.x = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void X3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.C = i2;
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.g0 : (String) invokeV.objValue;
    }

    public List<PbContent> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? N2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder Y2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048719, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? Z2(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void Y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i2) == null) {
            this.a0 = i2;
        }
    }

    public a2 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.G : (a2) invokeV.objValue;
    }

    public List<PbContent> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            MetaData metaData = this.T;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder Z2(boolean z, boolean z2, boolean z4) {
        InterceptResult invokeCommon;
        SpannableStringBuilder V2;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048724, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)})) == null) {
            if (this.r == 1) {
                V2 = U2();
                spannableStringBuilder = V2.toString();
            } else {
                V2 = V2();
                spannableStringBuilder = V2.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = V2;
            String str = spannableStringBuilder;
            if (z) {
                spannableStringBuilder2 = g(str, spannableStringBuilder3, z, true, z2, z4);
            } else {
                spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
            }
            this.x = spannableStringBuilder2;
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void Z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i2) == null) {
            this.D = i2;
        }
    }

    public ForumRecTip a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.g3 : (ForumRecTip) invokeV.objValue;
    }

    public String a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.S0 : (String) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public SpannableStringBuilder a3(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder U2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048729, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.s) && this.r != 1) {
                U2 = V2();
            } else {
                U2 = U2();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(U2);
            this.x = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void a4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.Y1 = z;
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public String b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.b2 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b3(boolean z, boolean z2) {
        c.a.d.o.b bVar;
        SpannableStringBuilder V2;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048734, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (s1() == 42 && X1()) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_convene));
                }
                if (t0() == 1) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_top));
                } else if (t0() == 2) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_notice));
                }
                if (l0() == 1 || this.R.a() != 0) {
                    if (n1() != null && s1() == 41) {
                        if (o1() == 2) {
                            arrayList.add(Integer.valueOf(c.a.u0.a4.f.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_zhibo));
                    }
                }
                if (z && g2() && (num = b4.get(Integer.valueOf(o1()))) != null) {
                    arrayList.add(num);
                }
                if (s0() == 1 && !E2() && H3 != getType() && Q3 != getType()) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.f0;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_live_on));
                }
                if (f1() == 1) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.frs_post_ding));
                }
                Integer num2 = a4.get(new Point(w(), t()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (J1() != null) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.tag_act));
                }
                if (G() != null) {
                    arrayList.add(Integer.valueOf(c.a.u0.a4.f.icon_tag_giftsend));
                }
                if (!c.a.d.f.p.m.isEmpty(this.J)) {
                    bVar = R4(this.J);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (bVar != null) {
                            spannableString = new SpannableString(sb2 + this.J + " ");
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
                            c.a.t0.s.l0.j jVar = new c.a.t0.s.l0.j(bitmapDrawable);
                            jVar.b(c.a.d.f.p.n.d(TbadkCoreApplication.getInst().getApplicationContext(), this.q));
                            spannableString.setSpan(jVar, i4, i4 + 1, 33);
                            i4 += 2;
                        }
                        if (bVar != null) {
                            spannableString.setSpan(bVar, i4, this.J.length() + i4, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    V2 = V2();
                    if (V2 != null) {
                        spannableStringBuilder.append((CharSequence) V2);
                    }
                    this.x = spannableStringBuilder;
                }
            }
            bVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            V2 = V2();
            if (V2 != null) {
            }
            this.x = spannableStringBuilder2;
        }
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.D1 = 1;
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.n1 : (String) invokeV.objValue;
    }

    public String c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.U1 : (String) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            c.a.u0.z3.k0.o oVar = this.M2;
            if (oVar != null) {
                return oVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void c3(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048739, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.B = jSONObject.optString("id");
            this.F = jSONObject.optLong("fid", 0L);
            this.E = jSONObject.optString("tid");
            this.s = jSONObject.optString("title");
            this.A0 = jSONObject.optInt("is_god");
            this.B0 = jSONObject.optLong("create_time", 0L) * 1000;
            this.C0 = jSONObject.optLong("audit_time", 0L) * 1000;
            this.K = jSONObject.optInt("reply_num", 0);
            jSONObject.optInt("repost_num", 0);
            this.L = jSONObject.optInt("view_num", 0);
            jSONObject.optString("last_time");
            this.M = jSONObject.optLong("last_time_int", 0L);
            this.N = jSONObject.optInt("is_top", 0);
            this.O = jSONObject.optInt("is_membertop", 0);
            this.P = jSONObject.optInt("is_good", 0);
            this.Q = jSONObject.optInt("is_livepost", 0);
            this.R.c(jSONObject.optJSONObject("topic"));
            this.S = jSONObject.optString("author_id");
            this.T.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            this.U = jSONObject.optString("fname");
            jSONObject.optInt("has_commented", 0);
            this.V = jSONObject.optInt("show_commented", 0);
            this.W = jSONObject.optString("click_url");
            jSONObject.optString("from");
            this.a0 = jSONObject.optInt("collect_status");
            this.b0 = jSONObject.optString("collect_mark_pid");
            this.c0 = jSONObject.optInt("is_voice_thread");
            this.d0 = jSONObject.optInt("thread_type");
            jSONObject.optInt("thread_type");
            this.r1 = jSONObject.optLong("share_num");
            this.g0 = jSONObject.optString("first_post_id", "0");
            this.F0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.r = jSONObject.optInt("is_ntitle");
            this.J = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.D0 = jSONObject.optString("tieba_game_information_source", "");
            this.p1.parseJson(jSONObject.optJSONObject("agree"));
            this.p1.threadId = this.E;
            JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
            ArrayList<DislikeInfo> arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    if (optJSONArray.getJSONObject(i2) != null) {
                        DislikeInfo.Builder builder = new DislikeInfo.Builder();
                        builder.dislike_reason = optJSONArray.getJSONObject(i2).optString("dislike_reason");
                        builder.dislike_id = Integer.valueOf(optJSONArray.getJSONObject(i2).optInt("dislike_id"));
                        arrayList.add(builder.build(true));
                    }
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
                this.l1 = sparseArray;
                this.m1 = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.O0.k(optJSONObject2);
            }
            if ((this.T == null || this.T.getUserId() == null) && this.h0 != null) {
                this.T = this.h0.get(this.S);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.q0 = optJSONObject.optString("location");
            }
            jSONObject.optString("label_url");
            this.R2 = jSONObject.optString("mode_url");
            this.S2 = jSONObject.optString("location");
            AlaInfoData alaInfoData = new AlaInfoData();
            this.y0 = alaInfoData;
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
            this.t = sb.toString();
            JSONArray optJSONArray3 = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray3 != null) {
                for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray3.getJSONObject(i5));
                    this.X.add(mediaData);
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
                    this.Y.add(voiceData$VoiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray(com.alipay.sdk.sys.a.x);
            if (optJSONArray5 != null) {
                for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                    b bVar = new b();
                    bVar.h(optJSONArray5.getJSONObject(i7));
                    this.I0.add(bVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                q2 q2Var = new q2();
                this.J0 = q2Var;
                q2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                i iVar = new i();
                this.K0 = iVar;
                iVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                u uVar = new u();
                this.L0 = uVar;
                uVar.c(optJSONObject6);
            }
            this.e0.setUserMap(this.h0);
            this.e0.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.f0.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!c.a.d.f.p.m.isEmpty(this.s)) {
                this.e0.setTitle(this.s);
            } else {
                this.e0.setTitle(this.t);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.O0.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                    c.a.t0.u.c cVar = new c.a.t0.u.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.P0.add(cVar);
                }
            }
            this.W0 = jSONObject.optInt("is_book_chapter", 0);
            this.X0.a(jSONObject.optJSONObject("book_chapter"));
            this.Z0 = jSONObject.optString("recom_source");
            this.d1 = jSONObject.optString("recom_reason");
            jSONObject.optString("recom_tag_icon");
            this.a1 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.c1 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.e1 = jSONObject.optLong("last_read_pid");
            this.f1 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                k2 k2Var = new k2();
                this.x0 = k2Var;
                k2Var.a(optJSONObject8);
            }
            this.o1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.t1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.t1 && optJSONObject9 != null) {
                r0 r0Var = new r0();
                this.s1 = r0Var;
                r0Var.g(optJSONObject9);
            }
            this.u1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                h hVar = new h();
                this.v1 = hVar;
                hVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.w1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.x1 = jSONObject.optInt("middle_page_num", 0);
            this.y1 = jSONObject.optInt("middle_page_pass_flag", 0);
            JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
            if (optJSONObject12 != null) {
                VideoInfo.Builder builder2 = new VideoInfo.Builder();
                builder2.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                builder2.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                builder2.video_md5 = optJSONObject12.optString(VideoFinishResult.KEY_VIDEO_MD5);
                builder2.video_url = optJSONObject12.optString("video_url");
                builder2.video_duration = new Integer(optJSONObject12.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                builder2.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                builder2.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                builder2.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                builder2.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                builder2.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                builder2.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                builder2.is_vertical = new Integer(optJSONObject12.optInt(TiebaStatic.Params.IS_VERTICAL, 0));
                builder2.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                this.v0 = builder2.build(true);
            }
            boolean z = jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD, 0) == 1;
            this.A1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.z1 = originalThreadInfo;
                    originalThreadInfo.p(optJSONObject13);
                } else {
                    this.z1 = null;
                }
            } else {
                this.z1 = null;
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
            if (optJSONObject14 != null) {
                SmartApp.Builder builder3 = new SmartApp.Builder();
                builder3.avatar = optJSONObject14.optString("avatar");
                builder3.name = optJSONObject14.optString("name");
                builder3._abstract = optJSONObject14.optString("abstract");
                builder3.pic = optJSONObject14.optString("pic");
                builder3.h5_url = optJSONObject14.optString("h5_url");
                builder3.id = optJSONObject14.optString("id");
                builder3.link = optJSONObject14.optString("link");
                this.M1 = builder3.build(false);
            }
            this.U1 = jSONObject.optString("t_share_img");
            this.V1 = jSONObject.optString("nid");
            this.W1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.q2 = jSONObject.optInt("bjh_content_tag");
            this.p2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.r2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.p1.baijiahaoData = this.r2;
            }
            this.s2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.t2 = jSONObject.optString("scard_packet_id");
            this.u2 = jSONObject.optInt("tab_id");
            this.v2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.n2 = jSONObject.optInt("if_comment", 0) == 1;
            this.o2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.E2 == null) {
                    this.E2 = new PollData();
                }
                this.E2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.z2) {
                        this.z2 = true;
                    }
                    this.x2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.y2.add(pbGoodsData);
                }
                if (this.y2.size() > 0 && !this.z2) {
                    this.z2 = true;
                }
            }
            this.F2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.O2 == null) {
                    this.O2 = new WorksInfoData();
                }
                this.O2.parseJson(optJSONObject17);
            }
            this.P2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.Q2.add(threadRecommendInfoData);
                }
            }
            a2 a2Var = new a2();
            this.G = a2Var;
            a2Var.e(jSONObject.optJSONObject("forum_info"));
            this.N2 = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.M0 = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.v = c1.a(optJSONArray10);
            }
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.u = c1.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.w = c1.a(optJSONArray12);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("star_rank_icon");
            if (optJSONObject18 != null) {
                this.B1 = optJSONObject18.optString("icon_pic_url");
                this.C1 = optJSONObject18.optString("icon_link");
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("location");
            if (optJSONObject19 != null) {
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LAT))) {
                    this.i0 = optJSONObject19.optString(SuggestAddrField.KEY_LAT);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LNG))) {
                    this.k0 = optJSONObject19.optString(SuggestAddrField.KEY_LNG);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("name"))) {
                    this.q0 = optJSONObject19.optString("name");
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("distance"))) {
                    this.r0 = optJSONObject19.optString("distance");
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ori_forum_info");
            if (optJSONObject20 != null) {
                OriginalForumInfo originalForumInfo = new OriginalForumInfo();
                originalForumInfo.id = optJSONObject20.optLong("ori_fid") + "";
                originalForumInfo.ori_fname = optJSONObject20.optString("ori_fname");
                originalForumInfo.ori_avatar = optJSONObject20.optString("ori_avatar");
                originalForumInfo.ori_member_num = optJSONObject20.optLong("ori_member_num");
                this.J1 = originalForumInfo;
            }
            JSONArray optJSONArray13 = jSONObject.optJSONArray("item_star");
            if (optJSONArray13 != null) {
                for (int i12 = 0; i12 < optJSONArray13.length(); i12++) {
                    JSONObject optJSONObject21 = optJSONArray13.optJSONObject(i12);
                    if (optJSONObject21 != null) {
                        HeadItem.Builder builder4 = new HeadItem.Builder();
                        builder4.content = optJSONObject21.optString("content");
                        builder4.name = optJSONObject21.optString("name");
                        builder4.type = Integer.valueOf(optJSONObject21.optInt("type"));
                        if (this.C2 == null) {
                            this.C2 = new ArrayList();
                        }
                        this.C2.add(builder4.build(true));
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("item");
            if (optJSONObject22 != null && 0 != optJSONObject22.optLong("item_id")) {
                Item.Builder builder5 = new Item.Builder();
                builder5.item_id = Long.valueOf(optJSONObject22.optLong("item_id"));
                builder5.item_name = optJSONObject22.optString("item_name");
                builder5.icon_size = Double.valueOf(optJSONObject22.optDouble("icon_size"));
                builder5.score = Double.valueOf(optJSONObject22.optDouble("score"));
                builder5.icon_url = optJSONObject22.optString("icon_url");
                builder5.star = Integer.valueOf(optJSONObject22.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
                builder5.forum_name = optJSONObject22.optString("forum_name");
                builder5.apk_name = optJSONObject22.optString("apk_name");
                builder5.button_link = optJSONObject22.optString("button_link");
                builder5.button_link_type = Integer.valueOf(optJSONObject22.optInt("button_link_type"));
                builder5.button_name = optJSONObject22.optString("button_name");
                JSONObject optJSONObject23 = optJSONObject22.optJSONObject("apk_detail");
                if (optJSONObject23 != null) {
                    ApkDetail.Builder builder6 = new ApkDetail.Builder();
                    builder6.authority_url = optJSONObject23.optString("authority_url");
                    builder6.developer = optJSONObject23.optString("developer");
                    builder6.publisher = optJSONObject23.optString("publisher");
                    builder6.privacy_url = optJSONObject23.optString("privacy_url");
                    builder6.size = optJSONObject23.optString("size");
                    builder6.update_time = optJSONObject23.optString("update_time");
                    builder6.version = optJSONObject23.optString("version");
                    builder6.version_code = Integer.valueOf(optJSONObject23.optInt("version_code"));
                    builder6.need_inner_buy = Integer.valueOf(optJSONObject23.optInt("need_inner_buy"));
                    builder6.need_network = Integer.valueOf(optJSONObject23.optInt("need_network"));
                    builder6.pkg_source = Integer.valueOf(optJSONObject23.optInt("pkg_source"));
                    builder5.apk_detail = builder6.build(true);
                }
                JSONArray optJSONArray14 = optJSONObject22.optJSONArray("tags");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray14 != null) {
                    for (int i13 = 0; i13 < optJSONArray14.length(); i13++) {
                        arrayList2.add(optJSONArray14.optString(i13));
                    }
                    builder5.tags = arrayList2;
                }
                Item build = builder5.build(true);
                if (build != null) {
                    this.A2 = build;
                    ItemData itemData = new ItemData();
                    this.B2 = itemData;
                    itemData.parseProto(build);
                }
            }
            this.U2 = StringHelper.equals(jSONObject.optString("is_tiebaplus_ad"), "1");
            this.V2 = jSONObject.optString("tiebaplus_order_id");
            this.W2 = jSONObject.optString("tiebaplus_token");
            this.X2 = jSONObject.optString("tiebaplus_extra_param");
            this.Y2 = jSONObject.optInt("tiebaplus_cant_delete") == 1;
            this.f3 = jSONObject.optInt("tab_show_mode");
            JSONObject optJSONObject24 = jSONObject.optJSONObject("tiebaplus_ad");
            if (optJSONObject24 != null) {
                optJSONObject24.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
                this.Z2 = optJSONObject24.optString("show_url");
                this.a3 = optJSONObject24.optString("cost_url");
            }
            JSONObject optJSONObject25 = jSONObject.optJSONObject("recommend_tip");
            if (optJSONObject25 != null) {
                ForumRecTip forumRecTip = new ForumRecTip();
                this.g3 = forumRecTip;
                forumRecTip.parseJson(optJSONObject25);
            }
            j3();
            JSONObject optJSONObject26 = jSONObject.optJSONObject("voice_room");
            if (optJSONObject26 != null) {
                VoiceRoom.Builder builder7 = new VoiceRoom.Builder();
                builder7.room_id = Long.valueOf(optJSONObject26.optLong("room_id"));
                builder7.room_name = optJSONObject26.getString(DpStatConstants.KEY_ROOM_NAME);
                this.e3 = builder7.build(true);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void c4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i2) == null) {
            this.P = i2;
        }
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.D0 : (String) invokeV.objValue;
    }

    public String d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.Q1 : (String) invokeV.objValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            MetaData metaData = this.T;
            return (metaData == null || metaData.getGodUserData() == null || this.T.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void d3(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048744, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.i0 = threadInfo.location.lat;
                this.k0 = threadInfo.location.lng;
                this.q0 = threadInfo.location.name;
                this.r0 = threadInfo.location.distance;
            }
            this.Z = threadInfo.is_tbread_dispatch.intValue();
            this.B = threadInfo.id + "";
            this.E = threadInfo.tid + "";
            this.F = threadInfo.fid.longValue();
            this.s = threadInfo.title;
            this.A0 = threadInfo.is_god.intValue();
            this.B0 = threadInfo.create_time.intValue() * 1000;
            this.C0 = threadInfo.audit_time.longValue() * 1000;
            this.K = threadInfo.reply_num.intValue();
            threadInfo.repost_num.intValue();
            this.L = threadInfo.view_num.intValue();
            String str = threadInfo.last_time;
            this.M = threadInfo.last_time_int.intValue();
            this.N = threadInfo.is_top.intValue();
            this.O = threadInfo.is_membertop.intValue();
            this.P = threadInfo.is_good.intValue();
            this.Q = threadInfo.is_livepost.intValue();
            this.R.d(threadInfo.topic);
            this.T.parserProtobuf(threadInfo.author);
            this.S = threadInfo.author_id.toString();
            this.U = threadInfo.fname;
            threadInfo.has_commented.intValue();
            this.V = threadInfo.show_commented.intValue();
            this.W = threadInfo.click_url;
            this.v0 = threadInfo.video_info;
            this.w0 = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.y0 = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            String str2 = threadInfo.from;
            this.a0 = threadInfo.collect_status.intValue();
            this.b0 = threadInfo.collect_mark_pid;
            this.c0 = threadInfo.is_voice_thread.intValue();
            this.d0 = threadInfo.thread_type.intValue();
            threadInfo.thread_type.intValue();
            this.g0 = threadInfo.first_post_id + "";
            this.F0 = threadInfo.post_id + "";
            threadInfo.time.intValue();
            this.r = threadInfo.is_ntitle.intValue();
            this.s0 = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.p1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.p1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.D0 = threadInfo.tieba_game_information_source;
            } else {
                this.D0 = "";
            }
            this.r1 = threadInfo.share_num.longValue();
            this.J = threadInfo.category_name;
            this.t0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.Y0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.u = threadInfo.rich_title;
            this.w = threadInfo.first_post_content;
            this.v = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.T == null || this.T.getUserId() == null || this.T.getUserId().equals("0") || this.K2) && this.S != null && !this.S.equals("0") && this.h0 != null && (metaData = this.h0.get(this.S)) != null) {
                this.T = metaData;
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
            this.t = sb.toString();
            List<Media> list2 = threadInfo.media;
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(list2.get(i4));
                    this.X.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.v0 = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                k2 k2Var = new k2();
                this.x0 = k2Var;
                k2Var.b(threadInfo.video_channel_info);
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
                    this.Y.add(voiceData$VoiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    b bVar = new b();
                    bVar.i(list4.get(i6));
                    this.I0.add(bVar);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                q2 q2Var = new q2();
                this.J0 = q2Var;
                q2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                i iVar = new i();
                this.K0 = iVar;
                iVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                u uVar = new u();
                this.L0 = uVar;
                uVar.d(threadInfo.cartoon_info);
            }
            this.e0.setUserMap(this.h0);
            this.e0.parserProtobuf(threadInfo.zan);
            this.f0.parserProtobuf(threadInfo.anchor_info);
            if (!c.a.d.f.p.m.isEmpty(this.s)) {
                this.e0.setTitle(this.s);
            } else {
                this.e0.setTitle(this.t);
            }
            this.M0 = threadInfo.livecover_src;
            threadInfo.storecount.intValue();
            this.G0 = threadInfo.post_num.intValue();
            threadInfo.post_num.intValue();
            threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        if (zhiBoInfoTW.labelInfo.get(i7) != null) {
                            c.a.t0.t.i.c cVar = new c.a.t0.t.i.c();
                            cVar.a(zhiBoInfoTW.labelInfo.get(i7).labelHot.intValue());
                            cVar.b(zhiBoInfoTW.labelInfo.get(i7).labelId);
                            cVar.c(zhiBoInfoTW.labelInfo.get(i7).labelContent);
                            this.u0.add(cVar);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    String str3 = noticeInfo.notice;
                }
                this.N0 = zhiBoInfoTW.copythread_remind.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                if (StringUtils.isNull(this.M0)) {
                    this.M0 = zhiBoInfoTW.livecover_src;
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
                    this.z0 = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            threadInfo.is_copythread.intValue();
            if (threadInfo.task_info != null) {
                this.O0.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i8 = 0; i8 != threadInfo.ext_tails.size(); i8++) {
                    c.a.t0.u.c cVar2 = new c.a.t0.u.c();
                    cVar2.b(threadInfo.ext_tails.get(i8));
                    this.P0.add(cVar2);
                }
            }
            this.Q0.parserProtobuf(threadInfo.push_status);
            this.V0 = threadInfo.lego_card;
            this.T0 = threadInfo.skin_info;
            this.W0 = threadInfo.is_book_chapter.intValue();
            this.X0.b(threadInfo.book_chapter);
            this.Z0 = threadInfo.recom_source;
            this.d1 = threadInfo.recom_reason;
            String str4 = threadInfo.recom_tag_icon;
            this.a1 = threadInfo.recom_weight;
            this.b1 = threadInfo.ab_tag;
            this.c1 = threadInfo.recom_extra;
            this.e1 = threadInfo.last_read_pid.longValue();
            this.f1 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.q1.h0(threadInfo.top_agree_post);
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
                this.l1 = sparseArray;
                this.m1 = sparseArray2;
            }
            this.o1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.t1 = z;
            if (z && threadInfo.link_info != null) {
                r0 r0Var = new r0();
                this.s1 = r0Var;
                r0Var.h(threadInfo.link_info);
            }
            this.u1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                h hVar = new h();
                this.v1 = hVar;
                hVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.w1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.x1 = threadInfo.middle_page_num.intValue();
            this.y1 = threadInfo.middle_page_pass_flag.intValue();
            this.A1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.B1 = threadInfo.star_rank_icon.icon_pic_url;
                this.C1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.z1 = originalThreadInfo;
                originalThreadInfo.n(threadInfo.origin_thread_info, this);
            } else {
                this.z1 = null;
                this.A1 = false;
            }
            this.D1 = threadInfo.is_topic.intValue();
            this.F1 = threadInfo.topic_user_name;
            String str5 = threadInfo.topic_h5_url;
            this.E1 = threadInfo.topic_module;
            String str6 = threadInfo.presentation_style;
            this.J1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str7 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                a2 a2Var = new a2();
                this.G = a2Var;
                a2Var.f(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.M1 = threadInfo.swan_info;
            }
            this.U1 = threadInfo.t_share_img;
            this.V1 = threadInfo.nid;
            this.W1 = threadInfo.is_headlinepost.intValue() == 1;
            String str8 = threadInfo.thread_share_link;
            this.p2 = threadInfo.article_cover;
            this.q2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.r2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.p1.baijiahaoData = this.r2;
            }
            this.s2 = threadInfo.is_s_card.intValue() == 1;
            this.t2 = threadInfo.scard_packet_id;
            this.u2 = threadInfo.tab_id.intValue();
            this.v2 = threadInfo.tab_name;
            String str9 = threadInfo.wonderful_post_info;
            this.n2 = threadInfo.if_comment.intValue() == 1;
            this.o2 = threadInfo.if_comment_info;
            this.w2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.z2) {
                        this.z2 = true;
                    }
                    this.x2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.y2.add(pbGoodsData);
                }
                if (this.y2.size() > 0 && !this.z2) {
                    this.z2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.A2 = threadInfo.item;
            }
            if (this.A2 != null) {
                ItemData itemData = new ItemData();
                this.B2 = itemData;
                itemData.parseProto(this.A2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.C2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.D2 = itemStarData;
                itemStarData.parseProto(this.C2);
            }
            if (threadInfo.poll_info != null) {
                if (this.E2 == null) {
                    this.E2 = new PollData();
                }
                this.E2.parserProtobuf(threadInfo.poll_info);
            }
            this.F2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.N2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.O2 == null) {
                    this.O2 = new WorksInfoData();
                }
                this.O2.parseProto(threadInfo.works_info);
            }
            this.P2 = threadInfo.collect_num.intValue();
            if (!ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseProto(threadRecommendInfo);
                    this.Q2.add(threadRecommendInfoData);
                }
            }
            this.h3 = threadInfo.is_frs_mask.intValue() == 1;
            this.U2 = StringHelper.equals(threadInfo.is_tiebaplus_ad, "1");
            this.V2 = threadInfo.tiebaplus_order_id;
            this.W2 = threadInfo.tiebaplus_token;
            this.X2 = threadInfo.tiebaplus_extra_param;
            this.Y2 = threadInfo.tiebaplus_cant_delete.intValue() == 1;
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                String str10 = tiebaPlusAd.ad_source;
                this.Z2 = tiebaPlusAd.show_url;
                this.a3 = tiebaPlusAd.cost_url;
            }
            this.e3 = threadInfo.voice_room;
            this.f3 = threadInfo.tab_show_mode.intValue();
            if (threadInfo.recommend_tip != null) {
                ForumRecTip forumRecTip = new ForumRecTip();
                this.g3 = forumRecTip;
                forumRecTip.parseProto(threadInfo.recommend_tip);
            }
            j3();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048745, this, i2) == null) {
            this.N = i2;
        }
    }

    public List<PbGoodsData> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.y2 : (List) invokeV.objValue;
    }

    public long e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.r1 : invokeV.longValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.z2 : invokeV.booleanValue;
    }

    public void e3(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048749, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            f3(z, z2, true);
        }
    }

    public void e4(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, item) == null) {
            this.A2 = item;
        }
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.p1.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.V : invokeV.intValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? this.g1 : invokeV.booleanValue;
    }

    public void f3(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048754, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)}) == null) {
            if (ListUtils.getCount(P0(z, z2, z4, false)) > 0) {
                Y2(z, z4);
                return;
            }
            SpannableStringBuilder V2 = V2();
            if (z) {
                spannableStringBuilder = g(V2.toString(), V2, z, z2, z4, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(V2);
            }
            this.x = spannableStringBuilder;
        }
    }

    public void f4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, itemData) == null) {
            this.B2 = itemData;
        }
    }

    public final SpannableStringBuilder g(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048756, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> P0 = P0(z, z2, z4, z5);
            if (P0 == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h2 = c.a.u0.g0.m.h(TbadkCoreApplication.getInst(), str, P0, false);
            if (P0.size() > 0) {
                if (h2 == null) {
                    h2 = new SpannableStringBuilder();
                }
                if (this.r == 1) {
                    this.x = h2;
                    return h2;
                }
            } else if (this.r == 1) {
                this.x = new SpannableStringBuilder();
                return h2;
            }
            if (spannableStringBuilder != null) {
                h2.append((CharSequence) spannableStringBuilder);
            } else if (P0.size() > 0 || h2.length() == 0) {
                h2.append((CharSequence) str);
            }
            return h2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public VideoInfo g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? this.G1 : (VideoInfo) invokeV.objValue;
    }

    public SkinInfo g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this.T0 : (SkinInfo) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.d0 == 41 : invokeV.booleanValue;
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            b3(false, true);
        }
    }

    public void g4(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, list) == null) {
            this.C2 = list;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            ArrayList<MediaData> G0 = G0();
            if (G0 == null || E2()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < G0.size() && i2 < 3; i2++) {
                if (G0.get(i2) != null && G0.get(i2).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(G0.get(i2).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = G0.get(i2).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = G0.get(i2).getPicUrl();
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
            VideoInfo videoInfo = this.v0;
            if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.imgUrl = this.v0.thumbnail_url;
                preLoadImageInfo2.procType = 10;
                preLoadImageInfo2.preloadType = 1;
                arrayList.add(preLoadImageInfo2);
            }
            if (this.T != null) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.T.getPortrait();
                preLoadImageInfo3.procType = 28;
                preLoadImageInfo3.preloadType = 3;
                arrayList.add(preLoadImageInfo3);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.t0.s.r.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            SparseArray<String> sparseArray = this.l1;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.o(getThreadData().w1());
            x0Var.k(getThreadData().U());
            x0Var.n(getThreadData().H0());
            x0Var.j(this.l1);
            x0Var.f13996g = this.m1;
            x0Var.p = this.b1;
            x0Var.k = this.a1;
            x0Var.m = this.c1;
            x0Var.l = this.Z0;
            x0Var.q = this.T1;
            x0Var.o = S0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.t0.s.r.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.d1 : (String) invokeV.objValue;
    }

    @Override // c.a.t0.s.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? this : (e2) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            c.a.u0.z3.k0.o oVar = this.M2;
            if (oVar != null) {
                return oVar.f() ? this.M2.g() ? AdvertAppInfo.L4 : AdvertAppInfo.M4 : this.M2.g() ? AdvertAppInfo.L4 : AdvertAppInfo.K4;
            } else if (k0()) {
                if (u1() != null) {
                    return H3;
                }
                return j3;
            } else {
                int t0 = t0();
                if (this.D1 == 1) {
                    if (this.E1 != null) {
                        return y3;
                    }
                    return this.G1 != null ? S3 : R3;
                } else if (this.y0 != null && this.d0 == 60) {
                    return K3;
                } else {
                    if (this.y0 != null && ((i2 = this.d0) == 49 || i2 == 69)) {
                        return I3;
                    }
                    if (this.y0 != null && this.d0 == 67) {
                        return L3;
                    }
                    int i4 = this.d0;
                    if (i4 == 51) {
                        return J3;
                    }
                    if (i4 == 63) {
                        return T3;
                    }
                    if (i4 == 64) {
                        return U3;
                    }
                    if (t0 != 2 && t0 != 1) {
                        if (this.v0 != null && f2() && !j2()) {
                            return Y3;
                        }
                        if (this.v0 != null && !j2()) {
                            if (d2()) {
                                return Q3;
                            }
                            if (this instanceof y0) {
                                return Z3;
                            }
                            return H3;
                        } else if (this.A1 && (originalThreadInfo = this.z1) != null) {
                            if (originalThreadInfo.x) {
                                if (originalThreadInfo.r != null) {
                                    return P3;
                                }
                                if (originalThreadInfo.g()) {
                                    return O3;
                                }
                                return N3;
                            }
                            return M3;
                        } else if (Q1()) {
                            return z3;
                        } else {
                            if (h2()) {
                                return W3.get() ? c4 : j3;
                            } else if (M1() && w() == 1) {
                                return W3.get() ? d4 : j3;
                            } else if (i2()) {
                                return F3;
                            } else {
                                if (d2()) {
                                    return G3;
                                }
                                if (this.f13835e) {
                                    return p3;
                                }
                                if (this.f13836f) {
                                    return q3;
                                }
                                if (this.f13837g) {
                                    return r3;
                                }
                                if (this.f13838h) {
                                    return s3;
                                }
                                if (this.f13839i) {
                                    return t3;
                                }
                                if (this.k) {
                                    return w3;
                                }
                                if (this.l) {
                                    return x3;
                                }
                                if (this.f13840j) {
                                    return u3;
                                }
                                if (this.m) {
                                    return B3;
                                }
                                if (this.H0) {
                                    int i32 = i3();
                                    if (i32 == 1) {
                                        return l3;
                                    }
                                    if (i32 == 2) {
                                        return m3;
                                    }
                                    if (i32 > 2) {
                                        return n3;
                                    }
                                    return j3;
                                }
                                return j3;
                            }
                        }
                    }
                    return i3;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            VideoInfo videoInfo = this.v0;
            if (videoInfo != null) {
                return videoInfo.video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public SmartApp h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.M1 : (SmartApp) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? n1() != null && s1() == 41 && l0() == 1 && o1() == 2 : invokeV.booleanValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            b3(false, false);
        }
    }

    public void h4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048773, this, j2) == null) {
            this.M = j2;
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int[] i0() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            int[] iArr = new int[2];
            int size = View.MeasureSpec.getSize(c.a.d.f.p.n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.a4.e.tbds10);
            int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> G0 = G0();
            if (c.a.t0.s.l.c().g() && ListUtils.getCount(G0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i13 = 0; i13 < G0.size(); i13++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(G0, i13);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(G0, 0);
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
            c.a.t0.b.g.b.k(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.k1 : invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) ? this.t1 : invokeV.booleanValue;
    }

    public int i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            if (!c.a.t0.s.l.c().g() || ListUtils.getCount(G0()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < G0().size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(G0(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void i4(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, list) == null) {
            this.x2 = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.x2) {
                if (pbLinkData.urlType == 2 && !this.z2) {
                    this.z2 = true;
                }
            }
        }
    }

    @Override // c.a.t0.s.r.a
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.Z1 : invokeV.booleanValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this.h1 : invokeV.intValue;
    }

    public SpannableStringBuilder j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) ? this.x : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) ? this.d0 == 41 : invokeV.booleanValue;
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048784, this) == null) {
            t3();
            m3();
            r3();
            s3();
            k3();
            p3();
            q3();
        }
    }

    public void j4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048785, this, z) == null) {
            d4(z ? 1 : 0);
        }
    }

    public SpannableString k(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048786, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c.a.u0.a4.e.ds8);
            Bitmap bitmap = SkinManager.getBitmap(c.a.u0.a4.f.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            c.a.t0.s.l0.k kVar = new c.a.t0.s.l0.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String q = c.a.t0.s.j0.b.k().q("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.nani_tail_default_postfix));
            if (StringUtils.isNull(q)) {
                q = TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.nani_tail_default_postfix);
            }
            StringBuilder sb = new StringBuilder(q);
            if (J() != null) {
                if (J().getGender() == 1) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.he));
                } else if (J().getGender() == 2) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.she));
                } else {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.ta));
                }
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(c.a.u0.a4.j.ta));
            }
            sb.insert(0, "[icon]");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(kVar, 0, 6, 17);
            spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) ? this.L1 : invokeV.booleanValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? this.u2 : invokeV.intValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) ? s1() == 50 : invokeV.booleanValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            this.z = Q2();
        }
    }

    public void k4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, str) == null) {
            this.b0 = str;
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.Q : invokeV.intValue;
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? this.v2 : (String) invokeV.objValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) ? s1() == 49 || s1() == 69 : invokeV.booleanValue;
    }

    public final void l3() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048795, this) == null) || (alaInfoData = this.y0) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j2 = this.B0;
            if (j2 > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j2);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.P1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.y0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.P1) || i2 <= 0) {
                if (i2 > 0) {
                    this.P1 = TbadkCoreApplication.getInst().getResources().getString(c.a.u0.a4.j.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.P1 += "   " + TbadkCoreApplication.getInst().getResources().getString(c.a.u0.a4.j.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void l4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048796, this, z) == null) {
            this.H1 = z;
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.C : invokeV.intValue;
    }

    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) ? this.f3 : invokeV.intValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) ? t0() == 1 : invokeV.booleanValue;
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048800, this) == null) {
            if ((this instanceof y0) && "0".equals(h0())) {
                this.P1 = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.video_is_checking_novisible);
                return;
            }
            int i2 = 36;
            if (!H2() && ((!b2() || getType() == I3) && !this.d2 && !this.i2)) {
                if (getType() != I3 && getType() != L3) {
                    if (K2() && !TextUtils.isEmpty(this.U)) {
                        this.P1 = StringHelper.cutChineseAndEnglishWithSuffix(this.U, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(c.a.u0.a4.j.forum);
                        return;
                    }
                    long x0 = x0() * 1000;
                    if (x0 != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(x0);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(x0);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(c.a.u0.a4.j.repley_when);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(x0);
                        }
                        this.P1 = string + formatTimeForJustNow;
                    } else {
                        long j2 = this.B0;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j2);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j2);
                        }
                        this.P1 = formatTimeForJustNow2;
                    }
                    if (this.Z1) {
                        i2 = 24;
                    } else if (!this.b2) {
                        i2 = 16;
                    }
                    String authInfo = UtilHelper.getAuthInfo(this.T, this.a2, i2);
                    if (y2()) {
                        String str = StringHelper.cutChineseAndEnglishWithSuffix(this.U, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(c.a.u0.a4.j.forum);
                        if (!TextUtils.isEmpty(authInfo)) {
                            this.P1 = authInfo + GlideException.IndentedAppendable.INDENT + str;
                        } else {
                            this.P1 = str;
                        }
                    } else if (!TextUtils.isEmpty(this.P1) && !TextUtils.isEmpty(authInfo)) {
                        this.P1 += GlideException.IndentedAppendable.INDENT + authInfo;
                    } else if (!TextUtils.isEmpty(authInfo)) {
                        this.P1 = authInfo;
                    }
                    if (TextUtils.isEmpty(this.P1) || TextUtils.isEmpty(A())) {
                        return;
                    }
                    this.P1 += " • " + A();
                    return;
                }
                l3();
                return;
            }
            long j4 = this.B0;
            if (j4 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j4);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j4);
                }
                this.P1 = formatTimeForJustNow3;
            }
            if (!this.i2 || (TextUtils.isEmpty(this.r0) && TextUtils.isEmpty(this.S2))) {
                if (this.Z1) {
                    i2 = 24;
                } else if (!this.b2) {
                    i2 = 16;
                }
                String authInfo2 = UtilHelper.getAuthInfo(this.T, this.a2, i2);
                if (!TextUtils.isEmpty(this.P1) && !TextUtils.isEmpty(authInfo2)) {
                    this.P1 += "   " + authInfo2;
                } else if (TextUtils.isEmpty(authInfo2)) {
                } else {
                    this.P1 = authInfo2;
                }
            }
        }
    }

    public void m4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.I1 = z;
        }
    }

    public int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public c2 n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? this.O0 : (c2) invokeV.objValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) ? this.H1 : invokeV.booleanValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048805, this) == null) && r2() && !TextUtils.isEmpty(this.T.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.P1)) {
                this.P1 += "   " + this.T.getNewGodData().getFieldName() + c.a.t0.d1.t0.c(this.T.getNewGodData().isVideoGod());
                return;
            }
            this.P1 = this.T.getNewGodData().getFieldName() + c.a.t0.d1.t0.c(this.T.getNewGodData().isVideoGod());
        }
    }

    public void n4(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, arrayList) == null) {
            this.X = arrayList;
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? this.O : invokeV.intValue;
    }

    public int o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) {
            c2 c2Var = this.O0;
            if (c2Var != null) {
                long e2 = c2Var.e();
                long a = this.O0.a();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < e2) {
                    return 1;
                }
                return currentTimeMillis > a ? 3 : 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) ? this.I1 : invokeV.booleanValue;
    }

    public void o3() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048811, this) == null) || H2() || b2()) {
            return;
        }
        long x0 = x0() * 1000;
        if (x0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(x0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(x0);
            }
            this.P1 = formatTimeForJustNow;
        }
        if (r2()) {
            n3();
        } else if (!this.a2 && (metaData = this.T) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.T.getBazhuGradeData().getDesc(), 24, "...");
            if (!TextUtils.isEmpty(this.P1)) {
                this.P1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.P1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.P1) || TextUtils.isEmpty(A())) {
            return;
        }
        this.P1 += " • " + A();
    }

    public void o4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, str) == null) {
            this.p = str;
        }
    }

    public SpannableString p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? this.z : (SpannableString) invokeV.objValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) ? this.r : invokeV.intValue;
    }

    public AlaInfoData p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) ? this.y0 : (AlaInfoData) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) ? this.o1 : invokeV.booleanValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048817, this) == null) {
            this.R1 = StringHelper.getFormatTimeShort(x0() * 1000);
        }
    }

    public void p4(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, pollData) == null) {
            this.E2 = pollData;
        }
    }

    public ArrayList<b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048819, this)) == null) ? this.I0 : (ArrayList) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) ? this.P1 : (String) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048822, this)) == null) ? this.f1 : invokeV.booleanValue;
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048823, this) == null) {
            this.S1 = StringHelper.getFormatTimeShort(x0());
        }
    }

    public void q4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048824, this, i2) == null) {
            this.T2 = i2;
        }
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) ? this.D : invokeV.intValue;
    }

    public List<ThreadRecommendInfoData> r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? this.Q2 : (List) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048827, this)) == null) {
            MetaData metaData = this.T;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048828, this) == null) {
            if (p1() != null && p1().share_info != null && p1().share_info.share_user_count > 0 && x2() && (this.x1 <= 0 || this.y1 != 0)) {
                int i2 = p1().share_info.share_user_count;
                if (i2 == 1) {
                    this.Q1 = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.Q1 = TbadkCoreApplication.getInst().getString(c.a.u0.a4.j.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                    return;
                }
            }
            this.Q1 = null;
        }
    }

    public void r4(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048829, this, praiseData) == null) {
            this.e0 = praiseData;
        }
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? this.P : invokeV.intValue;
    }

    public int s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) ? this.d0 : invokeV.intValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048832, this)) == null) ? this.d0 == 0 : invokeV.booleanValue;
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048833, this) == null) {
            SpannableStringBuilder X2 = X2();
            this.y = X2;
            c.a.u0.g0.m.b(this, X2, true);
        }
    }

    public void s4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048834, this, i2) == null) {
            this.K = i2;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) {
            if (!M1() || this.I0.size() < 1) {
                return -1;
            }
            b bVar = this.I0.get(0);
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

    public int t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) ? this.N : invokeV.intValue;
    }

    public k2 t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) ? this.x0 : (k2) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048838, this)) == null) ? this.d0 == 31 : invokeV.booleanValue;
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048839, this) == null) || StringUtils.isNull(this.T.getName_show())) {
            return;
        }
        this.O1 = StringHelper.cutChineseAndEnglishWithSuffix(this.T.getName_show(), 12, "...");
    }

    public void t4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048840, this, i2) == null) {
            this.o = i2;
        }
    }

    public Item u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) ? this.A2 : (Item) invokeV.objValue;
    }

    public VideoInfo u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) ? this.v0 : (VideoInfo) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048843, this)) == null) ? this.A0 == 1 : invokeV.booleanValue;
    }

    public void u3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, str) == null) {
            this.t = str;
        }
    }

    public void u4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, list) == null) {
            this.v = list;
        }
    }

    public List<HeadItem> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) ? this.C2 : (List) invokeV.objValue;
    }

    public VideoDesc v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) ? this.w0 : (VideoDesc) invokeV.objValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048848, this)) == null) ? s1() == 40 : invokeV.booleanValue;
    }

    public void v3(ArrayList<b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048849, this, arrayList) == null) {
            this.I0 = arrayList;
        }
    }

    public void v4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, list) == null) {
            this.u = list;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048851, this)) == null) {
            if (!M1() || this.I0.size() < 1 || this.I0.get(0) == null) {
                return -1;
            }
            return this.I0.get(0).a();
        }
        return invokeV.intValue;
    }

    public long w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) ? this.e1 : invokeV.longValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) {
            if (!StringUtils.isNull(this.E) && !"0".equals(this.E)) {
                return this.E;
            }
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048854, this)) == null) ? (u0() == null && ((originalThreadInfo = this.z1) == null || originalThreadInfo.C == null)) ? false : true : invokeV.booleanValue;
    }

    public void w3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048855, this, z) == null) {
            c4(z ? 1 : 0);
        }
    }

    public void w4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, str) == null) {
            this.I = str;
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048857, this)) == null) ? (!M1() || this.I0.size() < 1 || this.I0.get(0) == null) ? "" : this.I0.get(0).g() : (String) invokeV.objValue;
    }

    public long x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048858, this)) == null) ? this.M : invokeV.longValue;
    }

    @Nullable
    public List<c.a.t0.f1.p.b> x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048859, this)) == null) ? this.A : (List) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048860, this)) == null) ? s1() == 60 : invokeV.booleanValue;
    }

    public void x3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048861, this, i2) == null) {
            this.p1.agreeNum = i2;
        }
    }

    public void x4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048862, this, j2) == null) {
            this.r1 = j2;
        }
    }

    public ActivityItemData y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048863, this)) == null) {
            List<PbContent> list = this.u;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.u.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && I2() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = c.a.t0.u0.a.d(pbContent.text);
                    String str2 = pbContent.text;
                    activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                    return activityItemData;
                }
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048864, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public SpannableStringBuilder y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) ? this.y : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048866, this)) == null) ? (N2() || I2()) && !StringUtils.isNull(this.U) && this.a2 : invokeV.booleanValue;
    }

    public void y3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048867, this, j2) == null) {
            this.p1.agreeNum = j2;
        }
    }

    public void y4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048868, this, z) == null) {
            this.N1 = z;
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048869, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048870, this)) == null) ? this.R0 : (String) invokeV.objValue;
    }

    public PostData z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048871, this)) == null) ? this.q1 : (PostData) invokeV.objValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048872, this)) == null) ? this.N1 : invokeV.booleanValue;
    }

    public void z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048873, this, i2) == null) {
            this.p1.agreeType = i2;
        }
    }

    public void z4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048874, this, i2) == null) {
            this.k1 = i2;
        }
    }
}
