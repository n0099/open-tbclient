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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36741a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f36742b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static ApollonDownloadManager f36743c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f36744d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, a> f36745e;

    /* renamed from: f  reason: collision with root package name */
    public final String f36746f;

    /* renamed from: g  reason: collision with root package name */
    public Context f36747g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f36748h;

    /* renamed from: com.baidu.apollon.downloadmanager.ApollonDownloadManager$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes6.dex */
    public final class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApollonDownloadManager f36749a;

        /* renamed from: b  reason: collision with root package name */
        public DownloadItemInfo f36750b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<DownloadListener> f36751c;

        /* renamed from: d  reason: collision with root package name */
        public long f36752d;

        /* renamed from: e  reason: collision with root package name */
        public long f36753e;

        /* renamed from: f  reason: collision with root package name */
        public int f36754f;

        /* renamed from: g  reason: collision with root package name */
        public Context f36755g;

        public /* synthetic */ a(ApollonDownloadManager apollonDownloadManager, Context context, long j, AnonymousClass1 anonymousClass1) {
            this(apollonDownloadManager, context, j);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onChange(z);
                if (this.f36749a.a(this.f36750b)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f36754f == this.f36750b.getDownloadState() && this.f36752d == this.f36750b.getCurrentBytes()) || this.f36753e == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.f36750b.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.f36750b;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f36752d) * 1000) / (currentTimeMillis - this.f36753e));
                    } else {
                        this.f36750b.setSpeed(0L);
                    }
                    this.f36752d = this.f36750b.getCurrentBytes();
                    this.f36754f = this.f36750b.getDownloadState();
                    this.f36753e = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f36751c.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f36751c.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.f36750b);
                        }
                    }
                    if ((this.f36750b.getDownloadState() & 24) != 0) {
                        this.f36749a.unregisterObserver(this.f36755g, this.f36750b.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApollonDownloadManager apollonDownloadManager, Context context, long j) {
            super(context != null ? new Handler(context.getMainLooper()) : new Handler());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apollonDownloadManager, context, Long.valueOf(j)};
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
            this.f36749a = apollonDownloadManager;
            this.f36751c = new HashSet<>();
            this.f36752d = 0L;
            this.f36753e = 0L;
            this.f36754f = 1;
            this.f36750b = new DownloadItemInfo(j);
            this.f36755g = DxmApplicationContextImpl.getApplicationContext(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f36751c.remove(downloadListener);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                synchronized (this) {
                    this.f36751c.clear();
                }
            }
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.f36750b = downloadItemInfo;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f36751c.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36751c.isEmpty() : invokeV.booleanValue;
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
        this.f36745e = new HashMap<>();
        this.f36747g = null;
        this.f36748h = new SparseArray<>();
        this.f36747g = context;
        this.f36744d = (DownloadManager) context.getSystemService("download");
        this.f36746f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f36743c == null) {
                f36743c = new ApollonDownloadManager(context);
            }
            return f36743c;
        }
        return (ApollonDownloadManager) invokeL.objValue;
    }

    public void cancelDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f36744d.remove(j);
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
                this.f36748h.put(hashCode, a3);
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
                return this.f36744d.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    public DownloadItemInfo queryDownloadData(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            if (j == -1) {
                return null;
            }
            DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j);
            a(downloadItemInfo);
            return downloadItemInfo;
        }
        return (DownloadItemInfo) invokeJ.objValue;
    }

    public void registerObserver(Context context, long j, DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j), downloadListener}) == null) || downloadListener == null || -1 == j) {
            return;
        }
        a aVar = this.f36745e.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a(this, context, j, null);
            this.f36745e.put(Long.valueOf(j), aVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j), true, aVar);
        }
        aVar.a(downloadListener);
    }

    public void unregisterObserver(Context context, long j, DownloadListener downloadListener) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), downloadListener}) == null) || j == -1 || (aVar = this.f36745e.get(Long.valueOf(j))) == null) {
            return;
        }
        aVar.b(downloadListener);
        if (aVar.a()) {
            context.getContentResolver().unregisterContentObserver(aVar);
            this.f36745e.remove(Uri.parse("content://downloads/my_downloads/" + j));
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String str2 = str.startsWith(this.f36746f) ? null : this.f36746f;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f36746f.length()) : str;
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
                return this.f36744d.enqueue(a(str, str2, str3, z, z2, z3, str4));
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
        DownloadManager.Request request = this.f36748h.get(i2, null);
        if (request != null) {
            this.f36748h.delete(i2);
        }
        ContentResolver contentResolver = this.f36747g.getContentResolver();
        a remove = this.f36745e.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f36744d.enqueue(request);
        this.f36745e.put(Long.valueOf(enqueue), remove);
        remove.a(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }

    public void unregisterObserver(Context context, long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, context, j) == null) || j == -1 || (aVar = this.f36745e.get(Long.valueOf(j))) == null) {
            return;
        }
        aVar.b();
        context.getContentResolver().unregisterContentObserver(aVar);
        this.f36745e.remove(Uri.parse("content://downloads/my_downloads/" + j));
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
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
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
                cursor = this.f36744d.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
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
                long j = cursor.getLong(columnIndexOrThrow);
                long j2 = cursor.getLong(columnIndexOrThrow2);
                int i2 = cursor.getInt(columnIndex);
                downloadItemInfo.setTotalBytes(j);
                downloadItemInfo.setCurrentBytes(j2);
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
