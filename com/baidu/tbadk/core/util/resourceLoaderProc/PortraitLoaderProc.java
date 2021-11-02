package com.baidu.tbadk.core.util.resourceLoaderProc;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.l.b;
import b.a.e.l.d.a;
import b.a.q0.c0.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PortraitLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public static BdAsyncTaskParallel mBdAsyncTaskTwo;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mForceDownload;
    public int proType;
    public String serverAddr;
    public int size;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1687865857, "Lcom/baidu/tbadk/core/util/resourceLoaderProc/PortraitLoaderProc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1687865857, "Lcom/baidu/tbadk/core/util/resourceLoaderProc/PortraitLoaderProc;");
        }
    }

    public PortraitLoaderProc(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.serverAddr = null;
        this.size = 0;
        this.mForceDownload = false;
        this.proType = 0;
        float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.mForceDownload = z;
        this.proType = i2;
        if (f2 < 2.0f) {
            this.serverAddr = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.serverAddr = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.serverAddr = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.serverAddr = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, b.a.e.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (mBdAsyncTaskTwo == null) {
                mBdAsyncTaskTwo = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
            }
            return mBdAsyncTaskTwo;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.proType : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public String getUrlbyClientServerAddr(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, i3)) == null) {
            if (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://"))) {
                return this.serverAddr + str;
            }
            return str;
        }
        return (String) invokeLII.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, b.a.e.e.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, b.a.e.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.u()) {
                aVar.A(i2);
                aVar.z(i3);
                c.k().b(str, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, b.a.e.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            if (this.mForceDownload) {
                return null;
            }
            return super.getFromLocal(str, str2, i2, i3, bVar, objArr);
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, b.a.e.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            if (this.mForceDownload) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a l = c.k().l(str);
            if (z) {
                b.a.e.e.l.a.i(l != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return l;
        }
        return (a) invokeCommon.objValue;
    }
}
