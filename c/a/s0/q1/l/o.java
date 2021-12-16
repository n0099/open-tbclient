package c.a.s0.q1.l;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class o implements c.a.d.m.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final BdUniqueId f21670k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f21671e;

    /* renamed from: f  reason: collision with root package name */
    public String f21672f;

    /* renamed from: g  reason: collision with root package name */
    public String f21673g;

    /* renamed from: h  reason: collision with root package name */
    public String f21674h;

    /* renamed from: i  reason: collision with root package name */
    public int f21675i;

    /* renamed from: j  reason: collision with root package name */
    public String f21676j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1551028978, "Lc/a/s0/q1/l/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1551028978, "Lc/a/s0/q1/l/o;");
                return;
            }
        }
        f21670k = BdUniqueId.gen();
    }

    public o() {
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

    public void a(MediaTopic mediaTopic) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaTopic) == null) || mediaTopic == null) {
            return;
        }
        this.f21671e = mediaTopic.topic_id.longValue();
        this.f21672f = mediaTopic.topic_name;
        this.f21673g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        d(mediaTopic.video_info);
    }

    public void d(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoInfo) == null) {
            String str = videoInfo.video_md5;
            this.f21674h = videoInfo.video_url;
            this.f21675i = videoInfo.video_duration.intValue();
            videoInfo.video_width.intValue();
            videoInfo.video_height.intValue();
            this.f21676j = videoInfo.thumbnail_url;
            videoInfo.thumbnail_width.intValue();
            videoInfo.thumbnail_height.intValue();
            videoInfo.video_length.intValue();
            videoInfo.play_count.intValue();
        }
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f21670k : (BdUniqueId) invokeV.objValue;
    }
}
