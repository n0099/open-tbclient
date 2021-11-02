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
    public static final String f37315a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37316b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static b f37317c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f37318d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, C1610b> f37319e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37320f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.baidu.fsg.base.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1610b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c f37321a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<a> f37322b;

        /* renamed from: c  reason: collision with root package name */
        public long f37323c;

        /* renamed from: d  reason: collision with root package name */
        public long f37324d;

        /* renamed from: e  reason: collision with root package name */
        public int f37325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f37326f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1610b(b bVar, Context context, long j) {
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
            this.f37326f = bVar;
            this.f37322b = new HashSet<>();
            this.f37323c = 0L;
            this.f37324d = 0L;
            this.f37325e = 1;
            this.f37321a = new c(j);
        }

        public /* synthetic */ C1610b(b bVar, Context context, long j, com.baidu.fsg.base.a.a aVar) {
            this(bVar, context, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(a aVar) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
                synchronized (this) {
                    add = this.f37322b.add(aVar);
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
                    this.f37322b.clear();
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
                    remove = this.f37322b.remove(aVar);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37322b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c cVar;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f37326f.a(this.f37321a);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f37325e == this.f37321a.c() && this.f37323c == this.f37321a.a()) || this.f37324d == currentTimeMillis) {
                    return;
                }
                if (2 == this.f37321a.c()) {
                    cVar = this.f37321a;
                    j = ((cVar.a() - this.f37323c) * 1000) / (currentTimeMillis - this.f37324d);
                } else {
                    cVar = this.f37321a;
                    j = 0;
                }
                cVar.b(j);
                this.f37323c = this.f37321a.a();
                this.f37325e = this.f37321a.c();
                this.f37324d = currentTimeMillis;
                synchronized (this) {
                    int size = this.f37322b.size();
                    a[] aVarArr = new a[size];
                    this.f37322b.toArray(aVarArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        aVarArr[i2].a(this.f37321a);
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
        this.f37319e = new HashMap<>();
        this.f37320f = null;
        this.f37320f = context;
        this.f37318d = (DownloadManager) context.getSystemService("download");
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f37317c == null) {
                f37317c = new b(context);
            }
            return f37317c;
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
                return this.f37318d.enqueue(b(str, str2, str3, z, z2, z3, str4));
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
                return this.f37318d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f37318d.remove(j);
        }
    }

    public void a(Context context, long j) {
        C1610b c1610b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j) == null) || j == -1 || (c1610b = this.f37319e.get(Long.valueOf(j))) == null) {
            return;
        }
        c1610b.b();
        context.getContentResolver().unregisterContentObserver(c1610b);
        this.f37319e.remove(Uri.parse("content://downloads/my_downloads/" + j));
    }

    public void a(Context context, long j, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), aVar}) == null) || aVar == null || -1 == j) {
            return;
        }
        C1610b c1610b = this.f37319e.get(Long.valueOf(j));
        if (c1610b == null) {
            c1610b = new C1610b(this, context, j, null);
            this.f37319e.put(Long.valueOf(j), c1610b);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, c1610b);
        }
        c1610b.a(aVar);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || -1 == cVar.b()) {
            return;
        }
        Cursor query = this.f37318d.query(new DownloadManager.Query().setFilterById(cVar.b()));
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
        C1610b c1610b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), aVar}) == null) || j == -1 || (c1610b = this.f37319e.get(Long.valueOf(j))) == null) {
            return;
        }
        c1610b.b(aVar);
        if (c1610b.a()) {
            context.getContentResolver().unregisterContentObserver(c1610b);
            this.f37319e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }
}
