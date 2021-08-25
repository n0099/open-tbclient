package c.a.q0.w1.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.w1.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CardBoxMemberPayActivity f27921a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f27922b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27923c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f27924d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27925e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27926f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f27927g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27928h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27929i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f27930j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<f.d> p;
    public f.d q;
    public String r;

    /* renamed from: c.a.q0.w1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1303a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27931e;

        public View$OnClickListenerC1303a(a aVar, List<f.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27931e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27931e.f27927g == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f27931e.f27927g.getChildCount(); i2++) {
                View childAt = this.f27931e.f27927g.getChildAt(i2);
                if (childAt == null || childAt.getTag() == null) {
                    return;
                }
                f.d dVar = childAt.getTag() instanceof f.d ? (f.d) childAt.getTag() : null;
                if (dVar == null) {
                    return;
                }
                if (view == childAt) {
                    dVar.m = true;
                    this.f27931e.q = dVar;
                    this.f27931e.r = dVar.f27983g;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0305);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                } else {
                    dVar.m = false;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                }
            }
            this.f27931e.p();
        }
    }

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cardBoxMemberPayActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = "";
        this.f27921a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.card_box_member_pay_activity);
        this.m = this.f27921a.findViewById(R.id.card_box_member_pay_root_view);
        LinearLayout linearLayout = (LinearLayout) this.f27921a.findViewById(R.id.card_box_member_pay_info);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.f27921a.findViewById(R.id.empty_layout);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f27922b = (TbImageView) this.f27921a.findViewById(R.id.title_image);
        this.f27923c = (TextView) this.f27921a.findViewById(R.id.title_info);
        this.f27924d = (HeadImageView) this.f27921a.findViewById(R.id.head_portrait);
        this.f27925e = (TextView) this.f27921a.findViewById(R.id.user_name);
        this.f27926f = (TextView) this.f27921a.findViewById(R.id.desc_info);
        this.f27927g = (LinearLayout) this.f27921a.findViewById(R.id.choice_month_info);
        this.f27928h = (TextView) this.f27921a.findViewById(R.id.before_discount);
        this.f27929i = (TextView) this.f27921a.findViewById(R.id.after_discount);
        this.f27930j = (TextView) this.f27921a.findViewById(R.id.discount_desc);
        TextView textView = (TextView) this.f27921a.findViewById(R.id.open_member_view);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.f27921a.findViewById(R.id.card_box_member_agreement_view);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f27928h.getPaint().setFlags(16);
        this.f27924d.setIsRound(true);
        this.f27924d.setDrawBorder(false);
    }

    public f.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (f.d) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public LinearLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (LinearLayout) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TextView textView = this.f27923c;
            if (textView != null) {
                return textView.getText().toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f27921a.getLayoutMode().k(i2 == 1);
            this.f27921a.getLayoutMode().j(this.m);
        }
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || (bVar = fVar.f27964b) == null || (aVar = bVar.f27971b) == null) {
            return;
        }
        this.p = aVar.f27965a;
    }

    public final void l() {
        List<f.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.p) == null || list.size() <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            f.d dVar = this.p.get(i2);
            if (dVar != null && dVar.m) {
                this.q = dVar;
                return;
            }
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        k(fVar);
        l();
        q(fVar);
        p();
        o();
    }

    public String n(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i2)) == null) {
            if (str == null) {
                return "";
            }
            if (str.length() > i2) {
                return str.substring(0, i2 - 1) + "...";
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public final void o() {
        List<f.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.p) == null || list.size() <= 0) {
            return;
        }
        this.f27927g.removeAllViews();
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            f.d dVar = this.p.get(i2);
            if (dVar != null) {
                TextView textView = new TextView(this.f27921a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.f27921a.getResources().getDimension(R.dimen.ds16), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f27978b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.f27921a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (dVar.m) {
                    this.r = dVar.f27983g;
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1303a(this, this.p));
                this.f27927g.addView(textView);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        TextView textView = this.f27929i;
        textView.setText(this.f27921a.getResources().getString(R.string.yuan) + (this.q.f27986j / 100));
        if (!k.isEmpty(this.q.f27980d)) {
            TextView textView2 = this.f27928h;
            textView2.setText(this.f27921a.getResources().getString(R.string.origin_price) + this.q.f27980d);
        }
        this.f27930j.setText(this.q.f27982f);
    }

    public final void q(f fVar) {
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || fVar == null) {
            return;
        }
        f.g gVar = fVar.f27963a;
        if (gVar != null) {
            this.f27924d.startLoad(gVar.f27990b, 12, false);
            this.f27925e.setText(fVar.f27963a.f27989a);
            f.e eVar = fVar.f27963a.f27991c;
            if (eVar != null) {
                if (eVar.f27987a > 0) {
                    this.k.setText(this.f27921a.getResources().getString(R.string.renew_now));
                }
                this.f27922b.startLoad(fVar.f27963a.f27991c.f27988b, 21, false);
            }
        }
        f.b bVar = fVar.f27964b;
        if (bVar == null || (aVar = bVar.f27971b) == null) {
            return;
        }
        this.f27926f.setText(aVar.f27968d);
        this.f27923c.setText(fVar.f27964b.f27971b.f27967c);
    }
}
