package c.a.t0.q1.l;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Hottopic.TopicInfo;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class f implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f21543e;

    /* renamed from: f  reason: collision with root package name */
    public String f21544f;

    /* renamed from: g  reason: collision with root package name */
    public String f21545g;

    /* renamed from: h  reason: collision with root package name */
    public long f21546h;

    /* renamed from: i  reason: collision with root package name */
    public String f21547i;

    /* renamed from: j  reason: collision with root package name */
    public String f21548j;
    public String k;
    public String l;
    public long m;
    public String n;
    public String o;
    public Long p;
    public Integer q;
    public h r;
    public String s;
    public boolean t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1354515194, "Lc/a/t0/q1/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1354515194, "Lc/a/t0/q1/l/f;");
                return;
            }
        }
        u = BdUniqueId.gen();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(TopicInfo topicInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicInfo) == null) || topicInfo == null) {
            return;
        }
        this.f21543e = String.valueOf(topicInfo.topic_id);
        this.f21544f = topicInfo.topic_name;
        this.f21545g = topicInfo.desc;
        this.f21546h = topicInfo.total_post_num.longValue();
        this.f21547i = topicInfo.head_photo_url;
        this.f21548j = topicInfo.head_background_url;
        this.k = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        this.l = topicInfo.share_pic;
        this.m = topicInfo.idx_num.longValue();
        this.p = topicInfo.pmy_topic_id;
        this.s = topicInfo.head_photo_jump_url;
        this.q = topicInfo.pmy_source;
        this.t = topicInfo.is_deleted.longValue() == 1;
        VideoInfo videoInfo = topicInfo.video_info;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
            VideoInfo videoInfo2 = topicInfo.video_info;
            String str = videoInfo2.video_md5;
            this.n = videoInfo2.video_url;
            videoInfo2.video_duration.intValue();
            topicInfo.video_info.video_width.intValue();
            topicInfo.video_info.video_height.intValue();
            VideoInfo videoInfo3 = topicInfo.video_info;
            String str2 = videoInfo3.thumbnail_url;
            videoInfo3.thumbnail_width.intValue();
            topicInfo.video_info.thumbnail_height.intValue();
            topicInfo.video_info.video_length.intValue();
            topicInfo.video_info.play_count.intValue();
        }
        this.o = topicInfo.tag_list_type;
        if (topicInfo.join_info != null) {
            h hVar = new h();
            this.r = hVar;
            hVar.a(topicInfo.join_info);
        }
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? u : (BdUniqueId) invokeV.objValue;
    }
}
