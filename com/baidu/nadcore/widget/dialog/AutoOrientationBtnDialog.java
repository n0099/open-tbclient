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
    public ViewGroup f38487f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f38488g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f38489h;

    /* renamed from: i  reason: collision with root package name */
    public View f38490i;

    /* renamed from: j  reason: collision with root package name */
    public List<a> f38491j;

    /* renamed from: k  reason: collision with root package name */
    public int f38492k;
    public Context mContext;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f38493b;

        /* renamed from: c  reason: collision with root package name */
        public int f38494c;

        /* renamed from: d  reason: collision with root package name */
        public int f38495d;

        /* renamed from: e  reason: collision with root package name */
        public c f38496e;

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
            this.f38494c = -1;
            this.f38495d = -1;
            this.a = charSequence;
            this.f38494c = i2;
            this.f38496e = cVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends BoxAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f38497f;

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
            this.f38497f = new ArrayList();
            g(false);
            h(false);
        }

        @Override // com.baidu.nadcore.widget.dialog.BoxAlertDialog.a
        public BoxAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.a();
                autoOrientationBtnDialog.h(this.f38497f);
                return autoOrientationBtnDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        public b v(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar != null) {
                    c.a.c0.u.a.b(this.f38497f, aVar);
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
        public TextView f38498b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f38499c;

        /* renamed from: d  reason: collision with root package name */
        public AutoOrientationBtnDialog f38500d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoOrientationBtnDialog f38501e;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f38502e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f38503f;

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
                this.f38503f = dVar;
                this.f38502e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f38503f.f38500d.dismiss();
                    c cVar = this.f38502e.f38496e;
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
            this.f38501e = autoOrientationBtnDialog;
            if (view != null) {
                this.a = (TextView) view.findViewById(r.hv_btn_text);
                this.f38498b = (TextView) view.findViewById(r.hv_btn_subtext);
                this.f38499c = (LinearLayout) view;
                this.f38500d = autoOrientationBtnDialog2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.a.setText(aVar.a);
            if (aVar.f38494c > 0) {
                this.a.setTextColor(this.f38501e.f38488g.getResources().getColor(aVar.f38494c));
            }
            if (!TextUtils.isEmpty(aVar.f38493b)) {
                this.f38498b.setVisibility(0);
                this.f38498b.setText(aVar.f38493b);
            } else {
                this.f38498b.setVisibility(8);
            }
            if (aVar.f38495d > 0) {
                this.f38498b.setTextColor(this.f38501e.f38488g.getResources().getColor(aVar.f38495d));
            }
            this.f38499c.setOnClickListener(new a(this, aVar));
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
        this.f38491j = new ArrayList();
        this.f38492k = 2;
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
        } else if (size == this.f38492k) {
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
        this.f38489h.removeAllViews();
        this.f38489h.addView(linearLayout);
    }

    public final View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.f38488g.getResources().getColor(o.nad_dialog_gray));
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
            this.f38487f = viewGroup;
            this.f38488g = (FrameLayout) viewGroup.findViewById(r.hv_content);
            this.f38490i = this.f38487f.findViewById(r.hv_divider);
            this.f38489h = (FrameLayout) this.f38487f.findViewById(r.hv_btn_content);
            View createContentView = createContentView(this.f38488g);
            if (createContentView != null) {
                this.f38488g.addView(createContentView);
            }
            i();
            e(this.f38491j);
        }
    }

    public final void h(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f38491j.clear();
            if (list != null) {
                c.a.c0.u.a.c(this.f38491j, list);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f38490i.setBackgroundColor(getContext().getResources().getColor(o.nad_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            g();
            getBuilder().s(this.f38487f);
        }
    }
}
