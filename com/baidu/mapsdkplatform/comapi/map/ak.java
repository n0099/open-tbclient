package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ak extends LinearLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36419b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36420c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f36421d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f36422e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f36423f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f36424g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f36425h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f36426i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f36427j;

    /* renamed from: k  reason: collision with root package name */
    public Bitmap f36428k;
    public int l;
    public boolean m;
    public boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public ak(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = false;
        this.f36420c = context;
        c();
        if (this.f36421d == null || this.f36422e == null || this.f36423f == null || this.f36424g == null) {
            return;
        }
        this.a = new ImageView(this.f36420c);
        this.f36419b = new ImageView(this.f36420c);
        this.a.setImageBitmap(this.f36421d);
        this.f36419b.setImageBitmap(this.f36423f);
        this.l = a(this.f36423f.getHeight() / 6);
        a(this.a, "main_topbtn_up.9.png");
        a(this.f36419b, "main_bottombtn_up.9.png");
        this.a.setId(0);
        this.f36419b.setId(1);
        this.a.setClickable(true);
        this.f36419b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f36419b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.a);
        addView(this.f36419b);
        this.n = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.m = false;
        this.n = false;
        this.f36420c = context;
        this.m = z;
        this.a = new ImageView(this.f36420c);
        this.f36419b = new ImageView(this.f36420c);
        if (z) {
            d();
            if (this.f36425h == null || this.f36426i == null || this.f36427j == null || this.f36428k == null) {
                return;
            }
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f36419b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.a.setImageBitmap(this.f36425h);
            this.f36419b.setImageBitmap(this.f36427j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f36421d;
            if (bitmap == null || this.f36422e == null || this.f36423f == null || this.f36424g == null) {
                return;
            }
            this.a.setImageBitmap(bitmap);
            this.f36419b.setImageBitmap(this.f36423f);
            this.l = a(this.f36423f.getHeight() / 6);
            a(this.a, "main_topbtn_up.9.png");
            a(this.f36419b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.a.setId(0);
        this.f36419b.setId(1);
        this.a.setClickable(true);
        this.f36419b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f36419b.setOnTouchListener(this);
        addView(this.a);
        addView(this.f36419b);
        this.n = true;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((this.f36420c.getResources().getDisplayMetrics().density * i2) + 0.5f) : invokeI.intValue;
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
            matrix.postScale(f2, f2);
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f36420c);
            return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, str) == null) {
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f36420c);
            byte[] ninePatchChunk = a.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            view.setBackgroundDrawable(new NinePatchDrawable(a, ninePatchChunk, new Rect(), null));
            int i2 = this.l;
            view.setPadding(i2, i2, i2, i2);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f36421d = a("main_icon_zoomin.png");
            this.f36422e = a("main_icon_zoomin_dis.png");
            this.f36423f = a("main_icon_zoomout.png");
            this.f36424g = a("main_icon_zoomout_dis.png");
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f36425h = a("wear_zoom_in.png");
            this.f36426i = a("wear_zoom_in_pressed.png");
            this.f36427j = a("wear_zoon_out.png");
            this.f36428k = a("wear_zoom_out_pressed.png");
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.a.setEnabled(z);
            if (z) {
                imageView = this.a;
                bitmap = this.f36421d;
            } else {
                imageView = this.a;
                bitmap = this.f36422e;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Bitmap bitmap = this.f36421d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f36421d.recycle();
                this.f36421d = null;
            }
            Bitmap bitmap2 = this.f36422e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f36422e.recycle();
                this.f36422e = null;
            }
            Bitmap bitmap3 = this.f36423f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f36423f.recycle();
                this.f36423f = null;
            }
            Bitmap bitmap4 = this.f36424g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.f36424g.recycle();
                this.f36424g = null;
            }
            Bitmap bitmap5 = this.f36425h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.f36425h.recycle();
                this.f36425h = null;
            }
            Bitmap bitmap6 = this.f36426i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.f36426i.recycle();
                this.f36426i = null;
            }
            Bitmap bitmap7 = this.f36427j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.f36427j.recycle();
                this.f36427j = null;
            }
            Bitmap bitmap8 = this.f36428k;
            if (bitmap8 == null || bitmap8.isRecycled()) {
                return;
            }
            this.f36428k.recycle();
            this.f36428k = null;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f36419b.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f36419b.setEnabled(z);
            if (z) {
                imageView = this.f36419b;
                bitmap = this.f36423f;
            } else {
                imageView = this.f36419b;
                bitmap = this.f36424g;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, motionEvent)) == null) {
            if (view instanceof ImageView) {
                int id = ((ImageView) view).getId();
                if (id == 0) {
                    if (motionEvent.getAction() == 0) {
                        if (this.m) {
                            imageView = this.a;
                            bitmap = this.f36426i;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.a;
                        str = "main_topbtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.a;
                            bitmap = this.f36425h;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.a;
                        str = "main_topbtn_up.9.png";
                        a(imageView2, str);
                        return false;
                    } else {
                        return false;
                    }
                } else if (id != 1) {
                    return false;
                } else {
                    if (motionEvent.getAction() == 0) {
                        if (this.m) {
                            imageView = this.f36419b;
                            bitmap = this.f36428k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f36419b;
                        str = "main_bottombtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f36419b;
                            bitmap = this.f36427j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f36419b;
                        str = "main_bottombtn_up.9.png";
                        a(imageView2, str);
                        return false;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
