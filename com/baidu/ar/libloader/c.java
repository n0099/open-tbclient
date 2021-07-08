package com.baidu.ar.libloader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String sO;
    public List<String> sP;
    public a sQ;
    public boolean sR;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2);
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sR = false;
        this.sO = str;
        this.sP = new ArrayList();
    }

    private void av(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                System.load(str);
            } catch (Throwable th) {
                a aVar = this.sQ;
                if (aVar != null) {
                    aVar.a(str, th.getMessage());
                }
                throw th;
            }
        }
    }

    private List<String> fh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            List<String> asList = Arrays.asList("c++_shared", "opencv_java3", "anakin_lite");
            try {
                for (String str : asList) {
                    require(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return asList;
        }
        return (List) invokeV.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.sQ = aVar;
        }
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void load(Context context, ILibLoader.b bVar) {
        super.load(context, bVar);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        super.prepareCaseRes(aRType, str, str2, aVar);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            com.baidu.ar.h.b.k("LocalWithPathLibLoader", "require libName = " + str);
            if (!this.sR) {
                this.sR = true;
                if (fh().contains(str)) {
                    return;
                }
            }
            try {
                super.require(str);
                if (this.sP.contains(str)) {
                    return;
                }
                this.sP.add(str);
            } catch (Throwable unused) {
                if (TextUtils.isEmpty(this.sO)) {
                    return;
                }
                File file = new File(this.sO, "lib" + str + ".so");
                if (file.exists()) {
                    av(file.getAbsolutePath());
                    if (this.sP.contains(str)) {
                        return;
                    }
                    this.sP.add(str);
                }
            }
        }
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public /* bridge */ /* synthetic */ void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        super.setLibLoadPlugin(iLibLoaderPlugin);
    }

    @Override // com.baidu.ar.libloader.b, com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, cVar) == null) {
            if (cVar == null || !this.sP.contains(str)) {
                super.setLibReadyListener(str, cVar);
            } else {
                cVar.onReady();
            }
        }
    }
}
