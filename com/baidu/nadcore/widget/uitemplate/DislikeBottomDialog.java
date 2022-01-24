package com.baidu.nadcore.widget.uitemplate;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.d.h;
import c.a.c0.d.i;
import c.a.c0.g0.p;
import c.a.c0.s.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class DislikeBottomDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f37369e;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f37370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f37371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f37372g;

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
            this.f37372g = dislikeBottomDialog;
            this.f37370e = list;
            this.f37371f = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f37372g.f37369e != null) {
                    this.f37372g.f37369e.a(this.f37370e);
                }
                this.f37372g.f(this.f37371f, this.f37370e);
                this.f37372g.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f37373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f37374f;

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
            this.f37374f = dislikeBottomDialog;
            this.f37373e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37374f.dismiss();
                c.a.c0.f.d.c(this.f37373e.f37045e.f2218c, this.f37374f.getContext());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f37375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f37376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TextView f37377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f37378h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DislikeBottomDialog f37379i;

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
            this.f37379i = dislikeBottomDialog;
            this.f37375e = aVar;
            this.f37376f = list;
            this.f37377g = textView;
            this.f37378h = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f37375e.c()) {
                    this.f37375e.d(false);
                    if (this.f37376f.contains(this.f37375e)) {
                        c.a.c0.x.a.j(this.f37376f, this.f37375e);
                    }
                    if (this.f37376f.size() == 0) {
                        this.f37377g.setText(view.getContext().getResources().getText(h.nad_dislike_dislike));
                    }
                    this.f37378h.setTextColor(view.getContext().getResources().getColor(c.a.c0.d.b.NAD_FC1));
                    return;
                }
                this.f37375e.d(true);
                if (!this.f37376f.contains(this.f37375e)) {
                    c.a.c0.x.a.b(this.f37376f, this.f37375e);
                }
                this.f37378h.setTextColor(view.getContext().getResources().getColor(c.a.c0.d.b.NAD_FC13));
                this.f37377g.setText(view.getContext().getResources().getText(h.nad_dislike_done));
            }
        }
    }

    /* loaded from: classes10.dex */
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
        ArrayList arrayList;
        c.a.c0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            ArrayList arrayList2 = new ArrayList();
            ViewGroup viewGroup = null;
            View inflate = LayoutInflater.from(getContext()).inflate(g.nad_dialog_menu_new_dislike, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(e.tv_bottom);
            View findViewById = inflate.findViewById(e.line);
            textView.setText(getContext().getString(h.nad_dislike_dislike));
            textView.setOnClickListener(new a(this, arrayList2, adBaseModel));
            inflate.setBackground(inflate.getContext().getResources().getDrawable(c.a.c0.d.d.nad_bg_bottom_popup_ffffff));
            textView.setTextColor(inflate.getContext().getResources().getColor(c.a.c0.d.b.NAD_FC1));
            findViewById.setBackgroundColor(inflate.getContext().getResources().getColor(c.a.c0.d.b.NAD_FC96));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(e.layout_enum);
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            TextView textView2 = (TextView) inflate.findViewById(e.tv_why_show_ad);
            if (adBaseModel != null && (bVar = adBaseModel.f37045e) != null && !TextUtils.isEmpty(bVar.f2218c)) {
                if (!TextUtils.isEmpty(adBaseModel.f37045e.a)) {
                    textView2.setText(adBaseModel.f37045e.a);
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
            int i2 = 0;
            while (i2 < min) {
                b.a aVar = (b.a) c.a.c0.x.a.d(d2, i2);
                if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                    arrayList = arrayList2;
                } else {
                    View inflate2 = from.inflate(g.nad_item_menu_new_dislike, viewGroup);
                    TextView textView3 = (TextView) inflate2.findViewById(e.tv_enum);
                    textView3.setText(aVar.a());
                    textView3.setTextColor(inflate.getContext().getResources().getColor(c.a.c0.d.b.NAD_FC1));
                    arrayList = arrayList2;
                    inflate2.setOnClickListener(new c(this, aVar, arrayList2, textView, textView3));
                    linearLayout.addView(inflate2);
                }
                i2++;
                arrayList2 = arrayList;
                viewGroup = null;
            }
            setContentView(inflate);
        }
    }

    public final List<b.a> d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.s.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel)) == null) {
            if (adBaseModel == null || (bVar = adBaseModel.f37045e) == null) {
                return null;
            }
            return bVar.f2217b;
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
        attributes.windowAnimations = i.nad_BottomInAndOutStyle;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
    }

    public final void f(AdBaseModel adBaseModel, List<b.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, adBaseModel, list) == null) || adBaseModel == null) {
            return;
        }
        c.a.c0.a0.a.b(new c.a.c0.a0.c.b().d(getReasons(list)).f(adBaseModel.f37044d.f2233b).e(c.a.c0.h.a.a().b()));
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
                if (((b.a) c.a.c0.x.a.d(list, i2)) != null) {
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
            this.f37369e = dVar;
        }
    }

    public void showInImmersive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Window window = getWindow();
            if (window == null) {
                c.a.c0.g0.a.b(this);
                return;
            }
            window.setFlags(8, 8);
            c.a.c0.g0.a.b(this);
            p.a(window);
            window.clearFlags(8);
        }
    }
}
