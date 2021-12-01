package c.a.r0.k4;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f18812b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18813c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18814d;

    /* renamed from: e  reason: collision with root package name */
    public View f18815e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18816f;

    /* renamed from: g  reason: collision with root package name */
    public String f18817g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f18818h;

    /* renamed from: i  reason: collision with root package name */
    public e f18819i;

    /* renamed from: j  reason: collision with root package name */
    public c f18820j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18821k;

    /* renamed from: c.a.r0.k4.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1109a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18822e;

        public View$OnClickListenerC1109a(a aVar) {
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
            this.f18822e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18822e.f18820j.onClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f18823b;

        /* renamed from: c  reason: collision with root package name */
        public View f18824c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18825d;

        /* renamed from: e  reason: collision with root package name */
        public View f18826e;

        /* renamed from: f  reason: collision with root package name */
        public String f18827f;

        /* renamed from: g  reason: collision with root package name */
        public int f18828g;

        /* renamed from: h  reason: collision with root package name */
        public d f18829h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f18830i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f18831j;

        /* renamed from: k  reason: collision with root package name */
        public final View.OnClickListener f18832k;

        /* renamed from: c.a.r0.k4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC1110a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18833e;

            public View$OnClickListenerC1110a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18833e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f18833e.f18829h != null) {
                        this.f18833e.f18829h.onClick();
                    }
                    if (this.f18833e.f18823b == null || this.f18833e.f18823b.c() == null) {
                        return;
                    }
                    this.f18833e.f18823b.c().a(this.f18833e.a, view);
                }
            }
        }

        public b(String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18828g = 17;
            this.f18830i = true;
            this.f18832k = new View$OnClickListenerC1110a(this);
            this.f18827f = str;
            this.f18823b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18824c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f18825d) == null) {
                return;
            }
            textView.setOnClickListener(this.f18832k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f18823b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f18823b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f18823b.d(), false);
            this.f18824c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f18825d = textView;
            textView.setText(this.f18827f);
            this.f18825d.setGravity(this.f18828g);
            View findViewById = this.f18824c.findViewById(R.id.divider_line);
            this.f18826e = findViewById;
            if (this.f18830i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f18825d;
                if (textView != null) {
                    if (this.f18831j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f18825d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f18826e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f18829h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i2, View view);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f18812b = inflate;
        this.f18813c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f18814d = (TextView) this.f18812b.findViewById(R.id.title);
        this.f18815e = this.f18812b.findViewById(R.id.title_divide_line);
        this.f18818h = new ArrayList();
        this.f18816f = (TextView) this.f18812b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f18817g)) {
                this.f18814d.setText(this.f18817g);
                this.f18815e.setVisibility(0);
            } else {
                this.f18814d.setVisibility(8);
                this.f18815e.setVisibility(8);
            }
            if (this.f18820j != null) {
                this.f18816f.setOnClickListener(new View$OnClickListenerC1109a(this));
            }
            e();
            return this.f18812b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18819i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18813c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f18812b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f18814d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f18814d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f18815e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f18816f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f18816f, R.color.CAM_X0107);
            List<b> list = this.f18818h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.f18821k) {
                if (!StringUtils.isNull(this.f18817g) && (textView = this.f18814d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f18814d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f18818h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f18818h.get(0)) == null || bVar.f18831j) {
                    return;
                }
                bVar.f18831j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f18818h = list;
        this.f18813c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f18813c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f18820j = cVar;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f18817g = str;
        }
    }
}
