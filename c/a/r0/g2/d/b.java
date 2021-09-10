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
    public long f18620e;

    /* renamed from: f  reason: collision with root package name */
    public int f18621f;

    /* renamed from: g  reason: collision with root package name */
    public String f18622g;

    /* renamed from: h  reason: collision with root package name */
    public String f18623h;

    /* renamed from: i  reason: collision with root package name */
    public long f18624i;

    /* renamed from: j  reason: collision with root package name */
    public String f18625j;
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
        this.f18621f = i2 + 1;
        this.f18622g = newTopicList.topic_name;
        this.f18623h = newTopicList.topic_desc;
        this.f18624i = newTopicList.discuss_num.longValue();
        this.f18625j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f18620e = newTopicList.topic_id.longValue();
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f18619a : (BdUniqueId) invokeV.objValue;
    }
}
