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
    public View f19893b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19894c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19895d;

    /* renamed from: e  reason: collision with root package name */
    public View f19896e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19897f;

    /* renamed from: g  reason: collision with root package name */
    public String f19898g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f19899h;

    /* renamed from: i  reason: collision with root package name */
    public e f19900i;

    /* renamed from: j  reason: collision with root package name */
    public c f19901j;
    public boolean k;

    /* renamed from: c.a.t0.n4.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1235a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19902e;

        public View$OnClickListenerC1235a(a aVar) {
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
            this.f19902e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19902e.f19901j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f19903b;

        /* renamed from: c  reason: collision with root package name */
        public View f19904c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19905d;

        /* renamed from: e  reason: collision with root package name */
        public View f19906e;

        /* renamed from: f  reason: collision with root package name */
        public String f19907f;

        /* renamed from: g  reason: collision with root package name */
        public int f19908g;

        /* renamed from: h  reason: collision with root package name */
        public d f19909h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19910i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19911j;
        public final View.OnClickListener k;

        /* renamed from: c.a.t0.n4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1236a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19912e;

            public View$OnClickListenerC1236a(b bVar) {
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
                this.f19912e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f19912e.f19909h != null) {
                        this.f19912e.f19909h.onClick();
                    }
                    if (this.f19912e.f19903b == null || this.f19912e.f19903b.c() == null) {
                        return;
                    }
                    this.f19912e.f19903b.c().a(this.f19912e.a, view);
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
            this.f19908g = 17;
            this.f19910i = true;
            this.k = new View$OnClickListenerC1236a(this);
            this.f19907f = str;
            this.f19903b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19904c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f19905d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f19903b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f19903b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f19903b.d(), false);
            this.f19904c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f19905d = textView;
            textView.setText(this.f19907f);
            this.f19905d.setGravity(this.f19908g);
            View findViewById = this.f19904c.findViewById(R.id.divider_line);
            this.f19906e = findViewById;
            if (this.f19910i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f19905d;
                if (textView != null) {
                    if (this.f19911j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f19905d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19906e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f19909h = dVar;
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
        this.f19893b = inflate;
        this.f19894c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f19895d = (TextView) this.f19893b.findViewById(R.id.title);
        this.f19896e = this.f19893b.findViewById(R.id.title_divide_line);
        this.f19899h = new ArrayList();
        this.f19897f = (TextView) this.f19893b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f19898g)) {
                this.f19895d.setText(this.f19898g);
                this.f19896e.setVisibility(0);
            } else {
                this.f19895d.setVisibility(8);
                this.f19896e.setVisibility(8);
            }
            if (this.f19901j != null) {
                this.f19897f.setOnClickListener(new View$OnClickListenerC1235a(this));
            }
            e();
            return this.f19893b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19900i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19894c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f19893b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19895d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f19895d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f19896e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19897f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f19897f, R.color.CAM_X0107);
            List<b> list = this.f19899h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f19898g) && (textView = this.f19895d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f19895d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f19899h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f19899h.get(0)) == null || bVar.f19911j) {
                    return;
                }
                bVar.f19911j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f19899h = list;
        this.f19894c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f19894c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f19901j = cVar;
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
            this.f19898g = str;
        }
    }
}
