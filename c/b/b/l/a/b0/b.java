package c.b.b.l.a.b0;

import android.opengl.GLSurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes7.dex */
public class b implements GLSurfaceView.EGLConfigChooser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27408b;

    /* renamed from: c  reason: collision with root package name */
    public int f27409c;

    /* renamed from: d  reason: collision with root package name */
    public int f27410d;

    /* renamed from: e  reason: collision with root package name */
    public int f27411e;

    /* renamed from: f  reason: collision with root package name */
    public int f27412f;

    /* renamed from: g  reason: collision with root package name */
    public int f27413g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f27414h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f27415i;

    public b(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27415i = new int[1];
        this.a = i2;
        this.f27408b = i3;
        this.f27409c = i4;
        this.f27410d = i5;
        this.f27411e = i6;
        this.f27412f = i7;
        this.f27413g = i8;
        this.f27414h = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e6, code lost:
        if (r5 == r19.f27410d) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        InterceptResult invokeLLL;
        int i2;
        EGLConfig eGLConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
            EGLConfig[] eGLConfigArr2 = eGLConfigArr;
            int length = eGLConfigArr2.length;
            EGLConfig eGLConfig2 = null;
            EGLConfig eGLConfig3 = null;
            EGLConfig eGLConfig4 = null;
            int i3 = 0;
            while (i3 < length) {
                EGLConfig eGLConfig5 = eGLConfigArr2[i3];
                int b2 = b(egl10, eGLDisplay, eGLConfig5, 12325, 0);
                int b3 = b(egl10, eGLDisplay, eGLConfig5, 12326, 0);
                if (b2 < this.f27411e || b3 < this.f27412f) {
                    i2 = length;
                } else {
                    int b4 = b(egl10, eGLDisplay, eGLConfig5, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int b5 = b(egl10, eGLDisplay, eGLConfig5, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int b6 = b(egl10, eGLDisplay, eGLConfig5, 12322, 0);
                    int b7 = b(egl10, eGLDisplay, eGLConfig5, 12321, 0);
                    if (eGLConfig2 == null && b4 == 5 && b5 == 6 && b6 == 5 && b7 == 0) {
                        eGLConfig2 = eGLConfig5;
                    }
                    if (eGLConfig3 == null && b4 == this.a && b5 == this.f27408b && b6 == this.f27409c && b7 == this.f27410d) {
                        eGLConfig3 = eGLConfig5;
                        if (this.f27413g == 0) {
                            break;
                        }
                    }
                    i2 = length;
                    int b8 = b(egl10, eGLDisplay, eGLConfig5, 12338, 0);
                    EGLConfig eGLConfig6 = eGLConfig2;
                    int b9 = b(egl10, eGLDisplay, eGLConfig5, 12337, 0);
                    if (eGLConfig4 == null && b8 == 1 && b9 >= this.f27413g && b4 == this.a && b5 == this.f27408b && b6 == this.f27409c && b7 == this.f27410d) {
                        eGLConfig = eGLConfig3;
                    } else {
                        eGLConfig = eGLConfig3;
                        int b10 = b(egl10, eGLDisplay, eGLConfig5, 12512, 0);
                        int b11 = b(egl10, eGLDisplay, eGLConfig5, 12513, 0);
                        if (eGLConfig4 == null) {
                            if (b10 == 1) {
                                if (b11 >= this.f27413g) {
                                    if (b4 == this.a) {
                                        if (b5 == this.f27408b) {
                                            if (b6 == this.f27409c) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        eGLConfig3 = eGLConfig;
                        eGLConfig2 = eGLConfig6;
                    }
                    eGLConfig4 = eGLConfig5;
                    eGLConfig3 = eGLConfig;
                    eGLConfig2 = eGLConfig6;
                }
                i3++;
                eGLConfigArr2 = eGLConfigArr;
                length = i2;
            }
            return eGLConfig4 != null ? eGLConfig4 : eGLConfig3 != null ? eGLConfig3 : eGLConfig2;
        }
        return (EGLConfig) invokeLLL.objValue;
    }

    public final int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f27415i) ? this.f27415i[0] : i3 : invokeCommon.intValue;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay)) == null) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.f27414h, null, 0, iArr);
            int i2 = iArr[0];
            if (i2 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                egl10.eglChooseConfig(eGLDisplay, this.f27414h, eGLConfigArr, i2, iArr);
                return a(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        return (EGLConfig) invokeLL.objValue;
    }
}
