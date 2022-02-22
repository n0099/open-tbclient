package c.a.s0.a.f2.f;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.h2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.a.z2.g1.c<c.a.s0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6417f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6418g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f6419h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6420i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ x f6421j;

        /* renamed from: c.a.s0.a.f2.f.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0358a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f6422e;

            public RunnableC0358a(a aVar) {
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
                this.f6422e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f6422e;
                    aVar.f6421j.p(aVar.f6418g, aVar.f6419h, aVar.f6420i, aVar.f6416e, aVar.f6417f);
                }
            }
        }

        public a(x xVar, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6421j = xVar;
            this.f6416e = callbackHandler;
            this.f6417f = str;
            this.f6418g = context;
            this.f6419h = file;
            this.f6420i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.s0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.s0.a.h2.c.d.h(iVar)) {
                    c.a.s0.a.e0.d.i("SaveImage", "Permission denied");
                    c.a.s0.a.h2.c.d.q(iVar, this.f6416e, this.f6417f);
                    return;
                }
                c.a.s0.a.z2.q.k(new RunnableC0358a(this), "SaveImageAction");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f6424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6426h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6427i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ x f6428j;

        public b(x xVar, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6428j = xVar;
            this.f6423e = context;
            this.f6424f = file;
            this.f6425g = callbackHandler;
            this.f6426h = str;
            this.f6427i = unitedSchemeEntity;
        }

        @Override // c.a.s0.a.v1.f
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                boolean q = c.a.s0.a.z2.d.a() ? this.f6428j.q(this.f6423e, this.f6424f) : this.f6428j.r(this.f6423e, this.f6424f);
                int i2 = q ? 0 : 1001;
                if (q) {
                    str2 = "save success";
                } else {
                    str2 = "can not save to album : " + this.f6424f;
                }
                c.a.s0.a.e0.d.i("SaveImage", str2);
                this.f6425g.handleSchemeDispatchCallback(this.f6426h, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
            }
        }

        @Override // c.a.s0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                c.a.s0.a.e0.d.i("SaveImage", str + "");
                UnitedSchemeUtility.safeCallback(this.f6425g, this.f6427i, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6426h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(c.a.s0.a.f2.e eVar) {
        super(eVar, "/swanAPI/saveImageToPhotosAlbum");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String o(Uri uri, Context context) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, context)) == null) {
            Cursor cursor2 = null;
            r7 = null;
            r7 = null;
            String str = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                            cursor.moveToFirst();
                            str = cursor.getString(columnIndexOrThrow);
                        } catch (SQLException e2) {
                            e = e2;
                            if (z.f6443b) {
                                e.printStackTrace();
                            }
                            c.a.s0.w.d.d(cursor);
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        c.a.s0.w.d.d(cursor2);
                        throw th;
                    }
                }
            } catch (SQLException e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.s0.w.d.d(cursor2);
                throw th;
            }
            c.a.s0.w.d.d(cursor);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.s0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.s0.a.e0.d.c("SaveImage", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                c.a.s0.a.e0.d.c("SaveImage", "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            }
            String optString = a2.optString("filePath");
            try {
                File n = n(eVar, optString, URI.create(optString));
                if (n != null && n.exists() && n.isFile()) {
                    String optString2 = a2.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        c.a.s0.a.e0.d.c("SaveImage", "empty cb");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                        return false;
                    }
                    eVar.d0().g(context, "mapp_images", new a(this, callbackHandler, optString2, context, n, unitedSchemeEntity));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                c.a.s0.a.e0.d.c("SaveImage", "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
                return false;
            } catch (Exception e2) {
                if (z.f6443b) {
                    e2.printStackTrace();
                }
                c.a.s0.a.e0.d.c("SaveImage", "Illegal file_path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            String t = c.a.s0.w.d.t(file.getPath());
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(t)) {
                return valueOf;
            }
            return valueOf + "." + t;
        }
        return (String) invokeL.objValue;
    }

    public final File n(c.a.s0.a.d2.e eVar, String str, URI uri) {
        InterceptResult invokeLLL;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, uri)) == null) {
            c.a.s0.a.o2.f.d G = c.a.s0.a.g1.f.U().G();
            if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
                e2 = G.i(str);
            } else if (c.a.s0.a.x1.a.a.B(eVar.X())) {
                e2 = G.m(str);
            } else {
                e2 = G.e(str);
            }
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            return new File(e2);
        }
        return (File) invokeLLL.objValue;
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            c.a.s0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final boolean q(Context context, File file) {
        String str;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, file)) == null) {
            try {
                str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
            } catch (FileNotFoundException e2) {
                if (z.f6443b) {
                    e2.printStackTrace();
                }
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                String o = o(Uri.parse(str), context);
                if (!TextUtils.isEmpty(o)) {
                    c.a.s0.a.z2.u.r(context, o);
                }
            }
            if (z.f6443b) {
                String str2 = "saveToAlbum : file = " + file;
                String str3 = "saveToAlbum : image = " + str;
            }
            c.a.s0.a.e0.d.i("SaveImage", "save success");
            return !TextUtils.isEmpty(str);
        }
        return invokeLL.booleanValue;
    }

    public final boolean r(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, file)) == null) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
            if (decodeFile == null) {
                return false;
            }
            decodeFile.recycle();
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            c.a.s0.w.d.l(externalStoragePublicDirectory);
            File file2 = new File(externalStoragePublicDirectory, m(file));
            if (c.a.s0.w.d.f(file, file2) != 0) {
                c.a.s0.a.z2.u.r(context, file2.getAbsolutePath());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
