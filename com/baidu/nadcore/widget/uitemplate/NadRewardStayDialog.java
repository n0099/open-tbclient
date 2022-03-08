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
import c.a.b0.h0.r;
import c.a.b0.s.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NadRewardStayDialog extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final b f36044e;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NadRewardStayDialog f36045e;

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
            this.f36045e = nadRewardStayDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f36045e.f36044e.a(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f36044e = bVar;
    }

    public final void b(AdBaseModel adBaseModel) {
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            s.b bVar = (adBaseModel == null || (sVar = adBaseModel.q) == null) ? null : sVar.f1952f;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_reward_stay_view, (ViewGroup) null);
            String string = (bVar == null || TextUtils.isEmpty(bVar.a)) ? getContext().getResources().getString(R.string.nad_reward_stay_title) : bVar.a;
            String string2 = (bVar == null || TextUtils.isEmpty(bVar.f1965b)) ? getContext().getResources().getString(R.string.nad_reward_stay_confirm) : bVar.f1965b;
            String string3 = (bVar == null || TextUtils.isEmpty(bVar.f1966c)) ? getContext().getResources().getString(R.string.nad_reward_stay_cancel) : bVar.f1966c;
            ((TextView) inflate.findViewById(R.id.nad_reward_stay_content)).setText(string);
            TextView textView = (TextView) inflate.findViewById(R.id.nad_reward_stay_continue);
            textView.setText(string2);
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.nad_reward_stay_cancel);
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
            attributes.windowAnimations = R.style.nad_BottomInAndOutStyle;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.nad_reward_stay_continue) {
                this.f36044e.a(false);
            } else if (view.getId() == R.id.nad_reward_stay_cancel) {
                this.f36044e.a(true);
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
            r.a(window);
            window.clearFlags(8);
        }
    }
}
