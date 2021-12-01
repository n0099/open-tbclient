package c.a.p0.a.n1.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import c.a.p0.a.k;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.n1.j.a
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            boolean z = a.f7005c;
            if (bitmap == null) {
                return false;
            }
            if (!b(bitmap, rect)) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            int i2 = 0;
            for (int i3 = rect.left + 1; i3 < rect.right - 1; i3++) {
                for (int i4 = rect.top + 1; i4 < rect.bottom - 1; i4++) {
                    int pixel = bitmap.getPixel(i3, i4);
                    if (i2 == 0) {
                        i2 = pixel;
                    }
                    if (i2 != pixel && pixel != 0) {
                        if (k.a) {
                            String str = "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i3 + "," + i4 + SmallTailInfo.EMOTION_SUFFIX;
                        }
                        return false;
                    }
                }
            }
            if (a.f7005c) {
                String str2 = "color = " + i2 + "图片大小 " + rect.width() + " x " + rect.height();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
