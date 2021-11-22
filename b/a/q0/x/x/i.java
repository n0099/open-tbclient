package b.a.q0.x.x;

import android.content.Context;
import b.a.e.f.p.k;
import b.a.q0.x.m;
import b.a.q0.x.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
/* loaded from: classes4.dex */
public class i extends b.a.q0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f15051a;

    /* renamed from: b  reason: collision with root package name */
    public String f15052b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15053c;

    /* loaded from: classes4.dex */
    public class a implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f15055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f15056g;

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
            this.f15056g = iVar;
            this.f15054e = hVar;
            this.f15055f = editorTools;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            m findToolById;
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.f14962a;
            if (i2 == 4) {
                Object obj = aVar.f14964c;
                if (obj instanceof j) {
                    this.f15054e.Z((j) obj);
                    this.f15054e.Y(((j) aVar.f14964c).f15059c);
                } else if (obj instanceof String) {
                    this.f15054e.S((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f15054e.S(obj.toString());
                    this.f15054e.Y((SpanGroupManager) aVar.f14964c);
                }
                this.f15056g.f15051a = false;
            } else if (i2 == 16) {
                if (this.f15056g.f15051a) {
                    this.f15054e.getContext().showToast(R.string.over_limit_tip);
                }
                if (this.f15056g.h(this.f15054e.getContext(), 11025)) {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f15054e.getContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, true);
                    if (this.f15054e.u() != null) {
                        atListActivityConfig.setSelectedAtList(this.f15054e.u().u());
                    }
                    EditorTools editorTools = this.f15055f;
                    if (editorTools != null) {
                        atListActivityConfig.setFromTid(editorTools.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.f15055f.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    EditorTools editorTools2 = this.f15055f;
                    if (editorTools2 != null) {
                        statisticItem.addParam("tid", editorTools2.getTid());
                        statisticItem.addParam("fid", this.f15055f.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (i2 == 7) {
                this.f15054e.getContext().showToast(R.string.over_limit_tip);
                this.f15056g.f15051a = true;
            } else if (i2 == 8) {
                if (this.f15056g.h(this.f15054e.getContext(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f15054e.F();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f14964c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f15054e.c0((VoiceData$VoiceModel) obj2);
                    this.f15054e.v(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f15054e.c0(null);
                EditorTools editorTools3 = this.f15055f;
                if (editorTools3 == null || (findToolById = editorTools3.findToolById(6)) == null || (nVar = findToolById.k) == null) {
                    return;
                }
                nVar.onAction(new b.a.q0.x.a(52, 0, null));
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
        this.f15051a = false;
        this.f15053c = false;
        this.f15053c = z;
    }

    @Override // b.a.q0.x.c
    public b.a.q0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(this.f15053c ? 5 : 2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            h hVar = new h(editorTools);
            hVar.v = this.f15053c;
            return hVar;
        }
        return (b.a.q0.x.e) invokeL.objValue;
    }

    @Override // b.a.q0.x.c
    public void c(b.a.q0.x.e eVar) {
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

    @Override // b.a.q0.x.c
    public void d(b.a.q0.x.e eVar) {
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
                findToolById.j = 1;
            }
            if (!this.f15053c) {
                if (b.a.r0.m3.r0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                    mVar.j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new b.a.q0.x.o.a(a2.getContext(), 4));
            }
            f fVar = new f(a2.getContext(), this.f15053c, false, CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK);
            if (!k.isEmpty(this.f15052b)) {
                fVar.k(this.f15052b);
            }
            a2.addTool(fVar);
            a2.build();
            a2.sendAction(new b.a.q0.x.a(35, 5, Boolean.FALSE));
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
            this.f15052b = str;
        }
    }
}
