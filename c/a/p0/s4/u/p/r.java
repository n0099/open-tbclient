package c.a.p0.s4.u.p;

import c.a.o0.r.t.a;
import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class r implements a.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ r a = new r();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ r() {
    }

    @Override // c.a.o0.r.t.a.e
    public final void onClick(c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            WorkPublishActivity.m81showLocPermissionDialog$lambda21(aVar);
        }
    }
}
