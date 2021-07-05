package com.baidu.nps.pm.manager;

import android.app.Application;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.BundleInfoGroupManager;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.nps.utils.SourceData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.i.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes3.dex */
public class NPSPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPS-NPSPackageManager";
    public static NPSPackageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, BundleInfoGroup> mBundleInfoGroupMap;
    public Set<String> mInstallingSet;
    public boolean mIsInited;
    public Map<String, BundleInfo> mPresetInfoMap;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IInstallCallback f9020f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f9021g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9022h;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0132a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f9023a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0132a(a aVar, Handler handler) {
                super(handler);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, handler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Handler) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9023a = aVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    d.a.d0.i.g a2 = j.a(uri);
                    if (a2.f45304b > 0 || a2.f45303a > 0) {
                        this.f9023a.f9020f.onProgress(a2.f45303a, a2.f45304b);
                    }
                }
            }
        }

        public a(NPSPackageManager nPSPackageManager, String str, IInstallCallback iInstallCallback, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, iInstallCallback, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9022h = nPSPackageManager;
            this.f9019e = str;
            this.f9020f = iInstallCallback;
            this.f9021g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Uri e2 = j.e(this.f9019e);
                C0132a c0132a = new C0132a(this, null);
                ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, c0132a);
                int installBundle = this.f9022h.installBundle(this.f9019e, this.f9021g);
                this.f9022h.mInstallingSet.remove(this.f9019e);
                ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(c0132a);
                if (this.f9020f != null) {
                    if (d.a.d0.i.b.a()) {
                        Log.i(NPSPackageManager.TAG, "installBundle, retCode=" + installBundle);
                    }
                    this.f9020f.onResult(installBundle, "");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.d.a.a f9024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9025f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9026g;

        /* loaded from: classes3.dex */
        public class a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f9027a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Handler handler) {
                super(handler);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Handler) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9027a = bVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    d.a.d0.i.g a2 = j.a(uri);
                    if (this.f9027a.f9024e != null) {
                        if (a2.f45304b > 0 || a2.f45303a > 0) {
                            this.f9027a.f9024e.onProgress(a2.f45303a, a2.f45304b);
                        }
                    }
                }
            }
        }

        public b(NPSPackageManager nPSPackageManager, d.a.d0.d.a.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9026g = nPSPackageManager;
            this.f9024e = aVar;
            this.f9025f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = null;
                if (this.f9024e != null) {
                    Uri d2 = j.d(this.f9025f);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d2, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.f9026g.downloadBundle(this.f9025f);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                d.a.d0.d.a.a aVar3 = this.f9024e;
                if (aVar3 != null) {
                    aVar3.onResult(downloadBundle, "");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9028e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9029f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.d.a.a f9030g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9031h;

        public c(NPSPackageManager nPSPackageManager, String str, int i2, d.a.d0.d.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9031h = nPSPackageManager;
            this.f9028e = str;
            this.f9029f = i2;
            this.f9030g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9031h.getBundleStatus(this.f9028e) == 44) {
                    if (this.f9029f == 0) {
                        d.a.d0.g.a.b.i().c(this.f9031h.getUpdateBundle(this.f9028e));
                        return;
                    } else if (!d.a.d0.i.d.b(ContextHolder.getApplicationContext())) {
                        d.a.d0.g.a.b.i().c(this.f9031h.getUpdateBundle(this.f9028e));
                        d.a.d0.d.a.a aVar = this.f9030g;
                        if (aVar != null) {
                            aVar.onResult(51, this.f9031h.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                        }
                        if (d.a.d0.i.b.a()) {
                            Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.f9031h.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                            return;
                        }
                        return;
                    } else {
                        this.f9031h.downloadBundle(this.f9028e, this.f9030g, 48);
                        return;
                    }
                }
                d.a.d0.d.a.a aVar2 = this.f9030g;
                if (aVar2 != null) {
                    aVar2.onResult(3, this.f9031h.getDownloadMessage(d.a.d0.a.predownload_no_available_msg));
                }
                if (d.a.d0.i.b.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + this.f9031h.getDownloadMessage(d.a.d0.a.predownload_no_available_msg));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.d.a.a f9033f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f9034g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.f.a f9035h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9036i;

        /* loaded from: classes3.dex */
        public class a implements d.a.d0.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BundleInfo f9037a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f9038b;

            public a(d dVar, BundleInfo bundleInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bundleInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9038b = dVar;
                this.f9037a = bundleInfo;
            }

            @Override // d.a.d0.f.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        d dVar = this.f9038b;
                        dVar.f9036i.downloadBundle(dVar.f9032e, dVar.f9033f, 48);
                        return;
                    }
                    d.a.d0.g.a.b.i().c(this.f9037a);
                    d dVar2 = this.f9038b;
                    d.a.d0.d.a.a aVar = dVar2.f9033f;
                    if (aVar != null) {
                        aVar.onResult(51, dVar2.f9036i.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                    }
                    if (d.a.d0.i.b.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.f9038b.f9036i.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                    }
                }
            }
        }

        public d(NPSPackageManager nPSPackageManager, String str, d.a.d0.d.a.a aVar, int i2, d.a.d0.f.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, aVar, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9036i = nPSPackageManager;
            this.f9032e = str;
            this.f9033f = aVar;
            this.f9034g = i2;
            this.f9035h = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BundleInfo updateBundle = this.f9036i.getUpdateBundle(this.f9032e);
                if (updateBundle == null) {
                    d.a.d0.d.a.a aVar = this.f9033f;
                    if (aVar != null) {
                        aVar.onResult(3, this.f9036i.getDownloadMessage(d.a.d0.a.predownload_no_available_msg));
                    }
                    if (d.a.d0.i.b.a()) {
                        Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + this.f9036i.getDownloadMessage(d.a.d0.a.predownload_no_available_msg));
                    }
                } else if (this.f9034g == 1) {
                    if (d.a.d0.i.d.b(ContextHolder.getApplicationContext())) {
                        this.f9036i.downloadBundle(this.f9032e);
                    } else {
                        this.f9035h.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                    }
                } else {
                    d.a.d0.g.a.b.i().c(updateBundle);
                    d.a.d0.d.a.a aVar2 = this.f9033f;
                    if (aVar2 != null) {
                        aVar2.onResult(51, this.f9036i.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                    }
                    if (d.a.d0.i.b.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.f9036i.getDownloadMessage(d.a.d0.a.predownload_net_error_msg));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(NPSPackageManager nPSPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d0.g.a.b.i().b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9039a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f9040e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f9041f;

            public a(f fVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9041f = fVar;
                this.f9040e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9041f.f9039a.updateBundleInfos(this.f9040e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(NPSPackageManager nPSPackageManager, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9039a = nPSPackageManager;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                d.a.d0.c.a.g.a().b().run(new a(this, uri));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9042e;

        public g(NPSPackageManager nPSPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9042e = nPSPackageManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle o;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (o = d.a.d0.g.a.b.i().o()) != null && o.getInt(Constant.TAG.RET_CODE, -1) == 13) {
                ArrayList parcelableArrayList = o.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = o.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        this.f9042e.updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9043e;

        public h(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9043e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9043e.countDown();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f9045f;

        public i(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9045f = nPSPackageManager;
            this.f9044e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9045f.killProcessesWithPluginsRunning();
                this.f9044e.countDown();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1252040331, "Lcom/baidu/nps/pm/manager/NPSPackageManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1252040331, "Lcom/baidu/nps/pm/manager/NPSPackageManager;");
                return;
            }
        }
        sInstance = new NPSPackageManager();
    }

    public NPSPackageManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsInited = false;
        this.mBundleInfoGroupMap = new HashMap();
        this.mPresetInfoMap = new HashMap();
        this.mInstallingSet = new CopyOnWriteArraySet();
    }

    private boolean checkPresetBundleWithDownload(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, bundleInfo)) == null) ? hasValidPresetBundle(bundleInfo.getPackageName()) && this.mPresetInfoMap.get(bundleInfo.getPackageName()).getVersionCode() >= bundleInfo.getVersionCode() : invokeL.booleanValue;
    }

    private void clearDeprecatedBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (BundleInfo bundleInfo : d.a.d0.e.a.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            d.a.d0.g.a.b.i().a(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int downloadBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return 26;
            }
            BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
            if (bundleByType == null) {
                return 3;
            }
            if (checkPresetBundleWithDownload(bundleByType)) {
                return 2;
            }
            Bundle d2 = d.a.d0.g.a.b.i().d(bundleByType);
            if (d2 == null) {
                return 31;
            }
            int i2 = d2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 2) {
                ContentValues contentValues = (ContentValues) d2.getParcelable(Constant.TAG.RET_VALUE);
                long j = d2.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? d.a.d0.g.a.b.i().g(str) : (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            try {
                Application applicationContext = ContextHolder.getApplicationContext();
                return applicationContext != null ? applicationContext.getString(i2) : "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static NPSPackageManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? sInstance : (NPSPackageManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BundleInfo getUpdateBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return null;
            }
            return bundleInfoGroup.getBundleByType(1);
        }
        return (BundleInfo) invokeL.objValue;
    }

    private boolean hasValidDownloadedBundle(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleInfo2 = null;
            if (bundleInfoGroup != null) {
                bundleInfo2 = bundleInfoGroup.getBundleByType(2);
                bundleInfo = bundleInfoGroup.getBundleByType(3);
            } else {
                bundleInfo = null;
            }
            if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < d.a.d0.e.a.b().c(str)) {
                return false;
            }
            return bundleInfo2.getVersionCode() > (bundleInfo == null ? 0 : bundleInfo.getVersionCode());
        }
        return invokeL.booleanValue;
    }

    private boolean hasValidInstalledBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
            return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < d.a.d0.e.a.b().c(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private boolean hasValidPresetBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            initIfNeed();
            BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
            if (bundleInfo != null && bundleInfo.getVersionCode() >= d.a.d0.e.a.b().c(str)) {
                return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void initBundleInfoFromDB(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j) == null) {
            this.mBundleInfoGroupMap = d.a.d0.g.a.b.i().f(j);
        }
    }

    private synchronized void initIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            synchronized (this) {
                if (!this.mIsInited) {
                    init();
                }
            }
        }
    }

    private int initPresetInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            Bundle j = d.a.d0.g.a.b.i().j();
            if (j == null) {
                return 32;
            }
            int i2 = j.getInt(Constant.TAG.RET_CODE, -1);
            ArrayList parcelableArrayList = j.getParcelableArrayList(Constant.TAG.RET_VALUE);
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    BundleInfo bundleInfo = BundleInfo.toBundleInfo((ContentValues) ((Parcelable) it.next()));
                    this.mPresetInfoMap.put(bundleInfo.getPackageName(), bundleInfo);
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int installBundle(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, this, str, i2)) == null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(str);
            return installBundle(bundleInfo, i2);
        }
        return invokeLI.intValue;
    }

    private int installBundleOnly(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, bundleInfo)) == null) {
            Bundle l = d.a.d0.g.a.b.i().l(bundleInfo);
            if (l == null) {
                return 28;
            }
            int i2 = l.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) l.getParcelable(Constant.TAG.RET_VALUE);
                long j = l.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private void installPreset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            d.a.d0.c.a.g.a().b().run(new g(this));
        }
    }

    private boolean isForbidden(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return false;
            }
            BundleInfo bundleByType = bundleInfoGroup.getBundleByType(3);
            if (bundleByType == null || bundleByType.isForbidden()) {
                BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
                if (bundleByType2 == null || bundleByType2.isForbidden()) {
                    BundleInfo bundleByType3 = bundleInfoGroup.getBundleByType(1);
                    if (bundleByType3 == null || bundleByType3.isForbidden()) {
                        return (bundleByType == null && bundleByType2 == null && bundleByType3 == null) ? false : true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isValidPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, this, str)) == null) ? d.a.d0.e.a.b().c(str) != -1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Intent intent = new Intent(d.a.d0.i.a.f45301a);
            intent.setPackage(ContextHolder.getApplicationContext().getPackageName());
            ContextHolder.getApplicationContext().sendBroadcast(intent);
        }
    }

    private boolean needForceUpdate(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleInfo2 = null;
            if (bundleInfoGroup != null) {
                BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                bundleInfo2 = bundleInfoGroup.getBundleByType(3);
                bundleInfo = bundleByType;
            } else {
                bundleInfo = null;
            }
            return bundleInfo != null && bundleInfo.needForceUpdate() && bundleInfo.getVersionCode() > (bundleInfo2 == null ? 0 : bundleInfo2.getVersionCode());
        }
        return invokeL.booleanValue;
    }

    private void registerObsever() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            d.a.d0.g.a.b.i().r(true, new f(this, new Handler(Looper.getMainLooper())));
        }
    }

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            d.a.d0.c.a.a.a().c(applicationContext.getString(d.a.d0.a.alert_title_force_update), applicationContext.getString(d.a.d0.a.alert_msg_force_update), new h(this, countDownLatch), applicationContext.getString(d.a.d0.a.alert_force_update_negative_msg), new i(this, countDownLatch), applicationContext.getString(d.a.d0.a.alert_force_update_positive_msg));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateBundleInfo(BundleInfo bundleInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65570, this, bundleInfo, j) == null) {
            synchronized (this) {
                BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(bundleInfo.getPackageName());
                long j2 = 0;
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j);
                    this.mBundleInfoGroupMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                } else {
                    j2 = bundleInfoGroup.getTimeStamp();
                }
                if (j > j2) {
                    bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
                }
            }
        }
    }

    private synchronized void updateBundleInfos(List<BundleInfo> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65572, this, list, j) == null) {
            synchronized (this) {
                for (BundleInfo bundleInfo : list) {
                    updateBundleInfo(bundleInfo, j);
                }
            }
        }
    }

    public void downloadAllBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.d0.c.a.g.a().b().run(new e(this));
        }
    }

    public void downloadUpdatePackage(String str, d.a.d0.d.a.a aVar, d.a.d0.f.a aVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, str, aVar, aVar2, i2) == null) {
            d.a.d0.c.a.g.a().b().run(new d(this, str, aVar, i2, aVar2));
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bundle e2 = d.a.d0.g.a.b.i().e();
            if (e2 == null) {
                return 30;
            }
            int i2 = e2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 0) {
                ArrayList parcelableArrayList = e2.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = e2.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            initIfNeed();
            return this.mBundleInfoGroupMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroupForLogSystem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? BundleInfoGroupManager.toBundleInfoGroups(d.a.d0.g.a.a.c(ContextHolder.getApplicationContext()).e(), System.currentTimeMillis()) : (Map) invokeV.objValue;
    }

    public BundleInfoGroup getBundleGroup(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            initIfNeed();
            return this.mBundleInfoGroupMap.get(str);
        }
        return (BundleInfoGroup) invokeL.objValue;
    }

    public BundleInfo getBundleInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return null;
            }
            return bundleInfoGroup.getBundleByType(3);
        }
        return (BundleInfo) invokeL.objValue;
    }

    public int getBundleStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=5");
                    return 5;
                }
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=15");
                    return 15;
                }
                return 15;
            } else if (needForceUpdate(str)) {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else if (hasValidInstalledBundle(str)) {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else {
                if (d.a.d0.i.b.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            }
        }
        return invokeL.intValue;
    }

    public String getPackageNameFromComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            initIfNeed();
            return d.a.d0.e.a.b().e(str);
        }
        return (String) invokeL.objValue;
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.mIsInited) {
                    return;
                }
                d.a.d0.e.a.b().f();
                clearDeprecatedBundles();
                registerObsever();
                initBundleInfoFromDB(System.currentTimeMillis());
                initPresetInfo();
                installPreset();
                this.mIsInited = true;
            }
        }
    }

    public int installBundleForDebug(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (new File(str).exists()) {
                PackageInfo a2 = d.a.d0.i.e.a(str, 128);
                if (a2 == null) {
                    return 8;
                }
                BundleInfo bundleInfo = new BundleInfo();
                bundleInfo.setPackageName(a2.packageName);
                bundleInfo.setVersionCode(a2.versionCode);
                bundleInfo.setApkPath(str);
                return installLocalBundle(bundleInfo);
            }
            return 7;
        }
        return invokeL.intValue;
    }

    public int installLocalBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundleInfo)) == null) {
            Bundle m = d.a.d0.g.a.b.i().m(bundleInfo);
            if (m == null) {
                return 29;
            }
            int i2 = m.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) m.getParcelable(Constant.TAG.RET_VALUE);
                long j = m.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? d.a.d0.g.a.b.i().p(str) : invokeL.booleanValue;
    }

    public void preDownload(String str, d.a.d0.d.a.a aVar, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048593, this, str, aVar, i2, sourceData) == null) {
            d.a.d0.c.a.g.a().b().run(new c(this, str, i2, aVar));
        }
    }

    public int prepareBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? prepareBundle(str, 0) : invokeL.intValue;
    }

    public void recordBundleRunning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            d.a.d0.g.a.b.i().q(str);
        }
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, bundleInfo)) == null) {
            Bundle n = d.a.d0.g.a.b.i().n(bundleInfo);
            if (n == null) {
                return 33;
            }
            int i2 = n.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                BundleInfo bundleInfo2 = BundleInfo.toBundleInfo((ContentValues) n.getParcelable(Constant.TAG.RET_VALUE));
                long j = n.getLong("time_stamp");
                if (bundleInfo2 != null) {
                    updateBundleInfo(bundleInfo2, j);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public int prepareBundle(String str, int i2) {
        InterceptResult invokeLI;
        int installPreset;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, str, i2)) == null) {
            initIfNeed();
            if (isValidPackageName(str)) {
                if (isForbidden(str)) {
                    return 42;
                }
                if (needForceUpdate(str)) {
                    return 44;
                }
                if (hasValidPresetBundle(str) || hasValidDownloadedBundle(str) || hasValidInstalledBundle(str)) {
                    if (hasValidInstalledBundle(str) || !hasValidPresetBundle(str) || (installPreset = installPreset(this.mPresetInfoMap.get(str))) == 13) {
                        if (hasValidDownloadedBundle(str)) {
                            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
                            if (bundleInfoGroup == null) {
                                return 25;
                            }
                            BundleInfo bundleByType = bundleInfoGroup.getBundleByType(2);
                            if (bundleByType == null) {
                                return hasValidInstalledBundle(str) ? 41 : 23;
                            }
                            int installBundleOnly = installBundleOnly(bundleByType);
                            if (installBundleOnly == 50) {
                                if (bundleByType.needForceUpdate() && (i2 & 16) == 1) {
                                    sendResartAlert();
                                    return installBundleOnly;
                                }
                            } else if (installBundleOnly != 13) {
                                return installBundleOnly;
                            }
                        }
                        return hasValidInstalledBundle(str) ? 41 : 45;
                    }
                    return installPreset;
                }
                return 44;
            }
            return 15;
        }
        return invokeLI.intValue;
    }

    private int installBundle(BundleInfo bundleInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, this, bundleInfo, i2)) == null) {
            Bundle k = d.a.d0.g.a.b.i().k(bundleInfo);
            if (k == null) {
                return 27;
            }
            int i3 = k.getInt(Constant.TAG.RET_CODE, -1);
            if (i3 == 13) {
                ContentValues contentValues = (ContentValues) k.getParcelable(Constant.TAG.RET_VALUE);
                long j = k.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            } else if (i3 == 50) {
                int i4 = i2 & 16;
                if (i4 == 0) {
                    return 13;
                }
                BundleInfo bundleByType = getBundleGroup(bundleInfo.getPackageName()).getBundleByType(2);
                if (bundleByType != null && bundleByType.needForceUpdate() && i4 == 1) {
                    sendResartAlert();
                }
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBundleInfos(Uri uri) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, uri) == null) || uri == null) {
            return;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2) {
            return;
        }
        String str = pathSegments.get(0);
        try {
            j = Long.parseLong(pathSegments.get(1));
        } catch (NumberFormatException e2) {
            d.a.d0.c.a.f.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
            j = 0L;
        }
        if ("all".equalsIgnoreCase(str)) {
            initBundleInfoFromDB(j);
            return;
        }
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
            this.mBundleInfoGroupMap.put(str, d.a.d0.g.a.b.i().h(str, j));
        }
    }

    public void downloadBundle(String str, d.a.d0.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null) {
            return;
        }
        downloadBundle(str, aVar, 48);
    }

    public void downloadBundle(String str, d.a.d0.d.a.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, aVar, i2) == null) {
            d.a.d0.c.a.g.a().b().run(new b(this, aVar, str));
        }
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, iInstallCallback) == null) {
            installBundle(str, 0, iInstallCallback);
        }
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048588, this, str, i2, iInstallCallback) == null) {
            synchronized (this) {
                if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
                    if (d.a.d0.i.b.a()) {
                        Log.i(TAG, "installBundle, retCode=34");
                    }
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                d.a.d0.c.a.g.a().b().run(new a(this, str, iInstallCallback, i2));
            }
        }
    }
}
