package c.a.p0.s.q;

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
/* loaded from: classes3.dex */
public class a2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14111a;

    /* renamed from: b  reason: collision with root package name */
    public long f14112b;

    /* renamed from: c  reason: collision with root package name */
    public long f14113c;

    /* renamed from: d  reason: collision with root package name */
    public long f14114d;

    /* renamed from: e  reason: collision with root package name */
    public long f14115e;

    /* renamed from: f  reason: collision with root package name */
    public long f14116f;

    /* renamed from: g  reason: collision with root package name */
    public String f14117g;

    /* renamed from: h  reason: collision with root package name */
    public int f14118h;

    /* renamed from: i  reason: collision with root package name */
    public int f14119i;

    /* renamed from: j  reason: collision with root package name */
    public String f14120j;

    public a2() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14116f : invokeV.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f14112b + "";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14111a : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14120j : (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14115e : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f14113c + "";
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f14114d + "";
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14119i : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14117g : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f14118h : invokeV.intValue;
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14111a = jSONObject.optString("forum_name");
            this.f14112b = jSONObject.optLong("forum_id");
            this.f14113c = jSONObject.optLong("task_id");
            this.f14114d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.f14115e = jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            this.f14116f = jSONObject.optLong("end_time");
            this.f14117g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.f14118h = Integer.valueOf(split[0]).intValue();
                    this.f14119i = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.f14118h <= 0) {
                this.f14118h = 1;
            }
            if (this.f14119i <= 0) {
                this.f14119i = 1;
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
        this.f14111a = taskInfo.forum_name;
        this.f14112b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        this.f14113c = l != null ? l.longValue() : -1L;
        Long l2 = taskInfo.thread_id;
        this.f14114d = l2 != null ? l2.longValue() : -1L;
        String str = taskInfo.bgimg;
        this.f14117g = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        this.f14115e = l3 != null ? l3.longValue() : -1L;
        Long l4 = taskInfo.end_time;
        this.f14116f = l4 != null ? l4.longValue() : -1L;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.f14118h = c.a.e.e.m.b.d(split[0], 1);
                this.f14119i = c.a.e.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f14118h <= 0) {
            this.f14118h = 1;
        }
        if (this.f14119i <= 0) {
            this.f14119i = 1;
        }
        this.f14120j = taskInfo.obj_id;
    }
}
