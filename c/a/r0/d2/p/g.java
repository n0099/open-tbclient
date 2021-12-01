package c.a.r0.d2.p;

import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static g f16583c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f16584b;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberPlayerManager.InstallListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f16585b;

        public a(g gVar, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16585b = gVar;
            this.a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (this.f16585b.f16584b >= 3) {
                    this.f16585b.f16584b = 0;
                    CyberPlayerManager.InstallListener installListener = this.a;
                    if (installListener != null) {
                        installListener.onInstallError(i2, i3, str);
                        return;
                    }
                    return;
                }
                g.c(this.f16585b);
                this.f16585b.g(this.a);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                this.f16585b.f16584b = 0;
                this.f16585b.a = true;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallSuccess(i2, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CyberPlayerManager.InstallListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f16586b;

        public b(g gVar, CyberPlayerManager.InstallListener installListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, installListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16586b = gVar;
            this.a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (this.f16586b.f16584b >= 3) {
                    this.f16586b.f16584b = 0;
                    CyberPlayerManager.InstallListener installListener = this.a;
                    if (installListener != null) {
                        installListener.onInstallError(i2, i3, str);
                        return;
                    }
                    return;
                }
                g.c(this.f16586b);
                this.f16586b.g(this.a);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                this.f16586b.f16584b = 0;
                this.f16586b.a = true;
                CyberPlayerManager.InstallListener installListener = this.a;
                if (installListener != null) {
                    installListener.onInstallSuccess(i2, str);
                }
            }
        }
    }

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
                return;
            }
        }
        this.a = true;
    }

    public static /* synthetic */ int c(g gVar) {
        int i2 = gVar.f16584b;
        gVar.f16584b = i2 + 1;
        return i2;
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f16583c == null) {
                i();
            }
            return f16583c;
        }
        return (g) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (g.class) {
                if (f16583c == null) {
                    f16583c = new g();
                }
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
            if (isCoreLoaded && !this.a) {
                this.a = true;
            }
            return isCoreLoaded;
        }
        return invokeV.booleanValue;
    }

    public void g(CyberPlayerManager.InstallListener installListener) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, installListener) == null) || CyberPlayerManager.isCoreLoaded(3)) {
            return;
        }
        this.a = false;
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir != null) {
            absolutePath = cacheDir.getAbsolutePath();
        } else {
            absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cache-path", absolutePath);
        try {
            CyberPlayerManager.install(TbadkCoreApplication.getInst(), cuidGalaxy2, (String) null, 3, (Class<?>) null, hashMap, new a(this, installListener));
        } catch (Exception unused) {
        }
    }

    public void h(CyberPlayerManager.InstallListener installListener, int i2) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, installListener, i2) == null) || CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        this.a = false;
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir != null) {
            absolutePath = cacheDir.getAbsolutePath();
        } else {
            absolutePath = Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cache-path", absolutePath);
        try {
            CyberPlayerManager.install(TbadkCoreApplication.getInst(), cuidGalaxy2, (String) null, i2, (Class<?>) null, hashMap, new b(this, installListener));
        } catch (Exception unused) {
        }
    }
}
