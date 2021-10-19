package c.a.r0.p2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.s.i;
import c.a.q0.u.m;
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
public class i extends c.a.r0.p2.d.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f23349f;

    /* renamed from: g  reason: collision with root package name */
    public final WriteImagesInfo f23350g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23351h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.p2.e.a f23352i;

    /* renamed from: j  reason: collision with root package name */
    public PersonChangeData f23353j;
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
        public final /* synthetic */ PopupDialog f23354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f23355f;

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
            this.f23355f = iVar;
            this.f23354e = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f23355f.f23351h = false;
                if (i2 == 0) {
                    this.f23355f.t();
                } else if (i2 == 1) {
                    this.f23355f.v();
                }
                if (this.f23354e.isShowing()) {
                    this.f23354e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f23356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f23357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f23358g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f23359h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f23360i;

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
            this.f23360i = iVar;
            this.f23356e = mVar;
            this.f23357f = list;
            this.f23358g = i2;
            this.f23359h = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f23360i.f23351h = true;
                if (i2 == 0) {
                    this.f23360i.w(this.f23356e, this.f23357f, this.f23358g);
                } else if (i2 == 1) {
                    i iVar2 = this.f23360i;
                    if (iVar2.f23315e && iVar2.f23352i != null && this.f23360i.f23352i.j() != null && !this.f23360i.f23352i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f23360i.f23352i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f23360i.f23352i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f23360i.t();
                    }
                } else if (i2 == 2) {
                    i iVar3 = this.f23360i;
                    if (iVar3.f23315e && iVar3.f23352i != null && this.f23360i.f23352i.j() != null && !this.f23360i.f23352i.j().canModifyAvatar()) {
                        if (!StringUtils.isNull(this.f23360i.f23352i.j().getCantModifyAvatarDesc())) {
                            l.J(TbadkCoreApplication.getInst(), this.f23360i.f23352i.j().getCantModifyAvatarDesc());
                        } else {
                            l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                        }
                    } else {
                        this.f23360i.v();
                    }
                } else if (i2 == 3) {
                    TiebaStatic.log(new StatisticItem("c11616").param("obj_type", 1));
                    this.f23360i.u();
                }
                if (this.f23359h.isShowing()) {
                    this.f23359h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f23361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f23362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f23363g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f23364h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f23365i;

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
            this.f23365i = iVar;
            this.f23361e = mVar;
            this.f23362f = list;
            this.f23363g = i2;
            this.f23364h = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f23365i.w(this.f23361e, this.f23362f, this.f23363g);
                } else if (i2 == 1) {
                    j.d(this.f23361e, this.f23365i.f23349f.getUniqueId());
                } else if (i2 == 2) {
                    j.b(this.f23361e, this.f23362f);
                }
                if (this.f23364h.isShowing()) {
                    this.f23364h.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f23366a;

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
            this.f23366a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                this.f23366a.z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f23367a;

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
            this.f23367a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    this.f23367a.f23349f.showToast(setUserPicsResponse.getErrorString());
                } else {
                    this.f23367a.z();
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
        public final /* synthetic */ i f23368a;

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
            this.f23368a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.f23368a.x((PersonChangeData) customResponsedMessage.getData());
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
        this.f23350g = new WriteImagesInfo(1);
        this.f23351h = true;
        this.l = new d(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
        this.m = new e(this, CmdConfigHttp.CMD_SET_USER_PICS);
        this.n = new f(this);
        g gVar = new g(this, 2001380);
        this.o = gVar;
        this.f23349f = tbPageContext;
        gVar.setTag(bdUniqueId);
        this.m.setTag(bdUniqueId);
        this.l.setTag(bdUniqueId);
        this.f23349f.registerListener(this.o);
        this.f23349f.registerListener(this.m);
        this.f23349f.registerListener(this.l);
    }

    public void A(c.a.r0.p2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f23352i = aVar;
        }
    }

    public final void B() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f23349f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.choose_local_photo), this.f23349f.getString(R.string.change_system_photo)};
        PopupDialog popupDialog = new PopupDialog(this.f23349f);
        popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog));
        popupDialog.showDialog();
    }

    public final void D(m mVar, List<n> list, int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, mVar, list, i2) == null) || (tbPageContext = this.f23349f) == null) {
            return;
        }
        String[] strArr = {tbPageContext.getString(R.string.hd_photo), this.f23349f.getString(R.string.change_photo), this.f23349f.getString(R.string.change_system_photo), this.f23349f.getString(R.string.check_headpendant)};
        PopupDialog popupDialog = new PopupDialog(this.f23349f);
        popupDialog.setDefaultContentView(null, strArr, new b(this, mVar, list, i2, popupDialog));
        popupDialog.showDialog();
    }

    public final void J(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, mVar, list, i2) == null) {
            String[] strArr = {this.f23349f.getString(R.string.look_big_photo), this.f23349f.getString(R.string.set_as_portrait_photo), this.f23349f.getString(R.string.delete)};
            PopupDialog popupDialog = new PopupDialog(this.f23349f);
            popupDialog.setDefaultContentView(null, strArr, new c(this, mVar, list, i2, popupDialog));
            popupDialog.showDialog();
        }
    }

    public void o() {
        c.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f23352i) == null || aVar.j() == null) {
            return;
        }
        c.a.q0.c0.c.k().g(this.f23352i.j().getPortrait());
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
        this.f23350g.parseJson(stringExtra);
        this.f23350g.updateQuality();
        if (!ListUtils.isEmpty(this.f23350g.getChosedFiles())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.f23349f.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.f23350g.getChosedFiles().get(0).getFilePath(), 1.0f, this.f23351h)));
        }
        this.f23350g.clear();
    }

    public List<n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.r0.p2.e.a aVar = this.f23352i;
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
        c.a.r0.p2.e.a aVar = this.f23352i;
        if (aVar != null) {
            this.f23315e = aVar.m();
        }
        if (!l.D()) {
            this.f23349f.showToast(R.string.neterror);
        } else if (!this.f23315e) {
            if (nVar instanceof m) {
                w((m) nVar, list, i2);
            }
        } else if (nVar instanceof c.a.r0.m2.h.c) {
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbPageContext = this.f23349f) == null) {
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
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f23349f.getPageActivity(), this.f23350g.toJsonString(), true);
        albumActivityConfig.setRequestCode(12002);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f23349f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.f23349f.getPageActivity())));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f23349f == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f23349f.getPageActivity(), 12014, this.f23351h)));
    }

    public final void w(m mVar, List<n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048589, this, mVar, list, i2) == null) || this.f23349f == null || mVar == null || list == null || StringUtils.isNull(mVar.b())) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (n nVar : list) {
            if (nVar instanceof m) {
                m mVar2 = (m) nVar;
                if (mVar2.d() && !mVar2.b().startsWith("http")) {
                    arrayList.add(j.c(this.f23349f, mVar2.b()));
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
        ImageViewerConfig v = bVar.v(this.f23349f.getPageActivity());
        v.getIntent().putExtra("from", "portrait");
        this.f23349f.sendMessage(new CustomMessage(2010000, v));
    }

    public final void x(PersonChangeData personChangeData) {
        c.a.r0.p2.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, personChangeData) == null) || personChangeData == null || (aVar = this.f23352i) == null || aVar.j() == null || !this.f23352i.m() || !personChangeData.getPhotoChanged()) {
            return;
        }
        if (this.f23353j == null) {
            this.f23353j = new PersonChangeData();
        }
        this.f23353j.setPhotoChanged(true);
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
