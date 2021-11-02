package b.a.r0.j;

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
import b.a.e.e.p.l;
import b.a.q0.s.q.x0;
import b.a.r0.j.b;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public b.a.q0.s.g0.a C;
    public CompoundButton.OnCheckedChangeListener D;
    public PopupWindow.OnDismissListener E;
    public CustomMessageListener F;

    /* renamed from: a  reason: collision with root package name */
    public Context f18251a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18252b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f18253c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18254d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f18255e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f18256f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C0927b> f18257g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18258h;

    /* renamed from: i  reason: collision with root package name */
    public int f18259i;
    public int j;
    public int k;
    public NEGFeedBackView.b l;
    public PopupWindow m;
    public View n;
    public b.a.r0.j.b o;
    public boolean p;
    public int q;
    public int r;
    public LinearLayout s;
    public f t;
    public InterfaceC0930g u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18260e;

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
            this.f18260e = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f18260e.l != null) {
                    this.f18260e.l.onCheckedChanged(this.f18260e.f18255e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C0927b) {
                    b.C0927b c0927b = (b.C0927b) compoundButton.getTag();
                    if (z) {
                        if (this.f18260e.f18257g.contains(c0927b)) {
                            return;
                        }
                        this.f18260e.f18257g.add(c0927b);
                        return;
                    }
                    this.f18260e.f18257g.remove(c0927b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18261e;

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
            this.f18261e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18261e.m == null) {
                return;
            }
            this.f18261e.m.dismiss();
            this.f18261e.m = null;
            MessageManager.getInstance().unRegisterListener(this.f18261e.F);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f18262a;

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
            this.f18262a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f18262a.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18263e;

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
            this.f18263e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18263e.m != null) {
                    this.f18263e.m.dismiss();
                    this.f18263e.m = null;
                }
                if (this.f18263e.f18253c != null) {
                    this.f18263e.f18253c.dismiss();
                    this.f18263e.f18253c = null;
                }
                if (this.f18263e.f18258h) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.f18263e.B));
                }
                if (this.f18263e.t != null) {
                    this.f18263e.t.onClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f18264e;

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
            this.f18264e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f18264e.r();
                if (this.f18264e.B == "3" || this.f18264e.B == "4" || this.f18264e.B == "1") {
                    this.f18264e.q();
                } else if (r != null) {
                    this.f18264e.B();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f18264e.f18252b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onClick();
    }

    /* renamed from: b.a.r0.j.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0930g {
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
        this.f18251a = null;
        this.f18253c = null;
        this.f18255e = null;
        this.f18256f = null;
        this.f18257g = new ArrayList();
        this.l = null;
        this.q = 3;
        this.C = null;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this, 2001304);
        this.f18251a = tbPageContext.getPageActivity();
        this.f18252b = tbPageContext;
        this.n = view;
        u();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f18251a == null) {
            return;
        }
        this.B = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        p();
        this.f18259i = t() - l.g(this.f18251a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.j, this.f18259i);
        this.f18253c = popupWindow;
        popupWindow.setFocusable(true);
        this.f18253c.setTouchable(true);
        this.f18253c.setOnDismissListener(this.E);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f18251a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.m = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.m.showAtLocation(this.n, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f18253c, R.drawable.bg_dailog);
        this.f18253c.showAtLocation(this.n, 17, 0, 0);
        NEGFeedBackView.b bVar = this.l;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f18255e);
        }
        this.p = true;
        this.f18252b.registerListener(this.F);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.C == null) {
                this.C = new b.a.q0.s.g0.a(this.f18252b);
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
        SkinManager.setBackgroundColor(this.f18254d, R.color.CAM_X0205);
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
            PopupWindow popupWindow = this.f18253c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f18253c = null;
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
            if (this.f18255e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f18257g)) {
                int i3 = 0;
                while (i2 < this.f18257g.size()) {
                    b.C0927b c0927b = this.f18257g.get(i2);
                    if (c0927b != null) {
                        jSONArray.put(String.valueOf(c0927b.f18209b));
                        i3 = c0927b.f18208a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.B).param("obj_type", i2));
            if (this.f18258h) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.B).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.B).param("obj_type", i2));
            }
            InterfaceC0930g interfaceC0930g = this.u;
            if (interfaceC0930g != null) {
                interfaceC0930g.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f18255e.g());
                jSONObject.put("type", this.f18255e.a());
                jSONObject.put("forum_id", this.f18255e.c());
                jSONObject.put("is_frs_masks", this.f18255e.d());
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
            Context context = this.f18251a;
            if (context == null) {
                return null;
            }
            if (this.f18254d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f18254d = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = textView;
                if (this.f18258h) {
                    textView.setText(R.string.shield_reason);
                }
                this.y = (TextView) this.f18254d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.o.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f18251a, R.dimen.ds40);
                g2.setPadding(g3, 0, g3, 0);
                this.f18254d.addView(g2);
            }
            if (this.s == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f18251a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.s = linearLayout;
                this.w = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.v = (TextView) this.s.findViewById(R.id.dialog_bottom_certain_button);
                this.z = this.s.findViewById(R.id.top_line);
                this.A = this.s.findViewById(R.id.middle_line);
                this.f18254d.addView(this.s);
                this.w.setOnClickListener(new d(this));
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setOnClickListener(new e(this));
                }
                p();
            }
            return this.f18254d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f18254d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f18254d.getMeasuredHeight() + l.g(this.f18251a, R.dimen.ds12);
            this.k = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r = l.g(this.f18251a, R.dimen.tbds32);
            this.j = l.k(this.f18251a) - (this.r * 2);
            b.a.r0.j.b bVar = new b.a.r0.j.b(this.f18252b);
            this.o = bVar;
            bVar.o(this.D);
            this.o.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.p && this.f18257g.size() != 0) {
            this.f18257g.clear();
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f18258h = z;
        }
    }

    public void x(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f18255e = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f18256f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f18256f.size() - 1; size >= 8; size--) {
                this.f18256f.removeAt(size);
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

    public void z(InterfaceC0930g interfaceC0930g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0930g) == null) {
            this.u = interfaceC0930g;
        }
    }
}
