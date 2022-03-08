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
import android.util.AttributeSet;
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
import com.baidu.mapsdkplatform.comapi.map.ac;
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
/* loaded from: classes4.dex */
public final class TextureMapView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: i  reason: collision with root package name */
    public static String f34057i;

    /* renamed from: j  reason: collision with root package name */
    public static int f34058j;
    public static int k;
    public static final SparseArray<Integer> q;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;

    /* renamed from: b  reason: collision with root package name */
    public ac f34059b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduMap f34060c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f34061d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f34062e;

    /* renamed from: f  reason: collision with root package name */
    public ak f34063f;

    /* renamed from: g  reason: collision with root package name */
    public Point f34064g;

    /* renamed from: h  reason: collision with root package name */
    public Point f34065h;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public Context p;
    public float r;
    public com.baidu.mapsdkplatform.comapi.map.l s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

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
        f34058j = 0;
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
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        a(context, (BaiduMapOptions) null);
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
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
        a(context, (BaiduMapOptions) null);
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
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
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
        this.t = LogoPosition.logoPostionleftBottom.ordinal();
        this.u = true;
        this.v = true;
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
            this.f34062e = a2;
            if (this.f34062e == null) {
                ImageView imageView = new ImageView(context);
                this.f34061d = imageView;
                imageView.setImageBitmap(this.f34062e);
                addView(this.f34061d);
                return;
            }
            return;
        } else {
            matrix = new Matrix();
            f2 = 1.5f;
        }
        matrix.postScale(f2, f2);
        this.f34062e = Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        if (this.f34062e == null) {
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        Point point;
        Point point2;
        LogoPosition logoPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, baiduMapOptions) == null) {
            setBackgroundColor(-1);
            this.p = context;
            com.baidu.mapsdkplatform.comapi.map.i.a();
            BMapManager.init();
            a(context, baiduMapOptions, f34058j == 0 ? f34057i : CustomMapStyleLoader.getCustomStyleFilePath(), k);
            this.f34060c = new BaiduMap(this.f34059b);
            a(context);
            b(context);
            if (baiduMapOptions != null && !baiduMapOptions.f33864h) {
                this.f34063f.setVisibility(4);
            }
            c(context);
            if (baiduMapOptions != null && !baiduMapOptions.f33865i) {
                this.l.setVisibility(4);
            }
            if (baiduMapOptions != null && (logoPosition = baiduMapOptions.f33866j) != null) {
                this.t = logoPosition.ordinal();
            }
            if (baiduMapOptions != null && (point2 = baiduMapOptions.l) != null) {
                this.f34065h = point2;
            }
            if (baiduMapOptions == null || (point = baiduMapOptions.k) == null) {
                return;
            }
            this.f34064g = point;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65546, this, context, baiduMapOptions, str, i2) == null) {
            if (baiduMapOptions == null) {
                this.f34059b = new ac(context, null, str, i2);
            } else {
                this.f34059b = new ac(context, baiduMapOptions.a(), str, i2);
            }
            addView(this.f34059b);
            this.s = new t(this);
            this.f34059b.b().a(this.s);
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
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f34063f.a()) {
            float f2 = this.f34059b.b().E().a;
            this.f34063f.b(f2 > this.f34059b.b().f34496b);
            this.f34063f.a(f2 < this.f34059b.b().a);
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            ak akVar = new ak(context);
            this.f34063f = akVar;
            if (akVar.a()) {
                this.f34063f.b(new u(this));
                this.f34063f.a(new v(this));
                addView(this.f34063f);
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
            f34057i = str;
        }
    }

    @Deprecated
    public static void setIconCustom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, null, i2) == null) {
            k = i2;
        }
    }

    public static void setLoadCustomMapStyleFileMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            f34058j = i2;
        }
    }

    @Deprecated
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

    public final LogoPosition getLogoPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.t;
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? LogoPosition.logoPostionleftBottom : LogoPosition.logoPostionRightTop : LogoPosition.logoPostionRightBottom : LogoPosition.logoPostionCenterTop : LogoPosition.logoPostionCenterBottom : LogoPosition.logoPostionleftTop;
        }
        return (LogoPosition) invokeV.objValue;
    }

    public final BaiduMap getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaiduMap baiduMap = this.f34060c;
            baiduMap.f33850b = this;
            return baiduMap;
        }
        return (BaiduMap) invokeV.objValue;
    }

    public final int getMapLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q.get((int) this.f34059b.b().E().a).intValue() : invokeV.intValue;
    }

    public int getScaleControlViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : invokeV.intValue;
    }

    public int getScaleControlViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B : invokeV.intValue;
    }

    public void onCreate(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, context, bundle) == null) || bundle == null) {
            return;
        }
        MapStatus mapStatus = (MapStatus) bundle.getParcelable("mapstatus");
        if (this.f34064g != null) {
            this.f34064g = (Point) bundle.getParcelable("scalePosition");
        }
        if (this.f34065h != null) {
            this.f34065h = (Point) bundle.getParcelable("zoomPosition");
        }
        this.u = bundle.getBoolean("mZoomControlEnabled");
        this.v = bundle.getBoolean("mScaleControlEnabled");
        this.t = bundle.getInt("logoPosition");
        setPadding(bundle.getInt("paddingLeft"), bundle.getInt("paddingTop"), bundle.getInt("paddingRight"), bundle.getInt("paddingBottom"));
        a(context, new BaiduMapOptions().mapStatus(mapStatus));
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.p;
            if (context != null) {
                this.f34059b.a(context.hashCode());
            }
            Bitmap bitmap = this.f34062e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f34062e.recycle();
            }
            this.f34063f.b();
            BMapManager.destroy();
            com.baidu.mapsdkplatform.comapi.map.i.b();
            this.p = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int measuredHeight;
        int measuredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            a(this.f34061d);
            float f3 = 1.0f;
            if (((getWidth() - this.w) - this.x) - this.f34061d.getMeasuredWidth() <= 0 || ((getHeight() - this.y) - this.z) - this.f34061d.getMeasuredHeight() <= 0) {
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
                ac acVar = this.f34059b;
                if (childAt == acVar) {
                    acVar.layout(0, 0, getWidth(), getHeight());
                } else {
                    ImageView imageView = this.f34061d;
                    if (childAt == imageView) {
                        float f4 = f3 * 5.0f;
                        int i7 = (int) (this.w + f4);
                        int i8 = (int) (this.x + f4);
                        float f5 = 5.0f * f2;
                        int i9 = (int) (this.y + f5);
                        int i10 = (int) (this.z + f5);
                        int i11 = this.t;
                        if (i11 != 1) {
                            if (i11 == 2) {
                                measuredHeight = getHeight() - i10;
                                i9 = measuredHeight - this.f34061d.getMeasuredHeight();
                            } else if (i11 != 3) {
                                if (i11 == 4) {
                                    measuredHeight = getHeight() - i10;
                                    i9 = measuredHeight - this.f34061d.getMeasuredHeight();
                                } else if (i11 != 5) {
                                    measuredHeight = getHeight() - i10;
                                    measuredWidth = this.f34061d.getMeasuredWidth() + i7;
                                    i9 = measuredHeight - this.f34061d.getMeasuredHeight();
                                } else {
                                    measuredHeight = i9 + imageView.getMeasuredHeight();
                                }
                                measuredWidth = getWidth() - i8;
                                i7 = measuredWidth - this.f34061d.getMeasuredWidth();
                            } else {
                                measuredHeight = i9 + imageView.getMeasuredHeight();
                            }
                            i7 = (((getWidth() - this.f34061d.getMeasuredWidth()) + this.w) - this.x) / 2;
                            measuredWidth = (((getWidth() + this.f34061d.getMeasuredWidth()) + this.w) - this.x) / 2;
                        } else {
                            measuredHeight = imageView.getMeasuredHeight() + i9;
                            measuredWidth = this.f34061d.getMeasuredWidth() + i7;
                        }
                        this.f34061d.layout(i7, i9, measuredWidth, measuredHeight);
                    } else {
                        ak akVar = this.f34063f;
                        if (childAt != akVar) {
                            RelativeLayout relativeLayout = this.l;
                            if (childAt == relativeLayout) {
                                a(relativeLayout);
                                Point point = this.f34064g;
                                if (point == null) {
                                    this.B = this.l.getMeasuredWidth();
                                    this.A = this.l.getMeasuredHeight();
                                    int i12 = (int) (this.w + (5.0f * f3));
                                    int height = (getHeight() - ((int) ((this.z + (f2 * 5.0f)) + 56.0f))) - this.f34061d.getMeasuredHeight();
                                    this.l.layout(i12, height, this.B + i12, this.A + height);
                                } else {
                                    RelativeLayout relativeLayout2 = this.l;
                                    int i13 = point.x;
                                    relativeLayout2.layout(i13, point.y, relativeLayout2.getMeasuredWidth() + i13, this.f34064g.y + this.l.getMeasuredHeight());
                                }
                            } else {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof MapViewLayoutParams) {
                                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                                    Point a2 = mapViewLayoutParams.f33967c == MapViewLayoutParams.ELayoutMode.absoluteMode ? mapViewLayoutParams.f33966b : this.f34059b.b().a(CoordUtil.ll2mc(mapViewLayoutParams.a));
                                    a(childAt);
                                    int measuredWidth2 = childAt.getMeasuredWidth();
                                    int measuredHeight2 = childAt.getMeasuredHeight();
                                    float f6 = mapViewLayoutParams.f33968d;
                                    float f7 = mapViewLayoutParams.f33969e;
                                    int i14 = (int) (a2.x - (f6 * measuredWidth2));
                                    int i15 = ((int) (a2.y - (f7 * measuredHeight2))) + mapViewLayoutParams.f33970f;
                                    childAt.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
                                }
                            }
                        } else if (akVar.a()) {
                            a(this.f34063f);
                            Point point2 = this.f34065h;
                            if (point2 == null) {
                                int height2 = (int) (((getHeight() - 15) * f2) + this.y);
                                int width = (int) (((getWidth() - 15) * f3) + this.w);
                                int measuredWidth3 = width - this.f34063f.getMeasuredWidth();
                                int measuredHeight3 = height2 - this.f34063f.getMeasuredHeight();
                                if (this.t == 4) {
                                    height2 -= this.f34061d.getMeasuredHeight();
                                    measuredHeight3 -= this.f34061d.getMeasuredHeight();
                                }
                                this.f34063f.layout(measuredWidth3, measuredHeight3, width, height2);
                            } else {
                                ak akVar2 = this.f34063f;
                                int i16 = point2.x;
                                akVar2.layout(i16, point2.y, akVar2.getMeasuredWidth() + i16, this.f34065h.y + this.f34063f.getMeasuredHeight());
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f34059b.d();
        }
    }

    public final void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f34059b.c();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaiduMap baiduMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || bundle == null || (baiduMap = this.f34060c) == null) {
            return;
        }
        bundle.putParcelable("mapstatus", baiduMap.getMapStatus());
        Point point = this.f34064g;
        if (point != null) {
            bundle.putParcelable("scalePosition", point);
        }
        Point point2 = this.f34065h;
        if (point2 != null) {
            bundle.putParcelable("zoomPosition", point2);
        }
        bundle.putBoolean("mZoomControlEnabled", this.u);
        bundle.putBoolean("mScaleControlEnabled", this.v);
        bundle.putInt("logoPosition", this.t);
        bundle.putInt("paddingLeft", this.w);
        bundle.putInt("paddingTop", this.y);
        bundle.putInt("paddingRight", this.x);
        bundle.putInt("paddingBottom", this.z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, view) == null) || view == this.f34061d) {
            return;
        }
        super.removeView(view);
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, logoPosition) == null) {
            if (logoPosition == null) {
                logoPosition = LogoPosition.logoPostionleftBottom;
            }
            this.t = logoPosition.ordinal();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i2, i3, i4, i5) == null) {
            this.w = i2;
            this.y = i3;
            this.x = i4;
            this.z = i5;
        }
    }

    public void setScaleControlPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
            return;
        }
        this.f34064g = point;
        requestLayout();
    }

    public void setZoomControlsPosition(Point point) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, point) == null) || point == null || (i2 = point.x) < 0 || point.y < 0 || i2 > getWidth() || point.y > getHeight()) {
            return;
        }
        this.f34065h = point;
        requestLayout();
    }

    public void showScaleControl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l.setVisibility(z ? 0 : 8);
            this.v = z;
        }
    }

    public void showZoomControls(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.f34063f.a()) {
            this.f34063f.setVisibility(z ? 0 : 8);
            this.u = z;
        }
    }
}
