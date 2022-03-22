package c.a.p0.j2.f;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.p0.j2.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardBoxMemberPayActivity a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f15708b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15709c;

    /* renamed from: d  reason: collision with root package name */
    public HeadImageView f15710d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15711e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15712f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15713g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15714h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public View o;
    public List<f.d> p;
    public f.d q;
    public String r;

    /* renamed from: c.a.p0.j2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1180a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1180a(a aVar, List<f.d> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f15713g == null) {
                return;
            }
            for (int i = 0; i < this.a.f15713g.getChildCount(); i++) {
                View childAt = this.a.f15713g.getChildAt(i);
                if (childAt == null || childAt.getTag() == null) {
                    return;
                }
                f.d dVar = childAt.getTag() instanceof f.d ? (f.d) childAt.getTag() : null;
                if (dVar == null) {
                    return;
                }
                if (view == childAt) {
                    dVar.m = true;
                    this.a.q = dVar;
                    this.a.r = dVar.f15751g;
                    SkinManager.setViewTextColor(childAt, (int) R.color.CAM_X0305);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_selected_bg);
                } else {
                    dVar.m = false;
                    SkinManager.setViewTextColor(childAt, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(childAt, R.drawable.card_box_normal_bg);
                }
            }
            this.a.p();
        }
    }

    public a(CardBoxMemberPayActivity cardBoxMemberPayActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cardBoxMemberPayActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = "";
        this.a = cardBoxMemberPayActivity;
        cardBoxMemberPayActivity.setContentView(R.layout.obfuscated_res_0x7f0d017c);
        this.m = this.a.findViewById(R.id.obfuscated_res_0x7f0904ce);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0904cd);
        this.n = linearLayout;
        linearLayout.setOnClickListener(cardBoxMemberPayActivity);
        View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0908be);
        this.o = findViewById;
        findViewById.setOnClickListener(cardBoxMemberPayActivity);
        this.f15708b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092045);
        this.f15709c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092046);
        this.f15710d = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d24);
        this.f15711e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.f15712f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09077e);
        this.f15713g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090611);
        this.f15714h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090354);
        this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09014a);
        this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0907c3);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091608);
        this.k = textView;
        textView.setOnClickListener(cardBoxMemberPayActivity);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0904cc);
        this.l = textView2;
        textView2.setOnClickListener(cardBoxMemberPayActivity);
        this.f15714h.getPaint().setFlags(16);
        this.f15710d.setIsRound(true);
        this.f15710d.setDrawBorder(false);
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
            TextView textView = this.f15709c;
            if (textView != null) {
                return textView.getText().toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.m);
        }
    }

    public final void k(f fVar) {
        f.b bVar;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || (bVar = fVar.f15736b) == null || (aVar = bVar.f15741b) == null) {
            return;
        }
        this.p = aVar.a;
    }

    public final void l() {
        List<f.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.p) == null || list.size() <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            f.d dVar = this.p.get(i);
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

    public String n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (str == null) {
                return "";
            }
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
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
        this.f15713g.removeAllViews();
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            f.d dVar = this.p.get(i);
            if (dVar != null) {
                TextView textView = new TextView(this.a.getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                layoutParams.setMargins(0, 0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be), 0);
                textView.setLayoutParams(layoutParams);
                textView.setText(n(dVar.f15746b, 7));
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                if (dVar.m) {
                    this.r = dVar.f15751g;
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0312);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_selected_bg);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundResource(textView, R.drawable.card_box_normal_bg);
                }
                textView.setTag(dVar);
                textView.setOnClickListener(new View$OnClickListenerC1180a(this, this.p));
                this.f15713g.addView(textView);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        TextView textView = this.i;
        textView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15d9) + (this.q.j / 100));
        if (!m.isEmpty(this.q.f15748d)) {
            TextView textView2 = this.f15714h;
            textView2.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ce1) + this.q.f15748d);
        }
        this.j.setText(this.q.f15750f);
    }

    public final void q(f fVar) {
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) || fVar == null) {
            return;
        }
        f.g gVar = fVar.a;
        if (gVar != null) {
            this.f15710d.J(gVar.f15754b, 12, false);
            this.f15711e.setText(fVar.a.a);
            f.e eVar = fVar.a.f15755c;
            if (eVar != null) {
                if (eVar.a > 0) {
                    this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f84));
                }
                this.f15708b.J(fVar.a.f15755c.f15753b, 21, false);
            }
        }
        f.b bVar = fVar.f15736b;
        if (bVar == null || (aVar = bVar.f15741b) == null) {
            return;
        }
        this.f15712f.setText(aVar.f15739d);
        this.f15709c.setText(fVar.f15736b.f15741b.f15738c);
    }
}
