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
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
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
/* loaded from: classes2.dex */
public final class MapView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static String b;
    public static int c;
    public static int d;
    public static final SparseIntArray q;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public MapSurfaceView e;
    public BaiduMap f;
    public ImageView g;
    public Bitmap h;
    public com.baidu.mapsdkplatform.comapi.map.ad i;
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
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    @Deprecated
    public static void setMapCustomEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, null, z) == null) {
        }
    }

    public void cancelRenderMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean handleTouchMove(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void renderMap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public void setCustomStyleFilePathAndMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i) == null) {
        }
    }

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
        a = MapView.class.getSimpleName();
        c = 0;
        d = 0;
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.append(3, 2000000);
        q.append(4, 1000000);
        q.append(5, 500000);
        q.append(6, 200000);
        q.append(7, 100000);
        q.append(8, 50000);
        q.append(9, 25000);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) && bundle != null && (baiduMap = this.f) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            bundle.putBoolean("mZoomControlEnabled", this.s);
            bundle.putBoolean("mScaleControlEnabled", this.t);
            bundle.putInt("logoPosition", this.r);
            bundle.putInt("paddingLeft", this.v);
            bundle.putInt("paddingTop", this.x);
            bundle.putInt("paddingRight", this.w);
            bundle.putInt("paddingBottom", this.y);
        }
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, baiduMapOptions) == null) {
            this.p = context;
            com.baidu.mapsdkplatform.comapi.map.j.a();
            BMapManager.init();
            a(context, baiduMapOptions, b, c);
            a(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.h) {
                this.i.setVisibility(4);
            }
            c(context);
            if (baiduMapOptions != null && !baiduMapOptions.i) {
                this.l.setVisibility(4);
            }
            if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
                this.r = logoPosition.ordinal();
            }
            if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
                this.k = point2;
            }
            if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
                this.j = point;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapView(Context context, AttributeSet attributeSet, int i) {
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
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.r = LogoPosition.logoPostionleftBottom.ordinal();
        this.s = true;
        this.t = true;
        this.B = false;
        a(context, baiduMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, this, str, str2) == null) && (mapSurfaceView = this.e) != null && mapSurfaceView.getBaseMap() != null) {
            if (TextUtils.isEmpty(str)) {
                Log.e(a, "customStyleFilePath is empty or null, please check!");
            } else if (!str.endsWith(".sty")) {
                Log.e(a, "customStyleFile format is incorrect , please check!");
            } else if (!new File(str).exists()) {
                Log.e(a, "customStyleFile does not exist , please check!");
            } else {
                this.e.getBaseMap().b(str, str2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) && (layoutParams instanceof MapViewLayoutParams)) {
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            super.addView(view2, layoutParams);
        }
    }

    public void handleTouchDown(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) != null) || this.e == null) {
        }
    }

    public boolean handleTouchUp(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.e == null) {
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final BaiduMap getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaiduMap baiduMap = this.f;
            baiduMap.a = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return q.get(Math.round(this.e.getZoomLevel()));
        }
        return invokeV.intValue;
    }

    public Point getScaleControlPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (Point) invokeV.objValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public Point getZoomControlsPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return (Point) invokeV.objValue;
    }

    public boolean isShowScaleControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.onPause();
        }
    }

    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.e.onResume();
        }
    }

    private void a(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            int densityDpi = SysOSUtil.getDensityDpi();
            if (densityDpi < 180) {
                str = "logo_l.png";
            } else {
                str = "logo_h.png";
            }
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, context);
            if (a2 == null) {
                return;
            }
            if (densityDpi > 480) {
                Matrix matrix = new Matrix();
                matrix.postScale(2.0f, 2.0f);
                this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
            } else if (densityDpi > 320) {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                this.h = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
            } else {
                this.h = a2;
            }
            if (this.h != null) {
                ImageView imageView = new ImageView(context);
                this.g = imageView;
                imageView.setImageBitmap(this.h);
                addView(this.g);
            }
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65545, this, context, baiduMapOptions, str, i) == null) {
            this.e = new MapSurfaceView(context);
            if (baiduMapOptions != null) {
                this.f = new BaiduMap(context, this.e, baiduMapOptions.a());
            } else {
                this.f = new BaiduMap(context, this.e, (com.baidu.mapsdkplatform.comapi.map.v) null);
            }
            addView(this.e);
            r rVar = new r(this);
            if (this.e.getBaseMap() != null) {
                this.e.getBaseMap().a(rVar);
            }
        }
    }

    private void a(View view2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, view2) == null) {
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
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = new com.baidu.mapsdkplatform.comapi.map.ad(context, false);
            this.i = adVar;
            if (!adVar.a()) {
                return;
            }
            this.i.b(new s(this));
            this.i.a(new t(this));
            addView(this.i);
        }
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            if (str != null && str.length() != 0) {
                if (new File(str).exists()) {
                    b = str;
                    return;
                }
                throw new RuntimeException("BDMapSDKException: please check whether the customMapStylePath file exits");
            }
            throw new RuntimeException("BDMapSDKException: customMapStylePath String is illegal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MapCustomStyleOptions mapCustomStyleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, str, mapCustomStyleOptions) == null) {
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

    @Deprecated
    public static void setIconCustom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i) == null) {
            d = i;
        }
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i) == null) {
            c = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, view2) != null) || view2 == this.g) {
            return;
        }
        if (c()) {
            super.removeView(view2);
        } else {
            com.baidu.platform.comapi.util.j.a(new u(this, view2), 0L);
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, logoPosition) == null) {
            if (logoPosition == null) {
                this.r = LogoPosition.logoPostionleftBottom.ordinal();
            } else {
                this.r = logoPosition.ordinal();
            }
            requestLayout();
        }
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (mapSurfaceView = this.e) != null && mapSurfaceView.getBaseMap() != null) {
            this.e.getBaseMap().p(z);
        }
    }

    public void setMapCustomStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            a(str, "");
        }
    }

    public void setScaleControlPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, point) == null) && point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, motionEvent) == null) {
            this.e.onTouchEvent(motionEvent);
        }
    }

    public final void setZOrderMediaOverlay(boolean z) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z) != null) || (mapSurfaceView = this.e) == null) {
            return;
        }
        mapSurfaceView.setZOrderMediaOverlay(z);
    }

    public void setZoomControlsPosition(Point point) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, point) == null) && point != null && (i = point.x) >= 0 && point.y >= 0 && i <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            RelativeLayout relativeLayout = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
            this.t = z;
        }
    }

    public void showZoomControls(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && this.i.a()) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            adVar.setVisibility(i);
            this.s = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.ad adVar;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && (adVar = this.i) != null && adVar.a() && this.e.getBaseMap() != null) {
            float f = this.e.getBaseMap().D().a;
            com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.i;
            boolean z2 = true;
            if (f > this.e.getBaseMap().b) {
                z = true;
            } else {
                z = false;
            }
            adVar2.b(z);
            com.baidu.mapsdkplatform.comapi.map.ad adVar3 = this.i;
            if (f >= this.e.getBaseMap().a) {
                z2 = false;
            }
            adVar3.a(z2);
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, context) == null) {
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
            ImageView imageView = this.o;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams3);
                Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
                if (a2 != null) {
                    byte[] ninePatchChunk = a2.getNinePatchChunk();
                    if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
                    }
                }
                this.l.addView(this.o);
            }
            addView(this.l);
        }
    }

    public final LogoPosition getLogoPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.r;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return LogoPosition.logoPostionleftBottom;
                            }
                            return LogoPosition.logoPostionRightTop;
                        }
                        return LogoPosition.logoPostionRightBottom;
                    }
                    return LogoPosition.logoPostionCenterTop;
                }
                return LogoPosition.logoPostionCenterBottom;
            }
            return LogoPosition.logoPostionleftTop;
        }
        return (LogoPosition) invokeV.objValue;
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BaiduMap baiduMap = this.f;
            if (baiduMap != null) {
                baiduMap.c();
            }
            MapSurfaceView mapSurfaceView = this.e;
            if (mapSurfaceView != null) {
                mapSurfaceView.unInit();
            }
            Bitmap bitmap = this.h;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.h.recycle();
                this.h = null;
            }
            if (b != null) {
                b = null;
            }
            this.i.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.j.b();
            this.p = null;
        }
    }

    public boolean inRangeOfView(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            MapSurfaceView mapSurfaceView = this.e;
            if (mapSurfaceView != null && mapSurfaceView.inRangeOfView(f, f2)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setMapCustomStyle(MapCustomStyleOptions mapCustomStyleOptions, CustomMapStyleCallBack customMapStyleCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048601, this, mapCustomStyleOptions, customMapStyleCallBack) != null) || mapCustomStyleOptions == null) {
            return;
        }
        String customMapStyleId = mapCustomStyleOptions.getCustomMapStyleId();
        if (customMapStyleId != null && !customMapStyleId.isEmpty()) {
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.p, customMapStyleId, new q(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
            setMapCustomStyleEnable(true);
        }
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, context, bundle) != null) || bundle == null) {
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

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        Point point;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            a(this.g);
            float f2 = 1.0f;
            if (((getWidth() - this.v) - this.w) - this.g.getMeasuredWidth() > 0 && ((getHeight() - this.x) - this.y) - this.g.getMeasuredHeight() > 0) {
                f2 = ((getWidth() - this.v) - this.w) / getWidth();
                f = ((getHeight() - this.x) - this.y) / getHeight();
            } else {
                this.v = 0;
                this.w = 0;
                this.y = 0;
                this.x = 0;
                f = 1.0f;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    MapSurfaceView mapSurfaceView = this.e;
                    if (childAt == mapSurfaceView) {
                        mapSurfaceView.layout(0, 0, getWidth(), getHeight());
                    } else {
                        ImageView imageView = this.g;
                        if (childAt == imageView) {
                            float f3 = f2 * 5.0f;
                            int i6 = (int) (this.v + f3);
                            int i7 = (int) (this.w + f3);
                            float f4 = 5.0f * f;
                            int i8 = (int) (this.x + f4);
                            int i9 = (int) (this.y + f4);
                            int i10 = this.r;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    if (i10 != 3) {
                                        if (i10 != 4) {
                                            if (i10 != 5) {
                                                measuredHeight = getHeight() - i9;
                                                measuredWidth = this.g.getMeasuredWidth() + i6;
                                                i8 = measuredHeight - this.g.getMeasuredHeight();
                                            } else {
                                                measuredHeight = i8 + imageView.getMeasuredHeight();
                                                measuredWidth = getWidth() - i7;
                                                measuredWidth2 = this.g.getMeasuredWidth();
                                            }
                                        } else {
                                            measuredHeight = getHeight() - i9;
                                            i8 = measuredHeight - this.g.getMeasuredHeight();
                                            measuredWidth = getWidth() - i7;
                                            measuredWidth2 = this.g.getMeasuredWidth();
                                        }
                                        i6 = measuredWidth - measuredWidth2;
                                    } else {
                                        measuredHeight = i8 + imageView.getMeasuredHeight();
                                        i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                        measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                    }
                                } else {
                                    measuredHeight = getHeight() - i9;
                                    i8 = measuredHeight - this.g.getMeasuredHeight();
                                    i6 = (((getWidth() - this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                    measuredWidth = (((getWidth() + this.g.getMeasuredWidth()) + this.v) - this.w) / 2;
                                }
                            } else {
                                measuredHeight = imageView.getMeasuredHeight() + i8;
                                measuredWidth = this.g.getMeasuredWidth() + i6;
                            }
                            this.g.layout(i6, i8, measuredWidth, measuredHeight);
                        } else {
                            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.i;
                            if (childAt == adVar) {
                                if (adVar.a()) {
                                    a(this.i);
                                    Point point2 = this.k;
                                    if (point2 == null) {
                                        int height = (int) (((getHeight() - 15) * f) + this.x);
                                        int width = (int) (((getWidth() - 15) * f2) + this.v);
                                        int measuredWidth3 = width - this.i.getMeasuredWidth();
                                        int measuredHeight2 = height - this.i.getMeasuredHeight();
                                        if (this.r == 4) {
                                            height -= this.g.getMeasuredHeight();
                                            measuredHeight2 -= this.g.getMeasuredHeight();
                                        }
                                        this.i.layout(measuredWidth3, measuredHeight2, width, height);
                                    } else {
                                        com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.i;
                                        int i11 = point2.x;
                                        adVar2.layout(i11, point2.y, adVar2.getMeasuredWidth() + i11, this.k.y + this.i.getMeasuredHeight());
                                    }
                                }
                            } else {
                                RelativeLayout relativeLayout = this.l;
                                if (childAt == relativeLayout) {
                                    a(relativeLayout);
                                    Point point3 = this.j;
                                    if (point3 == null) {
                                        this.A = this.l.getMeasuredWidth();
                                        this.z = this.l.getMeasuredHeight();
                                        int i12 = (int) (this.v + (5.0f * f2));
                                        int height2 = (getHeight() - ((int) ((this.y + (f * 5.0f)) + 56.0f))) - this.g.getMeasuredHeight();
                                        this.l.layout(i12, height2, this.A + i12, this.z + height2);
                                    } else {
                                        RelativeLayout relativeLayout2 = this.l;
                                        int i13 = point3.x;
                                        relativeLayout2.layout(i13, point3.y, relativeLayout2.getMeasuredWidth() + i13, this.j.y + this.l.getMeasuredHeight());
                                    }
                                } else {
                                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                    if (layoutParams instanceof MapViewLayoutParams) {
                                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                        if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                            point = mapViewLayoutParams.b;
                                        } else {
                                            GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.a);
                                            if (this.e.getBaseMap() != null) {
                                                point = this.e.getBaseMap().a(ll2mc);
                                            } else {
                                                point = new Point();
                                            }
                                        }
                                        a(childAt);
                                        int measuredWidth4 = childAt.getMeasuredWidth();
                                        int measuredHeight3 = childAt.getMeasuredHeight();
                                        float f5 = mapViewLayoutParams.d;
                                        float f6 = mapViewLayoutParams.e;
                                        int i14 = (int) (point.x - (f5 * measuredWidth4));
                                        int i15 = ((int) (point.y - (f6 * measuredHeight3))) + mapViewLayoutParams.f;
                                        childAt.layout(i14, i15, measuredWidth4 + i14, measuredHeight3 + i15);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            this.v = i;
            this.x = i2;
            this.w = i3;
            this.y = i4;
        }
    }
}
