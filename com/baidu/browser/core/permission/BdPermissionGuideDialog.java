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
/* loaded from: classes10.dex */
public class BdPermissionGuideDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f33056e;

    /* renamed from: f  reason: collision with root package name */
    public String f33057f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a> f33058g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f33059h;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Drawable a;

        /* renamed from: b  reason: collision with root package name */
        public String f33060b;

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

    /* loaded from: classes10.dex */
    public class b extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f33061e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f33062f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f33063g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BdPermissionGuideDialog f33064h;

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
            this.f33064h = bdPermissionGuideDialog;
            this.f33061e = context;
            a();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageView imageView = new ImageView(this.f33061e);
                this.f33062f = imageView;
                imageView.setId(8192);
                int dimension = (int) getResources().getDimension(j.core_permission_guide_icon_size);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension, dimension);
                layoutParams.addRule(10);
                addView(this.f33062f, layoutParams);
                TextView textView = new TextView(this.f33061e);
                this.f33063g = textView;
                textView.setTextColor(getResources().getColor(i.core_permission_guide_icon_text_color));
                this.f33063g.setSingleLine();
                this.f33063g.setGravity(17);
                this.f33063g.setTextSize(0, getResources().getDimension(j.core_permission_guide_icon_text_size));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(3, this.f33062f.getId());
                layoutParams2.addRule(14);
                layoutParams2.topMargin = (int) getResources().getDimension(j.core_permission_guide_icon_text_margin_top);
                addView(this.f33063g, layoutParams2);
            }
        }

        public void b(Drawable drawable, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, str) == null) {
                ImageView imageView = this.f33062f;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                TextView textView = this.f33063g;
                if (textView != null) {
                    textView.setText(str);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f33065e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f33066f;

        /* renamed from: g  reason: collision with root package name */
        public b f33067g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f33068h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<a> f33069i;

        /* renamed from: j  reason: collision with root package name */
        public int f33070j;
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
            this.f33070j = 4096;
            this.f33065e = context;
            this.f33069i = new ArrayList<>();
        }

        public final void b() {
            ArrayList<a> arrayList;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (arrayList = this.f33069i) == null || this.f33065e == null || arrayList.size() == 0) {
                return;
            }
            TextView textView = new TextView(this.f33065e);
            this.f33066f = textView;
            textView.setText(this.k.f33057f);
            this.f33066f.setSingleLine();
            TextView textView2 = this.f33066f;
            int i2 = this.f33070j;
            this.f33070j = i2 + 1;
            textView2.setId(i2);
            this.f33066f.setTextSize(0, getResources().getDimension(j.core_permission_guide_info_size));
            this.f33066f.setTextColor(getResources().getColor(i.core_permission_dialog_info_color));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            addView(this.f33066f, layoutParams);
            int size = this.f33069i.size();
            int dimension = (int) getResources().getDimension(j.core_permission_guide_icon_margin);
            int dimension2 = (int) getResources().getDimension(j.core_permission_guide_icon_size);
            int dimension3 = (int) getResources().getDimension(j.core_permission_guide_icon_margin_top);
            b bVar = new b(this.k, this.f33065e);
            this.f33067g = bVar;
            int i3 = this.f33070j;
            this.f33070j = i3 + 1;
            bVar.setId(i3);
            this.f33067g.b(this.f33069i.get(0).a, this.f33069i.get(0).f33060b);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimension2, -2);
            layoutParams2.topMargin = dimension3;
            layoutParams2.leftMargin = ((((int) this.f33065e.getResources().getDimension(j.core_permission_dialog_width)) - ((size - 1) * dimension)) - (dimension2 * size)) / 2;
            layoutParams2.addRule(3, this.f33066f.getId());
            addView(this.f33067g, layoutParams2);
            for (int i4 = 1; i4 < size; i4++) {
                b bVar2 = new b(this.k, this.f33065e);
                int i5 = this.f33070j;
                this.f33070j = i5 + 1;
                bVar2.setId(i5);
                bVar2.b(this.f33069i.get(i4).a, this.f33069i.get(i4).f33060b);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimension2, -2);
                layoutParams3.topMargin = dimension3;
                layoutParams3.leftMargin = dimension;
                layoutParams3.addRule(1, this.f33070j - 2);
                layoutParams3.addRule(3, this.f33066f.getId());
                addView(bVar2, layoutParams3);
            }
            View view = new View(this.f33065e);
            int i6 = this.f33070j;
            this.f33070j = i6 + 1;
            view.setId(i6);
            view.setBackgroundColor(getResources().getColor(i.core_permission_next_step_top_divider_color));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) getResources().getDimension(j.core_permission_guide_dialog_button_width), (int) getResources().getDimension(j.core_permission_guide_dialog_divider_height));
            layoutParams4.addRule(3, this.f33067g.getId());
            layoutParams4.topMargin = getResources().getDimensionPixelSize(j.core_permission_go_setting_button_margin_top);
            addView(view, layoutParams4);
            TextView textView3 = new TextView(this.f33065e);
            this.f33068h = textView3;
            int i7 = this.f33070j;
            this.f33070j = i7 + 1;
            textView3.setId(i7);
            this.f33068h.setOnClickListener(this.k.f33059h);
            this.f33068h.setText(getResources().getString(m.core_permission_guide_next_step));
            this.f33068h.setTextSize(0, getResources().getDimension(j.core_permission_guide_title_size));
            this.f33068h.setTextColor(getResources().getColor(i.core_permission_next_step_text_color));
            this.f33068h.setGravity(17);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) getResources().getDimension(j.core_permission_guide_dialog_button_width), (int) getResources().getDimension(j.core_permission_guide_dialog_button_height));
            layoutParams5.addRule(3, view.getId());
            layoutParams5.addRule(14);
            addView(this.f33068h, layoutParams5);
        }

        public void c(ArrayList<a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.f33069i = arrayList;
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
        this.f33056e = context;
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
            c cVar = new c(this, this.f33056e);
            cVar.c(this.f33058g);
            cVar.b();
            setContentView(cVar, new ViewGroup.LayoutParams((int) this.f33056e.getResources().getDimension(j.core_permission_dialog_width), (int) this.f33056e.getResources().getDimension(j.core_permission_guide_dialog_height)));
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
            this.f33056e = null;
            this.f33059h = null;
            ArrayList<a> arrayList = this.f33058g;
            if (arrayList != null) {
                arrayList.clear();
                this.f33058g = null;
            }
        }
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f33057f = str;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f33059h = onClickListener;
        }
    }

    public void setPermissionList(ArrayList<a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f33058g = arrayList;
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
