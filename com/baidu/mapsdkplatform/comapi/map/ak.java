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
/* loaded from: classes10.dex */
public class ak extends LinearLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f36908b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36909c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f36910d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f36911e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f36912f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f36913g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f36914h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f36915i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f36916j;

    /* renamed from: k  reason: collision with root package name */
    public Bitmap f36917k;
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
        this.f36909c = context;
        c();
        if (this.f36910d == null || this.f36911e == null || this.f36912f == null || this.f36913g == null) {
            return;
        }
        this.a = new ImageView(this.f36909c);
        this.f36908b = new ImageView(this.f36909c);
        this.a.setImageBitmap(this.f36910d);
        this.f36908b.setImageBitmap(this.f36912f);
        this.l = a(this.f36912f.getHeight() / 6);
        a(this.a, "main_topbtn_up.9.png");
        a(this.f36908b, "main_bottombtn_up.9.png");
        this.a.setId(0);
        this.f36908b.setId(1);
        this.a.setClickable(true);
        this.f36908b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f36908b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.a);
        addView(this.f36908b);
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
        this.f36909c = context;
        this.m = z;
        this.a = new ImageView(this.f36909c);
        this.f36908b = new ImageView(this.f36909c);
        if (z) {
            d();
            if (this.f36914h == null || this.f36915i == null || this.f36916j == null || this.f36917k == null) {
                return;
            }
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f36908b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.a.setImageBitmap(this.f36914h);
            this.f36908b.setImageBitmap(this.f36916j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f36910d;
            if (bitmap == null || this.f36911e == null || this.f36912f == null || this.f36913g == null) {
                return;
            }
            this.a.setImageBitmap(bitmap);
            this.f36908b.setImageBitmap(this.f36912f);
            this.l = a(this.f36912f.getHeight() / 6);
            a(this.a, "main_topbtn_up.9.png");
            a(this.f36908b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.a.setId(0);
        this.f36908b.setId(1);
        this.a.setClickable(true);
        this.f36908b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f36908b.setOnTouchListener(this);
        addView(this.a);
        addView(this.f36908b);
        this.n = true;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((this.f36909c.getResources().getDisplayMetrics().density * i2) + 0.5f) : invokeI.intValue;
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
            matrix.postScale(f2, f2);
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f36909c);
            return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, str) == null) {
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f36909c);
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
            this.f36910d = a("main_icon_zoomin.png");
            this.f36911e = a("main_icon_zoomin_dis.png");
            this.f36912f = a("main_icon_zoomout.png");
            this.f36913g = a("main_icon_zoomout_dis.png");
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f36914h = a("wear_zoom_in.png");
            this.f36915i = a("wear_zoom_in_pressed.png");
            this.f36916j = a("wear_zoon_out.png");
            this.f36917k = a("wear_zoom_out_pressed.png");
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
                bitmap = this.f36910d;
            } else {
                imageView = this.a;
                bitmap = this.f36911e;
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
            Bitmap bitmap = this.f36910d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f36910d.recycle();
                this.f36910d = null;
            }
            Bitmap bitmap2 = this.f36911e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f36911e.recycle();
                this.f36911e = null;
            }
            Bitmap bitmap3 = this.f36912f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f36912f.recycle();
                this.f36912f = null;
            }
            Bitmap bitmap4 = this.f36913g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.f36913g.recycle();
                this.f36913g = null;
            }
            Bitmap bitmap5 = this.f36914h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.f36914h.recycle();
                this.f36914h = null;
            }
            Bitmap bitmap6 = this.f36915i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.f36915i.recycle();
                this.f36915i = null;
            }
            Bitmap bitmap7 = this.f36916j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.f36916j.recycle();
                this.f36916j = null;
            }
            Bitmap bitmap8 = this.f36917k;
            if (bitmap8 == null || bitmap8.isRecycled()) {
                return;
            }
            this.f36917k.recycle();
            this.f36917k = null;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f36908b.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f36908b.setEnabled(z);
            if (z) {
                imageView = this.f36908b;
                bitmap = this.f36912f;
            } else {
                imageView = this.f36908b;
                bitmap = this.f36913g;
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
                            bitmap = this.f36915i;
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
                            bitmap = this.f36914h;
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
                            imageView = this.f36908b;
                            bitmap = this.f36917k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f36908b;
                        str = "main_bottombtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f36908b;
                            bitmap = this.f36916j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f36908b;
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
