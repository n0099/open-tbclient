package c.a.r0.n1.k.b.c;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
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
/* loaded from: classes6.dex */
public class a extends c.a.r0.g0.f0.b {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId h0;
    public static final BdUniqueId i0;
    public transient /* synthetic */ FieldHolder $fh;
    public int W;
    public long X;
    public String Y;
    public String Z;
    public long a0;
    public String b0;
    public b c0;
    public PostData d0;
    public int e0;
    public String f0;
    public d2 g0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1358208568, "Lc/a/r0/n1/k/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1358208568, "Lc/a/r0/n1/k/b/c/a;");
                return;
            }
        }
        h0 = BdUniqueId.gen();
        i0 = BdUniqueId.gen();
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
        this.e0 = 0;
    }

    public static boolean P(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d2Var)) == null) ? d2Var != null && d2Var.getType() == d2.u3 : invokeL.booleanValue;
    }

    public void Q(NewTopicList newTopicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newTopicList) == null) || newTopicList == null) {
            return;
        }
        this.X = newTopicList.topic_id.longValue();
        this.Y = newTopicList.topic_name;
        this.Z = newTopicList.topic_desc;
        this.a0 = newTopicList.discuss_num.longValue();
        this.b0 = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            b bVar = new b();
            this.c0 = bVar;
            bVar.a = this.X;
            bVar.f20705f = 1;
            bVar.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.d0 = postData;
            postData.g0(newTopicList.top_agree_post);
        }
    }

    public void R(TopicModule topicModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, topicModule) == null) || topicModule == null) {
            return;
        }
        this.X = topicModule.topic_id.longValue();
        this.Y = topicModule.topic_name;
        this.Z = topicModule.topic_desc;
        this.b0 = topicModule.topic_image;
        this.f0 = topicModule.topic_avatar;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        b bVar = new b();
        this.c0 = bVar;
        bVar.a = this.X;
        bVar.f20705f = 3;
        bVar.c(topicModule.pk_module);
    }

    public void S(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            this.g0 = d2Var;
        }
    }

    @Override // c.a.r0.g0.f0.b, c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            x0 negFeedBackData = super.getNegFeedBackData();
            if (negFeedBackData != null) {
                negFeedBackData.q(this.X);
            }
            return negFeedBackData;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.r0.g0.f0.b, c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g0 : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e0 == 0 ? h0 : i0 : (BdUniqueId) invokeV.objValue;
    }
}
