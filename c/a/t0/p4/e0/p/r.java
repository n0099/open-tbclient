package c.a.t0.p4.e0.p;

import c.a.s0.s.s.a;
import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes8.dex */
public final /* synthetic */ class r implements a.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ r f21219e = new r();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ r() {
    }

    @Override // c.a.s0.s.s.a.e
    public final void onClick(c.a.s0.s.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            WorkPublishActivity.m88showLocPermissionDialog$lambda21(aVar);
        }
    }
}
