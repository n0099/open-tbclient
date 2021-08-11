package c.a.o0.x.w;

import android.content.Context;
import c.a.e.e.p.k;
import c.a.o0.x.m;
import c.a.o0.x.n;
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
/* loaded from: classes3.dex */
public class i extends c.a.o0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14861a;

    /* renamed from: b  reason: collision with root package name */
    public String f14862b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14863c;

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f14865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f14866g;

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
            this.f14866g = iVar;
            this.f14864e = hVar;
            this.f14865f = editorTools;
        }

        @Override // c.a.o0.x.b
        public void onAction(c.a.o0.x.a aVar) {
            m findToolById;
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.f14775a;
            if (i2 == 4) {
                Object obj = aVar.f14777c;
                if (obj instanceof j) {
                    this.f14864e.Y((j) obj);
                    this.f14864e.X(((j) aVar.f14777c).f14869c);
                } else if (obj instanceof String) {
                    this.f14864e.S((String) obj);
                } else if (obj instanceof SpanGroupManager) {
                    this.f14864e.S(obj.toString());
                    this.f14864e.X((SpanGroupManager) aVar.f14777c);
                }
                this.f14866g.f14861a = false;
            } else if (i2 == 16) {
                if (this.f14866g.f14861a) {
                    this.f14864e.t().showToast(R.string.over_limit_tip);
                }
                if (this.f14866g.h(this.f14864e.t(), 11025)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.f14864e.t().getPageActivity(), CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, true)));
                }
            } else if (i2 == 7) {
                this.f14864e.t().showToast(R.string.over_limit_tip);
                this.f14866g.f14861a = true;
            } else if (i2 == 8) {
                if (this.f14866g.h(this.f14864e.t(), 11001)) {
                    this.f14864e.F();
                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                }
            } else if (i2 == 10) {
                Object obj2 = aVar.f14777c;
                if (obj2 instanceof VoiceData$VoiceModel) {
                    this.f14864e.b0((VoiceData$VoiceModel) obj2);
                    this.f14864e.v(null);
                }
            } else if (i2 != 11) {
            } else {
                this.f14864e.b0(null);
                EditorTools editorTools = this.f14865f;
                if (editorTools == null || (findToolById = editorTools.findToolById(6)) == null || (nVar = findToolById.k) == null) {
                    return;
                }
                nVar.onAction(new c.a.o0.x.a(52, 0, null));
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
        this.f14861a = false;
        this.f14863c = false;
        this.f14863c = z;
    }

    @Override // c.a.o0.x.c
    public c.a.o0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(this.f14863c ? 5 : 2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.showLinePositionTop(false);
            h hVar = new h(editorTools);
            hVar.v = this.f14863c;
            return hVar;
        }
        return (c.a.o0.x.e) invokeL.objValue;
    }

    @Override // c.a.o0.x.c
    public void c(c.a.o0.x.e eVar) {
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

    @Override // c.a.o0.x.c
    public void d(c.a.o0.x.e eVar) {
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
                findToolById.f(false);
                findToolById.f14790j = 1;
            }
            if (!this.f14863c) {
                if (c.a.p0.i3.p0.c.a() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                    mVar.f14790j = 2;
                    a2.addTool(mVar);
                }
                a2.addTool(new c.a.o0.x.o.a(a2.getContext(), 4));
            }
            f fVar = new f(a2.getContext(), this.f14863c, false);
            if (!k.isEmpty(this.f14862b)) {
                fVar.l(this.f14862b);
            }
            a2.addTool(fVar);
            a2.build();
            a2.sendAction(new c.a.o0.x.a(35, 5, Boolean.FALSE));
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
            this.f14862b = str;
        }
    }
}
