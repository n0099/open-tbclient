package c.a.t0.p1.k.b.e;

import android.content.Context;
import android.text.InputFilter;
import c.a.d.f.p.n;
import c.a.s0.x.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends c.a.s0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes8.dex */
    public class a implements c.a.s0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.p1.k.b.e.a f21033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21034f;

        public a(b bVar, c.a.t0.p1.k.b.e.a aVar) {
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
            this.f21034f = bVar;
            this.f21033e = aVar;
        }

        @Override // c.a.s0.x.b
        public void onAction(c.a.s0.x.a aVar) {
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4 || i2 == 6) {
                this.f21033e.G((String) aVar.f14320c);
                this.f21034f.a = false;
            } else if (i2 == 7) {
                this.f21033e.getContext().showToast(R.string.over_limit_tip);
                this.f21034f.a = true;
            } else if (i2 == 8) {
                if (this.f21034f.g(this.f21033e.getContext(), 11001)) {
                    this.f21033e.x();
                    TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.f21033e.r())));
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f14320c).intValue();
                if (this.f21033e.q() != null && this.f21033e.q().getChosedFiles() != null && (size = this.f21033e.q().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f21033e.getContext().getPageActivity(), 12012, this.f21033e.q(), intValue)));
                }
            } else {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f21033e.getContext().getPageActivity(), this.f21033e.q().toJsonString(), true, true);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                if (c.a.s0.x.y.a.a().b() == 1) {
                    albumActivityConfig.setRequestFrom(4);
                    if (this.f21033e.q() != null) {
                        this.f21033e.q().setMaxImagesAllowed(1);
                    }
                } else if (this.f21033e.q() != null) {
                    this.f21033e.q().setMaxImagesAllowed(10);
                }
                n.w(this.f21033e.getContext().getPageActivity(), this.f21033e.getContext().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
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

    @Override // c.a.s0.x.c
    public c.a.s0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            return new c.a.t0.p1.k.b.e.a(editorTools);
        }
        return (c.a.s0.x.e) invokeL.objValue;
    }

    @Override // c.a.s0.x.c
    public void c(c.a.s0.x.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        a aVar = new a(this, (c.a.t0.p1.k.b.e.a) eVar);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(6, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(45, aVar);
    }

    @Override // c.a.s0.x.c
    public void d(c.a.s0.x.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.e(false);
                findToolById.f14337j = 1;
            }
            a2.addTool(new c.a.s0.x.r.d(a2.getContext(), 3));
            c cVar = new c(a2.getContext());
            if (cVar.f() != null) {
                cVar.f().setFilters(new InputFilter[]{new InputFilter.LengthFilter(w0.O1)});
            }
            a2.addTool(cVar);
            a2.build();
            a2.sendAction(new c.a.s0.x.a(35, 5, Boolean.FALSE));
            a2.hideTools();
        }
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i2) {
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
