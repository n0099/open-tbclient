package com.baidu.nadcore.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.b0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.nadcore.widget.txt.SelectorTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SafeUrlDialog extends AutoOrientationBtnDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View l;
    public TextView m;
    public SelectorTextView n;
    public c o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeUrlDialog f35967e;

        public a(SafeUrlDialog safeUrlDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeUrlDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35967e = safeUrlDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f35967e.o.k == null) {
                return;
            }
            this.f35967e.o.k.a(view);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeUrlDialog f35968e;

        public b(SafeUrlDialog safeUrlDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeUrlDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35968e = safeUrlDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f35968e.o.f35972j == null) {
                return;
            }
            this.f35968e.o.f35972j.a(view);
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends AutoOrientationBtnDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f35969g;

        /* renamed from: h  reason: collision with root package name */
        public int f35970h;

        /* renamed from: i  reason: collision with root package name */
        public int f35971i;

        /* renamed from: j  reason: collision with root package name */
        public AutoOrientationBtnDialog.c f35972j;
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

        public c A(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                super.q(i2);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog.b, com.baidu.nadcore.widget.dialog.BoxAlertDialog.a
        public BoxAlertDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                SafeUrlDialog safeUrlDialog = (SafeUrlDialog) super.a();
                safeUrlDialog.setSafeBuilder(this);
                return safeUrlDialog;
            }
            return (BoxAlertDialog) invokeV.objValue;
        }

        @Override // com.baidu.nadcore.widget.dialog.BoxAlertDialog.a
        public BoxAlertDialog f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new SafeUrlDialog(context) : (BoxAlertDialog) invokeL.objValue;
        }

        public c z(int i2, AutoOrientationBtnDialog.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, cVar)) == null) {
                this.f35969g = i2;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeUrlDialog(Context context) {
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

    @Override // com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog
    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nad_view_safe_dialog, viewGroup, false);
            this.l = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.safe_dialog_content);
            this.m = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_message));
            SelectorTextView selectorTextView = (SelectorTextView) this.l.findViewById(R.id.safe_dialog_sub_content);
            this.n = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_btn_blue));
            k();
            return this.l;
        }
        return (View) invokeL.objValue;
    }

    public final void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.o) == null) {
            return;
        }
        this.m.setText(this.mContext.getText(cVar.f35969g));
        this.m.setOnClickListener(new a(this));
        if (this.o.f35970h > 0) {
            this.n.setVisibility(0);
            this.n.setText(this.mContext.getText(this.o.f35970h));
            this.n.setOnClickListener(new b(this));
        } else {
            this.n.setVisibility(8);
        }
        if (this.o.f35971i > 0) {
            Drawable drawable = this.mContext.getResources().getDrawable(this.o.f35971i);
            c.a.b0.l0.t.b.c(getContext(), drawable);
            drawable.setBounds(0, 0, f.c.a(this.mContext, 12.0f), f.c.a(this.mContext, 12.0f));
            this.n.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void setSafeBuilder(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.o = cVar;
        }
    }
}
