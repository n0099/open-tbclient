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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f20334b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f20335c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20336d;

    /* renamed from: e  reason: collision with root package name */
    public View f20337e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20338f;

    /* renamed from: g  reason: collision with root package name */
    public String f20339g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f20340h;

    /* renamed from: i  reason: collision with root package name */
    public e f20341i;

    /* renamed from: j  reason: collision with root package name */
    public c f20342j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20343k;

    /* renamed from: c.a.t0.n4.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1226a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20344e;

        public View$OnClickListenerC1226a(a aVar) {
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
            this.f20344e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20344e.f20342j.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f20345b;

        /* renamed from: c  reason: collision with root package name */
        public View f20346c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20347d;

        /* renamed from: e  reason: collision with root package name */
        public View f20348e;

        /* renamed from: f  reason: collision with root package name */
        public String f20349f;

        /* renamed from: g  reason: collision with root package name */
        public int f20350g;

        /* renamed from: h  reason: collision with root package name */
        public d f20351h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20352i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f20353j;

        /* renamed from: k  reason: collision with root package name */
        public final View.OnClickListener f20354k;

        /* renamed from: c.a.t0.n4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1227a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f20355e;

            public View$OnClickListenerC1227a(b bVar) {
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
                this.f20355e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f20355e.f20351h != null) {
                        this.f20355e.f20351h.onClick();
                    }
                    if (this.f20355e.f20345b == null || this.f20355e.f20345b.c() == null) {
                        return;
                    }
                    this.f20355e.f20345b.c().a(this.f20355e.a, view);
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
            this.f20350g = 17;
            this.f20352i = true;
            this.f20354k = new View$OnClickListenerC1227a(this);
            this.f20349f = str;
            this.f20345b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20346c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f20347d) == null) {
                return;
            }
            textView.setOnClickListener(this.f20354k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f20345b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f20345b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f20345b.d(), false);
            this.f20346c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f20347d = textView;
            textView.setText(this.f20349f);
            this.f20347d.setGravity(this.f20350g);
            View findViewById = this.f20346c.findViewById(R.id.divider_line);
            this.f20348e = findViewById;
            if (this.f20352i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f20347d;
                if (textView != null) {
                    if (this.f20353j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f20347d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f20348e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f20351h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes7.dex */
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
        this.f20334b = inflate;
        this.f20335c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f20336d = (TextView) this.f20334b.findViewById(R.id.title);
        this.f20337e = this.f20334b.findViewById(R.id.title_divide_line);
        this.f20340h = new ArrayList();
        this.f20338f = (TextView) this.f20334b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f20339g)) {
                this.f20336d.setText(this.f20339g);
                this.f20337e.setVisibility(0);
            } else {
                this.f20336d.setVisibility(8);
                this.f20337e.setVisibility(8);
            }
            if (this.f20342j != null) {
                this.f20338f.setOnClickListener(new View$OnClickListenerC1226a(this));
            }
            e();
            return this.f20334b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20341i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20335c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f20334b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f20336d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f20336d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f20337e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f20338f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f20338f, R.color.CAM_X0107);
            List<b> list = this.f20340h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.f20343k) {
                if (!StringUtils.isNull(this.f20339g) && (textView = this.f20336d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f20336d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f20340h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f20340h.get(0)) == null || bVar.f20353j) {
                    return;
                }
                bVar.f20353j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f20340h = list;
        this.f20335c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f20335c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f20342j = cVar;
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
            this.f20339g = str;
        }
    }
}
