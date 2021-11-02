package b.a.q0.d1;

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
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
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
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes4.dex */
public class p0 extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static List<b.a.q0.u.m> u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f12170e;

    /* renamed from: f  reason: collision with root package name */
    public final TbPageContext<?> f12171f;

    /* renamed from: g  reason: collision with root package name */
    public String f12172g;

    /* renamed from: h  reason: collision with root package name */
    public String f12173h;

    /* renamed from: i  reason: collision with root package name */
    public String f12174i;
    public String j;
    public String k;
    public String l;
    public ItemData m;
    public AlertDialog n;
    public TiePlusDownloadDialog o;
    public final List<ProgressButton> p;
    public final PermissionJudgePolicy q;
    public final SharedPreferences r;
    public int s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p0 f12175a;

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
            this.f12175a = p0Var;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.f12175a.l) || StringUtils.isNull(this.f12175a.f12172g) || StringUtils.isNull(this.f12175a.f12173h)) {
                return;
            }
            b.a.q0.w.c.q().A(this.f12175a.f12172g, this.f12175a.l, this.f12175a.f12173h, -1, -1, null, true, false, false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12176e;

        public b(p0 p0Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12176e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(this.f12176e, 3);
                downloadManagerActivityConfig.setCurrentTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1507960002, "Lb/a/q0/d1/p0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1507960002, "Lb/a/q0/d1/p0;");
                return;
            }
        }
        u = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(@NonNull Context context) {
        super(2001118);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = false;
        this.f12170e = context;
        this.p = new ArrayList();
        this.r = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.q = new PermissionJudgePolicy();
        this.s = TbadkCoreApplication.getInst().getSkinType();
        this.q.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.f12171f = ((TbPageContextSupport) this.f12170e).getPageContext();
        } else {
            this.f12171f = null;
        }
    }

    public p0 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f12174i = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || StringUtils.isNull(this.f12173h)) {
            return;
        }
        for (ProgressButton progressButton : this.p) {
            progressButton.setCurProgress(-1);
            P(this.f12172g, this.f12173h, this.f12170e, progressButton);
        }
    }

    public final void I(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            if (m(activity)) {
                b.a.q0.w.c.q().A(this.f12172g, this.l, this.f12173h, -1, -1, null, true, false, false);
            } else {
                M(activity);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            int i2 = sharedPreferences.getInt(this.f12172g + this.f12173h, 0);
            for (ProgressButton progressButton : this.p) {
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i2);
            }
            DownloadData downloadData = new DownloadData(this.f12172g);
            downloadData.setExtra(Integer.valueOf(i2));
            downloadData.setName(this.f12173h);
            downloadData.setStatus(5);
            b.a.q0.w.c.q().w(downloadData);
        }
    }

    public final void K(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, activity) == null) && activity != null && m(activity)) {
            TiePlusDownloadDialog tiePlusDownloadDialog = this.o;
            if (tiePlusDownloadDialog != null) {
                tiePlusDownloadDialog.dismiss();
            }
            new ScreenTopToast(activity).setTitle(activity.getResources().getString(R.string.tie_plus_jump_download_manager_toast)).setBtnText(activity.getResources().getString(R.string.dialog_confirm_see)).setBtnClickListener(new b(this, activity)).show((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void M(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, activity) == null) || activity == null) {
            return;
        }
        this.q.clearRequestPermissionList();
        this.q.appendRequestPermission(this.f12171f.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.q.appendRequestPermission(this.f12171f.getPageActivity(), "android.permission.READ_EXTERNAL_STORAGE");
        this.q.startRequestPermission(activity);
    }

    public void O(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, context, textView) == null) {
            if (!n(context, str) && !b.a.q0.w.c.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void P(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, context, progressButton) == null) {
            boolean isUseLongText = progressButton.isUseLongText();
            if (n(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_open : R.string.pb_video_promotion_mount_open));
            } else if (b.a.q0.w.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_install : R.string.install));
            } else if (!b.a.q0.w.c.q().t(str) && !b.a.q0.w.c.q().r(str)) {
                File m = b.a.q0.w.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.r;
                    int i2 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i2);
                    progressButton.setText(context.getString(isUseLongText ? R.string.go_on_download : R.string.go_on));
                    if (this.t) {
                        d();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                progressButton.setText(context.getString(isUseLongText ? R.string.install_app : R.string.download));
            } else {
                SharedPreferences sharedPreferences2 = this.r;
                int i3 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i3);
                if (this.t) {
                    d();
                }
            }
        }
    }

    public final void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (i2 != sharedPreferences.getInt(this.f12172g + this.f12173h, -1)) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.putInt(this.f12172g + this.f12173h, i2);
                edit.apply();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.q0.f1.l.a.c().a(this.f12172g, this.j);
        }
    }

    public void e(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, progressButton) == null) || progressButton == null || this.p.contains(progressButton)) {
            return;
        }
        this.p.add(progressButton);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(b.a.q0.u.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, mVar) == null) || mVar == null) {
            return;
        }
        for (b.a.q0.u.m mVar2 : u) {
            if (TextUtils.isEmpty(mVar.f14158f) || mVar.f14158f.equals(mVar2.f14158f)) {
                return;
            }
            while (r0.hasNext()) {
            }
        }
        u.add(mVar);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (sharedPreferences.getInt(this.f12172g + this.f12173h, -1) != -1) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.remove(this.f12172g + this.f12173h);
                edit.apply();
            }
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            i(str, i2, "");
        }
    }

    public void i(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048591, this, str, i2, str2) == null) || StringUtils.isNull(str) || this.f12171f == null) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_BLACKLIST, true);
            UrlManager.getInstance().dealOneLink(this.f12171f, new String[]{str}, bundle);
        } else if (i2 == 2) {
            b.a.q0.m.a.j(this.f12170e, str);
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            if (!n(this.f12170e, "com.tencent.mm")) {
                BdToast.c(this.f12170e.getApplicationContext(), this.f12170e.getText(R.string.tie_plus_wechat_not_install)).q();
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
            if (this.n != null && this.s == TbadkCoreApplication.getInst().getSkinType()) {
                this.n.show();
                return;
            }
            this.s = TbadkCoreApplication.getInst().getSkinType();
            b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f12171f.getPageActivity());
            lVar.r(this.f12170e.getString(R.string.tie_plus_copy_wechat_success));
            lVar.n(this.f12170e.getString(R.string.tie_plus_open_wechat));
            lVar.l(true);
            lVar.g(false);
            lVar.p(new TBAlertConfig.a(this.f12170e.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: b.a.q0.d1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        p0.this.o(view);
                    }
                }
            }), new TBAlertConfig.a(this.f12170e.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: b.a.q0.d1.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        p0.this.p(view);
                    }
                }
            }));
            this.n = lVar.t();
        }
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f12173h : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f12172g : (String) invokeV.objValue;
    }

    public final void l(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f12172g) || StringUtils.isNull(this.f12173h) || StringUtils.isNull(this.l)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.m != null) {
                b.a.r0.j0.b.b bVar = new b.a.r0.j0.b.b();
                bVar.f18296e = this.m;
                bVar.f18297f = 2;
                Context context = this.f12170e;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bVar.f18298g = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
            }
            J();
            I(activity);
            if (this.t) {
                d();
                K(activity);
            }
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                I(activity);
            } else if (byteValue == 3) {
                J();
                I(activity);
            } else if (byteValue != 4) {
            } else {
                q(this.f12170e, this.f12172g);
            }
        } else if (m(activity)) {
            if (!b.a.q0.w.c.q().r(this.f12172g) && !b.a.q0.w.c.q().t(this.f12172g)) {
                DownloadData downloadData = new DownloadData(this.f12172g);
                downloadData.setStatus(4);
                b.a.q0.w.c.q().w(downloadData);
                return;
            }
            b.a.q0.w.c.q().g(this.l, this.f12172g);
        } else {
            M(activity);
        }
    }

    public final boolean m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.q.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.q.checkPermissionGranted(activity, "android.permission.READ_EXTERNAL_STORAGE");
        }
        return invokeL.booleanValue;
    }

    public final boolean n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, context, str)) == null) {
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

    public /* synthetic */ void o(View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f12171f) != null) {
                l((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    h(this.k, 0);
                    return;
                case 17:
                    h(this.f12174i, 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f12172g) && !StringUtils.isNull(this.l)) {
                        b.a.q0.w.c.q().h(this.l, this.f12172g, true);
                        File j = b.a.q0.w.c.q().j(this.f12172g);
                        if (j != null && j.exists()) {
                            j.delete();
                        }
                        if (!StringUtils.isNull(this.f12173h) && (m = b.a.q0.w.c.q().m(this.f12172g, this.f12173h)) != null && m.exists()) {
                            m.delete();
                        }
                        g();
                        DownloadData downloadData = new DownloadData(this.f12172g);
                        downloadData.setStatus(4);
                        b.a.q0.w.c.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.f12172g));
                    }
                    b.a.q0.f1.l.a.c().h(this.f12172g);
                    TiePlusDownloadDialog tiePlusDownloadDialog = this.o;
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

    public /* synthetic */ void p(View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!n(this.f12170e, "com.tencent.mm")) {
            BdToast.c(this.f12170e.getApplicationContext(), this.f12170e.getText(R.string.tie_plus_wechat_not_install)).q();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            this.f12170e.startActivity(intent);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final boolean q(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, context, str)) == null) {
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

    public void r(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, progressButton) == null) || progressButton == null) {
            return;
        }
        this.p.remove(progressButton);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.o = null;
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.n = null;
            }
            this.p.clear();
        }
    }

    public p0 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            this.f12173h = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public void v(TiePlusDownloadDialog tiePlusDownloadDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, tiePlusDownloadDialog) == null) {
            this.o = tiePlusDownloadDialog;
        }
    }

    public p0 w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 x(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (p0) invokeZ.objValue;
    }

    public void y(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, itemData) == null) {
            this.m = itemData;
        }
    }

    public p0 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.f12172g = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f12172g)) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.f12173h)) {
                        for (ProgressButton progressButton : this.p) {
                            P(this.f12172g, this.f12173h, this.f12170e, progressButton);
                        }
                    } else if (this.f12172g.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.f12173h)) {
                                for (ProgressButton progressButton2 : this.p) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            g();
                            return;
                        } else if (status == 1) {
                            int k = (int) (b.a.q0.w.c.q().k(this.f12172g) * 100.0f);
                            Q(k);
                            for (ProgressButton progressButton3 : this.p) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.updateProgress(k);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.f12171f;
                            if (tbPageContext != null) {
                                tbPageContext.showToast(R.string.download_error_info);
                            }
                            D();
                            return;
                        } else if (status == 3) {
                            g();
                            return;
                        } else if (status == 4) {
                            D();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i2 = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i2 = ((Integer) downloadData.getExtra()).intValue();
                                Q(i2);
                            }
                            for (ProgressButton progressButton4 : this.p) {
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
