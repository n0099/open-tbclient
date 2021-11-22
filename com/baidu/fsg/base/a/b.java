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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38145a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38146b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static b f38147c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f38148d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, C1647b> f38149e;

    /* renamed from: f  reason: collision with root package name */
    public Context f38150f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.baidu.fsg.base.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1647b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c f38151a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<a> f38152b;

        /* renamed from: c  reason: collision with root package name */
        public long f38153c;

        /* renamed from: d  reason: collision with root package name */
        public long f38154d;

        /* renamed from: e  reason: collision with root package name */
        public int f38155e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f38156f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1647b(b bVar, Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, Long.valueOf(j)};
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
            this.f38156f = bVar;
            this.f38152b = new HashSet<>();
            this.f38153c = 0L;
            this.f38154d = 0L;
            this.f38155e = 1;
            this.f38151a = new c(j);
        }

        public /* synthetic */ C1647b(b bVar, Context context, long j, com.baidu.fsg.base.a.a aVar) {
            this(bVar, context, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(a aVar) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
                synchronized (this) {
                    add = this.f38152b.add(aVar);
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
                    this.f38152b.clear();
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
                    remove = this.f38152b.remove(aVar);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38152b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c cVar;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f38156f.a(this.f38151a);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f38155e == this.f38151a.c() && this.f38153c == this.f38151a.a()) || this.f38154d == currentTimeMillis) {
                    return;
                }
                if (2 == this.f38151a.c()) {
                    cVar = this.f38151a;
                    j = ((cVar.a() - this.f38153c) * 1000) / (currentTimeMillis - this.f38154d);
                } else {
                    cVar = this.f38151a;
                    j = 0;
                }
                cVar.b(j);
                this.f38153c = this.f38151a.a();
                this.f38155e = this.f38151a.c();
                this.f38154d = currentTimeMillis;
                synchronized (this) {
                    int size = this.f38152b.size();
                    a[] aVarArr = new a[size];
                    this.f38152b.toArray(aVarArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        aVarArr[i2].a(this.f38151a);
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
        this.f38149e = new HashMap<>();
        this.f38150f = null;
        this.f38150f = context;
        this.f38148d = (DownloadManager) context.getSystemService("download");
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f38147c == null) {
                f38147c = new b(context);
            }
            return f38147c;
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
                return this.f38148d.enqueue(b(str, str2, str3, z, z2, z3, str4));
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
                return this.f38148d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f38148d.remove(j);
        }
    }

    public void a(Context context, long j) {
        C1647b c1647b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j) == null) || j == -1 || (c1647b = this.f38149e.get(Long.valueOf(j))) == null) {
            return;
        }
        c1647b.b();
        context.getContentResolver().unregisterContentObserver(c1647b);
        this.f38149e.remove(Uri.parse("content://downloads/my_downloads/" + j));
    }

    public void a(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), aVar}) == null) || aVar == null || -1 == j) {
            return;
        }
        C1647b c1647b = this.f38149e.get(Long.valueOf(j));
        if (c1647b == null) {
            c1647b = new C1647b(this, context, j, null);
            this.f38149e.put(Long.valueOf(j), c1647b);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, c1647b);
        }
        c1647b.a(aVar);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || -1 == cVar.b()) {
            return;
        }
        Cursor query = this.f38148d.query(new DownloadManager.Query().setFilterById(cVar.b()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                    int columnIndex = query.getColumnIndex("status");
                    long j = query.getLong(columnIndexOrThrow);
                    long j2 = query.getLong(columnIndexOrThrow2);
                    int i2 = query.getInt(columnIndex);
                    cVar.c(j);
                    cVar.a(j2);
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

    public c b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (j == -1) {
                return null;
            }
            c cVar = new c(j);
            a(cVar);
            return cVar;
        }
        return (c) invokeJ.objValue;
    }

    public void b(Context context, long j, a aVar) {
        C1647b c1647b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), aVar}) == null) || j == -1 || (c1647b = this.f38149e.get(Long.valueOf(j))) == null) {
            return;
        }
        c1647b.b(aVar);
        if (c1647b.a()) {
            context.getContentResolver().unregisterContentObserver(c1647b);
            this.f38149e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }
}
