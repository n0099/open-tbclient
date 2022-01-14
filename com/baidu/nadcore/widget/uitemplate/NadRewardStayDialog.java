package com.baidu.nadcore.widget.uitemplate;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.d.h;
import c.a.c0.d.i;
import c.a.c0.g0.p;
import c.a.c0.s.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadRewardStayDialog extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final b f37381e;

    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardStayDialog f37382e;

        public a(NadRewardStayDialog nadRewardStayDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardStayDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37382e = nadRewardStayDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f37382e.f37381e.a(false);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardStayDialog(Context context, @NonNull AdBaseModel adBaseModel, @NonNull b bVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel, bVar};
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
        c(adBaseModel);
        this.f37381e = bVar;
    }

    public final void b(AdBaseModel adBaseModel) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            o.b bVar = (adBaseModel == null || (oVar = adBaseModel.l) == null) ? null : oVar.f2255d;
            View inflate = LayoutInflater.from(getContext()).inflate(g.nad_reward_stay_view, (ViewGroup) null);
            String string = (bVar == null || TextUtils.isEmpty(bVar.a)) ? getContext().getResources().getString(h.nad_reward_stay_title) : bVar.a;
            String string2 = (bVar == null || TextUtils.isEmpty(bVar.f2264b)) ? getContext().getResources().getString(h.nad_reward_stay_confirm) : bVar.f2264b;
            String string3 = (bVar == null || TextUtils.isEmpty(bVar.f2265c)) ? getContext().getResources().getString(h.nad_reward_stay_cancel) : bVar.f2265c;
            ((TextView) inflate.findViewById(e.nad_reward_stay_content)).setText(string);
            TextView textView = (TextView) inflate.findViewById(e.nad_reward_stay_continue);
            textView.setText(string2);
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(e.nad_reward_stay_cancel);
            textView2.setText(string3);
            textView2.setOnClickListener(this);
            setContentView(inflate);
            setOnDismissListener(new a(this));
        }
    }

    public final void c(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            Window window = getWindow();
            window.requestFeature(1);
            b(adBaseModel);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = i.nad_BottomInAndOutStyle;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == e.nad_reward_stay_continue) {
                this.f37381e.a(false);
            } else if (view.getId() == e.nad_reward_stay_cancel) {
                this.f37381e.a(true);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Window window = getWindow();
            if (window == null) {
                super.show();
                return;
            }
            window.setFlags(8, 8);
            super.show();
            p.a(window);
            window.clearFlags(8);
        }
    }
}
