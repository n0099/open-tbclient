package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.p0.a.e;
import b.a.p0.a.f;
import b.a.p0.a.g;
import b.a.p0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AutoOrientationBtnDialog extends SwanAppAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f44910h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f44911i;
    public FrameLayout j;
    public View k;
    public List<a> l;
    public int m;
    public Context mContext;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f44912a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f44913b;

        /* renamed from: c  reason: collision with root package name */
        public int f44914c;

        /* renamed from: d  reason: collision with root package name */
        public int f44915d;

        /* renamed from: e  reason: collision with root package name */
        public c f44916e;

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
            this.f44914c = -1;
            this.f44915d = -1;
            this.f44912a = charSequence;
            this.f44914c = i2;
            this.f44916e = cVar;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends SwanAppAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f44917f;

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
            this.f44917f = new ArrayList();
            k(false);
            t(false);
        }

        public b a0(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar != null) {
                    this.f44917f.add(aVar);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public SwanAppAlertDialog c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                AutoOrientationBtnDialog autoOrientationBtnDialog = (AutoOrientationBtnDialog) super.c();
                autoOrientationBtnDialog.i(this.f44917f);
                return autoOrientationBtnDialog;
            }
            return (SwanAppAlertDialog) invokeV.objValue;
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

        /* renamed from: a  reason: collision with root package name */
        public TextView f44918a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f44919b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f44920c;

        /* renamed from: d  reason: collision with root package name */
        public AutoOrientationBtnDialog f44921d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoOrientationBtnDialog f44922e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f44923e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f44924f;

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
                this.f44924f = dVar;
                this.f44923e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f44924f.f44921d.dismiss();
                    c cVar = this.f44923e.f44916e;
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
            this.f44922e = autoOrientationBtnDialog;
            if (view != null) {
                this.f44918a = (TextView) view.findViewById(f.hv_btn_text);
                this.f44919b = (TextView) view.findViewById(f.hv_btn_subtext);
                this.f44920c = (LinearLayout) view;
                this.f44921d = autoOrientationBtnDialog2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f44918a.setText(aVar.f44912a);
            if (aVar.f44914c > 0) {
                this.f44918a.setTextColor(this.f44922e.f44911i.getResources().getColor(aVar.f44914c));
            }
            if (!TextUtils.isEmpty(aVar.f44913b)) {
                this.f44919b.setVisibility(0);
                this.f44919b.setText(aVar.f44913b);
            } else {
                this.f44919b.setVisibility(8);
            }
            if (aVar.f44915d > 0) {
                this.f44919b.setTextColor(this.f44922e.f44911i.getResources().getColor(aVar.f44915d));
            }
            this.f44920c.setOnClickListener(new a(this, aVar));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoOrientationBtnDialog(Context context) {
        super(context, i.SwanAppNoTitleDialog);
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
        this.l = new ArrayList();
        this.m = 2;
    }

    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final LinearLayout e(a aVar, LinearLayout linearLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, linearLayout)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(e.aiapp_alertdialog_button_day_bg_all_selector));
            new d(this, linearLayout2, this).a(aVar);
            return linearLayout2;
        }
        return (LinearLayout) invokeLL.objValue;
    }

    public final void f(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (list.size() > this.m) {
            linearLayout.setOrientation(1);
        } else {
            linearLayout.setOrientation(0);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            linearLayout.addView(e(list.get(i2), linearLayout));
            if (i2 < list.size() - 1) {
                if (list.size() > this.m) {
                    linearLayout.addView(g(1));
                } else {
                    linearLayout.addView(g(0));
                }
            }
        }
        this.j.removeAllViews();
        this.j.addView(linearLayout);
    }

    public final View g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.f44911i.getResources().getColor(b.a.p0.a.c.aiapps_dialog_gray));
            if (i2 == 1) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            this.mContext = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(g.aiapps_view_hv_dialog, getBuilder().e(), false);
            this.f44910h = viewGroup;
            this.f44911i = (FrameLayout) viewGroup.findViewById(f.hv_content);
            this.k = this.f44910h.findViewById(f.hv_divider);
            this.j = (FrameLayout) this.f44910h.findViewById(f.hv_btn_content);
            View createContentView = createContentView(this.f44911i);
            if (createContentView != null) {
                this.f44911i.addView(createContentView);
            }
            j();
            f(this.l);
        }
    }

    public final void i(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.l.clear();
            if (list != null) {
                this.l.addAll(list);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.setBackgroundColor(getContext().getResources().getColor(b.a.p0.a.c.aiapps_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            h();
            getBuilder().W(this.f44910h);
        }
    }
}
