package c.a.s0.u0.k.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f24255b;

    /* renamed from: c  reason: collision with root package name */
    public String f24256c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24257d;

    /* renamed from: e  reason: collision with root package name */
    public int f24258e;

    /* renamed from: f  reason: collision with root package name */
    public int f24259f;

    /* renamed from: g  reason: collision with root package name */
    public String f24260g;

    /* renamed from: h  reason: collision with root package name */
    public int f24261h;

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

    public void a(RecommendForumInfo recommendForumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recommendForumInfo) == null) {
            this.a = recommendForumInfo.avatar;
            this.f24255b = recommendForumInfo.forum_id.longValue();
            this.f24256c = recommendForumInfo.forum_name;
            this.f24257d = recommendForumInfo.is_like.intValue() == 1;
            this.f24258e = recommendForumInfo.member_count.intValue();
            this.f24259f = recommendForumInfo.thread_count.intValue();
            String str = recommendForumInfo.slogan;
            recommendForumInfo.forum_type.intValue();
            String str2 = recommendForumInfo.authen;
            this.f24260g = recommendForumInfo.recom_reason;
            recommendForumInfo.is_brand_forum.intValue();
            String str3 = recommendForumInfo.hot_text;
            String str4 = recommendForumInfo.abtest_tag;
            String str5 = recommendForumInfo.source;
            String str6 = recommendForumInfo.extra;
            this.f24261h = 1;
        }
    }
}
