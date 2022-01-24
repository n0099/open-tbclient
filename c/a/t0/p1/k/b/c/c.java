package c.a.t0.p1.k.b.c;

import c.a.s0.s.q.e2;
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
/* loaded from: classes8.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f21004e;

    /* renamed from: f  reason: collision with root package name */
    public e2 f21005f;

    /* renamed from: g  reason: collision with root package name */
    public long f21006g;

    /* renamed from: h  reason: collision with root package name */
    public int f21007h;

    /* renamed from: i  reason: collision with root package name */
    public int f21008i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f21009j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1048155958, "Lc/a/t0/p1/k/b/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1048155958, "Lc/a/t0/p1/k/b/c/c;");
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
        this.f21004e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            e2 e2Var = new e2();
            this.f21005f = e2Var;
            e2Var.d3(topicThread.thread_info);
            this.f21005f.h3();
        }
        this.f21007h = topicThread.user_agree.intValue();
        this.f21008i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
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
        this.f21004e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            e2 e2Var = new e2();
            this.f21005f = e2Var;
            e2Var.d3(topicThread.thread_info);
            this.f21005f.h3();
        }
        this.f21007h = Integer.parseInt(topicThread.user_agree);
        this.f21008i = topicThread.source.intValue();
    }
}
