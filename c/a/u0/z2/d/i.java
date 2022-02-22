package c.a.u0.z2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.t.j;
import c.a.t0.u.q;
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
/* loaded from: classes9.dex */
public class i extends c.a.u0.z2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f25938f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f25939g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25940h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u0.z2.e.a f25941i;

    /* renamed from: j  reason: collision with root package name */
    public PersonChangeData f25942j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes9.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f25944f;

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
            this.f25944f = iVar;
            this.f25943e = popupDialog;
        }

        @Override // c.a.t0.s.t.j.e
        public void onItemClick(c.a.t0.s.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f25944f.f25940h = false;
                if (i2 == 0) {
                    this.f25944f.t();
                } else if (i2 == 1) {
                    this.f25944f.v();
                }
                if (this.f25943e.isShowing()) {
                    this.f25943e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f25945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f25946f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f25947g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25948h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f25949i;

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
            this.f25949i = iVar;
            this.f25945e = qVar;
            this.f25946f = list;
            this.f25947g = i2;
            this.f25948h = popupDialog;
        }

        @Override // c.a.t0.s.t.j.e
        public void onItemClick(c.a.t0.s.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f25949i.f25940h = true;
                if (i2 == 0) {
                    this.f25949i.w(this.f25945e, this.f25946f, this.f25947g);
                } else if (i2 == 1) {
                    i iVar = this.f25949i;
                    if (iVar.f25913e && iVar.f25941i != null && this.f25949i.f25941i.j() != null && !this.f25949i.f25941i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f25949i.f25941i.j().getCantModifyAvatarDesc())) {
                            n.K(TbadkCoreApplication.getInst(), this.f25949i.f25941i.j().getCantModifyAvatarDesc());
                        } else {
                            n.J(TbadkCoreApplication.getInst(), c.a.u0.a3.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f25949i.t();
                    }
                } else if (i2 == 2) {
                    i iVar2 = this.f25949i;
                    if (iVar2.f25913e && iVar2.f25941i != null && this.f25949i.f25941i.j() != null && !this.f25949i.f25941i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f25949i.f25941i.j().getCantModifyAvatarDesc())) {
                            n.K(TbadkCoreApplication.getInst(), this.f25949i.f25941i.j().getCantModifyAvatarDesc());
                        } else {
                            n.J(TbadkCoreApplication.getInst(), c.a.u0.a3.g.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f25949i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f25949i.u();
                }
                if (this.f25948h.isShowing()) {
                    this.f25948h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f25950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f25951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f25952g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f25953h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f25954i;

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
            this.f25954i = iVar;
            this.f25950e = qVar;
            this.f25951f = list;
            this.f25952g = i2;
            this.f25953h = popupDialog;
        }

        @Override // c.a.t0.s.t.j.e
        public void onItemClick(c.a.t0.s.t.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f25954i.w(this.f25950e, this.f25951f, this.f25952g);
                } else if (i2 == 1) {
                    j.d(this.f25950e, this.f25954i.f25938f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f25950e, this.f25951f);
                }
                if (this.f25953h.isShowing()) {
                    this.f25953h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
                    this.a.f25938f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.a.z();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
        this.f25939g = new WriteImagesInfo(1);
        this.f25940h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f25938f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f25938f.registerListener(this.o);
        this.f25938f.registerListener(this.m);
        this.f25938f.registerListener(this.l);
    }

    public void A(c.a.u0.z2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f25941i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f25938f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.u0.a3.g.choose_local_photo), this.f25938f.getString(c.a.u0.a3.g.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f25938f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void C(q qVar, List<c.a.d.o.e.n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, qVar, list, i2) == null) || (tbPageContext = this.f25938f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(c.a.u0.a3.g.hd_photo), this.f25938f.getString(c.a.u0.a3.g.change_photo), this.f25938f.getString(c.a.u0.a3.g.change_system_photo), this.f25938f.getString(c.a.u0.a3.g.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f25938f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, qVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(q qVar, List<c.a.d.o.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, qVar, list, i2) == null) {
            String[] strArr = {this.f25938f.getString(c.a.u0.a3.g.look_big_photo), this.f25938f.getString(c.a.u0.a3.g.set_as_portrait_photo), this.f25938f.getString(c.a.u0.a3.g.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f25938f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, qVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        c.a.u0.z2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f25941i) == null || aVar.j() == null) {
            return;
        }
        c.a.t0.c0.c.k().g(this.f25941i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        c.a.d.o.e.n nVar = null;
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
        this.f25939g.parseJson(stringExtra);
        this.f25939g.updateQuality();
        if (!ListUtils.isEmpty(this.f25939g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f25938f.getPageActivity(), (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f25939g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f25940h)));
        }
        this.f25939g.clear();
    }

    public List<c.a.d.o.e.n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.u0.z2.e.a aVar = this.f25941i;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(c.a.d.o.e.n nVar, List<c.a.d.o.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i2) == null) {
            s(nVar, list, i2, false);
        }
    }

    public void s(c.a.d.o.e.n nVar, List<c.a.d.o.e.n> list, int i2, boolean z) {
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
        c.a.u0.z2.e.a aVar = this.f25941i;
        if (aVar != null) {
            this.f25913e = aVar.m();
        }
        if (!n.C()) {
            this.f25938f.showToast(c.a.u0.a3.g.neterror);
        } else if (!this.f25913e) {
            if (nVar instanceof q) {
                w((q) nVar, list, i2);
            }
        } else if (nVar instanceof c.a.u0.w2.h.c) {
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f25938f) == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (this.k == null) {
            this.k = new PermissionJudgePolicy();
        }
        this.k.clearRequestPermissionList();
        this.k.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.k.startRequestPermission(pageActivity)) {
            return;
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f25938f.getPageActivity(), this.f25939g.toJsonString(), true);
        albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f25938f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f25938f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f25938f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f25938f.getPageActivity(), 12014, this.f25940h)));
    }

    public final void w(q qVar, List<c.a.d.o.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, qVar, list, i2) == null) || this.f25938f == null || qVar == null || list == null || StringUtils.isNull(qVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (c.a.d.o.e.n nVar : list) {
            if (nVar instanceof q) {
                q qVar2 = (q) nVar;
                if (qVar2.e() && !qVar2.a().startsWith("http")) {
                    arrayList.add(j.c(this.f25938f, qVar2.a()));
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
        ImageViewerConfig v = bVar.v(this.f25938f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f25938f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.u0.z2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f25941i) == null || aVar.j() == null || !this.f25941i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f25942j == null) {
            this.f25942j = new PersonChangeData();
        }
        this.f25942j.setPhotoChanged(true);
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
