package com.baidu.nps.pm.manager;

import android.app.Activity;
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
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleConfig;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.BundleInfoGroupManager;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.nps.utils.SourceData;
import com.baidu.tieba.R;
import com.baidu.tieba.a91;
import com.baidu.tieba.b91;
import com.baidu.tieba.c91;
import com.baidu.tieba.d91;
import com.baidu.tieba.n91;
import com.baidu.tieba.o81;
import com.baidu.tieba.p91;
import com.baidu.tieba.q91;
import com.baidu.tieba.s91;
import com.baidu.tieba.t91;
import com.baidu.tieba.v81;
import com.baidu.tieba.v91;
import com.baidu.tieba.w81;
import com.baidu.tieba.y81;
import com.baidu.tieba.y91;
import com.baidu.tieba.z81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class NPSPackageManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPS-NPSPackageManager";
    public static NPSPackageManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, BundleInfoGroup> mBundleInfoGroupMap;
    public Set<String> mInstallingSet;
    public boolean mIsInited;
    public Map<String, BundleInfo> mPresetInfoMap;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ IInstallCallback d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ NPSPackageManager f;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0116a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0116a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.f.mInstallingSet.remove(this.a.b);
                    this.a.d.onResult(54, "");
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0117a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0117a(b bVar) {
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
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.a.a;
                        aVar.f.realInstall(aVar.b, aVar.d, aVar.a, aVar.c, aVar.e);
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    w81.a().b().run(new RunnableC0117a(this));
                }
            }
        }

        public a(NPSPackageManager nPSPackageManager, int i, String str, boolean z, IInstallCallback iInstallCallback, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, Integer.valueOf(i), str, Boolean.valueOf(z), iInstallCallback, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nPSPackageManager;
            this.a = i;
            this.b = str;
            this.c = z;
            this.d = iInstallCallback;
            this.e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            BundleInfoGroup bundleInfoGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.a & 2) != 0 && (bundleInfoGroup = (BundleInfoGroup) this.f.mBundleInfoGroupMap.get(this.b)) != null) {
                    BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                    boolean z = bundleInfoGroup.getBundleByType(3) != null;
                    boolean z2 = bundleInfoGroup.getBundleByType(2) != null;
                    int bundleStatus = this.f.getBundleStatus(this.b, this.c);
                    if (bundleByType != null && bundleStatus == 44 && !z && !z2 && bundleByType.getSize() >= 5242880 && !s91.b(ContextHolder.getApplicationContext())) {
                        Application applicationContext = ContextHolder.getApplicationContext();
                        o81.a().c(null, applicationContext.getString(R.string.obfuscated_res_0x7f0f0916, bundleByType.getName(), new DecimalFormat("###.0").format(bundleByType.getSize() / 1048576.0d)), new View$OnClickListenerC0116a(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f091a), new b(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f091b));
                        return;
                    }
                }
                this.f.realInstall(this.b, this.d, this.a, this.c, this.e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IInstallCallback a;
        public final /* synthetic */ Map b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NPSPackageManager nPSPackageManager, Handler handler, IInstallCallback iInstallCallback, Map map) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, handler, iInstallCallback, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iInstallCallback;
            this.b = map;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                v91 a = y91.a(uri);
                if (a.b > 0 || a.a > 0) {
                    this.a.onProgress(a.a, a.b);
                    String str = (String) this.b.get(this);
                    if (str != null) {
                        long j = (a.a * 100) / a.b;
                        if (j <= 0 || j > 100) {
                            return;
                        }
                        n91.h(str, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0919), (int) j);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y81 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ NPSPackageManager e;

        /* loaded from: classes2.dex */
        public class a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Handler handler) {
                super(handler);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, handler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Handler) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    v91 a = y91.a(uri);
                    if (this.a.a != null) {
                        if (a.b > 0 || a.a > 0) {
                            this.a.a.onProgress(a.a, a.b);
                        }
                    }
                }
            }
        }

        public c(NPSPackageManager nPSPackageManager, y81 y81Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, y81Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nPSPackageManager;
            this.a = y81Var;
            this.b = str;
            this.c = z;
            this.d = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = null;
                if (this.a != null) {
                    Uri d = y91.d(this.b);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.e.downloadBundle(this.b, this.c, this.d);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                y81 y81Var = this.a;
                if (y81Var != null) {
                    y81Var.onResult(downloadBundle, "");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ y81 c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ NPSPackageManager e;

        public d(NPSPackageManager nPSPackageManager, String str, int i, y81 y81Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, Integer.valueOf(i), y81Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nPSPackageManager;
            this.a = str;
            this.b = i;
            this.c = y81Var;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int bundleStatus = this.e.getBundleStatus(this.a);
                BundleInfo updateBundle = this.e.getUpdateBundle(this.a);
                if (bundleStatus == 44 && updateBundle != null) {
                    if (this.b == 0) {
                        d91.j().d(updateBundle);
                        return;
                    } else if (s91.b(ContextHolder.getApplicationContext())) {
                        this.e.downloadBundle(this.a, this.c, 48, this.d);
                        return;
                    } else {
                        d91.j().d(updateBundle);
                        y81 y81Var = this.c;
                        if (y81Var != null) {
                            y81Var.onResult(51, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                        }
                        if (q91.a()) {
                            Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                            return;
                        }
                        return;
                    }
                }
                y81 y81Var2 = this.c;
                if (y81Var2 != null) {
                    y81Var2.onResult(3, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0b));
                }
                if (q91.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0b));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ y81 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ a91 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ NPSPackageManager f;

        /* loaded from: classes2.dex */
        public class a implements b91 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BundleInfo a;
            public final /* synthetic */ e b;

            public a(e eVar, BundleInfo bundleInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bundleInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = bundleInfo;
            }

            @Override // com.baidu.tieba.b91
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 1) {
                        e eVar = this.b;
                        eVar.f.downloadBundle(eVar.a, eVar.b, 48, true);
                        return;
                    }
                    d91.j().d(this.a);
                    e eVar2 = this.b;
                    y81 y81Var = eVar2.b;
                    if (y81Var != null) {
                        y81Var.onResult(51, eVar2.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                    }
                    if (q91.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.b.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                    }
                }
            }
        }

        public e(NPSPackageManager nPSPackageManager, String str, y81 y81Var, int i, a91 a91Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, y81Var, Integer.valueOf(i), a91Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nPSPackageManager;
            this.a = str;
            this.b = y81Var;
            this.c = i;
            this.d = a91Var;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BundleInfo updateBundle = this.f.getUpdateBundle(this.a);
                if (updateBundle == null) {
                    y81 y81Var = this.b;
                    if (y81Var != null) {
                        y81Var.onResult(3, this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0b));
                    }
                    if (q91.a()) {
                        Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0b));
                    }
                } else if (this.c == 1) {
                    if (s91.b(ContextHolder.getApplicationContext())) {
                        this.f.downloadBundle(this.a, true, this.e);
                    } else {
                        this.d.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                    }
                } else {
                    d91.j().d(updateBundle);
                    y81 y81Var2 = this.b;
                    if (y81Var2 != null) {
                        y81Var2.onResult(51, this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                    }
                    if (q91.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0f0a));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(NPSPackageManager nPSPackageManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d91.j().c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NPSPackageManager a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Uri a;
            public final /* synthetic */ g b;

            public a(g gVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.updateBundleInfos(this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(NPSPackageManager nPSPackageManager, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                w81.a().b().run(new a(this, uri));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;

        public h(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.countDown();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ NPSPackageManager b;

        public i(NPSPackageManager nPSPackageManager, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nPSPackageManager;
            this.a = countDownLatch;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.killProcessesWithPluginsRunning();
                this.a.countDown();
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
        this.mBundleInfoGroupMap = new ConcurrentHashMap();
        this.mPresetInfoMap = new HashMap();
        this.mInstallingSet = new CopyOnWriteArraySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkMainBundleValid(List<SubBundleInfo> list, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        BundleInfo bundleByType;
        BundleInfo bundleByType2;
        BundleInfo bundleByType3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, this, list, z)) == null) {
            if (list != null && !list.isEmpty()) {
                for (SubBundleInfo subBundleInfo : list) {
                    BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(subBundleInfo.getPackageName());
                    if (bundleInfoGroup != null) {
                        BundleInfo bundleByType4 = bundleInfoGroup.getBundleByType(1);
                        if (bundleByType4 != null) {
                            if (bundleByType4.needForceUpdate() && bundleByType4.getVersionCode() > subBundleInfo.getMaxVersion()) {
                                return false;
                            }
                            if (bundleByType4.getVersionCode() >= subBundleInfo.getMinVersion() && bundleByType4.getVersionCode() <= subBundleInfo.getMaxVersion()) {
                                z2 = true;
                                if (!z2 && (bundleByType3 = bundleInfoGroup.getBundleByType(2)) != null) {
                                    if (!bundleByType3.needForceUpdate() && bundleByType3.getVersionCode() > subBundleInfo.getMaxVersion()) {
                                        return false;
                                    }
                                    if (checkVersionInSection(bundleByType3.getVersionCode(), subBundleInfo)) {
                                        z2 = true;
                                    }
                                }
                                if (!z2 && (bundleByType2 = bundleInfoGroup.getBundleByType(3)) != null && checkVersionInSection(bundleByType2.getVersionCode(), subBundleInfo)) {
                                    z2 = true;
                                }
                                if (!z2 && (bundleByType = bundleInfoGroup.getBundleByType(4)) != null && checkVersionInSection(bundleByType.getVersionCode(), subBundleInfo)) {
                                    z2 = true;
                                }
                                if (z2 && z) {
                                    return false;
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            if (!bundleByType3.needForceUpdate()) {
                            }
                            if (checkVersionInSection(bundleByType3.getVersionCode(), subBundleInfo)) {
                            }
                        }
                        if (!z2) {
                            z2 = true;
                        }
                        if (!z2) {
                            z2 = true;
                        }
                        if (z2) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean checkPresetBundleWithDownload(BundleInfo bundleInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, this, bundleInfo, z)) == null) ? hasValidPresetBundle(bundleInfo.getPackageName(), z) && this.mPresetInfoMap.get(bundleInfo.getPackageName()).getVersionCode() >= bundleInfo.getVersionCode() : invokeLZ.booleanValue;
    }

    private boolean checkVersionInSection(int i2, SubBundleInfo subBundleInfo) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i2, subBundleInfo)) == null) ? subBundleInfo != null && i2 >= subBundleInfo.getMinVersion() && i2 <= subBundleInfo.getMaxVersion() : invokeIL.booleanValue;
    }

    private void clearDeprecatedBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (BundleInfo bundleInfo : z81.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            d91.j().b(bundle);
        }
    }

    private int downloadBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, this, str, z)) == null) ? downloadBundle(str, z, false) : invokeLZ.intValue;
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) ? d91.j().h(str) : (List) invokeL.objValue;
    }

    private int getDependencyBundleStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, this, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? sInstance : (NPSPackageManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BundleInfo getUpdateBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return null;
            }
            return bundleInfoGroup.getBundleByType(1);
        }
        return (BundleInfo) invokeL.objValue;
    }

    private boolean hasValidDownloadedBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        BundleInfo bundleInfo;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, this, str, z)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleInfo2 = null;
            if (bundleInfoGroup != null) {
                bundleInfo2 = bundleInfoGroup.getBundleByType(2);
                bundleInfo = bundleInfoGroup.getBundleByType(3);
            } else {
                bundleInfo = null;
            }
            if (bundleInfoGroup == null || bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < z81.b().c(str)) {
                return false;
            }
            if (bundleInfo2.getVersionCode() <= (bundleInfo == null ? 0 : bundleInfo.getVersionCode())) {
                return false;
            }
            if (z) {
                if (q91.a()) {
                    Log.d(TAG, "hasValidDownloadedBundle multiBundleEnable=true pkg=" + str);
                }
                boolean isSubBundle = bundleInfo2.isSubBundle();
                String mainBudble = bundleInfo2.getMainBudble();
                if (!isSubBundle && (bundleByType = bundleInfoGroup.getBundleByType(1)) != null && bundleByType.isSubBundle()) {
                    mainBudble = bundleByType.getMainBudble();
                    isSubBundle = true;
                }
                if (bundleInfo2 != null && isSubBundle) {
                    return checkSubBundleValid(mainBudble, str, bundleInfo2.getVersionCode());
                }
                if (bundleInfo2.isMainBundle()) {
                    return checkMainBundleValid(bundleInfo2.getSubBundle(), bundleInfoGroup.getBundleByType(1) != null);
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean hasValidInstalledBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65558, this, str, z)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleByType2 = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
            if (((bundleByType2 == null || bundleByType2.isForbidden() || bundleByType2.getVersionCode() < z81.b().c(str)) ? false : true) && bundleByType2 != null) {
                if (z && bundleInfoGroup != null) {
                    if (q91.a()) {
                        Log.d(TAG, "hasValidInstalledBundle multiBundleEnable=true pkg=" + str);
                    }
                    boolean isSubBundle = bundleByType2.isSubBundle();
                    String mainBudble = bundleByType2.getMainBudble();
                    if (!isSubBundle) {
                        BundleInfo bundleByType3 = bundleInfoGroup.getBundleByType(2);
                        if (bundleByType3 != null && bundleByType3.isSubBundle()) {
                            mainBudble = bundleByType3.getMainBudble();
                            isSubBundle = true;
                        }
                        if (!isSubBundle && (bundleByType = bundleInfoGroup.getBundleByType(1)) != null && bundleByType.isSubBundle()) {
                            mainBudble = bundleByType.getMainBudble();
                            isSubBundle = true;
                        }
                    }
                    if (isSubBundle) {
                        return checkSubBundleValid(mainBudble, bundleByType2.getPackageName(), bundleByType2.getVersionCode());
                    }
                    if (bundleByType2.isMainBundle()) {
                        return checkMainBundleValid(bundleByType2.getSubBundle(), false);
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    private boolean hasValidPresetBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, this, str, z)) == null) {
            initIfNeed();
            BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
            if (bundleInfo == null) {
                return false;
            }
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
            if (bundleInfo.getVersionCode() < z81.b().c(str)) {
                return false;
            }
            if (bundleInfo.getVersionCode() <= (bundleByType == null ? 0 : bundleByType.getVersionCode())) {
                return false;
            }
            if (z) {
                if (q91.a()) {
                    Log.d(TAG, "hasValidPresetBundle multiBundleEnable=true pkg=" + str);
                }
                if (bundleInfo.isSubBundle()) {
                    return checkSubBundleValid(bundleInfo);
                }
                if (bundleInfo.isMainBundle()) {
                    return checkMainBundleValid(bundleInfo.getSubBundle(), false);
                }
                return true;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private void initBundleInfoFromDB(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65560, this, j) == null) {
            this.mBundleInfoGroupMap = d91.j().g(j);
        }
    }

    private synchronized void initIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            Bundle k = d91.j().k();
            if (k == null) {
                return 32;
            }
            int i2 = k.getInt(Constant.TAG.RET_CODE, -1);
            ArrayList parcelableArrayList = k.getParcelableArrayList(Constant.TAG.RET_VALUE);
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

    private int installBundle(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(str);
            return installBundle(bundleInfo, i2, z);
        }
        return invokeCommon.intValue;
    }

    private int installBundleOnly(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, bundleInfo)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle m = d91.j().m(bundleInfo);
            if (m == null) {
                return 28;
            }
            int i2 = m.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) m.getParcelable(Constant.TAG.RET_VALUE);
                long j = m.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
            statisticExtendInfo.source = "installBundleOnly";
            v81.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, bundleInfo)) == null) {
            Bundle o = d91.j().o(bundleInfo);
            if (o == null) {
                return 33;
            }
            int i2 = o.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                BundleInfo bundleInfo2 = BundleInfo.toBundleInfo((ContentValues) o.getParcelable(Constant.TAG.RET_VALUE));
                long j = o.getLong("time_stamp");
                if (bundleInfo2 != null) {
                    updateBundleInfo(bundleInfo2, j);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private boolean isForbidden(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) ? z81.b().c(str) != -1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Intent intent = new Intent(p91.a);
            intent.setPackage(ContextHolder.getApplicationContext().getPackageName());
            ContextHolder.getApplicationContext().sendBroadcast(intent);
        }
    }

    private boolean needForceUpdate(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, str)) == null) {
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
            int versionCode = bundleInfo2 == null ? 0 : bundleInfo2.getVersionCode();
            BundleInfo bundleInfo3 = this.mPresetInfoMap.get(str);
            return (bundleInfo3 == null || bundleInfo == null || bundleInfo3.getVersionCode() < bundleInfo.getVersionCode()) && bundleInfo != null && bundleInfo.needForceUpdate() && bundleInfo.getVersionCode() > versionCode;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realInstall(String str, IInstallCallback iInstallCallback, int i2, boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{str, iInstallCallback, Integer.valueOf(i2), Boolean.valueOf(z), activity}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Uri e2 = y91.e(str);
            HashMap hashMap = new HashMap();
            b bVar = new b(this, null, iInstallCallback, hashMap);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, bVar);
            String showInstallLoading = showInstallLoading(i2, activity, str);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                hashMap.put(bVar, showInstallLoading);
            }
            int installBundle = installBundle(str, i2, z);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                n91.c(showInstallLoading);
            }
            hashMap.clear();
            this.mInstallingSet.remove(str);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(bVar);
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
            statisticExtendInfo.source = "installBundle";
            v81.a().b().recordInstallResult(installBundle, str, getBundleVersion(str), "", statisticExtendInfo);
            if (iInstallCallback != null) {
                if (q91.a()) {
                    Log.i(TAG, "installBundle, retCode=" + installBundle);
                }
                iInstallCallback.onResult(installBundle, "");
            }
        }
    }

    private void registerObsever() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            d91.j().r(true, new g(this, new Handler(Looper.getMainLooper())));
        }
    }

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            o81.a().c(applicationContext.getString(R.string.obfuscated_res_0x7f0f0268), applicationContext.getString(R.string.obfuscated_res_0x7f0f0266), new h(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f0264), new i(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f0265));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    private String showInstallLoading(int i2, Activity activity, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65574, this, i2, activity, str)) == null) {
            if ((i2 & 4) != 0) {
                BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
                if (bundleInfoGroup != null) {
                    if (bundleInfoGroup.getBundleByType(3) != null) {
                        return null;
                    }
                    BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                    BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
                    if (bundleByType2 != null && bundleByType != null && bundleByType2.getVersionCode() == bundleByType.getVersionCode()) {
                        return null;
                    }
                }
                return n91.g(activity, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0919), null);
            }
            return null;
        }
        return (String) invokeILL.objValue;
    }

    private synchronized void updateBundleInfo(BundleInfo bundleInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65575, this, bundleInfo, j) == null) {
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
        if (interceptable == null || interceptable.invokeLJ(65578, this, list, j) == null) {
            synchronized (this) {
                for (BundleInfo bundleInfo : list) {
                    updateBundleInfo(bundleInfo, j);
                }
            }
        }
    }

    public boolean checkSubBundleValid(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundleInfo)) == null) {
            if (bundleInfo != null && bundleInfo.isSubBundle()) {
                return checkSubBundleValid(bundleInfo.getMainBudble(), bundleInfo.getPackageName(), bundleInfo.getVersionCode());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void downloadAllBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w81.a().b().run(new f(this));
        }
    }

    public void downloadUpdatePackage(String str, y81 y81Var, a91 a91Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, y81Var, a91Var, i2) == null) {
            downloadUpdatePackage(str, y81Var, a91Var, i2, false);
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Bundle f2 = d91.j().f();
            if (f2 == null) {
                return 30;
            }
            int i2 = f2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 0) {
                ArrayList parcelableArrayList = f2.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = f2.getLong("time_stamp");
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            initIfNeed();
            return this.mBundleInfoGroupMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroupForLogSystem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? BundleInfoGroupManager.toBundleInfoGroups(c91.d(ContextHolder.getApplicationContext()).e(), System.currentTimeMillis()) : (Map) invokeV.objValue;
    }

    public BundleInfoGroup getBundleGroup(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            initIfNeed();
            return this.mBundleInfoGroupMap.get(str);
        }
        return (BundleInfoGroup) invokeL.objValue;
    }

    public BundleInfo getBundleInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? getBundleStatus(str, false) : invokeL.intValue;
    }

    public int getBundleVersion(String str) {
        InterceptResult invokeL;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null || (bundleByType = bundleInfoGroup.getBundleByType(3)) == null) {
                return -1;
            }
            return bundleByType.getVersionCode();
        }
        return invokeL.intValue;
    }

    public String getPackageNameFromComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            initIfNeed();
            return z81.b().e(str);
        }
        return (String) invokeL.objValue;
    }

    public BundleInfo getPresetBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? this.mPresetInfoMap.get(str) : (BundleInfo) invokeL.objValue;
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this) {
                if (this.mIsInited) {
                    return;
                }
                z81.b().g();
                clearDeprecatedBundles();
                registerObsever();
                initBundleInfoFromDB(System.currentTimeMillis());
                initPresetInfo();
                this.mIsInited = true;
            }
        }
    }

    public int installBundleForDebug(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (new File(str).exists()) {
                PackageInfo a2 = t91.a(str, 128);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bundleInfo)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle n = d91.j().n(bundleInfo);
            if (n == null) {
                return 29;
            }
            int i2 = n.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 13) {
                ContentValues contentValues = (ContentValues) n.getParcelable(Constant.TAG.RET_VALUE);
                long j = n.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
            statisticExtendInfo.source = "installLocalBundle";
            v81.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    public boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? d91.j().p(str) : invokeL.booleanValue;
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mIsInited : invokeV.booleanValue;
    }

    public void preDownload(String str, y81 y81Var, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048607, this, str, y81Var, i2, sourceData) == null) {
            preDownload(str, y81Var, i2, sourceData, false);
        }
    }

    public int prepareBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? prepareBundle(str, 0, false) : invokeL.intValue;
    }

    public void recordBundleRunning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            d91.j().q(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int downloadBundle(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup == null) {
                return 26;
            }
            BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(1);
            if (z2 && !z && bundleByType2 != null && bundleByType2.isSubBundle()) {
                String mainBudble = bundleByType2.getMainBudble();
                BundleInfoGroup bundleInfoGroup2 = this.mBundleInfoGroupMap.get(mainBudble);
                if (bundleInfoGroup != null) {
                    BundleInfo bundleByType3 = bundleInfoGroup2.getBundleByType(2);
                    BundleInfo bundleByType4 = bundleInfoGroup2.getBundleByType(3);
                    if (isBundleRunning(mainBudble) || bundleByType3 == null || (bundleByType4 != null && bundleByType3.getVersionCode() <= bundleByType4.getVersionCode())) {
                        bundleByType3 = null;
                    }
                    if (bundleByType3 != null) {
                        bundleByType4 = bundleByType3;
                    }
                    if (bundleByType4 != null) {
                        Iterator<SubBundleInfo> it = bundleByType4.getSubBundle().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                i3 = -1;
                                break;
                            }
                            SubBundleInfo next = it.next();
                            if (bundleByType2.getPackageName().equals(next.getPackageName())) {
                                i2 = next.getMinVersion();
                                i3 = next.getMaxVersion();
                                break;
                            }
                        }
                        if (i2 >= 0 && i3 >= 0 && (bundleByType2.getVersionCode() > i3 || bundleByType2.getVersionCode() < i2)) {
                            bundleByType2 = null;
                        }
                        if (bundleByType2 == null && (bundleByType = bundleInfoGroup.getBundleByType(4)) != null && bundleByType.getVersionCode() >= i2 && bundleByType.getVersionCode() <= i3) {
                            bundleByType2 = bundleByType;
                        }
                    }
                }
            }
            if (bundleByType2 == null) {
                return 3;
            }
            if (checkPresetBundleWithDownload(bundleByType2, z2)) {
                return 2;
            }
            Bundle e2 = d91.j().e(bundleByType2);
            if (e2 == null) {
                return 31;
            }
            int i4 = e2.getInt(Constant.TAG.RET_CODE, -1);
            if (i4 == 2) {
                ContentValues contentValues = (ContentValues) e2.getParcelable(Constant.TAG.RET_VALUE);
                long j = e2.getLong("time_stamp");
                if (contentValues != null) {
                    updateBundleInfo(BundleInfo.toBundleInfo(contentValues), j);
                }
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public void downloadUpdatePackage(String str, y81 y81Var, a91 a91Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, y81Var, a91Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            w81.a().b().run(new e(this, str, y81Var, i2, a91Var, z));
        }
    }

    public int getBundleStatus(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) ? getBundleStatus(str, z, null) : invokeLZ.intValue;
    }

    public void preDownload(String str, y81 y81Var, int i2, SourceData sourceData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, y81Var, Integer.valueOf(i2), sourceData, Boolean.valueOf(z)}) == null) {
            w81.a().b().run(new d(this, str, i2, y81Var, z));
        }
    }

    public int prepareBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048613, this, str, z)) == null) ? prepareBundle(str, 0, z) : invokeLZ.intValue;
    }

    public int getBundleStatus(String str, boolean z, BundleConfig bundleConfig) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), bundleConfig})) == null) {
            if (TextUtils.isEmpty(str)) {
                if (q91.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=5");
                    return 5;
                }
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                if (q91.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=15");
                    return 15;
                }
                return 15;
            } else if (needForceUpdate(str)) {
                if (q91.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else if (hasValidInstalledBundle(str, z)) {
                if (q91.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            } else {
                boolean z2 = false;
                boolean hasValidPresetBundle = (bundleConfig == null || !bundleConfig.skipPresetBundle) ? hasValidPresetBundle(str, z) : false;
                if (bundleConfig == null || !bundleConfig.skipDownloadedBundle) {
                    z2 = hasValidDownloadedBundle(str, z);
                }
                if (!hasValidPresetBundle && !z2 && !hasValidInstalledBundle(str, z)) {
                    if (q91.a()) {
                        Log.i(TAG, "getBundleStatus, retCode=44");
                    }
                    return 44;
                }
                if (q91.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            }
        }
        return invokeCommon.intValue;
    }

    public int prepareBundle(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, str, i2)) == null) ? prepareBundle(str, i2, false) : invokeLI.intValue;
    }

    private int installBundle(BundleInfo bundleInfo, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{bundleInfo, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (q91.a() && z) {
                Log.d(TAG, "installBundle multiBundleEnable=true pkg=" + bundleInfo.getPackageName());
            }
            Bundle l = d91.j().l(bundleInfo, z);
            if (l == null) {
                return 27;
            }
            int i3 = l.getInt(Constant.TAG.RET_CODE, -1);
            if (i3 == 13) {
                ContentValues contentValues = (ContentValues) l.getParcelable(Constant.TAG.RET_VALUE);
                long j = l.getLong("time_stamp");
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
        return invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBundleInfos(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, uri) == null) || uri == null) {
            return;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2) {
            return;
        }
        String str = pathSegments.get(0);
        long j = 0;
        try {
            j = Long.parseLong(pathSegments.get(1));
        } catch (NumberFormatException e2) {
            v81.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
        }
        updateBundleInfos(str, j);
    }

    public int prepareBundle(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? prepareBundle(str, i2, z, null) : invokeCommon.intValue;
    }

    public boolean checkSubBundleValid(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        BundleInfoGroup bundleInfoGroup;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            if (q91.a()) {
                Log.d("NPSPackageManager", "checkSubBundleMatch");
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (bundleInfoGroup = this.mBundleInfoGroupMap.get(str)) == null || (bundleByType = bundleInfoGroup.getBundleByType(3)) == null) {
                return false;
            }
            List<SubBundleInfo> subBundle = bundleByType.getSubBundle();
            if (subBundle == null || subBundle.isEmpty()) {
                return true;
            }
            SubBundleInfo subBundleInfo = null;
            Iterator<SubBundleInfo> it = subBundle.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubBundleInfo next = it.next();
                if (!TextUtils.isEmpty(next.getPackageName()) && next.getPackageName().equals(str2)) {
                    subBundleInfo = next;
                    break;
                }
            }
            return subBundleInfo != null && i2 <= subBundleInfo.getMaxVersion() && i2 >= subBundleInfo.getMinVersion();
        }
        return invokeLLI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0096, code lost:
        if (r4 == 13) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int prepareBundle(String str, int i2, boolean z, BundleConfig bundleConfig) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), bundleConfig})) == null) {
            initIfNeed();
            if (isValidPackageName(str)) {
                if (isForbidden(str)) {
                    return 42;
                }
                if (needForceUpdate(str)) {
                    return 44;
                }
                boolean z2 = false;
                boolean hasValidPresetBundle = (bundleConfig == null || !bundleConfig.skipPresetBundle) ? hasValidPresetBundle(str, z) : false;
                boolean hasValidDownloadedBundle = (bundleConfig == null || !bundleConfig.skipDownloadedBundle) ? hasValidDownloadedBundle(str, z) : false;
                if (hasValidPresetBundle || hasValidDownloadedBundle || hasValidInstalledBundle(str, z)) {
                    boolean z3 = true;
                    if (hasValidPresetBundle) {
                        int installPreset = installPreset(this.mPresetInfoMap.get(str));
                        if (installPreset != 13) {
                            return installPreset;
                        }
                        z2 = true;
                    }
                    if (hasValidDownloadedBundle) {
                        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
                        if (bundleInfoGroup == null) {
                            return 25;
                        }
                        BundleInfo bundleByType = bundleInfoGroup.getBundleByType(2);
                        if (bundleByType == null) {
                            return hasValidInstalledBundle(str, z) ? 41 : 23;
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
                    z3 = z2;
                    if (z3) {
                        updateBundleInfos(str, System.currentTimeMillis());
                    }
                    return hasValidInstalledBundle(str, z) ? 41 : 45;
                }
                return 44;
            }
            return 15;
        }
        return invokeCommon.intValue;
    }

    private void updateBundleInfos(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65577, this, str, j) == null) {
            if ("all".equalsIgnoreCase(str)) {
                initBundleInfoFromDB(j);
                return;
            }
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
                this.mBundleInfoGroupMap.put(str, d91.j().i(str, j));
            }
        }
    }

    public void installBundle(String str, boolean z, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Boolean.valueOf(z), iInstallCallback}) == null) {
            installBundle(str, 0, z, iInstallCallback, null);
        }
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, iInstallCallback) == null) {
            installBundle(str, 0, iInstallCallback);
        }
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, str, i2, iInstallCallback) == null) {
            synchronized (this) {
                installBundle(str, i2, iInstallCallback, null);
            }
        }
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048599, this, str, i2, iInstallCallback, activity) == null) {
            synchronized (this) {
                installBundle(str, i2, false, iInstallCallback, activity);
            }
        }
    }

    public synchronized void installBundle(String str, int i2, boolean z, IInstallCallback iInstallCallback, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), iInstallCallback, activity}) == null) {
            synchronized (this) {
                if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
                    if (q91.a()) {
                        Log.i(TAG, "installBundle, retCode=34");
                    }
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                w81.a().b().run(new a(this, i2, str, z, iInstallCallback, activity));
            }
        }
    }

    public void downloadBundle(String str, y81 y81Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, y81Var) == null) || y81Var == null) {
            return;
        }
        downloadBundle(str, y81Var, 48);
    }

    public void downloadBundle(String str, y81 y81Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, y81Var, i2) == null) {
            downloadBundle(str, false, y81Var, i2, false);
        }
    }

    public void downloadBundle(String str, boolean z, y81 y81Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), y81Var, Integer.valueOf(i2)}) == null) {
            downloadBundle(str, z, y81Var, i2, false);
        }
    }

    public void downloadBundle(String str, y81 y81Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, y81Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            downloadBundle(str, false, y81Var, i2, z);
        }
    }

    public void downloadBundle(String str, boolean z, y81 y81Var, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), y81Var, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            w81.a().b().run(new c(this, y81Var, str, z2, z));
        }
    }
}
