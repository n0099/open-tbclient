package c.a.n0.y;

import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f9523b;

    /* renamed from: c  reason: collision with root package name */
    public int f9524c;

    /* renamed from: d  reason: collision with root package name */
    public int f9525d;

    /* renamed from: e  reason: collision with root package name */
    public int f9526e;

    /* renamed from: f  reason: collision with root package name */
    public int f9527f;

    /* renamed from: g  reason: collision with root package name */
    public int f9528g;

    /* renamed from: h  reason: collision with root package name */
    public int f9529h;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9529h = 0;
        new WeakReference(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r4 != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
        if (r4 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
        r11 = (int) (r3 * r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f8, code lost:
        if (r1 > r11) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2) {
        int i3;
        float f2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            int i5 = this.f9526e;
            if (i5 == 90 || i5 == 270) {
                i2 = i;
                i = i2;
            }
            int defaultSize = View.getDefaultSize(this.a, i);
            int defaultSize2 = View.getDefaultSize(this.f9523b, i2);
            if (this.f9529h != 3) {
                if (this.a > 0 && this.f9523b > 0) {
                    int mode = View.MeasureSpec.getMode(i);
                    i = View.MeasureSpec.getSize(i);
                    int mode2 = View.MeasureSpec.getMode(i2);
                    i2 = View.MeasureSpec.getSize(i2);
                    if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                        float f3 = i;
                        float f4 = i2;
                        float f5 = f3 / f4;
                        int i6 = this.f9529h;
                        if (i6 == 4) {
                            int i7 = this.f9526e;
                            f2 = (i7 == 90 || i7 == 270) ? 0.5625f : 1.7777778f;
                        } else if (i6 != 5) {
                            f2 = this.a / this.f9523b;
                            int i8 = this.f9524c;
                            if (i8 > 0 && (i4 = this.f9525d) > 0) {
                                f2 = (f2 * i8) / i4;
                            }
                        } else {
                            int i9 = this.f9526e;
                            f2 = (i9 == 90 || i9 == 270) ? 0.75f : 1.3333334f;
                        }
                        boolean z = f2 > f5;
                        int i10 = this.f9529h;
                        if (i10 != 0) {
                            if (i10 != 1) {
                                if (i10 != 4 && i10 != 5) {
                                    if (z) {
                                        i = Math.min(this.a, i);
                                        i2 = (int) (i / f2);
                                    } else {
                                        i2 = Math.min(this.f9523b, i2);
                                        i = (int) (i2 * f2);
                                    }
                                }
                            }
                        }
                    } else if (mode == 1073741824 && mode2 == 1073741824) {
                        int i11 = this.a;
                        int i12 = i11 * i2;
                        int i13 = this.f9523b;
                        if (i12 < i * i13) {
                            i = (i11 * i2) / i13;
                        } else if (i11 * i2 > i * i13) {
                            i2 = (i13 * i) / i11;
                        }
                    } else if (mode == 1073741824) {
                        int i14 = (this.f9523b * i) / this.a;
                        if (mode2 != Integer.MIN_VALUE || i14 <= i2) {
                            i2 = i14;
                        }
                    } else if (mode2 == 1073741824) {
                        i3 = (this.a * i2) / this.f9523b;
                        if (mode == Integer.MIN_VALUE) {
                        }
                        i = i3;
                    } else {
                        i3 = this.a;
                        int i15 = this.f9523b;
                        if (mode2 != Integer.MIN_VALUE || i15 <= i2) {
                            i2 = i15;
                        } else {
                            i3 = (i3 * i2) / i15;
                        }
                        if (mode == Integer.MIN_VALUE && i3 > i) {
                            i2 = (this.f9523b * i) / this.a;
                        }
                        i = i3;
                    }
                } else {
                    Log.d("MeasureHelper", "no size yet");
                    i = defaultSize;
                    i2 = defaultSize2;
                }
            }
            this.f9527f = i;
            this.f9528g = i2;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9528g : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9527f : invokeV.intValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f9529h = i;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f9526e = i;
        }
    }

    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.f9524c = i;
            this.f9525d = i2;
        }
    }

    public void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.a = i;
            this.f9523b = i2;
        }
    }
}
