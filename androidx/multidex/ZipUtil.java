package androidx.multidex;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
/* loaded from: classes.dex */
public final class ZipUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 16384;
    public static final int ENDHDR = 22;
    public static final int ENDSIG = 101010256;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class CentralDirectory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long offset;
        public long size;

        public CentralDirectory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ZipUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, randomAccessFile, centralDirectory)) == null) {
            CRC32 crc32 = new CRC32();
            long j = centralDirectory.size;
            randomAccessFile.seek(centralDirectory.offset);
            byte[] bArr = new byte[16384];
            int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            while (read != -1) {
                crc32.update(bArr, 0, read);
                j -= read;
                if (j == 0) {
                    break;
                }
                read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            }
            return crc32.getValue();
        }
        return invokeLL.longValue;
    }

    public static CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            long length = randomAccessFile.length() - 22;
            if (length >= 0) {
                long j = length - 65536;
                long j2 = j >= 0 ? j : 0L;
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        CentralDirectory centralDirectory = new CentralDirectory();
                        centralDirectory.size = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        centralDirectory.offset = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        return centralDirectory;
                    }
                    length--;
                } while (length >= j2);
                throw new ZipException("End Of Central Directory signature not found");
            }
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        return (CentralDirectory) invokeL.objValue;
    }

    public static long getZipCrc(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f7788a);
            try {
                return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
            } finally {
                randomAccessFile.close();
            }
        }
        return invokeL.longValue;
    }
}
