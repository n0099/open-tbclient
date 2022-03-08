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
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.BundleInfoGroupManager;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.nps.utils.SourceData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public class NPSPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPS-NPSPackageManager";
    public static NPSPackageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, BundleInfoGroup> mBundleInfoGroupMap;
    public Set<String> mInstallingSet;
    public boolean mIsInited;
    public Map<String, BundleInfo> mPresetInfoMap;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f36085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IInstallCallback f36086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36088h;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1822a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1822a(a aVar, Handler handler) {
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
                this.a = aVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    c.a.c0.h.g a = j.a(uri);
                    if (a.f2369b > 0 || a.a > 0) {
                        this.a.f36086f.onProgress(a.a, a.f2369b);
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
            this.f36088h = nPSPackageManager;
            this.f36085e = str;
            this.f36086f = iInstallCallback;
            this.f36087g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Uri e2 = j.e(this.f36085e);
                C1822a c1822a = new C1822a(this, null);
                ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, c1822a);
                int installBundle = this.f36088h.installBundle(this.f36085e, this.f36087g);
                this.f36088h.mInstallingSet.remove(this.f36085e);
                ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(c1822a);
                if (this.f36086f != null) {
                    if (c.a.c0.h.b.a()) {
                        String str = "installBundle, retCode=" + installBundle;
                    }
                    this.f36086f.onResult(installBundle, "");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.c.a.a f36089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f36090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36091g;

        /* loaded from: classes4.dex */
        public class a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = bVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    c.a.c0.h.g a = j.a(uri);
                    if (this.a.f36089e != null) {
                        if (a.f2369b > 0 || a.a > 0) {
                            this.a.f36089e.onProgress(a.a, a.f2369b);
                        }
                    }
                }
            }
        }

        public b(NPSPackageManager nPSPackageManager, c.a.c0.c.a.a aVar, String str) {
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
            this.f36091g = nPSPackageManager;
            this.f36089e = aVar;
            this.f36090f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = null;
                if (this.f36089e != null) {
                    Uri d2 = j.d(this.f36090f);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d2, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.f36091g.downloadBundle(this.f36090f);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                c.a.c0.c.a.a aVar3 = this.f36089e;
                if (aVar3 != null) {
                    aVar3.onResult(downloadBundle, "");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f36092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36093f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.c.a.a f36094g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36095h;

        public c(NPSPackageManager nPSPackageManager, String str, int i2, c.a.c0.c.a.a aVar) {
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
            this.f36095h = nPSPackageManager;
            this.f36092e = str;
            this.f36093f = i2;
            this.f36094g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f36095h.getBundleStatus(this.f36092e) == 44) {
                    if (this.f36093f == 0) {
                        c.a.c0.f.a.b.i().c(this.f36095h.getUpdateBundle(this.f36092e));
                        return;
                    } else if (!c.a.c0.h.d.b(ContextHolder.getApplicationContext())) {
                        c.a.c0.f.a.b.i().c(this.f36095h.getUpdateBundle(this.f36092e));
                        c.a.c0.c.a.a aVar = this.f36094g;
                        if (aVar != null) {
                            aVar.onResult(51, this.f36095h.getDownloadMessage(R.string.predownload_net_error_msg));
                        }
                        if (c.a.c0.h.b.a()) {
                            String str = "preDownload, retCode=51，message = " + this.f36095h.getDownloadMessage(R.string.predownload_net_error_msg);
                            return;
                        }
                        return;
                    } else {
                        this.f36095h.downloadBundle(this.f36092e, this.f36094g, 48);
                        return;
                    }
                }
                c.a.c0.c.a.a aVar2 = this.f36094g;
                if (aVar2 != null) {
                    aVar2.onResult(3, this.f36095h.getDownloadMessage(R.string.predownload_no_available_msg));
                }
                if (c.a.c0.h.b.a()) {
                    String str2 = "preDownload, retCode=3，message = " + this.f36095h.getDownloadMessage(R.string.predownload_no_available_msg);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f36096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.c.a.a f36097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36098g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.e.a f36099h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36100i;

        /* loaded from: classes4.dex */
        public class a implements c.a.c0.e.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BundleInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f36101b;

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
                this.f36101b = dVar;
                this.a = bundleInfo;
            }

            @Override // c.a.c0.e.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        d dVar = this.f36101b;
                        dVar.f36100i.downloadBundle(dVar.f36096e, dVar.f36097f, 48);
                        return;
                    }
                    c.a.c0.f.a.b.i().c(this.a);
                    d dVar2 = this.f36101b;
                    c.a.c0.c.a.a aVar = dVar2.f36097f;
                    if (aVar != null) {
                        aVar.onResult(51, dVar2.f36100i.getDownloadMessage(R.string.predownload_net_error_msg));
                    }
                    if (c.a.c0.h.b.a()) {
                        String str = "preDownload, retCode=51，message = " + this.f36101b.f36100i.getDownloadMessage(R.string.predownload_net_error_msg);
                    }
                }
            }
        }

        public d(NPSPackageManager nPSPackageManager, String str, c.a.c0.c.a.a aVar, int i2, c.a.c0.e.a aVar2) {
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
            this.f36100i = nPSPackageManager;
            this.f36096e = str;
            this.f36097f = aVar;
            this.f36098g = i2;
            this.f36099h = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BundleInfo updateBundle = this.f36100i.getUpdateBundle(this.f36096e);
                if (updateBundle == null) {
                    c.a.c0.c.a.a aVar = this.f36097f;
                    if (aVar != null) {
                        aVar.onResult(3, this.f36100i.getDownloadMessage(R.string.predownload_no_available_msg));
                    }
                    if (c.a.c0.h.b.a()) {
                        String str = "update, retCode=3,message = " + this.f36100i.getDownloadMessage(R.string.predownload_no_available_msg);
                    }
                } else if (this.f36098g == 1) {
                    if (c.a.c0.h.d.b(ContextHolder.getApplicationContext())) {
                        this.f36100i.downloadBundle(this.f36096e);
                    } else {
                        this.f36099h.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                    }
                } else {
                    c.a.c0.f.a.b.i().c(updateBundle);
                    c.a.c0.c.a.a aVar2 = this.f36097f;
                    if (aVar2 != null) {
                        aVar2.onResult(51, this.f36100i.getDownloadMessage(R.string.predownload_net_error_msg));
                    }
                    if (c.a.c0.h.b.a()) {
                        String str2 = "preDownload, retCode=51，message = " + this.f36100i.getDownloadMessage(R.string.predownload_net_error_msg);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                c.a.c0.f.a.b.i().b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NPSPackageManager a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f36102e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f36103f;

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
                this.f36103f = fVar;
                this.f36102e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f36103f.a.updateBundleInfos(this.f36102e);
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
            this.a = nPSPackageManager;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                c.a.c0.b.a.g.a().b().run(new a(this, uri));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36104e;

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
            this.f36104e = nPSPackageManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle o;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (o = c.a.c0.f.a.b.i().o()) != null && o.getInt(Constant.TAG.RET_CODE, -1) == 13) {
                ArrayList parcelableArrayList = o.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j2 = o.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        this.f36104e.updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f36105e;

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
            this.f36105e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36105e.countDown();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f36106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NPSPackageManager f36107f;

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
            this.f36107f = nPSPackageManager;
            this.f36106e = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36107f.killProcessesWithPluginsRunning();
                this.f36106e.countDown();
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
            for (BundleInfo bundleInfo : c.a.c0.d.a.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            c.a.c0.f.a.b.i().a(bundle);
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
            Bundle d2 = c.a.c0.f.a.b.i().d(bundleByType);
            if (d2 == null) {
                return 31;
            }
            int i2 = d2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 2) {
                ContentValues contentValues = (ContentValues) d2.getParcelable(Constant.TAG.RET_VALUE);
                long j2 = d2.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j2);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? c.a.c0.f.a.b.i().g(str) : (List) invokeL.objValue;
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
            if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < c.a.c0.d.a.b().c(str)) {
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
            return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < c.a.c0.d.a.b().c(str)) ? false : true;
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
            if (bundleInfo != null && bundleInfo.getVersionCode() >= c.a.c0.d.a.b().c(str)) {
                return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void initBundleInfoFromDB(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j2) == null) {
            this.mBundleInfoGroupMap = c.a.c0.f.a.b.i().f(j2);
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
            Bundle j2 = c.a.c0.f.a.b.i().j();
            if (j2 == null) {
                return 32;
            }
            int i2 = j2.getInt(Constant.TAG.RET_CODE, -1);
            ArrayList parcelableArrayList = j2.getParcelableArrayList(Constant.TAG.RET_VALUE);
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
            Bundle l = c.a.c0.f.a.b.i().l(bundleInfo);
            if (l == null) {
                return 28;
            }
            int i2 = l.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) l.getParcelable(Constant.TAG.RET_VALUE);
                long j2 = l.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j2);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private void installPreset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            c.a.c0.b.a.g.a().b().run(new g(this));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, this, str)) == null) ? c.a.c0.d.a.b().c(str) != -1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Intent intent = new Intent(c.a.c0.h.a.a);
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
            c.a.c0.f.a.b.i().r(true, new f(this, new Handler(Looper.getMainLooper())));
        }
    }

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            c.a.c0.b.a.a.a().c(applicationContext.getString(R.string.alert_title_force_update), applicationContext.getString(R.string.alert_msg_force_update), new h(this, countDownLatch), applicationContext.getString(R.string.alert_force_update_negative_msg), new i(this, countDownLatch), applicationContext.getString(R.string.alert_force_update_positive_msg));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateBundleInfo(BundleInfo bundleInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65570, this, bundleInfo, j2) == null) {
            synchronized (this) {
                BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(bundleInfo.getPackageName());
                long j3 = 0;
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j2);
                    this.mBundleInfoGroupMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                } else {
                    j3 = bundleInfoGroup.getTimeStamp();
                }
                if (j2 > j3) {
                    bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
                }
            }
        }
    }

    private synchronized void updateBundleInfos(List<BundleInfo> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65572, this, list, j2) == null) {
            synchronized (this) {
                for (BundleInfo bundleInfo : list) {
                    updateBundleInfo(bundleInfo, j2);
                }
            }
        }
    }

    public void downloadAllBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.c0.b.a.g.a().b().run(new e(this));
        }
    }

    public void downloadUpdatePackage(String str, c.a.c0.c.a.a aVar, c.a.c0.e.a aVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, str, aVar, aVar2, i2) == null) {
            c.a.c0.b.a.g.a().b().run(new d(this, str, aVar, i2, aVar2));
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bundle e2 = c.a.c0.f.a.b.i().e();
            if (e2 == null) {
                return 30;
            }
            int i2 = e2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 0) {
                ArrayList parcelableArrayList = e2.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j2 = e2.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? BundleInfoGroupManager.toBundleInfoGroups(c.a.c0.f.a.a.b(ContextHolder.getApplicationContext()).c(), System.currentTimeMillis()) : (Map) invokeV.objValue;
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
                c.a.c0.h.b.a();
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                c.a.c0.h.b.a();
                return 15;
            } else if (needForceUpdate(str)) {
                c.a.c0.h.b.a();
                return 44;
            } else if (hasValidInstalledBundle(str)) {
                c.a.c0.h.b.a();
                return 43;
            } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
                c.a.c0.h.b.a();
                return 44;
            } else {
                c.a.c0.h.b.a();
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
            return c.a.c0.d.a.b().e(str);
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
                c.a.c0.d.a.b().f();
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
                PackageInfo a2 = c.a.c0.h.e.a(str, 128);
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
            Bundle m = c.a.c0.f.a.b.i().m(bundleInfo);
            if (m == null) {
                return 29;
            }
            int i2 = m.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) m.getParcelable(Constant.TAG.RET_VALUE);
                long j2 = m.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j2);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? c.a.c0.f.a.b.i().p(str) : invokeL.booleanValue;
    }

    public void preDownload(String str, c.a.c0.c.a.a aVar, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048593, this, str, aVar, i2, sourceData) == null) {
            c.a.c0.b.a.g.a().b().run(new c(this, str, i2, aVar));
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
            c.a.c0.f.a.b.i().q(str);
        }
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, bundleInfo)) == null) {
            Bundle n = c.a.c0.f.a.b.i().n(bundleInfo);
            if (n == null) {
                return 33;
            }
            int i2 = n.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                BundleInfo bundleInfo2 = BundleInfo.toBundleInfo((ContentValues) n.getParcelable(Constant.TAG.RET_VALUE));
                long j2 = n.getLong("time_stamp");
                if (bundleInfo2 != null) {
                    updateBundleInfo(bundleInfo2, j2);
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
            Bundle k = c.a.c0.f.a.b.i().k(bundleInfo);
            if (k == null) {
                return 27;
            }
            int i3 = k.getInt(Constant.TAG.RET_CODE, -1);
            if (i3 == 13) {
                ContentValues contentValues = (ContentValues) k.getParcelable(Constant.TAG.RET_VALUE);
                long j2 = k.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j2);
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
        long j2;
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
            j2 = Long.parseLong(pathSegments.get(1));
        } catch (NumberFormatException e2) {
            c.a.c0.b.a.f.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
            j2 = 0L;
        }
        if ("all".equalsIgnoreCase(str)) {
            initBundleInfoFromDB(j2);
            return;
        }
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (j2 > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
            this.mBundleInfoGroupMap.put(str, c.a.c0.f.a.b.i().h(str, j2));
        }
    }

    public void downloadBundle(String str, c.a.c0.c.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null) {
            return;
        }
        downloadBundle(str, aVar, 48);
    }

    public void downloadBundle(String str, c.a.c0.c.a.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, aVar, i2) == null) {
            c.a.c0.b.a.g.a().b().run(new b(this, aVar, str));
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
                    c.a.c0.h.b.a();
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                c.a.c0.b.a.g.a().b().run(new a(this, str, iInstallCallback, i2));
            }
        }
    }
}
