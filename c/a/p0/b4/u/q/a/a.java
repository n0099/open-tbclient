package c.a.p0.b4.u.q.a;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.u.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassReqMessage;
import com.baidu.tieba.write.write.work.selecttag.model.GetSelectTagReqMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f16244a;

    /* renamed from: b  reason: collision with root package name */
    public List<List<String>> f16245b;

    /* renamed from: c  reason: collision with root package name */
    public n f16246c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f16247d;

    public a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16244a = new ArrayList();
        this.f16245b = new ArrayList();
        this.f16246c = new n();
        this.f16247d = bdUniqueId;
    }

    public n a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            this.f16246c.d(this.f16244a.get(i2));
            this.f16246c.e(this.f16245b.get(i2).get(i3));
            this.f16246c.c().clear();
            return this.f16246c;
        }
        return (n) invokeII.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16244a : (List) invokeV.objValue;
    }

    public List<List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16245b : (List) invokeV.objValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16246c.c() : (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetSelectClassReqMessage getSelectClassReqMessage = new GetSelectClassReqMessage();
            getSelectClassReqMessage.setTag(this.f16247d);
            MessageManager.getInstance().sendMessage(getSelectClassReqMessage);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GetSelectTagReqMessage getSelectTagReqMessage = new GetSelectTagReqMessage();
            getSelectTagReqMessage.setTag(this.f16247d);
            getSelectTagReqMessage.setFirstClass(this.f16246c.a());
            getSelectTagReqMessage.setSecondClass(this.f16246c.b());
            MessageManager.getInstance().sendMessage(getSelectTagReqMessage);
        }
    }

    public void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f16244a.clear();
            this.f16244a.addAll(list);
        }
    }

    public void h(List<List<String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f16245b.clear();
            this.f16245b.addAll(list);
        }
    }

    public void i(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) {
            this.f16246c = nVar;
        }
    }
}
