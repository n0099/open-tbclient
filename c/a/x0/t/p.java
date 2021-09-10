package c.a.x0.t;

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
/* loaded from: classes4.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RenderScript f31167a;

    /* renamed from: b  reason: collision with root package name */
    public ScriptIntrinsicYuvToRGB f31168b;

    /* renamed from: c  reason: collision with root package name */
    public Type.Builder f31169c;

    /* renamed from: d  reason: collision with root package name */
    public Type.Builder f31170d;

    /* renamed from: e  reason: collision with root package name */
    public Allocation f31171e;

    /* renamed from: f  reason: collision with root package name */
    public Allocation f31172f;

    public p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RenderScript create = RenderScript.create(context);
        this.f31167a = create;
        this.f31168b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (this.f31169c == null) {
                RenderScript renderScript = this.f31167a;
                Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f31169c = x;
                this.f31171e = Allocation.createTyped(this.f31167a, x.create(), 1);
                RenderScript renderScript2 = this.f31167a;
                Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i2).setY(i3);
                this.f31170d = y;
                this.f31172f = Allocation.createTyped(this.f31167a, y.create(), 1);
            }
            this.f31171e.copyFrom(bArr);
            this.f31168b.setInput(this.f31171e);
            this.f31168b.forEach(this.f31172f);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f31172f.copyTo(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
