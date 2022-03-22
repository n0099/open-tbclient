package c.a.p0.f1;

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
/* loaded from: classes2.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<FrsTabInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.o0.h0.b> f14107b;

    /* renamed from: c  reason: collision with root package name */
    public Context f14108c;

    /* renamed from: d  reason: collision with root package name */
    public String f14109d;

    /* renamed from: e  reason: collision with root package name */
    public String f14110e;

    /* renamed from: f  reason: collision with root package name */
    public String f14111f;

    /* renamed from: g  reason: collision with root package name */
    public String f14112g;

    public j0(Context context, List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.f14107b = new LinkedList();
        this.f14108c = context;
    }

    public void a(c.a.o0.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || bVar.b() == null) {
            return;
        }
        for (c.a.o0.h0.b bVar2 : this.f14107b) {
            if (bVar2 != null && bVar2.b() != null && bVar2.b().f10299e == bVar.b().f10299e) {
                return;
            }
        }
        this.f14107b.add(bVar);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14111f : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14109d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14110e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14112g : (String) invokeV.objValue;
    }

    public List<FrsTabInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public List<c.a.o0.h0.b> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14107b : (List) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14108c : (Context) invokeV.objValue;
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i < 100 && !ListUtils.isEmpty(this.a)) {
                for (FrsTabInfo frsTabInfo : this.a) {
                    if (frsTabInfo.tab_id.intValue() == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f14111f = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f14109d = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f14110e = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f14112g = str;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (FrsTabInfo frsTabInfo : this.a) {
                boolean z = false;
                Iterator<c.a.o0.h0.b> it = this.f14107b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c.a.o0.h0.b next = it.next();
                    if (next.b() != null && frsTabInfo.tab_id.intValue() == next.b().f10299e) {
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
                this.a.removeAll(linkedList2);
            }
            this.f14107b.clear();
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            this.f14107b.addAll(linkedList);
        }
    }
}
