package c.a.j.l.h.d;

import android.app.Activity;
import android.content.Context;
import c.a.j.l.h.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.toast.TaskToastViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.j.h.c.d.b<c.a.j.e.d.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public final long f3641b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3642c;

    /* renamed from: c.a.j.l.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0153a<T> implements c.a.j.h.c.c.c.c<TaskToastViewData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.j.l.h.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0154a implements b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TaskToastViewData f3643b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0153a f3644c;

            public C0154a(String str, TaskToastViewData taskToastViewData, C0153a c0153a, TaskToastViewData taskToastViewData2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, taskToastViewData, c0153a, taskToastViewData2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f3643b = taskToastViewData;
                this.f3644c = c0153a;
            }

            @Override // c.a.j.l.h.d.b.a
            public final void a() {
                c.a.j.h.b.h.a b2;
                c.a.j.j.e.a.a d2;
                c.a.j.j.e.a.a d3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.j.j.d.a v = BDPTask.m.v();
                    if (v != null && (d3 = v.d()) != null) {
                        d3.b(this.f3643b.getTaskInfoSingleKey(), c.a.j.g.f.b.f3526c.a());
                    }
                    c.a.j.j.d.a v2 = BDPTask.m.v();
                    if (v2 != null && (d2 = v2.d()) != null) {
                        d2.a(this.f3643b.getTaskInfoSingleKey());
                    }
                    c.a.j.j.d.a v3 = BDPTask.m.v();
                    if (v3 != null && (b2 = v3.b()) != null) {
                        b2.a(this.a, 2);
                    }
                    this.f3644c.a.h(this.f3643b.getTaskInfo());
                }
            }
        }

        /* renamed from: c.a.j.l.h.d.a$a$b */
        /* loaded from: classes.dex */
        public static final class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f3645e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0153a f3646f;

            public b(Context context, C0153a c0153a, TaskToastViewData taskToastViewData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, c0153a, taskToastViewData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3645e = context;
                this.f3646f = c0153a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3646f.a.a.k(this.f3645e);
                }
            }
        }

        public C0153a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.j.h.c.c.c.c
        /* renamed from: a */
        public final void onChanged(TaskToastViewData taskToastViewData) {
            c.a.j.h.b.d.a h2;
            c.a.j.h.b.d.a h3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, taskToastViewData) == null) || taskToastViewData == null) {
                return;
            }
            this.a.a.a(this.a.f3642c);
            this.a.a.d(taskToastViewData.getMessage());
            this.a.a.e(taskToastViewData.getBackColor());
            this.a.a.h(taskToastViewData.getDuration());
            this.a.a.j(taskToastViewData.getTxtColor());
            this.a.a.b(taskToastViewData.getToastLayoutParams());
            this.a.a.q(taskToastViewData.getBgUrl());
            String backBtnBgUrl = taskToastViewData.getBackBtnBgUrl();
            if (backBtnBgUrl != null) {
                this.a.a.o(backBtnBgUrl);
            }
            String backBtnColor = taskToastViewData.getBackBtnColor();
            if (backBtnColor != null) {
                this.a.a.n(backBtnColor);
            }
            String backBtnSchema = taskToastViewData.getBackBtnSchema();
            if (backBtnSchema != null) {
                this.a.a.c(new C0154a(backBtnSchema, taskToastViewData, this, taskToastViewData));
            }
            String backBtnTxt = taskToastViewData.getBackBtnTxt();
            if (backBtnTxt != null) {
                this.a.a.i(backBtnTxt);
            }
            String backBtnTxtColor = taskToastViewData.getBackBtnTxtColor();
            if (backBtnTxtColor != null) {
                this.a.a.p(backBtnTxtColor);
            }
            c.a.j.j.d.a v = BDPTask.m.v();
            Activity activity = null;
            Context appContext = (v == null || (h3 = v.h()) == null) ? null : h3.getAppContext();
            c.a.j.j.d.a v2 = BDPTask.m.v();
            if (v2 != null && (h2 = v2.h()) != null) {
                activity = h2.a();
            }
            if (activity == null) {
                activity = appContext;
            }
            if (activity != null) {
                int showType = taskToastViewData.getShowType();
                if (showType != 1) {
                    if (showType == 2) {
                        c.a.j.h.d.e.d(new b(activity, this, taskToastViewData), this.a.f3641b);
                    }
                } else if (appContext != null) {
                    this.a.a.g(appContext);
                }
                this.a.i(taskToastViewData.getTaskInfo(), taskToastViewData.getTaskStatus());
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
                return;
            }
        }
        this.a = new b();
        this.f3641b = 100L;
        this.f3642c = 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.j.h.c.c.a
    /* renamed from: g */
    public void a(c.a.j.e.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a().l(new C0153a(this));
        }
    }

    public final void h(TaskInfo taskInfo) {
        c.a.j.j.d.a v;
        c.a.j.j.i.a f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskInfo) == null) || (v = BDPTask.m.v()) == null || (f2 = v.f()) == null) {
            return;
        }
        f2.a("y_task_toast", "icon_clk", c.a.j.j.i.b.b(c.a.j.j.i.b.a, taskInfo.getId(), taskInfo.getActTaskId(), null, 4, null));
    }

    public final void i(TaskInfo taskInfo, TaskStatus taskStatus) {
        c.a.j.j.i.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, taskInfo, taskStatus) == null) {
            String c2 = c.a.j.j.i.b.a.c(taskStatus);
            c.a.j.j.d.a v = BDPTask.m.v();
            if (v == null || (f2 = v.f()) == null) {
                return;
            }
            f2.a("y_task_toast", "c_pv", c.a.j.j.i.b.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c2));
        }
    }
}
