package c.a.r0.w2.a;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.s3.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements QRCodeView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.r0.w2.a.a f26535a;

    /* renamed from: b  reason: collision with root package name */
    public final TbPageContext f26536b;

    /* renamed from: c  reason: collision with root package name */
    public f f26537c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s3.c f26538d;

    /* renamed from: e  reason: collision with root package name */
    public e f26539e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26540f;

    /* loaded from: classes4.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26542b;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26542b = bVar;
            this.f26541a = str;
        }

        @Override // c.a.r0.s3.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26542b.f26535a.viewHideLoading();
                this.f26542b.f26535a.showRiskForbidDialog();
            }
        }

        @Override // c.a.r0.s3.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26542b.f26535a.viewHideLoading();
                this.f26542b.f26535a.showJumpExternalDialog(this.f26541a);
            }
        }

        @Override // c.a.r0.s3.c.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f26542b.f26535a.viewHideLoading();
                this.f26542b.j(this.f26541a);
            }
        }

        @Override // c.a.r0.s3.c.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f26542b.f26535a.viewHideLoading();
                this.f26542b.f26535a.setErrorView();
            }
        }
    }

    /* renamed from: c.a.r0.w2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1243b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26543a;

        public C1243b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26543a = bVar;
        }

        @Override // c.a.r0.w2.a.b.e.a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            c.a.q0.s.d0.b.j().x("key_gallery_last_image_path", str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f26543a.f26535a.showGalleryLastImageTip(str, str2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f26544a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f26545b;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26545b = bVar;
            this.f26544a = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(this.f26544a, "UTF-8")));
                    this.f26545b.f26536b.getPageActivity().finish();
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26546a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26546a = bVar;
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return null;
                }
                String postNetData = new NetWork(str).postNetData();
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                try {
                    return new JSONObject(postNetData).optString("data");
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((d) str);
                this.f26546a.p(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26547a;

        /* renamed from: b  reason: collision with root package name */
        public a f26548b;

        /* loaded from: classes4.dex */
        public interface a {
            void a(String str, String str2);
        }

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26548b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0) {
                    return null;
                }
                String str = strArr[0];
                this.f26547a = str;
                return c.a.r0.w2.b.b.a.c(str);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((e) str);
                a aVar = this.f26548b;
                if (aVar != null) {
                    aVar.a(this.f26547a, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<String, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26549a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26549a = bVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                this.f26549a.f26535a.viewShowLoading();
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr == null || strArr.length <= 0) {
                    return null;
                }
                return c.a.r0.w2.b.b.a.c(strArr[0]);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((f) str);
                this.f26549a.f26535a.viewHideLoading();
                this.f26549a.b(str);
            }
        }
    }

    public b(c.a.r0.w2.a.a aVar, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26535a = aVar;
        this.f26536b = tbPageContext;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l.L(this.f26536b.getPageActivity(), R.string.disallow_camera_permission);
            this.f26536b.getPageActivity().finish();
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.f26535a.viewHideLoading();
                this.f26535a.setErrorView();
            } else if (this.f26540f) {
                Intent intent = new Intent();
                intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
                this.f26536b.getPageActivity().setResult(-1, intent);
                this.f26536b.getPageActivity().finish();
            } else if (k(str)) {
                this.f26535a.viewHideLoading();
            } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
                this.f26535a.viewHideLoading();
                i(str);
            } else if (l(str)) {
                this.f26535a.viewHideLoading();
                this.f26536b.getPageActivity().finish();
            } else if (!StringHelper.isNetworkUrl(str)) {
                this.f26535a.viewHideLoading();
                this.f26535a.setErrorView();
            } else {
                m(str);
            }
        }
    }

    public final String f(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentResolver)) == null) {
            Cursor cursor2 = null;
            if (contentResolver == null) {
                return null;
            }
            try {
                cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", "_data", "_size", "bucket_display_name", "date_modified"}, null, null, null);
            } catch (Exception unused) {
                str = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                try {
                    cursor.moveToLast();
                    str = cursor.getString(cursor.getColumnIndex("_data"));
                    try {
                    } catch (Exception unused2) {
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return str;
                    }
                } catch (Exception unused3) {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } else if (!new File(str).exists()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } else {
                    cursor.close();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public void g() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.f26536b) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || (this.f26536b.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && this.f26536b.getPageActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {
            String f2 = f(this.f26536b.getPageActivity().getContentResolver());
            if (TextUtils.isEmpty(f2) || f2.endsWith(".gif") || f2.endsWith(".GIF") || f2.equals(c.a.q0.s.d0.b.j().p("key_gallery_last_image_path", null))) {
                return;
            }
            e eVar = this.f26539e;
            if (eVar != null) {
                eVar.cancel();
            }
            e eVar2 = new e(new C1243b(this));
            this.f26539e = eVar2;
            eVar2.execute(f2);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.s3.c cVar = this.f26538d;
            if (cVar != null && !cVar.isCancelled()) {
                this.f26538d.cancel();
            }
            f fVar = this.f26537c;
            if (fVar != null) {
                fVar.cancel();
                this.f26537c = null;
            }
            e eVar = this.f26539e;
            if (eVar != null) {
                eVar.cancel();
                this.f26539e = null;
            }
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            CookieSyncManager.createInstance(this.f26536b.getPageActivity());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ";");
            cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
            CookieSyncManager.getInstance().sync();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f26536b.getPageActivity(), null, str, false)));
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            UrlManager.getInstance().dealOneLink(this.f26536b, new String[]{str});
            this.f26536b.getPageActivity().finish();
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (StringUtils.isNULL(str)) {
                return false;
            }
            if (str.startsWith("tiebaclient:")) {
                p(str);
                return true;
            } else if (str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") || str.contains("mappconsole/api/packagescheme")) {
                new d(this, null).execute(str);
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
            return runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!l.D()) {
                this.f26535a.viewHideLoading();
                l.M(this.f26536b.getPageActivity(), this.f26536b.getResources().getString(R.string.network_not_available));
                return;
            }
            c.a.r0.s3.c cVar = this.f26538d;
            if (cVar != null && !cVar.isCancelled()) {
                this.f26538d.cancel();
            }
            c.a.r0.s3.c cVar2 = new c.a.r0.s3.c(str, new a(this, str));
            this.f26538d = cVar2;
            cVar2.setPriority(3);
            this.f26538d.execute(new String[0]);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f26535a.viewShowLoading();
        f fVar = this.f26537c;
        if (fVar != null) {
            fVar.cancel();
        }
        f fVar2 = new f(this, null);
        this.f26537c = fVar2;
        fVar2.execute(str);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f26540f = z;
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                l.L(this.f26536b.getPageActivity(), R.string.ai_apps_not_support);
                return;
            }
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f26536b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this, str));
            permissionJudgePolicy.startRequestPermission(this.f26536b.getPageActivity());
        }
    }
}
