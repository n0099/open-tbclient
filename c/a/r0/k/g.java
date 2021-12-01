package c.a.r0.k;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.q.x0;
import c.a.r0.k.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public c.a.q0.s.g0.a C;
    public CompoundButton.OnCheckedChangeListener D;
    public PopupWindow.OnDismissListener E;
    public CustomMessageListener F;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18517b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f18518c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18519d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f18520e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f18521f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1093b> f18522g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18523h;

    /* renamed from: i  reason: collision with root package name */
    public int f18524i;

    /* renamed from: j  reason: collision with root package name */
    public int f18525j;

    /* renamed from: k  reason: collision with root package name */
    public int f18526k;
    public NEGFeedBackView.b l;
    public PopupWindow m;
    public View n;
    public c.a.r0.k.b o;
    public boolean p;
    public int q;
    public int r;
    public LinearLayout s;
    public f t;
    public InterfaceC1096g u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes6.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18527e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18527e = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f18527e.l != null) {
                    this.f18527e.l.onCheckedChanged(this.f18527e.f18520e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1093b) {
                    b.C1093b c1093b = (b.C1093b) compoundButton.getTag();
                    if (z) {
                        if (this.f18527e.f18522g.contains(c1093b)) {
                            return;
                        }
                        this.f18527e.f18522g.add(c1093b);
                        return;
                    }
                    this.f18527e.f18522g.remove(c1093b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18528e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18528e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18528e.m == null) {
                return;
            }
            this.f18528e.m.dismiss();
            this.f18528e.m = null;
            MessageManager.getInstance().unRegisterListener(this.f18528e.F);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18529e;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18529e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18529e.m != null) {
                    this.f18529e.m.dismiss();
                    this.f18529e.m = null;
                }
                if (this.f18529e.f18518c != null) {
                    this.f18529e.f18518c.dismiss();
                    this.f18529e.f18518c = null;
                }
                if (this.f18529e.f18523h) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.f18529e.B));
                }
                if (this.f18529e.t != null) {
                    this.f18529e.t.onClick();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18530e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18530e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f18530e.r();
                if (this.f18530e.B == "3" || this.f18530e.B == "4" || this.f18530e.B == "1") {
                    this.f18530e.q();
                } else if (r != null) {
                    this.f18530e.B();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f18530e.f18517b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onClick();
    }

    /* renamed from: c.a.r0.k.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1096g {
        void a(JSONArray jSONArray);
    }

    public g(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f18518c = null;
        this.f18520e = null;
        this.f18521f = null;
        this.f18522g = new ArrayList();
        this.l = null;
        this.q = 3;
        this.C = null;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.f18517b = tbPageContext;
        this.n = view;
        u();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a == null) {
            return;
        }
        this.B = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        p();
        this.f18524i = t() - l.f(this.a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f18525j, this.f18524i);
        this.f18518c = popupWindow;
        popupWindow.setFocusable(true);
        this.f18518c.setTouchable(true);
        this.f18518c.setOnDismissListener(this.E);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.m = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.m.showAtLocation(this.n, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f18518c, R.drawable.bg_dailog);
        this.f18518c.showAtLocation(this.n, 17, 0, 0);
        NEGFeedBackView.b bVar = this.l;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f18520e);
        }
        this.p = true;
        this.f18517b.registerListener(this.F);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.C == null) {
                this.C = new c.a.q0.s.g0.a(this.f18517b);
            }
            this.C.i(R.string.loading);
            this.C.h(true);
        }
    }

    public final void p() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.q) {
            return;
        }
        SkinManager.setBackgroundColor(this.f18519d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.A, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
        this.q = skinType;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PopupWindow popupWindow = this.f18518c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f18518c = null;
            }
            PopupWindow popupWindow2 = this.m;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.m = null;
            }
        }
    }

    public final JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f18520e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f18522g)) {
                int i3 = 0;
                while (i2 < this.f18522g.size()) {
                    b.C1093b c1093b = this.f18522g.get(i2);
                    if (c1093b != null) {
                        jSONArray.put(String.valueOf(c1093b.f18480b));
                        i3 = c1093b.a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.B).param("obj_type", i2));
            if (this.f18523h) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.B).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.B).param("obj_type", i2));
            }
            InterfaceC1096g interfaceC1096g = this.u;
            if (interfaceC1096g != null) {
                interfaceC1096g.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f18520e.g());
                jSONObject.put("type", this.f18520e.a());
                jSONObject.put("forum_id", this.f18520e.c());
                jSONObject.put("is_frs_masks", this.f18520e.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.f18519d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f18519d = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = textView;
                if (this.f18523h) {
                    textView.setText(R.string.shield_reason);
                }
                this.y = (TextView) this.f18519d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.o.g();
            if (g2 != null && g2.getParent() == null) {
                int f2 = l.f(this.a, R.dimen.ds40);
                g2.setPadding(f2, 0, f2, 0);
                this.f18519d.addView(g2);
            }
            if (this.s == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.s = linearLayout;
                this.w = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.v = (TextView) this.s.findViewById(R.id.dialog_bottom_certain_button);
                this.z = this.s.findViewById(R.id.top_line);
                this.A = this.s.findViewById(R.id.middle_line);
                this.f18519d.addView(this.s);
                this.w.setOnClickListener(new d(this));
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setOnClickListener(new e(this));
                }
                p();
            }
            return this.f18519d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f18519d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f18519d.getMeasuredHeight() + l.f(this.a, R.dimen.ds12);
            this.f18526k = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r = l.f(this.a, R.dimen.tbds32);
            this.f18525j = l.k(this.a) - (this.r * 2);
            c.a.r0.k.b bVar = new c.a.r0.k.b(this.f18517b);
            this.o = bVar;
            bVar.o(this.D);
            this.o.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.p && this.f18522g.size() != 0) {
            this.f18522g.clear();
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f18523h = z;
        }
    }

    public void x(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f18520e = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f18521f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f18521f.size() - 1; size >= 8; size--) {
                this.f18521f.removeAt(size);
            }
        }
        this.o.j(x0Var);
    }

    public void y(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, strArr) == null) {
            this.o.k(strArr);
        }
    }

    public void z(InterfaceC1096g interfaceC1096g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC1096g) == null) {
            this.u = interfaceC1096g;
        }
    }
}
