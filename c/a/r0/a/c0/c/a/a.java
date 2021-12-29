package c.a.r0.a.c0.c.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import c.a.r0.a.g1.f;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        PathType s = c.a.r0.a.o2.b.s(str);
        if (s == PathType.BD_FILE || s == PathType.RELATIVE) {
            this.a = new File(f.U().G().a(str)).getParent();
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lottieImageAsset)) == null) {
            if (lottieImageAsset == null) {
                return null;
            }
            String fileName = lottieImageAsset.getFileName();
            if (TextUtils.isEmpty(fileName)) {
                return null;
            }
            if (fileName.startsWith(WebGLImageLoader.DATA_URL) && fileName.indexOf("base64,") > 0) {
                try {
                    byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            } else if (TextUtils.isEmpty(this.a)) {
                return null;
            } else {
                String dirName = lottieImageAsset.getDirName();
                return BitmapFactory.decodeFile(new File(TextUtils.isEmpty(dirName) ? new File(this.a) : new File(this.a, dirName), lottieImageAsset.getFileName()).getAbsolutePath());
            }
        }
        return (Bitmap) invokeL.objValue;
    }
}
