package c.a.p0.j.p0.g.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendDivider;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.p0.j.p0.g.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAlertDialog n;
    public View o;
    public View p;
    public ImageView q;
    public View r;
    public RecyclerView s;
    public ListRecommendAdapter t;

    /* renamed from: c.a.p0.j.p0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0734a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10662e;

        public View$OnClickListenerC0734a(a aVar) {
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
            this.f10662e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f10662e.f10653g != null) {
                    this.f10662e.f10653g.c();
                }
                this.f10662e.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ListRecommendAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f10653g != null) {
                    this.a.f10653g.u(i2);
                }
                this.a.y();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10663e;

        public c(a aVar) {
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
            this.f10663e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f10663e.f10652f != null && this.f10663e.f10653g != null) {
                    this.f10663e.f10653g.o();
                }
                this.f10663e.y();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10664e;

        public d(a aVar) {
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
            this.f10664e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10664e.y();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10665e;

        public e(a aVar) {
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
            this.f10665e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10665e.r.getLayoutParams();
                layoutParams.width = this.f10665e.p.getWidth();
                int height = this.f10665e.p.getHeight();
                layoutParams.height = height;
                layoutParams.topMargin = -height;
                this.f10665e.r.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull c.a.p0.j.p0.g.b.d dVar) {
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
                super((Context) objArr2[0], (c.a.p0.j.p0.g.b.d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view.setOnClickListener(new View$OnClickListenerC0734a(this));
            this.t.setItemClickListener(new b(this));
            this.o.findViewById(R.id.swangame_recommend_dialog_game_center).setOnClickListener(new c(this));
            this.q.setOnClickListener(new d(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            SwanAppAlertDialog swanAppAlertDialog = this.n;
            if (swanAppAlertDialog != null) {
                swanAppAlertDialog.show();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean a = c.a.p0.a.s0.a.M().a();
            this.r.setVisibility(8);
            this.q.setImageResource(a ? R.drawable.swangame_recommend_button_close_night : R.drawable.swangame_recommend_button_close);
            if (a) {
                this.p.post(new e(this));
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SwanAppActivity activity = f.U().getActivity();
            float min = Math.min(activity != null && activity.isLandScape() ? 2.5f : 5.0f, this.s.getAdapter().getItemCount());
            Resources resources = this.f10651e.getResources();
            float dimension = resources.getDimension(R.dimen.swangame_recommend_dialog_list_divider_height);
            float dimension2 = resources.getDimension(R.dimen.swangame_recommend_dialog_list_default_padding);
            float dimension3 = resources.getDimension(R.dimen.swangame_recommend_dialog_width);
            Pair<Integer, Integer> x = f.U().x();
            this.s.getLayoutParams().width = (int) Math.min(dimension3, ((Integer) x.first).intValue());
            this.s.getLayoutParams().height = (int) Math.min((int) ((min * (resources.getDimension(R.dimen.swangame_recommend_dialog_list_item_height) + dimension)) + dimension2), ((Integer) x.second).intValue() * 0.67f);
            this.s.requestLayout();
        }
    }

    @Override // c.a.p0.j.p0.g.b.a, c.a.p0.j.p0.g.b.b
    public void e(c.a.p0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            super.e(aVar);
            this.t.updateModel(aVar);
            D();
        }
    }

    @Override // c.a.p0.j.p0.g.b.a
    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View i2 = super.i();
            View inflate = LayoutInflater.from(this.f10651e).inflate(R.layout.swangame_recommend_dialog, (ViewGroup) null);
            this.o = inflate;
            this.p = inflate.findViewById(R.id.swangame_recommend_dialog_content);
            this.r = this.o.findViewById(R.id.swangame_recommend_dialog_night_mask);
            this.q = (ImageView) this.o.findViewById(R.id.swangame_recommend_dialog_cancel);
            z();
            RecyclerView recyclerView = (RecyclerView) this.o.findViewById(R.id.swangame_recommend_dialog_list);
            this.s = recyclerView;
            recyclerView.setItemAnimator(null);
            this.s.setLayoutManager(new LinearLayoutManager(this.f10651e));
            this.s.addItemDecoration(new ListRecommendDivider(this.f10651e));
            ListRecommendAdapter listRecommendAdapter = new ListRecommendAdapter(this.f10651e);
            this.t = listRecommendAdapter;
            this.s.setAdapter(listRecommendAdapter);
            A(i2);
            return i2;
        }
        return (View) invokeV.objValue;
    }

    public final void y() {
        SwanAppAlertDialog swanAppAlertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (swanAppAlertDialog = this.n) == null) {
            return;
        }
        swanAppAlertDialog.dismiss();
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f10651e);
            aVar.m(true);
            aVar.f(true);
            aVar.k(false);
            aVar.j();
            aVar.b();
            aVar.p(17170445);
            aVar.W(this.o);
            aVar.t(false);
            this.n = aVar.c();
            c.a.p0.a.p2.f.b(f.U().getActivity(), this.n);
        }
    }
}
