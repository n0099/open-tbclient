package c.a.p0.f1.j1;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.x1;
import c.a.p0.a4.k0.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class g extends BaseCardInfo implements c.a.p0.b2.o.l.i, IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId G;
    public transient /* synthetic */ FieldHolder $fh;
    public WorksInfoData A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public AgreeData F;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f14123b;

    /* renamed from: c  reason: collision with root package name */
    public String f14124c;

    /* renamed from: d  reason: collision with root package name */
    public String f14125d;

    /* renamed from: e  reason: collision with root package name */
    public String f14126e;

    /* renamed from: f  reason: collision with root package name */
    public long f14127f;

    /* renamed from: g  reason: collision with root package name */
    public long f14128g;

    /* renamed from: h  reason: collision with root package name */
    public long f14129h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public List<String> r;
    public List<String> s;
    public String t;
    public b u;
    public c v;
    public BaijiahaoData w;
    public x1 x;
    public long y;
    public List<p> z;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f14130b;

        /* renamed from: c  reason: collision with root package name */
        public String f14131c;

        /* renamed from: d  reason: collision with root package name */
        public String f14132d;

        /* renamed from: e  reason: collision with root package name */
        public String f14133e;

        /* renamed from: f  reason: collision with root package name */
        public String f14134f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (StringUtils.isNull(this.f14133e) || StringUtils.isNull(this.f14132d)) ? false : true : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("startTime = " + this.a);
                sb.append(",   ad_end_time = " + this.f14130b);
                sb.append(",   pic_url = " + this.f14131c);
                sb.append(",   card_title = " + this.f14133e);
                sb.append(",   button_title = " + this.f14134f);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f14135b;

        /* renamed from: c  reason: collision with root package name */
        public String f14136c;

        /* renamed from: d  reason: collision with root package name */
        public String f14137d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14138e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f14139f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f14140g;

        /* renamed from: h  reason: collision with root package name */
        public a f14141h;

        /* loaded from: classes2.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;

            /* renamed from: b  reason: collision with root package name */
            public String f14142b;

            /* renamed from: c  reason: collision with root package name */
            public String f14143c;

            /* renamed from: d  reason: collision with root package name */
            public String f14144d;

            /* renamed from: e  reason: collision with root package name */
            public Integer f14145e;

            /* renamed from: f  reason: collision with root package name */
            public String f14146f;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f14147b;

        /* renamed from: c  reason: collision with root package name */
        public String f14148c;

        /* renamed from: d  reason: collision with root package name */
        public String f14149d;

        /* renamed from: e  reason: collision with root package name */
        public int f14150e;

        /* renamed from: f  reason: collision with root package name */
        public String f14151f;

        /* renamed from: g  reason: collision with root package name */
        public String f14152g;

        /* renamed from: h  reason: collision with root package name */
        public long f14153h;
        public String i;
        public String j;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-59747199, "Lc/a/p0/f1/j1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-59747199, "Lc/a/p0/f1/j1/g;");
                return;
            }
        }
        G = BdUniqueId.gen();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = new ArrayList();
        this.C = true;
        this.D = false;
        this.F = new AgreeData();
    }

    public static ThreadData e(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            if (gVar == null) {
                return null;
            }
            ThreadData threadData = new ThreadData();
            threadData.setId(gVar.f14123b);
            threadData.tid = gVar.f14123b;
            threadData.setTitle(gVar.t);
            threadData.setAbstract(gVar.t);
            try {
                threadData.setReply_num((int) gVar.f14128g);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            threadData.setShareNum(gVar.f14129h);
            threadData.setBaijiahaoData(gVar.w);
            if (threadData.getAgreeData() != null && gVar.F != null) {
                threadData.getAgreeData().threadId = gVar.f14123b;
                threadData.getAgreeData().agreeType = gVar.k;
                threadData.getAgreeData().hasAgree = gVar.l;
                threadData.getAgreeData().agreeNum = gVar.i;
                threadData.getAgreeData().baijiahaoData = gVar.w;
            }
            threadData.setFid(c.a.d.f.m.b.g(gVar.a, 0L));
            threadData.setThreadType(40);
            return threadData;
        }
        return (ThreadData) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14123b : (String) invokeV.objValue;
    }

    public AgreeData getAgreeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.F : (AgreeData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? G : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.v;
            if (cVar != null) {
                return cVar.f14149d;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaijiahaoData baijiahaoData = this.w;
            if (baijiahaoData == null) {
                return 1;
            }
            int i = baijiahaoData.oriUgcType;
            if (i == 2) {
                return 3;
            }
            return i == 4 ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.v;
            if (cVar == null) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(cVar.f14151f);
                return parseInt > 0 && ((float) Integer.parseInt(this.v.f14152g)) / ((float) parseInt) > 1.0f;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("forum_id");
            this.f14123b = jSONObject.optString("thread_id");
            this.f14124c = jSONObject.optString("nid");
            jSONObject.optString("first_post_id");
            jSONObject.optString("create_time");
            this.f14127f = jSONObject.optLong("play_count");
            this.t = jSONObject.optString("title");
            this.f14128g = jSONObject.optLong("post_num");
            this.f14129h = jSONObject.optLong("share_num");
            this.i = jSONObject.optLong("agree_num");
            this.j = jSONObject.optLong("disagree_num");
            this.k = jSONObject.optInt("agree_type");
            boolean z = true;
            this.l = jSONObject.optInt("has_agree") == 1;
            if (this.i < 0) {
                this.i = 0L;
            }
            if (this.j < 0) {
                this.j = 0L;
            }
            this.F.threadId = this.f14123b;
            this.F.agreeType = this.k;
            this.F.hasAgree = this.l;
            this.F.agreeNum = this.i;
            this.F.disAgreeNum = this.j;
            this.F.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
            this.m = jSONObject.optString("source");
            this.o = jSONObject.optString("extra");
            this.p = jSONObject.optString("abtest_tag");
            this.n = jSONObject.optString("weight");
            this.r = new ArrayList();
            String optString = jSONObject.optString("forum_id_shared");
            if (!StringUtils.isNull(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.r.add(jSONArray.optString(i));
                }
            }
            this.s = new ArrayList();
            String optString2 = jSONObject.optString("forum_name_shared");
            if (!StringUtils.isNull(optString2)) {
                JSONArray jSONArray2 = new JSONArray(optString2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.s.add(jSONArray2.optString(i2));
                }
            }
            String optString3 = jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (!TextUtils.isEmpty(optString3)) {
                this.u = new b();
                JSONObject jSONObject2 = new JSONObject(optString3);
                this.u.a = jSONObject2.optString("user_id");
                this.u.f14135b = jSONObject2.optString("user_name");
                this.u.f14136c = jSONObject2.optString("user_nickname");
                this.u.f14137d = jSONObject2.optString("portrait");
                this.u.f14138e = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                b bVar = this.u;
                if (jSONObject2.optInt("is_god") != 1) {
                    z = false;
                }
                bVar.f14139f = z;
                String optString4 = jSONObject2.optString("baijiahao_info");
                if (!TextUtils.isEmpty(optString4)) {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.u.f14141h = new b.a();
                    this.u.f14141h.a = jSONObject3.optString("name");
                    this.u.f14141h.f14144d = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    this.u.f14141h.f14142b = jSONObject3.optString("avatar");
                    this.u.f14141h.f14143c = jSONObject3.optString("avatar_h");
                    this.u.f14141h.f14145e = Integer.valueOf(jSONObject3.optInt("auth_id"));
                    this.u.f14141h.f14146f = jSONObject3.optString("auth_desc");
                }
            }
            String optString5 = jSONObject.optString("video");
            if (!TextUtils.isEmpty(optString5)) {
                this.v = new c();
                JSONObject jSONObject4 = new JSONObject(optString5);
                this.v.a = jSONObject4.optString("thumbnail_width");
                this.v.f14147b = jSONObject4.optString("thumbnail_height");
                this.v.f14148c = jSONObject4.optString(VideoFinishResult.KEY_VIDEO_MD5);
                this.v.f14149d = jSONObject4.optString("video_url");
                this.v.f14150e = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                this.v.f14151f = jSONObject4.optString("video_width");
                this.v.f14152g = jSONObject4.optString("video_height");
                this.v.f14153h = jSONObject4.optLong("video_size");
                this.v.i = jSONObject4.optString("video_type");
                this.v.j = jSONObject4.optString("thumbnail_url");
                this.v.k = jSONObject4.optString("video_format");
                this.v.l = jSONObject4.optString("thumbnail_picid");
                this.v.m = jSONObject4.optString("origin_video_url");
                this.v.n = jSONObject4.optString("mcn_lead_page");
                String optString6 = jSONObject4.optString("video_desc");
                if (!TextUtils.isEmpty(optString6)) {
                    this.v.p = new ArrayList();
                    JSONArray jSONArray3 = new JSONArray(optString6);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        d dVar = new d();
                        jSONArray3.optJSONObject(i3).optString("video_id");
                        jSONArray3.optJSONObject(i3).optString("video_url");
                        jSONArray3.optJSONObject(i3).optString("video_width");
                        jSONArray3.optJSONObject(i3).optString("video_height");
                        this.v.p.add(dVar);
                    }
                }
                JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.a = optJSONObject.optLong("ad_start_time");
                    aVar.f14130b = optJSONObject.optLong("ad_end_time");
                    aVar.f14131c = optJSONObject.optString("pic_url");
                    aVar.f14132d = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    aVar.f14133e = optJSONObject.optString("card_title");
                    aVar.f14134f = optJSONObject.optString("button_title");
                    optJSONObject.optLong("effect_time");
                    optJSONObject.optLong("expire_time");
                    this.v.o = aVar;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject2 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.w = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
            if (optJSONObject3 != null) {
                x1 x1Var = new x1();
                this.x = x1Var;
                x1Var.g(optJSONObject3);
            }
            this.y = jSONObject.optLong("last_time_int");
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                this.z = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    p pVar = new p();
                    pVar.a(optJSONArray.getJSONObject(i4));
                    this.z.add(pVar);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("works_info");
            if (optJSONObject4 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                this.A = worksInfoData;
                worksInfoData.parseJson(optJSONObject4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.p0.b2.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.B = z;
        }
    }

    @Override // c.a.p0.b2.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }
}
