package com.baidu.media.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.media.duplayer.Keep;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes3.dex */
public class DuMediaExtractor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public long mNativeDuMediaExtractor;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<DuMediaExtractor> f8093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DuMediaExtractor duMediaExtractor, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMediaExtractor, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8093a = new WeakReference<>(duMediaExtractor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                DuMediaExtractor duMediaExtractor = this.f8093a.get();
                if (duMediaExtractor == null || duMediaExtractor.mNativeDuMediaExtractor == 0) {
                    CyberLog.w("DuMediaExtractor", "IjkMediaPlayer went away with unhandled events");
                } else {
                    int i2 = message.what;
                }
            }
        }
    }

    public DuMediaExtractor() {
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
        nativeSetup(new WeakReference(this));
        i();
    }

    private native Bundle nativeGetMediaMeta();

    private native void nativePrepare();

    private native void nativeRelease();

    private native void nativeSetDataSource(String str, String[] strArr, String[] strArr2);

    private native void nativeSetOption(int i2, String str, long j);

    private native void nativeSetOption(int i2, String str, String str2);

    private native void nativeSetup(Object obj);

    @Keep
    public static boolean onNativeInvoke(Object obj, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, obj, i2, bundle)) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                CyberLog.e("DuMediaExtractor", "<null weakThiz>.onNativeInvoke()");
                return false;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                nativeRelease();
                this.mNativeDuMediaExtractor = 0L;
            }
        }
    }

    public void c(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            nativeSetOption(i2, str, j);
        }
    }

    public void d(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, str2) == null) {
            nativeSetOption(i2, str, str2);
        }
    }

    public void e(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, uri, map) == null) {
            g(uri.toString(), map);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            nativeSetDataSource(str, null, null);
            nativePrepare();
        }
    }

    public void g(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, map) == null) {
            if (map != null && !map.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().equals("Referer")) {
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(value)) {
                            d(1, Config.LAUNCH_REFERER, value);
                        }
                    } else {
                        sb.append(entry.getKey());
                        sb.append(": ");
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            sb.append(entry.getValue());
                        }
                        sb.append(Part.CRLF);
                    }
                }
                d(1, "headers", sb.toString());
            }
            f(str);
        }
    }

    public Bundle h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? nativeGetMediaMeta() : (Bundle) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                new a(this, myLooper);
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                new a(this, mainLooper);
            }
        }
    }
}
