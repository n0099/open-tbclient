package c.a.r0.g2.d;

import androidx.annotation.NonNull;
import c.a.e.l.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes3.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f18629e;

    /* renamed from: f  reason: collision with root package name */
    public int f18630f;

    /* renamed from: g  reason: collision with root package name */
    public String f18631g;

    /* renamed from: h  reason: collision with root package name */
    public String f18632h;

    /* renamed from: i  reason: collision with root package name */
    public long f18633i;

    /* renamed from: j  reason: collision with root package name */
    public String f18634j;
    public int k;

    public b(@NonNull NewTopicList newTopicList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newTopicList, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18630f = i2 + 1;
        this.f18631g = newTopicList.topic_name;
        this.f18632h = newTopicList.topic_desc;
        this.f18633i = newTopicList.discuss_num.longValue();
        this.f18634j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f18629e = newTopicList.topic_id.longValue();
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f18628a : (BdUniqueId) invokeV.objValue;
    }
}
