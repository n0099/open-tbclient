package c.a.g0.a.c;

import c.a.b0.r.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements c.a.b0.r.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3297b;

        public a(File file, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f3297b = bVar;
        }

        @Override // c.a.b0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
            }
        }

        @Override // c.a.b0.r.p.a
        public void c(Headers headers, InputStream inputStream, int i2) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                try {
                    e.c(inputStream, this.a);
                    if (this.f3297b != null) {
                        this.f3297b.a();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    public static int a(File file) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            int i2 = 0;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i3 = 0;
                    while (i2 < length) {
                        File file2 = listFiles[i2];
                        if (file2.isFile()) {
                            a2 = file2.delete();
                        } else {
                            a2 = a(file2);
                        }
                        i3 += a2;
                        i2++;
                    }
                    i2 = i3;
                }
                if (!file.delete()) {
                    g gVar = g.a;
                    gVar.e("FileUtil", "delete dir " + file.getAbsolutePath() + " failed.");
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static void b(File file, String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, file, str, bVar) == null) {
            k a2 = c.a.b0.r.g.b().a();
            c.a.b0.r.s.d dVar = new c.a.b0.r.s.d();
            dVar.k(str);
            dVar.c();
            a2.b(dVar, new a(file, bVar));
        }
    }

    public static void c(InputStream inputStream, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ReadableByteChannel newChannel = Channels.newChannel(inputStream);
            FileChannel channel = fileOutputStream.getChannel();
            long j2 = 4096;
            long j3 = 0;
            while (j2 > 0) {
                try {
                    j2 = channel.transferFrom(newChannel, j3, 4096L);
                    j3 += j2;
                } finally {
                    j.a(fileOutputStream);
                }
            }
        }
    }
}
