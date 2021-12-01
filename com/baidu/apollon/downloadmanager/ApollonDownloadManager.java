package com.baidu.apollon.downloadmanager;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
@TargetApi(9)
/* loaded from: classes8.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f32939b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static ApollonDownloadManager f32940c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f32941d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, a> f32942e;

    /* renamed from: f  reason: collision with root package name */
    public final String f32943f;

    /* renamed from: g  reason: collision with root package name */
    public Context f32944g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f32945h;

    /* renamed from: com.baidu.apollon.downloadmanager.ApollonDownloadManager$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes8.dex */
    public final class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ApollonDownloadManager a;

        /* renamed from: b  reason: collision with root package name */
        public DownloadItemInfo f32946b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<DownloadListener> f32947c;

        /* renamed from: d  reason: collision with root package name */
        public long f32948d;

        /* renamed from: e  reason: collision with root package name */
        public long f32949e;

        /* renamed from: f  reason: collision with root package name */
        public int f32950f;

        /* renamed from: g  reason: collision with root package name */
        public Context f32951g;

        public /* synthetic */ a(ApollonDownloadManager apollonDownloadManager, Context context, long j2, AnonymousClass1 anonymousClass1) {
            this(apollonDownloadManager, context, j2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onChange(z);
                if (this.a.a(this.f32946b)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f32950f == this.f32946b.getDownloadState() && this.f32948d == this.f32946b.getCurrentBytes()) || this.f32949e == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.f32946b.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.f32946b;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f32948d) * 1000) / (currentTimeMillis - this.f32949e));
                    } else {
                        this.f32946b.setSpeed(0L);
                    }
                    this.f32948d = this.f32946b.getCurrentBytes();
                    this.f32950f = this.f32946b.getDownloadState();
                    this.f32949e = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f32947c.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f32947c.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.f32946b);
                        }
                    }
                    if ((this.f32946b.getDownloadState() & 24) != 0) {
                        this.a.unregisterObserver(this.f32951g, this.f32946b.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApollonDownloadManager apollonDownloadManager, Context context, long j2) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apollonDownloadManager, context, Long.valueOf(j2)};
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
            this.a = apollonDownloadManager;
            this.f32947c = new HashSet<>();
            this.f32948d = 0L;
            this.f32949e = 0L;
            this.f32950f = 1;
            this.f32946b = new DownloadItemInfo(j2);
            this.f32951g = DxmApplicationContextImpl.getApplicationContext(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f32947c.remove(downloadListener);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                synchronized (this) {
                    this.f32947c.clear();
                }
            }
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.f32946b = downloadItemInfo;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f32947c.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32947c.isEmpty() : invokeV.booleanValue;
        }
    }

    public ApollonDownloadManager(Context context) {
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
        this.f32942e = new HashMap<>();
        this.f32944g = null;
        this.f32945h = new SparseArray<>();
        this.f32944g = context;
        this.f32941d = (DownloadManager) context.getSystemService("download");
        this.f32943f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (f32940c == null) {
                f32940c = new ApollonDownloadManager(context);
            }
            return f32940c;
        }
        return (ApollonDownloadManager) invokeL.objValue;
    }

    public void cancelDownload(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f32941d.remove(j2);
        }
    }

    public int createTask(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1;
            }
            if ((str3.startsWith("http://") || str3.startsWith("https://")) && (a2 = a(str2)) != null) {
                DownloadManager.Request a3 = a(str, a2, str3, z, z2, z3, str4);
                int hashCode = a3.hashCode();
                this.f32945h.put(hashCode, a3);
                return hashCode;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public long doDownload(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                return this.f32941d.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public DownloadItemInfo queryDownloadData(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 == -1) {
                return null;
            }
            DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j2);
            a(downloadItemInfo);
            return downloadItemInfo;
        }
        return (DownloadItemInfo) invokeJ.objValue;
    }

    public void registerObserver(Context context, long j2, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) || downloadListener == null || -1 == j2) {
            return;
        }
        a aVar = this.f32942e.get(Long.valueOf(j2));
        if (aVar == null) {
            aVar = new a(this, context, j2, null);
            this.f32942e.put(Long.valueOf(j2), aVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, aVar);
        }
        aVar.a(downloadListener);
    }

    public void unregisterObserver(Context context, long j2, DownloadListener downloadListener) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) || j2 == -1 || (aVar = this.f32942e.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b(downloadListener);
        if (aVar.a()) {
            context.getContentResolver().unregisterContentObserver(aVar);
            this.f32942e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String str2 = str.startsWith(this.f32943f) ? null : this.f32943f;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f32943f.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
            if (TextUtils.isEmpty(str3)) {
                return -1L;
            }
            if (str3.startsWith("http://") || str3.startsWith("https://")) {
                return this.f32941d.enqueue(a(str, str2, str3, z, z2, z3, str4));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public void doDownload(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || -1 == i2) {
            return;
        }
        DownloadManager.Request request = this.f32945h.get(i2, null);
        if (request != null) {
            this.f32945h.delete(i2);
        }
        ContentResolver contentResolver = this.f32944g.getContentResolver();
        a remove = this.f32942e.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f32941d.enqueue(request);
        this.f32942e.put(Long.valueOf(enqueue), remove);
        remove.a(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }

    public void unregisterObserver(Context context, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, context, j2) == null) || j2 == -1 || (aVar = this.f32942e.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b();
        context.getContentResolver().unregisterContentObserver(aVar);
        this.f32942e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
    }

    private DownloadManager.Request a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str4})) == null) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (0 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(DownloadItemInfo downloadItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, downloadItemInfo)) == null) {
            if (-1 == downloadItemInfo.getDownloadId()) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = this.f32941d.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
            } catch (Exception unused) {
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst()) {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                int columnIndex = cursor.getColumnIndex("status");
                long j2 = cursor.getLong(columnIndexOrThrow);
                long j3 = cursor.getLong(columnIndexOrThrow2);
                int i2 = cursor.getInt(columnIndex);
                downloadItemInfo.setTotalBytes(j2);
                downloadItemInfo.setCurrentBytes(j3);
                downloadItemInfo.setDownloadState(i2);
                if (cursor != null) {
                    cursor.close();
                }
                return true;
            }
            downloadItemInfo.setCurrentBytes(0L);
            downloadItemInfo.setTotalBytes(-1L);
            downloadItemInfo.setDownloadState(1);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
