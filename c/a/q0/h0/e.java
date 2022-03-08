package c.a.q0.h0;

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
    public static e f12608g;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f12609b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, View> f12610c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentTabWidget f12611d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12612e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12613f;

    /* loaded from: classes2.dex */
    public interface a {
        void initAndLoadForPreShow(Context context);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onChangeSkinType(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(42843219, "Lc/a/q0/h0/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(42843219, "Lc/a/q0/h0/e;");
        }
    }

    public e() {
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
        this.f12610c = new HashMap<>();
        this.f12612e = false;
        this.f12613f = false;
        this.f12612e = UbsABTestHelper.isPreShowPersonViewA();
    }

    public static e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f12608g == null) {
                synchronized (e.class) {
                    if (f12608g == null) {
                        f12608g = new e();
                    }
                }
            }
            return f12608g;
        }
        return (e) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12612e && SpeedStats.getInstance().isStartAppFromLauncher() : invokeV.booleanValue;
    }

    public FragmentTabWidget b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.f12611d == null) {
                this.f12611d = new FragmentTabWidget(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.height = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                layoutParams.gravity = 80;
                this.f12611d.setLayoutParams(layoutParams);
                this.f12611d.setClipChildren(false);
                this.f12611d.setClipToPadding(false);
                this.f12611d.setOrientation(0);
                this.f12611d.setShouldDrawIndicatorLine(false);
                this.f12611d.setShouldDrawTopLine(false);
                this.f12611d.setBackGroundStyle(0);
            }
            FragmentTabWidget fragmentTabWidget = this.f12611d;
            if (fragmentTabWidget != null && (fragmentTabWidget.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f12611d.getParent()).removeView(this.f12611d);
            }
            return this.f12611d;
        }
        return (FragmentTabWidget) invokeL.objValue;
    }

    public View c(Context context) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f12609b == null && (runTask = MessageManager.getInstance().runTask(2921672, View.class, context)) != null) {
                this.f12609b = (View) runTask.getData();
            }
            View view = this.f12609b;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f12609b.getParent()).removeView(this.f12609b);
            }
            return this.f12609b;
        }
        return (View) invokeL.objValue;
    }

    public View d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = this.f12610c.get(Integer.valueOf(i2));
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12613f : invokeV.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i2) == null) && this.f12613f) {
            View view = this.a;
            if (view != null && (view instanceof b)) {
                ((b) view).onChangeSkinType(i2);
            }
            View view2 = this.f12609b;
            if (view2 != null && (view2 instanceof b)) {
                ((b) view2).onChangeSkinType(i2);
            }
            FragmentTabWidget fragmentTabWidget = this.f12611d;
            if (fragmentTabWidget != null) {
                fragmentTabWidget.onChangeSkinType(i2);
                SkinManager.setBackgroundColor(this.f12611d, R.color.common_color_10274);
                ViewGroup.LayoutParams layoutParams = this.f12611d.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                this.f12611d.setLayoutParams(layoutParams);
                this.f12611d.makeWidgetDarkSkin(false, R.color.CAM_X0207);
                if (this.f12610c.isEmpty()) {
                    return;
                }
                for (Map.Entry<Integer, View> entry : this.f12610c.entrySet()) {
                    if (entry.getValue() != null && (entry.getValue() instanceof MaintabBottomIndicator)) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) entry.getValue();
                        maintabBottomIndicator.onChangeSkin(i2);
                        maintabBottomIndicator.makeDarkSkin(false);
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
            this.f12609b = null;
            this.f12610c.clear();
            this.f12611d = null;
            this.f12612e = false;
        }
    }

    public void j(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view) == null) {
            this.f12610c.put(Integer.valueOf(i2), view);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f12613f = z;
        }
    }
}
