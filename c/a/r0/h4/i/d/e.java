package c.a.r0.h4.i.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaMuxer a;

    /* renamed from: b  reason: collision with root package name */
    public int f17976b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17977c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f17978d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f17979e;

    public e(String str) throws IOException {
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
        this.f17976b = 2;
        this.f17977c = false;
        this.a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (!this.f17977c) {
                    addTrack = this.a.addTrack(mediaFormat);
                } else {
                    throw new IllegalStateException("muxer already started");
                }
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                z = this.f17977c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17979e = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17978d = true;
        }
    }

    public synchronized boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.f17979e && this.f17978d) {
                    if (this.f17976b > 0 && this.f17979e && this.f17978d) {
                        this.a.start();
                        this.f17977c = true;
                        notifyAll();
                    }
                    return this.f17977c;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f17976b > 0) {
                    try {
                        this.a.stop();
                        this.a.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f17977c = false;
                }
            }
        }
    }

    public synchronized void g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.f17977c) {
                    this.a.writeSampleData(i2, byteBuffer, bufferInfo);
                }
            }
        }
    }
}
