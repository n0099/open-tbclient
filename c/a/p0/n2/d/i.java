package c.a.p0.n2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.k.e.n;
import c.a.o0.s.s.i;
import c.a.o0.u.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class i extends c.a.p0.n2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f22238f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f22239g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22240h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.n2.e.a f22241i;

    /* renamed from: j  reason: collision with root package name */
    public PersonChangeData f22242j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes3.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f22244f;

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
            this.f22244f = iVar;
            this.f22243e = popupDialog;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22244f.f22240h = false;
                if (i2 == 0) {
                    this.f22244f.t();
                } else if (i2 == 1) {
                    this.f22244f.v();
                }
                if (this.f22243e.isShowing()) {
                    this.f22243e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f22245e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f22246f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f22247g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22248h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f22249i;

        public b(i iVar, m mVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22249i = iVar;
            this.f22245e = mVar;
            this.f22246f = list;
            this.f22247g = i2;
            this.f22248h = popupDialog;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22249i.f22240h = true;
                if (i2 == 0) {
                    this.f22249i.w(this.f22245e, this.f22246f, this.f22247g);
                } else if (i2 == 1) {
                    i iVar2 = this.f22249i;
                    if (iVar2.f22204e && iVar2.f22241i != null && this.f22249i.f22241i.j() != null && !this.f22249i.f22241i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f22249i.f22241i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f22249i.f22241i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f22249i.t();
                    }
                } else if (i2 == 2) {
                    i iVar3 = this.f22249i;
                    if (iVar3.f22204e && iVar3.f22241i != null && this.f22249i.f22241i.j() != null && !this.f22249i.f22241i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f22249i.f22241i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f22249i.f22241i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f22249i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f22249i.u();
                }
                if (this.f22248h.isShowing()) {
                    this.f22248h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f22250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f22251f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f22252g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22253h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f22254i;

        public c(i iVar, m mVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, mVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22254i = iVar;
            this.f22250e = mVar;
            this.f22251f = list;
            this.f22252g = i2;
            this.f22253h = popupDialog;
        }

        @Override // c.a.o0.s.s.i.e
        public void onItemClick(c.a.o0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f22254i.w(this.f22250e, this.f22251f, this.f22252g);
                } else if (i2 == 1) {
                    j.d(this.f22250e, this.f22254i.f22238f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f22250e, this.f22251f);
                }
                if (this.f22253h.isShowing()) {
                    this.f22253h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22255a;

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
            this.f22255a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.f22255a.z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22256a;

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
            this.f22256a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.f22256a.f22238f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.f22256a.z();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22257a;

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
            this.f22257a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.f22257a.x((PersonChangeData) customResponsedMessage.getData());
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
        this.f22239g = new WriteImagesInfo(1);
        this.f22240h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f22238f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f22238f.registerListener(this.o);
        this.f22238f.registerListener(this.m);
        this.f22238f.registerListener(this.l);
    }

    public void A(c.a.p0.n2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f22241i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f22238f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f22238f.getString(R.string.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f22238f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(m mVar, List<n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, list, i2) == null) || (tbPageContext = this.f22238f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f22238f.getString(R.string.change_photo), this.f22238f.getString(R.string.change_system_photo), this.f22238f.getString(R.string.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f22238f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, mVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void J(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, mVar, list, i2) == null) {
            String[] strArr = {this.f22238f.getString(R.string.look_big_photo), this.f22238f.getString(R.string.set_as_portrait_photo), this.f22238f.getString(R.string.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f22238f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, mVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        c.a.p0.n2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f22241i) == null || aVar.j() == null) {
            return;
        }
        c.a.o0.b0.c.k().g(this.f22241i.j().getPortrait());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || q() == null) {
            return;
        }
        n nVar = null;
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
        this.f22239g.parseJson(stringExtra);
        this.f22239g.updateQuality();
        if (!ListUtils.isEmpty(this.f22239g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f22238f.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f22239g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f22240h)));
        }
        this.f22239g.clear();
    }

    public List<n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.n2.e.a aVar = this.f22241i;
            if (aVar == null) {
                return null;
            }
            return aVar.k();
        }
        return (List) invokeV.objValue;
    }

    public void r(n nVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar, list, i2) == null) {
            s(nVar, list, i2, false);
        }
    }

    public void s(n nVar, List<n> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{nVar, list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || nVar == null) {
            return;
        }
        if (z) {
            if (nVar instanceof m) {
                w((m) nVar, list, i2);
                return;
            }
            return;
        }
        c.a.p0.n2.e.a aVar = this.f22241i;
        if (aVar != null) {
            this.f22204e = aVar.m();
        }
        if (!l.D()) {
            this.f22238f.showToast(R.string.neterror);
        } else if (!this.f22204e) {
            if (nVar instanceof m) {
                w((m) nVar, list, i2);
            }
        } else if (nVar instanceof c.a.p0.k2.h.c) {
            B();
        } else if (nVar instanceof m) {
            m mVar = (m) nVar;
            if (mVar.d()) {
                D(mVar, list, i2);
            } else {
                J(mVar, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f22238f) == null) {
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
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f22238f.getPageActivity(), this.f22239g.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f22238f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f22238f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f22238f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f22238f.getPageActivity(), 12014, this.f22240h)));
    }

    public final void w(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, mVar, list, i2) == null) || this.f22238f == null || mVar == null || list == null || StringUtils.isNull(mVar.b())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (n nVar : list) {
            if (nVar instanceof m) {
                m mVar2 = (m) nVar;
                if (mVar2.d() && !mVar2.b().startsWith("http")) {
                    arrayList.add(j.c(this.f22238f, mVar2.b()));
                } else {
                    arrayList.add(mVar2.b());
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
        ImageViewerConfig v = bVar.v(this.f22238f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f22238f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.p0.n2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f22241i) == null || aVar.j() == null || !this.f22241i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f22242j == null) {
            this.f22242j = new PersonChangeData();
        }
        this.f22242j.setPhotoChanged(true);
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.n);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.e.e.m.e.a().postDelayed(this.n, 300L);
        }
    }
}
