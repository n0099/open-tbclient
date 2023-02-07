package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypefaceCompatUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CACHE_FILE_PREFIX = ".font";
    public static final String TAG = "TypefaceCompatUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public TypefaceCompatUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, resources, i)) == null) {
            File tempFile = getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!copyToFile(tempFile, resources, i)) {
                    return null;
                }
                return mmap(tempFile);
            } finally {
                tempFile.delete();
            }
        }
        return (ByteBuffer) invokeLLI.objValue;
    }

    @NonNull
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(@NonNull Context context, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, @Nullable CancellationSignal cancellationSignal) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, fontInfoArr, cancellationSignal)) == null) {
            HashMap hashMap = new HashMap();
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                if (fontInfo.getResultCode() == 0) {
                    Uri uri = fontInfo.getUri();
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, mmap(context, cancellationSignal, uri));
                    }
                }
            }
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLLL.objValue;
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream;
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, file, resources, i)) == null) {
            try {
                inputStream = resources.openRawResource(i);
                try {
                    boolean copyToFile = copyToFile(file, inputStream);
                    closeQuietly(inputStream);
                    return copyToFile;
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } else {
            return invokeLLI.booleanValue;
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, inputStream)) == null) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        closeQuietly(fileOutputStream);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                closeQuietly(fileOutputStream2);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                closeQuietly(fileOutputStream2);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    @Nullable
    public static File getTempFile(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = CACHE_FILE_PREFIX + Process.myPid() + "-" + Process.myTid() + "-";
            for (int i = 0; i < 100; i++) {
                File file = new File(cacheDir, str + i);
                if (file.createNewFile()) {
                    return file;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, cancellationSignal, uri)) == null) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return map;
            } catch (IOException unused) {
                return null;
            }
        }
        return (ByteBuffer) invokeLLL.objValue;
    }

    @Nullable
    @RequiresApi(19)
    public static ByteBuffer mmap(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } catch (IOException unused) {
                return null;
            }
        }
        return (ByteBuffer) invokeL.objValue;
    }
}
