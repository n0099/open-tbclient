package b.a.q0.j0;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static h f12669h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12670a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends b.a.q0.j0.a>, b.a.q0.j0.b> f12671b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends b.a.q0.j0.a>, LinkedList<i>> f12672c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f12673d;

    /* renamed from: e  reason: collision with root package name */
    public d f12674e;

    /* renamed from: f  reason: collision with root package name */
    public final b.a.q0.j0.c f12675f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a.q0.n.g f12676g;

    /* loaded from: classes4.dex */
    public class a implements b.a.q0.j0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f12677a;

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
            this.f12677a = hVar;
        }

        @Override // b.a.q0.j0.c
        public void a(b.a.q0.j0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f12677a.d(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.j0.a f12678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f12679f;

        public b(h hVar, b.a.q0.j0.a aVar) {
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
            this.f12679f = hVar;
            this.f12678e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12679f.c(this.f12678e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.q0.n.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f12680e;

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
            this.f12680e = hVar;
        }

        @Override // b.a.q0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.f12680e.n(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-84392365, "Lb/a/q0/j0/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-84392365, "Lb/a/q0/j0/h;");
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
        this.f12670a = false;
        this.f12673d = new Handler(Looper.getMainLooper());
        this.f12675f = new a(this);
        this.f12676g = new c(this);
        this.f12671b = new HashMap();
        this.f12672c = new HashMap();
    }

    public static h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f12669h == null) {
                synchronized (h.class) {
                    if (f12669h == null) {
                        f12669h = new h();
                    }
                }
            }
            return f12669h;
        }
        return (h) invokeV.objValue;
    }

    public static void i(@NonNull b.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            f().h(aVar);
        }
    }

    public final void c(b.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        Class<?> cls = aVar.getClass();
        try {
            b.a.q0.j0.b bVar = this.f12671b.get(cls);
            if (bVar != null) {
                bVar.onEvent(aVar);
            }
        } catch (Exception e2) {
            BdLog.detailException(cls.getName(), e2);
        }
        try {
            LinkedList<i> linkedList = this.f12672c.get(cls);
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

    public final void d(b.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (l.C()) {
                c(aVar);
            } else {
                this.f12673d.post(new b(this, aVar));
            }
        }
    }

    public final void e(@NonNull Class<? extends b.a.q0.j0.a> cls, BdUniqueId bdUniqueId) {
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, application) == null) || this.f12670a) {
            return;
        }
        f.g();
        k(application);
        e eVar = new e(application);
        this.f12674e = eVar;
        eVar.b(this.f12675f);
        this.f12674e.startService();
        this.f12670a = true;
    }

    public void h(@NonNull b.a.q0.j0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!f.i()) {
                String c2 = f.c();
                f.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = aVar.getPid();
            if (aVar.getType() == 2 && myPid == pid) {
                d(aVar);
            } else {
                j(aVar);
            }
        }
    }

    public final void j(b.a.q0.j0.a aVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (dVar = this.f12674e) == null) {
            return;
        }
        dVar.a(aVar);
    }

    public final void k(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, application) == null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f12676g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(@NonNull Class<? extends b.a.q0.j0.a> cls, @NonNull b.a.q0.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cls, bVar) == null) {
            if (this.f12671b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.f12671b.put(cls, bVar);
        }
    }

    public void m(@NonNull Class<? extends b.a.q0.j0.a> cls, @NonNull i iVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, iVar, bdUniqueId) == null) {
            LinkedList<i> linkedList = this.f12672c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f12672c.put(cls, linkedList);
            }
            if (linkedList.contains(iVar)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            iVar.setTag(bdUniqueId);
            FrameHelper.insert(linkedList, iVar);
            e(cls, bdUniqueId);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends b.a.q0.j0.a>, LinkedList<i>> entry : this.f12672c.entrySet()) {
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
