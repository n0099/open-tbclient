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
    public ImageView f37064b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37065c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f37066d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f37067e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f37068f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f37069g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f37070h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f37071i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f37072j;

    /* renamed from: k  reason: collision with root package name */
    public Bitmap f37073k;
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
        this.f37065c = context;
        c();
        if (this.f37066d == null || this.f37067e == null || this.f37068f == null || this.f37069g == null) {
            return;
        }
        this.a = new ImageView(this.f37065c);
        this.f37064b = new ImageView(this.f37065c);
        this.a.setImageBitmap(this.f37066d);
        this.f37064b.setImageBitmap(this.f37068f);
        this.l = a(this.f37068f.getHeight() / 6);
        a(this.a, "main_topbtn_up.9.png");
        a(this.f37064b, "main_bottombtn_up.9.png");
        this.a.setId(0);
        this.f37064b.setId(1);
        this.a.setClickable(true);
        this.f37064b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f37064b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.a);
        addView(this.f37064b);
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
        this.f37065c = context;
        this.m = z;
        this.a = new ImageView(this.f37065c);
        this.f37064b = new ImageView(this.f37065c);
        if (z) {
            d();
            if (this.f37070h == null || this.f37071i == null || this.f37072j == null || this.f37073k == null) {
                return;
            }
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f37064b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.a.setImageBitmap(this.f37070h);
            this.f37064b.setImageBitmap(this.f37072j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f37066d;
            if (bitmap == null || this.f37067e == null || this.f37068f == null || this.f37069g == null) {
                return;
            }
            this.a.setImageBitmap(bitmap);
            this.f37064b.setImageBitmap(this.f37068f);
            this.l = a(this.f37068f.getHeight() / 6);
            a(this.a, "main_topbtn_up.9.png");
            a(this.f37064b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.a.setId(0);
        this.f37064b.setId(1);
        this.a.setClickable(true);
        this.f37064b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.f37064b.setOnTouchListener(this);
        addView(this.a);
        addView(this.f37064b);
        this.n = true;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? (int) ((this.f37065c.getResources().getDisplayMetrics().density * i2) + 0.5f) : invokeI.intValue;
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
            matrix.postScale(f2, f2);
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f37065c);
            return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, str) == null) {
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f37065c);
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
            this.f37066d = a("main_icon_zoomin.png");
            this.f37067e = a("main_icon_zoomin_dis.png");
            this.f37068f = a("main_icon_zoomout.png");
            this.f37069g = a("main_icon_zoomout_dis.png");
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.f37070h = a("wear_zoom_in.png");
            this.f37071i = a("wear_zoom_in_pressed.png");
            this.f37072j = a("wear_zoon_out.png");
            this.f37073k = a("wear_zoom_out_pressed.png");
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
                bitmap = this.f37066d;
            } else {
                imageView = this.a;
                bitmap = this.f37067e;
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
            Bitmap bitmap = this.f37066d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f37066d.recycle();
                this.f37066d = null;
            }
            Bitmap bitmap2 = this.f37067e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f37067e.recycle();
                this.f37067e = null;
            }
            Bitmap bitmap3 = this.f37068f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f37068f.recycle();
                this.f37068f = null;
            }
            Bitmap bitmap4 = this.f37069g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.f37069g.recycle();
                this.f37069g = null;
            }
            Bitmap bitmap5 = this.f37070h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.f37070h.recycle();
                this.f37070h = null;
            }
            Bitmap bitmap6 = this.f37071i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.f37071i.recycle();
                this.f37071i = null;
            }
            Bitmap bitmap7 = this.f37072j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.f37072j.recycle();
                this.f37072j = null;
            }
            Bitmap bitmap8 = this.f37073k;
            if (bitmap8 == null || bitmap8.isRecycled()) {
                return;
            }
            this.f37073k.recycle();
            this.f37073k = null;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f37064b.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f37064b.setEnabled(z);
            if (z) {
                imageView = this.f37064b;
                bitmap = this.f37068f;
            } else {
                imageView = this.f37064b;
                bitmap = this.f37069g;
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
                            bitmap = this.f37071i;
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
                            bitmap = this.f37070h;
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
                            imageView = this.f37064b;
                            bitmap = this.f37073k;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f37064b;
                        str = "main_bottombtn_down.9.png";
                        a(imageView2, str);
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            imageView = this.f37064b;
                            bitmap = this.f37072j;
                            imageView.setImageBitmap(bitmap);
                            return false;
                        }
                        imageView2 = this.f37064b;
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
