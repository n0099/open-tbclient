package c.a.r0.a.a0.a.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5089d;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public String f5090b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f5091c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-611625461, "Lc/a/r0/a/a0/a/j/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-611625461, "Lc/a/r0/a/a0/a/j/j;");
                return;
            }
        }
        f5089d = c.a.r0.a.k.a;
    }

    public j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5090b = str;
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Bitmap bitmap;
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (bitmap = this.a) == null || (matrix = this.f5091c) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, matrix, bVar.f5073h);
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f5090b);
                int g2 = c.a.r0.a.z2.n0.g((float) jSONObject.optDouble("x"));
                int g3 = c.a.r0.a.z2.n0.g((float) jSONObject.optDouble("y"));
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                if (optInt <= 0 || optInt2 <= 0) {
                    return 2002;
                }
                float g4 = c.a.r0.a.z2.n0.g(optInt);
                float g5 = c.a.r0.a.z2.n0.g(optInt2);
                String optString = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString)) {
                    return 2001;
                }
                try {
                    byte[] decode = Base64.decode(optString, 2);
                    int i2 = optInt * optInt2 * 4;
                    if (decode != null && decode.length == i2) {
                        this.a = e(d(decode, optInt, optInt2), g4, g5);
                        Matrix matrix = new Matrix();
                        this.f5091c = matrix;
                        matrix.postTranslate(g2, g3);
                        return 0;
                    }
                    return 2001;
                } catch (Exception e2) {
                    if (f5089d) {
                        e2.printStackTrace();
                    }
                    c.a.r0.a.e0.d.c("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                    return 1001;
                }
            } catch (JSONException e3) {
                if (f5089d) {
                    e3.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeV.intValue;
    }

    @NonNull
    public final Bitmap d(@NonNull byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 4;
                iArr[i5] = Color.argb(bArr[i6 + 3] & 255, bArr[i6] & 255, bArr[i6 + 1] & 255, bArr[i6 + 2] & 255);
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @NonNull
    public final Bitmap e(@NonNull Bitmap bitmap, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bitmap, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Matrix matrix = new Matrix();
            matrix.postScale(f2 / bitmap.getWidth(), f3 / bitmap.getHeight());
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
