package c.a.p0.a.q.a.j;

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
    public float f7089b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7090c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7091d;

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
        this.a = "sans-serif";
        this.f7089b = c.a.p0.a.p2.n0.g(10.0f);
        this.f7090c = false;
        this.f7091d = false;
    }

    @Override // c.a.p0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (this.f7090c && this.f7091d) {
                i2 = 3;
            } else if (this.f7090c) {
                i2 = 1;
            } else {
                i2 = this.f7091d ? 2 : 0;
            }
            bVar.f7049i.setTypeface(Typeface.create(this.a, i2));
            bVar.f7049i.setTextSize(this.f7089b);
        }
    }

    @Override // c.a.p0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    for (String str : jSONArray.optString(0).split(" ")) {
                        if (str.contains("italic")) {
                            this.f7091d = true;
                        } else if (str.contains("oblique")) {
                            this.f7091d = true;
                        } else if (str.contains("bold")) {
                            this.f7090c = true;
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
                                this.f7089b = c.a.p0.a.p2.n0.g(Float.parseFloat(str.substring(0, length)));
                            } else {
                                this.a = str;
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.p0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
