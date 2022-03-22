package c.a.p.f.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.p.f.a;
import c.a.p.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.taskmanager.DatabaseMng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c.a.p.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C0891a f11666f;

    /* renamed from: g  reason: collision with root package name */
    public C0882b f11667g;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(String str) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                JSONObject jSONObject = new JSONObject(new String(new c.a.p.h.b.b().a(Base64.decode(str, 3))));
                a aVar = new a();
                aVar.e(jSONObject.getString("id"));
                aVar.c(jSONObject.getInt("d_form_ver"));
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public String d() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                c.a.p.h.b.b bVar = new c.a.p.h.b.b();
                jSONObject.put("id", this.a);
                jSONObject.put("d_form_ver", 1);
                return Base64.encodeToString(bVar.b(jSONObject.toString().getBytes()), 3);
            }
            return (String) invokeV.objValue;
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a = str;
            }
        }
    }

    /* renamed from: c.a.p.f.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0882b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f11668b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11669c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f11670d;

        public C0882b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11670d = bVar;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11668b : (String) invokeV.objValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.a == j) {
                return;
            }
            this.a = j;
            this.f11669c = true;
        }

        public final boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.a = jSONObject.getLong("pub_lst_ts");
                        this.f11668b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f11669c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str.equals(this.f11668b)) {
                return;
            }
            this.f11668b = str;
            this.f11669c = true;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f11669c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.f11668b);
                        jSONObject.put("pub_lst_ts", this.a);
                        jSONObject.put("d_form_ver", 1);
                        this.f11670d.f11666f.i("pub.dat", jSONObject.toString(), true);
                        this.f11669c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c(this.f11670d.f11666f.g("pub.dat", true)) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f11671d;

        /* renamed from: e  reason: collision with root package name */
        public long f11672e;

        /* renamed from: f  reason: collision with root package name */
        public long f11673f;

        /* renamed from: g  reason: collision with root package name */
        public String f11674g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, String str) {
            super(bVar.f11666f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C0891a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.p.f.a.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f11671d = jSONObject.getString("pkg");
                this.f11672e = jSONObject.getLong("last_fe_ts");
                this.f11674g = jSONObject.getString("id");
                this.f11673f = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // c.a.p.f.a.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f11671d);
                jSONObject.put("last_fe_ts", this.f11672e);
                jSONObject.put("id", this.f11674g);
                jSONObject.put("tar_pkg_lst_up_ts", this.f11673f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11674g : (String) invokeV.objValue;
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.f11672e != j) {
                    this.f11672e = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str.equals(this.f11674g)) {
                    return false;
                }
                this.f11674g = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11673f : invokeV.longValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f11673f != j) {
                    this.f11673f = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str.equals(this.f11671d)) {
                    return false;
                }
                this.f11671d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11671d : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("esc-ms", 7500000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11667g = new C0882b(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF, IF] complete} */
    @Override // c.a.p.f.a
    public a.g b(String str, a.f fVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        c cVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                i = -101;
            } else {
                Context context = this.a.a;
                Cursor cursor = null;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    i = -1;
                } else {
                    if (fVar.a) {
                        cVar = new c(this, str);
                        cVar.d();
                        if (str.equals(cVar.l()) && packageInfo.lastUpdateTime == cVar.i()) {
                            String f2 = cVar.f();
                            if (!TextUtils.isEmpty(f2)) {
                                return a.g.f(f2);
                            }
                        }
                    } else {
                        cVar = null;
                    }
                    if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                        try {
                            try {
                                cursor = context.getContentResolver().query(MediaStore.setIncludePending(MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new String[]{"_id", "description"}, "owner_package_name = ? AND relative_path = ?", new String[]{str, "Pictures/" + str + "/helios/"}, DatabaseMng.DEFAULT_SORT_ORDER);
                                if (cursor != null) {
                                    while (cursor.moveToNext()) {
                                        String string = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                                        if (string != null) {
                                            try {
                                                String b2 = a.a(string).b();
                                                if (!TextUtils.isEmpty(b2)) {
                                                    if (fVar.a && cVar != null) {
                                                        cVar.h(b2);
                                                        cVar.g(System.currentTimeMillis());
                                                        cVar.j(packageInfo.lastUpdateTime);
                                                        cVar.k(str);
                                                    }
                                                    a.g f3 = a.g.f(b2);
                                                    c.a.p.h.c.a.c.a(cursor);
                                                    if (fVar.a && cVar != null) {
                                                        cVar.b();
                                                    }
                                                    return f3;
                                                }
                                                continue;
                                            } catch (Exception unused2) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                c.a.p.h.c.a.c.a(cursor);
                                if (fVar.a && cVar != null) {
                                    cVar.b();
                                }
                                i = -2;
                            } catch (Exception e2) {
                                a.g d2 = a.g.d(e2);
                                c.a.p.h.c.a.c.a(cursor);
                                if (fVar.a && cVar != null) {
                                    cVar.b();
                                }
                                return d2;
                            }
                        } catch (Throwable th) {
                            c.a.p.h.c.a.c.a(cursor);
                            if (fVar.a && cVar != null) {
                                cVar.b();
                            }
                            throw th;
                        }
                    } else {
                        i = -100;
                    }
                }
            }
            return a.g.b(i);
        }
        return (a.g) invokeLL.objValue;
    }

    @Override // c.a.p.f.a
    public void e(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f11666f = this.f11645b.f("esc-ms");
        }
    }

    @Override // c.a.p.f.a
    public a.e f(a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                return a.e.a();
            }
            this.f11667g.f();
            try {
                return i(dVar);
            } finally {
                this.f11667g.e();
            }
        }
        return (a.e) invokeL.objValue;
    }

    public final Uri h(String str, ContentResolver contentResolver, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048579, this, str, contentResolver, str2)) != null) {
            return (Uri) invokeLLL.objValue;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        int i = 0;
        contentValues.put("relative_path", String.format("Pictures/%s/helios", str));
        contentValues.put("description", str2);
        while (true) {
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    throw new IllegalStateException("file path maybe duplicated");
                    break;
                }
                return insert;
            } catch (IllegalStateException e2) {
                i++;
                if (i > 5) {
                    throw new IllegalStateException("insert file retry count exceed", e2);
                }
                contentValues.put("_display_name", "helios-icon-" + i + ".JPG");
            }
        }
    }

    public final a.e i(a.d dVar) {
        InterceptResult invokeL;
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            Context context = this.a.a;
            String packageName = context.getPackageName();
            ContentResolver contentResolver = this.a.a.getContentResolver();
            String c2 = this.a.f11649c.a("aid").c();
            String a2 = this.f11667g.a();
            if (a2 == null || !TextUtils.equals(a2, c2)) {
                if (Build.VERSION.SDK_INT < 29) {
                    return a.e.a();
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = null;
                try {
                    try {
                        a aVar = new a();
                        aVar.e(c2);
                        autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentResolver.openFileDescriptor(h(packageName, contentResolver, aVar.d()), "w", null));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    j(autoCloseOutputStream, context);
                    this.f11667g.d(c2);
                    this.f11667g.b(System.currentTimeMillis());
                    a.e d2 = a.e.d();
                    c.a.p.h.c.a.c.b(autoCloseOutputStream);
                    return d2;
                } catch (Exception e3) {
                    e = e3;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    a.e c3 = a.e.c(e);
                    c.a.p.h.c.a.c.b(autoCloseOutputStream2);
                    return c3;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    c.a.p.h.c.a.c.b(autoCloseOutputStream2);
                    throw th;
                }
            }
            return a.e.d();
        }
        return (a.e) invokeL.objValue;
    }

    public final void j(OutputStream outputStream, Context context) {
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, outputStream, context) == null) {
            Drawable loadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
            int intrinsicWidth = loadIcon.getIntrinsicWidth();
            int intrinsicHeight = loadIcon.getIntrinsicHeight();
            Matrix matrix = new Matrix();
            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            if (intrinsicWidth > 96 || intrinsicHeight > 96) {
                float f2 = 96;
                min = Math.min(f2 / intrinsicWidth, f2 / intrinsicHeight);
            } else {
                min = 1.0f;
            }
            float f3 = 96;
            matrix.setScale(min, min);
            matrix.postTranslate(Math.round((f3 - (intrinsicWidth * min)) * 0.5f), Math.round((f3 - (intrinsicHeight * min)) * 0.5f));
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(matrix);
            loadIcon.setBounds(0, 0, loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight());
            loadIcon.draw(canvas);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            createBitmap.recycle();
        }
    }
}
