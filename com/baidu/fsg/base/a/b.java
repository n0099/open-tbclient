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
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f32283b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static b f32284c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f32285d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, C1793b> f32286e;

    /* renamed from: f  reason: collision with root package name */
    public Context f32287f;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.baidu.fsg.base.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C1793b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c a;

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<a> f32288b;

        /* renamed from: c  reason: collision with root package name */
        public long f32289c;

        /* renamed from: d  reason: collision with root package name */
        public long f32290d;

        /* renamed from: e  reason: collision with root package name */
        public int f32291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f32292f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1793b(b bVar, Context context, long j2) {
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
            this.f32292f = bVar;
            this.f32288b = new HashSet<>();
            this.f32289c = 0L;
            this.f32290d = 0L;
            this.f32291e = 1;
            this.a = new c(j2);
        }

        public /* synthetic */ C1793b(b bVar, Context context, long j2, com.baidu.fsg.base.a.a aVar) {
            this(bVar, context, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(a aVar) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
                synchronized (this) {
                    add = this.f32288b.add(aVar);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                synchronized (this) {
                    this.f32288b.clear();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(a aVar) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, aVar)) == null) {
                synchronized (this) {
                    remove = this.f32288b.remove(aVar);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32288b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c cVar;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f32292f.a(this.a);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f32291e == this.a.c() && this.f32289c == this.a.a()) || this.f32290d == currentTimeMillis) {
                    return;
                }
                if (2 == this.a.c()) {
                    cVar = this.a;
                    j2 = ((cVar.a() - this.f32289c) * 1000) / (currentTimeMillis - this.f32290d);
                } else {
                    cVar = this.a;
                    j2 = 0;
                }
                cVar.b(j2);
                this.f32289c = this.a.a();
                this.f32291e = this.a.c();
                this.f32290d = currentTimeMillis;
                synchronized (this) {
                    int size = this.f32288b.size();
                    a[] aVarArr = new a[size];
                    this.f32288b.toArray(aVarArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        aVarArr[i2].a(this.a);
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
        this.f32286e = new HashMap<>();
        this.f32287f = null;
        this.f32287f = context;
        this.f32285d = (DownloadManager) context.getSystemService("download");
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f32284c == null) {
                f32284c = new b(context);
            }
            return f32284c;
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
                return this.f32285d.enqueue(b(str, str2, str3, z, z2, z3, str4));
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
                return this.f32285d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f32285d.remove(j2);
        }
    }

    public void a(Context context, long j2) {
        C1793b c1793b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j2) == null) || j2 == -1 || (c1793b = this.f32286e.get(Long.valueOf(j2))) == null) {
            return;
        }
        c1793b.b();
        context.getContentResolver().unregisterContentObserver(c1793b);
        this.f32286e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    public void a(Context context, long j2, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), aVar}) == null) || aVar == null || -1 == j2) {
            return;
        }
        C1793b c1793b = this.f32286e.get(Long.valueOf(j2));
        if (c1793b == null) {
            c1793b = new C1793b(this, context, j2, null);
            this.f32286e.put(Long.valueOf(j2), c1793b);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, c1793b);
        }
        c1793b.a(aVar);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || -1 == cVar.b()) {
            return;
        }
        Cursor query = this.f32285d.query(new DownloadManager.Query().setFilterById(cVar.b()));
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
        C1793b c1793b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j2), aVar}) == null) || j2 == -1 || (c1793b = this.f32286e.get(Long.valueOf(j2))) == null) {
            return;
        }
        c1793b.b(aVar);
        if (c1793b.a()) {
            context.getContentResolver().unregisterContentObserver(c1793b);
            this.f32286e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }
}
