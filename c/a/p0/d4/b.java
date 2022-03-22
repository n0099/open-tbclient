package c.a.p0.d4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends Dialog implements c.a.p0.d4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13663b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13664c;

    /* renamed from: d  reason: collision with root package name */
    public View f13665d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13666e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f13667f;

    /* renamed from: g  reason: collision with root package name */
    public View f13668g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f13669h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i) {
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
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (findViewWithTag = this.f13666e.findViewWithTag(Integer.valueOf(i))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    @Override // c.a.p0.d4.a
    public void b(int i) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (findViewWithTag = this.f13666e.findViewWithTag(Integer.valueOf(i))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // c.a.p0.d4.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.f13663b.setText(tag.getBname());
            this.f13664c.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i = 0;
            while (i < card_list.size()) {
                InterestFrsData.Card card = card_list.get(i);
                View a2 = new a(this, card, this.f13667f).a();
                this.f13666e.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.setMargins(0, i == 0 ? this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bc) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i != card_list.size() - 1) {
                    this.f13666e.addView(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0610, (ViewGroup) null));
                }
                ((TbImageView) this.f13666e.findViewWithTag(card.getAvatar())).J(card.getAvatar(), 10, false);
                i++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070240)) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025c) + getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a);
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
            this.f13668g = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.f13669h = (LinearLayout) this.f13668g.findViewById(R.id.obfuscated_res_0x7f0903e5);
            this.f13663b = (TextView) this.f13668g.findViewById(R.id.obfuscated_res_0x7f091943);
            this.f13664c = (TextView) this.f13668g.findViewById(R.id.obfuscated_res_0x7f091942);
            this.f13665d = this.f13668g.findViewById(R.id.obfuscated_res_0x7f0923c8);
            this.f13666e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911d2);
            this.f13665d.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0802e4));
        }
    }

    @Override // c.a.p0.d4.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13668g : (View) invokeV.objValue;
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
            this.f13667f = onClickListener;
            this.f13669h.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13670b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13671c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13672d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f13673e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f13674f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f13675g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f13676h;

        public a(b bVar, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f13676h = bVar;
            View inflate = LayoutInflater.from(bVar.a).inflate(R.layout.obfuscated_res_0x7f0d0612, (ViewGroup) null);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f13675g.setOnClickListener(onClickListener);
                this.f13675g.setTag(card);
                this.f13670b.setText(card.getFname());
                this.f13671c.setText(card.getCdesc());
                this.f13672d.setText(card.getSlogan());
                this.f13674f.setTag(card.getAvatar());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f13670b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0921ac);
                this.f13671c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09218e);
                this.f13673e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090fde);
                this.f13672d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09220b);
                this.f13674f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090e94);
                this.f13675g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0912fc);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f13673e.setBackgroundDrawable(this.f13676h.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a35));
                } else {
                    this.f13673e.setBackgroundDrawable(this.f13676h.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a37));
                }
            }
        }

        public a(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13676h = bVar;
            this.a = view;
            c();
        }
    }
}
