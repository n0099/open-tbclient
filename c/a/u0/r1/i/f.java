package c.a.u0.r1.i;

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
public class f implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f21753e;

    /* renamed from: f  reason: collision with root package name */
    public String f21754f;

    /* renamed from: g  reason: collision with root package name */
    public String f21755g;

    /* renamed from: h  reason: collision with root package name */
    public long f21756h;

    /* renamed from: i  reason: collision with root package name */
    public String f21757i;

    /* renamed from: j  reason: collision with root package name */
    public String f21758j;
    public String k;
    public String l;
    public long m;
    public h n;
    public boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2045415997, "Lc/a/u0/r1/i/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2045415997, "Lc/a/u0/r1/i/f;");
                return;
            }
        }
        p = BdUniqueId.gen();
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
        this.f21753e = String.valueOf(topicInfo.topic_id);
        this.f21754f = topicInfo.topic_name;
        this.f21755g = topicInfo.desc;
        this.f21756h = topicInfo.total_post_num.longValue();
        this.f21757i = topicInfo.head_photo_url;
        this.f21758j = topicInfo.head_background_url;
        this.k = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        this.l = topicInfo.share_pic;
        this.m = topicInfo.idx_num.longValue();
        Long l = topicInfo.pmy_topic_id;
        String str = topicInfo.head_photo_jump_url;
        Integer num = topicInfo.pmy_source;
        this.o = topicInfo.is_deleted.longValue() == 1;
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
            this.n = hVar;
            hVar.a(topicInfo.join_info);
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? p : (BdUniqueId) invokeV.objValue;
    }
}
