package c.a.p0.q1.l.b.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f17558g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public ThreadData f17559b;

    /* renamed from: c  reason: collision with root package name */
    public long f17560c;

    /* renamed from: d  reason: collision with root package name */
    public int f17561d;

    /* renamed from: e  reason: collision with root package name */
    public int f17562e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17563f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1278717862, "Lc/a/p0/q1/l/b/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1278717862, "Lc/a/p0/q1/l/b/c/c;");
                return;
            }
        }
        f17558g = BdUniqueId.gen();
    }

    public c() {
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

    public void e(TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.a = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            ThreadData threadData = new ThreadData();
            this.f17559b = threadData;
            threadData.parserProtobuf(topicThread.thread_info);
            this.f17559b.parser_title();
        }
        this.f17561d = topicThread.user_agree.intValue();
        this.f17562e = topicThread.source.intValue();
    }

    public void g(tbclient.NewTopicThread.TopicThread topicThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicThread) == null) || topicThread == null) {
            return;
        }
        this.a = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            ThreadData threadData = new ThreadData();
            this.f17559b = threadData;
            threadData.parserProtobuf(topicThread.thread_info);
            this.f17559b.parser_title();
        }
        this.f17561d = Integer.parseInt(topicThread.user_agree);
        this.f17562e = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f17558g : (BdUniqueId) invokeV.objValue;
    }
}
