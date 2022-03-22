package c.a.a0.f;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f1153b;

    /* renamed from: c  reason: collision with root package name */
    public int f1154c;

    /* renamed from: d  reason: collision with root package name */
    public long f1155d;

    /* renamed from: e  reason: collision with root package name */
    public long f1156e;

    /* renamed from: f  reason: collision with root package name */
    public long f1157f;

    /* renamed from: g  reason: collision with root package name */
    public long f1158g;

    /* renamed from: h  reason: collision with root package name */
    public long f1159h;

    public c() {
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
        this.a = new int[]{0, 0};
        this.f1153b = new int[]{0, 0};
        this.f1154c = 0;
        this.f1159h = 0L;
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f1155d = currentTimeMillis;
                if (this.f1159h == 0) {
                    this.f1159h = currentTimeMillis;
                }
                this.a[0] = (int) motionEvent.getRawX();
                this.a[1] = (int) motionEvent.getRawY();
            } else if (action != 1) {
                if (action != 2) {
                    return;
                }
                this.f1154c++;
            } else {
                this.f1154c = 0;
                this.f1156e = System.currentTimeMillis();
                this.f1153b[0] = (int) motionEvent.getRawX();
                this.f1153b[1] = (int) motionEvent.getRawY();
                if (Math.max(Math.abs(this.f1153b[0] - this.a[0]), Math.abs(this.f1153b[1] - this.a[1])) > 10) {
                    this.f1158g++;
                    this.f1157f += Math.max(0L, this.f1156e - this.f1155d);
                }
            }
        }
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int[] iArr = this.f1153b;
            return new int[]{iArr[0], iArr[1]};
        }
        return (int[]) invokeV.objValue;
    }
}
