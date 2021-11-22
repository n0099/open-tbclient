package b.a.p0.a.h0.o.g.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallbacks;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.h0.o.g.b.a, b.a.p0.a.h0.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.h0.o.g.e.b f5955b;

    /* renamed from: b.a.p0.a.h0.o.g.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0248a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.o.g.b.b f5956a;

        public C0248a(a aVar, b.a.p0.a.h0.o.g.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5956a = bVar;
        }

        @Override // b.a.p0.a.h0.o.g.e.d
        public void a(ImageRequest imageRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageRequest) == null) {
            }
        }

        @Override // b.a.p0.a.h0.o.g.e.d
        public void b(ImageRequest imageRequest) {
            b.a.p0.a.h0.o.g.b.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest) == null) || (bVar = this.f5956a) == null) {
                return;
            }
            bVar.a();
        }

        @Override // b.a.p0.a.h0.o.g.e.d
        public void c(ImageRequest imageRequest, Throwable th) {
            b.a.p0.a.h0.o.g.b.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, th) == null) || (bVar = this.f5956a) == null) {
                return;
            }
            bVar.a();
        }

        @Override // b.a.p0.a.h0.o.g.e.d
        public void onCancel(String str) {
            b.a.p0.a.h0.o.g.b.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (bVar = this.f5956a) == null) {
                return;
            }
            bVar.a();
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.h0.o.g.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.o.g.e.b
        public CacheKey a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(Uri.parse(str)), null);
            }
            return (CacheKey) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f5957a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1808991870, "Lb/a/p0/a/h0/o/g/e/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1808991870, "Lb/a/p0/a/h0/o/g/e/a$c;");
                    return;
                }
            }
            f5957a = new a(null);
        }
    }

    public /* synthetic */ a(C0248a c0248a) {
        this();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f5957a : (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.b.a
    public void a(String str, File file, b.a.p0.a.h0.o.g.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, str, file, bVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (file != null && file.exists()) {
            z = b(str, file);
        }
        if (z) {
            bVar.a();
        } else {
            e(str, new C0248a(this, bVar));
        }
    }

    public final boolean b(String str, File file) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            CacheKey a2 = this.f5955b.a(str);
            boolean z = false;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                BinaryResource insert = Fresco.getImagePipelineFactory().getMainFileCache().insert(a2, WriterCallbacks.from(fileInputStream));
                if (insert != null) {
                    if (insert.size() > 0) {
                        z = true;
                    }
                }
                b.a.p0.w.d.d(fileInputStream);
                return z;
            } catch (IOException e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                    Log.getStackTraceString(e);
                }
                b.a.p0.w.d.d(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                b.a.p0.w.d.d(fileInputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final File c(String str) {
        InterceptResult invokeL;
        BinaryResource resource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            CacheKey a2 = this.f5955b.a(str);
            if (a2 == null) {
                return null;
            }
            if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(a2)) {
                BinaryResource resource2 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(a2);
                if (resource2 != null) {
                    return ((FileBinaryResource) resource2).getFile();
                }
                return null;
            } else if (!ImagePipelineFactory.getInstance().getSmallImageFileCache().hasKey(a2) || (resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(a2)) == null) {
                return null;
            } else {
                return ((FileBinaryResource) resource).getFile();
            }
        }
        return (File) invokeL.objValue;
    }

    public final DataSource<Void> e(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, dVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (dVar != null) {
                    dVar.c(null, new Exception("url is empty"));
                }
                return null;
            }
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
            if (dVar != null) {
                newBuilderWithSource.setRequestListener(b.a.p0.a.c1.a.B().a(dVar));
            }
            return imagePipeline.prefetchToDiskCache(newBuilderWithSource.build(), null);
        }
        return (DataSource) invokeLL.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.b.a
    public InputStream get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            File c2 = c(str);
            if (c2 == null || !c2.exists()) {
                return null;
            }
            try {
                return new FileInputStream(c2);
            } catch (IOException e2) {
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                    Log.getStackTraceString(e2);
                    return null;
                }
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.o.g.b.a
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5955b = new b(this);
    }
}
