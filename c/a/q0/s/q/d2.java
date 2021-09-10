package c.a.q0.s.q;

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
import c.a.r0.a0.m;
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
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.UserPostPerm;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes3.dex */
public class d2 extends a implements PreLoadImageProvider, c.a.e.l.e.n, IVideoData {
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
    public static AtomicBoolean L3;
    public static AtomicBoolean M3;
    public static AtomicBoolean N3;
    public static final BdUniqueId O3;
    public static final BdUniqueId P3;
    public static HashMap<Point, Integer> Q3;
    public static HashMap<Integer, Integer> R3;
    public static final BdUniqueId S3;
    public static final BdUniqueId T3;
    public static HashMap<Point, Integer> U3;
    public static SparseArray<m.a> V3;
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
    public String A1;
    public ItemStarData A2;
    public int B;
    public int B0;
    public int B1;
    public PollData B2;
    public int C;
    public String C0;
    public TopicModule C1;
    public int C2;
    public String D;
    public int D0;
    public String D1;
    public String D2;
    public long E;
    public boolean E0;
    public String E1;
    public String E2;
    public z1 F;
    public ArrayList<b> F0;
    public VideoInfo F1;
    public String F2;
    public String G;
    public r2 G0;
    public boolean G1;
    public boolean G2;
    public String H;
    public i H0;
    public boolean H1;
    public boolean H2;
    public String I;
    public u I0;
    public OriginalForumInfo I1;
    public int I2;
    public int J;
    public String J0;
    public boolean J1;
    public c.a.r0.j3.i0.o J2;
    public int K;
    public int K0;
    public boolean K1;
    public int K2;
    public long L;
    public b2 L0;
    public SmartApp L1;
    public WorksInfoData L2;
    public int M;
    public ArrayList<c.a.q0.u.c> M0;
    public boolean M1;
    public int M2;
    public int N;
    public PushStatusData N0;
    public String N1;
    public List<ThreadRecommendInfoData> N2;
    public int O;
    public String O0;
    public String O1;
    public String O2;
    public int P;
    public String P0;
    public String P1;
    public int P2;
    public h2 Q;
    public SkinInfo Q0;
    public String Q1;
    public boolean Q2;
    public String R;
    public boolean R0;
    public String R1;
    public String R2;
    public MetaData S;
    public String S0;
    public int S1;
    public String S2;
    public String T;
    public int T0;
    public String T1;
    public String T2;
    public int U;
    public r U0;
    public String U1;
    public boolean U2;
    public String V;
    public boolean V0;
    public boolean V1;
    public UserPostPerm V2;
    public ArrayList<MediaData> W;
    public String W0;
    public boolean W1;
    public long W2;
    public ArrayList<VoiceData$VoiceModel> X;
    public String X0;
    public boolean X1;
    public boolean X2;
    public int Y;
    public String Y0;
    public boolean Y1;
    public int Z;
    public String Z0;
    public boolean Z1;
    public String a0;
    public String a1;
    public boolean a2;
    public int b0;
    public String b1;
    public boolean b2;
    public int c0;
    public long c1;
    public boolean c2;
    public boolean d1;
    public boolean d2;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14136e;
    public boolean e1;
    public boolean e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14137f;
    public int f1;
    public boolean f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14138g;
    public boolean g1;
    public boolean g2;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14139h;
    public boolean h1;
    public String h2;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14140i;
    public PraiseData i0;
    public int i1;
    public boolean i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14141j;
    public AnchorInfoData j0;
    public SparseArray<String> j1;
    public String j2;
    public boolean k;
    public String k0;
    public SparseArray<String> k1;
    public boolean k2;
    public boolean l;
    public HashMap<String, MetaData> l0;
    public String l1;
    public String l2;
    public boolean m;
    public String m0;
    public boolean m1;
    public String m2;
    public int n;
    public String n0;
    public AgreeData n1;
    public int n2;
    public String o;
    public String o0;
    public PostData o1;
    public BaijiahaoData o2;
    public int p;
    public int p0;
    public long p1;
    public boolean p2;
    public int q;
    public int q0;
    public r0 q1;
    public String q2;
    public String r;
    public ArrayList<c.a.q0.t.i.c> r0;
    public boolean r1;
    public int r2;
    public String s;
    public VideoInfo s0;
    public boolean s1;
    public String s2;
    public List<PbContent> t;
    public VideoDesc t0;
    public h t1;
    public ThreadInfo t2;
    public List<PbContent> u;
    public k2 u0;
    public MediaData u1;
    public List<PbLinkData> u2;
    public List<PbContent> v;
    public AlaInfoData v0;
    public int v1;
    public List<PbGoodsData> v2;
    public SpannableStringBuilder w;
    public int w0;
    public int w1;
    public boolean w2;
    public SpannableStringBuilder x;
    public int x0;
    public OriginalThreadInfo x1;
    public Item x2;
    public SpannableString y;
    public long y0;
    public boolean y1;
    public ItemData y2;
    @Nullable
    public List<c.a.q0.f1.o.a> z;
    public long z0;
    public String z1;
    public List<HeadItem> z2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-573978071, "Lc/a/q0/s/q/d2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-573978071, "Lc/a/q0/s/q/d2;");
                return;
            }
        }
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
        I3 = BdUniqueId.gen();
        J3 = BdUniqueId.gen();
        K3 = BdUniqueId.gen();
        L3 = new AtomicBoolean(false);
        M3 = new AtomicBoolean(false);
        N3 = new AtomicBoolean(false);
        O3 = BdUniqueId.gen();
        P3 = BdUniqueId.gen();
        Q3 = new HashMap<>();
        R3 = new HashMap<>();
        S3 = BdUniqueId.gen();
        T3 = BdUniqueId.gen();
        U3 = new HashMap<>();
        V3 = new SparseArray<>(3);
        Q3.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        Q3.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        Q3.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        Q3.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        Q3.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        Q3.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        Q3.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        Q3.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        U3.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        U3.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        U3.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        U3.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        U3.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        U3.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        U3.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        U3.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        R3.put(1, Integer.valueOf(R.drawable.label_interview_no));
        R3.put(2, Integer.valueOf(R.drawable.label_interview_live));
        R3.put(3, Integer.valueOf(R.drawable.label_interview_off));
        V3.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        V3.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        V3.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
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
        this.f14136e = false;
        this.f14137f = false;
        this.f14138g = false;
        this.f14139h = false;
        this.f14140i = false;
        this.f14141j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 0;
        this.o = "1";
        this.p = 1;
        this.Y = 0;
        this.a0 = null;
        this.q0 = 0;
        this.B0 = 0;
        this.C0 = "";
        this.E0 = false;
        this.J0 = "";
        this.d1 = true;
        this.h1 = false;
        this.i1 = -1;
        this.j1 = null;
        this.k1 = null;
        this.s1 = false;
        this.v1 = 0;
        this.B1 = 0;
        this.G1 = false;
        this.M1 = false;
        this.V1 = false;
        this.W1 = false;
        this.k2 = false;
        this.p2 = false;
        this.G2 = false;
        this.H2 = false;
        this.O2 = "";
        this.A = null;
        this.D = null;
        this.E = 0L;
        this.r = null;
        this.x0 = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0L;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = new h2();
        this.S = new MetaData();
        this.T = null;
        this.W = new ArrayList<>();
        this.X = new ArrayList<>();
        this.U = 0;
        this.V = null;
        this.s = null;
        this.Z = 0;
        this.i0 = new PraiseData();
        this.j0 = new AnchorInfoData();
        this.p0 = 0;
        this.F0 = new ArrayList<>();
        this.G0 = null;
        this.H0 = null;
        this.r0 = new ArrayList<>();
        this.D0 = 0;
        this.D0 = 0;
        this.K0 = 0;
        this.q0 = 0;
        this.w0 = 0;
        this.T0 = 0;
        this.U0 = new r();
        this.v = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.I = null;
        this.L0 = new b2();
        this.M0 = new ArrayList<>();
        this.N0 = new PushStatusData();
        this.Y = 0;
        this.e1 = false;
        this.f1 = -1;
        this.o1 = new PostData();
        this.n1 = new AgreeData();
        this.v1 = 0;
        this.w1 = 0;
        this.A0 = "";
        this.A1 = "";
        this.z1 = "";
        this.O0 = "";
        this.P0 = "";
        this.u2 = new ArrayList();
        this.v2 = new ArrayList();
        this.N2 = new ArrayList();
        this.C2 = -1;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o0 : (String) invokeV.objValue;
    }

    public List<PbLinkData> A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u2 : (List) invokeV.objValue;
    }

    public HashMap<String, MetaData> A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l0 : (HashMap) invokeV.objValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? r0() != 0 : invokeV.booleanValue;
    }

    public void A3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.K0 = i2;
        }
    }

    public void A4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.D = str;
        }
    }

    public AgreeData B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n1 : (AgreeData) invokeV.objValue;
    }

    public r0 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q1 : (r0) invokeV.objValue;
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (O1() || N1()) {
                return 2;
            }
            return (M1() || P1()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.B1 == 1 : invokeV.booleanValue;
    }

    public void B3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.n1.diffAgreeNum = j2;
        }
    }

    public void B4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.r = str;
        }
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n1.agreeNum : invokeV.longValue;
    }

    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n0 : (String) invokeV.objValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.K : invokeV.intValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.I1 != null : invokeV.booleanValue;
    }

    public void C3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.W2 = j2;
        }
    }

    public void C4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.E1 = str;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.n1.agreeType : invokeV.intValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    public ArrayList<VoiceData$VoiceModel> D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.X : (ArrayList) invokeV.objValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            BaijiahaoData baijiahaoData = this.o2;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public void D3(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            C3(c.a.e.e.m.b.g(str, 0L));
        }
    }

    public void D4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.D1 = str;
        }
    }

    public AnchorInfoData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.j0 : (AnchorInfoData) invokeV.objValue;
    }

    public ArrayList<MediaData> E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : (ArrayList) invokeV.objValue;
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (Q0() == 1) {
                return 2;
            }
            if (Q0() == 2) {
                return 3;
            }
            return Q0() == 3 ? 1 : 4;
        }
        return invokeV.intValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            int i2 = this.c0;
            return i2 == 40 || i2 == 50;
        }
        return invokeV.booleanValue;
    }

    public void E3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            this.E = j2;
        }
    }

    public void E4(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hashMap) == null) {
            this.l0 = hashMap;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.w0 : invokeV.intValue;
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.U1 : (String) invokeV.objValue;
    }

    public r2 F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.G0 : (r2) invokeV.objValue;
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? E2() && I2() : invokeV.booleanValue;
    }

    public void F3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.G = str;
        }
    }

    public void F4(UserPostPerm userPostPerm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, userPostPerm) == null) {
            this.V2 = userPostPerm;
        }
    }

    public i G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.H0 : (i) invokeV.objValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.q0 : invokeV.intValue;
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || ListUtils.getCount(this.z2) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.x;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) TbRichTextHelper.e(this.z2));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.y);
        spannableStringBuilder2.insert(0, (CharSequence) TbRichTextHelper.e(this.z2));
        this.y = new SpannableString(spannableStringBuilder2);
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.c0 == 11 || this.b0 == 1 : invokeV.booleanValue;
    }

    public void G3(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, list) == null) {
            this.v = list;
        }
    }

    public void G4(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, videoInfo) == null) {
            this.s0 = videoInfo;
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.m2 : (String) invokeV.objValue;
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void H1(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, spannableString) == null) || J() == null || showNoName() || showWeakenName()) {
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

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.c0 == 36 : invokeV.booleanValue;
    }

    public void H3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.R0 = z;
        }
    }

    public void H4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.K = i2;
        }
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.z0 : invokeV.longValue;
    }

    public PollData I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.B2 : (PollData) invokeV.objValue;
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.p0 == 1 : invokeV.booleanValue;
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            WorksInfoData worksInfoData = this.L2;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public void I3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.T = str;
        }
    }

    public void I4(ArrayList<VoiceData$VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, arrayList) == null) {
            this.X = arrayList;
        }
    }

    public MetaData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.S : (MetaData) invokeV.objValue;
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.P2 : invokeV.intValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? q0() == 1 : invokeV.booleanValue;
    }

    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.x0 != 0 : invokeV.booleanValue;
    }

    public void J3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.a2 = z;
        }
    }

    public void J4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j2) == null) {
            this.y0 = j2;
        }
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.n2 : invokeV.intValue;
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.D0 : invokeV.intValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? (J() == null || J().getAlaUserData() == null || J().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            UserPostPerm userPostPerm = this.V2;
            return userPostPerm != null && userPostPerm.not_show_hide_thread.intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public void K3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.Y1 = z;
        }
    }

    public void K4(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, list) == null) {
            this.v2 = list;
            if (ListUtils.isEmpty(list) || this.w2) {
                return;
            }
            this.w2 = true;
        }
    }

    public BaijiahaoData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.o2 : (BaijiahaoData) invokeV.objValue;
    }

    public PraiseData L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.i0 : (PraiseData) invokeV.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            MetaData metaData = this.S;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public SpannableString L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            SpannableStringBuilder P2 = P2();
            c.a.r0.a0.m.b(this, P2, false);
            return new SpannableString(P2);
        }
        return (SpannableString) invokeV.objValue;
    }

    public void L3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.l1 = str;
        }
    }

    public final c.a.e.l.b L4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
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
                return new c.a.e.l.b(bitmapDrawable, 1);
            }
            return null;
        }
        return (c.a.e.l.b) invokeL.objValue;
    }

    public u M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.I0 : (u) invokeV.objValue;
    }

    public ArrayList<c.a.q0.f1.m.b> M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            ArrayList<c.a.q0.f1.m.b> arrayList = new ArrayList<>();
            if (this.p2) {
                arrayList.add(new c.a.q0.f1.m.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            BaijiahaoData baijiahaoData = this.o2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableString M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (ListUtils.isEmpty(this.v)) {
                return null;
            }
            return new SpannableString(TbRichTextHelper.B(this, this.v, this.s));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void M3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.n1.hasAgree = i2 == 1;
        }
    }

    public void M4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.q = i2;
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public final ArrayList<m.a> N0(boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> arrayList = new ArrayList<>();
            boolean J2 = J2();
            if (z2) {
                if (z) {
                    if (J2 && !E2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if (j0() == 1 || o1() == 33 || (w1() != null && w1().a() != 0)) {
                        if (j1() == null || !c2()) {
                            if (!J2) {
                                arrayList.add(new m.a(R.string.photo_live_tips));
                            }
                        } else if (k1() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    }
                    if (c2()) {
                        arrayList.add(V3.get(k1()));
                    }
                    if (I1()) {
                        Integer num = U3.get(new Point(w(), t()));
                        if (num != null) {
                            arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (F1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.e.e.p.k.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                } else {
                    if (J2 && r0() != 1 && !E2()) {
                        arrayList.add(new m.a(R.string.god_title));
                    }
                    if ((j0() == 1 || o1() == 33) && !c2() && !J2) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                    if (q0() == 1) {
                        arrayList.add(new m.a(R.string.good));
                    }
                    if (r0() == 1) {
                        arrayList.add(new m.a(R.string.top));
                    }
                    if (c2() && j1() != null && k1() == 2) {
                        arrayList.add(new m.a(R.string.interview_live));
                    }
                    if (I1()) {
                        Integer num2 = U3.get(new Point(w(), t()));
                        if (num2 != null) {
                            arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new m.a(R.string.card_promotion_text));
                        }
                    }
                    if (this.T0 == 1) {
                        arrayList.add(new m.a(R.string.card_tbread_text));
                    }
                    if (G() != null) {
                        arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (F1() != null) {
                        arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!c.a.e.e.p.k.isEmpty(N())) {
                        arrayList.add(new m.a(N()));
                    }
                    if (z4 && h2()) {
                        arrayList.add(new m.a(R.string.ala_live));
                    }
                    if (z4 && g2()) {
                        arrayList.add(new m.a(R.string.live_record));
                    } else if (r2()) {
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

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            BaijiahaoData baijiahaoData = this.o2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public final void N2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
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
                    this.t.add(builder2.build(true));
                    i2 += split[i4].length();
                }
                if (matcher.find(i2)) {
                    builder.type = 1282;
                    builder.text = matcher.group(0);
                    builder.link = " =" + matcher.group(0);
                    this.t.add(builder.build(true));
                    i2 += matcher.group(0).length();
                }
            }
        }
    }

    public void N3(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, videoInfo) == null) {
            this.F1 = videoInfo;
        }
    }

    public void N4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && this.B0 == 0) {
            this.B0 = 1;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.K0 : invokeV.intValue;
    }

    public PushStatusData O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.N0 : (PushStatusData) invokeV.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            BaijiahaoData baijiahaoData = this.o2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    public void O2(WriteData writeData) {
        String l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, writeData) == null) || writeData == null) {
            return;
        }
        try {
            this.A = "0";
            this.D = "";
            this.E = c.a.e.e.m.b.g(writeData.getForumId(), 0L);
            this.r = writeData.getTitle();
            this.y0 = System.currentTimeMillis() / 1000;
            String str = (System.currentTimeMillis() / 1000) + "";
            this.L = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.S = metaData;
            metaData.parseFromCurrentUser();
            this.R = TbadkCoreApplication.getCurrentAccount();
            this.T = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (c.a.e.e.p.k.isEmpty(c.a.r0.j3.r0.g.i().l())) {
                l = writeData.getVideoInfo().getThumbPath();
            } else {
                l = c.a.r0.j3.r0.g.i().l();
            }
            builder.thumbnail_url = l;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.s0 = builder.build(true);
            this.c0 = 40;
            System.currentTimeMillis();
            this.q = writeData.isNoTitle() ? 1 : 0;
            this.s = writeData.getContent();
            z1 z1Var = new z1();
            this.F = z1Var;
            z1Var.f14373a = writeData.getForumId();
            this.F.f14374b = writeData.getForumName();
            this.r2 = writeData.getTabId();
            this.s2 = writeData.getTabName();
            N2(writeData.getTitle());
            e3();
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
            this.x2 = builder2.build(true);
            ItemData itemData = new ItemData();
            this.y2 = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.A = str;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.y0 : invokeV.longValue;
    }

    public ThreadInfo P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.t2 : (ThreadInfo) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            BaijiahaoData baijiahaoData = this.o2;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.z == null) {
                this.z = new ArrayList();
            }
            return TbRichTextHelper.C(this, this.u, this.s, this.z);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void P3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i2) == null) {
            this.f1 = i2 + 1;
        }
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.n1.disAgreeNum : invokeV.longValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (q2()) {
                return 4;
            }
            if (h2() || g2()) {
                return 3;
            }
            if (M1()) {
                return 5;
            }
            if (P1()) {
                return 6;
            }
            if (N1()) {
                return 7;
            }
            if (O1()) {
                return 8;
            }
            if (!this.y1 || this.x1 == null) {
                return r2() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? D2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? TbRichTextHelper.B(this, this.t, this.r) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void Q3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
        }
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.W2 : invokeV.longValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? N1() || O1() : invokeV.booleanValue;
    }

    public void R2(ArrayList<v> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, arrayList) == null) || this.q == 1 || arrayList == null || arrayList.size() <= 0) {
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

    public void R3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.e1 = z;
        }
    }

    public SparseArray<String> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.j1 : (SparseArray) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.Q1 : (String) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.X2 : invokeV.booleanValue;
    }

    public SpannableStringBuilder S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (StringUtils.isNull(this.r) || this.q == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Q2());
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void S3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            this.B = i2;
        }
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.E : invokeV.longValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.R1 : (String) invokeV.objValue;
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public SpannableStringBuilder T2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048688, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? U2(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void T3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i2) == null) {
            this.Z = i2;
        }
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.J : invokeV.intValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? I2() : invokeV.booleanValue;
    }

    public SpannableStringBuilder U2(boolean z, boolean z2, boolean z4) {
        InterceptResult invokeCommon;
        SpannableStringBuilder Q2;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048693, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)})) == null) {
            if (this.q == 1) {
                Q2 = P2();
                spannableStringBuilder = Q2.toString();
            } else {
                Q2 = Q2();
                spannableStringBuilder = Q2.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = Q2;
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

    public void U3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i2) == null) {
            this.C = i2;
        }
    }

    public List<PbContent> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.n : invokeV.intValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            MetaData metaData = this.S;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder V2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder P2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.r) && this.q != 1) {
                P2 = Q2();
            } else {
                P2 = P2();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(P2);
            this.w = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void V3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.X1 = z;
        }
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.C0 : (String) invokeV.objValue;
    }

    public List<PbContent> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.R0 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W2(boolean z, boolean z2) {
        c.a.e.l.b bVar;
        SpannableStringBuilder Q2;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (o1() == 42 && T1()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_convene));
                }
                if (r0() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_top));
                } else if (r0() == 2) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_notice));
                }
                if (j0() == 1 || this.Q.a() != 0) {
                    if (j1() != null && o1() == 41) {
                        if (k1() == 2) {
                            arrayList.add(Integer.valueOf(R.drawable.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                    }
                }
                if (z && c2() && (num = R3.get(Integer.valueOf(k1()))) != null) {
                    arrayList.add(num);
                }
                if (q0() == 1 && !A2() && w3 != getType() && F3 != getType()) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.j0;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
                }
                if (c1() == 1) {
                    arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
                }
                Integer num2 = Q3.get(new Point(w(), t()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (F1() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.tag_act));
                }
                if (G() != null) {
                    arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
                }
                if (!c.a.e.e.p.k.isEmpty(this.I)) {
                    bVar = L4(this.I);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (bVar != null) {
                            spannableString = new SpannableString(sb2 + this.I + " ");
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
                            c.a.q0.s.f0.j jVar = new c.a.q0.s.f0.j(bitmapDrawable);
                            jVar.b(c.a.e.e.p.l.e(TbadkCoreApplication.getInst().getApplicationContext(), this.p));
                            spannableString.setSpan(jVar, i4, i4 + 1, 33);
                            i4 += 2;
                        }
                        if (bVar != null) {
                            spannableString.setSpan(bVar, i4, this.I.length() + i4, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    Q2 = Q2();
                    if (Q2 != null) {
                        spannableStringBuilder.append((CharSequence) Q2);
                    }
                    this.w = spannableStringBuilder;
                }
            }
            bVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            Q2 = Q2();
            if (Q2 != null) {
            }
            this.w = spannableStringBuilder2;
        }
    }

    public void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.B1 = 1;
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.P0 : (String) invokeV.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.a2 : invokeV.booleanValue;
    }

    @Deprecated
    public void X2(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.A = jSONObject.optString("id");
            this.E = jSONObject.optLong("fid", 0L);
            this.D = jSONObject.optString("tid");
            this.r = jSONObject.optString("title");
            this.x0 = jSONObject.optInt("is_god");
            this.y0 = jSONObject.optLong("create_time", 0L) * 1000;
            this.z0 = jSONObject.optLong("audit_time", 0L) * 1000;
            this.J = jSONObject.optInt("reply_num", 0);
            jSONObject.optInt("repost_num", 0);
            this.K = jSONObject.optInt("view_num", 0);
            jSONObject.optString("last_time");
            this.L = jSONObject.optLong("last_time_int", 0L);
            this.M = jSONObject.optInt("is_top", 0);
            this.N = jSONObject.optInt("is_membertop", 0);
            this.O = jSONObject.optInt("is_good", 0);
            this.P = jSONObject.optInt("is_livepost", 0);
            this.Q.c(jSONObject.optJSONObject("topic"));
            this.R = jSONObject.optString("author_id");
            this.S.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            this.T = jSONObject.optString("fname");
            jSONObject.optInt("has_commented", 0);
            this.U = jSONObject.optInt("show_commented", 0);
            this.V = jSONObject.optString("click_url");
            jSONObject.optString("from");
            this.Z = jSONObject.optInt("collect_status");
            this.a0 = jSONObject.optString("collect_mark_pid");
            this.b0 = jSONObject.optInt("is_voice_thread");
            this.c0 = jSONObject.optInt("thread_type");
            jSONObject.optInt("thread_type");
            this.p1 = jSONObject.optLong("share_num");
            this.k0 = jSONObject.optString("first_post_id", "0");
            this.C0 = jSONObject.optString("post_id", "0");
            jSONObject.optLong("time", 0L);
            this.q = jSONObject.optInt("is_ntitle");
            this.I = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.A0 = jSONObject.optString("tieba_game_information_source", "");
            this.n1.parseJson(jSONObject.optJSONObject("agree"));
            this.n1.threadId = this.D;
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
                this.j1 = sparseArray;
                this.k1 = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.L0.k(optJSONObject2);
            }
            if ((this.S == null || this.S.getUserId() == null) && this.l0 != null) {
                this.S = this.l0.get(this.R);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.o0 = optJSONObject.optString("location");
            }
            jSONObject.optString("label_url");
            this.O2 = jSONObject.optString("mode_url");
            jSONObject.optString("location");
            AlaInfoData alaInfoData = new AlaInfoData();
            this.v0 = alaInfoData;
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
                    this.W.add(mediaData);
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
                    this.X.add(voiceData$VoiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray(com.alipay.sdk.sys.a.o);
            if (optJSONArray5 != null) {
                for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                    b bVar = new b();
                    bVar.h(optJSONArray5.getJSONObject(i7));
                    this.F0.add(bVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                r2 r2Var = new r2();
                this.G0 = r2Var;
                r2Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                i iVar = new i();
                this.H0 = iVar;
                iVar.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                u uVar = new u();
                this.I0 = uVar;
                uVar.c(optJSONObject6);
            }
            this.i0.setUserMap(this.l0);
            this.i0.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.j0.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!c.a.e.e.p.k.isEmpty(this.r)) {
                this.i0.setTitle(this.r);
            } else {
                this.i0.setTitle(this.s);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.L0.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i8 = 0; i8 < optJSONArray6.length(); i8++) {
                    c.a.q0.u.c cVar = new c.a.q0.u.c();
                    cVar.a(optJSONArray6.getJSONObject(i8));
                    this.M0.add(cVar);
                }
            }
            this.T0 = jSONObject.optInt("is_book_chapter", 0);
            this.U0.a(jSONObject.optJSONObject("book_chapter"));
            this.W0 = jSONObject.optString("recom_source");
            this.a1 = jSONObject.optString("recom_reason");
            this.b1 = jSONObject.optString("recom_tag_icon");
            this.X0 = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.Z0 = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            jSONObject.optString("recom_extra_img");
            jSONObject.optString("recom_extra_img_night");
            jSONObject.optInt("recom_extra_img_width", 0);
            jSONObject.optInt("recom_extra_img_height", 0);
            this.c1 = jSONObject.optLong("last_read_pid");
            this.d1 = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                k2 k2Var = new k2();
                this.u0 = k2Var;
                k2Var.a(optJSONObject8);
            }
            this.m1 = jSONObject.optInt("is_multiforum_thread") == 1;
            this.r1 = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.r1 && optJSONObject9 != null) {
                r0 r0Var = new r0();
                this.q1 = r0Var;
                r0Var.g(optJSONObject9);
            }
            this.s1 = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                h hVar = new h();
                this.t1 = hVar;
                hVar.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.u1 = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            jSONObject.optInt("is_called", 0);
            this.v1 = jSONObject.optInt("middle_page_num", 0);
            this.w1 = jSONObject.optInt("middle_page_pass_flag", 0);
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
                this.s0 = builder.build(true);
            }
            boolean z = jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD, 0) == 1;
            this.y1 = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.x1 = originalThreadInfo;
                    originalThreadInfo.o(optJSONObject13);
                } else {
                    this.x1 = null;
                }
            } else {
                this.x1 = null;
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
                this.L1 = builder2.build(false);
            }
            this.T1 = jSONObject.optString("t_share_img");
            this.U1 = jSONObject.optString("nid");
            this.V1 = jSONObject.optInt("is_headlinepost", 0) == 1;
            jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.n2 = jSONObject.optInt("bjh_content_tag");
            this.m2 = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.o2 = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.n1.baijiahaoData = this.o2;
            }
            this.p2 = jSONObject.optInt("is_s_card", 0) == 1;
            this.q2 = jSONObject.optString("scard_packet_id");
            this.r2 = jSONObject.optInt("tab_id");
            this.s2 = jSONObject.optString("tab_name");
            jSONObject.optString("wonderful_post_info");
            this.k2 = jSONObject.optInt("if_comment", 0) == 1;
            this.l2 = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.B2 == null) {
                    this.B2 = new PollData();
                }
                this.B2.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i9 = 0; i9 < optJSONArray7.length(); i9++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i9));
                    if (pbLinkData.urlType == 2 && !this.w2) {
                        this.w2 = true;
                    }
                    this.u2.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i10 = 0; i10 < optJSONArray8.length(); i10++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i10));
                    this.v2.add(pbGoodsData);
                }
                if (this.v2.size() > 0 && !this.w2) {
                    this.w2 = true;
                }
            }
            this.C2 = jSONObject.optInt("hot_num", -1);
            jSONObject.optInt("is_local");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.L2 == null) {
                    this.L2 = new WorksInfoData();
                }
                this.L2.parseJson(optJSONObject17);
            }
            this.M2 = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i11 = 0; i11 < optJSONArray9.length(); i11++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i11));
                    this.N2.add(threadRecommendInfoData);
                }
            }
            z1 z1Var = new z1();
            this.F = z1Var;
            z1Var.e(jSONObject.optJSONObject("forum_info"));
            this.K2 = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.J0 = jSONObject.optString("livecover_src");
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
                this.z1 = optJSONObject18.optString("icon_pic_url");
                this.A1 = optJSONObject18.optString("icon_link");
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("location");
            if (optJSONObject19 != null) {
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LAT))) {
                    this.m0 = optJSONObject19.optString(SuggestAddrField.KEY_LAT);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LNG))) {
                    this.m0 = optJSONObject19.optString(SuggestAddrField.KEY_LNG);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("name"))) {
                    this.m0 = optJSONObject19.optString("name");
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ori_forum_info");
            if (optJSONObject20 != null) {
                OriginalForumInfo originalForumInfo = new OriginalForumInfo();
                originalForumInfo.id = optJSONObject20.optLong("ori_fid") + "";
                originalForumInfo.ori_fname = optJSONObject20.optString("ori_fname");
                originalForumInfo.ori_avatar = optJSONObject20.optString("ori_avatar");
                originalForumInfo.ori_member_num = optJSONObject20.optLong("ori_member_num");
                this.I1 = originalForumInfo;
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
                        if (this.z2 == null) {
                            this.z2 = new ArrayList();
                        }
                        this.z2.add(builder3.build(true));
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
                    builder5.pkg_source = Integer.valueOf(optJSONObject23.optInt("pkg_source"));
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
                    this.x2 = build2;
                    ItemData itemData = new ItemData();
                    this.y2 = itemData;
                    itemData.parseProto(build2);
                }
            }
            this.Q2 = StringHelper.equals(jSONObject.optString("is_tiebaplus_ad"), "1");
            this.R2 = jSONObject.optString("tiebaplus_order_id");
            this.S2 = jSONObject.optString("tiebaplus_token");
            this.T2 = jSONObject.optString("tiebaplus_extra_param");
            this.U2 = jSONObject.optInt("tiebaplus_cant_delete") == 1;
            e3();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void X3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            this.O = i2;
        }
    }

    public z1 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.F : (z1) invokeV.objValue;
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            c.a.r0.j3.i0.o oVar = this.J2;
            if (oVar != null) {
                return oVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Y2(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.m0 = threadInfo.location.lat;
                this.n0 = threadInfo.location.lng;
                this.o0 = threadInfo.location.name;
            }
            this.Y = threadInfo.is_tbread_dispatch.intValue();
            this.A = threadInfo.id + "";
            this.D = threadInfo.tid + "";
            this.E = threadInfo.fid.longValue();
            this.r = threadInfo.title;
            this.x0 = threadInfo.is_god.intValue();
            this.y0 = threadInfo.create_time.intValue() * 1000;
            this.z0 = threadInfo.audit_time.longValue() * 1000;
            this.J = threadInfo.reply_num.intValue();
            threadInfo.repost_num.intValue();
            this.K = threadInfo.view_num.intValue();
            String str = threadInfo.last_time;
            this.L = threadInfo.last_time_int.intValue();
            this.M = threadInfo.is_top.intValue();
            this.N = threadInfo.is_membertop.intValue();
            this.O = threadInfo.is_good.intValue();
            this.P = threadInfo.is_livepost.intValue();
            this.Q.d(threadInfo.topic);
            this.S.parserProtobuf(threadInfo.author);
            this.R = threadInfo.author_id.toString();
            this.T = threadInfo.fname;
            threadInfo.has_commented.intValue();
            this.U = threadInfo.show_commented.intValue();
            this.V = threadInfo.click_url;
            this.s0 = threadInfo.video_info;
            this.t0 = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.v0 = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            String str2 = threadInfo.from;
            this.Z = threadInfo.collect_status.intValue();
            this.a0 = threadInfo.collect_mark_pid;
            this.b0 = threadInfo.is_voice_thread.intValue();
            this.c0 = threadInfo.thread_type.intValue();
            threadInfo.thread_type.intValue();
            this.k0 = threadInfo.first_post_id + "";
            this.C0 = threadInfo.post_id + "";
            threadInfo.time.intValue();
            this.q = threadInfo.is_ntitle.intValue();
            this.p0 = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.n1.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.n1.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.A0 = threadInfo.tieba_game_information_source;
            } else {
                this.A0 = "";
            }
            this.p1 = threadInfo.share_num.longValue();
            this.I = threadInfo.category_name;
            this.q0 = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.V0 = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.t = threadInfo.rich_title;
            this.v = threadInfo.first_post_content;
            this.u = threadInfo.rich_abstract;
            threadInfo.is_godthread_recommend.intValue();
            if ((this.S == null || this.S.getUserId() == null || this.S.getUserId().equals("0") || this.H2) && this.R != null && !this.R.equals("0") && this.l0 != null && (metaData = this.l0.get(this.R)) != null) {
                this.S = metaData;
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
                    this.W.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.s0 = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                k2 k2Var = new k2();
                this.u0 = k2Var;
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
                    this.X.add(voiceData$VoiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    b bVar = new b();
                    bVar.i(list4.get(i6));
                    this.F0.add(bVar);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                r2 r2Var = new r2();
                this.G0 = r2Var;
                r2Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                i iVar = new i();
                this.H0 = iVar;
                iVar.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                u uVar = new u();
                this.I0 = uVar;
                uVar.d(threadInfo.cartoon_info);
            }
            this.i0.setUserMap(this.l0);
            this.i0.parserProtobuf(threadInfo.zan);
            this.j0.parserProtobuf(threadInfo.anchor_info);
            if (!c.a.e.e.p.k.isEmpty(this.r)) {
                this.i0.setTitle(this.r);
            } else {
                this.i0.setTitle(this.s);
            }
            this.J0 = threadInfo.livecover_src;
            threadInfo.storecount.intValue();
            this.D0 = threadInfo.post_num.intValue();
            threadInfo.post_num.intValue();
            threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        if (zhiBoInfoTW.labelInfo.get(i7) != null) {
                            c.a.q0.t.i.c cVar = new c.a.q0.t.i.c();
                            cVar.a(zhiBoInfoTW.labelInfo.get(i7).labelHot.intValue());
                            cVar.b(zhiBoInfoTW.labelInfo.get(i7).labelId);
                            cVar.c(zhiBoInfoTW.labelInfo.get(i7).labelContent);
                            this.r0.add(cVar);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    String str3 = noticeInfo.notice;
                }
                this.K0 = zhiBoInfoTW.copythread_remind.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                zhiBoInfoTW.is_copytwzhibo.intValue();
                if (StringUtils.isNull(this.J0)) {
                    this.J0 = zhiBoInfoTW.livecover_src;
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
                    this.w0 = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            threadInfo.is_copythread.intValue();
            if (threadInfo.task_info != null) {
                this.L0.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i8 = 0; i8 != threadInfo.ext_tails.size(); i8++) {
                    c.a.q0.u.c cVar2 = new c.a.q0.u.c();
                    cVar2.b(threadInfo.ext_tails.get(i8));
                    this.M0.add(cVar2);
                }
            }
            this.N0.parserProtobuf(threadInfo.push_status);
            this.S0 = threadInfo.lego_card;
            this.Q0 = threadInfo.skin_info;
            this.T0 = threadInfo.is_book_chapter.intValue();
            this.U0.b(threadInfo.book_chapter);
            this.W0 = threadInfo.recom_source;
            this.a1 = threadInfo.recom_reason;
            this.b1 = threadInfo.recom_tag_icon;
            this.X0 = threadInfo.recom_weight;
            this.Y0 = threadInfo.ab_tag;
            this.Z0 = threadInfo.recom_extra;
            this.c1 = threadInfo.last_read_pid.longValue();
            this.d1 = threadInfo.cheak_repeat.intValue() == 1;
            List<ReportInfo> list6 = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.o1.c0(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.j1 = sparseArray;
                this.k1 = sparseArray2;
            }
            this.m1 = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.r1 = z;
            if (z && threadInfo.link_info != null) {
                r0 r0Var = new r0();
                this.q1 = r0Var;
                r0Var.h(threadInfo.link_info);
            }
            this.s1 = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                h hVar = new h();
                this.t1 = hVar;
                hVar.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.u1 = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            threadInfo.is_called.intValue();
            this.v1 = threadInfo.middle_page_num.intValue();
            this.w1 = threadInfo.middle_page_pass_flag.intValue();
            this.y1 = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.z1 = threadInfo.star_rank_icon.icon_pic_url;
                this.A1 = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.x1 = originalThreadInfo;
                originalThreadInfo.m(threadInfo.origin_thread_info, this);
            } else {
                this.x1 = null;
                this.y1 = false;
            }
            this.B1 = threadInfo.is_topic.intValue();
            this.D1 = threadInfo.topic_user_name;
            this.E1 = threadInfo.topic_h5_url;
            this.C1 = threadInfo.topic_module;
            String str4 = threadInfo.presentation_style;
            this.I1 = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            String str5 = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                z1 z1Var = new z1();
                this.F = z1Var;
                z1Var.f(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.L1 = threadInfo.swan_info;
            }
            this.T1 = threadInfo.t_share_img;
            this.U1 = threadInfo.nid;
            this.V1 = threadInfo.is_headlinepost.intValue() == 1;
            String str6 = threadInfo.thread_share_link;
            this.m2 = threadInfo.article_cover;
            this.n2 = threadInfo.bjh_content_tag.intValue();
            threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.o2 = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.n1.baijiahaoData = this.o2;
            }
            this.p2 = threadInfo.is_s_card.intValue() == 1;
            this.q2 = threadInfo.scard_packet_id;
            this.r2 = threadInfo.tab_id.intValue();
            this.s2 = threadInfo.tab_name;
            String str7 = threadInfo.wonderful_post_info;
            this.k2 = threadInfo.if_comment.intValue() == 1;
            this.l2 = threadInfo.if_comment_info;
            this.t2 = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.w2) {
                        this.w2 = true;
                    }
                    this.u2.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.v2.add(pbGoodsData);
                }
                if (this.v2.size() > 0 && !this.w2) {
                    this.w2 = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.x2 = threadInfo.item;
            }
            if (this.x2 != null) {
                ItemData itemData = new ItemData();
                this.y2 = itemData;
                itemData.parseProto(this.x2);
            }
            List<HeadItem> list8 = threadInfo.item_star;
            this.z2 = list8;
            if (!ListUtils.isEmpty(list8)) {
                ItemStarData itemStarData = new ItemStarData();
                this.A2 = itemStarData;
                itemStarData.parseProto(this.z2);
            }
            if (threadInfo.poll_info != null) {
                if (this.B2 == null) {
                    this.B2 = new PollData();
                }
                this.B2.parserProtobuf(threadInfo.poll_info);
            }
            this.C2 = threadInfo.hot_num.intValue();
            threadInfo.is_local.intValue();
            this.K2 = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.L2 == null) {
                    this.L2 = new WorksInfoData();
                }
                this.L2.parseProto(threadInfo.works_info);
            }
            this.M2 = threadInfo.collect_num.intValue();
            if (!ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseProto(threadRecommendInfo);
                    this.N2.add(threadRecommendInfoData);
                }
            }
            this.X2 = threadInfo.is_frs_mask.intValue() == 1;
            this.Q2 = StringHelper.equals(threadInfo.is_tiebaplus_ad, "1");
            this.R2 = threadInfo.tiebaplus_order_id;
            this.S2 = threadInfo.tiebaplus_token;
            this.T2 = threadInfo.tiebaplus_extra_param;
            this.U2 = threadInfo.tiebaplus_cant_delete.intValue() == 1;
            e3();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void Y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            this.M = i2;
        }
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    public String Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.T1 : (String) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            MetaData metaData = this.S;
            return (metaData == null || metaData.getGodUserData() == null || this.S.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void Z2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048718, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            a3(z, z2, true);
        }
    }

    public void Z3(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, item) == null) {
            this.x2 = item;
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.l1 : (String) invokeV.objValue;
    }

    public String a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.P1 : (String) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.w2 : invokeV.booleanValue;
    }

    public void a3(boolean z, boolean z2, boolean z4) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048723, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4)}) == null) {
            if (ListUtils.getCount(N0(z, z2, z4, false)) > 0) {
                T2(z, z4);
                return;
            }
            SpannableStringBuilder Q2 = Q2();
            if (z) {
                spannableStringBuilder = g(Q2.toString(), Q2, z, z2, z4, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(Q2);
            }
            this.w = spannableStringBuilder;
        }
    }

    public void a4(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, itemData) == null) {
            this.y2 = itemData;
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.A0 : (String) invokeV.objValue;
    }

    public long b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.p1 : invokeV.longValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.e1 : invokeV.booleanValue;
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            W2(false, true);
        }
    }

    public void b4(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, list) == null) {
            this.z2 = list;
        }
    }

    public List<PbGoodsData> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.v2 : (List) invokeV.objValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.U : invokeV.intValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.c0 == 41 : invokeV.booleanValue;
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            W2(false, false);
        }
    }

    public void c4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048734, this, j2) == null) {
            this.L = j2;
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.n1.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public SkinInfo d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.Q0 : (SkinInfo) invokeV.objValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? j1() != null && o1() == 41 && j0() == 1 && k1() == 2 : invokeV.booleanValue;
    }

    public int d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (!c.a.q0.s.k.c().g() || ListUtils.getCount(E0()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < E0().size(); i2++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(E0(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void d4(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, list) == null) {
            this.u2 = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.u2) {
                if (pbLinkData.urlType == 2 && !this.w2) {
                    this.w2 = true;
                }
            }
        }
    }

    public VideoInfo e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.F1 : (VideoInfo) invokeV.objValue;
    }

    public SmartApp e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.L1 : (SmartApp) invokeV.objValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.r1 : invokeV.booleanValue;
    }

    public void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            p3();
            h3();
            n3();
            o3();
            f3();
            l3();
            m3();
        }
    }

    public void e4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z) == null) {
            Y3(z ? 1 : 0);
        }
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.i1 : invokeV.intValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? this.c0 == 41 : invokeV.booleanValue;
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            this.y = L2();
        }
    }

    public void f4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, str) == null) {
            this.a0 = str;
        }
    }

    public final SpannableStringBuilder g(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048750, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            ArrayList<m.a> N0 = N0(z, z2, z4, z5);
            if (N0 == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h2 = c.a.r0.a0.m.h(TbadkCoreApplication.getInst(), str, N0, false);
            if (N0.size() > 0) {
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
            } else if (N0.size() > 0 || h2.length() == 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            int[] iArr = new int[2];
            int size = View.MeasureSpec.getSize(c.a.e.e.p.l.p(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i12 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> E0 = E0();
            if (c.a.q0.s.k.c().g() && ListUtils.getCount(E0) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i13 = 0; i13 < E0.size(); i13++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(E0, i13);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(E0, 0);
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
            c.a.q0.b.g.b.k(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public SpannableStringBuilder g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.w : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? o1() == 50 : invokeV.booleanValue;
    }

    public final void g3() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048754, this) == null) || (alaInfoData = this.v0) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j2 = this.y0;
            if (j2 > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j2);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.O1 = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.v0;
        if (alaInfoData2.openRecomFans == 1) {
            int i2 = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i2 = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.O1) || i2 <= 0) {
                if (i2 > 0) {
                    this.O1 = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
                    return;
                }
                return;
            }
            this.O1 += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i2);
        }
    }

    public void g4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
            this.G1 = z;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            ArrayList<MediaData> E0 = E0();
            if (E0 == null || A2()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < E0.size() && i2 < 3; i2++) {
                if (E0.get(i2) != null && E0.get(i2).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(E0.get(i2).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = E0.get(i2).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = E0.get(i2).getPicUrl();
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
            VideoInfo videoInfo = this.s0;
            if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.imgUrl = this.s0.thumbnail_url;
                preLoadImageInfo2.procType = 10;
                preLoadImageInfo2.preloadType = 1;
                arrayList.add(preLoadImageInfo2);
            }
            if (this.S != null) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.S.getPortrait();
                preLoadImageInfo3.procType = 28;
                preLoadImageInfo3.preloadType = 3;
                arrayList.add(preLoadImageInfo3);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            SparseArray<String> sparseArray = this.j1;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            x0 x0Var = new x0();
            getThreadData();
            x0Var.p(s1());
            getThreadData();
            x0Var.l(T());
            getThreadData();
            x0Var.o(F0());
            x0Var.k(this.j1);
            x0Var.f14351g = this.k1;
            x0Var.p = this.Y0;
            x0Var.k = this.X0;
            x0Var.m = this.Z0;
            x0Var.l = this.W0;
            x0Var.q = this.S1;
            x0Var.o = Q0();
            return x0Var;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) ? this.a1 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this : (d2) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            c.a.r0.j3.i0.o oVar = this.J2;
            if (oVar != null) {
                return oVar.f() ? this.J2.g() ? AdvertAppInfo.A4 : AdvertAppInfo.B4 : this.J2.g() ? AdvertAppInfo.A4 : AdvertAppInfo.z4;
            } else if (i0()) {
                if (q1() != null) {
                    return w3;
                }
                return Z2;
            } else {
                int r0 = r0();
                if (this.B1 == 1) {
                    if (this.C1 != null) {
                        return n3;
                    }
                    return this.F1 != null ? H3 : G3;
                } else if (this.v0 != null && this.c0 == 60) {
                    return z3;
                } else {
                    if (this.v0 != null && ((i2 = this.c0) == 49 || i2 == 69)) {
                        return x3;
                    }
                    if (this.v0 != null && this.c0 == 67) {
                        return A3;
                    }
                    int i4 = this.c0;
                    if (i4 == 51) {
                        return y3;
                    }
                    if (i4 == 63) {
                        return I3;
                    }
                    if (i4 == 64) {
                        return J3;
                    }
                    if (r0 != 2 && r0 != 1) {
                        if (this.s0 != null && b2() && !f2()) {
                            return O3;
                        }
                        if (this.s0 != null && !f2()) {
                            if (Z1()) {
                                return F3;
                            }
                            if (this instanceof y0) {
                                return P3;
                            }
                            return w3;
                        } else if (this.y1 && (originalThreadInfo = this.x1) != null) {
                            if (originalThreadInfo.w) {
                                if (originalThreadInfo.r != null) {
                                    return E3;
                                }
                                if (originalThreadInfo.f()) {
                                    return D3;
                                }
                                return C3;
                            }
                            return B3;
                        } else if (M1()) {
                            return o3;
                        } else {
                            if (d2()) {
                                return L3.get() ? S3 : Z2;
                            } else if (I1() && w() == 1) {
                                return L3.get() ? T3 : Z2;
                            } else if (e2()) {
                                return u3;
                            } else {
                                if (Z1()) {
                                    return v3;
                                }
                                if (this.f14136e) {
                                    return f3;
                                }
                                if (this.f14137f) {
                                    return g3;
                                }
                                if (this.f14138g) {
                                    return h3;
                                }
                                if (this.f14139h) {
                                    return i3;
                                }
                                if (this.f14140i) {
                                    return j3;
                                }
                                if (this.k) {
                                    return l3;
                                }
                                if (this.l) {
                                    return m3;
                                }
                                if (this.f14141j) {
                                    return k3;
                                }
                                if (this.m) {
                                    return q3;
                                }
                                if (this.E0) {
                                    int d32 = d3();
                                    if (d32 == 1) {
                                        return b3;
                                    }
                                    if (d32 == 2) {
                                        return c3;
                                    }
                                    if (d32 > 2) {
                                        return d3;
                                    }
                                    return Z2;
                                }
                                return Z2;
                            }
                        }
                    }
                    return Y2;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            VideoInfo videoInfo = this.s0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.f1 : invokeV.intValue;
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.r2 : invokeV.intValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? o1() == 49 || o1() == 69 : invokeV.booleanValue;
    }

    public final void h3() {
        MetaData metaData;
        MetaData metaData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            if ((this instanceof y0) && "0".equals(f0())) {
                this.O1 = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
                return;
            }
            if (!D2() && (!X1() || getType() == x3)) {
                if (getType() != x3 && getType() != A3) {
                    long v0 = v0() * 1000;
                    if (v0 != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(v0);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(v0);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(v0);
                        }
                        this.O1 = string + formatTimeForJustNow;
                    } else {
                        long j2 = this.y0;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j2);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j2);
                        }
                        this.O1 = formatTimeForJustNow2;
                    }
                    if (n2()) {
                        j3();
                    } else if (u2()) {
                        i3();
                    } else if (!this.Z1 && (metaData2 = this.S) != null && metaData2.showBazhuGrade()) {
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.S.getBazhuGradeData().getDesc(), this.Y1 ? 24 : 16, "...");
                        if (!TextUtils.isEmpty(this.O1)) {
                            this.O1 += "   " + cutChineseAndEnglishWithSuffix;
                        } else {
                            this.O1 = cutChineseAndEnglishWithSuffix;
                        }
                    }
                    if (TextUtils.isEmpty(this.O1) || TextUtils.isEmpty(A())) {
                        return;
                    }
                    this.O1 += " • " + A();
                    return;
                }
                g3();
                return;
            }
            long j4 = this.y0;
            if (j4 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j4);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j4);
                }
                this.O1 = formatTimeForJustNow3;
            }
            MetaData metaData3 = this.S;
            String str = (metaData3 == null || metaData3.getBaijiahaoInfo() == null || TextUtils.isEmpty(this.S.getBaijiahaoInfo().auth_desc)) ? "" : this.S.getBaijiahaoInfo().auth_desc;
            if (n2()) {
                j3();
            } else if (!this.Z1 && (metaData = this.S) != null && metaData.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = StringHelper.cutChineseAndEnglishWithSuffix(this.S.getBazhuGradeData().getDesc(), 24, "...");
                if (!TextUtils.isEmpty(this.O1)) {
                    this.O1 += "   " + cutChineseAndEnglishWithSuffix2;
                    return;
                }
                this.O1 = cutChineseAndEnglishWithSuffix2;
            } else if (!TextUtils.isEmpty(this.O1) && !TextUtils.isEmpty(str)) {
                this.O1 += "   " + str;
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.O1 = str;
            }
        }
    }

    public void h4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
            this.H1 = z;
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? this.K1 : invokeV.booleanValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? this.s2 : (String) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? r0() == 1 : invokeV.booleanValue;
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048772, this) == null) || StringUtils.isNull(this.T)) {
            return;
        }
        this.O1 = (StringHelper.cutChineseAndEnglishWithSuffix(this.T, 12, "...") + TbadkCoreApplication.getInst().getContext().getString(R.string.forum)) + GlideException.IndentedAppendable.INDENT + this.O1;
    }

    public void i4(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, arrayList) == null) {
            this.W = arrayList;
        }
    }

    @Override // c.a.q0.s.q.a
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) ? this.Y1 : invokeV.booleanValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.P : invokeV.intValue;
    }

    public b2 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.L0 : (b2) invokeV.objValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) ? this.G1 : invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && n2() && !TextUtils.isEmpty(this.S.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.O1)) {
                this.O1 += "   " + this.S.getNewGodData().getFieldName() + c.a.q0.d1.r0.d(this.S.getNewGodData().isVideoGod());
                return;
            }
            this.O1 = this.S.getNewGodData().getFieldName() + c.a.q0.d1.r0.d(this.S.getNewGodData().isVideoGod());
        }
    }

    public void j4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, str) == null) {
            this.o = str;
        }
    }

    public SpannableString k(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048780, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            c.a.q0.s.f0.k kVar = new c.a.q0.s.f0.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String p = c.a.q0.s.d0.b.j().p("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this.B : invokeV.intValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            b2 b2Var = this.L0;
            if (b2Var != null) {
                long e2 = b2Var.e();
                long a2 = this.L0.a();
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

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) ? this.H1 : invokeV.booleanValue;
    }

    public void k3() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048784, this) == null) || D2() || X1()) {
            return;
        }
        long v0 = v0() * 1000;
        if (v0 != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(v0);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(v0);
            }
            this.O1 = formatTimeForJustNow;
        }
        if (n2()) {
            j3();
        } else if (!this.Z1 && (metaData = this.S) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.S.getBazhuGradeData().getDesc(), 24, "...");
            if (!TextUtils.isEmpty(this.O1)) {
                this.O1 += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.O1 = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.O1) || TextUtils.isEmpty(A())) {
            return;
        }
        this.O1 += " • " + A();
    }

    public void k4(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, pollData) == null) {
            this.B2 = pollData;
        }
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) ? this.Z : invokeV.intValue;
    }

    public AlaInfoData l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) ? this.v0 : (AlaInfoData) invokeV.objValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? this.m1 : invokeV.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.Q1 = StringHelper.getFormatTimeShort(v0() * 1000);
        }
    }

    public void l4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048790, this, i2) == null) {
            this.P2 = i2;
        }
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.N : invokeV.intValue;
    }

    public String m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? this.O1 : (String) invokeV.objValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? this.d1 : invokeV.booleanValue;
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            this.R1 = StringHelper.getFormatTimeShort(v0());
        }
    }

    public void m4(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, praiseData) == null) {
            this.i0 = praiseData;
        }
    }

    public int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) ? this.q : invokeV.intValue;
    }

    public List<ThreadRecommendInfoData> n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? this.N2 : (List) invokeV.objValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) {
            MetaData metaData = this.S;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            if (l1() != null && l1().share_info != null && l1().share_info.share_user_count > 0 && t2() && (this.v1 <= 0 || this.w1 != 0)) {
                int i2 = l1().share_info.share_user_count;
                if (i2 == 1) {
                    this.P1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.P1 = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)});
                    return;
                }
            }
            this.P1 = null;
        }
    }

    public void n4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048800, this, i2) == null) {
            this.J = i2;
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public int o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) ? this.c0 : invokeV.intValue;
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) ? this.c0 == 0 : invokeV.booleanValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048805, this) == null) {
            SpannableStringBuilder S2 = S2();
            this.x = S2;
            c.a.r0.a0.m.b(this, S2, true);
        }
    }

    public void o4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048806, this, i2) == null) {
            this.n = i2;
        }
    }

    public SpannableString p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) ? this.y : (SpannableString) invokeV.objValue;
    }

    public int p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? this.C : invokeV.intValue;
    }

    public k2 p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) ? this.u0 : (k2) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) ? this.c0 == 31 : invokeV.booleanValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048811, this) == null) || StringUtils.isNull(this.S.getName_show())) {
            return;
        }
        this.N1 = StringHelper.cutChineseAndEnglishWithSuffix(this.S.getName_show(), 12, "...");
    }

    public void p4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, list) == null) {
            this.u = list;
        }
    }

    public ArrayList<b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? this.F0 : (ArrayList) invokeV.objValue;
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) ? this.O : invokeV.intValue;
    }

    public VideoInfo q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) ? this.s0 : (VideoInfo) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) ? this.x0 == 1 : invokeV.booleanValue;
    }

    public void q3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, str) == null) {
            this.s = str;
        }
    }

    public void q4(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, list) == null) {
            this.t = list;
        }
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048819, this)) == null) ? this.M : invokeV.intValue;
    }

    public VideoDesc r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) ? this.t0 : (VideoDesc) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) ? o1() == 40 : invokeV.booleanValue;
    }

    public void r3(ArrayList<b> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, arrayList) == null) {
            this.F0 = arrayList;
        }
    }

    public void r4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.H = str;
        }
    }

    public Item s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048824, this)) == null) ? this.x2 : (Item) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048825, this)) == null) {
            if (!StringUtils.isNull(this.D) && !"0".equals(this.D)) {
                return this.D;
            }
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? (s0() == null && ((originalThreadInfo = this.x1) == null || originalThreadInfo.B == null)) ? false : true : invokeV.booleanValue;
    }

    public void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048827, this, z) == null) {
            X3(z ? 1 : 0);
        }
    }

    public void s4(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048828, this, j2) == null) {
            this.p1 = j2;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048829, this)) == null) {
            if (!I1() || this.F0.size() < 1) {
                return -1;
            }
            b bVar = this.F0.get(0);
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

    public List<HeadItem> t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? this.z2 : (List) invokeV.objValue;
    }

    @Nullable
    public List<c.a.q0.f1.o.a> t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) ? this.z : (List) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048832, this)) == null) ? o1() == 60 : invokeV.booleanValue;
    }

    public void t3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048833, this, i2) == null) {
            this.n1.agreeNum = i2;
        }
    }

    public void t4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048834, this, z) == null) {
            this.M1 = z;
        }
    }

    public long u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) ? this.c1 : invokeV.longValue;
    }

    public SpannableStringBuilder u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) ? this.x : (SpannableStringBuilder) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) ? I2() && !StringUtils.isNull(this.T) && this.Z1 : invokeV.booleanValue;
    }

    public void u3(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048838, this, j2) == null) {
            this.n1.agreeNum = j2;
        }
    }

    public void u4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048839, this, i2) == null) {
            this.i1 = i2;
        }
    }

    public long v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) ? this.L : invokeV.longValue;
    }

    public PostData v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) ? this.o1 : (PostData) invokeV.objValue;
    }

    public boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) ? this.M1 : invokeV.booleanValue;
    }

    public void v3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048843, this, i2) == null) {
            this.n1.agreeType = i2;
        }
    }

    public void v4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048844, this, i2) == null) {
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048845, this)) == null) {
            if (!I1() || this.F0.size() < 1 || this.F0.get(0) == null) {
                return -1;
            }
            return this.F0.get(0).a();
        }
        return invokeV.intValue;
    }

    public String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public h2 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) ? this.Q : (h2) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048848, this)) == null) {
            int i2 = this.c0;
            return i2 == 63 || i2 == 64;
        }
        return invokeV.booleanValue;
    }

    public void w3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048849, this, i2) == null) {
            this.w0 = i2;
        }
    }

    public void w4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048850, this, str, str2) == null) {
            this.O0 = str;
            this.P0 = str2;
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048851, this)) == null) ? (!I1() || this.F0.size() < 1 || this.F0.get(0) == null) ? "" : this.F0.get(0).g() : (String) invokeV.objValue;
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) ? this.O0 : (String) invokeV.objValue;
    }

    public TopicModule x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) ? this.C1 : (TopicModule) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048854, this)) == null) ? this.X1 : invokeV.booleanValue;
    }

    public void x3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048855, this, str) == null) {
            this.m2 = str;
        }
    }

    public void x4(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, alaInfoData) == null) {
            this.v0 = alaInfoData;
        }
    }

    public ActivityItemData y() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048857, this)) == null) {
            List<PbContent> list = this.t;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent = this.t.get(i2);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && E2() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = c.a.q0.t0.b.d(pbContent.text);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048858, this)) == null) ? this.S0 : (String) invokeV.objValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048859, this)) == null) ? this.E1 : (String) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048860, this)) == null) ? this.Y == 1 : invokeV.booleanValue;
    }

    public void y3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, metaData) == null) {
            this.S = metaData;
        }
    }

    public void y4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, str) == null) {
            this.O1 = str;
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048863, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public String z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048864, this)) == null) ? this.N1 : (String) invokeV.objValue;
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) ? this.D1 : (String) invokeV.objValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048866, this)) == null) ? this.Q2 || this.U2 : invokeV.booleanValue;
    }

    public void z3(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048867, this, baijiahaoData) == null) {
            this.o2 = baijiahaoData;
        }
    }

    public void z4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048868, this, i2) == null) {
            this.c0 = i2;
        }
    }
}
