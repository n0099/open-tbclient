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
import c.a.c0.h0.o;
import c.a.c0.h0.q;
import c.a.c0.h0.r;
import c.a.c0.h0.s;
import c.a.c0.h0.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.dialog.BoxAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AutoOrientationBtnDialog extends BoxAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f38331f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f38332g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f38333h;

    /* renamed from: i  reason: collision with root package name */
    public View f38334i;

    /* renamed from: j  reason: collision with root package name */
    public List<a> f38335j;

    /* renamed from: k  reason: collision with root package name */
    public int f38336k;
    public Context mContext;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f38337b;

        /* renamed from: c  reason: collision with root package name */
        public int f38338c;

        /* renamed from: d  reason: collision with root package name */
        public int f38339d;

        /* renamed from: e  reason: collision with root package name */
        public c f38340e;

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
            this.f38338c = -1;
            this.f38339d = -1;
            this.a = charSequence;
            this.f38338c = i2;
            this.f38340e = cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends BoxAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f38341f;

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
            this.f38341f = new ArrayList();
            g(false);
            h(false);
        }

        @Override // com.baidu.nadcore.widget.dialog.BoxAlertDialog.a
        public BoxAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.a();
                autoOrientationBtnDialog.h(this.f38341f);
                return autoOrientationBtnDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public b v(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    c.a.c0.u.a.b(this.f38341f, aVar);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes10.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f38342b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f38343c;

        /* renamed from: d  reason: collision with root package name */
        public AutoOrientationBtnDialog f38344d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoOrientationBtnDialog f38345e;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f38346e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f38347f;

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
                this.f38347f = dVar;
                this.f38346e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f38347f.f38344d.dismiss();
                    c cVar = this.f38346e.f38340e;
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
            this.f38345e = autoOrientationBtnDialog;
            if (view != null) {
                this.a = (TextView) view.findViewById(r.hv_btn_text);
                this.f38342b = (TextView) view.findViewById(r.hv_btn_subtext);
                this.f38343c = (LinearLayout) view;
                this.f38344d = autoOrientationBtnDialog2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.setText(aVar.a);
            if (aVar.f38338c > 0) {
                this.a.setTextColor(this.f38345e.f38332g.getResources().getColor(aVar.f38338c));
            }
            if (!TextUtils.isEmpty(aVar.f38337b)) {
                this.f38342b.setVisibility(0);
                this.f38342b.setText(aVar.f38337b);
            } else {
                this.f38342b.setVisibility(8);
            }
            if (aVar.f38339d > 0) {
                this.f38342b.setTextColor(this.f38345e.f38332g.getResources().getColor(aVar.f38339d));
            }
            this.f38343c.setOnClickListener(new a(this, aVar));
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
        this.f38335j = new ArrayList();
        this.f38336k = 2;
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
        } else if (size == this.f38336k) {
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
        this.f38333h.removeAllViews();
        this.f38333h.addView(linearLayout);
    }

    public final View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.f38332g.getResources().getColor(o.nad_dialog_gray));
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
            this.f38331f = viewGroup;
            this.f38332g = (FrameLayout) viewGroup.findViewById(r.hv_content);
            this.f38334i = this.f38331f.findViewById(r.hv_divider);
            this.f38333h = (FrameLayout) this.f38331f.findViewById(r.hv_btn_content);
            View createContentView = createContentView(this.f38332g);
            if (createContentView != null) {
                this.f38332g.addView(createContentView);
            }
            i();
            e(this.f38335j);
        }
    }

    public final void h(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f38335j.clear();
            if (list != null) {
                c.a.c0.u.a.c(this.f38335j, list);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f38334i.setBackgroundColor(getContext().getResources().getColor(o.nad_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            g();
            getBuilder().s(this.f38331f);
        }
    }
}
