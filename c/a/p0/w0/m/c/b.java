package c.a.p0.w0.m.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f19498b;

    /* renamed from: c  reason: collision with root package name */
    public String f19499c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f19500d;

    /* renamed from: e  reason: collision with root package name */
    public int f19501e;

    /* renamed from: f  reason: collision with root package name */
    public int f19502f;

    /* renamed from: g  reason: collision with root package name */
    public String f19503g;

    /* renamed from: h  reason: collision with root package name */
    public int f19504h;

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

    public void a(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recommendForumInfo) == null) {
            this.a = recommendForumInfo.avatar;
            this.f19498b = recommendForumInfo.forum_id.longValue();
            this.f19499c = recommendForumInfo.forum_name;
            this.f19500d = recommendForumInfo.is_like.intValue() == 1;
            this.f19501e = recommendForumInfo.member_count.intValue();
            this.f19502f = recommendForumInfo.thread_count.intValue();
            String str = recommendForumInfo.slogan;
            recommendForumInfo.forum_type.intValue();
            String str2 = recommendForumInfo.authen;
            this.f19503g = recommendForumInfo.recom_reason;
            recommendForumInfo.is_brand_forum.intValue();
            String str3 = recommendForumInfo.hot_text;
            String str4 = recommendForumInfo.abtest_tag;
            String str5 = recommendForumInfo.source;
            String str6 = recommendForumInfo.extra;
            this.f19504h = 1;
        }
    }
}
