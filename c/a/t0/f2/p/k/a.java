package c.a.t0.f2.p.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17495b;

    /* renamed from: c  reason: collision with root package name */
    public String f17496c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Class, IPlayerContext> f17497d;

    /* renamed from: e  reason: collision with root package name */
    public IVideoPlayerCallback f17498e;

    /* renamed from: f  reason: collision with root package name */
    public List<LivePlayer.OnInfoListener> f17499f;

    /* renamed from: g  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f17500g;

    /* renamed from: h  reason: collision with root package name */
    public String f17501h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f17502i;

    /* renamed from: j  reason: collision with root package name */
    public OrientationHelper f17503j;
    public boolean k;
    public BaseKernelLayer l;
    public Button m;

    /* renamed from: c.a.t0.f2.p.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1104a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17504b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17505c;

        /* renamed from: d  reason: collision with root package name */
        public long f17506d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17507e;

        public C1104a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17507e = aVar;
            this.f17506d = 0L;
            this.a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || !this.f17507e.k || a.n || OrientationHelper.isSystemOrientationLocked(this.a)) {
                return;
            }
            if (!this.f17507e.d()) {
                this.f17504b = false;
                if (OrientationHelper.isPortrait(i2)) {
                    this.f17505c = true;
                }
                if (!this.f17505c || System.currentTimeMillis() - this.f17506d <= 1000) {
                    return;
                }
                if (OrientationHelper.isReverseLandscape(i2)) {
                    this.f17504b = true;
                    BdActivityUtils.requestLandscape(this.a, true);
                    return;
                } else if (OrientationHelper.isLandscape(i2)) {
                    this.f17504b = true;
                    BdActivityUtils.requestLandscape(this.a, false);
                    return;
                } else {
                    return;
                }
            }
            this.f17505c = false;
            if (OrientationHelper.isReverseLandscape(i2)) {
                this.f17504b = true;
                BdActivityUtils.requestLandscape(this.a, true);
            } else if (OrientationHelper.isLandscape(i2)) {
                this.f17504b = true;
                BdActivityUtils.requestLandscape(this.a, false);
            } else if (OrientationHelper.isPortrait(i2) && this.f17504b && System.currentTimeMillis() - this.f17506d > 1000) {
                this.f17506d = System.currentTimeMillis();
                this.f17504b = false;
                BdActivityUtils.requestPortrait(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(578640787, "Lc/a/t0/f2/p/k/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(578640787, "Lc/a/t0/f2/p/k/a;");
        }
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
                return;
            }
        }
        this.a = false;
        this.f17495b = false;
        this.f17496c = "lp_bdrtc";
        this.f17497d = new HashMap<>();
        this.f17499f = new ArrayList();
        this.f17500g = new ArrayList();
        this.f17501h = PlayerConstant.HALF_MODE;
        this.k = true;
        this.l = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = this.f17495b;
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) || onInfoListener == null || this.f17499f.contains(onInfoListener)) {
            return;
        }
        this.f17499f.add(onInfoListener);
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) || onProgressChangeListener == null || this.f17500g.contains(onProgressChangeListener)) {
            return;
        }
        this.f17500g.add(onProgressChangeListener);
    }

    public void attachKernelLayer(BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseKernelLayer) == null) {
            a("attachKernelLayer " + baseKernelLayer);
            this.l = baseKernelLayer;
            detachKernelLayer();
        }
    }

    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            this.f17502i = viewGroup;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f17495b = i2 >= 3;
            this.a = i2 >= 2;
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            a("initHelper");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.f17503j = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.f17503j.enableSensor();
                this.f17503j.setListener(new C1104a(this, (Activity) context));
            }
        }
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.f17501h, str) : invokeL.booleanValue;
    }

    @PublicMethod
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.equals(this.f17501h, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a("detachKernelLayer ");
            getPlayerKernelLayer();
            Button button = this.m;
            if (button != null) {
                ((ViewGroup) button.getParent()).removeView(this.m);
            }
            return this.l;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (orientationHelper = this.f17503j) == null) {
            return;
        }
        this.k = false;
        orientationHelper.disable();
    }

    public void e(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, obj) == null) || this.f17499f == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f17499f.size(); i4++) {
            this.f17499f.get(i4).onInfo(i2, i3, obj);
        }
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (orientationHelper = this.f17503j) != null && orientationHelper.canDetectOrientation()) {
            this.k = this.f17503j.enableSensor();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            boolean z = this.a;
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f17501h : (String) invokeV.objValue;
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.f17497d.get(cls);
            if (t != null) {
                return t;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            a("getPlayerKernelLayer ");
            if (this.l == null && this.f17502i != null) {
                this.m = new Button(this.f17502i.getContext());
                this.l = new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER);
            }
            return this.l;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                enableOrientationEventHelper();
            } else {
                disableOrientationEventHelper();
            }
            ViewGroup viewGroup = this.f17502i;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return;
            }
            VideoSystemHelper.setKeepScreenOnOff((Activity) this.f17502i.getContext(), z);
        }
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? TextUtils.equals(this.f17501h, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.f17497d.put(cls, iPlayerContext);
        }
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (orientationHelper = this.f17503j) == null) {
            return;
        }
        orientationHelper.disable();
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onInfoListener) == null) || onInfoListener == null) {
            return;
        }
        this.f17499f.remove(onInfoListener);
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onProgressChangeListener) == null) || onProgressChangeListener == null) {
            return;
        }
        this.f17500g.remove(onProgressChangeListener);
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            a("setMode mode= " + str);
            this.f17501h = str;
        }
    }

    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            n = z;
            if (z) {
                return;
            }
            enableOrientationEventHelper();
        }
    }

    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVideoPlayerCallback) == null) {
            this.f17498e = iVideoPlayerCallback;
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.f17502i != null && d() && (this.f17502i.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.f17502i.getContext());
        }
    }
}
