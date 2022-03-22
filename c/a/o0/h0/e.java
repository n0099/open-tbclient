package c.a.o0.h0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static e f10304g;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f10305b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, View> f10306c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentTabWidget f10307d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10308e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10309f;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Context context);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onChangeSkinType(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(852189845, "Lc/a/o0/h0/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(852189845, "Lc/a/o0/h0/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10306c = new HashMap<>();
        this.f10308e = false;
        this.f10309f = false;
        this.f10308e = UbsABTestHelper.isPreShowPersonViewA();
    }

    public static e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10304g == null) {
                synchronized (e.class) {
                    if (f10304g == null) {
                        f10304g = new e();
                    }
                }
            }
            return f10304g;
        }
        return (e) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10308e && SpeedStats.getInstance().isStartAppFromLauncher() : invokeV.booleanValue;
    }

    public FragmentTabWidget b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.f10307d == null) {
                this.f10307d = new FragmentTabWidget(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.height = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                layoutParams.gravity = 80;
                this.f10307d.setLayoutParams(layoutParams);
                this.f10307d.setClipChildren(false);
                this.f10307d.setClipToPadding(false);
                this.f10307d.setOrientation(0);
                this.f10307d.setShouldDrawIndicatorLine(false);
                this.f10307d.setShouldDrawTopLine(false);
                this.f10307d.setBackGroundStyle(0);
            }
            FragmentTabWidget fragmentTabWidget = this.f10307d;
            if (fragmentTabWidget != null && (fragmentTabWidget.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f10307d.getParent()).removeView(this.f10307d);
            }
            return this.f10307d;
        }
        return (FragmentTabWidget) invokeL.objValue;
    }

    public View c(Context context) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f10305b == null && (runTask = MessageManager.getInstance().runTask(2921672, View.class, context)) != null) {
                this.f10305b = (View) runTask.getData();
            }
            View view = this.f10305b;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f10305b.getParent()).removeView(this.f10305b);
            }
            return this.f10305b;
        }
        return (View) invokeL.objValue;
    }

    public View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            View view = this.f10306c.get(Integer.valueOf(i));
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f10306c.remove(Integer.valueOf(i));
            return view;
        }
        return (View) invokeI.objValue;
    }

    public View f(Context context) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.a == null && (runTask = MessageManager.getInstance().runTask(2921671, View.class, context)) != null) {
                this.a = (View) runTask.getData();
            }
            View view = this.a;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            return this.a;
        }
        return (View) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f10309f : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.f10309f) {
            View view = this.a;
            if (view != null && (view instanceof b)) {
                ((b) view).onChangeSkinType(i);
            }
            View view2 = this.f10305b;
            if (view2 != null && (view2 instanceof b)) {
                ((b) view2).onChangeSkinType(i);
            }
            FragmentTabWidget fragmentTabWidget = this.f10307d;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.i(i);
                SkinManager.setBackgroundColor(this.f10307d, R.color.common_color_10274);
                ViewGroup.LayoutParams layoutParams = this.f10307d.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                this.f10307d.setLayoutParams(layoutParams);
                this.f10307d.h(false, R.color.CAM_X0207);
                if (this.f10306c.isEmpty()) {
                    return;
                }
                for (Map.Entry<Integer, View> entry : this.f10306c.entrySet()) {
                    if (entry.getValue() != null && (entry.getValue() instanceof MaintabBottomIndicator)) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) entry.getValue();
                        maintabBottomIndicator.e(i);
                        maintabBottomIndicator.r(false);
                        maintabBottomIndicator.setSelected(maintabBottomIndicator.isSelected());
                    }
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a = null;
            this.f10305b = null;
            this.f10306c.clear();
            this.f10307d = null;
            this.f10308e = false;
        }
    }

    public void j(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view) == null) {
            this.f10306c.put(Integer.valueOf(i), view);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f10309f = z;
        }
    }
}
