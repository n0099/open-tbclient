package c.a.s0.s2.r;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.b1;
import c.a.r0.s.r.d2;
import c.a.r0.s.r.e1;
import c.a.r0.s.r.f1;
import c.a.r0.s.r.z1;
import c.a.s0.s2.u.f.h0;
import c.a.s0.s2.u.f.z;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.BusinessAccountData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.App;
import tbclient.Baijiahao;
import tbclient.ForumRuleStatus;
import tbclient.ManagerElection;
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.FloatingIcon;
import tbclient.PbPage.FloatingIconItem;
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h0 A;
    public List<MuteUser> B;
    public f1 C;
    public List<d2> D;
    public AlaLiveInfoCoreData E;
    public ArrayList<c.a.s0.v3.j0.p> F;
    public c.a.s0.v3.j0.p G;
    public TwzhiboAnti H;
    public List<z1> I;
    public List<z1> J;
    public w K;
    public PostData L;
    public j M;
    public long N;
    public r O;
    public String P;
    public String Q;
    public List<RecommendTopicData.RecommendTopicListData> R;
    public HashSet<String> S;
    public List<c.a.r0.s.r.q> T;
    public int U;
    public c.a.s0.s2.y.i.a V;
    public PostData W;
    public boolean X;
    public PostData Y;
    public int Z;
    public final UserData a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public String f22522b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f22523c;
    public List<c.a.s0.v3.j0.p> c0;

    /* renamed from: d  reason: collision with root package name */
    public int f22524d;
    public c.a.s0.s2.u.f.x d0;

    /* renamed from: e  reason: collision with root package name */
    public int f22525e;
    public z e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f22526f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public int f22527g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public m f22528h;
    public List<ThreadInfo> h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22529i;
    public ForumRuleStatus i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22530j;
    public BusinessAccountData j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22531k;
    public boolean k0;
    public a l;
    public boolean l0;
    public boolean m;
    public int m0;
    public ForumData n;
    public boolean n0;
    public z1 o;
    public boolean o0;
    public d2 p;
    public boolean p0;
    public ArrayList<PostData> q;
    public c.a.r0.t.c.g q0;
    public HashMap<String, MetaData> r;
    public int r0;
    public b1 s;
    public List<c.a.d.m.e.n> s0;
    public AntiData t;
    public boolean t0;
    public c.a.r0.u.g u;
    public int v;
    public int w;
    public int x;
    public String y;
    public e1 z;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22529i = false;
        this.f22530j = false;
        this.f22531k = false;
        this.m = false;
        this.w = 0;
        this.F = new ArrayList<>();
        this.G = null;
        this.H = null;
        this.U = 0;
        this.X = true;
        this.Z = 0;
        this.b0 = 0;
        this.c0 = new ArrayList();
        this.l0 = false;
        this.m0 = 0;
        this.r0 = 0;
        this.t0 = false;
        this.n = new ForumData();
        this.o = new z1();
        this.p = new d2();
        this.q = new ArrayList<>();
        this.r = new HashMap<>();
        this.s = new b1();
        this.t = new AntiData();
        this.u = new c.a.r0.u.g();
        this.v = 0;
        this.w = 0;
        this.a = new UserData();
        this.B = new ArrayList();
        this.z = new e1();
        this.C = new f1();
        this.A = new h0();
        this.H = new TwzhiboAnti();
        this.K = new w();
        this.d0 = new c.a.s0.s2.u.f.x();
        this.R = new ArrayList();
        this.S = new HashSet<>();
        this.q0 = new c.a.r0.t.c.g();
    }

    public j A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.M : (j) invokeV.objValue;
    }

    public void A0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) {
            this.W = postData;
            this.Y = postData;
            this.X = false;
        }
    }

    public c.a.s0.s2.u.f.x B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.s2.u.f.x xVar = this.d0;
            if (xVar == null || !xVar.isValid()) {
                return null;
            }
            return this.d0;
        }
        return (c.a.s0.s2.u.f.x) invokeV.objValue;
    }

    public void B0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postData) == null) {
            this.Y = postData;
        }
    }

    public z C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            z zVar = this.e0;
            if (zVar == null || !zVar.isValid()) {
                return null;
            }
            return this.e0;
        }
        return (z) invokeV.objValue;
    }

    public void C0(boolean z) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (d2Var = this.p) == null) {
            return;
        }
        if (z) {
            d2Var.X3(1);
        } else {
            d2Var.X3(0);
        }
    }

    public h0 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (h0) invokeV.objValue;
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.w = i2;
        }
    }

    public f1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (f1) invokeV.objValue;
    }

    public void E0(String str) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (d2Var = this.p) == null) {
            return;
        }
        d2Var.j4(str);
    }

    public ArrayList<PostData> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void F0(b1 b1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, b1Var, i2) == null) {
            this.s.k(b1Var.a());
            this.s.p(b1Var.g());
            this.s.q(b1Var.h());
            this.s.o(b1Var.e());
            this.s.n(b1Var.d());
            if (i2 == 0) {
                this.s = b1Var;
            } else if (i2 == 1) {
                this.s.l(b1Var.b());
            } else if (i2 == 2) {
                this.s.m(b1Var.c());
            }
        }
    }

    public c.a.s0.s2.y.i.a G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.V : (c.a.s0.s2.y.i.a) invokeV.objValue;
    }

    public void G0(c.a.s0.v3.j0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.G = pVar;
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m0 : invokeV.intValue;
    }

    public void H0(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rVar) == null) {
            this.O = rVar;
        }
    }

    public List<ThreadInfo> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h0 : (List) invokeV.objValue;
    }

    public void I0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.m0 = i2;
        }
    }

    public AlaLiveInfoCoreData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public void J0(int i2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (antiData = this.t) == null) {
            return;
        }
        antiData.replyPrivateFlag = i2;
    }

    public List<d2> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public void K0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, d2Var) == null) {
            this.p = d2Var;
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AntiData antiData = this.t;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void L0(List<c.a.d.m.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.s0 = list;
        }
    }

    public String[] M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? N(true) : (String[]) invokeV.objValue;
    }

    public PostData M0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, postData)) == null) {
            this.L = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public String[] N(boolean z) {
        InterceptResult invokeZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            String str = "";
            if (q0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (O() != null && O().J() != null && !c.a.d.f.p.l.isEmpty(O().J().getUserId())) {
                    String userId = O().J().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.t() != null && !c.a.d.f.p.l.isEmpty(i2.t().getUserId())) {
                        r2 = StringHelper.equals(userId, i2.t().getUserId()) ? i2.z() : null;
                        if (c.a.d.f.p.l.isEmpty("")) {
                            str = i2.S();
                        }
                    }
                    if (c.a.d.f.p.l.isEmpty(str) && c.a.d.f.p.l.isEmpty(r2)) {
                        for (int i3 = 0; i3 < size; i3++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                            if (postData != null && postData.t() != null && !c.a.d.f.p.l.isEmpty(postData.t().getUserId()) && StringHelper.equals(userId, postData.t().getUserId())) {
                                if (c.a.d.f.p.l.isEmpty(r2)) {
                                    r2 = postData.z();
                                }
                                if (c.a.d.f.p.l.isEmpty(str)) {
                                    str = postData.S();
                                }
                                if (!c.a.d.f.p.l.isEmpty(r2) && !c.a.d.f.p.l.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && c.a.d.f.p.l.isEmpty(r2)) {
                        r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    d2 d2Var = this.p;
                    if (d2Var != null && d2Var.E() != null && this.p.E().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(c.a.s0.s2.l.photo_live_tips) + "] " + str;
                    }
                    d2 d2Var2 = this.p;
                    if (d2Var2 != null && d2Var2.t1() != null && !c.a.d.f.p.l.isEmpty(this.p.t1().thumbnail_url)) {
                        r2 = this.p.t1().thumbnail_url;
                    }
                    d2 d2Var3 = this.p;
                    if (d2Var3 != null && !d2Var3.B1 && r2 == null && (originalThreadInfo = d2Var3.A1) != null && (arrayList = originalThreadInfo.f41397h) != null) {
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                break;
                            }
                            MediaData mediaData = arrayList.get(i4);
                            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                    r2 = mediaData.getThumbnails_url();
                                    break;
                                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                    r2 = mediaData.getPicUrl();
                                    break;
                                }
                            }
                            i4++;
                        }
                    }
                } else {
                    return new String[]{null, ""};
                }
            }
            return new String[]{r2, str};
        }
        return (String[]) invokeZ.objValue;
    }

    public void N0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f22522b = str;
        }
    }

    public d2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (d2) invokeV.objValue;
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.N : invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            d2 d2Var = this.p;
            return d2Var != null ? d2Var.g0() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<c.a.d.m.e.n> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s0 : (List) invokeV.objValue;
    }

    public r S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.O : (r) invokeV.objValue;
    }

    public w T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.K : (w) invokeV.objValue;
    }

    public UserData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a : (UserData) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.v : invokeV.intValue;
    }

    public PostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.L : (PostData) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f22522b : (String) invokeV.objValue;
    }

    public List<c.a.s0.v3.j0.p> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.c0 : (List) invokeV.objValue;
    }

    public c.a.r0.t.c.g Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.q0 : (c.a.r0.t.c.g) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d0 = null;
            this.e0 = null;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            b1 b1Var = this.s;
            return b1Var != null && b1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.G.getAdvertAppInfo() != null) {
                this.G.getAdvertAppInfo().l4 = null;
            }
            this.G = null;
        }
    }

    public final void b0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dataRes) == null) {
            this.O = new r(this.p, this.t);
            String str = dataRes.partial_visible_toast;
            PbFollowTip pbFollowTip = dataRes.follow_tip;
            if (pbFollowTip != null && pbFollowTip.is_toast_tip.intValue() == 1) {
                String str2 = dataRes.follow_tip.tip_text;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            this.E = alaLiveInfoCoreData;
            AlaLiveInfo alaLiveInfo = dataRes.ala_info;
            if (alaLiveInfo != null) {
                alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
            }
            this.P = dataRes.fold_tip;
            this.f22524d = dataRes.exp_news_today.intValue();
            this.f22525e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i2));
                    this.R.add(recommendTopicListData);
                }
            }
            this.f22526f = dataRes.pb_sort_info;
            this.f22527g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.f22528h = m.i(managerElection);
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            List<PbSortType> list = this.f22526f;
            if (list == null || list.size() <= this.f22527g) {
                return "";
            }
            for (int i2 = 0; i2 < this.f22526f.size(); i2++) {
                if (this.f22526f.get(i2).sort_type.intValue() == this.f22527g) {
                    return this.f22526f.get(i2).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void c0(DataRes dataRes) {
        List<Post> list;
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, dataRes) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.S.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.D0(this.r);
                postData.o0(this.n.isBrandForum);
                postData.h0(post, O());
                postData.x0(O().M0());
                postData.n0(dataRes.forum.id.longValue());
                if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().L() != null) {
                    postData.q().baijiahaoData = O().L();
                }
                this.S.add(postData.G());
                if (postData.A() == 1 && this.p.L1()) {
                    if (m0()) {
                        postData.w0(0);
                    } else {
                        postData.w0(this.p.w());
                    }
                } else if (postData.A() == 1 && this.p.f2()) {
                    postData.w0(41);
                } else if (postData.A() == 1 && (d2Var = this.p) != null && d2Var.H2()) {
                    postData.w0(0);
                    postData.X();
                    if (this.p.Y0() != null && this.p.Y0().size() != 0) {
                        postData.y0(new TbRichText(this.p.Y0(), this.p.v1(), true));
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", 0);
                            jSONObject.put("text", "");
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        postData.y0(TbRichTextView.parse(jSONArray, false));
                    }
                    this.L = postData;
                }
                if (postData.A() == 1 && (d2Var2 = this.p) != null && d2Var2.B1) {
                    postData.v0(d2Var2.A1);
                }
                if (postData.A() == 1) {
                    this.Y = postData;
                    this.X = false;
                    if (postData.t() != null && this.j0 != null) {
                        postData.t().setBusinessAccountData(this.j0);
                    }
                }
                this.q.add(postData);
            }
        }
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.t : (AntiData) invokeV.objValue;
    }

    public final void d0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
            return;
        }
        List<ThreadInfo> list2 = dataRes.feed_thread_list;
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.clear();
        for (ThreadInfo threadInfo : list2) {
            if (threadInfo != null) {
                d2 d2Var = new d2();
                d2Var.c3(threadInfo);
                this.D.add(d2Var);
            }
        }
        List<d2> list3 = this.D;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.D = ListUtils.subList(this.D, 0, 15);
    }

    public ArrayList<c.a.s0.v3.j0.p> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.F : (ArrayList) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public List<c.a.r0.s.r.q> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.T : (List) invokeV.objValue;
    }

    public final boolean f0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (d2Var = this.p) == null || d2Var.L() == null || this.p.L().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.L().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.U : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? O() != null && O().G2() : invokeV.booleanValue;
    }

    public z1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.o : (z1) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.k0 : invokeV.booleanValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.Y : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.W : (PostData) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? O() != null && O().s2() : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            d2 d2Var = this.p;
            return (d2Var == null || d2Var.q() == null || this.p.q().size() <= 0 || this.p.q().get(0) == null || !this.p.q().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    public ForumRuleStatus o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.i0 : (ForumRuleStatus) invokeV.objValue;
    }

    public boolean o0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) ? (this.x == 2 && z) || this.x == 1 : invokeZ.booleanValue;
    }

    public List<z1> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public final boolean p0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return Q().equals(threadInfo.id) || Q().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public CardHListViewData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.f22523c : (CardHListViewData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.p.m0() != 0 : invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? (O() == null || !O().H2() || O().t1() == null) ? false : true : invokeV.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w : invokeV.intValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? (O() == null || O().P2 == null || !O().P2.isWorks) ? false : true : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.r0 == 1 : invokeV.booleanValue;
    }

    public final void t0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, dataRes) == null) {
            this.x = dataRes.pb_notice_type.intValue();
            this.y = dataRes.pb_notice;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            d2 d2Var = this.p;
            if (d2Var != null) {
                return d2Var.E0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void u0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, dataRes) == null) {
            c.a.s0.v3.j0.p pVar = new c.a.s0.v3.j0.p();
            pVar.I0 = true;
            App app = dataRes.banner_list.pb_banner_ad;
            App c2 = c.a.s0.j3.y.q().c(app, Cmatch.PB_BANNER);
            if (c2 != null && !this.l0 && !c.a.s0.j3.a.j(c2, dataRes.banner_list)) {
                pVar.Q0 = true;
                this.l0 = true;
                app = c2;
            }
            pVar.N0(app);
            this.G = pVar;
        }
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public final void v0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.c0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                c.a.s0.v3.j0.p pVar = new c.a.s0.v3.j0.p();
                pVar.O0 = r0();
                pVar.N0(app);
                if (!this.c0.contains(pVar)) {
                    this.c0.add(pVar);
                }
            }
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public void w0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, floatingIcon) == null) || floatingIcon == null || (floatingIconItem = floatingIcon.pbpage) == null) {
            return;
        }
        c.a.r0.t.c.g gVar = this.q0;
        gVar.f13677f = floatingIconItem.icon_url;
        gVar.f13678g = floatingIconItem.fold_lottie;
        gVar.f13679h = floatingIconItem.unfold_lottie;
        gVar.f13680i = floatingIconItem.float_type;
        gVar.f13681j = floatingIconItem.fold_name;
        gVar.f13682k = floatingIconItem.unfold_name;
        gVar.f13676e = floatingIconItem.url;
        gVar.n = floatingIconItem.scheme;
        gVar.o = floatingIconItem.package_name;
        gVar.p = floatingIconItem.deeplink;
        gVar.l = floatingIconItem.view_statistics_url;
        gVar.m = floatingIconItem.click_statistics_url;
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public void x0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            c.a.s0.j3.j0.a.e().h(dataRes.asp_shown_info);
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i2));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.r.put(metaData.getUserId(), metaData);
                    }
                    if (i2 == 0) {
                        this.j0 = metaData.getBusinessAccountData();
                    }
                }
            }
            D0(dataRes.is_new_url.intValue());
            t0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.f(dataRes.display_forum);
            this.p.I4(this.r);
            this.p.c3(dataRes.thread);
            if (this.p.U() == 0) {
                this.p.I3(dataRes.forum.id.longValue());
            }
            if (this.p.J() != null && this.p.J().getBusinessAccountData() == null) {
                this.p.J().setBusinessAccountData(this.j0);
            }
            this.z.a(dataRes.news_info);
            int i3 = this.z.f13300c;
            if (i3 == 1) {
                this.A.H0 = this.z;
            } else if (i3 == 2) {
                this.A.I0 = this.z;
            } else if (i3 != 3) {
                this.A.I0 = this.z;
            } else {
                this.A.J0 = this.z;
            }
            this.C.J0(dataRes.recommend_book);
            c0(dataRes);
            PostData postData = new PostData();
            this.W = postData;
            postData.m0(1);
            this.W.D0(this.r);
            this.W.o0(this.n.isBrandForum);
            this.W.B0(this.p.P());
            this.W.n0(dataRes.forum.id.longValue());
            if (dataRes.first_floor_post != null) {
                this.W.g0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.B1) {
                this.W.v0(this.p.A1);
            }
            if (this.Y == null) {
                this.Y = this.W;
                this.X = true;
            }
            this.s.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.t0 = true;
            }
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.B.add(muteUser);
                    }
                }
            }
            this.p.r4(this.p.V0() > 0 ? this.p.V0() - 1 : 0);
            List<AdvertAppInfo> h2 = c.a.s0.j3.y.q().h();
            if (h2 != null) {
                h2.clear();
            }
            String str = null;
            this.G = null;
            this.l0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                u0(dataRes);
                for (App app : list2) {
                    c.a.s0.v3.j0.p pVar = new c.a.s0.v3.j0.p();
                    pVar.O0 = r0();
                    App c2 = c.a.s0.j3.y.q().c(app, r0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.l0 && !c.a.s0.j3.a.j(c2, dataRes.banner_list)) {
                        pVar.Q0 = true;
                        this.l0 = true;
                        app = c2;
                    }
                    pVar.N0(app);
                    if (!this.F.contains(pVar)) {
                        this.F.add(pVar);
                        if (h2 != null) {
                            h2.add(pVar.getAdvertAppInfo());
                        }
                    }
                }
                v0(dataRes);
            }
            c.a.s0.j3.y.q().g();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.H.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                j jVar = new j();
                this.M = jVar;
                jVar.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.f22523c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            d0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.I == null) {
                    this.I = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    z1 z1Var = new z1();
                    z1Var.f(simpleForum);
                    this.I.add(z1Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        z1 z1Var2 = new z1();
                        z1Var2.f(simpleForum2);
                        this.J.add(z1Var2);
                    }
                }
            }
            this.Q = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            b0(dataRes);
            if (this.T == null) {
                this.T = new ArrayList();
            }
            this.T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !p0(threadInfo) && !f0(threadInfo)) {
                        c.a.r0.s.r.q qVar = new c.a.r0.s.r.q();
                        qVar.X4(i4);
                        qVar.c3(threadInfo);
                        this.T.add(qVar);
                        i4++;
                    }
                }
            }
            if (this.V != null && this.V.q()) {
                this.V = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.V == null) {
                    c.a.s0.s2.y.i.a aVar = new c.a.s0.s2.y.i.a();
                    this.V = aVar;
                    aVar.t(dataRes.recom_ala_info);
                }
            } else if (this.V == null && dataRes.promotion != null) {
                c.a.s0.s2.y.i.a aVar2 = new c.a.s0.s2.y.i.a();
                this.V = aVar2;
                aVar2.w(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.f22529i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.f22530j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.f22531k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    b bVar = new b();
                    bVar.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.l.a(bVar);
                }
            }
            this.d0.d();
            this.d0.e(this.r);
            this.d0.a(dataRes.recom_ala_info);
            if (this.d0.s != null) {
                this.d0.s.o(Q());
            }
            z zVar = new z();
            this.e0 = zVar;
            zVar.d(this.r);
            this.e0.a(dataRes.recom_ala_info);
            if (this.e0.q != null) {
                this.e0.q.o(Q());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.h0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.f0 = str;
            this.g0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.i0 = dataRes.forum_rule;
            }
            this.k0 = dataRes.is_black_white.intValue() == 1;
            this.n0 = dataRes.is_official_forum.intValue() == 1;
            this.o0 = dataRes.show_adsense.intValue() == 1;
            this.p0 = dataRes.is_purchase.intValue() == 1;
            FloatingIcon floatingIcon = dataRes.floating_icon;
            w0(dataRes.floating_icon);
            this.r0 = dataRes.has_fold_comment.intValue();
            dataRes.fold_comment_num.longValue();
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public b1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.s : (b1) invokeV.objValue;
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.U = i2;
        }
    }

    public c.a.s0.v3.j0.p z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.G : (c.a.s0.v3.j0.p) invokeV.objValue;
    }

    public void z0(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, z1Var) == null) {
            this.o = z1Var;
        }
    }
}
