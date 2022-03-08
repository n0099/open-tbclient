package com.baidu.nadcore.widget.uitemplate;

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
import c.a.b0.h0.r;
import c.a.b0.s.b;
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
/* loaded from: classes4.dex */
public class DislikeBottomDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f36004e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f36005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f36007g;

        public a(DislikeBottomDialog dislikeBottomDialog, List list, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dislikeBottomDialog, list, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36007g = dislikeBottomDialog;
            this.f36005e = list;
            this.f36006f = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f36007g.f36004e != null) {
                    this.f36007g.f36004e.a(this.f36005e);
                }
                this.f36007g.f(this.f36006f, this.f36005e);
                this.f36007g.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f36009f;

        public b(DislikeBottomDialog dislikeBottomDialog, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dislikeBottomDialog, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36009f = dislikeBottomDialog;
            this.f36008e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36009f.dismiss();
                c.a.b0.f.c.c(this.f36008e.f35662g.f1901c, this.f36009f.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f36010e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f36011f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TextView f36012g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f36013h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f36014i;

        public c(DislikeBottomDialog dislikeBottomDialog, b.a aVar, List list, TextView textView, TextView textView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dislikeBottomDialog, aVar, list, textView, textView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36014i = dislikeBottomDialog;
            this.f36010e = aVar;
            this.f36011f = list;
            this.f36012g = textView;
            this.f36013h = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f36010e.c()) {
                    this.f36010e.f(false);
                    if (this.f36011f.contains(this.f36010e)) {
                        c.a.b0.x.a.j(this.f36011f, this.f36010e);
                    }
                    if (this.f36011f.size() == 0) {
                        this.f36012g.setText(view.getContext().getResources().getText(R.string.nad_dislike_dislike));
                    }
                    this.f36013h.setTextColor(view.getContext().getResources().getColor(R.color.NAD_FC1));
                    return;
                }
                this.f36010e.f(true);
                if (!this.f36011f.contains(this.f36010e)) {
                    c.a.b0.x.a.b(this.f36011f, this.f36010e);
                }
                this.f36013h.setTextColor(view.getContext().getResources().getColor(R.color.NAD_FC13));
                this.f36012g.setText(view.getContext().getResources().getText(R.string.nad_dislike_done));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(List<b.a> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DislikeBottomDialog(Context context, @NonNull AdBaseModel adBaseModel) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e(adBaseModel);
    }

    public final void c(AdBaseModel adBaseModel) {
        int i2;
        c.a.b0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = null;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_dialog_menu_new_dislike, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_bottom);
            View findViewById = inflate.findViewById(R.id.line);
            textView.setText(getContext().getString(R.string.nad_dislike_dislike));
            textView.setOnClickListener(new a(this, arrayList, adBaseModel));
            inflate.setBackground(inflate.getContext().getResources().getDrawable(R.drawable.nad_bg_bottom_popup_ffffff));
            Resources resources = inflate.getContext().getResources();
            int i3 = R.color.NAD_FC1;
            textView.setTextColor(resources.getColor(R.color.NAD_FC1));
            findViewById.setBackgroundColor(inflate.getContext().getResources().getColor(R.color.NAD_FC96));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_enum);
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_why_show_ad);
            if (adBaseModel != null && (bVar = adBaseModel.f35662g) != null && !TextUtils.isEmpty(bVar.f1901c)) {
                if (!TextUtils.isEmpty(adBaseModel.f35662g.a)) {
                    textView2.setText(adBaseModel.f35662g.a);
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
            int i4 = 0;
            while (i4 < min) {
                b.a aVar = (b.a) c.a.b0.x.a.d(d2, i4);
                if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                    i2 = i4;
                } else {
                    View inflate2 = from.inflate(R.layout.nad_item_menu_new_dislike, viewGroup);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.tv_enum);
                    textView3.setText(aVar.a());
                    textView3.setTextColor(inflate.getContext().getResources().getColor(i3));
                    i2 = i4;
                    inflate2.setOnClickListener(new c(this, aVar, arrayList, textView, textView3));
                    linearLayout.addView(inflate2);
                }
                i4 = i2 + 1;
                viewGroup = null;
                i3 = R.color.NAD_FC1;
            }
            setContentView(inflate);
        }
    }

    public final List<b.a> d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.b0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel)) == null) {
            if (adBaseModel == null || (bVar = adBaseModel.f35662g) == null) {
                return null;
            }
            return bVar.f1900b;
        }
        return (List) invokeL.objValue;
    }

    public final void e(@NonNull AdBaseModel adBaseModel) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) || (window = getWindow()) == null) {
            return;
        }
        window.requestFeature(1);
        c(adBaseModel);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.nad_BottomInAndOutStyle;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
    }

    public final void f(AdBaseModel adBaseModel, List<b.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, adBaseModel, list) == null) || adBaseModel == null) {
            return;
        }
        c.a.b0.a0.a.b(new c.a.b0.a0.c.b().d(getReasons(list)).f(adBaseModel.f35661f.f1923d).e(c.a.b0.h.a.a().b()));
    }

    public String getReasons(List<b.a> list) {
        InterceptResult invokeL;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list == null) {
                return StringUtil.EMPTY_ARRAY;
            }
            String str = "";
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((b.a) c.a.b0.x.a.d(list, i2)) != null) {
                    str = !TextUtils.isEmpty(str) ? str + "," + aVar.b() : str + aVar.b();
                }
            }
            return TextUtils.isEmpty(str) ? StringUtil.EMPTY_ARRAY : str;
        }
        return (String) invokeL.objValue;
    }

    public void setDislikeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.f36004e = dVar;
        }
    }

    public void showInImmersive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Window window = getWindow();
            if (window == null) {
                c.a.b0.h0.a.b(this);
                return;
            }
            window.setFlags(8, 8);
            c.a.b0.h0.a.b(this);
            r.a(window);
            window.clearFlags(8);
        }
    }
}
