package c.a.t0.p2.d;

import androidx.annotation.NonNull;
import c.a.d.n.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.NewTopicList;
/* loaded from: classes8.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f22008e;

    /* renamed from: f  reason: collision with root package name */
    public int f22009f;

    /* renamed from: g  reason: collision with root package name */
    public String f22010g;

    /* renamed from: h  reason: collision with root package name */
    public String f22011h;

    /* renamed from: i  reason: collision with root package name */
    public long f22012i;

    /* renamed from: j  reason: collision with root package name */
    public String f22013j;

    /* renamed from: k  reason: collision with root package name */
    public int f22014k;
    public int l;

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
        this.f22009f = i2 + 1;
        this.f22010g = newTopicList.topic_name;
        this.f22011h = newTopicList.topic_desc;
        this.f22012i = newTopicList.discuss_num.longValue();
        this.f22013j = newTopicList.topic_image;
        this.f22014k = newTopicList.topic_tag.intValue();
        this.f22008e = newTopicList.topic_id.longValue();
        this.l = newTopicList.is_video_topic.intValue();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l == 1 : invokeV.booleanValue;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.a : (BdUniqueId) invokeV.objValue;
    }
}
