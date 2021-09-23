package c.a.r0.i;

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
import c.a.e.e.p.l;
import c.a.q0.s.q.x0;
import c.a.r0.i.b;
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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public c.a.q0.s.f0.a C;
    public CompoundButton.OnCheckedChangeListener D;
    public PopupWindow.OnDismissListener E;
    public CustomMessageListener F;

    /* renamed from: a  reason: collision with root package name */
    public Context f19091a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19092b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f19093c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19094d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f19095e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f19096f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C0920b> f19097g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19098h;

    /* renamed from: i  reason: collision with root package name */
    public int f19099i;

    /* renamed from: j  reason: collision with root package name */
    public int f19100j;
    public int k;
    public NEGFeedBackView.b l;
    public PopupWindow m;
    public View n;
    public c.a.r0.i.b o;
    public boolean p;
    public int q;
    public int r;
    public LinearLayout s;
    public f t;
    public InterfaceC0923g u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19101e;

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
            this.f19101e = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f19101e.l != null) {
                    this.f19101e.l.onCheckedChanged(this.f19101e.f19095e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C0920b) {
                    b.C0920b c0920b = (b.C0920b) compoundButton.getTag();
                    if (z) {
                        if (this.f19101e.f19097g.contains(c0920b)) {
                            return;
                        }
                        this.f19101e.f19097g.add(c0920b);
                        return;
                    }
                    this.f19101e.f19097g.remove(c0920b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19102e;

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
            this.f19102e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19102e.m == null) {
                return;
            }
            this.f19102e.m.dismiss();
            this.f19102e.m = null;
            MessageManager.getInstance().unRegisterListener(this.f19102e.F);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19103a;

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
            this.f19103a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f19103a.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19104e;

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
            this.f19104e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19104e.m != null) {
                    this.f19104e.m.dismiss();
                    this.f19104e.m = null;
                }
                if (this.f19104e.f19093c != null) {
                    this.f19104e.f19093c.dismiss();
                    this.f19104e.f19093c = null;
                }
                if (this.f19104e.f19098h) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.f19104e.B));
                }
                if (this.f19104e.t != null) {
                    this.f19104e.t.onClick();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f19105e;

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
            this.f19105e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f19105e.r();
                if (this.f19105e.B == "3" || this.f19105e.B == "4" || this.f19105e.B == "1") {
                    this.f19105e.q();
                } else if (r != null) {
                    this.f19105e.B();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f19105e.f19092b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onClick();
    }

    /* renamed from: c.a.r0.i.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0923g {
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
        this.f19091a = null;
        this.f19093c = null;
        this.f19095e = null;
        this.f19096f = null;
        this.f19097g = new ArrayList();
        this.l = null;
        this.q = 3;
        this.C = null;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this, 2001304);
        this.f19091a = tbPageContext.getPageActivity();
        this.f19092b = tbPageContext;
        this.n = view;
        u();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f19091a == null) {
            return;
        }
        this.B = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        p();
        this.f19099i = t() - l.g(this.f19091a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f19100j, this.f19099i);
        this.f19093c = popupWindow;
        popupWindow.setFocusable(true);
        this.f19093c.setTouchable(true);
        this.f19093c.setOnDismissListener(this.E);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f19091a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.m = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.m.showAtLocation(this.n, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f19093c, R.drawable.bg_dailog);
        this.f19093c.showAtLocation(this.n, 17, 0, 0);
        NEGFeedBackView.b bVar = this.l;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f19095e);
        }
        this.p = true;
        this.f19092b.registerListener(this.F);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.C == null) {
                this.C = new c.a.q0.s.f0.a(this.f19092b);
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
        SkinManager.setBackgroundColor(this.f19094d, R.color.CAM_X0205);
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
            PopupWindow popupWindow = this.f19093c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f19093c = null;
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
            if (this.f19095e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f19097g)) {
                int i3 = 0;
                while (i2 < this.f19097g.size()) {
                    b.C0920b c0920b = this.f19097g.get(i2);
                    if (c0920b != null) {
                        jSONArray.put(String.valueOf(c0920b.f19047b));
                        i3 = c0920b.f19046a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.B).param("obj_type", i2));
            if (this.f19098h) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.B).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.B).param("obj_type", i2));
            }
            InterfaceC0923g interfaceC0923g = this.u;
            if (interfaceC0923g != null) {
                interfaceC0923g.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f19095e.g());
                jSONObject.put("type", this.f19095e.a());
                jSONObject.put("forum_id", this.f19095e.c());
                jSONObject.put("is_frs_masks", this.f19095e.d());
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
            Context context = this.f19091a;
            if (context == null) {
                return null;
            }
            if (this.f19094d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f19094d = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = textView;
                if (this.f19098h) {
                    textView.setText(R.string.shield_reason);
                }
                this.y = (TextView) this.f19094d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.o.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f19091a, R.dimen.ds40);
                g2.setPadding(g3, 0, g3, 0);
                this.f19094d.addView(g2);
            }
            if (this.s == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f19091a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.s = linearLayout;
                this.w = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.v = (TextView) this.s.findViewById(R.id.dialog_bottom_certain_button);
                this.z = this.s.findViewById(R.id.top_line);
                this.A = this.s.findViewById(R.id.middle_line);
                this.f19094d.addView(this.s);
                this.w.setOnClickListener(new d(this));
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setOnClickListener(new e(this));
                }
                p();
            }
            return this.f19094d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f19094d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f19094d.getMeasuredHeight() + l.g(this.f19091a, R.dimen.ds12);
            this.k = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r = l.g(this.f19091a, R.dimen.tbds32);
            this.f19100j = l.k(this.f19091a) - (this.r * 2);
            c.a.r0.i.b bVar = new c.a.r0.i.b(this.f19092b);
            this.o = bVar;
            bVar.o(this.D);
            this.o.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.p && this.f19097g.size() != 0) {
            this.f19097g.clear();
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f19098h = z;
        }
    }

    public void x(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f19095e = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f19096f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f19096f.size() - 1; size >= 8; size--) {
                this.f19096f.removeAt(size);
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

    public void z(InterfaceC0923g interfaceC0923g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0923g) == null) {
            this.u = interfaceC0923g;
        }
    }
}
