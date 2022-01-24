package c.a.r0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.text.SpanItem;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class o extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public float f5256b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5257c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5258d;

    public o() {
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
        this.a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.f5256b = c.a.r0.a.z2.n0.g(10.0f);
        this.f5257c = false;
        this.f5258d = false;
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f5257c && this.f5258d) {
                i2 = 3;
            } else if (this.f5257c) {
                i2 = 1;
            } else {
                i2 = this.f5258d ? 2 : 0;
            }
            bVar.f5216i.setTypeface(Typeface.create(this.a, i2));
            bVar.f5216i.setTextSize(this.f5256b);
        }
    }

    @Override // c.a.r0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains(SpanItem.STYLE_ITALIC)) {
                            this.f5258d = true;
                        } else if (str.contains("oblique")) {
                            this.f5258d = true;
                        } else if (str.contains(SpanItem.STYLE_BOLD)) {
                            this.f5257c = true;
                        } else if (!str.contains("normal")) {
                            if (Character.isDigit(str.charAt(0))) {
                                int length = str.length();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= str.length()) {
                                        break;
                                    } else if (!Character.isDigit(str.charAt(i2))) {
                                        length = i2;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                this.f5256b = c.a.r0.a.z2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.r0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
