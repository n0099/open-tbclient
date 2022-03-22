package c.a.a0.u.t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.u.g;
import c.a.a0.u.k;
import c.a.a0.u.s.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
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
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.u.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0073a implements c.a.a0.u.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1650b;

        public C0073a(File file, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.f1650b = bVar;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        @Override // c.a.a0.u.p.a
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                try {
                    a.b(inputStream, this.a);
                    if (this.f1650b != null) {
                        this.f1650b.a();
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

    public static void a(@NonNull File file, @NonNull String str, @Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, file, str, bVar) == null) {
            k a = g.b().a();
            d dVar = new d();
            dVar.k(str);
            dVar.c();
            a.b(dVar, new C0073a(file, bVar));
        }
    }

    public static void b(@NonNull InputStream inputStream, @NonNull File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ReadableByteChannel newChannel = Channels.newChannel(inputStream);
            FileChannel channel = fileOutputStream.getChannel();
            long j = 4096;
            long j2 = 0;
            while (j > 0) {
                try {
                    j = channel.transferFrom(newChannel, j2, 4096L);
                    j2 += j;
                } finally {
                    c.a.a0.h.d.a(fileOutputStream);
                }
            }
        }
    }
}
