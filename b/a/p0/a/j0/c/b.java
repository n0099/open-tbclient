package b.a.p0.a.j0.c;

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
import b.a.p0.a.c2.f.h0.a;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.a.n0.l.b;
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
public class b implements b.a.p0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6251e;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f6252f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static AtomicLong f6253g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f6254h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements h.n.b<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f6255e;

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
            this.f6255e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                if (cursor == null || !cursor.moveToFirst()) {
                    boolean unused = b.f6251e;
                    b.a.p0.a.i1.e.a.a(cursor);
                    this.f6255e.a(null);
                    return;
                }
                this.f6255e.a(b.j(cursor));
            }
        }
    }

    /* renamed from: b.a.p0.a.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0268b implements h.n.f<String, Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0268b() {
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
        @Override // h.n.f
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
        public b.a.p0.a.j0.a f6256b;

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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.f6257a.f8705e, dVar.f6257a.f8705e) : invokeLL.intValue;
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
        public PMSAppInfo f6258b;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922676232, "Lb/a/p0/a/j0/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922676232, "Lb/a/p0/a/j0/c/b;");
                return;
            }
        }
        f6251e = k.f6397a;
        f6252f = Sets.newHashSet();
        f6254h = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable b.a.p0.a.w0.b bVar, b.C0310b c0310b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, contentResolver, bVar, c0310b)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f8701a)) {
                return false;
            }
            if (f6251e) {
                String str = "addHistory: " + bVar.f8703c + " / " + bVar.f8701a;
            }
            if (k(bVar.f8701a)) {
                boolean z = f6251e;
                return false;
            }
            if (TextUtils.equals(String.valueOf(1), bVar.f8707g)) {
                String str2 = bVar.f8701a;
                b.a.p0.a.n0.l.c m = b.a.p0.a.n0.l.c.m(c0310b);
                m.i(1);
                g(contentResolver, str2, m.k());
            }
            Uri a2 = b.a.p0.a.j0.c.a.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", bVar.f8701a);
            contentValues.put("visit_time", Long.valueOf(bVar.f8705e));
            contentValues.put("app_from", bVar.f8709i);
            contentValues.put("app_name", bVar.f8703c);
            contentValues.put("app_key", bVar.f8702b);
            contentValues.put("version_code", bVar.j);
            contentValues.put("app_icon", bVar.f8704d);
            contentValues.put("frame_type", Integer.valueOf(bVar.f8706f));
            contentValues.put("app_type", bVar.f8707g);
            contentValues.put("pay_protected", Integer.valueOf(bVar.f8708h));
            contentValues.put("sync_state", (Integer) 0);
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
                if (f6251e) {
                    String str3 = "Add history: newUri - " + (insert == null ? "NULL" : insert.toString());
                }
                if (e()) {
                    String str4 = bVar.f8701a;
                    b.a.p0.a.n0.l.c m2 = b.a.p0.a.n0.l.c.m(c0310b);
                    m2.i(2);
                    r(contentResolver, str4, m2.k());
                }
                return insert != null;
            } catch (Exception e2) {
                b.a.p0.a.h0.a.f(a2.toString(), bVar.f8701a, e2.toString());
                if (f6251e) {
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
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.f6256b.f6227a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.f6256b.f6228b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.f6256b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.f6256b.f6229c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.f6256b.f6230d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.f6256b.f6231e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.f6256b.f6232f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.f6256b.f6233g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.f6256b.f6234h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.f6256b.f6235i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.f6256b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.f6256b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.f6256b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.f6256b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.f6256b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.f6256b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.f6256b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.f6256b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.f6256b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.f6256b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.f6256b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.f6256b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.f6256b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.f6256b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.f6256b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.f6256b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.f6256b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.f6256b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.f6256b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.f6256b.D ? 1 : 0)).add("app_from", cVar.f6257a.f8709i).add("visit_time", Long.valueOf(cVar.f6257a.f8705e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.f6256b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.f6256b.F);
                return;
            }
            f fVar = (f) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.f6257a.f8701a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.f6258b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.f6258b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.f6258b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.f6258b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.f6258b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.f6258b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.f6258b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.f6257a.f8704d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.f6257a.f8703c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.f6258b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.f6258b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.f6258b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.f6258b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.f6258b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.f6258b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.f6258b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.f6258b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.f6258b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.f6258b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.f6258b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.f6257a.f8709i).add("visit_time", Long.valueOf(fVar.f6257a.f8705e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.f6258b.payProtected)).add("customer_service", Integer.valueOf(fVar.f6258b.customerService)).add("global_notice", Integer.valueOf(fVar.f6258b.globalNotice)).add("global_private", Integer.valueOf(fVar.f6258b.globalPrivate)).add("pa_number", fVar.f6258b.paNumber).add("brand", fVar.f6258b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.f6258b.quickAppKey);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f6253g != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f6253g.get() > 86400000) {
                    f6253g.set(currentTimeMillis);
                    h.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                    return true;
                }
                return false;
            }
            synchronized (h.class) {
                if (f6253g == null) {
                    f6253g = new AtomicLong(h.a().getLong("key_check_delete_swan_history", 0L));
                    return e();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean f(ContentResolver contentResolver, String str, boolean z, b.C0310b c0310b) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        b.a.p0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{contentResolver, str, Boolean.valueOf(z), c0310b})) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Cursor query = contentResolver.query(b.a.p0.a.j0.c.a.a(), null, "app_id=?", new String[]{str}, null);
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
            b.a.p0.t.d.d(query);
            boolean z2 = contentResolver.delete(b.a.p0.a.j0.c.a.a(), "app_id=?", new String[]{str}) > 0;
            if (z && z2 && (d2 = b.a.p0.a.n0.f.c().d()) != null) {
                b.a.p0.a.n0.l.c m = b.a.p0.a.n0.l.c.m(c0310b);
                m.i(4);
                d2.e(str, true, m.k());
            }
            if (f6251e) {
                String str5 = "deleteHistory: " + str + " isSuccess: " + z2;
            }
            if (z2) {
                b.a.p0.a.w0.c.e("DEL", str, System.currentTimeMillis(), str4, str2, str3, null);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0310b c0310b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, contentResolver, str, c0310b) == null) {
            boolean z = f6251e;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String a2 = b.a.p0.a.v.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            List<String> q = q(contentResolver, str);
            if (q != null && q.size() != 0) {
                b.a.p0.a.n0.d d2 = b.a.p0.a.n0.f.c().d();
                if (d2 != null) {
                    boolean z2 = f6251e;
                    d2.g(q, false, false, c0310b);
                }
                boolean z3 = f6251e;
                contentResolver.delete(b.a.p0.a.j0.c.a.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
                return;
            }
            boolean z4 = f6251e;
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
                    cursor = contentResolver.query(b.a.p0.a.j0.c.a.a(), null, null, null, null);
                } catch (Exception e2) {
                    if (f6251e) {
                        e2.printStackTrace();
                    }
                    if (f6251e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f6251e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    b.a.p0.t.d.d(cursor);
                    return hashSet;
                }
                if (f6251e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                b.a.p0.t.d.d(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f6251e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                b.a.p0.t.d.d(cursor);
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
        h.d.f("").y(Schedulers.io()).h(new C0268b()).k(h.l.b.a.b()).w(new a(cVar));
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
                        str = String.format(b.a.p0.a.c2.f.h0.a.f4253d, string);
                    } else {
                        str = b.a.p0.a.c2.f.h0.a.f4252c + string + "\"}";
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
            b.a.p0.a.i1.e.a.a(cursor);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (f6251e) {
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
            return f6252f.contains(str);
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
            return AppRuntime.getAppContext().getContentResolver().query(b.a.p0.a.j0.c.a.a(), null, str, strArr, "visit_time desc  LIMIT 200");
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
                    b.a.p0.a.j0.a aVar = new b.a.p0.a.j0.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(o, aVar);
                    if (!TextUtils.isEmpty(aVar.f6227a)) {
                        c cVar = new c(null);
                        cVar.f6256b = aVar;
                        b.a.p0.a.w0.b bVar = cVar.f6257a;
                        bVar.f8701a = aVar.f6227a;
                        bVar.f8701a = o.getString(o.getColumnIndex("app_from"));
                        cVar.f6257a.f8705e = o.getLong(o.getColumnIndex("visit_time"));
                        hashMap.put(cVar.f6257a.f8701a, cVar);
                        if (f6251e) {
                            String str2 = "Aps&History == " + aVar.f6227a;
                        }
                    }
                } while (o.moveToNext());
                b.a.p0.t.d.d(o);
                if (f6251e) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(b.a.p0.a.j0.c.a.a(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                b.a.p0.t.d.d(query);
                if (f6251e) {
                }
                ArrayList<d> arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6251e) {
                }
                while (r12.hasNext()) {
                }
                if (f6251e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i3 = 0;
                if (i2 > 0) {
                }
                MatrixCursor matrixCursor = new MatrixCursor(f6254h, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor;
            }
            b.a.p0.t.d.d(o);
            if (f6251e) {
                String str3 = "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录";
            }
            query = AppRuntime.getAppContext().getContentResolver().query(b.a.p0.a.j0.c.a.a(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    b.a.p0.a.w0.b bVar2 = new b.a.p0.a.w0.b();
                    bVar2.f8701a = query.getString(query.getColumnIndex("app_id"));
                    bVar2.f8709i = query.getString(query.getColumnIndex("app_from"));
                    bVar2.f8705e = query.getLong(query.getColumnIndex("visit_time"));
                    bVar2.f8703c = query.getString(query.getColumnIndex("app_name"));
                    bVar2.f8702b = query.getString(query.getColumnIndex("app_key"));
                    bVar2.j = query.getString(query.getColumnIndex("version_code"));
                    bVar2.f8704d = query.getString(query.getColumnIndex("app_icon"));
                    bVar2.f8706f = query.getInt(query.getColumnIndex("frame_type"));
                    hashMap22.put(bVar2.f8701a, bVar2);
                    if (f6251e) {
                        String str4 = "History == " + bVar2.f8701a;
                    }
                } while (query.moveToNext());
                b.a.p0.t.d.d(query);
                if (f6251e) {
                }
                ArrayList<d> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6251e) {
                }
                while (r12.hasNext()) {
                }
                if (f6251e) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i32 = 0;
                if (i2 > 0) {
                    arrayList = arrayList.subList(0, i2);
                    if (f6251e) {
                    }
                }
                MatrixCursor matrixCursor2 = new MatrixCursor(f6254h, 50);
                while (r12.hasNext()) {
                }
                return matrixCursor2;
            }
            b.a.p0.t.d.d(query);
            if (f6251e) {
                String str5 = "^ History 库查询到 " + hashMap22.size() + " 个历史记录";
            }
            ArrayList<d> arrayList222 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(b.a.p0.n.g.a.h().t().values())) {
                if (f6251e) {
                    String str6 = "Pms == " + pMSAppInfo.appId;
                }
                String str7 = pMSAppInfo.appName;
                if (str7 != null && str7.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                    f fVar = new f(null);
                    fVar.f6257a = (b.a.p0.a.w0.b) hashMap22.get(pMSAppInfo.appId);
                    fVar.f6258b = pMSAppInfo;
                    arrayList222.add(fVar);
                }
            }
            if (f6251e) {
                String str8 = "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录";
            }
            for (d dVar : arrayList222) {
                hashMap.put(dVar.f6257a.f8701a, dVar);
            }
            if (f6251e) {
                String str9 = "合并后有 " + hashMap.size() + " 个历史记录";
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    String str10 = "Migrate == " + ((d) it.next()).f6257a.f8701a;
                }
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i322 = 0;
            if (i2 > 0 && i2 < arrayList.size()) {
                arrayList = arrayList.subList(0, i2);
                if (f6251e) {
                    String str11 = "Limit限制 " + i2 + " 条";
                }
            }
            MatrixCursor matrixCursor22 = new MatrixCursor(f6254h, 50);
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
                cursor = contentResolver.query(b.a.p0.a.j0.c.a.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
            } catch (Exception e2) {
                if (f6251e) {
                    e2.printStackTrace();
                }
                cursor = null;
            }
            if (f6251e && cursor != null) {
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
                    if (f6251e) {
                        e2.printStackTrace();
                    }
                    if (f6251e && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (f6251e) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        sb.toString();
                    }
                    b.a.p0.a.i1.e.a.a(cursor);
                    return hashSet;
                }
                if (f6251e && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    sb.toString();
                }
                b.a.p0.a.i1.e.a.a(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (f6251e && cursor != null) {
                    String str = "getAllHistoryIdsSet: Cursor count: " + cursor.getCount();
                }
                b.a.p0.a.i1.e.a.a(cursor);
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
                String a2 = b.a.p0.a.v.a.a(str);
                if (TextUtils.isEmpty(a2)) {
                    b.a.p0.t.d.d(null);
                    return null;
                }
                cursor = contentResolver.query(b.a.p0.a.j0.c.a.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
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
                            b.a.p0.t.d.d(cursor);
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (f6251e) {
                            e.printStackTrace();
                        }
                        b.a.p0.t.d.d(cursor);
                        return null;
                    }
                }
                b.a.p0.t.d.d(cursor);
                return null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                b.a.p0.t.d.d(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = contentResolver;
        }
    }

    @WorkerThread
    public static void r(@NonNull ContentResolver contentResolver, @Nullable String str, b.C0310b c0310b) {
        int i2;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, contentResolver, str, c0310b) == null) {
            Cursor cursor = null;
            if (str == null) {
                str = "";
            }
            try {
                try {
                    query = contentResolver.query(b.a.p0.a.j0.c.a.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
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
                if (f6251e) {
                    String str2 = "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str;
                }
                if (arrayList.isEmpty()) {
                    b.a.p0.t.d.d(query);
                    return;
                }
                b.a.p0.a.n0.d d2 = b.a.p0.a.n0.f.c().d();
                if (d2 != null) {
                    d2.f(arrayList, false, c0310b);
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
                int delete = contentResolver.delete(b.a.p0.a.j0.c.a.a(), str3, null);
                if (f6251e) {
                    String str4 = "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str3;
                }
                b.a.p0.t.d.d(query);
            } catch (Exception unused2) {
                cursor = query;
                boolean z = f6251e;
                b.a.p0.t.d.d(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                b.a.p0.t.d.d(cursor);
                throw th;
            }
        }
    }

    public static void s(ContentResolver contentResolver, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65555, null, contentResolver, str, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i2));
            contentResolver.update(b.a.p0.a.j0.c.a.a(), contentValues, "app_id=?", new String[]{str});
        }
    }

    public static void t(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : p(sQLiteDatabase)) {
                    PMSAppInfo s = b.a.p0.n.g.a.h().s(str);
                    if (s != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_name", s.appName);
                        contentValues.put("app_icon", s.iconUrl);
                        contentValues.put("frame_type", Integer.valueOf(s.appCategory));
                        contentValues.put("app_type", String.valueOf(s.type));
                        contentValues.put("sync_state", (Integer) 0);
                        if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                            boolean z = f6251e;
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
        public b.a.p0.a.w0.b f6257a;

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
            this.f6257a = new b.a.p0.a.w0.b();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
