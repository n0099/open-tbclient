package c.a.p0.g.c.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f10864a;

    /* loaded from: classes3.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && download.getState() == Download.DownloadState.FINISH && c.j(download) && !c.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser()) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && download.getState() == Download.DownloadState.FINISH && c.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser()) : invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.p0.g.c.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0544c implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f10865a;

        public C0544c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10865a = cVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? this.f10865a.k(download) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f10866a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10866a = cVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? (download == null || this.f10866a.k(download)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10867a;

        public e(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10867a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.f10867a) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10868a;

        public f(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10868a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.f10868a) && download.getState() == Download.DownloadState.FINISH : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10869a;

        public g(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10869a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.f10869a) && download.getState() == Download.DownloadState.FINISH : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10871b;

        public h(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10871b = cVar;
            this.f10870a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? (download == null || !TextUtils.equals(download.getUrl(), this.f10870a) || this.f10871b.k(download)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10872a;

        public i(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10872a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getKeyByUser(), this.f10872a) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10873a;

        public j(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10873a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && download.getState() == Download.DownloadState.FINISH && download.getKeyByUser().contains(this.f10873a) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10874a;

        public k(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10874a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? download != null && TextUtils.equals(download.getUrl(), this.f10874a) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10875a;

        public l(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10875a = context;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) ? (download == null || download.getState() != Download.DownloadState.FINISH || c.a.p0.g.c.e.a.h(this.f10875a, download.getKeyByUser())) ? false : true : invokeL.booleanValue;
        }
    }

    public c(DownloadManager downloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10864a = downloadManager;
    }

    public static boolean j(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, download)) == null) {
            if (download == null) {
                return false;
            }
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                return false;
            }
            File file = new File(realDownloadDir + File.separator + fileName);
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.f10864a.getDownloadListByFilter(new i(this, str));
                if (downloadListByFilter != null) {
                    z = downloadListByFilter.size() > 0;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.f10864a.getDownloadListByFilter(new j(this, str));
                if (downloadListByFilter != null) {
                    z = downloadListByFilter.size() > 0;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.f10864a.getDownloadListByFilter(new b(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 30;
                if (size <= 0) {
                    return;
                }
                int i2 = 0;
                for (Download download : downloadListByFilter) {
                    if (i2 == size) {
                        return;
                    }
                    if (download != null) {
                        this.f10864a.cancel(download.getId().longValue());
                    }
                    i2++;
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                h(this.f10864a.getDownloadListByFilter(new C0544c(this)));
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.f10864a.getDownloadListByFilter(new a(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 20;
                if (size <= 0) {
                    return;
                }
                int i2 = 0;
                for (Download download : downloadListByFilter) {
                    if (i2 == size) {
                        return;
                    }
                    if (download != null) {
                        this.f10864a.cancel(download.getId().longValue());
                    }
                    i2++;
                }
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        h(r(str));
    }

    public void h(Collection<Download> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, collection) == null) || collection == null) {
            return;
        }
        for (Download download : collection) {
            if (download != null) {
                this.f10864a.cancel(download.getId().longValue());
            }
        }
    }

    public synchronized String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                if (str.endsWith(".huawei")) {
                    return str.replace(".huawei", "");
                }
                if (str.endsWith(".mi")) {
                    return str.replace(".mi", "");
                }
                if (str.endsWith(".nearme.gamecenter")) {
                    return str.replace(".nearme.gamecenter", "");
                }
                if (str.endsWith(".vivo")) {
                    return str.replace(".vivo", "");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final boolean k(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download)) == null) {
            if (download == null) {
                return false;
            }
            return (l(download) || (download.getState() == Download.DownloadState.FINISH && !j(download))) && !c.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), download.getKeyByUser());
        }
        return invokeL.booleanValue;
    }

    public final boolean l(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, download)) == null) ? download != null && (System.currentTimeMillis() - new c.a.p0.g.c.d.a(download).e()) / 86400000 >= 30 : invokeL.booleanValue;
    }

    public void m() {
        Collection<Download> n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (n = n()) == null || n.isEmpty()) {
            return;
        }
        for (Download download : n) {
            if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                this.f10864a.pause(download.getId().longValue());
            }
        }
    }

    public Collection<Download> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f10864a.getDownloadListByFilter(new d(this)) : (Collection) invokeV.objValue;
    }

    public Download o(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Download download = null;
            if (TextUtils.isEmpty(str) || (downloadListByFilter = this.f10864a.getDownloadListByFilter(new e(this, str))) == null) {
                return null;
            }
            for (Download download2 : downloadListByFilter) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public synchronized Collection<Download> p(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            synchronized (this) {
                downloadListByFilter = this.f10864a.getDownloadListByFilter(new g(this, str));
            }
            return downloadListByFilter;
        }
        return (Collection) invokeL.objValue;
    }

    public synchronized Collection<Download> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return this.f10864a.getDownloadListByFilter(new h(this, str));
            }
        }
        return (Collection) invokeL.objValue;
    }

    public synchronized Collection<Download> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return this.f10864a.getDownloadListByFilter(new k(this, str));
            }
        }
        return (Collection) invokeL.objValue;
    }

    public Collection<Download> s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f10864a.getDownloadListByFilter(new f(this, str));
        }
        return (Collection) invokeL.objValue;
    }

    public synchronized Collection<Download> t() {
        InterceptResult invokeV;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                downloadListByFilter = this.f10864a.getDownloadListByFilter(new l(this, AppRuntime.getAppContext()));
            }
            return downloadListByFilter;
        }
        return (Collection) invokeV.objValue;
    }

    public Download u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            Download v = v(str);
            return v == null ? o(str2) : v;
        }
        return (Download) invokeLL.objValue;
    }

    public Download v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            Collection<Download> q = q(str);
            Download download = null;
            if (q == null) {
                return null;
            }
            for (Download download2 : q) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public Download w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            Collection<Download> s = s(str);
            Download download = null;
            if (s != null && s.size() != 0) {
                Iterator<Download> it = s.iterator();
                while (it.hasNext()) {
                    download = it.next();
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public Collection<Download> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Collection<Download> n = n();
            if (n == null || n.isEmpty()) {
                return null;
            }
            for (Download download : n) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                    this.f10864a.resume(download.getId().longValue());
                }
            }
            return n;
        }
        return (Collection) invokeV.objValue;
    }
}
