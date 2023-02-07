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
import com.baidu.tieba.bf1;
import com.baidu.tieba.cf1;
import com.baidu.tieba.ee1;
import com.baidu.tieba.ef1;
import com.baidu.tieba.fe1;
import com.baidu.tieba.he1;
import com.baidu.tieba.hf1;
import com.baidu.tieba.ie1;
import com.baidu.tieba.je1;
import com.baidu.tieba.ke1;
import com.baidu.tieba.le1;
import com.baidu.tieba.me1;
import com.baidu.tieba.we1;
import com.baidu.tieba.xd1;
import com.baidu.tieba.ye1;
import com.baidu.tieba.ze1;
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

    private int getDependencyBundleStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

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

        /* loaded from: classes2.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0134a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0134a(b bVar) {
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
                    fe1.a().b().run(new RunnableC0134a(this));
                }
            }
        }

        /* renamed from: com.baidu.nps.pm.manager.NPSPackageManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0133a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0133a(a aVar) {
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
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.a & 2) != 0 && (bundleInfoGroup = (BundleInfoGroup) this.f.mBundleInfoGroupMap.get(this.b)) != null) {
                    BundleInfo bundleByType = bundleInfoGroup.getBundleByType(1);
                    if (bundleInfoGroup.getBundleByType(3) != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (bundleInfoGroup.getBundleByType(2) != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int bundleStatus = this.f.getBundleStatus(this.b, this.c);
                    if (bundleByType != null && bundleStatus == 44 && !z && !z2 && bundleByType.getSize() >= 5242880 && !bf1.b(ContextHolder.getApplicationContext())) {
                        Application applicationContext = ContextHolder.getApplicationContext();
                        xd1.a().c(null, applicationContext.getString(R.string.obfuscated_res_0x7f0f09a3, bundleByType.getName(), new DecimalFormat("###.0").format(bundleByType.getSize() / 1048576.0d)), new View$OnClickListenerC0133a(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f09a7), new b(this), applicationContext.getString(R.string.obfuscated_res_0x7f0f09a8));
                        return;
                    }
                }
                this.f.realInstall(this.b, this.d, this.a, this.c, this.e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he1 a;
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
                    ef1 a = hf1.a(uri);
                    if (this.a.a != null) {
                        if (a.b > 0 || a.a > 0) {
                            this.a.a.onProgress(a.a, a.b);
                        }
                    }
                }
            }
        }

        public c(NPSPackageManager nPSPackageManager, he1 he1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, he1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = he1Var;
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
                    Uri d = hf1.d(this.b);
                    a aVar2 = new a(this, null);
                    ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(d, false, aVar2);
                    aVar = aVar2;
                }
                int downloadBundle = this.e.downloadBundle(this.b, this.c, this.d);
                if (aVar != null) {
                    ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(aVar);
                }
                he1 he1Var = this.a;
                if (he1Var != null) {
                    he1Var.onResult(downloadBundle, "");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ he1 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ je1 d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ NPSPackageManager f;

        /* loaded from: classes2.dex */
        public class a implements ke1 {
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

            @Override // com.baidu.tieba.ke1
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 1) {
                        e eVar = this.b;
                        eVar.f.downloadBundle(eVar.a, eVar.b, 48, true);
                        return;
                    }
                    me1.j().d(this.a);
                    e eVar2 = this.b;
                    he1 he1Var = eVar2.b;
                    if (he1Var != null) {
                        he1Var.onResult(51, eVar2.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                    }
                    if (ze1.a()) {
                        Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.b.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                    }
                }
            }
        }

        public e(NPSPackageManager nPSPackageManager, String str, he1 he1Var, int i, je1 je1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, he1Var, Integer.valueOf(i), je1Var, Boolean.valueOf(z)};
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
            this.b = he1Var;
            this.c = i;
            this.d = je1Var;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            BundleInfo updateBundle = this.f.getUpdateBundle(this.a);
            if (updateBundle == null) {
                he1 he1Var = this.b;
                if (he1Var != null) {
                    he1Var.onResult(3, this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa7));
                }
                if (ze1.a()) {
                    Log.i(NPSPackageManager.TAG, "update, retCode=3,message = " + this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa7));
                }
            } else if (this.c == 1) {
                if (!bf1.b(ContextHolder.getApplicationContext())) {
                    this.d.checkAuthorization(updateBundle, 1, new a(this, updateBundle));
                } else {
                    this.f.downloadBundle(this.a, true, this.e);
                }
            } else {
                me1.j().d(updateBundle);
                he1 he1Var2 = this.b;
                if (he1Var2 != null) {
                    he1Var2.onResult(51, this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                }
                if (ze1.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.f.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                }
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
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.b.a.updateBundleInfos(this.a);
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
                fe1.a().b().run(new a(this, uri));
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
                ef1 a = hf1.a(uri);
                if (a.b > 0 || a.a > 0) {
                    this.a.onProgress(a.a, a.b);
                    String str = (String) this.b.get(this);
                    if (str != null) {
                        long j = (a.a * 100) / a.b;
                        if (j > 0 && j <= 100) {
                            we1.h(str, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f09a6), (int) j);
                        }
                    }
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
        public final /* synthetic */ he1 c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ NPSPackageManager e;

        public d(NPSPackageManager nPSPackageManager, String str, int i, he1 he1Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nPSPackageManager, str, Integer.valueOf(i), he1Var, Boolean.valueOf(z)};
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
            this.c = he1Var;
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
                        me1.j().d(updateBundle);
                        return;
                    } else if (bf1.b(ContextHolder.getApplicationContext())) {
                        this.e.downloadBundle(this.a, this.c, 48, this.d);
                        return;
                    } else {
                        me1.j().d(updateBundle);
                        he1 he1Var = this.c;
                        if (he1Var != null) {
                            he1Var.onResult(51, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                        }
                        if (ze1.a()) {
                            Log.i(NPSPackageManager.TAG, "preDownload, retCode=51，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa6));
                            return;
                        }
                        return;
                    }
                }
                he1 he1Var2 = this.c;
                if (he1Var2 != null) {
                    he1Var2.onResult(3, this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa7));
                }
                if (ze1.a()) {
                    Log.i(NPSPackageManager.TAG, "preDownload, retCode=3，message = " + this.e.getDownloadMessage(R.string.obfuscated_res_0x7f0f0fa7));
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
                me1.j().c();
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.killProcessesWithPluginsRunning();
            this.a.countDown();
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

    public static NPSPackageManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return sInstance;
        }
        return (NPSPackageManager) invokeV.objValue;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void killProcessesWithPluginsRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            Intent intent = new Intent(ye1.a);
            intent.setPackage(ContextHolder.getApplicationContext().getPackageName());
            ContextHolder.getApplicationContext().sendBroadcast(intent);
        }
    }

    private void registerObsever() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            me1.j().r(true, new g(this, new Handler(Looper.getMainLooper())));
        }
    }

    public void downloadAllBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fe1.a().b().run(new f(this));
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return BundleInfoGroupManager.toBundleInfoGroups(le1.d(ContextHolder.getApplicationContext()).e(), System.currentTimeMillis());
        }
        return (Map) invokeV.objValue;
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mIsInited;
        }
        return invokeV.booleanValue;
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

    private void clearDeprecatedBundles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (BundleInfo bundleInfo : ie1.b().d()) {
                arrayList.add(BundleInfo.toContentValues(bundleInfo));
            }
            bundle.putParcelableArrayList(Constant.TAG.PARAM_VALUE, arrayList);
            me1.j().b(bundle);
        }
    }

    public synchronized void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this) {
                if (this.mIsInited) {
                    return;
                }
                ie1.b().g();
                clearDeprecatedBundles();
                registerObsever();
                initBundleInfoFromDB(System.currentTimeMillis());
                initPresetInfo();
                this.mIsInited = true;
            }
        }
    }

    private List<BundleInfo> getBundleInfoFromDB(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            return me1.j().h(str);
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, this, i2)) == null) {
            try {
                Application applicationContext = ContextHolder.getApplicationContext();
                if (applicationContext == null) {
                    return "";
                }
                return applicationContext.getString(i2);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeI.objValue;
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

    private void initBundleInfoFromDB(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65560, this, j) == null) {
            this.mBundleInfoGroupMap = me1.j().g(j);
        }
    }

    private boolean isValidPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, str)) == null) {
            if (ie1.b().c(str) != -1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean checkSubBundleValid(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundleInfo)) == null) {
            if (bundleInfo == null || !bundleInfo.isSubBundle()) {
                return false;
            }
            return checkSubBundleValid(bundleInfo.getMainBudble(), bundleInfo.getPackageName(), bundleInfo.getVersionCode());
        }
        return invokeL.booleanValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return getBundleStatus(str, false);
        }
        return invokeL.intValue;
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
            return ie1.b().e(str);
        }
        return (String) invokeL.objValue;
    }

    public BundleInfo getPresetBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            return this.mPresetInfoMap.get(str);
        }
        return (BundleInfo) invokeL.objValue;
    }

    public boolean isBundleRunning(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            return me1.j().p(str);
        }
        return invokeL.booleanValue;
    }

    public int prepareBundle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            return prepareBundle(str, 0, false);
        }
        return invokeL.intValue;
    }

    public void recordBundleRunning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            me1.j().q(str);
        }
    }

    public void downloadUpdatePackage(String str, he1 he1Var, je1 je1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, he1Var, je1Var, i2) == null) {
            downloadUpdatePackage(str, he1Var, je1Var, i2, false);
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

    public void preDownload(String str, he1 he1Var, int i2, SourceData sourceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048607, this, str, he1Var, i2, sourceData) == null) {
            preDownload(str, he1Var, i2, sourceData, false);
        }
    }

    private boolean checkVersionInSection(int i2, SubBundleInfo subBundleInfo) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i2, subBundleInfo)) == null) {
            if (subBundleInfo == null || i2 < subBundleInfo.getMinVersion() || i2 > subBundleInfo.getMaxVersion()) {
                return false;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private int downloadBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, this, str, z)) == null) {
            return downloadBundle(str, z, false);
        }
        return invokeLZ.intValue;
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

    public int getBundleStatus(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            return getBundleStatus(str, z, null);
        }
        return invokeLZ.intValue;
    }

    public void installBundle(String str, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, iInstallCallback) == null) {
            installBundle(str, 0, iInstallCallback);
        }
    }

    public int prepareBundle(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, str, i2)) == null) {
            return prepareBundle(str, i2, false);
        }
        return invokeLI.intValue;
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

    private boolean hasValidDownloadedBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        BundleInfo bundleInfo;
        int versionCode;
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
            boolean z2 = false;
            if (bundleInfoGroup == null || bundleInfo2 == null || bundleInfo2.isForbidden() || bundleInfo2.getVersionCode() < ie1.b().c(str)) {
                return false;
            }
            if (bundleInfo == null) {
                versionCode = 0;
            } else {
                versionCode = bundleInfo.getVersionCode();
            }
            if (bundleInfo2.getVersionCode() <= versionCode) {
                return false;
            }
            if (z) {
                if (ze1.a()) {
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
                    List<SubBundleInfo> subBundle = bundleInfo2.getSubBundle();
                    if (bundleInfoGroup.getBundleByType(1) != null) {
                        z2 = true;
                    }
                    return checkMainBundleValid(subBundle, z2);
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean hasValidInstalledBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        BundleInfo bundleInfo;
        boolean z2;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65558, this, str, z)) == null) {
            initIfNeed();
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup != null) {
                bundleInfo = bundleInfoGroup.getBundleByType(3);
            } else {
                bundleInfo = null;
            }
            if (bundleInfo != null && !bundleInfo.isForbidden() && bundleInfo.getVersionCode() >= ie1.b().c(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || bundleInfo == null) {
                return false;
            }
            if (z && bundleInfoGroup != null) {
                if (ze1.a()) {
                    Log.d(TAG, "hasValidInstalledBundle multiBundleEnable=true pkg=" + str);
                }
                boolean isSubBundle = bundleInfo.isSubBundle();
                String mainBudble = bundleInfo.getMainBudble();
                if (!isSubBundle) {
                    BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
                    if (bundleByType2 != null && bundleByType2.isSubBundle()) {
                        mainBudble = bundleByType2.getMainBudble();
                        isSubBundle = true;
                    }
                    if (!isSubBundle && (bundleByType = bundleInfoGroup.getBundleByType(1)) != null && bundleByType.isSubBundle()) {
                        mainBudble = bundleByType.getMainBudble();
                        isSubBundle = true;
                    }
                }
                if (isSubBundle) {
                    return checkSubBundleValid(mainBudble, bundleInfo.getPackageName(), bundleInfo.getVersionCode());
                }
                if (bundleInfo.isMainBundle()) {
                    return checkMainBundleValid(bundleInfo.getSubBundle(), false);
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean checkPresetBundleWithDownload(BundleInfo bundleInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, this, bundleInfo, z)) == null) {
            if (!hasValidPresetBundle(bundleInfo.getPackageName(), z) || this.mPresetInfoMap.get(bundleInfo.getPackageName()).getVersionCode() < bundleInfo.getVersionCode()) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
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

    private void updateBundleInfos(String str, long j) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65577, this, str, j) == null) {
            if ("all".equalsIgnoreCase(str)) {
                initBundleInfoFromDB(j);
                return;
            }
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup != null) {
                j2 = bundleInfoGroup.getTimeStamp();
            } else {
                j2 = 0;
            }
            if (j > j2) {
                this.mBundleInfoGroupMap.put(str, me1.j().i(str, j));
            }
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
                            if (it.hasNext()) {
                                SubBundleInfo next = it.next();
                                if (bundleByType2.getPackageName().equals(next.getPackageName())) {
                                    i2 = next.getMinVersion();
                                    i3 = next.getMaxVersion();
                                    break;
                                }
                            } else {
                                i2 = -1;
                                i3 = -1;
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
            Bundle e2 = me1.j().e(bundleByType2);
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

    private boolean hasValidPresetBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        int versionCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, this, str, z)) == null) {
            initIfNeed();
            BundleInfo bundleInfo = this.mPresetInfoMap.get(str);
            if (bundleInfo == null) {
                return false;
            }
            BundleInfo bundleInfo2 = null;
            BundleInfoGroup bundleInfoGroup = this.mBundleInfoGroupMap.get(str);
            if (bundleInfoGroup != null) {
                bundleInfo2 = bundleInfoGroup.getBundleByType(3);
            }
            if (bundleInfo.getVersionCode() < ie1.b().c(str)) {
                return false;
            }
            if (bundleInfo2 == null) {
                versionCode = 0;
            } else {
                versionCode = bundleInfo2.getVersionCode();
            }
            if (bundleInfo.getVersionCode() <= versionCode) {
                return false;
            }
            if (z) {
                if (ze1.a()) {
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

    private int initPresetInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            Bundle k = me1.j().k();
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

    private void sendResartAlert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            xd1.a().c(applicationContext.getString(R.string.obfuscated_res_0x7f0f026d), applicationContext.getString(R.string.obfuscated_res_0x7f0f026b), new h(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f0269), new i(this, countDownLatch), applicationContext.getString(R.string.obfuscated_res_0x7f0f026a));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public int fetchBundleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Bundle f2 = me1.j().f();
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

    private int installBundle(BundleInfo bundleInfo, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{bundleInfo, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (ze1.a() && z) {
                Log.d(TAG, "installBundle multiBundleEnable=true pkg=" + bundleInfo.getPackageName());
            }
            Bundle l = me1.j().l(bundleInfo, z);
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

    public int getBundleStatus(String str, boolean z, BundleConfig bundleConfig) {
        InterceptResult invokeCommon;
        boolean hasValidPresetBundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), bundleConfig})) == null) {
            if (TextUtils.isEmpty(str)) {
                if (ze1.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=5");
                    return 5;
                }
                return 5;
            }
            initIfNeed();
            if (!isValidPackageName(str)) {
                if (ze1.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=15");
                    return 15;
                }
                return 15;
            } else if (needForceUpdate(str)) {
                if (ze1.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=44");
                }
                return 44;
            } else if (hasValidInstalledBundle(str, z)) {
                if (ze1.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            } else {
                boolean z2 = false;
                if (bundleConfig != null && bundleConfig.skipPresetBundle) {
                    hasValidPresetBundle = false;
                } else {
                    hasValidPresetBundle = hasValidPresetBundle(str, z);
                }
                if (bundleConfig == null || !bundleConfig.skipDownloadedBundle) {
                    z2 = hasValidDownloadedBundle(str, z);
                }
                if (!hasValidPresetBundle && !z2 && !hasValidInstalledBundle(str, z)) {
                    if (ze1.a()) {
                        Log.i(TAG, "getBundleStatus, retCode=44");
                    }
                    return 44;
                }
                if (ze1.a()) {
                    Log.i(TAG, "getBundleStatus, retCode=43");
                }
                return 43;
            }
        }
        return invokeCommon.intValue;
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
            Bundle m = me1.j().m(bundleInfo);
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
            ee1.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBundleInfos(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65576, this, uri) != null) || uri == null) {
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
            ee1.a().b().recordException(1, e2.toString(), "uri=" + uri + ", pathSegments=" + pathSegments.toString());
        }
        updateBundleInfos(str, j);
    }

    public int installLocalBundle(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bundleInfo)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle n = me1.j().n(bundleInfo);
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
            ee1.a().b().recordInstallResult(i2, bundleInfo.getPackageName(), bundleInfo.getVersionCode(), "", statisticExtendInfo);
            return i2;
        }
        return invokeL.intValue;
    }

    private int installPreset(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, bundleInfo)) == null) {
            Bundle o = me1.j().o(bundleInfo);
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

    public int installBundleForDebug(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!new File(str).exists()) {
                return 7;
            }
            PackageInfo a2 = cf1.a(str, 128);
            if (a2 == null) {
                return 8;
            }
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setPackageName(a2.packageName);
            bundleInfo.setVersionCode(a2.versionCode);
            bundleInfo.setApkPath(str);
            return installLocalBundle(bundleInfo);
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
            if (bundleByType != null && !bundleByType.isForbidden()) {
                return false;
            }
            BundleInfo bundleByType2 = bundleInfoGroup.getBundleByType(2);
            if (bundleByType2 != null && !bundleByType2.isForbidden()) {
                return false;
            }
            BundleInfo bundleByType3 = bundleInfoGroup.getBundleByType(1);
            if (bundleByType3 != null && !bundleByType3.isForbidden()) {
                return false;
            }
            if (bundleByType == null && bundleByType2 == null && bundleByType3 == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean needForceUpdate(String str) {
        InterceptResult invokeL;
        BundleInfo bundleInfo;
        int versionCode;
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
            if (bundleInfo2 == null) {
                versionCode = 0;
            } else {
                versionCode = bundleInfo2.getVersionCode();
            }
            BundleInfo bundleInfo3 = this.mPresetInfoMap.get(str);
            if ((bundleInfo3 == null || bundleInfo == null || bundleInfo3.getVersionCode() < bundleInfo.getVersionCode()) && bundleInfo != null && bundleInfo.needForceUpdate() && bundleInfo.getVersionCode() > versionCode) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realInstall(String str, IInstallCallback iInstallCallback, int i2, boolean z, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{str, iInstallCallback, Integer.valueOf(i2), Boolean.valueOf(z), activity}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Uri e2 = hf1.e(str);
            HashMap hashMap = new HashMap();
            b bVar = new b(this, null, iInstallCallback, hashMap);
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(e2, false, bVar);
            String showInstallLoading = showInstallLoading(i2, activity, str);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                hashMap.put(bVar, showInstallLoading);
            }
            int installBundle = installBundle(str, i2, z);
            if (!TextUtils.isEmpty(showInstallLoading)) {
                we1.c(showInstallLoading);
            }
            hashMap.clear();
            this.mInstallingSet.remove(str);
            ContextHolder.getApplicationContext().getContentResolver().unregisterContentObserver(bVar);
            IStatisticManager.StatisticExtendInfo statisticExtendInfo = new IStatisticManager.StatisticExtendInfo();
            statisticExtendInfo.costTime = System.currentTimeMillis() - currentTimeMillis;
            statisticExtendInfo.source = "installBundle";
            ee1.a().b().recordInstallResult(installBundle, str, getBundleVersion(str), "", statisticExtendInfo);
            if (iInstallCallback != null) {
                if (ze1.a()) {
                    Log.i(TAG, "installBundle, retCode=" + installBundle);
                }
                iInstallCallback.onResult(installBundle, "");
            }
        }
    }

    private String showInstallLoading(int i2, Activity activity, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65574, this, i2, activity, str)) == null) {
            if ((i2 & 4) == 0) {
                return null;
            }
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
            return we1.g(activity, ContextHolder.getApplicationContext().getString(R.string.obfuscated_res_0x7f0f09a6), null);
        }
        return (String) invokeILL.objValue;
    }

    public boolean checkSubBundleValid(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        BundleInfoGroup bundleInfoGroup;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2)) == null) {
            if (ze1.a()) {
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
            if (subBundleInfo == null || i2 > subBundleInfo.getMaxVersion() || i2 < subBundleInfo.getMinVersion()) {
                return false;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public void downloadBundle(String str, he1 he1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, he1Var) != null) || he1Var == null) {
            return;
        }
        downloadBundle(str, he1Var, 48);
    }

    public int prepareBundle(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048613, this, str, z)) == null) {
            return prepareBundle(str, 0, z);
        }
        return invokeLZ.intValue;
    }

    public void downloadBundle(String str, he1 he1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, he1Var, i2) == null) {
            downloadBundle(str, false, he1Var, i2, false);
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

    public int prepareBundle(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            return prepareBundle(str, i2, z, null);
        }
        return invokeCommon.intValue;
    }

    public void downloadBundle(String str, he1 he1Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, he1Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            downloadBundle(str, false, he1Var, i2, z);
        }
    }

    public void downloadBundle(String str, boolean z, he1 he1Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), he1Var, Integer.valueOf(i2)}) == null) {
            downloadBundle(str, z, he1Var, i2, false);
        }
    }

    public void downloadBundle(String str, boolean z, he1 he1Var, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), he1Var, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            fe1.a().b().run(new c(this, he1Var, str, z2, z));
        }
    }

    public void downloadUpdatePackage(String str, he1 he1Var, je1 je1Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, he1Var, je1Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            fe1.a().b().run(new e(this, str, he1Var, i2, je1Var, z));
        }
    }

    public synchronized void installBundle(String str, int i2, boolean z, IInstallCallback iInstallCallback, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), iInstallCallback, activity}) == null) {
            synchronized (this) {
                if (this.mInstallingSet.contains(str) && iInstallCallback != null) {
                    if (ze1.a()) {
                        Log.i(TAG, "installBundle, retCode=34");
                    }
                    iInstallCallback.onResult(34, "");
                    return;
                }
                this.mInstallingSet.add(str);
                fe1.a().b().run(new a(this, i2, str, z, iInstallCallback, activity));
            }
        }
    }

    public void installBundle(String str, boolean z, IInstallCallback iInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Boolean.valueOf(z), iInstallCallback}) == null) {
            installBundle(str, 0, z, iInstallCallback, null);
        }
    }

    public void preDownload(String str, he1 he1Var, int i2, SourceData sourceData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, he1Var, Integer.valueOf(i2), sourceData, Boolean.valueOf(z)}) == null) {
            fe1.a().b().run(new d(this, str, i2, he1Var, z));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0096, code lost:
        if (r4 == 13) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int prepareBundle(String str, int i2, boolean z, BundleConfig bundleConfig) {
        InterceptResult invokeCommon;
        boolean hasValidPresetBundle;
        boolean hasValidDownloadedBundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), bundleConfig})) == null) {
            initIfNeed();
            if (!isValidPackageName(str)) {
                return 15;
            }
            if (isForbidden(str)) {
                return 42;
            }
            if (needForceUpdate(str)) {
                return 44;
            }
            boolean z2 = false;
            if (bundleConfig != null && bundleConfig.skipPresetBundle) {
                hasValidPresetBundle = false;
            } else {
                hasValidPresetBundle = hasValidPresetBundle(str, z);
            }
            if (bundleConfig != null && bundleConfig.skipDownloadedBundle) {
                hasValidDownloadedBundle = false;
            } else {
                hasValidDownloadedBundle = hasValidDownloadedBundle(str, z);
            }
            if (!hasValidPresetBundle && !hasValidDownloadedBundle && !hasValidInstalledBundle(str, z)) {
                return 44;
            }
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
                    if (hasValidInstalledBundle(str, z)) {
                        return 41;
                    }
                    return 23;
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
            if (hasValidInstalledBundle(str, z)) {
                return 41;
            }
            return 45;
        }
        return invokeCommon.intValue;
    }
}
