package c.a.p0.t2.d;

import androidx.annotation.NonNull;
import c.a.d.o.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes2.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f18608b;

    /* renamed from: c  reason: collision with root package name */
    public String f18609c;

    /* renamed from: d  reason: collision with root package name */
    public String f18610d;

    /* renamed from: e  reason: collision with root package name */
    public long f18611e;

    /* renamed from: f  reason: collision with root package name */
    public String f18612f;

    /* renamed from: g  reason: collision with root package name */
    public int f18613g;

    /* renamed from: h  reason: collision with root package name */
    public int f18614h;

    public b(@NonNull NewTopicList newTopicList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newTopicList, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18608b = i + 1;
        this.f18609c = newTopicList.topic_name;
        this.f18610d = newTopicList.topic_desc;
        this.f18611e = newTopicList.discuss_num.longValue();
        this.f18612f = newTopicList.topic_image;
        this.f18613g = newTopicList.topic_tag.intValue();
        this.a = newTopicList.topic_id.longValue();
        this.f18614h = newTopicList.is_video_topic.intValue();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18614h : invokeV.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18614h == 1 : invokeV.booleanValue;
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.a : (BdUniqueId) invokeV.objValue;
    }
}
