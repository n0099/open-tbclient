package c.a.r0.j.p0.d.a;

import android.graphics.Color;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0763a a;
    @V8JavascriptField
    public String backgroundColor;
    @V8JavascriptField
    public String borderColor;
    @V8JavascriptField
    public double borderRadius;
    @V8JavascriptField
    public int borderWidth;
    @V8JavascriptField
    public String color;
    @V8JavascriptField
    public double fontSize;
    @V8JavascriptField
    public String fontWeight;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public boolean hidden;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int lineHeight;
    @V8JavascriptField
    public double opacity;
    @V8JavascriptField
    public String textAlign;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* renamed from: c.a.r0.j.p0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0763a {
        void r();
    }

    public a(@NonNull c.a.r0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontSize = 16.0d;
        this.opacity = 1.0d;
        a(aVar);
    }

    public static int c(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            float f2 = (((-16777216) & i2) >>> 24) / 255.0f;
            return f2 > 0.0f ? Color.argb(255, (int) ((((16711680 & i2) >> 16) * f2) + 0.5d), (int) ((((65280 & i2) >> 8) * f2) + 0.5d), (int) (((i2 & 255) * f2) + 0.5d)) : i2;
        }
        return invokeI.intValue;
    }

    public final void a(@NonNull c.a.r0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.left = aVar.r("left", this.left);
            this.top = aVar.r("top", this.top);
            this.width = aVar.r("width", this.width);
            this.height = aVar.r("height", this.height);
            this.backgroundColor = aVar.C("backgroundColor", this.backgroundColor);
            this.borderColor = aVar.C("borderColor", this.borderColor);
            this.borderRadius = aVar.n("borderRadius", this.borderRadius);
            this.borderWidth = aVar.r("borderWidth", this.borderWidth);
            this.fontSize = aVar.n("fontSize", this.fontSize);
            this.lineHeight = aVar.r("lineHeight", this.lineHeight);
            this.textAlign = aVar.C("textAlign", this.textAlign);
            this.fontWeight = aVar.C("fontWeight", this.fontWeight);
            this.hidden = aVar.m(TKBase.VISIBILITY_HIDDEN, this.hidden);
            this.opacity = aVar.n("opacity", this.opacity);
            this.color = aVar.C("color", this.color);
            if (k.a) {
                String str = "parseApiButtonStyle = " + toString();
            }
        }
    }

    public void b(InterfaceC0763a interfaceC0763a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0763a) == null) {
            this.a = interfaceC0763a;
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (k.a) {
                String str2 = "onFieldChangedCallback fieldName=" + str;
            }
            InterfaceC0763a interfaceC0763a = this.a;
            if (interfaceC0763a != null) {
                interfaceC0763a.r();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
        }
        return (String) invokeV.objValue;
    }
}
