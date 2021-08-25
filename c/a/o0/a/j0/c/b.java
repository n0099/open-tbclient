package c.a.o0.a.j0.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c2.f.h0.a;
import c.a.o0.a.k;
import c.a.o0.a.k2.g.h;
import c.a.o0.a.n0.l.b;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.facebook.common.internal.Sets;
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
public class b implements c.a.o0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6900e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f6901f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f6902g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f6903h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements i.n.b<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f6904e;

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
            this.f6904e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                if (cursor == null || !cursor.moveToFirst()) {
                    boolean unused = b.f6900e;
                    c.a.o0.a.i1.e.a.a(cursor);
                    this.f6904e.a(null);
                    return;
                }
                this.f6904e.a(b.j(cursor));
            }
        }
    }

    /* renamed from: c.a.o0.a.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0271b implements i.n.f<String, Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0271b() {
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
        /* renamed from: a */
        public Cursor call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b.l() : (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public c.a.o0.a.j0.a f6905b;

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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.f6906a.f9424e, dVar.f6906a.f9424e) : invokeLL.intValue;
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
        public PMSAppInfo f6907b;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1562293128, "Lc/a/o0/a/j0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1562293128, "Lc/a/o0/a/j0/c/b;");
                return;
            }
        }
        f6900e = k.f7049a;
        f6901f = Sets.newHashSet();
        f6903h = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable c.a.o0.a.w0.b bVar, b.C0313b c0313b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, contentResolver, bVar, c0313b)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f9420a)) {
                return false;
            }
            if (f6900e) {
                String str = "addHistory: " + bVar.f9422c + " / " + bVar.f9420a;
            }
            if (k(bVar.f9420a)) {
                boolean z = f6900e;
                return false;
            }
            if (TextUtils.equals(String.valueOf(1), bVar.f9426g)) {
                String str2 = bVar.f9420a;
                c.a.o0.a.n0.l.c m = c.a.o0.a.n0.l.c.m(c0313b);
                m.i(1);
                g(contentResolver, str2, m.k());
            }
            Uri a2 = c.a.o0.a.j0.c.a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", bVar.f9420a);
            contentValues.put("visit_time", Long.valueOf(bVar.f9424e));
            contentValues.put("app_from", bVar.f9428i);
            contentValues.put("app_name", bVar.f9422c);
            contentValues.put("app_key", bVar.f9421b);
            contentValues.put("version_code", bVar.f9429j);
            contentValues.put("app_icon", bVar.f9423d);
            contentValues.put("frame_type", Integer.valueOf(bVar.f9425f));
            contentValues.put("app_type", bVar.f9426g);
            contentValues.put("pay_protected", Integer.valueOf(bVar.f9427h));
            contentValues.put("sync_state", (Integer) 0);
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
                if (f6900e) {
                    String str3 = "Add history: newUri - " + (insert == null ? "NULL" : insert.toString());
                }
                if (e()) {
                    String str4 = bVar.f9420a;
                    c.a.o0.a.n0.l.c m2 = c.a.o0.a.n0.l.c.m(c0313b);
                    m2.i(2);
                    r(contentResolver, str4, m2.k());
                }
                return insert != null;
            } catch (Exception e2) {
                c.a.o0.a.h0.a.f(a2.toString(), bVar.f9420a, e2.toString());
                if (f6900e) {
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
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.f6905b.f6875a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.f6905b.f6876b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.f6905b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.f6905b.f6877c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.f6905b.f6878d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.f6905b.f6879e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.f6905b.f6880f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.f6905b.f6881g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.f6905b.f6882h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.f6905b.f6883i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.f6905b.f6884j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.f6905b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.f6905b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.f6905b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.f6905b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.f6905b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.f6905b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.f6905b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.f6905b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.f6905b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.f6905b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.f6905b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.f6905b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.f6905b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.f6905b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.f6905b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.f6905b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.f6905b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.f6905b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.f6905b.D ? 1 : 0)).add("app_from", cVar.f6906a.f9428i).add("visit_time", Long.valueOf(cVar.f6906a.f9424e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.f6905b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.f6905b.F);
                return;
            }
            f fVar = (f) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.f6906a.f9420a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.f6907b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.f6907b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.f6907b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.f6907b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.f6907b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.f6907b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.f6907b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.f6906a.f9423d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.f6906a.f9422c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.f6907b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.f6907b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.f6907b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.f6907b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.f6907b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.f6907b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.f6907b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.f6907b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.f6907b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.f6907b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.f6907b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.f6906a.f9428i).add("visit_time", Long.valueOf(fVar.f6906a.f9424e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.f6907b.payProtected)).add("customer_service", Integer.valueOf(fVar.f6907b.customerService)).add("global_notice", Integer.valueOf(fVar.f6907b.globalNotice)).add("global_private", Integer.valueOf(fVar.f6907b.globalPrivate)).add("pa_number", fVar.f6907b.paNumber).add("brand", fVar.f6907b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.f6907b.quickAppKey);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f6902g != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f6902g.get() > 86400000) {
                    f6902g.set(currentTimeMillis);
                    h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                    return true;
                }
                return false;
            }
            synchronized (h.class) {
                if (f6902g == null) {
                    f6902g = new AtomicLong(h.a().getLong("key_check_delete_swan_history", 0L));
                    return e();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean f(ContentResolver contentResolver, String str, boolean z, b.C0313b c0313b) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        c.a.o0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{contentResolver, str, Boolean.valueOf(z), c0313b})) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Cursor query = contentResolver.query(c.a.o0.a.j0.c.a.a(), null, "app_id=?", new String[]{str}, null);
            String str4 = "";
            if (query == null || !query.moveToFirst()) {
                str2 = "";
                str3 = str2;
            } else {
                int columnIndex = query.getColumnIndex("app_key");
                int columnIndex2 = query.getColumnIndex("version_code");
                int columnIndex3 = query.getColumnIndex("app_type");
                str4 = query.getString(columnIndex);
                String string = query.getString(columnIndex2);
                String string2 = query.getString(columnIndex3);
                str3 = string;
                str2 = string2;
            }
            c.a.o0.t.d.d(query);
            boolean z2 = contentResolver.delete(c.a.o0.a.j0.c.a.a(), "app_id=?", new String[]{str}) > 0;
            if (z && z2 && (d2 = c.a.o0.a.n0.f.c().d()) != null) {
                c.a.o0.a.n0.l.c m = c.a.o0.a.n0.l.c.m(c0313b);
                m.i(4);
                d2.e(str, true, m.k());
            }
            if (f6900e) {
                String str5 = "deleteHistory: " + str + " isSuccess: " + z2;
            }
            if (z2) {
                c.a.o0.a.w0.c.e("DEL", str, System.currentTimeMillis(), str4, str2, str3, null);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0313b c0313b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, contentResolver, str, c0313b) == null) {
            boolean z = f6900e;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String a2 = c.a.o0.a.v.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            List<String> q = q(contentResolver, str);
            if (q != null && q.size() != 0) {
                c.a.o0.a.n0.d d2 = c.a.o0.a.n0.f.c().d();
                if (d2 != null) {
                    boolean z2 = f6900e;
                    d2.g(q, false, false, c0313b);
                }
                boolean z3 = f6900e;
                contentResolver.delete(c.a.o0.a.j0.c.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
                return;
            }
            boolean z4 = f6900e;
        }
    }

    @NonNull
    public static Set<String> h(@NonNull ContentResolver contentResolver) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, contentResolver)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(c.a.o0.a.j0.c.a.a(), null, null, null, null);
                } catch (Exception e2) {
                    if (f6900e) {
                        e2.printStackTrace();
                    }
                    if (f6900e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f6900e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    c.a.o0.t.d.d(cursor);
                    return hashSet;
                }
                if (f6900e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                c.a.o0.t.d.d(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f6900e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                c.a.o0.t.d.d(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static void i(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, cVar) == null) || cVar == null) {
            return;
        }
        i.d.i("").D(Schedulers.io()).k(new C0271b()).o(i.l.b.a.b()).B(new a(cVar));
    }

    @NonNull
    public static JSONObject j(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cursor)) == null) {
            JSONArray jSONArray = new JSONArray();
            do {
                JSONObject jSONObject = new JSONObject();
                try {
                    String string = cursor.getString(cursor.getColumnIndex("app_id"));
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("appid", string);
                    }
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
                        str = String.format(c.a.o0.a.c2.f.h0.a.f4832d, string);
                    } else {
                        str = c.a.o0.a.c2.f.h0.a.f4831c + string + "\"}";
                    }
                    jSONObject.put("scheme", str);
                    String string2 = cursor.getString(cursor.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put("dataStamp", string2);
                        jSONObject.put("dateStamp", string2);
                    }
                    String string3 = cursor.getString(cursor.getColumnIndex("app_icon"));
                    if (!TextUtils.isEmpty(string3)) {
                        jSONObject.put("iconUrl", string3);
                    }
                    jSONObject.put("payProtected", cursor.getInt(cursor.getColumnIndex("pay_protected")));
                    String string4 = cursor.getString(cursor.getColumnIndex("app_name"));
                    if (!TextUtils.isEmpty(string4)) {
                        jSONObject.put("title", string4);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } while (cursor.moveToNext());
            c.a.o0.a.i1.e.a.a(cursor);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (f6900e) {
                String str3 = "historyCursorToJson : " + jSONObject2.toString();
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return f6901f.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static Cursor l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? m(null, null) : (Cursor) invokeV.objValue;
    }

    public static Cursor m(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, strArr)) == null) {
            return AppRuntime.getAppContext().getContentResolver().query(c.a.o0.a.j0.c.a.a(), null, str, strArr, "visit_time desc  LIMIT 200");
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
    public static Cursor n(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor query;
        List<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i2)) == null) {
            HashMap hashMap = new HashMap();
            Cursor o = o(AppRuntime.getAppContext().getContentResolver(), str);
            if (o != null && o.moveToFirst()) {
                do {
                    c.a.o0.a.j0.a aVar = new c.a.o0.a.j0.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(o, aVar);
                    if (!TextUtils.isEmpty(aVar.f6875a)) {
                        c cVar = new c(null);
                        cVar.f6905b = aVar;
                        c.a.o0.a.w0.b bVar = cVar.f6906a;
                        bVar.f9420a = aVar.f6875a;
                        bVar.f9420a = o.getString(o.getColumnIndex("app_from"));
                        cVar.f6906a.f9424e = o.getLong(o.getColumnIndex("visit_time"));
                        hashMap.put(cVar.f6906a.f9420a, cVar);
                        if (f6900e) {
                            String str2 = "Aps&History == " + aVar.f6875a;
                        }
                    }
                } while (o.moveToNext());
                c.a.o0.t.d.d(o);
                if (f6900e) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(c.a.o0.a.j0.c.a.a(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                c.a.o0.t.d.d(query);
                if (f6900e) {
                }
                ArrayList<d> arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6900e) {
                }
                while (r12.hasNext()) {
                }
                if (f6900e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i3 = 0;
                if (i2 > 0) {
                }
                MatrixCursor matrixCursor = new MatrixCursor(f6903h, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor;
            }
            c.a.o0.t.d.d(o);
            if (f6900e) {
                String str3 = "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录";
            }
            query = AppRuntime.getAppContext().getContentResolver().query(c.a.o0.a.j0.c.a.a(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    c.a.o0.a.w0.b bVar2 = new c.a.o0.a.w0.b();
                    bVar2.f9420a = query.getString(query.getColumnIndex("app_id"));
                    bVar2.f9428i = query.getString(query.getColumnIndex("app_from"));
                    bVar2.f9424e = query.getLong(query.getColumnIndex("visit_time"));
                    bVar2.f9422c = query.getString(query.getColumnIndex("app_name"));
                    bVar2.f9421b = query.getString(query.getColumnIndex("app_key"));
                    bVar2.f9429j = query.getString(query.getColumnIndex("version_code"));
                    bVar2.f9423d = query.getString(query.getColumnIndex("app_icon"));
                    bVar2.f9425f = query.getInt(query.getColumnIndex("frame_type"));
                    hashMap22.put(bVar2.f9420a, bVar2);
                    if (f6900e) {
                        String str4 = "History == " + bVar2.f9420a;
                    }
                } while (query.moveToNext());
                c.a.o0.t.d.d(query);
                if (f6900e) {
                }
                ArrayList<d> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6900e) {
                }
                while (r12.hasNext()) {
                }
                if (f6900e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i32 = 0;
                if (i2 > 0) {
                    arrayList = arrayList.subList(0, i2);
                    if (f6900e) {
                    }
                }
                MatrixCursor matrixCursor2 = new MatrixCursor(f6903h, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor2;
            }
            c.a.o0.t.d.d(query);
            if (f6900e) {
                String str5 = "^ History 库查询到 " + hashMap22.size() + " 个历史记录";
            }
            ArrayList<d> arrayList222 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(c.a.o0.n.g.a.h().t().values())) {
                if (f6900e) {
                    String str6 = "Pms == " + pMSAppInfo.appId;
                }
                String str7 = pMSAppInfo.appName;
                if (str7 != null && str7.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                    f fVar = new f(null);
                    fVar.f6906a = (c.a.o0.a.w0.b) hashMap22.get(pMSAppInfo.appId);
                    fVar.f6907b = pMSAppInfo;
                    arrayList222.add(fVar);
                }
            }
            if (f6900e) {
                String str8 = "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录";
            }
            for (d dVar : arrayList222) {
                hashMap.put(dVar.f6906a.f9420a, dVar);
            }
            if (f6900e) {
                String str9 = "合并后有 " + hashMap.size() + " 个历史记录";
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    String str10 = "Migrate == " + ((d) it.next()).f6906a.f9420a;
                }
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i322 = 0;
            if (i2 > 0 && i2 < arrayList.size()) {
                arrayList = arrayList.subList(0, i2);
                if (f6900e) {
                    String str11 = "Limit限制 " + i2 + " 条";
                }
            }
            MatrixCursor matrixCursor22 = new MatrixCursor(f6903h, 50);
            for (d dVar2 : arrayList) {
                d(matrixCursor22, i322, dVar2);
                i322++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeLI.objValue;
    }

    @Nullable
    public static Cursor o(@NonNull ContentResolver contentResolver, @NonNull String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, contentResolver, str)) == null) {
            try {
                cursor = contentResolver.query(c.a.o0.a.j0.c.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
            } catch (Exception e2) {
                if (f6900e) {
                    e2.printStackTrace();
                }
                cursor = null;
            }
            if (f6900e && cursor != null) {
                String str2 = "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount();
            }
            return cursor;
        }
        return (Cursor) invokeLL.objValue;
    }

    public static Set<String> p(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, sQLiteDatabase)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("ai_apps_history", null, null, null, null, null, null);
                } catch (Exception e2) {
                    if (f6900e) {
                        e2.printStackTrace();
                    }
                    if (f6900e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f6900e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    c.a.o0.a.i1.e.a.a(cursor);
                    return hashSet;
                }
                if (f6900e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                c.a.o0.a.i1.e.a.a(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f6900e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                c.a.o0.a.i1.e.a.a(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0089 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    @Nullable
    public static List<String> q(@NonNull ContentResolver contentResolver, @Nullable String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65553, null, contentResolver, str)) != null) {
            return (List) invokeLL.objValue;
        }
        ?? r1 = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String a2 = c.a.o0.a.v.a.a(str);
                if (TextUtils.isEmpty(a2)) {
                    c.a.o0.t.d.d(null);
                    return null;
                }
                cursor = contentResolver.query(c.a.o0.a.j0.c.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
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
                            c.a.o0.t.d.d(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f6900e) {
                            e.printStackTrace();
                        }
                        c.a.o0.t.d.d(cursor);
                        return null;
                    }
                }
                c.a.o0.t.d.d(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                c.a.o0.t.d.d(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = contentResolver;
        }
    }

    @WorkerThread
    public static void r(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0313b c0313b) {
        int i2;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, contentResolver, str, c0313b) == null) {
            Cursor cursor = null;
            if (str == null) {
                str = "";
            }
            try {
                try {
                    query = contentResolver.query(c.a.o0.a.j0.c.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
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
                if (f6900e) {
                    String str2 = "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str;
                }
                if (arrayList.isEmpty()) {
                    c.a.o0.t.d.d(query);
                    return;
                }
                c.a.o0.a.n0.d d2 = c.a.o0.a.n0.f.c().d();
                if (d2 != null) {
                    d2.f(arrayList, false, c0313b);
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
                int delete = contentResolver.delete(c.a.o0.a.j0.c.a.a(), str3, null);
                if (f6900e) {
                    String str4 = "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str3;
                }
                c.a.o0.t.d.d(query);
            } catch (Exception unused2) {
                cursor = query;
                boolean z = f6900e;
                c.a.o0.t.d.d(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                c.a.o0.t.d.d(cursor);
                throw th;
            }
        }
    }

    public static void s(ContentResolver contentResolver, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, contentResolver, str, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i2));
            contentResolver.update(c.a.o0.a.j0.c.a.a(), contentValues, "app_id=?", new String[]{str});
        }
    }

    public static void t(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : p(sQLiteDatabase)) {
                    PMSAppInfo s = c.a.o0.n.g.a.h().s(str);
                    if (s != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_name", s.appName);
                        contentValues.put("app_icon", s.iconUrl);
                        contentValues.put("frame_type", Integer.valueOf(s.appCategory));
                        contentValues.put("app_type", String.valueOf(s.type));
                        contentValues.put("sync_state", (Integer) 0);
                        if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                            boolean z = f6900e;
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

        /* renamed from: a  reason: collision with root package name */
        public c.a.o0.a.w0.b f6906a;

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
            this.f6906a = new c.a.o0.a.w0.b();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
