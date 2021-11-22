package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.webkit.net.BdNetTask;
import java.io.File;
/* loaded from: classes7.dex */
public final class MapView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f40243a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40244b;

    /* renamed from: c  reason: collision with root package name */
    public static int f40245c;

    /* renamed from: d  reason: collision with root package name */
    public static int f40246d;
    public static final SparseArray<Integer> q;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f40247e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduMap f40248f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f40249g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f40250h;

    /* renamed from: i  reason: collision with root package name */
    public ak f40251i;
    public Point j;
    public Point k;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context p;
    public int r;
    public boolean s;
    public boolean t;
    public float u;
    public com.baidu.mapsdkplatform.comapi.map.l v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(367631120, "Lcom/baidu/mapapi/map/MapView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(367631120, "Lcom/baidu/mapapi/map/MapView;");
                return;
            }
        }
        f40243a = MapView.class.getSimpleName();
        f40245c = 0;
        f40246d = 0;
        SparseArray<Integer> sparseArray = new SparseArray<>();
        q = sparseArray;
        sparseArray.append(3, 2000000);
        q.append(4, 1000000);
        q.append(5, 500000);
        q.append(6, 200000);
        q.append(7, 100000);
        q.append(8, 50000);
        q.append(9, Integer.valueOf((int) BdNetTask.TIMEOUT_READ));
        q.append(10, 20000);
        q.append(11, 10000);
        q.append(12, 5000);
        q.append(13, 2000);
        q.append(14, 1000);
        q.append(15, 500);
        q.append(16, 200);
        q.append(17, 100);
        q.append(18, 50);
        q.append(19, 20);
        q.append(20, 10);
        q.append(21, 5);
        q.append(22, 2);
        q.append(23, 2);
        q.append(24, 2);
        q.append(25, 2);
        q.append(26, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapView(Context context) {
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapView(Context context, AttributeSet attributeSet) {
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapView(Context context, AttributeSet attributeSet, int i2) {
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        a(context, baiduMapOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context) {
        Matrix matrix;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65544, this, context) != null) {
            return;
        }
        int densityDpi = SysOSUtil.getDensityDpi();
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(densityDpi < 180 ? "logo_l.png" : "logo_h.png", context);
        if (densityDpi > 480) {
            matrix = new Matrix();
            f2 = 2.0f;
        } else if (densityDpi <= 320 || densityDpi > 480) {
            this.f40250h = a2;
            if (this.f40250h == null) {
                ImageView imageView = new ImageView(context);
                this.f40249g = imageView;
                imageView.setImageBitmap(this.f40250h);
                addView(this.f40249g);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f40250h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f40250h == null) {
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, baiduMapOptions) == null) {
            this.p = context;
            com.baidu.mapsdkplatform.comapi.map.i.a();
            BMapManager.init();
            a(context, baiduMapOptions, f40245c == 0 ? f40244b : CustomMapStyleLoader.getCustomStyleFilePath(), f40245c);
            this.f40248f = new BaiduMap(this.f40247e);
            a(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.f40134h) {
                this.f40251i.setVisibility(4);
            }
            c(context);
            if (baiduMapOptions != null && !baiduMapOptions.f40135i) {
                this.l.setVisibility(4);
            }
            if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
                this.r = logoPosition.ordinal();
            }
            if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
                this.k = point2;
            }
            if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
                return;
            }
            this.j = point;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65546, this, context, baiduMapOptions, str, i2) == null) {
            if (baiduMapOptions == null) {
                this.f40247e = new com.baidu.mapsdkplatform.comapi.map.j(context, null, str, i2);
            } else {
                this.f40247e = new com.baidu.mapsdkplatform.comapi.map.j(context, baiduMapOptions.a(), str, i2);
            }
            addView(this.f40247e);
            this.v = new l(this);
            this.f40247e.a().a(this.v);
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, view) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f40251i.a()) {
            float f2 = this.f40247e.a().E().f40899a;
            this.f40251i.b(f2 > this.f40247e.a().f40947b);
            this.f40251i.a(f2 < this.f40247e.a().f40946a);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            ak akVar = new ak(context, false);
            this.f40251i = akVar;
            if (akVar.a()) {
                this.f40251i.b(new m(this));
                this.f40251i.a(new n(this));
                addView(this.f40251i);
            }
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, context) == null) {
            this.l = new RelativeLayout(context);
            this.l.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.m = new TextView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            this.m.setTextColor(Color.parseColor("#FFFFFF"));
            this.m.setTextSize(2, 11.0f);
            TextView textView = this.m;
            textView.setTypeface(textView.getTypeface(), 1);
            this.m.setLayoutParams(layoutParams);
            this.m.setId(Integer.MAX_VALUE);
            this.l.addView(this.m);
            this.n = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.addRule(14);
            this.n.setTextColor(Color.parseColor("#000000"));
            this.n.setTextSize(2, 11.0f);
            this.n.setLayoutParams(layoutParams2);
            this.l.addView(this.n);
            this.o = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.m.getId());
            this.o.setLayoutParams(layoutParams3);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
            byte[] ninePatchChunk = a2.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
            this.l.addView(this.o);
            addView(this.l);
        }
    }

    public static void setCustomMapStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            if (str == null || str.length() == 0) {
                throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
            }
            if (!new File(str).exists()) {
                throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
            }
            f40244b = str;
        }
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i2) == null) {
            f40246d = i2;
        }
    }

    public static void setLoadCustomMapStyleFileMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            f40245c = i2;
        }
    }

    public static void setMapCustomEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
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

    public void cancelRenderMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f40247e.a().w(false);
            this.f40247e.a().P().clear();
        }
    }

    public final LogoPosition getLogoPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.r;
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
        }
        return (LogoPosition) invokeV.objValue;
    }

    public final BaiduMap getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduMap baiduMap = this.f40248f;
            baiduMap.f40119a = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? q.get((int) this.f40247e.a().E().f40899a).intValue() : invokeV.intValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : invokeV.intValue;
    }

    public boolean handleMultiTouch(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f40247e;
            return jVar != null && jVar.a(f2, f3, f4, f5);
        }
        return invokeCommon.booleanValue;
    }

    public void handleTouchDown(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (jVar = this.f40247e) == null) {
            return;
        }
        jVar.a(f2, f3);
    }

    public boolean handleTouchMove(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f40247e;
            return jVar != null && jVar.c(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public boolean handleTouchUp(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f40247e;
            if (jVar == null) {
                return false;
            }
            return jVar.b(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public boolean inRangeOfView(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.j jVar = this.f40247e;
            return jVar != null && jVar.d(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, context, bundle) == null) || bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.j != null) {
            this.j = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.k != null) {
            this.k = (Point) bundle.getParcelable("zoomPosition");
        }
        this.s = bundle.getBoolean("mZoomControlEnabled");
        this.t = bundle.getBoolean("mScaleControlEnabled");
        this.r = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Context context = this.p;
            if (context != null) {
                this.f40247e.b(context.hashCode());
            }
            Bitmap bitmap = this.f40250h;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f40250h.recycle();
                this.f40250h = null;
            }
            if (f40244b != null) {
                f40244b = null;
            }
            this.f40251i.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.i.b();
            this.p = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int measuredHeight;
        int measuredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            a(this.f40249g);
            float f3 = 1.0f;
            if (((getWidth() - this.w) - this.x) - this.f40249g.getMeasuredWidth() <= 0 || ((getHeight() - this.y) - this.z) - this.f40249g.getMeasuredHeight() <= 0) {
                this.w = 0;
                this.x = 0;
                this.z = 0;
                this.y = 0;
                f2 = 1.0f;
            } else {
                f3 = ((getWidth() - this.w) - this.x) / getWidth();
                f2 = ((getHeight() - this.y) - this.z) / getHeight();
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    com.baidu.mapsdkplatform.comapi.map.j jVar = this.f40247e;
                    if (childAt == jVar) {
                        jVar.layout(0, 0, getWidth(), getHeight());
                    } else {
                        ImageView imageView = this.f40249g;
                        if (childAt == imageView) {
                            float f4 = f3 * 5.0f;
                            int i7 = (int) (this.w + f4);
                            int i8 = (int) (this.x + f4);
                            float f5 = 5.0f * f2;
                            int i9 = (int) (this.y + f5);
                            int i10 = (int) (this.z + f5);
                            int i11 = this.r;
                            if (i11 != 1) {
                                if (i11 == 2) {
                                    measuredHeight = getHeight() - i10;
                                    i9 = measuredHeight - this.f40249g.getMeasuredHeight();
                                } else if (i11 != 3) {
                                    if (i11 == 4) {
                                        measuredHeight = getHeight() - i10;
                                        i9 = measuredHeight - this.f40249g.getMeasuredHeight();
                                    } else if (i11 != 5) {
                                        measuredHeight = getHeight() - i10;
                                        measuredWidth = this.f40249g.getMeasuredWidth() + i7;
                                        i9 = measuredHeight - this.f40249g.getMeasuredHeight();
                                    } else {
                                        measuredHeight = i9 + imageView.getMeasuredHeight();
                                    }
                                    measuredWidth = getWidth() - i8;
                                    i7 = measuredWidth - this.f40249g.getMeasuredWidth();
                                } else {
                                    measuredHeight = i9 + imageView.getMeasuredHeight();
                                }
                                i7 = (((getWidth() - this.f40249g.getMeasuredWidth()) + this.w) - this.x) / 2;
                                measuredWidth = (((getWidth() + this.f40249g.getMeasuredWidth()) + this.w) - this.x) / 2;
                            } else {
                                measuredHeight = imageView.getMeasuredHeight() + i9;
                                measuredWidth = this.f40249g.getMeasuredWidth() + i7;
                            }
                            this.f40249g.layout(i7, i9, measuredWidth, measuredHeight);
                        } else {
                            ak akVar = this.f40251i;
                            if (childAt != akVar) {
                                RelativeLayout relativeLayout = this.l;
                                if (childAt == relativeLayout) {
                                    a(relativeLayout);
                                    Point point = this.j;
                                    if (point == null) {
                                        this.B = this.l.getMeasuredWidth();
                                        this.A = this.l.getMeasuredHeight();
                                        int i12 = (int) (this.w + (5.0f * f3));
                                        int height = (getHeight() - ((int) ((this.z + (f2 * 5.0f)) + 56.0f))) - this.f40249g.getMeasuredHeight();
                                        this.l.layout(i12, height, this.B + i12, this.A + height);
                                    } else {
                                        RelativeLayout relativeLayout2 = this.l;
                                        int i13 = point.x;
                                        relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.j.y + this.l.getMeasuredHeight());
                                    }
                                } else {
                                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                    if (layoutParams instanceof MapViewLayoutParams) {
                                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                        Point a2 = mapViewLayoutParams.f40254c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f40253b : this.f40247e.a().a(CoordUtil.ll2mc(mapViewLayoutParams.f40252a));
                                        a(childAt);
                                        int measuredWidth2 = childAt.getMeasuredWidth();
                                        int measuredHeight2 = childAt.getMeasuredHeight();
                                        float f6 = mapViewLayoutParams.f40255d;
                                        float f7 = mapViewLayoutParams.f40256e;
                                        int i14 = (int) (a2.x - (f6 * measuredWidth2));
                                        int i15 = ((int) (a2.y - (f7 * measuredHeight2))) + mapViewLayoutParams.f40257f;
                                        childAt.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
                                    }
                                }
                            } else if (akVar.a()) {
                                a(this.f40251i);
                                Point point2 = this.k;
                                if (point2 == null) {
                                    int height2 = (int) (((getHeight() - 15) * f2) + this.y);
                                    int width = (int) (((getWidth() - 15) * f3) + this.w);
                                    int measuredWidth3 = width - this.f40251i.getMeasuredWidth();
                                    int measuredHeight3 = height2 - this.f40251i.getMeasuredHeight();
                                    if (this.r == 4) {
                                        height2 -= this.f40249g.getMeasuredHeight();
                                        measuredHeight3 -= this.f40249g.getMeasuredHeight();
                                    }
                                    this.f40251i.layout(measuredWidth3, measuredHeight3, width, height2);
                                } else {
                                    ak akVar2 = this.f40251i;
                                    int i16 = point2.x;
                                    akVar2.layout(i16, point2.y, akVar2.getMeasuredWidth() + i16, this.k.y + this.f40251i.getMeasuredHeight());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f40247e.onPause();
        }
    }

    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f40247e.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) || bundle == null || (baiduMap = this.f40248f) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.j;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.k;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.s);
        bundle.putBoolean("mScaleControlEnabled", this.t);
        bundle.putInt("logoPosition", this.r);
        bundle.putInt("paddingLeft", this.w);
        bundle.putInt("paddingTop", this.y);
        bundle.putInt("paddingRight", this.x);
        bundle.putInt("paddingBottom", this.z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || view == this.f40249g) {
            return;
        }
        super.removeView(view);
    }

    public void renderMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            com.baidu.mapsdkplatform.comapi.map.e a2 = this.f40247e.a();
            a2.w(true);
            a2.Q();
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, logoPosition) == null) {
            if (logoPosition == null) {
                logoPosition = LogoPosition.logoPostionleftBottom;
            }
            this.r = logoPosition.ordinal();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) {
            this.w = i2;
            this.y = i3;
            this.x = i4;
            this.z = i5;
        }
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
            return;
        }
        this.j = point;
        requestLayout();
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, motionEvent) == null) {
            this.f40247e.onTouchEvent(motionEvent);
        }
    }

    public final void setZOrderMediaOverlay(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (jVar = this.f40247e) == null) {
            return;
        }
        jVar.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
            return;
        }
        this.k = point;
        requestLayout();
    }

    public void showScaleControl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.l.setVisibility(z ? 0 : 8);
            this.t = z;
        }
    }

    public void showZoomControls(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && this.f40251i.a()) {
            this.f40251i.setVisibility(z ? 0 : 8);
            this.s = z;
        }
    }
}
