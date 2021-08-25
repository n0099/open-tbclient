package c.a.q0.v0;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<FrsTabInfo> f26213a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.p0.g0.b> f26214b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26215c;

    /* renamed from: d  reason: collision with root package name */
    public String f26216d;

    /* renamed from: e  reason: collision with root package name */
    public String f26217e;

    /* renamed from: f  reason: collision with root package name */
    public String f26218f;

    /* renamed from: g  reason: collision with root package name */
    public String f26219g;

    public i0(Context context, List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26213a = list;
        this.f26214b = new LinkedList();
        this.f26215c = context;
    }

    public void a(c.a.p0.g0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        for (c.a.p0.g0.b bVar2 : this.f26214b) {
            if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().f13480e == bVar.getFragmentTabStructure().f13480e) {
                return;
            }
        }
        this.f26214b.add(bVar);
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26215c : (Context) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26218f : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26216d : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26217e : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26219g : (String) invokeV.objValue;
    }

    public List<FrsTabInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26213a : (List) invokeV.objValue;
    }

    public List<c.a.p0.g0.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26214b : (List) invokeV.objValue;
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 < 100 && !ListUtils.isEmpty(this.f26213a)) {
                for (FrsTabInfo frsTabInfo : this.f26213a) {
                    if (frsTabInfo.tab_id.intValue() == i2) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f26218f = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f26216d = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f26217e = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f26219g = str;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (FrsTabInfo frsTabInfo : this.f26213a) {
                boolean z = false;
                Iterator<c.a.p0.g0.b> it = this.f26214b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c.a.p0.g0.b next = it.next();
                    if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().f13480e) {
                        linkedList.add(next);
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    linkedList2.add(frsTabInfo);
                }
            }
            if (!ListUtils.isEmpty(linkedList2)) {
                this.f26213a.removeAll(linkedList2);
            }
            this.f26214b.clear();
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            this.f26214b.addAll(linkedList);
        }
    }
}
