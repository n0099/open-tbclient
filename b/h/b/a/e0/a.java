package b.h.b.a.e0;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.i0.v;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final a f33130g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f33131a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33132b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33133c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33134d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33135e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f33136f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1369563235, "Lb/h/b/a/e0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1369563235, "Lb/h/b/a/e0/a;");
                return;
            }
        }
        f33130g = new a(-1, -16777216, 0, 0, -1, null);
    }

    public a(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), typeface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33131a = i2;
        this.f33132b = i3;
        this.f33133c = i4;
        this.f33134d = i5;
        this.f33135e = i6;
        this.f33136f = typeface;
    }

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, captionStyle)) == null) {
            if (v.f33519a >= 21) {
                return c(captionStyle);
            }
            return b(captionStyle);
        }
        return (a) invokeL.objValue;
    }

    @TargetApi(19)
    public static a b(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, captionStyle)) == null) ? new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface()) : (a) invokeL.objValue;
    }

    @TargetApi(21)
    public static a c(CaptioningManager.CaptionStyle captionStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, captionStyle)) == null) {
            return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f33130g.f33131a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f33130g.f33132b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f33130g.f33133c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f33130g.f33134d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f33130g.f33135e, captionStyle.getTypeface());
        }
        return (a) invokeL.objValue;
    }
}
