package c.a.p0.a.u1.n;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnyThread;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a implements c.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Integer, CopyOnWriteArrayList<View>> f8590c;

    /* renamed from: c.a.p0.a.u1.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0507a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(724851257, "Lc/a/p0/a/u1/n/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(724851257, "Lc/a/p0/a/u1/n/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0507a c0507a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public View b(@LayoutRes int i2, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeCommon;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), viewGroup, Boolean.valueOf(z)})) == null) {
            View d2 = d(i2);
            if (d2 != null && viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                ViewGroup.LayoutParams layoutParams2 = d2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
                } else {
                    layoutParams2.width = layoutParams.width;
                    layoutParams2.height = layoutParams.height;
                }
                d2.setLayoutParams(layoutParams2);
            }
            if (d2 == null) {
                long currentTimeMillis = System.currentTimeMillis();
                View inflate = LayoutInflater.from(c.a.p0.a.c1.a.c()).inflate(i2, viewGroup, z);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (c.a.p0.a.f1.f.a.a) {
                    String str = "getView resId = " + i2 + " ；inflate new view cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
                return inflate;
            }
            return d2;
        }
        return (View) invokeCommon.objValue;
    }

    @AnyThread
    public void c(@LayoutRes int... iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) || iArr == null || iArr.length == 0) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int length = iArr.length;
            LayoutInflater from = LayoutInflater.from(c.a.p0.a.c1.a.c());
            for (int i2 : iArr) {
                View inflate = from.inflate(i2, (ViewGroup) null);
                CopyOnWriteArrayList<View> copyOnWriteArrayList = this.f8590c.get(Integer.valueOf(i2));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                copyOnWriteArrayList.add(inflate);
                this.f8590c.put(Integer.valueOf(i2), copyOnWriteArrayList);
            }
            if (c.a.p0.a.f1.f.a.a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "inflateLayoutRes count = " + length + "; cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        } catch (Exception e2) {
            if (c.a.p0.a.f1.f.a.a) {
                Log.getStackTraceString(e2);
            }
        }
    }

    @Nullable
    @AnyThread
    public View d(@LayoutRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            View view = null;
            try {
                CopyOnWriteArrayList<View> copyOnWriteArrayList = this.f8590c.get(Integer.valueOf(i2));
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    view = copyOnWriteArrayList.remove(0);
                }
            } catch (Exception e2) {
                if (c.a.p0.a.f1.f.a.a) {
                    Log.getStackTraceString(e2);
                }
            }
            if (c.a.p0.a.f1.f.a.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryObtainLayoutByResId resId = ");
                sb.append(i2);
                sb.append(view == null ? " cache view is null" : " adopt cached view");
                sb.toString();
            }
            return view;
        }
        return (View) invokeI.objValue;
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
        this.f8590c = new ConcurrentHashMap<>();
    }
}
