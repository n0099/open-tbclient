package c.a.p0.z2.d;

import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f20953b;

    /* renamed from: c  reason: collision with root package name */
    public String f20954c;

    /* renamed from: d  reason: collision with root package name */
    public String f20955d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f20956e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f20957f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f20958g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20959h;

    public j() {
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
        this.a = false;
    }
}
