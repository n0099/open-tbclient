package c.a.s0.m4;

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
    public View f19596b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19597c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19598d;

    /* renamed from: e  reason: collision with root package name */
    public View f19599e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19600f;

    /* renamed from: g  reason: collision with root package name */
    public String f19601g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f19602h;

    /* renamed from: i  reason: collision with root package name */
    public e f19603i;

    /* renamed from: j  reason: collision with root package name */
    public c f19604j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19605k;

    /* renamed from: c.a.s0.m4.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1180a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19606e;

        public View$OnClickListenerC1180a(a aVar) {
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
            this.f19606e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19606e.f19604j.onClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f19607b;

        /* renamed from: c  reason: collision with root package name */
        public View f19608c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19609d;

        /* renamed from: e  reason: collision with root package name */
        public View f19610e;

        /* renamed from: f  reason: collision with root package name */
        public String f19611f;

        /* renamed from: g  reason: collision with root package name */
        public int f19612g;

        /* renamed from: h  reason: collision with root package name */
        public d f19613h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19614i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19615j;

        /* renamed from: k  reason: collision with root package name */
        public final View.OnClickListener f19616k;

        /* renamed from: c.a.s0.m4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1181a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19617e;

            public View$OnClickListenerC1181a(b bVar) {
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
                this.f19617e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f19617e.f19613h != null) {
                        this.f19617e.f19613h.onClick();
                    }
                    if (this.f19617e.f19607b == null || this.f19617e.f19607b.c() == null) {
                        return;
                    }
                    this.f19617e.f19607b.c().a(this.f19617e.a, view);
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
            this.f19612g = 17;
            this.f19614i = true;
            this.f19616k = new View$OnClickListenerC1181a(this);
            this.f19611f = str;
            this.f19607b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19608c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f19609d) == null) {
                return;
            }
            textView.setOnClickListener(this.f19616k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f19607b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f19607b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f19607b.d(), false);
            this.f19608c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f19609d = textView;
            textView.setText(this.f19611f);
            this.f19609d.setGravity(this.f19612g);
            View findViewById = this.f19608c.findViewById(R.id.divider_line);
            this.f19610e = findViewById;
            if (this.f19614i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f19609d;
                if (textView != null) {
                    if (this.f19615j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f19609d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f19610e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f19613h = dVar;
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
        this.f19596b = inflate;
        this.f19597c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f19598d = (TextView) this.f19596b.findViewById(R.id.title);
        this.f19599e = this.f19596b.findViewById(R.id.title_divide_line);
        this.f19602h = new ArrayList();
        this.f19600f = (TextView) this.f19596b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f19601g)) {
                this.f19598d.setText(this.f19601g);
                this.f19599e.setVisibility(0);
            } else {
                this.f19598d.setVisibility(8);
                this.f19599e.setVisibility(8);
            }
            if (this.f19604j != null) {
                this.f19600f.setOnClickListener(new View$OnClickListenerC1180a(this));
            }
            e();
            return this.f19596b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19603i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19597c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f19596b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19598d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f19598d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f19599e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f19600f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f19600f, R.color.CAM_X0107);
            List<b> list = this.f19602h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.f19605k) {
                if (!StringUtils.isNull(this.f19601g) && (textView = this.f19598d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f19598d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f19602h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f19602h.get(0)) == null || bVar.f19615j) {
                    return;
                }
                bVar.f19615j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f19602h = list;
        this.f19597c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f19597c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f19604j = cVar;
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
            this.f19601g = str;
        }
    }
}
