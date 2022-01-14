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
    public final long f4006b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4007c;

    /* renamed from: c.a.j.l.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0183a<T> implements c.a.j.h.c.c.c.c<TaskToastViewData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.j.l.h.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0184a implements b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TaskToastViewData f4008b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0183a f4009c;

            public C0184a(String str, TaskToastViewData taskToastViewData, C0183a c0183a, TaskToastViewData taskToastViewData2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, taskToastViewData, c0183a, taskToastViewData2};
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
                this.f4008b = taskToastViewData;
                this.f4009c = c0183a;
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
                        d3.b(this.f4008b.getTaskInfoSingleKey(), c.a.j.g.f.b.f3892c.a());
                    }
                    c.a.j.j.d.a v2 = BDPTask.m.v();
                    if (v2 != null && (d2 = v2.d()) != null) {
                        d2.a(this.f4008b.getTaskInfoSingleKey());
                    }
                    c.a.j.j.d.a v3 = BDPTask.m.v();
                    if (v3 != null && (b2 = v3.b()) != null) {
                        b2.a(this.a, 2);
                    }
                    this.f4009c.a.h(this.f4008b.getTaskInfo());
                }
            }
        }

        /* renamed from: c.a.j.l.h.d.a$a$b */
        /* loaded from: classes.dex */
        public static final class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f4010e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0183a f4011f;

            public b(Context context, C0183a c0183a, TaskToastViewData taskToastViewData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, c0183a, taskToastViewData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4010e = context;
                this.f4011f = c0183a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4011f.a.a.k(this.f4010e);
                }
            }
        }

        public C0183a(a aVar) {
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
            this.a.a.a(this.a.f4007c);
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
                this.a.a.c(new C0184a(backBtnSchema, taskToastViewData, this, taskToastViewData));
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
                        c.a.j.h.d.e.d(new b(activity, this, taskToastViewData), this.a.f4006b);
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
        this.f4006b = 100L;
        this.f4007c = 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.j.h.c.c.a
    /* renamed from: g */
    public void a(c.a.j.e.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a().l(new C0183a(this));
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
