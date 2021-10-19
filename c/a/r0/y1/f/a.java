package c.a.r0.y1.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.r0.y1.f.f;
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
    public CardBoxMemberPayActivity f28804a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f28805b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28806c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f28807d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28808e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28809f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f28810g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28811h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28812i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f28813j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<f.d> p;
    public f.d q;
    public String r;

    /* renamed from: c.a.r0.y1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1347a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28814e;

        public View$OnClickListenerC1347a(a aVar, List<f.d> list) {
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
            this.f28814e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f28814e.f28810g == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f28814e.f28810g.getChildCount(); i2++) {
                View childAt = this.f28814e.f28810g.getChildAt(i2);
                if (childAt == null || childAt.getTag() == null) {
                    return;
                }
                f.d dVar = childAt.getTag() instanceof f.d ? (f.d) childAt.getTag() : null;
                if (dVar == null) {
                    return;
                }
                if (view == childAt) {
                    dVar.m = true;
                    this.f28814e.q = dVar;
                    this.f28814e.r = dVar.f28866g;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0305);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                } else {
                    dVar.m = false;
                    SkinManager.setViewTextColor(childAt, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                }
            }
            this.f28814e.p();
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
        this.f28804a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.card_box_member_pay_activity);
        this.m = this.f28804a.findViewById(R.id.card_box_member_pay_root_view);
        LinearLayout linearLayout = (LinearLayout) this.f28804a.findViewById(R.id.card_box_member_pay_info);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.f28804a.findViewById(R.id.empty_layout);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f28805b = (TbImageView) this.f28804a.findViewById(R.id.title_image);
        this.f28806c = (TextView) this.f28804a.findViewById(R.id.title_info);
        this.f28807d = (HeadImageView) this.f28804a.findViewById(R.id.head_portrait);
        this.f28808e = (TextView) this.f28804a.findViewById(R.id.user_name);
        this.f28809f = (TextView) this.f28804a.findViewById(R.id.desc_info);
        this.f28810g = (LinearLayout) this.f28804a.findViewById(R.id.choice_month_info);
        this.f28811h = (TextView) this.f28804a.findViewById(R.id.before_discount);
        this.f28812i = (TextView) this.f28804a.findViewById(R.id.after_discount);
        this.f28813j = (TextView) this.f28804a.findViewById(R.id.discount_desc);
        TextView textView = (TextView) this.f28804a.findViewById(R.id.open_member_view);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.f28804a.findViewById(R.id.card_box_member_agreement_view);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f28811h.getPaint().setFlags(16);
        this.f28807d.setIsRound(true);
        this.f28807d.setDrawBorder(false);
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
            TextView textView = this.f28806c;
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
            this.f28804a.getLayoutMode().k(i2 == 1);
            this.f28804a.getLayoutMode().j(this.m);
        }
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || (bVar = fVar.f28847b) == null || (aVar = bVar.f28854b) == null) {
            return;
        }
        this.p = aVar.f28848a;
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
        this.f28810g.removeAllViews();
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            f.d dVar = this.p.get(i2);
            if (dVar != null) {
                TextView textView = new TextView(this.f28804a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.f28804a.getResources().getDimension(R.dimen.ds16), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f28861b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.f28804a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (dVar.m) {
                    this.r = dVar.f28866g;
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1347a(this, this.p));
                this.f28810g.addView(textView);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        TextView textView = this.f28812i;
        textView.setText(this.f28804a.getResources().getString(R.string.yuan) + (this.q.f28869j / 100));
        if (!k.isEmpty(this.q.f28863d)) {
            TextView textView2 = this.f28811h;
            textView2.setText(this.f28804a.getResources().getString(R.string.origin_price) + this.q.f28863d);
        }
        this.f28813j.setText(this.q.f28865f);
    }

    public final void q(f fVar) {
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || fVar == null) {
            return;
        }
        f.g gVar = fVar.f28846a;
        if (gVar != null) {
            this.f28807d.startLoad(gVar.f28873b, 12, false);
            this.f28808e.setText(fVar.f28846a.f28872a);
            f.e eVar = fVar.f28846a.f28874c;
            if (eVar != null) {
                if (eVar.f28870a > 0) {
                    this.k.setText(this.f28804a.getResources().getString(R.string.renew_now));
                }
                this.f28805b.startLoad(fVar.f28846a.f28874c.f28871b, 21, false);
            }
        }
        f.b bVar = fVar.f28847b;
        if (bVar == null || (aVar = bVar.f28854b) == null) {
            return;
        }
        this.f28809f.setText(aVar.f28851d);
        this.f28806c.setText(fVar.f28847b.f28854b.f28850c);
    }
}
