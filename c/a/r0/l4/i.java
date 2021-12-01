package c.a.r0.l4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.i;
import c.a.r0.t3.a0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19463b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f19464c;

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
            this.a = tbPageContext;
            this.f19463b = str;
            this.f19464c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.j(this.a, this.f19463b, this.f19464c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19467g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19468h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f19469i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Boolean f19470j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f19471k;

        public b(String str, String str2, String str3, String str4, int i2, Boolean bool, PopupDialog popupDialog) {
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
            this.f19465e = str;
            this.f19466f = str2;
            this.f19467g = str3;
            this.f19468h = str4;
            this.f19469i = i2;
            this.f19470j = bool;
            this.f19471k = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.l(true, true, this.f19465e, this.f19466f, this.f19467g, this.f19468h, this.f19469i, this.f19470j);
                } else if (i2 == 1) {
                    i.l(true, false, this.f19465e, this.f19466f, this.f19467g, this.f19468h, this.f19469i, this.f19470j);
                }
                PopupDialog popupDialog = this.f19471k;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupDialog a;

        public c(PopupDialog popupDialog) {
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
            this.a = popupDialog;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19475h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f19476i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Boolean f19477j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f19478k;
        public final /* synthetic */ String l;
        public final /* synthetic */ PopupDialog m;

        public d(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, PopupDialog popupDialog) {
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
            this.f19472e = str;
            this.f19473f = str2;
            this.f19474g = str3;
            this.f19475h = str4;
            this.f19476i = i2;
            this.f19477j = bool;
            this.f19478k = str5;
            this.l = str6;
            this.m = popupDialog;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    i.m(true, true, this.f19472e, this.f19473f, this.f19474g, this.f19475h, this.f19476i, this.f19477j, this.f19478k, this.l);
                } else if (i2 == 1) {
                    i.m(true, false, this.f19472e, this.f19473f, this.f19474g, this.f19475h, this.f19476i, this.f19477j, this.f19478k, this.l);
                }
                PopupDialog popupDialog = this.m;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PopupDialog a;

        public e(PopupDialog popupDialog) {
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
            this.a = popupDialog;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            PopupDialog popupDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupDialog = this.a) == null) {
                return;
            }
            popupDialog.dismiss();
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.q0.s.e0.b.j().k("key_work_video_guide_pop", -1) : invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? !TextUtils.isEmpty(a0.w()) : invokeV.booleanValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 || i2 == 2 : invokeI.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1 : invokeV.booleanValue;
    }

    public static boolean e(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, i3)) == null) {
            WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(context);
            workPublishGuideActivityConfig.setRequestCode(25064);
            workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            if (c(i2)) {
                workPublishGuideActivityConfig.setPopStatus(i2);
                workPublishGuideActivityConfig.setFrom(i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void f(c.a.d.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(fVar.getPageActivity());
        iVar.p(string);
        ArrayList arrayList = new ArrayList();
        c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        b bVar = new b(str, str2, str3, str4, i2, bool, popupDialog);
        c cVar = new c(popupDialog);
        iVar.j(arrayList);
        iVar.m(bVar);
        iVar.l(cVar);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(iVar);
        popupDialog.showDialog();
    }

    public static void g(c.a.d.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(fVar.getPageActivity());
        iVar.p(string);
        ArrayList arrayList = new ArrayList();
        c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), iVar);
        fVar2.o(R.color.CAM_X0105);
        fVar2.n(R.color.CAM_X0204);
        arrayList.add(fVar2);
        c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(1, fVar.getString(R.string.work_publish_open_dialog_add_new), iVar);
        fVar3.o(R.color.CAM_X0105);
        fVar3.n(R.color.CAM_X0204);
        arrayList.add(fVar3);
        d dVar = new d(str, str2, str3, str4, i2, bool, str5, str6, popupDialog);
        e eVar = new e(popupDialog);
        iVar.j(arrayList);
        iVar.m(dVar);
        iVar.l(eVar);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(iVar);
        popupDialog.showDialog();
    }

    public static void h(String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                f(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i2, bool);
            }
        }
    }

    public static void i(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                g(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i2, bool, str5, str6);
            }
        }
    }

    public static void j(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null || !d()) {
            return;
        }
        RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
        recordVideoActivityConfig.setShowType(0);
        if (forumWriteData != null) {
            recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
    }

    public static void k(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
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

    public static void l(boolean z, boolean z2, String str, String str2, String str3, String str4, int i2, Boolean bool) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) {
            if (!z) {
                i3 = 0;
            } else if (z2) {
                i3 = 2;
            } else {
                a0.r("");
                i3 = 1;
            }
            c.a.q0.s.m.d.a.c(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue());
        }
    }

    public static void m(boolean z, boolean z2, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6}) == null) {
            if (!z) {
                i3 = 0;
            } else if (z2) {
                i3 = 2;
            } else {
                a0.r("");
                i3 = 1;
            }
            c.a.q0.s.m.d.a.d(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue(), str5, str6);
        }
    }

    public static void n(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, editText, i2) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
