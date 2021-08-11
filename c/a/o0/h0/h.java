package c.a.o0.h0;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static h f13222h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13223a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends c.a.o0.h0.a>, c.a.o0.h0.b> f13224b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends c.a.o0.h0.a>, LinkedList<i>> f13225c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f13226d;

    /* renamed from: e  reason: collision with root package name */
    public d f13227e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.o0.h0.c f13228f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.o0.n.g f13229g;

    /* loaded from: classes3.dex */
    public class a implements c.a.o0.h0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f13230a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13230a = hVar;
        }

        @Override // c.a.o0.h0.c
        public void a(c.a.o0.h0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f13230a.d(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h0.a f13231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f13232f;

        public b(h hVar, c.a.o0.h0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13232f = hVar;
            this.f13231e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13232f.c(this.f13231e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.o0.n.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f13233e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13233e = hVar;
        }

        @Override // c.a.o0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.f13233e.n(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(852189938, "Lc/a/o0/h0/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(852189938, "Lc/a/o0/h0/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13223a = false;
        this.f13226d = new Handler(Looper.getMainLooper());
        this.f13228f = new a(this);
        this.f13229g = new c(this);
        this.f13224b = new HashMap();
        this.f13225c = new HashMap();
    }

    public static h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f13222h == null) {
                synchronized (h.class) {
                    if (f13222h == null) {
                        f13222h = new h();
                    }
                }
            }
            return f13222h;
        }
        return (h) invokeV.objValue;
    }

    public static void i(@NonNull c.a.o0.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            f().h(aVar);
        }
    }

    public final void c(c.a.o0.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        Class<?> cls = aVar.getClass();
        try {
            c.a.o0.h0.b bVar = this.f13224b.get(cls);
            if (bVar != null) {
                bVar.onEvent(aVar);
            }
        } catch (Exception e2) {
            BdLog.detailException(cls.getName(), e2);
        }
        try {
            LinkedList<i> linkedList = this.f13225c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (i iVar : linkedList) {
                if (iVar != null && (!iVar.isSelfListener() || (aVar.getPid() == myPid && iVar.getTag() != null && iVar.getTag().getId() == aVar.getTag()))) {
                    try {
                        iVar.onEvent(aVar);
                    } catch (Exception e3) {
                        BdLog.detailException(cls.getName(), e3);
                    }
                }
            }
        } catch (Exception e4) {
            BdLog.detailException(cls.getName(), e4);
        }
    }

    public final void d(c.a.o0.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (l.C()) {
                c(aVar);
            } else {
                this.f13226d.post(new b(this, aVar));
            }
        }
    }

    public final void e(@NonNull Class<? extends c.a.o0.h0.a> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject c2 = g.c(cls.getSimpleName(), cls);
            if (c2 instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) c2;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void g(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, application) == null) || this.f13223a) {
            return;
        }
        k(application);
        e eVar = new e(application);
        this.f13227e = eVar;
        eVar.c(this.f13228f);
        this.f13227e.a();
        this.f13223a = true;
    }

    public void h(@NonNull c.a.o0.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            int myPid = Process.myPid();
            int pid = aVar.getPid();
            if (aVar.getType() == 2 && myPid == pid) {
                d(aVar);
            } else {
                j(aVar);
            }
        }
    }

    public final void j(c.a.o0.h0.a aVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (dVar = this.f13227e) == null) {
            return;
        }
        dVar.b(aVar);
    }

    public final void k(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, application) == null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f13229g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(@NonNull Class<? extends c.a.o0.h0.a> cls, @NonNull c.a.o0.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, bVar) == null) {
            if (this.f13224b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.f13224b.put(cls, bVar);
        }
    }

    public void m(@NonNull Class<? extends c.a.o0.h0.a> cls, @NonNull i iVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, iVar, bdUniqueId) == null) {
            LinkedList<i> linkedList = this.f13225c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f13225c.put(cls, linkedList);
            }
            if (linkedList.contains(iVar)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            iVar.setTag(bdUniqueId);
            FrameHelper.f(linkedList, iVar);
            e(cls, bdUniqueId);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends c.a.o0.h0.a>, LinkedList<i>> entry : this.f13225c.entrySet()) {
            LinkedList<i> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<i> it = value.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
