package c.a.s0.x2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.s.t.i;
import c.a.r0.u.n;
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
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
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
/* loaded from: classes8.dex */
public class i extends c.a.s0.x2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f25656f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f25657g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25658h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.x2.e.a f25659i;

    /* renamed from: j  reason: collision with root package name */
    public PersonChangeData f25660j;

    /* renamed from: k  reason: collision with root package name */
    public PermissionJudgePolicy f25661k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes8.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f25663f;

        public a(i iVar, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25663f = iVar;
            this.f25662e = popupDialog;
        }

        @Override // c.a.r0.s.t.i.e
        public void onItemClick(c.a.r0.s.t.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f25663f.f25658h = false;
                if (i2 == 0) {
                    this.f25663f.t();
                } else if (i2 == 1) {
                    this.f25663f.v();
                }
                if (this.f25662e.isShowing()) {
                    this.f25662e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f25664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f25665f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f25666g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25667h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f25668i;

        public b(i iVar, n nVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, nVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25668i = iVar;
            this.f25664e = nVar;
            this.f25665f = list;
            this.f25666g = i2;
            this.f25667h = popupDialog;
        }

        @Override // c.a.r0.s.t.i.e
        public void onItemClick(c.a.r0.s.t.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f25668i.f25658h = true;
                if (i2 == 0) {
                    this.f25668i.w(this.f25664e, this.f25665f, this.f25666g);
                } else if (i2 == 1) {
                    i iVar2 = this.f25668i;
                    if (iVar2.f25628e && iVar2.f25659i != null && this.f25668i.f25659i.j() != null && !this.f25668i.f25659i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f25668i.f25659i.j().getCantModifyAvatarDesc())) {
                            m.J(TbadkCoreApplication.getInst(), this.f25668i.f25659i.j().getCantModifyAvatarDesc());
                        } else {
                            m.I(TbadkCoreApplication.getInst(), c.a.s0.y2.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f25668i.t();
                    }
                } else if (i2 == 2) {
                    i iVar3 = this.f25668i;
                    if (iVar3.f25628e && iVar3.f25659i != null && this.f25668i.f25659i.j() != null && !this.f25668i.f25659i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f25668i.f25659i.j().getCantModifyAvatarDesc())) {
                            m.J(TbadkCoreApplication.getInst(), this.f25668i.f25659i.j().getCantModifyAvatarDesc());
                        } else {
                            m.I(TbadkCoreApplication.getInst(), c.a.s0.y2.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f25668i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f25668i.u();
                }
                if (this.f25667h.isShowing()) {
                    this.f25667h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f25669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f25670f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f25671g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25672h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f25673i;

        public c(i iVar, n nVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, nVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25673i = iVar;
            this.f25669e = nVar;
            this.f25670f = list;
            this.f25671g = i2;
            this.f25672h = popupDialog;
        }

        @Override // c.a.r0.s.t.i.e
        public void onItemClick(c.a.r0.s.t.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f25673i.w(this.f25669e, this.f25670f, this.f25671g);
                } else if (i2 == 1) {
                    j.d(this.f25669e, this.f25673i.f25656f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f25669e, this.f25670f);
                }
                if (this.f25672h.isShowing()) {
                    this.f25672h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes8.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                    this.a.f25656f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.a.z();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25657g = new WriteImagesInfo(1);
        this.f25658h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f25656f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f25656f.registerListener(this.o);
        this.f25656f.registerListener(this.m);
        this.f25656f.registerListener(this.l);
    }

    public void A(c.a.s0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f25659i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f25656f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.s0.y2.g.choose_local_photo), this.f25656f.getString(c.a.s0.y2.g.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f25656f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void C(n nVar, List<c.a.d.m.e.n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, nVar, list, i2) == null) || (tbPageContext = this.f25656f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.s0.y2.g.hd_photo), this.f25656f.getString(c.a.s0.y2.g.change_photo), this.f25656f.getString(c.a.s0.y2.g.change_system_photo), this.f25656f.getString(c.a.s0.y2.g.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f25656f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, nVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(n nVar, List<c.a.d.m.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, nVar, list, i2) == null) {
            String[] strArr = {this.f25656f.getString(c.a.s0.y2.g.look_big_photo), this.f25656f.getString(c.a.s0.y2.g.set_as_portrait_photo), this.f25656f.getString(c.a.s0.y2.g.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f25656f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, nVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        c.a.s0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f25659i) == null || aVar.j() == null) {
            return;
        }
        c.a.r0.c0.c.k().g(this.f25659i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        c.a.d.m.e.n nVar = null;
        if (view.getTag() instanceof PersonInfoUserPicViewHolder) {
            nVar = ((PersonInfoUserPicViewHolder) view.getTag()).getData();
        } else if (view.getTag() instanceof PersonInfoAddUserPicViewHolder) {
            nVar = ((PersonInfoAddUserPicViewHolder) view.getTag()).getData();
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
        this.f25657g.parseJson(stringExtra);
        this.f25657g.updateQuality();
        if (!ListUtils.isEmpty(this.f25657g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f25656f.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f25657g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f25658h)));
        }
        this.f25657g.clear();
    }

    public List<c.a.d.m.e.n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.s0.x2.e.a aVar = this.f25659i;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(c.a.d.m.e.n nVar, List<c.a.d.m.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i2) == null) {
            s(nVar, list, i2, false);
        }
    }

    public void s(c.a.d.m.e.n nVar, List<c.a.d.m.e.n> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{nVar, list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof n) {
                w((n) nVar, list, i2);
                return;
            }
            return;
        }
        c.a.s0.x2.e.a aVar = this.f25659i;
        if (aVar != null) {
            this.f25628e = aVar.m();
        }
        if (!m.C()) {
            this.f25656f.showToast(c.a.s0.y2.g.neterror);
        } else if (!this.f25628e) {
            if (nVar instanceof n) {
                w((n) nVar, list, i2);
            }
        } else if (nVar instanceof c.a.s0.u2.h.c) {
            B();
        } else if (nVar instanceof n) {
            n nVar2 = (n) nVar;
            if (nVar2.e()) {
                C(nVar2, list, i2);
            } else {
                D(nVar2, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f25656f) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.f25661k == null) {
            this.f25661k = new PermissionJudgePolicy();
        }
        this.f25661k.clearRequestPermissionList();
        this.f25661k.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.f25661k.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f25656f.getPageActivity(), this.f25657g.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f25656f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f25656f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f25656f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f25656f.getPageActivity(), 12014, this.f25658h)));
    }

    public final void w(n nVar, List<c.a.d.m.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, nVar, list, i2) == null) || this.f25656f == null || nVar == null || list == null || StringUtils.isNull(nVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (c.a.d.m.e.n nVar2 : list) {
            if (nVar2 instanceof n) {
                n nVar3 = (n) nVar2;
                if (nVar3.e() && !nVar3.a().startsWith("http")) {
                    arrayList.add(j.c(this.f25656f, nVar3.a()));
                } else {
                    arrayList.add(nVar3.a());
                }
            }
        }
        int size = arrayList.size();
        String str = size > 0 ? arrayList.get(size - 1) : "";
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(i2);
        bVar.C(true);
        bVar.J(str);
        bVar.F(true);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(this.f25656f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f25656f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.s0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f25659i) == null || aVar.j() == null || !this.f25659i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f25660j == null) {
            this.f25660j = new PersonChangeData();
        }
        this.f25660j.setPhotoChanged(true);
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.n);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().postDelayed(this.n, 300L);
        }
    }
}
