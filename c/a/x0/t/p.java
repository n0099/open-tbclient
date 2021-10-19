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
    public RenderScript f31235a;

    /* renamed from: b  reason: collision with root package name */
    public ScriptIntrinsicYuvToRGB f31236b;

    /* renamed from: c  reason: collision with root package name */
    public Type.Builder f31237c;

    /* renamed from: d  reason: collision with root package name */
    public Type.Builder f31238d;

    /* renamed from: e  reason: collision with root package name */
    public Allocation f31239e;

    /* renamed from: f  reason: collision with root package name */
    public Allocation f31240f;

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
        this.f31235a = create;
        this.f31236b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public Bitmap a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (this.f31237c == null) {
                RenderScript renderScript = this.f31235a;
                Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f31237c = x;
                this.f31239e = Allocation.createTyped(this.f31235a, x.create(), 1);
                RenderScript renderScript2 = this.f31235a;
                Type.Builder y = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i2).setY(i3);
                this.f31238d = y;
                this.f31240f = Allocation.createTyped(this.f31235a, y.create(), 1);
            }
            this.f31239e.copyFrom(bArr);
            this.f31236b.setInput(this.f31239e);
            this.f31236b.forEach(this.f31240f);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f31240f.copyTo(createBitmap);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
