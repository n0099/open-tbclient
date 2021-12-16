package c.a.j.l.h.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import c.a.j.h.c.b.b;
import c.a.j.h.c.c.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.bdtask.ui.components.dialog.DoubleBtnDialog;
import com.baidu.bdtask.ui.components.dialog.SingleBtnDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends b<c.a.j.e.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.j.l.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0152a<T> implements c<TaskDialogViewData> {
        public static /* synthetic */ Interceptable $ic;
        public static final C0152a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858080830, "Lc/a/j/l/h/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1858080830, "Lc/a/j/l/h/c/a$a;");
                    return;
                }
            }
            a = new C0152a();
        }

        public C0152a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.j.h.c.c.c.c
        /* renamed from: a */
        public final void onChanged(TaskDialogViewData taskDialogViewData) {
            c.a.j.h.b.d.a h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, taskDialogViewData) == null) || taskDialogViewData == null) {
                return;
            }
            c.a.j.j.d.a v = BDPTask.m.v();
            Context appContext = (v == null || (h2 = v.h()) == null) ? null : h2.getAppContext();
            Intent intent = new Intent(appContext, taskDialogViewData.getShowType() == 1 ? SingleBtnDialog.class : DoubleBtnDialog.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", taskDialogViewData);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            if (appContext != null) {
                appContext.startActivity(intent);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.j.h.c.c.a
    /* renamed from: b */
    public void a(c.a.j.e.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a().l(C0152a.a);
        }
    }
}
