package b.a.r0.i1.b;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f17890e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17891a;

    /* renamed from: b  reason: collision with root package name */
    public int f17892b;

    /* renamed from: c  reason: collision with root package name */
    public int f17893c;

    /* renamed from: d  reason: collision with root package name */
    public int f17894d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-552259388, "Lb/a/r0/i1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-552259388, "Lb/a/r0/i1/b/a;");
                return;
            }
        }
        f17890e = new ArrayList<>(5);
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
            synchronized (f17890e) {
                if (f17890e.size() > 0) {
                    a remove = f17890e.remove(0);
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
            b2.f17894d = i2;
            b2.f17891a = i3;
            b2.f17892b = i4;
            b2.f17893c = i5;
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

    public static a f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j)) == null) {
            if (j == 4294967295L) {
                return null;
            }
            a b2 = b();
            b2.f17891a = ExpandableListView.getPackedPositionGroup(j);
            if (ExpandableListView.getPackedPositionType(j) == 1) {
                b2.f17894d = 1;
                b2.f17892b = ExpandableListView.getPackedPositionChild(j);
            } else {
                b2.f17894d = 2;
            }
            return b2;
        }
        return (a) invokeJ.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17894d == 1 ? ExpandableListView.getPackedPositionForChild(this.f17891a, this.f17892b) : ExpandableListView.getPackedPositionForGroup(this.f17891a) : invokeV.longValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f17890e) {
                if (f17890e.size() < 5) {
                    f17890e.add(this);
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17891a = 0;
            this.f17892b = 0;
            this.f17893c = 0;
            this.f17894d = 0;
        }
    }
}
