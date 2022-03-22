package c.a.p0.d4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends Dialog implements c.a.p0.d4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13690b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13691c;

    /* renamed from: d  reason: collision with root package name */
    public View f13692d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13693e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f13694f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f13695g;

    /* renamed from: h  reason: collision with root package name */
    public View f13696h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        e();
    }

    @Override // c.a.p0.d4.a
    public void a(int i) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (findViewWithTag = this.f13693e.findViewWithTag(Integer.valueOf(i))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    @Override // c.a.p0.d4.a
    public void b(int i) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (findViewWithTag = this.f13693e.findViewWithTag(Integer.valueOf(i))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // c.a.p0.d4.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.f13690b.setText(tag.getBname());
            this.f13691c.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i = 0;
            while (i < card_list.size()) {
                View a2 = new a(this, card_list.get(i), this.f13694f).a();
                this.f13693e.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225);
                layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d0) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i != card_list.size() - 1) {
                    this.f13693e.addView(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0610, (ViewGroup) null));
                }
                i++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07022f)) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025c) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a);
            float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070235);
            if (size > dimensionPixelSize2) {
                attributes.height = (int) dimensionPixelSize2;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d060d, null);
            this.f13696h = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.f13695g = (LinearLayout) this.f13696h.findViewById(R.id.obfuscated_res_0x7f0903e5);
            this.f13690b = (TextView) this.f13696h.findViewById(R.id.obfuscated_res_0x7f091943);
            this.f13691c = (TextView) this.f13696h.findViewById(R.id.obfuscated_res_0x7f091942);
            this.f13692d = this.f13696h.findViewById(R.id.obfuscated_res_0x7f0923c8);
            this.f13693e = (LinearLayout) this.f13696h.findViewById(R.id.obfuscated_res_0x7f0911d2);
            this.f13692d.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0802e2));
        }
    }

    @Override // c.a.p0.d4.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13696h : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.p0.d4.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = this.a;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.p0.d4.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f13694f = onClickListener;
            this.f13695g.setOnClickListener(onClickListener);
        }
    }

    @Override // android.app.Dialog, c.a.p0.d4.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.a;
            if (!(context instanceof Activity) || g.e((Activity) context)) {
                super.show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13697b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13698c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f13699d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f13700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f13701f;

        public a(e eVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f13701f = eVar;
            View inflate = LayoutInflater.from(eVar.a).inflate(R.layout.obfuscated_res_0x7f0d0613, (ViewGroup) null);
            this.a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f13700e.setOnClickListener(onClickListener);
                this.f13700e.setTag(card);
                this.f13697b.setText(card.getFname());
                if (card.getOrder() == 1) {
                    drawable = this.f13701f.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a36);
                } else {
                    drawable = card.getOrder() == 2 ? this.f13701f.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a34) : null;
                }
                this.f13697b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                this.f13698c.setText(card.getCdesc());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f13697b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0921ac);
                this.f13698c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09218e);
                this.f13699d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090fde);
                this.f13700e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0912fc);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f13699d.setBackgroundDrawable(this.f13701f.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a35));
                } else {
                    this.f13699d.setBackgroundDrawable(this.f13701f.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a37));
                }
            }
        }

        public a(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13701f = eVar;
            this.a = view;
            c();
        }
    }
}
