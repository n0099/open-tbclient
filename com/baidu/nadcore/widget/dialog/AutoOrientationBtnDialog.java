package com.baidu.nadcore.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.b0.h0.o;
import c.a.b0.h0.q;
import c.a.b0.h0.r;
import c.a.b0.h0.s;
import c.a.b0.h0.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.dialog.BoxAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AutoOrientationBtnDialog extends BoxAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f37842f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f37843g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f37844h;

    /* renamed from: i  reason: collision with root package name */
    public View f37845i;

    /* renamed from: j  reason: collision with root package name */
    public List<a> f37846j;

    /* renamed from: k  reason: collision with root package name */
    public int f37847k;
    public Context mContext;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f37848b;

        /* renamed from: c  reason: collision with root package name */
        public int f37849c;

        /* renamed from: d  reason: collision with root package name */
        public int f37850d;

        /* renamed from: e  reason: collision with root package name */
        public c f37851e;

        public a(CharSequence charSequence, int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37849c = -1;
            this.f37850d = -1;
            this.a = charSequence;
            this.f37849c = i2;
            this.f37851e = cVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends BoxAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f37852f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
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
            this.f37852f = new ArrayList();
            g(false);
            h(false);
        }

        @Override // com.baidu.nadcore.widget.dialog.BoxAlertDialog.a
        public BoxAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.a();
                autoOrientationBtnDialog.h(this.f37852f);
                return autoOrientationBtnDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public b v(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    c.a.b0.u.a.b(this.f37852f, aVar);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f37853b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f37854c;

        /* renamed from: d  reason: collision with root package name */
        public AutoOrientationBtnDialog f37855d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoOrientationBtnDialog f37856e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f37857e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f37858f;

            public a(d dVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37858f = dVar;
                this.f37857e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f37858f.f37855d.dismiss();
                    c cVar = this.f37857e.f37851e;
                    if (cVar != null) {
                        cVar.a(view);
                    }
                }
            }
        }

        public d(AutoOrientationBtnDialog autoOrientationBtnDialog, View view, AutoOrientationBtnDialog autoOrientationBtnDialog2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {autoOrientationBtnDialog, view, autoOrientationBtnDialog2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37856e = autoOrientationBtnDialog;
            if (view != null) {
                this.a = (TextView) view.findViewById(r.hv_btn_text);
                this.f37853b = (TextView) view.findViewById(r.hv_btn_subtext);
                this.f37854c = (LinearLayout) view;
                this.f37855d = autoOrientationBtnDialog2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.setText(aVar.a);
            if (aVar.f37849c > 0) {
                this.a.setTextColor(this.f37856e.f37843g.getResources().getColor(aVar.f37849c));
            }
            if (!TextUtils.isEmpty(aVar.f37848b)) {
                this.f37853b.setVisibility(0);
                this.f37853b.setText(aVar.f37848b);
            } else {
                this.f37853b.setVisibility(8);
            }
            if (aVar.f37850d > 0) {
                this.f37853b.setTextColor(this.f37856e.f37843g.getResources().getColor(aVar.f37850d));
            }
            this.f37854c.setOnClickListener(new a(this, aVar));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoOrientationBtnDialog(Context context) {
        super(context, u.NadNoTitleDialog);
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
        this.f37846j = new ArrayList();
        this.f37847k = 2;
    }

    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final LinearLayout d(a aVar, LinearLayout linearLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, linearLayout, i2)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(s.nad_item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(i2));
            new d(this, linearLayout2, this).a(aVar);
            return linearLayout2;
        }
        return (LinearLayout) invokeLLI.objValue;
    }

    public final void e(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            linearLayout.setOrientation(0);
            linearLayout.addView(d(list.get(0), linearLayout, q.nad_auto_orientation_dialog_btn_left_right_corner_bg_selector));
        } else if (size == this.f37847k) {
            linearLayout.setOrientation(0);
            linearLayout.addView(d(list.get(0), linearLayout, q.nad_auto_orientation_dialog_btn_left_corner_bg_selector));
            linearLayout.addView(f(0));
            linearLayout.addView(d(list.get(1), linearLayout, q.nad_auto_orientation_dialog_btn_right_corner_bg_selector));
        } else {
            linearLayout.setOrientation(1);
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 < list.size() - 1) {
                    linearLayout.addView(d(list.get(i2), linearLayout, q.nad_auto_orientation_dialog_btn_bg_selector));
                    linearLayout.addView(f(1));
                } else if (i2 == list.size() - 1) {
                    linearLayout.addView(d(list.get(i2), linearLayout, q.nad_auto_orientation_dialog_btn_left_right_corner_bg_selector));
                }
            }
        }
        this.f37844h.removeAllViews();
        this.f37844h.addView(linearLayout);
    }

    public final View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.f37843g.getResources().getColor(o.nad_dialog_gray));
            if (i2 == 1) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            this.mContext = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(s.nad_view_hv_dialog, getBuilder().c(), false);
            this.f37842f = viewGroup;
            this.f37843g = (FrameLayout) viewGroup.findViewById(r.hv_content);
            this.f37845i = this.f37842f.findViewById(r.hv_divider);
            this.f37844h = (FrameLayout) this.f37842f.findViewById(r.hv_btn_content);
            View createContentView = createContentView(this.f37843g);
            if (createContentView != null) {
                this.f37843g.addView(createContentView);
            }
            i();
            e(this.f37846j);
        }
    }

    public final void h(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f37846j.clear();
            if (list != null) {
                c.a.b0.u.a.c(this.f37846j, list);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f37845i.setBackgroundColor(getContext().getResources().getColor(o.nad_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            g();
            getBuilder().s(this.f37842f);
        }
    }
}
