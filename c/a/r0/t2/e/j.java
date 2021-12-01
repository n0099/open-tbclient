package c.a.r0.t2.e;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f23713b;

    /* renamed from: c  reason: collision with root package name */
    public String f23714c;

    /* renamed from: d  reason: collision with root package name */
    public String f23715d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f23716e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23717f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23718g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23719h;

    public j() {
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
        this.a = false;
    }
}
