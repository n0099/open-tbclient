package c.a.r0.a.j0.b;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.n0.l.b;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f7410b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f7411c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.j0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0441a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r0.a.j0.a f7412b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C0441a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(C0441a c0441a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f7413b;

        public c() {
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

        public /* synthetic */ c(C0441a c0441a) {
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.a.f7413b, dVar.a.f7413b) : invokeLL.intValue;
        }

        public /* synthetic */ e(C0441a c0441a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                int i2 = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0).getInt("aiapps_user_fav_count", 0);
                if (a.a) {
                    String str = "delegate读取到的收藏次数：" + i2;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fav_count", i2);
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                SharedPreferences sharedPreferences = AppRuntime.getAppContext().getSharedPreferences("aiapps_favorite", 0);
                int i2 = sharedPreferences.getInt("aiapps_user_fav_count", 0);
                if (a.a) {
                    String str = "delegate当前收藏次数：" + i2;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                int i3 = i2 + 1;
                edit.putInt("aiapps_user_fav_count", i3);
                edit.commit();
                if (a.a) {
                    String str2 = "delegate写入新收藏次数" + i3;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fav_count", i3);
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public PMSAppInfo f7414b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C0441a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ h(C0441a c0441a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1175074793, "Lc/a/r0/a/j0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1175074793, "Lc/a/r0/a/j0/b/a;");
                return;
            }
        }
        a = k.a;
        f7410b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        f7411c = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i2, c.a.r0.a.q0.b.a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, swanFavorItemData, i2, aVar)) == null) {
            if (i2 < 0) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j2 = j();
            if (j2.size() == 0) {
                if (!h(swanFavorItemData, 1)) {
                    if (aVar != null) {
                        aVar.b(false);
                    }
                    return false;
                }
                if (aVar != null) {
                    aVar.c();
                }
                p();
                return true;
            } else if (j2.size() + 1 == i2) {
                if (!h(swanFavorItemData, j2.get(j2.size() - 1).getIndex() + 1)) {
                    if (aVar != null) {
                        aVar.b(false);
                    }
                    return false;
                }
                if (aVar != null) {
                    aVar.c();
                }
                p();
                return true;
            } else {
                int i3 = 0;
                while (i3 < j2.size()) {
                    int i4 = i3 + 1;
                    if (i4 == i2) {
                        swanFavorItemData.setIndex(j2.get(i3).getIndex());
                        if (!h(swanFavorItemData, swanFavorItemData.getIndex())) {
                            if (aVar != null) {
                                aVar.b(false);
                            }
                            return false;
                        }
                    }
                    i3 = i4;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i5 = 0;
                while (i5 < j2.size()) {
                    int i6 = i5 + 1;
                    if (i6 >= i2) {
                        int index = j2.get(i5).getIndex() + 1;
                        j2.get(i5).setIndex(index);
                        arrayList.add(j2.get(i5).getAppKey());
                        arrayList2.add(Integer.valueOf(index));
                    }
                    i5 = i6;
                }
                boolean w = w(arrayList, arrayList2);
                if (!w) {
                    if (aVar != null) {
                        aVar.b(false);
                    }
                    return false;
                }
                if (aVar != null) {
                    aVar.c();
                }
                p();
                return w;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static void c(MatrixCursor matrixCursor, int i2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, matrixCursor, i2, dVar) == null) {
            if (dVar instanceof b) {
                b bVar = (b) dVar;
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.f7412b.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.f7412b.f7401b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.f7412b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.f7412b.f7402c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.f7412b.f7403d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.f7412b.f7404e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.f7412b.f7405f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.f7412b.f7406g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.f7412b.f7407h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.f7412b.f7408i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.f7412b.f7409j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.f7412b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.f7412b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.f7412b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.f7412b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.f7412b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.f7412b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.f7412b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.f7412b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.f7412b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.f7412b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.f7412b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.f7412b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.f7412b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.f7412b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.f7412b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.f7412b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.f7412b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.f7412b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.f7412b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.a.f7413b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.f7412b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.f7412b.F);
                return;
            }
            h hVar = (h) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.f7414b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.f7414b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.f7414b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.f7414b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.f7414b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.f7414b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.f7414b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.f7414b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.f7414b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.f7414b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.f7414b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.f7414b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.f7414b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.f7414b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.f7414b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.f7414b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.f7414b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.f7414b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.f7414b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.f7414b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.f7414b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(hVar.a.f7413b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.f7414b.payProtected)).add("customer_service", Integer.valueOf(hVar.f7414b.customerService)).add("global_notice", Integer.valueOf(hVar.f7414b.globalNotice)).add("global_private", Integer.valueOf(hVar.f7414b.globalPrivate)).add("pa_number", hVar.f7414b.paNumber).add("brand", hVar.f7414b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.f7414b.quickAppKey);
        }
    }

    public static Uri d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.r0.a.j0.b.b.f7416c.buildUpon().appendPath("favorite_and_aps").build() : (Uri) invokeV.objValue;
    }

    public static Uri e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.r0.a.j0.b.b.f7416c.buildUpon().appendPath("favorite").build() : (Uri) invokeV.objValue;
    }

    public static Uri f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.r0.a.j0.b.b.f7416c.buildUpon().appendPath("favorite_with_aps_pms").build() : (Uri) invokeV.objValue;
    }

    public static boolean g(@NonNull String str, c.a.r0.a.q0.b.b bVar, b.C0480b c0480b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, bVar, c0480b)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.c(false);
                }
                return false;
            }
            c.a.r0.a.n0.l.c m = c.a.r0.a.n0.l.c.m(c0480b);
            m.i(3);
            b.C0480b k = m.k();
            if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
                boolean z = a;
                if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                    if (ProcessUtils.isMainProcess()) {
                        c.a.r0.a.n0.d d2 = c.a.r0.a.n0.f.c().d();
                        if (d2 != null) {
                            d2.e(str, true, k);
                        }
                    } else if (c.a.r0.a.j0.c.b.i(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(c.a.r0.a.d2.d.J().r().N(), str)) {
                        c.a.r0.a.y1.c.e.a.P().Z(8, new SwanAppDeleteInfo(str).setPurgerScenes(c.a.r0.a.n0.l.c.m(k).c()));
                    }
                }
                if (a) {
                    String str2 = "取消收藏成功： " + str;
                }
                p();
                if (bVar != null) {
                    bVar.b();
                }
            } else if (bVar != null) {
                bVar.c(false);
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean h(@NonNull SwanFavorItemData swanFavorItemData, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, swanFavorItemData, i2)) == null) {
            Uri e2 = e();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", swanFavorItemData.getAppKey());
            contentValues.put("sort_index", Integer.valueOf(i2));
            contentValues.put("favorite_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("app_name", swanFavorItemData.getAppName());
            contentValues.put("app_icon", swanFavorItemData.getIconUrl());
            contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
            contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
            contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
            contentValues.put("is_new_favor", Integer.valueOf(swanFavorItemData.getIsNewFavor()));
            if (AppRuntime.getAppContext().getContentResolver().insert(e2, contentValues) != null) {
                if (a) {
                    String str = "数据库收藏成功： " + swanFavorItemData.getAppKey();
                }
                c.a.r0.a.o2.g.h.a().putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean i(List<SwanFavorItemData> list, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, hashMap)) == null) {
            if (list != null && list.size() > 0) {
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(c.a.r0.a.c1.a.c()).h().getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    int i2 = 0;
                    while (i2 < list.size()) {
                        ContentValues contentValues = new ContentValues();
                        SwanFavorItemData swanFavorItemData = list.get(i2);
                        contentValues.put("app_id", swanFavorItemData.getAppKey());
                        i2++;
                        contentValues.put("sort_index", Integer.valueOf(i2));
                        contentValues.put("favorite_time", Long.valueOf(swanFavorItemData.getCreateTime()));
                        contentValues.put("app_name", swanFavorItemData.getAppName());
                        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
                        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
                        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
                        contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
                        contentValues.put("is_new_favor", hashMap.get(swanFavorItemData.getAppKey()));
                        if (writableDatabase.insertWithOnConflict("ai_apps_favorites", null, contentValues, 5) < 0) {
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.endTransaction();
                                } catch (Exception unused) {
                                }
                            }
                            return false;
                        }
                    }
                    boolean z = a;
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                            return true;
                        } catch (Exception unused2) {
                            return true;
                        }
                    }
                    return true;
                } catch (Exception unused3) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused4) {
                        }
                    }
                } catch (Throwable th) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static List<SwanFavorItemData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            Cursor k = k();
            if (k == null) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList(k.getCount());
            try {
                try {
                    if (k.getCount() > 0) {
                        k.moveToFirst();
                        do {
                            SwanFavorItemData l = l(k);
                            if (!TextUtils.isEmpty(l.getAppKey()) && !TextUtils.isEmpty(l.getAppName())) {
                                arrayList.add(l);
                            }
                        } while (k.moveToNext());
                    }
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                return arrayList;
            } finally {
                c.a.r0.w.d.d(k);
            }
        }
        return (List) invokeV.objValue;
    }

    public static Cursor k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            u();
            return AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "sort_index");
        }
        return (Cursor) invokeV.objValue;
    }

    public static SwanFavorItemData l(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cursor)) == null) {
            SwanFavorItemData swanFavorItemData = new SwanFavorItemData();
            swanFavorItemData.setIndex(cursor.getInt(cursor.getColumnIndex("sort_index")));
            swanFavorItemData.setAppKey(cursor.getString(cursor.getColumnIndex("app_id")));
            swanFavorItemData.setAppName(cursor.getString(cursor.getColumnIndex("app_name")));
            swanFavorItemData.setIconUrl(cursor.getString(cursor.getColumnIndex("app_icon")));
            swanFavorItemData.setAppType(cursor.getInt(cursor.getColumnIndex("app_type")));
            swanFavorItemData.setAppFrameType(cursor.getInt(cursor.getColumnIndex("frame_type")));
            swanFavorItemData.setPayProtected(cursor.getInt(cursor.getColumnIndex("pay_protected")));
            swanFavorItemData.setIsNewFavor(cursor.getInt(cursor.getColumnIndex("is_new_favor")));
            if (a) {
                String str = "Favotite == " + swanFavorItemData.getAppKey();
            }
            if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
                List<c.a.r0.a.j0.a> r = r();
                if (r.size() > 0) {
                    Iterator<c.a.r0.a.j0.a> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.r0.a.j0.a next = it.next();
                        if (TextUtils.equals(swanFavorItemData.getAppKey(), next.a)) {
                            swanFavorItemData.setAppKey(next.a);
                            swanFavorItemData.setAppName(next.l);
                            swanFavorItemData.setIconUrl(next.f7408i);
                            swanFavorItemData.setAppFrameType(next.y);
                            swanFavorItemData.setAppType(next.r);
                            swanFavorItemData.setPayProtected(next.E);
                            v(swanFavorItemData);
                            break;
                        }
                    }
                }
            }
            return swanFavorItemData;
        }
        return (SwanFavorItemData) invokeL.objValue;
    }

    public static boolean m(List<SwanFavorItemData> list, String str, String str2, String str3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{list, str, str2, str3, Integer.valueOf(i2)})) == null) {
            if (list != null && list.size() > 0) {
                for (SwanFavorItemData swanFavorItemData : list) {
                    if (TextUtils.equals(str, swanFavorItemData.getAppKey()) && TextUtils.equals(str2, swanFavorItemData.getAppName()) && TextUtils.equals(str3, swanFavorItemData.getIconUrl()) && i2 == swanFavorItemData.getPayProtected()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r0.getCount() > 0) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean n(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            boolean z = true;
            boolean z2 = false;
            try {
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(e(), null, "app_id = ?", new String[]{str}, null);
                if (query != null) {
                }
                z = false;
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e2) {
                        e = e2;
                        z2 = z;
                        if (a) {
                            e.printStackTrace();
                        }
                        z = z2;
                        if (a) {
                        }
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (a) {
                String str2 = "小程序： " + str + "是否在收藏列表中：" + z;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, int i2, c.a.r0.a.q0.b.a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, str, i2, aVar)) == null) {
            if (TextUtils.isEmpty(str) || i2 < 1) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j2 = j();
            if (j2.size() < i2) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < j2.size()) {
                int i4 = i3 + 1;
                if (i4 == i2) {
                    arrayList.add(str);
                    arrayList2.add(Integer.valueOf(j2.get(i3).getIndex()));
                    if (!w(arrayList, arrayList2)) {
                        if (aVar != null) {
                            aVar.b(false);
                        }
                        return false;
                    }
                }
                i3 = i4;
            }
            arrayList.clear();
            arrayList2.clear();
            int i5 = 0;
            while (i5 < j2.size()) {
                int i6 = i5 + 1;
                if (i6 >= i2 && !TextUtils.equals(j2.get(i5).getAppKey(), str)) {
                    arrayList2.add(Integer.valueOf(j2.get(i5).getIndex() + 1));
                    arrayList.add(j2.get(i5).getAppKey());
                }
                i5 = i6;
            }
            boolean w = w(arrayList, arrayList2);
            if (!w) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            if (aVar != null) {
                aVar.c();
            }
            p();
            return w;
        }
        return invokeLIL.booleanValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            AppRuntime.getAppContext().getContentResolver().notifyChange(e(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(d(), (ContentObserver) null, false);
            AppRuntime.getAppContext().getContentResolver().notifyChange(f(), (ContentObserver) null, false);
        }
    }

    public static void q(List<SwanFavorItemData> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, list) == null) {
            Cursor k = k();
            if (list == null || list.size() <= 0) {
                if (k == null || k.getCount() <= 0) {
                    return;
                }
                AppRuntime.getAppContext().getContentResolver().delete(e(), null, null);
                p();
            } else if (k == null) {
            } else {
                boolean z2 = false;
                try {
                    try {
                        boolean moveToFirst = k.moveToFirst();
                        HashMap hashMap = new HashMap();
                        do {
                            z = true;
                            if (!moveToFirst) {
                                break;
                            }
                            String string = k.getString(k.getColumnIndex("app_id"));
                            String string2 = k.getString(k.getColumnIndex("app_icon"));
                            String string3 = k.getString(k.getColumnIndex("app_name"));
                            int i2 = k.getInt(k.getColumnIndex("pay_protected"));
                            hashMap.put(string, Integer.valueOf(k.getInt(k.getColumnIndex("is_new_favor"))));
                            if (!m(list, string, string3, string2, i2)) {
                                z2 = true;
                            }
                        } while (k.moveToNext());
                        if (z2 || k.getCount() == list.size()) {
                            z = z2;
                        }
                        if (z) {
                            AppRuntime.getAppContext().getContentResolver().delete(e(), null, null);
                            i(list, hashMap);
                            p();
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    c.a.r0.w.d.d(k);
                }
            }
        }
    }

    @NonNull
    public static List<c.a.r0.a.j0.a> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor s = s();
            if (s != null) {
                try {
                    try {
                        if (s.getCount() > 0) {
                            s.moveToFirst();
                            do {
                                c.a.r0.a.j0.a aVar = new c.a.r0.a.j0.a();
                                SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, aVar);
                                if (!TextUtils.isEmpty(aVar.a)) {
                                    arrayList.add(aVar);
                                }
                            } while (s.moveToNext());
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    c.a.r0.w.d.d(s);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196 A[LOOP:3: B:45:0x0190->B:47:0x0196, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x020d A[LOOP:5: B:55:0x0207->B:57:0x020d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor s() {
        InterceptResult invokeV;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            HashMap hashMap = new HashMap();
            Cursor query2 = AppRuntime.getAppContext().getContentResolver().query(d(), null, null, null, "favorite_time DESC");
            if (query2 != null && query2.moveToFirst()) {
                do {
                    c.a.r0.a.j0.a aVar = new c.a.r0.a.j0.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, aVar);
                    if (!TextUtils.isEmpty(aVar.a)) {
                        b bVar = new b(null);
                        bVar.f7412b = aVar;
                        c cVar = bVar.a;
                        cVar.a = aVar.a;
                        cVar.f7413b = query2.getLong(query2.getColumnIndex("favorite_time"));
                        hashMap.put(bVar.a.a, bVar);
                        if (a) {
                            String str = "Aps&Favotite == " + aVar.a;
                        }
                    }
                } while (query2.moveToNext());
                c.a.r0.w.d.d(query2);
                if (a) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                c.a.r0.w.d.d(query);
                if (a) {
                }
                ArrayList<d> arrayList = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r1.hasNext()) {
                }
                if (a) {
                }
                ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
                Collections.sort(arrayList2, new e(null));
                MatrixCursor matrixCursor = new MatrixCursor(f7411c, 50);
                int i2 = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor;
            }
            c.a.r0.w.d.d(query2);
            if (a) {
                String str2 = "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏";
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    c cVar2 = new c(null);
                    cVar2.a = query.getString(query.getColumnIndex("app_id"));
                    cVar2.f7413b = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(cVar2.a, cVar2);
                    if (a) {
                        String str3 = "Favotite == " + cVar2.a;
                    }
                } while (query.moveToNext());
                c.a.r0.w.d.d(query);
                if (a) {
                }
                ArrayList<d> arrayList3 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r1.hasNext()) {
                }
                if (a) {
                }
                ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
                Collections.sort(arrayList22, new e(null));
                MatrixCursor matrixCursor2 = new MatrixCursor(f7411c, 50);
                int i22 = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor2;
            }
            c.a.r0.w.d.d(query);
            if (a) {
                String str4 = "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏";
            }
            ArrayList<d> arrayList32 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(c.a.r0.q.g.a.i().v().values())) {
                if (a) {
                    String str5 = "Pms == " + pMSAppInfo.appId;
                }
                if (hashMap22.containsKey(pMSAppInfo.appId)) {
                    h hVar = new h(null);
                    hVar.a = (c) hashMap22.get(pMSAppInfo.appId);
                    hVar.f7414b = pMSAppInfo;
                    arrayList32.add(hVar);
                }
            }
            if (a) {
                String str6 = "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏";
            }
            for (d dVar : arrayList32) {
                hashMap.put(dVar.a.a, dVar);
            }
            if (a) {
                String str7 = "合并后有 " + hashMap.size() + " 条收藏";
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    String str8 = "Migrate == " + ((d) it.next()).a.a;
                }
            }
            ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
            Collections.sort(arrayList222, new e(null));
            MatrixCursor matrixCursor22 = new MatrixCursor(f7411c, 50);
            int i222 = 0;
            for (d dVar2 : arrayList222) {
                c(matrixCursor22, i222, dVar2);
                i222++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeV.objValue;
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            boolean z = a;
            c.a.r0.a.y1.b.e.c(g.class, null);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            int i2 = 1;
            if (c.a.r0.a.o2.g.h.a().getBoolean("key_first_sort", true)) {
                c.a.r0.a.o2.g.h.a().putBoolean("key_first_sort", false);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, "favorite_time DESC");
                if (query != null) {
                    try {
                        try {
                            query.moveToFirst();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            do {
                                arrayList.add(query.getString(query.getColumnIndex("app_id")));
                                arrayList2.add(Integer.valueOf(i2));
                                i2++;
                            } while (query.moveToNext());
                            w(arrayList, arrayList2);
                        } catch (Exception e2) {
                            if (a) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        c.a.r0.w.d.d(query);
                    }
                }
            }
        }
    }

    public static void v(@NonNull SwanFavorItemData swanFavorItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, swanFavorItemData) == null) || TextUtils.isEmpty(swanFavorItemData.getAppKey())) {
            return;
        }
        Uri e2 = e();
        String[] strArr = {swanFavorItemData.getAppKey()};
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_name", swanFavorItemData.getAppName());
        contentValues.put("app_icon", swanFavorItemData.getIconUrl());
        contentValues.put("app_type", Integer.valueOf(swanFavorItemData.getAppType()));
        contentValues.put("frame_type", Integer.valueOf(swanFavorItemData.getAppFrameType()));
        contentValues.put("pay_protected", Integer.valueOf(swanFavorItemData.getPayProtected()));
        if (AppRuntime.getAppContext().getContentResolver().update(e2, contentValues, "app_id = ?", strArr) > 0) {
            boolean z = a;
        }
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, list, list2)) == null) {
            if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(c.a.r0.a.c1.a.c()).h().getWritableDatabase();
                writableDatabase.beginTransaction();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    try {
                        String[] strArr = {list.get(i2)};
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("sort_index", list2.get(i2));
                        if (writableDatabase.update("ai_apps_favorites", contentValues, "app_id = ?", strArr) <= 0) {
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.endTransaction();
                                } catch (Exception unused) {
                                }
                            }
                            return false;
                        }
                    } catch (Exception unused2) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.endTransaction();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused5) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

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
            this.a = new c(null);
        }

        public /* synthetic */ d(C0441a c0441a) {
            this();
        }
    }
}
