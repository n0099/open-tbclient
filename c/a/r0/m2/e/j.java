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
    public boolean f22382a;

    /* renamed from: b  reason: collision with root package name */
    public String f22383b;

    /* renamed from: c  reason: collision with root package name */
    public String f22384c;

    /* renamed from: d  reason: collision with root package name */
    public String f22385d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f22386e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f22387f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f22388g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22389h;

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
        this.f22382a = false;
    }
}
