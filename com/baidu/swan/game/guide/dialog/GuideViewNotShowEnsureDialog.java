package com.baidu.swan.game.guide.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.q0.h.j.h;
import c.a.q0.h.j.i;
import c.a.q0.h.j.l;
import c.a.q0.j.p0.g.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class GuideViewNotShowEnsureDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DialogInterface.OnClickListener clickListener;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideViewNotShowEnsureDialog f40937e;

        public a(GuideViewNotShowEnsureDialog guideViewNotShowEnsureDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideViewNotShowEnsureDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40937e = guideViewNotShowEnsureDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40937e.dismiss();
                GuideViewNotShowEnsureDialog guideViewNotShowEnsureDialog = this.f40937e;
                DialogInterface.OnClickListener onClickListener = guideViewNotShowEnsureDialog.clickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(guideViewNotShowEnsureDialog, -2);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuideViewNotShowEnsureDialog f40938e;

        public b(GuideViewNotShowEnsureDialog guideViewNotShowEnsureDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guideViewNotShowEnsureDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40938e = guideViewNotShowEnsureDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40938e.dismiss();
                GuideViewNotShowEnsureDialog guideViewNotShowEnsureDialog = this.f40938e;
                DialogInterface.OnClickListener onClickListener = guideViewNotShowEnsureDialog.clickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(guideViewNotShowEnsureDialog, -1);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideViewNotShowEnsureDialog(@NonNull Context context) {
        super(context, l.AiappsGameGuideDialogStyle);
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
        this.clickListener = null;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = (TextView) findViewById(h.tv_cancel);
            TextView textView2 = (TextView) findViewById(h.tv_ensure);
            d.a(textView);
            d.a(textView2);
            textView.setOnClickListener(new a(this));
            textView2.setOnClickListener(new b(this));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(i.aiapps_game_guide_not_show_ensure_dialog);
            setCancelable(false);
            a();
        }
    }
}
