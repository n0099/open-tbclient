package c.a.r0.d4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.r0.k3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.dialog.BdProgressDialog;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16846a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f16847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f16848c;

        public a(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, str, forumWriteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16846a = tbPageContext;
            this.f16847b = str;
            this.f16848c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.k(this.f16846a, this.f16847b, this.f16848c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f16850f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PluginNetConfigInfos.PluginConfig f16851g;

        public b(TbPageContext tbPageContext, ForumWriteData forumWriteData, PluginNetConfigInfos.PluginConfig pluginConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, forumWriteData, pluginConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16849e = tbPageContext;
            this.f16850f = forumWriteData;
            this.f16851g = pluginConfig;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                C0811i c0811i = new C0811i(this.f16849e, this.f16850f, i.p(this.f16849e));
                if (PluginPackageManager.O().Z(XiaoyingUtil.PKG_NAME_VIDEO)) {
                    PluginPackageManager.O().u0(c0811i);
                } else {
                    PluginPackageManager.O().x0(this.f16851g, c0811i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                PluginPackageManager.O().u0(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16853f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16854g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f16855h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f16856i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Boolean f16857j;
        public final /* synthetic */ PopupDialog k;

        public e(String str, String str2, String str3, String str4, int i2, Boolean bool, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), bool, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16852e = str;
            this.f16853f = str2;
            this.f16854g = str3;
            this.f16855h = str4;
            this.f16856i = i2;
            this.f16857j = bool;
            this.k = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.m(true, true, this.f16852e, this.f16853f, this.f16854g, this.f16855h, this.f16856i, this.f16857j);
                } else if (i2 == 1) {
                    i.m(true, false, this.f16852e, this.f16853f, this.f16854g, this.f16855h, this.f16856i, this.f16857j);
                }
                PopupDialog popupDialog = this.k;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f16858a;

        public f(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16858a = popupDialog;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.f16858a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16859e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16860f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16861g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f16862h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f16863i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Boolean f16864j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ PopupDialog m;

        public g(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16859e = str;
            this.f16860f = str2;
            this.f16861g = str3;
            this.f16862h = str4;
            this.f16863i = i2;
            this.f16864j = bool;
            this.k = str5;
            this.l = str6;
            this.m = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.n(true, true, this.f16859e, this.f16860f, this.f16861g, this.f16862h, this.f16863i, this.f16864j, this.k, this.l);
                } else if (i2 == 1) {
                    i.n(true, false, this.f16859e, this.f16860f, this.f16861g, this.f16862h, this.f16863i, this.f16864j, this.k, this.l);
                }
                PopupDialog popupDialog = this.m;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f16865a;

        public h(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16865a = popupDialog;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.f16865a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    /* renamed from: c.a.r0.d4.i$i  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0811i implements c.a.e.h.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext f16866a;

        /* renamed from: b  reason: collision with root package name */
        public ForumWriteData f16867b;

        /* renamed from: c  reason: collision with root package name */
        public BdProgressDialog f16868c;

        public C0811i(TbPageContext tbPageContext, ForumWriteData forumWriteData, BdProgressDialog bdProgressDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, forumWriteData, bdProgressDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16866a = null;
            this.f16866a = tbPageContext;
            this.f16867b = forumWriteData;
            this.f16868c = bdProgressDialog;
        }

        @Override // c.a.e.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
                BdProgressDialog bdProgressDialog = this.f16868c;
                if (bdProgressDialog != null) {
                    c.a.e.e.m.g.b(bdProgressDialog, this.f16866a);
                }
                this.f16866a.showToast(R.string.plugin_video_installing);
            }
        }

        @Override // c.a.e.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) {
                BdProgressDialog bdProgressDialog = this.f16868c;
                if (bdProgressDialog != null) {
                    c.a.e.e.m.g.b(bdProgressDialog, this.f16866a);
                }
                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && (tbPageContext = this.f16866a) != null) {
                    tbPageContext.showToast(bdFileDownloadData.getStatusMsg());
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // c.a.e.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) {
                BdProgressDialog bdProgressDialog = this.f16868c;
                if (bdProgressDialog != null) {
                    c.a.e.e.m.g.b(bdProgressDialog, this.f16866a);
                }
                if (i2 == 0) {
                    i.l(this.f16866a, "", this.f16867b);
                } else {
                    TbPageContext tbPageContext = this.f16866a;
                    tbPageContext.showToast(this.f16866a.getString(R.string.install_failed) + str);
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // c.a.e.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            BdProgressDialog bdProgressDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || (bdProgressDialog = this.f16868c) == null) {
                return;
            }
            bdProgressDialog.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.q0.s.d0.b.j().k("key_work_video_guide_pop", -1) : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? !TextUtils.isEmpty(z.w()) : invokeV.booleanValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 1 || i2 == 2 : invokeI.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1 : invokeV.booleanValue;
    }

    public static boolean f(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, context, i2, i3)) == null) {
            WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(context);
            workPublishGuideActivityConfig.setRequestCode(25064);
            workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            if (d(i2)) {
                workPublishGuideActivityConfig.setPopStatus(i2);
                workPublishGuideActivityConfig.setFrom(i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void g(c.a.e.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(fVar.getPageActivity());
        iVar.q(string);
        ArrayList arrayList = new ArrayList();
        c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        e eVar = new e(str, str2, str3, str4, i2, bool, popupDialog);
        f fVar4 = new f(popupDialog);
        iVar.k(arrayList);
        iVar.n(eVar);
        iVar.m(fVar4);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(iVar);
        popupDialog.showDialog();
    }

    public static void h(c.a.e.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(fVar.getPageActivity());
        iVar.q(string);
        ArrayList arrayList = new ArrayList();
        c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        g gVar = new g(str, str2, str3, str4, i2, bool, str5, str6, popupDialog);
        h hVar = new h(popupDialog);
        iVar.k(arrayList);
        iVar.n(gVar);
        iVar.m(hVar);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(iVar);
        popupDialog.showDialog();
    }

    public static void i(String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                g(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i2, bool);
            }
        }
    }

    public static void j(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                h(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i2, bool, str5, str6);
            }
        }
    }

    public static void k(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
            return;
        }
        if (e()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
            recordVideoActivityConfig.setShowType(0);
            if (forumWriteData != null) {
                recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
        } else if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
            }
        } else if (!j.z()) {
            tbPageContext.showToast(R.string.neterror);
        } else if (c.a.e.h.j.f.d.c().d() == null || (pluginConfig = c.a.e.h.j.f.d.c().d().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) == null) {
        } else {
            PluginNetConfigInfos.Newest newest = pluginConfig.newest;
            float f2 = (newest == null || (i2 = newest.size) <= 0) ? 0.0f : i2 / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(R.string.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_wifi);
            if (j.x()) {
                String string3 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_mobile);
                if (f2 > 0.0f) {
                    string2 = string3 + "（" + f2 + "MB）";
                } else {
                    string2 = string3;
                }
                string = tbPageContext.getPageActivity().getString(R.string.install_app);
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(string2);
            aVar.setPositiveButton(string, new b(tbPageContext, forumWriteData, pluginConfig));
            aVar.setNegativeButton(R.string.cancel, new c());
            aVar.create(tbPageContext).show();
        }
    }

    public static void l(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new a(tbPageContext, str, forumWriteData));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public static void m(boolean z, boolean z2, String str, String str2, String str3, String str4, int i2, Boolean bool) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) {
            if (!z) {
                i3 = 0;
            } else if (z2) {
                i3 = 2;
            } else {
                z.r("");
                i3 = 1;
            }
            c.a.q0.s.m.c.f14042f.c(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue());
        }
    }

    public static void n(boolean z, boolean z2, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) {
            if (!z) {
                i3 = 0;
            } else if (z2) {
                i3 = 2;
            } else {
                z.r("");
                i3 = 1;
            }
            c.a.q0.s.m.c.f14042f.d(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue(), str5, str6);
        }
    }

    public static void o(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, editText, i2) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static BdProgressDialog p(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, tbPageContext)) == null) {
            BdProgressDialog bdProgressDialog = new BdProgressDialog(tbPageContext.getPageActivity());
            bdProgressDialog.setOnCancelListener(new d());
            bdProgressDialog.setCancelable(true);
            bdProgressDialog.setCanceledOnTouchOutside(false);
            bdProgressDialog.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
            c.a.e.e.m.g.i(bdProgressDialog, tbPageContext.getPageActivity());
            return bdProgressDialog;
        }
        return (BdProgressDialog) invokeL.objValue;
    }
}
