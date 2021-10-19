package c.a.q0.d1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p0 extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f13012e;

    /* renamed from: f  reason: collision with root package name */
    public final TbPageContext<?> f13013f;

    /* renamed from: g  reason: collision with root package name */
    public String f13014g;

    /* renamed from: h  reason: collision with root package name */
    public String f13015h;

    /* renamed from: i  reason: collision with root package name */
    public String f13016i;

    /* renamed from: j  reason: collision with root package name */
    public String f13017j;
    public String k;
    public ItemData l;
    public AlertDialog m;
    public TiePlusDownloadDialog n;
    public final List<ProgressButton> o;
    public final PermissionJudgePolicy p;
    public final SharedPreferences q;
    public int r;

    /* loaded from: classes3.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p0 f13018a;

        public a(p0 p0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13018a = p0Var;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.f13018a.k) || StringUtils.isNull(this.f13018a.f13014g) || StringUtils.isNull(this.f13018a.f13015h)) {
                return;
            }
            c.a.q0.w.c.q().z(this.f13018a.f13014g, this.f13018a.k, this.f13018a.f13015h, -1, -1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(@NonNull Context context) {
        super(2001118);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13012e = context;
        this.o = new ArrayList();
        this.q = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.p = new PermissionJudgePolicy();
        this.r = TbadkCoreApplication.getInst().getSkinType();
        this.p.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.f13013f = ((TbPageContextSupport) this.f13012e).getPageContext();
        } else {
            this.f13013f = null;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences sharedPreferences = this.q;
            int i2 = sharedPreferences.getInt(this.f13014g + this.f13015h, 0);
            for (ProgressButton progressButton : this.o) {
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i2);
            }
            DownloadData downloadData = new DownloadData(this.f13014g);
            downloadData.setExtra(Integer.valueOf(i2));
            downloadData.setStatus(5);
            c.a.q0.w.c.q().w(downloadData);
        }
    }

    public final void B(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        this.p.clearRequestPermissionList();
        this.p.appendRequestPermission(this.f13013f.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.p.appendRequestPermission(this.f13013f.getPageActivity(), "android.permission.READ_EXTERNAL_STORAGE");
        this.p.startRequestPermission(activity);
    }

    public void D(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, context, progressButton) == null) {
            boolean isUseLongText = progressButton.isUseLongText();
            if (l(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_open : R.string.pb_video_promotion_mount_open));
            } else if (c.a.q0.w.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_install : R.string.install));
            } else if (!c.a.q0.w.c.q().t(str) && !c.a.q0.w.c.q().r(str)) {
                File m = c.a.q0.w.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.q;
                    int i2 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i2);
                    progressButton.setText(context.getString(isUseLongText ? R.string.go_on_download : R.string.go_on));
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                progressButton.setText(context.getString(isUseLongText ? R.string.install_app : R.string.download));
            } else {
                SharedPreferences sharedPreferences2 = this.q;
                int i3 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i3);
            }
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SharedPreferences sharedPreferences = this.q;
            if (i2 != sharedPreferences.getInt(this.f13014g + this.f13015h, -1)) {
                SharedPreferences.Editor edit = this.q.edit();
                edit.putInt(this.f13014g + this.f13015h, i2);
                edit.apply();
            }
        }
    }

    public void d(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, progressButton) == null) || progressButton == null || this.o.contains(progressButton)) {
            return;
        }
        this.o.add(progressButton);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SharedPreferences sharedPreferences = this.q;
            if (sharedPreferences.getInt(this.f13014g + this.f13015h, -1) != -1) {
                SharedPreferences.Editor edit = this.q.edit();
                edit.remove(this.f13014g + this.f13015h);
                edit.apply();
            }
        }
    }

    public void f(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            g(str, i2, "");
        }
    }

    public void g(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048583, this, str, i2, str2) == null) || StringUtils.isNull(str) || this.f13013f == null) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_BLACKLIST, true);
            UrlManager.getInstance().dealOneLink(this.f13013f, new String[]{str}, bundle);
        } else if (i2 == 2) {
            c.a.q0.m.a.j(this.f13012e, str);
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            if (!l(this.f13012e, "com.tencent.mm")) {
                BdToast.c(this.f13012e.getApplicationContext(), this.f13012e.getText(R.string.tie_plus_wechat_not_install)).q();
            } else if (TextUtils.isEmpty(str)) {
            } else {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), TbConfig.WEIXIN_APP_ID);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                if (!TextUtils.isEmpty(str2)) {
                    req.path = str2;
                }
                createWXAPI.sendReq(req);
            }
        } else {
            UtilHelper.copyToClipBoard(str);
            if (this.m != null && this.r == TbadkCoreApplication.getInst().getSkinType()) {
                this.m.show();
                return;
            }
            this.r = TbadkCoreApplication.getInst().getSkinType();
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f13013f.getPageActivity());
            lVar.q(this.f13012e.getString(R.string.tie_plus_copy_wechat_success));
            lVar.m(this.f13012e.getString(R.string.tie_plus_open_wechat));
            lVar.l(true);
            lVar.g(false);
            lVar.o(new TBAlertConfig.a(this.f13012e.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.q0.d1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        p0.this.m(view);
                    }
                }
            }), new TBAlertConfig.a(this.f13012e.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.q0.d1.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        p0.this.n(view);
                    }
                }
            }));
            this.m = lVar.s();
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13015h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f13014g : (String) invokeV.objValue;
    }

    public final void j(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f13014g) || StringUtils.isNull(this.f13015h) || StringUtils.isNull(this.k)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.l != null) {
                c.a.r0.j0.b.b bVar = new c.a.r0.j0.b.b();
                bVar.f19309e = this.l;
                bVar.f19310f = 2;
                Context context = this.f13012e;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bVar.f19311g = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
            }
            A();
            z(activity);
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                z(activity);
            } else if (byteValue == 3) {
                A();
                z(activity);
            } else if (byteValue != 4) {
            } else {
                o(this.f13012e, this.f13014g);
            }
        } else if (k(activity)) {
            if (!c.a.q0.w.c.q().r(this.f13014g) && !c.a.q0.w.c.q().t(this.f13014g)) {
                DownloadData downloadData = new DownloadData(this.f13014g);
                downloadData.setStatus(4);
                c.a.q0.w.c.q().w(downloadData);
                return;
            }
            c.a.q0.w.c.q().g(this.k, this.f13014g);
        } else {
            B(activity);
        }
    }

    public final boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.p.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.p.checkPermissionGranted(activity, "android.permission.READ_EXTERNAL_STORAGE");
        }
        return invokeL.booleanValue;
    }

    public final boolean l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        context.getPackageManager().getPackageInfo(str, 64);
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public /* synthetic */ void m(View view) {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void n(View view) {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!l(this.f13012e, "com.tencent.mm")) {
            BdToast.c(this.f13012e.getApplicationContext(), this.f13012e.getText(R.string.tie_plus_wechat_not_install)).q();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            this.f13012e.startActivity(intent);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final boolean o(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return false;
            }
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(268435456);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f13013f) != null) {
                j((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    f(this.f13017j, 0);
                    return;
                case 17:
                    f(this.f13016i, 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f13014g) && !StringUtils.isNull(this.k)) {
                        c.a.q0.w.c.q().h(this.k, this.f13014g, true);
                        File j2 = c.a.q0.w.c.q().j(this.f13014g);
                        if (j2 != null && j2.exists()) {
                            j2.delete();
                        }
                        if (!StringUtils.isNull(this.f13015h) && (m = c.a.q0.w.c.q().m(this.f13014g, this.f13015h)) != null && m.exists()) {
                            m.delete();
                        }
                        e();
                        DownloadData downloadData = new DownloadData(this.f13014g);
                        downloadData.setStatus(4);
                        c.a.q0.w.c.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.f13014g));
                    }
                    TiePlusDownloadDialog tiePlusDownloadDialog = this.n;
                    if (tiePlusDownloadDialog != null) {
                        tiePlusDownloadDialog.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void p(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, progressButton) == null) || progressButton == null) {
            return;
        }
        this.o.remove(progressButton);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n = null;
            AlertDialog alertDialog = this.m;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.m = null;
            }
            this.o.clear();
        }
    }

    public p0 r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.f13015h = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public void s(TiePlusDownloadDialog tiePlusDownloadDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tiePlusDownloadDialog) == null) {
            this.n = tiePlusDownloadDialog;
        }
    }

    public p0 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public void u(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, itemData) == null) {
            this.l = itemData;
        }
    }

    public p0 v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f13014g = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f13016i = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            this.f13017j = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || StringUtils.isNull(this.f13015h)) {
            return;
        }
        for (ProgressButton progressButton : this.o) {
            progressButton.setCurProgress(-1);
            D(this.f13014g, this.f13015h, this.f13012e, progressButton);
        }
    }

    public final void z(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, activity) == null) {
            if (k(activity)) {
                c.a.q0.w.c.q().z(this.f13014g, this.k, this.f13015h, -1, -1);
            } else {
                B(activity);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f13014g) || this.o.size() <= 0) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 10 && !StringUtils.isNull(this.f13015h)) {
                        for (ProgressButton progressButton : this.o) {
                            D(this.f13014g, this.f13015h, this.f13012e, progressButton);
                        }
                    } else if (this.f13014g.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.f13015h)) {
                                for (ProgressButton progressButton2 : this.o) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            e();
                            return;
                        } else if (status == 1) {
                            int k = (int) (c.a.q0.w.c.q().k(this.f13014g) * 100.0f);
                            J(k);
                            for (ProgressButton progressButton3 : this.o) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.updateProgress(k);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.f13013f;
                            if (tbPageContext != null) {
                                tbPageContext.showToast(R.string.download_error_info);
                            }
                            y();
                            return;
                        } else if (status == 3) {
                            e();
                            return;
                        } else if (status == 4) {
                            y();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i2 = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i2 = ((Integer) downloadData.getExtra()).intValue();
                                J(i2);
                            }
                            for (ProgressButton progressButton4 : this.o) {
                                progressButton4.setTag((byte) 1);
                                progressButton4.updateProgress(i2);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
