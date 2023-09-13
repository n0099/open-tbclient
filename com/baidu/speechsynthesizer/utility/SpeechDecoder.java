package com.baidu.speechsynthesizer.utility;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.w0;
/* loaded from: classes4.dex */
public class SpeechDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnDecodedDataListener mDecodedDataListener;
    public final String mInstanceId;
    public final String tag;

    /* loaded from: classes4.dex */
    public interface OnDecodedDataListener {
        void onDecodedData(byte[] bArr);
    }

    public static native String bdTTSGetDecoderLibVersion();

    public static native int bdTTSSetNativeLogLevel(int i);

    public static native boolean isIpv4Reachable();

    public static native boolean isIpv6Reachable();

    public native int decode(byte[] bArr, int i, short[] sArr, int[] iArr, int i2, int i3);

    public native int decodeWithCallback(String str, byte[] bArr, Object obj, int i);

    public native int release(String str);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1113268339, "Lcom/baidu/speechsynthesizer/utility/SpeechDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1113268339, "Lcom/baidu/speechsynthesizer/utility/SpeechDecoder;");
                return;
            }
        }
        try {
            LoggerProxy.d("SpeechDecoder", "before load c++_shared");
            System.loadLibrary(SwanKV.LIB_CPP_SHARED);
        } catch (Throwable unused) {
            LoggerProxy.e("SpeechDecoder", "so file c++_shared load fail");
        }
        try {
            LoggerProxy.d("SpeechDecoder", "before load BDSpeechDecoder_V1");
            System.loadLibrary("BDSpeechDecoder_V1");
            LoggerProxy.d("SpeechDecoder", "after load BDSpeechDecoder_V1");
        } catch (Throwable unused2) {
            LoggerProxy.e("SpeechDecoder", "so file BDSpeechDecoder_V1 load fail");
        }
    }

    public SpeechDecoder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tag = w0.a("SpeechDecoder", str);
        this.mInstanceId = str;
    }

    public void decodeAudioCallback(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            this.mDecodedDataListener.onDecodedData(bArr);
        }
    }

    public void setOnDecodedDataListener(OnDecodedDataListener onDecodedDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDecodedDataListener) == null) {
            this.mDecodedDataListener = onDecodedDataListener;
        }
    }

    public int decodeWithCallback(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bArr, i)) == null) {
            return decodeWithCallback(this.mInstanceId, bArr, this, i);
        }
        return invokeLI.intValue;
    }
}
