package c.a.n0.j.p0.d.a;

import android.graphics.Color;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0722a a;
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

    /* renamed from: c.a.n0.j.p0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0722a {
        void s();
    }

    public a(@NonNull c.a.n0.a.o.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontSize = 16.0d;
        this.opacity = 1.0d;
        a(aVar);
    }

    public static int c(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            float f2 = (((-16777216) & i) >>> 24) / 255.0f;
            return f2 > 0.0f ? Color.argb(255, (int) ((((16711680 & i) >> 16) * f2) + 0.5d), (int) ((((65280 & i) >> 8) * f2) + 0.5d), (int) (((i & 255) * f2) + 0.5d)) : i;
        }
        return invokeI.intValue;
    }

    public final void a(@NonNull c.a.n0.a.o.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.left = aVar.r("left", this.left);
            this.top = aVar.r(AnimationProperty.TOP, this.top);
            this.width = aVar.r("width", this.width);
            this.height = aVar.r("height", this.height);
            this.backgroundColor = aVar.C("backgroundColor", this.backgroundColor);
            this.borderColor = aVar.C("borderColor", this.borderColor);
            this.borderRadius = aVar.n("borderRadius", this.borderRadius);
            this.borderWidth = aVar.r("borderWidth", this.borderWidth);
            this.fontSize = aVar.n(TtmlNode.ATTR_TTS_FONT_SIZE, this.fontSize);
            this.lineHeight = aVar.r("lineHeight", this.lineHeight);
            this.textAlign = aVar.C(TtmlNode.ATTR_TTS_TEXT_ALIGN, this.textAlign);
            this.fontWeight = aVar.C(TtmlNode.ATTR_TTS_FONT_WEIGHT, this.fontWeight);
            this.hidden = aVar.m(TKBase.VISIBILITY_HIDDEN, this.hidden);
            this.opacity = aVar.n("opacity", this.opacity);
            this.color = aVar.C("color", this.color);
            if (c.a.n0.a.a.a) {
                Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
            }
        }
    }

    public void b(InterfaceC0722a interfaceC0722a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0722a) == null) {
            this.a = interfaceC0722a;
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (c.a.n0.a.a.a) {
                Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
            }
            InterfaceC0722a interfaceC0722a = this.a;
            if (interfaceC0722a != null) {
                interfaceC0722a.s();
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
