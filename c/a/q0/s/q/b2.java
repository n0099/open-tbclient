package c.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes5.dex */
public class b2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f12860b;

    /* renamed from: c  reason: collision with root package name */
    public long f12861c;

    /* renamed from: d  reason: collision with root package name */
    public long f12862d;

    /* renamed from: e  reason: collision with root package name */
    public long f12863e;

    /* renamed from: f  reason: collision with root package name */
    public long f12864f;

    /* renamed from: g  reason: collision with root package name */
    public String f12865g;

    /* renamed from: h  reason: collision with root package name */
    public int f12866h;

    /* renamed from: i  reason: collision with root package name */
    public int f12867i;

    /* renamed from: j  reason: collision with root package name */
    public String f12868j;

    public b2() {
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

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12864f : invokeV.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f12860b + "";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12868j : (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12863e : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f12861c + "";
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f12862d + "";
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12867i : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12865g : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12866h : invokeV.intValue;
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("forum_name");
            this.f12860b = jSONObject.optLong("forum_id");
            this.f12861c = jSONObject.optLong("task_id");
            this.f12862d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f12863e = jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            this.f12864f = jSONObject.optLong("end_time");
            this.f12865g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f12866h = Integer.valueOf(split[0]).intValue();
                    this.f12867i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f12866h <= 0) {
                this.f12866h = 1;
            }
            if (this.f12867i <= 0) {
                this.f12867i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void l(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, taskInfo) == null) || taskInfo == null) {
            return;
        }
        this.a = taskInfo.forum_name;
        this.f12860b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f12861c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f12862d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f12865g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f12863e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f12864f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f12866h = c.a.d.f.m.b.e(split[0], 1);
                this.f12867i = c.a.d.f.m.b.e(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f12866h <= 0) {
            this.f12866h = 1;
        }
        if (this.f12867i <= 0) {
            this.f12867i = 1;
        }
        this.f12868j = taskInfo.obj_id;
    }
}
