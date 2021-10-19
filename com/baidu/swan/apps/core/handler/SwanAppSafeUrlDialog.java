package com.baidu.swan.apps.core.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.v2.b0;
import c.a.p0.a.v2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SwanAppSafeUrlDialog extends AutoOrientationBtnDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View n;
    public TextView o;
    public SelectorTextView p;
    public c q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppSafeUrlDialog f45924e;

        public a(SwanAppSafeUrlDialog swanAppSafeUrlDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppSafeUrlDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45924e = swanAppSafeUrlDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45924e.q.k == null) {
                return;
            }
            this.f45924e.q.k.a(view);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppSafeUrlDialog f45925e;

        public b(SwanAppSafeUrlDialog swanAppSafeUrlDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppSafeUrlDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45925e = swanAppSafeUrlDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45925e.q.f45929j == null) {
                return;
            }
            this.f45925e.q.f45929j.a(view);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends AutoOrientationBtnDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f45926g;

        /* renamed from: h  reason: collision with root package name */
        public int f45927h;

        /* renamed from: i  reason: collision with root package name */
        public int f45928i;

        /* renamed from: j  reason: collision with root package name */
        public AutoOrientationBtnDialog.c f45929j;
        public AutoOrientationBtnDialog.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
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
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public /* bridge */ /* synthetic */ SwanAppAlertDialog.a U(int i2) {
            g0(i2);
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog.b, com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public SwanAppAlertDialog c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                SwanAppSafeUrlDialog swanAppSafeUrlDialog = (SwanAppSafeUrlDialog) super.c();
                swanAppSafeUrlDialog.setSafeBuilder(this);
                return swanAppSafeUrlDialog;
            }
            return (SwanAppAlertDialog) invokeV.objValue;
        }

        public c e0(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f45926g = i2;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c f0(int i2, AutoOrientationBtnDialog.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, cVar)) == null) {
                this.f45926g = i2;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }

        public c g0(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                super.U(i2);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public SwanAppAlertDialog h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new SwanAppSafeUrlDialog(context) : (SwanAppAlertDialog) invokeL.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.a
        public /* bridge */ /* synthetic */ SwanAppAlertDialog.a v(int i2) {
            e0(i2);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppSafeUrlDialog(Context context) {
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
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.AutoOrientationBtnDialog
    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(g.aiapps_safe_dialog, viewGroup, false);
            this.n = inflate;
            TextView textView = (TextView) inflate.findViewById(f.safe_dialog_content);
            this.o = textView;
            textView.setTextColor(getContext().getResources().getColor(c.a.p0.a.c.aiapps_safe_dialog_message));
            SelectorTextView selectorTextView = (SelectorTextView) this.n.findViewById(f.safe_dialog_sub_content);
            this.p = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(c.a.p0.a.c.aiapps_safe_dialog_btn_blue));
            l();
            return this.n;
        }
        return (View) invokeL.objValue;
    }

    public final void l() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.q) == null) {
            return;
        }
        this.o.setText(this.mContext.getText(cVar.f45926g));
        this.o.setOnClickListener(new a(this));
        if (this.q.f45927h > 0) {
            this.p.setVisibility(0);
            this.p.setText(this.mContext.getText(this.q.f45927h));
            this.p.setOnClickListener(new b(this));
        } else {
            this.p.setVisibility(8);
        }
        if (this.q.f45928i > 0) {
            Drawable drawable = this.mContext.getResources().getDrawable(this.q.f45928i);
            b0.b(getContext(), drawable);
            drawable.setBounds(0, 0, n0.f(this.mContext, 12.0f), n0.f(this.mContext, 12.0f));
            this.p.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setSafeBuilder(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.q = cVar;
        }
    }
}
