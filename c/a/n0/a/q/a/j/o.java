package c.a.n0.a.q.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class o extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public float f5938b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5939c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5940d;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "sans-serif";
        this.f5938b = c.a.n0.a.p2.n0.g(10.0f);
        this.f5939c = false;
        this.f5940d = false;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f5939c && this.f5940d) {
                i = 3;
            } else if (this.f5939c) {
                i = 1;
            } else {
                i = this.f5940d ? 2 : 0;
            }
            bVar.f5899e.setTypeface(Typeface.create(this.a, i));
            bVar.f5899e.setTextSize(this.f5938b);
        }
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.f5940d = true;
                        } else if (str.contains("oblique")) {
                            this.f5940d = true;
                        } else if (str.contains("bold")) {
                            this.f5939c = true;
                        } else if (!str.contains("normal")) {
                            if (Character.isDigit(str.charAt(0))) {
                                int length = str.length();
                                int i = 0;
                                while (true) {
                                    if (i >= str.length()) {
                                        break;
                                    } else if (!Character.isDigit(str.charAt(i))) {
                                        length = i;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                this.f5938b = c.a.n0.a.p2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
