package b.a.r0.d4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.r0.l3.a0;
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
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f15841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f15842b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f15843c;

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
            this.f15841a = tbPageContext;
            this.f15842b = str;
            this.f15843c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.k(this.f15841a, this.f15842b, this.f15843c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f15844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f15845f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PluginNetConfigInfos.PluginConfig f15846g;

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
            this.f15844e = tbPageContext;
            this.f15845f = forumWriteData;
            this.f15846g = pluginConfig;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                C0806i c0806i = new C0806i(this.f15844e, this.f15845f, i.p(this.f15844e));
                if (PluginPackageManager.O().Z(XiaoyingUtil.PKG_NAME_VIDEO)) {
                    PluginPackageManager.O().u0(c0806i);
                } else {
                    PluginPackageManager.O().x0(this.f15846g, c0806i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class e implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15848f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f15849g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f15850h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f15851i;
        public final /* synthetic */ Boolean j;
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
            this.f15847e = str;
            this.f15848f = str2;
            this.f15849g = str3;
            this.f15850h = str4;
            this.f15851i = i2;
            this.j = bool;
            this.k = popupDialog;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.m(true, true, this.f15847e, this.f15848f, this.f15849g, this.f15850h, this.f15851i, this.j);
                } else if (i2 == 1) {
                    i.m(true, false, this.f15847e, this.f15848f, this.f15849g, this.f15850h, this.f15851i, this.j);
                }
                PopupDialog popupDialog = this.k;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f15852a;

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
            this.f15852a = popupDialog;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.f15852a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f15853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15854f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f15855g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f15856h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f15857i;
        public final /* synthetic */ Boolean j;
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
            this.f15853e = str;
            this.f15854f = str2;
            this.f15855g = str3;
            this.f15856h = str4;
            this.f15857i = i2;
            this.j = bool;
            this.k = str5;
            this.l = str6;
            this.m = popupDialog;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.n(true, true, this.f15853e, this.f15854f, this.f15855g, this.f15856h, this.f15857i, this.j, this.k, this.l);
                } else if (i2 == 1) {
                    i.n(true, false, this.f15853e, this.f15854f, this.f15855g, this.f15856h, this.f15857i, this.j, this.k, this.l);
                }
                PopupDialog popupDialog = this.m;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f15858a;

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
            this.f15858a = popupDialog;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.f15858a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    /* renamed from: b.a.r0.d4.i$i  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0806i implements b.a.e.h.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext f15859a;

        /* renamed from: b  reason: collision with root package name */
        public ForumWriteData f15860b;

        /* renamed from: c  reason: collision with root package name */
        public BdProgressDialog f15861c;

        public C0806i(TbPageContext tbPageContext, ForumWriteData forumWriteData, BdProgressDialog bdProgressDialog) {
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
            this.f15859a = null;
            this.f15859a = tbPageContext;
            this.f15860b = forumWriteData;
            this.f15861c = bdProgressDialog;
        }

        @Override // b.a.e.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
                BdProgressDialog bdProgressDialog = this.f15861c;
                if (bdProgressDialog != null) {
                    b.a.e.e.m.g.b(bdProgressDialog, this.f15859a);
                }
                this.f15859a.showToast(R.string.plugin_video_installing);
            }
        }

        @Override // b.a.e.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) {
                BdProgressDialog bdProgressDialog = this.f15861c;
                if (bdProgressDialog != null) {
                    b.a.e.e.m.g.b(bdProgressDialog, this.f15859a);
                }
                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && (tbPageContext = this.f15859a) != null) {
                    tbPageContext.showToast(bdFileDownloadData.getStatusMsg());
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // b.a.e.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) {
                BdProgressDialog bdProgressDialog = this.f15861c;
                if (bdProgressDialog != null) {
                    b.a.e.e.m.g.b(bdProgressDialog, this.f15859a);
                }
                if (i2 == 0) {
                    i.l(this.f15859a, "", this.f15860b);
                } else {
                    TbPageContext tbPageContext = this.f15859a;
                    tbPageContext.showToast(this.f15859a.getString(R.string.install_failed) + str);
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // b.a.e.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            BdProgressDialog bdProgressDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || (bdProgressDialog = this.f15861c) == null) {
                return;
            }
            bdProgressDialog.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b.a.q0.s.e0.b.j().k("key_work_video_guide_pop", -1) : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? !TextUtils.isEmpty(a0.w()) : invokeV.booleanValue;
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

    public static void g(b.a.e.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(fVar.getPageActivity());
        iVar.p(string);
        ArrayList arrayList = new ArrayList();
        b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        e eVar = new e(str, str2, str3, str4, i2, bool, popupDialog);
        f fVar4 = new f(popupDialog);
        iVar.j(arrayList);
        iVar.m(eVar);
        iVar.l(fVar4);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(iVar);
        popupDialog.showDialog();
    }

    public static void h(b.a.e.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(fVar.getPageActivity());
        iVar.p(string);
        ArrayList arrayList = new ArrayList();
        b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        g gVar = new g(str, str2, str3, str4, i2, bool, str5, str6, popupDialog);
        h hVar = new h(popupDialog);
        iVar.j(arrayList);
        iVar.m(gVar);
        iVar.l(hVar);
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
        } else if (b.a.e.h.j.f.d.c().d() == null || (pluginConfig = b.a.e.h.j.f.d.c().d().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) == null) {
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
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
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
                a0.r("");
                i3 = 1;
            }
            b.a.q0.s.m.c.f13160f.c(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue());
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
                a0.r("");
                i3 = 1;
            }
            b.a.q0.s.m.c.f13160f.d(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue(), str5, str6);
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
            b.a.e.e.m.g.i(bdProgressDialog, tbPageContext.getPageActivity());
            return bdProgressDialog;
        }
        return (BdProgressDialog) invokeL.objValue;
    }
}
