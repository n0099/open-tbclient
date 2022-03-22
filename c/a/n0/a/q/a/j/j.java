package c.a.n0.a.q.a.j;

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
    public static final boolean f5916d;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public String f5917b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f5918c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1080632297, "Lc/a/n0/a/q/a/j/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1080632297, "Lc/a/n0/a/q/a/j/j;");
                return;
            }
        }
        f5916d = c.a.n0.a.a.a;
    }

    public j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5917b = str;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Bitmap bitmap;
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) || (bitmap = this.a) == null || (matrix = this.f5918c) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, matrix, bVar.f5898d);
    }

    @Override // c.a.n0.a.q.a.j.a
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
                JSONObject jSONObject = new JSONObject(this.f5917b);
                int g2 = c.a.n0.a.p2.n0.g((float) jSONObject.optDouble("x"));
                int g3 = c.a.n0.a.p2.n0.g((float) jSONObject.optDouble("y"));
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                if (optInt <= 0 || optInt2 <= 0) {
                    return 2002;
                }
                float g4 = c.a.n0.a.p2.n0.g(optInt);
                float g5 = c.a.n0.a.p2.n0.g(optInt2);
                String optString = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString)) {
                    return 2001;
                }
                try {
                    byte[] decode = Base64.decode(optString, 2);
                    int i = optInt * optInt2 * 4;
                    if (decode != null && decode.length == i) {
                        this.a = e(d(decode, optInt, optInt2), g4, g5);
                        Matrix matrix = new Matrix();
                        this.f5918c = matrix;
                        matrix.postTranslate(g2, g3);
                        return 0;
                    }
                    return 2001;
                } catch (Exception e2) {
                    if (f5916d) {
                        e2.printStackTrace();
                    }
                    c.a.n0.a.u.d.c("canvasPutImageData", "canvasGetImageData meets exception in decoding bitmap");
                    return 1001;
                }
            } catch (JSONException e3) {
                if (f5916d) {
                    e3.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeV.intValue;
    }

    @NonNull
    public final Bitmap d(@NonNull byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            int i3 = i * i2;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * 4;
                iArr[i4] = Color.argb(bArr[i5 + 3] & 255, bArr[i5] & 255, bArr[i5 + 1] & 255, bArr[i5 + 2] & 255);
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
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
