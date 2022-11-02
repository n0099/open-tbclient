package com.baidu.platform.comapi.longlink;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.exception.InvalidComException;
import com.baidu.platform.comjni.base.longlink.NALongLink;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LongLinkClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public int c;

    public LongLinkClient(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = j;
    }

    public synchronized ELongLinkStatus sendData(byte[] bArr) throws InvalidComException {
        InterceptResult invokeL;
        ELongLinkStatus eLongLinkStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            synchronized (this) {
                if (isValid()) {
                    this.c++;
                    eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendData(this.b, this.a, this.c, bArr)];
                    eLongLinkStatus.setRequestId(this.c);
                } else {
                    throw new InvalidComException();
                }
            }
            return eLongLinkStatus;
        }
        return (ELongLinkStatus) invokeL.objValue;
    }

    public LongLinkClient(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = j;
        this.a = i;
    }

    public synchronized ELongLinkStatus sendFileData(String str, ArrayList<LongLinkFileData> arrayList) throws InvalidComException {
        InterceptResult invokeLL;
        ELongLinkStatus eLongLinkStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, arrayList)) == null) {
            synchronized (this) {
                if (isValid()) {
                    this.c++;
                    eLongLinkStatus = ELongLinkStatus.values()[NALongLink.sendFileData(this.b, this.a, this.c, str, arrayList)];
                    eLongLinkStatus.setRequestId(this.c);
                } else {
                    throw new InvalidComException();
                }
            }
            return eLongLinkStatus;
        }
        return (ELongLinkStatus) invokeLL.objValue;
    }

    public static LongLinkClient create() throws ComInitException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long create = NALongLink.create();
            if (create != 0) {
                return new LongLinkClient(create);
            }
            throw new ComInitException("LongLink Component created failed!");
        }
        return (LongLinkClient) invokeV.objValue;
    }

    public synchronized int getRequestId() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = this.c;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isValid() && NALongLink.release(this.b) <= 0) {
                this.b = 0L;
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean start() throws InvalidComException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (isValid()) {
                return NALongLink.start(this.b);
            }
            throw new InvalidComException();
        }
        return invokeV.booleanValue;
    }

    public void stop() throws InvalidComException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isValid()) {
                NALongLink.stop(this.b);
                return;
            }
            throw new InvalidComException();
        }
    }

    public static LongLinkClient create(int i) throws ComInitException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            long create = NALongLink.create();
            if (create != 0) {
                return new LongLinkClient(create, i);
            }
            throw new ComInitException("LongLink Component created failed!");
        }
        return (LongLinkClient) invokeI.objValue;
    }

    public synchronized boolean register(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        InterceptResult invokeL;
        boolean register;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, longLinkDataCallback)) == null) {
            synchronized (this) {
                if (isValid()) {
                    register = NALongLink.register(this.b, this.a, longLinkDataCallback);
                } else {
                    throw new InvalidComException();
                }
            }
            return register;
        }
        return invokeL.booleanValue;
    }

    public void setModuleId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public synchronized boolean unRegister(LongLinkDataCallback longLinkDataCallback) throws InvalidComException {
        InterceptResult invokeL;
        boolean unRegister;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, longLinkDataCallback)) == null) {
            synchronized (this) {
                if (isValid()) {
                    unRegister = NALongLink.unRegister(this.b, this.a, longLinkDataCallback);
                } else {
                    throw new InvalidComException();
                }
            }
            return unRegister;
        }
        return invokeL.booleanValue;
    }

    public boolean init(String str, String str2) throws InvalidComException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (isValid()) {
                return NALongLink.init(this.b, str, str2);
            }
            throw new InvalidComException();
        }
        return invokeLL.booleanValue;
    }
}
