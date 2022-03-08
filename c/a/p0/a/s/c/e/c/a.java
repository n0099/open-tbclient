package c.a.p0.a.s.c.e.c;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.p0.a.s.a.c.c;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.s.a.c.b<TextView, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppComponentContainerView f7301i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f7302j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull b bVar) {
        super(context, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.f7301i = new SwanAppComponentContainerView(context);
        this.f7302j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.c.b, c.a.p0.a.s.a.d.a, c.a.p0.a.s.b.a
    @NonNull
    /* renamed from: Z */
    public c.a.p0.a.s.f.b k(@NonNull b bVar, @NonNull b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bVar, bVar2)) == null) {
            c.a.p0.a.s.f.b k = super.k(bVar, bVar2);
            if (!TextUtils.equals(bVar.I, bVar2.I) && (TextUtils.equals(bVar.I, "scroll") || TextUtils.equals(bVar2.I, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(bVar.I, bVar2.I) || (TextUtils.equals(bVar2.I, "scroll") && bVar.H != bVar2.H)) {
                k.b(8);
            }
            return k;
        }
        return (c.a.p0.a.s.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.b.a
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.f7302j : (TextView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.d.a
    /* renamed from: b0 */
    public void P(@NonNull View view, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, bVar) == null) {
            boolean z = c.a.p0.a.s.b.a.f7271h;
            if (bVar.n == null) {
                return;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                super.P((View) parent, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.s.a.d.a
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, bVar) == null) {
            boolean z = c.a.p0.a.s.b.a.f7271h;
            if (bVar.n == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(bVar);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(bVar.o);
                gradientDrawable.setCornerRadius(bVar.r);
                gradientDrawable.setStroke(bVar.p, bVar.q);
                ((View) parent).setBackground(gradientDrawable);
            }
        }
    }

    @Override // c.a.p0.a.s.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? this.f7301i : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
