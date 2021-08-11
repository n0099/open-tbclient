package c.a.p0.f2.d;

import androidx.annotation.NonNull;
import c.a.e.k.e.n;
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
    public long f17753e;

    /* renamed from: f  reason: collision with root package name */
    public int f17754f;

    /* renamed from: g  reason: collision with root package name */
    public String f17755g;

    /* renamed from: h  reason: collision with root package name */
    public String f17756h;

    /* renamed from: i  reason: collision with root package name */
    public long f17757i;

    /* renamed from: j  reason: collision with root package name */
    public String f17758j;
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
        this.f17754f = i2 + 1;
        this.f17755g = newTopicList.topic_name;
        this.f17756h = newTopicList.topic_desc;
        this.f17757i = newTopicList.discuss_num.longValue();
        this.f17758j = newTopicList.topic_image;
        this.k = newTopicList.topic_tag.intValue();
        this.f17753e = newTopicList.topic_id.longValue();
    }

    @Override // c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f17752a : (BdUniqueId) invokeV.objValue;
    }
}
