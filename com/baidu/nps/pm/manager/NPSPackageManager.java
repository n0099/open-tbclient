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
import com.repackage.a61;
import com.repackage.b61;
import com.repackage.c61;
import com.repackage.d61;
import com.repackage.e61;
import com.repackage.n61;
import com.repackage.p51;
import com.repackage.p61;
import com.repackage.q61;
import com.repackage.s61;
import com.repackage.t61;
import com.repackage.v61;
import com.repackage.w51;
import com.repackage.x51;
import com.repackage.y61;
import com.repackage.z51;
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
        public final /* synthetic */ IInstallCallback c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ NPSPackageManager e;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0118a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0118a(a aVar) {
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
                    this.a.e.mInstallingSet.remove(this.a.b);
                    this.a.c.onResult(54, "");
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
            public class RunnableC0119a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0119a(b bVar) {
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
                        aVar.e.realInstall(aVar.b, aVar.c, aVar.a, aVar.d);
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
                    x51.a().b().run(new RunnableC0119a(this));
                }
            }
        }

        public a(NPSPackageManager nPSPackageManager, int i, String str, IInstallCallback iInstallCallback, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, Integer.valueOf(i), str, iInstallCallback, activity};
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
            this.a = i;
            this.b = str;
            this.c = iInstallCallback;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            BundleInfoGroup bundleInfoGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.a & 2) != 0 && (bundleInfoGroup = (BundleInfoGroup) this.e.mBundleInfoGroupMap.get(this.b)) != null) {
                    BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                    boolean z = bundleInfoGroup.getBundleByType(3) != null;
                    boolean z2 = bundleInfoGroup.getBundleByType(2) != null;
                    int bundleStatus = this.e.getBundleStatus(this.b);
                    if (bundleByType != null && bundleStatus == 44 && !z && !z2 && bundleByType.getSize() >= 5242880 && !s61.b(ContextHolder.getApplicationContext())) {
                        Application applicationContext = ContextHolder.getApplicationContext();
                        p51.a().c(null, applicationContext.getString(R.string.obfuscated_res_0x7f0f08fe, bundleByType.getName(), new DecimalFormat("###.0").format(bundleByType.getSize() / 1048576.0d)), new View$OnClickListenerC0118a(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f0902), new b(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f0903));
                        return;
                    }
                }
                this.e.realInstall(this.b, this.c, this.a, this.d);
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
                v61 a = y61.a(uri);
                if (a.b > 0 || a.a > 0) {
                    this.a.onProgress(a.a, a.b);
                    String str = (String) this.b.get(this);
                    if (str != null) {
                        long j = (a.a * 100) / a.b;
                        if (j <= 0 || j > 100) {
                            return;
                        }
                        n61.h(str, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0901), (int) j);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z51 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NPSPackageManager c;

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
                    v61 a = y61.a(uri);
                    if (this.a.a != null) {
                        if (a.b > 0 || a.a > 0) {
                            this.a.a.onProgress(a.a, a.b);
                        }
                    }
                }
            }
        }

        public c(NPSPackageManager nPSPackageManager, z51 z51Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, z51Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nPSPackageManager;
            this.a = z51Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = null;
                if (this.a != null) {
                    Uri d = y61.d(this.b);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.c.downloadBundle(this.b);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                z51 z51Var = this.a;
                if (z51Var != null) {
                    z51Var.onResult(downloadBundle, "");
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
        public final /* synthetic */ z51 c;
        public final /* synthetic */ NPSPackageManager d;

        public d(NPSPackageManager nPSPackageManager, String str, int i, z51 z51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, Integer.valueOf(i), z51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nPSPackageManager;
            this.a = str;
            this.b = i;
            this.c = z51Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int bundleStatus = this.d.getBundleStatus(this.a);
                BundleInfo updateBundle = this.d.getUpdateBundle(this.a);
                if (bundleStatus == 44 && updateBundle != null) {
                    if (this.b == 0) {
                        e61.j().d(updateBundle);
                        return;
                    } else if (s61.b(ContextHolder.getApplicationContext())) {
                        this.d.downloadBundle(this.a, this.c, 48);
                        return;
                    } else {
                        e61.j().d(updateBundle);
                        z51 z51Var = this.c;
                        if (z51Var != null) {
                            z51Var.onResult(51, this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
                        }
                        if (q61.a()) {
                            Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
                            return;
                        }
                        return;
                    }
                }
                z51 z51Var2 = this.c;
                if (z51Var2 != null) {
                    z51Var2.onResult(3, this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed3));
                }
                if (q61.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed3));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ z51 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ b61 d;
        public final /* synthetic */ NPSPackageManager e;

        /* loaded from: classes2.dex */
        public class a implements c61 {
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

            @Override // com.repackage.c61
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 1) {
                        e eVar = this.b;
                        eVar.e.downloadBundle(eVar.a, eVar.b, 48);
                        return;
                    }
                    e61.j().d(this.a);
                    e eVar2 = this.b;
                    z51 z51Var = eVar2.b;
                    if (z51Var != null) {
                        z51Var.onResult(51, eVar2.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
                    }
                    if (q61.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.b.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
                    }
                }
            }
        }

        public e(NPSPackageManager nPSPackageManager, String str, z51 z51Var, int i, b61 b61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, z51Var, Integer.valueOf(i), b61Var};
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
            this.b = z51Var;
            this.c = i;
            this.d = b61Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BundleInfo updateBundle = this.e.getUpdateBundle(this.a);
                if (updateBundle == null) {
                    z51 z51Var = this.b;
                    if (z51Var != null) {
                        z51Var.onResult(3, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed3));
                    }
                    if (q61.a()) {
                        Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed3));
                    }
                } else if (this.c == 1) {
                    if (s61.b(ContextHolder.getApplicationContext())) {
                        this.e.downloadBundle(this.a);
                    } else {
                        this.d.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                    }
                } else {
                    e61.j().d(updateBundle);
                    z51 z51Var2 = this.b;
                    if (z51Var2 != null) {
                        z51Var2.onResult(51, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
                    }
                    if (q61.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ed2));
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
                e61.j().c();
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
                x51.a().b().run(new a(this, uri));
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
            for (BundleInfo bundleInfo : a61.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            e61.j().b(bundle);
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
            Bundle e2 = e61.j().e(bundleByType);
            if (e2 == null) {
                return 31;
            }
            int i2 = e2.getInt(Constant.TAG.RET_CODE, -1);
            if (i2 == 2) {
                ContentValues contentValues = (ContentValues) e2.getParcelable(Constant.TAG.RET_VALUE);
                long j = e2.getLong("time_stamp");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? e61.j().h(str) : (List) invokeL.objValue;
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
            if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < a61.b().c(str)) {
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
            return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < a61.b().c(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private boolean hasValidPresetBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            initIfNeed();
            BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
            if (bundleInfo == null) {
                return false;
            }
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            BundleInfo bundleByType = bundleInfoGroup != null ? bundleInfoGroup.getBundleByType(3) : null;
            if (bundleInfo.getVersionCode() < a61.b().c(str)) {
                return false;
            }
            return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
        }
        return invokeL.booleanValue;
    }

    private void initBundleInfoFromDB(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j) == null) {
            this.mBundleInfoGroupMap = e61.j().g(j);
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
            Bundle k = e61.j().k();
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

    private int installBundle(String str, int i2) {
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
            long currentTimeMillis = System.currentTimeMillis();
            Bundle m = e61.j().m(bundleInfo);
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
            w51.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, bundleInfo)) == null) {
            Bundle o = e61.j().o(bundleInfo);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, this, str)) == null) ? a61.b().c(str) != -1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            Intent intent = new Intent(p61.a);
            intent.setPackage(ContextHolder.getApplicationContext().getPackageName());
            ContextHolder.getApplicationContext().sendBroadcast(intent);
        }
    }

    private boolean needForceUpdate(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, str)) == null) {
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
    public void realInstall(String str, IInstallCallback iInstallCallback, int i2, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65567, this, str, iInstallCallback, i2, activity) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Uri e2 = y61.e(str);
            HashMap hashMap = new HashMap();
            b bVar = new b(this, null, iInstallCallback, hashMap);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, bVar);
            String showInstallLoading = showInstallLoading(i2, activity, str);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                hashMap.put(bVar, showInstallLoading);
            }
            int installBundle = installBundle(str, i2);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                n61.c(showInstallLoading);
            }
            hashMap.clear();
            this.mInstallingSet.remove(str);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(bVar);
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
            statisticExtendInfo.source = "installBundle";
            w51.a().b().recordInstallResult(installBundle, str, getBundleVersion(str), "", statisticExtendInfo);
            if (iInstallCallback != null) {
                if (q61.a()) {
                    Log.i(TAG, "installBundle, retCode=" + installBundle);
                }
                iInstallCallback.onResult(installBundle, "");
            }
        }
    }

    private void registerObsever() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            e61.j().r(true, new g(this, new Handler(Looper.getMainLooper())));
        }
    }

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            p51.a().c(applicationContext.getString(R.string.obfuscated_res_0x7f0f0260), applicationContext.getString(R.string.obfuscated_res_0x7f0f025e), new h(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f025c), new i(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f025d));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    private String showInstallLoading(int i2, Activity activity, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65570, this, i2, activity, str)) == null) {
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
                return n61.g(activity, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0901), null);
            }
            return null;
        }
        return (String) invokeILL.objValue;
    }

    private synchronized void updateBundleInfo(BundleInfo bundleInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65571, this, bundleInfo, j) == null) {
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
        if (interceptable == null || interceptable.invokeLJ(65574, this, list, j) == null) {
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
            x51.a().b().run(new f(this));
        }
    }

    public void downloadUpdatePackage(String str, z51 z51Var, b61 b61Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, str, z51Var, b61Var, i2) == null) {
            x51.a().b().run(new e(this, str, z51Var, i2, b61Var));
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bundle f2 = e61.j().f();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            initIfNeed();
            return this.mBundleInfoGroupMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, BundleInfoGroup> getAllBundleGroupForLogSystem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? BundleInfoGroupManager.toBundleInfoGroups(d61.b(ContextHolder.getApplicationContext()).c(), System.currentTimeMillis()) : (Map) invokeV.objValue;
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
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=5");
                    return 5;
                }
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=15");
                    return 15;
                }
                return 15;
            } else if (needForceUpdate(str)) {
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else if (hasValidInstalledBundle(str)) {
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else {
                if (q61.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            }
        }
        return invokeL.intValue;
    }

    public int getBundleVersion(String str) {
        InterceptResult invokeL;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            initIfNeed();
            return a61.b().e(str);
        }
        return (String) invokeL.objValue;
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (this.mIsInited) {
                    return;
                }
                a61.b().f();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (new File(str).exists()) {
                PackageInfo a2 = t61.a(str, 128);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundleInfo)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle n = e61.j().n(bundleInfo);
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
            w51.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    public boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? e61.j().p(str) : invokeL.booleanValue;
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIsInited : invokeV.booleanValue;
    }

    public void preDownload(String str, z51 z51Var, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048596, this, str, z51Var, i2, sourceData) == null) {
            x51.a().b().run(new d(this, str, i2, z51Var));
        }
    }

    public int prepareBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? prepareBundle(str, 0) : invokeL.intValue;
    }

    public void recordBundleRunning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            e61.j().q(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
        if (r5 == 13) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int prepareBundle(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, str, i2)) == null) {
            initIfNeed();
            if (isValidPackageName(str)) {
                if (isForbidden(str)) {
                    return 42;
                }
                if (needForceUpdate(str)) {
                    return 44;
                }
                if (hasValidPresetBundle(str) || hasValidDownloadedBundle(str) || hasValidInstalledBundle(str)) {
                    boolean z = false;
                    boolean z2 = true;
                    if (hasValidPresetBundle(str)) {
                        int installPreset = installPreset(this.mPresetInfoMap.get(str));
                        if (installPreset != 13) {
                            return installPreset;
                        }
                        z = true;
                    }
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
                    z2 = z;
                    if (z2) {
                        updateBundleInfos(str, System.currentTimeMillis());
                    }
                    return hasValidInstalledBundle(str) ? 41 : 45;
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
            Bundle l = e61.j().l(bundleInfo);
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
        return invokeLI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBundleInfos(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, this, uri) == null) || uri == null) {
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
            w51.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
        }
        updateBundleInfos(str, j);
    }

    public void downloadBundle(String str, z51 z51Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z51Var) == null) || z51Var == null) {
            return;
        }
        downloadBundle(str, z51Var, 48);
    }

    public void downloadBundle(String str, z51 z51Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, z51Var, i2) == null) {
            x51.a().b().run(new c(this, z51Var, str));
        }
    }

    private void updateBundleInfos(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65573, this, str, j) == null) {
            if ("all".equalsIgnoreCase(str)) {
                initBundleInfoFromDB(j);
                return;
            }
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
                this.mBundleInfoGroupMap.put(str, e61.j().i(str, j));
            }
        }
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, iInstallCallback) == null) {
            installBundle(str, 0, iInstallCallback);
        }
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, iInstallCallback) == null) {
            synchronized (this) {
                installBundle(str, i2, iInstallCallback, null);
            }
        }
    }

    public synchronized void installBundle(String str, int i2, IInstallCallback iInstallCallback, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048590, this, str, i2, iInstallCallback, activity) == null) {
            synchronized (this) {
                if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
                    if (q61.a()) {
                        Log.i(TAG, "installBundle, retCode=34");
                    }
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                x51.a().b().run(new a(this, i2, str, iInstallCallback, activity));
            }
        }
    }
}
