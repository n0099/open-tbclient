package c.a.s0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.RecomPostTopic;
/* loaded from: classes6.dex */
public class o1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13466b;

    /* renamed from: c  reason: collision with root package name */
    public long f13467c;

    public o1() {
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

    public void a(RecomPostTopic recomPostTopic) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recomPostTopic) == null) || recomPostTopic == null) {
            return;
        }
        this.a = recomPostTopic.recom_title;
        this.f13466b = recomPostTopic.recom_topic;
        this.f13467c = recomPostTopic.uniq_topicid.longValue();
    }
}
