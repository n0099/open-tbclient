package c.a.s0.n4.e0.p;

import c.a.r0.s.t.a;
import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class r implements a.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ r f20340e = new r();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ r() {
    }

    @Override // c.a.r0.s.t.a.e
    public final void onClick(c.a.r0.s.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            WorkPublishActivity.m88showLocPermissionDialog$lambda21(aVar);
        }
    }
}
