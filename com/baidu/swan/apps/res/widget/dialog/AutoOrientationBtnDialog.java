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
import c.a.o0.a.e;
import c.a.o0.a.f;
import c.a.o0.a.g;
import c.a.o0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class AutoOrientationBtnDialog extends SwanAppAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f46314h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f46315i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f46316j;
    public View k;
    public List<a> l;
    public int m;
    public Context mContext;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f46317a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f46318b;

        /* renamed from: c  reason: collision with root package name */
        public int f46319c;

        /* renamed from: d  reason: collision with root package name */
        public int f46320d;

        /* renamed from: e  reason: collision with root package name */
        public c f46321e;

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
            this.f46319c = -1;
            this.f46320d = -1;
            this.f46317a = charSequence;
            this.f46319c = i2;
            this.f46321e = cVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends SwanAppAlertDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f46322f;

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
            this.f46322f = new ArrayList();
            k(false);
            t(false);
        }

        public b a0(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar != null) {
                    this.f46322f.add(aVar);
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
                autoOrientationBtnDialog.i(this.f46322f);
                return autoOrientationBtnDialog;
            }
            return (SwanAppAlertDialog) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f46323a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46324b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f46325c;

        /* renamed from: d  reason: collision with root package name */
        public AutoOrientationBtnDialog f46326d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AutoOrientationBtnDialog f46327e;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f46328e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f46329f;

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
                this.f46329f = dVar;
                this.f46328e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f46329f.f46326d.dismiss();
                    c cVar = this.f46328e.f46321e;
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
            this.f46327e = autoOrientationBtnDialog;
            if (view != null) {
                this.f46323a = (TextView) view.findViewById(f.hv_btn_text);
                this.f46324b = (TextView) view.findViewById(f.hv_btn_subtext);
                this.f46325c = (LinearLayout) view;
                this.f46326d = autoOrientationBtnDialog2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f46323a.setText(aVar.f46317a);
            if (aVar.f46319c > 0) {
                this.f46323a.setTextColor(this.f46327e.f46315i.getResources().getColor(aVar.f46319c));
            }
            if (!TextUtils.isEmpty(aVar.f46318b)) {
                this.f46324b.setVisibility(0);
                this.f46324b.setText(aVar.f46318b);
            } else {
                this.f46324b.setVisibility(8);
            }
            if (aVar.f46320d > 0) {
                this.f46324b.setTextColor(this.f46327e.f46315i.getResources().getColor(aVar.f46320d));
            }
            this.f46325c.setOnClickListener(new a(this, aVar));
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
        this.f46316j.removeAllViews();
        this.f46316j.addView(linearLayout);
    }

    public final View g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.mContext);
            view.setBackgroundColor(this.f46315i.getResources().getColor(c.a.o0.a.c.aiapps_dialog_gray));
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
            this.f46314h = viewGroup;
            this.f46315i = (FrameLayout) viewGroup.findViewById(f.hv_content);
            this.k = this.f46314h.findViewById(f.hv_divider);
            this.f46316j = (FrameLayout) this.f46314h.findViewById(f.hv_btn_content);
            View createContentView = createContentView(this.f46315i);
            if (createContentView != null) {
                this.f46315i.addView(createContentView);
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
            this.k.setBackgroundColor(getContext().getResources().getColor(c.a.o0.a.c.aiapps_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            h();
            getBuilder().W(this.f46314h);
        }
    }
}
