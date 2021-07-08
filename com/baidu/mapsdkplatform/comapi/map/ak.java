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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ak extends LinearLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f7694a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7695b;

    /* renamed from: c  reason: collision with root package name */
    public Context f7696c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7697d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f7698e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f7699f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f7700g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f7701h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f7702i;
    public Bitmap j;
    public Bitmap k;
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
        this.f7696c = context;
        c();
        if (this.f7697d == null || this.f7698e == null || this.f7699f == null || this.f7700g == null) {
            return;
        }
        this.f7694a = new ImageView(this.f7696c);
        this.f7695b = new ImageView(this.f7696c);
        this.f7694a.setImageBitmap(this.f7697d);
        this.f7695b.setImageBitmap(this.f7699f);
        this.l = a(this.f7699f.getHeight() / 6);
        a(this.f7694a, "main_topbtn_up.9.png");
        a(this.f7695b, "main_bottombtn_up.9.png");
        this.f7694a.setId(0);
        this.f7695b.setId(1);
        this.f7694a.setClickable(true);
        this.f7695b.setClickable(true);
        this.f7694a.setOnTouchListener(this);
        this.f7695b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f7694a);
        addView(this.f7695b);
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
        this.f7696c = context;
        this.m = z;
        this.f7694a = new ImageView(this.f7696c);
        this.f7695b = new ImageView(this.f7696c);
        if (z) {
            d();
            if (this.f7701h == null || this.f7702i == null || this.j == null || this.k == null) {
                return;
            }
            this.f7694a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7695b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7694a.setImageBitmap(this.f7701h);
            this.f7695b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f7697d;
            if (bitmap == null || this.f7698e == null || this.f7699f == null || this.f7700g == null) {
                return;
            }
            this.f7694a.setImageBitmap(bitmap);
            this.f7695b.setImageBitmap(this.f7699f);
            this.l = a(this.f7699f.getHeight() / 6);
            a(this.f7694a, "main_topbtn_up.9.png");
            a(this.f7695b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f7694a.setId(0);
        this.f7695b.setId(1);
        this.f7694a.setClickable(true);
        this.f7695b.setClickable(true);
        this.f7694a.setOnTouchListener(this);
        this.f7695b.setOnTouchListener(this);
        addView(this.f7694a);
        addView(this.f7695b);
        this.n = true;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((this.f7696c.getResources().getDisplayMetrics().density * i2) + 0.5f) : invokeI.intValue;
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
            matrix.postScale(f2, f2);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7696c);
            return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, str) == null) {
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7696c);
            byte[] ninePatchChunk = a2.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            view.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
            int i2 = this.l;
            view.setPadding(i2, i2, i2, i2);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f7697d = a("main_icon_zoomin.png");
            this.f7698e = a("main_icon_zoomin_dis.png");
            this.f7699f = a("main_icon_zoomout.png");
            this.f7700g = a("main_icon_zoomout_dis.png");
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f7701h = a("wear_zoom_in.png");
            this.f7702i = a("wear_zoom_in_pressed.png");
            this.j = a("wear_zoon_out.png");
            this.k = a("wear_zoom_out_pressed.png");
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f7694a.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f7694a.setEnabled(z);
            if (z) {
                imageView = this.f7694a;
                bitmap = this.f7697d;
            } else {
                imageView = this.f7694a;
                bitmap = this.f7698e;
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
            Bitmap bitmap = this.f7697d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f7697d.recycle();
                this.f7697d = null;
            }
            Bitmap bitmap2 = this.f7698e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f7698e.recycle();
                this.f7698e = null;
            }
            Bitmap bitmap3 = this.f7699f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f7699f.recycle();
                this.f7699f = null;
            }
            Bitmap bitmap4 = this.f7700g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.f7700g.recycle();
                this.f7700g = null;
            }
            Bitmap bitmap5 = this.f7701h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.f7701h.recycle();
                this.f7701h = null;
            }
            Bitmap bitmap6 = this.f7702i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.f7702i.recycle();
                this.f7702i = null;
            }
            Bitmap bitmap7 = this.j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.j.recycle();
                this.j = null;
            }
            Bitmap bitmap8 = this.k;
            if (bitmap8 == null || bitmap8.isRecycled()) {
                return;
            }
            this.k.recycle();
            this.k = null;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f7695b.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f7695b.setEnabled(z);
            if (z) {
                imageView = this.f7695b;
                bitmap = this.f7699f;
            } else {
                imageView = this.f7695b;
                bitmap = this.f7700g;
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
                            imageView = this.f7694a;
                            bitmap = this.f7702i;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f7694a;
                        str = "main_topbtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f7694a;
                            bitmap = this.f7701h;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f7694a;
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
                            imageView = this.f7695b;
                            bitmap = this.k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f7695b;
                        str = "main_bottombtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f7695b;
                            bitmap = this.j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f7695b;
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
