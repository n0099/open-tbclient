package com.baidu.fsg.base.a;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39367a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39368b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static b f39369c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f39370d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, C1653b> f39371e;

    /* renamed from: f  reason: collision with root package name */
    public Context f39372f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.baidu.fsg.base.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1653b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c f39373a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<a> f39374b;

        /* renamed from: c  reason: collision with root package name */
        public long f39375c;

        /* renamed from: d  reason: collision with root package name */
        public long f39376d;

        /* renamed from: e  reason: collision with root package name */
        public int f39377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f39378f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1653b(b bVar, Context context, long j2) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Long.valueOf(j2)};
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
            this.f39378f = bVar;
            this.f39374b = new HashSet<>();
            this.f39375c = 0L;
            this.f39376d = 0L;
            this.f39377e = 1;
            this.f39373a = new c(j2);
        }

        public /* synthetic */ C1653b(b bVar, Context context, long j2, com.baidu.fsg.base.a.a aVar) {
            this(bVar, context, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(a aVar) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
                synchronized (this) {
                    add = this.f39374b.add(aVar);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                synchronized (this) {
                    this.f39374b.clear();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(a aVar) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar)) == null) {
                synchronized (this) {
                    remove = this.f39374b.remove(aVar);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39374b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c cVar;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f39378f.a(this.f39373a);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f39377e == this.f39373a.c() && this.f39375c == this.f39373a.a()) || this.f39376d == currentTimeMillis) {
                    return;
                }
                if (2 == this.f39373a.c()) {
                    cVar = this.f39373a;
                    j2 = ((cVar.a() - this.f39375c) * 1000) / (currentTimeMillis - this.f39376d);
                } else {
                    cVar = this.f39373a;
                    j2 = 0;
                }
                cVar.b(j2);
                this.f39375c = this.f39373a.a();
                this.f39377e = this.f39373a.c();
                this.f39376d = currentTimeMillis;
                synchronized (this) {
                    int size = this.f39374b.size();
                    a[] aVarArr = new a[size];
                    this.f39374b.toArray(aVarArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        aVarArr[i2].a(this.f39373a);
                    }
                }
            }
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39371e = new HashMap<>();
        this.f39372f = null;
        this.f39372f = context;
        this.f39370d = (DownloadManager) context.getSystemService("download");
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f39369c == null) {
                f39369c = new b(context);
            }
            return f39369c;
        }
        return (b) invokeL.objValue;
    }

    private DownloadManager.Request b(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str3));
            request.setAllowedNetworkTypes(z3 ? 2 : 3);
            request.setShowRunningNotification(z);
            request.setVisibleInDownloadsUi(z2);
            request.setDestinationInExternalPublicDir(str, str2 + str4);
            return request;
        }
        return (DownloadManager.Request) invokeCommon.objValue;
    }

    public long a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1L;
            }
            if (str3.startsWith("http://") || str3.startsWith("https://")) {
                return this.f39370d.enqueue(b(str, str2, str3, z, z2, z3, str4));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public long a(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                return this.f39370d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f39370d.remove(j2);
        }
    }

    public void a(Context context, long j2) {
        C1653b c1653b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j2) == null) || j2 == -1 || (c1653b = this.f39371e.get(Long.valueOf(j2))) == null) {
            return;
        }
        c1653b.b();
        context.getContentResolver().unregisterContentObserver(c1653b);
        this.f39371e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    public void a(Context context, long j2, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), aVar}) == null) || aVar == null || -1 == j2) {
            return;
        }
        C1653b c1653b = this.f39371e.get(Long.valueOf(j2));
        if (c1653b == null) {
            c1653b = new C1653b(this, context, j2, null);
            this.f39371e.put(Long.valueOf(j2), c1653b);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, c1653b);
        }
        c1653b.a(aVar);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || -1 == cVar.b()) {
            return;
        }
        Cursor query = this.f39370d.query(new DownloadManager.Query().setFilterById(cVar.b()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                    int columnIndex = query.getColumnIndex("status");
                    long j2 = query.getLong(columnIndexOrThrow);
                    long j3 = query.getLong(columnIndexOrThrow2);
                    int i2 = query.getInt(columnIndex);
                    cVar.c(j2);
                    cVar.a(j3);
                    cVar.a(i2);
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        cVar.a(0L);
        cVar.c(-1L);
        cVar.a(1);
    }

    public c b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            if (j2 == -1) {
                return null;
            }
            c cVar = new c(j2);
            a(cVar);
            return cVar;
        }
        return (c) invokeJ.objValue;
    }

    public void b(Context context, long j2, a aVar) {
        C1653b c1653b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j2), aVar}) == null) || j2 == -1 || (c1653b = this.f39371e.get(Long.valueOf(j2))) == null) {
            return;
        }
        c1653b.b(aVar);
        if (c1653b.a()) {
            context.getContentResolver().unregisterContentObserver(c1653b);
            this.f39371e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }
}
