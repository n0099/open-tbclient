package c.a.p0.a.z.c;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d0.l.b;
import c.a.p0.a.e2.g.h;
import c.a.p0.a.v1.f.g0.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public class b implements c.a.p0.a.d0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9252e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f9253f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f9254g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements i.n.b<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f9255e;

        public a(a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9255e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        public void call(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                if (cursor == null || !cursor.moveToFirst()) {
                    boolean unused = b.f9252e;
                    c.a.p0.a.z0.e.a.a(cursor);
                    this.f9255e.a(null);
                    return;
                }
                this.f9255e.a(b.k(cursor));
            }
        }
    }

    /* renamed from: c.a.p0.a.z.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0607b implements i.n.f<String, Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0607b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.f
        public Cursor call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b.m() : (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.a.z.a f9256b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.a.f6466e, dVar.a.f6466e) : invokeLL.intValue;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f9257b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(135316337, "Lc/a/p0/a/z/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(135316337, "Lc/a/p0/a/z/c/b;");
                return;
            }
        }
        f9252e = c.a.p0.a.a.a;
        f9254g = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    @SuppressLint({"BDThrowableCheck"})
    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable c.a.p0.a.m0.c cVar, b.C0248b c0248b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, contentResolver, cVar, c0248b)) == null) {
            if (cVar == null || TextUtils.isEmpty(cVar.a)) {
                return false;
            }
            if (f9252e) {
                String str = "addHistory: " + cVar.f6464c + " / " + cVar.a;
            }
            if (TextUtils.equals(String.valueOf(1), cVar.f6468g)) {
                String str2 = cVar.a;
                c.a.p0.a.d0.l.c m = c.a.p0.a.d0.l.c.m(c0248b);
                m.i(1);
                h(contentResolver, str2, m.k());
            }
            Uri a2 = c.a.p0.a.z.c.a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", cVar.a);
            contentValues.put("visit_time", Long.valueOf(cVar.f6466e));
            contentValues.put("app_from", cVar.f6470i);
            contentValues.put("app_name", cVar.f6464c);
            contentValues.put("app_key", cVar.f6463b);
            contentValues.put("version_code", cVar.f6471j);
            contentValues.put("app_icon", cVar.f6465d);
            contentValues.put("frame_type", Integer.valueOf(cVar.f6467f));
            contentValues.put("app_type", cVar.f6468g);
            contentValues.put("pay_protected", Integer.valueOf(cVar.f6469h));
            contentValues.put("sync_state", (Integer) 0);
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
                if (f9252e) {
                    String str3 = "Add history: newUri - " + (insert == null ? "NULL" : insert.toString());
                }
                if (e()) {
                    String str4 = cVar.a;
                    c.a.p0.a.d0.l.c m2 = c.a.p0.a.d0.l.c.m(c0248b);
                    m2.i(2);
                    t(contentResolver, str4, m2.k());
                }
                return insert != null;
            } catch (Exception e2) {
                c.a.p0.a.x.a.f(a2.toString(), cVar.a, e2.toString());
                if (f9252e) {
                    String str5 = "encounter error while adding swan history" + e2.toString();
                    throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void d(MatrixCursor matrixCursor, int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, matrixCursor, i2, dVar) == null) {
            if (dVar instanceof c) {
                c cVar = (c) dVar;
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.f9256b.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.f9256b.f9234b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.f9256b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.f9256b.f9235c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.f9256b.f9236d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.f9256b.f9237e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.f9256b.f9238f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.f9256b.f9239g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.f9256b.f9240h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.f9256b.f9241i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.f9256b.f9242j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.f9256b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.f9256b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.f9256b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.f9256b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.f9256b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.f9256b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.f9256b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.f9256b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.f9256b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.f9256b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.f9256b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.f9256b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.f9256b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.f9256b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.f9256b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.f9256b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.f9256b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.f9256b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.f9256b.D ? 1 : 0)).add("app_from", cVar.a.f6470i).add("visit_time", Long.valueOf(cVar.a.f6466e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.f9256b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.f9256b.F);
                return;
            }
            f fVar = (f) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.a.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.f9257b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.f9257b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.f9257b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.f9257b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.f9257b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.f9257b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.f9257b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.a.f6465d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.a.f6464c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.f9257b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.f9257b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.f9257b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.f9257b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.f9257b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.f9257b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.f9257b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.f9257b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.f9257b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.f9257b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.f9257b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.a.f6470i).add("visit_time", Long.valueOf(fVar.a.f6466e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.f9257b.payProtected)).add("customer_service", Integer.valueOf(fVar.f9257b.customerService)).add("global_notice", Integer.valueOf(fVar.f9257b.globalNotice)).add("global_private", Integer.valueOf(fVar.f9257b.globalPrivate)).add("pa_number", fVar.f9257b.paNumber).add("brand", fVar.f9257b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.f9257b.quickAppKey);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f9253f != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f9253f.get() > 86400000) {
                    f9253f.set(currentTimeMillis);
                    h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                    return true;
                }
                return false;
            }
            synchronized (h.class) {
                if (f9253f == null) {
                    f9253f = new AtomicLong(h.a().getLong("key_check_delete_swan_history", 0L));
                    return e();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            AppRuntime.getAppContext().getContentResolver().delete(c.a.p0.a.z.c.a.a(), null, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(ContentResolver contentResolver, String str, String str2, String str3, String str4, boolean z, b.C0248b c0248b) {
        InterceptResult invokeCommon;
        char c2;
        int i2;
        int delete;
        boolean z2;
        c.a.p0.a.d0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{contentResolver, str, str2, str3, str4, Boolean.valueOf(z), c0248b})) == null) {
            switch (str4.hashCode()) {
                case 48:
                    if (str4.equals("0")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str4.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str4.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str4.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    i2 = 1;
                } else if (c2 == 2) {
                    i2 = 2;
                } else if (c2 == 3) {
                    i2 = 3;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    delete = contentResolver.delete(c.a.p0.a.z.c.a.a(), "app_key=? AND app_type=? AND version_code=?", new String[]{str2, String.valueOf(i2), str3});
                } else {
                    delete = contentResolver.delete(c.a.p0.a.z.c.a.a(), "app_id=?", new String[]{str});
                }
                z2 = delete <= 0;
                if (z && z2 && (d2 = c.a.p0.a.d0.f.c().d()) != null) {
                    c.a.p0.a.d0.l.c m = c.a.p0.a.d0.l.c.m(c0248b);
                    m.i(4);
                    d2.e(str, true, m.k());
                }
                if (f9252e) {
                    String str5 = "deleteHistory: " + str + " isSuccess: " + z2;
                }
                if (z2) {
                    c.a.p0.a.m0.d.j("DEL", str, System.currentTimeMillis(), str2, String.valueOf(i2), str3, null);
                }
                return z2;
            }
            i2 = 0;
            if (!TextUtils.isEmpty(str)) {
            }
            if (delete <= 0) {
            }
            if (z) {
                c.a.p0.a.d0.l.c m2 = c.a.p0.a.d0.l.c.m(c0248b);
                m2.i(4);
                d2.e(str, true, m2.k());
            }
            if (f9252e) {
            }
            if (z2) {
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static void h(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0248b c0248b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, contentResolver, str, c0248b) == null) {
            boolean z = f9252e;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String a2 = c.a.p0.a.l.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            List<String> s = s(contentResolver, str);
            if (s != null && s.size() != 0) {
                c.a.p0.a.d0.d d2 = c.a.p0.a.d0.f.c().d();
                if (d2 != null) {
                    boolean z2 = f9252e;
                    d2.g(s, false, false, c0248b);
                }
                boolean z3 = f9252e;
                contentResolver.delete(c.a.p0.a.z.c.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
                return;
            }
            boolean z4 = f9252e;
        }
    }

    @NonNull
    public static Set<String> i(@NonNull ContentResolver contentResolver) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, contentResolver)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(c.a.p0.a.z.c.a.a(), null, null, null, null);
                } catch (Exception e2) {
                    if (f9252e) {
                        e2.printStackTrace();
                    }
                    if (f9252e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f9252e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    c.a.p0.w.d.d(cursor);
                    return hashSet;
                }
                if (f9252e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                c.a.p0.w.d.d(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f9252e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                c.a.p0.w.d.d(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static void j(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, cVar) == null) || cVar == null) {
            return;
        }
        i.d.f("").y(Schedulers.io()).h(new C0607b()).k(i.l.b.a.b()).w(new a(cVar));
    }

    @NonNull
    public static JSONObject k(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cursor)) == null) {
            JSONArray jSONArray = new JSONArray();
            do {
                JSONObject jSONObject = new JSONObject();
                try {
                    String string = cursor.getString(cursor.getColumnIndex("app_id"));
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("appid", string);
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex("app_key"));
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put("appKey", string2);
                    }
                    jSONObject.put("version", cursor.getInt(cursor.getColumnIndex("version_code")));
                    int i2 = cursor.getInt(cursor.getColumnIndex("frame_type"));
                    jSONObject.put("frameType", i2);
                    int i3 = cursor.getInt(cursor.getColumnIndex("app_type"));
                    String str2 = "1";
                    if (i3 != 0) {
                        if (i3 == 1) {
                            str2 = "0";
                        } else if (i3 == 2) {
                            str2 = "2";
                        } else if (i3 == 3) {
                            str2 = "3";
                        }
                    }
                    jSONObject.put("type", str2);
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    if (i2 == 1) {
                        str = String.format(c.a.p0.a.v1.f.g0.a.f7923d, string);
                    } else {
                        str = c.a.p0.a.v1.f.g0.a.f7922c + string + "\"}";
                    }
                    jSONObject.put("scheme", str);
                    String string3 = cursor.getString(cursor.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string3)) {
                        jSONObject.put("dataStamp", string3);
                        jSONObject.put("dateStamp", string3);
                    }
                    String string4 = cursor.getString(cursor.getColumnIndex("app_icon"));
                    if (!TextUtils.isEmpty(string4)) {
                        jSONObject.put("iconUrl", string4);
                    }
                    jSONObject.put("payProtected", cursor.getInt(cursor.getColumnIndex("pay_protected")));
                    String string5 = cursor.getString(cursor.getColumnIndex("app_name"));
                    if (!TextUtils.isEmpty(string5)) {
                        jSONObject.put("title", string5);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } while (cursor.moveToNext());
            c.a.p0.a.z0.e.a.a(cursor);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (f9252e) {
                String str3 = "historyCursorToJson : " + jSONObject2.toString();
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void l(List<c.a.p0.a.m0.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        SQLiteDatabase e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e();
        e2.beginTransaction();
        try {
            try {
                for (c.a.p0.a.m0.c cVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", cVar.a);
                    contentValues.put("visit_time", Long.valueOf(cVar.f6466e));
                    contentValues.put("app_from", cVar.f6470i);
                    contentValues.put("app_name", cVar.f6464c);
                    contentValues.put("app_key", cVar.f6463b);
                    contentValues.put("version_code", cVar.f6471j);
                    contentValues.put("app_icon", cVar.f6465d);
                    contentValues.put("app_type", cVar.f6468g);
                    contentValues.put("frame_type", Integer.valueOf(cVar.f6467f));
                    contentValues.put("pay_protected", Integer.valueOf(cVar.f6469h));
                    contentValues.put("sync_state", (Integer) 1);
                    e2.insertWithOnConflict("ai_apps_history", null, contentValues, 5);
                }
                e2.setTransactionSuccessful();
            } catch (Exception e3) {
                if (f9252e) {
                    e3.printStackTrace();
                }
            }
            e2.endTransaction();
            AppRuntime.getAppContext().getContentResolver().notifyChange(c.a.p0.a.z.c.a.a(), (ContentObserver) null, false);
        } catch (Throwable th) {
            e2.endTransaction();
            throw th;
        }
    }

    public static Cursor m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? n(null, null) : (Cursor) invokeV.objValue;
    }

    public static Cursor n(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, strArr)) == null) {
            return AppRuntime.getAppContext().getContentResolver().query(c.a.p0.a.z.c.a.a(), null, str, strArr, "visit_time desc  LIMIT 200");
        }
        return (Cursor) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ec A[LOOP:3: B:50:0x01e6->B:52:0x01ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0288 A[LOOP:5: B:67:0x0282->B:69:0x0288, LOOP_END] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor o(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor query;
        List<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, str, i2)) == null) {
            HashMap hashMap = new HashMap();
            Cursor p = p(AppRuntime.getAppContext().getContentResolver(), str);
            if (p != null && p.moveToFirst()) {
                do {
                    c.a.p0.a.z.a aVar = new c.a.p0.a.z.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(p, aVar);
                    if (!TextUtils.isEmpty(aVar.a)) {
                        c cVar = new c(null);
                        cVar.f9256b = aVar;
                        c.a.p0.a.m0.c cVar2 = cVar.a;
                        cVar2.a = aVar.a;
                        cVar2.a = p.getString(p.getColumnIndex("app_from"));
                        cVar.a.f6466e = p.getLong(p.getColumnIndex("visit_time"));
                        hashMap.put(cVar.a.a, cVar);
                        if (f9252e) {
                            String str2 = "Aps&History == " + aVar.a;
                        }
                    }
                } while (p.moveToNext());
                c.a.p0.w.d.d(p);
                if (f9252e) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(c.a.p0.a.z.c.a.a(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                c.a.p0.w.d.d(query);
                if (f9252e) {
                }
                ArrayList<d> arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f9252e) {
                }
                while (r12.hasNext()) {
                }
                if (f9252e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i3 = 0;
                if (i2 > 0) {
                }
                MatrixCursor matrixCursor = new MatrixCursor(f9254g, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor;
            }
            c.a.p0.w.d.d(p);
            if (f9252e) {
                String str3 = "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录";
            }
            query = AppRuntime.getAppContext().getContentResolver().query(c.a.p0.a.z.c.a.a(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    c.a.p0.a.m0.c cVar3 = new c.a.p0.a.m0.c();
                    cVar3.a = query.getString(query.getColumnIndex("app_id"));
                    cVar3.f6470i = query.getString(query.getColumnIndex("app_from"));
                    cVar3.f6466e = query.getLong(query.getColumnIndex("visit_time"));
                    cVar3.f6464c = query.getString(query.getColumnIndex("app_name"));
                    cVar3.f6463b = query.getString(query.getColumnIndex("app_key"));
                    cVar3.f6471j = query.getString(query.getColumnIndex("version_code"));
                    cVar3.f6465d = query.getString(query.getColumnIndex("app_icon"));
                    cVar3.f6467f = query.getInt(query.getColumnIndex("frame_type"));
                    hashMap22.put(cVar3.a, cVar3);
                    if (f9252e) {
                        String str4 = "History == " + cVar3.a;
                    }
                } while (query.moveToNext());
                c.a.p0.w.d.d(query);
                if (f9252e) {
                }
                ArrayList<d> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f9252e) {
                }
                while (r12.hasNext()) {
                }
                if (f9252e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i32 = 0;
                if (i2 > 0) {
                    arrayList = arrayList.subList(0, i2);
                    if (f9252e) {
                    }
                }
                MatrixCursor matrixCursor2 = new MatrixCursor(f9254g, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor2;
            }
            c.a.p0.w.d.d(query);
            if (f9252e) {
                String str5 = "^ History 库查询到 " + hashMap22.size() + " 个历史记录";
            }
            ArrayList<d> arrayList222 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(c.a.p0.q.f.a.i().v().values())) {
                if (f9252e) {
                    String str6 = "Pms == " + pMSAppInfo.appId;
                }
                String str7 = pMSAppInfo.appName;
                if (str7 != null && str7.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                    f fVar = new f(null);
                    fVar.a = (c.a.p0.a.m0.c) hashMap22.get(pMSAppInfo.appId);
                    fVar.f9257b = pMSAppInfo;
                    arrayList222.add(fVar);
                }
            }
            if (f9252e) {
                String str8 = "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录";
            }
            for (d dVar : arrayList222) {
                hashMap.put(dVar.a.a, dVar);
            }
            if (f9252e) {
                String str9 = "合并后有 " + hashMap.size() + " 个历史记录";
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    String str10 = "Migrate == " + ((d) it.next()).a.a;
                }
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i322 = 0;
            if (i2 > 0 && i2 < arrayList.size()) {
                arrayList = arrayList.subList(0, i2);
                if (f9252e) {
                    String str11 = "Limit限制 " + i2 + " 条";
                }
            }
            MatrixCursor matrixCursor22 = new MatrixCursor(f9254g, 50);
            for (d dVar2 : arrayList) {
                d(matrixCursor22, i322, dVar2);
                i322++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeLI.objValue;
    }

    @Nullable
    public static Cursor p(@NonNull ContentResolver contentResolver, @NonNull String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, contentResolver, str)) == null) {
            try {
                cursor = contentResolver.query(c.a.p0.a.z.c.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
            } catch (Exception e2) {
                if (f9252e) {
                    e2.printStackTrace();
                }
                cursor = null;
            }
            if (f9252e && cursor != null) {
                String str2 = "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount();
            }
            return cursor;
        }
        return (Cursor) invokeLL.objValue;
    }

    public static Set<String> q(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, sQLiteDatabase)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("ai_apps_history", null, null, null, null, null, null);
                } catch (Exception e2) {
                    if (f9252e) {
                        e2.printStackTrace();
                    }
                    if (f9252e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f9252e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    c.a.p0.a.z0.e.a.a(cursor);
                    return hashSet;
                }
                if (f9252e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                c.a.p0.a.z0.e.a.a(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f9252e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                c.a.p0.a.z0.e.a.a(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static List<c.a.p0.a.m0.c> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
            Cursor query = contentResolver.query(c.a.p0.a.z.c.a.a(), null, "sync_state=?", new String[]{String.valueOf(0)}, "visit_time asc  LIMIT 200");
            if (query != null && query.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    c.a.p0.a.m0.c cVar = new c.a.p0.a.m0.c();
                    cVar.a = query.getString(query.getColumnIndex("app_id"));
                    cVar.f6466e = query.getLong(query.getColumnIndex("visit_time"));
                    arrayList.add(cVar);
                } while (query.moveToNext());
                c.a.p0.a.z0.e.a.a(query);
                return arrayList;
            }
            c.a.p0.a.z0.e.a.a(query);
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0089 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    @Nullable
    public static List<String> s(@NonNull ContentResolver contentResolver, @Nullable String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65555, null, contentResolver, str)) != null) {
            return (List) invokeLL.objValue;
        }
        ?? r1 = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String a2 = c.a.p0.a.l.a.a(str);
                if (TextUtils.isEmpty(a2)) {
                    c.a.p0.w.d.d(null);
                    return null;
                }
                cursor = contentResolver.query(c.a.p0.a.z.c.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("app_id"));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } while (cursor.moveToNext());
                            c.a.p0.w.d.d(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f9252e) {
                            e.printStackTrace();
                        }
                        c.a.p0.w.d.d(cursor);
                        return null;
                    }
                }
                c.a.p0.w.d.d(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                c.a.p0.w.d.d(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = contentResolver;
        }
    }

    @WorkerThread
    public static void t(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0248b c0248b) {
        int i2;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, contentResolver, str, c0248b) == null) {
            Cursor cursor = null;
            if (str == null) {
                str = "";
            }
            try {
                try {
                    query = contentResolver.query(c.a.p0.a.z.c.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ArrayList arrayList = new ArrayList();
                if (query != null) {
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("app_id"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                if (f9252e) {
                    String str2 = "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str;
                }
                if (arrayList.isEmpty()) {
                    c.a.p0.w.d.d(query);
                    return;
                }
                c.a.p0.a.d0.d d2 = c.a.p0.a.d0.f.c().d();
                if (d2 != null) {
                    d2.f(arrayList, false, c0248b);
                }
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (i2 = 0; i2 < size; i2++) {
                    sb.append(ExtendedMessageFormat.QUOTE);
                    sb.append((String) arrayList.get(i2));
                    sb.append(ExtendedMessageFormat.QUOTE);
                    if (i2 < size - 1) {
                        sb.append(",");
                    }
                }
                String str3 = "app_id in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
                int delete = contentResolver.delete(c.a.p0.a.z.c.a.a(), str3, null);
                if (f9252e) {
                    String str4 = "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str3;
                }
                c.a.p0.w.d.d(query);
            } catch (Exception unused2) {
                cursor = query;
                boolean z = f9252e;
                c.a.p0.w.d.d(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                c.a.p0.w.d.d(cursor);
                throw th;
            }
        }
    }

    public static void u(ContentResolver contentResolver, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65557, null, contentResolver, str, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i2));
            contentResolver.update(c.a.p0.a.z.c.a.a(), contentValues, "app_id=?", new String[]{str});
        }
    }

    public static void v(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : q(sQLiteDatabase)) {
                    PMSAppInfo u = c.a.p0.q.f.a.i().u(str);
                    if (u != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_name", u.appName);
                        contentValues.put("app_icon", u.iconUrl);
                        contentValues.put("frame_type", Integer.valueOf(u.appCategory));
                        contentValues.put("app_type", String.valueOf(u.type));
                        contentValues.put("sync_state", (Integer) 0);
                        if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                            boolean z = f9252e;
                            return;
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.m0.c a;

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
                    return;
                }
            }
            this.a = new c.a.p0.a.m0.c();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
