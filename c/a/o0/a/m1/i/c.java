package c.a.o0.a.m1.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import c.a.o0.a.k;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.o0.a.m1.i.a
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            boolean z = a.f7343c;
            if (bitmap == null) {
                return false;
            }
            if (!b(bitmap, rect)) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            try {
                int pixel = bitmap.getPixel(rect.left + 1, rect.top + 1);
                boolean z2 = pixel == -1 || pixel == -657931;
                if (!z2 && (set = this.f7345b) != null) {
                    Iterator<Integer> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().intValue() == pixel) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z2) {
                    for (int i2 = rect.left + 1; i2 < rect.right - 1; i2++) {
                        for (int i3 = rect.top + 1; i3 < rect.bottom - 1; i3++) {
                            if (pixel != bitmap.getPixel(i2, i3)) {
                                if (k.f7049a) {
                                    String str = "非白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i2 + "," + i3 + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                return false;
                            }
                        }
                    }
                    if (a.f7343c) {
                        String str2 = "白屏, 图片大小 " + rect.width() + " x " + rect.height();
                    }
                    return true;
                }
                return false;
            } catch (IllegalArgumentException e2) {
                if (a.f7343c) {
                    String str3 = "W:" + bitmap.getWidth() + "; H:" + bitmap.getHeight();
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
