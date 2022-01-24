package c.a.t0.p4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.s.j;
import c.a.t0.x3.a0;
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
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21539b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f21540c;

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
            this.f21539b = str;
            this.f21540c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s.i(this.a, this.f21539b, this.f21540c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21541e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f21542f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21543g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f21544h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f21545i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Boolean f21546j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ PopupDialog n;

        public b(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, String str7, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6, str7, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21541e = str;
            this.f21542f = str2;
            this.f21543g = str3;
            this.f21544h = str4;
            this.f21545i = i2;
            this.f21546j = bool;
            this.k = str5;
            this.l = str6;
            this.m = str7;
            this.n = popupDialog;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (i2 == 0) {
                    s.k(true, true, this.f21541e, this.f21542f, this.f21543g, this.f21544h, this.f21545i, this.f21546j, this.k, this.l, this.m);
                } else if (i2 == 1) {
                    s.k(true, false, this.f21541e, this.f21542f, this.f21543g, this.f21544h, this.f21545i, this.f21546j, this.k, this.l, this.m);
                }
                PopupDialog popupDialog = this.n;
                if (popupDialog != null) {
                    popupDialog.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements j.c {
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

        @Override // c.a.s0.s.s.j.c
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.s0.s.i0.b.k().l("key_work_video_guide_pop", -1) : invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? !TextUtils.isEmpty(a0.C()) : invokeV.booleanValue;
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

    public static void f(c.a.d.a.f fVar, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{fVar, str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6, str7}) == null) || fVar == null || fVar.getPageActivity() == null) {
            return;
        }
        String string = fVar.getString(R.string.work_publish_open_dialog_title);
        PopupDialog popupDialog = new PopupDialog(fVar);
        c.a.s0.s.s.j jVar = new c.a.s0.s.s.j(fVar.getPageActivity());
        jVar.q(string);
        ArrayList arrayList = new ArrayList();
        c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(0, fVar.getString(R.string.work_publish_open_dialog_load_draft), jVar);
        gVar.o(R.color.CAM_X0105);
        gVar.n(R.color.CAM_X0204);
        arrayList.add(gVar);
        c.a.s0.s.s.g gVar2 = new c.a.s0.s.s.g(1, fVar.getString(R.string.work_publish_open_dialog_add_new), jVar);
        gVar2.o(R.color.CAM_X0105);
        gVar2.n(R.color.CAM_X0204);
        arrayList.add(gVar2);
        b bVar = new b(str, str2, str3, str4, i2, bool, str5, str6, str7, popupDialog);
        c cVar = new c(popupDialog);
        jVar.j(arrayList);
        jVar.n(bVar);
        jVar.m(cVar);
        popupDialog.setCanceledOnTouchOutside(true);
        popupDialog.setContentView(jVar);
        popupDialog.showDialog();
    }

    public static void g(String str, String str2, String str3, String str4, int i2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool}) == null) {
            h(str, str2, str3, str4, i2, bool, "", "", "");
        }
    }

    public static void h(String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6, str7}) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                f(((TbPageContextSupport) currentActivity).getPageContext(), str, str2, str3, str4, i2, bool, str5, str6, str7);
            }
        }
    }

    public static void i(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null || !d()) {
            return;
        }
        RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
        recordVideoActivityConfig.setShowType(0);
        if (forumWriteData != null) {
            recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
    }

    public static void j(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
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

    public static void k(boolean z, boolean z2, String str, String str2, String str3, String str4, int i2, Boolean bool, String str5, String str6, String str7) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4, Integer.valueOf(i2), bool, str5, str6, str7}) == null) {
            if (!z) {
                i3 = 0;
            } else if (z2) {
                i3 = 2;
            } else {
                a0.x("");
                i3 = 1;
            }
            c.a.s0.s.m.d.a.c(i3, TbadkCoreApplication.getInst().getCurrentActivity(), str, str2, str3, str4, Integer.valueOf(i2), bool.booleanValue(), str5, str6, str7);
        }
    }

    public static void l(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, editText, i2) == null) {
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
