package b.a.r0.h1.k.a.c;

import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f19065e;

    /* renamed from: f  reason: collision with root package name */
    public d2 f19066f;

    /* renamed from: g  reason: collision with root package name */
    public long f19067g;

    /* renamed from: h  reason: collision with root package name */
    public int f19068h;

    /* renamed from: i  reason: collision with root package name */
    public int f19069i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(223458098, "Lb/a/r0/h1/k/a/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(223458098, "Lb/a/r0/h1/k/a/c/c;");
                return;
            }
        }
        k = BdUniqueId.gen();
    }

    public c() {
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

    public void g(TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.f19065e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            d2 d2Var = new d2();
            this.f19066f = d2Var;
            d2Var.a3(topicThread.thread_info);
            this.f19066f.e3();
        }
        this.f19068h = topicThread.user_agree.intValue();
        this.f19069i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k : (BdUniqueId) invokeV.objValue;
    }

    public void i(tbclient.NewTopicThread.TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.f19065e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            d2 d2Var = new d2();
            this.f19066f = d2Var;
            d2Var.a3(topicThread.thread_info);
            this.f19066f.e3();
        }
        this.f19068h = Integer.parseInt(topicThread.user_agree);
        this.f19069i = topicThread.source.intValue();
    }
}
