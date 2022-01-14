package c.a.t0.w0.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.io.IOException;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24662d = z;
    }

    public static int h(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i4 > i3 || i5 > i2) {
                int round = Math.round(i4 / i3);
                int round2 = Math.round(i5 / i2);
                if (round >= round2) {
                    round = round2;
                }
                if (round >= 3) {
                    if (round < 6.5d) {
                        return 4;
                    }
                    if (round < 8) {
                        return 8;
                    }
                }
                return round;
            }
            return 1;
        }
        return invokeLII.intValue;
    }

    public static Bitmap i(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = h(options, i2, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeLII.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:39:0x005f). Please submit an issue!!! */
    @Override // c.a.t0.w0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.t0.w0.a.g.b bVar = this.a;
            if (bVar.f24667e) {
                this.f24660b.onError(bVar.f24668f, "is cartoon style !!");
                return;
            }
            MultiMediaData multiMediaData = bVar.f24665c;
            if (multiMediaData != null && !TextUtils.isEmpty(multiMediaData.path)) {
                String str = multiMediaData.path;
                if (multiMediaData.type == 1) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(multiMediaData.start * 1000);
                            if (this.a.f24666d != 0.0f) {
                                g(new c.a.t0.w0.a.g.a(), c(frameAtTime, this.a.f24666d, multiMediaData));
                            } else {
                                g(new c.a.t0.w0.a.g.a(), frameAtTime);
                            }
                        } catch (IllegalArgumentException e2) {
                            e2.printStackTrace();
                        } catch (Exception unused) {
                        }
                        return;
                    } finally {
                        mediaMetadataRetriever.release();
                    }
                }
                Bitmap k = k(str);
                if (k != null) {
                    g(new c.a.t0.w0.a.g.a(), k);
                    return;
                }
                return;
            }
            this.f24660b.onError(this.a.f24668f, "multiMediaData is null !!");
        }
    }

    public final int j(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException unused) {
                exifInterface = null;
            }
            if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) != -1) {
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return 270;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public Bitmap k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c.a.t0.w0.a.g.b bVar = this.a;
            Bitmap i2 = i(str, bVar.a, bVar.f24664b);
            if (i2 == null) {
                return null;
            }
            int j2 = j(str);
            Matrix matrix = new Matrix();
            matrix.setRotate(j2);
            return Bitmap.createBitmap(i2, 0, 0, i2.getWidth(), i2.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }
}
