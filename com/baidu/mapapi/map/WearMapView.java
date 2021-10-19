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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.util.CustomMapStyleLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
@TargetApi(20)
/* loaded from: classes5.dex */
public class WearMapView extends ViewGroup implements View.OnApplyWindowInsetsListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BT_INVIEW = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final String f41712b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41713c;

    /* renamed from: d  reason: collision with root package name */
    public static int f41714d;

    /* renamed from: e  reason: collision with root package name */
    public static int f41715e;
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

    /* renamed from: a  reason: collision with root package name */
    public ScreenShape f41716a;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f41717f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduMap f41718g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f41719h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f41720i;

    /* renamed from: j  reason: collision with root package name */
    public ak f41721j;
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

    /* loaded from: classes5.dex */
    public class AnimationTask extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WearMapView f41722a;

        public AnimationTask(WearMapView wearMapView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wearMapView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41722a = wearMapView;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message message = new Message();
                message.what = 1;
                this.f41722a.mTimerHandler.sendMessage(message);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ScreenShape {
        public static /* synthetic */ Interceptable $ic;
        public static final ScreenShape RECTANGLE;
        public static final ScreenShape ROUND;
        public static final ScreenShape UNDETECTED;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ ScreenShape[] f41723a;
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
            f41723a = new ScreenShape[]{ROUND, RECTANGLE, screenShape};
        }

        public ScreenShape(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScreenShape[]) f41723a.clone() : (ScreenShape[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WearMapView f41724a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f41725b;

        public a(WearMapView wearMapView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wearMapView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41724a = wearMapView;
            this.f41725b = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f41725b.get() == null) {
                return;
            }
            super.handleMessage(message);
            if (message.what == 1 && this.f41724a.f41721j != null) {
                this.f41724a.a(true);
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
        f41712b = MapView.class.getSimpleName();
        f41714d = 0;
        f41715e = 0;
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
        x.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.f41716a = ScreenShape.ROUND;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.f41716a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WearMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.f41716a = ScreenShape.ROUND;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.k = true;
        this.v = true;
        this.f41716a = ScreenShape.ROUND;
        this.y = true;
        this.z = true;
        a(context, baiduMapOptions);
    }

    private int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3)) == null) ? i2 - ((int) Math.sqrt(Math.pow(i2, 2.0d) - Math.pow(i3, 2.0d))) : invokeII.intValue;
    }

    private void a(int i2) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, this, i2) == null) || (jVar = this.f41717f) == null) {
            return;
        }
        if (i2 == 0) {
            jVar.onPause();
            b();
        } else if (i2 != 1) {
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
            a(context, baiduMapOptions, f41714d == 0 ? f41713c : CustomMapStyleLoader.getCustomStyleFilePath());
            this.f41718g = new BaiduMap(this.f41717f);
            this.f41717f.a().t(false);
            this.f41717f.a().s(false);
            c(context);
            d(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.f41447h) {
                this.f41721j.setVisibility(4);
            }
            e(context);
            if (baiduMapOptions != null && !baiduMapOptions.f41448i) {
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
                this.f41717f = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, f41715e);
            } else {
                this.f41717f = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, f41715e);
            }
            addView(this.f41717f);
            this.B = new x(this);
            this.f41717f.a().a(this.B);
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, view) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            int i2 = layoutParams.width;
            int makeMeasureSpec = i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
            int i3 = layoutParams.height;
            view.measure(makeMeasureSpec, i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    private void a(View view, boolean z) {
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, view, z) == null) {
            if (z) {
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, -50.0f), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f));
                animatorSet.addListener(new aa(this, view));
            } else {
                view.setVisibility(0);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "TranslationY", -50.0f, 0.0f), ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f));
            }
            animatorSet.setDuration(IMLikeRequest.TIME_INTERVAL);
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65552, this, z) == null) && this.k) {
            a(this.f41721j, z);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.f41717f == null || this.v) {
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
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.f41717f != null && this.v) {
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
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65558, this, context) != null) {
            return;
        }
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            matrix = new Matrix();
            f2 = 2.0f;
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.f41720i = a2;
            if (this.f41720i == null) {
                ImageView imageView = new ImageView(context);
                this.f41719h = imageView;
                imageView.setImageBitmap(this.f41720i);
                addView(this.f41719h);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f41720i = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f41720i == null) {
        }
    }

    private void d() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (jVar = this.f41717f) == null) {
            return;
        }
        jVar.b();
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, context) == null) {
            ak akVar = new ak(context, true);
            this.f41721j = akVar;
            if (akVar.a()) {
                this.f41721j.b(new y(this));
                this.f41721j.a(new z(this));
                addView(this.f41721j);
            }
        }
    }

    private void e() {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (jVar = this.f41717f) == null) {
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
            f41713c = str;
        }
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, null, i2) == null) {
            f41715e = i2;
        }
    }

    public static void setLoadCustomMapStyleFileMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, null, i2) == null) {
            f41714d = i2;
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
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view, layoutParams) == null) && (layoutParams instanceof MapViewLayoutParams)) {
            super.addView(view, layoutParams);
        }
    }

    public final BaiduMap getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaiduMap baiduMap = this.f41718g;
            baiduMap.f41433c = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? x.get((int) this.f41717f.a().E().f42240a).intValue() : invokeV.intValue;
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
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, windowInsets)) == null) {
            this.f41716a = windowInsets.isRound() ? ScreenShape.ROUND : ScreenShape.RECTANGLE;
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
                this.f41717f.b(context.hashCode());
            }
            Bitmap bitmap = this.f41720i;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f41720i.recycle();
                this.f41720i = null;
            }
            this.f41721j.b();
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
            } else if (this.f41721j.getVisibility() == 0) {
                Timer timer2 = this.mTimer;
                if (timer2 != null) {
                    if (this.mTask != null) {
                        timer2.cancel();
                        this.mTask.cancel();
                    }
                    this.mTimer = null;
                    this.mTask = null;
                }
            } else if (this.f41721j.getVisibility() == 4) {
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
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            a(this.f41719h);
            float f3 = 1.0f;
            if (((getWidth() - this.C) - this.D) - this.f41719h.getMeasuredWidth() <= 0 || ((getHeight() - this.E) - this.F) - this.f41719h.getMeasuredHeight() <= 0) {
                this.C = 0;
                this.D = 0;
                this.F = 0;
                this.E = 0;
                f2 = 1.0f;
            } else {
                float width = ((getWidth() - this.C) - this.D) / getWidth();
                f3 = ((getHeight() - this.E) - this.F) / getHeight();
                f2 = width;
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                com.baidu.mapsdkplatform.comapi.map.j jVar = this.f41717f;
                if (childAt == jVar) {
                    jVar.layout(0, 0, getWidth(), getHeight());
                } else if (childAt == this.f41719h) {
                    int i11 = (int) (this.F + (12.0f * f3));
                    if (this.f41716a == ScreenShape.ROUND) {
                        a(this.f41721j);
                        int i12 = s / 2;
                        i8 = a(i12, this.f41721j.getMeasuredWidth() / 2);
                        i9 = ((s / 2) - a(i12, i12 - i8)) + u;
                    } else {
                        i8 = 0;
                        i9 = 0;
                    }
                    int i13 = (t - i8) - i11;
                    int i14 = s - i9;
                    this.f41719h.layout(i14 - this.f41719h.getMeasuredWidth(), i13 - this.f41719h.getMeasuredHeight(), i14, i13);
                } else {
                    ak akVar = this.f41721j;
                    if (childAt == akVar) {
                        if (akVar.a()) {
                            a(this.f41721j);
                            Point point = this.m;
                            if (point == null) {
                                int a2 = (int) ((12.0f * f3) + this.E + (this.f41716a == ScreenShape.ROUND ? a(t / 2, this.f41721j.getMeasuredWidth() / 2) : 0));
                                int measuredWidth = (s - this.f41721j.getMeasuredWidth()) / 2;
                                this.f41721j.layout(measuredWidth, a2, this.f41721j.getMeasuredWidth() + measuredWidth, this.f41721j.getMeasuredHeight() + a2);
                            } else {
                                ak akVar2 = this.f41721j;
                                int i15 = point.x;
                                akVar2.layout(i15, point.y, akVar2.getMeasuredWidth() + i15, this.m.y + this.f41721j.getMeasuredHeight());
                            }
                        }
                    } else if (childAt == this.n) {
                        if (this.f41716a == ScreenShape.ROUND) {
                            a(akVar);
                            int i16 = s / 2;
                            i6 = a(i16, this.f41721j.getMeasuredWidth() / 2);
                            i7 = ((s / 2) - a(i16, i16 - i6)) + u;
                        } else {
                            i6 = 0;
                            i7 = 0;
                        }
                        a(this.n);
                        Point point2 = this.l;
                        if (point2 == null) {
                            this.H = this.n.getMeasuredWidth();
                            this.G = this.n.getMeasuredHeight();
                            int i17 = (int) (this.C + (5.0f * f2) + i7);
                            int i18 = (t - ((int) (this.F + (12.0f * f3)))) - i6;
                            this.n.layout(i17, i18 - this.n.getMeasuredHeight(), this.H + i17, i18);
                        } else {
                            RelativeLayout relativeLayout = this.n;
                            int i19 = point2.x;
                            relativeLayout.layout(i19, point2.y, relativeLayout.getMeasuredWidth() + i19, this.l.y + this.n.getMeasuredHeight());
                        }
                    } else {
                        View view = this.o;
                        if (childAt == view) {
                            a(view);
                            this.o.layout(0, 0, this.o.getMeasuredWidth(), t);
                        } else {
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            if (layoutParams instanceof MapViewLayoutParams) {
                                MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                Point a3 = mapViewLayoutParams.f41574c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f41573b : this.f41717f.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f41572a));
                                a(childAt);
                                int measuredWidth2 = childAt.getMeasuredWidth();
                                int measuredHeight = childAt.getMeasuredHeight();
                                float f4 = mapViewLayoutParams.f41575d;
                                float f5 = mapViewLayoutParams.f41576e;
                                int i20 = (int) (a3.x - (f4 * measuredWidth2));
                                int i21 = ((int) (a3.y - (f5 * measuredHeight))) + mapViewLayoutParams.f41577f;
                                childAt.layout(i20, i21, measuredWidth2 + i20, measuredHeight + i21);
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
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) || bundle == null || (baiduMap = this.f41718g) == null) {
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
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, view) == null) || view == this.f41719h) {
            return;
        }
        super.removeView(view);
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
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048592, this, i2, i3, i4, i5) == null) {
            this.C = i2;
            this.E = i3;
            this.D = i4;
            this.F = i5;
        }
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
            return;
        }
        this.l = point;
        requestLayout();
    }

    public void setShape(ScreenShape screenShape) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, screenShape) == null) {
            this.f41716a = screenShape;
        }
    }

    public void setViewAnimitionEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.k = z;
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
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
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && this.f41721j.a()) {
            this.f41721j.setVisibility(z ? 0 : 8);
            this.y = z;
        }
    }
}
