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
/* loaded from: classes5.dex */
public class ak extends LinearLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f42208a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f42209b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42210c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f42211d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f42212e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f42213f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f42214g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f42215h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f42216i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f42217j;
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
        this.f42210c = context;
        c();
        if (this.f42211d == null || this.f42212e == null || this.f42213f == null || this.f42214g == null) {
            return;
        }
        this.f42208a = new ImageView(this.f42210c);
        this.f42209b = new ImageView(this.f42210c);
        this.f42208a.setImageBitmap(this.f42211d);
        this.f42209b.setImageBitmap(this.f42213f);
        this.l = a(this.f42213f.getHeight() / 6);
        a(this.f42208a, "main_topbtn_up.9.png");
        a(this.f42209b, "main_bottombtn_up.9.png");
        this.f42208a.setId(0);
        this.f42209b.setId(1);
        this.f42208a.setClickable(true);
        this.f42209b.setClickable(true);
        this.f42208a.setOnTouchListener(this);
        this.f42209b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f42208a);
        addView(this.f42209b);
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
        this.f42210c = context;
        this.m = z;
        this.f42208a = new ImageView(this.f42210c);
        this.f42209b = new ImageView(this.f42210c);
        if (z) {
            d();
            if (this.f42215h == null || this.f42216i == null || this.f42217j == null || this.k == null) {
                return;
            }
            this.f42208a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f42209b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f42208a.setImageBitmap(this.f42215h);
            this.f42209b.setImageBitmap(this.f42217j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f42211d;
            if (bitmap == null || this.f42212e == null || this.f42213f == null || this.f42214g == null) {
                return;
            }
            this.f42208a.setImageBitmap(bitmap);
            this.f42209b.setImageBitmap(this.f42213f);
            this.l = a(this.f42213f.getHeight() / 6);
            a(this.f42208a, "main_topbtn_up.9.png");
            a(this.f42209b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f42208a.setId(0);
        this.f42209b.setId(1);
        this.f42208a.setClickable(true);
        this.f42209b.setClickable(true);
        this.f42208a.setOnTouchListener(this);
        this.f42209b.setOnTouchListener(this);
        addView(this.f42208a);
        addView(this.f42209b);
        this.n = true;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((this.f42210c.getResources().getDisplayMetrics().density * i2) + 0.5f) : invokeI.intValue;
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
            matrix.postScale(f2, f2);
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f42210c);
            return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, str) == null) {
            Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f42210c);
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
            this.f42211d = a("main_icon_zoomin.png");
            this.f42212e = a("main_icon_zoomin_dis.png");
            this.f42213f = a("main_icon_zoomout.png");
            this.f42214g = a("main_icon_zoomout_dis.png");
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f42215h = a("wear_zoom_in.png");
            this.f42216i = a("wear_zoom_in_pressed.png");
            this.f42217j = a("wear_zoon_out.png");
            this.k = a("wear_zoom_out_pressed.png");
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f42208a.setOnClickListener(onClickListener);
        }
    }

    public void a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f42208a.setEnabled(z);
            if (z) {
                imageView = this.f42208a;
                bitmap = this.f42211d;
            } else {
                imageView = this.f42208a;
                bitmap = this.f42212e;
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
            Bitmap bitmap = this.f42211d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f42211d.recycle();
                this.f42211d = null;
            }
            Bitmap bitmap2 = this.f42212e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f42212e.recycle();
                this.f42212e = null;
            }
            Bitmap bitmap3 = this.f42213f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f42213f.recycle();
                this.f42213f = null;
            }
            Bitmap bitmap4 = this.f42214g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.f42214g.recycle();
                this.f42214g = null;
            }
            Bitmap bitmap5 = this.f42215h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.f42215h.recycle();
                this.f42215h = null;
            }
            Bitmap bitmap6 = this.f42216i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.f42216i.recycle();
                this.f42216i = null;
            }
            Bitmap bitmap7 = this.f42217j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.f42217j.recycle();
                this.f42217j = null;
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
            this.f42209b.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f42209b.setEnabled(z);
            if (z) {
                imageView = this.f42209b;
                bitmap = this.f42213f;
            } else {
                imageView = this.f42209b;
                bitmap = this.f42214g;
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
                            imageView = this.f42208a;
                            bitmap = this.f42216i;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f42208a;
                        str = "main_topbtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f42208a;
                            bitmap = this.f42215h;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f42208a;
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
                            imageView = this.f42209b;
                            bitmap = this.k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f42209b;
                        str = "main_bottombtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f42209b;
                            bitmap = this.f42217j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f42209b;
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
