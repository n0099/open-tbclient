package c.a.p0.c0.i;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f13012b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Class<? extends b>> f13013a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1723266345, "Lc/a/p0/c0/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1723266345, "Lc/a/p0/c0/i/c;");
                return;
            }
        }
        f13012b = new c();
    }

    public c() {
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
        this.f13013a = new HashMap<>();
        f(d.class);
        f(f.class);
        f(a.class);
        f(e.class);
        f(g.class);
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f13012b : (c) invokeV.objValue;
    }

    public b a(ImageOperation imageOperation) {
        InterceptResult invokeL;
        b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageOperation)) == null) {
            Class<? extends b> cls = this.f13013a.get(imageOperation.actionName);
            if (cls == null || (e2 = e(cls)) == null) {
                return null;
            }
            e2.d(imageOperation.actionParam);
            return e2;
        }
        return (b) invokeL.objValue;
    }

    public Bitmap b(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), list, imageFileInfo})) == null) {
            if (bitmap == null || ListUtils.isEmpty(list)) {
                return bitmap;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b a2 = a(list.get(i2));
                if ((a2 instanceof g) && imageFileInfo != null) {
                    ((g) a2).e(imageFileInfo.getFilePath());
                    return a2.b(bitmap, z);
                }
            }
            d dVar = null;
            int i3 = 0;
            while (i3 < size) {
                ImageOperation imageOperation = list.get(i3);
                if ("resize".equals(imageOperation.actionName)) {
                    d dVar2 = (d) a(imageOperation);
                    if (dVar == null || dVar2.f() <= dVar.f() || dVar2.e() <= dVar.e()) {
                        dVar = dVar2;
                    }
                    list.remove(i3);
                    i3--;
                }
                i3++;
            }
            Bitmap b2 = dVar != null ? dVar.b(bitmap, z) : null;
            if (list != null) {
                for (int i4 = 0; i4 < size; i4++) {
                    b a3 = a(list.get(i4));
                    if (a3 != null) {
                        if (b2 == null) {
                            return null;
                        }
                        b2 = a3.b(bitmap, z);
                    }
                }
            }
            return b2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public Bitmap c(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, imageFileInfo)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b a2 = a(list.get(i2));
                if ((a2 instanceof g) && imageFileInfo != null) {
                    return a2.c(imageFileInfo.getFilePath());
                }
            }
            d dVar = null;
            int i3 = 0;
            while (i3 < list.size()) {
                ImageOperation imageOperation = list.get(i3);
                if ("resize".equals(imageOperation.actionName)) {
                    d dVar2 = (d) a(imageOperation);
                    if (dVar == null || dVar2.f() <= dVar.f() || dVar2.e() <= dVar.e()) {
                        dVar = dVar2;
                    }
                    list.remove(i3);
                    i3--;
                }
                i3++;
            }
            Bitmap c2 = dVar != null ? dVar.c(str) : null;
            if (list != null) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    b a3 = a(list.get(i4));
                    if (a3 != null) {
                        if (c2 == null) {
                            c2 = a3.c(str);
                        } else {
                            c2 = a3.b(c2, true);
                        }
                    }
                }
            }
            return c2;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final b e(Class<? extends b> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    public final void f(Class<? extends b> cls) {
        b e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cls) == null) || (e2 = e(cls)) == null) {
            return;
        }
        this.f13013a.put(e2.a(), cls);
    }
}
