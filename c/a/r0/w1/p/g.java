package c.a.r0.w1.p;

import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static g f28093c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28094a;

    /* renamed from: b  reason: collision with root package name */
    public int f28095b;

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f28096a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f28097b;

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
            this.f28097b = gVar;
            this.f28096a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (this.f28097b.f28095b >= 3) {
                    this.f28097b.f28095b = 0;
                    CyberPlayerManager.InstallListener installListener = this.f28096a;
                    if (installListener != null) {
                        installListener.onInstallError(i2, i3, str);
                        return;
                    }
                    return;
                }
                g.c(this.f28097b);
                this.f28097b.g(this.f28096a);
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
                this.f28097b.f28095b = 0;
                this.f28097b.f28094a = true;
                CyberPlayerManager.InstallListener installListener = this.f28096a;
                if (installListener != null) {
                    installListener.onInstallSuccess(i2, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CyberPlayerManager.InstallListener f28098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f28099b;

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
            this.f28099b = gVar;
            this.f28098a = installListener;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                if (this.f28099b.f28095b >= 3) {
                    this.f28099b.f28095b = 0;
                    CyberPlayerManager.InstallListener installListener = this.f28098a;
                    if (installListener != null) {
                        installListener.onInstallError(i2, i3, str);
                        return;
                    }
                    return;
                }
                g.c(this.f28099b);
                this.f28099b.g(this.f28098a);
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
                this.f28099b.f28095b = 0;
                this.f28099b.f28094a = true;
                CyberPlayerManager.InstallListener installListener = this.f28098a;
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
        this.f28094a = true;
    }

    public static /* synthetic */ int c(g gVar) {
        int i2 = gVar.f28095b;
        gVar.f28095b = i2 + 1;
        return i2;
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f28093c == null) {
                i();
            }
            return f28093c;
        }
        return (g) invokeV.objValue;
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            synchronized (g.class) {
                if (f28093c == null) {
                    f28093c = new g();
                }
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean isCoreLoaded = CyberPlayerManager.isCoreLoaded(3);
            if (isCoreLoaded && !this.f28094a) {
                this.f28094a = true;
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
        this.f28094a = false;
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
        this.f28094a = false;
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
