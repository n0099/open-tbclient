package c.a.s0.s.q;

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
import c.a.t0.g0.m;
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
public class d2 extends a implements PreLoadImageProvider, c.a.d.n.e.n, IVideoData {
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
    public static AtomicBoolean V3;
    public static AtomicBoolean W3;
    public static final BdUniqueId X3;
    public static final BdUniqueId Y3;
    public static HashMap<Point, Integer> Z3;
    public static HashMap<Integer, Integer> a4;
    public static final BdUniqueId b4;
    public static final BdUniqueId c4;
    public static HashMap<Point, Integer> d4;
    public static SparseArray<m.a> e4;
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
    @Nullable
    public List<c.a.s0.g1.p.a> A;
    public int A0;
    public OriginalThreadInfo A1;
    public boolean A2;
    public String B;
    public long B0;
    public boolean B1;
    public Item B2;
    public int C;
    public long C0;
    public String C1;
    public ItemData C2;
    public int D;
    public String D0;
    public String D1;
    public List<HeadItem> D2;
    public String E;
    public int E0;
    public int E1;
    public ItemStarData E2;
    public long F;
    public String F0;
    public TopicModule F1;
    public PollData F2;
    public z1 G;
    public int G0;
    public String G1;
    public int G2;
    public String H;
    public boolean H0;
    public VideoInfo H1;
    public String H2;
    public String I;
    public ArrayList<b> I0;
    public boolean I1;
    public String I2;
    public String J;
    public q2 J0;
    public boolean J1;
    public String J2;
    public int K;
    public i K0;
    public OriginalForumInfo K1;
    public boolean K2;
    public int L;
    public u L0;
    public boolean L1;
    public boolean L2;
    public long M;
    public String M0;
    public boolean M1;
    public int M2;
    public int N;
    public int N0;
    public SmartApp N1;
    public c.a.t0.w3.j0.o N2;
    public int O;
    public b2 O0;
    public boolean O1;
    public int O2;
    public int P;
    public ArrayList<c.a.s0.u.c> P0;
    public String P1;
    public WorksInfoData P2;
    public int Q;
    public PushStatusData Q0;
    public String Q1;
    public int Q2;
    public h2 R;
    public String R0;
    public String R1;
    public List<ThreadRecommendInfoData> R2;
    public String S;
    public String S0;
    public String S1;
    public String S2;
    public MetaData T;
    public SkinInfo T0;
    public String T1;
    public String T2;
    public String U;
    public boolean U0;
    public int U1;
    public int U2;
    public int V;
    public String V0;
    public String V1;
    public boolean V2;
    public String W;
    public int W0;
    public String W1;
    public String W2;
    public ArrayList<MediaData> X;
    public r X0;
    public boolean X1;
    public String X2;
    public ArrayList<VoiceData$VoiceModel> Y;
    public boolean Y0;
    public boolean Y1;
    public String Y2;
    public int Z;
    public String Z0;
    public boolean Z1;
    public boolean Z2;
    public int a0;
    public String a1;
    public boolean a2;
    public String a3;
    public String b0;
    public String b1;
    public boolean b2;
    public String b3;
    public int c0;
    public String c1;
    public boolean c2;
    public UserPostPerm c3;
    public int d0;
    public String d1;
    public boolean d2;
    public long d3;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13657e;
    public PraiseData e0;
    public String e1;
    public boolean e2;
    public VoiceRoom e3;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13658f;
    public AnchorInfoData f0;
    public long f1;
    public boolean f2;
    public int f3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13659g;
    public String g0;
    public boolean g1;
    public boolean g2;
    public boolean g3;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13660h;
    public HashMap<String, MetaData> h0;
    public boolean h1;
    public boolean h2;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13661i;
    public String i0;
    public int i1;
    public boolean i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13662j;
    public boolean j1;
    public boolean j2;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13663k;
    public String k0;
    public boolean k1;
    public String k2;
    public boolean l;
    public int l1;
    public String l2;
    public boolean m;
    public SparseArray<String> m1;
    public boolean m2;
    public boolean n;
    public SparseArray<String> n1;
    public String n2;
    public int o;
    public String o1;
    public boolean o2;
    public String p;
    public boolean p1;
    public String p2;
    public int q;
    public String q0;
    public AgreeData q1;
    public String q2;
    public int r;
    public String r0;
    public PostData r1;
    public int r2;
    public String s;
    public int s0;
    public long s1;
    public BaijiahaoData s2;
    public String t;
    public int t0;
    public r0 t1;
    public boolean t2;
    public List<PbContent> u;
    public ArrayList<c.a.s0.t.i.c> u0;
    public boolean u1;
    public String u2;
    public List<PbContent> v;
    public VideoInfo v0;
    public boolean v1;
    public int v2;
    public List<PbContent> w;
    public VideoDesc w0;
    public h w1;
    public String w2;
    public SpannableStringBuilder x;
    public k2 x0;
    public MediaData x1;
    public ThreadInfo x2;
    public SpannableStringBuilder y;
    public AlaInfoData y0;
    public int y1;
    public List<PbLinkData> y2;
    public SpannableString z;
    public int z0;
    public int z1;
    public List<PbGoodsData> z2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-967005081, "Lc/a/s0/s/q/d2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-967005081, "Lc/a/s0/s/q/d2;");
                return;
            }
        }
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
        V3 = new AtomicBoolean(false);
        W3 = new AtomicBoolean(true);
        new AtomicBoolean(true);
        X3 = BdUniqueId.gen();
        Y3 = BdUniqueId.gen();
        Z3 = new HashMap<>();
        a4 = new HashMap<>();
        b4 = BdUniqueId.gen();
        c4 = BdUniqueId.gen();
        d4 = new HashMap<>();
        e4 = new SparseArray<>(3);
        Z3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        Z3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        Z3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        Z3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        Z3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        Z3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        Z3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        Z3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        d4.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        d4.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        d4.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        d4.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        d4.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        d4.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        d4.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        d4.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        a4.put(1, Integer.valueOf(R.drawable.label_interview_no));
        a4.put(2, Integer.valueOf(R.drawable.label_interview_live));
        a4.put(3, Integer.valueOf(R.drawable.label_interview_off));
        e4.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        e4.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        e4.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public d2() {
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
        this.f13657e = false;
        this.f13658f = false;
        this.f13659g = false;
        this.f13660h = false;
        this.f13661i = false;
        this.f13662j = false;
        this.f13663k = false;
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
        this.g1 = true;
        this.k1 = false;
        this.l1 = -1;
        this.m1 = null;
        this.n1 = null;
        this.v1 = false;
        this.y1 = 0;
        this.E1 = 0;
        this.I1 = false;
        this.O1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.o2 = false;
        this.t2 = false;
        this.K2 = false;
        this.L2 = false;
        this.S2 = "";
        this.T2 = "";
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
        this.O0 = new b2();
        this.P0 = new ArrayList<>();
        this.Q0 = new PushStatusData();
        this.Z = 0;
        this.h1 = false;
        this.i1 = -1;
        this.r1 = new PostData();
        this.q1 = new AgreeData();
        this.y1 = 0;
        this.z1 = 0;
        this.D0 = "";
        this.D1 = "";
        this.C1 = "";
        this.R0 = "";
        this.S0 = "";
        this.y2 = new ArrayList();
        this.z2 = new ArrayList();
        this.R2 = new ArrayList();
        this.G2 = -1;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q0 : (String) invokeV.objValue;
    }

    public String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.P1 : (String) invokeV.objValue;
    }

    public TopicModule A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.F1 : (TopicModule) invokeV.objValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Z1 : invokeV.booleanValue;
    }

    public void A3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.q2 = str;
        }
    }

    public void A4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.R0 = str;
            this.S0 = str2;
        }
    }

    public AgreeData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q1 : (AgreeData) invokeV.objValue;
    }

    public List<PbLinkData> B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.y2 : (List) invokeV.objValue;
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.G1 : (String) invokeV.objValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Z == 1 : invokeV.booleanValue;
    }

    public void B3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, metaData) == null) {
            this.T = metaData;
        }
    }

    public void B4(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, alaInfoData) == null) {
            this.y0 = alaInfoData;
        }
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q1.agreeNum : invokeV.longValue;
    }

    public r0 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t1 : (r0) invokeV.objValue;
    }

    public HashMap<String, MetaData> C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h0 : (HashMap) invokeV.objValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.V2 || this.Z2 : invokeV.booleanValue;
    }

    public void C3(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, baijiahaoData) == null) {
            this.s2 = baijiahaoData;
        }
    }

    public void C4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.Q1 = str;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q1.agreeType : invokeV.intValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (R1() || Q1()) {
                return 2;
            }
            return (P1() || S1()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? s0() != 0 : invokeV.booleanValue;
    }

    public void D3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.N0 = i2;
        }
    }

    public void D4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.d0 = i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.b0 : (String) invokeV.objValue;
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.L : invokeV.intValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E1 == 1 : invokeV.booleanValue;
    }

    public void E3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            this.q1.diffAgreeNum = j2;
        }
    }

    public void E4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.E = str;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.z0 : invokeV.intValue;
    }

    public ArrayList<MediaData> F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.X : (ArrayList) invokeV.objValue;
    }

    public ArrayList<VoiceData$VoiceModel> F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.Y : (ArrayList) invokeV.objValue;
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.K1 != null : invokeV.booleanValue;
    }

    public void F3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j2) == null) {
            this.d3 = j2;
        }
    }

    public void F4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.s = str;
        }
    }

    public i G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.K0 : (i) invokeV.objValue;
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.W1 : (String) invokeV.objValue;
    }

    public VoiceRoom G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.e3 : (VoiceRoom) invokeV.objValue;
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            BaijiahaoData baijiahaoData = this.s2;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public void G3(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            F3(c.a.d.f.m.b.g(str, 0L));
        }
    }

    public void G4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.q2 : (String) invokeV.objValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (R0() == 1) {
                return 2;
            }
            if (R0() == 2) {
                return 3;
            }
            return R0() == 3 ? 1 : 4;
        }
        return invokeV.intValue;
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int i2 = this.d0;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void H3(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, sparseArray) == null) {
            this.m1 = sparseArray;
        }
    }

    public void H4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.G1 = str;
        }
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.C0 : invokeV.longValue;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public q2 I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.J0 : (q2) invokeV.objValue;
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? H2() && M2() : invokeV.booleanValue;
    }

    public void I3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) {
            this.F = j2;
        }
    }

    public void I4(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, hashMap) == null) {
            this.h0 = hashMap;
        }
    }

    public MetaData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.T : (MetaData) invokeV.objValue;
    }

    public PollData J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.F2 : (PollData) invokeV.objValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || ListUtils.getCount(this.D2) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.y;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) c.a.s0.g1.n.e.e(this.D2));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.z);
        spannableStringBuilder2.insert(0, (CharSequence) c.a.s0.g1.n.e.e(this.D2));
        this.z = new SpannableString(spannableStringBuilder2);
    }

    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            VoiceRoom voiceRoom = this.e3;
            return voiceRoom != null && voiceRoom.room_id.longValue() > 0;
        }
        return invokeV.booleanValue;
    }

    public void J3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.H = str;
        }
    }

    public void J4(UserPostPerm userPostPerm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, userPostPerm) == null) {
            this.c3 = userPostPerm;
        }
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.r2 : invokeV.intValue;
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.U2 : invokeV.intValue;
    }

    public void K1(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, spannableString) == null) || J() == null || showNoName() || showWeakenName()) {
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

    public boolean K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.d0 == 11 || this.c0 == 1 : invokeV.booleanValue;
    }

    public void K3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, list) == null) {
            this.w = list;
        }
    }

    public void K4(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, videoInfo) == null) {
            this.v0 = videoInfo;
        }
    }

    public BaijiahaoData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.s2 : (BaijiahaoData) invokeV.objValue;
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.G0 : invokeV.intValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.s0 == 1 : invokeV.booleanValue;
    }

    public boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.d0 == 36 : invokeV.booleanValue;
    }

    public void L3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.U0 = z;
        }
    }

    public void L4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.L = i2;
        }
    }

    public u M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.L0 : (u) invokeV.objValue;
    }

    public PraiseData M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.e0 : (PraiseData) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? r0() == 1 : invokeV.booleanValue;
    }

    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            WorksInfoData worksInfoData = this.P2;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void M3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.U = str;
        }
    }

    public void M4(ArrayList<VoiceData$VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, arrayList) == null) {
            this.Y = arrayList;
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public ArrayList<c.a.s0.g1.n.b> N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            ArrayList<c.a.s0.g1.n.b> arrayList = new ArrayList<>();
            if (this.t2) {
                arrayList.add(new c.a.s0.g1.n.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? (J() == null || J().getAlaUserData() == null || J().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.A0 != 0 : invokeV.booleanValue;
    }

    public void N3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.c2 = z;
        }
    }

    public void N4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048659, this, j2) == null) {
            this.B0 = j2;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.N0 : invokeV.intValue;
    }

    public final ArrayList<m.a> O0(boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048661, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> arrayList = new ArrayList<>();
            boolean N2 = N2();
            if (z2) {
                if (z) {
                    if (N2 && !H2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if (k0() == 1 || r1() == 33 || (z1() != null && z1().a() != 0)) {
                        if (m1() == null || !f2()) {
                            if (!N2) {
                                arrayList.add(new m.a(R.string.photo_live_tips));
                            }
                        } else if (n1() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    }
                    if (f2()) {
                        arrayList.add(e4.get(n1()));
                    }
                    if (L1()) {
                        Integer num = d4.get(new Point(w(), t()));
                        if (num != null) {
                            arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (I1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.d.f.p.m.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                } else {
                    if (N2 && s0() != 1 && !H2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if ((k0() == 1 || r1() == 33) && !f2() && !N2) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                    if (r0() == 1) {
                        arrayList.add(new m.a(R.string.good));
                    }
                    if (s0() == 1) {
                        arrayList.add(new m.a(R.string.top));
                    }
                    if (f2() && m1() != null && n1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                    if (L1()) {
                        Integer num2 = d4.get(new Point(w(), t()));
                        if (num2 != null) {
                            arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (this.W0 == 1) {
                        arrayList.add(new m.a(R.string.card_tbread_text));
                    }
                    if (G() != null) {
                        arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (I1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.d.f.p.m.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                    if (z4 && k2()) {
                        arrayList.add(new m.a(R.string.ala_live));
                    }
                    if (z4 && j2()) {
                        arrayList.add(new m.a(R.string.live_record));
                    } else if (u2()) {
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

    public boolean O1() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            MetaData metaData = this.T;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            UserPostPerm userPostPerm = this.c3;
            return userPostPerm != null && userPostPerm.not_show_hide_thread.intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public void O3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.a2 = z;
        }
    }

    public void O4(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, list) == null) {
            this.z2 = list;
            if (ListUtils.isEmpty(list) || this.A2) {
                return;
            }
            this.A2 = true;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.B0 : invokeV.longValue;
    }

    public PushStatusData P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.Q0 : (PushStatusData) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            BaijiahaoData baijiahaoData = this.s2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableString P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            SpannableStringBuilder T2 = T2();
            c.a.t0.g0.m.b(this, T2, false);
            return new SpannableString(T2);
        }
        return (SpannableString) invokeV.objValue;
    }

    public void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.o1 = str;
        }
    }

    public boolean P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.A1;
            return originalThreadInfo != null && originalThreadInfo.H && this.F == originalThreadInfo.f41553e;
        }
        return invokeV.booleanValue;
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.q1.disAgreeNum : invokeV.longValue;
    }

    public ThreadInfo Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.x2 : (ThreadInfo) invokeV.objValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            BaijiahaoData baijiahaoData = this.s2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public SpannableString Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (ListUtils.isEmpty(this.w)) {
                return null;
            }
            return new SpannableString(c.a.s0.g1.n.e.C(this, this.w, this.t));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void Q3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i2) == null) {
            this.q1.hasAgree = i2 == 1;
        }
    }

    public final c.a.d.n.b Q4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, str)) == null) {
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
                return new c.a.d.n.b(bitmapDrawable, 1);
            }
            return null;
        }
        return (c.a.d.n.b) invokeL.objValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.d3 : invokeV.longValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (t2()) {
                return 4;
            }
            if (k2() || j2()) {
                return 3;
            }
            if (P1()) {
                return 5;
            }
            if (S1()) {
                return 6;
            }
            if (Q1()) {
                return 7;
            }
            if (R1()) {
                return 8;
            }
            if (!this.B1 || this.A1 == null) {
                return u2() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            BaijiahaoData baijiahaoData = this.s2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    public final void R2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, str) == null) {
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

    public void R3(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, videoInfo) == null) {
            this.H1 = videoInfo;
        }
    }

    public void R4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            this.r = i2;
        }
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.r0 : (String) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.Z0 : (String) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            BaijiahaoData baijiahaoData = this.s2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public void S2(WriteData writeData) {
        String n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, writeData) == null) || writeData == null) {
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
            if (c.a.d.f.p.m.isEmpty(c.a.t0.w3.s0.g.k().n())) {
                n = writeData.getVideoInfo().getThumbPath();
            } else {
                n = c.a.t0.w3.s0.g.k().n();
            }
            builder.thumbnail_url = n;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.v0 = builder.build(true);
            this.d0 = 40;
            System.currentTimeMillis();
            this.r = writeData.isNoTitle() ? 1 : 0;
            this.t = writeData.getContent();
            z1 z1Var = new z1();
            this.G = z1Var;
            z1Var.a = writeData.getForumId();
            this.G.f13864b = writeData.getForumName();
            this.v2 = writeData.getTabId();
            this.w2 = writeData.getTabName();
            R2(writeData.getTitle());
            i3();
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
            this.B2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.C2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.B = str;
        }
    }

    public void S4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && this.E0 == 0) {
            this.E0 = 1;
        }
    }

    public SparseArray<String> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.m1 : (SparseArray) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.S1 : (String) invokeV.objValue;
    }

    @Deprecated
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? G2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            if (this.A == null) {
                this.A = new ArrayList();
            }
            return c.a.s0.g1.n.e.D(this, this.v, this.t, this.A);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void T3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i2) == null) {
            this.i1 = i2 + 1;
        }
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.F : invokeV.longValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.T1 : (String) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? Q1() || R1() : invokeV.booleanValue;
    }

    public SpannableStringBuilder U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? c.a.s0.g1.n.e.C(this, this.u, this.s) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void U3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i2) == null) {
        }
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.K : invokeV.intValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.g3 : invokeV.booleanValue;
    }

    public void V2(ArrayList<v> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048703, this, arrayList) == null) || this.r == 1 || arrayList == null || arrayList.size() <= 0) {
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

    public void V3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z) == null) {
            this.h1 = z;
        }
    }

    public List<PbContent> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.w : (List) invokeV.objValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.o : invokeV.intValue;
    }

    public final boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public SpannableStringBuilder W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            if (StringUtils.isNull(this.s) || this.r == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(U2());
            this.x = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void W3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            this.C = i2;
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.F0 : (String) invokeV.objValue;
    }

    public List<PbContent> X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? M2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder X2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048713, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? Y2(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void X3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            this.a0 = i2;
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.g0 : (String) invokeV.objValue;
    }

    public List<PbContent> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.u : (List) invokeV.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            MetaData metaData = this.T;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder Y2(boolean z, boolean z2, boolean z4) {
        InterceptResult invokeCommon;
        SpannableStringBuilder U2;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048718, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)})) == null) {
            if (this.r == 1) {
                U2 = T2();
                spannableStringBuilder = U2.toString();
            } else {
                U2 = U2();
                spannableStringBuilder = U2.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = U2;
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

    public void Y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i2) == null) {
            this.D = i2;
        }
    }

    public z1 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.G : (z1) invokeV.objValue;
    }

    public String Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.S0 : (String) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public SpannableStringBuilder Z2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder T2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048723, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.s) && this.r != 1) {
                T2 = U2();
            } else {
                T2 = T2();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(T2);
            this.x = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void Z3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z) == null) {
            this.Z1 = z;
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public String a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.c2 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a3(boolean z, boolean z2) {
        c.a.d.n.b bVar;
        SpannableStringBuilder U2;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048728, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (r1() == 42 && W1()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_convene));
                }
                if (s0() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_top));
                } else if (s0() == 2) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_notice));
                }
                if (k0() == 1 || this.R.a() != 0) {
                    if (m1() != null && r1() == 41) {
                        if (n1() == 2) {
                            arrayList.add(Integer.valueOf(R.drawable.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                    }
                }
                if (z && f2() && (num = a4.get(Integer.valueOf(n1()))) != null) {
                    arrayList.add(num);
                }
                if (r0() == 1 && !D2() && G3 != getType() && P3 != getType()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.f0;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
                }
                if (e1() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
                }
                Integer num2 = Z3.get(new Point(w(), t()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (I1() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.tag_act));
                }
                if (G() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
                }
                if (!c.a.d.f.p.m.isEmpty(this.J)) {
                    bVar = Q4(this.J);
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
                            c.a.s0.s.i0.j jVar = new c.a.s0.s.i0.j(bitmapDrawable);
                            jVar.b(c.a.d.f.p.n.d(TbadkCoreApplication.getInst().getApplicationContext(), this.q));
                            spannableString.setSpan(jVar, i4, i4 + 1, 33);
                            i4 += 2;
                        }
                        if (bVar != null) {
                            spannableString.setSpan(bVar, i4, this.J.length() + i4, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    U2 = U2();
                    if (U2 != null) {
                        spannableStringBuilder.append((CharSequence) U2);
                    }
                    this.x = spannableStringBuilder;
                }
            }
            bVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            U2 = U2();
            if (U2 != null) {
            }
            this.x = spannableStringBuilder2;
        }
    }

    public void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.E1 = 1;
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.o1 : (String) invokeV.objValue;
    }

    public String b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.V1 : (String) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            c.a.t0.w3.j0.o oVar = this.N2;
            if (oVar != null) {
                return oVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void b3(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048733, this, jSONObject) == null) || jSONObject == null) {
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
            this.s1 = jSONObject.optLong("share_num");
            this.g0 = jSONObject.optString("first_post_id", "0");
            this.F0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.r = jSONObject.optInt("is_ntitle");
            this.J = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.D0 = jSONObject.optString("tieba_game_information_source", "");
            this.q1.parseJson(jSONObject.optJSONObject("agree"));
            this.q1.threadId = this.E;
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
                this.m1 = sparseArray;
                this.n1 = sparseArray2;
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
            this.S2 = jSONObject.optString("mode_url");
            this.T2 = jSONObject.optString("location");
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
                    c.a.s0.u.c cVar = new c.a.s0.u.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.P0.add(cVar);
                }
            }
            this.W0 = jSONObject.optInt("is_book_chapter", 0);
            this.X0.a(jSONObject.optJSONObject("book_chapter"));
            this.Z0 = jSONObject.optString("recom_source");
            this.d1 = jSONObject.optString("recom_reason");
            this.e1 = jSONObject.optString("recom_tag_icon");
            this.a1 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.c1 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.f1 = jSONObject.optLong("last_read_pid");
            this.g1 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                k2 k2Var = new k2();
                this.x0 = k2Var;
                k2Var.a(optJSONObject8);
            }
            this.p1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.u1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.u1 && optJSONObject9 != null) {
                r0 r0Var = new r0();
                this.t1 = r0Var;
                r0Var.g(optJSONObject9);
            }
            this.v1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                h hVar = new h();
                this.w1 = hVar;
                hVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.x1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.y1 = jSONObject.optInt("middle_page_num", 0);
            this.z1 = jSONObject.optInt("middle_page_pass_flag", 0);
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
            this.B1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.A1 = originalThreadInfo;
                    originalThreadInfo.p(optJSONObject13);
                } else {
                    this.A1 = null;
                }
            } else {
                this.A1 = null;
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
                this.N1 = builder3.build(false);
            }
            this.V1 = jSONObject.optString("t_share_img");
            this.W1 = jSONObject.optString("nid");
            this.X1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.r2 = jSONObject.optInt("bjh_content_tag");
            this.q2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.s2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.q1.baijiahaoData = this.s2;
            }
            this.t2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.u2 = jSONObject.optString("scard_packet_id");
            this.v2 = jSONObject.optInt("tab_id");
            this.w2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.o2 = jSONObject.optInt("if_comment", 0) == 1;
            this.p2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.F2 == null) {
                    this.F2 = new PollData();
                }
                this.F2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.A2) {
                        this.A2 = true;
                    }
                    this.y2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.z2.add(pbGoodsData);
                }
                if (this.z2.size() > 0 && !this.A2) {
                    this.A2 = true;
                }
            }
            this.G2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.P2 == null) {
                    this.P2 = new WorksInfoData();
                }
                this.P2.parseJson(optJSONObject17);
            }
            this.Q2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.R2.add(threadRecommendInfoData);
                }
            }
            z1 z1Var = new z1();
            this.G = z1Var;
            z1Var.e(jSONObject.optJSONObject("forum_info"));
            this.O2 = jSONObject.optInt("is_author_view");
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
                this.C1 = optJSONObject18.optString("icon_pic_url");
                this.D1 = optJSONObject18.optString("icon_link");
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
                this.K1 = originalForumInfo;
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
                        if (this.D2 == null) {
                            this.D2 = new ArrayList();
                        }
                        this.D2.add(builder4.build(true));
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
                    this.B2 = build;
                    ItemData itemData = new ItemData();
                    this.C2 = itemData;
                    itemData.parseProto(build);
                }
            }
            this.V2 = StringHelper.equals(jSONObject.optString("is_tiebaplus_ad"), "1");
            this.W2 = jSONObject.optString("tiebaplus_order_id");
            this.X2 = jSONObject.optString("tiebaplus_token");
            this.Y2 = jSONObject.optString("tiebaplus_extra_param");
            this.Z2 = jSONObject.optInt("tiebaplus_cant_delete") == 1;
            this.f3 = jSONObject.optInt("tab_show_mode");
            JSONObject optJSONObject24 = jSONObject.optJSONObject("tiebaplus_ad");
            if (optJSONObject24 != null) {
                optJSONObject24.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
                this.a3 = optJSONObject24.optString("show_url");
                this.b3 = optJSONObject24.optString("cost_url");
            }
            i3();
            JSONObject optJSONObject25 = jSONObject.optJSONObject("voice_room");
            if (optJSONObject25 != null) {
                VoiceRoom.Builder builder7 = new VoiceRoom.Builder();
                builder7.room_id = Long.valueOf(optJSONObject25.optLong("room_id"));
                builder7.room_name = optJSONObject25.getString(DpStatConstants.KEY_ROOM_NAME);
                this.e3 = builder7.build(true);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i2) == null) {
            this.P = i2;
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.D0 : (String) invokeV.objValue;
    }

    public String c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.R1 : (String) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            MetaData metaData = this.T;
            return (metaData == null || metaData.getGodUserData() == null || this.T.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void c3(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, threadInfo) == null) || threadInfo == null) {
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
                this.q1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.q1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.D0 = threadInfo.tieba_game_information_source;
            } else {
                this.D0 = "";
            }
            this.s1 = threadInfo.share_num.longValue();
            this.J = threadInfo.category_name;
            this.t0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.Y0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.u = threadInfo.rich_title;
            this.w = threadInfo.first_post_content;
            this.v = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.T == null || this.T.getUserId() == null || this.T.getUserId().equals("0") || this.L2) && this.S != null && !this.S.equals("0") && this.h0 != null && (metaData = this.h0.get(this.S)) != null) {
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
                            c.a.s0.t.i.c cVar = new c.a.s0.t.i.c();
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
                    c.a.s0.u.c cVar2 = new c.a.s0.u.c();
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
            this.e1 = threadInfo.recom_tag_icon;
            this.a1 = threadInfo.recom_weight;
            this.b1 = threadInfo.ab_tag;
            this.c1 = threadInfo.recom_extra;
            this.f1 = threadInfo.last_read_pid.longValue();
            this.g1 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.r1.h0(threadInfo.top_agree_post);
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
                this.m1 = sparseArray;
                this.n1 = sparseArray2;
            }
            this.p1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.u1 = z;
            if (z && threadInfo.link_info != null) {
                r0 r0Var = new r0();
                this.t1 = r0Var;
                r0Var.h(threadInfo.link_info);
            }
            this.v1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                h hVar = new h();
                this.w1 = hVar;
                hVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.x1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.y1 = threadInfo.middle_page_num.intValue();
            this.z1 = threadInfo.middle_page_pass_flag.intValue();
            this.B1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.C1 = threadInfo.star_rank_icon.icon_pic_url;
                this.D1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.A1 = originalThreadInfo;
                originalThreadInfo.n(threadInfo.origin_thread_info, this);
            } else {
                this.A1 = null;
                this.B1 = false;
            }
            this.E1 = threadInfo.is_topic.intValue();
            this.G1 = threadInfo.topic_user_name;
            String str4 = threadInfo.topic_h5_url;
            this.F1 = threadInfo.topic_module;
            String str5 = threadInfo.presentation_style;
            this.K1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str6 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                z1 z1Var = new z1();
                this.G = z1Var;
                z1Var.f(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.N1 = threadInfo.swan_info;
            }
            this.V1 = threadInfo.t_share_img;
            this.W1 = threadInfo.nid;
            this.X1 = threadInfo.is_headlinepost.intValue() == 1;
            String str7 = threadInfo.thread_share_link;
            this.q2 = threadInfo.article_cover;
            this.r2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.s2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.q1.baijiahaoData = this.s2;
            }
            this.t2 = threadInfo.is_s_card.intValue() == 1;
            this.u2 = threadInfo.scard_packet_id;
            this.v2 = threadInfo.tab_id.intValue();
            this.w2 = threadInfo.tab_name;
            String str8 = threadInfo.wonderful_post_info;
            this.o2 = threadInfo.if_comment.intValue() == 1;
            this.p2 = threadInfo.if_comment_info;
            this.x2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.A2) {
                        this.A2 = true;
                    }
                    this.y2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.z2.add(pbGoodsData);
                }
                if (this.z2.size() > 0 && !this.A2) {
                    this.A2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.B2 = threadInfo.item;
            }
            if (this.B2 != null) {
                ItemData itemData = new ItemData();
                this.C2 = itemData;
                itemData.parseProto(this.B2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.D2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.E2 = itemStarData;
                itemStarData.parseProto(this.D2);
            }
            if (threadInfo.poll_info != null) {
                if (this.F2 == null) {
                    this.F2 = new PollData();
                }
                this.F2.parserProtobuf(threadInfo.poll_info);
            }
            this.G2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.O2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.P2 == null) {
                    this.P2 = new WorksInfoData();
                }
                this.P2.parseProto(threadInfo.works_info);
            }
            this.Q2 = threadInfo.collect_num.intValue();
            if (!ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseProto(threadRecommendInfo);
                    this.R2.add(threadRecommendInfoData);
                }
            }
            this.g3 = threadInfo.is_frs_mask.intValue() == 1;
            this.V2 = StringHelper.equals(threadInfo.is_tiebaplus_ad, "1");
            this.W2 = threadInfo.tiebaplus_order_id;
            this.X2 = threadInfo.tiebaplus_token;
            this.Y2 = threadInfo.tiebaplus_extra_param;
            this.Z2 = threadInfo.tiebaplus_cant_delete.intValue() == 1;
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                String str9 = tiebaPlusAd.ad_source;
                this.a3 = tiebaPlusAd.show_url;
                this.b3 = tiebaPlusAd.cost_url;
            }
            this.e3 = threadInfo.voice_room;
            this.f3 = threadInfo.tab_show_mode.intValue();
            i3();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void c4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i2) == null) {
            this.N = i2;
        }
    }

    public List<PbGoodsData> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.z2 : (List) invokeV.objValue;
    }

    public long d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.s1 : invokeV.longValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.A2 : invokeV.booleanValue;
    }

    public void d3(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048743, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            e3(z, z2, true);
        }
    }

    public void d4(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, item) == null) {
            this.B2 = item;
        }
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) ? this.q1.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.V : invokeV.intValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.h1 : invokeV.booleanValue;
    }

    public void e3(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048748, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)}) == null) {
            if (ListUtils.getCount(O0(z, z2, z4, false)) > 0) {
                X2(z, z4);
                return;
            }
            SpannableStringBuilder U2 = U2();
            if (z) {
                spannableStringBuilder = g(U2.toString(), U2, z, z2, z4, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(U2);
            }
            this.x = spannableStringBuilder;
        }
    }

    public void e4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, itemData) == null) {
            this.C2 = itemData;
        }
    }

    public VideoInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.H1 : (VideoInfo) invokeV.objValue;
    }

    public SkinInfo f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.T0 : (SkinInfo) invokeV.objValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.d0 == 41 : invokeV.booleanValue;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            a3(false, true);
        }
    }

    public void f4(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, list) == null) {
            this.D2 = list;
        }
    }

    public final SpannableStringBuilder g(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048755, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> O0 = O0(z, z2, z4, z5);
            if (O0 == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h2 = c.a.t0.g0.m.h(TbadkCoreApplication.getInst(), str, O0, false);
            if (O0.size() > 0) {
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
            } else if (O0.size() > 0 || h2.length() == 0) {
                h2.append((CharSequence) str);
            }
            return h2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public SmartApp g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? this.N1 : (SmartApp) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? m1() != null && r1() == 41 && k0() == 1 && n1() == 2 : invokeV.booleanValue;
    }

    public void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            a3(false, false);
        }
    }

    public void g4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048760, this, j2) == null) {
            this.M = j2;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            ArrayList<MediaData> F0 = F0();
            if (F0 == null || D2()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < F0.size() && i2 < 3; i2++) {
                if (F0.get(i2) != null && F0.get(i2).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(F0.get(i2).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = F0.get(i2).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = F0.get(i2).getPicUrl();
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

    @Override // c.a.s0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            SparseArray<String> sparseArray = this.m1;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            x0Var.o(getThreadData().v1());
            x0Var.k(getThreadData().U());
            x0Var.n(getThreadData().G0());
            x0Var.j(this.m1);
            x0Var.f13845g = this.n1;
            x0Var.p = this.b1;
            x0Var.f13849k = this.a1;
            x0Var.m = this.c1;
            x0Var.l = this.Z0;
            x0Var.q = this.U1;
            x0Var.o = R0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.d1 : (String) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this : (d2) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            c.a.t0.w3.j0.o oVar = this.N2;
            if (oVar != null) {
                return oVar.f() ? this.N2.g() ? AdvertAppInfo.K4 : AdvertAppInfo.L4 : this.N2.g() ? AdvertAppInfo.K4 : AdvertAppInfo.J4;
            } else if (j0()) {
                if (t1() != null) {
                    return G3;
                }
                return i3;
            } else {
                int s0 = s0();
                if (this.E1 == 1) {
                    if (this.F1 != null) {
                        return x3;
                    }
                    return this.H1 != null ? R3 : Q3;
                } else if (this.y0 != null && this.d0 == 60) {
                    return J3;
                } else {
                    if (this.y0 != null && ((i2 = this.d0) == 49 || i2 == 69)) {
                        return H3;
                    }
                    if (this.y0 != null && this.d0 == 67) {
                        return K3;
                    }
                    int i4 = this.d0;
                    if (i4 == 51) {
                        return I3;
                    }
                    if (i4 == 63) {
                        return S3;
                    }
                    if (i4 == 64) {
                        return T3;
                    }
                    if (s0 != 2 && s0 != 1) {
                        if (this.v0 != null && e2() && !i2()) {
                            return X3;
                        }
                        if (this.v0 != null && !i2()) {
                            if (c2()) {
                                return P3;
                            }
                            if (this instanceof y0) {
                                return Y3;
                            }
                            return G3;
                        } else if (this.B1 && (originalThreadInfo = this.A1) != null) {
                            if (originalThreadInfo.x) {
                                if (originalThreadInfo.r != null) {
                                    return O3;
                                }
                                if (originalThreadInfo.g()) {
                                    return N3;
                                }
                                return M3;
                            }
                            return L3;
                        } else if (P1()) {
                            return y3;
                        } else {
                            if (g2()) {
                                return V3.get() ? b4 : i3;
                            } else if (L1() && w() == 1) {
                                return V3.get() ? c4 : i3;
                            } else if (h2()) {
                                return E3;
                            } else {
                                if (c2()) {
                                    return F3;
                                }
                                if (this.f13657e) {
                                    return o3;
                                }
                                if (this.f13658f) {
                                    return p3;
                                }
                                if (this.f13659g) {
                                    return q3;
                                }
                                if (this.f13660h) {
                                    return r3;
                                }
                                if (this.f13661i) {
                                    return s3;
                                }
                                if (this.f13663k) {
                                    return v3;
                                }
                                if (this.l) {
                                    return w3;
                                }
                                if (this.f13662j) {
                                    return t3;
                                }
                                if (this.m) {
                                    return A3;
                                }
                                if (this.H0) {
                                    int h32 = h3();
                                    if (h32 == 1) {
                                        return k3;
                                    }
                                    if (h32 == 2) {
                                        return l3;
                                    }
                                    if (h32 > 2) {
                                        return m3;
                                    }
                                    return i3;
                                }
                                return i3;
                            }
                        }
                    }
                    return h3;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            VideoInfo videoInfo = this.v0;
            if (videoInfo != null) {
                return videoInfo.video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int[] h0() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            int[] iArr = new int[2];
            int size = View.MeasureSpec.getSize(c.a.d.f.p.n.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> F0 = F0();
            if (c.a.s0.s.k.c().g() && ListUtils.getCount(F0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i13 = 0; i13 < F0.size(); i13++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(F0, i13);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(F0, 0);
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
            c.a.s0.b.g.b.k(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this.l1 : invokeV.intValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.u1 : invokeV.booleanValue;
    }

    public int h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            if (!c.a.s0.s.k.c().g() || ListUtils.getCount(F0()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < F0().size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(F0(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void h4(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, list) == null) {
            this.y2 = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.y2) {
                if (pbLinkData.urlType == 2 && !this.A2) {
                    this.A2 = true;
                }
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) ? this.i1 : invokeV.intValue;
    }

    public SpannableStringBuilder i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.x : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.d0 == 41 : invokeV.booleanValue;
    }

    public void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            s3();
            l3();
            q3();
            r3();
            j3();
            o3();
            p3();
        }
    }

    public void i4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z) == null) {
            c4(z ? 1 : 0);
        }
    }

    @Override // c.a.s0.s.q.a
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.a2 : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.M1 : invokeV.booleanValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this.v2 : invokeV.intValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) ? r1() == 50 : invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            this.z = P2();
        }
    }

    public void j4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, str) == null) {
            this.b0 = str;
        }
    }

    public SpannableString k(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048785, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            c.a.s0.s.i0.k kVar = new c.a.s0.s.i0.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String p = c.a.s0.s.g0.b.j().p("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) ? this.Q : invokeV.intValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) ? this.w2 : (String) invokeV.objValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? r1() == 49 || r1() == 69 : invokeV.booleanValue;
    }

    public final void k3() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048789, this) == null) || (alaInfoData = this.y0) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j2 = this.B0;
            if (j2 > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j2);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.Q1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.y0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.Q1) || i2 <= 0) {
                if (i2 > 0) {
                    this.Q1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.Q1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void k4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048790, this, z) == null) {
            this.I1 = z;
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.C : invokeV.intValue;
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.f3 : invokeV.intValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? s0() == 1 : invokeV.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            if ((this instanceof y0) && "0".equals(g0())) {
                this.Q1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
                return;
            }
            int i2 = 36;
            if (!G2() && ((!a2() || getType() == H3) && !this.e2 && !this.j2)) {
                if (getType() != H3 && getType() != K3) {
                    if (J2() && !TextUtils.isEmpty(this.U)) {
                        this.Q1 = StringHelper.cutChineseAndEnglishWithSuffix(this.U, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(R.string.forum);
                        return;
                    }
                    long w0 = w0() * 1000;
                    if (w0 != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(w0);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(w0);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(w0);
                        }
                        this.Q1 = string + formatTimeForJustNow;
                    } else {
                        long j2 = this.B0;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j2);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j2);
                        }
                        this.Q1 = formatTimeForJustNow2;
                    }
                    if (this.a2) {
                        i2 = 24;
                    } else if (!this.c2) {
                        i2 = 16;
                    }
                    String authInfo = UtilHelper.getAuthInfo(this.T, this.b2, i2);
                    if (x2()) {
                        String str = StringHelper.cutChineseAndEnglishWithSuffix(this.U, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(R.string.forum);
                        if (!TextUtils.isEmpty(authInfo)) {
                            this.Q1 = authInfo + GlideException.IndentedAppendable.INDENT + str;
                        } else {
                            this.Q1 = str;
                        }
                    } else if (!TextUtils.isEmpty(this.Q1) && !TextUtils.isEmpty(authInfo)) {
                        this.Q1 += GlideException.IndentedAppendable.INDENT + authInfo;
                    } else if (!TextUtils.isEmpty(authInfo)) {
                        this.Q1 = authInfo;
                    }
                    if (TextUtils.isEmpty(this.Q1) || TextUtils.isEmpty(A())) {
                        return;
                    }
                    this.Q1 += " • " + A();
                    return;
                }
                k3();
                return;
            }
            long j4 = this.B0;
            if (j4 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j4);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j4);
                }
                this.Q1 = formatTimeForJustNow3;
            }
            if (!this.j2 || (TextUtils.isEmpty(this.r0) && TextUtils.isEmpty(this.T2))) {
                if (this.a2) {
                    i2 = 24;
                } else if (!this.c2) {
                    i2 = 16;
                }
                String authInfo2 = UtilHelper.getAuthInfo(this.T, this.b2, i2);
                if (!TextUtils.isEmpty(this.Q1) && !TextUtils.isEmpty(authInfo2)) {
                    this.Q1 += "   " + authInfo2;
                } else if (TextUtils.isEmpty(authInfo2)) {
                } else {
                    this.Q1 = authInfo2;
                }
            }
        }
    }

    public void l4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048795, this, z) == null) {
            this.J1 = z;
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public b2 m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.O0 : (b2) invokeV.objValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) ? this.I1 : invokeV.booleanValue;
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048799, this) == null) && q2() && !TextUtils.isEmpty(this.T.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.Q1)) {
                this.Q1 += "   " + this.T.getNewGodData().getFieldName() + c.a.s0.e1.t0.c(this.T.getNewGodData().isVideoGod());
                return;
            }
            this.Q1 = this.T.getNewGodData().getFieldName() + c.a.s0.e1.t0.c(this.T.getNewGodData().isVideoGod());
        }
    }

    public void m4(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, arrayList) == null) {
            this.X = arrayList;
        }
    }

    public int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) ? this.O : invokeV.intValue;
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) {
            b2 b2Var = this.O0;
            if (b2Var != null) {
                long e2 = b2Var.e();
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

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? this.J1 : invokeV.booleanValue;
    }

    public void n3() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048804, this) == null) || G2() || a2()) {
            return;
        }
        long w0 = w0() * 1000;
        if (w0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(w0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(w0);
            }
            this.Q1 = formatTimeForJustNow;
        }
        if (q2()) {
            m3();
        } else if (!this.b2 && (metaData = this.T) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.T.getBazhuGradeData().getDesc(), 24, "...");
            if (!TextUtils.isEmpty(this.Q1)) {
                this.Q1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.Q1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.Q1) || TextUtils.isEmpty(A())) {
            return;
        }
        this.Q1 += " • " + A();
    }

    public void n4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, str) == null) {
            this.p = str;
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048806, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) ? this.r : invokeV.intValue;
    }

    public AlaInfoData o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? this.y0 : (AlaInfoData) invokeV.objValue;
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) ? this.p1 : invokeV.booleanValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048810, this) == null) {
            this.S1 = StringHelper.getFormatTimeShort(w0() * 1000);
        }
    }

    public void o4(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, pollData) == null) {
            this.F2 = pollData;
        }
    }

    public SpannableString p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048812, this)) == null) ? this.z : (SpannableString) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) ? this.Q1 : (String) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) ? this.g1 : invokeV.booleanValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048816, this) == null) {
            this.T1 = StringHelper.getFormatTimeShort(w0());
        }
    }

    public void p4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048817, this, i2) == null) {
            this.U2 = i2;
        }
    }

    public ArrayList<b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048818, this)) == null) ? this.I0 : (ArrayList) invokeV.objValue;
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048819, this)) == null) ? this.D : invokeV.intValue;
    }

    public List<ThreadRecommendInfoData> q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) ? this.R2 : (List) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) {
            MetaData metaData = this.T;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048822, this) == null) {
            if (o1() != null && o1().share_info != null && o1().share_info.share_user_count > 0 && w2() && (this.y1 <= 0 || this.z1 != 0)) {
                int i2 = o1().share_info.share_user_count;
                if (i2 == 1) {
                    this.R1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.R1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                    return;
                }
            }
            this.R1 = null;
        }
    }

    public void q4(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, praiseData) == null) {
            this.e0 = praiseData;
        }
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048824, this)) == null) ? this.P : invokeV.intValue;
    }

    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) ? this.d0 : invokeV.intValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? this.d0 == 0 : invokeV.booleanValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048827, this) == null) {
            SpannableStringBuilder W2 = W2();
            this.y = W2;
            c.a.t0.g0.m.b(this, W2, true);
        }
    }

    public void r4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048828, this, i2) == null) {
            this.K = i2;
        }
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048829, this)) == null) ? this.N : invokeV.intValue;
    }

    public k2 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? this.x0 : (k2) invokeV.objValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) ? this.d0 == 31 : invokeV.booleanValue;
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048832, this) == null) || StringUtils.isNull(this.T.getName_show())) {
            return;
        }
        this.P1 = StringHelper.cutChineseAndEnglishWithSuffix(this.T.getName_show(), 12, "...");
    }

    public void s4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048833, this, i2) == null) {
            this.o = i2;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) {
            if (!L1() || this.I0.size() < 1) {
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

    public Item t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) ? this.B2 : (Item) invokeV.objValue;
    }

    public VideoInfo t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) ? this.v0 : (VideoInfo) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) ? this.A0 == 1 : invokeV.booleanValue;
    }

    public void t3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, str) == null) {
            this.t = str;
        }
    }

    public void t4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, list) == null) {
            this.v = list;
        }
    }

    public List<HeadItem> u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) ? this.D2 : (List) invokeV.objValue;
    }

    public VideoDesc u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) ? this.w0 : (VideoDesc) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) ? r1() == 40 : invokeV.booleanValue;
    }

    public void u3(ArrayList<b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048843, this, arrayList) == null) {
            this.I0 = arrayList;
        }
    }

    public void u4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, list) == null) {
            this.u = list;
        }
    }

    public long v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048845, this)) == null) ? this.f1 : invokeV.longValue;
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) {
            if (!StringUtils.isNull(this.E) && !"0".equals(this.E)) {
                return this.E;
            }
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) ? (t0() == null && ((originalThreadInfo = this.A1) == null || originalThreadInfo.C == null)) ? false : true : invokeV.booleanValue;
    }

    public void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048848, this, z) == null) {
            b4(z ? 1 : 0);
        }
    }

    public void v4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048849, this, str) == null) {
            this.I = str;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048850, this)) == null) {
            if (!L1() || this.I0.size() < 1 || this.I0.get(0) == null) {
                return -1;
            }
            return this.I0.get(0).a();
        }
        return invokeV.intValue;
    }

    public long w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048851, this)) == null) ? this.M : invokeV.longValue;
    }

    @Nullable
    public List<c.a.s0.g1.p.a> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) ? this.A : (List) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) ? r1() == 60 : invokeV.booleanValue;
    }

    public void w3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048854, this, i2) == null) {
            this.q1.agreeNum = i2;
        }
    }

    public void w4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048855, this, j2) == null) {
            this.s1 = j2;
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048856, this)) == null) ? (!L1() || this.I0.size() < 1 || this.I0.get(0) == null) ? "" : this.I0.get(0).g() : (String) invokeV.objValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048857, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public SpannableStringBuilder x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048858, this)) == null) ? this.y : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048859, this)) == null) ? (M2() || H2()) && !StringUtils.isNull(this.U) && this.b2 : invokeV.booleanValue;
    }

    public void x3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048860, this, j2) == null) {
            this.q1.agreeNum = j2;
        }
    }

    public void x4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048861, this, z) == null) {
            this.O1 = z;
        }
    }

    public ActivityItemData y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048862, this)) == null) {
            List<PbContent> list = this.u;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.u.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && H2() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = c.a.s0.u0.a.d(pbContent.text);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048863, this)) == null) ? this.R0 : (String) invokeV.objValue;
    }

    public PostData y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048864, this)) == null) ? this.r1 : (PostData) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) ? this.O1 : invokeV.booleanValue;
    }

    public void y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048866, this, i2) == null) {
            this.q1.agreeType = i2;
        }
    }

    public void y4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048867, this, i2) == null) {
            this.l1 = i2;
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048868, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048869, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public h2 z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048870, this)) == null) ? this.R : (h2) invokeV.objValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048871, this)) == null) {
            int i2 = this.d0;
            return i2 == 63 || i2 == 64;
        }
        return invokeV.booleanValue;
    }

    public void z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048872, this, i2) == null) {
            this.z0 = i2;
        }
    }

    public void z4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048873, this, i2) == null) {
        }
    }
}
