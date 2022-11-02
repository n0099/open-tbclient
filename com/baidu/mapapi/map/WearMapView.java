package com.baidu.mapapi.map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes2.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BT_INVIEW = 1;
    public static final String b;
    public static String c;
    public static int d;
    public static int e;
    public static int s;
    public static int t;
    public static int u;
    public static final SparseArray<Integer> x;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public ScreenShape a;
    public MapSurfaceView f;
    public BaiduMap g;
    public ImageView h;
    public Bitmap i;
    public com.baidu.mapsdkplatform.comapi.map.ad j;
    public boolean k;
    public Point l;
    public Point m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    public RelativeLayout n;
    public SwipeDismissView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public boolean v;
    public Context w;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65575, null, z) == null) {
        }
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) {
        }
    }

    public void setMapCustomStyleEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class AnimationTask extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WearMapView a;

        public AnimationTask(WearMapView wearMapView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wearMapView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wearMapView;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = 1;
                this.a.mTimerHandler.sendMessage(message);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ScreenShape {
        public static /* synthetic */ Interceptable $ic;
        public static final ScreenShape RECTANGLE;
        public static final ScreenShape ROUND;
        public static final ScreenShape UNDETECTED;
        public static final /* synthetic */ ScreenShape[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1127404798, "Lcom/baidu/mapapi/map/WearMapView$ScreenShape;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1127404798, "Lcom/baidu/mapapi/map/WearMapView$ScreenShape;");
                    return;
                }
            }
            ROUND = new ScreenShape("ROUND", 0);
            RECTANGLE = new ScreenShape("RECTANGLE", 1);
            ScreenShape screenShape = new ScreenShape("UNDETECTED", 2);
            UNDETECTED = screenShape;
            a = new ScreenShape[]{ROUND, RECTANGLE, screenShape};
        }

        public ScreenShape(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ScreenShape valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ScreenShape) Enum.valueOf(ScreenShape.class, str);
            }
            return (ScreenShape) invokeL.objValue;
        }

        public static ScreenShape[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ScreenShape[]) a.clone();
            }
            return (ScreenShape[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WearMapView a;
        public final WeakReference<Context> b;

        public a(WearMapView wearMapView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wearMapView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wearMapView;
            this.b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || this.b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what != 1 || this.a.j == null) {
                return;
            }
            this.a.a(true);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-809937745, "Lcom/baidu/mapapi/map/WearMapView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-809937745, "Lcom/baidu/mapapi/map/WearMapView;");
                return;
            }
        }
        b = MapView.class.getSimpleName();
        d = 0;
        e = 0;
        s = 0;
        t = 0;
        u = 10;
        SparseArray<Integer> sparseArray = new SparseArray<>();
        x = sparseArray;
        sparseArray.append(3, 2000000);
        x.append(4, 1000000);
        x.append(5, 500000);
        x.append(6, 200000);
        x.append(7, 100000);
        x.append(8, 50000);
        x.append(9, 25000);
        x.append(10, 20000);
        x.append(11, 10000);
        x.append(12, 5000);
        x.append(13, 2000);
        x.append(14, 1000);
        x.append(15, 500);
        x.append(16, 200);
        x.append(17, 100);
        x.append(18, 50);
        x.append(19, 20);
        x.append(20, 10);
        x.append(21, 5);
        x.append(22, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearMapView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) && bundle != null && (baiduMap = this.g) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            Point point = this.l;
            if (point != null) {
                bundle.putParcelable("scalePosition", point);
            }
            Point point2 = this.m;
            if (point2 != null) {
                bundle.putParcelable("zoomPosition", point2);
            }
            bundle.putBoolean("mZoomControlEnabled", this.y);
            bundle.putBoolean("mScaleControlEnabled", this.z);
            bundle.putInt("paddingLeft", this.B);
            bundle.putInt("paddingTop", this.D);
            bundle.putInt("paddingRight", this.C);
            bundle.putInt("paddingBottom", this.E);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, this, str, str2) == null) && (mapSurfaceView = this.f) != null && mapSurfaceView.getBaseMap() != null) {
            if (TextUtils.isEmpty(str)) {
                Log.e(b, "customStyleFilePath is empty or null, please check!");
            } else if (!str.endsWith(".sty")) {
                Log.e(b, "customStyleFile format is incorrect , please check!");
            } else if (!new File(str).exists()) {
                Log.e(b, "customStyleFile does not exist , please check!");
            } else {
                this.f.getBaseMap().b(str, "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baiduMapOptions};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        this.H = false;
        a(context, baiduMapOptions);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) && (layoutParams instanceof MapViewLayoutParams)) {
            super.addView(view2, layoutParams);
        }
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, windowInsets)) == null) {
            if (windowInsets.isRound()) {
                this.a = ScreenShape.ROUND;
            } else {
                this.a = ScreenShape.RECTANGLE;
            }
            return windowInsets;
        }
        return (WindowInsets) invokeLL.objValue;
    }

    private int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) {
            return i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d)));
        }
        return invokeII.intValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.f != null && !this.v) {
            d();
            this.v = true;
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && this.f != null && this.v) {
            e();
            this.v = false;
        }
    }

    private void d() {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65565, this) != null) || (mapSurfaceView = this.f) == null) {
            return;
        }
        mapSurfaceView.onBackground();
    }

    private void e() {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65568, this) != null) || (mapSurfaceView = this.f) == null) {
            return;
        }
        mapSurfaceView.onForeground();
    }

    public final BaiduMap getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaiduMap baiduMap = this.g;
            baiduMap.c = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return x.get((int) this.f.getZoomLevel()).intValue();
        }
        return invokeV.intValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public final void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            removeAllViews();
        }
    }

    public void onExitAmbient() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(1);
        }
    }

    private void a(int i) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65544, this, i) != null) || (mapSurfaceView = this.f) == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                mapSurfaceView.onResume();
                c();
                return;
            }
            return;
        }
        mapSurfaceView.onPause();
        b();
    }

    @Deprecated
    public static void setIconCustom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65573, null, i) == null) {
            e = i;
        }
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65574, null, i) == null) {
            d = i;
        }
    }

    public final void onEnterAmbient(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            a(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, view2) != null) || view2 == this.h) {
            return;
        }
        super.removeView(view2);
    }

    public void setMapCustomStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            a(str, "");
        }
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, onDismissCallback) != null) || (swipeDismissView = this.o) == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    public void setScaleControlPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, point) == null) && point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, screenShape) == null) {
            this.a = screenShape;
        }
    }

    public void setViewAnimitionEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.k = z;
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, point) == null) && point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.m = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            RelativeLayout relativeLayout = this.n;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
            this.z = z;
        }
    }

    public void showZoomControls(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && this.j.a()) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            adVar.setVisibility(i);
            this.y = z;
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        AnimationTask animationTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, baiduMapOptions) == null) {
            a(context);
            setOnApplyWindowInsetsListener(this);
            this.w = context;
            this.mTimerHandler = new a(this, context);
            Timer timer = new Timer();
            this.mTimer = timer;
            if (timer != null && (animationTask = this.mTask) != null) {
                animationTask.cancel();
            }
            AnimationTask animationTask2 = new AnimationTask(this);
            this.mTask = animationTask2;
            this.mTimer.schedule(animationTask2, 5000L);
            com.baidu.mapsdkplatform.comapi.map.j.a();
            BMapManager.init();
            a(context, baiduMapOptions, c);
            this.f.getController().set3DGestureEnable(false);
            this.f.getController().setOverlookGestureEnable(false);
            c(context);
            d(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.h) {
                this.j.setVisibility(4);
            }
            e(context);
            if (baiduMapOptions != null && !baiduMapOptions.i) {
                this.n.setVisibility(4);
            }
            if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
                this.m = point2;
            }
            if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
                this.l = point;
            }
        }
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, context, bundle) != null) || bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.l != null) {
            this.l = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.m != null) {
            this.m = (Point) bundle.getParcelable("zoomPosition");
        }
        this.y = bundle.getBoolean("mZoomControlEnabled");
        this.z = bundle.getBoolean("mScaleControlEnabled");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, context, baiduMapOptions, str) == null) {
            this.f = new MapSurfaceView(context);
            if (baiduMapOptions != null) {
                this.g = new BaiduMap(context, this.f, baiduMapOptions.a());
            } else {
                this.g = new BaiduMap(context, this.f, (com.baidu.mapsdkplatform.comapi.map.v) null);
            }
            addView(this.f);
            this.f.getBaseMap().a(new ah(this));
        }
    }

    private void a(View view2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            int i = layoutParams.width;
            if (i > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            int i2 = layoutParams.height;
            if (i2 > 0) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, context) == null) {
            this.o = new SwipeDismissView(context, this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), t);
            this.o.setBackgroundColor(Color.argb(0, 0, 0, 0));
            this.o.setLayoutParams(layoutParams);
            addView(this.o);
        }
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, context) == null) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = new com.baidu.mapsdkplatform.comapi.map.ad(context, true);
            this.j = adVar;
            if (!adVar.a()) {
                return;
            }
            this.j.b(new ai(this));
            this.j.a(new aj(this));
            addView(this.j);
        }
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, str) == null) {
            if (str != null && str.length() != 0) {
                if (new File(str).exists()) {
                    c = str;
                    return;
                }
                throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
            }
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, this, view2, z) == null) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f));
                animatorSet.addListener(new ak(this, view2));
                animatorSet.setDuration(IMLikeRequest.TIME_INTERVAL);
                animatorSet.start();
                return;
            }
            view2.setVisibility(0);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f));
            animatorSet2.setDuration(IMLikeRequest.TIME_INTERVAL);
            animatorSet2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, str, mapCustomStyleOptions) == null) {
            if (!TextUtils.isEmpty(str)) {
                a(str, "");
                setMapCustomStyleEnable(true);
                return;
            }
            String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
            if (!TextUtils.isEmpty(localCustomStyleFilePath)) {
                a(localCustomStyleFilePath, "");
                setMapCustomStyleEnable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65554, this, z) != null) || !this.k) {
            return;
        }
        a(this.j, z);
    }

    private void c(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, context) == null) {
            int densityDpi = SysOSUtil.getDensityDpi();
            if (densityDpi < 180) {
                str = "logo_l.png";
            } else {
                str = "logo_h.png";
            }
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
            if (densityDpi > 480) {
                Matrix matrix = new Matrix();
                matrix.postScale(2.0f, 2.0f);
                this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
            } else if (densityDpi > 320 && densityDpi <= 480) {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
            } else {
                this.i = a2;
            }
            if (this.i != null) {
                ImageView imageView = new ImageView(context);
                this.h = imageView;
                imageView.setImageBitmap(this.i);
                addView(this.h);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        AnimationTask animationTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    if (timer != null && (animationTask = this.mTask) != null) {
                        animationTask.cancel();
                    }
                    AnimationTask animationTask2 = new AnimationTask(this);
                    this.mTask = animationTask2;
                    this.mTimer.schedule(animationTask2, 5000L);
                }
            } else if (this.j.getVisibility() == 0) {
                Timer timer2 = this.mTimer;
                if (timer2 != null) {
                    if (this.mTask != null) {
                        timer2.cancel();
                        this.mTask.cancel();
                    }
                    this.mTimer = null;
                    this.mTask = null;
                }
            } else if (this.j.getVisibility() == 4) {
                if (this.mTimer != null) {
                    AnimationTask animationTask3 = this.mTask;
                    if (animationTask3 != null) {
                        animationTask3.cancel();
                    }
                    this.mTimer.cancel();
                    this.mTask = null;
                    this.mTimer = null;
                }
                a(false);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    private void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, context) == null) {
            this.n = new RelativeLayout(context);
            this.n.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.p = new TextView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            this.p.setTextColor(Color.parseColor("#FFFFFF"));
            this.p.setTextSize(2, 11.0f);
            TextView textView = this.p;
            textView.setTypeface(textView.getTypeface(), 1);
            this.p.setLayoutParams(layoutParams);
            this.p.setId(Integer.MAX_VALUE);
            this.n.addView(this.p);
            this.q = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.addRule(14);
            this.q.setTextColor(Color.parseColor("#000000"));
            this.q.setTextSize(2, 11.0f);
            this.q.setLayoutParams(layoutParams2);
            this.n.addView(this.q);
            this.r = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.p.getId());
            this.r.setLayoutParams(layoutParams3);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
            byte[] ninePatchChunk = a2.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            this.r.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
            this.n.addView(this.r);
            addView(this.n);
        }
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.w != null) {
                this.f.unInit();
            }
            Bitmap bitmap = this.i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.i.recycle();
                this.i = null;
            }
            this.j.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.j.b();
            AnimationTask animationTask = this.mTask;
            if (animationTask != null) {
                animationTask.cancel();
            }
            this.w = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        Point point;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            a(this.h);
            float f2 = 1.0f;
            if (((getWidth() - this.B) - this.C) - this.h.getMeasuredWidth() > 0 && ((getHeight() - this.D) - this.E) - this.h.getMeasuredHeight() > 0) {
                float width = ((getWidth() - this.B) - this.C) / getWidth();
                f2 = ((getHeight() - this.D) - this.E) / getHeight();
                f = width;
            } else {
                this.B = 0;
                this.C = 0;
                this.E = 0;
                this.D = 0;
                f = 1.0f;
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                MapSurfaceView mapSurfaceView = this.f;
                if (childAt == mapSurfaceView) {
                    mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                } else if (childAt == this.h) {
                    int i11 = (int) (this.E + (12.0f * f2));
                    if (this.a == ScreenShape.ROUND) {
                        a(this.j);
                        int i12 = s / 2;
                        i8 = a(i12, this.j.getMeasuredWidth() / 2);
                        i9 = ((s / 2) - a(i12, i12 - i8)) + u;
                    } else {
                        i8 = 0;
                        i9 = 0;
                    }
                    int i13 = (t - i8) - i11;
                    int i14 = s - i9;
                    this.h.layout(i14 - this.h.getMeasuredWidth(), i13 - this.h.getMeasuredHeight(), i14, i13);
                } else {
                    com.baidu.mapsdkplatform.comapi.map.ad adVar = this.j;
                    if (childAt == adVar) {
                        if (adVar.a()) {
                            a(this.j);
                            Point point2 = this.m;
                            if (point2 == null) {
                                if (this.a == ScreenShape.ROUND) {
                                    i7 = a(t / 2, this.j.getMeasuredWidth() / 2);
                                } else {
                                    i7 = 0;
                                }
                                int i15 = (int) ((12.0f * f2) + this.D + i7);
                                int measuredWidth = (s - this.j.getMeasuredWidth()) / 2;
                                this.j.layout(measuredWidth, i15, this.j.getMeasuredWidth() + measuredWidth, this.j.getMeasuredHeight() + i15);
                            } else {
                                com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.j;
                                int i16 = point2.x;
                                adVar2.layout(i16, point2.y, adVar2.getMeasuredWidth() + i16, this.m.y + this.j.getMeasuredHeight());
                            }
                        }
                    } else if (childAt == this.n) {
                        if (this.a == ScreenShape.ROUND) {
                            a(adVar);
                            int i17 = s / 2;
                            i5 = a(i17, this.j.getMeasuredWidth() / 2);
                            i6 = ((s / 2) - a(i17, i17 - i5)) + u;
                        } else {
                            i5 = 0;
                            i6 = 0;
                        }
                        a(this.n);
                        Point point3 = this.l;
                        if (point3 == null) {
                            this.G = this.n.getMeasuredWidth();
                            this.F = this.n.getMeasuredHeight();
                            int i18 = (int) (this.B + (5.0f * f) + i6);
                            int i19 = (t - ((int) (this.E + (12.0f * f2)))) - i5;
                            this.n.layout(i18, i19 - this.n.getMeasuredHeight(), this.G + i18, i19);
                        } else {
                            RelativeLayout relativeLayout = this.n;
                            int i20 = point3.x;
                            relativeLayout.layout(i20, point3.y, relativeLayout.getMeasuredWidth() + i20, this.l.y + this.n.getMeasuredHeight());
                        }
                    } else {
                        View view2 = this.o;
                        if (childAt == view2) {
                            a(view2);
                            this.o.layout(0, 0, this.o.getMeasuredWidth(), t);
                        } else {
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            if (layoutParams instanceof MapViewLayoutParams) {
                                MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                    point = mapViewLayoutParams.b;
                                } else {
                                    GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.a);
                                    if (this.f.getBaseMap() != null) {
                                        point = this.f.getBaseMap().a(ll2mc);
                                    } else {
                                        point = new Point();
                                    }
                                }
                                a(childAt);
                                int measuredWidth2 = childAt.getMeasuredWidth();
                                int measuredHeight = childAt.getMeasuredHeight();
                                float f3 = mapViewLayoutParams.d;
                                float f4 = mapViewLayoutParams.e;
                                int i21 = (int) (point.x - (f3 * measuredWidth2));
                                int i22 = ((int) (point.y - (f4 * measuredHeight))) + mapViewLayoutParams.f;
                                childAt.layout(i21, i22, measuredWidth2 + i21, measuredHeight + i22);
                            }
                        }
                    }
                }
            }
        }
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, mapCustomStyleOptions, customMapStyleCallBack) != null) || mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.w, customMapStyleId, new ag(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048596, this, i, i2, i3, i4) == null) {
            this.B = i;
            this.D = i2;
            this.C = i3;
            this.E = i4;
        }
    }
}
