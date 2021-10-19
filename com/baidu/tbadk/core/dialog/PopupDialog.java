package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import c.a.q0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PopupDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47487e;

    /* renamed from: f  reason: collision with root package name */
    public f f47488f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47489g;

    /* renamed from: h  reason: collision with root package name */
    public float f47490h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47491i;

    /* renamed from: j  reason: collision with root package name */
    public i f47492j;
    public boolean k;
    public CustomMessageListener l;
    public View mContentView;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f47493a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PopupDialog popupDialog, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47493a = popupDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.f47493a.f47492j != null) {
                this.f47493a.f47492j.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f47494e;

        public b(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47494e = popupDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47494e.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f47495a;

        public c(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47495a = popupDialog;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f47495a.setCancelable(true);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.f47495a.setCancelable(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f47496a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f47497e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47497e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47497e.f47496a.f47488f == null || this.f47497e.f47496a.f47488f.getPageActivity() == null) {
                    return;
                }
                Activity pageActivity = this.f47497e.f47496a.f47488f.getPageActivity();
                if (pageActivity.isFinishing() || pageActivity.getWindow() == null) {
                    return;
                }
                PopupDialog.super.dismiss();
            }
        }

        public d(PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47496a = popupDialog;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f47496a.f47491i = false;
                this.f47496a.f47489g.post(new a(this));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.f47496a.f47491i = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1631619137, "Lcom/baidu/tbadk/core/dialog/PopupDialog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1631619137, "Lcom/baidu/tbadk/core/dialog/PopupDialog;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupDialog(f fVar, i iVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, iVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47490h = 0.33f;
        this.f47491i = false;
        this.k = true;
        this.l = new a(this, 2001304);
        this.f47488f = fVar;
        this.f47487e = fVar.getPageActivity();
        this.f47492j = iVar;
        this.mContentView = iVar.c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47489g == null || this.f47491i || !isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f47487e, R.anim.pop_exit_anim);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new d(this));
        this.f47489g.startAnimation(loadAnimation);
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
    }

    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContentView : (View) invokeV.objValue;
    }

    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47489g : (LinearLayout) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (isShowing()) {
                cancel();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.popup_dialog);
            Display defaultDisplay = ((WindowManager) this.f47487e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            if (this.k) {
                attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                getWindow().addFlags(512);
            }
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.f47490h);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
            this.f47489g = linearLayout;
            linearLayout.setOnClickListener(new b(this));
            View view = this.mContentView;
            if (view == null) {
                return;
            }
            this.f47489g.removeView(view);
            if (this.k) {
                View view2 = this.mContentView;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildAt(((ViewGroup) view2).getChildCount() - 1).getId() != m) {
                    View view3 = new View(getContext());
                    view3.setId(m);
                    view3.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(getContext(), R.dimen.bottom_enter_anim_place_holder_height)));
                    SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
                    ((ViewGroup) this.mContentView).addView(view3);
                }
            }
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    this.f47489g.addView(this.mContentView);
                    return;
                }
                return;
            }
            this.f47489g.addView(this.mContentView);
        }
    }

    public void setContentView(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            this.f47492j = iVar;
            this.mContentView = iVar.c();
        }
    }

    public void setDefaultContentView(String str, String[] strArr, i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, strArr, eVar) == null) {
            this.f47492j = new i(this.f47487e);
            if (!StringUtils.isNull(str)) {
                this.f47492j.q(str);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                arrayList.add(new c.a.q0.s.s.f(i2, strArr[i2], this.f47492j));
            }
            this.f47492j.k(arrayList);
            this.f47492j.n(eVar);
            setCanceledOnTouchOutside(true);
            this.mContentView = this.f47492j.c();
        }
    }

    public void setTitleContent(SpannableStringBuilder spannableStringBuilder) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spannableStringBuilder) == null) || (iVar = this.f47492j) == null) {
            return;
        }
        iVar.o(spannableStringBuilder);
        this.f47492j.p();
    }

    public void setWindowDimAmount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f47490h = f2;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.show();
            this.f47488f.registerListener(this.l);
        }
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f47491i = false;
            if (isShowing()) {
                super.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(g.j(this, this.f47488f))));
            if (this.f47489g != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f47487e, R.anim.bomb_pop_enter_anim);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new c(this));
                this.f47489g.startAnimation(loadAnimation);
            }
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.mContentView = view;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupDialog(f fVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47490h = 0.33f;
        this.f47491i = false;
        this.k = true;
        this.l = new a(this, 2001304);
        this.f47487e = fVar.getPageActivity();
        this.f47488f = fVar;
    }
}
