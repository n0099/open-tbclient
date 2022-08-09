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
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
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
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.util.CustomMapStyleLoader;
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
    public com.baidu.mapsdkplatform.comapi.map.l B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public ScreenShape a;
    public com.baidu.mapsdkplatform.comapi.map.j f;
    public BaiduMap g;
    public ImageView h;
    public Bitmap i;
    public ak j;
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

    /* loaded from: classes2.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScreenShape) Enum.valueOf(ScreenShape.class, str) : (ScreenShape) invokeL.objValue;
        }

        public static ScreenShape[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScreenShape[]) a.clone() : (ScreenShape[]) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && this.a.j != null) {
                this.a.a(true);
            }
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
        a(context, (BaiduMapOptions) null);
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
        a(context, (BaiduMapOptions) null);
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
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) ? i - ((int) Math.sqrt(Math.pow(i, 2.0d) - Math.pow(i2, 2.0d))) : invokeII.intValue;
    }

    private void a(int i) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, this, i) == null) || (jVar = this.f) == null) {
            return;
        }
        if (i == 0) {
            jVar.onPause();
            b();
        } else if (i != 1) {
        } else {
            jVar.onResume();
            c();
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            s = point.x;
            t = point.y;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        AnimationTask animationTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, context, baiduMapOptions) == null) {
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
            com.baidu.mapsdkplatform.comapi.map.i.a();
            BMapManager.init();
            a(context, baiduMapOptions, d == 0 ? c : CustomMapStyleLoader.getCustomStyleFilePath());
            this.g = new BaiduMap(this.f);
            this.f.a().t(false);
            this.f.a().s(false);
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
            if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
                return;
            }
            this.l = point;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, this, context, baiduMapOptions, str) == null) {
            if (baiduMapOptions == null) {
                this.f = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, e);
            } else {
                this.f = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, e);
            }
            addView(this.f);
            this.B = new x(this);
            this.f.a().a(this.B);
        }
    }

    private void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            int i = layoutParams.width;
            int makeMeasureSpec = i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
            int i2 = layoutParams.height;
            view2.measure(makeMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    private void a(View view2, boolean z) {
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, view2, z) == null) {
            if (z) {
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f));
                animatorSet.addListener(new aa(this, view2));
            } else {
                view2.setVisibility(0);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view2, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f));
            }
            animatorSet.setDuration(IMLikeRequest.TIME_INTERVAL);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65552, this, z) == null) && this.k) {
            a(this.j, z);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.f == null || this.v) {
            return;
        }
        d();
        this.v = true;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            this.o = new SwipeDismissView(context, this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), t);
            this.o.setBackgroundColor(Color.argb(0, 0, 0, 0));
            this.o.setLayoutParams(layoutParams);
            addView(this.o);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.f != null && this.v) {
            e();
            this.v = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Context context) {
        Matrix matrix;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65558, this, context) != null) {
            return;
        }
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            matrix = new Matrix();
            f = 2.0f;
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.i = a2;
            if (this.i == null) {
                ImageView imageView = new ImageView(context);
                this.h = imageView;
                imageView.setImageBitmap(this.i);
                addView(this.h);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f = 1.5f;
        }
        matrix.postScale(f, f);
        this.i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.i == null) {
        }
    }

    private void d() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (jVar = this.f) == null) {
            return;
        }
        jVar.b();
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, context) == null) {
            ak akVar = new ak(context, true);
            this.j = akVar;
            if (akVar.a()) {
                this.j.b(new y(this));
                this.j.a(new z(this));
                addView(this.j);
            }
        }
    }

    private void e() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (jVar = this.f) == null) {
            return;
        }
        jVar.c();
    }

    private void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, context) == null) {
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

    public static void setCustomMapStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            if (str == null || str.length() == 0) {
                throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
            }
            if (!new File(str).exists()) {
                throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
            }
            c = str;
        }
    }

    @Deprecated
    public static void setIconCustom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, null, i) == null) {
            e = i;
        }
    }

    public static void setLoadCustomMapStyleFileMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, null, i) == null) {
            d = i;
        }
    }

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65569, null, z) == null) {
            com.baidu.mapsdkplatform.comapi.map.i.a(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) && (layoutParams instanceof MapViewLayoutParams)) {
            super.addView(view2, layoutParams);
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? x.get((int) this.f.a().E().a).intValue() : invokeV.intValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G : invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.H : invokeV.intValue;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, windowInsets)) == null) {
            this.a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
            return windowInsets;
        }
        return (WindowInsets) invokeLL.objValue;
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, bundle) == null) || bundle == null) {
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

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.w;
            if (context != null) {
                this.f.b(context.hashCode());
            }
            Bitmap bitmap = this.i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.i.recycle();
                this.i = null;
            }
            this.j.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.i.b();
            AnimationTask animationTask = this.mTask;
            if (animationTask != null) {
                animationTask.cancel();
            }
            this.w = null;
        }
    }

    public final void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            removeAllViews();
        }
    }

    public final void onEnterAmbient(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            a(0);
        }
    }

    public void onExitAmbient() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(1);
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

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(20)
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            a(this.h);
            float f2 = 1.0f;
            if (((getWidth() - this.C) - this.D) - this.h.getMeasuredWidth() <= 0 || ((getHeight() - this.E) - this.F) - this.h.getMeasuredHeight() <= 0) {
                this.C = 0;
                this.D = 0;
                this.F = 0;
                this.E = 0;
                f = 1.0f;
            } else {
                float width = ((getWidth() - this.C) - this.D) / getWidth();
                f2 = ((getHeight() - this.E) - this.F) / getHeight();
                f = width;
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                com.baidu.mapsdkplatform.comapi.map.j jVar = this.f;
                if (childAt == jVar) {
                    jVar.layout(0, 0, getWidth(), getHeight());
                } else if (childAt == this.h) {
                    int i10 = (int) (this.F + (12.0f * f2));
                    if (this.a == ScreenShape.ROUND) {
                        a(this.j);
                        int i11 = s / 2;
                        i7 = a(i11, this.j.getMeasuredWidth() / 2);
                        i8 = ((s / 2) - a(i11, i11 - i7)) + u;
                    } else {
                        i7 = 0;
                        i8 = 0;
                    }
                    int i12 = (t - i7) - i10;
                    int i13 = s - i8;
                    this.h.layout(i13 - this.h.getMeasuredWidth(), i12 - this.h.getMeasuredHeight(), i13, i12);
                } else {
                    ak akVar = this.j;
                    if (childAt == akVar) {
                        if (akVar.a()) {
                            a(this.j);
                            Point point = this.m;
                            if (point == null) {
                                int a2 = (int) ((12.0f * f2) + this.E + (this.a == ScreenShape.ROUND ? a(t / 2, this.j.getMeasuredWidth() / 2) : 0));
                                int measuredWidth = (s - this.j.getMeasuredWidth()) / 2;
                                this.j.layout(measuredWidth, a2, this.j.getMeasuredWidth() + measuredWidth, this.j.getMeasuredHeight() + a2);
                            } else {
                                ak akVar2 = this.j;
                                int i14 = point.x;
                                akVar2.layout(i14, point.y, akVar2.getMeasuredWidth() + i14, this.m.y + this.j.getMeasuredHeight());
                            }
                        }
                    } else if (childAt == this.n) {
                        if (this.a == ScreenShape.ROUND) {
                            a(akVar);
                            int i15 = s / 2;
                            i5 = a(i15, this.j.getMeasuredWidth() / 2);
                            i6 = ((s / 2) - a(i15, i15 - i5)) + u;
                        } else {
                            i5 = 0;
                            i6 = 0;
                        }
                        a(this.n);
                        Point point2 = this.l;
                        if (point2 == null) {
                            this.H = this.n.getMeasuredWidth();
                            this.G = this.n.getMeasuredHeight();
                            int i16 = (int) (this.C + (5.0f * f) + i6);
                            int i17 = (t - ((int) (this.F + (12.0f * f2)))) - i5;
                            this.n.layout(i16, i17 - this.n.getMeasuredHeight(), this.H + i16, i17);
                        } else {
                            RelativeLayout relativeLayout = this.n;
                            int i18 = point2.x;
                            relativeLayout.layout(i18, point2.y, relativeLayout.getMeasuredWidth() + i18, this.l.y + this.n.getMeasuredHeight());
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
                                Point a3 = mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.f.a().a(CoordUtil.ll2mc(mapViewLayoutParams.a));
                                a(childAt);
                                int measuredWidth2 = childAt.getMeasuredWidth();
                                int measuredHeight = childAt.getMeasuredHeight();
                                float f3 = mapViewLayoutParams.d;
                                float f4 = mapViewLayoutParams.e;
                                int i19 = (int) (a3.x - (f3 * measuredWidth2));
                                int i20 = ((int) (a3.y - (f4 * measuredHeight))) + mapViewLayoutParams.f;
                                childAt.layout(i19, i20, measuredWidth2 + i19, measuredHeight + i20);
                            }
                        }
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || bundle == null || (baiduMap = this.g) == null) {
            return;
        }
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
        bundle.putInt("paddingLeft", this.C);
        bundle.putInt("paddingTop", this.E);
        bundle.putInt("paddingRight", this.D);
        bundle.putInt("paddingBottom", this.F);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view2) == null) || view2 == this.h) {
            return;
        }
        super.removeView(view2);
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onDismissCallback) == null) || (swipeDismissView = this.o) == null) {
            return;
        }
        swipeDismissView.setCallback(onDismissCallback);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i, i2, i3, i4) == null) {
            this.C = i;
            this.E = i2;
            this.D = i3;
            this.F = i4;
        }
    }

    public void setScaleControlPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, point) == null) || point == null || (i = point.x) < 0 || point.y < 0 || i > getWidth() || point.y > getHeight()) {
            return;
        }
        this.l = point;
        requestLayout();
    }

    public void setShape(ScreenShape screenShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, screenShape) == null) {
            this.a = screenShape;
        }
    }

    public void setViewAnimitionEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.k = z;
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, point) == null) || point == null || (i = point.x) < 0 || point.y < 0 || i > getWidth() || point.y > getHeight()) {
            return;
        }
        this.m = point;
        requestLayout();
    }

    public void showScaleControl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
            this.z = z;
        }
    }

    public void showZoomControls(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && this.j.a()) {
            this.j.setVisibility(z ? 0 : 8);
            this.y = z;
        }
    }
}
