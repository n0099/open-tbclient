package c.a.r0.n0.k.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22674a;

    /* renamed from: b  reason: collision with root package name */
    public long f22675b;

    /* renamed from: c  reason: collision with root package name */
    public String f22676c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22677d;

    /* renamed from: e  reason: collision with root package name */
    public int f22678e;

    /* renamed from: f  reason: collision with root package name */
    public int f22679f;

    /* renamed from: g  reason: collision with root package name */
    public String f22680g;

    /* renamed from: h  reason: collision with root package name */
    public int f22681h;

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
            this.f22674a = recommendForumInfo.avatar;
            this.f22675b = recommendForumInfo.forum_id.longValue();
            this.f22676c = recommendForumInfo.forum_name;
            this.f22677d = recommendForumInfo.is_like.intValue() == 1;
            this.f22678e = recommendForumInfo.member_count.intValue();
            this.f22679f = recommendForumInfo.thread_count.intValue();
            String str = recommendForumInfo.slogan;
            recommendForumInfo.forum_type.intValue();
            String str2 = recommendForumInfo.authen;
            this.f22680g = recommendForumInfo.recom_reason;
            recommendForumInfo.is_brand_forum.intValue();
            String str3 = recommendForumInfo.hot_text;
            String str4 = recommendForumInfo.abtest_tag;
            String str5 = recommendForumInfo.source;
            String str6 = recommendForumInfo.extra;
            this.f22681h = 1;
        }
    }
}
