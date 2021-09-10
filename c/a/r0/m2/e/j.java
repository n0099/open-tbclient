package c.a.r0.m2.e;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22366a;

    /* renamed from: b  reason: collision with root package name */
    public String f22367b;

    /* renamed from: c  reason: collision with root package name */
    public String f22368c;

    /* renamed from: d  reason: collision with root package name */
    public String f22369d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f22370e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f22371f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f22372g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22373h;

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
        this.f22366a = false;
    }
}
