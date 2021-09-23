package c.a.r0.g1.k.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f18490a;

    /* renamed from: b  reason: collision with root package name */
    public String f18491b;

    /* renamed from: c  reason: collision with root package name */
    public String f18492c;

    /* renamed from: d  reason: collision with root package name */
    public String f18493d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.g1.k.b.c.b f18494e;

    /* renamed from: f  reason: collision with root package name */
    public f f18495f;

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

    public void a(TopicDetail topicDetail) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicDetail) == null) || topicDetail == null) {
            return;
        }
        this.f18490a = topicDetail.topic_id.longValue();
        this.f18491b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f18492c = topicDetail.topic_image;
        this.f18493d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pkModule) == null) || pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        c.a.r0.g1.k.b.c.b bVar = new c.a.r0.g1.k.b.c.b();
        this.f18494e = bVar;
        bVar.f18542a = this.f18490a;
        bVar.f18547f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, timeLine) == null) || timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f18495f = fVar;
        fVar.a(this.f18490a, timeLine);
    }
}
