package c.b.b.l.a;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import com.badlogic.gdx.Files;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class y implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27093b;

    /* renamed from: c  reason: collision with root package name */
    public final AssetManager f27094c;

    /* renamed from: d  reason: collision with root package name */
    public a0 f27095d;

    public y(AssetManager assetManager, ContextWrapper contextWrapper, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, contextWrapper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27095d = null;
        this.f27094c = assetManager;
        String absolutePath = contextWrapper.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        this.f27093b = absolutePath;
        if (z) {
            this.a = h(contextWrapper);
        } else {
            this.a = null;
        }
    }

    @Override // com.badlogic.gdx.Files
    public c.b.b.m.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            g gVar = new g(this.f27094c, str, Files.FileType.Internal);
            return this.f27095d != null ? g(gVar, str) : gVar;
        }
        return (c.b.b.m.a) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27093b : (String) invokeV.objValue;
    }

    @Override // c.b.b.l.a.h
    public a0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27095d : (a0) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public c.b.b.m.a d(String str, Files.FileType fileType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, fileType)) == null) {
            g gVar = new g(fileType == Files.FileType.Internal ? this.f27094c : null, str, fileType);
            return (this.f27095d == null || fileType != Files.FileType.Internal) ? gVar : g(gVar, str);
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Files
    public c.b.b.m.a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new g((AssetManager) null, str, Files.FileType.Classpath) : (c.b.b.m.a) invokeL.objValue;
    }

    public final c.b.b.m.a g(c.b.b.m.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, str)) == null) {
            try {
                this.f27094c.open(str).close();
                return aVar;
            } catch (Exception unused) {
                w wVar = new w(str);
                return (wVar.x() && !wVar.c()) ? aVar : wVar;
            }
        }
        return (c.b.b.m.a) invokeLL.objValue;
    }

    public String h(ContextWrapper contextWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, contextWrapper)) == null) {
            File externalFilesDir = contextWrapper.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                String absolutePath = externalFilesDir.getAbsolutePath();
                if (absolutePath.endsWith("/")) {
                    return absolutePath;
                }
                return absolutePath + "/";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
