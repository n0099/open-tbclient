package c.a.n0.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Q;
    public BaseMenuView R;
    public Context S;
    public View T;
    public MainMenuView U;
    public FrameLayout V;
    public c.a.n0.n.a W;
    public boolean X;
    public int Y;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Context context = this.a.S;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                h.super.r();
                h hVar = this.a;
                BaseMenuView baseMenuView = hVar.R;
                if (baseMenuView != hVar.U) {
                    baseMenuView.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, View view, @Nullable c.a.n0.n.a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = true;
        this.Y = 0;
        this.S = context;
        this.T = view;
        this.W = aVar;
        D(false);
        F(true);
        J(true);
        C(new ColorDrawable(0));
        L(-1);
        G(-1);
        if (Build.VERSION.SDK_INT > 29) {
            H(true);
        }
        T();
    }

    public void R() {
        c.a.n0.n.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.W) == null) {
            return;
        }
        aVar.a(this.U);
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z) {
                super.r();
            } else if (x()) {
                ObjectAnimator c2 = c.c(this.Q);
                ObjectAnimator e2 = c.e(this.R);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new a(this));
                animatorSet.playTogether(c2, e2);
                animatorSet.start();
            }
        }
    }

    public final void T() {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.S).inflate(R.layout.obfuscated_res_0x7f0d0092, (ViewGroup) null);
            this.V = frameLayout;
            this.Q = frameLayout.findViewById(R.id.obfuscated_res_0x7f0913b0);
            this.U = (MainMenuView) this.V.findViewById(R.id.obfuscated_res_0x7f09018b);
            if (c.a.n0.w.e.d() && (this.S instanceof Activity)) {
                FrameLayout frameLayout2 = (FrameLayout) this.V.findViewById(R.id.obfuscated_res_0x7f0913ef);
                if (c.a.n0.w.e.e((Activity) this.S)) {
                    b2 = c.a.n0.w.e.a((Activity) this.S);
                } else {
                    b2 = (int) c.a.n0.w.e.b((Activity) this.S);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, -1);
                layoutParams.gravity = 17;
                if (frameLayout2 != null) {
                    frameLayout2.setLayoutParams(layoutParams);
                }
            }
            this.Q.setOnClickListener(this);
            this.U.setClickListener(this);
            this.U.setFitsSystemWindows(true);
            this.V.measure(0, 0);
            E(this.V);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.U.e();
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.Y = i;
        }
    }

    public void W(List<List<g>> list, View view, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, view, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.U.update(list, view, z, i);
            Y();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.Q.setAlpha(0.0f);
            MainMenuView mainMenuView = this.U;
            mainMenuView.setTranslationY(mainMenuView.getHeight());
            ObjectAnimator d2 = c.d(this.Q, this.U);
            ObjectAnimator b2 = c.b(this.U);
            ArrayList arrayList = new ArrayList();
            arrayList.add(d2);
            arrayList.add(b2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || x()) {
            return;
        }
        R();
        this.U.f();
        this.R = this.U;
        if (this.X) {
            F(false);
        }
        Activity activity = (Activity) this.S;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        N(this.T, 81, 0, 0);
        if (this.X) {
            v().setSystemUiVisibility(this.Y | 1024 | 4096);
            F(true);
            update();
        }
        X();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f09048d || id == R.id.obfuscated_res_0x7f0913b0) {
                S(true);
            }
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            S(true);
        }
    }
}
