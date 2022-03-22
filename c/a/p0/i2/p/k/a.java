package c.a.p0.i2.p.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15523b;

    /* renamed from: c  reason: collision with root package name */
    public String f15524c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Class, IPlayerContext> f15525d;

    /* renamed from: e  reason: collision with root package name */
    public IVideoPlayerCallback f15526e;

    /* renamed from: f  reason: collision with root package name */
    public List<LivePlayer.OnInfoListener> f15527f;

    /* renamed from: g  reason: collision with root package name */
    public List<LivePlayer.OnProgressChangeListener> f15528g;

    /* renamed from: h  reason: collision with root package name */
    public String f15529h;
    public ViewGroup i;
    public OrientationHelper j;
    public boolean k;
    public BaseKernelLayer l;
    public Button m;

    /* renamed from: c.a.p0.i2.p.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1163a implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15530b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15531c;

        /* renamed from: d  reason: collision with root package name */
        public long f15532d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15533e;

        public C1163a(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15533e = aVar;
            this.f15532d = 0L;
            this.a = activity;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || !this.f15533e.k || a.n || OrientationHelper.isSystemOrientationLocked(this.a)) {
                return;
            }
            if (!this.f15533e.d()) {
                this.f15530b = false;
                if (OrientationHelper.isPortrait(i)) {
                    this.f15531c = true;
                }
                if (!this.f15531c || System.currentTimeMillis() - this.f15532d <= 1000) {
                    return;
                }
                if (OrientationHelper.isReverseLandscape(i)) {
                    this.f15530b = true;
                    BdActivityUtils.requestLandscape(this.a, true);
                    return;
                } else if (OrientationHelper.isLandscape(i)) {
                    this.f15530b = true;
                    BdActivityUtils.requestLandscape(this.a, false);
                    return;
                } else {
                    return;
                }
            }
            this.f15531c = false;
            if (OrientationHelper.isReverseLandscape(i)) {
                this.f15530b = true;
                BdActivityUtils.requestLandscape(this.a, true);
            } else if (OrientationHelper.isLandscape(i)) {
                this.f15530b = true;
                BdActivityUtils.requestLandscape(this.a, false);
            } else if (OrientationHelper.isPortrait(i) && this.f15530b && System.currentTimeMillis() - this.f15532d > 1000) {
                this.f15532d = System.currentTimeMillis();
                this.f15530b = false;
                BdActivityUtils.requestPortrait(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1065086182, "Lc/a/p0/i2/p/k/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1065086182, "Lc/a/p0/i2/p/k/a;");
        }
    }

    public a() {
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
        this.a = false;
        this.f15523b = false;
        this.f15524c = "lp_bdrtc";
        this.f15525d = new HashMap<>();
        this.f15527f = new ArrayList();
        this.f15528g = new ArrayList();
        this.f15529h = PlayerConstant.HALF_MODE;
        this.k = true;
        this.l = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f15523b) {
            Log.d("lp_bdrtc", str);
        }
    }

    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onInfoListener) == null) || onInfoListener == null || this.f15527f.contains(onInfoListener)) {
            return;
        }
        this.f15527f.add(onInfoListener);
    }

    public void addProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onProgressChangeListener) == null) || onProgressChangeListener == null || this.f15528g.contains(onProgressChangeListener)) {
            return;
        }
        this.f15528g.add(onProgressChangeListener);
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
            this.i = viewGroup;
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f15523b = i >= 3;
            this.a = i >= 2;
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            a("initHelper");
            OrientationHelper orientationHelper = new OrientationHelper(context, 3);
            this.j = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.j.enableSensor();
                this.j.setListener(new C1163a(this, (Activity) context));
            }
        }
    }

    public boolean checkMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.f15529h, str) : invokeL.booleanValue;
    }

    @PublicMethod
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextUtils.equals(this.f15529h, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (orientationHelper = this.j) == null) {
            return;
        }
        this.k = false;
        orientationHelper.disable();
    }

    public void e(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, obj) == null) || this.f15527f == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f15527f.size(); i3++) {
            this.f15527f.get(i3).onInfo(i, i2, obj);
        }
    }

    public void enableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (orientationHelper = this.j) != null && orientationHelper.canDetectOrientation()) {
            this.k = this.j.enableSensor();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && this.a) {
            Log.v(this.f15524c, str);
        }
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f15529h : (String) invokeV.objValue;
    }

    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cls)) == null) {
            a("getPlayerContext " + cls);
            T t = (T) this.f15525d.get(cls);
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
            if (this.l == null && this.i != null) {
                this.m = new Button(this.i.getContext());
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
            ViewGroup viewGroup = this.i;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return;
            }
            VideoSystemHelper.setKeepScreenOnOff((Activity) this.i.getContext(), z);
        }
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? TextUtils.equals(this.f15529h, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, cls, iPlayerContext) == null) {
            a("registerContext " + iPlayerContext);
            this.f15525d.put(cls, iPlayerContext);
        }
    }

    public void release() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (orientationHelper = this.j) == null) {
            return;
        }
        orientationHelper.disable();
    }

    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onInfoListener) == null) || onInfoListener == null) {
            return;
        }
        this.f15527f.remove(onInfoListener);
    }

    public void removeProgressListener(LivePlayer.OnProgressChangeListener onProgressChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onProgressChangeListener) == null) || onProgressChangeListener == null) {
            return;
        }
        this.f15528g.remove(onProgressChangeListener);
    }

    public void setMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            a("setMode mode= " + str);
            this.f15529h = str;
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
            this.f15526e = iVideoPlayerCallback;
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.i != null && d() && (this.i.getContext() instanceof Activity)) {
            BdActivityUtils.requestPortrait((Activity) this.i.getContext());
        }
    }
}
