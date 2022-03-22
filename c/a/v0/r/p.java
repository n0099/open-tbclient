package c.a.v0.r;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RenderScript a;

    /* renamed from: b  reason: collision with root package name */
    public ScriptIntrinsicYuvToRGB f21837b;

    /* renamed from: c  reason: collision with root package name */
    public Type.Builder f21838c;

    /* renamed from: d  reason: collision with root package name */
    public Type.Builder f21839d;

    /* renamed from: e  reason: collision with root package name */
    public Allocation f21840e;

    /* renamed from: f  reason: collision with root package name */
    public Allocation f21841f;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RenderScript create = RenderScript.create(context);
        this.a = create;
        this.f21837b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            if (this.f21838c == null) {
                RenderScript renderScript = this.a;
                Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f21838c = x;
                this.f21840e = Allocation.createTyped(this.a, x.create(), 1);
                RenderScript renderScript2 = this.a;
                Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i).setY(i2);
                this.f21839d = y;
                this.f21841f = Allocation.createTyped(this.a, y.create(), 1);
            }
            this.f21840e.copyFrom(bArr);
            this.f21837b.setInput(this.f21840e);
            this.f21837b.forEach(this.f21841f);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.f21841f.copyTo(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
