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
/* loaded from: classes5.dex */
public final class ApollonDownloadManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37893a = "WalletDownloadManager";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37894b = "content://downloads/my_downloads/";

    /* renamed from: c  reason: collision with root package name */
    public static ApollonDownloadManager f37895c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final DownloadManager f37896d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Long, a> f37897e;

    /* renamed from: f  reason: collision with root package name */
    public final String f37898f;

    /* renamed from: g  reason: collision with root package name */
    public Context f37899g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f37900h;

    /* renamed from: com.baidu.apollon.downloadmanager.ApollonDownloadManager$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    /* loaded from: classes5.dex */
    public final class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApollonDownloadManager f37901a;

        /* renamed from: b  reason: collision with root package name */
        public DownloadItemInfo f37902b;

        /* renamed from: c  reason: collision with root package name */
        public final HashSet<DownloadListener> f37903c;

        /* renamed from: d  reason: collision with root package name */
        public long f37904d;

        /* renamed from: e  reason: collision with root package name */
        public long f37905e;

        /* renamed from: f  reason: collision with root package name */
        public int f37906f;

        /* renamed from: g  reason: collision with root package name */
        public Context f37907g;

        public /* synthetic */ a(ApollonDownloadManager apollonDownloadManager, Context context, long j2, AnonymousClass1 anonymousClass1) {
            this(apollonDownloadManager, context, j2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onChange(z);
                if (this.f37901a.a(this.f37902b)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f37906f == this.f37902b.getDownloadState() && this.f37904d == this.f37902b.getCurrentBytes()) || this.f37905e == currentTimeMillis) {
                        return;
                    }
                    if (2 == this.f37902b.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.f37902b;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f37904d) * 1000) / (currentTimeMillis - this.f37905e));
                    } else {
                        this.f37902b.setSpeed(0L);
                    }
                    this.f37904d = this.f37902b.getCurrentBytes();
                    this.f37906f = this.f37902b.getDownloadState();
                    this.f37905e = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f37903c.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f37903c.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.f37902b);
                        }
                    }
                    if ((this.f37902b.getDownloadState() & 24) != 0) {
                        this.f37901a.unregisterObserver(this.f37907g, this.f37902b.getDownloadId());
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
            this.f37901a = apollonDownloadManager;
            this.f37903c = new HashSet<>();
            this.f37904d = 0L;
            this.f37905e = 0L;
            this.f37906f = 1;
            this.f37902b = new DownloadItemInfo(j2);
            this.f37907g = DxmApplicationContextImpl.getApplicationContext(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, downloadListener)) == null) {
                synchronized (this) {
                    remove = this.f37903c.remove(downloadListener);
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
                    this.f37903c.clear();
                }
            }
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                this.f37902b = downloadItemInfo;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, downloadListener)) == null) {
                synchronized (this) {
                    add = this.f37903c.add(downloadListener);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37903c.isEmpty() : invokeV.booleanValue;
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
        this.f37897e = new HashMap<>();
        this.f37899g = null;
        this.f37900h = new SparseArray<>();
        this.f37899g = context;
        this.f37896d = (DownloadManager) context.getSystemService("download");
        this.f37898f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f37895c == null) {
                f37895c = new ApollonDownloadManager(context);
            }
            return f37895c;
        }
        return (ApollonDownloadManager) invokeL.objValue;
    }

    public void cancelDownload(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f37896d.remove(j2);
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
                this.f37900h.put(hashCode, a3);
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
                return this.f37896d.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
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
        a aVar = this.f37897e.get(Long.valueOf(j2));
        if (aVar == null) {
            aVar = new a(this, context, j2, null);
            this.f37897e.put(Long.valueOf(j2), aVar);
            context.getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + j2), true, aVar);
        }
        aVar.a(downloadListener);
    }

    public void unregisterObserver(Context context, long j2, DownloadListener downloadListener) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j2), downloadListener}) == null) || j2 == -1 || (aVar = this.f37897e.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b(downloadListener);
        if (aVar.a()) {
            context.getContentResolver().unregisterContentObserver(aVar);
            this.f37897e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String str2 = str.startsWith(this.f37898f) ? null : this.f37898f;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f37898f.length()) : str;
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
                return this.f37896d.enqueue(a(str, str2, str3, z, z2, z3, str4));
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
        DownloadManager.Request request = this.f37900h.get(i2, null);
        if (request != null) {
            this.f37900h.delete(i2);
        }
        ContentResolver contentResolver = this.f37899g.getContentResolver();
        a remove = this.f37897e.remove(Long.valueOf(i2));
        if (remove == null) {
            return;
        }
        contentResolver.unregisterContentObserver(remove);
        long enqueue = this.f37896d.enqueue(request);
        this.f37897e.put(Long.valueOf(enqueue), remove);
        remove.a(new DownloadItemInfo(enqueue));
        contentResolver.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, remove);
    }

    public void unregisterObserver(Context context, long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, context, j2) == null) || j2 == -1 || (aVar = this.f37897e.get(Long.valueOf(j2))) == null) {
            return;
        }
        aVar.b();
        context.getContentResolver().unregisterContentObserver(aVar);
        this.f37897e.remove(Uri.parse("content://downloads/my_downloads/" + j2));
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
                cursor = this.f37896d.query(new DownloadManager.Query().setFilterById(downloadItemInfo.getDownloadId()));
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
