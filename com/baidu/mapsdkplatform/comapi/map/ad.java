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
/* loaded from: classes3.dex */
public class ad extends LinearLayout implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public Context c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    public Bitmap g;
    public Bitmap h;
    public Bitmap i;
    public Bitmap j;
    public Bitmap k;
    public int l;
    public boolean m;
    public boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public ad(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = false;
        this.c = context;
        c();
        if (this.d != null && this.e != null && this.f != null && this.g != null) {
            this.a = new ImageView(this.c);
            this.b = new ImageView(this.c);
            this.a.setImageBitmap(this.d);
            this.b.setImageBitmap(this.f);
            this.l = a(this.f.getHeight() / 6);
            a(this.a, "main_topbtn_up.9.png");
            a(this.b, "main_bottombtn_up.9.png");
            this.a.setId(0);
            this.b.setId(1);
            this.a.setClickable(true);
            this.b.setClickable(true);
            this.a.setOnTouchListener(this);
            this.b.setOnTouchListener(this);
            setOrientation(1);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            addView(this.a);
            addView(this.b);
            this.n = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.m = false;
        this.n = false;
        this.c = context;
        this.m = z;
        this.a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        if (z) {
            d();
            if (this.h != null && this.i != null && this.j != null && this.k != null) {
                this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.a.setImageBitmap(this.h);
                this.b.setImageBitmap(this.j);
                setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                setOrientation(0);
            } else {
                return;
            }
        } else {
            c();
            Bitmap bitmap = this.d;
            if (bitmap != null && this.e != null && this.f != null && this.g != null) {
                this.a.setImageBitmap(bitmap);
                this.b.setImageBitmap(this.f);
                this.l = a(this.f.getHeight() / 6);
                a(this.a, "main_topbtn_up.9.png");
                a(this.b, "main_bottombtn_up.9.png");
                setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                setOrientation(1);
            } else {
                return;
            }
        }
        this.a.setId(0);
        this.b.setId(1);
        this.a.setClickable(true);
        this.b.setClickable(true);
        this.a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        addView(this.a);
        addView(this.b);
        this.n = true;
    }

    private int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            return (int) ((this.c.getResources().getDisplayMetrics().density * i) + 0.5f);
        }
        return invokeI.intValue;
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    private Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matrix matrix = new Matrix();
            int densityDpi = SysOSUtil.getDensityDpi();
            if (densityDpi > 480) {
                matrix.postScale(1.8f, 1.8f);
            } else if (densityDpi > 320 && densityDpi <= 480) {
                matrix.postScale(1.5f, 1.5f);
            } else {
                matrix.postScale(1.2f, 1.2f);
            }
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
            if (a == null) {
                return null;
            }
            return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    private void a(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, str) == null) {
            Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
            byte[] ninePatchChunk = a.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            view2.setBackgroundDrawable(new NinePatchDrawable(a, ninePatchChunk, new Rect(), null));
            int i = this.l;
            view2.setPadding(i, i, i, i);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.d = a("main_icon_zoomin.png");
            this.e = a("main_icon_zoomin_dis.png");
            this.f = a("main_icon_zoomout.png");
            this.g = a("main_icon_zoomout_dis.png");
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.h = a("wear_zoom_in.png");
            this.i = a("wear_zoom_in_pressed.png");
            this.j = a("wear_zoon_out.png");
            this.k = a("wear_zoom_out_pressed.png");
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void b(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || (imageView = this.b) == null) {
            return;
        }
        imageView.setEnabled(z);
        if (!z) {
            this.b.setImageBitmap(this.g);
        } else {
            this.b.setImageBitmap(this.f);
        }
    }

    public void a(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setEnabled(z);
        if (!z) {
            this.a.setImageBitmap(this.e);
        } else {
            this.a.setImageBitmap(this.d);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Bitmap bitmap = this.d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.d.recycle();
                this.d = null;
            }
            Bitmap bitmap2 = this.e;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.e.recycle();
                this.e = null;
            }
            Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f.recycle();
                this.f = null;
            }
            Bitmap bitmap4 = this.g;
            if (bitmap4 != null && !bitmap4.isRecycled()) {
                this.g.recycle();
                this.g = null;
            }
            Bitmap bitmap5 = this.h;
            if (bitmap5 != null && !bitmap5.isRecycled()) {
                this.h.recycle();
                this.h = null;
            }
            Bitmap bitmap6 = this.i;
            if (bitmap6 != null && !bitmap6.isRecycled()) {
                this.i.recycle();
                this.i = null;
            }
            Bitmap bitmap7 = this.j;
            if (bitmap7 != null && !bitmap7.isRecycled()) {
                this.j.recycle();
                this.j = null;
            }
            Bitmap bitmap8 = this.k;
            if (bitmap8 != null && !bitmap8.isRecycled()) {
                this.k.recycle();
                this.k = null;
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, motionEvent)) == null) {
            if (view2 instanceof ImageView) {
                int id = ((ImageView) view2).getId();
                if (id != 0) {
                    if (id == 1) {
                        if (motionEvent.getAction() == 0) {
                            if (!this.m) {
                                a(this.b, "main_bottombtn_down.9.png");
                                return false;
                            }
                            this.b.setImageBitmap(this.k);
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            if (!this.m) {
                                a(this.b, "main_bottombtn_up.9.png");
                                return false;
                            }
                            this.b.setImageBitmap(this.j);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return false;
                } else if (motionEvent.getAction() == 0) {
                    if (!this.m) {
                        a(this.a, "main_topbtn_down.9.png");
                        return false;
                    }
                    this.a.setImageBitmap(this.i);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    if (!this.m) {
                        a(this.a, "main_topbtn_up.9.png");
                        return false;
                    }
                    this.a.setImageBitmap(this.h);
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
