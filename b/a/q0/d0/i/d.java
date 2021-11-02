package b.a.q0.d0.i;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12063a;

    /* renamed from: b  reason: collision with root package name */
    public int f12064b;

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

    public static ImageOperation g(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            ImageOperation imageOperation = new ImageOperation();
            imageOperation.actionName = "resize";
            imageOperation.actionParam = i2 + "," + i3;
            return imageOperation;
        }
        return (ImageOperation) invokeII.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "resize" : (String) invokeV.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            b.a.q0.c0.c.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, this.f12063a, this.f12064b, z);
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public Bitmap c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? b(BitmapHelper.loadResizedBitmap(str, this.f12063a, this.f12064b), true) : (Bitmap) invokeL.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null) {
            return;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return;
        }
        this.f12063a = b.a.e.e.m.b.e(split[0], 0);
        this.f12064b = b.a.e.e.m.b.e(split[1], 0);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12064b : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12063a : invokeV.intValue;
    }
}
