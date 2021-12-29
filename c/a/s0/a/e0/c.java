package c.a.s0.a.e0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.g;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.ui.components.buoy.TaskBuoyView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static int f12407b;

    /* renamed from: c  reason: collision with root package name */
    public static int f12408c;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* loaded from: classes6.dex */
    public class a implements c.a.j.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.j.d.b
        public void a(TaskInfo taskInfo, TaskStatus taskStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, taskInfo, taskStatus) == null) {
                BdLog.d(taskInfo.getActionId() + " taskStatus onChanged :" + taskStatus);
                if (taskStatus.isRegistered()) {
                    BdLog.d("isRegistered=============>");
                }
                if (taskStatus.isUnRegistered()) {
                    BdLog.d("isUnRegistered=============>");
                }
                if (taskStatus.isRunning()) {
                    BdLog.d("isRunning=============>");
                }
                if (taskStatus.isFinished()) {
                    BdLog.d("isFinished=============>");
                }
            }
        }

        @Override // c.a.j.d.b
        public void b(TaskInfo taskInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i2, str) == null) {
                BdLog.d("[debug]error:" + str + " " + i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.j.l.h.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.j.l.h.a.b, c.a.j.l.h.a.c
        public void a(View view, TaskInfo taskInfo, TaskBuoyViewData taskBuoyViewData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, view, taskInfo, taskBuoyViewData) == null) {
                super.a(view, taskInfo, taskBuoyViewData);
                taskBuoyViewData.getTaskStatus().isFinished();
            }
        }
    }

    /* renamed from: c.a.s0.a.e0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0814c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1188523901, "Lc/a/s0/a/e0/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1188523901, "Lc/a/s0/a/e0/c$c;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0814c.a : (c) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || b(str) == null) {
            return;
        }
        BDPTask.m.h(str);
    }

    public TaskInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (BDPTask.m.m(str) == null) {
                return null;
            }
            return BDPTask.m.m(str).getTaskInfo();
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final void c(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri) == null) {
            String queryParameter = uri.getQueryParameter(g.d0);
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            String queryParameter2 = uri.getQueryParameter(g.f0);
            if (!TextUtils.isEmpty(queryParameter2)) {
                l(queryParameter2, queryParameter);
            }
            d(uri, queryParameter);
        }
    }

    public final void d(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, uri, str) == null) {
            c.a.s0.a.c cVar = new c.a.s0.a.c(str);
            int i2 = StringHelper.equals(uri.getQueryParameter(g.C), g.l0) ? 2 : 1;
            String queryParameter = uri.getQueryParameter(g.t);
            String queryParameter2 = uri.getQueryParameter(g.u);
            String queryParameter3 = uri.getQueryParameter(g.Y);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", cVar.e()).param("obj_type", cVar.d()).param("obj_param1", cVar.q()).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, cVar.s()).param("extra", cVar.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", queryParameter).param("tid", queryParameter2).param("query", queryParameter3).param("pid", uri.getQueryParameter("hightlight_anchor_pid")).param(TiebaStatic.Params.REFER, uri.getQueryParameter(TiebaStatic.Params.REFER)).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1));
        }
    }

    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            String p = j2.p("key_sdk_task_expand_data_" + str, "");
            if (TextUtils.isEmpty(p)) {
                return null;
            }
            try {
                return new JSONObject(p).optString(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            c.a.s0.a.e0.a.e(context);
            this.a = BdUniqueId.gen();
            c.a.s0.a.e0.b.a().b(this.a);
            f12408c = UtilHelper.getDimenPixelSize(R.dimen.tbds340);
            f12407b = UtilHelper.getDimenPixelSize(R.dimen.M_W_X011);
        }
    }

    public void h(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, buoyComponent) == null) && buoyComponent != null && (buoyComponent instanceof c.a.j.e.a.i.a)) {
            ((c.a.j.e.a.i.a) buoyComponent).F();
        }
    }

    public void i(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter(g.e0);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        j(queryParameter);
        c(uri);
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            BDPTask.m.A(str, new a(this));
        }
    }

    public void k(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, buoyComponent) == null) && buoyComponent != null && (buoyComponent instanceof c.a.j.e.a.i.a)) {
            ((c.a.j.e.a.i.a) buoyComponent).H();
        }
    }

    public void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
            j2.x("key_sdk_task_expand_data_" + str, str2);
        }
    }

    public BuoyComponent m(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        TaskInfo b2;
        BuoyComponent buoyComponent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, activity, viewGroup, str)) == null) {
            if (activity == null || (b2 = b(str)) == null) {
                return null;
            }
            TaskBuoyView taskBuoyView = new TaskBuoyView(activity);
            taskBuoyView.U(new b(this));
            if (b2.isClickAction()) {
                buoyComponent = c.a.j.e.a.b.b(taskBuoyView, new TaskBuoyViewModel(b2), b2);
            } else {
                buoyComponent = c.a.j.e.a.b.a(taskBuoyView, new c.a.j.e.a.i.b(b2), b2);
            }
            if (viewGroup != null) {
                buoyComponent.l(viewGroup, null);
            } else {
                int statusBarHeight = UtilHelper.getStatusBarHeight();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 5;
                layoutParams.topMargin = f12408c + statusBarHeight;
                layoutParams.rightMargin = f12407b;
                buoyComponent.l((FrameLayout) activity.findViewById(16908290), layoutParams);
            }
            if (buoyComponent instanceof c.a.j.e.a.i.a) {
                ((c.a.j.e.a.i.a) buoyComponent).J();
            }
            return buoyComponent;
        }
        return (BuoyComponent) invokeLLL.objValue;
    }

    public void n(BuoyComponent buoyComponent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, buoyComponent) == null) || buoyComponent == null) {
            return;
        }
        buoyComponent.n();
    }

    public c() {
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
}
