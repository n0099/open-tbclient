package c.a.r0.k2.h;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.e1;
import c.a.q0.s.q.f1;
import c.a.q0.s.q.z1;
import c.a.r0.k2.k.e.g0;
import c.a.r0.k2.k.e.x;
import c.a.r0.k2.k.e.z;
import c.a.r0.z2.y;
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
import com.baidu.tieba.R;
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
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g0 A;
    public List<MuteUser> B;
    public f1 C;
    public List<d2> D;
    public AlaLiveInfoCoreData E;
    public ArrayList<c.a.r0.k3.i0.p> F;
    public c.a.r0.k3.i0.p G;
    public TwzhiboAnti H;
    public List<z1> I;
    public List<z1> J;
    public u K;
    public PostData L;
    public i M;
    public long N;
    public p O;
    public String P;
    public String Q;
    public List<RecommendTopicData.RecommendTopicListData> R;
    public HashSet<String> S;
    public List<c.a.q0.s.q.q> T;
    public int U;
    public c.a.r0.k2.o.i.a V;
    public PostData W;
    public boolean X;
    public PostData Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public final UserData f19803a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public String f19804b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f19805c;
    public List<c.a.r0.k3.i0.p> c0;

    /* renamed from: d  reason: collision with root package name */
    public int f19806d;
    public x d0;

    /* renamed from: e  reason: collision with root package name */
    public int f19807e;
    public z e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f19808f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public int f19809g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public k f19810h;
    public List<ThreadInfo> h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19811i;
    public ForumRuleStatus i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19812j;
    public BusinessAccountData j0;
    public boolean k;
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
    public FloatingIcon q0;
    public HashMap<String, MetaData> r;
    public List<c.a.e.l.e.n> r0;
    public b1 s;
    public boolean s0;
    public AntiData t;
    public c.a.q0.u.f u;
    public int v;
    public int w;
    public int x;
    public String y;
    public e1 z;

    public e() {
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
        this.f19811i = false;
        this.f19812j = false;
        this.k = false;
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
        this.s0 = false;
        this.n = new ForumData();
        this.o = new z1();
        this.p = new d2();
        this.q = new ArrayList<>();
        this.r = new HashMap<>();
        this.s = new b1();
        this.t = new AntiData();
        this.u = new c.a.q0.u.f();
        this.v = 0;
        this.w = 0;
        this.f19803a = new UserData();
        this.B = new ArrayList();
        this.z = new e1();
        this.C = new f1();
        this.A = new g0();
        this.H = new TwzhiboAnti();
        this.K = new u();
        this.d0 = new x();
        this.R = new ArrayList();
        this.S = new HashSet<>();
    }

    public i A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.M : (i) invokeV.objValue;
    }

    public void A0(boolean z) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (d2Var = this.p) == null) {
            return;
        }
        if (z) {
            d2Var.S3(1);
        } else {
            d2Var.S3(0);
        }
    }

    public x B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            x xVar = this.d0;
            if (xVar == null || !xVar.isValid()) {
                return null;
            }
            return this.d0;
        }
        return (x) invokeV.objValue;
    }

    public void B0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.w = i2;
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

    public void C0(String str) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (d2Var = this.p) == null) {
            return;
        }
        d2Var.e4(str);
    }

    public g0 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (g0) invokeV.objValue;
    }

    public void D0(b1 b1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, b1Var, i2) == null) {
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

    public f1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (f1) invokeV.objValue;
    }

    public void E0(c.a.r0.k3.i0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            this.G = pVar;
        }
    }

    public ArrayList<PostData> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void F0(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) {
            this.O = pVar;
        }
    }

    public c.a.r0.k2.o.i.a G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.V : (c.a.r0.k2.o.i.a) invokeV.objValue;
    }

    public void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.m0 = i2;
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m0 : invokeV.intValue;
    }

    public void H0(int i2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (antiData = this.t) == null) {
            return;
        }
        antiData.replyPrivateFlag = i2;
    }

    public List<ThreadInfo> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h0 : (List) invokeV.objValue;
    }

    public void I0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) {
            this.p = d2Var;
        }
    }

    public AlaLiveInfoCoreData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public void J0(List<c.a.e.l.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.r0 = list;
        }
    }

    public List<d2> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public PostData K0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, postData)) == null) {
            this.L = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
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

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f19804b = str;
        }
    }

    public String[] M(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, context)) == null) ? N(context, true) : (String[]) invokeL.objValue;
    }

    public String[] N(Context context, boolean z) {
        InterceptResult invokeLZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048601, this, context, z)) == null) {
            String str = "";
            if (p0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (O() != null && O().J() != null && !c.a.e.e.p.k.isEmpty(O().J().getUserId())) {
                    String userId = O().J().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.t() != null && !c.a.e.e.p.k.isEmpty(i2.t().getUserId())) {
                        r2 = StringHelper.equals(userId, i2.t().getUserId()) ? i2.z() : null;
                        if (c.a.e.e.p.k.isEmpty("")) {
                            str = i2.Q();
                        }
                    }
                    if (c.a.e.e.p.k.isEmpty(str) && c.a.e.e.p.k.isEmpty(r2)) {
                        for (int i3 = 0; i3 < size; i3++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                            if (postData != null && postData.t() != null && !c.a.e.e.p.k.isEmpty(postData.t().getUserId()) && StringHelper.equals(userId, postData.t().getUserId())) {
                                if (c.a.e.e.p.k.isEmpty(r2)) {
                                    r2 = postData.z();
                                }
                                if (c.a.e.e.p.k.isEmpty(str)) {
                                    str = postData.Q();
                                }
                                if (!c.a.e.e.p.k.isEmpty(r2) && !c.a.e.e.p.k.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && c.a.e.e.p.k.isEmpty(r2)) {
                        r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    d2 d2Var = this.p;
                    if (d2Var != null && d2Var.E() != null && this.p.E().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + context.getString(R.string.photo_live_tips) + "] " + str;
                    }
                    d2 d2Var2 = this.p;
                    if (d2Var2 != null && d2Var2.q1() != null && !c.a.e.e.p.k.isEmpty(this.p.q1().thumbnail_url)) {
                        r2 = this.p.q1().thumbnail_url;
                    }
                    d2 d2Var3 = this.p;
                    if (d2Var3 != null && !d2Var3.z1 && r2 == null && (originalThreadInfo = d2Var3.y1) != null && (arrayList = originalThreadInfo.f47439h) != null) {
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
        return (String[]) invokeLZ.objValue;
    }

    public d2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : (d2) invokeV.objValue;
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.N : invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            d2 d2Var = this.p;
            return d2Var != null ? d2Var.f0() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<c.a.e.l.e.n> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r0 : (List) invokeV.objValue;
    }

    public p S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.O : (p) invokeV.objValue;
    }

    public u T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.K : (u) invokeV.objValue;
    }

    public UserData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f19803a : (UserData) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : invokeV.intValue;
    }

    public PostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.L : (PostData) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f19804b : (String) invokeV.objValue;
    }

    public List<c.a.r0.k3.i0.p> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.c0 : (List) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            b1 b1Var = this.s;
            return b1Var != null && b1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.d0 = null;
            this.e0 = null;
        }
    }

    public final void a0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dataRes) == null) {
            this.O = new p(this.p, this.t);
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
            this.f19806d = dataRes.exp_news_today.intValue();
            this.f19807e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i2));
                    this.R.add(recommendTopicListData);
                }
            }
            this.f19808f = dataRes.pb_sort_info;
            this.f19809g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.f19810h = k.i(managerElection);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.G.getAdvertAppInfo() != null) {
                this.G.getAdvertAppInfo().f4 = null;
            }
            this.G = null;
        }
    }

    public final void b0(DataRes dataRes, Context context) {
        List<Post> list;
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, dataRes, context) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.S.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.A0(this.r);
                postData.l0(this.n.isBrandForum);
                postData.f0(post, context, O());
                postData.u0(O().L0());
                if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().L() != null) {
                    postData.q().baijiahaoData = O().L();
                }
                this.S.add(postData.E());
                if (postData.A() == 1 && this.p.I1()) {
                    if (l0()) {
                        postData.t0(0);
                    } else {
                        postData.t0(this.p.w());
                    }
                } else if (postData.A() == 1 && this.p.c2()) {
                    postData.t0(41);
                } else if (postData.A() == 1 && (d2Var = this.p) != null && d2Var.E2()) {
                    postData.t0(0);
                    postData.V();
                    if (this.p.W0() != null && this.p.W0().size() != 0) {
                        postData.v0(new TbRichText(TbadkCoreApplication.getInst(), this.p.W0(), this.p.s1(), true));
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
                        postData.v0(TbRichTextView.parse(context, jSONArray, false));
                    }
                    this.L = postData;
                }
                if (postData.A() == 1 && (d2Var2 = this.p) != null && d2Var2.z1) {
                    postData.s0(d2Var2.y1);
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

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            List<PbSortType> list = this.f19808f;
            if (list == null || list.size() <= this.f19809g) {
                return "";
            }
            for (int i2 = 0; i2 < this.f19808f.size(); i2++) {
                if (this.f19808f.get(i2).sort_type.intValue() == this.f19809g) {
                    return this.f19808f.get(i2).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void c0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
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
                d2Var.Y2(threadInfo);
                this.D.add(d2Var);
            }
        }
        List<d2> list3 = this.D;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.D = ListUtils.subList(this.D, 0, 15);
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.t : (AntiData) invokeV.objValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.s0 : invokeV.booleanValue;
    }

    public ArrayList<c.a.r0.k3.i0.p> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.F : (ArrayList) invokeV.objValue;
    }

    public final boolean e0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (d2Var = this.p) == null || d2Var.L() == null || this.p.L().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.L().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public List<c.a.q0.s.q.q> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.T : (List) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? O() != null && O().D2() : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.U : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.k0 : invokeV.booleanValue;
    }

    public z1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.o : (z1) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.Y : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? O() != null && O().p2() : invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.W : (PostData) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public FloatingIcon k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.q0 : (FloatingIcon) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            d2 d2Var = this.p;
            return (d2Var == null || d2Var.q() == null || this.p.q().size() <= 0 || this.p.q().get(0) == null || !this.p.q().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public ForumData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean n0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) ? (this.x == 2 && z) || this.x == 1 : invokeZ.booleanValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean o0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return Q().equals(threadInfo.id) || Q().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public ForumRuleStatus p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.i0 : (ForumRuleStatus) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public List<z1> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? (O() == null || !O().E2() || O().q1() == null) ? false : true : invokeV.booleanValue;
    }

    public CardHListViewData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.f19805c : (CardHListViewData) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? (O() == null || O().M2 == null || !O().M2.isWorks) ? false : true : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.p.l0() != 0 : invokeV.booleanValue;
    }

    public final void s0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, dataRes) == null) {
            this.x = dataRes.pb_notice_type.intValue();
            this.y = dataRes.pb_notice;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w : invokeV.intValue;
    }

    public final void t0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, dataRes) == null) {
            c.a.r0.k3.i0.p pVar = new c.a.r0.k3.i0.p();
            pVar.E0 = true;
            App app = dataRes.banner_list.pb_banner_ad;
            App c2 = y.o().c(app, Cmatch.PB_BANNER);
            if (c2 != null && !this.l0 && !c.a.r0.z2.a.j(c2, dataRes.banner_list)) {
                pVar.M0 = true;
                this.l0 = true;
                app = c2;
            }
            pVar.J0(app);
            this.G = pVar;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            d2 d2Var = this.p;
            if (d2Var != null) {
                return d2Var.D0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void u0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.c0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                c.a.r0.k3.i0.p pVar = new c.a.r0.k3.i0.p();
                pVar.K0 = q0();
                pVar.J0(app);
                if (!this.c0.contains(pVar)) {
                    this.c0.add(pVar);
                }
            }
        }
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public void v0(DataRes dataRes, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048657, this, dataRes, context) == null) || dataRes == null) {
            return;
        }
        try {
            c.a.r0.z2.j0.a.e().h(dataRes.asp_shown_info);
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
            B0(dataRes.is_new_url.intValue());
            s0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.f(dataRes.display_forum);
            this.p.D4(this.r);
            this.p.Y2(dataRes.thread);
            if (this.p.T() == 0) {
                this.p.D3(dataRes.forum.id.longValue());
            }
            if (this.p.J() != null && this.p.J().getBusinessAccountData() == null) {
                this.p.J().setBusinessAccountData(this.j0);
            }
            this.z.a(dataRes.news_info);
            int i3 = this.z.f14180c;
            if (i3 == 1) {
                this.A.D0 = this.z;
            } else if (i3 == 2) {
                this.A.E0 = this.z;
            } else if (i3 != 3) {
                this.A.E0 = this.z;
            } else {
                this.A.F0 = this.z;
            }
            this.C.F0(dataRes.recommend_book);
            b0(dataRes, context);
            PostData postData = new PostData();
            this.W = postData;
            postData.k0(1);
            this.W.A0(this.r);
            this.W.l0(this.n.isBrandForum);
            this.W.y0(this.p.P());
            if (dataRes.first_floor_post != null) {
                this.W.e0(dataRes.first_floor_post, context);
            }
            if (this.p != null && this.p.z1) {
                this.W.s0(this.p.y1);
            }
            if (this.Y == null) {
                this.Y = this.W;
                this.X = true;
            }
            this.s.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.s0 = true;
            }
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.f19803a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.B.add(muteUser);
                    }
                }
            }
            this.p.m4(this.p.U0() > 0 ? this.p.U0() - 1 : 0);
            List<AdvertAppInfo> h2 = y.o().h();
            if (h2 != null) {
                h2.clear();
            }
            String str = null;
            this.G = null;
            this.l0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                t0(dataRes);
                for (App app : list2) {
                    c.a.r0.k3.i0.p pVar = new c.a.r0.k3.i0.p();
                    pVar.K0 = q0();
                    App c2 = y.o().c(app, q0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.l0 && !c.a.r0.z2.a.j(c2, dataRes.banner_list)) {
                        pVar.M0 = true;
                        this.l0 = true;
                        app = c2;
                    }
                    pVar.J0(app);
                    if (!this.F.contains(pVar)) {
                        this.F.add(pVar);
                        if (h2 != null) {
                            h2.add(pVar.getAdvertAppInfo());
                        }
                    }
                }
                u0(dataRes);
            }
            y.o().g();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.f19803a.getIsSelectTail());
            }
            this.H.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                i iVar = new i();
                this.M = iVar;
                iVar.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.f19805c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            c0(dataRes);
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
            a0(dataRes);
            if (this.T == null) {
                this.T = new ArrayList();
            }
            this.T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !o0(threadInfo) && !e0(threadInfo)) {
                        c.a.q0.s.q.q qVar = new c.a.q0.s.q.q();
                        qVar.R4(i4);
                        qVar.Y2(threadInfo);
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
                    c.a.r0.k2.o.i.a aVar = new c.a.r0.k2.o.i.a();
                    this.V = aVar;
                    aVar.t(dataRes.recom_ala_info);
                }
            } else if (this.V == null && dataRes.promotion != null) {
                c.a.r0.k2.o.i.a aVar2 = new c.a.r0.k2.o.i.a();
                this.V = aVar2;
                aVar2.w(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.f19811i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.f19812j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    b bVar = new b();
                    bVar.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new a();
                    }
                    this.l.b(bVar);
                }
            }
            this.d0.c();
            this.d0.d(this.r);
            this.d0.b(dataRes.recom_ala_info);
            if (this.d0.s != null) {
                this.d0.s.p(Q());
            }
            z zVar = new z();
            this.e0 = zVar;
            zVar.c(this.r);
            this.e0.b(dataRes.recom_ala_info);
            if (this.e0.q != null) {
                this.e0.q.p(Q());
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
            this.q0 = dataRes.floating_icon;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.U = i2;
        }
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public void x0(z1 z1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, z1Var) == null) {
            this.o = z1Var;
        }
    }

    public b1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.s : (b1) invokeV.objValue;
    }

    public void y0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, postData) == null) {
            this.W = postData;
            this.Y = postData;
            this.X = false;
        }
    }

    public c.a.r0.k3.i0.p z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.G : (c.a.r0.k3.i0.p) invokeV.objValue;
    }

    public void z0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, postData) == null) {
            this.Y = postData;
        }
    }
}
