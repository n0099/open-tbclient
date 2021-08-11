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
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39087a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f39088b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static a f39089c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f39090d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, b> f39091e;

    /* renamed from: f  reason: collision with root package name */
    public Context f39092f;

    /* renamed from: com.baidu.fsg.base.a.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1643a {
        void a(com.baidu.fsg.base.a.b bVar);
    }

    /* loaded from: classes5.dex */
    public final class b extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39093a;

        /* renamed from: b  reason: collision with root package name */
        public final com.baidu.fsg.base.a.b f39094b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<InterfaceC1643a> f39095c;

        /* renamed from: d  reason: collision with root package name */
        public long f39096d;

        /* renamed from: e  reason: collision with root package name */
        public long f39097e;

        /* renamed from: f  reason: collision with root package name */
        public int f39098f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context, long j2) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2)};
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
            this.f39093a = aVar;
            this.f39095c = new HashSet<>();
            this.f39096d = 0L;
            this.f39097e = 0L;
            this.f39098f = 1;
            this.f39094b = new com.baidu.fsg.base.a.b(j2);
        }

        public /* synthetic */ b(a aVar, Context context, long j2, AnonymousClass1 anonymousClass1) {
            this(aVar, context, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(InterfaceC1643a interfaceC1643a) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, interfaceC1643a)) == null) {
                synchronized (this) {
                    add = this.f39095c.add(interfaceC1643a);
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
                    this.f39095c.clear();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(InterfaceC1643a interfaceC1643a) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, interfaceC1643a)) == null) {
                synchronized (this) {
                    remove = this.f39095c.remove(interfaceC1643a);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39095c.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            com.baidu.fsg.base.a.b bVar;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                super.onChange(z);
                this.f39093a.a(this.f39094b);
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f39098f == this.f39094b.a() && this.f39096d == this.f39094b.b()) || this.f39097e == currentTimeMillis) {
                    return;
                }
                if (2 == this.f39094b.a()) {
                    bVar = this.f39094b;
                    j2 = ((bVar.b() - this.f39096d) * 1000) / (currentTimeMillis - this.f39097e);
                } else {
                    bVar = this.f39094b;
                    j2 = 0;
                }
                bVar.c(j2);
                this.f39096d = this.f39094b.b();
                this.f39098f = this.f39094b.a();
                this.f39097e = currentTimeMillis;
                synchronized (this) {
                    int size = this.f39095c.size();
                    InterfaceC1643a[] interfaceC1643aArr = new InterfaceC1643a[size];
                    this.f39095c.toArray(interfaceC1643aArr);
                    for (int i2 = 0; i2 < size; i2++) {
                        interfaceC1643aArr[i2].a(this.f39094b);
                    }
                }
            }
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
        this.f39091e = new HashMap<>();
        this.f39092f = null;
        this.f39092f = context;
        this.f39090d = (DownloadManager) context.getSystemService("download");
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f39089c == null) {
                f39089c = new a(context);
            }
            return f39089c;
        }
        return (a) invokeL.objValue;
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
                return this.f39090d.enqueue(b(str, str2, str3, z, z2, z3, str4));
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
                return this.f39090d.enqueue(b(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f39090d.remove(j2);
        }
    }

    public void a(Context context, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, context, j2) == null) || j2 == -1 || (bVar = this.f39091e.get(Long.valueOf(j2))) == null) {
            return;
        }
        bVar.b();
        context.getContentResolver().unregisterContentObserver(bVar);
        this.f39091e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    public void a(Context context, long j2, InterfaceC1643a interfaceC1643a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), interfaceC1643a}) == null) || interfaceC1643a == null || -1 == j2) {
            return;
        }
        b bVar = this.f39091e.get(Long.valueOf(j2));
        if (bVar == null) {
            bVar = new b(this, context, j2, null);
            this.f39091e.put(Long.valueOf(j2), bVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, bVar);
        }
        bVar.a(interfaceC1643a);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public void a(com.baidu.fsg.base.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || -1 == bVar.d()) {
            return;
        }
        Cursor query = this.f39090d.query(new DownloadManager.Query().setFilterById(bVar.d()));
        if (query != null) {
            try {
                if (query.getCount() != 0 && query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bytes_so_far");
                    int columnIndex = query.getColumnIndex("status");
                    long j2 = query.getLong(columnIndexOrThrow);
                    long j3 = query.getLong(columnIndexOrThrow2);
                    int i2 = query.getInt(columnIndex);
                    bVar.b(j2);
                    bVar.a(j3);
                    bVar.a(i2);
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
        bVar.a(0L);
        bVar.b(-1L);
        bVar.a(1);
    }

    public com.baidu.fsg.base.a.b b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            if (j2 == -1) {
                return null;
            }
            com.baidu.fsg.base.a.b bVar = new com.baidu.fsg.base.a.b(j2);
            a(bVar);
            return bVar;
        }
        return (com.baidu.fsg.base.a.b) invokeJ.objValue;
    }

    public void b(Context context, long j2, InterfaceC1643a interfaceC1643a) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j2), interfaceC1643a}) == null) || j2 == -1 || (bVar = this.f39091e.get(Long.valueOf(j2))) == null) {
            return;
        }
        bVar.b(interfaceC1643a);
        if (bVar.a()) {
            context.getContentResolver().unregisterContentObserver(bVar);
            this.f39091e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }
}
