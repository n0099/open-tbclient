package b.a.q0.d0.i;

import android.graphics.Bitmap;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12943a;

    public e() {
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
        this.f12943a = 0;
    }

    public static ImageOperation e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            ImageOperation imageOperation = new ImageOperation();
            imageOperation.actionName = "rotate";
            imageOperation.actionParam = String.valueOf(i2);
            return imageOperation;
        }
        return (ImageOperation) invokeI.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rotate" : (String) invokeV.objValue;
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
            int i2 = this.f12943a;
            if (i2 == 0 || i2 == 1) {
                return BitmapHelper.rotateBitmap(bitmap, this.f12943a);
            }
            return (i2 == 2 || i2 == 3) ? BitmapHelper.reversalBitmap(bitmap, this.f12943a) : bitmap;
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public Bitmap c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int max = Math.max(l.k(TbadkCoreApplication.getInst().getApp()), l.i(TbadkCoreApplication.getInst().getApp()));
            return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // b.a.q0.d0.i.b
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null) {
            return;
        }
        this.f12943a = Integer.parseInt(str);
    }
}
