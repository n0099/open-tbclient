package c.a.q0.v0.h1;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.y1;
import c.a.q0.i3.i0.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends BaseCardInfo implements c.a.q0.o1.o.l.i, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId K;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData A;
    public y1 B;
    public long C;
    public List<q> D;
    public WorksInfoData E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public AgreeData J;

    /* renamed from: e  reason: collision with root package name */
    public String f26159e;

    /* renamed from: f  reason: collision with root package name */
    public String f26160f;

    /* renamed from: g  reason: collision with root package name */
    public String f26161g;

    /* renamed from: h  reason: collision with root package name */
    public String f26162h;

    /* renamed from: i  reason: collision with root package name */
    public String f26163i;

    /* renamed from: j  reason: collision with root package name */
    public long f26164j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public List<String> v;
    public List<String> w;
    public String x;
    public b y;
    public c z;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f26165a;

        /* renamed from: b  reason: collision with root package name */
        public long f26166b;

        /* renamed from: c  reason: collision with root package name */
        public String f26167c;

        /* renamed from: d  reason: collision with root package name */
        public String f26168d;

        /* renamed from: e  reason: collision with root package name */
        public String f26169e;

        /* renamed from: f  reason: collision with root package name */
        public String f26170f;

        public a() {
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (StringUtils.isNull(this.f26169e) || StringUtils.isNull(this.f26168d)) ? false : true : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("startTime = " + this.f26165a);
                sb.append(",   ad_end_time = " + this.f26166b);
                sb.append(",   pic_url = " + this.f26167c);
                sb.append(",   card_title = " + this.f26169e);
                sb.append(",   button_title = " + this.f26170f);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26171a;

        /* renamed from: b  reason: collision with root package name */
        public String f26172b;

        /* renamed from: c  reason: collision with root package name */
        public String f26173c;

        /* renamed from: d  reason: collision with root package name */
        public String f26174d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26175e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26176f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f26177g;

        /* renamed from: h  reason: collision with root package name */
        public a f26178h;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f26179a;

            /* renamed from: b  reason: collision with root package name */
            public String f26180b;

            /* renamed from: c  reason: collision with root package name */
            public String f26181c;

            /* renamed from: d  reason: collision with root package name */
            public String f26182d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f26183e;

            /* renamed from: f  reason: collision with root package name */
            public String f26184f;

            public a() {
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

        public b() {
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

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26185a;

        /* renamed from: b  reason: collision with root package name */
        public String f26186b;

        /* renamed from: c  reason: collision with root package name */
        public String f26187c;

        /* renamed from: d  reason: collision with root package name */
        public String f26188d;

        /* renamed from: e  reason: collision with root package name */
        public int f26189e;

        /* renamed from: f  reason: collision with root package name */
        public String f26190f;

        /* renamed from: g  reason: collision with root package name */
        public String f26191g;

        /* renamed from: h  reason: collision with root package name */
        public long f26192h;

        /* renamed from: i  reason: collision with root package name */
        public String f26193i;

        /* renamed from: j  reason: collision with root package name */
        public String f26194j;
        public String k;
        public String l;
        public String m;
        public String n;
        public a o;
        public List<d> p;

        public c() {
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

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630887697, "Lc/a/q0/v0/h1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-630887697, "Lc/a/q0/v0/h1/g;");
                return;
            }
        }
        K = BdUniqueId.gen();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = new ArrayList();
        this.G = true;
        this.H = false;
        this.J = new AgreeData();
    }

    public static c2 g(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            c2 c2Var = new c2();
            c2Var.H3(gVar.f26160f);
            c2Var.B = gVar.f26160f;
            c2Var.r4(gVar.x);
            c2Var.k3(gVar.x);
            try {
                c2Var.d4((int) gVar.k);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c2Var.i4(gVar.l);
            c2Var.s3(gVar.A);
            if (c2Var.B() != null && gVar.J != null) {
                c2Var.B().threadId = gVar.f26160f;
                c2Var.B().agreeType = gVar.o;
                c2Var.B().hasAgree = gVar.p;
                c2Var.B().agreeNum = gVar.m;
                c2Var.B().baijiahaoData = gVar.A;
            }
            c2Var.x3(c.a.e.e.m.b.f(gVar.f26159e, 0L));
            c2Var.p4(40);
            return c2Var;
        }
        return (c2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? K : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.z;
            if (cVar != null) {
                return cVar.f26188d;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AgreeData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.J : (AgreeData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26160f : (String) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaijiahaoData baijiahaoData = this.A;
            if (baijiahaoData == null) {
                return 1;
            }
            int i2 = baijiahaoData.oriUgcType;
            if (i2 == 2) {
                return 3;
            }
            return i2 == 4 ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.z;
            if (cVar == null) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(cVar.f26190f);
                return parseInt > 0 && ((float) Integer.parseInt(this.z.f26191g)) / ((float) parseInt) > 1.0f;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f26159e = jSONObject.optString("forum_id");
            this.f26160f = jSONObject.optString("thread_id");
            this.f26161g = jSONObject.optString("nid");
            jSONObject.optString("first_post_id");
            jSONObject.optString("create_time");
            this.f26164j = jSONObject.optLong("play_count");
            this.x = jSONObject.optString("title");
            this.k = jSONObject.optLong("post_num");
            this.l = jSONObject.optLong("share_num");
            this.m = jSONObject.optLong("agree_num");
            this.n = jSONObject.optLong("disagree_num");
            this.o = jSONObject.optInt("agree_type");
            boolean z = true;
            this.p = jSONObject.optInt("has_agree") == 1;
            if (this.m < 0) {
                this.m = 0L;
            }
            if (this.n < 0) {
                this.n = 0L;
            }
            this.J.threadId = this.f26160f;
            this.J.agreeType = this.o;
            this.J.hasAgree = this.p;
            this.J.agreeNum = this.m;
            this.J.disAgreeNum = this.n;
            this.J.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
            this.q = jSONObject.optString("source");
            this.s = jSONObject.optString("extra");
            this.t = jSONObject.optString("abtest_tag");
            this.r = jSONObject.optString("weight");
            this.v = new ArrayList();
            String optString = jSONObject.optString("forum_id_shared");
            if (!StringUtils.isNull(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.v.add(jSONArray.optString(i2));
                }
            }
            this.w = new ArrayList();
            String optString2 = jSONObject.optString("forum_name_shared");
            if (!StringUtils.isNull(optString2)) {
                JSONArray jSONArray2 = new JSONArray(optString2);
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    this.w.add(jSONArray2.optString(i3));
                }
            }
            String optString3 = jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (!TextUtils.isEmpty(optString3)) {
                this.y = new b();
                JSONObject jSONObject2 = new JSONObject(optString3);
                this.y.f26171a = jSONObject2.optString("user_id");
                this.y.f26172b = jSONObject2.optString("user_name");
                this.y.f26173c = jSONObject2.optString("user_nickname");
                this.y.f26174d = jSONObject2.optString("portrait");
                this.y.f26175e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.y;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f26176f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.y.f26178h = new b.a();
                    this.y.f26178h.f26179a = jSONObject3.optString("name");
                    this.y.f26178h.f26182d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.y.f26178h.f26180b = jSONObject3.optString("avatar");
                    this.y.f26178h.f26181c = jSONObject3.optString("avatar_h");
                    this.y.f26178h.f26183e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.y.f26178h.f26184f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.z = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.z.f26185a = jSONObject4.optString("thumbnail_width");
                this.z.f26186b = jSONObject4.optString("thumbnail_height");
                this.z.f26187c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.z.f26188d = jSONObject4.optString("video_url");
                this.z.f26189e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.z.f26190f = jSONObject4.optString("video_width");
                this.z.f26191g = jSONObject4.optString("video_height");
                this.z.f26192h = jSONObject4.optLong("video_size");
                this.z.f26193i = jSONObject4.optString("video_type");
                this.z.f26194j = jSONObject4.optString("thumbnail_url");
                this.z.k = jSONObject4.optString("video_format");
                this.z.l = jSONObject4.optString("thumbnail_picid");
                this.z.m = jSONObject4.optString("origin_video_url");
                this.z.n = jSONObject4.optString("mcn_lead_page");
                String optString6 = jSONObject4.optString("video_desc");
                if (!TextUtils.isEmpty(optString6)) {
                    this.z.p = new ArrayList();
                    JSONArray jSONArray3 = new JSONArray(optString6);
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        d dVar = new d();
                        jSONArray3.optJSONObject(i4).optString("video_id");
                        jSONArray3.optJSONObject(i4).optString("video_url");
                        jSONArray3.optJSONObject(i4).optString("video_width");
                        jSONArray3.optJSONObject(i4).optString("video_height");
                        this.z.p.add(dVar);
                    }
                }
                JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.f26165a = optJSONObject.optLong("ad_start_time");
                    aVar.f26166b = optJSONObject.optLong("ad_end_time");
                    aVar.f26167c = optJSONObject.optString("pic_url");
                    aVar.f26168d = optJSONObject.optString("jump_url");
                    aVar.f26169e = optJSONObject.optString("card_title");
                    aVar.f26170f = optJSONObject.optString("button_title");
                    optJSONObject.optLong("effect_time");
                    optJSONObject.optLong("expire_time");
                    this.z.o = aVar;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject2 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.A = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject3 != null) {
                y1 y1Var = new y1();
                this.B = y1Var;
                y1Var.e(optJSONObject3);
            }
            this.C = jSONObject.optLong("last_time_int");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                this.D = new ArrayList();
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    q qVar = new q();
                    qVar.a(optJSONArray.getJSONObject(i5));
                    this.D.add(qVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("works_info");
            if (optJSONObject4 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.E = worksInfoData;
                worksInfoData.parseJson(optJSONObject4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.q0.o1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.F = z;
        }
    }

    @Override // c.a.q0.o1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }
}
