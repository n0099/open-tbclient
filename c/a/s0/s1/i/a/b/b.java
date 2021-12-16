package c.a.s0.s1.i.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f22188b;

    /* renamed from: c  reason: collision with root package name */
    public String f22189c;

    /* renamed from: d  reason: collision with root package name */
    public long f22190d;

    /* renamed from: e  reason: collision with root package name */
    public int f22191e;

    /* renamed from: f  reason: collision with root package name */
    public long f22192f;

    /* renamed from: g  reason: collision with root package name */
    public int f22193g;

    /* renamed from: h  reason: collision with root package name */
    public String f22194h;

    /* renamed from: i  reason: collision with root package name */
    public int f22195i;

    /* renamed from: j  reason: collision with root package name */
    public RecommendForumInfo f22196j;

    /* renamed from: k  reason: collision with root package name */
    public ThreadInfo f22197k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22195i : invokeV.intValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22192f : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22188b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22194h : (String) invokeV.objValue;
    }

    public RecommendForumInfo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22196j : (RecommendForumInfo) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22189c : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22190d : invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22191e : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22193g : invokeV.intValue;
    }

    public ThreadInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22197k : (ThreadInfo) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void l(BroadcastInfo broadcastInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, broadcastInfo) == null) || broadcastInfo == null) {
            return;
        }
        this.f22192f = broadcastInfo.bcast_id.longValue();
        this.a = broadcastInfo.title;
        this.f22188b = broadcastInfo.content;
        this.f22189c = broadcastInfo.pic_url;
        this.f22190d = broadcastInfo.publish_time.intValue();
        this.f22191e = broadcastInfo.pushuser_cnt.intValue();
        this.f22196j = broadcastInfo.forum_info;
        this.f22197k = broadcastInfo.thread_infos;
        this.f22194h = broadcastInfo.ctr;
        this.f22193g = broadcastInfo.pv.intValue();
        this.f22195i = broadcastInfo.audit_status.intValue();
    }
}
