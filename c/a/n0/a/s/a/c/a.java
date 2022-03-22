package c.a.n0.a.s.a.c;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements LineHeightSpan {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6083b;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1890187739, "Lc/a/n0/a/s/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1890187739, "Lc/a/n0/a/s/a/c/a;");
                return;
            }
        }
        f6083b = c.a.n0.a.a.a;
    }

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt}) == null) {
            if (f6083b) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in fm=" + fontMetricsInt);
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in height=" + this.a);
            }
            if (this.a < 0 || (i5 = fontMetricsInt.descent - fontMetricsInt.ascent) < 0) {
                return;
            }
            if (f6083b) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in originHeight=" + i5);
            }
            int i6 = (this.a - i5) / 2;
            if (f6083b) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: in hafDiff=" + i6);
            }
            fontMetricsInt.descent += i6;
            fontMetricsInt.ascent -= i6;
            if (f6083b) {
                Log.i("AdjustLineHeightSpan", "chooseHeight :: out fm=" + fontMetricsInt);
            }
        }
    }
}
