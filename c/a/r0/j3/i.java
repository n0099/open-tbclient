package c.a.r0.j3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsPage.BusinessPromot;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f20832a;

    /* renamed from: b  reason: collision with root package name */
    public String f20833b;

    /* renamed from: c  reason: collision with root package name */
    public String f20834c;

    /* renamed from: d  reason: collision with root package name */
    public int f20835d;

    /* renamed from: e  reason: collision with root package name */
    public String f20836e;

    /* renamed from: f  reason: collision with root package name */
    public String f20837f;

    /* renamed from: g  reason: collision with root package name */
    public String f20838g;

    /* renamed from: h  reason: collision with root package name */
    public int f20839h;

    /* renamed from: i  reason: collision with root package name */
    public long f20840i;

    /* renamed from: j  reason: collision with root package name */
    public List<j> f20841j;
    public int k;
    public List<String> l;
    public boolean m;
    public boolean n;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
    }

    public List<j> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20841j : (List) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20840i : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20833b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20834c : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20839h : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20838g : (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20836e : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f20832a : (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20835d : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f20837f : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void o(BusinessPromot businessPromot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, businessPromot) == null) || businessPromot == null) {
            return;
        }
        this.f20832a = businessPromot.title;
        this.f20833b = businessPromot.img;
        this.f20834c = businessPromot.img_popup;
        this.f20835d = businessPromot.type.intValue();
        this.f20836e = businessPromot.thread_id;
        this.f20837f = businessPromot.url;
        this.f20838g = businessPromot.schema;
        this.f20839h = businessPromot.join_num.intValue();
        this.f20840i = businessPromot.id.longValue();
        this.m = businessPromot.is_allow_shake.booleanValue();
        this.n = businessPromot.is_ad.booleanValue();
        if (businessPromot.comment_list != null) {
            this.f20841j = new LinkedList();
            for (int i2 = 0; i2 < businessPromot.comment_list.size(); i2++) {
                if (businessPromot.comment_list.get(i2) != null) {
                    j jVar = new j();
                    jVar.c(businessPromot.comment_list.get(i2));
                    this.f20841j.add(jVar);
                }
            }
        }
        this.k = businessPromot.thread_type.intValue();
        this.l = businessPromot.third_statistics_url;
    }
}
