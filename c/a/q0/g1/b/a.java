package c.a.q0.g1.b;

import android.widget.ExpandableListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f18325e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f18326a;

    /* renamed from: b  reason: collision with root package name */
    public int f18327b;

    /* renamed from: c  reason: collision with root package name */
    public int f18328c;

    /* renamed from: d  reason: collision with root package name */
    public int f18329d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658655426, "Lc/a/q0/g1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1658655426, "Lc/a/q0/g1/b/a;");
                return;
            }
        }
        f18325e = new ArrayList<>(5);
    }

    public a() {
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

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f18325e) {
                if (f18325e.size() > 0) {
                    a remove = f18325e.remove(0);
                    remove.h();
                    return remove;
                }
                return new a();
            }
        }
        return (a) invokeV.objValue;
    }

    public static a c(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i2, i3, i4, i5)) == null) {
            a b2 = b();
            b2.f18329d = i2;
            b2.f18326a = i3;
            b2.f18327b = i4;
            b2.f18328c = i5;
            return b2;
        }
        return (a) invokeIIII.objValue;
    }

    public static a d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? c(1, i2, i3, 0) : (a) invokeII.objValue;
    }

    public static a e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? c(2, i2, 0, 0) : (a) invokeI.objValue;
    }

    public static a f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j2)) == null) {
            if (j2 == 4294967295L) {
                return null;
            }
            a b2 = b();
            b2.f18326a = ExpandableListView.getPackedPositionGroup(j2);
            if (ExpandableListView.getPackedPositionType(j2) == 1) {
                b2.f18329d = 1;
                b2.f18327b = ExpandableListView.getPackedPositionChild(j2);
            } else {
                b2.f18329d = 2;
            }
            return b2;
        }
        return (a) invokeJ.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18329d == 1 ? ExpandableListView.getPackedPositionForChild(this.f18326a, this.f18327b) : ExpandableListView.getPackedPositionForGroup(this.f18326a) : invokeV.longValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f18325e) {
                if (f18325e.size() < 5) {
                    f18325e.add(this);
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18326a = 0;
            this.f18327b = 0;
            this.f18328c = 0;
            this.f18329d = 0;
        }
    }
}
