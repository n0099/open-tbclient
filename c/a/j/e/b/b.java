package c.a.j.e.b;

import c.a.j.h.c.b.a;
import c.a.j.h.c.b.b;
import com.baidu.bdtask.framework.ui.dialog.TaskDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class b<VD extends TaskDialogData, VM extends c.a.j.h.c.b.a<VD>, View extends c.a.j.h.c.b.b<VM>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final VM f3897b;

    /* renamed from: c  reason: collision with root package name */
    public final VD f3898c;

    public b(View view, VM vm, VD vd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, vm, vd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f3897b = vm;
        this.f3898c = vd;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.a(this.f3897b);
            this.f3897b.b(this.f3898c);
        }
    }
}
