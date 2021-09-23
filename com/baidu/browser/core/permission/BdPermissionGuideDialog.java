package com.baidu.browser.core.permission;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.k.a.i;
import c.a.k.a.j;
import c.a.k.a.m;
import c.a.k.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BdPermissionGuideDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f38571e;

    /* renamed from: f  reason: collision with root package name */
    public String f38572f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a> f38573g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f38574h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Drawable f38575a;

        /* renamed from: b  reason: collision with root package name */
        public String f38576b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f38577e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f38578f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f38579g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BdPermissionGuideDialog f38580h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BdPermissionGuideDialog bdPermissionGuideDialog, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPermissionGuideDialog, context};
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
            this.f38580h = bdPermissionGuideDialog;
            this.f38577e = context;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageView imageView = new ImageView(this.f38577e);
                this.f38578f = imageView;
                imageView.setId(8192);
                int dimension = (int) getResources().getDimension(j.core_permission_guide_icon_size);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension, dimension);
                layoutParams.addRule(10);
                addView(this.f38578f, layoutParams);
                TextView textView = new TextView(this.f38577e);
                this.f38579g = textView;
                textView.setTextColor(getResources().getColor(i.core_permission_guide_icon_text_color));
                this.f38579g.setSingleLine();
                this.f38579g.setGravity(17);
                this.f38579g.setTextSize(0, getResources().getDimension(j.core_permission_guide_icon_text_size));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(3, this.f38578f.getId());
                layoutParams2.addRule(14);
                layoutParams2.topMargin = (int) getResources().getDimension(j.core_permission_guide_icon_text_margin_top);
                addView(this.f38579g, layoutParams2);
            }
        }

        public void b(Drawable drawable, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, str) == null) {
                ImageView imageView = this.f38578f;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                TextView textView = this.f38579g;
                if (textView != null) {
                    textView.setText(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f38581e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f38582f;

        /* renamed from: g  reason: collision with root package name */
        public b f38583g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f38584h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<a> f38585i;

        /* renamed from: j  reason: collision with root package name */
        public int f38586j;
        public final /* synthetic */ BdPermissionGuideDialog k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BdPermissionGuideDialog bdPermissionGuideDialog, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPermissionGuideDialog, context};
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
            this.k = bdPermissionGuideDialog;
            this.f38586j = 4096;
            this.f38581e = context;
            this.f38585i = new ArrayList<>();
        }

        public final void b() {
            ArrayList<a> arrayList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (arrayList = this.f38585i) == null || this.f38581e == null || arrayList.size() == 0) {
                return;
            }
            TextView textView = new TextView(this.f38581e);
            this.f38582f = textView;
            textView.setText(this.k.f38572f);
            this.f38582f.setSingleLine();
            TextView textView2 = this.f38582f;
            int i2 = this.f38586j;
            this.f38586j = i2 + 1;
            textView2.setId(i2);
            this.f38582f.setTextSize(0, getResources().getDimension(j.core_permission_guide_info_size));
            this.f38582f.setTextColor(getResources().getColor(i.core_permission_dialog_info_color));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            addView(this.f38582f, layoutParams);
            int size = this.f38585i.size();
            int dimension = (int) getResources().getDimension(j.core_permission_guide_icon_margin);
            int dimension2 = (int) getResources().getDimension(j.core_permission_guide_icon_size);
            int dimension3 = (int) getResources().getDimension(j.core_permission_guide_icon_margin_top);
            b bVar = new b(this.k, this.f38581e);
            this.f38583g = bVar;
            int i3 = this.f38586j;
            this.f38586j = i3 + 1;
            bVar.setId(i3);
            this.f38583g.b(this.f38585i.get(0).f38575a, this.f38585i.get(0).f38576b);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimension2, -2);
            layoutParams2.topMargin = dimension3;
            layoutParams2.leftMargin = ((((int) this.f38581e.getResources().getDimension(j.core_permission_dialog_width)) - ((size - 1) * dimension)) - (dimension2 * size)) / 2;
            layoutParams2.addRule(3, this.f38582f.getId());
            addView(this.f38583g, layoutParams2);
            for (int i4 = 1; i4 < size; i4++) {
                b bVar2 = new b(this.k, this.f38581e);
                int i5 = this.f38586j;
                this.f38586j = i5 + 1;
                bVar2.setId(i5);
                bVar2.b(this.f38585i.get(i4).f38575a, this.f38585i.get(i4).f38576b);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimension2, -2);
                layoutParams3.topMargin = dimension3;
                layoutParams3.leftMargin = dimension;
                layoutParams3.addRule(1, this.f38586j - 2);
                layoutParams3.addRule(3, this.f38582f.getId());
                addView(bVar2, layoutParams3);
            }
            View view = new View(this.f38581e);
            int i6 = this.f38586j;
            this.f38586j = i6 + 1;
            view.setId(i6);
            view.setBackgroundColor(getResources().getColor(i.core_permission_next_step_top_divider_color));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) getResources().getDimension(j.core_permission_guide_dialog_button_width), (int) getResources().getDimension(j.core_permission_guide_dialog_divider_height));
            layoutParams4.addRule(3, this.f38583g.getId());
            layoutParams4.topMargin = getResources().getDimensionPixelSize(j.core_permission_go_setting_button_margin_top);
            addView(view, layoutParams4);
            TextView textView3 = new TextView(this.f38581e);
            this.f38584h = textView3;
            int i7 = this.f38586j;
            this.f38586j = i7 + 1;
            textView3.setId(i7);
            this.f38584h.setOnClickListener(this.k.f38574h);
            this.f38584h.setText(getResources().getString(m.core_permission_guide_next_step));
            this.f38584h.setTextSize(0, getResources().getDimension(j.core_permission_guide_title_size));
            this.f38584h.setTextColor(getResources().getColor(i.core_permission_next_step_text_color));
            this.f38584h.setGravity(17);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) getResources().getDimension(j.core_permission_guide_dialog_button_width), (int) getResources().getDimension(j.core_permission_guide_dialog_button_height));
            layoutParams5.addRule(3, view.getId());
            layoutParams5.addRule(14);
            addView(this.f38584h, layoutParams5);
        }

        public void c(ArrayList<a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.f38585i = arrayList;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPermissionGuideDialog(Context context) {
        super(context, n.BdPermissionGuideDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38571e = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (c.a.k.a.q.a.c()) {
                requestWindowFeature(1);
                c.a.k.a.q.a.b(getWindow().getDecorView());
            }
            c cVar = new c(this, this.f38571e);
            cVar.c(this.f38573g);
            cVar.b();
            setContentView(cVar, new ViewGroup.LayoutParams((int) this.f38571e.getResources().getDimension(j.core_permission_dialog_width), (int) this.f38571e.getResources().getDimension(j.core_permission_guide_dialog_height)));
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -2;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f38571e = null;
            this.f38574h = null;
            ArrayList<a> arrayList = this.f38573g;
            if (arrayList != null) {
                arrayList.clear();
                this.f38573g = null;
            }
        }
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f38572f = str;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f38574h = onClickListener;
        }
    }

    public void setPermissionList(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f38573g = arrayList;
        }
    }

    public void show(String str, String str2, ArrayList<a> arrayList, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, arrayList, onClickListener) == null) {
            setTitle(str);
            setPermissionList(arrayList);
            setOnClickListener(onClickListener);
            setCancelable(false);
            setMessage(str2);
            show();
        }
    }
}
