package c.a.p0.s1.b;

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
/* loaded from: classes2.dex */
public class f implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18157b;

    /* renamed from: c  reason: collision with root package name */
    public String f18158c;

    /* renamed from: d  reason: collision with root package name */
    public long f18159d;

    /* renamed from: e  reason: collision with root package name */
    public String f18160e;

    /* renamed from: f  reason: collision with root package name */
    public String f18161f;

    /* renamed from: g  reason: collision with root package name */
    public String f18162g;

    /* renamed from: h  reason: collision with root package name */
    public String f18163h;
    public long i;
    public h j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-379688630, "Lc/a/p0/s1/b/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-379688630, "Lc/a/p0/s1/b/f;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = String.valueOf(topicInfo.topic_id);
        this.f18157b = topicInfo.topic_name;
        this.f18158c = topicInfo.desc;
        this.f18159d = topicInfo.total_post_num.longValue();
        this.f18160e = topicInfo.head_photo_url;
        this.f18161f = topicInfo.head_background_url;
        this.f18162g = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        this.f18163h = topicInfo.share_pic;
        this.i = topicInfo.idx_num.longValue();
        Long l2 = topicInfo.pmy_topic_id;
        String str = topicInfo.head_photo_jump_url;
        Integer num = topicInfo.pmy_source;
        this.k = topicInfo.is_deleted.longValue() == 1;
        VideoInfo videoInfo = topicInfo.video_info;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
            VideoInfo videoInfo2 = topicInfo.video_info;
            String str2 = videoInfo2.video_md5;
            String str3 = videoInfo2.video_url;
            videoInfo2.video_duration.intValue();
            topicInfo.video_info.video_width.intValue();
            topicInfo.video_info.video_height.intValue();
            VideoInfo videoInfo3 = topicInfo.video_info;
            String str4 = videoInfo3.thumbnail_url;
            videoInfo3.thumbnail_width.intValue();
            topicInfo.video_info.thumbnail_height.intValue();
            topicInfo.video_info.video_length.intValue();
            topicInfo.video_info.play_count.intValue();
        }
        String str5 = topicInfo.tag_list_type;
        if (topicInfo.join_info != null) {
            h hVar = new h();
            this.j = hVar;
            hVar.a(topicInfo.join_info);
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }
}
