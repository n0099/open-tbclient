package c.a.s0.p2.d;

import androidx.annotation.NonNull;
import c.a.d.m.e.n;
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
    public long f21492e;

    /* renamed from: f  reason: collision with root package name */
    public int f21493f;

    /* renamed from: g  reason: collision with root package name */
    public String f21494g;

    /* renamed from: h  reason: collision with root package name */
    public String f21495h;

    /* renamed from: i  reason: collision with root package name */
    public long f21496i;

    /* renamed from: j  reason: collision with root package name */
    public String f21497j;

    /* renamed from: k  reason: collision with root package name */
    public int f21498k;
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
        this.f21493f = i2 + 1;
        this.f21494g = newTopicList.topic_name;
        this.f21495h = newTopicList.topic_desc;
        this.f21496i = newTopicList.discuss_num.longValue();
        this.f21497j = newTopicList.topic_image;
        this.f21498k = newTopicList.topic_tag.intValue();
        this.f21492e = newTopicList.topic_id.longValue();
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

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a.a : (BdUniqueId) invokeV.objValue;
    }
}
