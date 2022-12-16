package com.baidu.searchbox.dns.cache.disk;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.cache.ICache;
import com.baidu.searchbox.dns.cache.disk.DiskLruCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public class DiskLruCacheHelper implements ICache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_APP_VERSION = 1;
    public static final int DEFAULT_VALUE_COUNT = 1;
    public static final String DIR_NAME = "diskCache";
    public static final int MAX_COUNT = 5242880;
    public static final String TAG = "DiskLruCacheHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public File mDir;
    public DiskLruCache mDiskLruCache;
    public int mMaxCount;

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskLruCacheHelper(Context context) {
        this(context, DIR_NAME, 5242880);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskLruCacheHelper(Context context, File file) {
        this(context, file, 5242880);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (File) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DiskLruCacheHelper(Context context, File file, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mDir = file;
        this.mMaxCount = i;
        this.mDiskLruCache = generateCache(context, file, i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskLruCacheHelper(Context context, String str) {
        this(context, str, 5242880);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public DiskLruCacheHelper(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        File diskCacheDir = getDiskCacheDir(context, str);
        this.mDir = diskCacheDir;
        this.mMaxCount = i;
        this.mDiskLruCache = generateCache(context, diskCacheDir, i);
    }

    private String bytesToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private InputStream getInputStream(String str) {
        InterceptResult invokeL;
        DiskLruCache.Snapshot snapshot;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            try {
                if (this.mDiskLruCache == null || (snapshot = this.mDiskLruCache.get(hashKeyForDisk(str))) == null) {
                    return null;
                }
                return new GZIPInputStream(snapshot.getInputStream(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return (InputStream) invokeL.objValue;
        }
        return null;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            InputStream inputStream = getInputStream(str);
            if (inputStream == null) {
                return null;
            }
            try {
                return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            try {
                String hashKeyForDisk = hashKeyForDisk(str);
                if (this.mDiskLruCache != null) {
                    return this.mDiskLruCache.remove(hashKeyForDisk);
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private DiskLruCache.Editor editor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            try {
                String hashKeyForDisk = hashKeyForDisk(str);
                if (this.mDiskLruCache != null) {
                    return this.mDiskLruCache.edit(hashKeyForDisk);
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (DiskLruCache.Editor) invokeL.objValue;
    }

    private int getAppVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            if (context != null) {
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    private String hashKeyForDisk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return bytesToHexString(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return String.valueOf(str.hashCode());
            }
        }
        return (String) invokeL.objValue;
    }

    public void setMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                diskLruCache.setMaxSize(j);
            }
        }
    }

    private DiskLruCache generateCache(Context context, File file, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, this, context, file, i)) == null) {
            try {
                return DiskLruCache.open(file, getAppVersion(context), 1, i);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (DiskLruCache) invokeLLI.objValue;
    }

    private File getDiskCacheDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, str)) == null) {
            String path = context.getCacheDir().getPath();
            return new File(path + File.separator + str);
        }
        return (File) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                try {
                    diskLruCache.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void close() throws IOException {
        DiskLruCache diskLruCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (diskLruCache = this.mDiskLruCache) != null) {
            diskLruCache.close();
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                diskLruCache.flush();
            }
        }
    }

    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDir;
        }
        return (File) invokeV.objValue;
    }

    public long getMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                return diskLruCache.getMaxSize();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                return diskLruCache.isClosed();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public long size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (isClosed()) {
                this.mDiskLruCache = generateCache(this.mContext, this.mDir, this.mMaxCount);
            }
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                return diskLruCache.size();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0017 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.baidu.searchbox.dns.cache.disk.DiskLruCacheHelper, java.lang.Object] */
    @Override // com.baidu.searchbox.dns.cache.ICache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void put(String str, String str2) {
        ?? r1;
        DiskLruCache.Editor editor;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (isClosed()) {
                Context context = this.mContext;
                r1 = this.mDir;
                this.mDiskLruCache = generateCache(context, r1, this.mMaxCount);
            }
            DiskLruCache.Editor editor2 = null;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    try {
                        try {
                            editor = editor(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    r1 = 0;
                }
                if (editor == null) {
                    return;
                }
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(editor.newOutputStream(0))));
                } catch (IOException e4) {
                    e = e4;
                    bufferedWriter = null;
                }
                try {
                    bufferedWriter.write(str2);
                    editor.commit();
                    bufferedWriter.close();
                } catch (IOException e5) {
                    e = e5;
                    editor2 = editor;
                    r1 = bufferedWriter;
                    e.printStackTrace();
                    try {
                        editor2.abort();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    if (r1 != 0) {
                        r1.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = r1;
                if (bufferedWriter2 != null) {
                }
                throw th;
            }
        }
    }
}
