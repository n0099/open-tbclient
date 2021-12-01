package c.a.r0.j4.o;

import android.content.Context;
import c.a.q0.x.e;
import c.a.q0.x.m;
import c.a.r0.j4.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends c.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC1090b a;

    /* loaded from: classes6.dex */
    public class a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j4.o.a f18442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18443f;

        public a(b bVar, c.a.r0.j4.o.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18443f = bVar;
            this.f18442e = aVar;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            c.a.r0.j4.o.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f18442e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                this.f18442e.u((String) aVar.f13679c);
            } else if (i2 == 7) {
                this.f18442e.getContext().showToast(i.over_limit_tip);
            } else if (i2 != 8) {
            } else {
                this.f18442e.y();
                if (this.f18443f.h(this.f18442e.getContext(), 25066)) {
                    this.f18442e.o();
                    if (this.f18443f.a != null) {
                        this.f18443f.a.a(this.f18442e.l());
                    }
                }
            }
        }
    }

    /* renamed from: c.a.r0.j4.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1090b {
        void a(String str);
    }

    public b() {
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

    @Override // c.a.q0.x.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setHideBigEmotion(true);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(c.a.r0.j4.c.CAM_X0207);
            return new c.a.r0.j4.o.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // c.a.q0.x.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof c.a.r0.j4.o.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (c.a.r0.j4.o.a) eVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // c.a.q0.x.c
    public void d(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        a2.collect(arrayList);
        m findToolById = a2.findToolById(5);
        if (findToolById != null) {
            findToolById.e(false);
            findToolById.f13691d = 0;
        }
        a2.addTool(new c(a2.getContext()));
        a2.build();
        a2.sendAction(new c.a.q0.x.a(35, 5, Boolean.FALSE));
        a2.hide();
    }

    public e g(Context context, InterfaceC1090b interfaceC1090b) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, interfaceC1090b)) == null) {
            this.a = interfaceC1090b;
            return super.a(context);
        }
        return (e) invokeLL.objValue;
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
