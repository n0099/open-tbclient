package b.a.p0.h.o0.g.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b.a.p0.f.g;
import b.a.p0.h.o0.g.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends b.a.p0.h.o0.g.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int n;
    public b.a.p0.h.o0.g.c.b o;
    public b.a.p0.h.o0.g.c.b p;

    /* renamed from: b.a.p0.h.o0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0584a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10666e;

        public View$OnClickListenerC0584a(a aVar) {
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
            this.f10666e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f10666e.f10660g == null || this.f10666e.n < -1) {
                return;
            }
            if (this.f10666e.n == -1) {
                this.f10666e.f10660g.n();
            } else {
                this.f10666e.f10660g.t(this.f10666e.n);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10667e;

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
            this.f10667e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                a aVar = this.f10667e;
                RecommendItemModel y = aVar.y(aVar.n);
                this.f10667e.o.f10669b.setImageURI(y.iconUrl);
                this.f10667e.o.f10670c.setText(y.appName);
                this.f10667e.o.f10668a.setAlpha(1.0f);
                a aVar2 = this.f10667e;
                RecommendItemModel y2 = this.f10667e.y(aVar2.x(aVar2.n));
                this.f10667e.p.f10669b.setImageURI(y2.iconUrl);
                this.f10667e.p.f10670c.setText(y2.appName);
                this.f10667e.p.f10668a.setAlpha(0.0f);
                a.super.l();
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

    @Override // b.a.p0.h.o0.g.b.a, b.a.p0.h.o0.g.b.b
    public void d(b.a.p0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.d(aVar);
            if (z(aVar)) {
                return;
            }
            this.n = -2;
            this.p.f10669b.setImageURI(aVar.f10676a.iconUrl);
            this.p.f10670c.setText(aVar.f10676a.appName);
        }
    }

    @Override // b.a.p0.h.o0.g.b.a
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f10658e);
            b.a.p0.h.o0.g.c.b bVar = new b.a.p0.h.o0.g.c.b(this.f10658e);
            this.p = bVar;
            bVar.f10668a.setAlpha(0.0f);
            frameLayout.addView(this.p.f10668a);
            b.a.p0.h.o0.g.c.b bVar2 = new b.a.p0.h.o0.g.c.b(this.f10658e);
            this.o = bVar2;
            bVar2.f10668a.setAlpha(0.0f);
            this.o.f10669b.setActualImageResource(17170445);
            this.o.f10670c.setText((CharSequence) null);
            frameLayout.addView(this.o.f10668a);
            this.o.f10668a.setOnClickListener(new View$OnClickListenerC0584a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.p0.h.o0.g.b.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.f10659f)) {
                this.o.f10668a.setAlpha(1.0f);
                this.o.f10669b.setActualImageResource(b.a.p0.f.d.swangame_recommend_gamecenter);
                this.o.f10670c.setText(g.swangame_recommend_button_goto_game_center);
                super.l();
                return;
            }
            this.n = x(this.n);
            this.p.f10668a.animate().setDuration(160L).alpha(1.0f);
            this.o.f10668a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }

    public final int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = i2 + 1;
            if (i3 == this.f10659f.f10677b.size()) {
                return -1;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final RecommendItemModel y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 == -1 ? this.f10659f.f10676a : this.f10659f.f10677b.get(i2) : (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(b.a.p0.h.o0.g.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? aVar == null || aVar.f10677b == null || aVar.f10676a == null : invokeL.booleanValue;
    }
}
