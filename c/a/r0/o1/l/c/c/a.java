package c.a.r0.o1.l.c.c;

import c.a.q0.r.r.e2;
import c.a.q0.r.r.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes2.dex */
public class a extends c.a.r0.f0.d0.b {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId g0;
    public static final BdUniqueId h0;
    public transient /* synthetic */ FieldHolder $fh;
    public int V;
    public long W;
    public String X;
    public String Y;
    public long Z;
    public String a0;
    public b b0;
    public PostData c0;
    public int d0;
    public String e0;
    public e2 f0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1332696695, "Lc/a/r0/o1/l/c/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1332696695, "Lc/a/r0/o1/l/c/c/a;");
                return;
            }
        }
        g0 = BdUniqueId.gen();
        h0 = BdUniqueId.gen();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d0 = 0;
    }

    public static boolean O(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e2Var)) == null) ? e2Var != null && e2Var.getType() == e2.y3 : invokeL.booleanValue;
    }

    public void P(NewTopicList newTopicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newTopicList) == null) || newTopicList == null) {
            return;
        }
        this.W = newTopicList.topic_id.longValue();
        this.X = newTopicList.topic_name;
        this.Y = newTopicList.topic_desc;
        this.Z = newTopicList.discuss_num.longValue();
        this.a0 = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            b bVar = new b();
            this.b0 = bVar;
            bVar.a = this.W;
            bVar.f20266f = 1;
            bVar.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.c0 = postData;
            postData.h0(newTopicList.top_agree_post);
        }
    }

    public void Q(TopicModule topicModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicModule) == null) || topicModule == null) {
            return;
        }
        this.W = topicModule.topic_id.longValue();
        this.X = topicModule.topic_name;
        this.Y = topicModule.topic_desc;
        this.a0 = topicModule.topic_image;
        this.e0 = topicModule.topic_avatar;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        b bVar = new b();
        this.b0 = bVar;
        bVar.a = this.W;
        bVar.f20266f = 3;
        bVar.c(topicModule.pk_module);
    }

    public void R(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            this.f0 = e2Var;
        }
    }

    @Override // c.a.r0.f0.d0.b, c.a.q0.r.r.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            x0 negFeedBackData = super.getNegFeedBackData();
            if (negFeedBackData != null) {
                negFeedBackData.q(this.W);
            }
            return negFeedBackData;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.r0.f0.d0.b, c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f0 : (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d0 == 0 ? g0 : h0 : (BdUniqueId) invokeV.objValue;
    }
}
