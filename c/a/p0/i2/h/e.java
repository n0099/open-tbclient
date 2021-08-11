package c.a.p0.i2.h;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.b1;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.e1;
import c.a.o0.s.q.f1;
import c.a.o0.s.q.y1;
import c.a.p0.i2.k.e.a0;
import c.a.p0.i2.k.e.h0;
import c.a.p0.i2.k.e.y;
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
    public h0 A;
    public List<MuteUser> B;
    public f1 C;
    public List<c2> D;
    public AlaLiveInfoCoreData E;
    public ArrayList<c.a.p0.i3.h0.p> F;
    public c.a.p0.i3.h0.p G;
    public TwzhiboAnti H;
    public List<y1> I;
    public List<y1> J;
    public u K;
    public PostData L;
    public i M;
    public long N;
    public p O;
    public String P;
    public String Q;
    public List<RecommendTopicData.RecommendTopicListData> R;
    public HashSet<String> S;
    public List<c.a.o0.s.q.q> T;
    public int U;
    public c.a.p0.i2.o.i.a V;
    public PostData W;
    public boolean X;
    public PostData Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public final UserData f18729a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public String f18730b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public CardHListViewData f18731c;
    public List<c.a.p0.i3.h0.p> c0;

    /* renamed from: d  reason: collision with root package name */
    public int f18732d;
    public y d0;

    /* renamed from: e  reason: collision with root package name */
    public int f18733e;
    public a0 e0;

    /* renamed from: f  reason: collision with root package name */
    public List<PbSortType> f18734f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public int f18735g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public k f18736h;
    public List<ThreadInfo> h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18737i;
    public ForumRuleStatus i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18738j;
    public BusinessAccountData j0;
    public boolean k;
    public boolean k0;
    public a l;
    public boolean l0;
    public boolean m;
    public int m0;
    public ForumData n;
    public boolean n0;
    public y1 o;
    public boolean o0;
    public c2 p;
    public FloatingIcon p0;
    public ArrayList<PostData> q;
    public List<c.a.e.k.e.n> q0;
    public HashMap<String, MetaData> r;
    public boolean r0;
    public b1 s;
    public AntiData t;
    public c.a.o0.u.f u;
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
        this.f18737i = false;
        this.f18738j = false;
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
        this.r0 = false;
        this.n = new ForumData();
        this.o = new y1();
        this.p = new c2();
        this.q = new ArrayList<>();
        this.r = new HashMap<>();
        this.s = new b1();
        this.t = new AntiData();
        this.u = new c.a.o0.u.f();
        this.v = 0;
        this.w = 0;
        this.f18729a = new UserData();
        this.B = new ArrayList();
        this.z = new e1();
        this.C = new f1();
        this.A = new h0();
        this.H = new TwzhiboAnti();
        this.K = new u();
        this.d0 = new y();
        this.R = new ArrayList();
        this.S = new HashSet<>();
    }

    public i A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.M : (i) invokeV.objValue;
    }

    public void A0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.w = i2;
        }
    }

    public y B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y yVar = this.d0;
            if (yVar == null || !yVar.isValid()) {
                return null;
            }
            return this.d0;
        }
        return (y) invokeV.objValue;
    }

    public void B0(String str) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (c2Var = this.p) == null) {
            return;
        }
        c2Var.V3(str);
    }

    public a0 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a0 a0Var = this.e0;
            if (a0Var == null || !a0Var.isValid()) {
                return null;
            }
            return this.e0;
        }
        return (a0) invokeV.objValue;
    }

    public void C0(b1 b1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, b1Var, i2) == null) {
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

    public h0 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (h0) invokeV.objValue;
    }

    public void D0(c.a.p0.i3.h0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.G = pVar;
        }
    }

    public f1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (f1) invokeV.objValue;
    }

    public void E0(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pVar) == null) {
            this.O = pVar;
        }
    }

    public ArrayList<PostData> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.m0 = i2;
        }
    }

    public c.a.p0.i2.o.i.a G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.V : (c.a.p0.i2.o.i.a) invokeV.objValue;
    }

    public void G0(int i2) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (antiData = this.t) == null) {
            return;
        }
        antiData.replyPrivateFlag = i2;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m0 : invokeV.intValue;
    }

    public void H0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c2Var) == null) {
            this.p = c2Var;
        }
    }

    public List<ThreadInfo> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h0 : (List) invokeV.objValue;
    }

    public void I0(List<c.a.e.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.q0 = list;
        }
    }

    public AlaLiveInfoCoreData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public PostData J0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) {
            this.L = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public List<c2> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.D : (List) invokeV.objValue;
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f18730b = str;
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

    public String[] M(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) ? N(context, true) : (String[]) invokeL.objValue;
    }

    public String[] N(Context context, boolean z) {
        InterceptResult invokeLZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048600, this, context, z)) == null) {
            String str = "";
            if (o0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (O() != null && O().J() != null && !c.a.e.e.p.k.isEmpty(O().J().getUserId())) {
                    String userId = O().J().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.t() != null && !c.a.e.e.p.k.isEmpty(i2.t().getUserId())) {
                        r2 = StringHelper.equals(userId, i2.t().getUserId()) ? i2.z() : null;
                        if (c.a.e.e.p.k.isEmpty("")) {
                            str = i2.P();
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
                                    str = postData.P();
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
                    c2 c2Var = this.p;
                    if (c2Var != null && c2Var.E() != null && this.p.E().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + context.getString(R.string.photo_live_tips) + "] " + str;
                    }
                    c2 c2Var2 = this.p;
                    if (c2Var2 != null && c2Var2.o1() != null && !c.a.e.e.p.k.isEmpty(this.p.o1().thumbnail_url)) {
                        r2 = this.p.o1().thumbnail_url;
                    }
                    c2 c2Var3 = this.p;
                    if (c2Var3 != null && !c2Var3.w1 && r2 == null && (originalThreadInfo = c2Var3.v1) != null && (arrayList = originalThreadInfo.f47202h) != null) {
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

    public c2 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.p : (c2) invokeV.objValue;
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.N : invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c2 c2Var = this.p;
            return c2Var != null ? c2Var.f0() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<c.a.e.k.e.n> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.q0 : (List) invokeV.objValue;
    }

    public p S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.O : (p) invokeV.objValue;
    }

    public u T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.K : (u) invokeV.objValue;
    }

    public UserData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f18729a : (UserData) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : invokeV.intValue;
    }

    public PostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.L : (PostData) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f18730b : (String) invokeV.objValue;
    }

    public List<c.a.p0.i3.h0.p> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.c0 : (List) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            b1 b1Var = this.s;
            return b1Var != null && b1Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.d0 = null;
            this.e0 = null;
        }
    }

    public final void a0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dataRes) == null) {
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
            this.f18732d = dataRes.exp_news_today.intValue();
            this.f18733e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i2 = 0; i2 < dataRes.thread_topic.size(); i2++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i2));
                    this.R.add(recommendTopicListData);
                }
            }
            this.f18734f = dataRes.pb_sort_info;
            this.f18735g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.f18736h = k.i(managerElection);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.G.getAdvertAppInfo() != null) {
                this.G.getAdvertAppInfo().b4 = null;
            }
            this.G = null;
        }
    }

    public final void b0(DataRes dataRes, Context context) {
        List<Post> list;
        c2 c2Var;
        c2 c2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, dataRes, context) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.S.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.y0(this.r);
                postData.j0(this.n.isBrandForum);
                postData.d0(post, context, O());
                postData.s0(O().J0());
                if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().L() != null) {
                    postData.q().baijiahaoData = O().L();
                }
                this.S.add(postData.E());
                if (postData.A() == 1 && this.p.G1()) {
                    if (l0()) {
                        postData.r0(0);
                    } else {
                        postData.r0(this.p.w());
                    }
                } else if (postData.A() == 1 && this.p.Z1()) {
                    postData.r0(41);
                } else if (postData.A() == 1 && (c2Var = this.p) != null && c2Var.A2()) {
                    postData.r0(0);
                    postData.U();
                    if (this.p.U0() != null && this.p.U0().size() != 0) {
                        postData.t0(new TbRichText(TbadkCoreApplication.getInst(), this.p.U0(), this.p.q1(), true));
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
                        postData.t0(TbRichTextView.parse(context, jSONArray, false));
                    }
                    this.L = postData;
                }
                if (postData.A() == 1 && (c2Var2 = this.p) != null && c2Var2.w1) {
                    postData.q0(c2Var2.v1);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            List<PbSortType> list = this.f18734f;
            if (list == null || list.size() <= this.f18735g) {
                return "";
            }
            for (int i2 = 0; i2 < this.f18734f.size(); i2++) {
                if (this.f18734f.get(i2).sort_type.intValue() == this.f18735g) {
                    return this.f18734f.get(i2).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void c0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
            return;
        }
        List<ThreadInfo> list2 = dataRes.feed_thread_list;
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.clear();
        for (ThreadInfo threadInfo : list2) {
            if (threadInfo != null) {
                c2 c2Var = new c2();
                c2Var.S2(threadInfo);
                this.D.add(c2Var);
            }
        }
        List<c2> list3 = this.D;
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.D = ListUtils.subList(this.D, 0, 15);
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.t : (AntiData) invokeV.objValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.r0 : invokeV.booleanValue;
    }

    public ArrayList<c.a.p0.i3.h0.p> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.F : (ArrayList) invokeV.objValue;
    }

    public final boolean e0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (c2Var = this.p) == null || c2Var.L() == null || this.p.L().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.L().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public List<c.a.o0.s.q.q> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.T : (List) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? O() != null && O().z2() : invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.U : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.k0 : invokeV.booleanValue;
    }

    public y1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.o : (y1) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.Y : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? O() != null && O().l2() : invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.W : (PostData) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public FloatingIcon k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.p0 : (FloatingIcon) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            c2 c2Var = this.p;
            return (c2Var == null || c2Var.q() == null || this.p.q().size() <= 0 || this.p.q().get(0) == null || !this.p.q().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public ForumData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean m0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z)) == null) ? (this.x == 2 && z) || this.x == 1 : invokeZ.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean n0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return Q().equals(threadInfo.id) || Q().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.i0 : (ForumRuleStatus) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? (O() == null || !O().A2() || O().o1() == null) ? false : true : invokeV.booleanValue;
    }

    public List<y1> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.J : (List) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? (O() == null || O().J2 == null || !O().J2.isWorks) ? false : true : invokeV.booleanValue;
    }

    public CardHListViewData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.f18731c : (CardHListViewData) invokeV.objValue;
    }

    public final void r0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, dataRes) == null) {
            this.x = dataRes.pb_notice_type.intValue();
            this.y = dataRes.pb_notice;
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.p.k0() != 0 : invokeV.booleanValue;
    }

    public final void s0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, dataRes) == null) {
            c.a.p0.i3.h0.p pVar = new c.a.p0.i3.h0.p();
            pVar.E0 = true;
            App app = dataRes.banner_list.pb_banner_ad;
            App c2 = c.a.p0.x2.y.o().c(app, Cmatch.PB_BANNER);
            if (c2 != null && !this.l0 && !c.a.p0.x2.a.j(c2, dataRes.banner_list)) {
                pVar.M0 = true;
                this.l0 = true;
                app = c2;
            }
            pVar.H0(app);
            this.G = pVar;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.w : invokeV.intValue;
    }

    public final void t0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.c0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                c.a.p0.i3.h0.p pVar = new c.a.p0.i3.h0.p();
                pVar.K0 = p0();
                pVar.H0(app);
                if (!this.c0.contains(pVar)) {
                    this.c0.add(pVar);
                }
            }
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            c2 c2Var = this.p;
            if (c2Var != null) {
                return c2Var.B0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void u0(DataRes dataRes, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048654, this, dataRes, context) == null) || dataRes == null) {
            return;
        }
        try {
            c.a.p0.x2.j0.a.e().h(dataRes.asp_shown_info);
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
            A0(dataRes.is_new_url.intValue());
            r0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.f(dataRes.display_forum);
            this.p.u4(this.r);
            this.p.S2(dataRes.thread);
            if (this.p.T() == 0) {
                this.p.x3(dataRes.forum.id.longValue());
            }
            if (this.p.J() != null && this.p.J().getBusinessAccountData() == null) {
                this.p.J().setBusinessAccountData(this.j0);
            }
            this.z.a(dataRes.news_info);
            int i3 = this.z.f13900c;
            if (i3 == 1) {
                this.A.D0 = this.z;
            } else if (i3 == 2) {
                this.A.E0 = this.z;
            } else if (i3 != 3) {
                this.A.E0 = this.z;
            } else {
                this.A.F0 = this.z;
            }
            this.C.D0(dataRes.recommend_book);
            b0(dataRes, context);
            PostData postData = new PostData();
            this.W = postData;
            postData.i0(1);
            this.W.y0(this.r);
            this.W.j0(this.n.isBrandForum);
            this.W.w0(this.p.P());
            if (dataRes.first_floor_post != null) {
                this.W.c0(dataRes.first_floor_post, context);
            }
            if (this.p != null && this.p.w1) {
                this.W.q0(this.p.v1);
            }
            if (this.Y == null) {
                this.Y = this.W;
                this.X = true;
            }
            this.s.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.r0 = true;
            }
            this.t.parserProtobuf(dataRes.anti);
            this.u.c(dataRes.location);
            if (dataRes.user != null) {
                this.v = dataRes.user.is_manager.intValue();
            }
            this.f18729a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.B.add(muteUser);
                    }
                }
            }
            this.p.d4(this.p.S0() > 0 ? this.p.S0() - 1 : 0);
            List<AdvertAppInfo> h2 = c.a.p0.x2.y.o().h();
            if (h2 != null) {
                h2.clear();
            }
            String str = null;
            this.G = null;
            this.l0 = false;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                s0(dataRes);
                for (App app : list2) {
                    c.a.p0.i3.h0.p pVar = new c.a.p0.i3.h0.p();
                    pVar.K0 = p0();
                    App c2 = c.a.p0.x2.y.o().c(app, p0() ? Cmatch.VIDEO_PB_COMMENT : Cmatch.PB_COMMENT);
                    if (c2 != null && !this.l0 && !c.a.p0.x2.a.j(c2, dataRes.banner_list)) {
                        pVar.M0 = true;
                        this.l0 = true;
                        app = c2;
                    }
                    pVar.H0(app);
                    if (!this.F.contains(pVar)) {
                        this.F.add(pVar);
                        if (h2 != null) {
                            h2.add(pVar.getAdvertAppInfo());
                        }
                    }
                }
                t0(dataRes);
            }
            c.a.p0.x2.y.o().g();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.f18729a.getIsSelectTail());
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
                this.f18731c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            c0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.I == null) {
                    this.I = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    y1 y1Var = new y1();
                    y1Var.f(simpleForum);
                    this.I.add(y1Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        y1 y1Var2 = new y1();
                        y1Var2.f(simpleForum2);
                        this.J.add(y1Var2);
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
                    if (threadInfo != null && !n0(threadInfo) && !e0(threadInfo)) {
                        c.a.o0.s.q.q qVar = new c.a.o0.s.q.q();
                        qVar.H4(i4);
                        qVar.S2(threadInfo);
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
                    c.a.p0.i2.o.i.a aVar = new c.a.p0.i2.o.i.a();
                    this.V = aVar;
                    aVar.t(dataRes.recom_ala_info);
                }
            } else if (this.V == null && dataRes.promotion != null) {
                c.a.p0.i2.o.i.a aVar2 = new c.a.p0.i2.o.i.a();
                this.V = aVar2;
                aVar2.w(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.f18737i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.f18738j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
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
            a0 a0Var = new a0();
            this.e0 = a0Var;
            a0Var.c(this.r);
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
            this.o0 = dataRes.is_purchase.intValue() == 1;
            this.p0 = dataRes.floating_icon;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.B : (List) invokeV.objValue;
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            this.U = i2;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public void w0(y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, y1Var) == null) {
            this.o = y1Var;
        }
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public void x0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, postData) == null) {
            this.W = postData;
            this.Y = postData;
            this.X = false;
        }
    }

    public b1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.s : (b1) invokeV.objValue;
    }

    public void y0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, postData) == null) {
            this.Y = postData;
        }
    }

    public c.a.p0.i3.h0.p z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.G : (c.a.p0.i3.h0.p) invokeV.objValue;
    }

    public void z0(boolean z) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048664, this, z) == null) || (c2Var = this.p) == null) {
            return;
        }
        if (z) {
            c2Var.L3(1);
        } else {
            c2Var.L3(0);
        }
    }
}
