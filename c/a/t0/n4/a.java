package c.a.t0.n4;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f19792b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19793c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19794d;

    /* renamed from: e  reason: collision with root package name */
    public View f19795e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19796f;

    /* renamed from: g  reason: collision with root package name */
    public String f19797g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f19798h;

    /* renamed from: i  reason: collision with root package name */
    public e f19799i;

    /* renamed from: j  reason: collision with root package name */
    public c f19800j;
    public boolean k;

    /* renamed from: c.a.t0.n4.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1240a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19801e;

        public View$OnClickListenerC1240a(a aVar) {
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
            this.f19801e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19801e.f19800j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f19802b;

        /* renamed from: c  reason: collision with root package name */
        public View f19803c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19804d;

        /* renamed from: e  reason: collision with root package name */
        public View f19805e;

        /* renamed from: f  reason: collision with root package name */
        public String f19806f;

        /* renamed from: g  reason: collision with root package name */
        public int f19807g;

        /* renamed from: h  reason: collision with root package name */
        public d f19808h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19809i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19810j;
        public final View.OnClickListener k;

        /* renamed from: c.a.t0.n4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1241a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19811e;

            public View$OnClickListenerC1241a(b bVar) {
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
                this.f19811e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f19811e.f19808h != null) {
                        this.f19811e.f19808h.onClick();
                    }
                    if (this.f19811e.f19802b == null || this.f19811e.f19802b.c() == null) {
                        return;
                    }
                    this.f19811e.f19802b.c().a(this.f19811e.a, view);
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
            this.f19807g = 17;
            this.f19809i = true;
            this.k = new View$OnClickListenerC1241a(this);
            this.f19806f = str;
            this.f19802b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19803c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f19804d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f19802b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f19802b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f19802b.d(), false);
            this.f19803c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f19804d = textView;
            textView.setText(this.f19806f);
            this.f19804d.setGravity(this.f19807g);
            View findViewById = this.f19803c.findViewById(R.id.divider_line);
            this.f19805e = findViewById;
            if (this.f19809i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f19804d;
                if (textView != null) {
                    if (this.f19810j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f19804d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19805e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f19808h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes8.dex */
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
        this.f19792b = inflate;
        this.f19793c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f19794d = (TextView) this.f19792b.findViewById(R.id.title);
        this.f19795e = this.f19792b.findViewById(R.id.title_divide_line);
        this.f19798h = new ArrayList();
        this.f19796f = (TextView) this.f19792b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f19797g)) {
                this.f19794d.setText(this.f19797g);
                this.f19795e.setVisibility(0);
            } else {
                this.f19794d.setVisibility(8);
                this.f19795e.setVisibility(8);
            }
            if (this.f19800j != null) {
                this.f19796f.setOnClickListener(new View$OnClickListenerC1240a(this));
            }
            e();
            return this.f19792b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19799i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19793c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f19792b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19794d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f19794d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f19795e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19796f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f19796f, R.color.CAM_X0107);
            List<b> list = this.f19798h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f19797g) && (textView = this.f19794d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f19794d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f19798h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f19798h.get(0)) == null || bVar.f19810j) {
                    return;
                }
                bVar.f19810j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f19798h = list;
        this.f19793c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f19793c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f19800j = cVar;
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
            this.f19797g = str;
        }
    }
}
