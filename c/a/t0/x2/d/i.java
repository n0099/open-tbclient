package c.a.t0.x2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.s.j;
import c.a.s0.u.q;
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
public class i extends c.a.t0.x2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f26144f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f26145g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26146h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.x2.e.a f26147i;

    /* renamed from: j  reason: collision with root package name */
    public PersonChangeData f26148j;

    /* renamed from: k  reason: collision with root package name */
    public PermissionJudgePolicy f26149k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes8.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f26150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f26151f;

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
            this.f26151f = iVar;
            this.f26150e = popupDialog;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f26151f.f26146h = false;
                if (i2 == 0) {
                    this.f26151f.t();
                } else if (i2 == 1) {
                    this.f26151f.v();
                }
                if (this.f26150e.isShowing()) {
                    this.f26150e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f26152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f26153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f26154g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f26155h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f26156i;

        public b(i iVar, q qVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, qVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26156i = iVar;
            this.f26152e = qVar;
            this.f26153f = list;
            this.f26154g = i2;
            this.f26155h = popupDialog;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f26156i.f26146h = true;
                if (i2 == 0) {
                    this.f26156i.w(this.f26152e, this.f26153f, this.f26154g);
                } else if (i2 == 1) {
                    i iVar = this.f26156i;
                    if (iVar.f26116e && iVar.f26147i != null && this.f26156i.f26147i.j() != null && !this.f26156i.f26147i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f26156i.f26147i.j().getCantModifyAvatarDesc())) {
                            n.J(TbadkCoreApplication.getInst(), this.f26156i.f26147i.j().getCantModifyAvatarDesc());
                        } else {
                            n.I(TbadkCoreApplication.getInst(), c.a.t0.y2.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f26156i.t();
                    }
                } else if (i2 == 2) {
                    i iVar2 = this.f26156i;
                    if (iVar2.f26116e && iVar2.f26147i != null && this.f26156i.f26147i.j() != null && !this.f26156i.f26147i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f26156i.f26147i.j().getCantModifyAvatarDesc())) {
                            n.J(TbadkCoreApplication.getInst(), this.f26156i.f26147i.j().getCantModifyAvatarDesc());
                        } else {
                            n.I(TbadkCoreApplication.getInst(), c.a.t0.y2.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f26156i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f26156i.u();
                }
                if (this.f26155h.isShowing()) {
                    this.f26155h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f26157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f26158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f26159g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f26160h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f26161i;

        public c(i iVar, q qVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, qVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26161i = iVar;
            this.f26157e = qVar;
            this.f26158f = list;
            this.f26159g = i2;
            this.f26160h = popupDialog;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f26161i.w(this.f26157e, this.f26158f, this.f26159g);
                } else if (i2 == 1) {
                    j.d(this.f26157e, this.f26161i.f26144f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f26157e, this.f26158f);
                }
                if (this.f26160h.isShowing()) {
                    this.f26160h.dismiss();
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
                    this.a.f26144f.showToast(setUserPicsResponse.getErrorString());
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
        this.f26145g = new WriteImagesInfo(1);
        this.f26146h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f26144f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f26144f.registerListener(this.o);
        this.f26144f.registerListener(this.m);
        this.f26144f.registerListener(this.l);
    }

    public void A(c.a.t0.x2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f26147i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f26144f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.t0.y2.g.choose_local_photo), this.f26144f.getString(c.a.t0.y2.g.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f26144f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void C(q qVar, List<c.a.d.n.e.n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, qVar, list, i2) == null) || (tbPageContext = this.f26144f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.t0.y2.g.hd_photo), this.f26144f.getString(c.a.t0.y2.g.change_photo), this.f26144f.getString(c.a.t0.y2.g.change_system_photo), this.f26144f.getString(c.a.t0.y2.g.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f26144f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, qVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(q qVar, List<c.a.d.n.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, qVar, list, i2) == null) {
            String[] strArr = {this.f26144f.getString(c.a.t0.y2.g.look_big_photo), this.f26144f.getString(c.a.t0.y2.g.set_as_portrait_photo), this.f26144f.getString(c.a.t0.y2.g.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f26144f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, qVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        c.a.t0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f26147i) == null || aVar.j() == null) {
            return;
        }
        c.a.s0.c0.c.k().g(this.f26147i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        c.a.d.n.e.n nVar = null;
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
        this.f26145g.parseJson(stringExtra);
        this.f26145g.updateQuality();
        if (!ListUtils.isEmpty(this.f26145g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f26144f.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f26145g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f26146h)));
        }
        this.f26145g.clear();
    }

    public List<c.a.d.n.e.n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.t0.x2.e.a aVar = this.f26147i;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(c.a.d.n.e.n nVar, List<c.a.d.n.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i2) == null) {
            s(nVar, list, i2, false);
        }
    }

    public void s(c.a.d.n.e.n nVar, List<c.a.d.n.e.n> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{nVar, list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof q) {
                w((q) nVar, list, i2);
                return;
            }
            return;
        }
        c.a.t0.x2.e.a aVar = this.f26147i;
        if (aVar != null) {
            this.f26116e = aVar.m();
        }
        if (!n.C()) {
            this.f26144f.showToast(c.a.t0.y2.g.neterror);
        } else if (!this.f26116e) {
            if (nVar instanceof q) {
                w((q) nVar, list, i2);
            }
        } else if (nVar instanceof c.a.t0.u2.h.c) {
            B();
        } else if (nVar instanceof q) {
            q qVar = (q) nVar;
            if (qVar.e()) {
                C(qVar, list, i2);
            } else {
                D(qVar, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f26144f) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.f26149k == null) {
            this.f26149k = new PermissionJudgePolicy();
        }
        this.f26149k.clearRequestPermissionList();
        this.f26149k.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.f26149k.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f26144f.getPageActivity(), this.f26145g.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f26144f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f26144f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f26144f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f26144f.getPageActivity(), 12014, this.f26146h)));
    }

    public final void w(q qVar, List<c.a.d.n.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, qVar, list, i2) == null) || this.f26144f == null || qVar == null || list == null || StringUtils.isNull(qVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (c.a.d.n.e.n nVar : list) {
            if (nVar instanceof q) {
                q qVar2 = (q) nVar;
                if (qVar2.e() && !qVar2.a().startsWith("http")) {
                    arrayList.add(j.c(this.f26144f, qVar2.a()));
                } else {
                    arrayList.add(qVar2.a());
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
        ImageViewerConfig v = bVar.v(this.f26144f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f26144f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.t0.x2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f26147i) == null || aVar.j() == null || !this.f26147i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f26148j == null) {
            this.f26148j = new PersonChangeData();
        }
        this.f26148j.setPhotoChanged(true);
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
