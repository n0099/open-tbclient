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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d71;
import com.repackage.e71;
import com.repackage.g71;
import com.repackage.h71;
import com.repackage.i61;
import com.repackage.j71;
import com.repackage.m71;
import com.repackage.n61;
import com.repackage.o61;
import com.repackage.q61;
import com.repackage.r61;
import com.repackage.s61;
import com.repackage.t61;
import com.repackage.u61;
import com.repackage.v61;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        public final /* synthetic */ String a;
        public final /* synthetic */ IInstallCallback b;
        public final /* synthetic */ int c;
        public final /* synthetic */ NPSPackageManager d;

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0115a extends ContentObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0115a(a aVar, Handler handler) {
                super(handler);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, handler};
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
                this.a = aVar;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                    j71 a = m71.a(uri);
                    if (a.b > 0 || a.a > 0) {
                        this.a.b.onProgress(a.a, a.b);
                    }
                }
            }
        }

        public a(NPSPackageManager nPSPackageManager, String str, IInstallCallback iInstallCallback, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, iInstallCallback, Integer.valueOf(i)};
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
            this.b = iInstallCallback;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Uri e = m71.e(this.a);
                C0115a c0115a = new C0115a(this, null);
                ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e, false, c0115a);
                int installBundle = this.d.installBundle(this.a, this.c);
                this.d.mInstallingSet.remove(this.a);
                ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(c0115a);
                if (this.b != null) {
                    if (e71.a()) {
                        Log.i(NPSPackageManager.TAG, "installBundle, retCode=" + installBundle);
                    }
                    this.b.onResult(installBundle, "");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q61 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NPSPackageManager c;

        /* loaded from: classes2.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    j71 a = m71.a(uri);
                    if (this.a.a != null) {
                        if (a.b > 0 || a.a > 0) {
                            this.a.a.onProgress(a.a, a.b);
                        }
                    }
                }
            }
        }

        public b(NPSPackageManager nPSPackageManager, q61 q61Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, q61Var, str};
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
            this.a = q61Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = null;
                if (this.a != null) {
                    Uri d = m71.d(this.b);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.c.downloadBundle(this.b);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                q61 q61Var = this.a;
                if (q61Var != null) {
                    q61Var.onResult(downloadBundle, "");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ q61 c;
        public final /* synthetic */ NPSPackageManager d;

        public c(NPSPackageManager nPSPackageManager, String str, int i, q61 q61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, Integer.valueOf(i), q61Var};
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
            this.c = q61Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.getBundleStatus(this.a) == 44) {
                    if (this.b == 0) {
                        v61.i().c(this.d.getUpdateBundle(this.a));
                        return;
                    } else if (!g71.b(ContextHolder.getApplicationContext())) {
                        v61.i().c(this.d.getUpdateBundle(this.a));
                        q61 q61Var = this.c;
                        if (q61Var != null) {
                            q61Var.onResult(51, this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                        }
                        if (e71.a()) {
                            Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                            return;
                        }
                        return;
                    } else {
                        this.d.downloadBundle(this.a, this.c, 48);
                        return;
                    }
                }
                q61 q61Var2 = this.c;
                if (q61Var2 != null) {
                    q61Var2.onResult(3, this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0eca));
                }
                if (e71.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + this.d.getDownloadMessage(R.string.obfuscated_res_0x7f0f0eca));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q61 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ s61 d;
        public final /* synthetic */ NPSPackageManager e;

        /* loaded from: classes2.dex */
        public class a implements t61 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BundleInfo a;
            public final /* synthetic */ d b;

            public a(d dVar, BundleInfo bundleInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bundleInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = bundleInfo;
            }

            @Override // com.repackage.t61
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 1) {
                        d dVar = this.b;
                        dVar.e.downloadBundle(dVar.a, dVar.b, 48);
                        return;
                    }
                    v61.i().c(this.a);
                    d dVar2 = this.b;
                    q61 q61Var = dVar2.b;
                    if (q61Var != null) {
                        q61Var.onResult(51, dVar2.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                    }
                    if (e71.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.b.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                    }
                }
            }
        }

        public d(NPSPackageManager nPSPackageManager, String str, q61 q61Var, int i, s61 s61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, q61Var, Integer.valueOf(i), s61Var};
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
            this.b = q61Var;
            this.c = i;
            this.d = s61Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BundleInfo updateBundle = this.e.getUpdateBundle(this.a);
                if (updateBundle == null) {
                    q61 q61Var = this.b;
                    if (q61Var != null) {
                        q61Var.onResult(3, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0eca));
                    }
                    if (e71.a()) {
                        Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0eca));
                    }
                } else if (this.c == 1) {
                    if (g71.b(ContextHolder.getApplicationContext())) {
                        this.e.downloadBundle(this.a);
                    } else {
                        this.d.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                    }
                } else {
                    v61.i().c(updateBundle);
                    q61 q61Var2 = this.b;
                    if (q61Var2 != null) {
                        q61Var2.onResult(51, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                    }
                    if (e71.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0ec9));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                v61.i().b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NPSPackageManager a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Uri a;
            public final /* synthetic */ f b;

            public a(f fVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
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
        public f(NPSPackageManager nPSPackageManager, Handler handler) {
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
                o61.a().b().run(new a(this, uri));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NPSPackageManager a;

        public g(NPSPackageManager nPSPackageManager) {
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
                    return;
                }
            }
            this.a = nPSPackageManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle o;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (o = v61.i().o()) != null && o.getInt(Constant.TAG.RET_CODE, -1) == 13) {
                ArrayList parcelableArrayList = o.getParcelableArrayList(Constant.TAG.RET_VALUE);
                long j = o.getLong("time_stamp");
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        this.a.updateBundleInfo(BundleInfo.toBundleInfo((ContentValues) it.next()), j);
                    }
                }
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
            for (BundleInfo bundleInfo : r61.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            v61.i().a(bundle);
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
            Bundle d2 = v61.i().d(bundleByType);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) ? v61.i().g(str) : (List) invokeL.objValue;
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
            if (bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < r61.b().c(str)) {
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
            return (bundleByType == null || bundleByType.isForbidden() || bundleByType.getVersionCode() < r61.b().c(str)) ? false : true;
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
            if (bundleInfo != null && bundleInfo.getVersionCode() >= r61.b().c(str)) {
                return bundleInfo.getVersionCode() > (bundleByType == null ? 0 : bundleByType.getVersionCode());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void initBundleInfoFromDB(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65556, this, j) == null) {
            this.mBundleInfoGroupMap = v61.i().f(j);
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
            Bundle j = v61.i().j();
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
            Bundle l = v61.i().l(bundleInfo);
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
            o61.a().b().run(new g(this));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, this, str)) == null) ? r61.b().c(str) != -1 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            Intent intent = new Intent(d71.a);
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
            v61.i().r(true, new f(this, new Handler(Looper.getMainLooper())));
        }
    }

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            i61.a().c(applicationContext.getString(R.string.obfuscated_res_0x7f0f025d), applicationContext.getString(R.string.obfuscated_res_0x7f0f025b), new h(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f0259), new i(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f025a));
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
            o61.a().b().run(new e(this));
        }
    }

    public void downloadUpdatePackage(String str, q61 q61Var, s61 s61Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, str, q61Var, s61Var, i2) == null) {
            o61.a().b().run(new d(this, str, q61Var, i2, s61Var));
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bundle e2 = v61.i().e();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? BundleInfoGroupManager.toBundleInfoGroups(u61.b(ContextHolder.getApplicationContext()).c(), System.currentTimeMillis()) : (Map) invokeV.objValue;
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
                if (e71.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=5");
                    return 5;
                }
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                if (e71.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=15");
                    return 15;
                }
                return 15;
            } else if (needForceUpdate(str)) {
                if (e71.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else if (hasValidInstalledBundle(str)) {
                if (e71.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            } else if (!hasValidPresetBundle(str) && !hasValidDownloadedBundle(str) && !hasValidInstalledBundle(str)) {
                if (e71.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else {
                if (e71.a()) {
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
            return r61.b().e(str);
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
                r61.b().f();
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
                PackageInfo a2 = h71.a(str, 128);
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
            Bundle m = v61.i().m(bundleInfo);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? v61.i().p(str) : invokeL.booleanValue;
    }

    public void preDownload(String str, q61 q61Var, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048593, this, str, q61Var, i2, sourceData) == null) {
            o61.a().b().run(new c(this, str, i2, q61Var));
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
            v61.i().q(str);
        }
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, bundleInfo)) == null) {
            Bundle n = v61.i().n(bundleInfo);
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
            Bundle k = v61.i().k(bundleInfo);
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
            n61.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
            j = 0L;
        }
        if ("all".equalsIgnoreCase(str)) {
            initBundleInfoFromDB(j);
            return;
        }
        BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
        if (j > (bundleInfoGroup != null ? bundleInfoGroup.getTimeStamp() : 0L)) {
            this.mBundleInfoGroupMap.put(str, v61.i().h(str, j));
        }
    }

    public void downloadBundle(String str, q61 q61Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, q61Var) == null) || q61Var == null) {
            return;
        }
        downloadBundle(str, q61Var, 48);
    }

    public void downloadBundle(String str, q61 q61Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, q61Var, i2) == null) {
            o61.a().b().run(new b(this, q61Var, str));
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
                    if (e71.a()) {
                        Log.i(TAG, "installBundle, retCode=34");
                    }
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                o61.a().b().run(new a(this, str, iInstallCallback, i2));
            }
        }
    }
}
