package c.a.p0.f1.k.a.e;

import android.content.Context;
import android.text.InputFilter;
import c.a.e.e.p.l;
import c.a.o0.x.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends c.a.o0.x.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f17655a;

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.f1.k.a.e.a f17656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17657f;

        public a(b bVar, c.a.p0.f1.k.a.e.a aVar) {
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
            this.f17657f = bVar;
            this.f17656e = aVar;
        }

        @Override // c.a.o0.x.b
        public void onAction(c.a.o0.x.a aVar) {
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            int i2 = aVar.f14775a;
            if (i2 == 4 || i2 == 6) {
                this.f17656e.H((String) aVar.f14777c);
                this.f17657f.f17655a = false;
            } else if (i2 == 7) {
                this.f17656e.m().showToast(R.string.over_limit_tip);
                this.f17657f.f17655a = true;
            } else if (i2 == 8) {
                if (this.f17657f.g(this.f17656e.m(), 11001)) {
                    this.f17656e.y();
                    TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.f17656e.s())));
                }
            } else if (i2 != 14) {
                if (i2 != 15) {
                    return;
                }
                int intValue = ((Integer) aVar.f14777c).intValue();
                if (this.f17656e.r() != null && this.f17656e.r().getChosedFiles() != null && (size = this.f17656e.r().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f17656e.m().getPageActivity(), 12012, this.f17656e.r(), intValue)));
                }
            } else {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f17656e.m().getPageActivity(), this.f17656e.r().toJsonString(), true, true);
                albumActivityConfig.setRequestCode(12002);
                if (c.a.o0.x.w.a.a().b() == 1) {
                    albumActivityConfig.setRequestFrom(4);
                    if (this.f17656e.r() != null) {
                        this.f17656e.r().setMaxImagesAllowed(1);
                    }
                } else if (this.f17656e.r() != null) {
                    this.f17656e.r().setMaxImagesAllowed(10);
                }
                l.x(this.f17656e.m().getPageActivity(), this.f17656e.m().getPageActivity().getCurrentFocus());
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

    @Override // c.a.o0.x.c
    public c.a.o0.x.e b(Context context) {
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
            return new c.a.p0.f1.k.a.e.a(editorTools);
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
        a aVar = new a(this, (c.a.p0.f1.k.a.e.a) eVar);
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

    @Override // c.a.o0.x.c
    public void d(c.a.o0.x.e eVar) {
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
            a2.addTool(new c.a.o0.x.r.d(a2.getContext(), 3));
            c cVar = new c(a2.getContext());
            if (cVar.g() != null) {
                cVar.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            a2.addTool(cVar);
            a2.build();
            a2.sendAction(new c.a.o0.x.a(35, 5, Boolean.FALSE));
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
