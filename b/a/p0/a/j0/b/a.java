package b.a.p0.a.j0.b;

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
import b.a.p0.a.k;
import b.a.p0.a.n0.l.b;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6538a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6539b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f6540c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.j0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0283a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public b.a.p0.a.j0.a f6541b;

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
                    super((C0283a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(C0283a c0283a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6542a;

        /* renamed from: b  reason: collision with root package name */
        public long f6543b;

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

        public /* synthetic */ c(C0283a c0283a) {
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? Long.compare(dVar2.f6544a.f6543b, dVar.f6544a.f6543b) : invokeLL.intValue;
        }

        public /* synthetic */ e(C0283a c0283a) {
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
                if (a.f6538a) {
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
                if (a.f6538a) {
                    String str = "delegate当前收藏次数：" + i2;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                int i3 = i2 + 1;
                edit.putInt("aiapps_user_fav_count", i3);
                edit.commit();
                if (a.f6538a) {
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
        public PMSAppInfo f6545b;

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
                    super((C0283a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ h(C0283a c0283a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922706054, "Lb/a/p0/a/j0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922706054, "Lb/a/p0/a/j0/b/a;");
                return;
            }
        }
        f6538a = k.f6863a;
        f6539b = Sets.newHashSet("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        f6540c = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "favorite_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", "brand", SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    public static boolean b(@NonNull SwanFavorItemData swanFavorItemData, int i2, b.a.p0.a.q0.b.a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, swanFavorItemData, i2, aVar)) == null) {
            if (i2 < 0) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j = j();
            if (j.size() == 0) {
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
            } else if (j.size() + 1 == i2) {
                if (!h(swanFavorItemData, j.get(j.size() - 1).getIndex() + 1)) {
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
                while (i3 < j.size()) {
                    int i4 = i3 + 1;
                    if (i4 == i2) {
                        swanFavorItemData.setIndex(j.get(i3).getIndex());
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
                while (i5 < j.size()) {
                    int i6 = i5 + 1;
                    if (i6 >= i2) {
                        int index = j.get(i5).getIndex() + 1;
                        j.get(i5).setIndex(index);
                        arrayList.add(j.get(i5).getAppKey());
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
                matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), bVar.f6541b.f6529a).add(SwanAppDbControl.SwanAppTable.app_key.name(), bVar.f6541b.f6530b).add(SwanAppDbControl.SwanAppTable.version.name(), bVar.f6541b.q).add(SwanAppDbControl.SwanAppTable.description.name(), bVar.f6541b.f6531c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(bVar.f6541b.f6532d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), bVar.f6541b.f6533e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), bVar.f6541b.f6534f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), bVar.f6541b.f6535g).add(SwanAppDbControl.SwanAppTable.icon.name(), bVar.f6541b.f6536h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), bVar.f6541b.f6537i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), bVar.f6541b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), bVar.f6541b.k).add(SwanAppDbControl.SwanAppTable.name.name(), bVar.f6541b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), bVar.f6541b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), bVar.f6541b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), bVar.f6541b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), bVar.f6541b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(bVar.f6541b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(bVar.f6541b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), bVar.f6541b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), bVar.f6541b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), bVar.f6541b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(bVar.f6541b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(bVar.f6541b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), bVar.f6541b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(bVar.f6541b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(bVar.f6541b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(bVar.f6541b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(bVar.f6541b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(bVar.f6541b.D ? 1 : 0)).add("favorite_time", Long.valueOf(bVar.f6544a.f6543b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(bVar.f6541b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), bVar.f6541b.F);
                return;
            }
            h hVar = (h) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(SwanAppDbControl.SwanAppTable.app_id.name(), hVar.f6545b.appId).add(SwanAppDbControl.SwanAppTable.app_key.name(), hVar.f6545b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(hVar.f6545b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), hVar.f6545b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(hVar.f6545b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), hVar.f6545b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), hVar.f6545b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), hVar.f6545b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), hVar.f6545b.iconUrl).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), hVar.f6545b.appName).add(SwanAppDbControl.SwanAppTable.service_category.name(), hVar.f6545b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), hVar.f6545b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), hVar.f6545b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(hVar.f6545b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(hVar.f6545b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(hVar.f6545b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), hVar.f6545b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(hVar.f6545b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(hVar.f6545b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(hVar.f6545b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(hVar.f6545b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("favorite_time", Long.valueOf(hVar.f6544a.f6543b)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(hVar.f6545b.payProtected)).add("customer_service", Integer.valueOf(hVar.f6545b.customerService)).add("global_notice", Integer.valueOf(hVar.f6545b.globalNotice)).add("global_private", Integer.valueOf(hVar.f6545b.globalPrivate)).add("pa_number", hVar.f6545b.paNumber).add("brand", hVar.f6545b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), hVar.f6545b.quickAppKey);
        }
    }

    public static Uri d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b.a.p0.a.j0.b.b.f6547c.buildUpon().appendPath("favorite_and_aps").build() : (Uri) invokeV.objValue;
    }

    public static Uri e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.a.p0.a.j0.b.b.f6547c.buildUpon().appendPath("favorite").build() : (Uri) invokeV.objValue;
    }

    public static Uri f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.a.p0.a.j0.b.b.f6547c.buildUpon().appendPath("favorite_with_aps_pms").build() : (Uri) invokeV.objValue;
    }

    public static boolean g(@NonNull String str, b.a.p0.a.q0.b.b bVar, b.C0322b c0322b) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, bVar, c0322b)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.c(false);
                }
                return false;
            }
            b.a.p0.a.n0.l.c m = b.a.p0.a.n0.l.c.m(c0322b);
            m.i(3);
            b.C0322b k = m.k();
            if (AppRuntime.getAppContext().getContentResolver().delete(e(), "app_id = ?", new String[]{str}) > 0) {
                boolean z = f6538a;
                if (!TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                    if (ProcessUtils.isMainProcess()) {
                        b.a.p0.a.n0.d d2 = b.a.p0.a.n0.f.c().d();
                        if (d2 != null) {
                            d2.e(str, true, k);
                        }
                    } else if (b.a.p0.a.j0.c.b.i(AppRuntime.getAppContext().getContentResolver()).contains(str) || !TextUtils.equals(b.a.p0.a.d2.d.J().r().N(), str)) {
                        b.a.p0.a.y1.c.e.a.P().Z(8, new SwanAppDeleteInfo(str).setPurgerScenes(b.a.p0.a.n0.l.c.m(k).c()));
                    }
                }
                if (f6538a) {
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
                if (f6538a) {
                    String str = "数据库收藏成功： " + swanFavorItemData.getAppKey();
                }
                b.a.p0.a.o2.g.h.a().putString("favorite_guide_count_" + swanFavorItemData.getAppKey(), "-1");
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
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(b.a.p0.a.c1.a.c()).h().getWritableDatabase();
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
                    boolean z = f6538a;
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
                    if (f6538a) {
                        e2.printStackTrace();
                    }
                }
                return arrayList;
            } finally {
                b.a.p0.w.d.d(k);
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
            if (f6538a) {
                String str = "Favotite == " + swanFavorItemData.getAppKey();
            }
            if (TextUtils.isEmpty(swanFavorItemData.getAppName()) || TextUtils.isEmpty(swanFavorItemData.getIconUrl())) {
                List<b.a.p0.a.j0.a> r = r();
                if (r.size() > 0) {
                    Iterator<b.a.p0.a.j0.a> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b.a.p0.a.j0.a next = it.next();
                        if (TextUtils.equals(swanFavorItemData.getAppKey(), next.f6529a)) {
                            swanFavorItemData.setAppKey(next.f6529a);
                            swanFavorItemData.setAppName(next.l);
                            swanFavorItemData.setIconUrl(next.f6537i);
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
                        if (f6538a) {
                            e.printStackTrace();
                        }
                        z = z2;
                        if (f6538a) {
                        }
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (f6538a) {
                String str2 = "小程序： " + str + "是否在收藏列表中：" + z;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, int i2, b.a.p0.a.q0.b.a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, str, i2, aVar)) == null) {
            if (TextUtils.isEmpty(str) || i2 < 1) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            List<SwanFavorItemData> j = j();
            if (j.size() < i2) {
                if (aVar != null) {
                    aVar.b(false);
                }
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < j.size()) {
                int i4 = i3 + 1;
                if (i4 == i2) {
                    arrayList.add(str);
                    arrayList2.add(Integer.valueOf(j.get(i3).getIndex()));
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
            while (i5 < j.size()) {
                int i6 = i5 + 1;
                if (i6 >= i2 && !TextUtils.equals(j.get(i5).getAppKey(), str)) {
                    arrayList2.add(Integer.valueOf(j.get(i5).getIndex() + 1));
                    arrayList.add(j.get(i5).getAppKey());
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
                        if (f6538a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    b.a.p0.w.d.d(k);
                }
            }
        }
    }

    @NonNull
    public static List<b.a.p0.a.j0.a> r() {
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
                                b.a.p0.a.j0.a aVar = new b.a.p0.a.j0.a();
                                SwanAppDbControl.f(AppRuntime.getAppContext()).s(s, aVar);
                                if (!TextUtils.isEmpty(aVar.f6529a)) {
                                    arrayList.add(aVar);
                                }
                            } while (s.moveToNext());
                        }
                    } catch (Exception e2) {
                        if (f6538a) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    b.a.p0.w.d.d(s);
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
                    b.a.p0.a.j0.a aVar = new b.a.p0.a.j0.a();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(query2, aVar);
                    if (!TextUtils.isEmpty(aVar.f6529a)) {
                        b bVar = new b(null);
                        bVar.f6541b = aVar;
                        c cVar = bVar.f6544a;
                        cVar.f6542a = aVar.f6529a;
                        cVar.f6543b = query2.getLong(query2.getColumnIndex("favorite_time"));
                        hashMap.put(bVar.f6544a.f6542a, bVar);
                        if (f6538a) {
                            String str = "Aps&Favotite == " + aVar.f6529a;
                        }
                    }
                } while (query2.moveToNext());
                b.a.p0.w.d.d(query2);
                if (f6538a) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                b.a.p0.w.d.d(query);
                if (f6538a) {
                }
                ArrayList<d> arrayList = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6538a) {
                }
                while (r1.hasNext()) {
                }
                if (f6538a) {
                }
                ArrayList<d> arrayList2 = new ArrayList(hashMap.values());
                Collections.sort(arrayList2, new e(null));
                MatrixCursor matrixCursor = new MatrixCursor(f6540c, 50);
                int i2 = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor;
            }
            b.a.p0.w.d.d(query2);
            if (f6538a) {
                String str2 = "^ Aps & Favorite 查询到 " + hashMap.size() + " 条收藏";
            }
            query = AppRuntime.getAppContext().getContentResolver().query(e(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    c cVar2 = new c(null);
                    cVar2.f6542a = query.getString(query.getColumnIndex("app_id"));
                    cVar2.f6543b = query.getLong(query.getColumnIndex("favorite_time"));
                    hashMap22.put(cVar2.f6542a, cVar2);
                    if (f6538a) {
                        String str3 = "Favotite == " + cVar2.f6542a;
                    }
                } while (query.moveToNext());
                b.a.p0.w.d.d(query);
                if (f6538a) {
                }
                ArrayList<d> arrayList3 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (f6538a) {
                }
                while (r1.hasNext()) {
                }
                if (f6538a) {
                }
                ArrayList<d> arrayList22 = new ArrayList(hashMap.values());
                Collections.sort(arrayList22, new e(null));
                MatrixCursor matrixCursor2 = new MatrixCursor(f6540c, 50);
                int i22 = 0;
                while (r1.hasNext()) {
                }
                return matrixCursor2;
            }
            b.a.p0.w.d.d(query);
            if (f6538a) {
                String str4 = "^ Favorite 库查询到 " + hashMap22.size() + " 条收藏";
            }
            ArrayList<d> arrayList32 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(b.a.p0.q.g.a.i().v().values())) {
                if (f6538a) {
                    String str5 = "Pms == " + pMSAppInfo.appId;
                }
                if (hashMap22.containsKey(pMSAppInfo.appId)) {
                    h hVar = new h(null);
                    hVar.f6544a = (c) hashMap22.get(pMSAppInfo.appId);
                    hVar.f6545b = pMSAppInfo;
                    arrayList32.add(hVar);
                }
            }
            if (f6538a) {
                String str6 = "^ Pms & Favorite 查询到 " + arrayList32.size() + " 条收藏";
            }
            for (d dVar : arrayList32) {
                hashMap.put(dVar.f6544a.f6542a, dVar);
            }
            if (f6538a) {
                String str7 = "合并后有 " + hashMap.size() + " 条收藏";
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    String str8 = "Migrate == " + ((d) it.next()).f6544a.f6542a;
                }
            }
            ArrayList<d> arrayList222 = new ArrayList(hashMap.values());
            Collections.sort(arrayList222, new e(null));
            MatrixCursor matrixCursor22 = new MatrixCursor(f6540c, 50);
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
            boolean z = f6538a;
            b.a.p0.a.y1.b.e.c(g.class, null);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            int i2 = 1;
            if (b.a.p0.a.o2.g.h.a().getBoolean("key_first_sort", true)) {
                b.a.p0.a.o2.g.h.a().putBoolean("key_first_sort", false);
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
                            if (f6538a) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        b.a.p0.w.d.d(query);
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
            boolean z = f6538a;
        }
    }

    public static boolean w(List<String> list, List<Integer> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, list, list2)) == null) {
            if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
                SQLiteDatabase writableDatabase = SwanAppDbControl.f(b.a.p0.a.c1.a.c()).h().getWritableDatabase();
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

        /* renamed from: a  reason: collision with root package name */
        public c f6544a;

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
            this.f6544a = new c(null);
        }

        public /* synthetic */ d(C0283a c0283a) {
            this();
        }
    }
}
