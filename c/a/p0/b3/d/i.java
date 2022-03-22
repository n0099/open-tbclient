package c.a.p0.b3.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.t.l;
import c.a.o0.t.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends c.a.p0.b3.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f12666b;

    /* renamed from: c  reason: collision with root package name */
    public final WriteImagesInfo f12667c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12668d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.b3.e.a f12669e;

    /* renamed from: f  reason: collision with root package name */
    public PersonChangeData f12670f;

    /* renamed from: g  reason: collision with root package name */
    public PermissionJudgePolicy f12671g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f12672h;
    public HttpMessageListener i;
    public Runnable j;
    public CustomMessageListener k;

    /* loaded from: classes2.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f12673b;

        public a(i iVar, c.a.o0.r.t.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12673b = iVar;
            this.a = jVar;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f12673b.f12668d = false;
                if (i == 0) {
                    this.f12673b.t();
                } else if (i == 1) {
                    this.f12673b.v();
                }
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f12674b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f12675c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.j f12676d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f12677e;

        public b(i iVar, q qVar, List list, int i, c.a.o0.r.t.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, qVar, list, Integer.valueOf(i), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12677e = iVar;
            this.a = qVar;
            this.f12674b = list;
            this.f12675c = i;
            this.f12676d = jVar;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f12677e.f12668d = true;
                if (i == 0) {
                    this.f12677e.w(this.a, this.f12674b, this.f12675c);
                } else if (i == 1) {
                    i iVar = this.f12677e;
                    if (iVar.a && iVar.f12669e != null && this.f12677e.f12669e.j() != null && !this.f12677e.f12669e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f12677e.f12669e.j().getCantModifyAvatarDesc())) {
                            n.K(TbadkCoreApplication.getInst(), this.f12677e.f12669e.j().getCantModifyAvatarDesc());
                        } else {
                            n.J(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0de3);
                        }
                    } else {
                        this.f12677e.t();
                    }
                } else if (i == 2) {
                    i iVar2 = this.f12677e;
                    if (iVar2.a && iVar2.f12669e != null && this.f12677e.f12669e.j() != null && !this.f12677e.f12669e.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f12677e.f12669e.j().getCantModifyAvatarDesc())) {
                            n.K(TbadkCoreApplication.getInst(), this.f12677e.f12669e.j().getCantModifyAvatarDesc());
                        } else {
                            n.J(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0de3);
                        }
                    } else {
                        this.f12677e.v();
                    }
                } else if (i == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f12677e.u();
                }
                if (this.f12676d.isShowing()) {
                    this.f12676d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f12678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f12679c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.j f12680d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f12681e;

        public c(i iVar, q qVar, List list, int i, c.a.o0.r.t.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, qVar, list, Integer.valueOf(i), jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12681e = iVar;
            this.a = qVar;
            this.f12678b = list;
            this.f12679c = i;
            this.f12680d = jVar;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (i == 0) {
                    this.f12681e.w(this.a, this.f12678b, this.f12679c);
                } else if (i == 1) {
                    j.d(this.a, this.f12681e.f12666b.getUniqueId());
                } else if (i == 2) {
                    j.b(this.a, this.f12678b);
                }
                if (this.f12680d.isShowing()) {
                    this.f12680d.dismiss();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.a.f12666b.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.a.z();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.a.x((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12667c = new WriteImagesInfo(1);
        this.f12668d = true;
        this.f12672h = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.i = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.j = new f(this);
        g gVar = new g(this, 2001380);
        this.k = gVar;
        this.f12666b = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.i.setTag(bdUniqueId);
        this.f12672h.setTag(bdUniqueId);
        this.f12666b.registerListener(this.k);
        this.f12666b.registerListener(this.i);
        this.f12666b.registerListener(this.f12672h);
    }

    public void A(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f12669e = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f12666b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f03b7), this.f12666b.getString(R.string.obfuscated_res_0x7f0f0393)};
        c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.f12666b);
        jVar.j(null, strArr, new a(this, jVar));
        jVar.m();
    }

    public final void C(q qVar, List<c.a.d.o.e.n> list, int i) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, qVar, list, i) == null) || (tbPageContext = this.f12666b) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.obfuscated_res_0x7f0f0817), this.f12666b.getString(R.string.obfuscated_res_0x7f0f0390), this.f12666b.getString(R.string.obfuscated_res_0x7f0f0393), this.f12666b.getString(R.string.obfuscated_res_0x7f0f03aa)};
        c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.f12666b);
        jVar.j(null, strArr, new b(this, qVar, list, i, jVar));
        jVar.m();
    }

    public final void D(q qVar, List<c.a.d.o.e.n> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, qVar, list, i) == null) {
            String[] strArr = {this.f12666b.getString(R.string.obfuscated_res_0x7f0f0a5b), this.f12666b.getString(R.string.obfuscated_res_0x7f0f10ea), this.f12666b.getString(R.string.obfuscated_res_0x7f0f048e)};
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.f12666b);
            jVar.j(null, strArr, new c(this, qVar, list, i, jVar));
            jVar.m();
        }
    }

    public void o() {
        c.a.p0.b3.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f12669e) == null || aVar.j() == null) {
            return;
        }
        c.a.o0.b0.c.k().g(this.f12669e.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        c.a.d.o.e.n nVar = null;
        if (view.getTag() instanceof PersonInfoUserPicViewHolder) {
            nVar = ((PersonInfoUserPicViewHolder) view.getTag()).d();
        } else if (view.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            nVar = ((PersonInfoAddUserPicViewHolder) view.getTag()).d();
        }
        int position = ListUtils.getPosition(q(), nVar);
        if (position < 0) {
            return;
        }
        r(nVar, q(), position);
    }

    public void p(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, intent) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f12667c.parseJson(stringExtra);
        this.f12667c.updateQuality();
        if (!ListUtils.isEmpty(this.f12667c.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f12666b.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f12667c.getChosedFiles().get(0).getFilePath(), 1.0f, this.f12668d)));
        }
        this.f12667c.clear();
    }

    public List<c.a.d.o.e.n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.b3.e.a aVar = this.f12669e;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(c.a.d.o.e.n nVar, List<c.a.d.o.e.n> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i) == null) {
            s(nVar, list, i, false);
        }
    }

    public void s(c.a.d.o.e.n nVar, List<c.a.d.o.e.n> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{nVar, list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof q) {
                w((q) nVar, list, i);
                return;
            }
            return;
        }
        c.a.p0.b3.e.a aVar = this.f12669e;
        if (aVar != null) {
            this.a = aVar.m();
        }
        if (!n.C()) {
            this.f12666b.showToast(R.string.obfuscated_res_0x7f0f0c15);
        } else if (!this.a) {
            if (nVar instanceof q) {
                w((q) nVar, list, i);
            }
        } else if (nVar instanceof c.a.p0.y2.i.c) {
            B();
        } else if (nVar instanceof q) {
            q qVar = (q) nVar;
            if (qVar.e()) {
                C(qVar, list, i);
            } else {
                D(qVar, list, i);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f12666b) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.f12671g == null) {
            this.f12671g = new PermissionJudgePolicy();
        }
        this.f12671g.clearRequestPermissionList();
        this.f12671g.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.f12671g.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f12666b.getPageActivity(), this.f12667c.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f12666b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f12666b.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f12666b == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f12666b.getPageActivity(), 12014, this.f12668d)));
    }

    public final void w(q qVar, List<c.a.d.o.e.n> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, qVar, list, i) == null) || this.f12666b == null || qVar == null || list == null || StringUtils.isNull(qVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (c.a.d.o.e.n nVar : list) {
            if (nVar instanceof q) {
                q qVar2 = (q) nVar;
                if (qVar2.e() && !qVar2.a().startsWith("http")) {
                    arrayList.add(j.c(this.f12666b, qVar2.a()));
                } else {
                    arrayList.add(qVar2.a());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i);
        bVar.C(true);
        bVar.J(str);
        bVar.F(true);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(this.f12666b.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f12666b.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.p0.b3.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f12669e) == null || aVar.j() == null || !this.f12669e.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f12670f == null) {
            this.f12670f = new PersonChangeData();
        }
        this.f12670f.setPhotoChanged(true);
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.j);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.j, 300L);
        }
    }
}
