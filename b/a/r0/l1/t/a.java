package b.a.r0.l1.t;

import b.a.e.e.d.l;
import b.a.e.e.p.p;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ChatSetting> f20389a;

    /* renamed from: b.a.r0.l1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1014a extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20390a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20391b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f20392c;

        public C1014a(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20392c = aVar;
            this.f20390a = str;
            this.f20391b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.d1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChatSetting a2 = this.f20392c.a(this.f20390a, this.f20391b);
                if (a2 == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(a2.isAcceptNotify());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public a() {
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
        this.f20389a = new HashMap<>();
    }

    public abstract ChatSetting a(String str, String str2);

    public abstract l<String> b();

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            ChatSetting a2 = a(str, str2);
            if (a2 == null) {
                return false;
            }
            return a2.isAcceptNotify();
        }
        return invokeLL.booleanValue;
    }

    public void d(String str, String str2, q<Boolean> qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, qVar) == null) {
            l0.c(new C1014a(this, str, str2), qVar);
        }
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this.f20389a) {
                this.f20389a.clear();
            }
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (id == null || id.length() == 0) {
                return;
            }
            String str2 = id + "@";
            synchronized (this.f20389a) {
                l<String> b2 = b();
                List<l.b<String>> b3 = p.b(b2);
                if (b3 != null) {
                    for (l.b<String> bVar : b3) {
                        String str3 = bVar.f1704a;
                        if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                            this.f20389a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, str, str2, z) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        h(a2);
    }

    public void g(String str, String str2, boolean z, q<Void> qVar) {
        ChatSetting a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), qVar}) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setAcceptNotify(z);
        i(a2, qVar);
    }

    public abstract void h(ChatSetting chatSetting);

    public abstract void i(ChatSetting chatSetting, q<Void> qVar);
}
