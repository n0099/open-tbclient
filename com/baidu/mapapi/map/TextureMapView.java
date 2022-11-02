package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
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
import android.util.SparseArray;
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
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public final class TextureMapView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static String i;
    public static int j;
    public static int k;
    public static final SparseArray<Integer> q;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public MapTextureView b;
    public BaiduMap c;
    public ImageView d;
    public Bitmap e;
    public com.baidu.mapsdkplatform.comapi.map.ad f;
    public Point g;
    public Point h;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context p;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
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

    public void setCustomStyleFilePathAndMode(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1616270047, "Lcom/baidu/mapapi/map/TextureMapView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1616270047, "Lcom/baidu/mapapi/map/TextureMapView;");
                return;
            }
        }
        a = TextureMapView.class.getSimpleName();
        j = 0;
        k = 0;
        SparseArray<Integer> sparseArray = new SparseArray<>();
        q = sparseArray;
        sparseArray.append(3, 2000000);
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureMapView(Context context) {
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
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) && bundle != null && (baiduMap = this.c) != null) {
            bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
            Point point = this.g;
            if (point != null) {
                bundle.putParcelable("scalePosition", point);
            }
            Point point2 = this.h;
            if (point2 != null) {
                bundle.putParcelable("zoomPosition", point2);
            }
            bundle.putBoolean("mZoomControlEnabled", this.t);
            bundle.putBoolean("mScaleControlEnabled", this.u);
            bundle.putInt("logoPosition", this.s);
            bundle.putInt("paddingLeft", this.v);
            bundle.putInt("paddingTop", this.x);
            bundle.putInt("paddingRight", this.w);
            bundle.putInt("paddingBottom", this.y);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureMapView(Context context, AttributeSet attributeSet) {
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
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, baiduMapOptions) == null) {
            setBackgroundColor(-1);
            this.p = context;
            com.baidu.mapsdkplatform.comapi.map.j.a();
            BMapManager.init();
            a(context, baiduMapOptions, i, k);
            a(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.h) {
                this.f.setVisibility(4);
            }
            c(context);
            if (baiduMapOptions != null && !baiduMapOptions.i) {
                this.l.setVisibility(4);
            }
            if (baiduMapOptions != null && (logoPosition = baiduMapOptions.j) != null) {
                this.s = logoPosition.ordinal();
            }
            if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
                this.h = point2;
            }
            if (baiduMapOptions != null && (point = baiduMapOptions.k) != null) {
                this.g = point;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
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
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, (BaiduMapOptions) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
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
        this.s = LogoPosition.logoPostionleftBottom.ordinal();
        this.t = true;
        this.u = true;
        this.B = false;
        a(context, baiduMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        MapTextureView mapTextureView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, this, str, str2) == null) && (mapTextureView = this.b) != null && mapTextureView.getBaseMap() != null) {
            if (TextUtils.isEmpty(str)) {
                Log.e(a, "customStyleFilePath is empty or null, please check!");
            } else if (!str.endsWith(".sty")) {
                Log.e(a, "customStyleFile format is incorrect , please check!");
            } else if (!new File(str).exists()) {
                Log.e(a, "customStyleFile does not exist , please check!");
            } else {
                this.b.getBaseMap().b(str, str2);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaiduMap baiduMap = this.c;
            baiduMap.b = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return q.get((int) this.b.getBaseMap().D().a).intValue();
        }
        return invokeV.intValue;
    }

    public Point getScaleControlPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Point) invokeV.objValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.onPause();
        }
    }

    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.onResume();
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
            if (densityDpi > 480) {
                Matrix matrix = new Matrix();
                matrix.postScale(2.0f, 2.0f);
                this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
            } else if (densityDpi > 320 && densityDpi <= 480) {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                this.e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix2, true);
            } else {
                this.e = a2;
            }
            if (this.e != null) {
                ImageView imageView = new ImageView(context);
                this.d = imageView;
                imageView.setImageBitmap(this.e);
                addView(this.d);
            }
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65545, this, context, baiduMapOptions, str, i2) == null) {
            MapTextureView mapTextureView = new MapTextureView(context);
            this.b = mapTextureView;
            addView(mapTextureView);
            if (baiduMapOptions != null) {
                this.c = new BaiduMap(context, this.b, baiduMapOptions.a());
            } else {
                this.c = new BaiduMap(context, this.b, (com.baidu.mapsdkplatform.comapi.map.v) null);
            }
            this.b.getBaseMap().a(new ab(this));
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
            int i2 = layoutParams.width;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            int i3 = layoutParams.height;
            if (i3 > 0) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = new com.baidu.mapsdkplatform.comapi.map.ad(context);
            this.f = adVar;
            if (!adVar.a()) {
                return;
            }
            this.f.b(new ac(this));
            this.f.a(new ad(this));
            addView(this.f);
        }
    }

    @Deprecated
    public static void setCustomMapStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            if (str != null && str.length() != 0) {
                if (new File(str).exists()) {
                    i = str;
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
    public static void setIconCustom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            k = i2;
        }
    }

    @Deprecated
    public static void setLoadCustomMapStyleFileMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i2) == null) {
            j = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, view2) != null) || view2 == this.d) {
            return;
        }
        if (c()) {
            super.removeView(view2);
        } else {
            com.baidu.platform.comapi.util.j.a(new ae(this, view2), 0L);
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, logoPosition) == null) {
            if (logoPosition == null) {
                this.s = LogoPosition.logoPostionleftBottom.ordinal();
            } else {
                this.s = logoPosition.ordinal();
            }
            requestLayout();
        }
    }

    public void setMapCustomStyleEnable(boolean z) {
        MapTextureView mapTextureView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || (mapTextureView = this.b) == null) {
            return;
        }
        mapTextureView.getBaseMap().p(z);
    }

    public void setMapCustomStylePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            a(str, "");
        }
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, point) == null) && point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, point) == null) && point != null && (i2 = point.x) >= 0 && point.y >= 0 && i2 <= getWidth() && point.y <= getHeight()) {
            this.h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            RelativeLayout relativeLayout = this.l;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            relativeLayout.setVisibility(i2);
            this.u = z;
        }
    }

    public void showZoomControls(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && this.f.a()) {
            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.f;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            adVar.setVisibility(i2);
            this.t = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.ad adVar;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && (adVar = this.f) != null && adVar.a()) {
            float f = this.b.getBaseMap().D().a;
            com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.f;
            boolean z2 = true;
            if (f > this.b.getBaseMap().b) {
                z = true;
            } else {
                z = false;
            }
            adVar2.b(z);
            com.baidu.mapsdkplatform.comapi.map.ad adVar3 = this.f;
            if (f >= this.b.getBaseMap().a) {
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
            this.o.setLayoutParams(layoutParams3);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
            byte[] ninePatchChunk = a2.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            this.o.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
            this.l.addView(this.o);
            addView(this.l);
        }
    }

    public final LogoPosition getLogoPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.s;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.p != null) {
                this.b.onDestroy();
            }
            Bitmap bitmap = this.e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.e.recycle();
            }
            this.f.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.j.b();
            this.p = null;
        }
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, context, bundle) != null) || bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.g != null) {
            this.g = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.h != null) {
            this.h = (Point) bundle.getParcelable("zoomPosition");
        }
        this.t = bundle.getBoolean("mZoomControlEnabled");
        this.u = bundle.getBoolean("mScaleControlEnabled");
        this.s = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f;
        Point point;
        int measuredHeight;
        int measuredWidth;
        int measuredWidth2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            a(this.d);
            float f2 = 1.0f;
            if (((getWidth() - this.v) - this.w) - this.d.getMeasuredWidth() > 0 && ((getHeight() - this.x) - this.y) - this.d.getMeasuredHeight() > 0) {
                f2 = ((getWidth() - this.v) - this.w) / getWidth();
                f = ((getHeight() - this.x) - this.y) / getHeight();
            } else {
                this.v = 0;
                this.w = 0;
                this.y = 0;
                this.x = 0;
                f = 1.0f;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    MapTextureView mapTextureView = this.b;
                    if (childAt == mapTextureView) {
                        mapTextureView.layout(0, 0, getWidth(), getHeight());
                    } else {
                        ImageView imageView = this.d;
                        if (childAt == imageView) {
                            float f3 = f2 * 5.0f;
                            int i7 = (int) (this.v + f3);
                            int i8 = (int) (this.w + f3);
                            float f4 = 5.0f * f;
                            int i9 = (int) (this.x + f4);
                            int i10 = (int) (this.y + f4);
                            int i11 = this.s;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    if (i11 != 3) {
                                        if (i11 != 4) {
                                            if (i11 != 5) {
                                                measuredHeight = getHeight() - i10;
                                                measuredWidth = this.d.getMeasuredWidth() + i7;
                                                i9 = measuredHeight - this.d.getMeasuredHeight();
                                            } else {
                                                measuredHeight = i9 + imageView.getMeasuredHeight();
                                                measuredWidth = getWidth() - i8;
                                                measuredWidth2 = this.d.getMeasuredWidth();
                                            }
                                        } else {
                                            measuredHeight = getHeight() - i10;
                                            i9 = measuredHeight - this.d.getMeasuredHeight();
                                            measuredWidth = getWidth() - i8;
                                            measuredWidth2 = this.d.getMeasuredWidth();
                                        }
                                        i7 = measuredWidth - measuredWidth2;
                                    } else {
                                        measuredHeight = i9 + imageView.getMeasuredHeight();
                                        i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                                        measuredWidth = (((getWidth() + this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                                    }
                                } else {
                                    measuredHeight = getHeight() - i10;
                                    i9 = measuredHeight - this.d.getMeasuredHeight();
                                    i7 = (((getWidth() - this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                                    measuredWidth = (((getWidth() + this.d.getMeasuredWidth()) + this.v) - this.w) / 2;
                                }
                            } else {
                                measuredHeight = imageView.getMeasuredHeight() + i9;
                                measuredWidth = this.d.getMeasuredWidth() + i7;
                            }
                            this.d.layout(i7, i9, measuredWidth, measuredHeight);
                        } else {
                            com.baidu.mapsdkplatform.comapi.map.ad adVar = this.f;
                            if (childAt == adVar) {
                                if (adVar.a()) {
                                    a(this.f);
                                    Point point2 = this.h;
                                    if (point2 == null) {
                                        int height = (int) (((getHeight() - 15) * f) + this.x);
                                        int width = (int) (((getWidth() - 15) * f2) + this.v);
                                        int measuredWidth3 = width - this.f.getMeasuredWidth();
                                        int measuredHeight2 = height - this.f.getMeasuredHeight();
                                        if (this.s == 4) {
                                            height -= this.d.getMeasuredHeight();
                                            measuredHeight2 -= this.d.getMeasuredHeight();
                                        }
                                        this.f.layout(measuredWidth3, measuredHeight2, width, height);
                                    } else {
                                        com.baidu.mapsdkplatform.comapi.map.ad adVar2 = this.f;
                                        int i12 = point2.x;
                                        adVar2.layout(i12, point2.y, adVar2.getMeasuredWidth() + i12, this.h.y + this.f.getMeasuredHeight());
                                    }
                                }
                            } else {
                                RelativeLayout relativeLayout = this.l;
                                if (childAt == relativeLayout) {
                                    a(relativeLayout);
                                    Point point3 = this.g;
                                    if (point3 == null) {
                                        this.A = this.l.getMeasuredWidth();
                                        this.z = this.l.getMeasuredHeight();
                                        int i13 = (int) (this.v + (5.0f * f2));
                                        int height2 = (getHeight() - ((int) ((this.y + (f * 5.0f)) + 56.0f))) - this.d.getMeasuredHeight();
                                        this.l.layout(i13, height2, this.A + i13, this.z + height2);
                                    } else {
                                        RelativeLayout relativeLayout2 = this.l;
                                        int i14 = point3.x;
                                        relativeLayout2.layout(i14, point3.y, relativeLayout2.getMeasuredWidth() + i14, this.g.y + this.l.getMeasuredHeight());
                                    }
                                } else {
                                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                    if (layoutParams instanceof MapViewLayoutParams) {
                                        MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                        if (mapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {
                                            point = mapViewLayoutParams.b;
                                        } else {
                                            GeoPoint ll2mc = CoordUtil.ll2mc(mapViewLayoutParams.a);
                                            if (this.b.getBaseMap() != null) {
                                                point = this.b.getBaseMap().a(ll2mc);
                                            } else {
                                                point = new Point();
                                            }
                                        }
                                        a(childAt);
                                        int measuredWidth4 = childAt.getMeasuredWidth();
                                        int measuredHeight3 = childAt.getMeasuredHeight();
                                        float f5 = mapViewLayoutParams.d;
                                        float f6 = mapViewLayoutParams.e;
                                        int i15 = (int) (point.x - (f5 * measuredWidth4));
                                        int i16 = ((int) (point.y - (f6 * measuredHeight3))) + mapViewLayoutParams.f;
                                        childAt.layout(i15, i16, measuredWidth4 + i15, measuredHeight3 + i16);
                                    }
                                }
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
            com.baidu.mapsdkplatform.comapi.map.f.a().a(this.p, customMapStyleId, new aa(this, customMapStyleCallBack, mapCustomStyleOptions));
            return;
        }
        String localCustomStyleFilePath = mapCustomStyleOptions.getLocalCustomStyleFilePath();
        if (localCustomStyleFilePath != null && !localCustomStyleFilePath.isEmpty()) {
            a(localCustomStyleFilePath, "");
        }
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i2, i3, i4, i5) == null) {
            this.v = i2;
            this.x = i3;
            this.w = i4;
            this.y = i5;
        }
    }
}
