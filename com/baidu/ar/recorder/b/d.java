package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "d";
    public transient /* synthetic */ FieldHolder $fh;
    public MediaMuxer uV;
    public volatile boolean uW;
    public e uo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(750732677, "Lcom/baidu/ar/recorder/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(750732677, "Lcom/baidu/ar/recorder/b/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.uW = false;
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                try {
                    int addTrack = this.uV.addTrack(mediaFormat);
                    if (addTrack >= 0) {
                        return addTrack;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                com.baidu.ar.h.b.b(TAG, "addMuxerTrack error!!!");
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, byteBuffer, bufferInfo)) == null) {
            if (i2 != -1) {
                try {
                    this.uV.writeSampleData(i2, byteBuffer, bufferInfo);
                    return true;
                } catch (Exception unused) {
                    com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
                    return false;
                }
            }
            return false;
        }
        return invokeILL.booleanValue;
    }

    public boolean a(String str, int i2, e eVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, eVar)) == null) {
            if (!com.baidu.ar.recorder.c.a.ay(str)) {
                com.baidu.ar.recorder.c.a.ax(str);
            }
            try {
                this.uV = new MediaMuxer(str, i2);
                this.uo = eVar;
                this.uW = false;
                return true;
            } catch (Exception e2) {
                com.baidu.ar.h.b.b(TAG, "initMovieMuxer init error!!!");
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public boolean fU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.uW : invokeV.booleanValue;
    }

    public synchronized void fV() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                boolean z = true;
                try {
                    this.uV.start();
                    this.uW = true;
                } catch (Exception unused) {
                    com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
                    z = false;
                }
                if (this.uo != null) {
                    this.uo.O(z);
                }
            }
        }
    }

    public synchronized void fW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    this.uV.stop();
                    this.uW = false;
                    z = true;
                } catch (Exception unused) {
                    com.baidu.ar.h.b.b(TAG, "stopMuxer error!!!");
                }
                if (this.uo != null) {
                    this.uo.P(z);
                }
            }
        }
    }

    public void fX() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.uW) {
            return;
        }
        this.uV.release();
        this.uV = null;
    }
}
