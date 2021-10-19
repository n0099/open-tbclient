package c.a.r0.x0.h1;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.r0.k3.i0.q;
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
public class g extends BaseCardInfo implements c.a.r0.q1.o.l.i, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId K;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData A;
    public z1 B;
    public long C;
    public List<q> D;
    public WorksInfoData E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public AgreeData J;

    /* renamed from: e  reason: collision with root package name */
    public String f26998e;

    /* renamed from: f  reason: collision with root package name */
    public String f26999f;

    /* renamed from: g  reason: collision with root package name */
    public String f27000g;

    /* renamed from: h  reason: collision with root package name */
    public String f27001h;

    /* renamed from: i  reason: collision with root package name */
    public String f27002i;

    /* renamed from: j  reason: collision with root package name */
    public long f27003j;
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
        public long f27004a;

        /* renamed from: b  reason: collision with root package name */
        public long f27005b;

        /* renamed from: c  reason: collision with root package name */
        public String f27006c;

        /* renamed from: d  reason: collision with root package name */
        public String f27007d;

        /* renamed from: e  reason: collision with root package name */
        public String f27008e;

        /* renamed from: f  reason: collision with root package name */
        public String f27009f;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (StringUtils.isNull(this.f27008e) || StringUtils.isNull(this.f27007d)) ? false : true : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("startTime = " + this.f27004a);
                sb.append(",   ad_end_time = " + this.f27005b);
                sb.append(",   pic_url = " + this.f27006c);
                sb.append(",   card_title = " + this.f27008e);
                sb.append(",   button_title = " + this.f27009f);
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
        public String f27010a;

        /* renamed from: b  reason: collision with root package name */
        public String f27011b;

        /* renamed from: c  reason: collision with root package name */
        public String f27012c;

        /* renamed from: d  reason: collision with root package name */
        public String f27013d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27014e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27015f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27016g;

        /* renamed from: h  reason: collision with root package name */
        public a f27017h;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f27018a;

            /* renamed from: b  reason: collision with root package name */
            public String f27019b;

            /* renamed from: c  reason: collision with root package name */
            public String f27020c;

            /* renamed from: d  reason: collision with root package name */
            public String f27021d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f27022e;

            /* renamed from: f  reason: collision with root package name */
            public String f27023f;

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
        public String f27024a;

        /* renamed from: b  reason: collision with root package name */
        public String f27025b;

        /* renamed from: c  reason: collision with root package name */
        public String f27026c;

        /* renamed from: d  reason: collision with root package name */
        public String f27027d;

        /* renamed from: e  reason: collision with root package name */
        public int f27028e;

        /* renamed from: f  reason: collision with root package name */
        public String f27029f;

        /* renamed from: g  reason: collision with root package name */
        public String f27030g;

        /* renamed from: h  reason: collision with root package name */
        public long f27031h;

        /* renamed from: i  reason: collision with root package name */
        public String f27032i;

        /* renamed from: j  reason: collision with root package name */
        public String f27033j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1057781614, "Lc/a/r0/x0/h1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1057781614, "Lc/a/r0/x0/h1/g;");
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

    public static d2 g(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            d2 d2Var = new d2();
            d2Var.N3(gVar.f26999f);
            d2Var.E = gVar.f26999f;
            d2Var.A4(gVar.x);
            d2Var.p3(gVar.x);
            try {
                d2Var.m4((int) gVar.k);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            d2Var.r4(gVar.l);
            d2Var.y3(gVar.A);
            if (d2Var.B() != null && gVar.J != null) {
                d2Var.B().threadId = gVar.f26999f;
                d2Var.B().agreeType = gVar.o;
                d2Var.B().hasAgree = gVar.p;
                d2Var.B().agreeNum = gVar.m;
                d2Var.B().baijiahaoData = gVar.A;
            }
            d2Var.D3(c.a.e.e.m.b.g(gVar.f26998e, 0L));
            d2Var.y4(40);
            return d2Var;
        }
        return (d2) invokeL.objValue;
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
                return cVar.f27027d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26999f : (String) invokeV.objValue;
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
                int parseInt = Integer.parseInt(cVar.f27029f);
                return parseInt > 0 && ((float) Integer.parseInt(this.z.f27030g)) / ((float) parseInt) > 1.0f;
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
            this.f26998e = jSONObject.optString("forum_id");
            this.f26999f = jSONObject.optString("thread_id");
            this.f27000g = jSONObject.optString("nid");
            jSONObject.optString("first_post_id");
            jSONObject.optString("create_time");
            this.f27003j = jSONObject.optLong("play_count");
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
            this.J.threadId = this.f26999f;
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
                this.y.f27010a = jSONObject2.optString("user_id");
                this.y.f27011b = jSONObject2.optString("user_name");
                this.y.f27012c = jSONObject2.optString("user_nickname");
                this.y.f27013d = jSONObject2.optString("portrait");
                this.y.f27014e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.y;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f27015f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.y.f27017h = new b.a();
                    this.y.f27017h.f27018a = jSONObject3.optString("name");
                    this.y.f27017h.f27021d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.y.f27017h.f27019b = jSONObject3.optString("avatar");
                    this.y.f27017h.f27020c = jSONObject3.optString("avatar_h");
                    this.y.f27017h.f27022e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.y.f27017h.f27023f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.z = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.z.f27024a = jSONObject4.optString("thumbnail_width");
                this.z.f27025b = jSONObject4.optString("thumbnail_height");
                this.z.f27026c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.z.f27027d = jSONObject4.optString("video_url");
                this.z.f27028e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.z.f27029f = jSONObject4.optString("video_width");
                this.z.f27030g = jSONObject4.optString("video_height");
                this.z.f27031h = jSONObject4.optLong("video_size");
                this.z.f27032i = jSONObject4.optString("video_type");
                this.z.f27033j = jSONObject4.optString("thumbnail_url");
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
                    aVar.f27004a = optJSONObject.optLong("ad_start_time");
                    aVar.f27005b = optJSONObject.optLong("ad_end_time");
                    aVar.f27006c = optJSONObject.optString("pic_url");
                    aVar.f27007d = optJSONObject.optString("jump_url");
                    aVar.f27008e = optJSONObject.optString("card_title");
                    aVar.f27009f = optJSONObject.optString("button_title");
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
                z1 z1Var = new z1();
                this.B = z1Var;
                z1Var.e(optJSONObject3);
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

    @Override // c.a.r0.q1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.F = z;
        }
    }

    @Override // c.a.r0.q1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }
}
