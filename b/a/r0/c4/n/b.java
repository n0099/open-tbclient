package b.a.r0.c4.n;

import android.content.Context;
import b.a.q0.x.e;
import b.a.q0.x.m;
import b.a.r0.c4.i;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
/* loaded from: classes4.dex */
public class b extends b.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.c4.n.a f16697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16698f;

        public a(b bVar, b.a.r0.c4.n.a aVar) {
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
            this.f16698f = bVar;
            this.f16697e = aVar;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            b.a.r0.c4.n.a aVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (aVar2 = this.f16697e) == null || aVar2.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f14962a;
            if (i2 == 4) {
                this.f16697e.u((String) aVar.f14964c);
            } else if (i2 == 7) {
                this.f16697e.getContext().showToast(i.over_limit_tip);
            } else if (i2 != 8) {
            } else {
                this.f16697e.y();
                if (this.f16698f.f(this.f16697e.getContext(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f16697e.o();
                }
            }
        }
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

    @Override // b.a.q0.x.c
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarLauncherType(4);
            editorTools.setBackgroundColorId(b.a.r0.c4.c.CAM_X0207);
            return new b.a.r0.c4.n.a(editorTools);
        }
        return (e) invokeL.objValue;
    }

    @Override // b.a.q0.x.c
    public void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof b.a.r0.c4.n.a)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (b.a.r0.c4.n.a) eVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(8, aVar);
        }
    }

    @Override // b.a.q0.x.c
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
            findToolById.f14978d = 0;
        }
        a2.addTool(new c(a2.getContext()));
        a2.build();
        a2.sendAction(new b.a.q0.x.a(35, 5, Boolean.FALSE));
        a2.hide();
    }

    public final boolean f(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i2)) == null) {
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
