package c.a.p0.a.i1.g.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.io.PathUtils;
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
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.i1.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0269a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6853g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f6854h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6855i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f6856j;

        public C0269a(a aVar, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6856j = aVar;
            this.f6851e = callbackHandler;
            this.f6852f = str;
            this.f6853g = context;
            this.f6854h = file;
            this.f6855i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f6856j.u(this.f6853g, this.f6854h, this.f6855i, this.f6851e, this.f6852f);
                } else {
                    c.a.p0.a.e2.c.d.p(iVar, this.f6851e, this.f6852f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f6858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6860d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6862f;

        public b(a aVar, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6862f = aVar;
            this.f6857a = context;
            this.f6858b = file;
            this.f6859c = callbackHandler;
            this.f6860d = str;
            this.f6861e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4766b) {
                    String str2 = str + "";
                }
                this.f6862f.x(this.f6857a, this.f6858b, this.f6859c, this.f6860d);
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6859c, this.f6861e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6860d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements i.n.b<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6865g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6866h;

        public c(a aVar, CallbackHandler callbackHandler, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6866h = aVar;
            this.f6863e = callbackHandler;
            this.f6864f = str;
            this.f6865g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                if (file == null) {
                    this.f6863e.handleSchemeDispatchCallback(this.f6864f, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                    return;
                }
                Uri fromFile = Uri.fromFile(file);
                this.f6866h.w(this.f6865g, file.getPath(), -1L);
                this.f6865g.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                if (a0.f4766b) {
                    String str = "saveToAlbum : file = " + file;
                }
                this.f6863e.handleSchemeDispatchCallback(this.f6864f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements i.n.f<File, File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6868f;

        public d(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6868f = aVar;
            this.f6867e = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        /* renamed from: a */
        public File call(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String x = c.a.p0.a.k2.b.x(c.a.p0.a.a2.e.V());
                if (TextUtils.isEmpty(x) || !file.getPath().startsWith(x)) {
                    return null;
                }
                return this.f6868f.q(this.f6867e, file);
            }
            return (File) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/saveVideoToPhotosAlbum");
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

    public static File t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
            if (file.exists()) {
                String str = "video";
                File file2 = new File(file, (new File(file, "Video").exists() || !new File(file, "video").exists()) ? "Video" : "Video");
                if ((file2.exists() || file2.mkdirs()) && file2.canWrite()) {
                    return file2;
                }
            }
            File file3 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + FileUtils.SEARCHBOX_FOLDER + File.separator + "Video");
            if (file3.exists() || file3.mkdirs()) {
                return file3;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file4 = new File(externalFilesDir.getPath() + File.separator + "Video");
                if (file4.exists() || file4.mkdirs()) {
                    return file4;
                }
            }
            File file5 = new File(context.getFilesDir().getPath() + File.separator + "Video");
            if (file5.exists() || file5.mkdirs()) {
                return file5;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.d0()) {
                boolean z = a0.f4766b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                    return false;
                }
                String optString = a2.optString("filePath");
                try {
                    File file = null;
                    if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                        String M = c.a.p0.a.k2.b.M(optString, eVar.f4558f);
                        if (!TextUtils.isEmpty(M)) {
                            file = new File(M);
                        }
                    } else {
                        String L = c.a.p0.a.k2.b.L(optString, eVar, eVar.Z());
                        if (!TextUtils.isEmpty(L)) {
                            file = new File(L);
                        }
                    }
                    if (file != null && file.exists() && file.isFile()) {
                        String optString2 = a2.optString("cb");
                        if (TextUtils.isEmpty(optString2)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                            return false;
                        }
                        eVar.T().g(context, "mapp_images", new C0269a(this, callbackHandler, optString2, context, file, unitedSchemeEntity));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                    return false;
                } catch (Exception e2) {
                    if (a0.f4766b) {
                        e2.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public final File q(Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, file)) == null) {
            File t = t(context);
            if (t == null) {
                return null;
            }
            File file2 = new File(t, file.getName());
            if (c.a.p0.t.d.f(file, file2) > 0) {
                return file2;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final long r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? j2 <= 0 ? System.currentTimeMillis() : j2 : invokeJ.longValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String lowerCase = str.toLowerCase();
            return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? "video/mp4" : "video/3gp";
        }
        return (String) invokeL.objValue;
    }

    public final void u(@NonNull Context context, @NonNull File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            c.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final ContentValues v(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
            ContentValues contentValues = new ContentValues();
            File file = new File(str);
            long r = r(j2);
            contentValues.put("title", file.getName());
            contentValues.put("_display_name", file.getName());
            contentValues.put("date_modified", Long.valueOf(r));
            contentValues.put("date_added", Long.valueOf(r));
            contentValues.put("_data", file.getAbsolutePath());
            contentValues.put("_size", Long.valueOf(file.length()));
            return contentValues;
        }
        return (ContentValues) invokeLJ.objValue;
    }

    public final void w(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Long.valueOf(j2)}) == null) && p(str)) {
            long r = r(j2);
            ContentValues v = v(str, r);
            v.put("datetaken", Long.valueOf(r));
            v.put("mime_type", s(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v);
        }
    }

    public final void x(@NonNull Context context, @NonNull File file, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, file, callbackHandler, str) == null) {
            if (file == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
                return;
            }
            i.d.i(file).k(new d(this, context)).D(Schedulers.io()).o(i.l.b.a.b()).B(new c(this, callbackHandler, str, context));
        }
    }
}
