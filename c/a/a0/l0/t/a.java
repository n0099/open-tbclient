package c.a.a0.l0.t;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.a0.h0.r;
import c.a.a0.s.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: c.a.a0.l0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0064a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f1490b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f1491c;

        public View$OnClickListenerC0064a(a aVar, List list, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1491c = aVar;
            this.a = list;
            this.f1490b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f1491c.a != null) {
                    this.f1491c.a.a(this.a);
                }
                this.f1491c.g(this.f1490b, this.a);
                this.f1491c.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1492b;

        public b(a aVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1492b = aVar;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f1492b.dismiss();
                c.a.a0.g.c.c(this.a.f27544g.f1528c, this.f1492b.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1493b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f1494c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f1495d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1496e;

        public c(a aVar, b.a aVar2, List list, TextView textView, TextView textView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, list, textView, textView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1496e = aVar;
            this.a = aVar2;
            this.f1493b = list;
            this.f1494c = textView;
            this.f1495d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.c()) {
                    this.a.f(false);
                    if (this.f1493b.contains(this.a)) {
                        c.a.a0.x.a.j(this.f1493b, this.a);
                    }
                    if (this.f1493b.size() == 0) {
                        this.f1494c.setText(view.getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0b6d));
                    }
                    this.f1495d.setTextColor(view.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06024e));
                    return;
                }
                this.a.f(true);
                if (!this.f1493b.contains(this.a)) {
                    c.a.a0.x.a.b(this.f1493b, this.a);
                }
                this.f1495d.setTextColor(view.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06025c));
                this.f1494c.setText(view.getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0b6e));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(List<b.a> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull AdBaseModel adBaseModel) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel};
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
        f(adBaseModel);
    }

    public final void c(AdBaseModel adBaseModel) {
        int i;
        c.a.a0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = null;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05aa, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09218a);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091255);
            textView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0b6d));
            textView.setOnClickListener(new View$OnClickListenerC0064a(this, arrayList, adBaseModel));
            inflate.setBackground(inflate.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d87));
            Resources resources = inflate.getContext().getResources();
            int i2 = R.color.obfuscated_res_0x7f06024e;
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06024e));
            findViewById.setBackgroundColor(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0602a7));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0911d8);
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09222f);
            if (adBaseModel != null && (bVar = adBaseModel.f27544g) != null && !TextUtils.isEmpty(bVar.f1528c)) {
                if (!TextUtils.isEmpty(adBaseModel.f27544g.a)) {
                    textView2.setText(adBaseModel.f27544g.a);
                }
                textView2.setVisibility(0);
                textView2.setOnClickListener(new b(this, adBaseModel));
            } else {
                textView2.setVisibility(8);
            }
            List<b.a> d2 = d(adBaseModel);
            if (d2 == null) {
                linearLayout.setVisibility(8);
                return;
            }
            int min = Math.min(d2.size(), 7);
            int i3 = 0;
            while (i3 < min) {
                b.a aVar = (b.a) c.a.a0.x.a.d(d2, i3);
                if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                    i = i3;
                } else {
                    View inflate2 = from.inflate(R.layout.obfuscated_res_0x7f0d05b7, viewGroup);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f0921a8);
                    textView3.setText(aVar.a());
                    textView3.setTextColor(inflate.getContext().getResources().getColor(i2));
                    i = i3;
                    inflate2.setOnClickListener(new c(this, aVar, arrayList, textView, textView3));
                    linearLayout.addView(inflate2);
                }
                i3 = i + 1;
                viewGroup = null;
                i2 = R.color.obfuscated_res_0x7f06024e;
            }
            setContentView(inflate);
        }
    }

    public final List<b.a> d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.a0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel)) == null) {
            if (adBaseModel == null || (bVar = adBaseModel.f27544g) == null) {
                return null;
            }
            return bVar.f1527b;
        }
        return (List) invokeL.objValue;
    }

    public String e(List<b.a> list) {
        InterceptResult invokeL;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return StringUtil.EMPTY_ARRAY;
            }
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if (((b.a) c.a.a0.x.a.d(list, i)) != null) {
                    str = !TextUtils.isEmpty(str) ? str + "," + aVar.b() : str + aVar.b();
                }
            }
            return TextUtils.isEmpty(str) ? StringUtil.EMPTY_ARRAY : str;
        }
        return (String) invokeL.objValue;
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || (window = getWindow()) == null) {
            return;
        }
        window.requestFeature(1);
        c(adBaseModel);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.obfuscated_res_0x7f1003b7;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
    }

    public final void g(AdBaseModel adBaseModel, List<b.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, list) == null) || adBaseModel == null) {
            return;
        }
        c.a.a0.a0.a.b(new c.a.a0.a0.c.b().d(e(list)).f(adBaseModel.f27543f.f1549d).e(c.a.a0.h.a.a().b()));
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.a = dVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Window window = getWindow();
            if (window == null) {
                c.a.a0.h0.a.b(this);
                return;
            }
            window.setFlags(8, 8);
            c.a.a0.h0.a.b(this);
            r.a(window);
            window.clearFlags(8);
        }
    }
}
