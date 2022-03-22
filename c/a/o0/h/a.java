package c.a.o0.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0810a {
        void a(boolean z, boolean z2, String str);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a b(BaseActivity baseActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, baseActivity)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, a.class, baseActivity);
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (a) runTask.getData();
        }
        return (a) invokeL.objValue;
    }

    public static a c(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921318, a.class, baseFragmentActivity);
            if (runTask == null || runTask.getData() == null) {
                return null;
            }
            return (a) runTask.getData();
        }
        return (a) invokeL.objValue;
    }

    public abstract void a();

    public abstract void d();

    public abstract boolean e();

    public abstract MarkData f();

    public abstract String g();

    public abstract void h(boolean z);

    public abstract void i(MarkData markData);

    public abstract void j(InterfaceC0810a interfaceC0810a);
}
