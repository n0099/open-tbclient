package c.a.q0.w.y;

import android.content.Context;
import c.a.q0.w.m;
import c.a.q0.w.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class i extends c.a.q0.w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f14071b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14072c;

    /* loaded from: classes2.dex */
    public class a implements c.a.q0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f14074f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f14075g;

        public a(i iVar, h hVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, hVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14075g = iVar;
            this.f14073e = hVar;
            this.f14074f = editorTools;
        }

        @Override // c.a.q0.w.b
        public void onAction(c.a.q0.w.a aVar) {
            m findToolById;
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.a;
            if (i2 == 4) {
                Object obj = aVar.f13989c;
                if (obj instanceof j) {
                    this.f14073e.Z((j) obj);
                    this.f14073e.Y(((j) aVar.f13989c).f14077c);
                } else if (obj instanceof String) {
                    this.f14073e.S((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f14073e.S(obj.toString());
                    this.f14073e.Y((SpanGroupManager) aVar.f13989c);
                }
                this.f14075g.a = false;
            } else if (i2 == 16) {
                if (this.f14075g.a) {
                    this.f14073e.getContext().showToast((int) R.string.over_limit_tip);
                }
                if (this.f14075g.h(this.f14073e.getContext(), 11025)) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f14073e.getContext().getPageActivity(), 12005, true);
                    if (this.f14073e.u() != null) {
                        atListActivityConfig.setSelectedAtList(this.f14073e.u().u());
                    }
                    EditorTools editorTools = this.f14074f;
                    if (editorTools != null) {
                        atListActivityConfig.setFromTid(editorTools.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.f14074f.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    EditorTools editorTools2 = this.f14074f;
                    if (editorTools2 != null) {
                        statisticItem.addParam("tid", editorTools2.getTid());
                        statisticItem.addParam("fid", this.f14074f.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (i2 == 7) {
                this.f14073e.getContext().showToast((int) R.string.over_limit_tip);
                this.f14075g.a = true;
            } else if (i2 == 8) {
                if (this.f14075g.h(this.f14073e.getContext(), 11001)) {
                    this.f14073e.F();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f13989c;
                if (obj2 instanceof VoiceData.VoiceModel) {
                    this.f14073e.c0((VoiceData.VoiceModel) obj2);
                    this.f14073e.v(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f14073e.c0(null);
                EditorTools editorTools3 = this.f14074f;
                if (editorTools3 == null || (findToolById = editorTools3.findToolById(6)) == null || (nVar = findToolById.k) == null) {
                    return;
                }
                nVar.onAction(new c.a.q0.w.a(52, 0, null));
            }
        }
    }

    public i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f14072c = false;
        this.f14072c = z;
    }

    @Override // c.a.q0.w.c
    public c.a.q0.w.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(this.f14072c ? 5 : 2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            h hVar = new h(editorTools);
            hVar.v = this.f14072c;
            return hVar;
        }
        return (c.a.q0.w.e) invokeL.objValue;
    }

    @Override // c.a.q0.w.c
    public void c(c.a.q0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
            return;
        }
        EditorTools a2 = eVar.a();
        a aVar = new a(this, (h) eVar, a2);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
    }

    @Override // c.a.q0.w.c
    public void d(c.a.q0.w.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.e(false);
                findToolById.f14006j = 1;
            }
            if (!this.f14072c) {
                if (c.a.r0.y3.s0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                    mVar.f14006j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new c.a.q0.w.o.a(a2.getContext(), 4));
            }
            f fVar = new f(a2.getContext(), this.f14072c, false, 12005);
            if (!c.a.d.f.p.m.isEmpty(this.f14071b)) {
                fVar.k(this.f14071b);
            }
            a2.addTool(fVar);
            a2.build();
            a2.sendAction(new c.a.q0.w.a(35, 5, Boolean.FALSE));
            a2.hideTools();
        }
    }

    public final boolean h(TbPageContext<?> tbPageContext, int i2) {
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

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f14071b = str;
        }
    }
}
