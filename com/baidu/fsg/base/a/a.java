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
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5122a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5123b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static a f5124c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f5125d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, b> f5126e;

    /* renamed from: f  reason: collision with root package name */
    public Context f5127f;

    /* renamed from: com.baidu.fsg.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0096a {
        void a(c cVar);
    }

    /* loaded from: classes2.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5128a;

        /* renamed from: b  reason: collision with root package name */
        public final c f5129b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<InterfaceC0096a> f5130c;

        /* renamed from: d  reason: collision with root package name */
        public long f5131d;

        /* renamed from: e  reason: collision with root package name */
        public long f5132e;

        /* renamed from: f  reason: collision with root package name */
        public int f5133f;

        public /* synthetic */ b(a aVar, Context context, long j, com.baidu.fsg.base.a.b bVar) {
            this(aVar, context, j);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f5128a.a(this.f5129b);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f5133f == this.f5129b.a() && this.f5131d == this.f5129b.b()) || this.f5132e == currentTimeMillis) {
                    return;
                }
                if (2 == this.f5129b.a()) {
                    c cVar = this.f5129b;
                    cVar.c(((cVar.b() - this.f5131d) * 1000) / (currentTimeMillis - this.f5132e));
                } else {
                    this.f5129b.c(0L);
                }
                this.f5131d = this.f5129b.b();
                this.f5133f = this.f5129b.a();
                this.f5132e = currentTimeMillis;
                synchronized (this) {
                    int size = this.f5130c.size();
                    InterfaceC0096a[] interfaceC0096aArr = new InterfaceC0096a[size];
                    this.f5130c.toArray(interfaceC0096aArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        interfaceC0096aArr[i2].a(this.f5129b);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j)};
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
            this.f5128a = aVar;
            this.f5130c = new HashSet<>();
            this.f5131d = 0L;
            this.f5132e = 0L;
            this.f5133f = 1;
            this.f5129b = new c(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(InterfaceC0096a interfaceC0096a) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, interfaceC0096a)) == null) {
                synchronized (this) {
                    remove = this.f5130c.remove(interfaceC0096a);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(InterfaceC0096a interfaceC0096a) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, interfaceC0096a)) == null) {
                synchronized (this) {
                    add = this.f5130c.add(interfaceC0096a);
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
                    this.f5130c.clear();
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5130c.isEmpty() : invokeV.booleanValue;
        }
    }

    public a(Context context) {
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
        this.f5126e = new HashMap<>();
        this.f5127f = null;
        this.f5127f = context;
        this.f5125d = (DownloadManager) context.getSystemService("download");
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f5124c == null) {
                f5124c = new a(context);
            }
            return f5124c;
        }
        return (a) invokeL.objValue;
    }

    public void b(Context context, long j, InterfaceC0096a interfaceC0096a) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), interfaceC0096a}) == null) || j == -1 || (bVar = this.f5126e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b(interfaceC0096a);
        if (bVar.a()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f5126e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    public void a(Context context, long j, InterfaceC0096a interfaceC0096a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), interfaceC0096a}) == null) || interfaceC0096a == null || -1 == j) {
            return;
        }
        b bVar = this.f5126e.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = new b(this, context, j, null);
            this.f5126e.put(Long.valueOf(j), bVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, bVar);
        }
        bVar.a(interfaceC0096a);
    }

    private DownloadManager.Request b(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str3));
            if (z3) {
                request.setAllowedNetworkTypes(2);
            } else {
                request.setAllowedNetworkTypes(3);
            }
            request.setShowRunningNotification(z);
            request.setVisibleInDownloadsUi(z2);
            request.setDestinationInExternalPublicDir(str, str2 + str4);
            return request;
        }
        return (DownloadManager.Request) invokeCommon.objValue;
    }

    public void a(Context context, long j) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j) == null) || j == -1 || (bVar = this.f5126e.get(Long.valueOf(j))) == null) {
            return;
        }
        bVar.b();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f5126e.remove(Uri.parse("content://downloads/my_downloads/" + j));
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

    public long a(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                return this.f5125d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public long a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1L;
            }
            if (str3.startsWith("http://") || str3.startsWith("https://")) {
                return this.f5125d.enqueue(b(str, str2, str3, z, z2, z3, str4));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f5125d.remove(j);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || -1 == cVar.d()) {
            return;
        }
        Cursor query = this.f5125d.query(new DownloadManager.Query().setFilterById(cVar.d()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                    int columnIndex = query.getColumnIndex("status");
                    long j = query.getLong(columnIndexOrThrow);
                    long j2 = query.getLong(columnIndexOrThrow2);
                    int i2 = query.getInt(columnIndex);
                    cVar.b(j);
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
        cVar.b(-1L);
        cVar.a(1);
    }
}
