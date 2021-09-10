package c.a.q0.d1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p0 extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f12978e;

    /* renamed from: f  reason: collision with root package name */
    public final TbPageContext<?> f12979f;

    /* renamed from: g  reason: collision with root package name */
    public String f12980g;

    /* renamed from: h  reason: collision with root package name */
    public String f12981h;

    /* renamed from: i  reason: collision with root package name */
    public String f12982i;

    /* renamed from: j  reason: collision with root package name */
    public String f12983j;
    public String k;
    public TiePlusDownloadDialog l;
    public final List<ProgressButton> m;
    public final PermissionJudgePolicy n;
    public final SharedPreferences o;

    /* loaded from: classes3.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p0 f12984a;

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
            this.f12984a = p0Var;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.f12984a.k) || StringUtils.isNull(this.f12984a.f12980g) || StringUtils.isNull(this.f12984a.f12981h)) {
                return;
            }
            c.a.q0.w.c.q().z(this.f12984a.f12980g, this.f12984a.k, this.f12984a.f12981h, -1, -1);
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
        this.f12978e = context;
        this.m = new ArrayList();
        this.o = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        this.n = permissionJudgePolicy;
        permissionJudgePolicy.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.f12979f = ((TbPageContextSupport) this.f12978e).getPageContext();
        } else {
            this.f12979f = null;
        }
    }

    public void d(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, progressButton) == null) || progressButton == null || this.m.contains(progressButton)) {
            return;
        }
        this.m.add(progressButton);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPreferences sharedPreferences = this.o;
            if (sharedPreferences.getInt(this.f12980g + this.f12981h, -1) != -1) {
                SharedPreferences.Editor edit = this.o.edit();
                edit.remove(this.f12980g + this.f12981h);
                edit.apply();
            }
        }
    }

    public void f(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) || StringUtils.isNull(str) || this.f12979f == null) {
            return;
        }
        if (z) {
            UrlManager.getInstance().dealOneLink(this.f12979f, new String[]{str});
        } else {
            c.a.q0.m.a.j(this.f12978e, str);
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12981h : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12980g : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f12980g) || StringUtils.isNull(this.f12981h) || StringUtils.isNull(this.k)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue != 0) {
            if (byteValue == 1) {
                if (j(activity)) {
                    if (!c.a.q0.w.c.q().r(this.f12980g) && !c.a.q0.w.c.q().t(this.f12980g)) {
                        DownloadData downloadData = new DownloadData(this.f12980g);
                        downloadData.setStatus(4);
                        c.a.q0.w.c.q().w(downloadData);
                        return;
                    }
                    c.a.q0.w.c.q().g(this.k, this.f12980g);
                    return;
                }
                u(activity);
                return;
            }
            if (byteValue != 2) {
                if (byteValue != 3) {
                    if (byteValue != 4) {
                        return;
                    }
                    l(this.f12978e, this.f12980g);
                    return;
                }
            }
            if (!j(activity)) {
                c.a.q0.w.c.q().z(this.f12980g, this.k, this.f12981h, -1, -1);
                return;
            } else {
                u(activity);
                return;
            }
        }
        SharedPreferences sharedPreferences = this.o;
        int i2 = sharedPreferences.getInt(this.f12980g + this.f12981h, 0);
        for (ProgressButton progressButton2 : this.m) {
            progressButton2.setTag((byte) 1);
            progressButton2.updateProgress(i2);
        }
        DownloadData downloadData2 = new DownloadData(this.f12980g);
        downloadData2.setExtra(Integer.valueOf(i2));
        downloadData2.setStatus(5);
        c.a.q0.w.c.q().w(downloadData2);
        if (!j(activity)) {
        }
    }

    public final boolean j(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.n.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.n.checkPermissionGranted(activity, "android.permission.READ_EXTERNAL_STORAGE");
        }
        return invokeL.booleanValue;
    }

    public final boolean k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
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

    public final boolean l(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str)) == null) {
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

    public void m(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, progressButton) == null) || progressButton == null) {
            return;
        }
        this.m.remove(progressButton);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = null;
            this.m.clear();
        }
    }

    public p0 o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f12981h = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f12979f) != null) {
                i((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    f(this.f12983j, true);
                    return;
                case 17:
                    f(this.f12982i, true);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f12980g) && !StringUtils.isNull(this.k)) {
                        c.a.q0.w.c.q().h(this.k, this.f12980g, true);
                        File j2 = c.a.q0.w.c.q().j(this.f12980g);
                        if (j2 != null && j2.exists()) {
                            j2.delete();
                        }
                        if (!StringUtils.isNull(this.f12981h) && (m = c.a.q0.w.c.q().m(this.f12980g, this.f12981h)) != null && m.exists()) {
                            m.delete();
                        }
                        e();
                        DownloadData downloadData = new DownloadData(this.f12980g);
                        downloadData.setStatus(4);
                        c.a.q0.w.c.q().w(downloadData);
                    }
                    TiePlusDownloadDialog tiePlusDownloadDialog = this.l;
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

    public void p(TiePlusDownloadDialog tiePlusDownloadDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tiePlusDownloadDialog) == null) {
            this.l = tiePlusDownloadDialog;
        }
    }

    public p0 q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f12980g = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f12982i = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public p0 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.f12983j = str;
            return this;
        }
        return (p0) invokeL.objValue;
    }

    public final void u(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, activity) == null) || activity == null) {
            return;
        }
        this.n.clearRequestPermissionList();
        this.n.appendRequestPermission(this.f12979f.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.n.appendRequestPermission(this.f12979f.getPageActivity(), "android.permission.READ_EXTERNAL_STORAGE");
        this.n.startRequestPermission(activity);
    }

    public void v(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048597, this, str, str2, context, progressButton) == null) {
            boolean z = progressButton.getColorStyle() == 1;
            if (k(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(z ? R.string.immediately_open : R.string.pb_video_promotion_mount_open));
            } else if (c.a.q0.w.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(z ? R.string.immediately_install : R.string.install));
            } else if (!c.a.q0.w.c.q().t(str) && !c.a.q0.w.c.q().r(str)) {
                File m = c.a.q0.w.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.o;
                    int i2 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i2);
                    progressButton.setText(context.getString(z ? R.string.go_on_download : R.string.go_on));
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                progressButton.setText(context.getString(z ? R.string.install_app : R.string.download));
            } else {
                SharedPreferences sharedPreferences2 = this.o;
                int i3 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i3);
            }
        }
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            SharedPreferences sharedPreferences = this.o;
            if (i2 != sharedPreferences.getInt(this.f12980g + this.f12981h, -1)) {
                SharedPreferences.Editor edit = this.o.edit();
                edit.putInt(this.f12980g + this.f12981h, i2);
                edit.apply();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f12980g) || this.m.size() <= 0) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 10 && !StringUtils.isNull(this.f12981h)) {
                        for (ProgressButton progressButton : this.m) {
                            v(this.f12980g, this.f12981h, this.f12978e, progressButton);
                        }
                    } else if (this.f12980g.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status != 0) {
                            if (status != 1) {
                                if (status == 2) {
                                    TbPageContext<?> tbPageContext = this.f12979f;
                                    if (tbPageContext != null) {
                                        tbPageContext.showToast(R.string.download_error_info);
                                    }
                                } else if (status != 3) {
                                    if (status != 4) {
                                        if (status != 5) {
                                            return;
                                        }
                                        if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                            w(((Integer) downloadData.getExtra()).intValue());
                                        }
                                        for (ProgressButton progressButton2 : this.m) {
                                            progressButton2.setTag((byte) 1);
                                            progressButton2.updateProgress(0);
                                        }
                                        return;
                                    }
                                }
                                if (StringUtils.isNull(this.f12981h)) {
                                    return;
                                }
                                for (ProgressButton progressButton3 : this.m) {
                                    progressButton3.setCurProgress(-1);
                                    v(this.f12980g, this.f12981h, this.f12978e, progressButton3);
                                }
                                return;
                            }
                            int k = (int) (c.a.q0.w.c.q().k(this.f12980g) * 100.0f);
                            w(k);
                            for (ProgressButton progressButton4 : this.m) {
                                progressButton4.setTag((byte) 1);
                                progressButton4.updateProgress(k);
                            }
                            return;
                        } else if (!StringUtils.isNull(this.f12981h)) {
                            for (ProgressButton progressButton5 : this.m) {
                                progressButton5.setCurProgress(100);
                            }
                        }
                        e();
                        return;
                    }
                }
            }
        }
    }
}
