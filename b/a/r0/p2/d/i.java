package b.a.r0.p2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.s.s.i;
import b.a.q0.u.o;
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
/* loaded from: classes5.dex */
public class i extends b.a.r0.p2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f22245f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f22246g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22247h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.p2.e.a f22248i;
    public PersonChangeData j;
    public PermissionJudgePolicy k;
    public HttpMessageListener l;
    public HttpMessageListener m;
    public Runnable n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f22250f;

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
            this.f22250f = iVar;
            this.f22249e = popupDialog;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22250f.f22247h = false;
                if (i2 == 0) {
                    this.f22250f.t();
                } else if (i2 == 1) {
                    this.f22250f.v();
                }
                if (this.f22249e.isShowing()) {
                    this.f22249e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f22251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f22252f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f22253g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22254h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f22255i;

        public b(i iVar, o oVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, oVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22255i = iVar;
            this.f22251e = oVar;
            this.f22252f = list;
            this.f22253g = i2;
            this.f22254h = popupDialog;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22255i.f22247h = true;
                if (i2 == 0) {
                    this.f22255i.w(this.f22251e, this.f22252f, this.f22253g);
                } else if (i2 == 1) {
                    i iVar2 = this.f22255i;
                    if (iVar2.f22214e && iVar2.f22248i != null && this.f22255i.f22248i.j() != null && !this.f22255i.f22248i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f22255i.f22248i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f22255i.f22248i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f22255i.t();
                    }
                } else if (i2 == 2) {
                    i iVar3 = this.f22255i;
                    if (iVar3.f22214e && iVar3.f22248i != null && this.f22255i.f22248i.j() != null && !this.f22255i.f22248i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f22255i.f22248i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f22255i.f22248i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f22255i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f22255i.u();
                }
                if (this.f22254h.isShowing()) {
                    this.f22254h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f22256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f22257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f22258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22259h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f22260i;

        public c(i iVar, o oVar, List list, int i2, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, oVar, list, Integer.valueOf(i2), popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22260i = iVar;
            this.f22256e = oVar;
            this.f22257f = list;
            this.f22258g = i2;
            this.f22259h = popupDialog;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f22260i.w(this.f22256e, this.f22257f, this.f22258g);
                } else if (i2 == 1) {
                    j.d(this.f22256e, this.f22260i.f22245f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f22256e, this.f22257f);
                }
                if (this.f22259h.isShowing()) {
                    this.f22259h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22261a;

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
            this.f22261a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.f22261a.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22262a;

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
            this.f22262a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.f22262a.f22245f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.f22262a.z();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22263a;

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
            this.f22263a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.f22263a.x((PersonChangeData) customResponsedMessage.getData());
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
        this.f22246g = new WriteImagesInfo(1);
        this.f22247h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f22245f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f22245f.registerListener(this.o);
        this.f22245f.registerListener(this.m);
        this.f22245f.registerListener(this.l);
    }

    public void A(b.a.r0.p2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f22248i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f22245f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f22245f.getString(R.string.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f22245f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(o oVar, List<n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, oVar, list, i2) == null) || (tbPageContext = this.f22245f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f22245f.getString(R.string.change_photo), this.f22245f.getString(R.string.change_system_photo), this.f22245f.getString(R.string.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f22245f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, oVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void I(o oVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, oVar, list, i2) == null) {
            String[] strArr = {this.f22245f.getString(R.string.look_big_photo), this.f22245f.getString(R.string.set_as_portrait_photo), this.f22245f.getString(R.string.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f22245f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, oVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        b.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f22248i) == null || aVar.j() == null) {
            return;
        }
        b.a.q0.c0.c.k().g(this.f22248i.j().getPortrait());
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
        this.f22246g.parseJson(stringExtra);
        this.f22246g.updateQuality();
        if (!ListUtils.isEmpty(this.f22246g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f22245f.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f22246g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f22247h)));
        }
        this.f22246g.clear();
    }

    public List<n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.r0.p2.e.a aVar = this.f22248i;
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
            if (nVar instanceof o) {
                w((o) nVar, list, i2);
                return;
            }
            return;
        }
        b.a.r0.p2.e.a aVar = this.f22248i;
        if (aVar != null) {
            this.f22214e = aVar.m();
        }
        if (!l.D()) {
            this.f22245f.showToast(R.string.neterror);
        } else if (!this.f22214e) {
            if (nVar instanceof o) {
                w((o) nVar, list, i2);
            }
        } else if (nVar instanceof b.a.r0.m2.h.c) {
            B();
        } else if (nVar instanceof o) {
            o oVar = (o) nVar;
            if (oVar.e()) {
                D(oVar, list, i2);
            } else {
                I(oVar, list, i2);
            }
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f22245f) == null) {
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
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f22245f.getPageActivity(), this.f22246g.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f22245f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f22245f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f22245f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f22245f.getPageActivity(), 12014, this.f22247h)));
    }

    public final void w(o oVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, oVar, list, i2) == null) || this.f22245f == null || oVar == null || list == null || StringUtils.isNull(oVar.a())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (n nVar : list) {
            if (nVar instanceof o) {
                o oVar2 = (o) nVar;
                if (oVar2.e() && !oVar2.a().startsWith("http")) {
                    arrayList.add(j.c(this.f22245f, oVar2.a()));
                } else {
                    arrayList.add(oVar2.a());
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
        ImageViewerConfig v = bVar.v(this.f22245f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f22245f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        b.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f22248i) == null || aVar.j() == null || !this.f22248i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.j == null) {
            this.j = new PersonChangeData();
        }
        this.j.setPhotoChanged(true);
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.n);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.e.e.m.e.a().postDelayed(this.n, 300L);
        }
    }
}
