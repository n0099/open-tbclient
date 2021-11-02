package b.a.p0.a.s1;

import androidx.annotation.NonNull;
import b.a.p0.a.s1.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f7854a;

    /* renamed from: b  reason: collision with root package name */
    public final f f7855b;

    public a(int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7854a = i2;
        this.f7855b = fVar;
    }

    @Override // b.a.p0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, strArr, iArr) == null) {
            if (i2 != this.f7854a) {
                this.f7855b.b(2, "request permission fail");
                return;
            }
            for (int i3 : iArr) {
                if (i3 == -1) {
                    this.f7855b.b(1, "user denied");
                    return;
                }
            }
            this.f7855b.a("permission granted successful");
        }
    }
}
