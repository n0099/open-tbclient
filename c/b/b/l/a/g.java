package c.b.b.l.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class g extends c.b.b.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final AssetManager f27058c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(AssetManager assetManager, String str, Files.FileType fileType) {
        super(str.replace(FileUtil.WINDOWS_SEPARATOR, '/'), fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, str, fileType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Files.FileType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27058c = assetManager;
    }

    @Override // c.b.b.m.a
    public c.b.b.m.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String replace = str.replace(FileUtil.WINDOWS_SEPARATOR, '/');
            return this.a.getPath().length() == 0 ? new g(this.f27058c, new File(replace), this.f27108b) : new g(this.f27058c, new File(this.a, replace), this.f27108b);
        }
        return (c.b.b.m.a) invokeL.objValue;
    }

    @Override // c.b.b.m.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f27108b == Files.FileType.Internal) {
                String path = this.a.getPath();
                try {
                    this.f27058c.open(path).close();
                    return true;
                } catch (Exception unused) {
                    try {
                        return this.f27058c.list(path).length > 0;
                    } catch (Exception unused2) {
                        return false;
                    }
                }
            }
            return super.c();
        }
        return invokeV.booleanValue;
    }

    @Override // c.b.b.m.a
    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27108b == Files.FileType.Local ? new File(c.b.b.f.f26966d.b(), this.a.getPath()) : super.e() : (File) invokeV.objValue;
    }

    @Override // c.b.b.m.a
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f27108b == Files.FileType.Internal) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    assetFileDescriptor = this.f27058c.openFd(this.a.getPath());
                    long length = assetFileDescriptor.getLength();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    return length;
                } catch (IOException unused2) {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Throwable th) {
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            return super.f();
        }
        return invokeV.longValue;
    }

    @Override // c.b.b.m.a
    public c.b.b.m.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                if (this.f27108b == Files.FileType.Absolute) {
                    parentFile = new File("/");
                } else {
                    parentFile = new File("");
                }
            }
            return new g(this.f27058c, parentFile, this.f27108b);
        }
        return (c.b.b.m.a) invokeV.objValue;
    }

    @Override // c.b.b.m.a
    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f27108b == Files.FileType.Internal) {
                try {
                    return this.f27058c.open(this.a.getPath());
                } catch (IOException e2) {
                    throw new GdxRuntimeException("Error reading file: " + this.a + " (" + this.f27108b + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            return super.m();
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // c.b.b.m.a
    public c.b.b.m.a s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String replace = str.replace(FileUtil.WINDOWS_SEPARATOR, '/');
            if (this.a.getPath().length() != 0) {
                return c.b.b.f.f26966d.d(new File(this.a.getParent(), replace).getPath(), this.f27108b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (c.b.b.m.a) invokeL.objValue;
    }

    public AssetFileDescriptor u() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AssetManager assetManager = this.f27058c;
            if (assetManager != null) {
                return assetManager.openFd(j());
            }
            return null;
        }
        return (AssetFileDescriptor) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(AssetManager assetManager, File file, Files.FileType fileType) {
        super(file, fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, file, fileType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((File) objArr2[0], (Files.FileType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27058c = assetManager;
    }
}
