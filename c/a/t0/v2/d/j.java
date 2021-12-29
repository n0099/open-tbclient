package c.a.t0.v2.d;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f25309b;

    /* renamed from: c  reason: collision with root package name */
    public String f25310c;

    /* renamed from: d  reason: collision with root package name */
    public String f25311d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f25312e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f25313f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f25314g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25315h;

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
