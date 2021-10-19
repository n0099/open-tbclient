package c.a.r0.x1.p.j;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28296e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28297f;

    /* renamed from: g  reason: collision with root package name */
    public String f28298g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Class, IPlayerContext> f28299h;

    /* renamed from: i  reason: collision with root package name */
    public IVideoPlayerCallback f28300i;

    /* renamed from: j  reason: collision with root package name */
    public List<LivePlayer.OnInfoListener> f28301j;
    public List<LivePlayer.OnProgressChangeListener> k;
    public String l;
    public ViewGroup m;
    public OrientationHelper n;
    public boolean o;
    public BaseKernelLayer p;
    public Button q;

    /* renamed from: c.a.r0.x1.p.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1330a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f28302a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28303b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28304c;

        /* renamed from: d  reason: collision with root package name */
        public long f28305d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28306e;

        public C1330a(a aVar, Activity activity) {
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
            this.f28306e = aVar;
            this.f28305d = 0L;
            this.f28302a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || !this.f28306e.o || a.r || OrientationHelper.isSystemOrientationLocked(this.f28302a)) {
                return;
            }
            if (!this.f28306e.d()) {
                this.f28303b = false;
                if (OrientationHelper.isPortrait(i2)) {
                    this.f28304c = true;
                }
                if (!this.f28304c || System.currentTimeMillis() - this.f28305d <= 1000) {
                    return;
                }
                if (OrientationHelper.isReverseLandscape(i2)) {
                    this.f28303b = true;
                    BdActivityUtils.requestLandscape(this.f28302a, true);
                    return;
                } else if (OrientationHelper.isLandscape(i2)) {
                    this.f28303b = true;
                    BdActivityUtils.requestLandscape(this.f28302a, false);
                    return;
                } else {
                    return;
                }
            }
            this.f28304c = false;
            if (OrientationHelper.isReverseLandscape(i2)) {
                this.f28303b = true;
                BdActivityUtils.requestLandscape(this.f28302a, true);
            } else if (OrientationHelper.isLandscape(i2)) {
                this.f28303b = true;
                BdActivityUtils.requestLandscape(this.f28302a, false);
            } else if (OrientationHelper.isPortrait(i2) && this.f28303b && System.currentTimeMillis() - this.f28305d > 1000) {
                this.f28305d = System.currentTimeMillis();
                this.f28303b = false;
                BdActivityUtils.requestPortrait(this.f28302a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(403193257, "Lc/a/r0/x1/p/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(403193257, "Lc/a/r0/x1/p/j/a;");
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
        this.f28296e = false;
        this.f28297f = false;
        this.f28298g = "lp_bdrtc";
        this.f28299h = new HashMap<>();
        this.f28301j = new ArrayList();
        this.k = new ArrayList();
        this.l = PlayerConstant.HALF_MODE;
        this.o = true;
        this.p = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            boolean z = this.f28297f;
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) || onInfoListener == null || this.f28301j.contains(onInfoListener)) {
            return;
        }
        this.f28301j.add(onInfoListener);
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) || onProgressChangeListener == null || this.k.contains(onProgressChangeListener)) {
            return;
        }
        this.k.add(onProgressChangeListener);
    }

    public void attachKernelLayer(BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseKernelLayer) == null) {
            a("attachKernelLayer " + baseKernelLayer);
            this.p = baseKernelLayer;
            detachKernelLayer();
        }
    }

    public void attachToContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            this.m = viewGroup;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f28297f = i2 >= 3;
            this.f28296e = i2 >= 2;
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            a("initHelper");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.n = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.n.enableSensor();
                this.n.setListener(new C1330a(this, (Activity) context));
            }
        }
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.l, str) : invokeL.booleanValue;
    }

    @PublicMethod
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.equals(this.l, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a("detachKernelLayer ");
            getPlayerKernelLayer();
            Button button = this.q;
            if (button != null) {
                ((ViewGroup) button.getParent()).removeView(this.q);
            }
            return this.p;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (orientationHelper = this.n) == null) {
            return;
        }
        this.o = false;
        orientationHelper.disable();
    }

    public void e(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, obj) == null) || this.f28301j == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f28301j.size(); i4++) {
            this.f28301j.get(i4).onInfo(i2, i3, obj);
        }
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (orientationHelper = this.n) != null && orientationHelper.canDetectOrientation()) {
            this.o = this.n.enableSensor();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            boolean z = this.f28296e;
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.f28299h.get(cls);
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
            if (this.p == null && this.m != null) {
                this.q = new Button(this.m.getContext());
                this.p = new BaseKernelLayer("NormalVideoKernel");
            }
            return this.p;
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
            ViewGroup viewGroup = this.m;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return;
            }
            VideoSystemHelper.setKeepScreenOnOff((Activity) this.m.getContext(), z);
        }
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? TextUtils.equals(this.l, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.f28299h.put(cls, iPlayerContext);
        }
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (orientationHelper = this.n) == null) {
            return;
        }
        orientationHelper.disable();
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onInfoListener) == null) || onInfoListener == null) {
            return;
        }
        this.f28301j.remove(onInfoListener);
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onProgressChangeListener) == null) || onProgressChangeListener == null) {
            return;
        }
        this.k.remove(onProgressChangeListener);
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            a("setMode mode= " + str);
            this.l = str;
        }
    }

    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            r = z;
            if (z) {
                return;
            }
            enableOrientationEventHelper();
        }
    }

    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVideoPlayerCallback) == null) {
            this.f28300i = iVideoPlayerCallback;
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.m != null && d() && (this.m.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.m.getContext());
        }
    }
}
