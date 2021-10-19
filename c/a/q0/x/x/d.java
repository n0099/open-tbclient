package c.a.q0.x.x;

import android.content.Context;
import c.a.e.e.p.l;
import c.a.q0.x.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorTools f15173f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f15174g;

        public a(d dVar, e eVar, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15174g = dVar;
            this.f15172e = eVar;
            this.f15173f = editorTools;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            e eVar;
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (eVar = this.f15172e) == null || eVar.a() == null || aVar == null) {
                return;
            }
            int i2 = aVar.f15109a;
            if (i2 == 4) {
                this.f15172e.o0(aVar.f15111c.toString());
            } else if (i2 == 5) {
                if (this.f15173f.isToolVisible()) {
                    return;
                }
                TiebaStatic.eventStat(this.f15173f.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
            } else if (i2 == 7) {
                this.f15172e.s().showToast(R.string.over_limit_tip);
            } else if (i2 == 8) {
                if (this.f15174g.k(this.f15172e.s(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f15172e.N(null, null);
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f15111c).intValue();
                if (this.f15172e.A() != null && this.f15172e.A().getChosedFiles() != null && (size = this.f15172e.A().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f15172e.s().getPageActivity(), 12012, this.f15172e.A(), intValue)));
                }
            } else {
                if (this.f15172e.A() != null) {
                    this.f15172e.A().setMaxImagesAllowed(1);
                }
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f15172e.s().getPageActivity(), this.f15172e.A().toJsonString(), true, true);
                if (!StringUtils.isNull(this.f15174g.m(), true)) {
                    albumActivityConfig.getIntent().putExtra("from", this.f15174g.m());
                }
                if (this.f15174g.l() != null && !StringUtils.isNull(this.f15174g.l().getId(), true)) {
                    albumActivityConfig.getIntent().putExtra("forum_id", this.f15174g.l().getId());
                }
                albumActivityConfig.setRequestCode(12002);
                l.x(this.f15172e.s().getPageActivity(), this.f15172e.s().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public d() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // c.a.q0.x.x.g, c.a.q0.x.c
    public c.a.q0.x.e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0201);
            editorTools.showLinePositionTop(false);
            editorTools.setMoreButtonAtEnd(true);
            e eVar = new e(editorTools);
            eVar.l0(n());
            eVar.z = true;
            return eVar;
        }
        return (c.a.q0.x.e) invokeL.objValue;
    }

    @Override // c.a.q0.x.x.g, c.a.q0.x.c
    public void c(c.a.q0.x.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) && (eVar instanceof e)) {
            EditorTools a2 = eVar.a();
            a aVar = new a(this, (e) eVar, a2);
            a2.setActionListener(5, aVar);
            a2.setActionListener(4, aVar);
            a2.setActionListener(7, aVar);
            a2.setActionListener(14, aVar);
            a2.setActionListener(15, aVar);
            a2.setActionListener(8, aVar);
            a2.setActionListener(32, aVar);
            a2.setActionListener(45, aVar);
        }
    }

    @Override // c.a.q0.x.x.g, c.a.q0.x.c
    public void d(c.a.q0.x.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            EditorTools a2 = eVar.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.addTool(new c.a.q0.x.r.d(a2.getContext(), 1));
            a2.addTool(new f(a2.getContext(), true, false, 12004));
            a2.collect(arrayList);
            m findToolById = a2.findToolById(5);
            if (findToolById != null) {
                findToolById.f15132j = 2;
                findToolById.f(false);
            }
            a2.build();
            a2.sendAction(new c.a.q0.x.a(35, 5, Boolean.FALSE));
        }
    }
}
