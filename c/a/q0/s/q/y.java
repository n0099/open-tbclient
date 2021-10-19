package c.a.q0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.Size;
/* loaded from: classes3.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b0> f14379a;

    /* renamed from: b  reason: collision with root package name */
    public String f14380b;

    /* renamed from: c  reason: collision with root package name */
    public d f14381c;

    public y() {
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
        this.f14379a = new ArrayList<>();
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14381c : (d) invokeV.objValue;
    }

    public ArrayList<b0> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14379a : (ArrayList) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14380b : (String) invokeV.objValue;
    }

    public void d(ActivityHead activityHead, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, activityHead, j2) == null) || activityHead == null) {
            return;
        }
        activityHead.activity_type.intValue();
        String str = activityHead.activity_title;
        Size size = activityHead.top_size;
        if (size != null) {
            size.width.intValue();
        }
        Size size2 = activityHead.top_size;
        if (size2 != null) {
            size2.height.intValue();
        }
        this.f14380b = activityHead.obj_id;
        f(activityHead.head_imgs);
        d dVar = new d();
        dVar.f14146a = activityHead.pull_down_pic_android;
        dVar.f14147b = activityHead.pull_down_url;
        dVar.f14148c = activityHead.pull_down_interval.intValue();
        dVar.f14149d = activityHead.pull_down_exposure_url;
        dVar.f14150e = activityHead.pull_down_click_url;
        dVar.f14151f = activityHead.pull_down_schema;
        dVar.f14152g = activityHead.pull_down_package_name;
        dVar.f14153h = activityHead.is_ad.booleanValue();
        dVar.f14154i = activityHead.obj_id;
        dVar.f14155j = j2;
        this.f14381c = dVar;
    }

    public void e(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, headImgs) == null) || headImgs == null) {
            return;
        }
        b0 b0Var = new b0();
        b0Var.l(headImgs);
        this.f14379a.add(b0Var);
    }

    public void f(List<HeadImgs> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (HeadImgs headImgs : list) {
            e(headImgs);
        }
    }

    public void g(ArrayList<b0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f14379a = arrayList;
        }
    }
}
