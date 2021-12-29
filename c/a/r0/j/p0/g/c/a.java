package c.a.r0.j.p0.g.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c.a.r0.h.g;
import c.a.r0.j.p0.g.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.r0.j.p0.g.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int n;
    public c.a.r0.j.p0.g.c.b o;
    public c.a.r0.j.p0.g.c.b p;

    /* renamed from: c.a.r0.j.p0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0759a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11448e;

        public View$OnClickListenerC0759a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11448e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11448e.f11442g == null || this.f11448e.n < -1) {
                return;
            }
            if (this.f11448e.n == -1) {
                this.f11448e.f11442g.o();
            } else {
                this.f11448e.f11442g.u(this.f11448e.n);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11449e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11449e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                a aVar = this.f11449e;
                RecommendItemModel y = aVar.y(aVar.n);
                this.f11449e.o.f11450b.setImageURI(y.iconUrl);
                this.f11449e.o.f11451c.setText(y.appName);
                this.f11449e.o.a.setAlpha(1.0f);
                a aVar2 = this.f11449e;
                RecommendItemModel y2 = this.f11449e.y(aVar2.x(aVar2.n));
                this.f11449e.p.f11450b.setImageURI(y2.iconUrl);
                this.f11449e.p.f11451c.setText(y2.appName);
                this.f11449e.p.a.setAlpha(0.0f);
                a.super.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -2;
    }

    @Override // c.a.r0.j.p0.g.b.a, c.a.r0.j.p0.g.b.b
    public void e(c.a.r0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.e(aVar);
            if (z(aVar)) {
                return;
            }
            this.n = -2;
            this.p.f11450b.setImageURI(aVar.a.iconUrl);
            this.p.f11451c.setText(aVar.a.appName);
        }
    }

    @Override // c.a.r0.j.p0.g.b.a
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f11440e);
            c.a.r0.j.p0.g.c.b bVar = new c.a.r0.j.p0.g.c.b(this.f11440e);
            this.p = bVar;
            bVar.a.setAlpha(0.0f);
            frameLayout.addView(this.p.a);
            c.a.r0.j.p0.g.c.b bVar2 = new c.a.r0.j.p0.g.c.b(this.f11440e);
            this.o = bVar2;
            bVar2.a.setAlpha(0.0f);
            this.o.f11450b.setActualImageResource(17170445);
            this.o.f11451c.setText((CharSequence) null);
            frameLayout.addView(this.o.a);
            this.o.a.setOnClickListener(new View$OnClickListenerC0759a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.j.p0.g.b.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.f11441f)) {
                this.o.a.setAlpha(1.0f);
                this.o.f11450b.setActualImageResource(c.a.r0.h.d.aiapps_gamecenter_logo);
                this.o.f11451c.setText(g.swangame_recommend_button_goto_game_center);
                super.k();
                return;
            }
            this.n = x(this.n);
            this.p.a.animate().setDuration(160L).alpha(1.0f);
            this.o.a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }

    public final int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = i2 + 1;
            if (i3 == this.f11441f.f11456b.size()) {
                return -1;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final RecommendItemModel y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 == -1 ? this.f11441f.a : this.f11441f.f11456b.get(i2) : (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(c.a.r0.j.p0.g.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? aVar == null || aVar.f11456b == null || aVar.a == null : invokeL.booleanValue;
    }
}
