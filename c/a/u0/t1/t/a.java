package c.a.u0.t1.t;

import c.a.d.f.d.l;
import c.a.t0.d1.l0;
import c.a.t0.d1.o0;
import c.a.t0.d1.s;
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
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ChatSetting> a;

    /* renamed from: c.a.u0.t1.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1397a extends l0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f22736c;

        public C1397a(a aVar, String str, String str2) {
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
            this.f22736c = aVar;
            this.a = str;
            this.f22735b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.t0.d1.l0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ChatSetting a = this.f22736c.a(this.a, this.f22735b);
                if (a == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(a.isAcceptNotify());
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
        this.a = new HashMap<>();
    }

    public abstract ChatSetting a(String str, String str2);

    public abstract l<String> b();

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            ChatSetting a = a(str, str2);
            if (a == null) {
                return false;
            }
            return a.isAcceptNotify();
        }
        return invokeLL.booleanValue;
    }

    public void d(String str, String str2, s<Boolean> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, sVar) == null) {
            o0.c(new C1397a(this, str, str2), sVar);
        }
    }

    public void e(Class<? extends ChatSetting> cls) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (id == null || id.length() == 0) {
                return;
            }
            String str2 = id + "@";
            synchronized (this.a) {
                l<String> b2 = b();
                List<l.b<String>> b3 = c.a.d.f.p.s.b(b2);
                if (b3 != null) {
                    for (l.b<String> bVar : b3) {
                        String str3 = bVar.a;
                        if (str3 != null && str3.startsWith(str2) && (str = b2.get(str3)) != null) {
                            this.a.put(str3, (ChatSetting) OrmObject.objectWithJsonStr(str, cls));
                        }
                    }
                }
            }
        }
    }

    public void f(String str, String str2, boolean z) {
        ChatSetting a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, str, str2, z) == null) || (a = a(str, str2)) == null) {
            return;
        }
        a.setAcceptNotify(z);
        h(a);
    }

    public void g(String str, String str2, boolean z, s<Void> sVar) {
        ChatSetting a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), sVar}) == null) || (a = a(str, str2)) == null) {
            return;
        }
        a.setAcceptNotify(z);
        i(a, sVar);
    }

    public abstract void h(ChatSetting chatSetting);

    public abstract void i(ChatSetting chatSetting, s<Void> sVar);
}
